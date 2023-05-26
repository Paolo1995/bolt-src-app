package ee.mtakso.driver.network.client.price;

import ee.mtakso.driver.network.response.ServerResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* compiled from: PriceReviewApi.kt */
/* loaded from: classes3.dex */
public interface PriceReviewApi {
    @GET("/priceReview/getReasonsList")
    Single<ServerResponse<PriceReviewReasons>> a(@Query("order_id") long j8);
}
