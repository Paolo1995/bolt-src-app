package com.sinch.android.rtc.internal.client.calling.PeerConnection;

import android.util.Log;
import com.sinch.android.rtc.internal.natives.ConnectionInfo;
import com.sinch.android.rtc.internal.natives.StatsReport;
import com.sinch.android.rtc.internal.natives.jni.Call;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.webrtc.RTCStats;
import org.webrtc.RTCStatsReport;

/* loaded from: classes3.dex */
public class StatsCollector {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String AUDIO_STATS_TAG = "AUDIO STATS";
    private static final String CONN_INFO_HOST = "ip";
    private static final String CONN_INFO_PORT = "port";
    private static final String CONN_INFO_PROTOCOL = "protocol";
    private static final String CONN_INFO_TYPE = "candidateType";
    private static final String SINCH_INBOUND_RTP_STATS_TAG = "inbound-rtp";
    private static final String SINCH_LOCAL_CANDIDATE_TAG = "localCandidateId";
    private static final String SINCH_MEDIASOURCE_KIND_TAG = "kind";
    private static final String SINCH_MEDIATYPE_AUDIO = "audio";
    private static final String SINCH_MEDIATYPE_VIDEO = "video";
    private static final String SINCH_MEDIA_SOURCE_STATS_TAG = "media-source";
    private static final String SINCH_NETWORK_TYPE_TAG = "networkType";
    private static final String SINCH_OUTBOUND_RTP_STATS_TAG = "outbound-rtp";
    private static final String SINCH_REMOTE_CANDIDATE_TAG = "remoteCandidateId";
    private static final String SINCH_STATS_TYPE = "sinch_statsType";
    private static final String SINCH_STAT_ID = "sinch_statId";
    private static final String SINCH_TIMESTAMP_US = "sinch_timeStampUs";
    private static final String SINCH_MEDIATYPE_TAG = "mediaType";
    private static final String PACKETS_RECEIVED_TAG = "packetsReceived";
    private static final String PACKETS_LOST_TAG = "packetsLost";
    private static final String[] RTP_STATS = {"codecId", "trackId", SINCH_MEDIATYPE_TAG, PACKETS_RECEIVED_TAG, "bytesReceived", PACKETS_LOST_TAG, "packetsSent", "bytesSent", "jitter", "qpSum", "qpSum", "framesEncoded", "framesDecoded"};
    private static final String[] MEDIA_SOURCE_STATS = {"audioLevel", "totalAudioEnergy", "totalSamplesDuration"};
    private static final String[] CANDIDATE_PAIR_STATS = {"bytesSent", "bytesReceived", "totalRoundTripTime", "currentRoundTripTime", "availableOutgoingBitrate", "requestsReceived", "requestsSent", "responsesReceived", "responsesSent", "consentRequestsSent"};
    private static final String[] TRACK_STATS = {"audioLevel", "totalSamplesReceived", "totalSamplesDuration", "concealedSamples", "concealmentEvents", "frameWidth", "frameHeight", "framesReceived", "framesDecoded", "framesDropped", "framesSent", "hugeFramesSent"};
    private static CumulativeValue[] cumulativeValues = {new CumulativeValue(), new CumulativeValue(), new CumulativeValue(), new CumulativeValue()};

    /* loaded from: classes3.dex */
    public static class CumulativeValue {
        private double curAvgVal;
        private long prevTs;
        private double prevVal;

        private CumulativeValue() {
        }

        public void addValue(long j8, double d8) {
            double d9 = this.prevVal;
            if (d8 > d9) {
                long j9 = this.prevTs;
                if (j8 > j9 && j9 != 0) {
                    this.curAvgVal = (d8 - d9) / ((j8 - j9) / 1000000);
                    this.prevTs = j8;
                    this.prevVal = d8;
                    return;
                }
            }
            reset(j8, d8);
        }

        public double getCurAvgVal() {
            return this.curAvgVal;
        }

        public float getCurAvgValFloat() {
            return (float) this.curAvgVal;
        }

        public int getCurAvgValInt() {
            return (int) this.curAvgVal;
        }

        public void reset(long j8, double d8) {
            this.prevTs = j8;
            this.prevVal = d8;
            this.curAvgVal = d8;
        }
    }

    /* loaded from: classes3.dex */
    public interface StatsFeedback {
        void onConnectionInfo(ConnectionInfo connectionInfo);

        void onStatisticReport(StatsReport[] statsReportArr);
    }

    private static native void addRtcStatsObjectToCollection(long j8, long j9);

    private static native void addRtcStatsValue(long j8, String str, double d8);

    private static native void addRtcStatsValue(long j8, String str, int i8);

    private static native void addRtcStatsValue(long j8, String str, long j9);

    private static native void addRtcStatsValue(long j8, String str, String str2);

    private static native void addRtcStatsValue(long j8, String str, boolean z7);

    private static StatsReport[] convertToFeedBack(RTCStatsReport rTCStatsReport) {
        Map<String, RTCStats> statsMap = rTCStatsReport.getStatsMap();
        ArrayList arrayList = new ArrayList();
        for (RTCStats rTCStats : statsMap.values()) {
            ArrayList arrayList2 = new ArrayList();
            for (Map.Entry<String, Object> entry : rTCStats.getMembers().entrySet()) {
                arrayList2.add(new StatsReport.Value(entry.getKey(), entry.getValue().toString()));
            }
            arrayList.add(new StatsReport(rTCStats.getId(), rTCStats.getType(), rTCStats.getTimestampUs() / 1000.0d, (StatsReport.Value[]) arrayList2.toArray(new StatsReport.Value[arrayList2.size()])));
        }
        return (StatsReport[]) arrayList.toArray(new StatsReport[arrayList.size()]);
    }

    private static native long createRtcStatsCollection();

    private static native long createRtcStatsObject(String str, String str2, double d8);

    private static void filterWithLookup(Map<String, Object> map, Map<String, Object> map2, String[] strArr) {
        if (map2 == null || map == null || strArr == null) {
            return;
        }
        for (String str : strArr) {
            Object obj = map2.get(str);
            if (obj != null) {
                map.put(str, obj);
            }
        }
    }

    private static Object getAndRemove(Map<String, Object> map, String str) {
        Object obj = map.get(str);
        map.remove(str);
        return obj;
    }

    private static void processSinchMediaStatsReport(Call call, SinchMediaStats sinchMediaStats, double d8, StatsFeedback statsFeedback) {
        String str;
        Map<String, Object> map;
        String str2;
        for (Map.Entry<Integer, Map<String, Object>> entry : sinchMediaStats.getMediaStatsCollections()) {
            updateTrackStatsFromLookup(entry.getValue(), sinchMediaStats, TRACK_STATS);
        }
        Iterator<Map.Entry<Integer, Map<String, Object>>> it = sinchMediaStats.getMediaStatsCollections().iterator();
        int i8 = 0;
        int i9 = 0;
        while (true) {
            boolean hasNext = it.hasNext();
            str = SINCH_TIMESTAMP_US;
            if (!hasNext) {
                break;
            }
            Map.Entry<Integer, Map<String, Object>> next = it.next();
            Map<String, Object> value = next.getValue();
            int intValue = next.getKey().intValue();
            if (value.get(SINCH_TIMESTAMP_US) != null) {
                long longValue = ((Long) value.get(SINCH_TIMESTAMP_US)).longValue();
                boolean z7 = value.get("bytesReceived") != null;
                cumulativeValues[intValue].addValue(longValue, ((BigInteger) value.get(z7 ? "bytesReceived" : "bytesSent")).doubleValue() * 8.0d);
                int curAvgValInt = cumulativeValues[intValue].getCurAvgValInt();
                value.put("actualBitrate", Integer.valueOf(curAvgValInt));
                if (z7) {
                    i8 += curAvgValInt;
                } else {
                    i9 += curAvgValInt;
                }
            }
        }
        sinchMediaStats.getCandidatePairStats().put("actualTotalBitrateInbound", Integer.valueOf(i8));
        sinchMediaStats.getCandidatePairStats().put("actualTotalBitrateOutbound", Integer.valueOf(i9));
        if (sinchMediaStats.localCandidateId != null && (str2 = sinchMediaStats.getNetworkTypesForLocalCands().get(sinchMediaStats.localCandidateId)) != null) {
            sinchMediaStats.getCandidatePairStats().put(SINCH_NETWORK_TYPE_TAG, str2);
        }
        Log.d(AUDIO_STATS_TAG, "COMMON    :" + sinchMediaStats.getCandidatePairStats().toString());
        long createRtcStatsCollection = createRtcStatsCollection();
        HashMap hashMap = new HashMap();
        Iterator<Map.Entry<Integer, Map<String, Object>>> it2 = sinchMediaStats.getMediaStatsCollections().iterator();
        while (it2.hasNext()) {
            Map.Entry<Integer, Map<String, Object>> next2 = it2.next();
            if (!next2.getValue().isEmpty()) {
                String str3 = (String) getAndRemove(next2.getValue(), SINCH_STAT_ID);
                long longValue2 = ((Long) getAndRemove(next2.getValue(), str)).longValue();
                String str4 = (String) getAndRemove(next2.getValue(), SINCH_STATS_TYPE);
                Object obj = sinchMediaStats.getCandidatePairStats().get("currentRoundTripTime");
                if (obj != null) {
                    next2.getValue().put("currentRoundTripTime", obj);
                }
                Iterator<Map.Entry<Integer, Map<String, Object>>> it3 = it2;
                String str5 = str;
                reportWebRtcStats(call, createRtcStatsCollection, str4, str3, longValue2, next2.getValue());
                IncompleteRtcStatObject incompleteRtcStatObject = new IncompleteRtcStatObject(str3, str4, longValue2);
                if (hashMap.containsKey(incompleteRtcStatObject)) {
                    map = (Map) hashMap.get(incompleteRtcStatObject);
                    for (Map.Entry<String, Object> entry2 : next2.getValue().entrySet()) {
                        map.put(entry2.getKey(), entry2.getValue());
                    }
                } else {
                    map = next2.getValue();
                }
                hashMap.put(incompleteRtcStatObject, map);
                str = str5;
                it2 = it3;
            }
        }
        call.reportWebRtcStats(createRtcStatsCollection);
        if (statsFeedback != null) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry entry3 : hashMap.entrySet()) {
                IncompleteRtcStatObject incompleteRtcStatObject2 = (IncompleteRtcStatObject) entry3.getKey();
                hashMap2.put(incompleteRtcStatObject2.getId(), new RTCStats(incompleteRtcStatObject2.getTimestamp(), incompleteRtcStatObject2.getType(), incompleteRtcStatObject2.getId(), (Map) entry3.getValue()));
            }
            statsFeedback.onStatisticReport(convertToFeedBack(new RTCStatsReport((long) d8, hashMap2)));
        }
        releaseRtcStatsCollection(createRtcStatsCollection);
        if (sinchMediaStats.remoteCandidateId != null) {
            ConnectionInfo connectionInfo = sinchMediaStats.getConnectionInfo().get(sinchMediaStats.remoteCandidateId);
            if (statsFeedback != null) {
                statsFeedback.onConnectionInfo(connectionInfo);
            }
        }
    }

    public static void processWebRtcStatsReports(Call call, RTCStatsReport rTCStatsReport, StatsFeedback statsFeedback) {
        Map<String, RTCStats> statsMap = rTCStatsReport.getStatsMap();
        SinchMediaStats sinchMediaStats = new SinchMediaStats();
        for (RTCStats rTCStats : statsMap.values()) {
            String type = rTCStats.getType();
            type.hashCode();
            char c8 = 65535;
            switch (type.hashCode()) {
                case -1258653148:
                    if (type.equals(SINCH_MEDIA_SOURCE_STATS_TAG)) {
                        c8 = 0;
                        break;
                    }
                    break;
                case -994679270:
                    if (type.equals(SINCH_INBOUND_RTP_STATS_TAG)) {
                        c8 = 1;
                        break;
                    }
                    break;
                case -960999236:
                    if (type.equals("remote-candidate")) {
                        c8 = 2;
                        break;
                    }
                    break;
                case -819060207:
                    if (type.equals(SINCH_OUTBOUND_RTP_STATS_TAG)) {
                        c8 = 3;
                        break;
                    }
                    break;
                case -563327583:
                    if (type.equals("local-candidate")) {
                        c8 = 4;
                        break;
                    }
                    break;
                case 94834710:
                    if (type.equals("codec")) {
                        c8 = 5;
                        break;
                    }
                    break;
                case 110621003:
                    if (type.equals("track")) {
                        c8 = 6;
                        break;
                    }
                    break;
                case 1352460516:
                    if (type.equals("candidate-pair")) {
                        c8 = 7;
                        break;
                    }
                    break;
            }
            switch (c8) {
                case 0:
                    updateMediaSourceStats(rTCStats, sinchMediaStats);
                    break;
                case 1:
                case 3:
                    updateRtpStats(rTCStats, sinchMediaStats);
                    break;
                case 2:
                    updateRemoteCandidates(rTCStats, sinchMediaStats);
                    break;
                case 4:
                    updateLocalCandidates(rTCStats, sinchMediaStats);
                    break;
                case 5:
                    updateCodecValues(rTCStats, sinchMediaStats);
                    break;
                case 6:
                    updateTracksObjects(rTCStats, sinchMediaStats);
                    break;
                case 7:
                    updateCandidatePairStat(rTCStats, sinchMediaStats);
                    break;
            }
        }
        processSinchMediaStatsReport(call, sinchMediaStats, rTCStatsReport.getTimestampUs(), statsFeedback);
    }

    private static native void releaseRtcStatsCollection(long j8);

    private static native void releaseRtcStatsObject(long j8);

    public static void reportWebRtcStats(Call call, long j8, String str, String str2, double d8, Map<String, Object> map) {
        Long valueOf;
        if (map.entrySet().isEmpty()) {
            return;
        }
        double d9 = d8 / 1000.0d;
        long createRtcStatsObject = createRtcStatsObject(str, str2, d9);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            if (entry.getValue() instanceof BigInteger) {
                valueOf = Long.valueOf(((BigInteger) entry.getValue()).longValue());
            } else if (entry.getValue() instanceof Long) {
                valueOf = (Long) entry.getValue();
            } else if (entry.getValue() instanceof Boolean) {
                addRtcStatsValue(createRtcStatsObject, key, ((Boolean) entry.getValue()).booleanValue());
            } else if (entry.getValue() instanceof Integer) {
                addRtcStatsValue(createRtcStatsObject, key, ((Integer) entry.getValue()).intValue());
            } else if (entry.getValue() instanceof Double) {
                addRtcStatsValue(createRtcStatsObject, key, ((Double) entry.getValue()).doubleValue());
            } else if (entry.getValue() instanceof String) {
                addRtcStatsValue(createRtcStatsObject, key, (String) entry.getValue());
            }
            addRtcStatsValue(createRtcStatsObject, key, valueOf.longValue());
        }
        addRtcStatsValue(createRtcStatsObject, "timestamp", (long) d9);
        addRtcStatsObjectToCollection(j8, createRtcStatsObject);
    }

    private static void updateCandidatePairStat(RTCStats rTCStats, SinchMediaStats sinchMediaStats) {
        if (rTCStats.getMembers().get("state").toString().equalsIgnoreCase("succeeded")) {
            filterWithLookup(sinchMediaStats.getCandidatePairStats(), rTCStats.getMembers(), CANDIDATE_PAIR_STATS);
            sinchMediaStats.localCandidateId = (String) rTCStats.getMembers().get(SINCH_LOCAL_CANDIDATE_TAG);
            sinchMediaStats.remoteCandidateId = (String) rTCStats.getMembers().get(SINCH_REMOTE_CANDIDATE_TAG);
        }
    }

    private static void updateCodecValues(RTCStats rTCStats, SinchMediaStats sinchMediaStats) {
        sinchMediaStats.getCodecNames().put(rTCStats.getId(), (String) rTCStats.getMembers().get("mimeType"));
    }

    private static void updateLocalCandidates(RTCStats rTCStats, SinchMediaStats sinchMediaStats) {
        sinchMediaStats.getNetworkTypesForLocalCands().put(rTCStats.getId(), (String) rTCStats.getMembers().get(SINCH_NETWORK_TYPE_TAG));
    }

    private static void updateMediaSourceStats(RTCStats rTCStats, SinchMediaStats sinchMediaStats) {
        if (((String) rTCStats.getMembers().get(SINCH_MEDIASOURCE_KIND_TAG)).equalsIgnoreCase("audio")) {
            filterWithLookup(sinchMediaStats.getAudioStatsOutbound(), rTCStats.getMembers(), MEDIA_SOURCE_STATS);
        }
    }

    private static void updateRemoteCandidates(RTCStats rTCStats, SinchMediaStats sinchMediaStats) {
        String id = rTCStats.getId();
        sinchMediaStats.getConnectionInfo().put(id, new ConnectionInfo(id, (String) rTCStats.getMembers().get(CONN_INFO_TYPE), (String) rTCStats.getMembers().get(CONN_INFO_PROTOCOL), (String) rTCStats.getMembers().get(CONN_INFO_HOST), ((Integer) rTCStats.getMembers().get(CONN_INFO_PORT)).intValue()));
    }

    private static void updateRtpStats(RTCStats rTCStats, SinchMediaStats sinchMediaStats) {
        String str = (String) rTCStats.getMembers().get(SINCH_MEDIATYPE_TAG);
        if (str.equalsIgnoreCase("audio") || str.equalsIgnoreCase("video")) {
            Map<String, Object> mediaStats = sinchMediaStats.getMediaStats(rTCStats.getType().equalsIgnoreCase(SINCH_INBOUND_RTP_STATS_TAG), str.equalsIgnoreCase("video"));
            filterWithLookup(mediaStats, rTCStats.getMembers(), RTP_STATS);
            mediaStats.put(SINCH_TIMESTAMP_US, Long.valueOf((long) rTCStats.getTimestampUs()));
            mediaStats.put(SINCH_STAT_ID, rTCStats.getId());
            mediaStats.put(SINCH_STATS_TYPE, rTCStats.getType());
        }
    }

    private static void updateTrackStatsFromLookup(Map<String, Object> map, SinchMediaStats sinchMediaStats, String[] strArr) {
        String str;
        if (map != null) {
            RTCStats rTCStats = sinchMediaStats.getTracks().get(map.get("trackId"));
            if (rTCStats != null) {
                filterWithLookup(map, rTCStats.getMembers(), strArr);
                map.remove("trackId");
            }
            String str2 = (String) map.get("codecId");
            if (str2 == null || (str = (String) sinchMediaStats.getCodecNames().get(str2)) == null) {
                return;
            }
            map.put("codec", str);
            map.remove("codecId");
        }
    }

    private static void updateTracksObjects(RTCStats rTCStats, SinchMediaStats sinchMediaStats) {
        sinchMediaStats.getTracks().put(rTCStats.getId(), rTCStats);
    }
}
