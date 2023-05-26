package ee.mtakso.driver.ui.screens.order.scheduled;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.interactor.order.scheduled.GetAcceptedOrdersInteractor;
import ee.mtakso.driver.ui.interactor.order.scheduled.GetScheduledOrdersInteractor;
import eu.bolt.android.engine.html.HtmlEngine;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ScheduledOrdersViewModel_Factory implements Factory<ScheduledOrdersViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<GetScheduledOrdersInteractor> f31823a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<GetAcceptedOrdersInteractor> f31824b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ScheduledOrderListModelFactory> f31825c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ScheduledOrderInfoBlockMapper> f31826d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<HtmlEngine> f31827e;

    public ScheduledOrdersViewModel_Factory(Provider<GetScheduledOrdersInteractor> provider, Provider<GetAcceptedOrdersInteractor> provider2, Provider<ScheduledOrderListModelFactory> provider3, Provider<ScheduledOrderInfoBlockMapper> provider4, Provider<HtmlEngine> provider5) {
        this.f31823a = provider;
        this.f31824b = provider2;
        this.f31825c = provider3;
        this.f31826d = provider4;
        this.f31827e = provider5;
    }

    public static ScheduledOrdersViewModel_Factory a(Provider<GetScheduledOrdersInteractor> provider, Provider<GetAcceptedOrdersInteractor> provider2, Provider<ScheduledOrderListModelFactory> provider3, Provider<ScheduledOrderInfoBlockMapper> provider4, Provider<HtmlEngine> provider5) {
        return new ScheduledOrdersViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static ScheduledOrdersViewModel c(GetScheduledOrdersInteractor getScheduledOrdersInteractor, GetAcceptedOrdersInteractor getAcceptedOrdersInteractor, ScheduledOrderListModelFactory scheduledOrderListModelFactory, ScheduledOrderInfoBlockMapper scheduledOrderInfoBlockMapper, HtmlEngine htmlEngine) {
        return new ScheduledOrdersViewModel(getScheduledOrdersInteractor, getAcceptedOrdersInteractor, scheduledOrderListModelFactory, scheduledOrderInfoBlockMapper, htmlEngine);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ScheduledOrdersViewModel get() {
        return c(this.f31823a.get(), this.f31824b.get(), this.f31825c.get(), this.f31826d.get(), this.f31827e.get());
    }
}
