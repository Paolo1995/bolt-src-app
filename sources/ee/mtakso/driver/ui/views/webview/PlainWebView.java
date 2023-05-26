package ee.mtakso.driver.ui.views.webview;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.SparseArray;
import android.view.View;
import android.view.autofill.AutofillValue;
import android.webkit.PermissionRequest;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.common.internal.ImagesContract;
import eu.bolt.kalev.Kalev;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: PlainWebView.kt */
/* loaded from: classes5.dex */
public class PlainWebView extends WebView {

    /* renamed from: r  reason: collision with root package name */
    public static final Companion f34544r = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private Function1<? super String, Unit> f34545f;

    /* renamed from: g  reason: collision with root package name */
    private Function1<? super String, Boolean> f34546g;

    /* renamed from: h  reason: collision with root package name */
    private Function0<Unit> f34547h;

    /* renamed from: i  reason: collision with root package name */
    private Function0<Unit> f34548i;

    /* renamed from: j  reason: collision with root package name */
    private Function1<? super String, Boolean> f34549j;

    /* renamed from: k  reason: collision with root package name */
    private Function1<? super String, Boolean> f34550k;

    /* renamed from: l  reason: collision with root package name */
    private WebViewClient f34551l;

    /* renamed from: m  reason: collision with root package name */
    private WebChromeClient f34552m;

    /* renamed from: n  reason: collision with root package name */
    private final ManagedWebViewClient f34553n;

    /* renamed from: o  reason: collision with root package name */
    private final ManagedWebChromeClient f34554o;

    /* renamed from: p  reason: collision with root package name */
    private ValueCallback<Uri[]> f34555p;

    /* renamed from: q  reason: collision with root package name */
    public Map<Integer, View> f34556q;

    /* compiled from: PlainWebView.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlainWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.f(context, "context");
        this.f34556q = new LinkedHashMap();
        ManagedWebViewClient managedWebViewClient = new ManagedWebViewClient() { // from class: ee.mtakso.driver.ui.views.webview.PlainWebView$internalWebViewClient$1
            @Override // ee.mtakso.driver.ui.views.webview.ManagedWebViewClient, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                WebViewClient webViewClient;
                super.onPageFinished(webView, str);
                Function1<String, Unit> loadingCallback = PlainWebView.this.getLoadingCallback();
                if (loadingCallback != null) {
                    loadingCallback.invoke(str);
                }
                webViewClient = PlainWebView.this.f34551l;
                if (webViewClient != null) {
                    webViewClient.onPageFinished(webView, str);
                }
            }

            @Override // android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                WebViewClient webViewClient;
                webViewClient = PlainWebView.this.f34551l;
                if (webViewClient != null) {
                    return webViewClient.shouldInterceptRequest(webView, str);
                }
                return null;
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                boolean h8;
                Uri url;
                h8 = PlainWebView.this.h((webResourceRequest == null || (url = webResourceRequest.getUrl()) == null) ? null : url.toString());
                return h8;
            }

            @Override // android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                WebViewClient webViewClient;
                webViewClient = PlainWebView.this.f34551l;
                if (webViewClient != null) {
                    return webViewClient.shouldInterceptRequest(webView, webResourceRequest);
                }
                return null;
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, String str) {
                boolean h8;
                Intrinsics.f(view, "view");
                h8 = PlainWebView.this.h(str);
                return h8;
            }
        };
        this.f34553n = managedWebViewClient;
        ManagedWebChromeClient managedWebChromeClient = new ManagedWebChromeClient() { // from class: ee.mtakso.driver.ui.views.webview.PlainWebView$internalWebChromeClient$1
            @Override // android.webkit.WebChromeClient
            public boolean onCreateWindow(WebView webView, boolean z7, boolean z8, Message message) {
                WebView.HitTestResult hitTestResult;
                String g8;
                PlainWebView plainWebView = PlainWebView.this;
                if (webView != null) {
                    hitTestResult = webView.getHitTestResult();
                } else {
                    hitTestResult = null;
                }
                g8 = plainWebView.g(hitTestResult);
                if (g8 != null) {
                    if (URLUtil.isNetworkUrl(g8)) {
                        Function1<String, Boolean> onCreateWindow = PlainWebView.this.getOnCreateWindow();
                        if (onCreateWindow != null) {
                            return onCreateWindow.invoke(g8).booleanValue();
                        }
                        return super.onCreateWindow(webView, z7, z8, message);
                    } else if (Intrinsics.a(g8, "boltdriverapp://action/closeBrowser")) {
                        Function0<Unit> onCloseWebViewListener = PlainWebView.this.getOnCloseWebViewListener();
                        if (onCloseWebViewListener != null) {
                            onCloseWebViewListener.invoke();
                        }
                        return true;
                    } else {
                        Function1<String, Boolean> onHandleDeepLinkUrlChange = PlainWebView.this.getOnHandleDeepLinkUrlChange();
                        if (onHandleDeepLinkUrlChange != null) {
                            return onHandleDeepLinkUrlChange.invoke(g8).booleanValue();
                        }
                        return false;
                    }
                }
                return super.onCreateWindow(webView, z7, z8, message);
            }

            @Override // android.webkit.WebChromeClient
            public void onPermissionRequest(PermissionRequest permissionRequest) {
                WebChromeClient webChromeClient;
                webChromeClient = PlainWebView.this.f34552m;
                if (webChromeClient != null) {
                    webChromeClient.onPermissionRequest(permissionRequest);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
                WebChromeClient webChromeClient;
                webChromeClient = PlainWebView.this.f34552m;
                if (webChromeClient != null) {
                    webChromeClient.onPermissionRequestCanceled(permissionRequest);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                WebChromeClient webChromeClient;
                webChromeClient = PlainWebView.this.f34552m;
                if (webChromeClient != null) {
                    webChromeClient.onReceivedTitle(webView, str);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                Intrinsics.f(webView, "webView");
                Intrinsics.f(filePathCallback, "filePathCallback");
                Intrinsics.f(fileChooserParams, "fileChooserParams");
                PlainWebView.this.f34555p = filePathCallback;
                Function0<Unit> onFileRequestListener = PlainWebView.this.getOnFileRequestListener();
                if (onFileRequestListener != null) {
                    onFileRequestListener.invoke();
                    return true;
                }
                return true;
            }
        };
        this.f34554o = managedWebChromeClient;
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(true);
        getSettings().setAllowFileAccess(true);
        super.setWebViewClient(managedWebViewClient);
        super.setWebChromeClient(managedWebChromeClient);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String g(WebView.HitTestResult hitTestResult) {
        if (hitTestResult == null) {
            return null;
        }
        if (hitTestResult.getType() == 8) {
            Message obtainMessage = new Handler().obtainMessage();
            Intrinsics.e(obtainMessage, "handler.obtainMessage()");
            requestFocusNodeHref(obtainMessage);
            String string = obtainMessage.getData().getString(ImagesContract.URL);
            if (string == null) {
                return Uri.parse(hitTestResult.getExtra()).toString();
            }
            return string;
        }
        return Uri.parse(hitTestResult.getExtra()).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean h(String str) {
        if (str == null) {
            return false;
        }
        if (URLUtil.isNetworkUrl(str)) {
            Function1<? super String, Boolean> function1 = this.f34546g;
            if (function1 == null) {
                return false;
            }
            return function1.invoke(str).booleanValue();
        } else if (Intrinsics.a(str, "boltdriverapp://action/closeBrowser")) {
            Function0<Unit> function0 = this.f34547h;
            if (function0 != null) {
                function0.invoke();
            }
            return true;
        } else {
            Function1<? super String, Boolean> function12 = this.f34550k;
            if (function12 == null) {
                return false;
            }
            return function12.invoke(str).booleanValue();
        }
    }

    @Override // android.view.View
    public void autofill(AutofillValue autofillValue) {
        try {
            super.autofill(autofillValue);
        } catch (Exception e8) {
            Kalev.e(e8, "Not able to auto-fill on WebView!");
        }
    }

    public final void f(Uri uri) {
        ValueCallback<Uri[]> valueCallback = this.f34555p;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(uri != null ? new Uri[]{uri} : null);
        }
        this.f34555p = null;
    }

    public final Function1<String, Unit> getLoadingCallback() {
        return this.f34545f;
    }

    public final Function0<Unit> getOnCloseWebViewListener() {
        return this.f34547h;
    }

    public final Function1<String, Boolean> getOnCreateWindow() {
        return this.f34549j;
    }

    public final Function0<Unit> getOnFileRequestListener() {
        return this.f34548i;
    }

    public final Function1<String, Boolean> getOnHandleDeepLinkUrlChange() {
        return this.f34550k;
    }

    public final Function1<String, Boolean> getUrlLoadingStrategy() {
        return this.f34546g;
    }

    public final void i(String html) {
        Intrinsics.f(html, "html");
        loadData(html, "text/html", "UTF-8");
    }

    public final void j(String html) {
        Intrinsics.f(html, "html");
        byte[] bytes = html.getBytes(Charsets.f51135b);
        Intrinsics.e(bytes, "this as java.lang.String).getBytes(charset)");
        loadData(Base64.encodeToString(bytes, 1), "text/html; charset=utf-8", "base64");
    }

    public final void setLoadingCallback(Function1<? super String, Unit> function1) {
        this.f34545f = function1;
    }

    public final void setOnCloseWebViewListener(Function0<Unit> function0) {
        this.f34547h = function0;
    }

    public final void setOnCreateWindow(Function1<? super String, Boolean> function1) {
        boolean z7;
        this.f34549j = function1;
        WebSettings settings = getSettings();
        if (function1 != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        settings.setSupportMultipleWindows(z7);
    }

    public final void setOnFileRequestListener(Function0<Unit> function0) {
        this.f34548i = function0;
    }

    public final void setOnHandleDeepLinkUrlChange(Function1<? super String, Boolean> function1) {
        this.f34550k = function1;
    }

    public final void setUrlLoadingStrategy(Function1<? super String, Boolean> function1) {
        this.f34546g = function1;
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.f34552m = webChromeClient;
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient client) {
        Intrinsics.f(client, "client");
        this.f34551l = client;
    }

    public final void setWebViewTracker(WebViewTracker webViewTracker) {
        Intrinsics.f(webViewTracker, "webViewTracker");
        this.f34553n.a(webViewTracker);
        this.f34554o.a(webViewTracker);
    }

    @Override // android.webkit.WebView, android.view.View
    public void autofill(SparseArray<AutofillValue> values) {
        Intrinsics.f(values, "values");
        try {
            super.autofill(values);
        } catch (Exception e8) {
            Kalev.e(e8, "Not able to auto-fill on WebView!");
        }
    }
}
