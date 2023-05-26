package ee.mtakso.driver.service.modules.order.v2;

import androidx.fragment.app.FragmentTransaction;
import ee.mtakso.driver.model.CancellationReason;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.order.ChangeRouteRequest;
import ee.mtakso.driver.network.client.order.OrderClient;
import ee.mtakso.driver.network.client.order.PriceReviewInfo;
import ee.mtakso.driver.network.client.order.RateClientInfo;
import ee.mtakso.driver.network.client.order.RejectOrderResponse;
import ee.mtakso.driver.network.client.order.RejectReasonInfo;
import ee.mtakso.driver.network.client.order.StopTimerResponse;
import ee.mtakso.driver.network.client.order.UpcomingStop;
import ee.mtakso.driver.network.response.EmptyServerResponse;
import ee.mtakso.driver.service.geo.GeoCoordinate;
import ee.mtakso.driver.service.geo.transmitter.LocationTransmitter;
import ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager;
import ee.mtakso.driver.service.order.details.ActiveOrderDetails;
import ee.mtakso.driver.service.order.details.ActiveOrderDetailsKt;
import ee.mtakso.driver.service.order.details.OrderDetails;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.service.order.details.OrdersCache;
import ee.mtakso.driver.utils.AssertUtils;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.RetryWithDelaySingle;
import eu.bolt.kalev.Kalev;
import io.reactivex.Completable;
import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import j$.util.Spliterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderStateManager.kt */
@Singleton
/* loaded from: classes3.dex */
public final class OrderStateManager {

    /* renamed from: a */
    private final OrderProvider f24932a;

    /* renamed from: b */
    private final OrdersCache f24933b;

    /* renamed from: c */
    private final OrderClient f24934c;

    /* renamed from: d */
    private final LocationTransmitter f24935d;

    /* renamed from: e */
    private final DriverDestinationsManager f24936e;

    /* renamed from: f */
    private Disposable f24937f;

    /* renamed from: g */
    private Disposable f24938g;

    /* renamed from: h */
    private final PublishSubject<Notification<OrderStateChange>> f24939h;

    @Inject
    public OrderStateManager(OrderProvider provider, OrdersCache ordersCache, OrderClient apiClient, LocationTransmitter locationTransmitter, DriverDestinationsManager destinationsManager) {
        Intrinsics.f(provider, "provider");
        Intrinsics.f(ordersCache, "ordersCache");
        Intrinsics.f(apiClient, "apiClient");
        Intrinsics.f(locationTransmitter, "locationTransmitter");
        Intrinsics.f(destinationsManager, "destinationsManager");
        this.f24932a = provider;
        this.f24933b = ordersCache;
        this.f24934c = apiClient;
        this.f24935d = locationTransmitter;
        this.f24936e = destinationsManager;
        PublishSubject<Notification<OrderStateChange>> e8 = PublishSubject.e();
        Intrinsics.e(e8, "create<Notification<OrderStateChange>>()");
        this.f24939h = e8;
    }

    public static final void A0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void B0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final SingleSource D0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    public final Completable E0(OrderHandle orderHandle) {
        Completable D = LocationTransmitter.l(this.f24935d, orderHandle, true, 0, 4, null).D(new RetryWithDelaySingle(3, 3000L));
        final OrderStateManager$sendTrackingResults$1 orderStateManager$sendTrackingResults$1 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderStateManager$sendTrackingResults$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to send GPS tracking results!");
            }
        };
        Completable A = D.p(new Consumer() { // from class: ee.mtakso.driver.service.modules.order.v2.m0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderStateManager.F0(Function1.this, obj);
            }
        }).A();
        Intrinsics.e(A, "locationTransmitter\n    …       .onErrorComplete()");
        return A;
    }

    public static final void F0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final SingleSource H0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    public static final SingleSource I(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    public static final void I0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void J0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void K0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final SingleSource M0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    public static final SingleSource O(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    public static final SingleSource Q(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    public static final void R(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void S(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void T(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void V(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void W(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void X(Single<EmptyServerResponse> single, final OrderStateChangeType orderStateChangeType) {
        if (!DisposableExtKt.b(this.f24938g)) {
            this.f24939h.onNext(Notification.c(new OrderStateChangeError(orderStateChangeType, new RuntimeException("Order is being changed. Couldn't update order state."))));
            return;
        }
        Single<EmptyServerResponse> F = single.F(new RetryWithDelaySingle(3, 5000L));
        final Function1<Disposable, Unit> function1 = new Function1<Disposable, Unit>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderStateManager$changeOrderState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(Disposable disposable) {
                PublishSubject publishSubject;
                publishSubject = OrderStateManager.this.f24939h;
                publishSubject.onNext(Notification.c(new OrderStateChangeProgress(orderStateChangeType)));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Disposable disposable) {
                b(disposable);
                return Unit.f50853a;
            }
        };
        Single<EmptyServerResponse> n8 = F.n(new Consumer() { // from class: ee.mtakso.driver.service.modules.order.v2.i0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderStateManager.Z(Function1.this, obj);
            }
        });
        final Function1<EmptyServerResponse, Unit> function12 = new Function1<EmptyServerResponse, Unit>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderStateManager$changeOrderState$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(EmptyServerResponse emptyServerResponse) {
                PublishSubject publishSubject;
                publishSubject = OrderStateManager.this.f24939h;
                publishSubject.onNext(Notification.c(new OrderStateChangeSuccess(orderStateChangeType)));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EmptyServerResponse emptyServerResponse) {
                b(emptyServerResponse);
                return Unit.f50853a;
            }
        };
        Consumer<? super EmptyServerResponse> consumer = new Consumer() { // from class: ee.mtakso.driver.service.modules.order.v2.j0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderStateManager.a0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderStateManager$changeOrderState$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                PublishSubject publishSubject;
                publishSubject = OrderStateManager.this.f24939h;
                OrderStateChangeType orderStateChangeType2 = orderStateChangeType;
                Intrinsics.e(it, "it");
                publishSubject.onNext(Notification.c(new OrderStateChangeError(orderStateChangeType2, it)));
            }
        };
        this.f24938g = n8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.service.modules.order.v2.l0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderStateManager.b0(Function1.this, obj);
            }
        });
    }

    static /* synthetic */ void Y(OrderStateManager orderStateManager, Single single, OrderStateChangeType orderStateChangeType, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            orderStateChangeType = OrderStateChangeType.DEFAULT;
        }
        orderStateManager.X(single, orderStateChangeType);
    }

    public static final void Z(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void a0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void b0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final SingleSource d0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    public static final void e0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void f0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void g0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final SingleSource i0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    public static final void k0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final SingleSource l0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    public static final void m0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void n0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final SingleSource p0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    public final long q0(ActiveOrderDetails activeOrderDetails) {
        Object W;
        List<UpcomingStop> a8 = ActiveOrderDetailsKt.a(activeOrderDetails);
        if (a8.size() >= 2) {
            W = CollectionsKt___CollectionsKt.W(a8);
            return ((UpcomingStop) W).b();
        }
        throw new Exception("There is no stop to arrive");
    }

    public static final SingleSource s0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    public static /* synthetic */ void x0(OrderStateManager orderStateManager, CancellationReason cancellationReason, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            cancellationReason = null;
        }
        orderStateManager.w0(cancellationReason);
    }

    public static final SingleSource y0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    public static final void z0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void C0(final long j8) {
        Single<OrderDetails> r7 = OrderProviderUtils.r(this.f24932a, OrderState.ORDER_STATE_DRIVING_WITH_CLIENT, OrderState.ORDER_STATE_WAITING_ON_STOP);
        final Function1<OrderDetails, SingleSource<? extends EmptyServerResponse>> function1 = new Function1<OrderDetails, SingleSource<? extends EmptyServerResponse>>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderStateManager$selectNextStop$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends EmptyServerResponse> invoke(OrderDetails it) {
                OrderClient orderClient;
                Intrinsics.f(it, "it");
                orderClient = OrderStateManager.this.f24934c;
                return orderClient.I(it.a(), j8);
            }
        };
        Single<EmptyServerResponse> r8 = r7.r(new Function() { // from class: ee.mtakso.driver.service.modules.order.v2.h0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource D0;
                D0 = OrderStateManager.D0(Function1.this, obj);
                return D0;
            }
        });
        Intrinsics.e(r8, "fun selectNextStop(stopI…geType.SWITCH_STOP)\n    }");
        X(r8, OrderStateChangeType.SWITCH_STOP);
    }

    public final void G0(final String addressText, final GeoCoordinate point) {
        Intrinsics.f(addressText, "addressText");
        Intrinsics.f(point, "point");
        if (!DisposableExtKt.b(this.f24938g)) {
            AssertUtils.b(null, 1, null);
            return;
        }
        Single<OrderDetails> r7 = OrderProviderUtils.r(this.f24932a, OrderState.ORDER_STATE_DRIVING_WITH_CLIENT, OrderState.ORDER_STATE_WAITING_ON_STOP);
        final Function1<OrderDetails, SingleSource<? extends EmptyServerResponse>> function1 = new Function1<OrderDetails, SingleSource<? extends EmptyServerResponse>>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderStateManager$setRideDestination$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends EmptyServerResponse> invoke(OrderDetails it) {
                OrderClient orderClient;
                Intrinsics.f(it, "it");
                orderClient = OrderStateManager.this.f24934c;
                return orderClient.J(it.a(), addressText, point);
            }
        };
        Single<R> r8 = r7.r(new Function() { // from class: ee.mtakso.driver.service.modules.order.v2.p0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource H0;
                H0 = OrderStateManager.H0(Function1.this, obj);
                return H0;
            }
        });
        final Function1<Disposable, Unit> function12 = new Function1<Disposable, Unit>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderStateManager$setRideDestination$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Disposable disposable) {
                PublishSubject publishSubject;
                publishSubject = OrderStateManager.this.f24939h;
                publishSubject.onNext(Notification.c(new OrderStateChangeProgress(OrderStateChangeType.CHANGE_DESTINATION)));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Disposable disposable) {
                b(disposable);
                return Unit.f50853a;
            }
        };
        Single n8 = r8.n(new Consumer() { // from class: ee.mtakso.driver.service.modules.order.v2.q0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderStateManager.I0(Function1.this, obj);
            }
        });
        final Function1<EmptyServerResponse, Unit> function13 = new Function1<EmptyServerResponse, Unit>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderStateManager$setRideDestination$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(EmptyServerResponse emptyServerResponse) {
                PublishSubject publishSubject;
                publishSubject = OrderStateManager.this.f24939h;
                publishSubject.onNext(Notification.c(new OrderStateChangeSuccess(OrderStateChangeType.CHANGE_DESTINATION)));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EmptyServerResponse emptyServerResponse) {
                b(emptyServerResponse);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.modules.order.v2.r0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderStateManager.J0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function14 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderStateManager$setRideDestination$4
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
                PublishSubject publishSubject;
                publishSubject = OrderStateManager.this.f24939h;
                OrderStateChangeType orderStateChangeType = OrderStateChangeType.CHANGE_DESTINATION;
                Intrinsics.e(it, "it");
                publishSubject.onNext(Notification.c(new OrderStateChangeError(orderStateChangeType, it)));
            }
        };
        this.f24938g = n8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.service.modules.order.v2.s0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderStateManager.K0(Function1.this, obj);
            }
        });
    }

    public final void H() {
        Single<OrderDetails> z7 = OrderProviderUtils.z(this.f24932a, OrderState.ORDER_STATE_WAITING_DRIVER_CONFIRMATION, OrderState.ORDER_STATE_DRIVER_ACCEPTED);
        final Function1<OrderDetails, SingleSource<? extends EmptyServerResponse>> function1 = new Function1<OrderDetails, SingleSource<? extends EmptyServerResponse>>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderStateManager$accept$1

            /* compiled from: OrderStateManager.kt */
            /* loaded from: classes3.dex */
            public /* synthetic */ class WhenMappings {

                /* renamed from: a  reason: collision with root package name */
                public static final /* synthetic */ int[] f24941a;

                static {
                    int[] iArr = new int[OrderState.values().length];
                    try {
                        iArr[OrderState.ORDER_STATE_WAITING_DRIVER_CONFIRMATION.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[OrderState.ORDER_STATE_DRIVER_ACCEPTED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f24941a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends EmptyServerResponse> invoke(OrderDetails it) {
                OrderClient orderClient;
                Intrinsics.f(it, "it");
                int i8 = WhenMappings.f24941a[it.b().ordinal()];
                if (i8 == 1) {
                    orderClient = OrderStateManager.this.f24934c;
                    return orderClient.h(it.a());
                } else if (i8 == 2) {
                    Single w7 = Single.w(new EmptyServerResponse(-1, "Fake", null, null));
                    Intrinsics.e(w7, "just(EmptyServerResponse(-1, \"Fake\", null, null))");
                    return w7;
                } else {
                    OrderState b8 = it.b();
                    throw new IllegalStateException("Unexpected order state: " + b8);
                }
            }
        };
        Single<EmptyServerResponse> r7 = z7.r(new Function() { // from class: ee.mtakso.driver.service.modules.order.v2.n0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource I;
                I = OrderStateManager.I(Function1.this, obj);
                return I;
            }
        });
        Intrinsics.e(r7, "fun accept() {\n        /…eChangeType.ACCEPT)\n    }");
        X(r7, OrderStateChangeType.ACCEPT);
    }

    public final void L0() {
        Single<ActiveOrderDetails> p8 = OrderProviderUtils.p(this.f24932a, OrderState.ORDER_STATE_DRIVING_WITH_CLIENT);
        final Function1<ActiveOrderDetails, SingleSource<? extends EmptyServerResponse>> function1 = new Function1<ActiveOrderDetails, SingleSource<? extends EmptyServerResponse>>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderStateManager$visitedStop$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends EmptyServerResponse> invoke(ActiveOrderDetails order) {
                Completable E0;
                OrderClient orderClient;
                Object W;
                Intrinsics.f(order, "order");
                E0 = OrderStateManager.this.E0(order.a());
                orderClient = OrderStateManager.this.f24934c;
                OrderHandle a8 = order.a();
                W = CollectionsKt___CollectionsKt.W(ActiveOrderDetailsKt.a(order));
                return E0.f(orderClient.M(a8, ((UpcomingStop) W).b()));
            }
        };
        Single<R> r7 = p8.r(new Function() { // from class: ee.mtakso.driver.service.modules.order.v2.g0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource M0;
                M0 = OrderStateManager.M0(Function1.this, obj);
                return M0;
            }
        });
        Intrinsics.e(r7, "fun visitedStop() {\n    ….changeOrderState()\n    }");
        Y(this, r7, null, 1, null);
    }

    public final void N() {
        Single<OrderDetails> r7 = OrderProviderUtils.r(this.f24932a, OrderState.ORDER_STATE_DRIVER_ACCEPTED);
        final Function1<OrderDetails, SingleSource<? extends EmptyServerResponse>> function1 = new Function1<OrderDetails, SingleSource<? extends EmptyServerResponse>>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderStateManager$arrivedToPickup$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends EmptyServerResponse> invoke(OrderDetails order) {
                Completable E0;
                OrderClient orderClient;
                Intrinsics.f(order, "order");
                E0 = OrderStateManager.this.E0(order.a());
                orderClient = OrderStateManager.this.f24934c;
                return E0.f(orderClient.m(order.a()));
            }
        };
        Single<R> r8 = r7.r(new Function() { // from class: ee.mtakso.driver.service.modules.order.v2.r
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource O;
                O = OrderStateManager.O(Function1.this, obj);
                return O;
            }
        });
        Intrinsics.e(r8, "fun arrivedToPickup() {\n….changeOrderState()\n    }");
        Y(this, r8, null, 1, null);
    }

    public final void P() {
        if (!DisposableExtKt.b(this.f24938g)) {
            Kalev.e(new RuntimeException("Order is being changed. Failed to arrivedToStop"), "Order is being changed. Failed to arrivedToStop");
            return;
        }
        Single<ActiveOrderDetails> p8 = OrderProviderUtils.p(this.f24932a, OrderState.ORDER_STATE_DRIVING_WITH_CLIENT);
        final Function1<ActiveOrderDetails, SingleSource<? extends StopTimerResponse>> function1 = new Function1<ActiveOrderDetails, SingleSource<? extends StopTimerResponse>>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderStateManager$arrivedToStop$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends StopTimerResponse> invoke(ActiveOrderDetails order) {
                Completable E0;
                OrderClient orderClient;
                long q02;
                Intrinsics.f(order, "order");
                E0 = OrderStateManager.this.E0(order.a());
                orderClient = OrderStateManager.this.f24934c;
                OrderHandle a8 = order.a();
                q02 = OrderStateManager.this.q0(order);
                return E0.f(orderClient.k(a8, q02));
            }
        };
        Single F = p8.r(new Function() { // from class: ee.mtakso.driver.service.modules.order.v2.v
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource Q;
                Q = OrderStateManager.Q(Function1.this, obj);
                return Q;
            }
        }).F(new RetryWithDelaySingle(3, 5000L));
        final Function1<Disposable, Unit> function12 = new Function1<Disposable, Unit>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderStateManager$arrivedToStop$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Disposable disposable) {
                PublishSubject publishSubject;
                publishSubject = OrderStateManager.this.f24939h;
                publishSubject.onNext(Notification.c(new OrderStateChangeProgress(OrderStateChangeType.DEFAULT)));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Disposable disposable) {
                b(disposable);
                return Unit.f50853a;
            }
        };
        Single n8 = F.n(new Consumer() { // from class: ee.mtakso.driver.service.modules.order.v2.w
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderStateManager.R(Function1.this, obj);
            }
        });
        final Function1<StopTimerResponse, Unit> function13 = new Function1<StopTimerResponse, Unit>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderStateManager$arrivedToStop$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(StopTimerResponse stopTimerResponse) {
                PublishSubject publishSubject;
                publishSubject = OrderStateManager.this.f24939h;
                publishSubject.onNext(Notification.c(new OrderStateChangeSuccess(OrderStateChangeType.DEFAULT)));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(StopTimerResponse stopTimerResponse) {
                b(stopTimerResponse);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.modules.order.v2.x
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderStateManager.S(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function14 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderStateManager$arrivedToStop$4
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
                PublishSubject publishSubject;
                publishSubject = OrderStateManager.this.f24939h;
                OrderStateChangeType orderStateChangeType = OrderStateChangeType.DEFAULT;
                Intrinsics.e(it, "it");
                publishSubject.onNext(Notification.c(new OrderStateChangeError(orderStateChangeType, it)));
            }
        };
        this.f24938g = n8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.service.modules.order.v2.y
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderStateManager.T(Function1.this, obj);
            }
        });
    }

    public final void U() {
        if (!DisposableExtKt.b(this.f24937f)) {
            return;
        }
        Single<EmptyServerResponse> y7 = this.f24936e.y();
        final OrderStateManager$cancelDestination$1 orderStateManager$cancelDestination$1 = new Function1<EmptyServerResponse, Unit>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderStateManager$cancelDestination$1
            public final void b(EmptyServerResponse emptyServerResponse) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EmptyServerResponse emptyServerResponse) {
                b(emptyServerResponse);
                return Unit.f50853a;
            }
        };
        Consumer<? super EmptyServerResponse> consumer = new Consumer() { // from class: ee.mtakso.driver.service.modules.order.v2.s
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderStateManager.V(Function1.this, obj);
            }
        };
        final OrderStateManager$cancelDestination$2 orderStateManager$cancelDestination$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderStateManager$cancelDestination$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable error) {
                Intrinsics.e(error, "error");
                Kalev.o(error).b("Failed to cancel destination");
            }
        };
        this.f24937f = y7.I(consumer, new Consumer() { // from class: ee.mtakso.driver.service.modules.order.v2.t
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderStateManager.W(Function1.this, obj);
            }
        });
    }

    public final void c0(final List<ChangeRouteRequest.DestinationStop> destinationStops) {
        Intrinsics.f(destinationStops, "destinationStops");
        if (!DisposableExtKt.b(this.f24938g)) {
            eu.bolt.driver.core.utils.AssertUtils.b(null, 1, null);
            return;
        }
        Single<OrderDetails> r7 = OrderProviderUtils.r(this.f24932a, OrderState.ORDER_STATE_DRIVING_WITH_CLIENT, OrderState.ORDER_STATE_WAITING_ON_STOP);
        final Function1<OrderDetails, SingleSource<? extends EmptyServerResponse>> function1 = new Function1<OrderDetails, SingleSource<? extends EmptyServerResponse>>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderStateManager$changeRoute$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends EmptyServerResponse> invoke(OrderDetails it) {
                OrderClient orderClient;
                Intrinsics.f(it, "it");
                orderClient = OrderStateManager.this.f24934c;
                return orderClient.n(it.a(), destinationStops);
            }
        };
        Single<R> r8 = r7.r(new Function() { // from class: ee.mtakso.driver.service.modules.order.v2.t0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource d02;
                d02 = OrderStateManager.d0(Function1.this, obj);
                return d02;
            }
        });
        final Function1<Disposable, Unit> function12 = new Function1<Disposable, Unit>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderStateManager$changeRoute$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Disposable disposable) {
                PublishSubject publishSubject;
                publishSubject = OrderStateManager.this.f24939h;
                publishSubject.onNext(Notification.c(new OrderStateChangeProgress(OrderStateChangeType.CHANGE_DESTINATION)));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Disposable disposable) {
                b(disposable);
                return Unit.f50853a;
            }
        };
        Single n8 = r8.n(new Consumer() { // from class: ee.mtakso.driver.service.modules.order.v2.u0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderStateManager.e0(Function1.this, obj);
            }
        });
        final Function1<EmptyServerResponse, Unit> function13 = new Function1<EmptyServerResponse, Unit>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderStateManager$changeRoute$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(EmptyServerResponse emptyServerResponse) {
                PublishSubject publishSubject;
                publishSubject = OrderStateManager.this.f24939h;
                publishSubject.onNext(Notification.c(new OrderStateChangeSuccess(OrderStateChangeType.CHANGE_DESTINATION)));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EmptyServerResponse emptyServerResponse) {
                b(emptyServerResponse);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.modules.order.v2.p
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderStateManager.f0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function14 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderStateManager$changeRoute$4
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
                PublishSubject publishSubject;
                publishSubject = OrderStateManager.this.f24939h;
                OrderStateChangeType orderStateChangeType = OrderStateChangeType.CHANGE_DESTINATION;
                Intrinsics.e(it, "it");
                publishSubject.onNext(Notification.c(new OrderStateChangeError(orderStateChangeType, it)));
            }
        };
        this.f24938g = n8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.service.modules.order.v2.q
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderStateManager.g0(Function1.this, obj);
            }
        });
    }

    public final void h0() {
        Single<OrderDetails> r7 = OrderProviderUtils.r(this.f24932a, OrderState.ORDER_STATE_DRIVER_ARRIVED_TO_CLIENT);
        final Function1<OrderDetails, SingleSource<? extends EmptyServerResponse>> function1 = new Function1<OrderDetails, SingleSource<? extends EmptyServerResponse>>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderStateManager$clientArrived$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends EmptyServerResponse> invoke(OrderDetails order) {
                Completable E0;
                OrderClient orderClient;
                Intrinsics.f(order, "order");
                E0 = OrderStateManager.this.E0(order.a());
                orderClient = OrderStateManager.this.f24934c;
                return E0.f(orderClient.p(order.a()));
            }
        };
        Single<R> r8 = r7.r(new Function() { // from class: ee.mtakso.driver.service.modules.order.v2.e0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource i02;
                i02 = OrderStateManager.i0(Function1.this, obj);
                return i02;
            }
        });
        Intrinsics.e(r8, "fun clientArrived() {\n  ….changeOrderState()\n    }");
        Y(this, r8, null, 1, null);
    }

    public final void j0() {
        if (!DisposableExtKt.b(this.f24938g)) {
            AssertUtils.b(null, 1, null);
            return;
        }
        Single<ActiveOrderDetails> p8 = OrderProviderUtils.p(this.f24932a, OrderState.ORDER_STATE_WAITING_ON_STOP);
        final Function1<ActiveOrderDetails, SingleSource<? extends EmptyServerResponse>> function1 = new Function1<ActiveOrderDetails, SingleSource<? extends EmptyServerResponse>>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderStateManager$departFromStop$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends EmptyServerResponse> invoke(ActiveOrderDetails order) {
                Completable E0;
                OrderClient orderClient;
                Object W;
                Intrinsics.f(order, "order");
                E0 = OrderStateManager.this.E0(order.a());
                orderClient = OrderStateManager.this.f24934c;
                OrderHandle a8 = order.a();
                W = CollectionsKt___CollectionsKt.W(ActiveOrderDetailsKt.a(order));
                return E0.f(orderClient.o(a8, ((UpcomingStop) W).b()));
            }
        };
        Single F = p8.r(new Function() { // from class: ee.mtakso.driver.service.modules.order.v2.a0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource l02;
                l02 = OrderStateManager.l0(Function1.this, obj);
                return l02;
            }
        }).F(new RetryWithDelaySingle(3, 5000L));
        final Function1<Disposable, Unit> function12 = new Function1<Disposable, Unit>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderStateManager$departFromStop$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Disposable disposable) {
                PublishSubject publishSubject;
                publishSubject = OrderStateManager.this.f24939h;
                publishSubject.onNext(Notification.c(new OrderStateChangeProgress(OrderStateChangeType.DEFAULT)));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Disposable disposable) {
                b(disposable);
                return Unit.f50853a;
            }
        };
        Single n8 = F.n(new Consumer() { // from class: ee.mtakso.driver.service.modules.order.v2.b0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderStateManager.m0(Function1.this, obj);
            }
        });
        final Function1<EmptyServerResponse, Unit> function13 = new Function1<EmptyServerResponse, Unit>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderStateManager$departFromStop$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(EmptyServerResponse emptyServerResponse) {
                PublishSubject publishSubject;
                publishSubject = OrderStateManager.this.f24939h;
                publishSubject.onNext(Notification.c(new OrderStateChangeSuccess(OrderStateChangeType.DEFAULT)));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EmptyServerResponse emptyServerResponse) {
                b(emptyServerResponse);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.modules.order.v2.c0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderStateManager.n0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function14 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderStateManager$departFromStop$4
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
                PublishSubject publishSubject;
                publishSubject = OrderStateManager.this.f24939h;
                OrderStateChangeType orderStateChangeType = OrderStateChangeType.DEFAULT;
                Intrinsics.e(it, "it");
                publishSubject.onNext(Notification.c(new OrderStateChangeError(orderStateChangeType, it)));
            }
        };
        this.f24938g = n8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.service.modules.order.v2.d0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderStateManager.k0(Function1.this, obj);
            }
        });
    }

    public final Completable o0(final PriceReviewInfo priceReviewInfo, final RateClientInfo rateClientInfo) {
        Intrinsics.f(priceReviewInfo, "priceReviewInfo");
        Single<ActiveOrderDetails> u7 = OrderProviderUtils.u(this.f24932a, OrderState.ORDER_STATE_ARRIVED_TO_DESTINATION);
        final Function1<ActiveOrderDetails, SingleSource<? extends EmptyServerResponse>> function1 = new Function1<ActiveOrderDetails, SingleSource<? extends EmptyServerResponse>>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderStateManager$finalizeOrder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends EmptyServerResponse> invoke(ActiveOrderDetails activeOrderDetails) {
                OrderClient orderClient;
                Intrinsics.f(activeOrderDetails, "activeOrderDetails");
                orderClient = OrderStateManager.this.f24934c;
                return orderClient.q(activeOrderDetails.a(), priceReviewInfo, rateClientInfo);
            }
        };
        Completable v7 = u7.r(new Function() { // from class: ee.mtakso.driver.service.modules.order.v2.f0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource p02;
                p02 = OrderStateManager.p0(Function1.this, obj);
                return p02;
            }
        }).v();
        Intrinsics.e(v7, "fun finalizeOrder(priceR…   .ignoreElement()\n    }");
        return v7;
    }

    public final void r0() {
        Single<OrderDetails> r7 = OrderProviderUtils.r(this.f24932a, OrderState.ORDER_STATE_DRIVING_WITH_CLIENT, OrderState.ORDER_STATE_WAITING_ON_STOP);
        final Function1<OrderDetails, SingleSource<? extends EmptyServerResponse>> function1 = new Function1<OrderDetails, SingleSource<? extends EmptyServerResponse>>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderStateManager$finishRide$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends EmptyServerResponse> invoke(OrderDetails order) {
                Completable E0;
                OrderClient orderClient;
                Intrinsics.f(order, "order");
                E0 = OrderStateManager.this.E0(order.a());
                orderClient = OrderStateManager.this.f24934c;
                return E0.f(orderClient.l(order.a()));
            }
        };
        Single<R> r8 = r7.r(new Function() { // from class: ee.mtakso.driver.service.modules.order.v2.u
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource s02;
                s02 = OrderStateManager.s0(Function1.this, obj);
                return s02;
            }
        });
        Intrinsics.e(r8, "fun finishRide() {\n     ….changeOrderState()\n    }");
        Y(this, r8, null, 1, null);
    }

    public final void t0(OrderHandle orderHandle) {
        ActiveOrderDetails activeOrderDetails;
        ActiveOrderDetails e8;
        Intrinsics.f(orderHandle, "orderHandle");
        OrderDetails e9 = this.f24933b.e(orderHandle);
        if (e9 instanceof ActiveOrderDetails) {
            activeOrderDetails = (ActiveOrderDetails) e9;
        } else {
            activeOrderDetails = null;
        }
        ActiveOrderDetails activeOrderDetails2 = activeOrderDetails;
        if (activeOrderDetails2 != null) {
            OrdersCache ordersCache = this.f24933b;
            e8 = activeOrderDetails2.e((r36 & 1) != 0 ? activeOrderDetails2.a() : null, (r36 & 2) != 0 ? activeOrderDetails2.d() : 0, (r36 & 4) != 0 ? activeOrderDetails2.b() : null, (r36 & 8) != 0 ? activeOrderDetails2.c() : null, (r36 & 16) != 0 ? activeOrderDetails2.f25399e : null, (r36 & 32) != 0 ? activeOrderDetails2.f25400f : 0L, (r36 & 64) != 0 ? activeOrderDetails2.f25401g : true, (r36 & 128) != 0 ? activeOrderDetails2.f25402h : false, (r36 & Spliterator.NONNULL) != 0 ? activeOrderDetails2.f25403i : null, (r36 & 512) != 0 ? activeOrderDetails2.f25404j : 0L, (r36 & Spliterator.IMMUTABLE) != 0 ? activeOrderDetails2.f25405k : null, (r36 & 2048) != 0 ? activeOrderDetails2.f25406l : null, (r36 & 4096) != 0 ? activeOrderDetails2.f25407m : null, (r36 & FragmentTransaction.TRANSIT_EXIT_MASK) != 0 ? activeOrderDetails2.f25408n : null, (r36 & 16384) != 0 ? activeOrderDetails2.f25409o : null, (r36 & 32768) != 0 ? activeOrderDetails2.f25410p : null);
            ordersCache.b(e8);
        }
    }

    public final Observable<Notification<OrderStateChange>> u0() {
        return this.f24939h;
    }

    public final void v0(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        this.f24933b.h(orderHandle);
    }

    public final void w0(CancellationReason cancellationReason) {
        final RejectReasonInfo rejectReasonInfo = null;
        if (!DisposableExtKt.b(this.f24938g)) {
            AssertUtils.b(null, 1, null);
            return;
        }
        if (cancellationReason != null) {
            rejectReasonInfo = new RejectReasonInfo(cancellationReason.a(), cancellationReason.b());
        }
        Single<OrderDetails> r7 = OrderProviderUtils.r(this.f24932a, OrderState.ORDER_STATE_WAITING_DRIVER_CONFIRMATION, OrderState.ORDER_STATE_DRIVER_ACCEPTED, OrderState.ORDER_STATE_DRIVER_ARRIVED_TO_CLIENT);
        final Function1<OrderDetails, SingleSource<? extends RejectOrderResponse>> function1 = new Function1<OrderDetails, SingleSource<? extends RejectOrderResponse>>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderStateManager$rejectOrder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends RejectOrderResponse> invoke(OrderDetails it) {
                OrderClient orderClient;
                Intrinsics.f(it, "it");
                orderClient = OrderStateManager.this.f24934c;
                return orderClient.H(it.a(), rejectReasonInfo);
            }
        };
        Single<R> r8 = r7.r(new Function() { // from class: ee.mtakso.driver.service.modules.order.v2.o
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource y02;
                y02 = OrderStateManager.y0(Function1.this, obj);
                return y02;
            }
        });
        final Function1<Disposable, Unit> function12 = new Function1<Disposable, Unit>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderStateManager$rejectOrder$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Disposable disposable) {
                PublishSubject publishSubject;
                publishSubject = OrderStateManager.this.f24939h;
                publishSubject.onNext(Notification.c(new OrderStateChangeProgress(OrderStateChangeType.CANCEL_CURRENT_ORDER)));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Disposable disposable) {
                b(disposable);
                return Unit.f50853a;
            }
        };
        Single n8 = r8.n(new Consumer() { // from class: ee.mtakso.driver.service.modules.order.v2.z
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderStateManager.z0(Function1.this, obj);
            }
        });
        final Function1<RejectOrderResponse, Unit> function13 = new Function1<RejectOrderResponse, Unit>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderStateManager$rejectOrder$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(RejectOrderResponse rejectOrderResponse) {
                PublishSubject publishSubject;
                publishSubject = OrderStateManager.this.f24939h;
                publishSubject.onNext(Notification.c(new OrderStateChangeSuccessWithData(OrderStateChangeType.CANCEL_CURRENT_ORDER, rejectOrderResponse)));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RejectOrderResponse rejectOrderResponse) {
                b(rejectOrderResponse);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.modules.order.v2.k0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderStateManager.A0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function14 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.modules.order.v2.OrderStateManager$rejectOrder$4
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
                PublishSubject publishSubject;
                publishSubject = OrderStateManager.this.f24939h;
                OrderStateChangeType orderStateChangeType = OrderStateChangeType.CANCEL_CURRENT_ORDER;
                Intrinsics.e(it, "it");
                publishSubject.onNext(Notification.c(new OrderStateChangeError(orderStateChangeType, it)));
            }
        };
        this.f24938g = n8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.service.modules.order.v2.o0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderStateManager.B0(Function1.this, obj);
            }
        });
    }
}
