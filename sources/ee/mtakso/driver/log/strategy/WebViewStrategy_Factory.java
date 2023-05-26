package ee.mtakso.driver.log.strategy;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.log.storage.LogStorage;
import ee.mtakso.driver.param.DriverProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class WebViewStrategy_Factory implements Factory<WebViewStrategy> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverProvider> f21169a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<LogStorage> f21170b;

    public WebViewStrategy_Factory(Provider<DriverProvider> provider, Provider<LogStorage> provider2) {
        this.f21169a = provider;
        this.f21170b = provider2;
    }

    public static WebViewStrategy_Factory a(Provider<DriverProvider> provider, Provider<LogStorage> provider2) {
        return new WebViewStrategy_Factory(provider, provider2);
    }

    public static WebViewStrategy c(DriverProvider driverProvider, LogStorage logStorage) {
        return new WebViewStrategy(driverProvider, logStorage);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public WebViewStrategy get() {
        return c(this.f21169a.get(), this.f21170b.get());
    }
}
