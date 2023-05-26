package ee.mtakso.driver.service.analytics.event;

import android.content.Context;
import android.content.pm.PackageManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.log.report.ReportManager;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.platform.core.PlatformManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AnalyticsImpl_Factory implements Factory<AnalyticsImpl> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f23462a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Features> f23463b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverProvider> f23464c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<AnalyticsManager> f23465d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<PackageManager> f23466e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<ReportManager> f23467f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<PlatformManager> f23468g;

    public AnalyticsImpl_Factory(Provider<Context> provider, Provider<Features> provider2, Provider<DriverProvider> provider3, Provider<AnalyticsManager> provider4, Provider<PackageManager> provider5, Provider<ReportManager> provider6, Provider<PlatformManager> provider7) {
        this.f23462a = provider;
        this.f23463b = provider2;
        this.f23464c = provider3;
        this.f23465d = provider4;
        this.f23466e = provider5;
        this.f23467f = provider6;
        this.f23468g = provider7;
    }

    public static AnalyticsImpl_Factory a(Provider<Context> provider, Provider<Features> provider2, Provider<DriverProvider> provider3, Provider<AnalyticsManager> provider4, Provider<PackageManager> provider5, Provider<ReportManager> provider6, Provider<PlatformManager> provider7) {
        return new AnalyticsImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static AnalyticsImpl c(Context context, Features features, DriverProvider driverProvider, AnalyticsManager analyticsManager, PackageManager packageManager, ReportManager reportManager, PlatformManager platformManager) {
        return new AnalyticsImpl(context, features, driverProvider, analyticsManager, packageManager, reportManager, platformManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AnalyticsImpl get() {
        return c(this.f23462a.get(), this.f23463b.get(), this.f23464c.get(), this.f23465d.get(), this.f23466e.get(), this.f23467f.get(), this.f23468g.get());
    }
}
