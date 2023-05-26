package ee.mtakso.driver.network.client.analytics;

import ee.mtakso.driver.network.response.EmptyServerResponse;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/* compiled from: LeadAnalyticsApi.kt */
/* loaded from: classes3.dex */
public interface LeadAnalyticsApi {
    @POST("/event/registration/store/")
    Single<EmptyServerResponse> a(@Body AnalyticsRequest analyticsRequest);
}
