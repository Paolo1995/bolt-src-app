package ee.mtakso.driver.ui.screens.campaigns.v2.circlek;

import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.views.webview.WebViewTracker;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CircleKLoyaltyViewModel.kt */
/* loaded from: classes3.dex */
public final class CircleKLoyaltyViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final WebViewTracker f27385f;

    @Inject
    public CircleKLoyaltyViewModel(WebViewTracker webViewTracker) {
        Intrinsics.f(webViewTracker, "webViewTracker");
        this.f27385f = webViewTracker;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        this.f27385f.b();
    }

    public final WebViewTracker D() {
        return this.f27385f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.f27385f.a();
    }
}
