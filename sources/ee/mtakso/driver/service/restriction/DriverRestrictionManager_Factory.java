package ee.mtakso.driver.service.restriction;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.identity.verification.IdentityVerificationManager;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.service.analytics.event.facade.AppVerificationAnalytics;
import ee.mtakso.driver.service.deviceinfo.DeviceInfoSender;
import ee.mtakso.driver.service.driver.DriverManager;
import ee.mtakso.driver.service.order.details.OrderProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverRestrictionManager_Factory implements Factory<DriverRestrictionManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f25831a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverManager> f25832b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<OrderProvider> f25833c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DeviceInfoSender> f25834d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<DriverFeatures> f25835e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<AppVerificationAnalytics> f25836f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<IdentityVerificationManager> f25837g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<DriverTrainingRestrictionManager> f25838h;

    public DriverRestrictionManager_Factory(Provider<Context> provider, Provider<DriverManager> provider2, Provider<OrderProvider> provider3, Provider<DeviceInfoSender> provider4, Provider<DriverFeatures> provider5, Provider<AppVerificationAnalytics> provider6, Provider<IdentityVerificationManager> provider7, Provider<DriverTrainingRestrictionManager> provider8) {
        this.f25831a = provider;
        this.f25832b = provider2;
        this.f25833c = provider3;
        this.f25834d = provider4;
        this.f25835e = provider5;
        this.f25836f = provider6;
        this.f25837g = provider7;
        this.f25838h = provider8;
    }

    public static DriverRestrictionManager_Factory a(Provider<Context> provider, Provider<DriverManager> provider2, Provider<OrderProvider> provider3, Provider<DeviceInfoSender> provider4, Provider<DriverFeatures> provider5, Provider<AppVerificationAnalytics> provider6, Provider<IdentityVerificationManager> provider7, Provider<DriverTrainingRestrictionManager> provider8) {
        return new DriverRestrictionManager_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static DriverRestrictionManager c(Context context, DriverManager driverManager, OrderProvider orderProvider, DeviceInfoSender deviceInfoSender, DriverFeatures driverFeatures, AppVerificationAnalytics appVerificationAnalytics, IdentityVerificationManager identityVerificationManager, DriverTrainingRestrictionManager driverTrainingRestrictionManager) {
        return new DriverRestrictionManager(context, driverManager, orderProvider, deviceInfoSender, driverFeatures, appVerificationAnalytics, identityVerificationManager, driverTrainingRestrictionManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverRestrictionManager get() {
        return c(this.f25831a.get(), this.f25832b.get(), this.f25833c.get(), this.f25834d.get(), this.f25835e.get(), this.f25836f.get(), this.f25837g.get(), this.f25838h.get());
    }
}
