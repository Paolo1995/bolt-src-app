package eu.bolt.verification.sdk.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Message;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import eu.bolt.android.rib.BaseViewRibPresenterExtKt;
import eu.bolt.coroutines.flows.PublishFlow;
import eu.bolt.logger.Logger;
import eu.bolt.verification.R$string;
import eu.bolt.verification.sdk.internal.ac;
import eu.bolt.verification.sdk.internal.dr;
import eu.bolt.verification.sdk.internal.lr;
import io.reactivex.Observable;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.rx2.RxConvertKt;

@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes5.dex */
public final class er implements dr {

    /* renamed from: a  reason: collision with root package name */
    private final hr f42855a;

    /* renamed from: b  reason: collision with root package name */
    private final Logger f42856b;

    /* renamed from: c  reason: collision with root package name */
    private final PublishFlow<dr.b> f42857c;

    /* renamed from: d  reason: collision with root package name */
    private final String f42858d;

    /* renamed from: e  reason: collision with root package name */
    private ir f42859e;

    /* renamed from: f  reason: collision with root package name */
    private String f42860f;

    /* renamed from: g  reason: collision with root package name */
    private String f42861g;

    /* renamed from: h  reason: collision with root package name */
    private final v3 f42862h;

    /* loaded from: classes5.dex */
    /* synthetic */ class a extends FunctionReferenceImpl implements Function1<String, Boolean> {
        a(Object obj) {
            super(1, obj, v3.class, "intercept", "intercept(Ljava/lang/String;)Z", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: j */
        public final Boolean invoke(String p02) {
            Intrinsics.f(p02, "p0");
            return Boolean.valueOf(((v3) this.f50989g).b(p02));
        }
    }

    /* loaded from: classes5.dex */
    /* synthetic */ class b extends FunctionReferenceImpl implements Function1<String, Unit> {
        b(Object obj) {
            super(1, obj, er.class, "onPageLoaded", "onPageLoaded(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            j(str);
            return Unit.f50853a;
        }

        public final void j(String p02) {
            Intrinsics.f(p02, "p0");
            ((er) this.f50989g).O(p02);
        }
    }

    /* loaded from: classes5.dex */
    /* synthetic */ class c extends FunctionReferenceImpl implements Function2<String, String, Unit> {
        c(Object obj) {
            super(2, obj, er.class, "onPageLoadingError", "onPageLoadingError(Ljava/lang/String;Ljava/lang/String;)V", 0);
        }

        public final void j(String p02, String p12) {
            Intrinsics.f(p02, "p0");
            Intrinsics.f(p12, "p1");
            ((er) this.f50989g).K(p02, p12);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit s(String str, String str2) {
            j(str, str2);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends WebChromeClient {
        d() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            Intrinsics.f(consoleMessage, "consoleMessage");
            Logger logger = er.this.f42856b;
            String str = er.this.f42858d;
            String message = consoleMessage.message();
            String sourceId = consoleMessage.sourceId();
            logger.b(str + " console_msg: " + message + ", sourceId:" + sourceId);
            if (consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR) {
                er.this.C(consoleMessage);
                return true;
            }
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView view, boolean z7, boolean z8, Message resultMsg) {
            Intrinsics.f(view, "view");
            Intrinsics.f(resultMsg, "resultMsg");
            er.this.M(er.this.A(view));
            return false;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            Intrinsics.f(filePathCallback, "filePathCallback");
            Intrinsics.f(fileChooserParams, "fileChooserParams");
            er.this.f42857c.f(new dr.b.c(fileChooserParams, filePathCallback));
            return true;
        }
    }

    /* loaded from: classes5.dex */
    static final class e extends Lambda implements Function0<Unit> {
        e() {
            super(0);
        }

        public final void b() {
            er.this.f42857c.f(dr.b.C0046b.f42663a);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            b();
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    static final class f extends Lambda implements Function1<String, Boolean> {
        f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final Boolean invoke(String it) {
            Intrinsics.f(it, "it");
            ir irVar = er.this.f42859e;
            return Boolean.valueOf(irVar != null ? irVar.c(it) : false);
        }
    }

    /* loaded from: classes5.dex */
    static final class g extends Lambda implements Function1<String, Unit> {
        g() {
            super(1);
        }

        public final void b(String it) {
            Intrinsics.f(it, "it");
            er.this.f42857c.f(new dr.b.g(it));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            b(str);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    public static final class h implements Flow<dr.b.a> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Flow f42867f;

        /* loaded from: classes5.dex */
        public static final class a<T> implements FlowCollector {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ FlowCollector f42868f;

            @DebugMetadata(c = "eu.bolt.android.webview.WebPageRibPresenterImpl$observeCloseClicks$$inlined$map$1$2", f = "WebPageRibPresenterImpl.kt", l = {223}, m = "emit")
            /* renamed from: eu.bolt.verification.sdk.internal.er$h$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public static final class C0051a extends ContinuationImpl {

                /* renamed from: f  reason: collision with root package name */
                /* synthetic */ Object f42869f;

                /* renamed from: g  reason: collision with root package name */
                int f42870g;

                public C0051a(Continuation continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.f42869f = obj;
                    this.f42870g |= Integer.MIN_VALUE;
                    return a.this.b(null, this);
                }
            }

            public a(FlowCollector flowCollector) {
                this.f42868f = flowCollector;
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
            /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object b(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof eu.bolt.verification.sdk.internal.er.h.a.C0051a
                    if (r0 == 0) goto L13
                    r0 = r6
                    eu.bolt.verification.sdk.internal.er$h$a$a r0 = (eu.bolt.verification.sdk.internal.er.h.a.C0051a) r0
                    int r1 = r0.f42870g
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f42870g = r1
                    goto L18
                L13:
                    eu.bolt.verification.sdk.internal.er$h$a$a r0 = new eu.bolt.verification.sdk.internal.er$h$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.f42869f
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                    int r2 = r0.f42870g
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    kotlin.ResultKt.b(r6)
                    goto L43
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    kotlin.ResultKt.b(r6)
                    kotlinx.coroutines.flow.FlowCollector r6 = r4.f42868f
                    kotlin.Unit r5 = (kotlin.Unit) r5
                    eu.bolt.verification.sdk.internal.dr$b$a r5 = eu.bolt.verification.sdk.internal.dr.b.a.f42662a
                    r0.f42870g = r3
                    java.lang.Object r5 = r6.b(r5, r0)
                    if (r5 != r1) goto L43
                    return r1
                L43:
                    kotlin.Unit r5 = kotlin.Unit.f50853a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.er.h.a.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        public h(Flow flow) {
            this.f42867f = flow;
        }

        @Override // kotlinx.coroutines.flow.Flow
        public Object a(FlowCollector<? super dr.b.a> flowCollector, Continuation continuation) {
            Object d8;
            Object a8 = this.f42867f.a(new a(flowCollector), continuation);
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            return a8 == d8 ? a8 : Unit.f50853a;
        }
    }

    @Inject
    public er(hr view, lr windowInsetsViewDelegate) {
        Intrinsics.f(view, "view");
        Intrinsics.f(windowInsetsViewDelegate, "windowInsetsViewDelegate");
        this.f42855a = view;
        this.f42856b = ac.b.f42045b.e();
        this.f42857c = BaseViewRibPresenterExtKt.a(this);
        this.f42858d = "WebViewRib";
        v3 v3Var = new v3(new e(), new f(), new g());
        this.f42862h = v3Var;
        lr.a.a(windowInsetsViewDelegate, view, false, false, 4, null);
        WebSettings settings = view.getBinding().f44053c.getSettings();
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setSupportMultipleWindows(true);
        view.getBinding().f44053c.setWebViewClient(new a3("WebViewRib", new a(v3Var), new b(this), new c(this)));
        view.getBinding().f44053c.setWebChromeClient(z());
        view.getBinding().f44053c.setDownloadListener(new DownloadListener() { // from class: eu.bolt.verification.sdk.internal.ls
            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j8) {
                er.G(er.this, str, str2, str3, str4, j8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String A(WebView webView) {
        WebView.HitTestResult hitTestResult = webView.getHitTestResult();
        Intrinsics.e(hitTestResult, "view.hitTestResult");
        String uri = Uri.parse(hitTestResult.getExtra()).toString();
        Intrinsics.e(uri, "parse.toString()");
        return uri;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(ConsoleMessage consoleMessage) {
        PublishFlow<dr.b> publishFlow = this.f42857c;
        String url = this.f42855a.getBinding().f44053c.getUrl();
        if (url == null) {
            url = "";
        }
        String sourceId = consoleMessage.sourceId();
        Intrinsics.e(sourceId, "consoleMessage.sourceId()");
        String message = consoleMessage.message();
        Intrinsics.e(message, "consoleMessage.message()");
        publishFlow.f(new dr.b.d(url, sourceId, message));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(er this$0, String str, String str2, String str3, String str4, long j8) {
        Intrinsics.f(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        if (intent.resolveActivity(this$0.f42855a.getBinding().getRoot().getContext().getPackageManager()) != null) {
            this$0.f42855a.getBinding().getRoot().getContext().startActivity(intent);
            return;
        }
        Logger logger = this$0.f42856b;
        logger.e("not found downloading action for url " + str);
    }

    private final Flow<dr.b.a> I() {
        return new h(RxConvertKt.b(this.f42855a.getBinding().f44052b.a0()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(String str, String str2) {
        if (Intrinsics.a(this.f42861g, str)) {
            return;
        }
        this.f42861g = str;
        this.f42857c.f(new dr.b.f(str, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(String str) {
        if (this.f42862h.b(str)) {
            return;
        }
        Context context = this.f42855a.getContext();
        Intrinsics.e(context, "view.context");
        f2.g(context, str, R$string.dialog_share_no_apps_found_toast, 0, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(String str) {
        if (Intrinsics.a(this.f42860f, str)) {
            return;
        }
        this.f42860f = str;
        this.f42857c.f(new dr.b.e(str));
    }

    private final d z() {
        return new d();
    }

    @Override // eu.bolt.verification.sdk.internal.dr
    public boolean c() {
        return this.f42855a.getBinding().f44053c.canGoBack();
    }

    @Override // eu.bolt.verification.sdk.internal.dr
    public void d(int i8) {
        Context context = this.f42855a.getContext();
        Intrinsics.e(context, "view.context");
        f2.d(context, i8, 0, 2, null);
    }

    @Override // eu.bolt.verification.sdk.internal.dr
    public void e() {
        this.f42855a.getBinding().f44053c.goBack();
    }

    @Override // eu.bolt.android.rib.BaseViewRibPresenter
    public Observable<dr.b> h() {
        return dr.a.a(this);
    }

    @Override // eu.bolt.android.rib.BaseViewRibPresenter
    public Flow<dr.b> p() {
        return FlowKt.D(I(), this.f42857c);
    }

    @Override // eu.bolt.verification.sdk.internal.dr
    public void q(ir urlHandler) {
        Intrinsics.f(urlHandler, "urlHandler");
        this.f42859e = urlHandler;
    }

    @Override // eu.bolt.verification.sdk.internal.dr
    public void r(String url, String str, Map<String, String> headers) {
        Intrinsics.f(url, "url");
        Intrinsics.f(headers, "headers");
        this.f42855a.getBinding().f44052b.setTitle(str);
        this.f42855a.getBinding().f44053c.loadUrl(url, headers);
    }

    @Override // eu.bolt.verification.sdk.internal.dr
    public void s(String url, String str) {
        Intrinsics.f(url, "url");
        this.f42855a.getBinding().f44052b.setTitle(str);
        this.f42855a.getBinding().f44053c.loadUrl(url);
    }
}
