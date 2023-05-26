package com.sinch.android.rtc.internal.client;

import java.util.ArrayList;
import java.util.List;
import org.webrtc.PeerConnection;

/* loaded from: classes3.dex */
public class WebRtcCallConfiguration {
    private boolean mUseTurn;
    private PeerConnection.SdpSemantics mSdpSemantics = PeerConnection.SdpSemantics.PLAN_B;
    private List<String> mLegacyStunServers = new ArrayList();

    public List<String> getLegacyStunServers() {
        return this.mLegacyStunServers;
    }

    public PeerConnection.SdpSemantics getSdpSemantic() {
        return this.mSdpSemantics;
    }

    public boolean getUseTurn() {
        return this.mUseTurn;
    }

    public void setLegacyStunServers(List<String> list) {
        this.mLegacyStunServers = list;
    }

    public void setSdpSemantic(boolean z7) {
        this.mSdpSemantics = z7 ? PeerConnection.SdpSemantics.UNIFIED_PLAN : PeerConnection.SdpSemantics.PLAN_B;
    }

    public void setUseTurn(boolean z7) {
        this.mUseTurn = z7;
    }
}
