package ee.mtakso.driver.network;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.cache.CacheProvider;
import ee.mtakso.driver.network.client.applog.ApplogParamsInterceptor;
import ee.mtakso.driver.network.interceptor.HttpErrorInterceptor;
import ee.mtakso.driver.network.interceptor.LoggingInterceptor;
import ee.mtakso.driver.network.interceptor.StandardParamsInterceptors;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ClientFactory_Factory implements Factory<ClientFactory> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<StandardParamsInterceptors> f21290a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ApplogParamsInterceptor> f21291b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<LoggingInterceptor> f21292c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<CacheProvider> f21293d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<HttpErrorInterceptor> f21294e;

    public ClientFactory_Factory(Provider<StandardParamsInterceptors> provider, Provider<ApplogParamsInterceptor> provider2, Provider<LoggingInterceptor> provider3, Provider<CacheProvider> provider4, Provider<HttpErrorInterceptor> provider5) {
        this.f21290a = provider;
        this.f21291b = provider2;
        this.f21292c = provider3;
        this.f21293d = provider4;
        this.f21294e = provider5;
    }

    public static ClientFactory_Factory a(Provider<StandardParamsInterceptors> provider, Provider<ApplogParamsInterceptor> provider2, Provider<LoggingInterceptor> provider3, Provider<CacheProvider> provider4, Provider<HttpErrorInterceptor> provider5) {
        return new ClientFactory_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static ClientFactory c(StandardParamsInterceptors standardParamsInterceptors, ApplogParamsInterceptor applogParamsInterceptor, LoggingInterceptor loggingInterceptor, CacheProvider cacheProvider, HttpErrorInterceptor httpErrorInterceptor) {
        return new ClientFactory(standardParamsInterceptors, applogParamsInterceptor, loggingInterceptor, cacheProvider, httpErrorInterceptor);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ClientFactory get() {
        return c(this.f21290a.get(), this.f21291b.get(), this.f21292c.get(), this.f21293d.get(), this.f21294e.get());
    }
}
