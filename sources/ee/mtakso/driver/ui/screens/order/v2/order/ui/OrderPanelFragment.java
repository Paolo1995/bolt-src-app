package ee.mtakso.driver.ui.screens.order.v2.order.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.order.DriverAppStickyBanner;
import ee.mtakso.driver.network.client.order.Price;
import ee.mtakso.driver.network.client.order.RejectReason;
import ee.mtakso.driver.network.client.order.StopType;
import ee.mtakso.driver.network.client.order.UpcomingStop;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.geo.GeoCoordinate;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.contact_methods.ContactMethodsBaseActivity;
import ee.mtakso.driver.ui.screens.contact_methods.contactoptions.ContactOptionsFragment;
import ee.mtakso.driver.ui.screens.dialogs.ConfirmationDialog;
import ee.mtakso.driver.ui.screens.dialogs.InfoDialog;
import ee.mtakso.driver.ui.screens.navigator_chooser.NavigatorChooserFragment;
import ee.mtakso.driver.ui.screens.order.add_stop.AddressChangeType;
import ee.mtakso.driver.ui.screens.order.cancel.TripCancellationBottomSheetFragment;
import ee.mtakso.driver.ui.screens.order.lookup.orderdestination.OrderDestinationFragment;
import ee.mtakso.driver.ui.screens.order.lookup.orderdestination.OrderDestinationResult;
import ee.mtakso.driver.ui.screens.order.ordermenudialog.OrderMenuCallback;
import ee.mtakso.driver.ui.screens.order.ordermenudialog.OrderMenuDialogFragment;
import ee.mtakso.driver.ui.screens.order.v2.CancelWarningType;
import ee.mtakso.driver.ui.screens.order.v2.ConfirmationSignal;
import ee.mtakso.driver.ui.screens.order.v2.OrderViewModel;
import ee.mtakso.driver.ui.screens.order.v2.order.AppStickyBanner;
import ee.mtakso.driver.ui.screens.order.v2.order.BottomBarState;
import ee.mtakso.driver.ui.screens.order.v2.order.BottomWidgetStates;
import ee.mtakso.driver.ui.screens.order.v2.order.DriverAppStickyBannerMapper;
import ee.mtakso.driver.ui.screens.order.v2.order.OrderCommonData;
import ee.mtakso.driver.ui.screens.order.v2.order.OrderData;
import ee.mtakso.driver.ui.screens.order.v2.order.OrderMenuData;
import ee.mtakso.driver.ui.screens.waybill.WaybillFragment;
import ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment;
import ee.mtakso.driver.uicore.components.views.AlphaAnimatedPlaceholderView;
import ee.mtakso.driver.uicore.components.views.swipe.SwipeButton;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import ee.mtakso.driver.utils.AssertUtils;
import ee.mtakso.driver.utils.ext.FragmentFactoryUtils;
import eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment;
import eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback;
import eu.bolt.driver.core.ui.base.dialog.DialogLifecycleEvent;
import eu.bolt.driver.core.ui.common.dialog.CancellationDialog;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderPanelFragment.kt */
/* loaded from: classes3.dex */
public final class OrderPanelFragment extends BazeMvvmFragment<OrderViewModel> implements OrderMenuCallback {
    public static final Companion C = new Companion(null);
    private final ActivityResultLauncher<Intent> A;
    public Map<Integer, View> B;

    /* renamed from: o  reason: collision with root package name */
    private final FragmentFactory f32389o;

    /* renamed from: p  reason: collision with root package name */
    private final RoutingManager f32390p;

    /* renamed from: q  reason: collision with root package name */
    private final DriverProvider f32391q;

    /* renamed from: r  reason: collision with root package name */
    private final DriverAppStickyBannerMapper f32392r;

    /* renamed from: s  reason: collision with root package name */
    private GoingToPickupViewDelegate f32393s;

    /* renamed from: t  reason: collision with root package name */
    private WaitingForClientViewDelegate f32394t;

    /* renamed from: u  reason: collision with root package name */
    private DrivingWithClientViewDelegate f32395u;

    /* renamed from: v  reason: collision with root package name */
    private BottomSheetStateDelegate f32396v;

    /* renamed from: w  reason: collision with root package name */
    private WaitingOnStopDelegate f32397w;

    /* renamed from: x  reason: collision with root package name */
    private StickyBannerViewDelegate f32398x;

    /* renamed from: y  reason: collision with root package name */
    private final boolean f32399y;

    /* renamed from: z  reason: collision with root package name */
    private final Function3<DialogFragment, View, Object, Unit> f32400z;

    /* compiled from: OrderPanelFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: OrderPanelFragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f32401a;

        static {
            int[] iArr = new int[ConfirmationSignal.values().length];
            try {
                iArr[ConfirmationSignal.ARRIVE_TO_PICKUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ConfirmationSignal.AUTO_REMINDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ConfirmationSignal.ARRIVE_TO_DESTINATION_SWIPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ConfirmationSignal.ARRIVE_TO_DESTINATION_MENU.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ConfirmationSignal.EDIT_DESTINATION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ConfirmationSignal.CHOOSE_NAVIGATOR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ConfirmationSignal.REORDER_STOPS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f32401a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public OrderPanelFragment(BaseUiDependencies deps, FragmentFactory fragmentFactory, RoutingManager routingManager, DriverProvider driverProvider, DriverAppStickyBannerMapper driverAppStickyBannerMapper) {
        super(deps, R.layout.active_order_bottom_layout, null, 4, null);
        Intrinsics.f(deps, "deps");
        Intrinsics.f(fragmentFactory, "fragmentFactory");
        Intrinsics.f(routingManager, "routingManager");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(driverAppStickyBannerMapper, "driverAppStickyBannerMapper");
        this.B = new LinkedHashMap();
        this.f32389o = fragmentFactory;
        this.f32390p = routingManager;
        this.f32391q = driverProvider;
        this.f32392r = driverAppStickyBannerMapper;
        this.f32399y = driverProvider.q().C();
        this.f32400z = new Function3<DialogFragment, View, Object, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.ui.OrderPanelFragment$onConfirmationClickListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            public final void b(DialogFragment dialogFragment, View view, Object obj) {
                OrderViewModel M;
                OrderViewModel M2;
                OrderViewModel M3;
                OrderViewModel M4;
                OrderViewModel M5;
                OrderViewModel M6;
                OrderViewModel M7;
                Intrinsics.f(dialogFragment, "dialogFragment");
                dialogFragment.dismiss();
                if (Intrinsics.a(obj, "confirm")) {
                    OrderPanelFragment orderPanelFragment = OrderPanelFragment.this;
                    Intrinsics.d(obj, "null cannot be cast to non-null type kotlin.String");
                    String tag = dialogFragment.getTag();
                    Intrinsics.d(tag, "null cannot be cast to non-null type kotlin.String");
                    orderPanelFragment.W0((String) obj, tag);
                    String tag2 = dialogFragment.getTag();
                    if (tag2 != null) {
                        switch (tag2.hashCode()) {
                            case -2073825491:
                                if (tag2.equals("ARRIVE_TO_DESTINATION_SWIPE")) {
                                    M3 = OrderPanelFragment.this.M();
                                    M3.s1(false);
                                    return;
                                }
                                return;
                            case -1520041939:
                                if (tag2.equals("REORDER_STOPS")) {
                                    M4 = OrderPanelFragment.this.M();
                                    M4.p3(dialogFragment.requireArguments().getLong("extra_stop_id"));
                                    return;
                                }
                                return;
                            case -1452566804:
                                if (tag2.equals("ARRIVE_TO_DESTINATION_MENU")) {
                                    M5 = OrderPanelFragment.this.M();
                                    M5.s1(true);
                                    return;
                                }
                                return;
                            case -1403730600:
                                if (tag2.equals("ARRIVE_TO_PICKUP")) {
                                    M6 = OrderPanelFragment.this.M();
                                    M6.C3(true);
                                    return;
                                }
                                return;
                            case 1541135673:
                                if (tag2.equals("EDIT_DESTINATION")) {
                                    OrderPanelFragment.this.p0(Long.valueOf(dialogFragment.requireArguments().getLong("extra_stop_id")));
                                    return;
                                }
                                return;
                            case 1880555778:
                                if (tag2.equals("AUTO_REMINDER")) {
                                    M7 = OrderPanelFragment.this.M();
                                    OrderViewModel.D3(M7, false, 1, null);
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                    return;
                }
                OrderPanelFragment orderPanelFragment2 = OrderPanelFragment.this;
                Intrinsics.d(obj, "null cannot be cast to non-null type kotlin.String");
                String tag3 = dialogFragment.getTag();
                Intrinsics.d(tag3, "null cannot be cast to non-null type kotlin.String");
                orderPanelFragment2.W0((String) obj, tag3);
                String tag4 = dialogFragment.getTag();
                if (tag4 != null) {
                    int hashCode = tag4.hashCode();
                    if (hashCode != -2073825491) {
                        if (hashCode == -1452566804 && tag4.equals("ARRIVE_TO_DESTINATION_MENU")) {
                            M2 = OrderPanelFragment.this.M();
                            M2.U2(true);
                        }
                    } else if (tag4.equals("ARRIVE_TO_DESTINATION_SWIPE")) {
                        M = OrderPanelFragment.this.M();
                        M.U2(false);
                    }
                }
                OrderPanelFragment orderPanelFragment3 = OrderPanelFragment.this;
                int i8 = R.id.active_order_swipe_button;
                ((SwipeButton) orderPanelFragment3.d0(i8)).K(((SwipeButton) OrderPanelFragment.this.d0(i8)).getCurrentState(), true);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit l(DialogFragment dialogFragment, View view, Object obj) {
                b(dialogFragment, view, obj);
                return Unit.f50853a;
            }
        };
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.ui.c
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                OrderPanelFragment.V0(OrderPanelFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.e(registerForActivityResult, "registerForActivityResul…}\n            }\n        }");
        this.A = registerForActivityResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(OrderPanelFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().t3(BottomBarState.EXPANDED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(OrderPanelFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.S0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(OrderPanelFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        q0(this$0, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(OrderPanelFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.H0().h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(OrderPanelFragment this$0, BottomWidgetStates it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        this$0.N0(it);
    }

    private final BottomSheetStateDelegate H0() {
        BottomSheetStateDelegate bottomSheetStateDelegate = this.f32396v;
        if (bottomSheetStateDelegate != null) {
            return bottomSheetStateDelegate;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final DrivingWithClientViewDelegate I0() {
        DrivingWithClientViewDelegate drivingWithClientViewDelegate = this.f32395u;
        if (drivingWithClientViewDelegate != null) {
            return drivingWithClientViewDelegate;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final GoingToPickupViewDelegate J0() {
        GoingToPickupViewDelegate goingToPickupViewDelegate = this.f32393s;
        if (goingToPickupViewDelegate != null) {
            return goingToPickupViewDelegate;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final StickyBannerViewDelegate K0() {
        StickyBannerViewDelegate stickyBannerViewDelegate = this.f32398x;
        if (stickyBannerViewDelegate != null) {
            return stickyBannerViewDelegate;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final WaitingForClientViewDelegate L0() {
        WaitingForClientViewDelegate waitingForClientViewDelegate = this.f32394t;
        if (waitingForClientViewDelegate != null) {
            return waitingForClientViewDelegate;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final WaitingOnStopDelegate M0() {
        WaitingOnStopDelegate waitingOnStopDelegate = this.f32397w;
        if (waitingOnStopDelegate != null) {
            return waitingOnStopDelegate;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final void N0(BottomWidgetStates bottomWidgetStates) {
        H0().m(bottomWidgetStates);
    }

    private final void O0() {
        DialogFragment dialogFragment;
        Fragment findFragmentByTag = requireFragmentManager().findFragmentByTag("cancelReason");
        if (findFragmentByTag instanceof DialogFragment) {
            dialogFragment = (DialogFragment) findFragmentByTag;
        } else {
            dialogFragment = null;
        }
        if (dialogFragment != null) {
            dialogFragment.dismissAllowingStateLoss();
        }
        Toast.makeText(requireContext(), (int) R.string.ride_cancelled_description, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P0(final CancelWarningType cancelWarningType) {
        if (cancelWarningType instanceof CancelWarningType.Confirmation) {
            DefaultDialogCallback defaultDialogCallback = new DefaultDialogCallback() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.ui.OrderPanelFragment$showCancelWarningDialog$cancelDialogCallback$1
                @Override // eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback, eu.bolt.driver.core.ui.base.dialog.DialogCallback
                public void a(BaseDialogFragment dialog, View view, Object payload) {
                    OrderViewModel M;
                    Intrinsics.f(dialog, "dialog");
                    Intrinsics.f(view, "view");
                    Intrinsics.f(payload, "payload");
                    if (Intrinsics.a(payload, "negative")) {
                        dialog.dismissAllowingStateLoss();
                    } else if (Intrinsics.a(payload, "positive")) {
                        dialog.dismissAllowingStateLoss();
                        M = OrderPanelFragment.this.M();
                        M.k1(((CancelWarningType.Confirmation) cancelWarningType).a());
                    }
                }

                @Override // eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback, eu.bolt.driver.core.ui.base.dialog.DialogCallback
                public void b(BaseDialogFragment dialog, DialogLifecycleEvent event, Object obj) {
                    Intrinsics.f(dialog, "dialog");
                    Intrinsics.f(event, "event");
                    if (event == DialogLifecycleEvent.CANCELLED) {
                        dialog.dismissAllowingStateLoss();
                    }
                }
            };
            CancellationDialog.Companion companion = CancellationDialog.f41073m;
            String string = getString(R.string.cancel_warning_title);
            Intrinsics.e(string, "getString(R.string.cancel_warning_title)");
            CharSequence b8 = ((CancelWarningType.Confirmation) cancelWarningType).b();
            String string2 = getString(R.string.cancel_order_warning_confirm);
            Intrinsics.e(string2, "getString(R.string.cancel_order_warning_confirm)");
            String string3 = getString(R.string.cancel_order_warning_dont_cancel);
            Intrinsics.e(string3, "getString(R.string.cance…rder_warning_dont_cancel)");
            FragmentUtils.b(companion.a(string, b8, string2, string3, defaultDialogCallback), this, "dialog_tag_cancel_confirmation");
        } else if (cancelWarningType != null) {
            FragmentUtils.b(s0(cancelWarningType, new Function3<DialogFragment, View, Object, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.ui.OrderPanelFragment$showCancelWarningDialog$1$cancelWarningDialogListener$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                public final void b(DialogFragment dialogFragment, View view, Object obj) {
                    OrderViewModel M;
                    OrderViewModel M2;
                    OrderViewModel M3;
                    Intrinsics.f(dialogFragment, "dialogFragment");
                    dialogFragment.dismiss();
                    if (Intrinsics.a(obj, "confirm")) {
                        M2 = OrderPanelFragment.this.M();
                        M2.f3();
                        M3 = OrderPanelFragment.this.M();
                        M3.z3(cancelWarningType.a());
                    } else if (Intrinsics.a(obj, "cancel")) {
                        M = OrderPanelFragment.this.M();
                        M.X2();
                    }
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit l(DialogFragment dialogFragment, View view, Object obj) {
                    b(dialogFragment, view, obj);
                    return Unit.f50853a;
                }
            }), this, "dialog_tag_cancel_warning");
            M().V2(cancelWarningType);
        }
    }

    private final void Q0(ConfirmationSignal confirmationSignal, Long l8) {
        switch (WhenMappings.f32401a[confirmationSignal.ordinal()]) {
            case 1:
                ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment l02 = l0();
                FragmentActivity requireActivity = requireActivity();
                Intrinsics.e(requireActivity, "requireActivity()");
                FragmentUtils.c(l02, requireActivity, confirmationSignal.name());
                return;
            case 2:
                ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment k02 = k0();
                FragmentActivity requireActivity2 = requireActivity();
                Intrinsics.e(requireActivity2, "requireActivity()");
                FragmentUtils.c(k02, requireActivity2, confirmationSignal.name());
                return;
            case 3:
                ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment n02 = n0();
                FragmentActivity requireActivity3 = requireActivity();
                Intrinsics.e(requireActivity3, "requireActivity()");
                FragmentUtils.c(n02, requireActivity3, confirmationSignal.name());
                return;
            case 4:
                ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment n03 = n0();
                FragmentActivity requireActivity4 = requireActivity();
                Intrinsics.e(requireActivity4, "requireActivity()");
                FragmentUtils.c(n03, requireActivity4, confirmationSignal.name());
                return;
            case 5:
                if (l8 != null) {
                    ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment m02 = m0(l8.longValue());
                    FragmentActivity requireActivity5 = requireActivity();
                    Intrinsics.e(requireActivity5, "requireActivity()");
                    FragmentUtils.c(m02, requireActivity5, confirmationSignal.name());
                    return;
                }
                return;
            case 6:
                NavigatorChooserFragment.Companion companion = NavigatorChooserFragment.f30914t;
                Context requireContext = requireContext();
                Intrinsics.e(requireContext, "requireContext()");
                companion.a(requireContext);
                return;
            default:
                return;
        }
    }

    static /* synthetic */ void R0(OrderPanelFragment orderPanelFragment, ConfirmationSignal confirmationSignal, Long l8, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            l8 = null;
        }
        orderPanelFragment.Q0(confirmationSignal, l8);
    }

    private final void S0() {
        OrderMenuData b8;
        OrderData f8 = M().E2().f();
        if (f8 != null && (b8 = f8.b()) != null) {
            FragmentFactory fragmentFactory = this.f32389o;
            Context requireContext = requireContext();
            Intrinsics.e(requireContext, "requireContext()");
            OrderMenuDialogFragment orderMenuDialogFragment = (OrderMenuDialogFragment) FragmentFactoryUtils.b(fragmentFactory, requireContext, OrderMenuDialogFragment.class, OrderMenuDialogFragment.F.a(b8.f(), b8.k(), b8.n(), Boolean.valueOf(b8.c()), Boolean.valueOf(b8.d()), Boolean.valueOf(b8.q()), Boolean.valueOf(b8.o()), Boolean.valueOf(b8.p()), b8.e(), b8.b(), b8.a(), b8.m(), b8.l(), b8.i(), b8.j(), b8.h(), b8.g()));
            if (!getChildFragmentManager().isStateSaved() && !getChildFragmentManager().isDestroyed()) {
                FragmentUtils.b(orderMenuDialogFragment, this, "menu");
                M().a3();
                return;
            }
            AssertUtils.a("Order menu is not shown. Fragment manager is not ready");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T0(OrderData orderData) {
        AppStickyBanner appStickyBanner;
        if (orderData instanceof OrderData.GoingToPickupData) {
            J0().b((OrderData.GoingToPickupData) orderData);
        } else if (orderData instanceof OrderData.WaitingForClientData) {
            L0().b((OrderData.WaitingForClientData) orderData);
        } else if (orderData instanceof OrderData.DrivingWithClientData) {
            I0().d((OrderData.DrivingWithClientData) orderData);
        } else if (orderData instanceof OrderData.WaitingOnStopData) {
            M0().b((OrderData.WaitingOnStopData) orderData);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        StickyBannerViewDelegate K0 = K0();
        DriverAppStickyBanner g8 = orderData.a().g();
        if (g8 != null) {
            appStickyBanner = this.f32392r.a(g8);
        } else {
            appStickyBanner = null;
        }
        K0.b(appStickyBanner);
    }

    private final void U0(ArrayList<RejectReason> arrayList) {
        FragmentFactory fragmentFactory = this.f32389o;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        FragmentUtils.c((TripCancellationBottomSheetFragment) FragmentFactoryUtils.b(fragmentFactory, requireContext, TripCancellationBottomSheetFragment.class, TripCancellationBottomSheetFragment.f31228x.b(arrayList)), requireActivity, "cancelReason");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V0(OrderPanelFragment this$0, ActivityResult activityResult) {
        OrderDestinationResult b8;
        long j8;
        List<UpcomingStop> e8;
        Intrinsics.f(this$0, "this$0");
        Intent a8 = activityResult.a();
        if (activityResult.b() == -1 && a8 != null && (b8 = OrderDestinationFragment.f31468q.b(a8)) != null) {
            if (this$0.f32399y) {
                Long b9 = b8.b();
                if (b9 != null) {
                    j8 = b9.longValue();
                } else {
                    j8 = -1;
                }
                e8 = CollectionsKt__CollectionsJVMKt.e(new UpcomingStop(j8, b8.a(), Double.valueOf(b8.c()), Double.valueOf(b8.d()), StopType.UNKNOWN, null));
                this$0.M().h1(e8, AddressChangeType.EDIT_ADDRESS);
                return;
            }
            this$0.M().u3(b8.a(), new GeoCoordinate(b8.c(), b8.d()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0041, code lost:
        if (r8.equals("ARRIVE_TO_DESTINATION_MENU") == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004a, code lost:
        if (r8.equals("ARRIVE_TO_DESTINATION_SWIPE") == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0051, code lost:
        if (kotlin.jvm.internal.Intrinsics.a(r7, "confirm") == false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
        r1 = "End Trip";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void W0(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            int r0 = r8.hashCode()
            java.lang.String r1 = "No"
            java.lang.String r2 = "confirm"
            java.lang.String r3 = "Far From The Destination Reminder Dialog Shown"
            java.lang.String r4 = "Far From The Pickup Point Reminder Dialog Shown"
            java.lang.String r5 = "Start Trip Reminder Dialog Shown"
            switch(r0) {
                case -2073825491: goto L44;
                case -1452566804: goto L3b;
                case -1403730600: goto L28;
                case 1880555778: goto L12;
                default: goto L11;
            }
        L11:
            goto L56
        L12:
            java.lang.String r0 = "AUTO_REMINDER"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L1b
            goto L56
        L1b:
            boolean r7 = kotlin.jvm.internal.Intrinsics.a(r7, r2)
            if (r7 == 0) goto L24
            java.lang.String r1 = "Start"
            goto L26
        L24:
            java.lang.String r1 = "Wait Passenger"
        L26:
            r3 = r5
            goto L59
        L28:
            java.lang.String r0 = "ARRIVE_TO_PICKUP"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L31
            goto L56
        L31:
            boolean r7 = kotlin.jvm.internal.Intrinsics.a(r7, r2)
            if (r7 == 0) goto L39
            java.lang.String r1 = "Yes"
        L39:
            r3 = r4
            goto L59
        L3b:
            java.lang.String r0 = "ARRIVE_TO_DESTINATION_MENU"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L4d
            goto L56
        L44:
            java.lang.String r0 = "ARRIVE_TO_DESTINATION_SWIPE"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L4d
            goto L56
        L4d:
            boolean r7 = kotlin.jvm.internal.Intrinsics.a(r7, r2)
            if (r7 == 0) goto L59
            java.lang.String r1 = "End Trip"
            goto L59
        L56:
            r3 = 0
            java.lang.String r1 = ""
        L59:
            if (r3 == 0) goto L64
            ee.mtakso.driver.ui.base.mvvm.BaseViewModel r7 = r6.M()
            ee.mtakso.driver.ui.screens.order.v2.OrderViewModel r7 = (ee.mtakso.driver.ui.screens.order.v2.OrderViewModel) r7
            r7.M3(r3, r1)
        L64:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.order.v2.order.ui.OrderPanelFragment.W0(java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X0(OrderMenuData orderMenuData) {
        OrderMenuDialogFragment r02 = r0();
        if (r02 == null) {
            return;
        }
        r02.q0(orderMenuData.b());
        r02.p0(orderMenuData.a());
    }

    private final ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment k0() {
        ConfirmationDialog.Companion companion = ConfirmationDialog.f28256p;
        String string = getString(R.string.reminder_title);
        Intrinsics.e(string, "getString(R.string.reminder_title)");
        String string2 = getString(R.string.reminder_message);
        Intrinsics.e(string2, "getString(R.string.reminder_message)");
        String string3 = getString(R.string.reminder_start);
        Intrinsics.e(string3, "getString(R.string.reminder_start)");
        return ConfirmationDialog.Companion.b(companion, string, string2, string3, null, UiKitRoundButtonType.f36162l, getString(R.string.reminder_wait_for_client), this.f32400z, null, null, 392, null);
    }

    private final ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment l0() {
        ConfirmationDialog.Companion companion = ConfirmationDialog.f28256p;
        String string = getString(R.string.confirm_pickup_title);
        Intrinsics.e(string, "getString(R.string.confirm_pickup_title)");
        String string2 = getString(R.string.confirmation_pickup_message);
        Intrinsics.e(string2, "getString(R.string.confirmation_pickup_message)");
        String string3 = getString(R.string.yes_arrived);
        Intrinsics.e(string3, "getString(R.string.yes_arrived)");
        return ConfirmationDialog.Companion.b(companion, string, string2, string3, null, UiKitRoundButtonType.f36162l, getString(R.string.no), this.f32400z, null, null, 392, null);
    }

    private final ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment m0(long j8) {
        String string;
        ConfirmationDialog.Companion companion = ConfirmationDialog.f28256p;
        String string2 = getString(R.string.confirm_destination_change_title);
        Intrinsics.e(string2, "getString(R.string.confi…destination_change_title)");
        if (this.f32399y) {
            string = getString(R.string.confirm_final_destination_change_message);
        } else {
            string = getString(R.string.confirm_destination_change_message);
        }
        Intrinsics.e(string, "if (multipleDestinationE…ge_message)\n            }");
        String string3 = getString(R.string.confirm_destination_change_ok);
        Intrinsics.e(string3, "getString(R.string.confirm_destination_change_ok)");
        return ConfirmationDialog.Companion.b(companion, string2, string, string3, null, UiKitRoundButtonType.f36163m, getString(R.string.no), this.f32400z, BundleKt.a(TuplesKt.a("extra_stop_id", Long.valueOf(j8))), null, 264, null);
    }

    private final ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment n0() {
        ConfirmationDialog.Companion companion = ConfirmationDialog.f28256p;
        String string = getString(R.string.confirm_end_ride_md_title);
        Intrinsics.e(string, "getString(R.string.confirm_end_ride_md_title)");
        String string2 = getString(R.string.confirm_end_ride_md_message);
        Intrinsics.e(string2, "getString(R.string.confirm_end_ride_md_message)");
        String string3 = getString(R.string.yes_end_ride_md_lowercase);
        Intrinsics.e(string3, "getString(R.string.yes_end_ride_md_lowercase)");
        return ConfirmationDialog.Companion.b(companion, string, string2, string3, null, UiKitRoundButtonType.f36163m, getString(R.string.no), this.f32400z, null, null, 392, null);
    }

    private final ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment o0(long j8) {
        ConfirmationDialog.Companion companion = ConfirmationDialog.f28256p;
        String string = getString(R.string.confirm_select_stop_title);
        Intrinsics.e(string, "getString(R.string.confirm_select_stop_title)");
        String string2 = getString(R.string.confirm_select_stop_message);
        Intrinsics.e(string2, "getString(R.string.confirm_select_stop_message)");
        String string3 = getString(R.string.confirm_select_stop_ok);
        Intrinsics.e(string3, "getString(R.string.confirm_select_stop_ok)");
        UiKitRoundButtonType uiKitRoundButtonType = UiKitRoundButtonType.f36161k;
        String string4 = getString(R.string.no);
        Function3<DialogFragment, View, Object, Unit> function3 = this.f32400z;
        Bundle bundle = new Bundle();
        bundle.putLong("extra_stop_id", j8);
        Unit unit = Unit.f50853a;
        return ConfirmationDialog.Companion.b(companion, string, string2, string3, null, uiKitRoundButtonType, string4, function3, bundle, null, 264, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0(Long l8) {
        Long l9;
        OrderCommonData a8;
        OrderData f8 = M().E2().f();
        if (f8 != null && (a8 = f8.a()) != null) {
            l9 = a8.h();
        } else {
            l9 = null;
        }
        M().W2();
        ActivityResultLauncher<Intent> activityResultLauncher = this.A;
        SimpleActivity.Companion companion = SimpleActivity.f27004l;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        activityResultLauncher.launch(SimpleActivity.Companion.h(companion, requireContext, OrderDestinationFragment.class, OrderDestinationFragment.f31468q.a(l8, l9), false, 8, null));
    }

    static /* synthetic */ void q0(OrderPanelFragment orderPanelFragment, Long l8, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            l8 = null;
        }
        orderPanelFragment.p0(l8);
    }

    private final OrderMenuDialogFragment r0() {
        Fragment findFragmentByTag = getChildFragmentManager().findFragmentByTag("menu");
        if (findFragmentByTag instanceof OrderMenuDialogFragment) {
            return (OrderMenuDialogFragment) findFragmentByTag;
        }
        return null;
    }

    private final ConfirmationDialog s0(CancelWarningType cancelWarningType, Function3<? super DialogFragment, ? super View, Object, Unit> function3) {
        ConfirmationDialog.Companion companion = ConfirmationDialog.f28256p;
        String string = getString(R.string.cancel_warning_title);
        Intrinsics.e(string, "getString(R.string.cancel_warning_title)");
        CharSequence t02 = t0(cancelWarningType);
        String string2 = getString(R.string.cancel_order_warning_confirm);
        Intrinsics.e(string2, "getString(R.string.cancel_order_warning_confirm)");
        return ConfirmationDialog.Companion.b(companion, string, t02, string2, null, UiKitRoundButtonType.f36163m, getString(R.string.cancel_order_warning_dont_cancel), function3, null, null, 392, null);
    }

    private final CharSequence t0(CancelWarningType cancelWarningType) {
        if (cancelWarningType instanceof CancelWarningType.CampaignWarning) {
            String string = getString(R.string.cancel_warning_campaign);
            Intrinsics.e(string, "getString(R.string.cancel_warning_campaign)");
            return string;
        } else if (cancelWarningType instanceof CancelWarningType.DriverScoreAndCampaignWarning) {
            String string2 = getString(R.string.cancel_warning_driver_score_campaign);
            Intrinsics.e(string2, "getString(R.string.cance…ng_driver_score_campaign)");
            return string2;
        } else if (cancelWarningType instanceof CancelWarningType.DriverScoreWarning) {
            String string3 = getString(R.string.cancel_warning_driver_score);
            Intrinsics.e(string3, "getString(R.string.cancel_warning_driver_score)");
            return string3;
        } else if (cancelWarningType instanceof CancelWarningType.Confirmation) {
            return ((CancelWarningType.Confirmation) cancelWarningType).b();
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void u0() {
        OrderMenuDialogFragment r02 = r0();
        if (r02 != null) {
            r02.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(OrderPanelFragment this$0, Price it) {
        Intrinsics.f(this$0, "this$0");
        OrderMenuDialogFragment r02 = this$0.r0();
        if (r02 != null) {
            Intrinsics.e(it, "it");
            r02.t0(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(OrderPanelFragment this$0, ConfirmationSignal it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        R0(this$0, it, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(OrderPanelFragment this$0, List list) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.d(list, "null cannot be cast to non-null type java.util.ArrayList<ee.mtakso.driver.network.client.order.RejectReason>{ kotlin.collections.TypeAliasesKt.ArrayList<ee.mtakso.driver.network.client.order.RejectReason> }");
        this$0.U0((ArrayList) list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(OrderPanelFragment this$0, Unit unit) {
        Intrinsics.f(this$0, "this$0");
        this$0.O0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.screens.order.ordermenudialog.OrderMenuCallback
    public void A() {
        u0();
        M().g1();
    }

    @Override // ee.mtakso.driver.ui.screens.order.ordermenudialog.OrderMenuCallback
    public void B(long j8) {
        u0();
        if (((OrderData) LiveDataExtKt.b(M().E2())).b().n().size() > 1) {
            Q0(ConfirmationSignal.EDIT_DESTINATION, Long.valueOf(j8));
        } else {
            p0(Long.valueOf(j8));
        }
    }

    @Override // ee.mtakso.driver.ui.screens.order.ordermenudialog.OrderMenuCallback
    public void C() {
        M().d1();
        OrderMenuDialogFragment r02 = r0();
        if (r02 != null) {
            r02.v0();
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.B.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void G() {
        View shimmer_loading = d0(R.id.shimmer_loading);
        Intrinsics.e(shimmer_loading, "shimmer_loading");
        ViewExtKt.e(shimmer_loading, false, 0, 2, null);
        ConstraintLayout active_order_bottom_layout_content_parent = (ConstraintLayout) d0(R.id.active_order_bottom_layout_content_parent);
        Intrinsics.e(active_order_bottom_layout_content_parent, "active_order_bottom_layout_content_parent");
        ViewExtKt.e(active_order_bottom_layout_content_parent, true, 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: G0 */
    public OrderViewModel Q() {
        BaseUiDependencies E;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        E = E();
        return (OrderViewModel) new ViewModelProvider(requireActivity, E.d()).a(OrderViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void I() {
        OrderData f8 = M().E2().f();
        if (f8 instanceof OrderData.WaitingOnStopData) {
            AlphaAnimatedPlaceholderView alphaAnimatedPlaceholderView = (AlphaAnimatedPlaceholderView) d0(R.id.shimmer_loading).findViewById(R.id.active_order_client_name_loading);
            Intrinsics.e(alphaAnimatedPlaceholderView, "shimmer_loading.active_order_client_name_loading");
            ViewExtKt.e(alphaAnimatedPlaceholderView, false, 0, 2, null);
        } else if (f8 instanceof OrderData.DrivingWithClientData) {
            AlphaAnimatedPlaceholderView alphaAnimatedPlaceholderView2 = (AlphaAnimatedPlaceholderView) d0(R.id.shimmer_loading).findViewById(R.id.active_order_client_name_loading);
            Intrinsics.e(alphaAnimatedPlaceholderView2, "shimmer_loading.active_order_client_name_loading");
            ViewExtKt.e(alphaAnimatedPlaceholderView2, false, 0, 2, null);
        } else {
            AlphaAnimatedPlaceholderView alphaAnimatedPlaceholderView3 = (AlphaAnimatedPlaceholderView) d0(R.id.shimmer_loading).findViewById(R.id.active_order_client_name_loading);
            Intrinsics.e(alphaAnimatedPlaceholderView3, "shimmer_loading.active_order_client_name_loading");
            ViewExtKt.e(alphaAnimatedPlaceholderView3, true, 0, 2, null);
        }
        View shimmer_loading = d0(R.id.shimmer_loading);
        Intrinsics.e(shimmer_loading, "shimmer_loading");
        ViewExtKt.e(shimmer_loading, true, 0, 2, null);
        ConstraintLayout active_order_bottom_layout_content_parent = (ConstraintLayout) d0(R.id.active_order_bottom_layout_content_parent);
        Intrinsics.e(active_order_bottom_layout_content_parent, "active_order_bottom_layout_content_parent");
        ViewExtKt.e(active_order_bottom_layout_content_parent, false, 0, 2, null);
    }

    public View d0(int i8) {
        View findViewById;
        Map<Integer, View> map = this.B;
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

    @Override // ee.mtakso.driver.ui.screens.order.ordermenudialog.OrderMenuCallback
    public void f() {
        u0();
        M().P3();
        M().v3();
    }

    @Override // ee.mtakso.driver.ui.screens.order.ordermenudialog.OrderMenuCallback
    public void g() {
        u0();
        R0(this, ConfirmationSignal.ARRIVE_TO_DESTINATION_MENU, null, 2, null);
    }

    @Override // ee.mtakso.driver.ui.screens.order.ordermenudialog.OrderMenuCallback
    public void h() {
        u0();
        RoutingManager.d(this.f32390p, WaybillFragment.f33614r.a(((OrderData) LiveDataExtKt.b(M().E2())).a().e()), false, 2, null);
    }

    @Override // ee.mtakso.driver.ui.screens.order.ordermenudialog.OrderMenuCallback
    public void i() {
        InfoDialog.Companion companion = InfoDialog.f28307n;
        String string = getString(R.string.share_ride_details);
        String string2 = getString(R.string.share_ride_details_description);
        String string3 = getString(R.string.close);
        Intrinsics.e(string3, "getString(R.string.close)");
        FragmentUtils.b(InfoDialog.Companion.b(companion, string, string2, string3, null, null, 16, null), this, "dialog_tag_share_trip");
        M().g3();
    }

    @Override // ee.mtakso.driver.ui.screens.order.ordermenudialog.OrderMenuCallback
    public void m(long j8) {
        u0();
        UpcomingStop upcomingStop = (UpcomingStop) CollectionsKt___CollectionsKt.Y(((OrderData) LiveDataExtKt.b(M().E2())).b().n());
        boolean z7 = false;
        if (upcomingStop != null && upcomingStop.b() == j8) {
            z7 = true;
        }
        if (z7) {
            return;
        }
        ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment o02 = o0(j8);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        FragmentUtils.c(o02, requireActivity, "REORDER_STOPS");
    }

    @Override // ee.mtakso.driver.ui.screens.order.ordermenudialog.OrderMenuCallback
    public void o() {
        u0();
        M().k3();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f32393s = null;
        this.f32394t = null;
        this.f32395u = null;
        this.f32396v = null;
        this.f32397w = null;
        this.f32398x = null;
        super.onDestroyView();
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        for (ConfirmationSignal confirmationSignal : ConfirmationSignal.values()) {
            RestoreableDialogFragment.Companion.b(RestoreableDialogFragment.f34751j, requireFragmentManager(), confirmationSignal.name(), this.f32400z, null, 8, null);
        }
        PaymentTypeDrawer paymentTypeDrawer = new PaymentTypeDrawer(view);
        this.f32393s = new GoingToPickupViewDelegate(view);
        this.f32394t = new WaitingForClientViewDelegate(view);
        this.f32395u = new DrivingWithClientViewDelegate(view, paymentTypeDrawer);
        this.f32396v = new BottomSheetStateDelegate(view);
        this.f32397w = new WaitingOnStopDelegate(view, paymentTypeDrawer);
        View findViewById = view.findViewById(R.id.stickyBannerContent);
        Intrinsics.e(findViewById, "view.stickyBannerContent");
        this.f32398x = new StickyBannerViewDelegate(findViewById);
        view.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.ui.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OrderPanelFragment.A0(OrderPanelFragment.this, view2);
            }
        });
        ((FrameLayout) d0(R.id.active_order_menu_button)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.ui.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OrderPanelFragment.B0(OrderPanelFragment.this, view2);
            }
        });
        ((TextView) d0(R.id.active_order_set_destination_name)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.ui.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OrderPanelFragment.C0(OrderPanelFragment.this, view2);
            }
        });
        ((SwipeButton) d0(R.id.active_order_swipe_button)).setOnRequestStateChangeListener(new Function1() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.ui.OrderPanelFragment$onViewCreated$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Void invoke(SwipeButton.State state) {
                OrderViewModel M;
                Intrinsics.f(state, "<anonymous parameter 0>");
                M = OrderPanelFragment.this.M();
                OrderViewModel.D3(M, false, 1, null);
                return null;
            }
        });
        ((ImageView) d0(R.id.active_order_payment_method)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.ui.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OrderPanelFragment.D0(OrderPanelFragment.this, view2);
            }
        });
        LiveData<OrderData> E2 = M().E2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<OrderData, Unit> function1 = new Function1<OrderData, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.ui.OrderPanelFragment$onViewCreated$7
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(OrderData it) {
                OrderPanelFragment orderPanelFragment = OrderPanelFragment.this;
                Intrinsics.e(it, "it");
                orderPanelFragment.T0(it);
                OrderPanelFragment.this.X0(it.b());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OrderData orderData) {
                b(orderData);
                return Unit.f50853a;
            }
        };
        E2.i(viewLifecycleOwner, new Observer() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.ui.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OrderPanelFragment.E0(Function1.this, obj);
            }
        });
        M().t2().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.ui.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OrderPanelFragment.F0(OrderPanelFragment.this, (BottomWidgetStates) obj);
            }
        });
        M().H2().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.ui.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OrderPanelFragment.v0(OrderPanelFragment.this, (Price) obj);
            }
        });
        M().u2().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.ui.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OrderPanelFragment.w0(OrderPanelFragment.this, (ConfirmationSignal) obj);
            }
        });
        M().Q2().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.ui.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OrderPanelFragment.x0(OrderPanelFragment.this, (List) obj);
            }
        });
        M().R2().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.ui.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OrderPanelFragment.y0(OrderPanelFragment.this, (Unit) obj);
            }
        });
        LiveData<CancelWarningType> S2 = M().S2();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<CancelWarningType, Unit> function12 = new Function1<CancelWarningType, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.ui.OrderPanelFragment$onViewCreated$13
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(CancelWarningType cancelWarningType) {
                OrderPanelFragment.this.P0(cancelWarningType);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CancelWarningType cancelWarningType) {
                b(cancelWarningType);
                return Unit.f50853a;
            }
        };
        S2.i(viewLifecycleOwner2, new Observer() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.ui.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OrderPanelFragment.z0(Function1.this, obj);
            }
        });
    }

    @Override // ee.mtakso.driver.ui.screens.order.ordermenudialog.OrderMenuCallback
    public void p() {
        u0();
        M().u1();
        M().Y2(false);
    }

    @Override // ee.mtakso.driver.ui.screens.order.ordermenudialog.OrderMenuCallback
    public void r() {
        u0();
        M().k3();
    }

    @Override // ee.mtakso.driver.ui.screens.order.ordermenudialog.OrderMenuCallback
    public void s() {
        u0();
        M().B3();
    }

    @Override // ee.mtakso.driver.ui.screens.order.ordermenudialog.OrderMenuCallback
    public void u() {
        u0();
        M().X0();
        M().Y2(true);
    }

    @Override // ee.mtakso.driver.ui.screens.order.ordermenudialog.OrderMenuCallback
    public void v() {
        u0();
        NavigatorChooserFragment.Companion companion = NavigatorChooserFragment.f30914t;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        companion.a(requireContext);
    }

    @Override // ee.mtakso.driver.ui.screens.order.ordermenudialog.OrderMenuCallback
    public void y() {
        u0();
        ContactMethodsBaseActivity.Companion companion = ContactMethodsBaseActivity.f27750n;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        Intent intent = new Intent(requireContext, ContactMethodsBaseActivity.class);
        intent.putExtra("dialog_class_argument", ContactOptionsFragment.class);
        intent.addFlags(268500992);
        requireContext.startActivity(intent);
    }
}
