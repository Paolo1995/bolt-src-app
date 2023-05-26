package ee.mtakso.driver.ui.screens.login.v3.login;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class LoginV3Fragment_Factory implements Factory<LoginV3Fragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f30703a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<RoutingManager> f30704b;

    public LoginV3Fragment_Factory(Provider<BaseUiDependencies> provider, Provider<RoutingManager> provider2) {
        this.f30703a = provider;
        this.f30704b = provider2;
    }

    public static LoginV3Fragment_Factory a(Provider<BaseUiDependencies> provider, Provider<RoutingManager> provider2) {
        return new LoginV3Fragment_Factory(provider, provider2);
    }

    public static LoginV3Fragment c(BaseUiDependencies baseUiDependencies, RoutingManager routingManager) {
        return new LoginV3Fragment(baseUiDependencies, routingManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LoginV3Fragment get() {
        return c(this.f30703a.get(), this.f30704b.get());
    }
}
