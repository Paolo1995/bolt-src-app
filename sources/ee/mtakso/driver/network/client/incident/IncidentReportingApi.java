package ee.mtakso.driver.network.client.incident;

import ee.mtakso.driver.network.response.EmptyServerResponse;
import ee.mtakso.driver.network.response.ServerResponse;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* compiled from: IncidentReportingApi.kt */
/* loaded from: classes3.dex */
public interface IncidentReportingApi {
    @FormUrlEncoded
    @POST("/driver/updateIncident")
    Single<EmptyServerResponse> a(@Field("incident_id") long j8, @Field("lat") double d8, @Field("lng") double d9);

    @POST("/driver/createIncident")
    Single<ServerResponse<OpenIncidentResult>> b(@Body OpenIncidentRequest openIncidentRequest);
}
