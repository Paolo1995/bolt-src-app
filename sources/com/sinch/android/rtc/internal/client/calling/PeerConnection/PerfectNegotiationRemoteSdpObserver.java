package com.sinch.android.rtc.internal.client.calling.PeerConnection;

import android.util.Log;
import java.util.concurrent.Executor;
import org.webrtc.SdpObserver;
import org.webrtc.SessionDescription;

/* loaded from: classes3.dex */
public class PerfectNegotiationRemoteSdpObserver implements SdpObserver {
    private final String TAG = PerfectNegotiationRemoteSdpObserver.class.getSimpleName();
    private final DefaultPeerConnectionClient mClient;
    private final Executor mExecutor;
    private final PeerConnectionInstance mPeerConnectionInstance;

    public PerfectNegotiationRemoteSdpObserver(DefaultPeerConnectionClient defaultPeerConnectionClient, PeerConnectionInstance peerConnectionInstance, Executor executor) {
        this.mClient = defaultPeerConnectionClient;
        this.mPeerConnectionInstance = peerConnectionInstance;
        this.mExecutor = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSetFailure$1(String str) {
        String str2 = this.TAG;
        Log.d(str2, "Failed to set remote session description, error: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSetSuccess$0() {
        SessionDescription remoteDescription = this.mPeerConnectionInstance.peerConnection.getRemoteDescription();
        String str = DefaultPeerConnectionClient.TAG;
        Log.d(str, "Successfully set remoteDescription (" + remoteDescription.type + ") in " + this.mPeerConnectionInstance.peerConnection + ": " + remoteDescription.description);
        if (remoteDescription.type == SessionDescription.Type.OFFER) {
            this.mPeerConnectionInstance.setAndSendLocalSessionDescription(false);
        }
    }

    @Override // org.webrtc.SdpObserver
    public void onCreateFailure(String str) {
    }

    @Override // org.webrtc.SdpObserver
    public void onCreateSuccess(SessionDescription sessionDescription) {
    }

    @Override // org.webrtc.SdpObserver
    public void onSetFailure(final String str) {
        this.mExecutor.execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.b1
            @Override // java.lang.Runnable
            public final void run() {
                PerfectNegotiationRemoteSdpObserver.this.lambda$onSetFailure$1(str);
            }
        });
    }

    @Override // org.webrtc.SdpObserver
    public void onSetSuccess() {
        this.mExecutor.execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.a1
            @Override // java.lang.Runnable
            public final void run() {
                PerfectNegotiationRemoteSdpObserver.this.lambda$onSetSuccess$0();
            }
        });
    }
}
