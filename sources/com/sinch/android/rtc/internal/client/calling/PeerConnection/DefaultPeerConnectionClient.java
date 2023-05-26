package com.sinch.android.rtc.internal.client.calling.PeerConnection;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.api.Api;
import com.sinch.android.rtc.calling.CallEndCause;
import com.sinch.android.rtc.internal.CallbackHandler;
import com.sinch.android.rtc.internal.InternalErrorCodes;
import com.sinch.android.rtc.internal.client.InternalCapability;
import com.sinch.android.rtc.internal.client.ScheduledExecutor;
import com.sinch.android.rtc.internal.client.WebRtcCallConfiguration;
import com.sinch.android.rtc.internal.client.calling.JsepMessage;
import com.sinch.android.rtc.internal.client.calling.JsepMessageChannel;
import com.sinch.android.rtc.internal.client.calling.PeerConnection.DefaultPeerConnectionClient;
import com.sinch.android.rtc.internal.client.calling.PeerConnection.StatsCollector;
import com.sinch.android.rtc.internal.client.video.ProxyLocalVideoSink;
import com.sinch.android.rtc.internal.client.video.ProxyRemoteVideoSink;
import com.sinch.android.rtc.internal.client.video.VideoControllerInternal;
import com.sinch.android.rtc.internal.natives.CallEventListener;
import com.sinch.android.rtc.internal.natives.ConnectionInfo;
import com.sinch.android.rtc.internal.natives.StatsReport;
import com.sinch.android.rtc.internal.natives.jni.Call;
import com.sinch.android.rtc.internal.natives.jni.CallQualitySettings;
import com.sinch.android.rtc.internal.natives.jni.WebRtcIceServer;
import com.sinch.android.rtc.internal.service.time.TimeService;
import com.sinch.android.rtc.video.LocalVideoFrameListener;
import com.sinch.android.rtc.video.RemoteVideoFrameListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.webrtc.AudioSource;
import org.webrtc.AudioTrack;
import org.webrtc.Camera1Enumerator;
import org.webrtc.Camera2Enumerator;
import org.webrtc.CameraEnumerator;
import org.webrtc.CameraVideoCapturer;
import org.webrtc.IceCandidate;
import org.webrtc.Logging;
import org.webrtc.MediaConstraints;
import org.webrtc.MediaStreamTrack;
import org.webrtc.PeerConnection;
import org.webrtc.PeerConnectionFactory;
import org.webrtc.RTCStatsCollectorCallback;
import org.webrtc.RTCStatsReport;
import org.webrtc.RtcCertificatePem;
import org.webrtc.RtpSender;
import org.webrtc.SessionDescription;
import org.webrtc.SurfaceTextureHelper;
import org.webrtc.VideoCapturer;
import org.webrtc.VideoSource;
import org.webrtc.VideoTrack;

/* loaded from: classes3.dex */
public class DefaultPeerConnectionClient implements PeerConnectionClientInterface, StatsCollector.StatsFeedback, ScheduledExecutor {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String AUDIO_CODEC_OPUS = "opus";
    private static final String AUDIO_TRACK_ID = "a";
    private static final String DUMMY_REMOTE_INSTANCE_ID = "DummyRemoteInstanceId";
    public static final int MAX_LINGERING_PERIOD_MS = 300000;
    private static final long MAX_WAIT_FOR_AUTOMATIC_RECONNECTION_ICE_RESTART_MS = 10000;
    private static final long MAX_WAIT_FOR_NETWORK_AVAILABLE_ICE_RESTART_MS = 5000;
    private static final int STATS_FIRST_BURST_COUNT = 10;
    private static final int STATS_PERIOD_AT_START_OF_CALL_MS = 2000;
    private static final int STATS_PERIOD_MS = 10000;
    public static final String TAG = DefaultPeerConnectionClient.class.getSimpleName();
    private static final String VIDEO_TRACK_ID = "v";
    private MediaConstraints audioConstraints;
    private AudioSource audioSource;
    private ScheduledFuture<?> autoHangUpFuture;
    public final Call call;
    private final CallEventListener callEventListener;
    private CallQualitySettings callQualitySettings;
    private final CallbackHandler callbackHandler;
    private final Context context;
    public boolean isInitiator;
    public JsepMessageChannel jsepChannel;
    private AudioTrack localAudioTrack;
    private LocalVideoFrameListener localVideoFrameListener;
    public final ScheduledExecutorService mExecutor;
    private final PeerConnectionFactory mFactory;
    private final PeerConnectionFactoryProvider mFactoryProvider;
    private final PeerConnectionFactoryWrapper mFactoryWrapper;
    private final IceRestarter mIceRestarter;
    private final List<WebRtcIceServer> mIceServers;
    private final RtcCertificatePem mPeerConnectionsCertificate;
    public boolean mUseRelayIceCandidatesOnly;
    private final WebRtcCallConfiguration mWebRtcCallConfiguration;
    private PeerConnectionParameters peerConnectionParameters;
    public String preferredVideoCodec;
    private RemoteVideoFrameListener remoteVideoFrameListener;
    private MediaConstraints sdpMediaConstraints;
    private StatsCollector.StatsFeedback statsFeedback;
    private int statsTimerBurstCount;
    private SurfaceTextureHelper surfaceTextureHelper;
    private TimeService timeService;
    public boolean videoCallEnabled;
    private VideoCapturer videoCapturer;
    private VideoControllerInternal videoController;
    public int maxAudioBandwidth = 0;
    public int maxVideoBandwidth = 0;
    public int backEndLimitedMaxAudioBandwidh = Api.BaseClientBuilder.API_PRIORITY_OTHER;
    public int backEndLimitedMaxVideoBandwidh = Api.BaseClientBuilder.API_PRIORITY_OTHER;
    public boolean enableAudio = true;
    public boolean isError = false;
    public String currentRemoteUfrag = null;
    private int statsPeriodMs = InternalErrorCodes.ApiCallFailed;
    private String currentRemoteInstanceId = DUMMY_REMOTE_INSTANCE_ID;
    private boolean mRendererAdded = false;
    public boolean mIsClosing = false;
    private boolean remoteInstanceResolved = false;
    public SessionDescription localSdp = null;
    private Timer statsTimer = new Timer();
    private VideoSource videoSource = null;
    private VideoTrack localVideoTrack = null;
    private ProxyLocalVideoSink localVideoSink = null;
    private ProxyRemoteVideoSink remoteVideoSink = null;
    public LinkedList<IceCandidate> relayIceCandidates = new LinkedList<>();
    private boolean connectionEstablished = false;
    public boolean dataChannelEnabled = false;
    private boolean enableStatsEvents = false;
    private boolean mEnableLocalAudio = false;
    private boolean mEnableRemoteAudio = false;
    private boolean mEnableLocalVideo = false;
    private boolean mEnableRemoteVideo = false;
    private ConnectionInfo connectionInfo = null;
    private boolean mShouldAllowPerfectNegotiation = false;
    private Map<String, PeerConnectionInstance> peerConnectionInstances = new HashMap();
    private ArrayList<MediaStreamTrack> mediaTracks = new ArrayList<>();

    /* renamed from: com.sinch.android.rtc.internal.client.calling.PeerConnection.DefaultPeerConnectionClient$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 extends TimerTask {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0(RTCStatsReport rTCStatsReport) {
            DefaultPeerConnectionClient defaultPeerConnectionClient = DefaultPeerConnectionClient.this;
            if (defaultPeerConnectionClient.mIsClosing) {
                return;
            }
            defaultPeerConnectionClient.processWebRtcStatsReports(rTCStatsReport);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$1() {
            DefaultPeerConnectionClient defaultPeerConnectionClient = DefaultPeerConnectionClient.this;
            if (defaultPeerConnectionClient.mIsClosing || defaultPeerConnectionClient.getCurrentPeerConnectionInstance() == null || DefaultPeerConnectionClient.this.getCurrentPeerConnectionInstance().peerConnection == null) {
                return;
            }
            DefaultPeerConnectionClient defaultPeerConnectionClient2 = DefaultPeerConnectionClient.this;
            if (defaultPeerConnectionClient2.isError) {
                return;
            }
            defaultPeerConnectionClient2.getCurrentPeerConnectionInstance().peerConnection.getStats(new RTCStatsCollectorCallback() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.b0
                @Override // org.webrtc.RTCStatsCollectorCallback
                public final void onStatsDelivered(RTCStatsReport rTCStatsReport) {
                    DefaultPeerConnectionClient.AnonymousClass1.this.lambda$run$0(rTCStatsReport);
                }
            });
            DefaultPeerConnectionClient.access$008(DefaultPeerConnectionClient.this);
            if (DefaultPeerConnectionClient.this.statsTimerBurstCount == 10) {
                DefaultPeerConnectionClient.this.statsTimer.cancel();
                DefaultPeerConnectionClient.this.statsTimer = new Timer();
                DefaultPeerConnectionClient defaultPeerConnectionClient3 = DefaultPeerConnectionClient.this;
                defaultPeerConnectionClient3.enableStatsEventsInternal(defaultPeerConnectionClient3.statsPeriodMs);
            }
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            DefaultPeerConnectionClient.this.execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.a0
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultPeerConnectionClient.AnonymousClass1.this.lambda$run$1();
                }
            });
        }
    }

    /* renamed from: com.sinch.android.rtc.internal.client.calling.PeerConnection.DefaultPeerConnectionClient$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$sinch$android$rtc$internal$client$calling$JsepMessage$Type;

        static {
            int[] iArr = new int[JsepMessage.Type.values().length];
            $SwitchMap$com$sinch$android$rtc$internal$client$calling$JsepMessage$Type = iArr;
            try {
                iArr[JsepMessage.Type.Answer.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$sinch$android$rtc$internal$client$calling$JsepMessage$Type[JsepMessage.Type.Offer.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$sinch$android$rtc$internal$client$calling$JsepMessage$Type[JsepMessage.Type.PrAnswer.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$sinch$android$rtc$internal$client$calling$JsepMessage$Type[JsepMessage.Type.IceCandidate.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$sinch$android$rtc$internal$client$calling$JsepMessage$Type[JsepMessage.Type.RelayIceCandidate.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private DefaultPeerConnectionClient(Context context, final Call call, final boolean z7, final boolean z8, CallbackHandler callbackHandler, final VideoControllerInternal videoControllerInternal, JsepMessageChannel jsepMessageChannel, WebRtcCallConfiguration webRtcCallConfiguration, List<WebRtcIceServer> list, StatsCollector.StatsFeedback statsFeedback, TimeService timeService, boolean z9) {
        this.mUseRelayIceCandidatesOnly = false;
        this.call = call;
        this.context = context;
        this.videoCallEnabled = z7;
        this.callbackHandler = callbackHandler;
        this.isInitiator = z8;
        this.videoController = videoControllerInternal;
        this.jsepChannel = jsepMessageChannel;
        this.mWebRtcCallConfiguration = webRtcCallConfiguration;
        this.statsFeedback = statsFeedback;
        this.timeService = timeService;
        this.mIceServers = list;
        this.videoCapturer = null;
        this.callEventListener = call.getEventListener();
        this.localVideoFrameListener = videoControllerInternal.getLocalVideoFrameListener();
        this.remoteVideoFrameListener = videoControllerInternal.getRemoteVideoFrameListener();
        this.mUseRelayIceCandidatesOnly = z9;
        PeerConnectionFactoryProvider createDefaultPeerConnectionFactoryWrapper = DefaultPeerConnectionFactoryProvider.createDefaultPeerConnectionFactoryWrapper(context, true);
        this.mFactoryProvider = createDefaultPeerConnectionFactoryWrapper;
        PeerConnectionFactoryWrapper factoryWrapper = createDefaultPeerConnectionFactoryWrapper.getFactoryWrapper();
        this.mFactoryWrapper = factoryWrapper;
        this.mFactory = factoryWrapper.getFactory();
        this.mExecutor = createDefaultPeerConnectionFactoryWrapper.getExecutor();
        this.callQualitySettings = new CallQualitySettings();
        videoControllerInternal.setPeerConnectionClient(this);
        PeerConnectionParameters defaultPeerConnectionParameters = z7 ? PeerConnectionParameters.getDefaultPeerConnectionParameters() : PeerConnectionParameters.getDefaultAudioPeerConnectionParameters();
        this.peerConnectionParameters = defaultPeerConnectionParameters;
        createMediaConstraintsInternal(defaultPeerConnectionParameters);
        if (this.peerConnectionParameters.videoCallEnabled) {
            this.videoCapturer = createVideoCapturer();
        }
        if (this.videoCapturer == null) {
            Log.w(TAG, "VideoCapture is null. Switch to audio only call.");
            this.videoCallEnabled = false;
        }
        this.mPeerConnectionsCertificate = RtcCertificatePem.generateCertificate(PeerConnection.KeyType.ECDSA);
        this.mIceRestarter = new IceRestarter(MAX_WAIT_FOR_NETWORK_AVAILABLE_ICE_RESTART_MS, MAX_WAIT_FOR_AUTOMATIC_RECONNECTION_ICE_RESTART_MS, new NetworkMonitor(context, this), this);
        execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.l
            @Override // java.lang.Runnable
            public final void run() {
                DefaultPeerConnectionClient.this.lambda$new$0(z7, videoControllerInternal, call, z8);
            }
        });
    }

    public static /* synthetic */ int access$008(DefaultPeerConnectionClient defaultPeerConnectionClient) {
        int i8 = defaultPeerConnectionClient.statsTimerBurstCount;
        defaultPeerConnectionClient.statsTimerBurstCount = i8 + 1;
        return i8;
    }

    private PeerConnectionInstance addPeerConnectionInstance(String str, ArrayList<MediaStreamTrack> arrayList, boolean z7) {
        PeerConnectionInstance peerConnectionInstance = new PeerConnectionInstance(this, this, this.mFactory, str.equals(DUMMY_REMOTE_INSTANCE_ID) ? null : str, this.peerConnectionParameters, z7, arrayList);
        this.peerConnectionInstances.put(str, peerConnectionInstance);
        return peerConnectionInstance;
    }

    private void cancelAutoHangUp() {
        ScheduledFuture<?> scheduledFuture = this.autoHangUpFuture;
        if (scheduledFuture != null) {
            boolean cancel = scheduledFuture.cancel(true);
            String str = TAG;
            Log.d(str, "Auto hang up cancelled, result: " + cancel);
            this.autoHangUpFuture = null;
        }
    }

    private void closeInternal() {
        PeerConnectionFactory peerConnectionFactory = this.mFactory;
        if (peerConnectionFactory != null && this.peerConnectionParameters.aecDump) {
            peerConnectionFactory.stopAecDump();
        }
        if (this.videoCallEnabled) {
            String str = TAG;
            Log.d(str, "Removing video sinks and video processor.");
            if (this.videoController.getLocalRenderer() != null) {
                this.localVideoSink.setSink(null);
                this.localVideoTrack.removeSink(this.videoController.getLocalRenderer());
                this.videoSource.setVideoProcessor(null);
                Log.d(str, "Local video sink removed.");
            }
            if (this.videoController.getRemoteRenderer() != null) {
                this.remoteVideoSink.setSink(null);
                VideoTrack remoteVideoTrack = getCurrentPeerConnectionInstance().getRemoteVideoTrack();
                if (remoteVideoTrack != null) {
                    remoteVideoTrack.removeSink(this.remoteVideoSink);
                    Log.d(str, "Remote video sink removed.");
                }
            }
        }
        String str2 = TAG;
        Log.d(str2, "Closing peer connection. mIsClosing = " + this.mIsClosing + ", this = " + this);
        this.statsTimer.cancel();
        for (Map.Entry<String, PeerConnectionInstance> entry : this.peerConnectionInstances.entrySet()) {
            String str3 = TAG;
            Log.d(str3, "Closing peer connection instance: " + entry.getKey());
            PeerConnectionInstance value = entry.getValue();
            if (value != null) {
                value.disposeInternal();
            }
        }
        String str4 = TAG;
        Log.d(str4, "Closing audio source.");
        AudioSource audioSource = this.audioSource;
        if (audioSource != null) {
            audioSource.dispose();
            this.audioSource = null;
            Log.d(str4, "Audio source closed.");
        }
        Log.d(str4, "Stopping capture.");
        VideoCapturer videoCapturer = this.videoCapturer;
        if (videoCapturer != null) {
            try {
                videoCapturer.stopCapture();
                this.videoCapturer.dispose();
                this.videoCapturer = null;
                Log.d(str4, "Capture stopped.");
            } catch (InterruptedException e8) {
                throw new RuntimeException(e8);
            }
        }
        Log.d(str4, "Closing video source.");
        VideoSource videoSource = this.videoSource;
        if (videoSource != null) {
            videoSource.dispose();
            this.videoSource = null;
            Log.d(str4, "Video source closed.");
        }
        Log.d(str4, "Closing texture helper.");
        SurfaceTextureHelper surfaceTextureHelper = this.surfaceTextureHelper;
        if (surfaceTextureHelper != null) {
            surfaceTextureHelper.dispose();
            this.surfaceTextureHelper = null;
            Log.d(str4, "Texture helper closed.");
        }
        Log.d(str4, "Closing PeerConnectionFactory.");
        PeerConnectionFactory peerConnectionFactory2 = this.mFactory;
        if (peerConnectionFactory2 != null) {
            peerConnectionFactory2.dispose();
            Log.d(str4, "PeerConnectionFactory closed.");
        }
        Log.d(str4, "Closing PeerConnectionFactoryProvider.");
        PeerConnectionFactoryProvider peerConnectionFactoryProvider = this.mFactoryProvider;
        if (peerConnectionFactoryProvider != null) {
            peerConnectionFactoryProvider.dispose();
            Log.d(str4, "PeerConnectionFactoryProvider closed.");
        }
        Log.d(str4, "Closing IceRestarter.");
        IceRestarter iceRestarter = this.mIceRestarter;
        if (iceRestarter != null) {
            iceRestarter.dispose();
            Log.d(str4, "IceRestarter closed.");
        }
        Log.d(str4, "PeerConnectionClient closed.");
    }

    private AudioTrack createAudioTrack() {
        AudioSource createAudioSource = this.mFactory.createAudioSource(this.audioConstraints);
        this.audioSource = createAudioSource;
        AudioTrack createAudioTrack = this.mFactory.createAudioTrack(AUDIO_TRACK_ID, createAudioSource);
        this.localAudioTrack = createAudioTrack;
        createAudioTrack.setEnabled(true);
        return this.localAudioTrack;
    }

    private VideoCapturer createCameraCapturer(CameraEnumerator cameraEnumerator, int i8) {
        String[] deviceNames = cameraEnumerator.getDeviceNames();
        boolean z7 = i8 == 1;
        String str = z7 ? "front" : "back";
        for (int i9 = 0; i9 < 2; i9++) {
            for (String str2 : deviceNames) {
                if (cameraEnumerator.isFrontFacing(str2) == z7) {
                    Logging.d(TAG, "Creating " + str + " facing camera capturer.");
                    CameraVideoCapturer createCapturer = cameraEnumerator.createCapturer(str2, null);
                    if (createCapturer != null) {
                        return createCapturer;
                    }
                }
            }
            Logging.w(TAG, "Creating " + str + " facing camera capturer failed - no such camera found, trying to open other camera.");
            z7 ^= true;
        }
        Logging.e(TAG, "Creating camera capturer failed - no cameras found!");
        return null;
    }

    private void createMediaConstraintsInternal(PeerConnectionParameters peerConnectionParameters) {
        MediaConstraints[] createMediaConstraints = PeerConnectionUtils.createMediaConstraints(this.mFactoryWrapper, peerConnectionParameters.noAudioProcessing, peerConnectionParameters.enableLevelControl, this.videoCallEnabled, peerConnectionParameters);
        this.audioConstraints = createMediaConstraints[0];
        this.sdpMediaConstraints = createMediaConstraints[2];
    }

    public static synchronized PeerConnectionClientInterface createPeerConnectionClient(Context context, Call call, boolean z7, boolean z8, CallbackHandler callbackHandler, VideoControllerInternal videoControllerInternal, JsepMessageChannel jsepMessageChannel, WebRtcCallConfiguration webRtcCallConfiguration, List<WebRtcIceServer> list, StatsCollector.StatsFeedback statsFeedback, TimeService timeService, boolean z9) {
        DefaultPeerConnectionClient defaultPeerConnectionClient;
        synchronized (DefaultPeerConnectionClient.class) {
            defaultPeerConnectionClient = new DefaultPeerConnectionClient(context, call, z7, z8, callbackHandler, videoControllerInternal, jsepMessageChannel, webRtcCallConfiguration, list, statsFeedback, timeService, z9);
        }
        return defaultPeerConnectionClient;
    }

    private VideoCapturer createVideoCapturer() {
        CameraEnumerator camera1Enumerator;
        String str;
        int captureDevicePosition = this.videoController.getCaptureDevicePosition();
        if (this.peerConnectionParameters.captureToTexture) {
            if (Camera2Enumerator.isSupported(this.context)) {
                Logging.d(TAG, "Creating capturer using camera2 API.");
                camera1Enumerator = new Camera2Enumerator(this.context);
            } else {
                Logging.d(TAG, "Creating capturer using camera1 API.");
                camera1Enumerator = new Camera1Enumerator(this.peerConnectionParameters.captureToTexture);
            }
            VideoCapturer createCameraCapturer = createCameraCapturer(camera1Enumerator, captureDevicePosition);
            if (createCameraCapturer != null) {
                return createCameraCapturer;
            }
            str = "Failed to open camera";
        } else {
            str = "captureToTexture needs to be enabled!";
        }
        reportError(str);
        return null;
    }

    private VideoTrack createVideoTrack(VideoCapturer videoCapturer) {
        this.surfaceTextureHelper = SurfaceTextureHelper.create("CaptureThread", this.videoController.getEglBase().getEglBaseContext());
        VideoSource createVideoSource = this.mFactory.createVideoSource(videoCapturer.isScreencast());
        this.videoSource = createVideoSource;
        createVideoSource.setVideoProcessor(this.localVideoSink);
        videoCapturer.initialize(this.surfaceTextureHelper, this.context, this.videoSource.getCapturerObserver());
        if (ContextCompat.checkSelfPermission(this.context, "android.permission.CAMERA") != 0) {
            enableVideoTrack(false);
        } else {
            PeerConnectionParameters peerConnectionParameters = this.peerConnectionParameters;
            videoCapturer.startCapture(peerConnectionParameters.videoWidth, peerConnectionParameters.videoHeight, peerConnectionParameters.videoFps);
        }
        VideoTrack createVideoTrack = this.mFactory.createVideoTrack(VIDEO_TRACK_ID, this.videoSource);
        this.localVideoTrack = createVideoTrack;
        createVideoTrack.setEnabled(true);
        if (this.videoController.getLocalRenderer() != null) {
            this.localVideoTrack.addSink(this.videoController.getLocalRenderer());
        }
        return this.localVideoTrack;
    }

    private void enableMediaInternal() {
        execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.t
            @Override // java.lang.Runnable
            public final void run() {
                DefaultPeerConnectionClient.this.lambda$enableMediaInternal$9();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableStatsEventsInternal(final int i8) {
        execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.v
            @Override // java.lang.Runnable
            public final void run() {
                DefaultPeerConnectionClient.this.lambda$enableStatsEventsInternal$2(i8);
            }
        });
    }

    private PeerConnectionInstance getPeerConnectionInstance(String str) {
        return this.peerConnectionInstances.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$close$1() {
        cancelAutoHangUp();
        this.mIsClosing = true;
        closeInternal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$enableMedia$6(boolean z7, boolean z8, boolean z9, boolean z10) {
        this.mEnableLocalAudio = z7;
        this.mEnableRemoteAudio = z8;
        this.mEnableLocalVideo = z9;
        this.mEnableRemoteVideo = z10;
        enableMediaInternal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$enableMediaInternal$9() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = TAG;
        Log.d(str5, "Attempting to enable media streams for this peer connection.");
        Log.d(str5, "Global enableAudio: " + this.enableAudio);
        Log.d(str5, "Global videoCallEnabled: " + this.videoCallEnabled);
        Log.d(str5, "mEnableLocalAudio: " + this.mEnableLocalAudio);
        Log.d(str5, "mEnableLocalAudio: " + this.mEnableLocalAudio);
        Log.d(str5, "mEnableRemoteAudio: " + this.mEnableRemoteAudio);
        Log.d(str5, "mEnableLocalVideo: " + this.mEnableLocalVideo);
        Log.d(str5, "mEnableRemoteVideo: " + this.mEnableRemoteVideo);
        if (this.isError) {
            str = "Failed to enable media in peerConnection";
        } else {
            boolean z7 = true;
            boolean z8 = this.mEnableLocalAudio && this.enableAudio;
            boolean z9 = this.mEnableRemoteAudio && this.enableAudio;
            boolean z10 = this.mEnableLocalVideo && this.videoCallEnabled;
            z7 = (this.mEnableRemoteVideo && this.videoCallEnabled) ? false : false;
            AudioTrack audioTrack = this.localAudioTrack;
            if (audioTrack != null) {
                audioTrack.setEnabled(z8);
                str2 = "Local Audio: " + z8;
            } else {
                str2 = "Local Audio: null";
            }
            Log.d(str5, str2);
            if (getCurrentPeerConnectionInstance().getRemoteAudioTrack() != null) {
                getCurrentPeerConnectionInstance().getRemoteAudioTrack().setEnabled(z9);
                str3 = "Remote Audio: " + z9;
            } else {
                str3 = "Remote Audio: null";
            }
            Log.d(str5, str3);
            VideoTrack videoTrack = this.localVideoTrack;
            if (videoTrack != null) {
                videoTrack.setEnabled(z10);
                str4 = "Local Video: " + this.localVideoTrack;
            } else {
                str4 = "Local Video: null";
            }
            Log.d(str5, str4);
            if (getCurrentPeerConnectionInstance().getRemoteVideoTrack() != null) {
                getCurrentPeerConnectionInstance().getRemoteVideoTrack().setEnabled(z7);
                str = "Remote Video: " + getCurrentPeerConnectionInstance().getRemoteVideoTrack();
            } else {
                str = "Remote Video: null";
            }
        }
        Log.d(str5, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$enableStatsEventsInternal$2(int i8) {
        if (!this.enableStatsEvents) {
            this.statsTimer.cancel();
            return;
        }
        try {
            this.statsTimer.schedule(new AnonymousClass1(), 0L, i8);
        } catch (Exception e8) {
            Log.e(TAG, "Can not schedule statistics timer", e8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$execute$20(Runnable runnable) {
        if (!this.mIsClosing) {
            runnable.run();
            return;
        }
        String str = TAG;
        Log.w(str, "Closing! Executor in running phase, ignores task: " + runnable.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(boolean z7, VideoControllerInternal videoControllerInternal, Call call, boolean z8) {
        try {
            if (this.mPeerConnectionsCertificate == null) {
                throw new RuntimeException("Failed to create SSL certificate for PeerConnection");
            }
            PeerConnectionParameters defaultPeerConnectionParameters = z7 ? PeerConnectionParameters.getDefaultPeerConnectionParameters() : PeerConnectionParameters.getDefaultAudioPeerConnectionParameters();
            this.peerConnectionParameters = defaultPeerConnectionParameters;
            this.preferredVideoCodec = PeerConnectionUtils.checkPreferredVideoCodec(defaultPeerConnectionParameters, z7);
            String str = TAG;
            Log.d(str, "Preferred video codec: " + this.preferredVideoCodec);
            if (z7) {
                this.localVideoSink = new ProxyLocalVideoSink();
                this.remoteVideoSink = new ProxyRemoteVideoSink(call.getCallId());
                this.mediaTracks.add(createVideoTrack(this.videoCapturer));
            }
            this.mediaTracks.add(createAudioTrack());
            PeerConnectionInstance addPeerConnectionInstance = addPeerConnectionInstance(DUMMY_REMOTE_INSTANCE_ID, this.mediaTracks, true);
            if (z8) {
                addPeerConnectionInstance.createOffer(this.sdpMediaConstraints);
            }
        } catch (Exception e8) {
            reportError("Failed to create peer connection: " + e8.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onConnectionInfo$3(ConnectionInfo connectionInfo) {
        ConnectionInfo connectionInfo2 = this.connectionInfo;
        if (connectionInfo2 != null && connectionInfo2.getPort() == connectionInfo.getPort() && this.connectionInfo.getConnectionType().equals(connectionInfo.getConnectionType()) && this.connectionInfo.getProtocol().equals(connectionInfo.getProtocol())) {
            return;
        }
        this.connectionInfo = connectionInfo;
        String connectionType = connectionInfo.getConnectionType();
        Call call = this.call;
        call.setConnectionInfo(call.getCallId(), connectionType, connectionInfo.getProtocol(), connectionInfo.getHost(), connectionInfo.getPort());
        StatsCollector.StatsFeedback statsFeedback = this.statsFeedback;
        if (statsFeedback != null) {
            statsFeedback.onConnectionInfo(connectionInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onReceivedAnswer$14(String str, JsepMessage jsepMessage) {
        this.currentRemoteInstanceId = str;
        PeerConnectionInstance peerConnectionInstance = this.peerConnectionInstances.get(DUMMY_REMOTE_INSTANCE_ID);
        if (peerConnectionInstance != null) {
            this.peerConnectionInstances.put(this.currentRemoteInstanceId, peerConnectionInstance);
            this.peerConnectionInstances.remove(DUMMY_REMOTE_INSTANCE_ID);
            peerConnectionInstance.updateRemoteInstanceId(str);
        } else {
            peerConnectionInstance = this.peerConnectionInstances.get(str);
            if (peerConnectionInstance == null) {
                peerConnectionInstance = addPeerConnectionInstance(str, this.mediaTracks, false);
                peerConnectionInstance.createOffer(this.sdpMediaConstraints);
            }
        }
        peerConnectionInstance.setRemoteDescription(jsepMessage.getSessionDescription());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onReceivedIceCandidate$16(String str, JsepMessage jsepMessage) {
        PeerConnectionInstance peerConnectionInstance = getPeerConnectionInstance(str);
        if (peerConnectionInstance == null) {
            peerConnectionInstance = getCurrentPeerConnectionInstance();
        }
        peerConnectionInstance.addRemoteIceCandidate(jsepMessage.getIceCandidate());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onReceivedOffer$15(JsepMessage jsepMessage) {
        if (getCurrentPeerConnectionInstance() != null) {
            getCurrentPeerConnectionInstance().setRemoteDescription(jsepMessage.getSessionDescription());
            if (this.isInitiator) {
                return;
            }
            getCurrentPeerConnectionInstance().createAnswer(this.sdpMediaConstraints);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onReceivedRelayIceCandidate$13(JsepMessage jsepMessage) {
        this.relayIceCandidates.add(jsepMessage.getIceCandidate());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onRemoteInstanceIdResolved$5(String str) {
        if (this.remoteInstanceResolved || str == null || str.isEmpty()) {
            return;
        }
        this.remoteInstanceResolved = true;
        this.currentRemoteInstanceId = str;
        String str2 = TAG;
        Log.d(str2, "Pruning peer connection NOT associated with this remoteInstanceId: " + str);
        Log.d(str2, "Total number of PeerConnections: " + this.peerConnectionInstances.size());
        if (this.peerConnectionInstances.size() == 1) {
            Map.Entry<String, PeerConnectionInstance> next = this.peerConnectionInstances.entrySet().iterator().next();
            String key = next.getKey();
            if (!key.equals(this.currentRemoteInstanceId)) {
                this.peerConnectionInstances.put(this.currentRemoteInstanceId, next.getValue());
                this.peerConnectionInstances.remove(key);
                next.getValue().updateRemoteInstanceId(this.currentRemoteInstanceId);
            }
        }
        Iterator<Map.Entry<String, PeerConnectionInstance>> it = this.peerConnectionInstances.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, PeerConnectionInstance> next2 = it.next();
            if (!next2.getKey().equals(this.currentRemoteInstanceId)) {
                it.remove();
                next2.getValue().disposeInternal();
                String str3 = TAG;
                Log.d(str3, "Removing PeerConnection associated with remoteInstanceID = " + next2.getKey() + " remaining number of PeerConnecgions: " + this.peerConnectionInstances.size());
            }
        }
        getCurrentPeerConnectionInstance().addRelayIceCandidates();
        updateVideoTrackerInternal();
        this.connectionEstablished = true;
        enableStatsEventsInternal(2000);
        this.mIceRestarter.setTarget((PeerConnectionInstance) new ArrayList(this.peerConnectionInstances.values()).get(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStatisticReport$4(StatsReport[] statsReportArr) {
        StatsCollector.StatsFeedback statsFeedback = this.statsFeedback;
        if (statsFeedback != null) {
            statsFeedback.onStatisticReport(statsReportArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$peerConnectionStateChangedToConnected$7(PeerConnectionInstance peerConnectionInstance) {
        cancelAutoHangUp();
        this.mIceRestarter.notifyIceStateConnected(peerConnectionInstance);
        if (this.mShouldAllowPerfectNegotiation) {
            peerConnectionInstance.enablePerfectNegotiation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$peerConnectionStateChangedToFailed$8(PeerConnectionInstance peerConnectionInstance) {
        scheduleAutoHangUp();
        this.mIceRestarter.notifyIceStateFailed(peerConnectionInstance);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reportError$17() {
        if (this.isError) {
            return;
        }
        this.isError = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$schedule$21(Runnable runnable) {
        if (!this.mIsClosing) {
            runnable.run();
            return;
        }
        String str = TAG;
        Log.w(str, "Closing! Executor in running phase, ignores task: " + runnable.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$scheduleAutoHangUp$23() {
        Call call = this.call;
        if (call != null) {
            call.terminate(CallEndCause.INACTIVE.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setLocalVideoFrameListener$11(LocalVideoFrameListener localVideoFrameListener) {
        this.localVideoFrameListener = localVideoFrameListener;
        ProxyLocalVideoSink proxyLocalVideoSink = this.localVideoSink;
        if (proxyLocalVideoSink != null) {
            proxyLocalVideoSink.setLocalVideoFrameListener(localVideoFrameListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setRemoteVideoFrameListener$12(RemoteVideoFrameListener remoteVideoFrameListener) {
        this.remoteVideoFrameListener = remoteVideoFrameListener;
        ProxyRemoteVideoSink proxyRemoteVideoSink = this.remoteVideoSink;
        if (proxyRemoteVideoSink != null) {
            proxyRemoteVideoSink.setRemoteVideoFrameListener(remoteVideoFrameListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateVideoTrackRenderer$19() {
        if (this.mRendererAdded || !this.connectionEstablished) {
            return;
        }
        updateVideoTrackerInternal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateVideoTrackerInternal$18() {
        this.callEventListener.onVideoTrackAdded(this.call, null);
    }

    private void onReceivedAnswer(final String str, final JsepMessage jsepMessage) {
        execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.g
            @Override // java.lang.Runnable
            public final void run() {
                DefaultPeerConnectionClient.this.lambda$onReceivedAnswer$14(str, jsepMessage);
            }
        });
    }

    private void onReceivedIceCandidate(final String str, final JsepMessage jsepMessage) {
        execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.c
            @Override // java.lang.Runnable
            public final void run() {
                DefaultPeerConnectionClient.this.lambda$onReceivedIceCandidate$16(str, jsepMessage);
            }
        });
    }

    private void onReceivedOffer(final JsepMessage jsepMessage) {
        execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.k
            @Override // java.lang.Runnable
            public final void run() {
                DefaultPeerConnectionClient.this.lambda$onReceivedOffer$15(jsepMessage);
            }
        });
    }

    private void onReceivedRelayIceCandidate(final JsepMessage jsepMessage) {
        execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.y
            @Override // java.lang.Runnable
            public final void run() {
                DefaultPeerConnectionClient.this.lambda$onReceivedRelayIceCandidate$13(jsepMessage);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processWebRtcStatsReports(RTCStatsReport rTCStatsReport) {
        StatsCollector.processWebRtcStatsReports(this.call, rTCStatsReport, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: reportClientEvent */
    public void lambda$reportClientEventOnExecutor$22(String str) {
        TimeService timeService = this.timeService;
        long now = timeService != null ? timeService.now() : System.currentTimeMillis();
        Call call = this.call;
        if (call != null) {
            call.reportClientEvent(str, now);
        }
    }

    private void reportClientEventOnExecutor(final String str) {
        execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.f
            @Override // java.lang.Runnable
            public final void run() {
                DefaultPeerConnectionClient.this.lambda$reportClientEventOnExecutor$22(str);
            }
        });
    }

    private void scheduleAutoHangUp() {
        Log.d(TAG, "Scheduling automatic hang up after 300000MS");
        cancelAutoHangUp();
        this.autoHangUpFuture = schedule(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.q
            @Override // java.lang.Runnable
            public final void run() {
                DefaultPeerConnectionClient.this.lambda$scheduleAutoHangUp$23();
            }
        }, 300000L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: switchCameraInternal */
    public void lambda$switchCamera$10() {
        if (!(this.videoCapturer instanceof CameraVideoCapturer)) {
            Log.d(TAG, "Will not switch camera, video capturer is not a camera");
        } else if (this.videoCallEnabled && !this.isError) {
            Log.d(TAG, "Switch camera");
            ((CameraVideoCapturer) this.videoCapturer).switchCamera(null);
        } else {
            String str = TAG;
            Log.e(str, "Failed to switch camera. Video: " + this.videoCallEnabled + ". Error : " + this.isError);
        }
    }

    private void updateVideoTrackerInternal() {
        if (getCurrentPeerConnectionInstance().getRemoteVideoTrack() != null) {
            this.remoteVideoSink.setSink(this.videoController.getRemoteRenderer());
            this.remoteVideoSink.setRemoteVideoFrameListener(this.videoController.getRemoteVideoFrameListener());
            getCurrentPeerConnectionInstance().getRemoteVideoTrack().addSink(this.remoteVideoSink);
            this.callbackHandler.post(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.h
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultPeerConnectionClient.this.lambda$updateVideoTrackerInternal$18();
                }
            });
            this.mRendererAdded = true;
        }
    }

    @Override // com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionClientInterface
    public void close() {
        execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.m
            @Override // java.lang.Runnable
            public final void run() {
                DefaultPeerConnectionClient.this.lambda$close$1();
            }
        });
    }

    @Override // com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionClientInterface
    public void enableMedia(final boolean z7, final boolean z8, final boolean z9, final boolean z10) {
        execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.w
            @Override // java.lang.Runnable
            public final void run() {
                DefaultPeerConnectionClient.this.lambda$enableMedia$6(z7, z8, z9, z10);
            }
        });
    }

    @Override // com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionClientInterface
    public void enableStatsEvents(boolean z7, int i8) {
        this.enableStatsEvents = z7;
        if (z7) {
            this.statsTimerBurstCount = 0;
        }
        if (i8 == 0) {
            i8 = STATS_PERIOD_MS;
        }
        this.statsPeriodMs = i8;
        if (this.connectionEstablished) {
            enableStatsEventsInternal(2000);
        }
    }

    @Override // com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionClientInterface
    public void enableVideoTrack(boolean z7) {
        String str = TAG;
        Log.d(str, "enableVideoTrack = " + z7);
        if (this.videoCapturer != null) {
            if (z7 && ContextCompat.checkSelfPermission(this.context, "android.permission.CAMERA") == 0) {
                VideoCapturer videoCapturer = this.videoCapturer;
                PeerConnectionParameters peerConnectionParameters = this.peerConnectionParameters;
                videoCapturer.startCapture(peerConnectionParameters.videoWidth, peerConnectionParameters.videoHeight, peerConnectionParameters.videoFps);
                return;
            }
            try {
                this.videoCapturer.stopCapture();
            } catch (InterruptedException e8) {
                e8.printStackTrace();
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull final Runnable runnable) {
        synchronized (this) {
            if (this.mIsClosing) {
                String str = TAG;
                Log.w(str, "Closing! Executor in scheduling phase, ignores task: " + runnable.toString());
            } else {
                this.mExecutor.execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        DefaultPeerConnectionClient.this.lambda$execute$20(runnable);
                    }
                });
            }
        }
    }

    public PeerConnectionInstance getCurrentPeerConnectionInstance() {
        return getPeerConnectionInstance(this.currentRemoteInstanceId);
    }

    public boolean getEnableRemoteAudio() {
        return this.mEnableRemoteAudio;
    }

    public boolean getEnableRemoteVideo() {
        return this.mEnableRemoteVideo;
    }

    public List<WebRtcIceServer> getIceServers() {
        return this.mIceServers;
    }

    public RtcCertificatePem getPeerConnectionCertificate() {
        return this.mPeerConnectionsCertificate;
    }

    public WebRtcCallConfiguration getWebRtcCallConfiguration() {
        return this.mWebRtcCallConfiguration;
    }

    @Override // com.sinch.android.rtc.internal.client.calling.PeerConnection.StatsCollector.StatsFeedback
    public void onConnectionInfo(final ConnectionInfo connectionInfo) {
        execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.i
            @Override // java.lang.Runnable
            public final void run() {
                DefaultPeerConnectionClient.this.lambda$onConnectionInfo$3(connectionInfo);
            }
        });
    }

    @Override // com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionClientInterface
    public void onJsepMessageReceive(String str, JsepMessage jsepMessage) {
        String str2 = TAG;
        Log.d(str2, "onJsepMessageReceive: " + jsepMessage + " type: " + jsepMessage.getType() + ", payload: " + jsepMessage.getPayload());
        if (this.remoteInstanceResolved && !str.equals(this.currentRemoteInstanceId)) {
            Log.d(str2, "onJsepMessageReceive: discarding message (from instance: " + str + ") while the session is already established for the remote instance: " + this.currentRemoteInstanceId);
            return;
        }
        int i8 = AnonymousClass2.$SwitchMap$com$sinch$android$rtc$internal$client$calling$JsepMessage$Type[jsepMessage.getType().ordinal()];
        if (i8 == 1) {
            onReceivedAnswer(str, jsepMessage);
        } else if (i8 == 2) {
            onReceivedOffer(jsepMessage);
        } else if (i8 == 4) {
            onReceivedIceCandidate(str, jsepMessage);
        } else if (i8 != 5) {
        } else {
            onReceivedRelayIceCandidate(jsepMessage);
        }
    }

    @Override // com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionClientInterface
    public void onRemoteInstanceIdResolved(final String str) {
        execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.u
            @Override // java.lang.Runnable
            public final void run() {
                DefaultPeerConnectionClient.this.lambda$onRemoteInstanceIdResolved$5(str);
            }
        });
    }

    @Override // com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionClientInterface
    public void onRemotePeerCapabilitiesChange(String str, List<String> list) {
        PeerConnectionInstance peerConnectionInstance = getPeerConnectionInstance(str);
        if (peerConnectionInstance == null) {
            peerConnectionInstance = getCurrentPeerConnectionInstance();
        }
        if (peerConnectionInstance != null) {
            for (String str2 : list) {
                if (str2.startsWith(InternalCapability.ICE_RESTART.toString()) && getWebRtcCallConfiguration().getUseTurn()) {
                    this.mIceRestarter.enable();
                    this.mShouldAllowPerfectNegotiation = true;
                }
            }
        }
    }

    @Override // com.sinch.android.rtc.internal.client.calling.PeerConnection.StatsCollector.StatsFeedback
    public void onStatisticReport(final StatsReport[] statsReportArr) {
        execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.p
            @Override // java.lang.Runnable
            public final void run() {
                DefaultPeerConnectionClient.this.lambda$onStatisticReport$4(statsReportArr);
            }
        });
    }

    public void peerConnectionDiscardedCollidingOffer(PeerConnectionInstance peerConnectionInstance) {
        reportClientEventOnExecutor("WEBRTC_COLLIDING_OFFER_DISCARDED");
    }

    public void peerConnectionRestartedIce(PeerConnectionInstance peerConnectionInstance) {
        reportClientEventOnExecutor("WEBRTC_ICE_RESTARTED");
    }

    public void peerConnectionStateChangedToCompleted(PeerConnectionInstance peerConnectionInstance) {
        reportClientEventOnExecutor("WEBRTC_ICE_CONNECTION_COMPLETED");
    }

    public void peerConnectionStateChangedToConnected(final PeerConnectionInstance peerConnectionInstance) {
        reportClientEventOnExecutor("WEBRTC_ICE_CONNECTION_CONNECTED");
        execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.x
            @Override // java.lang.Runnable
            public final void run() {
                DefaultPeerConnectionClient.this.lambda$peerConnectionStateChangedToConnected$7(peerConnectionInstance);
            }
        });
    }

    public void peerConnectionStateChangedToFailed(final PeerConnectionInstance peerConnectionInstance) {
        reportClientEventOnExecutor("WEBRTC_ICE_CONNECTION_FAILED");
        execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.d
            @Override // java.lang.Runnable
            public final void run() {
                DefaultPeerConnectionClient.this.lambda$peerConnectionStateChangedToFailed$8(peerConnectionInstance);
            }
        });
    }

    public void reportError(String str) {
        String str2 = TAG;
        Log.e(str2, "Peerconnection error: " + str);
        execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.e
            @Override // java.lang.Runnable
            public final void run() {
                DefaultPeerConnectionClient.this.lambda$reportError$17();
            }
        });
    }

    @Override // com.sinch.android.rtc.internal.client.ScheduledExecutor
    public ScheduledFuture<?> schedule(final Runnable runnable, long j8, TimeUnit timeUnit) {
        synchronized (this) {
            if (!this.mIsClosing) {
                return this.mExecutor.schedule(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        DefaultPeerConnectionClient.this.lambda$schedule$21(runnable);
                    }
                }, j8, timeUnit);
            }
            String str = TAG;
            Log.w(str, "Closing! Executor in scheduling phase, ignores task: " + runnable.toString());
            return null;
        }
    }

    @Override // com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionClientInterface
    public void sendDtmf(String str) {
        for (RtpSender rtpSender : getCurrentPeerConnectionInstance().peerConnection.getSenders()) {
            if (rtpSender.dtmf().canInsertDtmf()) {
                rtpSender.dtmf().insertDtmf(str, 200, 200);
                return;
            }
        }
    }

    @Override // com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionClientInterface
    public void setBandwidthLimits(int i8, int i9) {
        this.maxAudioBandwidth = Math.max(0, Math.min(i8, this.backEndLimitedMaxAudioBandwidh));
        this.maxVideoBandwidth = Math.max(0, Math.min(i9, this.backEndLimitedMaxVideoBandwidh));
        String str = TAG;
        Log.d(str, "Setting audio bitrate to " + this.maxAudioBandwidth + " kbps");
        Log.d(str, "Setting video bitrate to " + this.maxVideoBandwidth + " kbps");
    }

    @Override // com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionClientInterface
    public void setCommunicationMode(boolean z7) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Setting  AudioManager mode to ");
        sb.append(z7 ? "MODE_IN_COMMUNICATION" : "MODE_NORMAL");
        Log.d(str, sb.toString());
        CallQualitySettings callQualitySettings = this.callQualitySettings;
        if (callQualitySettings != null) {
            callQualitySettings.setCommunicationMode(z7);
        } else {
            Log.e(str, "setCommunicationMode failed!");
        }
    }

    @Override // com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionClientInterface
    public void setLocalVideoFrameListener(final LocalVideoFrameListener localVideoFrameListener) {
        execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.r
            @Override // java.lang.Runnable
            public final void run() {
                DefaultPeerConnectionClient.this.lambda$setLocalVideoFrameListener$11(localVideoFrameListener);
            }
        });
    }

    @Override // com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionClientInterface
    public void setRemoteVideoFrameListener(final RemoteVideoFrameListener remoteVideoFrameListener) {
        execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.n
            @Override // java.lang.Runnable
            public final void run() {
                DefaultPeerConnectionClient.this.lambda$setRemoteVideoFrameListener$12(remoteVideoFrameListener);
            }
        });
    }

    @Override // com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionClientInterface
    public void setTorchMode(boolean z7) {
        if (this.videoCapturer instanceof CameraVideoCapturer) {
            if (this.videoCallEnabled && !this.isError) {
                String str = TAG;
                Log.d(str, "Set torch mode to " + z7);
                ((CameraVideoCapturer) this.videoCapturer).setTorchMode(z7);
                return;
            }
            String str2 = TAG;
            Log.e(str2, "Failed to set torch mode. Video: " + this.videoCallEnabled + ". Error : " + this.isError);
        }
    }

    @Override // com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionClientInterface
    public void switchCamera() {
        execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.s
            @Override // java.lang.Runnable
            public final void run() {
                DefaultPeerConnectionClient.this.lambda$switchCamera$10();
            }
        });
    }

    public void updateVideoTrackRenderer() {
        execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.calling.PeerConnection.z
            @Override // java.lang.Runnable
            public final void run() {
                DefaultPeerConnectionClient.this.lambda$updateVideoTrackRenderer$19();
            }
        });
    }
}
