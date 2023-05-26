package com.sinch.android.rtc.internal.client.audio;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.media.AudioManager;
import android.util.Log;
import androidx.core.content.ContextCompat;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes3.dex */
public class PreAndroid12SpeakerController implements SpeakerController {
    private final AudioManager audioManager;
    private final Context context;
    private final String TAG = PreAndroid12SpeakerController.class.getSimpleName();
    private final BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

    public PreAndroid12SpeakerController(Context context) {
        this.context = context;
        this.audioManager = (AudioManager) context.getApplicationContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
    }

    private void executeIfBluetoothPermissionsGranted(Runnable runnable) {
        if (ContextCompat.checkSelfPermission(this.context, "android.permission.BLUETOOTH") == 0 || ContextCompat.checkSelfPermission(this.context, "android.permission.BLUETOOTH_CONNECT") == 0) {
            runnable.run();
        } else {
            Log.d(this.TAG, "Bluetooth permissions not granted, aborting");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$disable$1() {
        setBluetoothSco(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$enable$0() {
        setBluetoothSco(false);
    }

    @SuppressLint({"MissingPermission", "WrongConstant"})
    private void setBluetoothSco(boolean z7) {
        BluetoothAdapter bluetoothAdapter = this.bluetoothAdapter;
        if (bluetoothAdapter == null || 2 != bluetoothAdapter.getProfileConnectionState(1)) {
            return;
        }
        this.audioManager.setBluetoothScoOn(z7);
        if (z7) {
            this.audioManager.startBluetoothSco();
        } else {
            this.audioManager.stopBluetoothSco();
        }
    }

    @Override // com.sinch.android.rtc.internal.client.audio.SpeakerController
    public void disable() {
        this.audioManager.setSpeakerphoneOn(false);
        executeIfBluetoothPermissionsGranted(new Runnable() { // from class: com.sinch.android.rtc.internal.client.audio.e
            @Override // java.lang.Runnable
            public final void run() {
                PreAndroid12SpeakerController.this.lambda$disable$1();
            }
        });
    }

    @Override // com.sinch.android.rtc.internal.client.audio.SpeakerController
    public void enable() {
        this.audioManager.setSpeakerphoneOn(true);
        executeIfBluetoothPermissionsGranted(new Runnable() { // from class: com.sinch.android.rtc.internal.client.audio.d
            @Override // java.lang.Runnable
            public final void run() {
                PreAndroid12SpeakerController.this.lambda$enable$0();
            }
        });
    }
}
