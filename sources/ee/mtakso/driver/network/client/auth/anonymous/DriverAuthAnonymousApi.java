package ee.mtakso.driver.network.client.auth.anonymous;

import ee.mtakso.driver.network.client.targeting.TargetingParameters;
import eu.bolt.driver.core.network.response.EmptyServerResponse;
import eu.bolt.driver.core.network.response.ServerResponse;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/* compiled from: DriverAuthAnonymousApi.kt */
/* loaded from: classes3.dex */
public interface DriverAuthAnonymousApi {
    @FormUrlEncoded
    @POST("/driver/getAccessToken")
    Single<ServerResponse<AccessToken>> a(@Field("refresh_token") String str);

    @GET("/driver/getAuthenticationConfiguration")
    Single<ServerResponse<AuthConfigurationResponse>> b(@Query("auth_method") String str, @Query("app_store") String str2);

    @FormUrlEncoded
    @POST("/driver/completeAuthentication")
    Single<ServerResponse<RefreshToken>> c(@Field("verification_token") String str, @Field("code") String str2, @Field("device_uid") String str3, @Field("device_name") String str4, @Field("device_os_version") String str5);

    @FormUrlEncoded
    @POST("/driver/resendVerificationCode")
    Single<ServerResponse<VerificationCode>> d(@Field("verification_token") String str, @Field("channel") String str2, @Field("device_uid") String str3, @Field("device_name") String str4, @Field("device_os_version") String str5);

    @POST("/driver/startAuthentication")
    Single<ServerResponse<AuthResultResponse>> e(@Body StartAuthenticationRequest startAuthenticationRequest);

    @FormUrlEncoded
    @POST("/driver/sendMagicLink")
    Single<EmptyServerResponse> f(@Field("email") String str, @Field("version") String str2, @Field("device_uid") String str3, @Field("device_name") String str4, @Field("device_os_version") String str5);

    @GET("/driver/getLoginConfiguration")
    Single<ServerResponse<TargetingParameters>> g();

    @POST("/driver/authenticateWithMagicLink")
    Single<ServerResponse<RefreshToken>> h(@Body AuthenticateWithMagicLinkRequest authenticateWithMagicLinkRequest);

    @FormUrlEncoded
    @POST("/driver/authenticate")
    Single<ServerResponse<RefreshToken>> i(@Field("username") String str, @Field("password") String str2, @Field("version") String str3, @Field("device_uid") String str4, @Field("device_name") String str5, @Field("device_os_version") String str6);
}
