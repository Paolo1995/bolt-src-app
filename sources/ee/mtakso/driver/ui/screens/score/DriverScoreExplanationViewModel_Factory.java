package ee.mtakso.driver.ui.screens.score;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.score.DriverScoreClient;
import ee.mtakso.driver.service.analytics.event.facade.DriverScoreAnalytics;
import ee.mtakso.driver.ui.views.webview.WebViewTracker;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverScoreExplanationViewModel_Factory implements Factory<DriverScoreExplanationViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverScoreClient> f32900a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverScoreAnalytics> f32901b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<WebViewTracker> f32902c;

    public DriverScoreExplanationViewModel_Factory(Provider<DriverScoreClient> provider, Provider<DriverScoreAnalytics> provider2, Provider<WebViewTracker> provider3) {
        this.f32900a = provider;
        this.f32901b = provider2;
        this.f32902c = provider3;
    }

    public static DriverScoreExplanationViewModel_Factory a(Provider<DriverScoreClient> provider, Provider<DriverScoreAnalytics> provider2, Provider<WebViewTracker> provider3) {
        return new DriverScoreExplanationViewModel_Factory(provider, provider2, provider3);
    }

    public static DriverScoreExplanationViewModel c(DriverScoreClient driverScoreClient, DriverScoreAnalytics driverScoreAnalytics, WebViewTracker webViewTracker) {
        return new DriverScoreExplanationViewModel(driverScoreClient, driverScoreAnalytics, webViewTracker);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverScoreExplanationViewModel get() {
        return c(this.f32900a.get(), this.f32901b.get(), this.f32902c.get());
    }
}
