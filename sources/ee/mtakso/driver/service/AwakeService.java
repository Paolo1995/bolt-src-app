package ee.mtakso.driver.service;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import ee.mtakso.driver.R;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.network.client.driver.DriverStatus;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.platform.core.PlatformManager;
import ee.mtakso.driver.platform.core.PlatformType;
import ee.mtakso.driver.service.auth.LightAuthFlow;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import ee.mtakso.driver.service.quickaccess.QuickAccessService;
import ee.mtakso.driver.service.routing.AppRoutingManager;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import ee.mtakso.driver.ui.notification.UiNotificationManager;
import ee.mtakso.driver.utils.BackgroundManager;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.RxUtils;
import ee.mtakso.driver.utils.power.WakeLockManager;
import eu.bolt.driver.core.util.PendingIntentFactory;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AwakeService.kt */
/* loaded from: classes3.dex */
public final class AwakeService extends Service {

    /* renamed from: p  reason: collision with root package name */
    public static final Companion f23369p = new Companion(null);

    /* renamed from: q  reason: collision with root package name */
    private static boolean f23370q;

    /* renamed from: r  reason: collision with root package name */
    private static boolean f23371r;
    @Inject

    /* renamed from: f  reason: collision with root package name */
    public LightAuthFlow f23372f;
    @Inject

    /* renamed from: g  reason: collision with root package name */
    public TrueTimeProvider f23373g;
    @Inject

    /* renamed from: h  reason: collision with root package name */
    public DriverStatusProvider f23374h;
    @Inject

    /* renamed from: i  reason: collision with root package name */
    public UiNotificationManager f23375i;
    @Inject

    /* renamed from: j  reason: collision with root package name */
    public BackgroundManager f23376j;
    @Inject

    /* renamed from: k  reason: collision with root package name */
    public DriverProvider f23377k;
    @Inject

    /* renamed from: l  reason: collision with root package name */
    public WakeLockManager f23378l;
    @Inject

    /* renamed from: m  reason: collision with root package name */
    public PlatformManager f23379m;

    /* renamed from: n  reason: collision with root package name */
    private Disposable f23380n;

    /* renamed from: o  reason: collision with root package name */
    private DriverStatus f23381o;

    /* compiled from: AwakeService.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Intent a(Context context) {
            return new Intent(context, AwakeService.class);
        }

        public final void b(Context context) {
            Intrinsics.f(context, "context");
            if (AwakeService.f23370q) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                context.startForegroundService(a(context));
            } else {
                context.startService(a(context));
            }
            AwakeService.f23370q = true;
        }
    }

    /* compiled from: AwakeService.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f23382a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f23383b;

        static {
            int[] iArr = new int[DriverStatus.values().length];
            try {
                iArr[DriverStatus.WAITING_ORDER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DriverStatus.ACTIVE_ORDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DriverStatus.PENDING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DriverStatus.INACTIVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DriverStatus.BUSY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DriverStatus.OFFLINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[DriverStatus.UNDEFINED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[DriverStatus.UNKNOWN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            f23382a = iArr;
            int[] iArr2 = new int[PlatformType.values().length];
            try {
                iArr2[PlatformType.GMS.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[PlatformType.HMS.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            f23383b = iArr2;
        }
    }

    private final void h() {
        p().b(26, "driverapp:online");
    }

    private final Notification i(String str) {
        return o().g(this, PendingIntentFactory.b(new PendingIntentFactory(this), AppRoutingManager.f25869b.a(this), 0, 0, null, 14, null), str);
    }

    private final String m(DriverStatus driverStatus) {
        int i8 = WhenMappings.f23382a[driverStatus.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    return "";
                }
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown driverStatus");
                Kalev.e(illegalArgumentException, "Unknown driverStatus: " + driverStatus);
                return "";
            }
            String string = getString(R.string.title_order_in_progress);
            Intrinsics.e(string, "getString(R.string.title_order_in_progress)");
            return string;
        }
        String string2 = getString(R.string.your_status_is_set_to_online);
        Intrinsics.e(string2, "getString(R.string.your_status_is_set_to_online)");
        return string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource q(Function1 tmp0, Observable p02) {
        Intrinsics.f(tmp0, "$tmp0");
        Intrinsics.f(p02, "p0");
        return (ObservableSource) tmp0.invoke(p02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void t() {
        v();
        stopForeground(true);
        stopSelf();
    }

    private final void u() {
        int i8;
        int i9 = WhenMappings.f23383b[n().getType().ordinal()];
        if (i9 != 1) {
            if (i9 == 2) {
                i8 = 29;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            i8 = 30;
        }
        if (Build.VERSION.SDK_INT < i8 || k().d() == null) {
            t();
        }
    }

    private final void v() {
        p().e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(DriverStatus driverStatus) {
        switch (WhenMappings.f23382a[driverStatus.ordinal()]) {
            case 1:
            case 2:
            case 3:
                startForeground(1991, i(m(driverStatus)));
                h();
                return;
            case 4:
            case 5:
            case 6:
                t();
                return;
            case 7:
                u();
                return;
            default:
                return;
        }
    }

    public final LightAuthFlow j() {
        LightAuthFlow lightAuthFlow = this.f23372f;
        if (lightAuthFlow != null) {
            return lightAuthFlow;
        }
        Intrinsics.w("authFlow");
        return null;
    }

    public final DriverProvider k() {
        DriverProvider driverProvider = this.f23377k;
        if (driverProvider != null) {
            return driverProvider;
        }
        Intrinsics.w("driverProvider");
        return null;
    }

    public final DriverStatusProvider l() {
        DriverStatusProvider driverStatusProvider = this.f23374h;
        if (driverStatusProvider != null) {
            return driverStatusProvider;
        }
        Intrinsics.w("driverStatusProvider");
        return null;
    }

    public final PlatformManager n() {
        PlatformManager platformManager = this.f23379m;
        if (platformManager != null) {
            return platformManager;
        }
        Intrinsics.w("platformManager");
        return null;
    }

    public final UiNotificationManager o() {
        UiNotificationManager uiNotificationManager = this.f23375i;
        if (uiNotificationManager != null) {
            return uiNotificationManager;
        }
        Intrinsics.w("uiNotificationManager");
        return null;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        Injector.f20166d.b().E(this);
        super.onCreate();
        Kalev.b("AwakeService created");
        startForeground(1991, i(""));
        f23371r = true;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (f23371r) {
            j().u(this);
        }
        stopService(QuickAccessService.D.a(this));
        v();
        Kalev.b("AwakeService destroyed");
        Disposable disposable = this.f23380n;
        if (disposable != null) {
            disposable.dispose();
        }
        f23370q = false;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i8, int i9) {
        f23371r = false;
        if (intent == null) {
            j().u(this);
        }
        startService(QuickAccessService.D.a(this));
        startForeground(1991, i(""));
        if (DisposableExtKt.b(this.f23380n)) {
            Observable<DriverStatus> distinctUntilChanged = l().g().distinctUntilChanged();
            final AwakeService$onStartCommand$1 awakeService$onStartCommand$1 = new Function1<Observable<DriverStatus>, ObservableSource<DriverStatus>>() { // from class: ee.mtakso.driver.service.AwakeService$onStartCommand$1
                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final ObservableSource<DriverStatus> invoke(Observable<DriverStatus> it) {
                    Intrinsics.f(it, "it");
                    return RxUtils.a(it);
                }
            };
            Observable<R> compose = distinctUntilChanged.compose(new ObservableTransformer() { // from class: ee.mtakso.driver.service.a
                @Override // io.reactivex.ObservableTransformer
                public final ObservableSource a(Observable observable) {
                    ObservableSource q8;
                    q8 = AwakeService.q(Function1.this, observable);
                    return q8;
                }
            });
            final Function1<DriverStatus, Unit> function1 = new Function1<DriverStatus, Unit>() { // from class: ee.mtakso.driver.service.AwakeService$onStartCommand$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final void b(DriverStatus driverStatus) {
                    AwakeService.this.f23381o = driverStatus;
                    AwakeService awakeService = AwakeService.this;
                    Intrinsics.e(driverStatus, "driverStatus");
                    awakeService.w(driverStatus);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DriverStatus driverStatus) {
                    b(driverStatus);
                    return Unit.f50853a;
                }
            };
            Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.b
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    AwakeService.r(Function1.this, obj);
                }
            };
            final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.AwakeService$onStartCommand$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.f50853a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable error) {
                    Intrinsics.e(error, "error");
                    Kalev.e(error, "Failed to observe driver status!");
                    AwakeService.this.stopForeground(true);
                    AwakeService.this.stopSelf();
                }
            };
            this.f23380n = compose.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.service.c
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    AwakeService.s(Function1.this, obj);
                }
            });
            return 1;
        }
        DriverStatus driverStatus = this.f23381o;
        if (driverStatus != null) {
            w(driverStatus);
            return 1;
        }
        return 1;
    }

    public final WakeLockManager p() {
        WakeLockManager wakeLockManager = this.f23378l;
        if (wakeLockManager != null) {
            return wakeLockManager;
        }
        Intrinsics.w("wakeLockManager");
        return null;
    }
}
