package ee.mtakso.driver.ui.screens.earnings.v3.payout;

import android.content.Context;
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
import ee.mtakso.driver.ui.screens.earnings.v3.payout.RequestWebUrlFragment;
import ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment;
import ee.mtakso.driver.uicore.components.views.IndeterminateProgressView;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import ee.mtakso.driver.utils.ChromeCustomTabsUrlLauncher;
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

/* compiled from: RequestWebUrlFragment.kt */
/* loaded from: classes3.dex */
public final class RequestWebUrlFragment extends BazeMvvmFragment<RequestWebUrlViewModel> {

    /* renamed from: r  reason: collision with root package name */
    public static final Companion f29410r = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final ChromeCustomTabsUrlLauncher f29411o;

    /* renamed from: p  reason: collision with root package name */
    private final Function3<DialogFragment, View, Object, Unit> f29412p;

    /* renamed from: q  reason: collision with root package name */
    public Map<Integer, View> f29413q;

    /* compiled from: RequestWebUrlFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RoutingCommand a(String requestUrl) {
            Intrinsics.f(requestUrl, "requestUrl");
            SimpleActivity.Companion companion = SimpleActivity.f27004l;
            Bundle bundle = new Bundle();
            bundle.putString("ARG_REQUEST_URL", requestUrl);
            Unit unit = Unit.f50853a;
            return SimpleActivity.Companion.b(companion, RequestWebUrlFragment.class, bundle, false, 0, 12, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public RequestWebUrlFragment(BaseUiDependencies deps, ChromeCustomTabsUrlLauncher urlLauncher) {
        super(deps, R.layout.fragment_request_web_url, null, 4, null);
        Intrinsics.f(deps, "deps");
        Intrinsics.f(urlLauncher, "urlLauncher");
        this.f29413q = new LinkedHashMap();
        this.f29411o = urlLauncher;
        this.f29412p = new Function3<DialogFragment, View, Object, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.payout.RequestWebUrlFragment$errorDialogListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            public final void b(DialogFragment dialogFragment, View view, Object obj) {
                Navigator V;
                Intrinsics.f(dialogFragment, "<anonymous parameter 0>");
                if (Intrinsics.a("dismiss", obj)) {
                    V = RequestWebUrlFragment.this.V();
                    V.c();
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
    public final Navigator V() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.d(requireActivity, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.Navigator");
        return (Navigator) requireActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f29413q.clear();
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
        FragmentUtils.b(companion.a(requireContext, error, this.f29412p), this, "error");
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
        Map<Integer, View> map = this.f29413q;
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
    /* renamed from: X */
    public RequestWebUrlViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (RequestWebUrlViewModel) new ViewModelProvider(this, E.d()).a(RequestWebUrlViewModel.class);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RestoreableDialogFragment.Companion.b(RestoreableDialogFragment.f34751j, getChildFragmentManager(), "error", this.f29412p, null, 8, null);
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
        V().x(new PopupToolbarAppearance(0, new Text.Value(""), false, null, null, null, null, null, null, 509, null));
        if (bundle == null) {
            String string = requireArguments().getString("ARG_REQUEST_URL");
            if (string != null) {
                Intrinsics.e(string, "requireNotNull(requireAr…tString(ARG_REQUEST_URL))");
                M().G(string);
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        LiveData<String> J = M().J();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.payout.RequestWebUrlFragment$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String url) {
                Navigator V;
                ChromeCustomTabsUrlLauncher chromeCustomTabsUrlLauncher;
                V = RequestWebUrlFragment.this.V();
                V.c();
                chromeCustomTabsUrlLauncher = RequestWebUrlFragment.this.f29411o;
                Intrinsics.e(url, "url");
                chromeCustomTabsUrlLauncher.a(url);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        };
        J.i(viewLifecycleOwner, new Observer() { // from class: t3.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RequestWebUrlFragment.W(Function1.this, obj);
            }
        });
    }
}
