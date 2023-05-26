package eu.bolt.driver.earnings.network;

import eu.bolt.driver.core.network.response.ServerResponse;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* compiled from: EarningsBalanceApi.kt */
/* loaded from: classes5.dex */
public interface EarningsBalanceApi {
    @GET("/driver/v2/getBalanceHistory")
    Object a(@Query("id") String str, @Query("last_page") String str2, Continuation<? super ServerResponse<BalanceHistory>> continuation);

    @GET("/driver/v2/getBalanceScreen")
    Object b(Continuation<? super ServerResponse<BalanceScreen>> continuation);
}
