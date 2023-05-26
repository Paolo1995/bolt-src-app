package com.sinch.android.rtc.internal.client.calling;

import android.content.Context;
import android.os.Build;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.sinch.android.rtc.MissingPermissionException;
import com.sinch.android.rtc.PushPair;
import com.sinch.android.rtc.calling.CallController;
import com.sinch.android.rtc.calling.CallControllerListener;
import com.sinch.android.rtc.calling.CallDirection;
import com.sinch.android.rtc.calling.CallEndCause;
import com.sinch.android.rtc.calling.CallNotificationResult;
import com.sinch.android.rtc.calling.MediaConstraints;
import com.sinch.android.rtc.internal.AudioRouteMonitor;
import com.sinch.android.rtc.internal.CallbackHandler;
import com.sinch.android.rtc.internal.ExternalPushListener;
import com.sinch.android.rtc.internal.client.DefaultCall;
import com.sinch.android.rtc.internal.client.SinchClientStatusProvider;
import com.sinch.android.rtc.internal.client.SinchLogger;
import com.sinch.android.rtc.internal.client.WebRtcCallConfiguration;
import com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionFactoryProvider;
import com.sinch.android.rtc.internal.client.video.VideoControllerInternal;
import com.sinch.android.rtc.internal.natives.CallEventListener;
import com.sinch.android.rtc.internal.natives.ConnectionInfo;
import com.sinch.android.rtc.internal.natives.MediaOfferFlag;
import com.sinch.android.rtc.internal.natives.StatsReport;
import com.sinch.android.rtc.internal.natives.jni.Call;
import com.sinch.android.rtc.internal.natives.jni.CallClient;
import com.sinch.android.rtc.internal.natives.jni.CallClientListener;
import com.sinch.android.rtc.internal.natives.jni.NativeCallClient;
import com.sinch.android.rtc.internal.natives.jni.WebRtcIceServer;
import com.sinch.android.rtc.internal.service.state.AppStateService;
import com.sinch.android.rtc.internal.service.time.TimeService;
import j$.util.DesugarCollections;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;
import org.webrtc.audio.WebRtcAudioTrack;

/* loaded from: classes3.dex */
public class DefaultCallController implements CallController, CallClientListener, JsepMessageReceiver, CallEventListener, AudioRouteMonitor.AudioRouteMonitorListener {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String APP_USER_DOMAIN = "mxp";
    public static final String CONFERENCE_DOMAIN = "conference";
    private static final int HEADER_MAX_SIZE = 1024;
    public static final long ICE_SERVERS_VALID_WINDOW_MS = 30000;
    public static final String PSTN_DOMAIN = "pstn";
    public static final String SIP_DOMAIN = "sip";
    private static final String TAG = "DefaultCallController";
    private final AppStateService mAppStateService;
    private AudioRouteMonitor mAudioRouteMonitor;
    private final CallClient mCallClient;
    private CallbackHandler mCallbackHandler;
    private Context mContext;
    private String mExternalPushDisplayName;
    private final boolean mIsUsingManagedPush;
    private final JsepMessageChannel mJsepMessageChannel;
    private SinchLogger mLogger;
    private WebRtcIceServer[] mOutboundCallsWebRtcIceServers;
    private PeerConnectionFactoryProvider mPeerConnectionFactory;
    private boolean mSendExtedndedSessionReport;
    private SinchClientStatusProvider mSinchClientStatusProvider;
    private int mStatsCollectingPeriodMs;
    private TimeService mTimeService;
    private boolean mUseRelayIceCandidatesOnly;
    private VideoControllerInternal mVideoController;
    private WebRtcCallConfiguration mWebRtcCallConfiguration;
    private PhoneListener phoneListener;
    private final CopyOnWriteArraySet<CallControllerListener> mCallControllerListeners = new CopyOnWriteArraySet<>();
    private final Set<ExternalPushListener> mExternalPushListeners = new CopyOnWriteArraySet();
    private final Map<String, DefaultCall> callsHandled = DesugarCollections.synchronizedMap(new HashMap());
    private final Map<Call, DefaultCall> activeCalls = DesugarCollections.synchronizedMap(new HashMap());
    private boolean respectNativeCalls = true;
    private int maxAudioBitrate = 0;
    private int maxVideoBitrate = 0;

    /* loaded from: classes3.dex */
    public class PhoneListener extends PhoneStateListener {
        private PhoneListener() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i8, String str) {
            if (i8 == 2) {
                synchronized (DefaultCallController.this.activeCalls) {
                    for (Map.Entry entry : DefaultCallController.this.activeCalls.entrySet()) {
                        ((DefaultCall) entry.getValue()).hangup();
                    }
                }
                unlisten();
            }
        }

        public void unlisten() {
            ((TelephonyManager) DefaultCallController.this.mContext.getSystemService("phone")).listen(this, 0);
            DefaultCallController.this.phoneListener = null;
        }
    }

    public DefaultCallController(SinchLogger sinchLogger, SinchClientStatusProvider sinchClientStatusProvider, TimeService timeService, AppStateService appStateService, CallClient callClient, Context context, CallbackHandler callbackHandler, PeerConnectionFactoryProvider peerConnectionFactoryProvider, com.sinch.android.rtc.internal.natives.jni.JsepMessageChannel jsepMessageChannel, boolean z7, int i8, boolean z8, boolean z9) {
        this.mAudioRouteMonitor = null;
        this.mUseRelayIceCandidatesOnly = false;
        this.mStatsCollectingPeriodMs = 10000;
        this.mLogger = sinchLogger;
        this.mSinchClientStatusProvider = sinchClientStatusProvider;
        this.mCallClient = callClient;
        callClient.setListener(this);
        this.mContext = context;
        this.mCallbackHandler = callbackHandler;
        this.mPeerConnectionFactory = peerConnectionFactoryProvider;
        DefaultJsepMessageChannel defaultJsepMessageChannel = new DefaultJsepMessageChannel(jsepMessageChannel, this.mLogger);
        this.mJsepMessageChannel = defaultJsepMessageChannel;
        defaultJsepMessageChannel.setInboundReceiver(this);
        this.mSendExtedndedSessionReport = z7;
        this.mStatsCollectingPeriodMs = i8;
        this.mWebRtcCallConfiguration = new WebRtcCallConfiguration();
        this.mTimeService = timeService;
        this.mUseRelayIceCandidatesOnly = z8;
        this.mIsUsingManagedPush = z9;
        this.mAppStateService = appStateService;
        if (Build.VERSION.SDK_INT >= 24) {
            AudioRouteMonitor audioRouteMonitor = new AudioRouteMonitor();
            this.mAudioRouteMonitor = audioRouteMonitor;
            audioRouteMonitor.setAudioRouteMonitorListener(this);
            this.mAudioRouteMonitor.attachToWebRtcAudioTracks();
        }
    }

    private com.sinch.android.rtc.calling.Call call(String str, String str2, String str3, Map<String, String> map, MediaOfferFlag mediaOfferFlag) {
        throwUnlessStarted();
        throwIfMissingPermission();
        if (str == null || "".equals(str)) {
            throw new IllegalArgumentException("toUserId must not be null or empty");
        }
        if (map == null) {
            map = new HashMap<>();
        }
        String str4 = str2 == null ? "" : str2;
        throwIfHeadersSizeLimitExceeded(map);
        return createCall(this.mCallClient.createOutgoingCall(UUID.randomUUID().toString(), str4, str, str3, (String[]) map.keySet().toArray(new String[map.size()]), (String[]) map.values().toArray(new String[map.size()]), mediaOfferFlag.ordinal()));
    }

    private com.sinch.android.rtc.calling.Call createCall(Call call) {
        call.setEventListener(this);
        DefaultCall defaultCall = new DefaultCall(this.mLogger, call, this.mContext, this.mCallbackHandler, this.mVideoController, this.mJsepMessageChannel, getWebRtcCallConfiguration(), this.mTimeService, this.mAppStateService, call.isInbound() ? Collections.emptyList() : getNonExpiredIceServers(this.mOutboundCallsWebRtcIceServers), this.mUseRelayIceCandidatesOnly);
        defaultCall.setBandwidthLimits(this.maxAudioBitrate, this.maxVideoBitrate);
        defaultCall.setSendExtendedSessionReport(this.mSendExtedndedSessionReport, this.mStatsCollectingPeriodMs);
        this.activeCalls.put(call, defaultCall);
        this.callsHandled.put(call.getCallId(), defaultCall);
        return defaultCall;
    }

    private void handleInboundCallIceServers(Call call, WebRtcIceServer[] webRtcIceServerArr) {
        DefaultCall defaultCall = this.activeCalls.get(call);
        if (defaultCall != null) {
            defaultCall.onIceServers(getNonExpiredIceServers(webRtcIceServerArr));
            return;
        }
        SinchLogger sinchLogger = this.mLogger;
        String str = TAG;
        sinchLogger.w(str, "Received ice servers for non existent call id: " + call.getCallId());
    }

    private void handleOutboundCallsIceServers(WebRtcIceServer[] webRtcIceServerArr) {
        this.mOutboundCallsWebRtcIceServers = webRtcIceServerArr;
        for (DefaultCall defaultCall : this.activeCalls.values()) {
            if (defaultCall.getDirection() == CallDirection.OUTGOING) {
                defaultCall.onIceServers(getNonExpiredIceServers(webRtcIceServerArr));
            }
        }
    }

    private void notifyExternalPushListeners(Call call, Map<String, String> map) {
        if (map == null) {
            Log.w(TAG, "Received null payload from native SDK layer");
            return;
        }
        String str = this.mExternalPushDisplayName;
        if (str != null) {
            map.put("name", str);
        }
        DefaultCall defaultCall = this.activeCalls.get(call);
        if (defaultCall != null) {
            for (ExternalPushListener externalPushListener : this.mExternalPushListeners) {
                externalPushListener.onNewExternalPushPayload(defaultCall, map);
            }
            return;
        }
        String str2 = TAG;
        Log.w(str2, "onNewPushPayload called for non-existent call with id " + call.getCallId());
    }

    private void setupPhoneStateListener() {
        if (this.respectNativeCalls && this.phoneListener == null && this.activeCalls.size() > 0 && this.mContext.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
            this.phoneListener = new PhoneListener();
            ((TelephonyManager) this.mContext.getSystemService("phone")).listen(this.phoneListener, 32);
        }
    }

    private void throwIfDisposed() {
        if (this.mSinchClientStatusProvider.isDisposed()) {
            throw new IllegalStateException("SinchClient is stopped, you may not perform further actions until it is recreated");
        }
    }

    private void throwIfExternalPushOperationInvalid(ExternalPushListener externalPushListener) {
        if (externalPushListener == null) {
            throw new IllegalArgumentException("ExternalPushListener cannot be null");
        }
        if (this.mIsUsingManagedPush) {
            throw new UnsupportedOperationException("External push functionality not supported when using managed push.");
        }
    }

    private void throwIfHeadersSizeLimitExceeded(Map<String, String> map) {
        int i8 = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                i8 = i8 + entry.getKey().getBytes("UTF-8").length + entry.getValue().getBytes("UTF-8").length;
                if (i8 > 1024) {
                    throw new IllegalArgumentException("Header size limit exceeded 1024 bytes");
                }
            } catch (UnsupportedEncodingException unused) {
                throw new IllegalArgumentException("Could not encode headers as UTF-8");
            }
        }
    }

    private void throwIfMissingPermission() {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.RECORD_AUDIO") != 0) {
            throw new MissingPermissionException("android.permission.RECORD_AUDIO");
        }
    }

    private void throwUnlessStarted() {
        throwIfDisposed();
        if (!this.mSinchClientStatusProvider.isStarted()) {
            throw new IllegalStateException("SinchClient not started");
        }
    }

    @Override // com.sinch.android.rtc.calling.CallController
    public void addCallControllerListener(CallControllerListener callControllerListener) {
        this.mCallControllerListeners.add(callControllerListener);
    }

    public void addExternalPushListener(ExternalPushListener externalPushListener) throws IllegalArgumentException, UnsupportedOperationException {
        throwIfExternalPushOperationInvalid(externalPushListener);
        this.mExternalPushListeners.add(externalPushListener);
    }

    @Override // com.sinch.android.rtc.calling.CallController
    public com.sinch.android.rtc.calling.Call callConference(String str) {
        return callConference(str, null, null);
    }

    @Override // com.sinch.android.rtc.calling.CallController
    public com.sinch.android.rtc.calling.Call callConference(String str, String str2) {
        return callConference(str, str2, null);
    }

    @Override // com.sinch.android.rtc.calling.CallController
    public com.sinch.android.rtc.calling.Call callConference(String str, String str2, Map<String, String> map) {
        if (str.length() <= 64) {
            return call(str, str2, CONFERENCE_DOMAIN, map, MediaOfferFlag.AudioOnly);
        }
        throw new IllegalArgumentException("conferenceId must be at most 64 characters");
    }

    @Override // com.sinch.android.rtc.calling.CallController
    public com.sinch.android.rtc.calling.Call callConference(String str, Map<String, String> map) {
        return callConference(str, null, map);
    }

    @Override // com.sinch.android.rtc.calling.CallController
    public com.sinch.android.rtc.calling.Call callPhoneNumber(String str, String str2) {
        return callPhoneNumber(str, str2, null);
    }

    @Override // com.sinch.android.rtc.calling.CallController
    public com.sinch.android.rtc.calling.Call callPhoneNumber(String str, String str2, Map<String, String> map) {
        if (str2 == null || str2.isEmpty()) {
            throw new IllegalArgumentException("cli must not be null or empty");
        }
        return call(str, str2, PSTN_DOMAIN, map, MediaOfferFlag.AudioOnly);
    }

    @Override // com.sinch.android.rtc.calling.CallController
    public com.sinch.android.rtc.calling.Call callSip(String str) {
        return callSip(str, null, null);
    }

    @Override // com.sinch.android.rtc.calling.CallController
    public com.sinch.android.rtc.calling.Call callSip(String str, String str2) {
        return callSip(str, str2, null);
    }

    @Override // com.sinch.android.rtc.calling.CallController
    public com.sinch.android.rtc.calling.Call callSip(String str, String str2, Map<String, String> map) {
        return call(str, str2, SIP_DOMAIN, map, MediaOfferFlag.AudioOnly);
    }

    @Override // com.sinch.android.rtc.calling.CallController
    public com.sinch.android.rtc.calling.Call callSip(String str, Map<String, String> map) {
        return callSip(str, null, map);
    }

    @Override // com.sinch.android.rtc.calling.CallController
    public com.sinch.android.rtc.calling.Call callUser(String str, @NonNull MediaConstraints mediaConstraints) {
        return callUser(str, mediaConstraints, null);
    }

    @Override // com.sinch.android.rtc.calling.CallController
    public com.sinch.android.rtc.calling.Call callUser(String str, @NonNull MediaConstraints mediaConstraints, Map<String, String> map) {
        if (mediaConstraints != null) {
            return call(str, null, "mxp", map, mediaConstraints.isVideoRequested() ? MediaOfferFlag.AudioAndVideo : MediaOfferFlag.AudioOnly);
        }
        throw new IllegalArgumentException("mediaConstraints must not be null");
    }

    @Override // com.sinch.android.rtc.calling.CallController
    public com.sinch.android.rtc.calling.Call getCall(String str) {
        if (str == null) {
            return null;
        }
        for (Map.Entry<String, DefaultCall> entry : this.callsHandled.entrySet()) {
            if (str.equalsIgnoreCase(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }

    public List<WebRtcIceServer> getNonExpiredIceServers(WebRtcIceServer[] webRtcIceServerArr) {
        if (webRtcIceServerArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        long now = this.mTimeService.now();
        for (WebRtcIceServer webRtcIceServer : webRtcIceServerArr) {
            if (webRtcIceServer.getValidUntil() != null && now < webRtcIceServer.getValidUntil().getTime() - ICE_SERVERS_VALID_WINDOW_MS) {
                arrayList.add(webRtcIceServer);
            }
        }
        return arrayList;
    }

    public WebRtcCallConfiguration getWebRtcCallConfiguration() {
        return this.mWebRtcCallConfiguration;
    }

    public void handleCallPushPayload(CallNotificationResult callNotificationResult) {
        if (callNotificationResult.isTimedOut()) {
            return;
        }
        throwUnlessStarted();
        if (this.callsHandled.keySet().contains(callNotificationResult.getCallId())) {
            return;
        }
        MediaOfferFlag mediaOfferFlag = callNotificationResult.isVideoOffered() ? MediaOfferFlag.AudioAndVideo : MediaOfferFlag.AudioOnly;
        Map<String, String> callHeaders = callNotificationResult.getCallHeaders();
        if (callHeaders == null) {
            callHeaders = new HashMap<>();
        }
        Call createIncomingCall = this.mCallClient.createIncomingCall(callNotificationResult.getCallId(), callNotificationResult.getRemoteUserId(), callNotificationResult.getDomain(), (String[]) callHeaders.keySet().toArray(new String[callHeaders.size()]), (String[]) callHeaders.values().toArray(new String[callHeaders.size()]), mediaOfferFlag.ordinal());
        createCall(createIncomingCall);
        SinchLogger sinchLogger = this.mLogger;
        String str = TAG;
        sinchLogger.d(str, "Incoming session created: " + createIncomingCall.getCallId());
        if (!this.respectNativeCalls || ((TelephonyManager) this.mContext.getSystemService("phone")).getCallState() == 0) {
            createIncomingCall.startInbound();
            return;
        }
        createIncomingCall.startInbound();
        createIncomingCall.terminate(CallEndCause.HUNG_UP.getValue());
    }

    public boolean isRespectNativeCalls() {
        return this.respectNativeCalls;
    }

    public void notifyIncomingCall(com.sinch.android.rtc.calling.Call call) {
        Iterator<CallControllerListener> it = this.mCallControllerListeners.iterator();
        while (it.hasNext()) {
            it.next().onIncomingCall(this, call);
        }
        WebRtcAudioTrack.deferRemoteAudioPlayback();
    }

    @Override // com.sinch.android.rtc.internal.AudioRouteMonitor.AudioRouteMonitorListener
    public void onAudioRoutingChanged(String str) {
        TimeService timeService = this.mTimeService;
        long now = timeService != null ? timeService.now() : System.currentTimeMillis();
        for (DefaultCall defaultCall : this.activeCalls.values()) {
            defaultCall.reportAudioRouteEvent(str, now);
        }
    }

    @Override // com.sinch.android.rtc.internal.natives.CallEventListener
    public void onCallStatistics(Call call, StatsReport[] statsReportArr) {
        DefaultCall defaultCall = this.activeCalls.get(call);
        if (defaultCall == null) {
            return;
        }
        defaultCall.onStatisticReport(statsReportArr);
    }

    @Override // com.sinch.android.rtc.internal.natives.CallEventListener
    public void onConnectionInfo(Call call, ConnectionInfo connectionInfo) {
        DefaultCall defaultCall = this.activeCalls.get(call);
        if (defaultCall == null) {
            return;
        }
        defaultCall.onConnectionInfo(connectionInfo);
    }

    @Override // com.sinch.android.rtc.internal.natives.CallEventListener
    public void onEstablished(Call call) {
        DefaultCall defaultCall = this.activeCalls.get(call);
        if (defaultCall == null) {
            return;
        }
        setupPhoneStateListener();
        defaultCall.onSessionEstablished();
        WebRtcAudioTrack.proceedWithRemoteAudioPlayback();
    }

    @Override // com.sinch.android.rtc.internal.natives.jni.CallClientListener
    public void onIceServers(Call call, WebRtcIceServer[] webRtcIceServerArr) {
        if (call != null) {
            handleInboundCallIceServers(call, webRtcIceServerArr);
        } else {
            handleOutboundCallsIceServers(webRtcIceServerArr);
        }
    }

    @Override // com.sinch.android.rtc.internal.natives.jni.CallClientListener
    public void onIncomingCall(Call call) {
        SinchLogger sinchLogger = this.mLogger;
        String str = TAG;
        sinchLogger.d(str, "onIncomingSession " + call.getCallId());
        if (!this.respectNativeCalls || ((TelephonyManager) this.mContext.getSystemService("phone")).getCallState() == 0) {
            notifyIncomingCall(this.activeCalls.containsKey(call) ? this.activeCalls.get(call) : createCall(call));
        } else {
            call.terminate(CallEndCause.HUNG_UP.getValue());
        }
    }

    @Override // com.sinch.android.rtc.internal.client.calling.JsepMessageReceiver
    public void onJsepMessageReceived(String str, String str2, JsepMessage jsepMessage) {
        for (DefaultCall defaultCall : this.activeCalls.values()) {
            if (defaultCall.getCallId().equals(str)) {
                defaultCall.onJsepMessageReceive(str2, jsepMessage);
            }
        }
    }

    @Override // com.sinch.android.rtc.internal.natives.jni.CallClientListener
    public void onNewExternalPushPayload(Call call, Map<String, String> map) {
        if (this.mIsUsingManagedPush) {
            Log.d(TAG, "Ignoring onNewPushPayload. Managed push is used");
            return;
        }
        String str = TAG;
        Log.d(str, "onNewPushPayload called for call " + call.getCallId());
        notifyExternalPushListeners(call, map);
    }

    @Override // com.sinch.android.rtc.internal.natives.CallEventListener
    public void onProgressing(Call call) {
        DefaultCall defaultCall = this.activeCalls.get(call);
        if (defaultCall == null) {
            return;
        }
        defaultCall.onSessionProgressing();
    }

    @Override // com.sinch.android.rtc.internal.natives.CallEventListener
    public void onPushData(Call call, List<PushPair> list) {
        DefaultCall defaultCall = this.activeCalls.get(call);
        if (defaultCall != null) {
            defaultCall.onPushData(list);
        } else {
            this.mLogger.w(TAG, "Got onPushData callback for unknown call");
        }
    }

    @Override // com.sinch.android.rtc.internal.natives.CallEventListener
    public void onRemotePeerCapabilitiesChange(Call call, String str, List<String> list) {
        DefaultCall defaultCall = this.activeCalls.get(call);
        if (defaultCall == null) {
            return;
        }
        defaultCall.onRemotePeerCapabilitiesChange(str, list);
    }

    @Override // com.sinch.android.rtc.internal.natives.CallEventListener
    public void onSignalStrength(Call call, int i8, int i9, int i10, int i11) {
        SinchLogger sinchLogger = this.mLogger;
        String str = TAG;
        sinchLogger.d(str, "onSignalStrength: " + call.getCallId());
    }

    @Override // com.sinch.android.rtc.internal.natives.CallEventListener
    public void onTerminated(Call call) {
        PhoneListener phoneListener;
        DefaultCall remove = this.activeCalls.remove(call);
        if (remove == null) {
            return;
        }
        remove.onSessionTerminated();
        WebRtcAudioTrack.proceedWithRemoteAudioPlayback();
        if (this.respectNativeCalls && this.activeCalls.isEmpty() && (phoneListener = this.phoneListener) != null) {
            phoneListener.unlisten();
        }
    }

    @Override // com.sinch.android.rtc.internal.natives.CallEventListener
    public void onVideoTrackAdded(Call call, Object obj) {
        DefaultCall defaultCall = this.activeCalls.get(call);
        if (defaultCall == null) {
            this.mLogger.w(TAG, "Got VideoTrackAdded for unknown call");
        } else {
            defaultCall.onVideoTrackAdded();
        }
    }

    @Override // com.sinch.android.rtc.internal.natives.CallEventListener
    public void onVideoTrackPaused(Call call) {
        DefaultCall defaultCall = this.activeCalls.get(call);
        if (defaultCall == null) {
            this.mLogger.w(TAG, "Got VideoTrackPaused for unknown call");
        } else {
            defaultCall.onVideoTrackPaused();
        }
    }

    @Override // com.sinch.android.rtc.internal.natives.CallEventListener
    public void onVideoTrackResumed(Call call) {
        DefaultCall defaultCall = this.activeCalls.get(call);
        if (defaultCall == null) {
            this.mLogger.w(TAG, "Got VideoTrackPaused for unknown call");
        } else {
            defaultCall.onVideoTrackResumed();
        }
    }

    @Override // com.sinch.android.rtc.calling.CallController
    public void removeCallControllerListener(CallControllerListener callControllerListener) {
        this.mCallControllerListeners.remove(callControllerListener);
    }

    public void removeExternalPushListener(ExternalPushListener externalPushListener) throws IllegalArgumentException, UnsupportedOperationException {
        throwIfExternalPushOperationInvalid(externalPushListener);
        this.mExternalPushListeners.remove(externalPushListener);
    }

    public void setBandwidthLimits(int i8, int i9) {
        this.maxAudioBitrate = i8;
        this.maxVideoBitrate = i9;
    }

    public void setExternalPushDisplayName(String str) {
        this.mExternalPushDisplayName = str;
    }

    public void setLegacyStunServers(List<String> list) {
        this.mWebRtcCallConfiguration.setLegacyStunServers(list);
    }

    @Override // com.sinch.android.rtc.calling.CallController
    public void setRespectNativeCalls(boolean z7) {
        throwIfDisposed();
        if (this.mSinchClientStatusProvider.isStarted()) {
            throw new IllegalStateException("This setting needs to be set before starting the SinchClient");
        }
        this.respectNativeCalls = z7;
    }

    public void setSdpSemantic(boolean z7) {
        this.mWebRtcCallConfiguration.setSdpSemantic(z7);
    }

    public void setSendExtendedSessionReport(boolean z7) {
        this.mSendExtedndedSessionReport = z7;
        for (DefaultCall defaultCall : this.activeCalls.values()) {
            defaultCall.setSendExtendedSessionReport(this.mSendExtedndedSessionReport, this.mStatsCollectingPeriodMs);
        }
    }

    public void setUseRelayCandidatesOnly(boolean z7) {
        this.mUseRelayIceCandidatesOnly = z7;
    }

    public void setUseTurn(boolean z7) {
        this.mWebRtcCallConfiguration.setUseTurn(z7);
    }

    public void setVideoTrackController(VideoControllerInternal videoControllerInternal) {
        this.mVideoController = videoControllerInternal;
    }

    public void terminate() {
        this.mCallClient.setListener(null);
        AudioRouteMonitor audioRouteMonitor = this.mAudioRouteMonitor;
        if (audioRouteMonitor != null) {
            audioRouteMonitor.detachFromWebRtcAudioTracks();
            this.mAudioRouteMonitor = null;
        }
        CallClient callClient = this.mCallClient;
        if (callClient instanceof NativeCallClient) {
            ((NativeCallClient) callClient).invalidate();
        }
    }
}
