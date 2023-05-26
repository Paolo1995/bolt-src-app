package com.sinch.android.rtc.internal.client;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import com.sinch.android.rtc.AudioController;
import com.sinch.android.rtc.ClientRegistration;
import com.sinch.android.rtc.MissingPermissionException;
import com.sinch.android.rtc.PushConfiguration;
import com.sinch.android.rtc.PushTokenRegistrationCallback;
import com.sinch.android.rtc.PushTokenUnregistrationCallback;
import com.sinch.android.rtc.SinchClient;
import com.sinch.android.rtc.SinchClientListener;
import com.sinch.android.rtc.SinchError;
import com.sinch.android.rtc.SinchPush;
import com.sinch.android.rtc.UserController;
import com.sinch.android.rtc.UserRegistrationCallback;
import com.sinch.android.rtc.calling.CallController;
import com.sinch.android.rtc.calling.CallNotificationResult;
import com.sinch.android.rtc.internal.CallbackHandler;
import com.sinch.android.rtc.internal.DefaultUserControllerBuilder;
import com.sinch.android.rtc.internal.RuntimeResources;
import com.sinch.android.rtc.internal.SinchClientPrivate;
import com.sinch.android.rtc.internal.client.audio.Android12SpeakerController;
import com.sinch.android.rtc.internal.client.audio.PreAndroid12SpeakerController;
import com.sinch.android.rtc.internal.client.calling.DefaultCallController;
import com.sinch.android.rtc.internal.client.calling.PeerConnection.DefaultPeerConnectionFactoryProvider;
import com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionFactoryProvider;
import com.sinch.android.rtc.internal.client.libloader.NativeLibLoader;
import com.sinch.android.rtc.internal.client.video.DefaultVideoController;
import com.sinch.android.rtc.internal.client.video.VideoControllerInternal;
import com.sinch.android.rtc.internal.natives.LogLevel;
import com.sinch.android.rtc.internal.natives.UserAgentEventListener;
import com.sinch.android.rtc.internal.natives.UserAgentState;
import com.sinch.android.rtc.internal.natives.jni.DefaultUserAgent;
import com.sinch.android.rtc.internal.natives.jni.DefaultUserController;
import com.sinch.android.rtc.internal.natives.jni.SinchRebrtcRevision;
import com.sinch.android.rtc.internal.natives.jni.UserAgent;
import com.sinch.android.rtc.internal.service.dispatcher.DefaultDispatcher;
import com.sinch.android.rtc.internal.service.dispatcher.Dispatcher;
import com.sinch.android.rtc.internal.service.http.HttpClientInterface;
import com.sinch.android.rtc.internal.service.http.HttpService;
import com.sinch.android.rtc.internal.service.http.SinchHttpServiceObserver;
import com.sinch.android.rtc.internal.service.pubnub.PublishSubscribeClient;
import com.sinch.android.rtc.internal.service.serviceprovider.DefaultServiceProvider;
import com.sinch.android.rtc.internal.service.time.TimeService;
import com.sinch.android.rtc.video.VideoController;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import org.webrtc.Logging;
import org.webrtc.sinch.AudioDeviceUtil;

/* loaded from: classes3.dex */
public class DefaultSinchClient implements SinchClient, UserAgentEventListener, ConnectivityListenerCallback, SinchLogger, SinchClientStatusProvider, SinchClientPrivate, SinchHttpServiceObserver, RuntimeResources {
    private static final int DEFAULT_DO_HOUSE_KEEPING_DELAY = 2000;
    private static final int DEFAULT_REFRESH_CONFIG_DELAY = 43200000;
    public static final int GRACEFUL_TIMEOUT = 5000;
    public static final String PAYLOAD_TAG_DISPLAYNAME = "name";
    public static final String PAYLOAD_TAG_MXP = "mxp";
    public static final String PAYLOAD_TAG_SINCH = "sinch";
    private static final String TAG = SinchClient.class.getSimpleName();
    private static final int UNSPECIFIED_PUSH_PROFILE_REQUEST_ID = 0;
    private String mApplicationKey;
    private AudioControllerInternal mAudioController;
    private DefaultCallController mCallClient;
    private CallbackHandler mCallbackHandler;
    private ConfigRefresher mConfigRefresher;
    private ConnectivityListener mConnectivityListener;
    private Context mContext;
    private final String mDeviceId;
    private DeviceInformation mDeviceInformation;
    private DefaultDispatcher mDispatcher;
    private String mEnvironmentHost;
    private HouseKeeper mHouseKeeper;
    private HttpClientInterface mHttpClient;
    private HttpService mHttpService;
    private SinchHttpServiceObserver mHttpServiceObserver;
    private boolean mOnClientFailedSent;
    private PeerConnectionFactoryProvider mPeerConnectionFactoryProvider;
    private String mPersistenceServiceDatabasePath;
    private final PublishSubscribeClient mPubsubClient;
    private DefaultServiceProvider mServiceProvider;
    private int mStatsCollectingPeriosMs;
    private TimeService mTimeService;
    private UserAgent mUserAgent;
    private UserController mUserController;
    private final String mUserId;
    private VideoControllerInternal mVideoController;
    private WorkerThread mWorkerThread;
    private CopyOnWriteArraySet<SinchClientListener> mSinchClientListeners = new CopyOnWriteArraySet<>();
    private boolean mShouldStartListeningOnActiveConnection = false;
    private boolean mDisposed = false;
    private boolean mStarting = false;
    private boolean mManagedPushEnabled = false;
    private List<Runnable> mPendingActions = new ArrayList();
    private boolean mSendExtendedSessionReport = false;
    private boolean mUseRelayIceCandidatesOnly = false;

    /* loaded from: classes3.dex */
    public static class Environment {
        public String host;
        public boolean useSsl;

        public Environment(String str, boolean z7) {
            this.host = str;
            this.useSsl = z7;
        }
    }

    public DefaultSinchClient(Context context, ServiceFactory serviceFactory, String str, String str2, String str3, String str4, PushConfiguration pushConfiguration, ConnectivityListener connectivityListener, String str5, VideoControllerInternal videoControllerInternal, CallbackHandler callbackHandler, boolean z7, String str6, int i8) {
        boolean z8;
        this.mPeerConnectionFactoryProvider = null;
        if (str2 == null || str2.length() == 0) {
            throw new IllegalArgumentException("userId is empty");
        }
        if (str4 == null || str4.length() == 0) {
            throw new IllegalArgumentException("applicationKey is empty");
        }
        if (str3 == null || str3.length() == 0) {
            throw new IllegalArgumentException("environmentHost is empty");
        }
        if (str5 == null || str5.length() == 0) {
            throw new IllegalArgumentException("persistenceServiceDatabasePath is null, or empty");
        }
        this.mApplicationKey = str4;
        this.mEnvironmentHost = str3;
        this.mPersistenceServiceDatabasePath = str5;
        NativeLibLoader.loadAllRequiredLibraries(context.getApplicationContext());
        String str7 = TAG;
        Log.i(str7, "RebRTC revision:" + SinchRebrtcRevision.getRebrtcRevision());
        this.mStatsCollectingPeriosMs = i8;
        this.mCallbackHandler = callbackHandler;
        this.mContext = context.getApplicationContext();
        this.mUserId = str2;
        this.mDeviceId = str;
        this.mConnectivityListener = connectivityListener;
        connectivityListener.setCallback(this);
        this.mTimeService = serviceFactory.mTimeService;
        this.mDispatcher = serviceFactory.createDefaultDispatcher();
        this.mWorkerThread = serviceFactory.createWorkerThread();
        HttpClientInterface createHttpClient = serviceFactory.createHttpClient();
        this.mHttpClient = createHttpClient;
        this.mHttpService = serviceFactory.createDefaultHttpService(createHttpClient);
        PublishSubscribeClient createPublishSubscribeClient = serviceFactory.createPublishSubscribeClient(this.mWorkerThread, this.mHttpClient);
        this.mPubsubClient = createPublishSubscribeClient;
        this.mDeviceInformation = new DeviceInformation(str);
        this.mServiceProvider = new DefaultServiceProvider(this.mDispatcher, this.mHttpService, createPublishSubscribeClient);
        Environment environment = getEnvironment(str3);
        UserAgent createUserAgent = serviceFactory.createUserAgent(this.mServiceProvider.getNativeServiceProvider(), str4, str2, environment.host, environment.useSsl, str5, this.mDeviceInformation);
        this.mUserAgent = createUserAgent;
        createUserAgent.setEventListener(this);
        this.mHouseKeeper = new HouseKeeper(this.mDispatcher, this.mUserAgent);
        this.mConfigRefresher = new ConfigRefresher(this.mDispatcher, this.mUserAgent);
        this.mVideoController = videoControllerInternal;
        if (videoControllerInternal == null) {
            this.mVideoController = new DefaultVideoController(this.mContext, this);
        }
        this.mPeerConnectionFactoryProvider = DefaultPeerConnectionFactoryProvider.createDefaultPeerConnectionFactoryWrapper(this.mContext, z7);
        this.mCallClient = new DefaultCallController(this, this, this.mTimeService, serviceFactory.createAndroidAppStateService(context), this.mUserAgent.getCallClient(), this.mContext, this.mCallbackHandler, this.mPeerConnectionFactoryProvider, this.mUserAgent.getJsepMessageChannel(), this.mSendExtendedSessionReport, this.mStatsCollectingPeriosMs, this.mUseRelayIceCandidatesOnly, pushConfiguration != null);
        Context context2 = this.mContext;
        ConnectivityListener connectivityListener2 = this.mConnectivityListener;
        context2.registerReceiver(connectivityListener2, connectivityListener2.createIntentFilter());
        this.mUserController = createUserController(pushConfiguration);
        if (pushConfiguration != null) {
            z8 = true;
            setSupportManagedPushInternal(true);
        } else {
            z8 = true;
        }
        toggleCapability(InternalCapability.PUSH, z8);
        if (!this.mManagedPushEnabled || str6 == null) {
            return;
        }
        this.mUserAgent.setPushNotificationDisplayName(str6);
    }

    private void createAudioController() {
        this.mAudioController = new DefaultAudioController(this.mContext, this, Build.VERSION.SDK_INT >= 31 ? new Android12SpeakerController(this.mContext) : new PreAndroid12SpeakerController(this.mContext));
    }

    private UserController createUserController(PushConfiguration pushConfiguration) {
        return ((DefaultUserControllerBuilder) new DefaultUserControllerBuilder().userId(this.mUserId).applicationKey(this.mApplicationKey).environmentHost(this.mEnvironmentHost).pushConfiguration(pushConfiguration)).buildWithResources(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: finalCleanUp */
    public void lambda$shutdown$1() {
        this.mHttpServiceObserver = null;
        HttpClientInterface httpClientInterface = this.mHttpClient;
        if (httpClientInterface != null) {
            httpClientInterface.cancelAllRequests();
            this.mHttpClient = null;
        }
        this.mPeerConnectionFactoryProvider.dispose();
        this.mCallbackHandler = null;
        this.mPubsubClient.stopPubSubClient();
        this.mWorkerThread.stopThread();
        this.mWorkerThread = null;
        this.mDispatcher.stop();
        this.mDispatcher = null;
        this.mUserAgent.dispose();
        UserAgent userAgent = this.mUserAgent;
        if (userAgent instanceof DefaultUserAgent) {
            ((DefaultUserAgent) userAgent).invalidate();
        }
        this.mUserAgent = null;
        this.mContext = null;
        this.mConnectivityListener = null;
        this.mServiceProvider.dispose();
        this.mServiceProvider = null;
        UserController userController = this.mUserController;
        if (userController instanceof DefaultUserController) {
            ((DefaultUserController) userController).disposeManagedPush();
            ((DefaultUserController) this.mUserController).invalidate();
        }
        HttpService httpService = this.mHttpService;
        if (httpService != null) {
            httpService.setObserver(null);
            this.mHttpService.cancelAllRequests();
        }
        this.mHttpService = null;
        Iterator<SinchClientListener> it = this.mSinchClientListeners.iterator();
        while (it.hasNext()) {
            SinchClientListener next = it.next();
            if (next instanceof SinchClientListenerInternal) {
                ((SinchClientListenerInternal) next).onClientStopped(this);
            }
        }
    }

    public static Environment getEnvironment(String str) {
        if (str.startsWith("https://") || str.startsWith("http://")) {
            try {
                URL url = new URL(str);
                int port = url.getPort();
                if ("http".equals(url.getProtocol())) {
                    if (port > 0) {
                        return new Environment(url.getHost() + ":" + url.getPort(), false);
                    }
                    return new Environment(url.getHost(), false);
                } else if (port > 0) {
                    return new Environment(url.getHost() + ":" + url.getPort(), true);
                } else {
                    return new Environment(url.getHost(), true);
                }
            } catch (MalformedURLException unused) {
                return new Environment(str, true);
            }
        }
        return new Environment(str, true);
    }

    private boolean isCapabilityEnabled(InternalCapability internalCapability) {
        return this.mUserAgent.isCapabilityEnabled(internalCapability.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onHttpRequestSent$0(String str, String str2, byte[] bArr) {
        SinchHttpServiceObserver sinchHttpServiceObserver = this.mHttpServiceObserver;
        if (sinchHttpServiceObserver != null) {
            sinchHttpServiceObserver.onHttpRequestSent(str, str2, bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$relayRemotePushNotification$2(CallNotificationResult callNotificationResult) {
        this.mCallClient.handleCallPushPayload(callNotificationResult);
    }

    private void registerUserAndPushProfile() {
        this.mUserController.registerUser(new UserRegistrationCallback() { // from class: com.sinch.android.rtc.internal.client.DefaultSinchClient.1
            @Override // com.sinch.android.rtc.UserRegistrationCallback
            public void onCredentialsRequired(ClientRegistration clientRegistration) {
                Iterator it = DefaultSinchClient.this.mSinchClientListeners.iterator();
                while (it.hasNext()) {
                    ((SinchClientListener) it.next()).onCredentialsRequired(clientRegistration);
                }
            }

            @Override // com.sinch.android.rtc.UserRegistrationCallback
            public void onUserRegistered() {
                Log.d(DefaultSinchClient.TAG, "User registered.");
                Iterator it = DefaultSinchClient.this.mSinchClientListeners.iterator();
                while (it.hasNext()) {
                    ((SinchClientListener) it.next()).onUserRegistered();
                }
                if (DefaultSinchClient.this.mManagedPushEnabled) {
                    return;
                }
                DefaultSinchClient.this.startInternal();
            }

            @Override // com.sinch.android.rtc.UserRegistrationCallback
            public void onUserRegistrationFailed(SinchError sinchError) {
                Log.d(DefaultSinchClient.TAG, "User registration failed.");
                Iterator it = DefaultSinchClient.this.mSinchClientListeners.iterator();
                while (it.hasNext()) {
                    ((SinchClientListener) it.next()).onUserRegistrationFailed(sinchError);
                }
                DefaultSinchClient.this.sendOnFailedToAllListeners(sinchError);
            }
        }, new PushTokenRegistrationCallback() { // from class: com.sinch.android.rtc.internal.client.DefaultSinchClient.2
            @Override // com.sinch.android.rtc.PushTokenRegistrationCallback
            public void onPushTokenRegistered() {
                Log.d(DefaultSinchClient.TAG, "Push token registered.");
                Iterator it = DefaultSinchClient.this.mSinchClientListeners.iterator();
                while (it.hasNext()) {
                    ((SinchClientListener) it.next()).onPushTokenRegistered();
                }
                DefaultSinchClient.this.startInternal();
            }

            @Override // com.sinch.android.rtc.PushTokenRegistrationCallback
            public void onPushTokenRegistrationFailed(SinchError sinchError) {
                Log.d(DefaultSinchClient.TAG, "Push token registration failed.");
                Iterator it = DefaultSinchClient.this.mSinchClientListeners.iterator();
                while (it.hasNext()) {
                    ((SinchClientListener) it.next()).onPushTokenRegistrationFailed(sinchError);
                }
                DefaultSinchClient.this.sendOnFailedToAllListeners(sinchError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendOnFailedToAllListeners(SinchError sinchError) {
        if (this.mOnClientFailedSent) {
            w(TAG, "Skipping sending onClientFailed() since it's already been sent.");
            return;
        }
        this.mOnClientFailedSent = true;
        Iterator<SinchClientListener> it = this.mSinchClientListeners.iterator();
        while (it.hasNext()) {
            it.next().onClientFailed(this, sinchError);
        }
    }

    private void setSupportManagedPushInternal(boolean z7) {
        throwIfStarted();
        this.mManagedPushEnabled = z7;
        if (z7) {
            this.mUserAgent.setUseManagedPush(true);
        }
    }

    private void startIfNeeded() {
        if (isStarted() || this.mUserAgent.getState() == UserAgentState.STARTING || this.mStarting) {
            return;
        }
        start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startInternal() {
        if (isDisposed()) {
            Log.e(TAG, "SinchClient stopped between Start() and startInternal() , further calls will throw Exceptions.");
            return;
        }
        if (this.mVideoController == null) {
            this.mVideoController = new DefaultVideoController(this.mContext, this);
        }
        DefaultCallController defaultCallController = this.mCallClient;
        if (defaultCallController != null) {
            defaultCallController.setVideoTrackController(this.mVideoController);
        }
        this.mUserAgent.start();
        this.mHouseKeeper.start(2000);
        this.mConfigRefresher.start(DEFAULT_REFRESH_CONFIG_DELAY);
    }

    private void throwIfDisposed() {
        if (isDisposed()) {
            throw new IllegalStateException("SinchClient stopped, further calls will throw Exceptions.");
        }
    }

    private void throwIfStarted() {
        throwIfDisposed();
        if (isStarted()) {
            throw new IllegalStateException("SinchClient already started, you may not perform this action.");
        }
    }

    private void throwUnlessStarted() {
        throwIfDisposed();
        if (!isStarted()) {
            throw new IllegalStateException("SinchClient not started.");
        }
    }

    private void toggleCapability(InternalCapability internalCapability, boolean z7) {
        if (z7) {
            this.mUserAgent.enableCapability(internalCapability.toString());
        } else {
            this.mUserAgent.disableCapability(internalCapability.toString());
        }
    }

    @Override // com.sinch.android.rtc.SinchClient
    public void addSinchClientListener(SinchClientListener sinchClientListener) {
        this.mSinchClientListeners.add(sinchClientListener);
    }

    @Override // com.sinch.android.rtc.SinchClient
    public void checkManifest() {
        throwIfDisposed();
        if (this.mContext.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
            throw new MissingPermissionException("android.permission.INTERNET");
        }
        if (this.mContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            throw new MissingPermissionException("android.permission.ACCESS_NETWORK_STATE");
        }
        if (this.mContext.checkCallingOrSelfPermission("android.permission.RECORD_AUDIO") != 0) {
            throw new MissingPermissionException("android.permission.RECORD_AUDIO");
        }
        if (this.mContext.checkCallingOrSelfPermission("android.permission.MODIFY_AUDIO_SETTINGS") != 0) {
            throw new MissingPermissionException("android.permission.MODIFY_AUDIO_SETTINGS");
        }
        if (this.mCallClient.isRespectNativeCalls() && this.mContext.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            throw new MissingPermissionException("android.permission.READ_PHONE_STATE");
        }
    }

    @Override // com.sinch.android.rtc.internal.client.SinchLogger
    public void d(String str, String str2) {
        notifyLog(3, str, str2);
    }

    @Override // com.sinch.android.rtc.internal.client.SinchLogger
    public void e(String str, String str2) {
        notifyLog(6, str, str2);
    }

    @Override // com.sinch.android.rtc.SinchClient
    public AudioController getAudioController() {
        throwUnlessStarted();
        if (this.mAudioController == null) {
            createAudioController();
        }
        return this.mAudioController;
    }

    @Override // com.sinch.android.rtc.SinchClient
    public CallController getCallController() {
        throwIfDisposed();
        return this.mCallClient;
    }

    @Override // com.sinch.android.rtc.internal.RuntimeResources
    public CallbackHandler getCallbackHandler() {
        return this.mCallbackHandler;
    }

    @Override // com.sinch.android.rtc.internal.RuntimeResources
    public Context getContext() {
        return this.mContext;
    }

    @Override // com.sinch.android.rtc.internal.RuntimeResources
    public String getDeviceId() {
        return this.mDeviceInformation.deviceId;
    }

    @Override // com.sinch.android.rtc.internal.RuntimeResources
    public Dispatcher getDispatcher() {
        return this.mDispatcher;
    }

    @Override // com.sinch.android.rtc.internal.RuntimeResources
    public HttpService getHttpService() {
        return this.mHttpService;
    }

    @Override // com.sinch.android.rtc.SinchClient
    public String getLocalUserId() {
        return this.mUserId;
    }

    @Override // com.sinch.android.rtc.internal.RuntimeResources
    public String getPersistenceServiceDatabasePath() {
        return this.mPersistenceServiceDatabasePath;
    }

    @Override // com.sinch.android.rtc.internal.RuntimeResources
    public TimeService getTimeService() {
        return this.mTimeService;
    }

    @Override // com.sinch.android.rtc.SinchClient
    public VideoController getVideoController() {
        if (this.mVideoController == null) {
            this.mVideoController = new DefaultVideoController(this.mContext, this);
        }
        return this.mVideoController;
    }

    @Override // com.sinch.android.rtc.internal.client.SinchLogger
    public void i(String str, String str2) {
        notifyLog(4, str, str2);
    }

    @Override // com.sinch.android.rtc.internal.client.SinchClientStatusProvider
    public boolean isDisposed() {
        return this.mDisposed;
    }

    @Override // com.sinch.android.rtc.SinchClient, com.sinch.android.rtc.internal.client.SinchClientStatusProvider
    public boolean isStarted() {
        UserAgent userAgent = this.mUserAgent;
        return userAgent != null && userAgent.isStarted();
    }

    @Override // com.sinch.android.rtc.internal.natives.UserAgentEventListener
    public void log(int i8, String str, String str2) {
        notifyLog(LogLevel.nativeToAndroid(i8), str, str2);
    }

    public void notifyLog(int i8, String str, String str2) {
        Iterator<SinchClientListener> it = this.mSinchClientListeners.iterator();
        while (it.hasNext()) {
            it.next().onLogMessage(i8, str, str2);
        }
    }

    @Override // com.sinch.android.rtc.internal.natives.UserAgentEventListener
    public void onAudioFeaturesChanged(int i8, int i9, boolean z7) {
        AudioDeviceUtil.setAudioSource(i8);
        AudioDeviceUtil.setAudioMode(i9);
        AudioDeviceUtil.setOverrideAudioMode(z7);
    }

    @Override // com.sinch.android.rtc.internal.natives.UserAgentEventListener
    public void onConfigChanged(String str) {
        DefaultCallController defaultCallController = this.mCallClient;
        if (defaultCallController != null) {
            defaultCallController.setLegacyStunServers(this.mUserAgent.getLegacyStunServers());
        }
    }

    @Override // com.sinch.android.rtc.internal.natives.UserAgentEventListener
    public void onExtendedSessionReportFlag(boolean z7) {
        this.mSendExtendedSessionReport = z7;
        DefaultCallController defaultCallController = this.mCallClient;
        if (defaultCallController != null) {
            defaultCallController.setSendExtendedSessionReport(z7);
        }
    }

    @Override // com.sinch.android.rtc.internal.natives.UserAgentEventListener
    public void onFailed(UserAgent userAgent, SinchError sinchError) {
        sendOnFailedToAllListeners(sinchError);
    }

    @Override // com.sinch.android.rtc.internal.service.http.SinchHttpServiceObserver
    public void onHttpRequestSent(final String str, final String str2, final byte[] bArr) {
        this.mCallbackHandler.post(new Runnable() { // from class: com.sinch.android.rtc.internal.client.o
            @Override // java.lang.Runnable
            public final void run() {
                DefaultSinchClient.this.lambda$onHttpRequestSent$0(str, str2, bArr);
            }
        });
    }

    @Override // com.sinch.android.rtc.internal.natives.UserAgentEventListener
    public void onNewPushProfileRequired(String str) {
    }

    @Override // com.sinch.android.rtc.internal.natives.UserAgentEventListener
    public void onPushProfileRegistered(int i8) {
        d(TAG, "tokenRegistered()");
        Iterator<SinchClientListener> it = this.mSinchClientListeners.iterator();
        while (it.hasNext()) {
            it.next().onPushTokenRegistered();
        }
    }

    @Override // com.sinch.android.rtc.internal.natives.UserAgentEventListener
    public void onPushProfileRegistrationFailed(int i8, SinchError sinchError) {
        w(TAG, "tokenRegistrationFailed()");
        Iterator<SinchClientListener> it = this.mSinchClientListeners.iterator();
        while (it.hasNext()) {
            it.next().onPushTokenRegistrationFailed(sinchError);
        }
    }

    @Override // com.sinch.android.rtc.internal.natives.UserAgentEventListener
    public void onRegisterInstance(UserAgent userAgent, ClientRegistration clientRegistration) {
        Iterator<SinchClientListener> it = this.mSinchClientListeners.iterator();
        while (it.hasNext()) {
            it.next().onCredentialsRequired(clientRegistration);
        }
    }

    @Override // com.sinch.android.rtc.internal.natives.UserAgentEventListener
    public void onSDPSemanticChanged(boolean z7) {
        DefaultCallController defaultCallController = this.mCallClient;
        if (defaultCallController != null) {
            defaultCallController.setSdpSemantic(z7);
        }
    }

    @Override // com.sinch.android.rtc.internal.natives.UserAgentEventListener
    public void onStarted(UserAgent userAgent) {
        d(TAG, "onStarted()");
        for (Runnable runnable : this.mPendingActions) {
            runnable.run();
        }
        this.mPendingActions.clear();
        if (this.mShouldStartListeningOnActiveConnection) {
            startListeningOnActiveConnection();
            this.mShouldStartListeningOnActiveConnection = false;
        }
        Iterator<SinchClientListener> it = this.mSinchClientListeners.iterator();
        while (it.hasNext()) {
            it.next().onClientStarted(this);
        }
    }

    @Override // com.sinch.android.rtc.internal.natives.UserAgentEventListener
    public void onUseTurnChanged(boolean z7) {
        DefaultCallController defaultCallController = this.mCallClient;
        if (defaultCallController != null) {
            defaultCallController.setUseTurn(z7);
            this.mCallClient.setLegacyStunServers(this.mUserAgent.getLegacyStunServers());
        }
    }

    @Override // com.sinch.android.rtc.internal.SinchClientPrivate
    public void relayPlainPushPayload(String str) {
        relayRemotePushNotification(SinchPush.queryPushNotificationPayload(this.mContext, Collections.singletonMap(PAYLOAD_TAG_SINCH, str)));
    }

    @Override // com.sinch.android.rtc.SinchClient
    public void relayRemotePushNotification(@NonNull final CallNotificationResult callNotificationResult) throws IllegalArgumentException {
        if (callNotificationResult == null) {
            throw new IllegalArgumentException("Payload cannot be null");
        }
        throwIfDisposed();
        if (isStarted()) {
            this.mCallClient.setLegacyStunServers(this.mUserAgent.getLegacyStunServers());
            this.mCallClient.handleCallPushPayload(callNotificationResult);
            return;
        }
        this.mPendingActions.add(new Runnable() { // from class: com.sinch.android.rtc.internal.client.p
            @Override // java.lang.Runnable
            public final void run() {
                DefaultSinchClient.this.lambda$relayRemotePushNotification$2(callNotificationResult);
            }
        });
        startIfNeeded();
    }

    @Override // com.sinch.android.rtc.SinchClient
    public void removeSinchClientListener(SinchClientListener sinchClientListener) {
        this.mSinchClientListeners.remove(sinchClientListener);
    }

    @Override // com.sinch.android.rtc.internal.client.ConnectivityListenerCallback
    public void resendFailedRequests() {
        UserAgent userAgent = this.mUserAgent;
        if (userAgent == null || !userAgent.isStarted()) {
            return;
        }
        d(TAG, "Resending failed requests");
        this.mUserAgent.resendFailedRequests();
    }

    @Override // com.sinch.android.rtc.internal.SinchClientPrivate
    public void setHttpServiceObserver(SinchHttpServiceObserver sinchHttpServiceObserver) {
        if (sinchHttpServiceObserver == null) {
            this.mHttpService.setObserver(null);
            return;
        }
        this.mHttpService.setObserver(this);
        this.mHttpServiceObserver = sinchHttpServiceObserver;
    }

    public void setMinimumLogLevel(int i8) {
        throwIfDisposed();
        this.mUserAgent.setMinimumLogLevel(i8);
        Logging.enableLogToDebugOutput(i8 != 0 ? i8 != 1 ? i8 != 2 ? i8 != 3 ? Logging.Severity.LS_NONE : Logging.Severity.LS_ERROR : Logging.Severity.LS_WARNING : Logging.Severity.LS_INFO : Logging.Severity.LS_VERBOSE);
    }

    @Override // com.sinch.android.rtc.internal.SinchClientPrivate
    public void setSupportActiveConnection(boolean z7) {
        throwIfStarted();
        toggleCapability(InternalCapability.ONLINE, z7);
    }

    @Override // com.sinch.android.rtc.internal.SinchClientPrivate
    public void setUseRelayCandidatesOnly(boolean z7) {
        this.mUseRelayIceCandidatesOnly = z7;
        DefaultCallController defaultCallController = this.mCallClient;
        if (defaultCallController != null) {
            defaultCallController.setUseRelayCandidatesOnly(z7);
        }
    }

    public void shutdown(boolean z7) {
        throwIfDisposed();
        d(TAG, "terminate()");
        this.mDisposed = true;
        this.mConnectivityListener.dispose();
        this.mContext.unregisterReceiver(this.mConnectivityListener);
        VideoControllerInternal videoControllerInternal = this.mVideoController;
        if (videoControllerInternal != null) {
            videoControllerInternal.dispose();
            this.mVideoController = null;
        }
        AudioControllerInternal audioControllerInternal = this.mAudioController;
        if (audioControllerInternal != null) {
            audioControllerInternal.dispose();
            this.mAudioController = null;
        }
        this.mHouseKeeper.stop();
        this.mConfigRefresher.stop();
        UserAgent userAgent = this.mUserAgent;
        if (userAgent != null) {
            userAgent.stop();
            this.mUserAgent.setEventListener(null);
        }
        this.mHouseKeeper.dispose();
        this.mHouseKeeper = null;
        this.mConfigRefresher.dispose();
        this.mConfigRefresher = null;
        this.mCallClient.terminate();
        this.mCallClient = null;
        this.mPubsubClient.stopSubscribersAndHistory();
        if (z7) {
            this.mCallbackHandler.postDelayed(new Runnable() { // from class: com.sinch.android.rtc.internal.client.q
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultSinchClient.this.lambda$shutdown$1();
                }
            }, 5000);
        } else {
            lambda$shutdown$1();
        }
    }

    @Override // com.sinch.android.rtc.SinchClient
    public void start() {
        throwIfStarted();
        this.mStarting = true;
        this.mOnClientFailedSent = false;
        if (this.mUserAgent.getState() == UserAgentState.STARTING) {
            throw new IllegalStateException("SinchClient already starting");
        }
        registerUserAndPushProfile();
    }

    @Override // com.sinch.android.rtc.internal.SinchClientPrivate
    public void startListeningOnActiveConnection() {
        throwIfDisposed();
        UserAgent userAgent = this.mUserAgent;
        if (userAgent == null || !userAgent.isStarted()) {
            this.mShouldStartListeningOnActiveConnection = true;
            return;
        }
        d(TAG, "mUserAgent.startBroadcastListener()");
        this.mUserAgent.startBroadcastListener();
    }

    @Override // com.sinch.android.rtc.internal.SinchClientPrivate
    public void stopListeningOnActiveConnection() {
        throwIfDisposed();
        UserAgent userAgent = this.mUserAgent;
        if (userAgent == null || !userAgent.isStarted()) {
            this.mShouldStartListeningOnActiveConnection = false;
            return;
        }
        d(TAG, "mUserAgent.stopBroadcastListener()");
        this.mUserAgent.stopBroadcastListener();
    }

    public boolean supportsCapability(String str) {
        return this.mUserAgent.isCapabilityEnabled(str);
    }

    @Override // com.sinch.android.rtc.internal.SinchClientPrivate
    public void terminateForcefully() {
        shutdown(false);
    }

    @Override // com.sinch.android.rtc.SinchClient
    public void terminateGracefully() {
        shutdown(true);
    }

    @Override // com.sinch.android.rtc.SinchClient
    public void unregisterPushToken(PushTokenUnregistrationCallback pushTokenUnregistrationCallback) throws UnsupportedOperationException {
        if (!this.mManagedPushEnabled) {
            throw new UnsupportedOperationException("To unregister push token managed push functionality must be enabled");
        }
        this.mUserController.unregisterPushToken(pushTokenUnregistrationCallback);
    }

    @Override // com.sinch.android.rtc.internal.client.SinchLogger
    public void v(String str, String str2) {
        notifyLog(2, str, str2);
    }

    @Override // com.sinch.android.rtc.internal.client.SinchLogger
    public void w(String str, String str2) {
        notifyLog(5, str, str2);
    }
}
