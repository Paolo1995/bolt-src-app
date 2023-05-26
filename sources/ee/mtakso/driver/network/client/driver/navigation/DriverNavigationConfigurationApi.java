package ee.mtakso.driver.network.client.driver.navigation;

import eu.bolt.driver.core.network.response.ServerResponse;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/* compiled from: DriverNavigationConfigurationApi.kt */
/* loaded from: classes3.dex */
public interface DriverNavigationConfigurationApi {
    @Headers({"Location: Required"})
    @GET("/driver/getDriverNavigationOptions")
    Object a(Continuation<? super ServerResponse<DynamicNavigation>> continuation);
}
