package ee.mtakso.driver.network.client.partner;

import ee.mtakso.driver.network.client.auth.anonymous.RefreshToken;
import eu.bolt.driver.core.network.response.EmptyServerResponse;
import eu.bolt.driver.core.network.response.ServerResponse;
import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/* compiled from: PartnerApi.kt */
/* loaded from: classes3.dex */
public interface PartnerApi {
    @FormUrlEncoded
    @POST("/driver-auth/partnerDriver/setDeviceToken/")
    Single<EmptyServerResponse> a(@Field("device_token") String str);

    @GET("/driver-auth/partnerDriver/getDriverRefreshToken")
    Single<ServerResponse<RefreshToken>> b();
}
