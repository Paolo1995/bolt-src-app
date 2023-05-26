package ee.mtakso.driver.ui.screens.sos;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics;
import ee.mtakso.driver.service.modules.incident.IncidentReportingService;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class SosDialogViewModel_Factory implements Factory<SosDialogViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<TrueTimeProvider> f33420a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<IncidentReportingService> f33421b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverProvider> f33422c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<OrderFlowAnalytics> f33423d;

    public SosDialogViewModel_Factory(Provider<TrueTimeProvider> provider, Provider<IncidentReportingService> provider2, Provider<DriverProvider> provider3, Provider<OrderFlowAnalytics> provider4) {
        this.f33420a = provider;
        this.f33421b = provider2;
        this.f33422c = provider3;
        this.f33423d = provider4;
    }

    public static SosDialogViewModel_Factory a(Provider<TrueTimeProvider> provider, Provider<IncidentReportingService> provider2, Provider<DriverProvider> provider3, Provider<OrderFlowAnalytics> provider4) {
        return new SosDialogViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static SosDialogViewModel c(TrueTimeProvider trueTimeProvider, IncidentReportingService incidentReportingService, DriverProvider driverProvider, OrderFlowAnalytics orderFlowAnalytics) {
        return new SosDialogViewModel(trueTimeProvider, incidentReportingService, driverProvider, orderFlowAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SosDialogViewModel get() {
        return c(this.f33420a.get(), this.f33421b.get(), this.f33422c.get(), this.f33423d.get());
    }
}
