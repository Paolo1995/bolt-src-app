package ee.mtakso.driver.service.modules.polling;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.modules.order.v2.OrderTracker;
import ee.mtakso.driver.service.pollerv2.PollerSource;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PollingLoggerService_Factory implements Factory<PollingLoggerService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PollerSource> f25134a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OrderTracker> f25135b;

    public PollingLoggerService_Factory(Provider<PollerSource> provider, Provider<OrderTracker> provider2) {
        this.f25134a = provider;
        this.f25135b = provider2;
    }

    public static PollingLoggerService_Factory a(Provider<PollerSource> provider, Provider<OrderTracker> provider2) {
        return new PollingLoggerService_Factory(provider, provider2);
    }

    public static PollingLoggerService c(PollerSource pollerSource, OrderTracker orderTracker) {
        return new PollingLoggerService(pollerSource, orderTracker);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PollingLoggerService get() {
        return c(this.f25134a.get(), this.f25135b.get());
    }
}
