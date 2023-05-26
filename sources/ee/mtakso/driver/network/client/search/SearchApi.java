package ee.mtakso.driver.network.client.search;

import ee.mtakso.driver.network.response.ServerResponse;
import io.reactivex.Single;
import retrofit2.http.GET;

/* compiled from: SearchApi.kt */
/* loaded from: classes3.dex */
public interface SearchApi {
    @GET("/search/driver/getOtherActiveDrivers/")
    Single<ServerResponse<Drivers>> a();
}
