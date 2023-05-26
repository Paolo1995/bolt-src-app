package ee.mtakso.driver.service.modules.status;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.network.client.driver.DriverMightBeBlocked;
import ee.mtakso.driver.network.client.driver.DriverStatus;
import ee.mtakso.driver.network.client.driver.MightBeBlockedType;
import ee.mtakso.driver.network.exception.ApiException;
import ee.mtakso.driver.network.response.EmptyServerResponse;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.analytics.event.facade.AppStateAnalytics;
import ee.mtakso.driver.service.modules.reporters.AppReporter;
import ee.mtakso.driver.service.modules.status.GoOfflineIssue;
import ee.mtakso.driver.service.modules.status.GoOnlineStepResult;
import ee.mtakso.driver.utils.ObservableExtKt;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.driver.utils.RetryWithDelayWithConditionSingle;
import ee.mtakso.driver.utils.RxUtils;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.SingleTransformer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes3.dex */
public class DriverStatusSenderImpl implements DriverStatusSender {

    /* renamed from: a  reason: collision with root package name */
    private final DriverClient f25228a;

    /* renamed from: b  reason: collision with root package name */
    private final AppReporter f25229b;

    /* renamed from: c  reason: collision with root package name */
    private final AppStateAnalytics f25230c;

    /* renamed from: d  reason: collision with root package name */
    private final DriverProvider f25231d;

    /* renamed from: e  reason: collision with root package name */
    private final GoOnlineFlow f25232e;

    /* renamed from: f  reason: collision with root package name */
    private Disposable f25233f;

    /* renamed from: g  reason: collision with root package name */
    private BehaviorSubject<DriverStatus> f25234g = BehaviorSubject.f(DriverStatus.UNDEFINED);

    /* renamed from: h  reason: collision with root package name */
    private PublishSubject<Optional<DriverMightBeBlocked>> f25235h = PublishSubject.e();

    /* renamed from: i  reason: collision with root package name */
    private BehaviorSubject<Optional<GoOnlineIssue>> f25236i = BehaviorSubject.e();

    /* renamed from: j  reason: collision with root package name */
    private PublishSubject<Optional<GoOfflineIssue>> f25237j = PublishSubject.e();

    /* renamed from: k  reason: collision with root package name */
    private PublishSubject<Throwable> f25238k = PublishSubject.e();

    /* renamed from: l  reason: collision with root package name */
    private boolean f25239l = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ee.mtakso.driver.service.modules.status.DriverStatusSenderImpl$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25240a;

        static {
            int[] iArr = new int[MightBeBlockedType.values().length];
            f25240a = iArr;
            try {
                iArr[MightBeBlockedType.ACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25240a[MightBeBlockedType.PRICING_CONFIRMATION_REQUIRED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25240a[MightBeBlockedType.PRICING_REQUIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25240a[MightBeBlockedType.BLOCKED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25240a[MightBeBlockedType.BLOCKED_BY_TRAINING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25240a[MightBeBlockedType.VERIFICATION_REQUIRED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Inject
    public DriverStatusSenderImpl(DriverClient driverClient, AppStateAnalytics appStateAnalytics, AppReporter appReporter, DriverProvider driverProvider, GoOnlineFlow goOnlineFlow) {
        this.f25228a = driverClient;
        this.f25229b = appReporter;
        this.f25230c = appStateAnalytics;
        this.f25231d = driverProvider;
        this.f25232e = goOnlineFlow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(Throwable th) throws Exception {
        Kalev.e(th, "Failed to set driver inactive!");
        this.f25239l = true;
        if (th instanceof ApiException) {
            ApiException apiException = (ApiException) th;
            if (apiException.c() == 28401 && apiException.d() != null) {
                this.f25237j.onNext(Optional.f(new GoOfflineIssue.Blocked(apiException.d())));
                return;
            }
        }
        this.f25237j.onNext(Optional.f(new GoOfflineIssue.Failed(th)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B() throws Exception {
        this.f25239l = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(GoOnlineStepResult goOnlineStepResult) throws Exception {
        this.f25236i.onNext(Optional.f(GoOnlineStepResultKt.a(goOnlineStepResult)));
        if (!(goOnlineStepResult instanceof GoOnlineStepResult.LocationCheck)) {
            if (goOnlineStepResult instanceof GoOnlineStepResult.StartWorking) {
                DriverMightBeBlocked a8 = ((GoOnlineStepResult.StartWorking) goOnlineStepResult).a();
                int i8 = AnonymousClass1.f25240a[a8.f().ordinal()];
                if (i8 != 1 && i8 != 2 && i8 != 3) {
                    this.f25235h.onNext(Optional.f(a8));
                }
            } else if (goOnlineStepResult instanceof GoOnlineStepResult.Error) {
                Throwable a9 = ((GoOnlineStepResult.Error) goOnlineStepResult).a();
                Kalev.e(a9, "Failed to go online!");
                this.f25238k.onNext(a9);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(Throwable th) throws Exception {
        Kalev.e(th, "Unknown error");
        this.f25238k.onNext(th);
        this.f25239l = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean x(Throwable th) throws Exception {
        boolean z7;
        if ((th instanceof ApiException) && ((ApiException) th).c() == 28401) {
            z7 = false;
        } else {
            z7 = true;
        }
        return Boolean.valueOf(z7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y() throws Exception {
        this.f25239l = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(EmptyServerResponse emptyServerResponse) throws Exception {
        this.f25239l = true;
        Kalev.b("Driver status set to inactive");
    }

    @Override // ee.mtakso.driver.service.modules.status.DriverStatusSender
    public void a() {
        this.f25234g.onNext(DriverStatus.UNDEFINED);
    }

    @Override // ee.mtakso.driver.service.modules.status.DriverStatusProvider
    public Observable<Throwable> b() {
        return this.f25238k;
    }

    @Override // ee.mtakso.driver.service.modules.status.DriverStatusSender
    public void c() {
        this.f25234g.onNext(DriverStatus.PENDING);
    }

    @Override // ee.mtakso.driver.service.modules.status.DriverStatusSender
    public Observable<DriverStatus> d() {
        return this.f25234g;
    }

    @Override // ee.mtakso.driver.service.modules.status.DriverStatusSender
    public void e() {
        f();
        this.f25239l = false;
        BehaviorSubject<DriverStatus> behaviorSubject = this.f25234g;
        DriverStatus driverStatus = DriverStatus.PENDING;
        behaviorSubject.onNext(driverStatus);
        this.f25229b.j(driverStatus);
        this.f25230c.X3(driverStatus.name());
        this.f25233f = this.f25228a.w().l(new Consumer() { // from class: ee.mtakso.driver.service.modules.status.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Kalev.e((Throwable) obj, "Could not send inactive status successfully, check logs for more details");
            }
        }).F(new RetryWithDelayWithConditionSingle(5, 5000, new Function() { // from class: ee.mtakso.driver.service.modules.status.f
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean x7;
                x7 = DriverStatusSenderImpl.x((Throwable) obj);
                return x7;
            }
        })).e(new SingleTransformer() { // from class: ee.mtakso.driver.service.modules.status.g
            @Override // io.reactivex.SingleTransformer
            public final SingleSource a(Single single) {
                return RxUtils.c(single);
            }
        }).k(new Action() { // from class: ee.mtakso.driver.service.modules.status.h
            @Override // io.reactivex.functions.Action
            public final void run() {
                DriverStatusSenderImpl.this.y();
            }
        }).I(new Consumer() { // from class: ee.mtakso.driver.service.modules.status.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverStatusSenderImpl.this.z((EmptyServerResponse) obj);
            }
        }, new Consumer() { // from class: ee.mtakso.driver.service.modules.status.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverStatusSenderImpl.this.A((Throwable) obj);
            }
        });
    }

    @Override // ee.mtakso.driver.service.modules.status.DriverStatusSender
    public void f() {
        RxUtils.d(this.f25233f);
        this.f25233f = null;
    }

    @Override // ee.mtakso.driver.service.modules.status.DriverStatusProvider
    public Observable<DriverStatus> g() {
        return this.f25234g;
    }

    @Override // ee.mtakso.driver.service.modules.status.DriverStatusProvider
    public Observable<Optional<DriverMightBeBlocked>> h() {
        return this.f25235h;
    }

    @Override // ee.mtakso.driver.service.modules.status.DriverStatusSender
    public synchronized void i(DriverStatus driverStatus) {
        if (!driverStatus.equals(DriverStatus.PENDING) && !driverStatus.equals(DriverStatus.UNDEFINED)) {
            if (!this.f25239l) {
                return;
            }
            Kalev.b("DriverStatus set to " + driverStatus);
            this.f25229b.i(driverStatus.name());
            this.f25234g.onNext(driverStatus);
            this.f25229b.j(driverStatus);
            this.f25230c.X3(driverStatus.name());
            return;
        }
        throw new IllegalArgumentException(String.format("%s status can be set only by DriverStatusSenderImpl itself", driverStatus));
    }

    @Override // ee.mtakso.driver.service.modules.status.DriverStatusSender
    public void j(Long l8, OrderHandle orderHandle) {
        f();
        this.f25239l = false;
        BehaviorSubject<DriverStatus> behaviorSubject = this.f25234g;
        DriverStatus driverStatus = DriverStatus.PENDING;
        behaviorSubject.onNext(driverStatus);
        this.f25229b.j(driverStatus);
        this.f25230c.X3(driverStatus.name());
        this.f25233f = this.f25232e.y(this.f25231d.t().S().a() / 1000.0d, l8, orderHandle).compose(new ObservableTransformer() { // from class: ee.mtakso.driver.service.modules.status.a
            @Override // io.reactivex.ObservableTransformer
            public final ObservableSource a(Observable observable) {
                return RxUtils.b(observable);
            }
        }).doFinally(new Action() { // from class: ee.mtakso.driver.service.modules.status.b
            @Override // io.reactivex.functions.Action
            public final void run() {
                DriverStatusSenderImpl.this.B();
            }
        }).subscribe(new Consumer() { // from class: ee.mtakso.driver.service.modules.status.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverStatusSenderImpl.this.C((GoOnlineStepResult) obj);
            }
        }, new Consumer() { // from class: ee.mtakso.driver.service.modules.status.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverStatusSenderImpl.this.D((Throwable) obj);
            }
        });
    }

    @Override // ee.mtakso.driver.service.modules.status.DriverStatusProvider
    public Observable<GoOnlineIssue> k() {
        return ObservableExtKt.h(this.f25236i);
    }

    @Override // ee.mtakso.driver.service.modules.status.DriverStatusSender
    public void l() {
        this.f25236i.onNext(Optional.a());
    }

    @Override // ee.mtakso.driver.service.modules.status.DriverStatusProvider
    public Observable<GoOfflineIssue> m() {
        return ObservableExtKt.h(this.f25237j);
    }

    @Override // ee.mtakso.driver.service.modules.status.DriverStatusProvider
    public synchronized DriverStatus n() {
        return this.f25234g.g();
    }
}
