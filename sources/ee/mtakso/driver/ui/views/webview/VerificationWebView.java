package ee.mtakso.driver.ui.views.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.PermissionRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VerificationWebView.kt */
/* loaded from: classes5.dex */
public final class VerificationWebView extends PlainWebView {

    /* renamed from: s  reason: collision with root package name */
    public Map<Integer, View> f34563s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerificationWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.f(context, "context");
        this.f34563s = new LinkedHashMap();
        setWebChromeClient(new ManagedWebChromeClient() { // from class: ee.mtakso.driver.ui.views.webview.VerificationWebView.1
            @Override // android.webkit.WebChromeClient
            public Bitmap getDefaultVideoPoster() {
                Bitmap createBitmap = Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
                Intrinsics.e(createBitmap, "createBitmap(10, 10, Bitmap.Config.ARGB_8888)");
                return createBitmap;
            }

            @Override // android.webkit.WebChromeClient
            public void onPermissionRequest(PermissionRequest permissionRequest) {
                if (permissionRequest != null) {
                    permissionRequest.grant(permissionRequest.getResources());
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
                super.onPermissionRequestCanceled(permissionRequest);
            }
        });
        WebSettings settings = getSettings();
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setAllowContentAccess(true);
        setWebViewClient(new WebViewClient() { // from class: ee.mtakso.driver.ui.views.webview.VerificationWebView.3
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                VerificationWebView.this.loadUrl("javascript:(function() { window['__NVW_WEBVIEW__']=true})");
            }
        });
    }
}
