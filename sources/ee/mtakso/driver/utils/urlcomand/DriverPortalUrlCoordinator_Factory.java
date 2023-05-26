package ee.mtakso.driver.utils.urlcomand;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.screens.settings.MagicLinkInteractor;
import ee.mtakso.driver.utils.CompositeUrlLauncher;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class DriverPortalUrlCoordinator_Factory implements Factory<DriverPortalUrlCoordinator> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<CompositeUrlLauncher> f36474a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<MagicLinkInteractor> f36475b;

    public DriverPortalUrlCoordinator_Factory(Provider<CompositeUrlLauncher> provider, Provider<MagicLinkInteractor> provider2) {
        this.f36474a = provider;
        this.f36475b = provider2;
    }

    public static DriverPortalUrlCoordinator_Factory a(Provider<CompositeUrlLauncher> provider, Provider<MagicLinkInteractor> provider2) {
        return new DriverPortalUrlCoordinator_Factory(provider, provider2);
    }

    public static DriverPortalUrlCoordinator c(CompositeUrlLauncher compositeUrlLauncher, MagicLinkInteractor magicLinkInteractor) {
        return new DriverPortalUrlCoordinator(compositeUrlLauncher, magicLinkInteractor);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverPortalUrlCoordinator get() {
        return c(this.f36474a.get(), this.f36475b.get());
    }
}
