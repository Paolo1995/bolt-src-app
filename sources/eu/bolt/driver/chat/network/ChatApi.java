package eu.bolt.driver.chat.network;

import eu.bolt.driver.core.network.response.ServerResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* compiled from: ChatApi.kt */
/* loaded from: classes5.dex */
public interface ChatApi {
    @GET("/chat/driver/getActiveChats")
    Single<ServerResponse<ActiveChats>> b();

    @GET("/chat/driver/v2/getChatHistory")
    Single<ServerResponse<ChatHistory>> c(@Query("chat_id") String str);
}
