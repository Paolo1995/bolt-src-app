package org.webrtc.audio;

import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.AudioEffect;
import android.media.audiofx.NoiseSuppressor;
import java.util.UUID;
import org.webrtc.Logging;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class WebRtcAudioEffects {
    private static final UUID AOSP_ACOUSTIC_ECHO_CANCELER = UUID.fromString("bb392ec0-8d4d-11e0-a896-0002a5d5c51b");
    private static final UUID AOSP_NOISE_SUPPRESSOR = UUID.fromString("c06c8400-8e06-11e0-9cb6-0002a5d5c51b");
    private static final boolean DEBUG = false;
    private static final String TAG = "WebRtcAudioEffectsExternal";
    private static AudioEffect.Descriptor[] cachedEffects;
    private AcousticEchoCanceler aec;
    private NoiseSuppressor ns;
    private boolean shouldEnableAec;
    private boolean shouldEnableNs;

    public WebRtcAudioEffects() {
        Logging.d(TAG, "ctor" + WebRtcAudioUtils.getThreadInfo());
    }

    private static void assertTrue(boolean z7) {
        if (!z7) {
            throw new AssertionError("Expected condition to be true");
        }
    }

    private boolean effectTypeIsVoIP(UUID uuid) {
        return (AudioEffect.EFFECT_TYPE_AEC.equals(uuid) && isAcousticEchoCancelerSupported()) || (AudioEffect.EFFECT_TYPE_NS.equals(uuid) && isNoiseSuppressorSupported());
    }

    private static AudioEffect.Descriptor[] getAvailableEffects() {
        AudioEffect.Descriptor[] descriptorArr = cachedEffects;
        if (descriptorArr != null) {
            return descriptorArr;
        }
        AudioEffect.Descriptor[] queryEffects = AudioEffect.queryEffects();
        cachedEffects = queryEffects;
        return queryEffects;
    }

    public static boolean isAcousticEchoCancelerSupported() {
        return isEffectTypeAvailable(AudioEffect.EFFECT_TYPE_AEC, AOSP_ACOUSTIC_ECHO_CANCELER);
    }

    private static boolean isEffectTypeAvailable(UUID uuid, UUID uuid2) {
        AudioEffect.Descriptor[] availableEffects = getAvailableEffects();
        if (availableEffects == null) {
            return false;
        }
        for (AudioEffect.Descriptor descriptor : availableEffects) {
            if (descriptor.type.equals(uuid)) {
                return !descriptor.uuid.equals(uuid2);
            }
        }
        return false;
    }

    public static boolean isNoiseSuppressorSupported() {
        return isEffectTypeAvailable(AudioEffect.EFFECT_TYPE_NS, AOSP_NOISE_SUPPRESSOR);
    }

    public void enable(int i8) {
        Logging.d(TAG, "enable(audioSession=" + i8 + ")");
        boolean z7 = true;
        assertTrue(this.aec == null);
        assertTrue(this.ns == null);
        if (isAcousticEchoCancelerSupported()) {
            AcousticEchoCanceler create = AcousticEchoCanceler.create(i8);
            this.aec = create;
            if (create != null) {
                boolean enabled = create.getEnabled();
                boolean z8 = this.shouldEnableAec && isAcousticEchoCancelerSupported();
                if (this.aec.setEnabled(z8) != 0) {
                    Logging.e(TAG, "Failed to set the AcousticEchoCanceler state");
                }
                StringBuilder sb = new StringBuilder();
                sb.append("AcousticEchoCanceler: was ");
                sb.append(enabled ? "enabled" : "disabled");
                sb.append(", enable: ");
                sb.append(z8);
                sb.append(", is now: ");
                sb.append(this.aec.getEnabled() ? "enabled" : "disabled");
                Logging.d(TAG, sb.toString());
            } else {
                Logging.e(TAG, "Failed to create the AcousticEchoCanceler instance");
            }
        }
        if (isNoiseSuppressorSupported()) {
            NoiseSuppressor create2 = NoiseSuppressor.create(i8);
            this.ns = create2;
            if (create2 == null) {
                Logging.e(TAG, "Failed to create the NoiseSuppressor instance");
                return;
            }
            boolean enabled2 = create2.getEnabled();
            z7 = (this.shouldEnableNs && isNoiseSuppressorSupported()) ? false : false;
            if (this.ns.setEnabled(z7) != 0) {
                Logging.e(TAG, "Failed to set the NoiseSuppressor state");
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("NoiseSuppressor: was ");
            sb2.append(enabled2 ? "enabled" : "disabled");
            sb2.append(", enable: ");
            sb2.append(z7);
            sb2.append(", is now: ");
            sb2.append(this.ns.getEnabled() ? "enabled" : "disabled");
            Logging.d(TAG, sb2.toString());
        }
    }

    public void release() {
        Logging.d(TAG, "release");
        AcousticEchoCanceler acousticEchoCanceler = this.aec;
        if (acousticEchoCanceler != null) {
            acousticEchoCanceler.release();
            this.aec = null;
        }
        NoiseSuppressor noiseSuppressor = this.ns;
        if (noiseSuppressor != null) {
            noiseSuppressor.release();
            this.ns = null;
        }
    }

    public boolean setAEC(boolean z7) {
        Logging.d(TAG, "setAEC(" + z7 + ")");
        if (!isAcousticEchoCancelerSupported()) {
            Logging.w(TAG, "Platform AEC is not supported");
            this.shouldEnableAec = false;
            return false;
        } else if (this.aec == null || z7 == this.shouldEnableAec) {
            this.shouldEnableAec = z7;
            return true;
        } else {
            Logging.e(TAG, "Platform AEC state can't be modified while recording");
            return false;
        }
    }

    public boolean setNS(boolean z7) {
        Logging.d(TAG, "setNS(" + z7 + ")");
        if (!isNoiseSuppressorSupported()) {
            Logging.w(TAG, "Platform NS is not supported");
            this.shouldEnableNs = false;
            return false;
        } else if (this.ns == null || z7 == this.shouldEnableNs) {
            this.shouldEnableNs = z7;
            return true;
        } else {
            Logging.e(TAG, "Platform NS state can't be modified while recording");
            return false;
        }
    }
}
