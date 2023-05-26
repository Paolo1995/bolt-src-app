package ee.mtakso.driver.ui.screens.order.scheduled;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.android.engine.html.HtmlEngine;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ScheduledOrderDetailsComponentFactory_Factory implements Factory<ScheduledOrderDetailsComponentFactory> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ScheduledOrderInfoBlockMapper> f31675a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ScheduledOrderButtonAppearanceMapper> f31676b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<HtmlEngine> f31677c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<OrderMapPointsFactory> f31678d;

    public ScheduledOrderDetailsComponentFactory_Factory(Provider<ScheduledOrderInfoBlockMapper> provider, Provider<ScheduledOrderButtonAppearanceMapper> provider2, Provider<HtmlEngine> provider3, Provider<OrderMapPointsFactory> provider4) {
        this.f31675a = provider;
        this.f31676b = provider2;
        this.f31677c = provider3;
        this.f31678d = provider4;
    }

    public static ScheduledOrderDetailsComponentFactory_Factory a(Provider<ScheduledOrderInfoBlockMapper> provider, Provider<ScheduledOrderButtonAppearanceMapper> provider2, Provider<HtmlEngine> provider3, Provider<OrderMapPointsFactory> provider4) {
        return new ScheduledOrderDetailsComponentFactory_Factory(provider, provider2, provider3, provider4);
    }

    public static ScheduledOrderDetailsComponentFactory c(ScheduledOrderInfoBlockMapper scheduledOrderInfoBlockMapper, ScheduledOrderButtonAppearanceMapper scheduledOrderButtonAppearanceMapper, HtmlEngine htmlEngine, OrderMapPointsFactory orderMapPointsFactory) {
        return new ScheduledOrderDetailsComponentFactory(scheduledOrderInfoBlockMapper, scheduledOrderButtonAppearanceMapper, htmlEngine, orderMapPointsFactory);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ScheduledOrderDetailsComponentFactory get() {
        return c(this.f31675a.get(), this.f31676b.get(), this.f31677c.get(), this.f31678d.get());
    }
}
