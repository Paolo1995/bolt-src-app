package ee.mtakso.driver.network.client.boltclub;

import ee.mtakso.driver.network.client.boltclub.model.BoltClubOfferDetailsResponse;
import ee.mtakso.driver.network.client.boltclub.model.BoltClubOffersResponse;
import eu.bolt.driver.core.network.response.EmptyServerResponse;
import eu.bolt.driver.core.network.response.ServerResponse;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* compiled from: BoltClubApi.kt */
/* loaded from: classes3.dex */
public interface BoltClubApi {
    @POST("/driver/boltClub/getOfferDetails")
    Single<ServerResponse<BoltClubOfferDetailsResponse>> a(@Body BoltClubDetailsRequest boltClubDetailsRequest);

    @POST("/driver/boltClub/setOfferFavouriteStatus")
    Single<EmptyServerResponse> b(@Body FavouriteStatusRequest favouriteStatusRequest);

    @FormUrlEncoded
    @POST("/driver/boltClub/getOfferList")
    Single<ServerResponse<BoltClubOffersResponse>> c(@Field("language") String str);
}
