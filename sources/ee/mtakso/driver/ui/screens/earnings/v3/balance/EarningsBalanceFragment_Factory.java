package ee.mtakso.driver.ui.screens.earnings.v3.balance;

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
public final class EarningsBalanceFragment_Factory implements Factory<EarningsBalanceFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f28796a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<RoutingManager> f28797b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DeeplinkDelegate> f28798c;

    public EarningsBalanceFragment_Factory(Provider<BaseUiDependencies> provider, Provider<RoutingManager> provider2, Provider<DeeplinkDelegate> provider3) {
        this.f28796a = provider;
        this.f28797b = provider2;
        this.f28798c = provider3;
    }

    public static EarningsBalanceFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<RoutingManager> provider2, Provider<DeeplinkDelegate> provider3) {
        return new EarningsBalanceFragment_Factory(provider, provider2, provider3);
    }

    public static EarningsBalanceFragment c(BaseUiDependencies baseUiDependencies, RoutingManager routingManager, DeeplinkDelegate deeplinkDelegate) {
        return new EarningsBalanceFragment(baseUiDependencies, routingManager, deeplinkDelegate);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EarningsBalanceFragment get() {
        return c(this.f28796a.get(), this.f28797b.get(), this.f28798c.get());
    }
}
