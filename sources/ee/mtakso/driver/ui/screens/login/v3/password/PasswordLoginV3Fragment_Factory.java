package ee.mtakso.driver.ui.screens.login.v3.password;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.platform.core.PlatformManager;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.utils.AppResolver;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PasswordLoginV3Fragment_Factory implements Factory<PasswordLoginV3Fragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f30748a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<AppResolver> f30749b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<PlatformManager> f30750c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<RoutingManager> f30751d;

    public PasswordLoginV3Fragment_Factory(Provider<BaseUiDependencies> provider, Provider<AppResolver> provider2, Provider<PlatformManager> provider3, Provider<RoutingManager> provider4) {
        this.f30748a = provider;
        this.f30749b = provider2;
        this.f30750c = provider3;
        this.f30751d = provider4;
    }

    public static PasswordLoginV3Fragment_Factory a(Provider<BaseUiDependencies> provider, Provider<AppResolver> provider2, Provider<PlatformManager> provider3, Provider<RoutingManager> provider4) {
        return new PasswordLoginV3Fragment_Factory(provider, provider2, provider3, provider4);
    }

    public static PasswordLoginV3Fragment c(BaseUiDependencies baseUiDependencies, AppResolver appResolver, PlatformManager platformManager, RoutingManager routingManager) {
        return new PasswordLoginV3Fragment(baseUiDependencies, appResolver, platformManager, routingManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PasswordLoginV3Fragment get() {
        return c(this.f30748a.get(), this.f30749b.get(), this.f30750c.get(), this.f30751d.get());
    }
}
