package ee.mtakso.driver.ui.views.webview;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.log.strategy.memory.WebViewStrategy;
import ee.mtakso.driver.service.analytics.event.facade.WebViewAnalytics;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class WebViewTracker_Factory implements Factory<WebViewTracker> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<WebViewAnalytics> f34569a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<WebViewStrategy> f34570b;

    public WebViewTracker_Factory(Provider<WebViewAnalytics> provider, Provider<WebViewStrategy> provider2) {
        this.f34569a = provider;
        this.f34570b = provider2;
    }

    public static WebViewTracker_Factory a(Provider<WebViewAnalytics> provider, Provider<WebViewStrategy> provider2) {
        return new WebViewTracker_Factory(provider, provider2);
    }

    public static WebViewTracker c(WebViewAnalytics webViewAnalytics, WebViewStrategy webViewStrategy) {
        return new WebViewTracker(webViewAnalytics, webViewStrategy);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public WebViewTracker get() {
        return c(this.f34569a.get(), this.f34570b.get());
    }
}
