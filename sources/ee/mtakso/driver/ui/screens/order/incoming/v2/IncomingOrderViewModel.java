package ee.mtakso.driver.ui.screens.order.incoming.v2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.order.Order;
import ee.mtakso.driver.network.client.order.OrderMapPoint;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.param.RateMePrefsManager;
import ee.mtakso.driver.service.geo.GeoCoordinate;
import ee.mtakso.driver.service.geo.GeoLocation;
import ee.mtakso.driver.service.modules.order.v2.OrderStateChange;
import ee.mtakso.driver.service.modules.order.v2.OrderStateManager;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.lifecycle.ObservableLiveData;
import ee.mtakso.driver.ui.base.mvvm.lifecycle.SingleLiveData;
import ee.mtakso.driver.ui.interactor.order.IncomingOrderData;
import ee.mtakso.driver.ui.interactor.order.IncomingOrderDetails;
import ee.mtakso.driver.ui.interactor.order.IncomingOrderInteractor;
import ee.mtakso.driver.ui.interactor.order.incoming.IncomingOrderRoute;
import ee.mtakso.driver.ui.interactor.order.incoming.IncomingOrderRouteInteractor;
import ee.mtakso.driver.ui.theme.AppThemeUtils;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.ObservableExtKt;
import eu.bolt.android.maps.core.plugin.driver.MapStyle;
import eu.bolt.driver.core.theme.AppThemeManager;
import eu.bolt.kalev.Kalev;
import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IncomingOrderViewModel.kt */
/* loaded from: classes3.dex */
public final class IncomingOrderViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final IncomingOrderInteractor f31407f;

    /* renamed from: g  reason: collision with root package name */
    private final IncomingOrderRouteInteractor f31408g;

    /* renamed from: h  reason: collision with root package name */
    private final OrderStateManager f31409h;

    /* renamed from: i  reason: collision with root package name */
    private final AppThemeManager f31410i;

    /* renamed from: j  reason: collision with root package name */
    private final RateMePrefsManager f31411j;

    /* renamed from: k  reason: collision with root package name */
    private final TrueTimeProvider f31412k;

    /* renamed from: l  reason: collision with root package name */
    private final DriverFeatures f31413l;

    /* renamed from: m  reason: collision with root package name */
    private final MutableLiveData<Integer> f31414m;

    /* renamed from: n  reason: collision with root package name */
    private final ObservableLiveData<IncomingOrderData> f31415n;

    /* renamed from: o  reason: collision with root package name */
    private final SingleLiveData<IncomingOrderRoute> f31416o;

    /* renamed from: p  reason: collision with root package name */
    private final MutableLiveData<OrderStateChange> f31417p;

    /* renamed from: q  reason: collision with root package name */
    private final LiveData<OrderStateChange> f31418q;

    /* renamed from: r  reason: collision with root package name */
    private Disposable f31419r;

    /* renamed from: s  reason: collision with root package name */
    private final MutableLiveData<Long> f31420s;

    /* renamed from: t  reason: collision with root package name */
    private final LiveData<Long> f31421t;

    /* renamed from: u  reason: collision with root package name */
    private Disposable f31422u;

    @Inject
    public IncomingOrderViewModel(IncomingOrderInteractor incomingOrderInteractor, IncomingOrderRouteInteractor incomingOrderRouteInteractor, OrderStateManager orderStateManager, AppThemeManager appThemeManager, RateMePrefsManager rateMePrefsManager, TrueTimeProvider trueTimeProvider, DriverFeatures driverFeatures) {
        Intrinsics.f(incomingOrderInteractor, "incomingOrderInteractor");
        Intrinsics.f(incomingOrderRouteInteractor, "incomingOrderRouteInteractor");
        Intrinsics.f(orderStateManager, "orderStateManager");
        Intrinsics.f(appThemeManager, "appThemeManager");
        Intrinsics.f(rateMePrefsManager, "rateMePrefsManager");
        Intrinsics.f(trueTimeProvider, "trueTimeProvider");
        Intrinsics.f(driverFeatures, "driverFeatures");
        this.f31407f = incomingOrderInteractor;
        this.f31408g = incomingOrderRouteInteractor;
        this.f31409h = orderStateManager;
        this.f31410i = appThemeManager;
        this.f31411j = rateMePrefsManager;
        this.f31412k = trueTimeProvider;
        this.f31413l = driverFeatures;
        this.f31414m = new MutableLiveData<>();
        this.f31415n = new ObservableLiveData<>();
        this.f31416o = new SingleLiveData<>();
        MutableLiveData<OrderStateChange> mutableLiveData = new MutableLiveData<>();
        this.f31417p = mutableLiveData;
        this.f31418q = mutableLiveData;
        MutableLiveData<Long> mutableLiveData2 = new MutableLiveData<>();
        this.f31420s = mutableLiveData2;
        this.f31421t = mutableLiveData2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(IncomingOrderData incomingOrderData) {
        Order order;
        Object obj;
        int v7;
        Object[] s7;
        GeoCoordinate[] geoCoordinateArr;
        boolean z7;
        boolean z8;
        IncomingOrderDetails c8 = incomingOrderData.b().c();
        Object obj2 = null;
        if (c8 != null) {
            order = c8.b();
        } else {
            order = null;
        }
        GeoLocation c9 = incomingOrderData.a().c();
        if (order != null && c9 != null && !this.f31416o.s()) {
            Iterator<T> it = order.l().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((OrderMapPoint) obj).e() == OrderMapPoint.Type.PICKUP) {
                        z8 = true;
                        continue;
                    } else {
                        z8 = false;
                        continue;
                    }
                    if (z8) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            OrderMapPoint orderMapPoint = (OrderMapPoint) obj;
            Iterator<T> it2 = order.l().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                if (((OrderMapPoint) next).e() == OrderMapPoint.Type.CURRENT_ORDER_DESTINATION) {
                    z7 = true;
                    continue;
                } else {
                    z7 = false;
                    continue;
                }
                if (z7) {
                    obj2 = next;
                    break;
                }
            }
            OrderMapPoint orderMapPoint2 = (OrderMapPoint) obj2;
            List<OrderMapPoint> l8 = order.l();
            v7 = CollectionsKt__IterablesKt.v(l8, 10);
            ArrayList arrayList = new ArrayList(v7);
            for (OrderMapPoint orderMapPoint3 : l8) {
                arrayList.add(new GeoCoordinate(orderMapPoint3.a(), orderMapPoint3.b()));
            }
            GeoCoordinate[] geoCoordinateArr2 = (GeoCoordinate[]) arrayList.toArray(new GeoCoordinate[0]);
            if (!this.f31413l.h() || orderMapPoint == null || orderMapPoint2 == null) {
                s7 = ArraysKt___ArraysJvmKt.s(new GeoCoordinate[]{c9.e()}, geoCoordinateArr2);
                geoCoordinateArr = (GeoCoordinate[]) s7;
            } else {
                geoCoordinateArr = new GeoCoordinate[]{new GeoCoordinate(orderMapPoint2.a(), orderMapPoint2.b()), new GeoCoordinate(orderMapPoint.a(), orderMapPoint.b())};
            }
            SingleLiveData<IncomingOrderRoute> singleLiveData = this.f31416o;
            Single<IncomingOrderRoute> K = this.f31408g.e(order.z(), (GeoCoordinate[]) Arrays.copyOf(geoCoordinateArr, geoCoordinateArr.length)).K(Schedulers.c());
            Intrinsics.e(K, "incomingOrderRouteIntera…scribeOn(Schedulers.io())");
            singleLiveData.t(K, new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderViewModel$loadRoute$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.f50853a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable it3) {
                    Intrinsics.f(it3, "it");
                    Kalev.e(it3, "Failed to load the route");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        this.f31415n.s(this.f31407f.k(), new Function1<IncomingOrderData, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(IncomingOrderData it) {
                Intrinsics.f(it, "it");
                IncomingOrderViewModel.this.U(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IncomingOrderData incomingOrderData) {
                b(incomingOrderData);
                return Unit.f50853a;
            }
        }, new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderViewModel$onStart$2
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
            public final void invoke2(Throwable it) {
                Intrinsics.f(it, "it");
                IncomingOrderViewModel.this.z(it, "Failed to get incoming order");
            }
        });
        Observable<Notification<OrderStateChange>> observeOn = this.f31409h.u0().observeOn(AndroidSchedulers.a());
        final Function1<Notification<OrderStateChange>, Unit> function1 = new Function1<Notification<OrderStateChange>, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderViewModel$onStart$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Notification<OrderStateChange> notification) {
                MutableLiveData mutableLiveData;
                if (notification.e() != null) {
                    mutableLiveData = IncomingOrderViewModel.this.f31417p;
                    mutableLiveData.o(notification.e());
                    return;
                }
                BaseViewModel.A(IncomingOrderViewModel.this, new NullPointerException("Order state change value is NULL"), null, 2, null);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Notification<OrderStateChange> notification) {
                b(notification);
                return Unit.f50853a;
            }
        };
        Consumer<? super Notification<OrderStateChange>> consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.incoming.v2.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                IncomingOrderViewModel.V(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderViewModel$onStart$4
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
            public final void invoke2(Throwable it) {
                IncomingOrderViewModel incomingOrderViewModel = IncomingOrderViewModel.this;
                Intrinsics.e(it, "it");
                incomingOrderViewModel.z(it, "Failed to get order state change");
            }
        };
        this.f31419r = observeOn.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.incoming.v2.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                IncomingOrderViewModel.W(Function1.this, obj);
            }
        });
    }

    public final void H() {
        this.f31409h.H();
    }

    public final void N() {
        OrderStateManager.x0(this.f31409h, null, 1, null);
        this.f31411j.b();
    }

    public final LiveData<Long> O() {
        return this.f31421t;
    }

    public final MapStyle P() {
        return AppThemeUtils.f34255a.c(this.f31410i.d());
    }

    public final ObservableLiveData<IncomingOrderData> Q() {
        return this.f31415n;
    }

    public final LiveData<OrderStateChange> R() {
        return this.f31418q;
    }

    public final SingleLiveData<IncomingOrderRoute> S() {
        return this.f31416o;
    }

    public final MutableLiveData<Integer> T() {
        return this.f31414m;
    }

    public final void X(IncomingOrderDetails details) {
        Intrinsics.f(details, "details");
        final long I = details.b().I();
        long max = Math.max((I - this.f31412k.a()) - 40, 0L);
        Disposable disposable = this.f31422u;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Observable<Long> interval = Observable.interval(max, 1L, TimeUnit.SECONDS);
        Intrinsics.e(interval, "interval(delay, 1, TimeUnit.SECONDS)");
        Observable g8 = ObservableExtKt.g(interval);
        final Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderViewModel$startExpirationTimer$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Code restructure failed: missing block: B:4:0x0013, code lost:
                r5 = r3.f31422u;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void b(java.lang.Long r5) {
                /*
                    r4 = this;
                    long r0 = r1
                    ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderViewModel r5 = r3
                    ee.mtakso.driver.service.time.TrueTimeProvider r5 = ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderViewModel.L(r5)
                    long r2 = r5.a()
                    long r0 = r0 - r2
                    r2 = 0
                    int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r5 >= 0) goto L1e
                    ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderViewModel r5 = r3
                    io.reactivex.disposables.Disposable r5 = ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderViewModel.J(r5)
                    if (r5 == 0) goto L1e
                    ee.mtakso.driver.utils.DisposableExtKt.a(r5)
                L1e:
                    ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderViewModel r5 = r3
                    androidx.lifecycle.MutableLiveData r5 = ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderViewModel.I(r5)
                    long r0 = java.lang.Math.max(r0, r2)
                    java.lang.Long r0 = java.lang.Long.valueOf(r0)
                    r5.o(r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderViewModel$startExpirationTimer$1.b(java.lang.Long):void");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l8) {
                b(l8);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.incoming.v2.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                IncomingOrderViewModel.Y(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderViewModel$startExpirationTimer$2
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
            public final void invoke2(Throwable it) {
                IncomingOrderViewModel incomingOrderViewModel = IncomingOrderViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(incomingOrderViewModel, it, null, 2, null);
            }
        };
        this.f31422u = g8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.incoming.v2.l
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                IncomingOrderViewModel.Z(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f31419r;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Disposable disposable2 = this.f31422u;
        if (disposable2 != null) {
            DisposableExtKt.a(disposable2);
        }
    }
}
