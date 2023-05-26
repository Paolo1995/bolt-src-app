package ee.mtakso.driver.network.client.contact;

import ee.mtakso.driver.network.response.ServerResponse;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/* compiled from: ContactApi.kt */
/* loaded from: classes3.dex */
public interface ContactApi {
    @GET("/comms-manager/driver/getAllContactConfigurations")
    Single<ServerResponse<ContactConfigurationsResponse>> a();

    @POST("/comms-manager/driver/getContactOptionDetails")
    Single<ServerResponse<ContactOptionsDetailsResponse>> b(@Body ContactOptionsDetailsRequest contactOptionsDetailsRequest);

    @POST("/comms-manager/driver/getAvailableContactOptions")
    Single<ServerResponse<AvailableContactOptionsResponse>> c(@Body AvailableContactOptionsRequest availableContactOptionsRequest);
}
