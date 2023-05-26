package ee.mtakso.driver.network.client.support;

import ee.mtakso.driver.network.response.ServerResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* compiled from: SupportApi.kt */
/* loaded from: classes3.dex */
public interface SupportApi {
    @GET("/driver/getSupportWebappLinkForInbox")
    Single<ServerResponse<SupportWebAppLinkResponse>> a();

    @GET("/driver/getSupportWebappLinkForSettings")
    Single<ServerResponse<SupportWebAppLinkResponse>> b();

    @GET("/driver/getSupportWebappLinkForPush")
    Single<ServerResponse<SupportWebAppLinkResponse>> c(@Query("webapp_launch_token") String str);

    @GET("/driver/getSupportWebappLinkForRideDetails")
    Single<ServerResponse<SupportWebAppLinkResponse>> d(@Query("order_system") String str, @Query("city_id") long j8, @Query("order_id") long j9);
}
