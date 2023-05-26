package ee.mtakso.driver.ui.screens.order.scheduled;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.order.ScheduledOrderManager;
import ee.mtakso.driver.ui.interactor.order.scheduled.GetUpcomingOrderDetailsInteractor;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ScheduledOrderDetailsViewModel_Factory implements Factory<ScheduledOrderDetailsViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<GetUpcomingOrderDetailsInteractor> f31722a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ScheduledOrderManager> f31723b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ScheduledOrderDetailsStateFactory> f31724c;

    public ScheduledOrderDetailsViewModel_Factory(Provider<GetUpcomingOrderDetailsInteractor> provider, Provider<ScheduledOrderManager> provider2, Provider<ScheduledOrderDetailsStateFactory> provider3) {
        this.f31722a = provider;
        this.f31723b = provider2;
        this.f31724c = provider3;
    }

    public static ScheduledOrderDetailsViewModel_Factory a(Provider<GetUpcomingOrderDetailsInteractor> provider, Provider<ScheduledOrderManager> provider2, Provider<ScheduledOrderDetailsStateFactory> provider3) {
        return new ScheduledOrderDetailsViewModel_Factory(provider, provider2, provider3);
    }

    public static ScheduledOrderDetailsViewModel c(GetUpcomingOrderDetailsInteractor getUpcomingOrderDetailsInteractor, ScheduledOrderManager scheduledOrderManager, ScheduledOrderDetailsStateFactory scheduledOrderDetailsStateFactory) {
        return new ScheduledOrderDetailsViewModel(getUpcomingOrderDetailsInteractor, scheduledOrderManager, scheduledOrderDetailsStateFactory);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ScheduledOrderDetailsViewModel get() {
        return c(this.f31722a.get(), this.f31723b.get(), this.f31724c.get());
    }
}
