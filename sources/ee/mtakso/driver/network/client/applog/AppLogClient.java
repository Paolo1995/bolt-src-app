package ee.mtakso.driver.network.client.applog;

import com.google.gson.JsonObject;
import dagger.Lazy;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.http.Body;

/* compiled from: AppLogClient.kt */
/* loaded from: classes3.dex */
public final class AppLogClient {

    /* renamed from: a  reason: collision with root package name */
    private final Lazy<DriverAppLogAnonymousApi> f21357a;

    @Inject
    public AppLogClient(Lazy<DriverAppLogAnonymousApi> api) {
        Intrinsics.f(api, "api");
        this.f21357a = api;
    }

    public final Call<JsonObject> a(@Body LogUploadRequest body) {
        Intrinsics.f(body, "body");
        return this.f21357a.get().a(body);
    }
}
