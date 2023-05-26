package ee.mtakso.driver.ui.screens.support;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.features.Feature;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.ui.screens.signup.PhotoPathDelegate;
import ee.mtakso.driver.ui.screens.signup.TrackActivityRecreatedDelegate;
import ee.mtakso.driver.ui.views.webview.PlainWebView;
import ee.mtakso.driver.uicore.components.views.IndeterminateProgressView;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.utils.CompositeUrlLauncher;
import ee.mtakso.driver.utils.ext.ApiExceptionUtils;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.ui.routing.RoutingCommand;
import eu.bolt.kalev.Kalev;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SupportFragment.kt */
/* loaded from: classes5.dex */
public final class SupportFragment extends BazeMvvmFragment<SupportViewModel> {

    /* renamed from: u */
    public static final Companion f33440u = new Companion(null);

    /* renamed from: o */
    private final PermissionManager f33441o;

    /* renamed from: p */
    private final CompositeUrlLauncher f33442p;

    /* renamed from: q */
    private final Lazy f33443q;

    /* renamed from: r */
    private final Lazy f33444r;

    /* renamed from: s */
    private boolean f33445s;

    /* renamed from: t */
    public Map<Integer, View> f33446t;

    /* compiled from: SupportFragment.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ RoutingCommand.ActivityClass b(Companion companion, String str, String str2, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                str = null;
            }
            if ((i8 & 2) != 0) {
                str2 = null;
            }
            return companion.a(str, str2);
        }

        public static /* synthetic */ Bundle d(Companion companion, String str, String str2, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                str = null;
            }
            if ((i8 & 2) != 0) {
                str2 = null;
            }
            return companion.c(str, str2);
        }

        public static /* synthetic */ void f(Companion companion, Context context, String str, String str2, int i8, Object obj) {
            if ((i8 & 2) != 0) {
                str = null;
            }
            if ((i8 & 4) != 0) {
                str2 = null;
            }
            companion.e(context, str, str2);
        }

        public final RoutingCommand.ActivityClass a(String str, String str2) {
            return SimpleActivity.Companion.f(SimpleActivity.f27004l, SupportFragment.class, c(str, str2), false, 0, 8, null);
        }

        public final Bundle c(String str, String str2) {
            return BundleKt.a(TuplesKt.a("argument_support_webapp_url", str), TuplesKt.a("argument_webapp_launch_token", str2));
        }

        public final void e(Context context, String str, String str2) {
            Intrinsics.f(context, "context");
            SimpleActivity.f27004l.l(context, SupportFragment.class, c(str, str2), false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public SupportFragment(BaseUiDependencies deps, PermissionManager permissionManager, CompositeUrlLauncher urlLauncher) {
        super(deps, R.layout.fragment_plain_webview_toolbar, null, 4, null);
        Lazy b8;
        Lazy b9;
        Intrinsics.f(deps, "deps");
        Intrinsics.f(permissionManager, "permissionManager");
        Intrinsics.f(urlLauncher, "urlLauncher");
        this.f33446t = new LinkedHashMap();
        this.f33441o = permissionManager;
        this.f33442p = urlLauncher;
        b8 = LazyKt__LazyJVMKt.b(new Function0<PhotoPathDelegate>() { // from class: ee.mtakso.driver.ui.screens.support.SupportFragment$photoPathDelegate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final PhotoPathDelegate invoke() {
                Context requireContext = SupportFragment.this.requireContext();
                Intrinsics.e(requireContext, "requireContext()");
                return new PhotoPathDelegate(requireContext);
            }
        });
        this.f33443q = b8;
        b9 = LazyKt__LazyJVMKt.b(new Function0<TrackActivityRecreatedDelegate>() { // from class: ee.mtakso.driver.ui.screens.support.SupportFragment$trackActivityRecreatedDelegate$2
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final TrackActivityRecreatedDelegate invoke() {
                return new TrackActivityRecreatedDelegate(new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.support.SupportFragment$trackActivityRecreatedDelegate$2.1
                    public final void b() {
                        Kalev.d("SupportFragment - Activity recreated while picking document");
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        b();
                        return Unit.f50853a;
                    }
                });
            }
        });
        this.f33444r = b9;
    }

    public final Navigator b0() {
        FragmentActivity activity = getActivity();
        Intrinsics.d(activity, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.Navigator");
        return (Navigator) activity;
    }

    public final PhotoPathDelegate c0() {
        return (PhotoPathDelegate) this.f33443q.getValue();
    }

    private final String d0() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return null;
        }
        return arguments.getString("argument_support_webapp_url", null);
    }

    public final TrackActivityRecreatedDelegate e0() {
        return (TrackActivityRecreatedDelegate) this.f33444r.getValue();
    }

    private final String f0() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return null;
        }
        return arguments.getString("argument_webapp_launch_token", null);
    }

    private final void g0(String str, String str2) {
        if (str != null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str2);
            try {
                startActivity(intent);
                return;
            } catch (Exception unused) {
                RuntimeException runtimeException = new RuntimeException("WebView download failed!");
                Kalev.e(runtimeException, "Not able to start url " + str + " with mimeType " + str2);
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setData(Uri.parse(str));
                try {
                    startActivity(intent2);
                    return;
                } catch (Exception unused2) {
                    RuntimeException runtimeException2 = new RuntimeException("WebView download failed!");
                    Kalev.e(runtimeException2, "Not able to start url " + str + " without mimeType");
                    Toast.makeText(requireContext(), (int) R.string.something_went_wrong, 0).show();
                    return;
                }
            }
        }
        Kalev.e(new RuntimeException("WebView download failed!"), "URL is null");
        Toast.makeText(requireContext(), (int) R.string.something_went_wrong, 0).show();
    }

    public static final void h0(SupportFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.b0().c();
    }

    public static final void i0(SupportFragment this$0, String str, String str2, String str3, String str4, long j8) {
        Intrinsics.f(this$0, "this$0");
        this$0.g0(str, str4);
    }

    public static final void j0(SupportFragment this$0, String str) {
        Intrinsics.f(this$0, "this$0");
        ((PlainWebView) this$0.U(R.id.Qc)).loadUrl(str);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f33446t.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void G() {
        IndeterminateProgressView progressView = (IndeterminateProgressView) U(R.id.r9);
        Intrinsics.e(progressView, "progressView");
        ViewExtKt.e(progressView, false, 0, 2, null);
        PlainWebView webView = (PlainWebView) U(R.id.Qc);
        Intrinsics.e(webView, "webView");
        ViewExtKt.e(webView, true, 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void H(Throwable error) {
        Intrinsics.f(error, "error");
        PlainWebView webView = (PlainWebView) U(R.id.Qc);
        Intrinsics.e(webView, "webView");
        ViewExtKt.e(webView, false, 0, 2, null);
        NotificationDialog.Companion companion = NotificationDialog.f28313n;
        String string = getString(R.string.error);
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        String k8 = ApiExceptionUtils.k(error, requireContext);
        String string2 = getString(R.string.ok_lowercase);
        Intrinsics.e(string2, "getString(R.string.ok_lowercase)");
        NotificationDialog d8 = NotificationDialog.Companion.d(companion, string, k8, string2, error, null, 16, null);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        FragmentUtils.c(d8, requireActivity, "error");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void I() {
        IndeterminateProgressView progressView = (IndeterminateProgressView) U(R.id.r9);
        Intrinsics.e(progressView, "progressView");
        ViewExtKt.e(progressView, true, 0, 2, null);
        PlainWebView webView = (PlainWebView) U(R.id.Qc);
        Intrinsics.e(webView, "webView");
        ViewExtKt.e(webView, false, 0, 2, null);
    }

    public View U(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f33446t;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: k0 */
    public SupportViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (SupportViewModel) new ViewModelProvider(this, E.d()).a(SupportViewModel.class);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i8, int i9, Intent intent) {
        Uri uri;
        if (i8 == 5609) {
            if (i9 == -1) {
                uri = c0().f(intent);
            } else {
                uri = null;
            }
            ((PlainWebView) U(R.id.Qc)).f(uri);
            c0().a();
            return;
        }
        super.onActivityResult(i8, i9, intent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e0().a(bundle);
        if (M().I().b(Feature.Type.CUSTOMER_SUPPORT_WEBVIEW_ORIENTATION_LOCKED)) {
            requireActivity().setRequestedOrientation(14);
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        int i8 = R.id.Qc;
        ((PlainWebView) U(i8)).setOnCloseWebViewListener(null);
        ((PlainWebView) U(i8)).setOnFileRequestListener(null);
        D();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        e0().c();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.f(outState, "outState");
        super.onSaveInstanceState(outState);
        e0().d(outState);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f3  */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onViewCreated(android.view.View r5, android.os.Bundle r6) {
        /*
            r4 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.f(r5, r0)
            super.onViewCreated(r5, r6)
            java.lang.String r5 = r4.d0()
            java.lang.String r6 = r4.f0()
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L1d
            boolean r2 = kotlin.text.StringsKt.y(r5)
            if (r2 == 0) goto L1b
            goto L1d
        L1b:
            r2 = 0
            goto L1e
        L1d:
            r2 = 1
        L1e:
            if (r2 == 0) goto L49
            if (r6 == 0) goto L2a
            boolean r2 = kotlin.text.StringsKt.y(r6)
            if (r2 == 0) goto L29
            goto L2a
        L29:
            r0 = 0
        L2a:
            if (r0 == 0) goto L49
            java.lang.String r5 = "Support webapp url or webapp launch token cannot be empty for support screen"
            eu.bolt.kalev.Kalev.d(r5)
            android.content.Context r5 = r4.requireContext()
            r6 = 2131954518(0x7f130b56, float:1.9545537E38)
            android.widget.Toast r5 = android.widget.Toast.makeText(r5, r6, r1)
            r5.show()
            androidx.fragment.app.FragmentActivity r5 = r4.getActivity()
            if (r5 == 0) goto L48
            r5.finish()
        L48:
            return
        L49:
            int r0 = ee.mtakso.driver.R.id.toolbarTitle
            android.view.View r0 = r4.U(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 2131954595(0x7f130ba3, float:1.9545694E38)
            r0.setText(r1)
            int r0 = ee.mtakso.driver.R.id.toolbarIcon
            android.view.View r0 = r4.U(r0)
            androidx.appcompat.widget.AppCompatImageView r0 = (androidx.appcompat.widget.AppCompatImageView) r0
            ee.mtakso.driver.ui.screens.support.a r1 = new ee.mtakso.driver.ui.screens.support.a
            r1.<init>()
            r0.setOnClickListener(r1)
            ee.mtakso.driver.ui.base.mvvm.BaseViewModel r0 = r4.M()
            ee.mtakso.driver.ui.screens.support.SupportViewModel r0 = (ee.mtakso.driver.ui.screens.support.SupportViewModel) r0
            ee.mtakso.driver.ui.views.webview.WebViewTracker r0 = r0.J()
            java.lang.String r1 = "Support"
            r0.c(r1)
            int r0 = ee.mtakso.driver.R.id.Qc
            android.view.View r1 = r4.U(r0)
            ee.mtakso.driver.ui.views.webview.PlainWebView r1 = (ee.mtakso.driver.ui.views.webview.PlainWebView) r1
            ee.mtakso.driver.ui.base.mvvm.BaseViewModel r2 = r4.M()
            ee.mtakso.driver.ui.screens.support.SupportViewModel r2 = (ee.mtakso.driver.ui.screens.support.SupportViewModel) r2
            ee.mtakso.driver.ui.views.webview.WebViewTracker r2 = r2.J()
            r1.setWebViewTracker(r2)
            android.view.View r1 = r4.U(r0)
            ee.mtakso.driver.ui.views.webview.PlainWebView r1 = (ee.mtakso.driver.ui.views.webview.PlainWebView) r1
            ee.mtakso.driver.ui.screens.support.SupportFragment$onViewCreated$2 r2 = new ee.mtakso.driver.ui.screens.support.SupportFragment$onViewCreated$2
            r2.<init>()
            r1.setOnCloseWebViewListener(r2)
            android.view.View r1 = r4.U(r0)
            ee.mtakso.driver.ui.views.webview.PlainWebView r1 = (ee.mtakso.driver.ui.views.webview.PlainWebView) r1
            ee.mtakso.driver.ui.screens.support.SupportFragment$onViewCreated$3 r2 = new ee.mtakso.driver.ui.screens.support.SupportFragment$onViewCreated$3
            r2.<init>()
            r1.setOnFileRequestListener(r2)
            android.view.View r1 = r4.U(r0)
            ee.mtakso.driver.ui.views.webview.PlainWebView r1 = (ee.mtakso.driver.ui.views.webview.PlainWebView) r1
            ee.mtakso.driver.ui.screens.support.b r2 = new ee.mtakso.driver.ui.screens.support.b
            r2.<init>()
            r1.setDownloadListener(r2)
            android.view.View r1 = r4.U(r0)
            ee.mtakso.driver.ui.views.webview.PlainWebView r1 = (ee.mtakso.driver.ui.views.webview.PlainWebView) r1
            ee.mtakso.driver.ui.screens.support.SupportFragment$onViewCreated$5 r2 = new ee.mtakso.driver.ui.screens.support.SupportFragment$onViewCreated$5
            r2.<init>()
            r1.setOnCreateWindow(r2)
            android.view.View r1 = r4.U(r0)
            ee.mtakso.driver.ui.views.webview.PlainWebView r1 = (ee.mtakso.driver.ui.views.webview.PlainWebView) r1
            ee.mtakso.driver.ui.screens.support.SupportFragment$onViewCreated$6 r2 = new ee.mtakso.driver.ui.screens.support.SupportFragment$onViewCreated$6
            r2.<init>()
            r1.setOnHandleDeepLinkUrlChange(r2)
            ee.mtakso.driver.ui.base.mvvm.BaseViewModel r1 = r4.M()
            ee.mtakso.driver.ui.screens.support.SupportViewModel r1 = (ee.mtakso.driver.ui.screens.support.SupportViewModel) r1
            androidx.lifecycle.LiveData r1 = r1.O()
            androidx.lifecycle.LifecycleOwner r2 = r4.getViewLifecycleOwner()
            ee.mtakso.driver.ui.screens.support.c r3 = new ee.mtakso.driver.ui.screens.support.c
            r3.<init>()
            r1.i(r2, r3)
            if (r5 == 0) goto Lf3
            android.view.View r6 = r4.U(r0)
            ee.mtakso.driver.ui.views.webview.PlainWebView r6 = (ee.mtakso.driver.ui.views.webview.PlainWebView) r6
            r6.loadUrl(r5)
            goto Lfe
        Lf3:
            if (r6 == 0) goto Lfe
            ee.mtakso.driver.ui.base.mvvm.BaseViewModel r5 = r4.M()
            ee.mtakso.driver.ui.screens.support.SupportViewModel r5 = (ee.mtakso.driver.ui.screens.support.SupportViewModel) r5
            r5.K(r6)
        Lfe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.support.SupportFragment.onViewCreated(android.view.View, android.os.Bundle):void");
    }
}
