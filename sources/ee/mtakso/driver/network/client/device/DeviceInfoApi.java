package ee.mtakso.driver.network.client.device;

import ee.mtakso.driver.network.response.EmptyServerResponse;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/* compiled from: DeviceInfoApi.kt */
/* loaded from: classes3.dex */
public interface DeviceInfoApi {
    @POST("/driverPhoneDetails")
    Single<EmptyServerResponse> a(@Body DeviceFingerprint deviceFingerprint);

    @POST("/deviceEvent")
    Single<EmptyServerResponse> b(@Body DeviceEvent deviceEvent);
}
