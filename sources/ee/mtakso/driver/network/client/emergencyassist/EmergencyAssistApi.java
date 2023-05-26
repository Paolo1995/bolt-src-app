package ee.mtakso.driver.network.client.emergencyassist;

import ee.mtakso.driver.network.client.emergencyassist.help_provider.ExternalHelpProviderResponse;
import ee.mtakso.driver.network.client.emergencyassist.local_authority.DidYouGetHelpRequest;
import ee.mtakso.driver.network.client.emergencyassist.reverse_geocode.EmergencyAssistReverseGeocodeResponse;
import ee.mtakso.driver.network.client.emergencyassist.third_party_incident.RequestExternalHelpResponse;
import ee.mtakso.driver.network.client.emergencyassist.third_party_incident.RequestExternalHelpUpdateRequest;
import ee.mtakso.driver.network.client.incident.OpenIncidentRequest;
import eu.bolt.driver.core.network.response.EmptyServerResponse;
import eu.bolt.driver.core.network.response.ServerResponse;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/* compiled from: EmergencyAssistApi.kt */
/* loaded from: classes3.dex */
public interface EmergencyAssistApi {
    @POST("/driver/safety/emergencyAssist/requestExternalHelp")
    Single<ServerResponse<RequestExternalHelpResponse>> a(@Body OpenIncidentRequest openIncidentRequest);

    @GET("/driver/reverseGeocode")
    Single<ServerResponse<EmergencyAssistReverseGeocodeResponse>> b(@Query("lat") double d8, @Query("lng") double d9);

    @POST("/driver/safety/emergencyAssist/noHelpNeeded")
    Single<EmptyServerResponse> c(@Body DidYouGetHelpRequest didYouGetHelpRequest);

    @POST("/driver/safety/emergencyAssist/requestExternalHelpUpdate")
    Single<EmptyServerResponse> d(@Body RequestExternalHelpUpdateRequest requestExternalHelpUpdateRequest);

    @POST("/driver/safety/emergencyAssist/requestBoltHelp")
    Single<EmptyServerResponse> e(@Body DidYouGetHelpRequest didYouGetHelpRequest);

    @GET("/driver/safety/emergencyAssist/getExternalHelpProvider")
    Single<ServerResponse<ExternalHelpProviderResponse>> f(@Query("lat") double d8, @Query("lng") double d9);
}
