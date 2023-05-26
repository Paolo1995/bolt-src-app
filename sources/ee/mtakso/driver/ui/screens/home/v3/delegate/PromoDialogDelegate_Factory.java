package ee.mtakso.driver.ui.screens.home.v3.delegate;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.analytics.event.facade.BackendModalDialogAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.OrderAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.QuickAccessStateAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.SettingsAnalytics;
import eu.bolt.driver.core.permission.PermissionManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PromoDialogDelegate_Factory implements Factory<PromoDialogDelegate> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverProvider> f29909a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OrderAnalytics> f29910b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<QuickAccessStateAnalytics> f29911c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<BackendModalDialogAnalytics> f29912d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<PermissionManager> f29913e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<SettingsAnalytics> f29914f;

    public PromoDialogDelegate_Factory(Provider<DriverProvider> provider, Provider<OrderAnalytics> provider2, Provider<QuickAccessStateAnalytics> provider3, Provider<BackendModalDialogAnalytics> provider4, Provider<PermissionManager> provider5, Provider<SettingsAnalytics> provider6) {
        this.f29909a = provider;
        this.f29910b = provider2;
        this.f29911c = provider3;
        this.f29912d = provider4;
        this.f29913e = provider5;
        this.f29914f = provider6;
    }

    public static PromoDialogDelegate_Factory a(Provider<DriverProvider> provider, Provider<OrderAnalytics> provider2, Provider<QuickAccessStateAnalytics> provider3, Provider<BackendModalDialogAnalytics> provider4, Provider<PermissionManager> provider5, Provider<SettingsAnalytics> provider6) {
        return new PromoDialogDelegate_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static PromoDialogDelegate c(DriverProvider driverProvider, OrderAnalytics orderAnalytics, QuickAccessStateAnalytics quickAccessStateAnalytics, BackendModalDialogAnalytics backendModalDialogAnalytics, PermissionManager permissionManager, SettingsAnalytics settingsAnalytics) {
        return new PromoDialogDelegate(driverProvider, orderAnalytics, quickAccessStateAnalytics, backendModalDialogAnalytics, permissionManager, settingsAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PromoDialogDelegate get() {
        return c(this.f29909a.get(), this.f29910b.get(), this.f29911c.get(), this.f29912d.get(), this.f29913e.get(), this.f29914f.get());
    }
}
