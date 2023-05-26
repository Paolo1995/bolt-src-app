package ee.mtakso.driver.network.client.auth.authenticated;

import ee.mtakso.driver.network.response.EmptyServerResponse;
import ee.mtakso.driver.network.response.ServerResponse;
import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* compiled from: AuthenticatedAuthApi.kt */
/* loaded from: classes3.dex */
public interface AuthenticatedAuthApi {
    @FormUrlEncoded
    @POST("/driver/logout")
    Single<EmptyServerResponse> a(@Field("refresh_token") String str);

    @FormUrlEncoded
    @POST("/driver/getDriverPortalMagicToken")
    Single<ServerResponse<DriverPortalMagicToken>> b(@Field("version") String str, @Field("device_uid") String str2, @Field("device_name") String str3, @Field("device_os_version") String str4);
}
