package eu.bolt.driver.earnings.network;

import eu.bolt.driver.core.network.response.EmptyServerResponse;
import eu.bolt.driver.core.network.response.ServerResponse;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/* compiled from: EarningsGoalApi.kt */
/* loaded from: classes5.dex */
public interface EarningsGoalApi {
    @POST("/driver/deleteDriverEarningsGoal")
    Single<EmptyServerResponse> a();

    @GET("/driver/getDriverEarningsGoal")
    Single<ServerResponse<GetEarningsGoalResponse>> b();

    @POST("/driver/keepDriverEarningsGoalTarget")
    Single<EmptyServerResponse> c();

    @POST("/driver/setDriverEarningsGoal")
    Single<EmptyServerResponse> d(@Body SetEarningsGoalRequest setEarningsGoalRequest);
}
