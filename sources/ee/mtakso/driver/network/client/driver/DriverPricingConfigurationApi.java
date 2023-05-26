package ee.mtakso.driver.network.client.driver;

import eu.bolt.driver.core.network.response.ServerResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/* compiled from: DriverPricingConfigurationApi.kt */
/* loaded from: classes3.dex */
public interface DriverPricingConfigurationApi {
    @Headers({"Location: Required"})
    @GET("/driver/getDriverPricingConfiguration")
    Single<ServerResponse<DriverPricingConfiguration>> a();
}
