package ee.mtakso.driver.ui.screens.score;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.PopupToolbarAppearance;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.ui.views.webview.PlainWebView;
import ee.mtakso.driver.uicore.components.views.IndeterminateProgressView;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.driver.core.theme.Theme;
import eu.bolt.driver.core.theme.ThemeManager;
import eu.bolt.kalev.Kalev;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverScoreExplanationFragment.kt */
/* loaded from: classes3.dex */
public final class DriverScoreExplanationFragment extends BazeMvvmFragment<DriverScoreExplanationViewModel> {

    /* renamed from: q  reason: collision with root package name */
    public static final Companion f32886q = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final ThemeManager f32887o;

    /* renamed from: p  reason: collision with root package name */
    public Map<Integer, View> f32888p;

    /* compiled from: DriverScoreExplanationFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public DriverScoreExplanationFragment(BaseUiDependencies deps, ThemeManager themeManager) {
        super(deps, R.layout.fragment_driver_score_explanation, null, 4, null);
        Intrinsics.f(deps, "deps");
        Intrinsics.f(themeManager, "themeManager");
        this.f32888p = new LinkedHashMap();
        this.f32887o = themeManager;
    }

    private final Navigator U() {
        FragmentActivity activity = getActivity();
        Intrinsics.d(activity, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.Navigator");
        return (Navigator) activity;
    }

    private final Theme V() {
        Integer num;
        Resources resources;
        Configuration configuration;
        Context context = getContext();
        if (context != null && (resources = context.getResources()) != null && (configuration = resources.getConfiguration()) != null) {
            num = Integer.valueOf(configuration.uiMode & 48);
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 32) {
            return Theme.DARK;
        }
        if (num != null && num.intValue() == 16) {
            return Theme.LIGHT;
        }
        return Theme.LEGACY;
    }

    private final boolean W() {
        if (this.f32887o.a() == Theme.SYSTEM) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z(String str) {
        int i8 = R.id.Qc;
        PlainWebView webView = (PlainWebView) S(i8);
        Intrinsics.e(webView, "webView");
        ViewExtKt.e(webView, true, 0, 2, null);
        try {
            ((PlainWebView) S(i8)).j(str);
            ((PlainWebView) S(i8)).setBackgroundColor(0);
        } catch (Throwable th) {
            Kalev.e(th, "Exception while showing Webview!");
            Toast.makeText(requireContext(), (int) R.string.no_browser_detected, 0).show();
            U().c();
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f32888p.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return 2132017818;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void G() {
        super.G();
        IndeterminateProgressView progressView = (IndeterminateProgressView) S(R.id.r9);
        Intrinsics.e(progressView, "progressView");
        ViewExtKt.e(progressView, false, 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void H(Throwable error) {
        Intrinsics.f(error, "error");
        NotificationDialog.Companion companion = NotificationDialog.f28313n;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        NotificationDialog c8 = NotificationDialog.Companion.c(companion, requireContext, error, null, 4, null);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        FragmentUtils.c(c8, requireActivity, "error");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void I() {
        super.I();
        IndeterminateProgressView progressView = (IndeterminateProgressView) S(R.id.r9);
        Intrinsics.e(progressView, "progressView");
        ViewExtKt.e(progressView, true, 0, 2, null);
    }

    public View S(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f32888p;
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
    /* renamed from: Y */
    public DriverScoreExplanationViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (DriverScoreExplanationViewModel) new ViewModelProvider(this, E.d()).a(DriverScoreExplanationViewModel.class);
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
        Theme a8 = this.f32887o.a();
        DriverScoreExplanationViewModel M = M();
        if (W()) {
            a8 = V();
        }
        M.H(a8);
        M().N();
        U().n(new PopupToolbarAppearance(0, new Text.Resource(R.string.driver_score, null, 2, null), false, 5, null));
        M().L().c("DriverScore");
        int i8 = R.id.Qc;
        ((PlainWebView) S(i8)).setWebViewTracker(M().L());
        PlainWebView webView = (PlainWebView) S(i8);
        Intrinsics.e(webView, "webView");
        ViewExtKt.e(webView, false, 0, 2, null);
        LiveData<String> M2 = M().M();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.score.DriverScoreExplanationFragment$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String htmlContent) {
                DriverScoreExplanationFragment driverScoreExplanationFragment = DriverScoreExplanationFragment.this;
                Intrinsics.e(htmlContent, "htmlContent");
                driverScoreExplanationFragment.Z(htmlContent);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        };
        M2.i(viewLifecycleOwner, new Observer() { // from class: ee.mtakso.driver.ui.screens.score.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DriverScoreExplanationFragment.X(Function1.this, obj);
            }
        });
    }
}
