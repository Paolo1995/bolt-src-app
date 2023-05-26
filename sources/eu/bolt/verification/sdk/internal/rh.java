package eu.bolt.verification.sdk.internal;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

@g0(name = "comms")
/* loaded from: classes5.dex */
public interface rh {
    @GET("story/get")
    Single<jj> c(@Query("id") String str);
}
