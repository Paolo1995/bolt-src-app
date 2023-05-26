package org.webrtc;

import java.util.Map;

/* loaded from: classes4.dex */
public class RTCStats {
    private final String id;
    private final Map<String, Object> members;
    private final long timestampUs;
    private final String type;

    public RTCStats(long j8, String str, String str2, Map<String, Object> map) {
        this.timestampUs = j8;
        this.type = str;
        this.id = str2;
        this.members = map;
    }

    private static void appendValue(StringBuilder sb, Object obj) {
        if (!(obj instanceof Object[])) {
            if (!(obj instanceof String)) {
                sb.append(obj);
                return;
            }
            sb.append('\"');
            sb.append(obj);
            sb.append('\"');
            return;
        }
        Object[] objArr = (Object[]) obj;
        sb.append('[');
        for (int i8 = 0; i8 < objArr.length; i8++) {
            if (i8 != 0) {
                sb.append(", ");
            }
            appendValue(sb, objArr[i8]);
        }
        sb.append(']');
    }

    @CalledByNative
    public static RTCStats create(long j8, String str, String str2, Map map) {
        return new RTCStats(j8, str, str2, map);
    }

    public String getId() {
        return this.id;
    }

    public Map<String, Object> getMembers() {
        return this.members;
    }

    public double getTimestampUs() {
        return this.timestampUs;
    }

    public String getType() {
        return this.type;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ timestampUs: ");
        sb.append(this.timestampUs);
        sb.append(", type: ");
        sb.append(this.type);
        sb.append(", id: ");
        sb.append(this.id);
        for (Map.Entry<String, Object> entry : this.members.entrySet()) {
            sb.append(", ");
            sb.append(entry.getKey());
            sb.append(": ");
            appendValue(sb, entry.getValue());
        }
        sb.append(" }");
        return sb.toString();
    }
}
