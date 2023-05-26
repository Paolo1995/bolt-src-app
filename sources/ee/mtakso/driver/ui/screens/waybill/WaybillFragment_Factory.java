package ee.mtakso.driver.ui.screens.waybill;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.views.webview.WebViewTracker;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes5.dex */
public final class WaybillFragment_Factory implements Factory<WaybillFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<WebViewTracker> f33619a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f33620b;

    public WaybillFragment_Factory(Provider<WebViewTracker> provider, Provider<BaseUiDependencies> provider2) {
        this.f33619a = provider;
        this.f33620b = provider2;
    }

    public static WaybillFragment_Factory a(Provider<WebViewTracker> provider, Provider<BaseUiDependencies> provider2) {
        return new WaybillFragment_Factory(provider, provider2);
    }

    public static WaybillFragment c(WebViewTracker webViewTracker, BaseUiDependencies baseUiDependencies) {
        return new WaybillFragment(webViewTracker, baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public WaybillFragment get() {
        return c(this.f33619a.get(), this.f33620b.get());
    }
}
