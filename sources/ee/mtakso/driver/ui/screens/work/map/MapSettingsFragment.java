package ee.mtakso.driver.ui.screens.work.map;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.material.chip.Chip;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.interactor.map.MapSettingsCategory;
import ee.mtakso.driver.ui.screens.work.map.MapSettingsFragment;
import ee.mtakso.driver.ui.screens.work.map.MapSettingsState;
import ee.mtakso.driver.ui.views.DynamicViewHelper;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import eu.bolt.driver.core.ui.base.bottomsheet.SecondaryBottomSheetFragment;
import eu.bolt.driver.core.ui.routing.RoutingCommand;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import eu.bolt.driver.core.ui.routing.state.RoutingState;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: MapSettingsFragment.kt */
/* loaded from: classes5.dex */
public final class MapSettingsFragment extends SecondaryBottomSheetFragment {

    /* renamed from: w  reason: collision with root package name */
    public static final Companion f34136w = new Companion(null);

    /* renamed from: r  reason: collision with root package name */
    private final RoutingManager f34137r;

    /* renamed from: s  reason: collision with root package name */
    private final Lazy f34138s;

    /* renamed from: t  reason: collision with root package name */
    private DynamicViewHelper<HeatmapViewHolder> f34139t;

    /* renamed from: u  reason: collision with root package name */
    private DynamicViewHelper<CategoryViewHolder> f34140u;

    /* renamed from: v  reason: collision with root package name */
    public Map<Integer, View> f34141v;

    /* compiled from: MapSettingsFragment.kt */
    /* loaded from: classes5.dex */
    public static final class CategoryViewHolder implements DynamicViewHelper.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        private final View f34144a;

        /* renamed from: b  reason: collision with root package name */
        private final Chip f34145b;

        /* renamed from: c  reason: collision with root package name */
        public Map<Integer, View> f34146c;

        public CategoryViewHolder(View containerView) {
            Intrinsics.f(containerView, "containerView");
            this.f34146c = new LinkedHashMap();
            this.f34144a = containerView;
            View a8 = a();
            Intrinsics.d(a8, "null cannot be cast to non-null type com.google.android.material.chip.Chip");
            this.f34145b = (Chip) a8;
        }

        @Override // ee.mtakso.driver.ui.views.DynamicViewHelper.ViewHolder
        public View a() {
            return this.f34144a;
        }

        public final Chip b() {
            return this.f34145b;
        }
    }

    /* compiled from: MapSettingsFragment.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RoutingCommand a() {
            List e8;
            e8 = CollectionsKt__CollectionsJVMKt.e(MapSettingsFragment.class);
            return new RoutingCommand.DialogFragmentClass(new RoutingState(FragmentActivity.class, e8), MapSettingsFragment.class, null, null, 12, null);
        }
    }

    /* compiled from: MapSettingsFragment.kt */
    /* loaded from: classes5.dex */
    public static final class HeatmapViewHolder implements DynamicViewHelper.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        private final View f34147a;

        /* renamed from: b  reason: collision with root package name */
        private final ImageView f34148b;

        /* renamed from: c  reason: collision with root package name */
        private final ImageView f34149c;

        /* renamed from: d  reason: collision with root package name */
        private final ImageView f34150d;

        /* renamed from: e  reason: collision with root package name */
        private final TextView f34151e;

        /* renamed from: f  reason: collision with root package name */
        public Map<Integer, View> f34152f;

        public HeatmapViewHolder(View containerView) {
            Intrinsics.f(containerView, "containerView");
            this.f34152f = new LinkedHashMap();
            this.f34147a = containerView;
            ImageView imageView = (ImageView) a().findViewById(R.id.heatmapTypeBackground);
            Intrinsics.d(imageView, "null cannot be cast to non-null type android.widget.ImageView");
            this.f34148b = imageView;
            ImageView imageView2 = (ImageView) a().findViewById(R.id.heatmapTypePreview);
            Intrinsics.d(imageView2, "null cannot be cast to non-null type android.widget.ImageView");
            this.f34149c = imageView2;
            ImageView imageView3 = (ImageView) a().findViewById(R.id.heatmapTypeIcon);
            Intrinsics.d(imageView3, "null cannot be cast to non-null type android.widget.ImageView");
            this.f34150d = imageView3;
            TextView textView = (TextView) a().findViewById(R.id.heatmapTypeTitle);
            Intrinsics.d(textView, "null cannot be cast to non-null type android.widget.TextView");
            this.f34151e = textView;
        }

        @Override // ee.mtakso.driver.ui.views.DynamicViewHelper.ViewHolder
        public View a() {
            return this.f34147a;
        }

        public final ImageView b() {
            return this.f34148b;
        }

        public final ImageView c() {
            return this.f34149c;
        }

        public final TextView d() {
            return this.f34151e;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public MapSettingsFragment(final BaseUiDependencies deps, RoutingManager routingManager) {
        super(R.layout.fragment_map_settings);
        Intrinsics.f(deps, "deps");
        Intrinsics.f(routingManager, "routingManager");
        this.f34141v = new LinkedHashMap();
        this.f34137r = routingManager;
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: ee.mtakso.driver.ui.screens.work.map.MapSettingsFragment$viewModel$2
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
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: ee.mtakso.driver.ui.screens.work.map.MapSettingsFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.f34138s = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.b(MapSettingsViewModel.class), new Function0<ViewModelStore>() { // from class: ee.mtakso.driver.ui.screens.work.map.MapSettingsFragment$special$$inlined$viewModels$default$2
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

    /* JADX INFO: Access modifiers changed from: private */
    public final MapSettingsViewModel b0() {
        return (MapSettingsViewModel) this.f34138s.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0(MapSettingsState mapSettingsState) {
        boolean z7;
        if (mapSettingsState instanceof MapSettingsState.Loading) {
            View mapSettingsLoading = O(R.id.mapSettingsLoading);
            Intrinsics.e(mapSettingsLoading, "mapSettingsLoading");
            ViewExtKt.d(mapSettingsLoading, false, 0, 3, null);
            View mapSettingsContent = O(R.id.mapSettingsContent);
            Intrinsics.e(mapSettingsContent, "mapSettingsContent");
            ViewExtKt.d(mapSettingsContent, false, 0, 2, null);
        } else if (!(mapSettingsState instanceof MapSettingsState.Ready)) {
            View mapSettingsLoading2 = O(R.id.mapSettingsLoading);
            Intrinsics.e(mapSettingsLoading2, "mapSettingsLoading");
            ViewExtKt.d(mapSettingsLoading2, false, 0, 2, null);
            View mapSettingsContent2 = O(R.id.mapSettingsContent);
            Intrinsics.e(mapSettingsContent2, "mapSettingsContent");
            ViewExtKt.d(mapSettingsContent2, false, 0, 3, null);
        } else {
            View mapSettingsLoading3 = O(R.id.mapSettingsLoading);
            Intrinsics.e(mapSettingsLoading3, "mapSettingsLoading");
            ViewExtKt.d(mapSettingsLoading3, false, 0, 2, null);
            View mapSettingsContent3 = O(R.id.mapSettingsContent);
            Intrinsics.e(mapSettingsContent3, "mapSettingsContent");
            ViewExtKt.d(mapSettingsContent3, false, 0, 3, null);
            MapSettingsState.Ready ready = (MapSettingsState.Ready) mapSettingsState;
            boolean z8 = true;
            boolean z9 = !ready.c().isEmpty();
            Flow heatmapSelectionFlow = (Flow) O(R.id.heatmapSelectionFlow);
            Intrinsics.e(heatmapSelectionFlow, "heatmapSelectionFlow");
            ViewExtKt.d(heatmapSelectionFlow, z9, 0, 2, null);
            DynamicViewHelper<HeatmapViewHolder> dynamicViewHelper = this.f34139t;
            if (dynamicViewHelper != null) {
                dynamicViewHelper.a(ready.c().size(), new MapSettingsFragment$renderState$1(mapSettingsState, this));
            }
            ((TextView) O(R.id.heatmapDescription)).setText(ready.b());
            List<MapSettingsCategory> a8 = ready.a();
            boolean z10 = !a8.isEmpty();
            ImageView heatmapBackgroundBottom = (ImageView) O(R.id.heatmapBackgroundBottom);
            Intrinsics.e(heatmapBackgroundBottom, "heatmapBackgroundBottom");
            if (z9 && !z10) {
                z7 = true;
            } else {
                z7 = false;
            }
            ViewExtKt.d(heatmapBackgroundBottom, z7, 0, 2, null);
            ImageView heatmapRoundedBackgroundBottom = (ImageView) O(R.id.heatmapRoundedBackgroundBottom);
            Intrinsics.e(heatmapRoundedBackgroundBottom, "heatmapRoundedBackgroundBottom");
            ViewExtKt.d(heatmapRoundedBackgroundBottom, (z9 && z10) ? false : false, 0, 2, null);
            Group heatmapChipsFlowGroup = (Group) O(R.id.heatmapChipsFlowGroup);
            Intrinsics.e(heatmapChipsFlowGroup, "heatmapChipsFlowGroup");
            ViewExtKt.d(heatmapChipsFlowGroup, z10, 0, 2, null);
            DynamicViewHelper<CategoryViewHolder> dynamicViewHelper2 = this.f34140u;
            if (dynamicViewHelper2 != null) {
                dynamicViewHelper2.a(a8.size(), new MapSettingsFragment$renderState$2(a8, this));
            }
            ((ImageButton) O(R.id.heatmapTitleInfo)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.work.map.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MapSettingsFragment.e0(MapSettingsFragment.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(MapSettingsFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.b0().T();
        this$0.f34137r.c(MapExplanationFragment.f34120t.a());
    }

    @Override // eu.bolt.driver.core.ui.base.bottomsheet.SecondaryBottomSheetFragment, eu.bolt.driver.core.ui.base.bottomsheet.BaseBottomSheetFragment
    public void H() {
        this.f34141v.clear();
    }

    @Override // eu.bolt.driver.core.ui.base.bottomsheet.SecondaryBottomSheetFragment
    public View O(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f34141v;
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
    public void onDestroyView() {
        super.onDestroyView();
        this.f34139t = null;
        H();
    }

    @Override // eu.bolt.driver.core.ui.base.bottomsheet.SecondaryBottomSheetFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        List q8;
        List q9;
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        int i8 = R.id.mapSettingsContent;
        View O = O(i8);
        Intrinsics.d(O, "null cannot be cast to non-null type android.view.ViewGroup");
        View heatmapType1 = O(R.id.heatmapType1);
        Intrinsics.e(heatmapType1, "heatmapType1");
        View heatmapType2 = O(R.id.heatmapType2);
        Intrinsics.e(heatmapType2, "heatmapType2");
        View heatmapType3 = O(R.id.heatmapType3);
        Intrinsics.e(heatmapType3, "heatmapType3");
        q8 = CollectionsKt__CollectionsKt.q(new HeatmapViewHolder(heatmapType1), new HeatmapViewHolder(heatmapType2), new HeatmapViewHolder(heatmapType3));
        this.f34139t = new DynamicViewHelper<>((ViewGroup) O, q8, (Flow) O(R.id.heatmapSelectionFlow), new Function2<LayoutInflater, ViewGroup, HeatmapViewHolder>() { // from class: ee.mtakso.driver.ui.screens.work.map.MapSettingsFragment$onViewCreated$1
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: b */
            public final MapSettingsFragment.HeatmapViewHolder s(LayoutInflater inflater, ViewGroup parent) {
                Intrinsics.f(inflater, "inflater");
                Intrinsics.f(parent, "parent");
                View inflate = inflater.inflate(R.layout.content_map_settings_heatmap_type, parent, false);
                Intrinsics.e(inflate, "inflater.inflate(R.layou…tmap_type, parent, false)");
                return new MapSettingsFragment.HeatmapViewHolder(inflate);
            }
        });
        View O2 = O(i8);
        Intrinsics.d(O2, "null cannot be cast to non-null type android.view.ViewGroup");
        View heatmapChip1 = O(R.id.heatmapChip1);
        Intrinsics.e(heatmapChip1, "heatmapChip1");
        View heatmapChip2 = O(R.id.heatmapChip2);
        Intrinsics.e(heatmapChip2, "heatmapChip2");
        View heatmapChip3 = O(R.id.heatmapChip3);
        Intrinsics.e(heatmapChip3, "heatmapChip3");
        q9 = CollectionsKt__CollectionsKt.q(new CategoryViewHolder(heatmapChip1), new CategoryViewHolder(heatmapChip2), new CategoryViewHolder(heatmapChip3));
        this.f34140u = new DynamicViewHelper<>((ViewGroup) O2, q9, (Flow) O(R.id.heatmapChipsFlow), new Function2<LayoutInflater, ViewGroup, CategoryViewHolder>() { // from class: ee.mtakso.driver.ui.screens.work.map.MapSettingsFragment$onViewCreated$2
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: b */
            public final MapSettingsFragment.CategoryViewHolder s(LayoutInflater inflater, ViewGroup parent) {
                Intrinsics.f(inflater, "inflater");
                Intrinsics.f(parent, "parent");
                View inflate = inflater.inflate(R.layout.content_category_heatmap_item, parent, false);
                Intrinsics.e(inflate, "inflater.inflate(R.layou…tmap_item, parent, false)");
                return new MapSettingsFragment.CategoryViewHolder(inflate);
            }
        });
        b0().C();
        LiveData<MapSettingsState> K = b0().K();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<MapSettingsState, Unit> function1 = new Function1<MapSettingsState, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.map.MapSettingsFragment$onViewCreated$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(MapSettingsState state) {
                MapSettingsFragment mapSettingsFragment = MapSettingsFragment.this;
                Intrinsics.e(state, "state");
                mapSettingsFragment.d0(state);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MapSettingsState mapSettingsState) {
                b(mapSettingsState);
                return Unit.f50853a;
            }
        };
        K.i(viewLifecycleOwner, new Observer() { // from class: ee.mtakso.driver.ui.screens.work.map.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MapSettingsFragment.c0(Function1.this, obj);
            }
        });
    }
}
