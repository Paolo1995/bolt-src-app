package ee.mtakso.driver.ui.screens.campaigns.v2.circlek;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.signup.PhotoPathDelegate;
import ee.mtakso.driver.ui.screens.signup.TrackActivityRecreatedDelegate;
import ee.mtakso.driver.ui.views.webview.PlainWebView;
import eu.bolt.driver.core.permission.PermissionManager;
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

/* compiled from: CircleKLoyaltyFragment.kt */
/* loaded from: classes3.dex */
public final class CircleKLoyaltyFragment extends BazeMvvmFragment<CircleKLoyaltyViewModel> {

    /* renamed from: t  reason: collision with root package name */
    public static final Companion f27371t = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final PermissionManager f27372o;

    /* renamed from: p  reason: collision with root package name */
    private final Lazy f27373p;

    /* renamed from: q  reason: collision with root package name */
    private final Lazy f27374q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f27375r;

    /* renamed from: s  reason: collision with root package name */
    public Map<Integer, View> f27376s;

    /* compiled from: CircleKLoyaltyFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(String magicLink) {
            Intrinsics.f(magicLink, "magicLink");
            return BundleKt.a(TuplesKt.a("argument_magic_link", magicLink));
        }

        public final void b(Navigator navigator, String magicLink) {
            Intrinsics.f(navigator, "navigator");
            Intrinsics.f(magicLink, "magicLink");
            navigator.d(CircleKLoyaltyFragment.class, a(magicLink), false);
        }

        public final void c(Context context, String magicLink) {
            Intrinsics.f(context, "context");
            Intrinsics.f(magicLink, "magicLink");
            SimpleActivity.f27004l.l(context, CircleKLoyaltyFragment.class, a(magicLink), false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public CircleKLoyaltyFragment(BaseUiDependencies deps, PermissionManager permissionManager) {
        super(deps, R.layout.fragment_plain_webview_toolbar, null, 4, null);
        Lazy b8;
        Lazy b9;
        Intrinsics.f(deps, "deps");
        Intrinsics.f(permissionManager, "permissionManager");
        this.f27376s = new LinkedHashMap();
        this.f27372o = permissionManager;
        b8 = LazyKt__LazyJVMKt.b(new Function0<PhotoPathDelegate>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.circlek.CircleKLoyaltyFragment$photoPathDelegate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final PhotoPathDelegate invoke() {
                Context requireContext = CircleKLoyaltyFragment.this.requireContext();
                Intrinsics.e(requireContext, "requireContext()");
                return new PhotoPathDelegate(requireContext);
            }
        });
        this.f27373p = b8;
        b9 = LazyKt__LazyJVMKt.b(new Function0<TrackActivityRecreatedDelegate>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.circlek.CircleKLoyaltyFragment$trackActivityRecreatedDelegate$2
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final TrackActivityRecreatedDelegate invoke() {
                return new TrackActivityRecreatedDelegate(new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.circlek.CircleKLoyaltyFragment$trackActivityRecreatedDelegate$2.1
                    public final void b() {
                        Kalev.d("CircleKLoyaltyFragment - Activity recreated while picking document");
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        b();
                        return Unit.f50853a;
                    }
                });
            }
        });
        this.f27374q = b9;
    }

    private final String Y() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return null;
        }
        return arguments.getString("argument_magic_link", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Navigator Z() {
        FragmentActivity activity = getActivity();
        Intrinsics.d(activity, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.Navigator");
        return (Navigator) activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PhotoPathDelegate a0() {
        return (PhotoPathDelegate) this.f27373p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TrackActivityRecreatedDelegate b0() {
        return (TrackActivityRecreatedDelegate) this.f27374q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(CircleKLoyaltyFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.Z().c();
    }

    public static final void e0(Context context, String str) {
        f27371t.c(context, str);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f27376s.clear();
    }

    public View S(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f27376s;
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: d0 */
    public CircleKLoyaltyViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (CircleKLoyaltyViewModel) new ViewModelProvider(this, E.d()).a(CircleKLoyaltyViewModel.class);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i8, int i9, Intent intent) {
        Uri uri;
        if (i8 == 5609) {
            if (i9 == -1) {
                uri = a0().f(intent);
            } else {
                uri = null;
            }
            ((PlainWebView) S(R.id.Qc)).f(uri);
            a0().a();
            return;
        }
        super.onActivityResult(i8, i9, intent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requireActivity().setRequestedOrientation(14);
        b0().a(bundle);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        b0().c();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.f(outState, "outState");
        super.onSaveInstanceState(outState);
        b0().d(outState);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onViewCreated(android.view.View r3, android.os.Bundle r4) {
        /*
            r2 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.f(r3, r0)
            super.onViewCreated(r3, r4)
            java.lang.String r3 = r2.Y()
            r4 = 0
            if (r3 == 0) goto L18
            boolean r0 = kotlin.text.StringsKt.y(r3)
            if (r0 == 0) goto L16
            goto L18
        L16:
            r0 = 0
            goto L19
        L18:
            r0 = 1
        L19:
            if (r0 == 0) goto L38
            java.lang.String r3 = "CircleK magic link cannot be empty for circle k webView"
            eu.bolt.kalev.Kalev.d(r3)
            android.content.Context r3 = r2.requireContext()
            r0 = 2131954518(0x7f130b56, float:1.9545537E38)
            android.widget.Toast r3 = android.widget.Toast.makeText(r3, r0, r4)
            r3.show()
            androidx.fragment.app.FragmentActivity r3 = r2.getActivity()
            if (r3 == 0) goto L37
            r3.finish()
        L37:
            return
        L38:
            int r4 = ee.mtakso.driver.R.id.toolbarTitle
            android.view.View r4 = r2.S(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r0 = 2131952387(0x7f130303, float:1.9541215E38)
            r4.setText(r0)
            int r4 = ee.mtakso.driver.R.id.toolbarIcon
            android.view.View r4 = r2.S(r4)
            androidx.appcompat.widget.AppCompatImageView r4 = (androidx.appcompat.widget.AppCompatImageView) r4
            ee.mtakso.driver.ui.screens.campaigns.v2.circlek.a r0 = new ee.mtakso.driver.ui.screens.campaigns.v2.circlek.a
            r0.<init>()
            r4.setOnClickListener(r0)
            ee.mtakso.driver.ui.base.mvvm.BaseViewModel r4 = r2.M()
            ee.mtakso.driver.ui.screens.campaigns.v2.circlek.CircleKLoyaltyViewModel r4 = (ee.mtakso.driver.ui.screens.campaigns.v2.circlek.CircleKLoyaltyViewModel) r4
            ee.mtakso.driver.ui.views.webview.WebViewTracker r4 = r4.D()
            java.lang.String r0 = "CircleK Loyalty"
            r4.c(r0)
            int r4 = ee.mtakso.driver.R.id.Qc
            android.view.View r0 = r2.S(r4)
            ee.mtakso.driver.ui.views.webview.PlainWebView r0 = (ee.mtakso.driver.ui.views.webview.PlainWebView) r0
            ee.mtakso.driver.ui.base.mvvm.BaseViewModel r1 = r2.M()
            ee.mtakso.driver.ui.screens.campaigns.v2.circlek.CircleKLoyaltyViewModel r1 = (ee.mtakso.driver.ui.screens.campaigns.v2.circlek.CircleKLoyaltyViewModel) r1
            ee.mtakso.driver.ui.views.webview.WebViewTracker r1 = r1.D()
            r0.setWebViewTracker(r1)
            android.view.View r0 = r2.S(r4)
            ee.mtakso.driver.ui.views.webview.PlainWebView r0 = (ee.mtakso.driver.ui.views.webview.PlainWebView) r0
            ee.mtakso.driver.ui.screens.campaigns.v2.circlek.CircleKLoyaltyFragment$onViewCreated$2 r1 = new ee.mtakso.driver.ui.screens.campaigns.v2.circlek.CircleKLoyaltyFragment$onViewCreated$2
            r1.<init>()
            r0.setOnCloseWebViewListener(r1)
            android.view.View r0 = r2.S(r4)
            ee.mtakso.driver.ui.views.webview.PlainWebView r0 = (ee.mtakso.driver.ui.views.webview.PlainWebView) r0
            ee.mtakso.driver.ui.screens.campaigns.v2.circlek.CircleKLoyaltyFragment$onViewCreated$3 r1 = new ee.mtakso.driver.ui.screens.campaigns.v2.circlek.CircleKLoyaltyFragment$onViewCreated$3
            r1.<init>()
            r0.setOnFileRequestListener(r1)
            android.view.View r4 = r2.S(r4)
            ee.mtakso.driver.ui.views.webview.PlainWebView r4 = (ee.mtakso.driver.ui.views.webview.PlainWebView) r4
            r4.loadUrl(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.campaigns.v2.circlek.CircleKLoyaltyFragment.onViewCreated(android.view.View, android.os.Bundle):void");
    }
}
