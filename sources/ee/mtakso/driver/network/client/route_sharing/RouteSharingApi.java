package ee.mtakso.driver.network.client.route_sharing;

import ee.mtakso.driver.network.response.ServerResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* compiled from: RouteSharingApi.kt */
/* loaded from: classes3.dex */
public interface RouteSharingApi {
    @GET("/routeSharing/getDriverRouteSharingUrlByOrderId")
    Single<ServerResponse<RouteSharing>> a(@Query("city_id") long j8, @Query("order_id") long j9);
}
