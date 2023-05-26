package ee.mtakso.driver.network.client.settings;

import ee.mtakso.driver.network.response.DestinationServerResponse;
import ee.mtakso.driver.network.response.EmptyServerResponse;
import ee.mtakso.driver.network.response.ServerResponse;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/* compiled from: SettingsApi.kt */
/* loaded from: classes3.dex */
public interface SettingsApi {
    @Headers({"Location: Required"})
    @POST("dispatchPref/v1/updateSettings")
    Single<ServerResponse<SettingsResponse>> a(@Body SettingsUpdateRequest settingsUpdateRequest);

    @FormUrlEncoded
    @POST("/driver/addDriverDestination/")
    Single<DestinationServerResponse<DriverDestinationId>> b(@Field("type") String str, @Field("name") String str2, @Field("address") String str3, @Field("lat") double d8, @Field("lng") double d9);

    @Headers({"Location: Required"})
    @GET("dispatchPref/v1/getSettings")
    Single<ServerResponse<SettingsResponse>> c();

    @Headers({"Location: Required"})
    @POST("dispatchPref/v1/setDriverPricingState")
    Single<EmptyServerResponse> d(@Body SetDriverPricingStateRequest setDriverPricingStateRequest);

    @FormUrlEncoded
    @POST("/driver/deleteDriverDestination/")
    Single<EmptyServerResponse> e(@Field("driver_destination_id") long j8);

    @GET("/driver/getDriverDestinations/")
    Single<ServerResponse<DriverDestinations>> f();

    @FormUrlEncoded
    @POST("/driver/updateDriverDestination/")
    Single<DestinationServerResponse<DriverDestinationId>> g(@Field("driver_destination_id") long j8, @Field("type") String str, @Field("name") String str2, @Field("address") String str3, @Field("lat") double d8, @Field("lng") double d9);
}
