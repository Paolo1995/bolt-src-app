package ee.mtakso.driver.network.client.campaign;

import eu.bolt.driver.core.network.response.EmptyServerResponse;
import eu.bolt.driver.core.network.response.ServerResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* compiled from: CampaignApi.kt */
/* loaded from: classes3.dex */
public interface CampaignApi {
    @GET("/driver/v2/getOptinChoices")
    Single<ServerResponse<OptInChoicesV2>> a();

    @GET("/driver/v2/getCampaign")
    Single<ServerResponse<CampaignV2Details>> b(@Query("campaign_id") long j8);

    @GET("/driver/v1/activateOptin")
    Single<EmptyServerResponse> c(@Query("group_id") long j8, @Query("choice_id") long j9);

    @GET("/driver/v2/getInviteCampaignSummary")
    Single<ServerResponse<InviteCampaignV2Summary>> d();

    @GET("/driver/v2/getActiveAndPendingCampaigns")
    Single<ServerResponse<ActiveAndPendingCampaignsV2>> e();

    @GET("/driver/v1/getActiveCampaigns")
    Single<ServerResponse<ActiveAndFutureCampaigns>> f();

    @GET("/driver/v2/getPastCampaigns")
    Single<ServerResponse<PastCampaignsV2>> g(@Query("only_completed") boolean z7, @Query("offset") int i8, @Query("limit") int i9);

    @GET("/driver/v2/getActiveCampaignsInfo")
    Single<ServerResponse<ActiveAndPendingCampaignInfo>> h();
}
