package org.webrtc;

import java.util.Map;

/* loaded from: classes4.dex */
public class RTCStatsReport {
    private final Map<String, RTCStats> stats;
    private final long timestampUs;

    public RTCStatsReport(long j8, Map<String, RTCStats> map) {
        this.timestampUs = j8;
        this.stats = map;
    }

    @CalledByNative
    private static RTCStatsReport create(long j8, Map map) {
        return new RTCStatsReport(j8, map);
    }

    public Map<String, RTCStats> getStatsMap() {
        return this.stats;
    }

    public double getTimestampUs() {
        return this.timestampUs;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ timestampUs: ");
        sb.append(this.timestampUs);
        sb.append(", stats: [\n");
        boolean z7 = true;
        for (RTCStats rTCStats : this.stats.values()) {
            if (!z7) {
                sb.append(",\n");
            }
            sb.append(rTCStats);
            z7 = false;
        }
        sb.append(" ] }");
        return sb.toString();
    }
}
