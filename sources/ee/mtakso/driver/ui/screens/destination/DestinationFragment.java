package ee.mtakso.driver.ui.screens.destination;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.settings.DriverDestination;
import ee.mtakso.driver.network.response.DestinationValidationError;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.geo.state.GeoLocationIssue;
import ee.mtakso.driver.service.modules.driverdestinations.DestinationLimit;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.destination.DestinationFragment;
import ee.mtakso.driver.ui.screens.destination.edit.DestinationEditBottomDialogFragment;
import ee.mtakso.driver.ui.screens.destination.search.DriverDestinationSearchFragment;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.ui.screens.home.v2.subpage.destination.DestinationsViewModel;
import ee.mtakso.driver.ui.screens.home.v2.subpage.destination.about.AboutDriverDestinationsFragment;
import ee.mtakso.driver.ui.screens.work.LocationRequiredDialogDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.DividerDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.utils.ext.ApiExceptionUtils;
import ee.mtakso.driver.utils.ext.FragmentFactoryUtils;
import eu.bolt.driver.core.ui.common.activity.PopupToolbarAppearance;
import eu.bolt.driver.core.ui.common.snackbar.SnackBarDelegate;
import eu.bolt.driver.core.ui.common.snackbar.SnackBarModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DestinationFragment.kt */
/* loaded from: classes3.dex */
public final class DestinationFragment extends BazeMvvmFragment<DestinationsViewModel> {

    /* renamed from: w  reason: collision with root package name */
    public static final Companion f28147w = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final GeoLocationManager f28148o;

    /* renamed from: p  reason: collision with root package name */
    private final DestinationMapper f28149p;

    /* renamed from: q  reason: collision with root package name */
    private final FragmentFactory f28150q;

    /* renamed from: r  reason: collision with root package name */
    private final LocationRequiredDialogDelegate f28151r;

    /* renamed from: s  reason: collision with root package name */
    private final DiffAdapter f28152s;

    /* renamed from: t  reason: collision with root package name */
    private SnackBarDelegate f28153t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f28154u;

    /* renamed from: v  reason: collision with root package name */
    public Map<Integer, View> f28155v;

    /* compiled from: DestinationFragment.kt */
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
    public DestinationFragment(BaseUiDependencies deps, GeoLocationManager locationManager, DestinationMapper destinationMapper, FragmentFactory fragmentFactory) {
        super(deps, R.layout.fragment_destinations, null, 4, null);
        Intrinsics.f(deps, "deps");
        Intrinsics.f(locationManager, "locationManager");
        Intrinsics.f(destinationMapper, "destinationMapper");
        Intrinsics.f(fragmentFactory, "fragmentFactory");
        this.f28155v = new LinkedHashMap();
        this.f28148o = locationManager;
        this.f28149p = destinationMapper;
        this.f28150q = fragmentFactory;
        this.f28151r = new LocationRequiredDialogDelegate();
        this.f28152s = new DiffAdapter().P(new TwoLinesItemDelegate(new DestinationFragment$diffAdapter$1(this), null, 0, new DestinationFragment$diffAdapter$2(this), 6, null)).P(new DividerDelegate());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void B0(DestinationScreenState destinationScreenState) {
        ArrayList arrayList = new ArrayList();
        List<ListModel> a8 = destinationScreenState.a();
        arrayList.addAll(a8);
        if (!a8.isEmpty()) {
            arrayList.add(destinationScreenState.b());
        }
        Intrinsics.d(a8, "null cannot be cast to non-null type kotlin.collections.List<ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate.Model<ee.mtakso.driver.network.client.settings.DriverDestination>>");
        arrayList.addAll(m0(a8));
        DiffAdapter.V(this.f28152s, arrayList, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C0(final DestinationLimit destinationLimit) {
        boolean z7;
        String string;
        final int a8 = destinationLimit.a() - destinationLimit.b();
        if (a8 <= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.f28154u = z7;
        TextView textView = (TextView) Z(R.id.driverDestinationsQuota);
        if (this.f28154u) {
            string = getString(R.string.destination_no_trips_left);
        } else {
            string = getString(R.string.driver_destinations_quota, Integer.valueOf(a8), Integer.valueOf(destinationLimit.a()));
        }
        textView.setText(string);
        ((TextView) Z(R.id.driverDestinationsInfo)).setOnClickListener(new View.OnClickListener() { // from class: g3.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DestinationFragment.D0(DestinationFragment.this, a8, destinationLimit, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(DestinationFragment this$0, int i8, DestinationLimit limit, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(limit, "$limit");
        Navigator n02 = this$0.n0();
        if (n02 != null) {
            Navigator.DefaultImpls.b(n02, AboutDriverDestinationsFragment.class, AboutDriverDestinationsFragment.f29739h.a(i8, limit.a()), false, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SnackBarModel k0() {
        return new SnackBarModel(-1, new Text.Resource(R.string.destination_address_removed, null, 2, null), null, null, null, null, 60, null);
    }

    private final DriverDestination l0(String str, String str2) {
        return new DriverDestination(0L, str, str2, null, null, null, null, 57, null);
    }

    private final List<ListModel> m0(List<TwoLinesItemDelegate.Model<DriverDestination>> list) {
        ArrayList arrayList = new ArrayList();
        if (z0(list, "home")) {
            String string = getString(R.string.destination_add_home_address);
            Intrinsics.e(string, "getString(R.string.destination_add_home_address)");
            arrayList.add(l0("home", string));
        }
        if (z0(list, "favorite")) {
            String string2 = getString(R.string.destination_add_favourite_address);
            Intrinsics.e(string2, "getString(R.string.desti…on_add_favourite_address)");
            arrayList.add(l0("favorite", string2));
        }
        if (!this.f28154u) {
            String string3 = getString(R.string.set_destination);
            Intrinsics.e(string3, "getString(R.string.set_destination)");
            arrayList.add(l0("manual", string3));
        }
        return this.f28149p.f(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Navigator n0() {
        FragmentActivity activity = getActivity();
        if (activity instanceof Navigator) {
            return (Navigator) activity;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0(TwoLinesItemDelegate.Model<DriverDestination> model) {
        DestinationsViewModel.E0(M(), model.B(), false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0(TwoLinesItemDelegate.Model<DriverDestination> model) {
        FragmentFactory fragmentFactory = this.f28150q;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        ((DestinationEditBottomDialogFragment) FragmentFactoryUtils.b(fragmentFactory, requireContext, DestinationEditBottomDialogFragment.class, DestinationEditBottomDialogFragment.f28198w.a(model.B()))).show(getParentFragmentManager(), "destinationEditDialog");
    }

    private final boolean q0(Throwable th) {
        String str;
        if (ApiExceptionUtils.m(th, 702)) {
            DestinationValidationError e8 = ApiExceptionUtils.e(th);
            if (e8 != null) {
                str = e8.a();
            } else {
                str = null;
            }
            if (Intrinsics.a(str, "quota_exceeded")) {
                return true;
            }
        }
        return false;
    }

    private final void r0() {
        LiveData<DestinationLimit> g02 = M().g0();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<DestinationLimit, Unit> function1 = new Function1<DestinationLimit, Unit>() { // from class: ee.mtakso.driver.ui.screens.destination.DestinationFragment$initObservers$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DestinationLimit it) {
                DestinationFragment destinationFragment = DestinationFragment.this;
                Intrinsics.e(it, "it");
                destinationFragment.C0(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DestinationLimit destinationLimit) {
                b(destinationLimit);
                return Unit.f50853a;
            }
        };
        g02.i(viewLifecycleOwner, new Observer() { // from class: g3.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DestinationFragment.s0(Function1.this, obj);
            }
        });
        LiveData<DestinationScreenState> j02 = M().j0();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<DestinationScreenState, Unit> function12 = new Function1<DestinationScreenState, Unit>() { // from class: ee.mtakso.driver.ui.screens.destination.DestinationFragment$initObservers$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DestinationScreenState destinationsScreenState) {
                DestinationFragment destinationFragment = DestinationFragment.this;
                Intrinsics.e(destinationsScreenState, "destinationsScreenState");
                destinationFragment.B0(destinationsScreenState);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DestinationScreenState destinationScreenState) {
                b(destinationScreenState);
                return Unit.f50853a;
            }
        };
        j02.i(viewLifecycleOwner2, new Observer() { // from class: g3.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DestinationFragment.t0(Function1.this, obj);
            }
        });
        LiveData<Unit> i02 = M().i0();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<Unit, Unit> function13 = new Function1<Unit, Unit>() { // from class: ee.mtakso.driver.ui.screens.destination.DestinationFragment$initObservers$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Unit unit) {
                LocationRequiredDialogDelegate locationRequiredDialogDelegate;
                locationRequiredDialogDelegate = DestinationFragment.this.f28151r;
                locationRequiredDialogDelegate.f(DestinationFragment.this);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                b(unit);
                return Unit.f50853a;
            }
        };
        i02.i(viewLifecycleOwner3, new Observer() { // from class: g3.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DestinationFragment.u0(Function1.this, obj);
            }
        });
        LiveData<GeoLocationIssue> h02 = M().h0();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        final Function1<GeoLocationIssue, Unit> function14 = new Function1<GeoLocationIssue, Unit>() { // from class: ee.mtakso.driver.ui.screens.destination.DestinationFragment$initObservers$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(GeoLocationIssue it) {
                GeoLocationManager geoLocationManager;
                geoLocationManager = DestinationFragment.this.f28148o;
                Intrinsics.e(it, "it");
                FragmentActivity requireActivity = DestinationFragment.this.requireActivity();
                Intrinsics.e(requireActivity, "requireActivity()");
                GeoLocationManager.E(geoLocationManager, it, requireActivity, null, 4, null);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GeoLocationIssue geoLocationIssue) {
                b(geoLocationIssue);
                return Unit.f50853a;
            }
        };
        h02.i(viewLifecycleOwner4, new Observer() { // from class: g3.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DestinationFragment.v0(Function1.this, obj);
            }
        });
        M().k0().i(getViewLifecycleOwner(), new Observer() { // from class: g3.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DestinationFragment.w0(DestinationFragment.this, obj);
            }
        });
        LiveData<DriverDestination> l02 = M().l0();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        final Function1<DriverDestination, Unit> function15 = new Function1<DriverDestination, Unit>() { // from class: ee.mtakso.driver.ui.screens.destination.DestinationFragment$initObservers$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DriverDestination driverDestination) {
                Navigator n02 = DestinationFragment.this.n0();
                if (n02 != null) {
                    DriverDestinationSearchFragment.Companion companion = DriverDestinationSearchFragment.f28206s;
                    Intrinsics.e(driverDestination, "driverDestination");
                    Navigator.DefaultImpls.b(n02, DriverDestinationSearchFragment.class, companion.a(driverDestination), false, 4, null);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DriverDestination driverDestination) {
                b(driverDestination);
                return Unit.f50853a;
            }
        };
        l02.i(viewLifecycleOwner5, new Observer() { // from class: g3.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DestinationFragment.x0(Function1.this, obj);
            }
        });
        LiveData<DriverDestination> f02 = M().f0();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        final Function1<DriverDestination, Unit> function16 = new Function1<DriverDestination, Unit>() { // from class: ee.mtakso.driver.ui.screens.destination.DestinationFragment$initObservers$7
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DriverDestination driverDestination) {
                SnackBarDelegate snackBarDelegate;
                SnackBarModel k02;
                snackBarDelegate = DestinationFragment.this.f28153t;
                if (snackBarDelegate != null) {
                    k02 = DestinationFragment.this.k0();
                    snackBarDelegate.b(k02);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DriverDestination driverDestination) {
                b(driverDestination);
                return Unit.f50853a;
            }
        };
        f02.i(viewLifecycleOwner6, new Observer() { // from class: g3.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DestinationFragment.y0(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(final DestinationFragment this$0, Object obj) {
        Intrinsics.f(this$0, "this$0");
        final Lifecycle.State state = Lifecycle.State.RESUMED;
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: ee.mtakso.driver.ui.screens.destination.DestinationFragment$initObservers$lambda$5$$inlined$doAtState$1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                Intrinsics.f(source, "source");
                Intrinsics.f(event, "event");
                if (LifecycleOwner.this.getLifecycle().b().a(state)) {
                    Navigator n02 = this$0.n0();
                    if (n02 != null) {
                        n02.c();
                    }
                    LifecycleOwner.this.getLifecycle().c(this);
                }
            }
        };
        if (this$0.getLifecycle().b().a(state)) {
            Navigator n02 = this$0.n0();
            if (n02 != null) {
                n02.c();
                return;
            }
            return;
        }
        this$0.getLifecycle().a(lifecycleEventObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final boolean z0(List<TwoLinesItemDelegate.Model<DriverDestination>> list, String str) {
        String str2;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            DriverDestination driverDestination = (DriverDestination) ((TwoLinesItemDelegate.Model) it.next()).B();
            if (driverDestination != null) {
                str2 = driverDestination.f();
            } else {
                str2 = null;
            }
            if (Intrinsics.a(str2, str)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: A0 */
    public DestinationsViewModel Q() {
        BaseUiDependencies E;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        E = E();
        return (DestinationsViewModel) new ViewModelProvider(requireActivity, E.d()).a(DestinationsViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f28155v.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void G() {
        super.G();
        ((CircularProgressIndicator) Z(R.id.V6)).j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void H(Throwable error) {
        Intrinsics.f(error, "error");
        if (q0(error)) {
            NotificationDialog.Companion companion = NotificationDialog.f28313n;
            String string = getString(R.string.destination_no_trips_left);
            Context requireContext = requireContext();
            Intrinsics.e(requireContext, "requireContext()");
            String k8 = ApiExceptionUtils.k(error, requireContext);
            String string2 = getString(R.string.close);
            Intrinsics.e(string2, "getString(R.string.close)");
            NotificationDialog f8 = NotificationDialog.Companion.f(companion, string, k8, string2, 0, null, error, 16, null);
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.e(requireActivity, "requireActivity()");
            FragmentUtils.c(f8, requireActivity, "error");
            return;
        }
        NotificationDialog.Companion companion2 = NotificationDialog.f28313n;
        Context requireContext2 = requireContext();
        Intrinsics.e(requireContext2, "requireContext()");
        NotificationDialog c8 = NotificationDialog.Companion.c(companion2, requireContext2, error, null, 4, null);
        FragmentActivity requireActivity2 = requireActivity();
        Intrinsics.e(requireActivity2, "requireActivity()");
        FragmentUtils.c(c8, requireActivity2, "error");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void I() {
        super.I();
        ((CircularProgressIndicator) Z(R.id.V6)).q();
    }

    public View Z(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f28155v;
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

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f28153t = null;
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        M().m0();
        Navigator n02 = n0();
        if (n02 != null) {
            n02.x(new PopupToolbarAppearance(0, new Text.Value(""), false, null, null, null, null, null, null, 509, null));
        }
        int i8 = R.id.recyclerViewDestinations;
        ((RecyclerView) Z(i8)).setLayoutManager(new LinearLayoutManager(requireContext()));
        ((RecyclerView) Z(i8)).setAdapter(this.f28152s);
        ((RecyclerView) Z(i8)).h(new ListItemDividerDecoration(Dimens.c(24.0f)));
        this.f28151r.d(new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.destination.DestinationFragment$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final void b() {
                DestinationsViewModel M;
                M = DestinationFragment.this.M();
                M.w0();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        });
        this.f28151r.e(new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.destination.DestinationFragment$onViewCreated$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final void b() {
                Navigator n03 = DestinationFragment.this.n0();
                if (n03 != null) {
                    n03.c();
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        });
        this.f28151r.c(this);
        ConstraintLayout root = (ConstraintLayout) Z(R.id.root);
        Intrinsics.e(root, "root");
        this.f28153t = new SnackBarDelegate(root, null, 2, null);
        r0();
    }
}
