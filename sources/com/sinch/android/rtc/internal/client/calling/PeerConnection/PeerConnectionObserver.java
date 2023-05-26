package com.sinch.android.rtc.internal.client.calling.PeerConnection;

import android.util.Log;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sinch.android.rtc.internal.client.calling.JsepMessage;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Executor;
import org.webrtc.AudioTrack;
import org.webrtc.CandidatePairChangeEvent;
import org.webrtc.DataChannel;
import org.webrtc.IceCandidate;
import org.webrtc.IceCandidateErrorEvent;
import org.webrtc.MediaStream;
import org.webrtc.PeerConnection;
import org.webrtc.RtpReceiver;
import org.webrtc.RtpTransceiver;
import org.webrtc.VideoTrack;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class PeerConnectionObserver implements PeerConnection.Observer {
    private final DefaultPeerConnectionClient mClient;
    private final Executor mExecutor;
    private final PeerConnectionInstance mPeerConnectionInstance;
    public LinkedList<IceCandidate> localCandidates = new LinkedList<>();
    private String remoteInstanceId = null;

    public PeerConnectionObserver(DefaultPeerConnectionClient defaultPeerConnectionClient, PeerConnectionInstance peerConnectionInstance, Executor executor) {
        this.mClient = defaultPeerConnectionClient;
        this.mPeerConnectionInstance = peerConnectionInstance;
        this.mExecutor = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAddStream$4(MediaStream mediaStream) {
        DefaultPeerConnectionClient defaultPeerConnectionClient;
        String str;
        String str2 = DefaultPeerConnectionClient.TAG;
        Log.d(str2, "onAddStream, isError = " + this.mClient.isError);
        if (this.mClient.isError) {
            return;
        }
        if (mediaStream.audioTracks.size() > 1) {
            defaultPeerConnectionClient = this.mClient;
            str = "Weird-looking stream: stream.audioTracks.size() > 1";
        } else if (mediaStream.audioTracks.size() == 0) {
            defaultPeerConnectionClient = this.mClient;
            str = "Weird-looking stream: stream.audioTracks.size() == 0";
        } else if (mediaStream.videoTracks.size() <= 1) {
            AudioTrack audioTrack = mediaStream.audioTracks.get(0);
            boolean enableRemoteAudio = this.mClient.getEnableRemoteAudio();
            boolean enableRemoteVideo = this.mClient.getEnableRemoteVideo();
            audioTrack.setEnabled(enableRemoteAudio);
            this.mPeerConnectionInstance.setRemoteAudioTrack(audioTrack);
            Log.d(str2, "onAddStream, remoteAudioTrack = " + audioTrack + " , remoteAudioEnabled = " + enableRemoteAudio);
            if (mediaStream.videoTracks.size() > 0) {
                VideoTrack videoTrack = mediaStream.videoTracks.get(0);
                Log.d(str2, "onAddStream, remoteVideoTrack = " + videoTrack + " , remoteVideoEnabled = " + enableRemoteVideo);
                videoTrack.setEnabled(enableRemoteVideo);
                this.mPeerConnectionInstance.setRemoteVideoTrack(videoTrack);
                return;
            }
            return;
        } else {
            defaultPeerConnectionClient = this.mClient;
            str = "Weird-looking stream: stream.videoTracks.size() > 1";
        }
        defaultPeerConnectionClient.reportError(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onIceCandidate$1(IceCandidate iceCandidate) {
        this.localCandidates.add(iceCandidate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onIceCandidatesRemoved$2() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onIceConnectionChange$3(PeerConnection.IceConnectionState iceConnectionState) {
        String str = DefaultPeerConnectionClient.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("IceConnectionState: ");
        sb.append(iceConnectionState);
        sb.append(" this PeerConnectionInstance remote peer's id is ");
        sb.append(this.remoteInstanceId);
        sb.append(", and this connection is ");
        sb.append(this.mPeerConnectionInstance.isActive() ? AppMeasurementSdk.ConditionalUserProperty.ACTIVE : "not active");
        Log.d(str, sb.toString());
        if (iceConnectionState == PeerConnection.IceConnectionState.COMPLETED) {
            this.mClient.peerConnectionStateChangedToCompleted(this.mPeerConnectionInstance);
        } else if (iceConnectionState == PeerConnection.IceConnectionState.CONNECTED) {
            this.mClient.peerConnectionStateChangedToConnected(this.mPeerConnectionInstance);
        } else if (!(iceConnectionState == PeerConnection.IceConnectionState.DISCONNECTED && this.mPeerConnectionInstance.isActive()) && iceConnectionState == PeerConnection.IceConnectionState.FAILED) {
            this.mClient.peerConnectionStateChangedToFailed(this.mPeerConnectionInstance);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onRemoveStream$5() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendIceCancidates$0(String str) {
        Iterator<IceCandidate> it = this.localCandidates.iterator();
        while (it.hasNext()) {
            JsepMessage fromIceCandidate = JsepMessage.fromIceCandidate(it.next());
            String str2 = DefaultPeerConnectionClient.TAG;
            Log.d(str2, "Local Ice Candidate: " + fromIceCandidate.getPayload());
            DefaultPeerConnectionClient defaultPeerConnectionClient = this.mClient;
            defaultPeerConnectionClient.jsepChannel.sendMessage(defaultPeerConnectionClient.call.getCallId(), str, fromIceCandidate);
        }
        this.localCandidates.clear();
    }

    private void sendIceCancidates(final String str) {
        this.mExecutor.execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.u0
            @Override // java.lang.Runnable
            public final void run() {
                PeerConnectionObserver.this.lambda$sendIceCancidates$0(str);
            }
        });
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onAddStream(final MediaStream mediaStream) {
        this.mExecutor.execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.r0
            @Override // java.lang.Runnable
            public final void run() {
                PeerConnectionObserver.this.lambda$onAddStream$4(mediaStream);
            }
        });
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onAddTrack(RtpReceiver rtpReceiver, MediaStream[] mediaStreamArr) {
        Log.d(DefaultPeerConnectionClient.TAG, "onAddTrack called");
    }

    @Override // org.webrtc.PeerConnection.Observer
    public /* synthetic */ void onConnectionChange(PeerConnection.PeerConnectionState peerConnectionState) {
        org.webrtc.y.b(this, peerConnectionState);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onDataChannel(final DataChannel dataChannel) {
        String str = DefaultPeerConnectionClient.TAG;
        Log.d(str, "New Data channel " + dataChannel.label());
        if (this.mClient.dataChannelEnabled) {
            dataChannel.registerObserver(new DataChannel.Observer() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionObserver.1
                @Override // org.webrtc.DataChannel.Observer
                public void onBufferedAmountChange(long j8) {
                    String str2 = DefaultPeerConnectionClient.TAG;
                    Log.d(str2, "Data channel buffered amount changed: " + dataChannel.label() + ": " + dataChannel.state());
                }

                @Override // org.webrtc.DataChannel.Observer
                public void onMessage(DataChannel.Buffer buffer) {
                    if (buffer.binary) {
                        String str2 = DefaultPeerConnectionClient.TAG;
                        Log.d(str2, "Received binary msg over " + dataChannel);
                        return;
                    }
                    ByteBuffer byteBuffer = buffer.data;
                    byte[] bArr = new byte[byteBuffer.capacity()];
                    byteBuffer.get(bArr);
                    String str3 = new String(bArr, Charset.forName("UTF-8"));
                    String str4 = DefaultPeerConnectionClient.TAG;
                    Log.d(str4, "Got msg: " + str3 + " over " + dataChannel);
                }

                @Override // org.webrtc.DataChannel.Observer
                public void onStateChange() {
                    String str2 = DefaultPeerConnectionClient.TAG;
                    Log.d(str2, "Data channel state changed: " + dataChannel.label() + ": " + dataChannel.state());
                }
            });
        }
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onIceCandidate(final IceCandidate iceCandidate) {
        this.mExecutor.execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.v0
            @Override // java.lang.Runnable
            public final void run() {
                PeerConnectionObserver.this.lambda$onIceCandidate$1(iceCandidate);
            }
        });
        String str = this.remoteInstanceId;
        if (str != null) {
            sendIceCancidates(str);
        }
    }

    @Override // org.webrtc.PeerConnection.Observer
    public /* synthetic */ void onIceCandidateError(IceCandidateErrorEvent iceCandidateErrorEvent) {
        org.webrtc.y.c(this, iceCandidateErrorEvent);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr) {
        this.mExecutor.execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.t0
            @Override // java.lang.Runnable
            public final void run() {
                PeerConnectionObserver.lambda$onIceCandidatesRemoved$2();
            }
        });
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onIceConnectionChange(final PeerConnection.IceConnectionState iceConnectionState) {
        this.mExecutor.execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.w0
            @Override // java.lang.Runnable
            public final void run() {
                PeerConnectionObserver.this.lambda$onIceConnectionChange$3(iceConnectionState);
            }
        });
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onIceConnectionReceivingChange(boolean z7) {
        String str = DefaultPeerConnectionClient.TAG;
        Log.d(str, "IceConnectionReceiving changed to " + z7);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onIceGatheringChange(PeerConnection.IceGatheringState iceGatheringState) {
        String str = DefaultPeerConnectionClient.TAG;
        Log.d(str, "IceGatheringState: " + iceGatheringState);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onRemoveStream(MediaStream mediaStream) {
        this.mExecutor.execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.s0
            @Override // java.lang.Runnable
            public final void run() {
                PeerConnectionObserver.lambda$onRemoveStream$5();
            }
        });
    }

    @Override // org.webrtc.PeerConnection.Observer
    public /* synthetic */ void onRemoveTrack(RtpReceiver rtpReceiver) {
        org.webrtc.y.d(this, rtpReceiver);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onRenegotiationNeeded() {
        if (this.mPeerConnectionInstance.isEnabledPerfectNegotiation()) {
            Log.d(DefaultPeerConnectionClient.TAG, "renegotiationNeeded");
            this.mPeerConnectionInstance.setAndSendLocalSessionDescription(true);
        }
    }

    @Override // org.webrtc.PeerConnection.Observer
    public /* synthetic */ void onSelectedCandidatePairChanged(CandidatePairChangeEvent candidatePairChangeEvent) {
        org.webrtc.y.e(this, candidatePairChangeEvent);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onSignalingChange(PeerConnection.SignalingState signalingState) {
        String str = DefaultPeerConnectionClient.TAG;
        Log.d(str, "SignalingState: " + signalingState);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public /* synthetic */ void onStandardizedIceConnectionChange(PeerConnection.IceConnectionState iceConnectionState) {
        org.webrtc.y.f(this, iceConnectionState);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public /* synthetic */ void onTrack(RtpTransceiver rtpTransceiver) {
        org.webrtc.y.g(this, rtpTransceiver);
    }

    public void updateRemoteInstanceId(String str) {
        this.remoteInstanceId = str;
        if (str != null) {
            sendIceCancidates(str);
        }
    }
}
