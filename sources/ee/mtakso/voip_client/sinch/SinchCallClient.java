package ee.mtakso.voip_client.sinch;

import android.content.Context;
import android.os.Build;
import com.sinch.android.rtc.ClientRegistration;
import com.sinch.android.rtc.PushConfiguration;
import com.sinch.android.rtc.PushTokenRegistrationCallback;
import com.sinch.android.rtc.SinchClient;
import com.sinch.android.rtc.SinchClientListener;
import com.sinch.android.rtc.SinchError;
import com.sinch.android.rtc.SinchPush;
import com.sinch.android.rtc.UserController;
import com.sinch.android.rtc.UserRegistrationCallback;
import com.sinch.android.rtc.calling.Call;
import com.sinch.android.rtc.calling.CallController;
import com.sinch.android.rtc.calling.CallControllerListener;
import com.sinch.android.rtc.calling.CallDirection;
import com.sinch.android.rtc.calling.CallNotificationResult;
import com.sinch.android.rtc.calling.MediaConstraints;
import ee.mtakso.voip_client.VoipAudioDelegate;
import ee.mtakso.voip_client.VoipCall;
import ee.mtakso.voip_client.VoipClient;
import ee.mtakso.voip_client.VoipConnection;
import ee.mtakso.voip_client.VoipLogger;
import ee.mtakso.voip_client.VoipPeer;
import ee.mtakso.voip_client.VoipPushServiceType;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l1.a;
import l1.b;
import l1.c;

/* compiled from: SinchCallClient.kt */
/* loaded from: classes5.dex */
public final class SinchCallClient implements VoipClient, SinchCallDelegate {

    /* renamed from: s  reason: collision with root package name */
    public static final Companion f36558s = new Companion(null);

    /* renamed from: t  reason: collision with root package name */
    private static final MediaConstraints f36559t = new MediaConstraints(false);

    /* renamed from: a  reason: collision with root package name */
    private final Context f36560a;

    /* renamed from: b  reason: collision with root package name */
    private final String f36561b;

    /* renamed from: c  reason: collision with root package name */
    private final String f36562c;

    /* renamed from: d  reason: collision with root package name */
    private final String f36563d;

    /* renamed from: e  reason: collision with root package name */
    private final String f36564e;

    /* renamed from: f  reason: collision with root package name */
    private final VoipAudioDelegate f36565f;

    /* renamed from: g  reason: collision with root package name */
    private final VoipPushServiceType f36566g;

    /* renamed from: h  reason: collision with root package name */
    private final PushProfileData f36567h;

    /* renamed from: i  reason: collision with root package name */
    private final VoipLogger f36568i;

    /* renamed from: j  reason: collision with root package name */
    private Map<String, String> f36569j;

    /* renamed from: k  reason: collision with root package name */
    private final BehaviorSubject<VoipClient.StartStatus> f36570k;

    /* renamed from: l  reason: collision with root package name */
    private final BehaviorSubject<VoipCall> f36571l;

    /* renamed from: m  reason: collision with root package name */
    private final SinchClient f36572m;

    /* renamed from: n  reason: collision with root package name */
    private final CallController f36573n;

    /* renamed from: o  reason: collision with root package name */
    private final UserController f36574o;

    /* renamed from: p  reason: collision with root package name */
    private VoipCall f36575p;

    /* renamed from: q  reason: collision with root package name */
    private final InternalUserRegistrationListener f36576q;

    /* renamed from: r  reason: collision with root package name */
    private final InternalPushTokenRegistrationListener f36577r;

    /* compiled from: SinchCallClient.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SinchCallClient.kt */
    /* loaded from: classes5.dex */
    private final class InternalCallListener implements CallControllerListener {
        public InternalCallListener() {
        }

        @Override // com.sinch.android.rtc.calling.CallControllerListener
        public void onIncomingCall(CallController callController, Call call) {
            if (call == null) {
                return;
            }
            SinchCallClient.this.g().c("On new incoming call %s with headers: %s", call.getCallId(), call.getHeaders());
            SinchCallClient sinchCallClient = SinchCallClient.this;
            VoipConnection voipConnection = new VoipConnection(sinchCallClient.y(call, sinchCallClient.f36569j));
            String remoteUserId = call.getRemoteUserId();
            Intrinsics.e(remoteUserId, "call.remoteUserId");
            VoipCall b8 = SinchCall.f36545l.b(call, voipConnection, new VoipPeer(remoteUserId, voipConnection.a().get("displayName"), voipConnection.a().get("pictureUrl")), SinchCallClient.this);
            SinchCallClient.this.f36575p = b8;
            SinchCallClient.this.f36571l.onNext(b8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SinchCallClient.kt */
    /* loaded from: classes5.dex */
    public final class InternalClientListener implements SinchClientListener {
        public InternalClientListener() {
        }

        @Override // com.sinch.android.rtc.SinchClientListener
        public void onClientFailed(SinchClient sinchClient, SinchError sinchError) {
            Integer num;
            VoipLogger g8 = SinchCallClient.this.g();
            Object[] objArr = new Object[2];
            String str = null;
            if (sinchError != null) {
                num = Integer.valueOf(sinchError.getCode());
            } else {
                num = null;
            }
            objArr[0] = num;
            if (sinchError != null) {
                str = sinchError.getMessage();
            }
            objArr[1] = str;
            g8.d("client has failed with code: %s and message: %s", objArr);
            SinchCallClient.this.f36570k.onNext(VoipClient.StartStatus.FAILED);
        }

        @Override // com.sinch.android.rtc.SinchClientListener
        public void onClientStarted(SinchClient sinchClient) {
            SinchCallClient.this.g().c("Client has started", new Object[0]);
            SinchCallClient.this.A();
            SinchCallClient.this.f36570k.onNext(VoipClient.StartStatus.ON_STARTED);
        }

        @Override // com.sinch.android.rtc.UserRegistrationCallback
        public void onCredentialsRequired(ClientRegistration clientRegistration) {
            SinchCallClient.this.g().d("Credentials required when initializing SinchClient", new Object[0]);
            if (clientRegistration != null) {
                clientRegistration.register(SinchCallClient.this.f36564e);
            }
        }

        @Override // com.sinch.android.rtc.SinchClientListener
        public void onLogMessage(int i8, String str, String str2) {
            if (str2 == null) {
                return;
            }
            String b8 = SinchCallClient.this.g().b(str, str2);
            switch (i8) {
                case 2:
                case 3:
                case 4:
                case 5:
                    SinchCallClient.this.g().c(b8, new Object[0]);
                    return;
                case 6:
                case 7:
                    SinchCallClient.this.g().d(b8, new Object[0]);
                    return;
                default:
                    return;
            }
        }

        @Override // com.sinch.android.rtc.PushTokenRegistrationCallback
        public void onPushTokenRegistered() {
            SinchCallClient.this.g().c("Client push token registered", new Object[0]);
        }

        @Override // com.sinch.android.rtc.PushTokenRegistrationCallback
        public void onPushTokenRegistrationFailed(SinchError sinchError) {
            Integer num;
            VoipLogger g8 = SinchCallClient.this.g();
            Object[] objArr = new Object[2];
            String str = null;
            if (sinchError != null) {
                num = Integer.valueOf(sinchError.getCode());
            } else {
                num = null;
            }
            objArr[0] = num;
            if (sinchError != null) {
                str = sinchError.getMessage();
            }
            objArr[1] = str;
            g8.d("Client push token registration with code: %s and message: %s", objArr);
        }

        @Override // com.sinch.android.rtc.PushTokenUnregistrationCallback
        public void onPushTokenUnregistered() {
            SinchCallClient.this.g().c("Push token unregistered successfully", new Object[0]);
        }

        @Override // com.sinch.android.rtc.PushTokenUnregistrationCallback
        public void onPushTokenUnregistrationFailed(SinchError sinchError) {
            Integer num;
            VoipLogger g8 = SinchCallClient.this.g();
            Object[] objArr = new Object[2];
            String str = null;
            if (sinchError != null) {
                num = Integer.valueOf(sinchError.getCode());
            } else {
                num = null;
            }
            objArr[0] = num;
            if (sinchError != null) {
                str = sinchError.getMessage();
            }
            objArr[1] = str;
            g8.d("Push token can not be unregistered. Error code: %s, message: %s", objArr);
        }

        @Override // com.sinch.android.rtc.UserRegistrationCallback
        public void onUserRegistered() {
            SinchCallClient.this.g().c("Client user registered", new Object[0]);
        }

        @Override // com.sinch.android.rtc.UserRegistrationCallback
        public void onUserRegistrationFailed(SinchError sinchError) {
            Integer num;
            VoipLogger g8 = SinchCallClient.this.g();
            Object[] objArr = new Object[2];
            String str = null;
            if (sinchError != null) {
                num = Integer.valueOf(sinchError.getCode());
            } else {
                num = null;
            }
            objArr[0] = num;
            if (sinchError != null) {
                str = sinchError.getMessage();
            }
            objArr[1] = str;
            g8.d("Client registration failed with code: %s and message: %s", objArr);
        }
    }

    /* compiled from: SinchCallClient.kt */
    /* loaded from: classes5.dex */
    private final class InternalPushTokenRegistrationListener implements PushTokenRegistrationCallback {
        public InternalPushTokenRegistrationListener() {
        }

        @Override // com.sinch.android.rtc.PushTokenRegistrationCallback
        public void onPushTokenRegistered() {
            SinchCallClient.this.g().c("On token registered", new Object[0]);
            SinchCallClient.this.z();
            SinchCallClient.this.f36570k.onNext(VoipClient.StartStatus.TOKEN_REGISTRATION_COMPLETED);
        }

        @Override // com.sinch.android.rtc.PushTokenRegistrationCallback
        public void onPushTokenRegistrationFailed(SinchError sinchError) {
            String str;
            VoipLogger g8 = SinchCallClient.this.g();
            if (sinchError != null) {
                str = sinchError.getMessage();
            } else {
                str = null;
            }
            g8.d("On token registration failed: " + str, new Object[0]);
            SinchCallClient.this.f36570k.onNext(VoipClient.StartStatus.TOKEN_REGISTRATION_FAILED);
        }
    }

    /* compiled from: SinchCallClient.kt */
    /* loaded from: classes5.dex */
    private final class InternalUserRegistrationListener implements UserRegistrationCallback {
        public InternalUserRegistrationListener() {
        }

        @Override // com.sinch.android.rtc.UserRegistrationCallback
        public void onCredentialsRequired(ClientRegistration clientRegistration) {
            SinchCallClient.this.g().c("Required additional credentials with jwt %s", SinchCallClient.this.f36564e);
            if (clientRegistration != null) {
                clientRegistration.register(SinchCallClient.this.f36564e);
            }
        }

        @Override // com.sinch.android.rtc.UserRegistrationCallback
        public void onUserRegistered() {
            SinchCallClient.this.g().c("User was registered", new Object[0]);
            SinchCallClient.this.f36570k.onNext(VoipClient.StartStatus.USER_REGISTRATION_COMPLETED);
        }

        @Override // com.sinch.android.rtc.UserRegistrationCallback
        public void onUserRegistrationFailed(SinchError sinchError) {
            SinchCallClient.this.f36570k.onNext(VoipClient.StartStatus.USER_REGISTRATION_FAILED);
        }
    }

    /* compiled from: SinchCallClient.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f36582a;

        static {
            int[] iArr = new int[VoipPushServiceType.values().length];
            try {
                iArr[VoipPushServiceType.GMS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VoipPushServiceType.HMS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f36582a = iArr;
        }
    }

    public SinchCallClient(Context context, String userId, String applicationKey, String environment, String jwt, VoipAudioDelegate audioDelegate, VoipPushServiceType voipPushServiceType, PushProfileData pushProfileData, VoipLogger logger) {
        Intrinsics.f(context, "context");
        Intrinsics.f(userId, "userId");
        Intrinsics.f(applicationKey, "applicationKey");
        Intrinsics.f(environment, "environment");
        Intrinsics.f(jwt, "jwt");
        Intrinsics.f(audioDelegate, "audioDelegate");
        Intrinsics.f(voipPushServiceType, "voipPushServiceType");
        Intrinsics.f(pushProfileData, "pushProfileData");
        Intrinsics.f(logger, "logger");
        this.f36560a = context;
        this.f36561b = userId;
        this.f36562c = applicationKey;
        this.f36563d = environment;
        this.f36564e = jwt;
        this.f36565f = audioDelegate;
        this.f36566g = voipPushServiceType;
        this.f36567h = pushProfileData;
        this.f36568i = logger;
        BehaviorSubject<VoipClient.StartStatus> e8 = BehaviorSubject.e();
        Intrinsics.e(e8, "create<VoipClient.StartStatus>()");
        this.f36570k = e8;
        BehaviorSubject<VoipCall> e9 = BehaviorSubject.e();
        Intrinsics.e(e9, "create<VoipCall>()");
        this.f36571l = e9;
        InternalUserRegistrationListener internalUserRegistrationListener = new InternalUserRegistrationListener();
        this.f36576q = internalUserRegistrationListener;
        InternalPushTokenRegistrationListener internalPushTokenRegistrationListener = new InternalPushTokenRegistrationListener();
        this.f36577r = internalPushTokenRegistrationListener;
        PushConfiguration u7 = u(voipPushServiceType, pushProfileData);
        SinchClient build = b.a().context(context).applicationKey(applicationKey).environmentHost(environment).userId(userId).pushConfiguration(u7).build();
        Intrinsics.e(build, "builder()\n              …\n                .build()");
        this.f36572m = build;
        UserController build2 = c.a().context(context).applicationKey(applicationKey).environmentHost(environment).userId(userId).pushConfiguration(u7).build();
        Intrinsics.e(build2, "builder()\n              …\n                .build()");
        this.f36574o = build2;
        CallController callController = build.getCallController();
        Intrinsics.e(callController, "sinchClient.callController");
        this.f36573n = callController;
        callController.addCallControllerListener(new InternalCallListener());
        build2.registerUser(internalUserRegistrationListener, internalPushTokenRegistrationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A() {
        this.f36565f.reset();
    }

    private final PushConfiguration u(VoipPushServiceType voipPushServiceType, PushProfileData pushProfileData) {
        int i8 = WhenMappings.f36582a[voipPushServiceType.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                PushConfiguration build = a.b().applicationId(pushProfileData.a()).deviceToken(pushProfileData.b()).build();
                Intrinsics.e(build, "hmsPushConfigurationBuil…                 .build()");
                return build;
            }
            throw new NoWhenBranchMatchedException();
        }
        PushConfiguration build2 = a.a().registrationToken(pushProfileData.b()).senderID(pushProfileData.a()).build();
        Intrinsics.e(build2, "fcmPushConfigurationBuil…                 .build()");
        return build2;
    }

    private final Call v(String str, Map<String, String> map) {
        Call callUser = this.f36573n.callUser(str, f36559t, map);
        Intrinsics.e(callUser, "callController.callUser(…IDEO_CONSTRAINT, headers)");
        return callUser;
    }

    private final void w() {
        VoipCall j8 = j();
        if (j8 == null) {
            return;
        }
        j8.d();
        this.f36575p = null;
    }

    private final boolean x() {
        if (Build.VERSION.SDK_INT <= 30) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, String> y(Call call, Map<String, String> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (map != null) {
            linkedHashMap.putAll(map);
        }
        Map<String, String> headers = call.getHeaders();
        Intrinsics.e(headers, "headers");
        linkedHashMap.putAll(headers);
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z() {
        this.f36573n.setRespectNativeCalls(x());
        this.f36572m.addSinchClientListener(new InternalClientListener());
        this.f36572m.start();
    }

    @Override // ee.mtakso.voip_client.VoipClient
    public void a(boolean z7) {
        this.f36565f.a(z7);
    }

    @Override // ee.mtakso.voip_client.VoipClient
    public void b(boolean z7) {
        this.f36565f.b(z7);
    }

    @Override // ee.mtakso.voip_client.VoipClient
    public VoipCall c() {
        VoipCall j8 = j();
        if (j8 == null) {
            return null;
        }
        VoipCall c8 = j8.c();
        this.f36575p = c8;
        return c8;
    }

    @Override // ee.mtakso.voip_client.VoipClient
    public boolean d() {
        return this.f36565f.d();
    }

    @Override // ee.mtakso.voip_client.VoipClient
    public void destroy() {
        g().c("Sinch client was destroyed", new Object[0]);
        A();
        this.f36572m.terminateGracefully();
    }

    @Override // ee.mtakso.voip_client.VoipClient
    public boolean e() {
        return this.f36565f.e();
    }

    @Override // ee.mtakso.voip_client.sinch.SinchCallDelegate
    public Call f(Call from, Map<String, String> headers) {
        Intrinsics.f(from, "from");
        Intrinsics.f(headers, "headers");
        String remoteUserId = from.getRemoteUserId();
        Intrinsics.e(remoteUserId, "from.remoteUserId");
        return v(remoteUserId, headers);
    }

    @Override // ee.mtakso.voip_client.sinch.SinchCallDelegate
    public VoipLogger g() {
        return this.f36568i;
    }

    @Override // ee.mtakso.voip_client.VoipClient
    public boolean h(Map<String, String> data) {
        Intrinsics.f(data, "data");
        if (!SinchPush.isSinchPushPayload(data)) {
            return false;
        }
        g().c("On consume push data: %s", data.toString());
        CallNotificationResult queryPushNotificationPayload = SinchPush.queryPushNotificationPayload(this.f36560a, data);
        this.f36569j = queryPushNotificationPayload.getCallHeaders();
        g().c("Were consumed headers separately from call: %s", this.f36569j);
        this.f36572m.relayRemotePushNotification(queryPushNotificationPayload);
        return true;
    }

    @Override // ee.mtakso.voip_client.VoipClient
    public Observable<VoipCall> i() {
        return this.f36571l;
    }

    @Override // ee.mtakso.voip_client.VoipClient
    public boolean isRunning() {
        if (this.f36570k.g() != null) {
            return true;
        }
        return false;
    }

    @Override // ee.mtakso.voip_client.VoipClient
    public VoipCall j() {
        return this.f36575p;
    }

    @Override // ee.mtakso.voip_client.VoipClient
    public Observable<VoipClient.StartStatus> k() {
        return this.f36570k;
    }

    @Override // ee.mtakso.voip_client.VoipClient
    public VoipCall l(VoipPeer peer, VoipConnection connection) {
        Intrinsics.f(peer, "peer");
        Intrinsics.f(connection, "connection");
        w();
        VoipCall b8 = SinchCall.f36545l.b(v(peer.a(), connection.a()), connection, peer, this);
        this.f36575p = b8;
        return b8;
    }

    @Override // ee.mtakso.voip_client.sinch.SinchCallDelegate
    public void onCallEnded(Call call) {
        this.f36565f.stop();
    }

    @Override // ee.mtakso.voip_client.sinch.SinchCallDelegate
    public void onCallEstablished(Call call) {
        CallDirection callDirection;
        if (call != null) {
            callDirection = call.getDirection();
        } else {
            callDirection = null;
        }
        if (callDirection == CallDirection.INCOMING) {
            this.f36565f.start();
        }
    }

    @Override // ee.mtakso.voip_client.sinch.SinchCallDelegate
    public void onCallProgressing(Call call) {
        CallDirection callDirection;
        if (call != null) {
            callDirection = call.getDirection();
        } else {
            callDirection = null;
        }
        if (callDirection == CallDirection.OUTGOING) {
            this.f36565f.start();
        }
    }
}
