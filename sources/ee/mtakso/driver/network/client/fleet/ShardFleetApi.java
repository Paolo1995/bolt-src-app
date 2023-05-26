package ee.mtakso.driver.network.client.fleet;

import ee.mtakso.driver.network.response.EmptyDestinationServerResponse;
import ee.mtakso.driver.network.response.EmptyServerResponse;
import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* compiled from: ShardFleetApi.kt */
/* loaded from: classes3.dex */
public interface ShardFleetApi {
    @POST("/orderDriver/removeActiveDriverDestination/")
    Single<EmptyServerResponse> a();

    @FormUrlEncoded
    @POST("/orderDriver/setActiveDriverDestination/")
    Single<EmptyDestinationServerResponse> b(@Field("driver_destination_id") long j8);
}
