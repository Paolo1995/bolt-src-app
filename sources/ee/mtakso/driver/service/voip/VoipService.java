package ee.mtakso.driver.service.voip;

import android.content.Context;
import ee.mtakso.driver.network.client.contact.VoipConfiguration;
import ee.mtakso.driver.platform.core.PlatformType;
import ee.mtakso.driver.platform.push.TokenProvider;
import ee.mtakso.driver.service.BaseService;
import ee.mtakso.driver.service.voip.extractor.VoipInfoExtractor;
import ee.mtakso.driver.service.voip.extractor.VoipInfoExtractorFactory;
import ee.mtakso.driver.service.voip.lifecycle.VoipLifecycleObservableImpl;
import ee.mtakso.voip_client.VoipCall;
import ee.mtakso.voip_client.VoipClient;
import ee.mtakso.voip_client.VoipConnection;
import ee.mtakso.voip_client.VoipPeer;
import ee.mtakso.voip_client.sinch.PushProfileData;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.voip.DriverVoipSdk;
import eu.bolt.driver.voip.PushServiceType;
import eu.bolt.driver.voip.VoipManager;
import eu.bolt.driver.voip.VoipSession;
import eu.bolt.driver.voip.VoipUserConfig;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoipService.kt */
@Singleton
/* loaded from: classes3.dex */
public final class VoipService implements BaseService {

    /* renamed from: a  reason: collision with root package name */
    private final Context f26102a;

    /* renamed from: b  reason: collision with root package name */
    private final VoipLifecycleObservableImpl f26103b;

    /* renamed from: c  reason: collision with root package name */
    private final PermissionManager f26104c;

    /* renamed from: d  reason: collision with root package name */
    private final VoipInfoExtractor f26105d;

    /* renamed from: e  reason: collision with root package name */
    private final DefaultVoipLogger f26106e;

    /* renamed from: f  reason: collision with root package name */
    private final Lazy f26107f;

    /* renamed from: g  reason: collision with root package name */
    private VoipSession f26108g;

    /* renamed from: h  reason: collision with root package name */
    private final VoipService$activeCallLifecycleObserver$1 f26109h;

    /* renamed from: i  reason: collision with root package name */
    private final CompositeDisposable f26110i;

    /* renamed from: j  reason: collision with root package name */
    private CompositeDisposable f26111j;

    /* renamed from: k  reason: collision with root package name */
    private volatile boolean f26112k;

    /* compiled from: VoipService.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f26113a;

        static {
            int[] iArr = new int[PlatformType.values().length];
            try {
                iArr[PlatformType.GMS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PlatformType.HMS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f26113a = iArr;
        }
    }

    @Inject
    public VoipService(VoipInfoExtractorFactory voipInfoExtractorFactory, Context context, VoipLifecycleObservableImpl voipLifecycleObservableImpl, PermissionManager permissionManager) {
        Lazy b8;
        Intrinsics.f(voipInfoExtractorFactory, "voipInfoExtractorFactory");
        Intrinsics.f(context, "context");
        Intrinsics.f(voipLifecycleObservableImpl, "voipLifecycleObservableImpl");
        Intrinsics.f(permissionManager, "permissionManager");
        this.f26102a = context;
        this.f26103b = voipLifecycleObservableImpl;
        this.f26104c = permissionManager;
        this.f26105d = voipInfoExtractorFactory.a();
        this.f26106e = new DefaultVoipLogger();
        b8 = LazyKt__LazyJVMKt.b(new Function0<VoipManager>() { // from class: ee.mtakso.driver.service.voip.VoipService$voipManager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final VoipManager invoke() {
                Context context2;
                PermissionManager permissionManager2;
                DefaultVoipLogger defaultVoipLogger;
                Kalev.d("Create Voip Manager by service");
                DriverVoipSdk driverVoipSdk = DriverVoipSdk.f41604a;
                context2 = VoipService.this.f26102a;
                permissionManager2 = VoipService.this.f26104c;
                defaultVoipLogger = VoipService.this.f26106e;
                return driverVoipSdk.a(context2, permissionManager2, defaultVoipLogger);
            }
        });
        this.f26107f = b8;
        this.f26109h = new VoipService$activeCallLifecycleObserver$1(this);
        this.f26110i = new CompositeDisposable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E() {
        t();
        final VoipCall u7 = u();
        if (u7 == null) {
            return;
        }
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.f26111j = compositeDisposable;
        Observable<VoipCall.State> h8 = u7.h();
        final Function1<VoipCall.State, Unit> function1 = new Function1<VoipCall.State, Unit>() { // from class: ee.mtakso.driver.service.voip.VoipService$listenActiveCall$1

            /* compiled from: VoipService.kt */
            /* loaded from: classes3.dex */
            public /* synthetic */ class WhenMappings {

                /* renamed from: a  reason: collision with root package name */
                public static final /* synthetic */ int[] f26126a;

                static {
                    int[] iArr = new int[VoipCall.State.values().length];
                    try {
                        iArr[VoipCall.State.CREATED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[VoipCall.State.ESTABLISHING.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[VoipCall.State.ESTABLISHED.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    f26126a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(VoipCall.State state) {
                int i8;
                VoipService$activeCallLifecycleObserver$1 voipService$activeCallLifecycleObserver$1;
                VoipService$activeCallLifecycleObserver$1 voipService$activeCallLifecycleObserver$12;
                VoipService$activeCallLifecycleObserver$1 voipService$activeCallLifecycleObserver$13;
                if (state == null) {
                    i8 = -1;
                } else {
                    i8 = WhenMappings.f26126a[state.ordinal()];
                }
                if (i8 == 1) {
                    voipService$activeCallLifecycleObserver$1 = VoipService.this.f26109h;
                    voipService$activeCallLifecycleObserver$1.d(u7);
                } else if (i8 == 2) {
                    voipService$activeCallLifecycleObserver$12 = VoipService.this.f26109h;
                    voipService$activeCallLifecycleObserver$12.a(u7);
                } else if (i8 == 3) {
                    voipService$activeCallLifecycleObserver$13 = VoipService.this.f26109h;
                    voipService$activeCallLifecycleObserver$13.c(u7);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VoipCall.State state) {
                b(state);
                return Unit.f50853a;
            }
        };
        compositeDisposable.b(h8.subscribe(new Consumer() { // from class: ee.mtakso.driver.service.voip.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VoipService.F(Function1.this, obj);
            }
        }));
        CompositeDisposable compositeDisposable2 = this.f26111j;
        if (compositeDisposable2 != null) {
            Observable<VoipCall.EndReason> i8 = u7.i();
            final Function1<VoipCall.EndReason, Unit> function12 = new Function1<VoipCall.EndReason, Unit>() { // from class: ee.mtakso.driver.service.voip.VoipService$listenActiveCall$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void b(VoipCall.EndReason it) {
                    VoipService$activeCallLifecycleObserver$1 voipService$activeCallLifecycleObserver$1;
                    voipService$activeCallLifecycleObserver$1 = VoipService.this.f26109h;
                    VoipCall voipCall = u7;
                    Intrinsics.e(it, "it");
                    voipService$activeCallLifecycleObserver$1.b(voipCall, it);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(VoipCall.EndReason endReason) {
                    b(endReason);
                    return Unit.f50853a;
                }
            };
            compositeDisposable2.b(i8.subscribe(new Consumer() { // from class: ee.mtakso.driver.service.voip.e
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    VoipService.G(Function1.this, obj);
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final PushServiceType H(PlatformType platformType) {
        int i8 = WhenMappings.f26113a[platformType.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return PushServiceType.HMS;
            }
            throw new NoWhenBranchMatchedException();
        }
        return PushServiceType.GMS;
    }

    private final void t() {
        CompositeDisposable compositeDisposable = this.f26111j;
        if (compositeDisposable != null) {
            compositeDisposable.d();
        }
        this.f26111j = null;
    }

    private final VoipManager v() {
        return (VoipManager) this.f26107f.getValue();
    }

    private final boolean x() {
        if (this.f26104c.o("android.permission.RECORD_AUDIO").d() != PermissionManager.PermissionStatus.GRANTED) {
            this.f26106e.c("Permission was not provided", new Object[0]);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String z(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (String) tmp0.invoke(obj);
    }

    public final boolean C() {
        VoipSession voipSession = this.f26108g;
        if (voipSession != null) {
            return voipSession.y();
        }
        return false;
    }

    public final boolean D() {
        VoipSession voipSession = this.f26108g;
        if (voipSession != null) {
            return voipSession.I();
        }
        return false;
    }

    public final void I() {
        VoipSession voipSession = this.f26108g;
        Intrinsics.c(voipSession);
        voipSession.v0();
        E();
    }

    public final void J() {
        VoipSession voipSession = this.f26108g;
        if (voipSession != null) {
            voipSession.C0();
        }
    }

    public final void K() {
        VoipSession voipSession = this.f26108g;
        if (voipSession != null) {
            voipSession.D0();
        }
    }

    public final void q(VoipPeer peer, VoipConnection connection) {
        Intrinsics.f(peer, "peer");
        Intrinsics.f(connection, "connection");
        if (!x()) {
            return;
        }
        VoipSession voipSession = this.f26108g;
        Intrinsics.c(voipSession);
        voipSession.k(peer, connection);
        E();
    }

    public final boolean r(Map<String, String> data) {
        Intrinsics.f(data, "data");
        VoipSession voipSession = this.f26108g;
        if (voipSession != null) {
            return voipSession.m(data);
        }
        return false;
    }

    public final void s() {
        this.f26112k = false;
        t();
        this.f26110i.d();
        v().c();
        this.f26108g = null;
    }

    @Override // ee.mtakso.driver.service.BaseService
    public boolean start() {
        return true;
    }

    @Override // ee.mtakso.driver.service.BaseService
    public void stop() {
        s();
    }

    public final VoipCall u() {
        VoipSession voipSession = this.f26108g;
        Intrinsics.c(voipSession);
        return voipSession.q();
    }

    public final void w() {
        VoipSession voipSession = this.f26108g;
        if (voipSession != null) {
            voipSession.t();
        }
    }

    public final void y(VoipConfiguration config, PlatformType platformType, TokenProvider.PushTokenData data) {
        Intrinsics.f(config, "config");
        Intrinsics.f(platformType, "platformType");
        Intrinsics.f(data, "data");
        VoipInfoExtractor.Info a8 = this.f26105d.a(config);
        if (a8 == null) {
            return;
        }
        VoipSession voipSession = this.f26108g;
        boolean z7 = true;
        if ((voipSession == null || !voipSession.F()) ? false : false) {
            return;
        }
        Kalev.d("VoipService active session connect");
        VoipSession a9 = v().a(new VoipUserConfig(a8.c(), a8.a(), a8.b(), H(platformType), new PushProfileData(data.a(), data.b())));
        this.f26108g = a9;
        CompositeDisposable compositeDisposable = this.f26110i;
        Intrinsics.c(a9);
        Observable<VoipCall> f02 = a9.f0();
        final VoipService$initWithConfig$1 voipService$initWithConfig$1 = new Function1<VoipCall, String>() { // from class: ee.mtakso.driver.service.voip.VoipService$initWithConfig$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final String invoke(VoipCall call) {
                Intrinsics.f(call, "call");
                return call.getId();
            }
        };
        Observable<VoipCall> distinctUntilChanged = f02.distinctUntilChanged(new Function() { // from class: ee.mtakso.driver.service.voip.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String z8;
                z8 = VoipService.z(Function1.this, obj);
                return z8;
            }
        });
        final Function1<VoipCall, Unit> function1 = new Function1<VoipCall, Unit>() { // from class: ee.mtakso.driver.service.voip.VoipService$initWithConfig$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(VoipCall voipCall) {
                VoipService.this.E();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VoipCall voipCall) {
                b(voipCall);
                return Unit.f50853a;
            }
        };
        compositeDisposable.b(distinctUntilChanged.subscribe(new Consumer() { // from class: ee.mtakso.driver.service.voip.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VoipService.A(Function1.this, obj);
            }
        }));
        CompositeDisposable compositeDisposable2 = this.f26110i;
        VoipSession voipSession2 = this.f26108g;
        Intrinsics.c(voipSession2);
        Observable<VoipClient.StartStatus> s02 = voipSession2.s0();
        final Function1<VoipClient.StartStatus, Unit> function12 = new Function1<VoipClient.StartStatus, Unit>() { // from class: ee.mtakso.driver.service.voip.VoipService$initWithConfig$3

            /* compiled from: VoipService.kt */
            /* loaded from: classes3.dex */
            public /* synthetic */ class WhenMappings {

                /* renamed from: a  reason: collision with root package name */
                public static final /* synthetic */ int[] f26123a;

                static {
                    int[] iArr = new int[VoipClient.StartStatus.values().length];
                    try {
                        iArr[VoipClient.StartStatus.ON_STARTED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[VoipClient.StartStatus.FAILED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f26123a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(VoipClient.StartStatus status) {
                Intrinsics.f(status, "status");
                int i8 = WhenMappings.f26123a[status.ordinal()];
                if (i8 == 1) {
                    VoipService.this.f26112k = true;
                } else if (i8 == 2) {
                    VoipService.this.s();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VoipClient.StartStatus startStatus) {
                b(startStatus);
                return Unit.f50853a;
            }
        };
        compositeDisposable2.b(s02.subscribe(new Consumer() { // from class: ee.mtakso.driver.service.voip.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VoipService.B(Function1.this, obj);
            }
        }));
    }
}
