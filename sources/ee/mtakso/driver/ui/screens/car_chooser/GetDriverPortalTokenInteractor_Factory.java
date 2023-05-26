package ee.mtakso.driver.ui.screens.car_chooser;

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
public final class GetDriverPortalTokenInteractor_Factory implements Factory<GetDriverPortalTokenInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<AuthenticatedAuthClient> f27725a;

    public GetDriverPortalTokenInteractor_Factory(Provider<AuthenticatedAuthClient> provider) {
        this.f27725a = provider;
    }

    public static GetDriverPortalTokenInteractor_Factory a(Provider<AuthenticatedAuthClient> provider) {
        return new GetDriverPortalTokenInteractor_Factory(provider);
    }

    public static GetDriverPortalTokenInteractor c(AuthenticatedAuthClient authenticatedAuthClient) {
        return new GetDriverPortalTokenInteractor(authenticatedAuthClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public GetDriverPortalTokenInteractor get() {
        return c(this.f27725a.get());
    }
}
