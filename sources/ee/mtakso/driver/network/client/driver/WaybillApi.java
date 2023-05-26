package ee.mtakso.driver.network.client.driver;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.response.ServerResponse;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/* compiled from: WaybillApi.kt */
/* loaded from: classes3.dex */
public interface WaybillApi {
    @POST("/driver/getWaybill")
    Single<ServerResponse<WayBillData>> a(@Body OrderHandle orderHandle);
}
