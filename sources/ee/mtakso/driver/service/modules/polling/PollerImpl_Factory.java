package ee.mtakso.driver.service.modules.polling;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.modules.status.DriverStatusSender;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PollerImpl_Factory implements Factory<PollerImpl> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PollerFactory> f25126a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ActivePollingErrorHandler> f25127b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<InactivePollingErrorHandler> f25128c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DriverStatusSender> f25129d;

    public PollerImpl_Factory(Provider<PollerFactory> provider, Provider<ActivePollingErrorHandler> provider2, Provider<InactivePollingErrorHandler> provider3, Provider<DriverStatusSender> provider4) {
        this.f25126a = provider;
        this.f25127b = provider2;
        this.f25128c = provider3;
        this.f25129d = provider4;
    }

    public static PollerImpl_Factory a(Provider<PollerFactory> provider, Provider<ActivePollingErrorHandler> provider2, Provider<InactivePollingErrorHandler> provider3, Provider<DriverStatusSender> provider4) {
        return new PollerImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static PollerImpl c(PollerFactory pollerFactory, ActivePollingErrorHandler activePollingErrorHandler, InactivePollingErrorHandler inactivePollingErrorHandler, DriverStatusSender driverStatusSender) {
        return new PollerImpl(pollerFactory, activePollingErrorHandler, inactivePollingErrorHandler, driverStatusSender);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PollerImpl get() {
        return c(this.f25126a.get(), this.f25127b.get(), this.f25128c.get(), this.f25129d.get());
    }
}
