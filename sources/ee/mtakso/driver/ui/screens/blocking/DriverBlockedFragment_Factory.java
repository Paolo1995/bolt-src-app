package ee.mtakso.driver.ui.screens.blocking;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.utils.CompositeUrlLauncher;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class DriverBlockedFragment_Factory implements Factory<DriverBlockedFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f27088a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<RoutingManager> f27089b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<CompositeUrlLauncher> f27090c;

    public DriverBlockedFragment_Factory(Provider<BaseUiDependencies> provider, Provider<RoutingManager> provider2, Provider<CompositeUrlLauncher> provider3) {
        this.f27088a = provider;
        this.f27089b = provider2;
        this.f27090c = provider3;
    }

    public static DriverBlockedFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<RoutingManager> provider2, Provider<CompositeUrlLauncher> provider3) {
        return new DriverBlockedFragment_Factory(provider, provider2, provider3);
    }

    public static DriverBlockedFragment c(BaseUiDependencies baseUiDependencies, RoutingManager routingManager, CompositeUrlLauncher compositeUrlLauncher) {
        return new DriverBlockedFragment(baseUiDependencies, routingManager, compositeUrlLauncher);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverBlockedFragment get() {
        return c(this.f27088a.get(), this.f27089b.get(), this.f27090c.get());
    }
}
