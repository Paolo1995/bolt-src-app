package ee.mtakso.driver.service.integration.clevertap;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.param.DriverSettings;
import ee.mtakso.driver.ui.notification.UiNotificationManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class CleverTapService_Factory implements Factory<CleverTapService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverConfig> f24558a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverSettings> f24559b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<CleverTapManager> f24560c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<Context> f24561d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<UiNotificationManager> f24562e;

    public CleverTapService_Factory(Provider<DriverConfig> provider, Provider<DriverSettings> provider2, Provider<CleverTapManager> provider3, Provider<Context> provider4, Provider<UiNotificationManager> provider5) {
        this.f24558a = provider;
        this.f24559b = provider2;
        this.f24560c = provider3;
        this.f24561d = provider4;
        this.f24562e = provider5;
    }

    public static CleverTapService_Factory a(Provider<DriverConfig> provider, Provider<DriverSettings> provider2, Provider<CleverTapManager> provider3, Provider<Context> provider4, Provider<UiNotificationManager> provider5) {
        return new CleverTapService_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static CleverTapService c(DriverConfig driverConfig, DriverSettings driverSettings, CleverTapManager cleverTapManager, Context context, UiNotificationManager uiNotificationManager) {
        return new CleverTapService(driverConfig, driverSettings, cleverTapManager, context, uiNotificationManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CleverTapService get() {
        return c(this.f24558a.get(), this.f24559b.get(), this.f24560c.get(), this.f24561d.get(), this.f24562e.get());
    }
}
