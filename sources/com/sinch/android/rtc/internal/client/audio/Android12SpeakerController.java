package com.sinch.android.rtc.internal.client.audio;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.util.Log;
import java.util.List;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes3.dex */
public class Android12SpeakerController implements SpeakerController {
    private final String TAG = Android12SpeakerController.class.getSimpleName();
    private final AudioManager audioManager;

    public Android12SpeakerController(Context context) {
        this.audioManager = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
    }

    @Override // com.sinch.android.rtc.internal.client.audio.SpeakerController
    public void disable() {
        List<AudioDeviceInfo> availableCommunicationDevices;
        availableCommunicationDevices = this.audioManager.getAvailableCommunicationDevices();
        AudioDeviceInfo audioDeviceInfo = null;
        AudioDeviceInfo audioDeviceInfo2 = null;
        for (AudioDeviceInfo audioDeviceInfo3 : availableCommunicationDevices) {
            if (audioDeviceInfo3.isSink()) {
                int type = audioDeviceInfo3.getType();
                if (type == 1) {
                    audioDeviceInfo2 = audioDeviceInfo3;
                }
                if (type == 3 || type == 4) {
                    audioDeviceInfo = audioDeviceInfo3;
                }
                if (type == 7 || type == 26) {
                    this.audioManager.setCommunicationDevice(audioDeviceInfo3);
                    return;
                }
            }
        }
        if (audioDeviceInfo != null) {
            this.audioManager.setCommunicationDevice(audioDeviceInfo);
        } else if (audioDeviceInfo2 != null) {
            this.audioManager.setCommunicationDevice(audioDeviceInfo2);
        } else {
            Log.w(this.TAG, "Disabling the speakerphone failed as no suitable device was found");
        }
    }

    @Override // com.sinch.android.rtc.internal.client.audio.SpeakerController
    public void enable() {
        List<AudioDeviceInfo> availableCommunicationDevices;
        availableCommunicationDevices = this.audioManager.getAvailableCommunicationDevices();
        for (AudioDeviceInfo audioDeviceInfo : availableCommunicationDevices) {
            if (audioDeviceInfo.getType() == 2) {
                this.audioManager.setCommunicationDevice(audioDeviceInfo);
                return;
            }
        }
        Log.w(this.TAG, "Enabling the speakerphone failed as no device with type TYPE_BUILTIN_SPEAKER was found");
    }
}
