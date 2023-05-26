package ee.mtakso.driver.ui.screens.waybill;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.OrderHandleKt;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.helper.LoadingDialogDelegate;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.waybill.WaybillFragment;
import ee.mtakso.driver.ui.screens.waybill.WaybillState;
import ee.mtakso.driver.ui.views.webview.PlainWebView;
import ee.mtakso.driver.ui.views.webview.WebViewTracker;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.driver.core.ui.common.activity.PopupToolbarAppearance;
import eu.bolt.driver.core.ui.routing.RoutingCommand;
import eu.bolt.kalev.Kalev;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WaybillFragment.kt */
/* loaded from: classes5.dex */
public final class WaybillFragment extends BazeMvvmFragment<WaybillViewModel> {

    /* renamed from: r  reason: collision with root package name */
    public static final Companion f33614r = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final WebViewTracker f33615o;

    /* renamed from: p  reason: collision with root package name */
    private final Lazy f33616p;

    /* renamed from: q  reason: collision with root package name */
    public Map<Integer, View> f33617q;

    /* compiled from: WaybillFragment.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RoutingCommand.ActivityClass a(OrderHandle orderHandle) {
            Intrinsics.f(orderHandle, "orderHandle");
            return SimpleActivity.Companion.f(SimpleActivity.f27004l, WaybillFragment.class, OrderHandleKt.d(orderHandle), true, 0, 8, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public WaybillFragment(WebViewTracker webViewTracker, BaseUiDependencies deps) {
        super(deps, R.layout.fragment_waybill, null, 4, null);
        Lazy b8;
        Intrinsics.f(webViewTracker, "webViewTracker");
        Intrinsics.f(deps, "deps");
        this.f33617q = new LinkedHashMap();
        this.f33615o = webViewTracker;
        b8 = LazyKt__LazyJVMKt.b(new Function0<Navigator>() { // from class: ee.mtakso.driver.ui.screens.waybill.WaybillFragment$navigator$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Navigator invoke() {
                FragmentActivity activity = WaybillFragment.this.getActivity();
                if (activity instanceof Navigator) {
                    return (Navigator) activity;
                }
                return null;
            }
        });
        this.f33616p = b8;
    }

    private final LoadingDialogDelegate T() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        return new LoadingDialogDelegate(requireActivity);
    }

    private final Navigator U() {
        return (Navigator) this.f33616p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(WaybillFragment this$0, WaybillState waybillState) {
        Intrinsics.f(this$0, "this$0");
        this$0.X(waybillState.a());
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f33617q.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void G() {
        T().a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void I() {
        T().b();
    }

    public View S(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f33617q;
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
    public WaybillViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (WaybillViewModel) new ViewModelProvider(this, E.d()).a(WaybillViewModel.class);
    }

    public final void X(String html) {
        Intrinsics.f(html, "html");
        try {
            ((PlainWebView) S(R.id.waybillView)).j(html);
        } catch (Throwable th) {
            Kalev.e(th, "Exception while loading the base64 encoded text to waybill!");
            try {
                ((PlainWebView) S(R.id.waybillView)).i(html);
            } catch (Throwable th2) {
                Kalev.e(th2, "Exception while showing Webview!");
                Toast.makeText(requireContext(), (int) R.string.no_browser_detected, 0).show();
            }
        }
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
        M().J().i(getViewLifecycleOwner(), new Observer() { // from class: j5.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WaybillFragment.V(WaybillFragment.this, (WaybillState) obj);
            }
        });
        Bundle requireArguments = requireArguments();
        Intrinsics.e(requireArguments, "requireArguments()");
        M().G(OrderHandleKt.a(requireArguments));
        this.f33615o.c("Waybill");
        ((PlainWebView) S(R.id.waybillView)).setWebViewTracker(this.f33615o);
        Navigator U = U();
        if (U != null) {
            U.x(new PopupToolbarAppearance(0, new Text.Resource(R.string.waybill, null, 2, null), false, null, null, null, null, null, null, 509, null));
        }
    }
}
