package ee.mtakso.driver.network.client.order;

import ee.mtakso.driver.network.client.OrderRequest;
import ee.mtakso.driver.network.response.ServerResponse;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/* compiled from: RideHistoryApi.kt */
/* loaded from: classes3.dex */
public interface RideHistoryApi {
    @GET("/orderDriver/v1/getOrderHistory")
    Single<ServerResponse<PreviousOrders>> a();

    @Headers({"Location: Required"})
    @POST("/orderDriver/v1/getPreviousOrder")
    Single<ServerResponse<PreviousOrderDetails>> b(@Body OrderRequest orderRequest);
}
