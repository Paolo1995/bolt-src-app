package eu.bolt.driver.earnings.network;

import eu.bolt.driver.core.network.response.ServerResponse;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* compiled from: EarningsApi.kt */
/* loaded from: classes5.dex */
public interface EarningsApi {
    @GET("/driver/getEarningBreakdownScreen")
    Object a(@Query("start_date") long j8, @Query("end_date") long j9, Continuation<? super ServerResponse<EarningBreakdownScreen>> continuation);

    @GET("/driver/getEarningLandingScreen")
    Object b(Continuation<? super ServerResponse<EarningLandingScreen>> continuation);

    @GET("/driver/getEarningBreakdownIntervals")
    Object c(Continuation<? super ServerResponse<EarningBreakdownIntervals>> continuation);

    @GET("/driver/getEarningPayoutExplanation")
    Object d(Continuation<? super ServerResponse<EarningPayoutExplanationResponse>> continuation);
}
