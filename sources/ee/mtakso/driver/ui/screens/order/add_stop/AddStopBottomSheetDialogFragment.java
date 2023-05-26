package ee.mtakso.driver.ui.screens.order.add_stop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.order.StopType;
import ee.mtakso.driver.network.client.order.UpcomingStop;
import ee.mtakso.driver.service.geo.GeoCoordinate;
import ee.mtakso.driver.service.geo.GeoLocation;
import ee.mtakso.driver.ui.base.mvvm.BaseMvvmScrollableBottomSheetDialogFragment;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.interactor.order.active.map.MapData;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.order.add_stop.AddStopBottomSheetDialogFragment;
import ee.mtakso.driver.ui.screens.order.lookup.orderdestination.OrderDestinationFragment;
import ee.mtakso.driver.ui.screens.order.lookup.orderdestination.OrderDestinationResult;
import ee.mtakso.driver.ui.screens.order.v2.OrderViewModel;
import ee.mtakso.driver.ui.screens.order.v2.map.MapState;
import ee.mtakso.driver.ui.screens.order.v2.order.OrderCommonData;
import ee.mtakso.driver.ui.screens.order.v2.order.OrderData;
import ee.mtakso.driver.uicore.utils.RippleProvider;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AddStopBottomSheetDialogFragment.kt */
/* loaded from: classes3.dex */
public final class AddStopBottomSheetDialogFragment extends BaseMvvmScrollableBottomSheetDialogFragment<OrderViewModel> {

    /* renamed from: w  reason: collision with root package name */
    public static final Companion f30977w = new Companion(null);

    /* renamed from: u  reason: collision with root package name */
    private final ActivityResultLauncher<Intent> f30978u;

    /* renamed from: v  reason: collision with root package name */
    public Map<Integer, View> f30979v;

    /* compiled from: AddStopBottomSheetDialogFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(int i8) {
            return BundleKt.a(TuplesKt.a("max_number_of_intermediate_stops", Integer.valueOf(i8)));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public AddStopBottomSheetDialogFragment(BaseUiDependencies depss) {
        super(depss, R.layout.fragment_add_stop, null, 4, null);
        Intrinsics.f(depss, "depss");
        this.f30979v = new LinkedHashMap();
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback() { // from class: p4.a
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                AddStopBottomSheetDialogFragment.g0(AddStopBottomSheetDialogFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.e(registerForActivityResult, "registerForActivityResul…)\n            }\n        }");
        this.f30978u = registerForActivityResult;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.J0(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void b0(ee.mtakso.driver.network.client.order.UpcomingStop r3, ee.mtakso.driver.ui.screens.order.add_stop.AddressChangeType r4) {
        /*
            r2 = this;
            ee.mtakso.driver.ui.base.mvvm.BaseViewModel r0 = r2.O()
            ee.mtakso.driver.ui.screens.order.v2.OrderViewModel r0 = (ee.mtakso.driver.ui.screens.order.v2.OrderViewModel) r0
            androidx.lifecycle.LiveData r0 = r0.E2()
            java.lang.Object r0 = r0.f()
            ee.mtakso.driver.ui.screens.order.v2.order.OrderData r0 = (ee.mtakso.driver.ui.screens.order.v2.order.OrderData) r0
            if (r0 == 0) goto L24
            ee.mtakso.driver.ui.screens.order.v2.order.OrderMenuData r0 = r0.b()
            if (r0 == 0) goto L24
            java.util.List r0 = r0.n()
            if (r0 == 0) goto L24
            java.util.List r0 = kotlin.collections.CollectionsKt.J0(r0)
            if (r0 != 0) goto L29
        L24:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L29:
            r1 = 0
            r0.add(r1, r3)
            ee.mtakso.driver.ui.base.mvvm.BaseViewModel r3 = r2.O()
            ee.mtakso.driver.ui.screens.order.v2.OrderViewModel r3 = (ee.mtakso.driver.ui.screens.order.v2.OrderViewModel) r3
            r3.h1(r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.order.add_stop.AddStopBottomSheetDialogFragment.b0(ee.mtakso.driver.network.client.order.UpcomingStop, ee.mtakso.driver.ui.screens.order.add_stop.AddressChangeType):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(AddStopBottomSheetDialogFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.O().G3();
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(AddStopBottomSheetDialogFragment this$0, View view) {
        GeoLocation geoLocation;
        MapData c8;
        Intrinsics.f(this$0, "this$0");
        this$0.O().H3();
        MapState f8 = this$0.O().A2().f();
        if (f8 != null && (c8 = f8.c()) != null) {
            geoLocation = c8.a();
        } else {
            geoLocation = null;
        }
        if (geoLocation != null) {
            this$0.b0(new UpcomingStop(-1L, null, Double.valueOf(geoLocation.e().a()), Double.valueOf(geoLocation.e().b()), StopType.UNKNOWN, null), AddressChangeType.ADD_ADDRESS_AT_CURRENT_LOCATION);
        }
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(AddStopBottomSheetDialogFragment this$0, View view) {
        Long l8;
        OrderCommonData a8;
        Intrinsics.f(this$0, "this$0");
        OrderData f8 = this$0.O().E2().f();
        if (f8 != null && (a8 = f8.a()) != null) {
            l8 = a8.h();
        } else {
            l8 = null;
        }
        this$0.O().F3();
        ActivityResultLauncher<Intent> activityResultLauncher = this$0.f30978u;
        SimpleActivity.Companion companion = SimpleActivity.f27004l;
        Context requireContext = this$0.requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        activityResultLauncher.launch(SimpleActivity.Companion.h(companion, requireContext, OrderDestinationFragment.class, OrderDestinationFragment.f31468q.a(null, l8), false, 8, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(AddStopBottomSheetDialogFragment this$0, ActivityResult activityResult) {
        Intrinsics.f(this$0, "this$0");
        Intent a8 = activityResult.a();
        if (activityResult.b() == -1 && a8 != null) {
            OrderDestinationResult b8 = OrderDestinationFragment.f31468q.b(a8);
            if (b8 != null) {
                this$0.O().O3(new GeoCoordinate(b8.c(), b8.d()));
                this$0.b0(new UpcomingStop(-1L, b8.a(), Double.valueOf(b8.c()), Double.valueOf(b8.d()), StopType.UNKNOWN, null), AddressChangeType.ADD_ADDRESS_THROUGH_SEARCH);
            }
            this$0.dismissAllowingStateLoss();
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmScrollableBottomSheetDialogFragment, ee.mtakso.driver.uicore.components.dialogs.BaseScrollableBottomSheetDialogFragment, ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment
    public void H() {
        this.f30979v.clear();
    }

    public View a0(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f30979v;
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
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmScrollableBottomSheetDialogFragment
    /* renamed from: f0 */
    public OrderViewModel T() {
        BaseUiDependencies baseUiDependencies;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        baseUiDependencies = ((BaseMvvmScrollableBottomSheetDialogFragment) this).f26256q;
        return (OrderViewModel) new ViewModelProvider(requireActivity, baseUiDependencies.d()).a(OrderViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmScrollableBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, 2132017805);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmScrollableBottomSheetDialogFragment, ee.mtakso.driver.uicore.components.dialogs.BaseScrollableBottomSheetDialogFragment, ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmScrollableBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Integer num;
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        O().I3();
        Bundle arguments = getArguments();
        if (arguments != null) {
            num = Integer.valueOf(arguments.getInt("max_number_of_intermediate_stops"));
        } else {
            num = null;
        }
        ((TextView) a0(R.id.addStopSubtitle)).setText(getString(R.string.active_ride_add_stop_information, num));
        RippleProvider rippleProvider = RippleProvider.f35730a;
        int i8 = R.id.addStopAtCurrentLocation;
        TextView addStopAtCurrentLocation = (TextView) a0(i8);
        Intrinsics.e(addStopAtCurrentLocation, "addStopAtCurrentLocation");
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        int b8 = ContextUtilsKt.b(requireContext, R.attr.backPrimary);
        Context requireContext2 = requireContext();
        Intrinsics.e(requireContext2, "requireContext()");
        rippleProvider.a(addStopAtCurrentLocation, b8, ContextUtilsKt.b(requireContext2, R.attr.colorControlNormal));
        int i9 = R.id.enterStopAddress;
        TextView enterStopAddress = (TextView) a0(i9);
        Intrinsics.e(enterStopAddress, "enterStopAddress");
        Context requireContext3 = requireContext();
        Intrinsics.e(requireContext3, "requireContext()");
        int b9 = ContextUtilsKt.b(requireContext3, R.attr.backPrimary);
        Context requireContext4 = requireContext();
        Intrinsics.e(requireContext4, "requireContext()");
        rippleProvider.a(enterStopAddress, b9, ContextUtilsKt.b(requireContext4, R.attr.colorControlNormal));
        ((ImageView) a0(R.id.cancelAction)).setOnClickListener(new View.OnClickListener() { // from class: p4.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AddStopBottomSheetDialogFragment.c0(AddStopBottomSheetDialogFragment.this, view2);
            }
        });
        ((TextView) a0(i8)).setOnClickListener(new View.OnClickListener() { // from class: p4.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AddStopBottomSheetDialogFragment.d0(AddStopBottomSheetDialogFragment.this, view2);
            }
        });
        ((TextView) a0(i9)).setOnClickListener(new View.OnClickListener() { // from class: p4.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AddStopBottomSheetDialogFragment.e0(AddStopBottomSheetDialogFragment.this, view2);
            }
        });
    }
}
