package ee.mtakso.driver.ui.screens.order.scheduled;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ScheduledOrderDetailsStateFactory_Factory implements Factory<ScheduledOrderDetailsStateFactory> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ScheduledOrderDetailsComponentFactory> f31710a;

    public ScheduledOrderDetailsStateFactory_Factory(Provider<ScheduledOrderDetailsComponentFactory> provider) {
        this.f31710a = provider;
    }

    public static ScheduledOrderDetailsStateFactory_Factory a(Provider<ScheduledOrderDetailsComponentFactory> provider) {
        return new ScheduledOrderDetailsStateFactory_Factory(provider);
    }

    public static ScheduledOrderDetailsStateFactory c(ScheduledOrderDetailsComponentFactory scheduledOrderDetailsComponentFactory) {
        return new ScheduledOrderDetailsStateFactory(scheduledOrderDetailsComponentFactory);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ScheduledOrderDetailsStateFactory get() {
        return c(this.f31710a.get());
    }
}
