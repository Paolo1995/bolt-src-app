package ee.mtakso.driver.log.strategy.memory;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.log.applog.ApplogUploader;
import ee.mtakso.driver.param.DeviceFeatures;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class WebViewStrategy_Factory implements Factory<WebViewStrategy> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ApplogUploader> f21183a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DeviceFeatures> f21184b;

    public WebViewStrategy_Factory(Provider<ApplogUploader> provider, Provider<DeviceFeatures> provider2) {
        this.f21183a = provider;
        this.f21184b = provider2;
    }

    public static WebViewStrategy_Factory a(Provider<ApplogUploader> provider, Provider<DeviceFeatures> provider2) {
        return new WebViewStrategy_Factory(provider, provider2);
    }

    public static WebViewStrategy c(ApplogUploader applogUploader, DeviceFeatures deviceFeatures) {
        return new WebViewStrategy(applogUploader, deviceFeatures);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public WebViewStrategy get() {
        return c(this.f21183a.get(), this.f21184b.get());
    }
}
