package ee.mtakso.driver.network.client.order;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.OrderRequest;
import ee.mtakso.driver.network.client.ShardApiProvider;
import ee.mtakso.driver.network.client.order.ChangeRouteRequest;
import ee.mtakso.driver.network.response.CompositeResponseTransformer;
import ee.mtakso.driver.network.response.EmptyServerResponse;
import ee.mtakso.driver.network.response.ResponseErrorProcessor;
import ee.mtakso.driver.network.response.ServerResponse;
import ee.mtakso.driver.network.response.ServerResponseKt;
import ee.mtakso.driver.service.geo.GeoCoordinate;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderClient.kt */
/* loaded from: classes3.dex */
public final class OrderClient {

    /* renamed from: a  reason: collision with root package name */
    private final ShardApiProvider f22408a;

    /* renamed from: b  reason: collision with root package name */
    private final CompositeResponseTransformer f22409b;

    /* renamed from: c  reason: collision with root package name */
    private final ResponseErrorProcessor f22410c;

    @Inject
    public OrderClient(ShardApiProvider apiProvider, CompositeResponseTransformer responseTransformer, ResponseErrorProcessor errorProcessor) {
        Intrinsics.f(apiProvider, "apiProvider");
        Intrinsics.f(responseTransformer, "responseTransformer");
        Intrinsics.f(errorProcessor, "errorProcessor");
        this.f22408a = apiProvider;
        this.f22409b = responseTransformer;
        this.f22410c = errorProcessor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OrderCompletionReason A(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (OrderCompletionReason) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduledRideRequests D(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ScheduledRideRequests) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduledRideDetails F(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ScheduledRideDetails) tmp0.invoke(obj);
    }

    private final PriceReviewRequest K(PriceReviewInfo priceReviewInfo) {
        long c8 = priceReviewInfo.c();
        return new PriceReviewRequest(priceReviewInfo.g().doubleValue(), c8, priceReviewInfo.h(), priceReviewInfo.e(), priceReviewInfo.f(), priceReviewInfo.d());
    }

    private final RateClientRequest L(RateClientInfo rateClientInfo) {
        return new RateClientRequest(rateClientInfo.c(), rateClientInfo.b(), rateClientInfo.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AcceptScheduledRideResponse j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (AcceptScheduledRideResponse) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AcceptedScheduledRides s(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (AcceptedScheduledRides) tmp0.invoke(obj);
    }

    private final OrderApi t() {
        return this.f22408a.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FifoQueueStateResponse w(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (FifoQueueStateResponse) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FifoQueueStateForDriverResponse y(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (FifoQueueStateForDriverResponse) tmp0.invoke(obj);
    }

    public final Single<PricingData> B(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        return SingleExtKt.g(t().a(new OrderRequest(orderHandle)), this.f22409b);
    }

    public final Single<ScheduledRideRequests> C(String str) {
        Single<ServerResponse<ScheduledRideRequests>> d8 = t().d(new ScheduledRidesGroupRequest(str));
        final OrderClient$getScheduledRideRequests$1 orderClient$getScheduledRideRequests$1 = new Function1<ServerResponse<ScheduledRideRequests>, ScheduledRideRequests>() { // from class: ee.mtakso.driver.network.client.order.OrderClient$getScheduledRideRequests$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ScheduledRideRequests invoke(ServerResponse<ScheduledRideRequests> it) {
                Intrinsics.f(it, "it");
                return (ScheduledRideRequests) ServerResponseKt.b(it);
            }
        };
        Single x7 = d8.x(new Function() { // from class: ee.mtakso.driver.network.client.order.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ScheduledRideRequests D;
                D = OrderClient.D(Function1.this, obj);
                return D;
            }
        });
        Intrinsics.e(x7, "api.getScheduledRideRequ…).map { it.exposeData() }");
        return x7;
    }

    public final Single<ScheduledRideDetails> E(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        Single<ServerResponse<ScheduledRideDetails>> b8 = t().b(new OrderRequest(orderHandle));
        final OrderClient$getUpcomingRideDetails$1 orderClient$getUpcomingRideDetails$1 = new Function1<ServerResponse<ScheduledRideDetails>, ScheduledRideDetails>() { // from class: ee.mtakso.driver.network.client.order.OrderClient$getUpcomingRideDetails$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ScheduledRideDetails invoke(ServerResponse<ScheduledRideDetails> it) {
                Intrinsics.f(it, "it");
                return (ScheduledRideDetails) ServerResponseKt.b(it);
            }
        };
        Single x7 = b8.x(new Function() { // from class: ee.mtakso.driver.network.client.order.f
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ScheduledRideDetails F;
                F = OrderClient.F(Function1.this, obj);
                return F;
            }
        });
        Intrinsics.e(x7, "api.getUpcomingRideDetai…).map { it.exposeData() }");
        return x7;
    }

    public final Single<StopSummary> G(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        return SingleExtKt.g(t().v(new OrderRequest(orderHandle)), this.f22409b);
    }

    public final Single<RejectOrderResponse> H(OrderHandle orderHandle, RejectReasonInfo rejectReasonInfo) {
        Intrinsics.f(orderHandle, "orderHandle");
        return SingleExtKt.g(t().m(new RejectOrderRequest(orderHandle, rejectReasonInfo)), this.f22409b);
    }

    public final Single<EmptyServerResponse> I(OrderHandle orderHandle, long j8) {
        Intrinsics.f(orderHandle, "orderHandle");
        return SingleExtKt.e(t().n(new StopRequest(orderHandle, String.valueOf(j8))), this.f22410c);
    }

    public final Single<EmptyServerResponse> J(OrderHandle orderHandle, String address, GeoCoordinate point) {
        Intrinsics.f(orderHandle, "orderHandle");
        Intrinsics.f(address, "address");
        Intrinsics.f(point, "point");
        return SingleExtKt.e(t().o(new SetDestinationRequest(orderHandle, address, point.a(), point.b())), this.f22410c);
    }

    public final Single<EmptyServerResponse> M(OrderHandle orderHandle, long j8) {
        Intrinsics.f(orderHandle, "orderHandle");
        return SingleExtKt.e(t().e(new StopRequest(orderHandle, String.valueOf(j8))), this.f22410c);
    }

    public final Single<EmptyServerResponse> h(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        return SingleExtKt.e(t().k(new OrderRequest(orderHandle)), this.f22410c);
    }

    public final Single<AcceptScheduledRideResponse> i(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        Single<ServerResponse<AcceptScheduledRideResponse>> g8 = t().g(new OrderRequest(orderHandle));
        final OrderClient$acceptScheduledRide$1 orderClient$acceptScheduledRide$1 = new Function1<ServerResponse<AcceptScheduledRideResponse>, AcceptScheduledRideResponse>() { // from class: ee.mtakso.driver.network.client.order.OrderClient$acceptScheduledRide$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final AcceptScheduledRideResponse invoke(ServerResponse<AcceptScheduledRideResponse> it) {
                Intrinsics.f(it, "it");
                return (AcceptScheduledRideResponse) ServerResponseKt.b(it);
            }
        };
        Single x7 = g8.x(new Function() { // from class: ee.mtakso.driver.network.client.order.g
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                AcceptScheduledRideResponse j8;
                j8 = OrderClient.j(Function1.this, obj);
                return j8;
            }
        });
        Intrinsics.e(x7, "api.acceptScheduledRide(…).map { it.exposeData() }");
        return x7;
    }

    public final Single<StopTimerResponse> k(OrderHandle orderHandle, long j8) {
        Intrinsics.f(orderHandle, "orderHandle");
        return SingleExtKt.g(t().h(new StopRequest(orderHandle, String.valueOf(j8))), this.f22409b);
    }

    public final Single<EmptyServerResponse> l(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        return SingleExtKt.e(t().l(new OrderRequest(orderHandle)), this.f22410c);
    }

    public final Single<EmptyServerResponse> m(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        return SingleExtKt.e(t().t(new OrderRequest(orderHandle)), this.f22410c);
    }

    public final Single<EmptyServerResponse> n(OrderHandle orderHandle, List<ChangeRouteRequest.DestinationStop> destinationStops) {
        Intrinsics.f(orderHandle, "orderHandle");
        Intrinsics.f(destinationStops, "destinationStops");
        return t().c(new ChangeRouteRequest(orderHandle, destinationStops));
    }

    public final Single<EmptyServerResponse> o(OrderHandle orderHandle, long j8) {
        Intrinsics.f(orderHandle, "orderHandle");
        return SingleExtKt.e(t().s(new StopRequest(orderHandle, String.valueOf(j8))), this.f22410c);
    }

    public final Single<EmptyServerResponse> p(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        return SingleExtKt.e(t().i(new OrderRequest(orderHandle)), this.f22410c);
    }

    public final Single<EmptyServerResponse> q(OrderHandle orderHandle, PriceReviewInfo priceReviewInfo, RateClientInfo rateClientInfo) {
        RateClientRequest rateClientRequest;
        Intrinsics.f(orderHandle, "orderHandle");
        Intrinsics.f(priceReviewInfo, "priceReviewInfo");
        OrderApi t7 = t();
        if (rateClientInfo != null) {
            rateClientRequest = L(rateClientInfo);
        } else {
            rateClientRequest = null;
        }
        return SingleExtKt.e(t7.q(new FinalizeOrderRequest(orderHandle, rateClientRequest, K(priceReviewInfo))), this.f22410c);
    }

    public final Single<AcceptedScheduledRides> r() {
        Single<ServerResponse<AcceptedScheduledRides>> p8 = t().p();
        final OrderClient$getAcceptedScheduledRides$1 orderClient$getAcceptedScheduledRides$1 = new Function1<ServerResponse<AcceptedScheduledRides>, AcceptedScheduledRides>() { // from class: ee.mtakso.driver.network.client.order.OrderClient$getAcceptedScheduledRides$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final AcceptedScheduledRides invoke(ServerResponse<AcceptedScheduledRides> it) {
                Intrinsics.f(it, "it");
                return (AcceptedScheduledRides) ServerResponseKt.b(it);
            }
        };
        Single x7 = p8.x(new Function() { // from class: ee.mtakso.driver.network.client.order.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                AcceptedScheduledRides s7;
                s7 = OrderClient.s(Function1.this, obj);
                return s7;
            }
        });
        Intrinsics.e(x7, "api.getAcceptedScheduled…).map { it.exposeData() }");
        return x7;
    }

    public final Single<Price> u(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        return SingleExtKt.g(t().f(new OrderRequest(orderHandle)), this.f22409b);
    }

    public final Single<FifoQueueStateResponse> v() {
        Single<ServerResponse<FifoQueueStateResponse>> j8 = t().j(new FifoQueueStateRequest(1L));
        final OrderClient$getFifoQueueState$1 orderClient$getFifoQueueState$1 = new Function1<ServerResponse<FifoQueueStateResponse>, FifoQueueStateResponse>() { // from class: ee.mtakso.driver.network.client.order.OrderClient$getFifoQueueState$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final FifoQueueStateResponse invoke(ServerResponse<FifoQueueStateResponse> it) {
                Intrinsics.f(it, "it");
                return (FifoQueueStateResponse) ServerResponseKt.b(it);
            }
        };
        Single x7 = j8.x(new Function() { // from class: ee.mtakso.driver.network.client.order.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                FifoQueueStateResponse w7;
                w7 = OrderClient.w(Function1.this, obj);
                return w7;
            }
        });
        Intrinsics.e(x7, "api.getFifoQueueState(Fi… .map { it.exposeData() }");
        return x7;
    }

    public final Single<FifoQueueStateForDriverResponse> x() {
        Single<ServerResponse<FifoQueueStateForDriverResponse>> r7 = t().r(new FifoQueueStateForDriverRequest(1L));
        final OrderClient$getFifoQueueStateForDriver$1 orderClient$getFifoQueueStateForDriver$1 = new Function1<ServerResponse<FifoQueueStateForDriverResponse>, FifoQueueStateForDriverResponse>() { // from class: ee.mtakso.driver.network.client.order.OrderClient$getFifoQueueStateForDriver$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final FifoQueueStateForDriverResponse invoke(ServerResponse<FifoQueueStateForDriverResponse> it) {
                Intrinsics.f(it, "it");
                return (FifoQueueStateForDriverResponse) ServerResponseKt.b(it);
            }
        };
        Single x7 = r7.x(new Function() { // from class: ee.mtakso.driver.network.client.order.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                FifoQueueStateForDriverResponse y7;
                y7 = OrderClient.y(Function1.this, obj);
                return y7;
            }
        });
        Intrinsics.e(x7, "api.getFifoQueueStateFor… .map { it.exposeData() }");
        return x7;
    }

    public final Single<OrderCompletionReason> z(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        Single<ServerResponse<OrderCompletionReason>> w7 = t().w(new OrderRequest(orderHandle));
        final OrderClient$getOrderCompletionReason$1 orderClient$getOrderCompletionReason$1 = new Function1<ServerResponse<OrderCompletionReason>, OrderCompletionReason>() { // from class: ee.mtakso.driver.network.client.order.OrderClient$getOrderCompletionReason$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final OrderCompletionReason invoke(ServerResponse<OrderCompletionReason> it) {
                Intrinsics.f(it, "it");
                return (OrderCompletionReason) ServerResponseKt.b(it);
            }
        };
        Single x7 = w7.x(new Function() { // from class: ee.mtakso.driver.network.client.order.e
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                OrderCompletionReason A;
                A = OrderClient.A(Function1.this, obj);
                return A;
            }
        });
        Intrinsics.e(x7, "api.getOrderCompletionRe…).map { it.exposeData() }");
        return x7;
    }
}
