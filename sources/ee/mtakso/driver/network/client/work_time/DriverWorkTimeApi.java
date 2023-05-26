package ee.mtakso.driver.network.client.work_time;

import ee.mtakso.driver.network.response.ServerResponse;
import io.reactivex.Single;
import retrofit2.http.GET;

/* compiled from: DriverWorkTimeApi.kt */
/* loaded from: classes3.dex */
public interface DriverWorkTimeApi {
    @GET("/driver/getWorkingTimeInfo")
    Single<ServerResponse<WorkingTimeInfo>> a();
}
