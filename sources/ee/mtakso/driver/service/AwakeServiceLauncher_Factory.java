package ee.mtakso.driver.service;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.platform.core.PlatformManager;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import ee.mtakso.driver.utils.BackgroundManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AwakeServiceLauncher_Factory implements Factory<AwakeServiceLauncher> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f23396a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverStatusProvider> f23397b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverProvider> f23398c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<BackgroundManager> f23399d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<PlatformManager> f23400e;

    public AwakeServiceLauncher_Factory(Provider<Context> provider, Provider<DriverStatusProvider> provider2, Provider<DriverProvider> provider3, Provider<BackgroundManager> provider4, Provider<PlatformManager> provider5) {
        this.f23396a = provider;
        this.f23397b = provider2;
        this.f23398c = provider3;
        this.f23399d = provider4;
        this.f23400e = provider5;
    }

    public static AwakeServiceLauncher_Factory a(Provider<Context> provider, Provider<DriverStatusProvider> provider2, Provider<DriverProvider> provider3, Provider<BackgroundManager> provider4, Provider<PlatformManager> provider5) {
        return new AwakeServiceLauncher_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static AwakeServiceLauncher c(Context context, DriverStatusProvider driverStatusProvider, DriverProvider driverProvider, BackgroundManager backgroundManager, PlatformManager platformManager) {
        return new AwakeServiceLauncher(context, driverStatusProvider, driverProvider, backgroundManager, platformManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AwakeServiceLauncher get() {
        return c(this.f23396a.get(), this.f23397b.get(), this.f23398c.get(), this.f23399d.get(), this.f23400e.get());
    }
}
