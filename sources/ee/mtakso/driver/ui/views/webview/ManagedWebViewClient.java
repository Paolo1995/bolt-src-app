package ee.mtakso.driver.ui.views.webview;

import android.annotation.TargetApi;
import android.net.http.SslError;
import android.os.Message;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ManagedWebViewClient.kt */
/* loaded from: classes5.dex */
public class ManagedWebViewClient extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    private WebViewTracker f34543a;

    public final void a(WebViewTracker webViewTracker) {
        Intrinsics.f(webViewTracker, "webViewTracker");
        this.f34543a = webViewTracker;
    }

    @Override // android.webkit.WebViewClient
    public void onPageCommitVisible(WebView webView, String str) {
        WebViewTracker webViewTracker = this.f34543a;
        if (webViewTracker != null) {
            webViewTracker.f(str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        WebViewTracker webViewTracker = this.f34543a;
        if (webViewTracker != null) {
            webViewTracker.g(str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i8, String str, String str2) {
        WebViewTracker webViewTracker = this.f34543a;
        if (webViewTracker != null) {
            webViewTracker.h(i8, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(23)
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        WebViewTracker webViewTracker = this.f34543a;
        if (webViewTracker != null) {
            webViewTracker.j(webResourceRequest, webResourceResponse);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        WebViewTracker webViewTracker = this.f34543a;
        if (webViewTracker != null) {
            webViewTracker.k(sslError);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        WebViewTracker webViewTracker = this.f34543a;
        if (webViewTracker != null) {
            webViewTracker.l();
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        WebViewTracker webViewTracker = this.f34543a;
        if (webViewTracker != null) {
            webViewTracker.i(webResourceRequest, webResourceError);
        }
    }
}
