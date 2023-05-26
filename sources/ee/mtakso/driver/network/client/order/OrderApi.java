package ee.mtakso.driver.network.client.order;

import ee.mtakso.driver.network.client.OrderRequest;
import ee.mtakso.driver.network.response.EmptyServerResponse;
import ee.mtakso.driver.network.response.ServerResponse;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/* compiled from: OrderApi.kt */
/* loaded from: classes3.dex */
public interface OrderApi {
    @Headers({"Location: Required"})
    @POST("/orderDriver/v1/getOrderPricing/")
    Single<ServerResponse<PricingData>> a(@Body OrderRequest orderRequest);

    @POST("/orderDriver/v1/getUpcomingRideDetails")
    Single<ServerResponse<ScheduledRideDetails>> b(@Body OrderRequest orderRequest);

    @Headers({"Location: Required"})
    @POST("/orderDriver/v1/changeRoute")
    Single<EmptyServerResponse> c(@Body ChangeRouteRequest changeRouteRequest);

    @Headers({"Location: Required"})
    @POST("/orderDriver/v1/getScheduledRideRequests")
    Single<ServerResponse<ScheduledRideRequests>> d(@Body ScheduledRidesGroupRequest scheduledRidesGroupRequest);

    @Headers({"Location: Required"})
    @POST("/orderDriver/v1/visitStop")
    Single<EmptyServerResponse> e(@Body StopRequest stopRequest);

    @Headers({"Location: Required"})
    @POST("/orderDriver/v1/getPrice/")
    Single<ServerResponse<Price>> f(@Body OrderRequest orderRequest);

    @Headers({"Location: Required"})
    @POST("/orderDriver/v1/acceptScheduledRide")
    Single<ServerResponse<AcceptScheduledRideResponse>> g(@Body OrderRequest orderRequest);

    @Headers({"Location: Required"})
    @POST("/orderDriver/v1/arriveToStop")
    Single<ServerResponse<StopTimerResponse>> h(@Body StopRequest stopRequest);

    @Headers({"Location: Required"})
    @POST("/orderDriver/v1/drivingWithClient/")
    Single<EmptyServerResponse> i(@Body OrderRequest orderRequest);

    @Headers({"Location: Required"})
    @POST("/orderDriver/v1/getFifoQueueState")
    Single<ServerResponse<FifoQueueStateResponse>> j(@Body FifoQueueStateRequest fifoQueueStateRequest);

    @Headers({"Location: Required"})
    @POST("/orderDriver/v1/acceptOrder/")
    Single<EmptyServerResponse> k(@Body OrderRequest orderRequest);

    @Headers({"Location: Required"})
    @POST("/orderDriver/v1/finishOrder/")
    Single<EmptyServerResponse> l(@Body OrderRequest orderRequest);

    @Headers({"Location: Required"})
    @POST("/orderDriver/v1/rejectOrder/")
    Single<ServerResponse<RejectOrderResponse>> m(@Body RejectOrderRequest rejectOrderRequest);

    @Headers({"Location: Required"})
    @POST("/orderDriver/v1/selectNextStop")
    Single<EmptyServerResponse> n(@Body StopRequest stopRequest);

    @Headers({"Location: Required"})
    @POST("/orderDriver/v1/setDestination")
    Single<EmptyServerResponse> o(@Body SetDestinationRequest setDestinationRequest);

    @Headers({"Location: Required"})
    @POST("/orderDriver/v1/getAcceptedScheduledRides")
    Single<ServerResponse<AcceptedScheduledRides>> p();

    @Headers({"Location: Required"})
    @POST("/orderDriver/v1/finalizeOrder")
    Single<EmptyServerResponse> q(@Body FinalizeOrderRequest finalizeOrderRequest);

    @Headers({"Location: Required"})
    @POST("/orderDriver/v1/getFifoQueueStateForDriver")
    Single<ServerResponse<FifoQueueStateForDriverResponse>> r(@Body FifoQueueStateForDriverRequest fifoQueueStateForDriverRequest);

    @Headers({"Location: Required"})
    @POST("/orderDriver/v1/departFromStop")
    Single<EmptyServerResponse> s(@Body StopRequest stopRequest);

    @Headers({"Location: Required"})
    @POST("/orderDriver/v1/arrivedToClient/")
    Single<EmptyServerResponse> t(@Body OrderRequest orderRequest);

    @GET("/orderDriver/getDriverSummaryStatistics")
    Single<ServerResponse<DriverStatisticsSummary>> u();

    @Headers({"Location: Required"})
    @POST("/orderDriver/v1/getCurrentWaitPeriodSummary")
    Single<ServerResponse<StopSummary>> v(@Body OrderRequest orderRequest);

    @POST("/orderDriver/v1/getOrderCompletionReason")
    Single<ServerResponse<OrderCompletionReason>> w(@Body OrderRequest orderRequest);
}
