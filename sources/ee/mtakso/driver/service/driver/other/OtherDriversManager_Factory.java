package ee.mtakso.driver.service.driver.other;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.search.SearchClient;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OtherDriversManager_Factory implements Factory<OtherDriversManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<SearchClient> f24343a;

    public OtherDriversManager_Factory(Provider<SearchClient> provider) {
        this.f24343a = provider;
    }

    public static OtherDriversManager_Factory a(Provider<SearchClient> provider) {
        return new OtherDriversManager_Factory(provider);
    }

    public static OtherDriversManager c(SearchClient searchClient) {
        return new OtherDriversManager(searchClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OtherDriversManager get() {
        return c(this.f24343a.get());
    }
}
