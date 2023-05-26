package ee.mtakso.driver.service.modules.order.v2;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.pollerv2.PollerSource;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PollingAnalyticsService_Factory implements Factory<PollingAnalyticsService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PollerSource> f25006a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OrderTracker> f25007b;

    public PollingAnalyticsService_Factory(Provider<PollerSource> provider, Provider<OrderTracker> provider2) {
        this.f25006a = provider;
        this.f25007b = provider2;
    }

    public static PollingAnalyticsService_Factory a(Provider<PollerSource> provider, Provider<OrderTracker> provider2) {
        return new PollingAnalyticsService_Factory(provider, provider2);
    }

    public static PollingAnalyticsService c(PollerSource pollerSource, OrderTracker orderTracker) {
        return new PollingAnalyticsService(pollerSource, orderTracker);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PollingAnalyticsService get() {
        return c(this.f25006a.get(), this.f25007b.get());
    }
}
