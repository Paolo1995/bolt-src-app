package ee.mtakso.driver.network.client.score;

import ee.mtakso.driver.network.response.ServerResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* compiled from: DriverScoreApi.kt */
/* loaded from: classes3.dex */
public interface DriverScoreApi {
    @GET("/driver/getScore")
    Single<ServerResponse<DriverScoreResponse>> a();

    @GET("/driver/getScoreOverview")
    Single<ServerResponse<DriverScoreOverviewResponse>> b();

    @GET("/driver/getScoreExplanation")
    Single<ServerResponse<DriverScoreExplanationResponse>> c(@Query("theme") String str);
}
