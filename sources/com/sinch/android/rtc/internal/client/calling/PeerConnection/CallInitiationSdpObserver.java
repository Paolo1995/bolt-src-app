package com.sinch.android.rtc.internal.client.calling.PeerConnection;

import android.util.Log;
import com.sinch.android.rtc.internal.natives.jni.Call;
import java.security.InvalidParameterException;
import java.util.concurrent.Executor;
import org.webrtc.PeerConnection;
import org.webrtc.SdpObserver;
import org.webrtc.SessionDescription;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class CallInitiationSdpObserver implements SdpObserver {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private final DefaultPeerConnectionClient mClient;
    private final Executor mExecutor;
    private final PeerConnectionInstance mPeerConnectionInstance;
    private final String TAG = CallInitiationSdpObserver.class.getSimpleName();
    private String mRemoteInstanceId = null;

    public CallInitiationSdpObserver(DefaultPeerConnectionClient defaultPeerConnectionClient, PeerConnectionInstance peerConnectionInstance, Executor executor) {
        this.mClient = defaultPeerConnectionClient;
        this.mPeerConnectionInstance = peerConnectionInstance;
        this.mExecutor = executor;
    }

    private boolean areAllSdpSet() {
        return (this.mPeerConnectionInstance.peerConnection.getRemoteDescription() != null) && (this.mPeerConnectionInstance.peerConnection.getLocalDescription() != null) && (this.mClient.localSdp != null) && (this.mPeerConnectionInstance.remoteSdp != null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateSuccess$0(SessionDescription sessionDescription) {
        if (this.mPeerConnectionInstance.peerConnection.getLocalDescription() != null) {
            this.mClient.reportError("Multiple SDP create.");
            return;
        }
        String str = sessionDescription.description;
        DefaultPeerConnectionClient defaultPeerConnectionClient = this.mClient;
        if (defaultPeerConnectionClient.videoCallEnabled) {
            str = SdpUtils.preferCodec(str, defaultPeerConnectionClient.preferredVideoCodec, false);
            if (PeerConnectionUtils.VIDEO_CODEC_H264.equals(this.mClient.preferredVideoCodec)) {
                str = SdpUtils.removeExtensions(str, "video-orientation");
            }
        }
        try {
            DefaultPeerConnectionClient defaultPeerConnectionClient2 = this.mClient;
            str = SdpUtils.setMaxBandwidth(str, defaultPeerConnectionClient2.maxAudioBandwidth, defaultPeerConnectionClient2.maxVideoBandwidth);
        } catch (InvalidParameterException e8) {
            String str2 = this.TAG;
            Log.e(str2, "Can't set bandwidth: " + e8.getMessage());
        }
        SessionDescription sessionDescription2 = new SessionDescription(sessionDescription.type, str);
        PeerConnectionInstance peerConnectionInstance = this.mPeerConnectionInstance;
        if (peerConnectionInstance.peerConnection == null || this.mClient.isError) {
            return;
        }
        if (!peerConnectionInstance.isOriginalPeerConnection()) {
            Log.d(DefaultPeerConnectionClient.TAG, "Re-using original SDP for new PC Instance.");
            sessionDescription2 = this.mClient.localSdp;
        }
        String str3 = DefaultPeerConnectionClient.TAG;
        Log.d(str3, "setLocalDescription from " + sessionDescription2.type + " : " + sessionDescription2.description);
        PeerConnectionInstance peerConnectionInstance2 = this.mPeerConnectionInstance;
        peerConnectionInstance2.peerConnection.setLocalDescription(peerConnectionInstance2.callInitiationSdpObserver, sessionDescription2);
        this.mClient.localSdp = sessionDescription2;
        if (this.mPeerConnectionInstance.isOriginalPeerConnection()) {
            DefaultPeerConnectionClient defaultPeerConnectionClient3 = this.mClient;
            boolean z7 = defaultPeerConnectionClient3.isInitiator;
            Call call = defaultPeerConnectionClient3.call;
            if (z7) {
                call.startOutbound(sessionDescription2.description);
            } else {
                call.setLocalAnswer(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSetSuccess$1() {
        PeerConnection peerConnection = this.mPeerConnectionInstance.peerConnection;
        if (peerConnection == null || this.mClient.isError) {
            return;
        }
        PeerConnection.SignalingState signalingState = peerConnection.signalingState();
        String str = DefaultPeerConnectionClient.TAG;
        Log.d(str, "\nonSetSuccess: new signaling state: " + signalingState);
        if (areAllSdpSet()) {
            Log.d(str, "\nonSetSuccess: both SDPs set successfully!\n");
            this.mPeerConnectionInstance.startCall();
        } else if (signalingState != PeerConnection.SignalingState.HAVE_LOCAL_OFFER || this.mPeerConnectionInstance.remoteSdp == null) {
        } else {
            Log.d(str, "\nonSetSuccess: setting deferred remote answer.\n");
            PeerConnectionInstance peerConnectionInstance = this.mPeerConnectionInstance;
            peerConnectionInstance.setRemoteDescription(peerConnectionInstance.remoteSdp);
        }
    }

    @Override // org.webrtc.SdpObserver
    public void onCreateFailure(String str) {
        DefaultPeerConnectionClient defaultPeerConnectionClient = this.mClient;
        defaultPeerConnectionClient.reportError("createSDP error: " + str);
    }

    @Override // org.webrtc.SdpObserver
    public void onCreateSuccess(final SessionDescription sessionDescription) {
        this.mExecutor.execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.b
            @Override // java.lang.Runnable
            public final void run() {
                CallInitiationSdpObserver.this.lambda$onCreateSuccess$0(sessionDescription);
            }
        });
    }

    @Override // org.webrtc.SdpObserver
    public void onSetFailure(String str) {
        DefaultPeerConnectionClient defaultPeerConnectionClient = this.mClient;
        defaultPeerConnectionClient.reportError("setSDP error: " + str);
    }

    @Override // org.webrtc.SdpObserver
    public void onSetSuccess() {
        this.mExecutor.execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.a
            @Override // java.lang.Runnable
            public final void run() {
                CallInitiationSdpObserver.this.lambda$onSetSuccess$1();
            }
        });
    }

    public void updateRemoteInstanceId(String str) {
        this.mRemoteInstanceId = str;
    }
}
