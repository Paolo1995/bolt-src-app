package ee.mtakso.driver.ui.screens.support;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.network.client.support.SupportClient;
import ee.mtakso.driver.ui.views.webview.WebViewTracker;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class SupportViewModel_Factory implements Factory<SupportViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<WebViewTracker> f33466a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Features> f33467b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<SupportClient> f33468c;

    public SupportViewModel_Factory(Provider<WebViewTracker> provider, Provider<Features> provider2, Provider<SupportClient> provider3) {
        this.f33466a = provider;
        this.f33467b = provider2;
        this.f33468c = provider3;
    }

    public static SupportViewModel_Factory a(Provider<WebViewTracker> provider, Provider<Features> provider2, Provider<SupportClient> provider3) {
        return new SupportViewModel_Factory(provider, provider2, provider3);
    }

    public static SupportViewModel c(WebViewTracker webViewTracker, Features features, SupportClient supportClient) {
        return new SupportViewModel(webViewTracker, features, supportClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SupportViewModel get() {
        return c(this.f33466a.get(), this.f33467b.get(), this.f33468c.get());
    }
}
