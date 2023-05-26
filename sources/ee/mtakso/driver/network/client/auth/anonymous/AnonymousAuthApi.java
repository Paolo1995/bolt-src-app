package ee.mtakso.driver.network.client.auth.anonymous;

import eu.bolt.driver.core.network.response.ServerResponse;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* compiled from: AnonymousAuthApi.kt */
/* loaded from: classes3.dex */
public interface AnonymousAuthApi {
    @POST("/driver-auth/partnerDriver/resendVerificationCode")
    Single<ServerResponse<VerificationCode>> a(@Body PhoneResendAuthenticationRequest phoneResendAuthenticationRequest);

    @FormUrlEncoded
    @POST("/driver-auth/partnerDriver/authenticateWithMagicLink")
    Single<ee.mtakso.driver.network.response.ServerResponse<RefreshToken>> b(@Field("token") String str, @Field("version") String str2, @Field("device_uid") String str3, @Field("device_name") String str4, @Field("device_os_version") String str5);

    @POST("/driver-auth/partnerDriver/startAuthentication")
    Single<ServerResponse<VerificationCode>> c(@Body PhoneAuthenticationRequest phoneAuthenticationRequest);

    @FormUrlEncoded
    @POST("/driver-auth/partnerDriver/getAccessToken/")
    Single<ServerResponse<AccessToken>> d(@Field("refresh_token") String str);

    @FormUrlEncoded
    @POST("/driver-auth/partnerDriver/v2/confirmAuthentication/")
    Single<ee.mtakso.driver.network.response.ServerResponse<ConfirmAuthenticationResponse>> e(@Field("verification_token") String str, @Field("verification_code") String str2, @Field("device_uid") String str3, @Field("device_name") String str4, @Field("device_os_version") String str5);
}
