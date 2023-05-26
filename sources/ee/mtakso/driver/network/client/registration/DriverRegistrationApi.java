package ee.mtakso.driver.network.client.registration;

import ee.mtakso.driver.network.response.ServerResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* compiled from: DriverRegistrationApi.kt */
/* loaded from: classes3.dex */
public interface DriverRegistrationApi {
    @GET("/driver/getDriverRegistrationStatus")
    Single<ServerResponse<DriverRegistrationCompletionStatus>> a(@Query("hash") String str);
}
