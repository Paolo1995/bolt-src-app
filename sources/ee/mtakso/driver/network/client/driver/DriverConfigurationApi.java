package ee.mtakso.driver.network.client.driver;

import eu.bolt.driver.core.network.client.driver.DriverConfiguration;
import eu.bolt.driver.core.network.response.ServerResponse;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;

/* compiled from: DriverConfigurationApi.kt */
/* loaded from: classes3.dex */
public interface DriverConfigurationApi {
    @GET("/driver/getLoggedInDriverConfiguration")
    Object a(Continuation<? super ServerResponse<DriverConfiguration>> continuation);
}
