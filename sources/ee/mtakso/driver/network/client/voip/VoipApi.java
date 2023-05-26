package ee.mtakso.driver.network.client.voip;

import ee.mtakso.driver.network.response.EmptyServerResponse;
import ee.mtakso.driver.network.response.ServerResponse;
import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* compiled from: VoipApi.kt */
/* loaded from: classes3.dex */
public interface VoipApi {
    @FormUrlEncoded
    @POST("/voip/driver/getCallbackDetails")
    Single<ServerResponse<CallbackOptions>> a(@Field("context") String str);

    @FormUrlEncoded
    @POST("/voip/driver/rateVoipCall")
    Single<EmptyServerResponse> b(@Field("rating") int i8, @Field("call_id") String str);
}
