package ee.mtakso.driver.network.client.order;

import ee.mtakso.driver.network.client.OrderRequest;
import eu.bolt.driver.core.network.response.EmptyServerResponse;
import eu.bolt.driver.core.network.response.ServerResponse;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/* compiled from: DriverOrderApi.kt */
/* loaded from: classes3.dex */
public interface DriverOrderApi {
    @Headers({"Location: Required"})
    @POST("/orderDriver/v1/getActiveOrder")
    Object a(@Body OrderRequest orderRequest, Continuation<? super ServerResponse<Order>> continuation);

    @POST("/driverOrder/disableNewOrders")
    Object b(@Body DisableNewOrderRequest disableNewOrderRequest, Continuation<? super EmptyServerResponse> continuation);
}
