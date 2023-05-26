package ee.mtakso.driver.ui.screens.vehicle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.vehicle.Application;
import ee.mtakso.driver.network.client.vehicle.Car;
import ee.mtakso.driver.network.client.vehicle.VehiclesAndApplications;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.ui.screens.vehicle.list.ActiveVehicleDelegate;
import ee.mtakso.driver.ui.screens.vehicle.list.InsuredVehicleDelegate;
import ee.mtakso.driver.ui.screens.vehicle.list.VehicleApplicationDelegate;
import ee.mtakso.driver.ui.utils.ClipboardUtil;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDepthDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.ItemHeaderDelegate;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import eu.bolt.driver.core.ui.common.activity.PopupToolbarAppearance;
import eu.bolt.driver.core.ui.routing.state.Screen;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VehicleListFragment.kt */
/* loaded from: classes5.dex */
public final class VehicleListFragment extends BazeMvvmFragment<VehicleListViewModel> implements Screen {

    /* renamed from: o  reason: collision with root package name */
    private final Lazy f33507o;

    /* renamed from: p  reason: collision with root package name */
    private int f33508p;

    /* renamed from: q  reason: collision with root package name */
    private final DiffAdapter f33509q;

    /* renamed from: r  reason: collision with root package name */
    public Map<Integer, View> f33510r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public VehicleListFragment(BaseUiDependencies deps) {
        super(deps, R.layout.fragment_vehicle_list, null, 4, null);
        Lazy b8;
        Intrinsics.f(deps, "deps");
        this.f33510r = new LinkedHashMap();
        b8 = LazyKt__LazyJVMKt.b(new Function0<ClipboardUtil>() { // from class: ee.mtakso.driver.ui.screens.vehicle.VehicleListFragment$clipboardUtil$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final ClipboardUtil invoke() {
                ClipboardUtil.Companion companion = ClipboardUtil.f34300b;
                Context requireContext = VehicleListFragment.this.requireContext();
                Intrinsics.e(requireContext, "requireContext()");
                return companion.a(requireContext);
            }
        });
        this.f33507o = b8;
        this.f33508p = 2132017818;
        this.f33509q = new DiffAdapter().P(new ItemHeaderDelegate()).P(new VehicleApplicationDelegate(new Function1<Long, Unit>() { // from class: ee.mtakso.driver.ui.screens.vehicle.VehicleListFragment$diffAdapter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(long j8) {
                VehicleListViewModel M;
                M = VehicleListFragment.this.M();
                FragmentActivity activity = VehicleListFragment.this.getActivity();
                Intrinsics.d(activity, "null cannot be cast to non-null type android.content.Context");
                M.Y(j8, activity);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l8) {
                b(l8.longValue());
                return Unit.f50853a;
            }
        })).P(new ActiveVehicleDelegate(new Function1<Long, Unit>() { // from class: ee.mtakso.driver.ui.screens.vehicle.VehicleListFragment$diffAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(long j8) {
                VehicleListViewModel M;
                M = VehicleListFragment.this.M();
                if (!M.e0(j8)) {
                    VehicleListFragment.this.Z(R.string.car_change_error);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l8) {
                b(l8.longValue());
                return Unit.f50853a;
            }
        })).P(new InsuredVehicleDelegate(new Function1<Long, Unit>() { // from class: ee.mtakso.driver.ui.screens.vehicle.VehicleListFragment$diffAdapter$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(long j8) {
                VehicleListViewModel M;
                M = VehicleListFragment.this.M();
                if (!M.e0(j8)) {
                    VehicleListFragment.this.Z(R.string.car_change_error);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l8) {
                b(l8.longValue());
                return Unit.f50853a;
            }
        }, new Function1<Long, Unit>() { // from class: ee.mtakso.driver.ui.screens.vehicle.VehicleListFragment$diffAdapter$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(long j8) {
                ClipboardUtil a02;
                VehicleListViewModel M;
                a02 = VehicleListFragment.this.a0();
                M = VehicleListFragment.this.M();
                a02.a(M.U(j8).d());
                VehicleListFragment.this.Z(R.string.car_insurance_key_message);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l8) {
                b(l8.longValue());
                return Unit.f50853a;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"WrongConstant"})
    public final void Z(int i8) {
        Snackbar.u0(requireView(), i8, 0).e0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClipboardUtil a0() {
        return (ClipboardUtil) this.f33507o.getValue();
    }

    private final Navigator b0() {
        FragmentActivity activity = getActivity();
        Intrinsics.d(activity, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.Navigator");
        return (Navigator) activity;
    }

    private final List<ListModel> c0(VehiclesAndApplications vehiclesAndApplications) {
        List v02;
        List v03;
        boolean z7;
        int v7;
        int v8;
        ArrayList arrayList;
        ArrayList arrayList2;
        List list;
        boolean z8;
        boolean z9;
        DividerModel model;
        boolean z10;
        boolean z11;
        boolean z12;
        final long S = M().S();
        boolean W = M().W();
        v02 = CollectionsKt___CollectionsKt.v0(vehiclesAndApplications.b(), new Comparator() { // from class: ee.mtakso.driver.ui.screens.vehicle.VehicleListFragment$mapVehiclesAndApplications$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t7, T t8) {
                int a8;
                a8 = ComparisonsKt__ComparisonsKt.a(((Car) t7).c(), ((Car) t8).c());
                return a8;
            }
        });
        v03 = CollectionsKt___CollectionsKt.v0(v02, new Comparator() { // from class: ee.mtakso.driver.ui.screens.vehicle.VehicleListFragment$mapVehiclesAndApplications$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t7, T t8) {
                boolean z13;
                int a8;
                boolean z14 = true;
                if (((Car) t8).a() == S) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                Boolean valueOf = Boolean.valueOf(z13);
                if (((Car) t7).a() != S) {
                    z14 = false;
                }
                a8 = ComparisonsKt__ComparisonsKt.a(valueOf, Boolean.valueOf(z14));
                return a8;
            }
        });
        List<Application> a8 = vehiclesAndApplications.a();
        if ((!v03.isEmpty()) && (!a8.isEmpty())) {
            z7 = true;
        } else {
            z7 = false;
        }
        ArrayList arrayList3 = new ArrayList();
        if (z7) {
            arrayList3.add(new ItemHeaderDelegate.Model("header_applications", getString(R.string.car_applications_header), null, null, null, null, 60, null));
        }
        v7 = CollectionsKt__IterablesKt.v(a8, 10);
        ArrayList arrayList4 = new ArrayList(v7);
        int i8 = 0;
        for (Object obj : a8) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            Application application = (Application) obj;
            String valueOf = String.valueOf(application.a());
            long a9 = application.a();
            String d8 = application.d();
            String c8 = application.c();
            int b8 = CarApplicationStateExtKt.b(application.b());
            Color c9 = CarApplicationStateExtKt.c(application.b());
            Color a10 = CarApplicationStateExtKt.a(application.b());
            if (i8 != a8.size() - 1) {
                z12 = true;
            } else {
                z12 = false;
            }
            arrayList4.add(new VehicleApplicationDelegate.Model(valueOf, a9, d8, c8, b8, c9, a10, z12, false, false, null, null, 0.0f, 7936, null));
            i8 = i9;
        }
        arrayList3.addAll(arrayList4);
        if (z7) {
            arrayList3.add(new ItemHeaderDelegate.Model("header_cars", getString(R.string.vehicles_header), null, null, null, null, 60, null));
        }
        v8 = CollectionsKt__IterablesKt.v(v03, 10);
        ArrayList arrayList5 = new ArrayList(v8);
        int i10 = 0;
        for (Object obj2 : v03) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            Car car = (Car) obj2;
            if (car.d() == null) {
                String valueOf2 = String.valueOf(car.a());
                long a11 = car.a();
                String c10 = car.c();
                String b9 = car.b();
                if (car.a() == S) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (i10 != v03.size() - 1) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                arrayList = arrayList5;
                arrayList2 = arrayList3;
                list = v03;
                model = new ActiveVehicleDelegate.Model(valueOf2, a11, c10, b9, z10, W, z11, false, false, null, null, 0.0f, 3968, null);
            } else {
                arrayList = arrayList5;
                arrayList2 = arrayList3;
                list = v03;
                String valueOf3 = String.valueOf(car.a());
                long a12 = car.a();
                String c11 = car.c();
                String b10 = car.b();
                if (car.a() == S) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (i10 != list.size() - 1) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                model = new InsuredVehicleDelegate.Model(valueOf3, a12, c11, b10, z8, W, z9, false, false, null, null, 0.0f, 3968, null);
            }
            ArrayList arrayList6 = arrayList;
            arrayList6.add(model);
            arrayList5 = arrayList6;
            i10 = i11;
            v03 = list;
            arrayList3 = arrayList2;
        }
        ArrayList arrayList7 = arrayList3;
        arrayList7.addAll(arrayList5);
        return arrayList7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(VehicleListFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        Intrinsics.d(activity, "null cannot be cast to non-null type android.content.Context");
        this$0.M().O(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(VehicleListFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        Intrinsics.d(activity, "null cannot be cast to non-null type android.content.Context");
        this$0.M().O(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(VehicleListFragment this$0, Unit unit) {
        Intrinsics.f(this$0, "this$0");
        this$0.b0().c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(VehicleListFragment this$0, VehiclesAndApplications it) {
        Intrinsics.f(this$0, "this$0");
        if (it.b().isEmpty() && it.a().isEmpty()) {
            RecyclerView recyclerView = (RecyclerView) this$0.V(R.id.H9);
            Intrinsics.e(recyclerView, "recyclerView");
            ViewExtKt.e(recyclerView, false, 0, 2, null);
            ConstraintLayout noVehiclesView = (ConstraintLayout) this$0.V(R.id.noVehiclesView);
            Intrinsics.e(noVehiclesView, "noVehiclesView");
            ViewExtKt.e(noVehiclesView, true, 0, 2, null);
            ((ExtendedFloatingActionButton) this$0.V(R.id.fabAddCar)).y();
            return;
        }
        DiffAdapter diffAdapter = this$0.f33509q;
        Intrinsics.e(it, "it");
        DiffAdapter.V(diffAdapter, this$0.c0(it), null, 2, null);
        ((ExtendedFloatingActionButton) this$0.V(R.id.fabAddCar)).E();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f33510r.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return Integer.valueOf(this.f33508p);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void H(Throwable error) {
        Intrinsics.f(error, "error");
        super.H(error);
        NotificationDialog.Companion companion = NotificationDialog.f28313n;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        FragmentUtils.b(NotificationDialog.Companion.c(companion, requireContext, error, null, 4, null), this, "error");
    }

    public View V(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f33510r;
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
    /* renamed from: h0 */
    public VehicleListViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (VehicleListViewModel) new ViewModelProvider(this, E.d()).a(VehicleListViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        M().b0();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        b0().x(new PopupToolbarAppearance(0, new Text.Resource(R.string.title_vehicles, null, 2, null), false, null, null, null, null, null, null, 509, null));
        int i8 = R.id.H9;
        ((RecyclerView) V(i8)).setLayoutManager(new LinearLayoutManager(requireContext()));
        ((RecyclerView) V(i8)).setAdapter(this.f33509q);
        ((RecyclerView) V(i8)).h(new ListItemDepthDecoration(Dimens.d(24)));
        ((RecyclerView) V(i8)).h(new ListItemDividerDecoration(Dimens.c(24.0f)));
        ((RecyclerView) V(i8)).l(new RecyclerView.OnScrollListener() { // from class: ee.mtakso.driver.ui.screens.vehicle.VehicleListFragment$onViewCreated$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void b(RecyclerView recyclerView, int i9, int i10) {
                LinearLayoutManager linearLayoutManager;
                Intrinsics.f(recyclerView, "recyclerView");
                super.b(recyclerView, i9, i10);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager) {
                    linearLayoutManager = (LinearLayoutManager) layoutManager;
                } else {
                    linearLayoutManager = null;
                }
                if (linearLayoutManager == null) {
                    return;
                }
                if (linearLayoutManager.g2() == 0) {
                    ((ExtendedFloatingActionButton) VehicleListFragment.this.V(R.id.fabAddCar)).w();
                } else {
                    ((ExtendedFloatingActionButton) VehicleListFragment.this.V(R.id.fabAddCar)).F();
                }
            }
        });
        ((ExtendedFloatingActionButton) V(R.id.fabAddCar)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.vehicle.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VehicleListFragment.d0(VehicleListFragment.this, view2);
            }
        });
        ((RoundButton) V(R.id.btnAddCar)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.vehicle.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VehicleListFragment.e0(VehicleListFragment.this, view2);
            }
        });
        M().R().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.vehicle.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VehicleListFragment.f0(VehicleListFragment.this, (Unit) obj);
            }
        });
        M().V().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.vehicle.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VehicleListFragment.g0(VehicleListFragment.this, (VehiclesAndApplications) obj);
            }
        });
    }
}
