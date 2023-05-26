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
public final class ScheduledOrderInfoBlockMapper_Factory implements Factory<ScheduledOrderInfoBlockMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<HtmlEngine> f31744a;

    public ScheduledOrderInfoBlockMapper_Factory(Provider<HtmlEngine> provider) {
        this.f31744a = provider;
    }

    public static ScheduledOrderInfoBlockMapper_Factory a(Provider<HtmlEngine> provider) {
        return new ScheduledOrderInfoBlockMapper_Factory(provider);
    }

    public static ScheduledOrderInfoBlockMapper c(HtmlEngine htmlEngine) {
        return new ScheduledOrderInfoBlockMapper(htmlEngine);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ScheduledOrderInfoBlockMapper get() {
        return c(this.f31744a.get());
    }
}
