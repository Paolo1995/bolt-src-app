package ee.mtakso.driver.ui.views.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebView;
import ee.mtakso.driver.uicore.utils.SignUpUtilsKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SignUpView.kt */
/* loaded from: classes5.dex */
public final class SignUpView extends PlainWebView {

    /* renamed from: s  reason: collision with root package name */
    private Function1<? super String, Unit> f34559s;

    /* renamed from: t  reason: collision with root package name */
    private Function1<? super String, Unit> f34560t;

    /* renamed from: u  reason: collision with root package name */
    public Map<Integer, View> f34561u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignUpView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.f(context, "context");
        this.f34561u = new LinkedHashMap();
        setFocusable(true);
        setFocusableInTouchMode(true);
        setWebChromeClient(new ManagedWebChromeClient() { // from class: ee.mtakso.driver.ui.views.webview.SignUpView.1
            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView view, String str) {
                Function1<String, Unit> onPageTitleChanged;
                Intrinsics.f(view, "view");
                String a8 = SignUpUtilsKt.a(CookieManager.getInstance().getCookie(view.getUrl()));
                Function1<String, Unit> registrationTokenListener = SignUpView.this.getRegistrationTokenListener();
                if (registrationTokenListener != null) {
                    registrationTokenListener.invoke(a8);
                }
                if (str != null && (onPageTitleChanged = SignUpView.this.getOnPageTitleChanged()) != null) {
                    onPageTitleChanged.invoke(str);
                }
                super.onReceivedTitle(view, str);
            }
        });
    }

    public final Function1<String, Unit> getOnPageTitleChanged() {
        return this.f34559s;
    }

    public final Function1<String, Unit> getRegistrationTokenListener() {
        return this.f34560t;
    }

    public final void setOnPageTitleChanged(Function1<? super String, Unit> function1) {
        this.f34559s = function1;
    }

    public final void setRegistrationTokenListener(Function1<? super String, Unit> function1) {
        this.f34560t = function1;
    }
}
