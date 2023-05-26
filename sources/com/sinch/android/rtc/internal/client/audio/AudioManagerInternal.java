package com.sinch.android.rtc.internal.client.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.util.Log;
import com.sinch.android.rtc.AudioController;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.webrtc.MediaStreamTrack;
import org.webrtc.ThreadUtils;
import org.webrtc.audio.WebRtcAudioUtils;

/* loaded from: classes3.dex */
public class AudioManagerInternal {
    private static final String TAG = "AudioManagerInternal";
    private AudioManagerState amState;
    private final Context apprtcContext;
    private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener;
    private AudioManager audioManager;
    private AudioManagerEvents audioManagerEvents;
    private final BluetoothManager bluetoothManager;
    private AudioDevice defaultAudioDevice;
    private WebRtcProximitySensor proximitySensor;
    private AudioDevice selectedAudioDevice;
    private final AudioController.UseSpeakerphone useSpeakerphone;
    private AudioDevice userSelectedAudioDevice;
    private BroadcastReceiver wiredHeadsetReceiver;
    private boolean savedIsSpeakerPhoneOn = false;
    private boolean hasWiredHeadset = false;
    private Set<AudioDevice> audioDevices = new HashSet();

    /* renamed from: com.sinch.android.rtc.internal.client.audio.AudioManagerInternal$3  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$com$sinch$android$rtc$internal$client$audio$AudioManagerInternal$AudioDevice;

        static {
            int[] iArr = new int[AudioDevice.values().length];
            $SwitchMap$com$sinch$android$rtc$internal$client$audio$AudioManagerInternal$AudioDevice = iArr;
            try {
                iArr[AudioDevice.SPEAKER_PHONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$sinch$android$rtc$internal$client$audio$AudioManagerInternal$AudioDevice[AudioDevice.EARPIECE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$sinch$android$rtc$internal$client$audio$AudioManagerInternal$AudioDevice[AudioDevice.WIRED_HEADSET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$sinch$android$rtc$internal$client$audio$AudioManagerInternal$AudioDevice[AudioDevice.BLUETOOTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public enum AudioDevice {
        SPEAKER_PHONE,
        WIRED_HEADSET,
        EARPIECE,
        BLUETOOTH,
        NONE
    }

    /* loaded from: classes3.dex */
    public interface AudioManagerEvents {
        void onAudioDeviceChanged(AudioDevice audioDevice, Set<AudioDevice> set);
    }

    /* loaded from: classes3.dex */
    public enum AudioManagerState {
        UNINITIALIZED,
        PREINITIALIZED,
        RUNNING,
        STARTING
    }

    /* loaded from: classes3.dex */
    public class WiredHeadsetReceiver extends BroadcastReceiver {
        private static final int HAS_MIC = 1;
        private static final int HAS_NO_MIC = 0;
        private static final int STATE_PLUGGED = 1;
        private static final int STATE_UNPLUGGED = 0;

        private WiredHeadsetReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("state", 0);
            int intExtra2 = intent.getIntExtra("microphone", 0);
            String stringExtra = intent.getStringExtra("name");
            StringBuilder sb = new StringBuilder();
            sb.append("WiredHeadsetReceiver.onReceive");
            sb.append(WebRtcAudioUtils.getThreadInfo());
            sb.append(": a=");
            sb.append(intent.getAction());
            sb.append(", s=");
            sb.append(intExtra == 0 ? "unplugged" : "plugged");
            sb.append(", m=");
            sb.append(intExtra2 == 1 ? "mic" : "no mic");
            sb.append(", n=");
            sb.append(stringExtra);
            sb.append(", sb=");
            sb.append(isInitialStickyBroadcast());
            Log.d(AudioManagerInternal.TAG, sb.toString());
            AudioManagerInternal.this.hasWiredHeadset = intExtra == 1;
            AudioManagerInternal.this.updateAudioDeviceState();
        }
    }

    private AudioManagerInternal(Context context, AudioController.UseSpeakerphone useSpeakerphone) {
        this.proximitySensor = null;
        Log.d(TAG, "ctor");
        ThreadUtils.checkIsOnMainThread();
        this.apprtcContext = context;
        this.audioManager = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        this.bluetoothManager = BluetoothManager.create(context, this);
        this.wiredHeadsetReceiver = new WiredHeadsetReceiver();
        this.amState = AudioManagerState.UNINITIALIZED;
        this.useSpeakerphone = useSpeakerphone;
        Log.d(TAG, "useSpeakerphone: " + useSpeakerphone);
        setDefaultAudioDevice(useSpeakerphone.equals(AudioController.UseSpeakerphone.SPEAKERPHONE_FALSE) ? AudioDevice.EARPIECE : AudioDevice.SPEAKER_PHONE);
        WebRtcProximitySensor create = WebRtcProximitySensor.create(context, new Runnable() { // from class: com.sinch.android.rtc.internal.client.audio.AudioManagerInternal.1
            @Override // java.lang.Runnable
            public void run() {
                AudioManagerInternal.this.onProximitySensorChangedState();
            }
        });
        this.proximitySensor = create;
        if (create != null) {
            create.start();
        }
        Log.d(TAG, "defaultAudioDevice: " + this.defaultAudioDevice);
        logDeviceInfo(TAG);
    }

    public static AudioManagerInternal create(Context context, AudioController.UseSpeakerphone useSpeakerphone) {
        return new AudioManagerInternal(context, useSpeakerphone);
    }

    private boolean hasEarpiece() {
        return this.apprtcContext.getPackageManager().hasSystemFeature("android.hardware.telephony");
    }

    @Deprecated
    private boolean hasWiredHeadset() {
        AudioDeviceInfo[] devices;
        String str;
        if (Build.VERSION.SDK_INT < 23) {
            return this.audioManager.isWiredHeadsetOn();
        }
        devices = this.audioManager.getDevices(3);
        for (AudioDeviceInfo audioDeviceInfo : devices) {
            int type = audioDeviceInfo.getType();
            if (type == 3) {
                str = "hasWiredHeadset: found wired headset";
            } else if (type == 11) {
                str = "hasWiredHeadset: found USB audio device";
            }
            Log.d(TAG, str);
            return true;
        }
        return false;
    }

    public static void logDeviceInfo(String str) {
        Log.d(str, "Android SDK: " + Build.VERSION.SDK_INT + ", Release: " + Build.VERSION.RELEASE + ", Brand: " + Build.BRAND + ", Device: " + Build.DEVICE + ", Id: " + Build.ID + ", Hardware: " + Build.HARDWARE + ", Manufacturer: " + Build.MANUFACTURER + ", Model: " + Build.MODEL + ", Product: " + Build.PRODUCT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProximitySensorChangedState() {
        if (this.useSpeakerphone.equals(AudioController.UseSpeakerphone.SPEAKERPHONE_AUTO) && this.audioDevices.size() == 2) {
            Set<AudioDevice> set = this.audioDevices;
            AudioDevice audioDevice = AudioDevice.EARPIECE;
            if (set.contains(audioDevice)) {
                Set<AudioDevice> set2 = this.audioDevices;
                AudioDevice audioDevice2 = AudioDevice.SPEAKER_PHONE;
                if (set2.contains(audioDevice2)) {
                    if (this.proximitySensor.sensorReportsNearState()) {
                        setAudioDeviceInternal(audioDevice);
                    } else {
                        setAudioDeviceInternal(audioDevice2);
                    }
                    AudioManagerEvents audioManagerEvents = this.audioManagerEvents;
                    if (audioManagerEvents != null) {
                        audioManagerEvents.onAudioDeviceChanged(this.selectedAudioDevice, this.audioDevices);
                    }
                }
            }
        }
    }

    private void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        this.apprtcContext.registerReceiver(broadcastReceiver, intentFilter);
    }

    private void setAudioDeviceInternal(AudioDevice audioDevice) {
        Log.d(TAG, "setAudioDeviceInternal(device=" + audioDevice + ")");
        WebRtcAudioUtils.assertIsTrue(this.audioDevices.contains(audioDevice));
        int i8 = AnonymousClass3.$SwitchMap$com$sinch$android$rtc$internal$client$audio$AudioManagerInternal$AudioDevice[audioDevice.ordinal()];
        if (i8 == 1) {
            setSpeakerphoneOn(true);
        } else if (i8 == 2 || i8 == 3 || i8 == 4) {
            setSpeakerphoneOn(false);
        } else {
            Log.e(TAG, "Invalid audio device selection");
        }
        this.selectedAudioDevice = audioDevice;
    }

    private void setSpeakerphoneOn(boolean z7) {
        if (this.audioManager.isSpeakerphoneOn() == z7) {
            return;
        }
        this.audioManager.setSpeakerphoneOn(z7);
    }

    private void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        this.apprtcContext.unregisterReceiver(broadcastReceiver);
    }

    public Set<AudioDevice> getAudioDevices() {
        ThreadUtils.checkIsOnMainThread();
        return Collections.unmodifiableSet(new HashSet(this.audioDevices));
    }

    public AudioDevice getSelectedAudioDevice() {
        ThreadUtils.checkIsOnMainThread();
        return this.selectedAudioDevice;
    }

    public boolean isRunning() {
        return this.amState == AudioManagerState.RUNNING;
    }

    public void selectAudioDevice(AudioDevice audioDevice) {
        ThreadUtils.checkIsOnMainThread();
        if (!this.audioDevices.contains(audioDevice)) {
            Log.e(TAG, "Can not select " + audioDevice + " from available " + this.audioDevices);
        }
        this.userSelectedAudioDevice = audioDevice;
        updateAudioDeviceState();
    }

    public void setDefaultAudioDevice(AudioDevice audioDevice) {
        ThreadUtils.checkIsOnMainThread();
        int i8 = AnonymousClass3.$SwitchMap$com$sinch$android$rtc$internal$client$audio$AudioManagerInternal$AudioDevice[audioDevice.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                Log.e(TAG, "Invalid default audio device selection");
                Log.d(TAG, "setDefaultAudioDevice(device=" + this.defaultAudioDevice + ")");
                updateAudioDeviceState();
            } else if (!hasEarpiece()) {
                audioDevice = AudioDevice.SPEAKER_PHONE;
            }
        }
        this.defaultAudioDevice = audioDevice;
        Log.d(TAG, "setDefaultAudioDevice(device=" + this.defaultAudioDevice + ")");
        updateAudioDeviceState();
    }

    public void start(AudioManagerEvents audioManagerEvents, boolean z7) {
        AudioManagerState audioManagerState;
        Log.d(TAG, "start");
        ThreadUtils.checkIsOnMainThread();
        AudioManagerState audioManagerState2 = this.amState;
        AudioManagerState audioManagerState3 = AudioManagerState.RUNNING;
        if (audioManagerState2 == audioManagerState3 || audioManagerState2 == (audioManagerState = AudioManagerState.STARTING)) {
            Log.e(TAG, "AudioManager is already active");
            return;
        }
        Log.d(TAG, "AudioManager starts...");
        this.audioManagerEvents = audioManagerEvents;
        this.amState = audioManagerState;
        this.savedIsSpeakerPhoneOn = this.audioManager.isSpeakerphoneOn();
        this.hasWiredHeadset = hasWiredHeadset();
        WebRtcProximitySensor webRtcProximitySensor = this.proximitySensor;
        if (webRtcProximitySensor != null) {
            webRtcProximitySensor.start();
        }
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: com.sinch.android.rtc.internal.client.audio.AudioManagerInternal.2
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public void onAudioFocusChange(int i8) {
                String str = i8 != -3 ? i8 != -2 ? i8 != -1 ? i8 != 1 ? i8 != 2 ? i8 != 3 ? i8 != 4 ? "AUDIOFOCUS_INVALID" : "AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE" : "AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK" : "AUDIOFOCUS_GAIN_TRANSIENT" : "AUDIOFOCUS_GAIN" : "AUDIOFOCUS_LOSS" : "AUDIOFOCUS_LOSS_TRANSIENT" : "AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK";
                Log.d(AudioManagerInternal.TAG, "onAudioFocusChange: " + str);
            }
        };
        this.audioFocusChangeListener = onAudioFocusChangeListener;
        if (this.audioManager.requestAudioFocus(onAudioFocusChangeListener, 0, 2) == 1) {
            Log.d(TAG, "Audio focus request granted for VOICE_CALL streams");
        } else {
            Log.e(TAG, "Audio focus request failed");
        }
        AudioDevice audioDevice = AudioDevice.NONE;
        this.userSelectedAudioDevice = audioDevice;
        this.selectedAudioDevice = audioDevice;
        this.audioDevices.clear();
        if (z7) {
            this.bluetoothManager.start();
        }
        updateAudioDeviceState();
        registerReceiver(this.wiredHeadsetReceiver, new IntentFilter("android.intent.action.HEADSET_PLUG"));
        this.amState = audioManagerState3;
        Log.d(TAG, "AudioManager started");
    }

    public void stop() {
        Log.d(TAG, "stop");
        ThreadUtils.checkIsOnMainThread();
        if (this.amState != AudioManagerState.RUNNING) {
            Log.e(TAG, "Trying to stop AudioManager in incorrect state: " + this.amState);
            return;
        }
        try {
            unregisterReceiver(this.wiredHeadsetReceiver);
        } catch (IllegalArgumentException unused) {
        }
        this.bluetoothManager.stop();
        setSpeakerphoneOn(this.savedIsSpeakerPhoneOn);
        this.audioManager.abandonAudioFocus(this.audioFocusChangeListener);
        this.audioFocusChangeListener = null;
        Log.d(TAG, "Abandoned audio focus for VOICE_CALL streams");
        WebRtcProximitySensor webRtcProximitySensor = this.proximitySensor;
        if (webRtcProximitySensor != null) {
            webRtcProximitySensor.stop();
        }
        this.audioManagerEvents = null;
        this.amState = AudioManagerState.UNINITIALIZED;
        Log.d(TAG, "AudioManager stopped");
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x0192, code lost:
        if (r0.contains(r1) != false) goto L59;
     */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void updateAudioDeviceState() {
        /*
            Method dump skipped, instructions count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sinch.android.rtc.internal.client.audio.AudioManagerInternal.updateAudioDeviceState():void");
    }
}
