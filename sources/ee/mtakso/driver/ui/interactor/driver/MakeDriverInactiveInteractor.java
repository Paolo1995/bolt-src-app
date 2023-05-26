package ee.mtakso.driver.ui.interactor.driver;

import ee.mtakso.driver.network.client.driver.DriverStatus;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.driver.DriverManager;
import ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import ee.mtakso.driver.service.modules.status.GoOfflineIssue;
import ee.mtakso.driver.service.modules.surge.SurgeManager;
import ee.mtakso.driver.service.rating.app.AppRatingManager;
import ee.mtakso.driver.ui.interactor.driver.MakeDriverInactiveStatus;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MakeDriverInactiveInteractor.kt */
/* loaded from: classes3.dex */
public final class MakeDriverInactiveInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final DriverStatusProvider f26484a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverManager f26485b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverProvider f26486c;

    /* renamed from: d  reason: collision with root package name */
    private final DriverDestinationsManager f26487d;

    /* renamed from: e  reason: collision with root package name */
    private final SurgeManager f26488e;

    /* renamed from: f  reason: collision with root package name */
    private final AppRatingManager f26489f;

    @Inject
    public MakeDriverInactiveInteractor(DriverStatusProvider driverStatusProvider, DriverManager driverManager, DriverProvider driverProvider, DriverDestinationsManager destinationManager, SurgeManager surgeManager, AppRatingManager appRatingManager) {
        Intrinsics.f(driverStatusProvider, "driverStatusProvider");
        Intrinsics.f(driverManager, "driverManager");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(destinationManager, "destinationManager");
        Intrinsics.f(surgeManager, "surgeManager");
        Intrinsics.f(appRatingManager, "appRatingManager");
        this.f26484a = driverStatusProvider;
        this.f26485b = driverManager;
        this.f26486c = driverProvider;
        this.f26487d = destinationManager;
        this.f26488e = surgeManager;
        this.f26489f = appRatingManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SetInactiveConfirmationSignal h(boolean z7) {
        if (n() && !z7) {
            return SetInactiveConfirmationSignal.GO_OFFLINE;
        }
        if (this.f26488e.c() && !z7) {
            return SetInactiveConfirmationSignal.GO_OFFLINE_WITH_SURGE;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MakeDriverInactiveStatus.Inactive k(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (MakeDriverInactiveStatus.Inactive) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MakeDriverInactiveStatus.Failed l(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (MakeDriverInactiveStatus.Failed) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final boolean n() {
        if (this.f26486c.m().p() && !this.f26486c.t().m().a() && !this.f26487d.E()) {
            return true;
        }
        return false;
    }

    public final Single<MakeDriverInactiveStatus> i(final boolean z7) {
        Observable<DriverStatus> g8 = this.f26484a.g();
        final MakeDriverInactiveInteractor$makeDriverInactive$1 makeDriverInactiveInteractor$makeDriverInactive$1 = new Function1<DriverStatus, Boolean>() { // from class: ee.mtakso.driver.ui.interactor.driver.MakeDriverInactiveInteractor$makeDriverInactive$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(DriverStatus it) {
                boolean z8;
                Intrinsics.f(it, "it");
                if (it == DriverStatus.INACTIVE) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                return Boolean.valueOf(z8);
            }
        };
        Observable<DriverStatus> filter = g8.filter(new Predicate() { // from class: ee.mtakso.driver.ui.interactor.driver.f
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean j8;
                j8 = MakeDriverInactiveInteractor.j(Function1.this, obj);
                return j8;
            }
        });
        final Function1<DriverStatus, MakeDriverInactiveStatus.Inactive> function1 = new Function1<DriverStatus, MakeDriverInactiveStatus.Inactive>() { // from class: ee.mtakso.driver.ui.interactor.driver.MakeDriverInactiveInteractor$makeDriverInactive$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final MakeDriverInactiveStatus.Inactive invoke(DriverStatus it) {
                SetInactiveConfirmationSignal h8;
                Intrinsics.f(it, "it");
                h8 = MakeDriverInactiveInteractor.this.h(z7);
                return new MakeDriverInactiveStatus.Inactive(h8);
            }
        };
        ObservableSource map = filter.map(new Function() { // from class: ee.mtakso.driver.ui.interactor.driver.g
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                MakeDriverInactiveStatus.Inactive k8;
                k8 = MakeDriverInactiveInteractor.k(Function1.this, obj);
                return k8;
            }
        });
        Observable<GoOfflineIssue> m8 = this.f26484a.m();
        final MakeDriverInactiveInteractor$makeDriverInactive$3 makeDriverInactiveInteractor$makeDriverInactive$3 = new Function1<GoOfflineIssue, MakeDriverInactiveStatus.Failed>() { // from class: ee.mtakso.driver.ui.interactor.driver.MakeDriverInactiveInteractor$makeDriverInactive$3
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final MakeDriverInactiveStatus.Failed invoke(GoOfflineIssue it) {
                Intrinsics.f(it, "it");
                return new MakeDriverInactiveStatus.Failed(it);
            }
        };
        Single firstOrError = Observable.merge(map, m8.map(new Function() { // from class: ee.mtakso.driver.ui.interactor.driver.h
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                MakeDriverInactiveStatus.Failed l8;
                l8 = MakeDriverInactiveInteractor.l(Function1.this, obj);
                return l8;
            }
        })).firstOrError();
        final Function1<Disposable, Unit> function12 = new Function1<Disposable, Unit>() { // from class: ee.mtakso.driver.ui.interactor.driver.MakeDriverInactiveInteractor$makeDriverInactive$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Disposable disposable) {
                AppRatingManager appRatingManager;
                DriverManager driverManager;
                appRatingManager = MakeDriverInactiveInteractor.this.f26489f;
                appRatingManager.m();
                driverManager = MakeDriverInactiveInteractor.this.f26485b;
                driverManager.j();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Disposable disposable) {
                b(disposable);
                return Unit.f50853a;
            }
        };
        Single<MakeDriverInactiveStatus> K = firstOrError.n(new Consumer() { // from class: ee.mtakso.driver.ui.interactor.driver.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MakeDriverInactiveInteractor.m(Function1.this, obj);
            }
        }).K(AndroidSchedulers.a());
        Intrinsics.e(K, "fun makeDriverInactive(c…ulers.mainThread())\n    }");
        return K;
    }
}
