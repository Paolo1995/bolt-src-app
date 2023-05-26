package ee.mtakso.driver.network.interceptor;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.log.report.ReportManager;
import ee.mtakso.driver.network.exception.ApiExceptionFactory;
import ee.mtakso.driver.network.response.ResponseErrorProcessor;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.analytics.event.facade.NetworkErrorAnalytics;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class HttpErrorInterceptor_Factory implements Factory<HttpErrorInterceptor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ResponseErrorProcessor> f22948a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<NetworkErrorAnalytics> f22949b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ApiExceptionFactory> f22950c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ReportManager> f22951d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<DriverProvider> f22952e;

    public HttpErrorInterceptor_Factory(Provider<ResponseErrorProcessor> provider, Provider<NetworkErrorAnalytics> provider2, Provider<ApiExceptionFactory> provider3, Provider<ReportManager> provider4, Provider<DriverProvider> provider5) {
        this.f22948a = provider;
        this.f22949b = provider2;
        this.f22950c = provider3;
        this.f22951d = provider4;
        this.f22952e = provider5;
    }

    public static HttpErrorInterceptor_Factory a(Provider<ResponseErrorProcessor> provider, Provider<NetworkErrorAnalytics> provider2, Provider<ApiExceptionFactory> provider3, Provider<ReportManager> provider4, Provider<DriverProvider> provider5) {
        return new HttpErrorInterceptor_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static HttpErrorInterceptor c(ResponseErrorProcessor responseErrorProcessor, NetworkErrorAnalytics networkErrorAnalytics, ApiExceptionFactory apiExceptionFactory, ReportManager reportManager, DriverProvider driverProvider) {
        return new HttpErrorInterceptor(responseErrorProcessor, networkErrorAnalytics, apiExceptionFactory, reportManager, driverProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public HttpErrorInterceptor get() {
        return c(this.f22948a.get(), this.f22949b.get(), this.f22950c.get(), this.f22951d.get(), this.f22952e.get());
    }
}
