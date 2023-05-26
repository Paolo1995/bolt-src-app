package ee.mtakso.driver.ui.screens.campaigns.v2.circlek;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.views.webview.WebViewTracker;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class CircleKLoyaltyViewModel_Factory implements Factory<CircleKLoyaltyViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<WebViewTracker> f27386a;

    public CircleKLoyaltyViewModel_Factory(Provider<WebViewTracker> provider) {
        this.f27386a = provider;
    }

    public static CircleKLoyaltyViewModel_Factory a(Provider<WebViewTracker> provider) {
        return new CircleKLoyaltyViewModel_Factory(provider);
    }

    public static CircleKLoyaltyViewModel c(WebViewTracker webViewTracker) {
        return new CircleKLoyaltyViewModel(webViewTracker);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CircleKLoyaltyViewModel get() {
        return c(this.f27386a.get());
    }
}
