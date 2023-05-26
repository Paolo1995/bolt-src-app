package ee.mtakso.driver.network.client.search;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.response.CompositeResponseTransformer;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class SearchClient_Factory implements Factory<SearchClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<SearchApi> f22780a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<CompositeResponseTransformer> f22781b;

    public SearchClient_Factory(Provider<SearchApi> provider, Provider<CompositeResponseTransformer> provider2) {
        this.f22780a = provider;
        this.f22781b = provider2;
    }

    public static SearchClient_Factory a(Provider<SearchApi> provider, Provider<CompositeResponseTransformer> provider2) {
        return new SearchClient_Factory(provider, provider2);
    }

    public static SearchClient c(Lazy<SearchApi> lazy, CompositeResponseTransformer compositeResponseTransformer) {
        return new SearchClient(lazy, compositeResponseTransformer);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SearchClient get() {
        return c(DoubleCheck.lazy(this.f22780a), this.f22781b.get());
    }
}
