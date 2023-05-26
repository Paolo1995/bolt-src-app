package org.webrtc.audio;

import android.media.AudioManager;
import com.sinch.android.rtc.internal.client.calling.DefaultCallController;
import java.util.Timer;
import java.util.TimerTask;
import org.webrtc.Logging;

/* loaded from: classes4.dex */
class VolumeLogger {
    private static final String TAG = "VolumeLogger";
    private static final String THREAD_NAME = "WebRtcVolumeLevelLoggerThread";
    private static final int TIMER_PERIOD_IN_SECONDS = 30;
    private final AudioManager audioManager;
    private Timer timer;

    /* loaded from: classes4.dex */
    public class LogVolumeTask extends TimerTask {
        private final int maxRingVolume;
        private final int maxVoiceCallVolume;

        public LogVolumeTask(int i8, int i9) {
            this.maxRingVolume = i8;
            this.maxVoiceCallVolume = i9;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            StringBuilder sb;
            int i8;
            int mode = VolumeLogger.this.audioManager.getMode();
            if (mode == 1) {
                sb = new StringBuilder();
                sb.append("STREAM_RING stream volume: ");
                sb.append(VolumeLogger.this.audioManager.getStreamVolume(2));
                sb.append(" (max=");
                i8 = this.maxRingVolume;
            } else if (mode != 3) {
                return;
            } else {
                sb = new StringBuilder();
                sb.append("VOICE_CALL stream volume: ");
                sb.append(VolumeLogger.this.audioManager.getStreamVolume(0));
                sb.append(" (max=");
                i8 = this.maxVoiceCallVolume;
            }
            sb.append(i8);
            sb.append(")");
            Logging.d(VolumeLogger.TAG, sb.toString());
        }
    }

    public VolumeLogger(AudioManager audioManager) {
        this.audioManager = audioManager;
    }

    public void start() {
        Logging.d(TAG, "start" + WebRtcAudioUtils.getThreadInfo());
        if (this.timer != null) {
            return;
        }
        Logging.d(TAG, "audio mode is: " + WebRtcAudioUtils.modeToString(this.audioManager.getMode()));
        Timer timer = new Timer(THREAD_NAME);
        this.timer = timer;
        timer.schedule(new LogVolumeTask(this.audioManager.getStreamMaxVolume(2), this.audioManager.getStreamMaxVolume(0)), 0L, DefaultCallController.ICE_SERVERS_VALID_WINDOW_MS);
    }

    public void stop() {
        Logging.d(TAG, "stop" + WebRtcAudioUtils.getThreadInfo());
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer = null;
        }
    }
}
