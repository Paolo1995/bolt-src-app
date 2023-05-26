package ee.mtakso.driver.network.client.vehicle;

import ee.mtakso.driver.network.response.ServerResponse;
import io.reactivex.Single;
import retrofit2.http.GET;

/* compiled from: CarApplicationApi.kt */
/* loaded from: classes3.dex */
public interface CarApplicationApi {
    @GET("/driver/getVehiclesAndApplications")
    Single<ServerResponse<VehiclesAndApplications>> a();
}
