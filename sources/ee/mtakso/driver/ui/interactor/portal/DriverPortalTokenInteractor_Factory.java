package ee.mtakso.driver.ui.interactor.portal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.auth.authenticated.AuthenticatedAuthClient;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverPortalTokenInteractor_Factory implements Factory<DriverPortalTokenInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<AuthenticatedAuthClient> f26792a;

    public DriverPortalTokenInteractor_Factory(Provider<AuthenticatedAuthClient> provider) {
        this.f26792a = provider;
    }

    public static DriverPortalTokenInteractor_Factory a(Provider<AuthenticatedAuthClient> provider) {
        return new DriverPortalTokenInteractor_Factory(provider);
    }

    public static DriverPortalTokenInteractor c(AuthenticatedAuthClient authenticatedAuthClient) {
        return new DriverPortalTokenInteractor(authenticatedAuthClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverPortalTokenInteractor get() {
        return c(this.f26792a.get());
    }
}
