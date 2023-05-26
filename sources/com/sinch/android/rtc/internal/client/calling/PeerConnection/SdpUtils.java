package com.sinch.android.rtc.internal.client.calling.PeerConnection;

import android.util.Log;
import com.sinch.gson.JsonObject;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import org.webrtc.SessionDescription;

/* loaded from: classes3.dex */
public class SdpUtils {
    private static final String AUDIO_CODEC_PARAM_BITRATE = "maxaveragebitrate";
    public static final String TAG = "SdpUtils";
    private static final String VIDEO_CODEC_PARAM_START_BITRATE = "x-google-start-bitrate";
    public static final int defaultAudioBitrateKbps = 32;
    public static final int defaultVideoBitrateKbps = 1500;
    public static final int maxAudioBitrateKbps = 100;
    public static final int maxVideoBitrateKbps = 5000;

    public static String createSdpJson(SessionDescription sessionDescription) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", sessionDescription.type.canonicalForm());
        jsonObject.addProperty("sdp", sessionDescription.description);
        return jsonObject.toString();
    }

    private static int findMediaDescriptionLine(boolean z7, String[] strArr) {
        String str = z7 ? "m=audio " : "m=video ";
        for (int i8 = 0; i8 < strArr.length; i8++) {
            if (strArr[i8].startsWith(str)) {
                return i8;
            }
        }
        return -1;
    }

    public static final String getIceFoundationForRelayUdp(String str) {
        CRC32 crc32 = new CRC32();
        crc32.update(("relay" + str + "udp").getBytes());
        return Long.valueOf(crc32.getValue()).toString();
    }

    public static String insertSdpLine(String str, String str2, String str3) {
        String[] split;
        String str4 = "";
        for (String str5 : str.split("\r\n")) {
            str4 = str4 + str5 + "\r\n";
            if (str5.startsWith(str2)) {
                str4 = str4 + str3 + "\r\n";
            }
        }
        return str4;
    }

    private static String joinString(Iterable<? extends CharSequence> iterable, String str, boolean z7) {
        Iterator<? extends CharSequence> it = iterable.iterator();
        if (it.hasNext()) {
            StringBuilder sb = new StringBuilder(it.next());
            while (it.hasNext()) {
                sb.append(str);
                sb.append(it.next());
            }
            if (z7) {
                sb.append(str);
            }
            return sb.toString();
        }
        return "";
    }

    public static String movePayloadTypesToFront(List<String> list, String str) {
        List asList = Arrays.asList(str.split(" "));
        if (asList.size() <= 3) {
            String str2 = TAG;
            Log.e(str2, "Wrong SDP media description format: " + str);
            return null;
        }
        List subList = asList.subList(0, 3);
        ArrayList arrayList = new ArrayList(asList.subList(3, asList.size()));
        arrayList.removeAll(list);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(subList);
        arrayList2.addAll(list);
        arrayList2.addAll(arrayList);
        return joinString(arrayList2, " ", false);
    }

    public static String preferCodec(String str, String str2, boolean z7) {
        String[] split = str.split("\r\n");
        int findMediaDescriptionLine = findMediaDescriptionLine(z7, split);
        if (findMediaDescriptionLine == -1) {
            Log.w(TAG, "No mediaDescription line, so can't prefer " + str2);
            return str;
        }
        ArrayList arrayList = new ArrayList();
        Pattern compile = Pattern.compile("^a=rtpmap:(\\d+) " + str2 + "(/\\d+)+[\r]?$");
        for (String str3 : split) {
            Matcher matcher = compile.matcher(str3);
            if (matcher.matches()) {
                arrayList.add(matcher.group(1));
            }
        }
        if (arrayList.isEmpty()) {
            Log.w(TAG, "No payload types with name " + str2);
            return str;
        }
        String movePayloadTypesToFront = movePayloadTypesToFront(arrayList, split[findMediaDescriptionLine]);
        if (movePayloadTypesToFront == null) {
            return str;
        }
        Log.d(TAG, "Change media description from: " + split[findMediaDescriptionLine] + " to " + movePayloadTypesToFront);
        split[findMediaDescriptionLine] = movePayloadTypesToFront;
        return joinString(Arrays.asList(split), "\r\n", true);
    }

    public static String removeExtensions(String str, String str2) {
        LinkedList linkedList = new LinkedList();
        String[] split = str.split("\r\n");
        Pattern compile = Pattern.compile("^a=extmap:\\d+ .*" + str2 + ".*$");
        for (String str3 : split) {
            if (compile.matcher(str3).matches()) {
                linkedList.add(str3);
            }
        }
        LinkedList linkedList2 = new LinkedList();
        linkedList2.addAll(Arrays.asList(split));
        linkedList2.removeAll(linkedList);
        return joinString(linkedList2, "\r\n", true);
    }

    public static String setMaxBandwidth(String str, int i8, int i9) throws InvalidParameterException {
        if (str != null) {
            if (i8 >= 0) {
                if (i9 >= 0) {
                    if (i8 == 0) {
                        i8 = 32;
                    }
                    if (i9 == 0) {
                        i9 = 1500;
                    }
                    int min = Math.min(i8, 100);
                    return setMaxBandwidth(setMaxBandwidth(str, min, true), Math.min(i9, 5000), false);
                }
                throw new InvalidParameterException("videoBandwidth should be non-negative integer!");
            }
            throw new InvalidParameterException("audioBandwidth should be non-negative integer!");
        }
        throw new InvalidParameterException("sdpDescription should not be null!");
    }

    public static String setMaxBandwidth(String str, int i8, boolean z7) {
        List list;
        String[] split = str.split("\r\n");
        int findMediaDescriptionLine = findMediaDescriptionLine(z7, split);
        String str2 = "b=AS:" + i8;
        if (findMediaDescriptionLine == -1) {
            Log.w(TAG, "No mediaDescription line, so can't set bandwidth!");
            return str;
        }
        int i9 = findMediaDescriptionLine + 1;
        while (i9 < split.length && (split[i9].startsWith("i") || split[i9].startsWith("c"))) {
            i9++;
        }
        if (i9 >= split.length || !split[i9].startsWith("b")) {
            LinkedList linkedList = new LinkedList(Arrays.asList(split));
            linkedList.add(i9, str2);
            list = linkedList;
        } else {
            split[i9] = str2;
            list = Arrays.asList(split);
        }
        return joinString(list, "\r\n", true);
    }

    public static String setStartBitrate(String str, boolean z7, String str2, int i8) {
        boolean z8;
        String str3;
        StringBuilder sb;
        String[] split = str2.split("\r\n");
        Pattern compile = Pattern.compile("^a=rtpmap:(\\d+) " + str + "(/\\d+)+[\r]?$");
        int i9 = 0;
        while (true) {
            z8 = true;
            if (i9 >= split.length) {
                i9 = -1;
                str3 = null;
                break;
            }
            Matcher matcher = compile.matcher(split[i9]);
            if (matcher.matches()) {
                str3 = matcher.group(1);
                break;
            }
            i9++;
        }
        if (str3 == null) {
            String str4 = TAG;
            Log.w(str4, "No rtpmap for " + str + " codec");
            return str2;
        }
        String str5 = TAG;
        Log.d(str5, "Found " + str + " rtpmap " + str3 + " at " + split[i9]);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("^a=fmtp:");
        sb2.append(str3);
        sb2.append(" \\w+=\\d+.*[\r]?$");
        Pattern compile2 = Pattern.compile(sb2.toString());
        int i10 = 0;
        while (true) {
            if (i10 >= split.length) {
                z8 = false;
                break;
            } else if (compile2.matcher(split[i10]).matches()) {
                String str6 = TAG;
                Log.d(str6, "Found " + str + " " + split[i10]);
                if (z7) {
                    split[i10] = split[i10] + "; x-google-start-bitrate=" + i8;
                } else {
                    split[i10] = split[i10] + "; maxaveragebitrate=" + (i8 * 1000);
                }
                Log.d(str6, "Update remote SDP line: " + split[i10]);
            } else {
                i10++;
            }
        }
        StringBuilder sb3 = new StringBuilder();
        for (int i11 = 0; i11 < split.length; i11++) {
            sb3.append(split[i11]);
            sb3.append("\r\n");
            if (!z8 && i11 == i9) {
                if (z7) {
                    sb = new StringBuilder();
                    sb.append("a=fmtp:");
                    sb.append(str3);
                    sb.append(" ");
                    sb.append("x-google-start-bitrate");
                    sb.append("=");
                    sb.append(i8);
                } else {
                    sb = new StringBuilder();
                    sb.append("a=fmtp:");
                    sb.append(str3);
                    sb.append(" ");
                    sb.append("maxaveragebitrate");
                    sb.append("=");
                    sb.append(i8 * 1000);
                }
                String sb4 = sb.toString();
                String str7 = TAG;
                Log.d(str7, "Add remote SDP line: " + sb4);
                sb3.append(sb4);
                sb3.append("\r\n");
            }
        }
        return sb3.toString();
    }
}
