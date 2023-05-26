package ee.mtakso.driver.ui.screens.order.scheduled;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.interactor.order.scheduled.GetScheduledOrdersInteractor;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ScheduledOrdersGroupViewModel_Factory implements Factory<ScheduledOrdersGroupViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<GetScheduledOrdersInteractor> f31798a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ScheduledOrderListModelFactory> f31799b;

    public ScheduledOrdersGroupViewModel_Factory(Provider<GetScheduledOrdersInteractor> provider, Provider<ScheduledOrderListModelFactory> provider2) {
        this.f31798a = provider;
        this.f31799b = provider2;
    }

    public static ScheduledOrdersGroupViewModel_Factory a(Provider<GetScheduledOrdersInteractor> provider, Provider<ScheduledOrderListModelFactory> provider2) {
        return new ScheduledOrdersGroupViewModel_Factory(provider, provider2);
    }

    public static ScheduledOrdersGroupViewModel c(GetScheduledOrdersInteractor getScheduledOrdersInteractor, ScheduledOrderListModelFactory scheduledOrderListModelFactory) {
        return new ScheduledOrdersGroupViewModel(getScheduledOrdersInteractor, scheduledOrderListModelFactory);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ScheduledOrdersGroupViewModel get() {
        return c(this.f31798a.get(), this.f31799b.get());
    }
}
