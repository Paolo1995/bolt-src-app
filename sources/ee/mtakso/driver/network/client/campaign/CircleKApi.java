package ee.mtakso.driver.network.client.campaign;

import ee.mtakso.driver.network.response.ServerResponse;
import io.reactivex.Single;
import retrofit2.http.GET;

/* compiled from: CircleKApi.kt */
/* loaded from: classes3.dex */
public interface CircleKApi {
    @GET("/driver/getLoyaltySignupMagicLink")
    Single<ServerResponse<CircleKLoyaltySignUpMagicLink>> a();
}
