package ee.mtakso.driver.ui.screens.earnings.v2.payout.howto;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.howto.HowToRequestPayoutFragment;
import ee.mtakso.driver.ui.views.webview.PlainWebView;
import ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment;
import ee.mtakso.driver.uicore.components.views.IndeterminateProgressView;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import eu.bolt.driver.core.ui.common.activity.PopupToolbarAppearance;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HowToRequestPayoutFragment.kt */
/* loaded from: classes3.dex */
public final class HowToRequestPayoutFragment extends BazeMvvmFragment<HowToRequestPayoutViewModel> {

    /* renamed from: q  reason: collision with root package name */
    public static final Companion f28720q = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final Function3<DialogFragment, View, Object, Unit> f28721o;

    /* renamed from: p  reason: collision with root package name */
    public Map<Integer, View> f28722p;

    /* compiled from: HowToRequestPayoutFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RoutingCommand a() {
            return SimpleActivity.Companion.b(SimpleActivity.f27004l, HowToRequestPayoutFragment.class, null, false, 0, 14, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public HowToRequestPayoutFragment(BaseUiDependencies deps) {
        super(deps, R.layout.fragment_how_to_request_payout, null, 4, null);
        Intrinsics.f(deps, "deps");
        this.f28722p = new LinkedHashMap();
        this.f28721o = new Function3<DialogFragment, View, Object, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.payout.howto.HowToRequestPayoutFragment$dismissListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            public final void b(DialogFragment dialogFragment, View view, Object obj) {
                Navigator U;
                Intrinsics.f(dialogFragment, "<anonymous parameter 0>");
                if (Intrinsics.a("dismiss", obj)) {
                    U = HowToRequestPayoutFragment.this.U();
                    U.c();
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit l(DialogFragment dialogFragment, View view, Object obj) {
                b(dialogFragment, view, obj);
                return Unit.f50853a;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Navigator U() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.d(requireActivity, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.Navigator");
        return (Navigator) requireActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f28722p.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void G() {
        super.G();
        IndeterminateProgressView loadingView = (IndeterminateProgressView) S(R.id.V6);
        Intrinsics.e(loadingView, "loadingView");
        ViewExtKt.d(loadingView, false, 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void H(Throwable error) {
        Intrinsics.f(error, "error");
        super.H(error);
        NotificationDialog.Companion companion = NotificationDialog.f28313n;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        NotificationDialog a8 = companion.a(requireContext, error, this.f28721o);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        FragmentUtils.c(a8, requireActivity, "TAG_ERROR_DIALOG");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void I() {
        super.I();
        IndeterminateProgressView loadingView = (IndeterminateProgressView) S(R.id.V6);
        Intrinsics.e(loadingView, "loadingView");
        ViewExtKt.d(loadingView, false, 0, 3, null);
    }

    public View S(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f28722p;
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
    /* renamed from: W */
    public HowToRequestPayoutViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (HowToRequestPayoutViewModel) new ViewModelProvider(this, E.d()).a(HowToRequestPayoutViewModel.class);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RestoreableDialogFragment.Companion.b(RestoreableDialogFragment.f34751j, getChildFragmentManager(), "TAG_ERROR_DIALOG", this.f28721o, null, 8, null);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        U().x(new PopupToolbarAppearance(0, new Text.Resource(R.string.requirements, null, 2, null), false, null, null, null, null, null, null, 509, null));
        PlainWebView webView = (PlainWebView) S(R.id.Qc);
        Intrinsics.e(webView, "webView");
        ViewExtKt.d(webView, false, 0, 2, null);
        LiveData<String> G = M().G();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.payout.howto.HowToRequestPayoutFragment$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String str) {
                HowToRequestPayoutFragment howToRequestPayoutFragment = HowToRequestPayoutFragment.this;
                int i8 = R.id.Qc;
                PlainWebView webView2 = (PlainWebView) howToRequestPayoutFragment.S(i8);
                Intrinsics.e(webView2, "webView");
                ViewExtKt.d(webView2, true, 0, 2, null);
                Context requireContext = HowToRequestPayoutFragment.this.requireContext();
                Intrinsics.e(requireContext, "requireContext()");
                int b8 = ContextUtilsKt.b(requireContext, R.attr.contentPrimary);
                int red = Color.red(b8);
                int green = Color.green(b8);
                int blue = Color.blue(b8);
                int alpha = Color.alpha(b8);
                ((PlainWebView) HowToRequestPayoutFragment.this.S(i8)).i("<html><head></head><body style=\"background-color:transparent;color:rgba(" + red + "," + green + "," + blue + "," + alpha + ");\">" + str + "</body></html>");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        };
        G.i(viewLifecycleOwner, new Observer() { // from class: q3.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HowToRequestPayoutFragment.V(Function1.this, obj);
            }
        });
    }
}
