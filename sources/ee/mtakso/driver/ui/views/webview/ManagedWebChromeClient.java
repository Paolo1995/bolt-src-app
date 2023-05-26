package ee.mtakso.driver.ui.views.webview;

import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ManagedWebChromeClient.kt */
/* loaded from: classes5.dex */
public class ManagedWebChromeClient extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    private WebViewTracker f34542a;

    public final void a(WebViewTracker webViewTracker) {
        Intrinsics.f(webViewTracker, "webViewTracker");
        this.f34542a = webViewTracker;
    }

    @Override // android.webkit.WebChromeClient
    public void onConsoleMessage(String str, int i8, String str2) {
        WebViewTracker webViewTracker = this.f34542a;
        if (webViewTracker != null) {
            webViewTracker.e(str, i8, str2);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        WebViewTracker webViewTracker = this.f34542a;
        if (webViewTracker != null) {
            webViewTracker.d(consoleMessage);
            return true;
        }
        return true;
    }
}
