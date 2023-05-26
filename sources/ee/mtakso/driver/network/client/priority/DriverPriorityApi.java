package ee.mtakso.driver.network.client.priority;

import ee.mtakso.driver.network.response.ServerResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/* compiled from: DriverPriorityApi.kt */
/* loaded from: classes3.dex */
public interface DriverPriorityApi {
    @Headers({"Location: Required"})
    @GET("orderDriver/v1/getPriorityOverview")
    Single<ServerResponse<DriverPriorityResponse>> a();
}
