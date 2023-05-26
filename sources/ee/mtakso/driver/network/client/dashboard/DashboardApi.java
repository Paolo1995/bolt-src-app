package ee.mtakso.driver.network.client.dashboard;

import ee.mtakso.driver.network.response.ServerResponse;
import io.reactivex.Single;
import retrofit2.http.GET;

/* compiled from: DashboardApi.kt */
/* loaded from: classes3.dex */
public interface DashboardApi {
    @GET("/orderDriver/v1/getDriverHomeScreen")
    Single<ServerResponse<DriverHomeScreenResponse>> a();
}
