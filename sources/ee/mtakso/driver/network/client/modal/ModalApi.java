package ee.mtakso.driver.network.client.modal;

import ee.mtakso.driver.network.response.EmptyServerResponse;
import ee.mtakso.driver.network.response.ServerResponse;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/* compiled from: ModalApi.kt */
/* loaded from: classes3.dex */
public interface ModalApi {
    @Headers({"Location: Required"})
    @POST("/driver/storeModalAction")
    Single<EmptyServerResponse> a(@Body ModalDialogActionReport modalDialogActionReport);

    @Headers({"Location: Required"})
    @GET("/driver/modal")
    Single<ServerResponse<ModalDialogResponse>> b(@Query("event") String str);
}
