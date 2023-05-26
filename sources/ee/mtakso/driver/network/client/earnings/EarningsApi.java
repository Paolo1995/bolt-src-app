package ee.mtakso.driver.network.client.earnings;

import ee.mtakso.driver.network.response.ServerResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/* compiled from: EarningsApi.kt */
/* loaded from: classes3.dex */
public interface EarningsApi {
    @Headers({"Location: Required"})
    @GET("/driver/checkPayToBolt")
    Single<ServerResponse<PayToBoltResponse>> a();

    @Headers({"Location: Required"})
    @GET("/driver/getReportIntervalList")
    Single<ServerResponse<ReportIntervals>> b(@Query("mode_key") String str);

    @Headers({"Location: Required"})
    @GET("/driver/getReportScreenChart")
    Single<ServerResponse<EarningsChartResponse>> c(@Query("interval_key") String str);

    @Headers({"Location: Required"})
    @GET("/driver/getReportScreen")
    Single<ServerResponse<ReportScreen>> d(@Query("interval_key") String str, @Query("screen") String str2);

    @Headers({"Location: Required"})
    @GET("/driver/getReportScreensConfig")
    Single<ServerResponse<EarningsReportScreenConfig>> e();
}
