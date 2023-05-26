package ee.mtakso.driver.ui.screens.settings;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.auth.authenticated.AuthenticatedAuthClient;
import ee.mtakso.driver.utils.UrlFactory;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class MagicLinkInteractor_Factory implements Factory<MagicLinkInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<UrlFactory> f33011a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<AuthenticatedAuthClient> f33012b;

    public MagicLinkInteractor_Factory(Provider<UrlFactory> provider, Provider<AuthenticatedAuthClient> provider2) {
        this.f33011a = provider;
        this.f33012b = provider2;
    }

    public static MagicLinkInteractor_Factory a(Provider<UrlFactory> provider, Provider<AuthenticatedAuthClient> provider2) {
        return new MagicLinkInteractor_Factory(provider, provider2);
    }

    public static MagicLinkInteractor c(UrlFactory urlFactory, AuthenticatedAuthClient authenticatedAuthClient) {
        return new MagicLinkInteractor(urlFactory, authenticatedAuthClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MagicLinkInteractor get() {
        return c(this.f33011a.get(), this.f33012b.get());
    }
}
