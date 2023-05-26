package ee.mtakso.driver.ui.views.webview;

import android.annotation.TargetApi;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.ConsoleMessage;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.google.android.gms.common.internal.ImagesContract;
import ee.mtakso.driver.log.strategy.memory.WebViewStrategy;
import ee.mtakso.driver.service.analytics.event.facade.WebViewAnalytics;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.LogEntry;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebViewTracker.kt */
/* loaded from: classes5.dex */
public final class WebViewTracker {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f34565d = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final WebViewAnalytics f34566a;

    /* renamed from: b  reason: collision with root package name */
    private final WebViewStrategy f34567b;

    /* renamed from: c  reason: collision with root package name */
    private String f34568c;

    /* compiled from: WebViewTracker.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public WebViewTracker(WebViewAnalytics webViewAnalytics, WebViewStrategy webViewStrategy) {
        Intrinsics.f(webViewAnalytics, "webViewAnalytics");
        Intrinsics.f(webViewStrategy, "webViewStrategy");
        this.f34566a = webViewAnalytics;
        this.f34567b = webViewStrategy;
        this.f34568c = "";
    }

    public final void a() {
        this.f34567b.d();
    }

    public final void b() {
        this.f34567b.g();
    }

    public final void c(String webViewTag) {
        Intrinsics.f(webViewTag, "webViewTag");
        this.f34568c = webViewTag;
    }

    public final void d(ConsoleMessage consoleMessage) {
        String str;
        String str2;
        Integer num;
        String str3;
        ConsoleMessage.MessageLevel messageLevel;
        LogEntry j8 = Kalev.j("WebView Tracker");
        ConsoleMessage.MessageLevel messageLevel2 = null;
        if (consoleMessage != null && (messageLevel = consoleMessage.messageLevel()) != null) {
            str = messageLevel.name();
        } else {
            str = null;
        }
        LogEntry n8 = j8.n("messageLevel", str);
        if (consoleMessage != null) {
            str2 = consoleMessage.message();
        } else {
            str2 = null;
        }
        LogEntry n9 = n8.n("message", str2);
        if (consoleMessage != null) {
            num = Integer.valueOf(consoleMessage.lineNumber());
        } else {
            num = null;
        }
        LogEntry n10 = n9.n("lineNumber", num);
        if (consoleMessage != null) {
            str3 = consoleMessage.sourceId();
        } else {
            str3 = null;
        }
        n10.n("sourceId", str3).a("WebView Console Message");
        if (consoleMessage != null) {
            messageLevel2 = consoleMessage.messageLevel();
        }
        if (messageLevel2 == ConsoleMessage.MessageLevel.ERROR) {
            WebViewAnalytics webViewAnalytics = this.f34566a;
            String str4 = this.f34568c;
            String name = consoleMessage.messageLevel().name();
            String message = consoleMessage.message();
            Intrinsics.e(message, "consoleMessage.message()");
            webViewAnalytics.D2(str4, name, message, consoleMessage.lineNumber(), consoleMessage.sourceId());
        }
    }

    public final void e(String str, int i8, String str2) {
        Kalev.j("WebView Tracker").n("message", str).n("lineNumber", Integer.valueOf(i8)).n("sourceId", str2).a("WebView Console Message");
    }

    public final void f(String str) {
        String str2;
        LogEntry n8 = Kalev.j("WebView Tracker").n("tag", this.f34568c);
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        n8.n(ImagesContract.URL, str2).a("Web Page Visible");
        WebViewAnalytics webViewAnalytics = this.f34566a;
        String str3 = this.f34568c;
        if (str == null) {
            str = "";
        }
        webViewAnalytics.L3(str3, str);
    }

    public final void g(String str) {
        String str2;
        LogEntry n8 = Kalev.j("WebView Tracker").n("tag", this.f34568c);
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        n8.n(ImagesContract.URL, str2).a("Web Page Load Succeed");
        WebViewAnalytics webViewAnalytics = this.f34566a;
        String str3 = this.f34568c;
        if (str == null) {
            str = "";
        }
        webViewAnalytics.a1(str3, str);
    }

    public final void h(int i8, String str, String str2) {
        String str3;
        String str4;
        LogEntry n8 = Kalev.j("WebView Tracker").n("tag", this.f34568c);
        if (str2 == null) {
            str3 = "";
        } else {
            str3 = str2;
        }
        LogEntry n9 = n8.n(ImagesContract.URL, str3).n("errorCode", Integer.valueOf(i8));
        if (str == null) {
            str4 = "";
        } else {
            str4 = str;
        }
        n9.n("description", str4).a("Web Page Load Failed");
        WebViewAnalytics webViewAnalytics = this.f34566a;
        String str5 = this.f34568c;
        if (str2 == null) {
            str2 = "";
        }
        if (str == null) {
            str = "";
        }
        webViewAnalytics.l3(str5, str2, i8, str);
    }

    @TargetApi(23)
    public final void i(WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        int i8;
        CharSequence description;
        Uri url;
        CharSequence description2;
        Uri url2;
        CharSequence charSequence = "";
        LogEntry n8 = Kalev.j("WebView Tracker").n("tag", this.f34568c).n(ImagesContract.URL, (webResourceRequest == null || (url2 = webResourceRequest.getUrl()) == null || (r2 = url2.toString()) == null) ? "" : "");
        int i9 = -1;
        if (webResourceError != null) {
            i8 = webResourceError.getErrorCode();
        } else {
            i8 = -1;
        }
        n8.n("errorCode", Integer.valueOf(i8)).n("description", (webResourceError == null || (description2 = webResourceError.getDescription()) == null || (r3 = description2.toString()) == null) ? "" : "").a("Web Page Load Failed");
        WebViewAnalytics webViewAnalytics = this.f34566a;
        String str = this.f34568c;
        String str2 = (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null || (str2 = url.toString()) == null) ? "" : "";
        if (webResourceError != null) {
            i9 = webResourceError.getErrorCode();
        }
        if (webResourceError != null && (description = webResourceError.getDescription()) != null) {
            charSequence = description;
        }
        webViewAnalytics.l3(str, str2, i9, charSequence.toString());
    }

    @TargetApi(23)
    public final void j(WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        int i8;
        String str;
        Uri url;
        Uri url2;
        String str2 = "";
        LogEntry n8 = Kalev.j("WebView Tracker").n("tag", this.f34568c).n(ImagesContract.URL, (webResourceRequest == null || (url2 = webResourceRequest.getUrl()) == null || (r2 = url2.toString()) == null) ? "" : "");
        int i9 = -1;
        if (webResourceResponse != null) {
            i8 = webResourceResponse.getStatusCode();
        } else {
            i8 = -1;
        }
        LogEntry n9 = n8.n("statusCode", Integer.valueOf(i8));
        String str3 = null;
        if (webResourceResponse != null) {
            str = webResourceResponse.getReasonPhrase();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        n9.n("reasonPhrase", str).a("Web Page Http Error");
        WebViewAnalytics webViewAnalytics = this.f34566a;
        String str4 = this.f34568c;
        String str5 = (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null || (str5 = url.toString()) == null) ? "" : "";
        if (webResourceResponse != null) {
            i9 = webResourceResponse.getStatusCode();
        }
        if (webResourceResponse != null) {
            str3 = webResourceResponse.getReasonPhrase();
        }
        if (str3 != null) {
            str2 = str3;
        }
        webViewAnalytics.B(str4, str5, i9, str2);
    }

    public final void k(SslError sslError) {
        String str;
        int i8;
        LogEntry n8 = Kalev.j("WebView Tracker").n("tag", this.f34568c);
        String str2 = null;
        if (sslError != null) {
            str = sslError.getUrl();
        } else {
            str = null;
        }
        String str3 = "";
        if (str == null) {
            str = "";
        }
        LogEntry n9 = n8.n(ImagesContract.URL, str);
        int i9 = -1;
        if (sslError != null) {
            i8 = sslError.getPrimaryError();
        } else {
            i8 = -1;
        }
        n9.n("primaryError", Integer.valueOf(i8)).a("Web Page Ssl Error");
        WebViewAnalytics webViewAnalytics = this.f34566a;
        String str4 = this.f34568c;
        if (sslError != null) {
            str2 = sslError.getUrl();
        }
        if (str2 != null) {
            str3 = str2;
        }
        if (sslError != null) {
            i9 = sslError.getPrimaryError();
        }
        webViewAnalytics.S3(str4, str3, i9);
    }

    public final void l() {
        Kalev.j("WebView Tracker").n("tag", this.f34568c).a("Web Page Too Many Redirects");
        this.f34566a.Y0(this.f34568c);
    }
}
