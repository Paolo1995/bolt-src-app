package com.sinch.android.rtc.internal.client.calling.PeerConnection;

import com.sinch.android.rtc.internal.natives.ConnectionInfo;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.webrtc.RTCStats;

/* loaded from: classes3.dex */
public class SinchMediaStats {
    public String localCandidateId;
    public String remoteCandidateId;
    private Map<Integer, Map<String, Object>> mediaStatsCollections = new HashMap();
    private Map<String, Object> candidatePairStats = new HashMap();
    private Map<String, Object> codecNames = new HashMap();
    private Map<String, RTCStats> tracks = new HashMap();
    private Map<String, String> networkTypesForLocalCands = new HashMap();
    private Map<String, ConnectionInfo> remoteCandidatesInfo = new HashMap();

    public SinchMediaStats() {
        for (int i8 = 0; i8 < 4; i8++) {
            this.mediaStatsCollections.put(Integer.valueOf(i8), new HashMap());
        }
    }

    public Map<String, Object> getAudioStatsInbound() {
        return this.mediaStatsCollections.get(0);
    }

    public Map<String, Object> getAudioStatsOutbound() {
        return this.mediaStatsCollections.get(1);
    }

    public Map<String, Object> getCandidatePairStats() {
        return this.candidatePairStats;
    }

    public Map<String, Object> getCodecNames() {
        return this.codecNames;
    }

    public Map<String, ConnectionInfo> getConnectionInfo() {
        return this.remoteCandidatesInfo;
    }

    public Map<String, Object> getMediaStats(boolean z7, boolean z8) {
        return z8 ? z7 ? getVideoStatsInbound() : getVideoStatsOutbound() : z7 ? getAudioStatsInbound() : getAudioStatsOutbound();
    }

    public Set<Map.Entry<Integer, Map<String, Object>>> getMediaStatsCollections() {
        return this.mediaStatsCollections.entrySet();
    }

    public Map<String, String> getNetworkTypesForLocalCands() {
        return this.networkTypesForLocalCands;
    }

    public Map<String, RTCStats> getTracks() {
        return this.tracks;
    }

    public Map<String, Object> getVideoStatsInbound() {
        return this.mediaStatsCollections.get(2);
    }

    public Map<String, Object> getVideoStatsOutbound() {
        return this.mediaStatsCollections.get(3);
    }
}
