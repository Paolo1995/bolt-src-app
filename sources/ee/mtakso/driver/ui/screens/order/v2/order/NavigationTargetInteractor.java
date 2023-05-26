package ee.mtakso.driver.ui.screens.order.v2.order;

import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.order.OrderKt;
import ee.mtakso.driver.service.geo.GeoCoordinate;
import ee.mtakso.driver.service.modules.order.v2.OrderProviderUtils;
import ee.mtakso.driver.service.order.details.ActiveOrderDetails;
import ee.mtakso.driver.service.order.details.OrderDetails;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.utils.ObservableExtKt;
import io.reactivex.Observable;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavigationTargetInteractor.kt */
/* loaded from: classes3.dex */
public final class NavigationTargetInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final OrderProvider f32211a;

    @Inject
    public NavigationTargetInteractor(OrderProvider orderProvider) {
        Intrinsics.f(orderProvider, "orderProvider");
        this.f32211a = orderProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavigationTarget f(ActiveOrderDetails activeOrderDetails) {
        GeoCoordinate a8 = OrderKt.a(activeOrderDetails.i());
        if (a8 == null) {
            a8 = OrderKt.b(activeOrderDetails.i());
        }
        if (a8 != null) {
            return new NavigationTarget(a8, activeOrderDetails.i().E());
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NavigationTarget j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (NavigationTarget) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean k(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.s(obj, obj2)).booleanValue();
    }

    public Observable<NavigationTarget> g() {
        Observable k8 = ObservableExtKt.k(this.f32211a.a(), new Function1<List<? extends OrderDetails>, ActiveOrderDetails>() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.NavigationTargetInteractor$observeScreenData$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ActiveOrderDetails invoke(List<? extends OrderDetails> it) {
                Intrinsics.f(it, "it");
                return OrderProviderUtils.i(it);
            }
        });
        final NavigationTargetInteractor$observeScreenData$2 navigationTargetInteractor$observeScreenData$2 = new Function1<ActiveOrderDetails, Boolean>() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.NavigationTargetInteractor$observeScreenData$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(ActiveOrderDetails it) {
                boolean z7;
                Intrinsics.f(it, "it");
                if (it.b() != OrderState.ORDER_STATE_DRIVING_WITH_CLIENT && it.b() != OrderState.ORDER_STATE_DRIVER_ACCEPTED) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                return Boolean.valueOf(z7);
            }
        };
        Observable filter = k8.filter(new Predicate() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.f
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean h8;
                h8 = NavigationTargetInteractor.h(Function1.this, obj);
                return h8;
            }
        });
        final NavigationTargetInteractor$observeScreenData$3 navigationTargetInteractor$observeScreenData$3 = new Function1<ActiveOrderDetails, Boolean>() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.NavigationTargetInteractor$observeScreenData$3
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(ActiveOrderDetails it) {
                boolean z7;
                Intrinsics.f(it, "it");
                if (OrderKt.b(it.i()) != null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                return Boolean.valueOf(z7);
            }
        };
        Observable filter2 = filter.filter(new Predicate() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.g
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean i8;
                i8 = NavigationTargetInteractor.i(Function1.this, obj);
                return i8;
            }
        });
        final Function1<ActiveOrderDetails, NavigationTarget> function1 = new Function1<ActiveOrderDetails, NavigationTarget>() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.NavigationTargetInteractor$observeScreenData$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final NavigationTarget invoke(ActiveOrderDetails it) {
                NavigationTarget f8;
                Intrinsics.f(it, "it");
                f8 = NavigationTargetInteractor.this.f(it);
                return f8;
            }
        };
        Observable map = filter2.map(new Function() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.h
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                NavigationTarget j8;
                j8 = NavigationTargetInteractor.j(Function1.this, obj);
                return j8;
            }
        });
        final NavigationTargetInteractor$observeScreenData$5 navigationTargetInteractor$observeScreenData$5 = new Function2<NavigationTarget, NavigationTarget, Boolean>() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.NavigationTargetInteractor$observeScreenData$5
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: b */
            public final Boolean s(NavigationTarget oldTarget, NavigationTarget newTarget) {
                boolean z7;
                Intrinsics.f(oldTarget, "oldTarget");
                Intrinsics.f(newTarget, "newTarget");
                if (oldTarget.a().a() == newTarget.a().a()) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                return Boolean.valueOf(z7);
            }
        };
        Observable distinctUntilChanged = map.distinctUntilChanged(new BiPredicate() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.i
            @Override // io.reactivex.functions.BiPredicate
            public final boolean test(Object obj, Object obj2) {
                boolean k9;
                k9 = NavigationTargetInteractor.k(Function2.this, obj, obj2);
                return k9;
            }
        });
        Intrinsics.e(distinctUntilChanged, "override fun observeScre…utationSchedulers()\n    }");
        return ObservableExtKt.f(distinctUntilChanged);
    }
}
