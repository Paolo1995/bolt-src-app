package eu.bolt.driver.stories.network;

import eu.bolt.android.stories.model.Story;
import eu.bolt.driver.core.network.response.ServerResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/* compiled from: StoriesApi.kt */
/* loaded from: classes5.dex */
public interface StoriesApi {
    @Headers({"Location: Required"})
    @GET("/comms/driver/getStoryPreviews")
    Single<ServerResponse<StoriesPreviewsResponse>> a();

    @GET("/comms/driver/story/get")
    Single<ServerResponse<Story>> b(@Query("id") String str);
}
