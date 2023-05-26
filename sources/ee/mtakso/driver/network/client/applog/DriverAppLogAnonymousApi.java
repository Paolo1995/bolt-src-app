package ee.mtakso.driver.network.client.applog;

import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/* compiled from: DriverAppLogAnonymousApi.kt */
/* loaded from: classes3.dex */
public interface DriverAppLogAnonymousApi {
    @POST("/driver/logNoAuth")
    Call<JsonObject> a(@Body LogUploadRequest logUploadRequest);
}
