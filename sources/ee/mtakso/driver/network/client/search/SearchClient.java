package ee.mtakso.driver.network.client.search;

import dagger.Lazy;
import ee.mtakso.driver.network.response.CompositeResponseTransformer;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SearchClient.kt */
/* loaded from: classes3.dex */
public final class SearchClient {

    /* renamed from: a  reason: collision with root package name */
    private final Lazy<SearchApi> f22778a;

    /* renamed from: b  reason: collision with root package name */
    private final CompositeResponseTransformer f22779b;

    @Inject
    public SearchClient(Lazy<SearchApi> api, CompositeResponseTransformer transformer) {
        Intrinsics.f(api, "api");
        Intrinsics.f(transformer, "transformer");
        this.f22778a = api;
        this.f22779b = transformer;
    }

    public final Single<Drivers> a() {
        return SingleExtKt.g(this.f22778a.get().a(), this.f22779b);
    }
}
