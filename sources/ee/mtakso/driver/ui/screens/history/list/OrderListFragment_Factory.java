package ee.mtakso.driver.ui.screens.history.list;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeDialogDelegate;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class OrderListFragment_Factory implements Factory<OrderListFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f29595a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<RoutingManager> f29596b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<RateMeDialogDelegate> f29597c;

    public OrderListFragment_Factory(Provider<BaseUiDependencies> provider, Provider<RoutingManager> provider2, Provider<RateMeDialogDelegate> provider3) {
        this.f29595a = provider;
        this.f29596b = provider2;
        this.f29597c = provider3;
    }

    public static OrderListFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<RoutingManager> provider2, Provider<RateMeDialogDelegate> provider3) {
        return new OrderListFragment_Factory(provider, provider2, provider3);
    }

    public static OrderListFragment c(BaseUiDependencies baseUiDependencies, RoutingManager routingManager, RateMeDialogDelegate rateMeDialogDelegate) {
        return new OrderListFragment(baseUiDependencies, routingManager, rateMeDialogDelegate);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OrderListFragment get() {
        return c(this.f29595a.get(), this.f29596b.get(), this.f29597c.get());
    }
}
