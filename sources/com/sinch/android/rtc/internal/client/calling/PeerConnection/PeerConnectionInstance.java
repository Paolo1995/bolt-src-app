package com.sinch.android.rtc.internal.client.calling.PeerConnection;

import android.util.Log;
import com.sinch.android.rtc.internal.natives.jni.WebRtcIceServer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
import org.webrtc.AudioTrack;
import org.webrtc.IceCandidate;
import org.webrtc.MediaConstraints;
import org.webrtc.MediaStreamTrack;
import org.webrtc.PeerConnection;
import org.webrtc.PeerConnectionFactory;
import org.webrtc.RtpSender;
import org.webrtc.SessionDescription;
import org.webrtc.VideoTrack;

/* loaded from: classes3.dex */
public class PeerConnectionInstance {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String STREAM_TRACK_ID = "s";
    private static final String TAG = "PeerConnectionInstance";
    public final CallInitiationSdpObserver callInitiationSdpObserver;
    private boolean mActive;
    private final DefaultPeerConnectionClient mClient;
    private boolean mEnablePerfectNegotiation;
    private final Executor mExecutor;
    private final PeerConnectionFactory mFactory;
    private boolean mIsMakingOffer;
    private final boolean mOriginalPeerConnection;
    private final PeerConnectionObserver mPcObserver;
    private final PeerConnectionParameters mPeerConnectionParameters;
    private final PerfectNegotiationLocalSdpObserver mPerfectNegotiationLocalSdpObserver;
    private final PerfectNegotiationRemoteSdpObserver mPerfectNegotiationRemoteSdpObserver;
    private AudioTrack mRemoteAudioTrack;
    public String mRemoteInstanceId;
    private VideoTrack mRemoteVideoTrack;
    public PeerConnection peerConnection;
    public LinkedList<IceCandidate> queuedRemoteCandidates;
    public SessionDescription remoteSdp;

    public PeerConnectionInstance(DefaultPeerConnectionClient defaultPeerConnectionClient, Executor executor, PeerConnectionFactory peerConnectionFactory, String str, PeerConnectionParameters peerConnectionParameters, boolean z7, ArrayList<MediaStreamTrack> arrayList) {
        this.mClient = defaultPeerConnectionClient;
        this.mExecutor = executor;
        this.mFactory = peerConnectionFactory;
        this.mPeerConnectionParameters = peerConnectionParameters;
        this.mOriginalPeerConnection = z7;
        PeerConnectionObserver peerConnectionObserver = new PeerConnectionObserver(defaultPeerConnectionClient, this, executor);
        this.mPcObserver = peerConnectionObserver;
        this.mRemoteInstanceId = str;
        peerConnectionObserver.updateRemoteInstanceId(str);
        this.callInitiationSdpObserver = new CallInitiationSdpObserver(defaultPeerConnectionClient, this, executor);
        this.mPerfectNegotiationLocalSdpObserver = new PerfectNegotiationLocalSdpObserver(defaultPeerConnectionClient, this, executor);
        this.mPerfectNegotiationRemoteSdpObserver = new PerfectNegotiationRemoteSdpObserver(defaultPeerConnectionClient, this, executor);
        this.queuedRemoteCandidates = new LinkedList<>();
        createPeerConnectionInternal(arrayList);
        this.mActive = true;
    }

    private void createPeerConnectionInternal(final ArrayList<MediaStreamTrack> arrayList) {
        this.mExecutor.execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.p0
            @Override // java.lang.Runnable
            public final void run() {
                PeerConnectionInstance.this.lambda$createPeerConnectionInternal$0(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addRelayIceCandidates$7() {
        if (this.peerConnection != null) {
            DefaultPeerConnectionClient defaultPeerConnectionClient = this.mClient;
            if (defaultPeerConnectionClient.isError) {
                return;
            }
            Iterator<IceCandidate> it = defaultPeerConnectionClient.relayIceCandidates.iterator();
            while (it.hasNext()) {
                IceCandidate next = it.next();
                if (this.queuedRemoteCandidates != null) {
                    String str = TAG;
                    Log.d(str, "\tAdding new relay candidate to queue: " + next.toString());
                    this.queuedRemoteCandidates.add(next);
                } else {
                    String str2 = TAG;
                    Log.d(str2, "\tAdded new relay remote candidate: " + next.toString());
                    this.peerConnection.addIceCandidate(next);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addRemoteIceCandidate$6(IceCandidate iceCandidate) {
        if (this.peerConnection == null || this.mClient.isError) {
            return;
        }
        LinkedList<IceCandidate> linkedList = this.queuedRemoteCandidates;
        if (linkedList != null) {
            linkedList.add(iceCandidate);
            return;
        }
        String str = TAG;
        Log.d(str, "\tAdded remote candidate: " + iceCandidate.toString());
        this.peerConnection.addIceCandidate(iceCandidate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createAnswer$2(MediaConstraints mediaConstraints) {
        if (this.peerConnection == null || this.mClient.isError) {
            return;
        }
        Log.d(TAG, "PC create ANSWER");
        this.mClient.isInitiator = false;
        this.peerConnection.createAnswer(this.callInitiationSdpObserver, mediaConstraints);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createOffer$1(MediaConstraints mediaConstraints) {
        if (this.peerConnection == null || this.mClient.isError) {
            return;
        }
        Log.d(TAG, "PC Create OFFER");
        this.mClient.isInitiator = true;
        this.peerConnection.createOffer(this.callInitiationSdpObserver, mediaConstraints);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createPeerConnectionInternal$0(ArrayList arrayList) {
        if (this.mFactory == null || this.mClient.isError) {
            Log.e(TAG, "Peerconnection mFactory is not created");
            return;
        }
        Log.d(TAG, "Create peer connection.");
        ArrayList arrayList2 = new ArrayList();
        List<WebRtcIceServer> iceServers = this.mClient.getIceServers();
        if (iceServers != null) {
            for (WebRtcIceServer webRtcIceServer : iceServers) {
                arrayList2.add(PeerConnection.IceServer.builder(webRtcIceServer.getUrls()).setUsername(webRtcIceServer.getUsername()).setPassword(webRtcIceServer.getPassword()).createIceServer());
            }
        }
        for (String str : this.mClient.getWebRtcCallConfiguration().getLegacyStunServers()) {
            arrayList2.add(new PeerConnection.IceServer(str));
        }
        PeerConnection.RTCConfiguration rTCConfiguration = new PeerConnection.RTCConfiguration(arrayList2);
        DefaultPeerConnectionClient defaultPeerConnectionClient = this.mClient;
        rTCConfiguration.iceTransportsType = defaultPeerConnectionClient.mUseRelayIceCandidatesOnly ? PeerConnection.IceTransportsType.RELAY : PeerConnection.IceTransportsType.ALL;
        rTCConfiguration.certificate = defaultPeerConnectionClient.getPeerConnectionCertificate();
        rTCConfiguration.tcpCandidatePolicy = PeerConnection.TcpCandidatePolicy.DISABLED;
        rTCConfiguration.bundlePolicy = PeerConnection.BundlePolicy.MAXBUNDLE;
        rTCConfiguration.rtcpMuxPolicy = PeerConnection.RtcpMuxPolicy.REQUIRE;
        rTCConfiguration.continualGatheringPolicy = PeerConnection.ContinualGatheringPolicy.GATHER_CONTINUALLY;
        rTCConfiguration.keyType = PeerConnection.KeyType.ECDSA;
        rTCConfiguration.sdpSemantics = this.mClient.getWebRtcCallConfiguration().getSdpSemantic();
        if (this.mClient.isInitiator) {
            rTCConfiguration.enableImplicitRollback = true;
        }
        this.peerConnection = this.mFactory.createPeerConnection(rTCConfiguration, this.mPcObserver);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.peerConnection.addTrack((MediaStreamTrack) it.next(), Collections.singletonList(STREAM_TRACK_ID));
        }
        String str2 = TAG;
        Log.d(str2, "MediaStream added to " + this.peerConnection);
        DefaultPeerConnectionClient defaultPeerConnectionClient2 = this.mClient;
        defaultPeerConnectionClient2.isInitiator = false;
        this.peerConnection.setBitrate(null, null, Integer.valueOf((defaultPeerConnectionClient2.maxAudioBandwidth + defaultPeerConnectionClient2.maxVideoBandwidth) * 1000));
        Log.d(str2, "Peer connection created.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$drainCandidates$3() {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("drainCandidates, queuedRemoteCandidates = ");
        LinkedList<IceCandidate> linkedList = this.queuedRemoteCandidates;
        sb.append(linkedList == null ? "null" : linkedList.toString());
        Log.d(str, sb.toString());
        if (this.queuedRemoteCandidates != null) {
            Log.d(str, "queuedRemoteCandidates.size() = " + this.queuedRemoteCandidates.size());
            Iterator<IceCandidate> it = this.queuedRemoteCandidates.iterator();
            while (it.hasNext()) {
                this.peerConnection.addIceCandidate(it.next());
            }
            this.queuedRemoteCandidates = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setRemoteAnswer$4(SessionDescription sessionDescription) {
        PeerConnection peerConnection = this.peerConnection;
        if (peerConnection == null || this.mClient.isError) {
            return;
        }
        if (peerConnection.signalingState() == PeerConnection.SignalingState.HAVE_LOCAL_OFFER) {
            setRemoteDescriptionInternal(sessionDescription);
        } else {
            this.remoteSdp = sessionDescription;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setRemoteDescriptionInternal$5(SessionDescription sessionDescription) {
        PeerConnection peerConnection = this.peerConnection;
        if (peerConnection == null || this.mClient.isError) {
            return;
        }
        SessionDescription.Type type = sessionDescription.type;
        if (type == SessionDescription.Type.ANSWER) {
            if (peerConnection.signalingState() != PeerConnection.SignalingState.HAVE_LOCAL_OFFER && this.peerConnection.signalingState() != PeerConnection.SignalingState.HAVE_LOCAL_PRANSWER) {
                Log.e(TAG, "setRemoteDescription: can't set remote answer - wrong state!");
                return;
            }
        } else if (type == SessionDescription.Type.OFFER && peerConnection.signalingState() != PeerConnection.SignalingState.STABLE) {
            Log.e(TAG, "setRemoteDescription: can't set remote offer - wrong state!");
            return;
        }
        this.remoteSdp = sessionDescription;
        String[] split = sessionDescription.description.replaceAll("\\s", " ").split(" ");
        int i8 = 0;
        while (true) {
            if (i8 >= split.length) {
                break;
            }
            int indexOf = split[i8].indexOf("ice-ufrag:");
            if (indexOf != -1) {
                this.mClient.currentRemoteUfrag = split[i8].substring(indexOf + 10);
                break;
            }
            i8++;
        }
        String str = this.remoteSdp.description;
        DefaultPeerConnectionClient defaultPeerConnectionClient = this.mClient;
        if (defaultPeerConnectionClient.videoCallEnabled) {
            str = SdpUtils.preferCodec(str, defaultPeerConnectionClient.preferredVideoCodec, false);
        }
        int i9 = this.mPeerConnectionParameters.audioStartBitrate;
        if (i9 > 0) {
            str = SdpUtils.setStartBitrate(DefaultPeerConnectionClient.AUDIO_CODEC_OPUS, false, str, i9);
        }
        String removeExtensions = SdpUtils.removeExtensions(str, "video-orientation");
        if (!removeExtensions.contains("a=group:BUNDLE")) {
            removeExtensions = SdpUtils.insertSdpLine(removeExtensions, "t=", "a=group:BUNDLE audio");
        }
        String str2 = TAG;
        Log.d(str2, "setRemoteDescription: \r\n" + removeExtensions);
        this.peerConnection.setRemoteDescription(this.callInitiationSdpObserver, new SessionDescription(this.remoteSdp.type, removeExtensions));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startCall$8() {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("startCall(), current time: ");
        sb.append(System.currentTimeMillis());
        Log.d(str, sb.toString());
        drainCandidates();
    }

    private void setRemoteAnswer(final SessionDescription sessionDescription) {
        this.mExecutor.execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.m0
            @Override // java.lang.Runnable
            public final void run() {
                PeerConnectionInstance.this.lambda$setRemoteAnswer$4(sessionDescription);
            }
        });
    }

    private void setRemoteDescriptionInternal(final SessionDescription sessionDescription) {
        this.mExecutor.execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.k0
            @Override // java.lang.Runnable
            public final void run() {
                PeerConnectionInstance.this.lambda$setRemoteDescriptionInternal$5(sessionDescription);
            }
        });
    }

    public void addRelayIceCandidates() {
        Log.d(TAG, "\tAdding RELAY ICE candidates to the Peer Connection");
        this.mExecutor.execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.i0
            @Override // java.lang.Runnable
            public final void run() {
                PeerConnectionInstance.this.lambda$addRelayIceCandidates$7();
            }
        });
    }

    public void addRemoteIceCandidate(final IceCandidate iceCandidate) {
        this.mExecutor.execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.l0
            @Override // java.lang.Runnable
            public final void run() {
                PeerConnectionInstance.this.lambda$addRemoteIceCandidate$6(iceCandidate);
            }
        });
    }

    public void createAnswer(final MediaConstraints mediaConstraints) {
        this.mExecutor.execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.q0
            @Override // java.lang.Runnable
            public final void run() {
                PeerConnectionInstance.this.lambda$createAnswer$2(mediaConstraints);
            }
        });
    }

    public void createOffer(final MediaConstraints mediaConstraints) {
        this.mExecutor.execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.j0
            @Override // java.lang.Runnable
            public final void run() {
                PeerConnectionInstance.this.lambda$createOffer$1(mediaConstraints);
            }
        });
    }

    public void disposeInternal() {
        this.mActive = false;
        this.mEnablePerfectNegotiation = false;
        removeMediaTracks();
        String str = TAG;
        Log.d(str, "Closing PeerConnection.");
        PeerConnection peerConnection = this.peerConnection;
        if (peerConnection != null) {
            peerConnection.close();
            this.peerConnection.dispose();
            this.peerConnection = null;
            Log.d(str, "PeerConnection closed.");
        }
        Log.d(str, "disposeInternal() finished, mActive = " + this.mActive);
    }

    public void drainCandidates() {
        this.mExecutor.execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.n0
            @Override // java.lang.Runnable
            public final void run() {
                PeerConnectionInstance.this.lambda$drainCandidates$3();
            }
        });
    }

    public void enablePerfectNegotiation() {
        String str = DefaultPeerConnectionClient.TAG;
        Log.d(str, "Enabling perfect negotiation in " + this.peerConnection);
        this.mEnablePerfectNegotiation = true;
    }

    public AudioTrack getRemoteAudioTrack() {
        return this.mRemoteAudioTrack;
    }

    public String getRemoteInstanceId() {
        return this.mRemoteInstanceId;
    }

    public VideoTrack getRemoteVideoTrack() {
        return this.mRemoteVideoTrack;
    }

    public boolean isActive() {
        return this.mActive;
    }

    public boolean isEnabledPerfectNegotiation() {
        return this.mEnablePerfectNegotiation;
    }

    public boolean isOriginalPeerConnection() {
        return this.mOriginalPeerConnection;
    }

    public void removeMediaTracks() {
        PeerConnection peerConnection;
        String str;
        StringBuilder sb;
        String str2;
        if (!this.mActive || (peerConnection = this.peerConnection) == null) {
            return;
        }
        for (RtpSender rtpSender : peerConnection.getSenders()) {
            if (this.peerConnection.removeTrack(rtpSender)) {
                str = TAG;
                sb = new StringBuilder();
                str2 = "MediaStreamTrack removed from ";
            } else {
                str = TAG;
                sb = new StringBuilder();
                str2 = "Failed to remove MediaStreamTrack from";
            }
            sb.append(str2);
            sb.append(this.peerConnection);
            Log.d(str, sb.toString());
        }
    }

    public void restartIce() {
        String str = TAG;
        Log.d(str, "Restarting ice in " + this.peerConnection);
        this.mClient.peerConnectionRestartedIce(this);
        this.peerConnection.restartIce();
    }

    public void setAndSendLocalSessionDescription(boolean z7) {
        this.mIsMakingOffer = z7;
        this.peerConnection.setLocalDescription(this.mPerfectNegotiationLocalSdpObserver);
    }

    public void setIsMakingOffer(boolean z7) {
        this.mIsMakingOffer = z7;
    }

    public void setRemoteAudioTrack(AudioTrack audioTrack) {
        this.mRemoteAudioTrack = audioTrack;
    }

    public void setRemoteDescription(SessionDescription sessionDescription) {
        if (!isEnabledPerfectNegotiation()) {
            if (SessionDescription.Type.OFFER == sessionDescription.type) {
                setRemoteDescriptionInternal(sessionDescription);
                return;
            } else {
                setRemoteAnswer(sessionDescription);
                return;
            }
        }
        if (sessionDescription.type == SessionDescription.Type.OFFER) {
            boolean z7 = this.mClient.isInitiator;
            boolean z8 = this.peerConnection.signalingState() != PeerConnection.SignalingState.STABLE || this.mIsMakingOffer;
            if (!z7 && z8) {
                this.mClient.peerConnectionDiscardedCollidingOffer(this);
                return;
            }
        }
        this.peerConnection.setRemoteDescription(this.mPerfectNegotiationRemoteSdpObserver, sessionDescription);
    }

    public void setRemoteVideoTrack(VideoTrack videoTrack) {
        this.mRemoteVideoTrack = videoTrack;
        this.mClient.updateVideoTrackRenderer();
    }

    public void startCall() {
        this.mExecutor.execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.o0
            @Override // java.lang.Runnable
            public final void run() {
                PeerConnectionInstance.this.lambda$startCall$8();
            }
        });
    }

    public void updateRemoteInstanceId(String str) {
        this.mRemoteInstanceId = str;
        this.mPcObserver.updateRemoteInstanceId(str);
        this.callInitiationSdpObserver.updateRemoteInstanceId(str);
    }
}
