package ee.mtakso.driver.ui.screens.order.lookup.orderdestination;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class OrderDestinationFragment_Factory implements Factory<OrderDestinationFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f31476a;

    public OrderDestinationFragment_Factory(Provider<BaseUiDependencies> provider) {
        this.f31476a = provider;
    }

    public static OrderDestinationFragment_Factory a(Provider<BaseUiDependencies> provider) {
        return new OrderDestinationFragment_Factory(provider);
    }

    public static OrderDestinationFragment c(BaseUiDependencies baseUiDependencies) {
        return new OrderDestinationFragment(baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OrderDestinationFragment get() {
        return c(this.f31476a.get());
    }
}
