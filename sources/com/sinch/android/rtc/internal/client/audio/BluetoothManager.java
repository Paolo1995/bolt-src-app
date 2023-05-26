package com.sinch.android.rtc.internal.client.audio;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import com.sinch.android.rtc.MissingPermissionException;
import java.util.List;
import java.util.Set;
import org.webrtc.MediaStreamTrack;
import org.webrtc.ThreadUtils;
import org.webrtc.audio.WebRtcAudioUtils;

/* loaded from: classes3.dex */
public class BluetoothManager {
    private static final int BLUETOOTH_SCO_TIMEOUT_MS = 4000;
    private static final int MAX_SCO_CONNECTION_ATTEMPTS = 2;
    private static final String TAG = "BluetoothManager";
    private final Context apprtcContext;
    private final AudioManager audioManager;
    private final AudioManagerInternal audiomanagerInternal;
    private BluetoothAdapter bluetoothAdapter;
    private BluetoothDevice bluetoothDevice;
    private BluetoothHeadset bluetoothHeadset;
    private final BroadcastReceiver bluetoothHeadsetReceiver;
    private final BluetoothProfile.ServiceListener bluetoothServiceListener;
    private State bluetoothState;
    private final Runnable bluetoothTimeoutRunnable = new Runnable() { // from class: com.sinch.android.rtc.internal.client.audio.BluetoothManager.1
        @Override // java.lang.Runnable
        public void run() {
            BluetoothManager.this.bluetoothTimeout();
        }
    };
    private final Handler handler;
    public int scoConnectionAttempts;

    /* loaded from: classes3.dex */
    public class BluetoothHeadsetBroadcastReceiver extends BroadcastReceiver {
        private BluetoothHeadsetBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str;
            BluetoothManager bluetoothManager;
            if (BluetoothManager.this.bluetoothState == State.UNINITIALIZED) {
                return;
            }
            String action = intent.getAction();
            if (action.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
                Log.d(BluetoothManager.TAG, "BluetoothHeadsetBroadcastReceiver.onReceive: a=ACTION_CONNECTION_STATE_CHANGED, s=" + BluetoothManager.this.stateToString(intExtra) + ", sb=" + isInitialStickyBroadcast() + ", BT state: " + BluetoothManager.this.bluetoothState);
                if (intExtra != 2) {
                    if (intExtra != 1 && intExtra != 3 && intExtra == 0) {
                        BluetoothManager.this.stopScoAudio();
                        bluetoothManager = BluetoothManager.this;
                        bluetoothManager.updateAudioDeviceState();
                    }
                }
                bluetoothManager = BluetoothManager.this;
                bluetoothManager.scoConnectionAttempts = 0;
                bluetoothManager.updateAudioDeviceState();
            } else if (action.equals("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED")) {
                int intExtra2 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 10);
                Log.d(BluetoothManager.TAG, "BluetoothHeadsetBroadcastReceiver.onReceive: a=ACTION_AUDIO_STATE_CHANGED, s=" + BluetoothManager.this.stateToString(intExtra2) + ", sb=" + isInitialStickyBroadcast() + ", BT state: " + BluetoothManager.this.bluetoothState);
                if (intExtra2 == 12) {
                    BluetoothManager.this.cancelTimer();
                    if (BluetoothManager.this.bluetoothState == State.SCO_CONNECTING) {
                        Log.d(BluetoothManager.TAG, "+++ Bluetooth audio SCO is now connected");
                        BluetoothManager.this.bluetoothState = State.SCO_CONNECTED;
                        bluetoothManager = BluetoothManager.this;
                        bluetoothManager.scoConnectionAttempts = 0;
                        bluetoothManager.updateAudioDeviceState();
                    } else {
                        Log.w(BluetoothManager.TAG, "Unexpected state BluetoothHeadset.STATE_AUDIO_CONNECTED");
                    }
                } else if (intExtra2 == 11) {
                    Log.d(BluetoothManager.TAG, "+++ Bluetooth audio SCO is now connecting...");
                } else if (intExtra2 == 10) {
                    Log.d(BluetoothManager.TAG, "+++ Bluetooth audio SCO is now disconnected");
                    if (isInitialStickyBroadcast()) {
                        str = "Ignore STATE_AUDIO_DISCONNECTED initial sticky broadcast.";
                        Log.d(BluetoothManager.TAG, str);
                    }
                    BluetoothManager.this.updateDevice();
                    bluetoothManager = BluetoothManager.this;
                    bluetoothManager.updateAudioDeviceState();
                }
            }
            str = "onReceive done: BT state=" + BluetoothManager.this.bluetoothState;
            Log.d(BluetoothManager.TAG, str);
        }
    }

    /* loaded from: classes3.dex */
    public class BluetoothServiceListener implements BluetoothProfile.ServiceListener {
        private BluetoothServiceListener() {
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int i8, BluetoothProfile bluetoothProfile) {
            if (i8 != 1 || BluetoothManager.this.bluetoothState == State.UNINITIALIZED) {
                return;
            }
            Log.d(BluetoothManager.TAG, "BluetoothServiceListener.onServiceConnected: BT state=" + BluetoothManager.this.bluetoothState);
            BluetoothManager.this.bluetoothHeadset = (BluetoothHeadset) bluetoothProfile;
            BluetoothManager.this.updateAudioDeviceState();
            Log.d(BluetoothManager.TAG, "onServiceConnected done: BT state=" + BluetoothManager.this.bluetoothState);
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int i8) {
            if (i8 != 1 || BluetoothManager.this.bluetoothState == State.UNINITIALIZED) {
                return;
            }
            Log.d(BluetoothManager.TAG, "BluetoothServiceListener.onServiceDisconnected: BT state=" + BluetoothManager.this.bluetoothState);
            BluetoothManager.this.stopScoAudio();
            BluetoothManager.this.bluetoothHeadset = null;
            BluetoothManager.this.bluetoothDevice = null;
            BluetoothManager.this.bluetoothState = State.HEADSET_UNAVAILABLE;
            BluetoothManager.this.updateAudioDeviceState();
            Log.d(BluetoothManager.TAG, "onServiceDisconnected done: BT state=" + BluetoothManager.this.bluetoothState);
        }
    }

    /* loaded from: classes3.dex */
    public enum State {
        UNINITIALIZED,
        ERROR,
        HEADSET_UNAVAILABLE,
        HEADSET_AVAILABLE,
        SCO_DISCONNECTING,
        SCO_CONNECTING,
        SCO_CONNECTED
    }

    public BluetoothManager(Context context, AudioManagerInternal audioManagerInternal) {
        Log.d(TAG, "ctor");
        ThreadUtils.checkIsOnMainThread();
        this.apprtcContext = context;
        this.audiomanagerInternal = audioManagerInternal;
        this.audioManager = getAudioManager(context);
        this.bluetoothState = State.UNINITIALIZED;
        this.bluetoothServiceListener = new BluetoothServiceListener();
        this.bluetoothHeadsetReceiver = new BluetoothHeadsetBroadcastReceiver();
        this.handler = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void bluetoothTimeout() {
        /*
            r4 = this;
            org.webrtc.ThreadUtils.checkIsOnMainThread()
            com.sinch.android.rtc.internal.client.audio.BluetoothManager$State r0 = r4.bluetoothState
            com.sinch.android.rtc.internal.client.audio.BluetoothManager$State r1 = com.sinch.android.rtc.internal.client.audio.BluetoothManager.State.UNINITIALIZED
            if (r0 == r1) goto Lc2
            android.bluetooth.BluetoothHeadset r0 = r4.bluetoothHeadset
            if (r0 != 0) goto Lf
            goto Lc2
        Lf:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "bluetoothTimeout: BT state="
            r0.append(r1)
            com.sinch.android.rtc.internal.client.audio.BluetoothManager$State r1 = r4.bluetoothState
            r0.append(r1)
            java.lang.String r1 = ", attempts: "
            r0.append(r1)
            int r1 = r4.scoConnectionAttempts
            r0.append(r1)
            java.lang.String r1 = ", SCO is on: "
            r0.append(r1)
            boolean r1 = r4.isScoOn()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "BluetoothManager"
            android.util.Log.d(r1, r0)
            com.sinch.android.rtc.internal.client.audio.BluetoothManager$State r0 = r4.bluetoothState
            com.sinch.android.rtc.internal.client.audio.BluetoothManager$State r2 = com.sinch.android.rtc.internal.client.audio.BluetoothManager.State.SCO_CONNECTING
            if (r0 == r2) goto L44
            return
        L44:
            android.bluetooth.BluetoothHeadset r0 = r4.bluetoothHeadset
            java.util.List r0 = r0.getConnectedDevices()
            int r2 = r0.size()
            r3 = 0
            if (r2 <= 0) goto L97
            java.lang.Object r0 = r0.get(r3)
            android.bluetooth.BluetoothDevice r0 = (android.bluetooth.BluetoothDevice) r0
            r4.bluetoothDevice = r0
            android.bluetooth.BluetoothHeadset r2 = r4.bluetoothHeadset
            boolean r0 = r2.isAudioConnected(r0)
            if (r0 == 0) goto L7d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "SCO connected with "
            r0.append(r2)
            android.bluetooth.BluetoothDevice r2 = r4.bluetoothDevice
            java.lang.String r2 = r2.getName()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r1, r0)
            r0 = 1
            goto L98
        L7d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "SCO is not connected with "
            r0.append(r2)
            android.bluetooth.BluetoothDevice r2 = r4.bluetoothDevice
            java.lang.String r2 = r2.getName()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r1, r0)
        L97:
            r0 = 0
        L98:
            if (r0 == 0) goto La1
            com.sinch.android.rtc.internal.client.audio.BluetoothManager$State r0 = com.sinch.android.rtc.internal.client.audio.BluetoothManager.State.SCO_CONNECTED
            r4.bluetoothState = r0
            r4.scoConnectionAttempts = r3
            goto La9
        La1:
            java.lang.String r0 = "BT failed to connect after timeout"
            android.util.Log.w(r1, r0)
            r4.stopScoAudio()
        La9:
            r4.updateAudioDeviceState()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "bluetoothTimeout done: BT state="
            r0.append(r2)
            com.sinch.android.rtc.internal.client.audio.BluetoothManager$State r2 = r4.bluetoothState
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r1, r0)
        Lc2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sinch.android.rtc.internal.client.audio.BluetoothManager.bluetoothTimeout():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelTimer() {
        ThreadUtils.checkIsOnMainThread();
        Log.d(TAG, "cancelTimer");
        this.handler.removeCallbacks(this.bluetoothTimeoutRunnable);
    }

    public static BluetoothManager create(Context context, AudioManagerInternal audioManagerInternal) {
        Log.d(TAG, "create" + WebRtcAudioUtils.getThreadInfo());
        return new BluetoothManager(context, audioManagerInternal);
    }

    private boolean isScoOn() {
        return this.audioManager.isBluetoothScoOn();
    }

    private void startTimer() {
        ThreadUtils.checkIsOnMainThread();
        Log.d(TAG, "startTimer");
        this.handler.postDelayed(this.bluetoothTimeoutRunnable, 4000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String stateToString(int i8) {
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 != 3) {
                        switch (i8) {
                            case 10:
                                return "OFF";
                            case 11:
                                return "TURNING_ON";
                            case 12:
                                return "ON";
                            case 13:
                                return "TURNING_OFF";
                            default:
                                return "INVALID";
                        }
                    }
                    return "DISCONNECTING";
                }
                return "CONNECTED";
            }
            return "CONNECTING";
        }
        return "DISCONNECTED";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAudioDeviceState() {
        ThreadUtils.checkIsOnMainThread();
        Log.d(TAG, "updateAudioDeviceState");
        this.audiomanagerInternal.updateAudioDeviceState();
    }

    public AudioManager getAudioManager(Context context) {
        return (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
    }

    public boolean getBluetoothProfileProxy(Context context, BluetoothProfile.ServiceListener serviceListener, int i8) {
        return this.bluetoothAdapter.getProfileProxy(context, serviceListener, i8);
    }

    public State getState() {
        ThreadUtils.checkIsOnMainThread();
        return this.bluetoothState;
    }

    public boolean hasPermission(Context context, String str) {
        return this.apprtcContext.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    @SuppressLint({"HardwareIds"})
    public void logBluetoothAdapterInfo(BluetoothAdapter bluetoothAdapter) {
        Log.d(TAG, "BluetoothAdapter: enabled=" + bluetoothAdapter.isEnabled() + ", state=" + stateToString(bluetoothAdapter.getState()) + ", name=" + bluetoothAdapter.getName() + ", address=" + bluetoothAdapter.getAddress());
        Set<BluetoothDevice> bondedDevices = bluetoothAdapter.getBondedDevices();
        if (bondedDevices.isEmpty()) {
            return;
        }
        Log.d(TAG, "paired devices:");
        for (BluetoothDevice bluetoothDevice : bondedDevices) {
            Log.d(TAG, " name=" + bluetoothDevice.getName() + ", address=" + bluetoothDevice.getAddress());
        }
    }

    public void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        this.apprtcContext.registerReceiver(broadcastReceiver, intentFilter);
    }

    public void start() {
        ThreadUtils.checkIsOnMainThread();
        Log.d(TAG, "start");
        if (!hasPermission(this.apprtcContext, "android.permission.BLUETOOTH")) {
            Log.w(TAG, "Process (pid=" + Process.myPid() + ") lacks BLUETOOTH permission");
            throw new MissingPermissionException("android.permission.BLUETOOTH");
        } else if (this.bluetoothState != State.UNINITIALIZED) {
            Log.w(TAG, "Invalid BT state");
        } else {
            this.bluetoothHeadset = null;
            this.bluetoothDevice = null;
            this.scoConnectionAttempts = 0;
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            this.bluetoothAdapter = defaultAdapter;
            if (defaultAdapter == null) {
                Log.w(TAG, "Device does not support Bluetooth");
            } else if (!this.audioManager.isBluetoothScoAvailableOffCall()) {
                Log.e(TAG, "Bluetooth SCO audio is not available off call");
            } else {
                logBluetoothAdapterInfo(this.bluetoothAdapter);
                if (!getBluetoothProfileProxy(this.apprtcContext, this.bluetoothServiceListener, 1)) {
                    Log.e(TAG, "BluetoothAdapter.getProfileProxy(HEADSET) failed");
                    return;
                }
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
                intentFilter.addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
                registerReceiver(this.bluetoothHeadsetReceiver, intentFilter);
                Log.d(TAG, "HEADSET profile state: " + stateToString(this.bluetoothAdapter.getProfileConnectionState(1)));
                Log.d(TAG, "Bluetooth proxy for headset profile has started");
                this.bluetoothState = State.HEADSET_UNAVAILABLE;
                Log.d(TAG, "start done: BT state=" + this.bluetoothState);
            }
        }
    }

    public boolean startScoAudio() {
        String str;
        ThreadUtils.checkIsOnMainThread();
        Log.d(TAG, "startSco: BT state=" + this.bluetoothState + ", attempts: " + this.scoConnectionAttempts + ", SCO is on: " + isScoOn());
        if (this.scoConnectionAttempts >= 2) {
            str = "BT SCO connection fails - no more attempts";
        } else {
            State state = this.bluetoothState;
            if (state == State.SCO_CONNECTED) {
                Log.w(TAG, "Ignoring startScoAudio as SCO is already connected");
                return true;
            }
            State state2 = State.SCO_CONNECTING;
            if (state == state2) {
                Log.w(TAG, "Ignoring startScoAudio as SCO is connecting");
                return true;
            } else if (state == State.HEADSET_AVAILABLE) {
                Log.d(TAG, "Starting Bluetooth SCO and waits for ACTION_AUDIO_STATE_CHANGED...");
                this.bluetoothState = state2;
                this.audioManager.startBluetoothSco();
                this.audioManager.setBluetoothScoOn(true);
                this.scoConnectionAttempts++;
                startTimer();
                Log.d(TAG, "startScoAudio done: BT state=" + this.bluetoothState + ", SCO is on: " + isScoOn());
                return true;
            } else {
                str = "BT SCO connection fails - no headset available";
            }
        }
        Log.e(TAG, str);
        return false;
    }

    public void stop() {
        ThreadUtils.checkIsOnMainThread();
        Log.d(TAG, "stop: BT state=" + this.bluetoothState);
        if (this.bluetoothAdapter == null) {
            return;
        }
        stopScoAudio();
        State state = this.bluetoothState;
        State state2 = State.UNINITIALIZED;
        if (state == state2) {
            return;
        }
        unregisterReceiver(this.bluetoothHeadsetReceiver);
        cancelTimer();
        BluetoothHeadset bluetoothHeadset = this.bluetoothHeadset;
        if (bluetoothHeadset != null) {
            this.bluetoothAdapter.closeProfileProxy(1, bluetoothHeadset);
            this.bluetoothHeadset = null;
        }
        this.bluetoothAdapter = null;
        this.bluetoothDevice = null;
        this.bluetoothState = state2;
        Log.d(TAG, "stop done: BT state=" + this.bluetoothState);
    }

    public void stopScoAudio() {
        ThreadUtils.checkIsOnMainThread();
        Log.d(TAG, "stopScoAudio: BT state=" + this.bluetoothState + ", SCO is on: " + isScoOn());
        State state = this.bluetoothState;
        if (state == State.SCO_CONNECTING || state == State.SCO_CONNECTED) {
            cancelTimer();
            this.audioManager.stopBluetoothSco();
            this.audioManager.setBluetoothScoOn(false);
            this.bluetoothState = State.SCO_DISCONNECTING;
            Log.d(TAG, "stopScoAudio done: BT state=" + this.bluetoothState + ", SCO is on: " + isScoOn());
        }
    }

    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        this.apprtcContext.unregisterReceiver(broadcastReceiver);
    }

    public void updateDevice() {
        String str;
        if (this.bluetoothState == State.UNINITIALIZED || this.bluetoothHeadset == null) {
            return;
        }
        Log.d(TAG, "updateDevice");
        List<BluetoothDevice> connectedDevices = this.bluetoothHeadset.getConnectedDevices();
        if (connectedDevices.isEmpty()) {
            this.bluetoothDevice = null;
            this.bluetoothState = State.HEADSET_UNAVAILABLE;
            str = "No connected bluetooth headset";
        } else {
            this.bluetoothDevice = connectedDevices.get(0);
            this.bluetoothState = State.HEADSET_AVAILABLE;
            str = "Connected bluetooth headset: name=" + this.bluetoothDevice.getName() + ", state=" + stateToString(this.bluetoothHeadset.getConnectionState(this.bluetoothDevice)) + ", SCO audio=" + this.bluetoothHeadset.isAudioConnected(this.bluetoothDevice);
        }
        Log.d(TAG, str);
        Log.d(TAG, "updateDevice done: BT state=" + this.bluetoothState);
    }
}
