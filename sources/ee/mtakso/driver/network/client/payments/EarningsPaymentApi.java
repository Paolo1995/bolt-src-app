package ee.mtakso.driver.network.client.payments;

import ee.mtakso.driver.network.response.ServerResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

/* compiled from: EarningsPaymentApi.kt */
/* loaded from: classes3.dex */
public interface EarningsPaymentApi {
    @POST
    Single<ServerResponse<EarningsPayment>> a(@Url String str);

    @GET
    Single<ServerResponse<EarningsPayment>> b(@Url String str);
}
