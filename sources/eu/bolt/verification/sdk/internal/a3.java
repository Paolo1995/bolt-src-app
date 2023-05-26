package eu.bolt.verification.sdk.internal;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.webkit.URLUtil;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import eu.bolt.logger.Logger;
import eu.bolt.verification.sdk.internal.ac;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public class a3 extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    private final String f41942a;

    /* renamed from: b  reason: collision with root package name */
    private final Function1<String, Boolean> f41943b;

    /* renamed from: c  reason: collision with root package name */
    private final Function1<String, Unit> f41944c;

    /* renamed from: d  reason: collision with root package name */
    private final Function2<String, String, Unit> f41945d;

    /* renamed from: e  reason: collision with root package name */
    private final Logger f41946e;

    /* JADX WARN: Multi-variable type inference failed */
    public a3(String tag, Function1<? super String, Boolean> overrideUrlPredicate, Function1<? super String, Unit> onPageLoaded, Function2<? super String, ? super String, Unit> onPageLoadingError) {
        Intrinsics.f(tag, "tag");
        Intrinsics.f(overrideUrlPredicate, "overrideUrlPredicate");
        Intrinsics.f(onPageLoaded, "onPageLoaded");
        Intrinsics.f(onPageLoadingError, "onPageLoadingError");
        this.f41942a = tag;
        this.f41943b = overrideUrlPredicate;
        this.f41944c = onPageLoaded;
        this.f41945d = onPageLoadingError;
        this.f41946e = ac.b.f42045b.e();
    }

    @Override // android.webkit.WebViewClient
    public void onPageCommitVisible(WebView webView, String str) {
        if (str != null) {
            this.f41944c.invoke(str);
        }
        super.onPageCommitVisible(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        if (str != null) {
            this.f41944c.invoke(str);
        }
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView view, int i8, String description, String failingUrl) {
        Intrinsics.f(view, "view");
        Intrinsics.f(description, "description");
        Intrinsics.f(failingUrl, "failingUrl");
        Logger logger = this.f41946e;
        String str = this.f41942a;
        logger.e(str + " An error occurred when loading url: " + failingUrl + " error: " + i8 + " " + description);
        Function2<String, String, Unit> function2 = this.f41945d;
        StringBuilder sb = new StringBuilder();
        sb.append(i8);
        sb.append(" ");
        sb.append(description);
        function2.s(failingUrl, sb.toString());
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(23)
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        Intrinsics.f(view, "view");
        Intrinsics.f(request, "request");
        Intrinsics.f(error, "error");
        Logger logger = this.f41946e;
        String str = this.f41942a;
        Uri url = request.getUrl();
        int errorCode = error.getErrorCode();
        CharSequence description = error.getDescription();
        logger.e(str + " An error occurred when loading url: " + url + " error: " + errorCode + " " + ((Object) description));
        Function2<String, String, Unit> function2 = this.f41945d;
        String uri = request.getUrl().toString();
        Intrinsics.e(uri, "request.url.toString()");
        int errorCode2 = error.getErrorCode();
        CharSequence description2 = error.getDescription();
        function2.s(uri, errorCode2 + " " + ((Object) description2));
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        Intrinsics.f(view, "view");
        Intrinsics.f(url, "url");
        if (this.f41943b.invoke(url).booleanValue()) {
            return true;
        }
        if (URLUtil.isNetworkUrl(url)) {
            return false;
        }
        view.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
        return true;
    }
}
