package ee.mtakso.driver.ui.views.webview;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: EarningsPaymentWebView.kt */
/* loaded from: classes5.dex */
public final class EarningsPaymentWebView extends PlainWebView {

    /* renamed from: v  reason: collision with root package name */
    public static final Companion f34536v = new Companion(null);

    /* renamed from: s  reason: collision with root package name */
    private Function0<Unit> f34537s;

    /* renamed from: t  reason: collision with root package name */
    private Function0<Unit> f34538t;

    /* renamed from: u  reason: collision with root package name */
    public Map<Integer, View> f34539u;

    /* compiled from: EarningsPaymentWebView.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EarningsPaymentWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.f(context, "context");
        this.f34539u = new LinkedHashMap();
        setFocusable(true);
        setFocusableInTouchMode(true);
        setWebViewClient(new ManagedWebViewClient() { // from class: ee.mtakso.driver.ui.views.webview.EarningsPaymentWebView.1
            @Override // android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                Uri uri;
                EarningsPaymentWebView earningsPaymentWebView = EarningsPaymentWebView.this;
                if (webResourceRequest != null) {
                    uri = webResourceRequest.getUrl();
                } else {
                    uri = null;
                }
                earningsPaymentWebView.m(String.valueOf(uri));
                return null;
            }
        });
        setUrlLoadingStrategy(new Function1<String, Boolean>() { // from class: ee.mtakso.driver.ui.views.webview.EarningsPaymentWebView.2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(String it) {
                Intrinsics.f(it, "it");
                return Boolean.FALSE;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(final String str) {
        post(new Runnable() { // from class: ee.mtakso.driver.ui.views.webview.a
            @Override // java.lang.Runnable
            public final void run() {
                EarningsPaymentWebView.n(str, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(String str, EarningsPaymentWebView this$0) {
        boolean Q;
        boolean Q2;
        Function0<Unit> function0;
        Intrinsics.f(this$0, "this$0");
        if (str != null) {
            Q = StringsKt__StringsKt.Q(str, "https://bolt.eu/success", false, 2, null);
            if (Q) {
                Function0<Unit> function02 = this$0.f34537s;
                if (function02 != null) {
                    function02.invoke();
                    return;
                }
                return;
            }
            Q2 = StringsKt__StringsKt.Q(str, "https://bolt.eu/failure", false, 2, null);
            if (Q2 && (function0 = this$0.f34538t) != null) {
                function0.invoke();
            }
        }
    }

    public final Function0<Unit> getOnFailedPaymentListener() {
        return this.f34538t;
    }

    public final Function0<Unit> getOnSuccessfulPaymentListener() {
        return this.f34537s;
    }

    public final void setOnFailedPaymentListener(Function0<Unit> function0) {
        this.f34538t = function0;
    }

    public final void setOnSuccessfulPaymentListener(Function0<Unit> function0) {
        this.f34537s = function0;
    }
}
