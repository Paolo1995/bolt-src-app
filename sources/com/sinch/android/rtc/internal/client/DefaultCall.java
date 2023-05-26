package com.sinch.android.rtc.internal.client;

import android.content.Context;
import android.util.Pair;
import com.sinch.android.rtc.MissingPermissionException;
import com.sinch.android.rtc.PushPair;
import com.sinch.android.rtc.calling.Call;
import com.sinch.android.rtc.calling.CallDetails;
import com.sinch.android.rtc.calling.CallDirection;
import com.sinch.android.rtc.calling.CallEndCause;
import com.sinch.android.rtc.calling.CallListener;
import com.sinch.android.rtc.calling.CallState;
import com.sinch.android.rtc.internal.CallbackHandler;
import com.sinch.android.rtc.internal.client.calling.JsepMessage;
import com.sinch.android.rtc.internal.client.calling.JsepMessageChannel;
import com.sinch.android.rtc.internal.client.calling.PeerConnection.DefaultPeerConnectionClient;
import com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionClientInterface;
import com.sinch.android.rtc.internal.client.calling.PeerConnection.StatsCollector;
import com.sinch.android.rtc.internal.client.video.VideoControllerInternal;
import com.sinch.android.rtc.internal.natives.ConnectionInfo;
import com.sinch.android.rtc.internal.natives.StatsReport;
import com.sinch.android.rtc.internal.natives.jni.WebRtcIceServer;
import com.sinch.android.rtc.internal.service.state.AppStateService;
import com.sinch.android.rtc.internal.service.time.TimeService;
import com.sinch.android.rtc.video.VideoCallListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes3.dex */
public class DefaultCall implements Call, StatsCollector.StatsFeedback {
    private static final String TAG = Call.class.getSimpleName();
    private static String validDtmf = "0123456789*#ABCD";
    private final com.sinch.android.rtc.internal.natives.jni.Call call;
    private final SinchLogger logger;
    private final AppStateService mAppStateService;
    private CallbackHandler mCallbackHandler;
    private Context mContext;
    private DtmfPlayer mDtmfFeedback;
    private List<WebRtcIceServer> mIceServers;
    private final JsepMessageChannel mJsepMessageChannel;
    private PeerConnectionClientInterface mPeerConnectionClient;
    private TimeService mTimeService;
    private boolean mUseRelayIceCandidatesOnly;
    private VideoControllerInternal mVideoController;
    private final WebRtcCallConfiguration mWebRtcCallConfiguration;
    private CopyOnWriteArraySet<CallListener> listeners = new CopyOnWriteArraySet<>();
    private boolean isValidForActions = true;
    private Queue<Pair<String, JsepMessage>> mPendingJsepMessages = new LinkedList();
    private boolean mIceServersReceived = false;
    private boolean mCallAnswered = false;
    private Queue<Runnable> mVideoEventsQueue = new LinkedList();
    private Queue<Runnable> mPeerConnectionClientEventsQueue = new LinkedList();

    public DefaultCall(SinchLogger sinchLogger, com.sinch.android.rtc.internal.natives.jni.Call call, Context context, CallbackHandler callbackHandler, VideoControllerInternal videoControllerInternal, JsepMessageChannel jsepMessageChannel, WebRtcCallConfiguration webRtcCallConfiguration, TimeService timeService, AppStateService appStateService, List<WebRtcIceServer> list, boolean z7) {
        this.mUseRelayIceCandidatesOnly = false;
        this.mJsepMessageChannel = jsepMessageChannel;
        this.mWebRtcCallConfiguration = webRtcCallConfiguration;
        this.logger = sinchLogger;
        this.call = call;
        this.mVideoController = videoControllerInternal;
        this.mCallbackHandler = callbackHandler;
        this.mContext = context;
        this.mTimeService = timeService;
        this.mAppStateService = appStateService;
        this.mPendingJsepMessages.clear();
        this.mUseRelayIceCandidatesOnly = z7;
        if (list == null || list.isEmpty() || getDirection() != CallDirection.OUTGOING) {
            return;
        }
        onIceServers(list);
    }

    private void DrainJsepMessages() {
        if (this.mPeerConnectionClient != null) {
            while (this.mPendingJsepMessages.peek() != null) {
                Pair<String, JsepMessage> poll = this.mPendingJsepMessages.poll();
                this.mPeerConnectionClient.onJsepMessageReceive((String) poll.first, (JsepMessage) poll.second);
            }
        }
    }

    private synchronized void createPeerConnectionIfApplicable() {
        if (this.mPeerConnectionClient == null && this.mIceServersReceived && !shouldPostponeIncomingCallPeerConnectionInitialization()) {
            Context context = this.mContext;
            com.sinch.android.rtc.internal.natives.jni.Call call = this.call;
            PeerConnectionClientInterface createPeerConnectionClient = DefaultPeerConnectionClient.createPeerConnectionClient(context, call, call.getDetails().isVideoOffered(), this.call.getDirection() == 1, this.mCallbackHandler, this.mVideoController, this.mJsepMessageChannel, this.mWebRtcCallConfiguration, this.mIceServers, this, this.mTimeService, this.mUseRelayIceCandidatesOnly);
            this.mPeerConnectionClient = createPeerConnectionClient;
            if (createPeerConnectionClient != null) {
                processPeerConnectionClientEventsQueue();
                this.mPeerConnectionClient.enableMedia(false, false, true, false);
                DrainJsepMessages();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: deliverOnVideoTrackAdded */
    public void lambda$onVideoTrackAdded$0() {
        Iterator<CallListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            CallListener next = it.next();
            if (next instanceof VideoCallListener) {
                ((VideoCallListener) next).onVideoTrackAdded(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: deliverOnVideoTrackPaused */
    public void lambda$onVideoTrackPaused$1() {
        Iterator<CallListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            CallListener next = it.next();
            if (next instanceof VideoCallListener) {
                ((VideoCallListener) next).onVideoTrackPaused(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: deliverOnVideoTrackResumed */
    public void lambda$onVideoTrackResumed$2() {
        Iterator<CallListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            CallListener next = it.next();
            if (next instanceof VideoCallListener) {
                ((VideoCallListener) next).onVideoTrackResumed(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setBandwidthLimits$4(int i8, int i9) {
        this.mPeerConnectionClient.setBandwidthLimits(i8, i9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setSendExtendedSessionReport$3(int i8) {
        this.mPeerConnectionClient.enableStatsEvents(true, i8);
    }

    private void processPeerConnectionClientEventsQueue() {
        synchronized (this.mPeerConnectionClientEventsQueue) {
            if (this.mPeerConnectionClient != null) {
                while (this.mPeerConnectionClientEventsQueue.size() > 0) {
                    this.mPeerConnectionClientEventsQueue.poll().run();
                }
            }
        }
    }

    private void processVideoEventQueue() {
        boolean z7;
        Iterator<CallListener> it = this.listeners.iterator();
        while (true) {
            if (!it.hasNext()) {
                z7 = false;
                break;
            } else if (it.next() instanceof VideoCallListener) {
                z7 = true;
                break;
            }
        }
        if (z7) {
            while (this.mVideoEventsQueue.size() > 0) {
                this.mVideoEventsQueue.poll().run();
            }
        }
    }

    private boolean shouldPostponeIncomingCallPeerConnectionInitialization() {
        if (getDirection() == CallDirection.INCOMING) {
            return ((this.mAppStateService.isAppInForeground() && this.mAppStateService.isMicrophonePermissionGranted()) || this.mCallAnswered) ? false : true;
        }
        return false;
    }

    private void validateDtmf(String str) {
        for (int i8 = 0; i8 < str.length(); i8++) {
            if (validDtmf.indexOf(str.charAt(i8)) < 0) {
                throw new IllegalArgumentException("keys can only contain the following characters: " + validDtmf);
            }
        }
    }

    @Override // com.sinch.android.rtc.calling.Call
    public void addCallListener(CallListener callListener) {
        this.listeners.add(callListener);
        processVideoEventQueue();
    }

    @Override // com.sinch.android.rtc.calling.Call
    public void answer() throws MissingPermissionException {
        if (this.isValidForActions) {
            if (this.mContext.checkCallingOrSelfPermission("android.permission.RECORD_AUDIO") != 0) {
                throw new MissingPermissionException("android.permission.RECORD_AUDIO");
            }
            this.mCallAnswered = true;
            createPeerConnectionIfApplicable();
            this.call.accept();
        }
    }

    @Override // com.sinch.android.rtc.calling.Call
    public String getCallId() {
        return this.call.getCallId();
    }

    @Override // com.sinch.android.rtc.calling.Call
    public CallDetails getDetails() {
        return new DefaultCallDetails(this.call.getDetails());
    }

    @Override // com.sinch.android.rtc.calling.Call
    public CallDirection getDirection() {
        return this.call.getDirection() == 0 ? CallDirection.INCOMING : CallDirection.OUTGOING;
    }

    @Override // com.sinch.android.rtc.calling.Call
    public Map<String, String> getHeaders() {
        return this.call.getHeaders();
    }

    public List<WebRtcIceServer> getIceServers() {
        return this.mIceServers;
    }

    public com.sinch.android.rtc.internal.natives.jni.Call getNativeCall() {
        return this.call;
    }

    @Override // com.sinch.android.rtc.calling.Call
    public String getRemoteUserId() {
        return this.call.getRemoteUserId();
    }

    @Override // com.sinch.android.rtc.calling.Call
    public CallState getState() {
        int state = this.call.getState();
        if (state < 0 || state >= CallState.values().length) {
            throw new IllegalStateException("Illegal Call State exception with number:" + state);
        }
        return CallState.values()[state];
    }

    @Override // com.sinch.android.rtc.calling.Call
    public void hangup() {
        if (this.isValidForActions) {
            this.call.terminate(CallEndCause.HUNG_UP.getValue());
        }
    }

    public boolean isPeerConnectionCreated() {
        return this.mPeerConnectionClient != null;
    }

    @Override // com.sinch.android.rtc.internal.client.calling.PeerConnection.StatsCollector.StatsFeedback
    public void onConnectionInfo(ConnectionInfo connectionInfo) {
        Iterator<CallListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            CallListener next = it.next();
            if (next instanceof InternalCallListener) {
                ((InternalCallListener) next).onConnectionInfo(this, connectionInfo);
            }
        }
    }

    public void onIceServers(List<WebRtcIceServer> list) {
        if (this.mIceServersReceived) {
            return;
        }
        this.mIceServersReceived = true;
        this.mIceServers = list;
        createPeerConnectionIfApplicable();
    }

    public void onJsepMessageReceive(String str, JsepMessage jsepMessage) {
        PeerConnectionClientInterface peerConnectionClientInterface = this.mPeerConnectionClient;
        if (peerConnectionClientInterface == null) {
            this.mPendingJsepMessages.add(new Pair<>(str, jsepMessage));
        } else {
            peerConnectionClientInterface.onJsepMessageReceive(str, jsepMessage);
        }
    }

    public void onPushData(List<PushPair> list) {
    }

    public void onRemotePeerCapabilitiesChange(String str, List<String> list) {
        com.sinch.android.rtc.internal.natives.CallDetails details = this.call.getDetails();
        if (details != null) {
            SinchLogger sinchLogger = this.logger;
            String str2 = TAG;
            sinchLogger.d(str2, "onRemotePeerCapabilitiesChange: " + this.call.getCallId() + ": " + details.toString());
        }
        PeerConnectionClientInterface peerConnectionClientInterface = this.mPeerConnectionClient;
        if (peerConnectionClientInterface != null) {
            peerConnectionClientInterface.onRemotePeerCapabilitiesChange(str, list);
        }
    }

    public void onSessionEstablished() {
        com.sinch.android.rtc.internal.natives.CallDetails details = this.call.getDetails();
        if (details != null) {
            SinchLogger sinchLogger = this.logger;
            String str = TAG;
            sinchLogger.d(str, "onSessionEstablished: " + this.call.getCallId() + ": " + details.toString());
        }
        PeerConnectionClientInterface peerConnectionClientInterface = this.mPeerConnectionClient;
        if (peerConnectionClientInterface != null) {
            peerConnectionClientInterface.setCommunicationMode(true);
        }
        Iterator<CallListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onCallEstablished(this);
        }
        PeerConnectionClientInterface peerConnectionClientInterface2 = this.mPeerConnectionClient;
        if (peerConnectionClientInterface2 != null) {
            peerConnectionClientInterface2.onRemoteInstanceIdResolved(this.call.getRemoteInstanceId());
            this.logger.d(TAG, "enabling media tracks for mPeerConnectionClient");
            this.mPeerConnectionClient.enableMedia(true, true, true, true);
        }
    }

    public void onSessionProgressing() {
        com.sinch.android.rtc.internal.natives.CallDetails details = this.call.getDetails();
        if (details != null) {
            SinchLogger sinchLogger = this.logger;
            String str = TAG;
            sinchLogger.d(str, "onSessionProgressing: " + this.call.getCallId() + ": " + details.toString());
        }
        boolean hasEarlyMedia = this.call.hasEarlyMedia();
        PeerConnectionClientInterface peerConnectionClientInterface = this.mPeerConnectionClient;
        if (peerConnectionClientInterface != null && hasEarlyMedia) {
            peerConnectionClientInterface.onRemoteInstanceIdResolved(this.call.getRemoteInstanceId());
            this.logger.d(TAG, "enabling audio tracks for mPeerConnectionClient because early media is requested");
            this.mPeerConnectionClient.enableMedia(true, true, false, false);
        }
        Iterator<CallListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            CallListener next = it.next();
            if (next instanceof InternalCallListener) {
                next = (InternalCallListener) next;
            }
            next.onCallProgressing(this);
        }
    }

    public void onSessionTerminated() {
        this.isValidForActions = false;
        com.sinch.android.rtc.internal.natives.CallDetails details = this.call.getDetails();
        if (details != null) {
            SinchLogger sinchLogger = this.logger;
            String str = TAG;
            sinchLogger.d(str, "onSessionTerminated: " + this.call.getCallId() + ": " + details.toString());
        }
        PeerConnectionClientInterface peerConnectionClientInterface = this.mPeerConnectionClient;
        if (peerConnectionClientInterface != null) {
            peerConnectionClientInterface.setCommunicationMode(false);
        }
        Iterator<CallListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onCallEnded(this);
        }
        PeerConnectionClientInterface peerConnectionClientInterface2 = this.mPeerConnectionClient;
        if (peerConnectionClientInterface2 != null) {
            peerConnectionClientInterface2.close();
        }
    }

    @Override // com.sinch.android.rtc.internal.client.calling.PeerConnection.StatsCollector.StatsFeedback
    public void onStatisticReport(StatsReport[] statsReportArr) {
        Iterator<CallListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            CallListener next = it.next();
            if (next instanceof InternalCallListener) {
                ((InternalCallListener) next).onStatisticReport(statsReportArr);
            }
        }
    }

    public void onVideoTrackAdded() {
        this.mVideoEventsQueue.add(new Runnable() { // from class: com.sinch.android.rtc.internal.client.f
            @Override // java.lang.Runnable
            public final void run() {
                DefaultCall.this.lambda$onVideoTrackAdded$0();
            }
        });
        processVideoEventQueue();
    }

    public void onVideoTrackPaused() {
        this.mVideoEventsQueue.add(new Runnable() { // from class: com.sinch.android.rtc.internal.client.e
            @Override // java.lang.Runnable
            public final void run() {
                DefaultCall.this.lambda$onVideoTrackPaused$1();
            }
        });
        processVideoEventQueue();
    }

    public void onVideoTrackResumed() {
        this.mVideoEventsQueue.add(new Runnable() { // from class: com.sinch.android.rtc.internal.client.d
            @Override // java.lang.Runnable
            public final void run() {
                DefaultCall.this.lambda$onVideoTrackResumed$2();
            }
        });
        processVideoEventQueue();
    }

    @Override // com.sinch.android.rtc.calling.Call
    public void pauseVideo() {
        PeerConnectionClientInterface peerConnectionClientInterface;
        if (!this.isValidForActions || (peerConnectionClientInterface = this.mPeerConnectionClient) == null) {
            return;
        }
        peerConnectionClientInterface.enableVideoTrack(false);
        this.call.enableVideoTrack(false);
    }

    @Override // com.sinch.android.rtc.calling.Call
    public void removeCallListener(CallListener callListener) {
        this.listeners.remove(callListener);
    }

    public void reportAudioRouteEvent(String str, long j8) {
        this.call.reportAudioRouteEvent(str, j8);
    }

    @Override // com.sinch.android.rtc.calling.Call
    public void resumeVideo() {
        PeerConnectionClientInterface peerConnectionClientInterface;
        if (!this.isValidForActions || (peerConnectionClientInterface = this.mPeerConnectionClient) == null) {
            return;
        }
        peerConnectionClientInterface.enableVideoTrack(true);
        this.call.enableVideoTrack(true);
    }

    @Override // com.sinch.android.rtc.calling.Call
    public void sendDTMF(String str) {
        if (this.isValidForActions) {
            validateDtmf(str);
            this.mPeerConnectionClient.sendDtmf(str);
            if (this.mDtmfFeedback == null) {
                this.mDtmfFeedback = new DtmfPlayer();
            }
            this.mDtmfFeedback.play(str);
        }
    }

    @Override // com.sinch.android.rtc.calling.Call
    public void setBandwidthLimits(final int i8, final int i9) {
        synchronized (this.mPeerConnectionClientEventsQueue) {
            this.mPeerConnectionClientEventsQueue.add(new Runnable() { // from class: com.sinch.android.rtc.internal.client.b
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultCall.this.lambda$setBandwidthLimits$4(i8, i9);
                }
            });
        }
        processPeerConnectionClientEventsQueue();
    }

    public void setSendExtendedSessionReport(boolean z7, final int i8) {
        synchronized (this.mPeerConnectionClientEventsQueue) {
            this.mPeerConnectionClientEventsQueue.add(new Runnable() { // from class: com.sinch.android.rtc.internal.client.c
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultCall.this.lambda$setSendExtendedSessionReport$3(i8);
                }
            });
        }
        processPeerConnectionClientEventsQueue();
    }
}
