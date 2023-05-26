package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.log.InternalLog;
import ee.mtakso.driver.log.applog.ApplogFactory;
import ee.mtakso.driver.log.applog.ApplogUploader;
import ee.mtakso.driver.network.client.applog.AppLogClient;
import ee.mtakso.driver.param.DeviceFeatures;
import ee.mtakso.driver.param.DriverProvider;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class LogsModule_ProvideApplogUploaderFactory implements Factory<ApplogUploader> {

    /* renamed from: a  reason: collision with root package name */
    private final LogsModule f20760a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<AppLogClient> f20761b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverProvider> f20762c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ApplogFactory> f20763d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<InternalLog> f20764e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<DeviceFeatures> f20765f;

    public LogsModule_ProvideApplogUploaderFactory(LogsModule logsModule, Provider<AppLogClient> provider, Provider<DriverProvider> provider2, Provider<ApplogFactory> provider3, Provider<InternalLog> provider4, Provider<DeviceFeatures> provider5) {
        this.f20760a = logsModule;
        this.f20761b = provider;
        this.f20762c = provider2;
        this.f20763d = provider3;
        this.f20764e = provider4;
        this.f20765f = provider5;
    }

    public static LogsModule_ProvideApplogUploaderFactory a(LogsModule logsModule, Provider<AppLogClient> provider, Provider<DriverProvider> provider2, Provider<ApplogFactory> provider3, Provider<InternalLog> provider4, Provider<DeviceFeatures> provider5) {
        return new LogsModule_ProvideApplogUploaderFactory(logsModule, provider, provider2, provider3, provider4, provider5);
    }

    public static ApplogUploader c(LogsModule logsModule, AppLogClient appLogClient, DriverProvider driverProvider, ApplogFactory applogFactory, InternalLog internalLog, DeviceFeatures deviceFeatures) {
        return (ApplogUploader) Preconditions.checkNotNullFromProvides(logsModule.a(appLogClient, driverProvider, applogFactory, internalLog, deviceFeatures));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ApplogUploader get() {
        return c(this.f20760a, this.f20761b.get(), this.f20762c.get(), this.f20763d.get(), this.f20764e.get(), this.f20765f.get());
    }
}
