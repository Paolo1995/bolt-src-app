package ee.mtakso.driver.network.client.earnings;

import ee.mtakso.driver.network.response.ServerResponse;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/* compiled from: PayoutApi.kt */
/* loaded from: classes3.dex */
public interface PayoutApi {
    @Headers({"Location: Required"})
    @GET("/driver/getPayoutHistory")
    Single<ServerResponse<PayoutHistoryResponce>> a();

    @Headers({"Location: Required"})
    @GET("/driver/getPayoutRequestConfirmation")
    Single<ServerResponse<PayoutConfirmationResponce>> b();

    @Headers({"Location: Required"})
    @GET("/driver/getPaymentSection")
    Single<ServerResponse<PaymentSettingsResponse>> c();

    @Headers({"Location: Required"})
    @GET("/driver/getPayToBoltUrl")
    Single<ServerResponse<PayToBoltLinkResponse>> d();

    @Headers({"Location: Required"})
    @GET("/driver/getPayout")
    Single<ServerResponse<PayoutResponce>> e(@Query("id") long j8);

    @Headers({"Location: Required"})
    @POST("/driver/createPayoutRequest")
    Single<ServerResponse<CreatePayoutResponse>> f(@Body CreatePayoutRequest createPayoutRequest);
}
