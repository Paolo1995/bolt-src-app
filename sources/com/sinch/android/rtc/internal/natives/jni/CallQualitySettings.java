package com.sinch.android.rtc.internal.natives.jni;

import android.media.AudioManager;
import android.util.Log;
import org.webrtc.ContextUtils;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes3.dex */
public class CallQualitySettings {
    private static final String TAG = "CallQualitySettings";
    private final AudioManager mAudioManager;
    private boolean mAudioModeNeedsRestore;
    private int mSavedAudioMode;

    public CallQualitySettings() {
        this.mAudioModeNeedsRestore = false;
        this.mSavedAudioMode = -2;
        this.mAudioManager = (AudioManager) ContextUtils.getApplicationContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
    }

    public CallQualitySettings(AudioManager audioManager) {
        this.mAudioModeNeedsRestore = false;
        this.mSavedAudioMode = -2;
        this.mAudioManager = audioManager;
    }

    public void setCommunicationMode(boolean z7) {
        boolean z8;
        if (z7) {
            if (this.mAudioManager.getMode() == 3) {
                return;
            }
            this.mSavedAudioMode = this.mAudioManager.getMode();
            try {
                this.mAudioManager.setMode(3);
            } catch (SecurityException e8) {
                Log.e(TAG, "Could not change AudioManager mode to MODE_IN_COMMUNICATION: " + e8);
            }
            z8 = true;
        } else if (!this.mAudioModeNeedsRestore) {
            return;
        } else {
            try {
                this.mAudioManager.setMode(this.mSavedAudioMode);
            } catch (SecurityException e9) {
                Log.e(TAG, "Could not change AudioManager mode to " + this.mSavedAudioMode + ": " + e9);
            }
            z8 = false;
        }
        this.mAudioModeNeedsRestore = z8;
    }
}
