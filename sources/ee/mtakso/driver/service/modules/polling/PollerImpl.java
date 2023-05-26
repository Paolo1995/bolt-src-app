package ee.mtakso.driver.service.modules.polling;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import ee.mtakso.driver.network.client.driver.DriverStatus;
import ee.mtakso.driver.network.client.driver.PollingResult;
import ee.mtakso.driver.service.ObservableService;
import ee.mtakso.driver.service.modules.polling.Poller;
import ee.mtakso.driver.service.modules.status.DriverStatusSender;
import eu.bolt.kalev.Kalev;
import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PollerImpl.kt */
@Singleton
/* loaded from: classes3.dex */
public final class PollerImpl implements Poller {

    /* renamed from: a  reason: collision with root package name */
    private final DriverStatusSender f25114a;

    /* renamed from: b  reason: collision with root package name */
    private final Lazy f25115b;

    /* renamed from: c  reason: collision with root package name */
    private final Lazy f25116c;

    /* renamed from: d  reason: collision with root package name */
    private final PublishSubject<PollingSigned<PollingResult>> f25117d;

    /* compiled from: PollerImpl.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f25118a;

        static {
            int[] iArr = new int[DriverStatus.values().length];
            try {
                iArr[DriverStatus.UNDEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DriverStatus.INACTIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DriverStatus.BUSY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DriverStatus.WAITING_ORDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DriverStatus.ACTIVE_ORDER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DriverStatus.PENDING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[DriverStatus.OFFLINE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[DriverStatus.UNKNOWN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            f25118a = iArr;
        }
    }

    @Inject
    public PollerImpl(final PollerFactory pollerFactory, final ActivePollingErrorHandler activePollingErrorHandler, final InactivePollingErrorHandler inactivePollingErrorHandler, DriverStatusSender driverStatusSender) {
        Lazy b8;
        Lazy b9;
        Intrinsics.f(pollerFactory, "pollerFactory");
        Intrinsics.f(activePollingErrorHandler, "activePollingErrorHandler");
        Intrinsics.f(inactivePollingErrorHandler, "inactivePollingErrorHandler");
        Intrinsics.f(driverStatusSender, "driverStatusSender");
        this.f25114a = driverStatusSender;
        b8 = LazyKt__LazyJVMKt.b(new Function0<ObservableService<PollingSigned<PollingResult>>>() { // from class: ee.mtakso.driver.service.modules.polling.PollerImpl$activePoller$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final ObservableService<PollingSigned<PollingResult>> invoke() {
                PublishSubject publishSubject;
                ObservableService<PollingSigned<PollingResult>> a8 = PollerFactory.this.a(2L, AppMeasurementSdk.ConditionalUserProperty.ACTIVE, activePollingErrorHandler);
                PollerImpl pollerImpl = this;
                Observable<PollingSigned<PollingResult>> c8 = a8.c();
                publishSubject = pollerImpl.f25117d;
                c8.subscribe(publishSubject);
                return a8;
            }
        });
        this.f25115b = b8;
        b9 = LazyKt__LazyJVMKt.b(new Function0<ObservableService<PollingSigned<PollingResult>>>() { // from class: ee.mtakso.driver.service.modules.polling.PollerImpl$inactivePoller$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final ObservableService<PollingSigned<PollingResult>> invoke() {
                PublishSubject publishSubject;
                ObservableService<PollingSigned<PollingResult>> a8 = PollerFactory.this.a(5L, "inactive", inactivePollingErrorHandler);
                PollerImpl pollerImpl = this;
                Observable<PollingSigned<PollingResult>> c8 = a8.c();
                publishSubject = pollerImpl.f25117d;
                c8.subscribe(publishSubject);
                return a8;
            }
        });
        this.f25116c = b9;
        PublishSubject<PollingSigned<PollingResult>> e8 = PublishSubject.e();
        Intrinsics.e(e8, "create<PollingResultModel>()");
        this.f25117d = e8;
    }

    private final ObservableService<PollingSigned<PollingResult>> i() {
        return (ObservableService) this.f25115b.getValue();
    }

    private final ObservableService<PollingSigned<PollingResult>> j() {
        return (ObservableService) this.f25116c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Notification k(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Notification) tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.service.modules.polling.Poller
    public void a() {
        DriverStatus n8 = this.f25114a.n();
        switch (WhenMappings.f25118a[n8.ordinal()]) {
            case 1:
            case 2:
            case 3:
                i().stop();
                j().start();
                return;
            case 4:
            case 5:
            case 6:
                i().start();
                j().stop();
                return;
            case 7:
            case 8:
                Kalev.d("Tried to start polling with unsupported driver state: " + n8);
                return;
            default:
                return;
        }
    }

    @Override // ee.mtakso.driver.service.modules.polling.Poller
    public void b() {
        j().stop();
        i().stop();
    }

    @Override // ee.mtakso.driver.service.ObservableService
    public Observable<PollingSigned<PollingResult>> c() {
        return this.f25117d;
    }

    @Override // ee.mtakso.driver.service.pollerv2.PollerSource
    public Observable<PollingSigned<PollingResult>> e() {
        return Poller.DefaultImpls.a(this);
    }

    @Override // ee.mtakso.driver.service.pollerv2.PollerSource
    public Observable<Notification<PollingSigned<PollingResult>>> f() {
        Observable<PollingSigned<PollingResult>> c8 = c();
        final PollerImpl$observePollingResultNotification$1 pollerImpl$observePollingResultNotification$1 = new Function1<PollingSigned<PollingResult>, Notification<PollingSigned<PollingResult>>>() { // from class: ee.mtakso.driver.service.modules.polling.PollerImpl$observePollingResultNotification$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Notification<PollingSigned<PollingResult>> invoke(PollingSigned<PollingResult> it) {
                Intrinsics.f(it, "it");
                return Notification.c(it);
            }
        };
        Observable map = c8.map(new Function() { // from class: ee.mtakso.driver.service.modules.polling.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Notification k8;
                k8 = PollerImpl.k(Function1.this, obj);
                return k8;
            }
        });
        Intrinsics.e(map, "observeResults().map { N…cation.createOnNext(it) }");
        return map;
    }

    @Override // ee.mtakso.driver.service.BaseService
    public boolean start() {
        a();
        return true;
    }

    @Override // ee.mtakso.driver.service.BaseService
    public void stop() {
        b();
    }
}
