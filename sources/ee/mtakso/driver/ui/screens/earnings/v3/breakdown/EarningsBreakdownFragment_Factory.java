package ee.mtakso.driver.ui.screens.earnings.v3.breakdown;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.screens.home.v3.delegate.DeeplinkDelegate;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class EarningsBreakdownFragment_Factory implements Factory<EarningsBreakdownFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f28904a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DeeplinkDelegate> f28905b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<RoutingManager> f28906c;

    public EarningsBreakdownFragment_Factory(Provider<BaseUiDependencies> provider, Provider<DeeplinkDelegate> provider2, Provider<RoutingManager> provider3) {
        this.f28904a = provider;
        this.f28905b = provider2;
        this.f28906c = provider3;
    }

    public static EarningsBreakdownFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<DeeplinkDelegate> provider2, Provider<RoutingManager> provider3) {
        return new EarningsBreakdownFragment_Factory(provider, provider2, provider3);
    }

    public static EarningsBreakdownFragment c(BaseUiDependencies baseUiDependencies, DeeplinkDelegate deeplinkDelegate, RoutingManager routingManager) {
        return new EarningsBreakdownFragment(baseUiDependencies, deeplinkDelegate, routingManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EarningsBreakdownFragment get() {
        return c(this.f28904a.get(), this.f28905b.get(), this.f28906c.get());
    }
}
