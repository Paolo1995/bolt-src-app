package org.webrtc.sinch;

import android.util.Log;

/* loaded from: classes4.dex */
public class AudioDeviceUtil {
    private static int _audioMode = 0;
    private static int _audioSource = 1;
    private static boolean _overrideAudioMode = false;
    public static final String logTag = "Sinch-AudioDeviceUtil";

    public static void LogException(String str, Exception exc) {
        Log.d(str, "Unexpected exception: ", exc);
    }

    public static synchronized int getAudioMode() {
        int i8;
        synchronized (AudioDeviceUtil.class) {
            i8 = _audioMode;
        }
        return i8;
    }

    public static synchronized int getAudioSource() {
        int i8;
        synchronized (AudioDeviceUtil.class) {
            i8 = _audioSource;
        }
        return i8;
    }

    public static synchronized void setAudioMode(int i8) {
        synchronized (AudioDeviceUtil.class) {
            _audioMode = i8;
        }
    }

    public static synchronized void setAudioSource(int i8) {
        synchronized (AudioDeviceUtil.class) {
            _audioSource = i8;
        }
    }

    public static synchronized void setOverrideAudioMode(boolean z7) {
        synchronized (AudioDeviceUtil.class) {
            _overrideAudioMode = z7;
        }
    }

    public static synchronized boolean shouldOverrideAudioMode() {
        boolean z7;
        synchronized (AudioDeviceUtil.class) {
            z7 = _overrideAudioMode;
        }
        return z7;
    }
}
