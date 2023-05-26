package com.sinch.android.rtc.internal.client.calling.PeerConnection;

import android.util.Log;
import com.sinch.android.rtc.internal.client.calling.JsepMessage;
import java.util.concurrent.Executor;
import org.webrtc.SdpObserver;
import org.webrtc.SessionDescription;

/* loaded from: classes3.dex */
public class PerfectNegotiationLocalSdpObserver implements SdpObserver {
    private final String TAG = PerfectNegotiationLocalSdpObserver.class.getSimpleName();
    private final DefaultPeerConnectionClient mClient;
    private final Executor mExecutor;
    private final PeerConnectionInstance mPeerConnectionInstance;

    public PerfectNegotiationLocalSdpObserver(DefaultPeerConnectionClient defaultPeerConnectionClient, PeerConnectionInstance peerConnectionInstance, Executor executor) {
        this.mClient = defaultPeerConnectionClient;
        this.mPeerConnectionInstance = peerConnectionInstance;
        this.mExecutor = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSetFailure$1(String str) {
        this.mPeerConnectionInstance.setIsMakingOffer(false);
        String str2 = this.TAG;
        Log.d(str2, "Failed to set (parameterless) session description, error: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSetSuccess$0() {
        SessionDescription localDescription = this.mPeerConnectionInstance.peerConnection.getLocalDescription();
        String str = DefaultPeerConnectionClient.TAG;
        Log.d(str, "Successfully set localDescription (" + localDescription.type + ") in " + this.mPeerConnectionInstance.peerConnection + ": " + localDescription.description);
        this.mPeerConnectionInstance.setIsMakingOffer(false);
        DefaultPeerConnectionClient defaultPeerConnectionClient = this.mClient;
        defaultPeerConnectionClient.jsepChannel.sendMessage(defaultPeerConnectionClient.call.getCallId(), this.mPeerConnectionInstance.getRemoteInstanceId(), JsepMessage.fromSessionDescription(localDescription));
    }

    @Override // org.webrtc.SdpObserver
    public void onCreateFailure(String str) {
    }

    @Override // org.webrtc.SdpObserver
    public void onCreateSuccess(SessionDescription sessionDescription) {
    }

    @Override // org.webrtc.SdpObserver
    public void onSetFailure(final String str) {
        this.mExecutor.execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.z0
            @Override // java.lang.Runnable
            public final void run() {
                PerfectNegotiationLocalSdpObserver.this.lambda$onSetFailure$1(str);
            }
        });
    }

    @Override // org.webrtc.SdpObserver
    public void onSetSuccess() {
        this.mExecutor.execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.y0
            @Override // java.lang.Runnable
            public final void run() {
                PerfectNegotiationLocalSdpObserver.this.lambda$onSetSuccess$0();
            }
        });
    }
}
