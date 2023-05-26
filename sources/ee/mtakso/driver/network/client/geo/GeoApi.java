package ee.mtakso.driver.network.client.geo;

import ee.mtakso.driver.network.response.ServerResponse;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/* compiled from: GeoApi.kt */
/* loaded from: classes3.dex */
public interface GeoApi {
    @GET("/driver/findExternalSourceAddresses")
    Single<ServerResponse<ExternalSourceAddresses>> a(@Query("lat") double d8, @Query("lng") double d9, @Query("user_id") Long l8, @Query("search_string") String str, @Query("limit") int i8);

    @GET("/driver/findExternalSourceAddressDetails")
    Single<ServerResponse<ExternalSourceAddressDetails>> b(@Query("source") String str, @Query("user_id") Long l8, @Query("place_id") String str2);

    @Headers({"Location: Required"})
    @POST("/driver/getDrivingDirections")
    Single<ServerResponse<Directions>> c(@Body DrivingDirectionsParams drivingDirectionsParams);
}
