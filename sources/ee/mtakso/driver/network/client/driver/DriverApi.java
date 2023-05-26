package ee.mtakso.driver.network.client.driver;

import ee.mtakso.driver.network.client.driver.surge.SurgeResponse;
import ee.mtakso.driver.network.response.DestinationServerResponse;
import ee.mtakso.driver.network.response.EmptyServerResponse;
import ee.mtakso.driver.network.response.ServerResponse;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/* compiled from: DriverApi.kt */
/* loaded from: classes3.dex */
public interface DriverApi {
    @FormUrlEncoded
    @POST("/driver/setDeviceToken/")
    Single<EmptyServerResponse> a(@Field("device_token") String str);

    @Headers({"Location: Optional"})
    @POST("/polling/driver")
    Single<ServerResponse<PollingResult>> b(@Body PollingRequest pollingRequest);

    @POST("/orderDriver/driverStartWorking/")
    Single<DestinationServerResponse<DriverMightBeBlocked>> c(@Body StartWorkingRequest startWorkingRequest, @Header("environment_data") String str);

    @GET("/orderDriver/getCurrentSurges/")
    Single<ServerResponse<SurgeResponse>> d(@Query("lat") double d8, @Query("lng") double d9);

    @GET("/driver/getCars/")
    Single<ServerResponse<Cars>> e();

    @GET("/orderDriver/getActivityHours/")
    Single<ServerResponse<DriverHours>> f(@Query("group_by") String str);

    @Headers({"Location: Required"})
    @POST("/tracking/v1/storeLocations/")
    Single<EmptyServerResponse> g(@Body DriverGpsLocationsRequest driverGpsLocationsRequest);

    @GET("/orderDriver/getActivityRides/")
    Single<ServerResponse<DriverRides>> h(@Query("group_by") String str);

    @GET("/orderDriver/getActivityCancels/")
    Single<ServerResponse<DriverCancels>> i();

    @FormUrlEncoded
    @POST("/orderDriver/driverSetMaxClientDistance/")
    Single<EmptyServerResponse> j(@Field("max_client_distance") double d8);

    @FormUrlEncoded
    @POST("/orderDriver/setTakeNewOrdersDuringOrder")
    Single<EmptyServerResponse> k(@Field("is_taking") int i8);

    @Headers({"Location: Optional"})
    @POST("/orderDriver/v1/getMapsConfigs")
    Single<ServerResponse<DriverMapsConfigs>> l();

    @POST("/orderDriver/v1/getMapsConfigsExplanation")
    Single<ServerResponse<DriverMapsConfigsExplanation>> m(@Query("theme") String str);

    @FormUrlEncoded
    @POST("/orderDriver/driverSetInactive/")
    Single<EmptyServerResponse> n(@Field("aeNXG3wGxeqTkvNkDlCQk1em") String str);

    @Headers({"Location: Required"})
    @POST("/orderDriver/v1/findClientDestinationAddresses/")
    Single<ServerResponse<AddressSuggestions>> o(@Body SearchClientDestinationRequest searchClientDestinationRequest);

    @FormUrlEncoded
    @POST("/driver/updateProfile/")
    Single<EmptyServerResponse> p(@Field("language") String str);

    @FormUrlEncoded
    @POST("/driver/selectCar/")
    Single<EmptyServerResponse> q(@Field("car_id") long j8);
}
