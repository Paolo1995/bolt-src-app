package com.sinch.android.rtc.internal.client.calling.PeerConnection;

import android.os.Environment;
import android.util.Log;
import j$.util.DesugarArrays;
import j$.util.function.Predicate;
import java.io.File;
import org.webrtc.MediaConstraints;
import org.webrtc.PeerConnectionFactory;
import org.webrtc.VideoCodecInfo;
import org.webrtc.voiceengine.WebRtcAudioManager;
import org.webrtc.voiceengine.WebRtcAudioUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class PeerConnectionUtils {
    public static final String AUDIO_AUTO_GAIN_CONTROL_CONSTRAINT = "googAutoGainControl";
    public static final String AUDIO_CODEC_PARAM_BITRATE = "maxaveragebitrate";
    public static final String AUDIO_ECHO_CANCELLATION_CONSTRAINT = "googEchoCancellation";
    public static final String AUDIO_HIGH_PASS_FILTER_CONSTRAINT = "googHighpassFilter";
    public static final String AUDIO_LEVEL_CONTROL_CONSTRAINT = "levelControl";
    public static final String AUDIO_NOISE_SUPPRESSION_CONSTRAINT = "googNoiseSuppression";
    public static final String DTLS_SRTP_KEY_AGREEMENT_CONSTRAINT = "DtlsSrtpKeyAgreement";
    public static final int HD_VIDEO_HEIGHT = 720;
    public static final int HD_VIDEO_WIDTH = 1280;
    public static final int MAX_VIDEO_FPS = 30;
    public static final String MAX_VIDEO_FPS_CONSTRAINT = "maxFrameRate";
    public static final int MAX_VIDEO_HEIGHT = 1280;
    public static final String MAX_VIDEO_HEIGHT_CONSTRAINT = "maxHeight";
    public static final int MAX_VIDEO_WIDTH = 1280;
    public static final String MAX_VIDEO_WIDTH_CONSTRAINT = "maxWidth";
    public static final String MIN_VIDEO_FPS_CONSTRAINT = "minFrameRate";
    public static final String MIN_VIDEO_HEIGHT_CONSTRAINT = "minHeight";
    public static final String MIN_VIDEO_WIDTH_CONSTRAINT = "minWidth";
    private static final String TAG = DefaultPeerConnectionClient.class.getSimpleName();
    public static final String VIDEO_CODEC_H264 = "H264";
    public static final String VIDEO_CODEC_H264_BASELINE = "H264 Baseline";
    public static final String VIDEO_CODEC_H264_HIGH = "H264 High";
    public static final String VIDEO_CODEC_PARAM_START_BITRATE = "x-google-start-bitrate";
    public static final String VIDEO_CODEC_VP8 = "VP8";
    public static final String VIDEO_CODEC_VP9 = "VP9";

    public static String checkPreferredVideoCodec(PeerConnectionParameters peerConnectionParameters, boolean z7) {
        String str;
        String str2 = VIDEO_CODEC_H264;
        if (z7 && (str = peerConnectionParameters.videoCodec) != null) {
            char c8 = 65535;
            switch (str.hashCode()) {
                case -2140422726:
                    if (str.equals(VIDEO_CODEC_H264_HIGH)) {
                        c8 = 0;
                        break;
                    }
                    break;
                case -1031013795:
                    if (str.equals(VIDEO_CODEC_H264_BASELINE)) {
                        c8 = 1;
                        break;
                    }
                    break;
                case 85183:
                    if (str.equals(VIDEO_CODEC_VP9)) {
                        c8 = 2;
                        break;
                    }
                    break;
                case 2194728:
                    if (str.equals(VIDEO_CODEC_H264)) {
                        c8 = 3;
                        break;
                    }
                    break;
            }
            switch (c8) {
                case 2:
                    str2 = VIDEO_CODEC_VP9;
                    break;
            }
            String str3 = TAG;
            Log.d(str3, "Preferred video codec: " + str2);
            return str2;
        }
        str2 = VIDEO_CODEC_VP8;
        String str32 = TAG;
        Log.d(str32, "Preferred video codec: " + str2);
        return str2;
    }

    public static MediaConstraints[] createMediaConstraints(PeerConnectionFactoryWrapper peerConnectionFactoryWrapper, boolean z7, boolean z8, boolean z9, PeerConnectionParameters peerConnectionParameters) {
        MediaConstraints[] mediaConstraintsArr = new MediaConstraints[3];
        MediaConstraints mediaConstraints = new MediaConstraints();
        if (z7) {
            Log.d(TAG, "Disabling audio processing");
            mediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair(AUDIO_ECHO_CANCELLATION_CONSTRAINT, "false"));
            mediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair(AUDIO_AUTO_GAIN_CONTROL_CONSTRAINT, "false"));
            mediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair(AUDIO_HIGH_PASS_FILTER_CONSTRAINT, "false"));
            mediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair(AUDIO_NOISE_SUPPRESSION_CONSTRAINT, "false"));
        }
        if (z8) {
            Log.d(TAG, "Enabling level control.");
            mediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair(AUDIO_LEVEL_CONTROL_CONSTRAINT, "true"));
        }
        MediaConstraints mediaConstraints2 = new MediaConstraints();
        mediaConstraints2.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveAudio", "true"));
        if (z9) {
            mediaConstraints2.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveVideo", "true"));
        } else {
            mediaConstraints2.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveVideo", "false"));
        }
        MediaConstraints mediaConstraints3 = new MediaConstraints();
        if (z9) {
            mediaConstraints3 = new MediaConstraints();
            int i8 = peerConnectionParameters.videoWidth;
            int i9 = peerConnectionParameters.videoHeight;
            if ((i8 == 0 || i9 == 0) && peerConnectionParameters.videoCodecHwAcceleration && isHwEncoderAvailable(peerConnectionFactoryWrapper, VIDEO_CODEC_VP8)) {
                i9 = HD_VIDEO_HEIGHT;
                i8 = 1280;
            }
            if (i8 > 0 && i9 > 0) {
                int min = Math.min(i8, 1280);
                int min2 = Math.min(i9, 1280);
                mediaConstraints3.mandatory.add(new MediaConstraints.KeyValuePair(MIN_VIDEO_WIDTH_CONSTRAINT, Integer.toString(min)));
                mediaConstraints3.mandatory.add(new MediaConstraints.KeyValuePair(MAX_VIDEO_WIDTH_CONSTRAINT, Integer.toString(min)));
                mediaConstraints3.mandatory.add(new MediaConstraints.KeyValuePair(MIN_VIDEO_HEIGHT_CONSTRAINT, Integer.toString(min2)));
                mediaConstraints3.mandatory.add(new MediaConstraints.KeyValuePair(MAX_VIDEO_HEIGHT_CONSTRAINT, Integer.toString(min2)));
            }
            int i10 = peerConnectionParameters.videoFps;
            if (i10 > 0) {
                int min3 = Math.min(i10, 30);
                mediaConstraints3.mandatory.add(new MediaConstraints.KeyValuePair(MIN_VIDEO_FPS_CONSTRAINT, Integer.toString(min3)));
                mediaConstraints3.mandatory.add(new MediaConstraints.KeyValuePair(MAX_VIDEO_FPS_CONSTRAINT, Integer.toString(min3)));
            }
        }
        mediaConstraintsArr[0] = mediaConstraints;
        mediaConstraintsArr[1] = mediaConstraints3;
        mediaConstraintsArr[2] = mediaConstraints2;
        return mediaConstraintsArr;
    }

    public static void enableWebRtcTracing(boolean z7) {
        if (z7) {
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            PeerConnectionFactory.startInternalTracingCapture(absolutePath + File.separator + "webrtc-trace.txt");
        }
    }

    private static boolean isCodecAvailable(PeerConnectionFactoryWrapper peerConnectionFactoryWrapper, boolean z7, final String str) {
        VideoCodecInfo[] encoders = z7 ? peerConnectionFactoryWrapper.getEncoders() : peerConnectionFactoryWrapper.getDecoders();
        if (!peerConnectionFactoryWrapper.isHardwareCodecsUsed() || encoders == null) {
            return false;
        }
        return DesugarArrays.stream(encoders).anyMatch(new Predicate() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.x0
            @Override // j$.util.function.Predicate
            public /* synthetic */ Predicate and(Predicate predicate) {
                return Predicate.CC.$default$and(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public /* synthetic */ Predicate negate() {
                return Predicate.CC.$default$negate(this);
            }

            @Override // j$.util.function.Predicate
            public /* synthetic */ Predicate or(Predicate predicate) {
                return Predicate.CC.$default$or(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public final boolean test(Object obj) {
                boolean lambda$isCodecAvailable$0;
                lambda$isCodecAvailable$0 = PeerConnectionUtils.lambda$isCodecAvailable$0(str, (VideoCodecInfo) obj);
                return lambda$isCodecAvailable$0;
            }
        });
    }

    private static boolean isHwDecoderAvailable(PeerConnectionFactoryWrapper peerConnectionFactoryWrapper, String str) {
        return isCodecAvailable(peerConnectionFactoryWrapper, false, str);
    }

    private static boolean isHwEncoderAvailable(PeerConnectionFactoryWrapper peerConnectionFactoryWrapper, String str) {
        return isCodecAvailable(peerConnectionFactoryWrapper, true, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$isCodecAvailable$0(String str, VideoCodecInfo videoCodecInfo) {
        return videoCodecInfo.name.toLowerCase().contains(str.toLowerCase());
    }

    public static void setupAudioProcessing(PeerConnectionParameters peerConnectionParameters) {
        if (peerConnectionParameters.useOpenSLES) {
            Log.d(TAG, "Allow OpenSL ES audio if device supports it");
            WebRtcAudioManager.setBlacklistDeviceForOpenSLESUsage(false);
        } else {
            Log.d(TAG, "Disable OpenSL ES audio even if device supports it");
            WebRtcAudioManager.setBlacklistDeviceForOpenSLESUsage(true);
        }
        if (peerConnectionParameters.disableBuiltInAEC) {
            Log.d(TAG, "Disable built-in AEC even if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAcousticEchoCanceler(true);
        } else {
            Log.d(TAG, "Enable built-in AEC if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAcousticEchoCanceler(false);
        }
        if (peerConnectionParameters.disableBuiltInAGC) {
            Log.d(TAG, "Disable built-in AGC even if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAutomaticGainControl(true);
        } else {
            Log.d(TAG, "Enable built-in AGC if device supports it");
            WebRtcAudioUtils.setWebRtcBasedAutomaticGainControl(false);
        }
        if (peerConnectionParameters.disableBuiltInNS) {
            Log.d(TAG, "Disable built-in NS even if device supports it");
            WebRtcAudioUtils.setWebRtcBasedNoiseSuppressor(true);
            return;
        }
        Log.d(TAG, "Enable built-in NS if device supports it");
        WebRtcAudioUtils.setWebRtcBasedNoiseSuppressor(false);
    }
}
