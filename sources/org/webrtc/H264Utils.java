package org.webrtc;

import com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
class H264Utils {
    public static VideoCodecInfo DEFAULT_H264_BASELINE_PROFILE_CODEC = new VideoCodecInfo(PeerConnectionUtils.VIDEO_CODEC_H264, getDefaultH264Params(false));
    public static VideoCodecInfo DEFAULT_H264_HIGH_PROFILE_CODEC = new VideoCodecInfo(PeerConnectionUtils.VIDEO_CODEC_H264, getDefaultH264Params(true));
    public static final String H264_CONSTRAINED_BASELINE_3_1 = "42e01f";
    public static final String H264_CONSTRAINED_HIGH_3_1 = "640c1f";
    public static final String H264_FMTP_LEVEL_ASYMMETRY_ALLOWED = "level-asymmetry-allowed";
    public static final String H264_FMTP_PACKETIZATION_MODE = "packetization-mode";
    public static final String H264_FMTP_PROFILE_LEVEL_ID = "profile-level-id";
    public static final String H264_LEVEL_3_1 = "1f";
    public static final String H264_PROFILE_CONSTRAINED_BASELINE = "42e0";
    public static final String H264_PROFILE_CONSTRAINED_HIGH = "640c";

    public static Map<String, String> getDefaultH264Params(boolean z7) {
        HashMap hashMap = new HashMap();
        hashMap.put("level-asymmetry-allowed", "1");
        hashMap.put("packetization-mode", "1");
        hashMap.put("profile-level-id", z7 ? "640c1f" : "42e01f");
        return hashMap;
    }

    public static boolean isSameH264Profile(Map<String, String> map, Map<String, String> map2) {
        return nativeIsSameH264Profile(map, map2);
    }

    private static native boolean nativeIsSameH264Profile(Map<String, String> map, Map<String, String> map2);
}
