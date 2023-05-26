package ee.mtakso.driver.ui.screens.work.map;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.work.map.MapExplanationState;
import ee.mtakso.driver.ui.views.webview.PlainWebView;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import eu.bolt.driver.core.ui.base.bottomsheet.SecondaryBottomSheetFragment;
import eu.bolt.driver.core.ui.routing.RoutingCommand;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import eu.bolt.driver.core.ui.routing.state.RoutingState;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: MapExplanationFragment.kt */
/* loaded from: classes5.dex */
public final class MapExplanationFragment extends SecondaryBottomSheetFragment {

    /* renamed from: t  reason: collision with root package name */
    public static final Companion f34120t = new Companion(null);

    /* renamed from: r  reason: collision with root package name */
    private final Lazy f34121r;

    /* renamed from: s  reason: collision with root package name */
    public Map<Integer, View> f34122s;

    /* compiled from: MapExplanationFragment.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RoutingCommand a() {
            List e8;
            e8 = CollectionsKt__CollectionsJVMKt.e(MapExplanationFragment.class);
            return new RoutingCommand.DialogFragmentClass(new RoutingState(SimpleActivity.class, e8), MapExplanationFragment.class, null, null, 12, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public MapExplanationFragment(final BaseUiDependencies deps) {
        super(R.layout.fragment_map_explanation);
        Intrinsics.f(deps, "deps");
        this.f34122s = new LinkedHashMap();
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: ee.mtakso.driver.ui.screens.work.map.MapExplanationFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return BaseUiDependencies.this.d();
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: ee.mtakso.driver.ui.screens.work.map.MapExplanationFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.f34121r = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.b(MapExplanationViewModel.class), new Function0<ViewModelStore>() { // from class: ee.mtakso.driver.ui.screens.work.map.MapExplanationFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
                Intrinsics.e(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, function0);
    }

    private final MapExplanationViewModel Y() {
        return (MapExplanationViewModel) this.f34121r.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // eu.bolt.driver.core.ui.base.bottomsheet.SecondaryBottomSheetFragment, eu.bolt.driver.core.ui.base.bottomsheet.BaseBottomSheetFragment
    public void H() {
        this.f34122s.clear();
    }

    @Override // eu.bolt.driver.core.ui.base.bottomsheet.SecondaryBottomSheetFragment
    public View O(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f34122s;
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

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, 2132017806);
        setCancelable(true);
        U(true);
    }

    @Override // eu.bolt.driver.core.ui.base.bottomsheet.SecondaryBottomSheetFragment, eu.bolt.driver.core.ui.base.bottomsheet.BaseBottomSheetFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H();
    }

    @Override // eu.bolt.driver.core.ui.base.bottomsheet.SecondaryBottomSheetFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        Y().C();
        LiveData<MapExplanationState> G = Y().G();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<MapExplanationState, Unit> function1 = new Function1<MapExplanationState, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.map.MapExplanationFragment$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(MapExplanationState mapExplanationState) {
                if (mapExplanationState instanceof MapExplanationState.Loading) {
                    PlainWebView webView = (PlainWebView) MapExplanationFragment.this.O(R.id.Qc);
                    Intrinsics.e(webView, "webView");
                    ViewExtKt.d(webView, false, 0, 2, null);
                    ((CircularProgressIndicator) MapExplanationFragment.this.O(R.id.r9)).q();
                } else if (mapExplanationState instanceof MapExplanationState.Ready) {
                    MapExplanationFragment mapExplanationFragment = MapExplanationFragment.this;
                    int i8 = R.id.Qc;
                    PlainWebView webView2 = (PlainWebView) mapExplanationFragment.O(i8);
                    Intrinsics.e(webView2, "webView");
                    ViewExtKt.d(webView2, false, 0, 3, null);
                    CircularProgressIndicator progressView = (CircularProgressIndicator) MapExplanationFragment.this.O(R.id.r9);
                    Intrinsics.e(progressView, "progressView");
                    ViewExtKt.d(progressView, false, 0, 2, null);
                    ((PlainWebView) MapExplanationFragment.this.O(i8)).setScrollContainer(false);
                    ((PlainWebView) MapExplanationFragment.this.O(i8)).j(((MapExplanationState.Ready) mapExplanationState).a());
                    ((PlainWebView) MapExplanationFragment.this.O(i8)).setBackgroundColor(0);
                } else if (mapExplanationState instanceof MapExplanationState.Error) {
                    PlainWebView webView3 = (PlainWebView) MapExplanationFragment.this.O(R.id.Qc);
                    Intrinsics.e(webView3, "webView");
                    ViewExtKt.d(webView3, false, 0, 2, null);
                    CircularProgressIndicator progressView2 = (CircularProgressIndicator) MapExplanationFragment.this.O(R.id.r9);
                    Intrinsics.e(progressView2, "progressView");
                    ViewExtKt.d(progressView2, false, 0, 2, null);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MapExplanationState mapExplanationState) {
                b(mapExplanationState);
                return Unit.f50853a;
            }
        };
        G.i(viewLifecycleOwner, new Observer() { // from class: ee.mtakso.driver.ui.screens.work.map.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MapExplanationFragment.Z(Function1.this, obj);
            }
        });
    }
}
