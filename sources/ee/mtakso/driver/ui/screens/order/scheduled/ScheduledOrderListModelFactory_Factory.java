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
public final class ScheduledOrderListModelFactory_Factory implements Factory<ScheduledOrderListModelFactory> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<HtmlEngine> f31754a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OrderMapPointsFactory> f31755b;

    public ScheduledOrderListModelFactory_Factory(Provider<HtmlEngine> provider, Provider<OrderMapPointsFactory> provider2) {
        this.f31754a = provider;
        this.f31755b = provider2;
    }

    public static ScheduledOrderListModelFactory_Factory a(Provider<HtmlEngine> provider, Provider<OrderMapPointsFactory> provider2) {
        return new ScheduledOrderListModelFactory_Factory(provider, provider2);
    }

    public static ScheduledOrderListModelFactory c(HtmlEngine htmlEngine, OrderMapPointsFactory orderMapPointsFactory) {
        return new ScheduledOrderListModelFactory(htmlEngine, orderMapPointsFactory);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ScheduledOrderListModelFactory get() {
        return c(this.f31754a.get(), this.f31755b.get());
    }
}
