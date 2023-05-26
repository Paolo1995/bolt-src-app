package ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.views.webview.EarningsPaymentWebView;
import ee.mtakso.driver.uicore.components.views.IndeterminateProgressView;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: PayToBoltFragment.kt */
/* loaded from: classes3.dex */
public final class PayToBoltFragment extends BazeMvvmFragment<PayToBoltViewModel> {

    /* renamed from: q  reason: collision with root package name */
    public static final Companion f28625q = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private OnPayListener f28626o;

    /* renamed from: p  reason: collision with root package name */
    public Map<Integer, View> f28627p;

    /* compiled from: PayToBoltFragment.kt */
    /* loaded from: classes3.dex */
    public interface ActionBarMenuController {
        void E();

        void b();
    }

    /* compiled from: PayToBoltFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(String url) {
            Intrinsics.f(url, "url");
            Bundle bundle = new Bundle();
            bundle.putString("args.url", url);
            return bundle;
        }

        public final Bundle b(String url) {
            Intrinsics.f(url, "url");
            Bundle bundle = new Bundle();
            bundle.putString("raw.args.url", url);
            return bundle;
        }
    }

    /* compiled from: PayToBoltFragment.kt */
    /* loaded from: classes3.dex */
    public interface OnPayListener {
        void j();

        void z();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public PayToBoltFragment(BaseUiDependencies deps) {
        super(deps, R.layout.fragment_balance_webview, null, 4, null);
        Intrinsics.f(deps, "deps");
        this.f28627p = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(PayToBoltFragment this$0, String str) {
        Intrinsics.f(this$0, "this$0");
        ((EarningsPaymentWebView) this$0.S(R.id.earningsPaymentWebView)).loadUrl(str);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f28627p.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void G() {
        IndeterminateProgressView loadingView = (IndeterminateProgressView) S(R.id.V6);
        Intrinsics.e(loadingView, "loadingView");
        ViewExtKt.e(loadingView, false, 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void I() {
        IndeterminateProgressView loadingView = (IndeterminateProgressView) S(R.id.V6);
        Intrinsics.e(loadingView, "loadingView");
        ViewExtKt.e(loadingView, true, 0, 2, null);
    }

    public View S(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f28627p;
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

    public final OnPayListener U() {
        return this.f28626o;
    }

    public final boolean V() {
        String string;
        boolean y7;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("raw.args.url")) == null) {
            return false;
        }
        y7 = StringsKt__StringsJVMKt.y(string);
        if (!(!y7)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: X */
    public PayToBoltViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (PayToBoltViewModel) new ViewModelProvider(this, E.d()).a(PayToBoltViewModel.class);
    }

    public final void Y(OnPayListener onPayListener) {
        this.f28626o = onPayListener;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        ActionBarMenuController actionBarMenuController;
        super.onStart();
        FragmentActivity activity = getActivity();
        if (activity instanceof ActionBarMenuController) {
            actionBarMenuController = (ActionBarMenuController) activity;
        } else {
            actionBarMenuController = null;
        }
        if (actionBarMenuController != null) {
            actionBarMenuController.E();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        ActionBarMenuController actionBarMenuController;
        super.onStop();
        FragmentActivity activity = getActivity();
        if (activity instanceof ActionBarMenuController) {
            actionBarMenuController = (ActionBarMenuController) activity;
        } else {
            actionBarMenuController = null;
        }
        if (actionBarMenuController != null) {
            actionBarMenuController.b();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b4  */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onViewCreated(android.view.View r4, android.os.Bundle r5) {
        /*
            r3 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.f(r4, r0)
            super.onViewCreated(r4, r5)
            androidx.fragment.app.FragmentActivity r4 = r3.getActivity()
            boolean r5 = r4 instanceof androidx.appcompat.app.AppCompatActivity
            r0 = 0
            if (r5 == 0) goto L14
            androidx.appcompat.app.AppCompatActivity r4 = (androidx.appcompat.app.AppCompatActivity) r4
            goto L15
        L14:
            r4 = r0
        L15:
            if (r4 == 0) goto L1c
            androidx.appcompat.app.ActionBar r4 = r4.getSupportActionBar()
            goto L1d
        L1c:
            r4 = r0
        L1d:
            if (r4 != 0) goto L20
            goto L2a
        L20:
            r5 = 2131953563(0x7f13079b, float:1.95436E38)
            java.lang.String r5 = r3.getString(r5)
            r4.w(r5)
        L2a:
            ee.mtakso.driver.ui.base.mvvm.BaseViewModel r4 = r3.M()
            ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayToBoltViewModel r4 = (ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayToBoltViewModel) r4
            androidx.lifecycle.LiveData r4 = r4.K()
            androidx.lifecycle.LifecycleOwner r5 = r3.getViewLifecycleOwner()
            o3.a r1 = new o3.a
            r1.<init>()
            r4.i(r5, r1)
            ee.mtakso.driver.ui.base.mvvm.BaseViewModel r4 = r3.M()
            ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayToBoltViewModel r4 = (ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayToBoltViewModel) r4
            ee.mtakso.driver.ui.views.webview.WebViewTracker r4 = r4.J()
            java.lang.String r5 = "Pay to Bolt V2"
            r4.c(r5)
            int r4 = ee.mtakso.driver.R.id.earningsPaymentWebView
            android.view.View r5 = r3.S(r4)
            ee.mtakso.driver.ui.views.webview.EarningsPaymentWebView r5 = (ee.mtakso.driver.ui.views.webview.EarningsPaymentWebView) r5
            ee.mtakso.driver.ui.base.mvvm.BaseViewModel r1 = r3.M()
            ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayToBoltViewModel r1 = (ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayToBoltViewModel) r1
            ee.mtakso.driver.ui.views.webview.WebViewTracker r1 = r1.J()
            r5.setWebViewTracker(r1)
            android.view.View r5 = r3.S(r4)
            ee.mtakso.driver.ui.views.webview.EarningsPaymentWebView r5 = (ee.mtakso.driver.ui.views.webview.EarningsPaymentWebView) r5
            ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayToBoltFragment$onViewCreated$2 r1 = new ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayToBoltFragment$onViewCreated$2
            r1.<init>()
            r5.setOnSuccessfulPaymentListener(r1)
            android.view.View r4 = r3.S(r4)
            ee.mtakso.driver.ui.views.webview.EarningsPaymentWebView r4 = (ee.mtakso.driver.ui.views.webview.EarningsPaymentWebView) r4
            ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayToBoltFragment$onViewCreated$3 r5 = new ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayToBoltFragment$onViewCreated$3
            r5.<init>()
            r4.setOnFailedPaymentListener(r5)
            android.os.Bundle r4 = r3.getArguments()
            if (r4 == 0) goto L8d
            java.lang.String r5 = "args.url"
            java.lang.String r4 = r4.getString(r5)
            goto L8e
        L8d:
            r4 = r0
        L8e:
            android.os.Bundle r5 = r3.getArguments()
            if (r5 == 0) goto L9a
            java.lang.String r0 = "raw.args.url"
            java.lang.String r0 = r5.getString(r0)
        L9a:
            r5 = 0
            r1 = 1
            if (r0 == 0) goto La7
            boolean r2 = kotlin.text.StringsKt.y(r0)
            r2 = r2 ^ r1
            if (r2 != r1) goto La7
            r2 = 1
            goto La8
        La7:
            r2 = 0
        La8:
            if (r2 == 0) goto Lb4
            ee.mtakso.driver.ui.base.mvvm.BaseViewModel r4 = r3.M()
            ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayToBoltViewModel r4 = (ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayToBoltViewModel) r4
            r4.F(r0)
            goto Ld4
        Lb4:
            if (r4 == 0) goto Lbe
            boolean r0 = kotlin.text.StringsKt.y(r4)
            r0 = r0 ^ r1
            if (r0 != r1) goto Lbe
            r5 = 1
        Lbe:
            if (r5 == 0) goto Lca
            ee.mtakso.driver.ui.base.mvvm.BaseViewModel r5 = r3.M()
            ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayToBoltViewModel r5 = (ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayToBoltViewModel) r5
            r5.G(r4)
            goto Ld4
        Lca:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "URL is empty"
            r4.<init>(r5)
            r3.H(r4)
        Ld4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayToBoltFragment.onViewCreated(android.view.View, android.os.Bundle):void");
    }
}
