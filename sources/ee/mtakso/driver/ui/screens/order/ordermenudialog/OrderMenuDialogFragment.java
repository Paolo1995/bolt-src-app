package ee.mtakso.driver.ui.screens.order.ordermenudialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentFactory;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.order.Price;
import ee.mtakso.driver.network.client.order.UpcomingStop;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.modules.order.v2.OrderTracker;
import ee.mtakso.driver.ui.screens.dialogs.ConfirmationDialog;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverInfoBlockMapper;
import ee.mtakso.driver.ui.screens.order.add_stop.AddStopBottomSheetDialogFragment;
import ee.mtakso.driver.ui.screens.order.ordermenudialog.Destination;
import ee.mtakso.driver.ui.screens.order.ordermenudialog.OrderMenuDialogData;
import ee.mtakso.driver.ui.screens.order.ordermenudialog.OrderMenuDialogFragment;
import ee.mtakso.driver.ui.screens.order.v2.order.BackToBackState;
import ee.mtakso.driver.uicore.components.dialogs.BaseScrollableBottomSheetDialogFragment;
import ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.ButtonItemDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.DividerDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.InfoBlockDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.MultipleButtonDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemTextDelegate;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Margins;
import ee.mtakso.driver.uikit.utils.Padding;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonSize;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import ee.mtakso.driver.utils.ext.FragmentFactoryUtils;
import eu.bolt.driver.earnings.network.DriverInfoBlock;
import j$.util.Spliterator;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: OrderMenuDialogFragment.kt */
/* loaded from: classes3.dex */
public final class OrderMenuDialogFragment extends BaseScrollableBottomSheetDialogFragment {
    public static final Companion F = new Companion(null);
    private static final int G = Dimens.c(8);
    private ListModel A;
    private final Lazy B;
    private final Lazy C;
    private final boolean D;
    public Map<Integer, View> E;

    /* renamed from: q  reason: collision with root package name */
    private final DriverProvider f31552q;

    /* renamed from: r  reason: collision with root package name */
    private final FragmentFactory f31553r;

    /* renamed from: s  reason: collision with root package name */
    private final OrderMenuDialogMapper f31554s;

    /* renamed from: t  reason: collision with root package name */
    private final OrderTracker f31555t;

    /* renamed from: u  reason: collision with root package name */
    private final DriverInfoBlockMapper f31556u;

    /* renamed from: v  reason: collision with root package name */
    private final Lazy f31557v;

    /* renamed from: w  reason: collision with root package name */
    private final Function3<DialogFragment, View, Object, Unit> f31558w;

    /* renamed from: x  reason: collision with root package name */
    private final DiffAdapter f31559x;

    /* renamed from: y  reason: collision with root package name */
    private final List<OrderMenuDialogData> f31560y;

    /* renamed from: z  reason: collision with root package name */
    private final List<OrderMenuDialogData> f31561z;

    /* compiled from: OrderMenuDialogFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(String str, String navigatorName, List<UpcomingStop> list, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, boolean z7, BackToBackState b2bState, String str2, boolean z8, String str3, int i8, int i9, int i10, DriverInfoBlock driverInfoBlock) {
            Intrinsics.f(navigatorName, "navigatorName");
            Intrinsics.f(b2bState, "b2bState");
            Bundle bundle = new Bundle();
            bundle.putString("client_name", str);
            bundle.putString("navigation", navigatorName);
            bundle.putParcelableArrayList("stops", new ArrayList<>(list != null ? list : CollectionsKt__CollectionsKt.k()));
            bundle.putString("next_order_address", str2);
            bundle.putString("next_order_state", b2bState.name());
            Boolean bool6 = Boolean.TRUE;
            bundle.putBoolean("can_calculate_price", Intrinsics.a(bool, bool6));
            bundle.putBoolean("can_cancel_order", Intrinsics.a(bool2, bool6));
            bundle.putBoolean("can_show_waybill", Intrinsics.a(bool3, bool6));
            bundle.putBoolean("can_show_waybill", Intrinsics.a(bool3, bool6));
            bundle.putBoolean("can_change_destination", Intrinsics.a(bool4, bool6));
            bundle.putBoolean("have_matched_destination", Intrinsics.a(bool5, bool6));
            bundle.putBoolean("can_end_ride", z7);
            bundle.putBoolean("arg_trip_sharing_enabled", z8);
            bundle.putString("arg_order_summary", str3);
            bundle.putInt("max_number_stops", i8);
            bundle.putInt("number_stops", i9);
            bundle.putInt("max_number_intermediate_stops", i10);
            bundle.putParcelable("arg_driver_info_block", driverInfoBlock);
            return bundle;
        }
    }

    /* compiled from: OrderMenuDialogFragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f31562a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f31563b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f31564c;

        static {
            int[] iArr = new int[BackToBackState.values().length];
            try {
                iArr[BackToBackState.ENABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BackToBackState.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BackToBackState.UNAVAILABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f31562a = iArr;
            int[] iArr2 = new int[OrderMenuDialogData.OrderMenuSection.values().length];
            try {
                iArr2[OrderMenuDialogData.OrderMenuSection.CONTACT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[OrderMenuDialogData.OrderMenuSection.SHARE_TRIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[OrderMenuDialogData.OrderMenuSection.CANCEL_RIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[OrderMenuDialogData.OrderMenuSection.NAVIGATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[OrderMenuDialogData.OrderMenuSection.PRICE.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[OrderMenuDialogData.OrderMenuSection.WAYBILL.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[OrderMenuDialogData.OrderMenuSection.STOPS.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[OrderMenuDialogData.OrderMenuSection.CANCEL_NEXT_RIDE.ordinal()] = 8;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[OrderMenuDialogData.OrderMenuSection.MATCH_TO_DESTINATION.ordinal()] = 9;
            } catch (NoSuchFieldError unused12) {
            }
            f31563b = iArr2;
            int[] iArr3 = new int[OrderMenuDialogData.ButtonType.values().length];
            try {
                iArr3[OrderMenuDialogData.ButtonType.ADD_STOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr3[OrderMenuDialogData.ButtonType.END_RIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            f31564c = iArr3;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public OrderMenuDialogFragment(DriverProvider driverProvider, FragmentFactory fragmentFactory, OrderMenuDialogMapper orderMenuDialogMapper, OrderTracker orderTracker, DriverInfoBlockMapper driverInfoBlockMapper) {
        super(R.layout.fragment_order_menu, null, 2, null);
        Lazy b8;
        Lazy b9;
        Lazy b10;
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(fragmentFactory, "fragmentFactory");
        Intrinsics.f(orderMenuDialogMapper, "orderMenuDialogMapper");
        Intrinsics.f(orderTracker, "orderTracker");
        Intrinsics.f(driverInfoBlockMapper, "driverInfoBlockMapper");
        this.E = new LinkedHashMap();
        this.f31552q = driverProvider;
        this.f31553r = fragmentFactory;
        this.f31554s = orderMenuDialogMapper;
        this.f31555t = orderTracker;
        this.f31556u = driverInfoBlockMapper;
        b8 = LazyKt__LazyJVMKt.b(new Function0<OrderMenuCallback>() { // from class: ee.mtakso.driver.ui.screens.order.ordermenudialog.OrderMenuDialogFragment$callback$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final OrderMenuCallback invoke() {
                OrderMenuCallback d02;
                d02 = OrderMenuDialogFragment.this.d0();
                return d02;
            }
        });
        this.f31557v = b8;
        this.f31558w = new Function3<DialogFragment, View, Object, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.ordermenudialog.OrderMenuDialogFragment$onDialogConfirmationListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            public final void b(DialogFragment dialogFragment, View view, Object obj) {
                OrderTracker orderTracker2;
                OrderTracker orderTracker3;
                OrderMenuCallback g02;
                Intrinsics.f(dialogFragment, "dialogFragment");
                if (Intrinsics.a(obj, "confirm")) {
                    orderTracker3 = OrderMenuDialogFragment.this.f31555t;
                    orderTracker3.j("Cancel");
                    g02 = OrderMenuDialogFragment.this.g0();
                    g02.o();
                } else {
                    orderTracker2 = OrderMenuDialogFragment.this.f31555t;
                    orderTracker2.j("Don't Cancel");
                }
                dialogFragment.dismiss();
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit l(DialogFragment dialogFragment, View view, Object obj) {
                b(dialogFragment, view, obj);
                return Unit.f50853a;
            }
        };
        DiffAdapter diffAdapter = new DiffAdapter();
        diffAdapter.P(new TwoLinesItemDelegate(new OrderMenuDialogFragment$diffAdapter$1$1(this), new OrderMenuDialogFragment$diffAdapter$1$2(this), 0, null, 12, null));
        diffAdapter.P(new TwoLinesItemTextDelegate(new OrderMenuDialogFragment$diffAdapter$1$3(this), new OrderMenuDialogFragment$diffAdapter$1$4(this), new OrderMenuDialogFragment$diffAdapter$1$5(this)));
        diffAdapter.P(new MultipleButtonDelegate(new Function1<MultipleButtonDelegate.ButtonModel<OrderMenuDialogData.ButtonType>, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.ordermenudialog.OrderMenuDialogFragment$diffAdapter$1$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(MultipleButtonDelegate.ButtonModel<OrderMenuDialogData.ButtonType> it) {
                Intrinsics.f(it, "it");
                OrderMenuDialogFragment.this.j0(it.g());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MultipleButtonDelegate.ButtonModel<OrderMenuDialogData.ButtonType> buttonModel) {
                b(buttonModel);
                return Unit.f50853a;
            }
        }));
        diffAdapter.P(new ButtonItemDelegate(new Function1<ButtonItemDelegate.Model<OrderMenuDialogData.ButtonType>, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.ordermenudialog.OrderMenuDialogFragment$diffAdapter$1$7
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ButtonItemDelegate.Model<OrderMenuDialogData.ButtonType> it) {
                Intrinsics.f(it, "it");
                OrderMenuDialogFragment.this.j0(it.t());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ButtonItemDelegate.Model<OrderMenuDialogData.ButtonType> model) {
                b(model);
                return Unit.f50853a;
            }
        }));
        diffAdapter.P(new DividerDelegate());
        diffAdapter.P(new InfoBlockDelegate());
        this.f31559x = diffAdapter;
        this.f31560y = new ArrayList();
        this.f31561z = new ArrayList();
        b9 = LazyKt__LazyJVMKt.b(new Function0<List<? extends UpcomingStop>>() { // from class: ee.mtakso.driver.ui.screens.order.ordermenudialog.OrderMenuDialogFragment$stops$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends UpcomingStop> invoke() {
                List<? extends UpcomingStop> k8;
                ArrayList parcelableArrayList = OrderMenuDialogFragment.this.requireArguments().getParcelableArrayList("stops");
                if (parcelableArrayList == null) {
                    k8 = CollectionsKt__CollectionsKt.k();
                    return k8;
                }
                return parcelableArrayList;
            }
        });
        this.B = b9;
        b10 = LazyKt__LazyJVMKt.b(new Function0<DriverInfoBlock>() { // from class: ee.mtakso.driver.ui.screens.order.ordermenudialog.OrderMenuDialogFragment$infoBlock$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final DriverInfoBlock invoke() {
                return (DriverInfoBlock) OrderMenuDialogFragment.this.requireArguments().getParcelable("arg_driver_info_block");
            }
        });
        this.C = b10;
        this.D = true;
    }

    private final ListModel W() {
        boolean z7;
        List n8;
        boolean C = this.f31552q.q().C();
        boolean z8 = requireArguments().getBoolean("can_end_ride");
        if (requireArguments().getInt("max_number_stops") <= requireArguments().getInt("number_stops")) {
            z7 = true;
        } else {
            z7 = false;
        }
        boolean z9 = !i0().isEmpty();
        Margins margins = new Margins(0, Dimens.c(16), 0, Dimens.c(16), 5, null);
        if (!C && z8) {
            return new ButtonItemDelegate.Model("separator_id", new Text.Resource(R.string.button_end_ride_here, null, 2, null), Integer.valueOf((int) R.drawable.ic_stop_sign), null, UiKitRoundButtonSize.f36155i, UiKitRoundButtonType.f36164n, null, null, false, null, margins, OrderMenuDialogData.ButtonType.END_RIDE, false, null, null, 0.0f, false, false, 254920, null);
        } else if (C && z8 && z7) {
            return new ButtonItemDelegate.Model("separator_id", new Text.Resource(R.string.button_end_ride_here, null, 2, null), Integer.valueOf((int) R.drawable.ic_end_ride_24), null, UiKitRoundButtonSize.f36155i, UiKitRoundButtonType.f36163m, null, null, false, null, margins, OrderMenuDialogData.ButtonType.END_RIDE, false, null, null, 0.0f, false, false, 254920, null);
        } else if (C && z9 && !z8 && !z7) {
            Text.Resource resource = new Text.Resource(R.string.active_ride_add_stop, null, 2, null);
            UiKitRoundButtonType uiKitRoundButtonType = UiKitRoundButtonType.f36164n;
            UiKitRoundButtonSize uiKitRoundButtonSize = UiKitRoundButtonSize.f36155i;
            Context requireContext = requireContext();
            Intrinsics.e(requireContext, "requireContext()");
            return new ButtonItemDelegate.Model("separator_id", resource, Integer.valueOf((int) R.drawable.ic_wait_white), Integer.valueOf(ContextUtilsKt.d(requireContext, R.attr.contentPrimary)), uiKitRoundButtonSize, uiKitRoundButtonType, null, null, false, null, margins, OrderMenuDialogData.ButtonType.ADD_STOP, false, null, null, 0.0f, false, false, 254912, null);
        } else if (C && z9 && z8 && !z7) {
            Text.Resource resource2 = new Text.Resource(R.string.active_ride_add_stop, null, 2, null);
            Color.Attr attr = new Color.Attr(R.attr.contentPrimary);
            Context requireContext2 = requireContext();
            Intrinsics.e(requireContext2, "requireContext()");
            int d8 = ContextUtilsKt.d(requireContext2, R.attr.contentPrimary);
            UiKitRoundButtonType uiKitRoundButtonType2 = UiKitRoundButtonType.f36164n;
            UiKitRoundButtonSize uiKitRoundButtonSize2 = UiKitRoundButtonSize.f36155i;
            OrderMenuDialogData.ButtonType buttonType = OrderMenuDialogData.ButtonType.ADD_STOP;
            Margins margins2 = new Margins(0, 0, Dimens.c(16), 0, 11, null);
            int c8 = Dimens.c(180);
            Padding padding = new Padding(Dimens.c(16), Dimens.c(16), Dimens.c(16), Dimens.c(16));
            int c9 = Dimens.c(56);
            Text.Resource resource3 = new Text.Resource(R.string.active_ride_end_ride, null, 2, null);
            Color.Attr attr2 = new Color.Attr(R.attr.contentPrimary);
            Context requireContext3 = requireContext();
            Intrinsics.e(requireContext3, "requireContext()");
            int d9 = ContextUtilsKt.d(requireContext3, R.attr.dynamicWhite);
            n8 = CollectionsKt__CollectionsKt.n(new MultipleButtonDelegate.ButtonModel(resource2, attr, Integer.valueOf((int) R.drawable.ic_wait_white), Integer.valueOf(d8), uiKitRoundButtonSize2, uiKitRoundButtonType2, 2132017742, Integer.valueOf(c8), null, margins2, Integer.valueOf(c9), padding, buttonType, Spliterator.NONNULL, null), new MultipleButtonDelegate.ButtonModel(resource3, attr2, Integer.valueOf((int) R.drawable.ic_end_ride_24), Integer.valueOf(d9), uiKitRoundButtonSize2, UiKitRoundButtonType.f36163m, 2132017742, Integer.valueOf(Dimens.c(180)), null, new Margins(Dimens.c(16), 0, 0, 0, 14, null), Integer.valueOf(Dimens.c(56)), new Padding(Dimens.c(16), Dimens.c(16), Dimens.c(16), Dimens.c(16)), OrderMenuDialogData.ButtonType.END_RIDE, Spliterator.NONNULL, null));
            return new MultipleButtonDelegate.Model("separator_id", n8, null, 4, null);
        } else {
            return X();
        }
    }

    private final ListModel X() {
        return new DividerDelegate.Model("separator_id", G, 0, null, new Color.Attr(R.attr.backTertiary), 0, 0, 108, null);
    }

    private final List<OrderMenuDialogData> Y() {
        Text.Resource resource;
        ArrayList arrayList = new ArrayList();
        StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
        String string = getString(R.string.button_contact_driver);
        Intrinsics.e(string, "getString(R.string.button_contact_driver)");
        String format = String.format(string, Arrays.copyOf(new Object[]{requireArguments().getString("client_name")}, 1));
        Intrinsics.e(format, "format(format, *args)");
        arrayList.add(new OrderMenuDialogData(new Text.Value(format), null, null, null, OrderMenuDialogData.OrderMenuSection.CONTACT, false, 46, null));
        String string2 = requireContext().getString(R.string.active_ride_set_default_navigation);
        Intrinsics.e(string2, "requireContext().getStri…e_set_default_navigation)");
        String navigationName = requireArguments().getString("navigation", string2);
        if (!Intrinsics.a(navigationName, string2)) {
            resource = new Text.Resource(R.string.order_route_details_change_item, null, 2, null);
        } else {
            resource = null;
        }
        Intrinsics.e(navigationName, "navigationName");
        arrayList.add(new OrderMenuDialogData(new Text.Value(navigationName), null, resource, null, OrderMenuDialogData.OrderMenuSection.NAVIGATION, false, 42, null));
        if (requireArguments().getBoolean("can_calculate_price", false)) {
            arrayList.add(new OrderMenuDialogData(new Text.Resource(R.string.calculate_price, null, 2, null), null, null, null, OrderMenuDialogData.OrderMenuSection.PRICE, false, 46, null));
        }
        if (requireArguments().getBoolean("can_show_waybill", false)) {
            arrayList.add(new OrderMenuDialogData(new Text.Resource(R.string.waybill, null, 2, null), null, null, null, OrderMenuDialogData.OrderMenuSection.WAYBILL, false, 46, null));
        }
        if (requireArguments().getBoolean("have_matched_destination")) {
            arrayList.add(new OrderMenuDialogData(new Text.Resource(R.string.match_to_destination, null, 2, null), null, null, null, OrderMenuDialogData.OrderMenuSection.MATCH_TO_DESTINATION, false, 46, null));
        }
        return arrayList;
    }

    private final List<OrderMenuDialogData> Z() {
        ArrayList arrayList = new ArrayList();
        boolean z7 = requireArguments().getBoolean("arg_trip_sharing_enabled", false);
        boolean J = this.f31552q.q().J();
        boolean z8 = requireArguments().getBoolean("can_cancel_order");
        arrayList.addAll(a0());
        if (z7 && !J) {
            arrayList.add(new OrderMenuDialogData(new Text.Resource(R.string.share_ride_details, null, 2, null), null, null, null, OrderMenuDialogData.OrderMenuSection.SHARE_TRIP, false, 46, null));
        }
        if (z8) {
            arrayList.add(new OrderMenuDialogData(new Text.Resource(R.string.cancel_ride, null, 2, null), null, null, null, OrderMenuDialogData.OrderMenuSection.CANCEL_RIDE, false, 46, null));
        }
        return arrayList;
    }

    private final List<OrderMenuDialogData> a0() {
        int v7;
        boolean z7;
        boolean z8 = requireArguments().getBoolean("can_change_destination", true);
        List<UpcomingStop> i02 = i0();
        v7 = CollectionsKt__IterablesKt.v(i02, 10);
        ArrayList arrayList = new ArrayList(v7);
        int i8 = 0;
        for (Object obj : i02) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            UpcomingStop upcomingStop = (UpcomingStop) obj;
            Destination.StopType a8 = Destination.f31524d.a(i8, i0().size());
            Text b02 = b0(z8, a8);
            String a9 = upcomingStop.a();
            if (a9 == null) {
                a9 = getString(R.string.set_destination);
                Intrinsics.e(a9, "getString(R.string.set_destination)");
            }
            Text.Value value = new Text.Value(a9);
            OrderMenuDialogData.OrderMenuSection orderMenuSection = OrderMenuDialogData.OrderMenuSection.STOPS;
            ArrayList arrayList2 = arrayList;
            long b8 = upcomingStop.b();
            if (upcomingStop.a() != null) {
                z7 = true;
            } else {
                z7 = false;
            }
            arrayList = arrayList2;
            arrayList.add(new OrderMenuDialogData(value, null, b02, new Destination(b8, a8, z7), orderMenuSection, false, 34, null));
            i8 = i9;
        }
        return arrayList;
    }

    private final Text b0(boolean z7, Destination.StopType stopType) {
        if (!z7) {
            return null;
        }
        if (stopType != Destination.StopType.DESTINATION_ONLY && stopType != Destination.StopType.DESTINATION) {
            return null;
        }
        return new Text.Resource(R.string.order_route_details_change_item, null, 2, null);
    }

    private final InfoBlockDelegate.Model c0() {
        DriverInfoBlock h02 = h0();
        if (h02 != null) {
            DriverInfoBlockMapper driverInfoBlockMapper = this.f31556u;
            String d8 = h02.d();
            return driverInfoBlockMapper.b("info_block_" + d8, h02);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OrderMenuCallback d0() {
        FragmentActivity activity = getActivity();
        if (activity instanceof OrderMenuCallback) {
            return (OrderMenuCallback) activity;
        }
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof OrderMenuCallback) {
            return (OrderMenuCallback) parentFragment;
        }
        throw new IllegalStateException("Failed to find callback");
    }

    private final int e0() {
        boolean z7;
        int i8 = 0;
        for (OrderMenuDialogData orderMenuDialogData : this.f31561z) {
            if (orderMenuDialogData.h() == OrderMenuDialogData.OrderMenuSection.PRICE) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                i8++;
            } else {
                return i8;
            }
        }
        return -1;
    }

    private final String f0(Price price) {
        String b8 = price.b();
        String str = "";
        if (b8 != null) {
            str = ((Object) "") + b8;
        }
        BigDecimal c8 = price.c();
        if (c8 != null) {
            double doubleValue = c8.doubleValue();
            StringBuilder sb = new StringBuilder();
            sb.append((Object) str);
            sb.append(doubleValue);
            str = sb.toString();
        }
        String a8 = price.a();
        if (a8 != null) {
            return ((Object) str) + a8;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OrderMenuCallback g0() {
        return (OrderMenuCallback) this.f31557v.getValue();
    }

    private final DriverInfoBlock h0() {
        return (DriverInfoBlock) this.C.getValue();
    }

    private final List<UpcomingStop> i0() {
        return (List) this.B.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0(OrderMenuDialogData.ButtonType buttonType) {
        int i8;
        if (buttonType == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f31564c[buttonType.ordinal()];
        }
        if (i8 != 1) {
            if (i8 == 2) {
                g0().g();
                return;
            }
            return;
        }
        o0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0(TwoLinesItemDelegate.Model<OrderMenuDialogData> model) {
        OrderMenuDialogData.OrderMenuSection orderMenuSection;
        int i8;
        OrderMenuDialogData B;
        Destination c8;
        OrderMenuDialogData B2 = model.B();
        if (B2 != null) {
            orderMenuSection = B2.h();
        } else {
            orderMenuSection = null;
        }
        if (orderMenuSection == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f31563b[orderMenuSection.ordinal()];
        }
        if (i8 != 4) {
            if (i8 == 7 && (B = model.B()) != null && (c8 = B.c()) != null) {
                g0().B(c8.b());
                return;
            }
            return;
        }
        g0().v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0(TwoLinesItemDelegate.Model<OrderMenuDialogData> model) {
        OrderMenuDialogData.OrderMenuSection orderMenuSection;
        int i8;
        OrderMenuDialogData B = model.B();
        if (B != null) {
            orderMenuSection = B.h();
        } else {
            orderMenuSection = null;
        }
        if (orderMenuSection == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f31563b[orderMenuSection.ordinal()];
        }
        if (i8 == 2) {
            g0().i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0(TwoLinesItemDelegate.Model<OrderMenuDialogData> model) {
        OrderMenuDialogData.OrderMenuSection orderMenuSection;
        int i8;
        Destination c8;
        OrderMenuDialogData B = model.B();
        if (B != null) {
            orderMenuSection = B.h();
        } else {
            orderMenuSection = null;
        }
        if (orderMenuSection == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f31563b[orderMenuSection.ordinal()];
        }
        switch (i8) {
            case 1:
                g0().y();
                return;
            case 2:
                g0().f();
                return;
            case 3:
                g0().r();
                return;
            case 4:
                g0().s();
                return;
            case 5:
                g0().C();
                return;
            case 6:
                g0().h();
                return;
            case 7:
                OrderMenuDialogData B2 = model.B();
                if (B2 != null && (c8 = B2.c()) != null) {
                    if (!c8.a()) {
                        g0().B(c8.b());
                        return;
                    } else {
                        g0().m(c8.b());
                        return;
                    }
                }
                return;
            case 8:
                u0();
                return;
            case 9:
                g0().A();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(OrderMenuDialogFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final void o0() {
        int i8;
        Bundle arguments = getArguments();
        if (arguments != null) {
            i8 = arguments.getInt("max_number_intermediate_stops");
        } else {
            i8 = 0;
        }
        FragmentFactory fragmentFactory = this.f31553r;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        Fragment requireParentFragment = requireParentFragment();
        Intrinsics.e(requireParentFragment, "requireParentFragment()");
        FragmentUtils.b((AddStopBottomSheetDialogFragment) FragmentFactoryUtils.b(fragmentFactory, requireContext, AddStopBottomSheetDialogFragment.class, AddStopBottomSheetDialogFragment.f30977w.a(i8)), requireParentFragment, "tag_add_stop");
        dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(OrderMenuDialogFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.g0().p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(OrderMenuDialogFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.g0().u();
    }

    private final void u0() {
        ConfirmationDialog.Companion companion = ConfirmationDialog.f28256p;
        String string = getString(R.string.question_cancel_next_trip);
        Intrinsics.e(string, "getString(R.string.question_cancel_next_trip)");
        String string2 = getString(R.string.description_cancel_next_trip);
        Intrinsics.e(string2, "getString(R.string.description_cancel_next_trip)");
        String string3 = getString(R.string.action_cancel);
        Intrinsics.e(string3, "getString(R.string.action_cancel)");
        ConfirmationDialog b8 = ConfirmationDialog.Companion.b(companion, string, string2, string3, null, UiKitRoundButtonType.f36163m, getString(R.string.dont_cancel), this.f31558w, null, null, 392, null);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        FragmentUtils.c(b8, requireActivity, "cancel_next_ride");
    }

    private final void w0() {
        ArrayList arrayList = new ArrayList();
        InfoBlockDelegate.Model c02 = c0();
        if (c02 != null) {
            arrayList.add(c02);
        }
        List<ListModel> f8 = this.f31554s.f(this.f31560y);
        List<ListModel> f9 = this.f31554s.f(this.f31561z);
        if (i0().isEmpty()) {
            arrayList.addAll(f9);
            arrayList.add(X());
            arrayList.addAll(f8);
        } else {
            arrayList.addAll(f8);
            ListModel listModel = this.A;
            if (listModel != null) {
                arrayList.add(listModel);
            }
            arrayList.addAll(f9);
        }
        DiffAdapter.V(this.f31559x, arrayList, null, 2, null);
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseScrollableBottomSheetDialogFragment, ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment
    public void H() {
        this.E.clear();
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment
    protected boolean I() {
        return this.D;
    }

    public View O(int i8) {
        View findViewById;
        Map<Integer, View> map = this.E;
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
        setStyle(0, 2132017805);
    }

    @Override // ee.mtakso.driver.uicore.components.dialogs.BaseScrollableBottomSheetDialogFragment, ee.mtakso.driver.uicore.components.dialogs.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        boolean z7;
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        String string = requireArguments().getString("next_order_state", "DISABLED");
        Intrinsics.e(string, "requireArguments().getSt…SABLED.name\n            )");
        q0(BackToBackState.valueOf(string));
        String string2 = requireArguments().getString("arg_order_summary");
        int i8 = R.id.orderMenuSubtitle;
        TextView orderMenuSubtitle = (TextView) O(i8);
        Intrinsics.e(orderMenuSubtitle, "orderMenuSubtitle");
        if (string2 != null && string2.length() != 0) {
            z7 = false;
        } else {
            z7 = true;
        }
        ViewExtKt.e(orderMenuSubtitle, true ^ z7, 0, 2, null);
        ((TextView) O(i8)).setText(string2);
        int i9 = R.id.orderMenuRecyclerView;
        ((RecyclerView) O(i9)).setLayoutManager(new LinearLayoutManager(requireContext()));
        ((RecyclerView) O(i9)).h(new ListItemDividerDecoration(Dimens.b(24.0f)));
        ((RecyclerView) O(i9)).setAdapter(this.f31559x);
        this.f31560y.addAll(Z());
        this.f31561z.addAll(Y());
        this.A = W();
        w0();
        ((ImageView) O(R.id.cancelAction)).setOnClickListener(new View.OnClickListener() { // from class: w4.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OrderMenuDialogFragment.n0(OrderMenuDialogFragment.this, view2);
            }
        });
        RestoreableDialogFragment.Companion.b(RestoreableDialogFragment.f34751j, getChildFragmentManager(), "cancel_next_ride", this.f31558w, null, 8, null);
    }

    public final void p0(String str) {
        boolean z7;
        Iterator<OrderMenuDialogData> it = this.f31561z.iterator();
        int i8 = 0;
        while (true) {
            if (it.hasNext()) {
                if (it.next().h() == OrderMenuDialogData.OrderMenuSection.CANCEL_NEXT_RIDE) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z7) {
                    break;
                }
                i8++;
            } else {
                i8 = -1;
                break;
            }
        }
        if (str == null) {
            if (i8 >= 0) {
                this.f31561z.remove(i8);
                w0();
                return;
            }
            return;
        }
        OrderMenuDialogData orderMenuDialogData = new OrderMenuDialogData(new Text.Resource(R.string.title_cancel_next_trip, null, 2, null), new Text.Value(str), null, null, OrderMenuDialogData.OrderMenuSection.CANCEL_NEXT_RIDE, false, 44, null);
        if (i8 >= 0) {
            this.f31561z.set(i8, orderMenuDialogData);
        } else {
            this.f31561z.add(orderMenuDialogData);
        }
        w0();
    }

    public final void q0(BackToBackState state) {
        Intrinsics.f(state, "state");
        int i8 = R.id.enableDisableNewRequests;
        RoundButton enableDisableNewRequests = (RoundButton) O(i8);
        Intrinsics.e(enableDisableNewRequests, "enableDisableNewRequests");
        ViewExtKt.e(enableDisableNewRequests, !this.f31552q.q().i(), 0, 2, null);
        int i9 = WhenMappings.f31562a[state.ordinal()];
        if (i9 != 1) {
            if (i9 != 2) {
                if (i9 == 3) {
                    RoundButton enableDisableNewRequests2 = (RoundButton) O(i8);
                    Intrinsics.e(enableDisableNewRequests2, "enableDisableNewRequests");
                    ViewExtKt.e(enableDisableNewRequests2, false, 0, 2, null);
                    return;
                }
                return;
            }
            ((RoundButton) O(i8)).setText(R.string.button_enable_new_requests);
            ((RoundButton) O(i8)).setOnClickListener(new View.OnClickListener() { // from class: w4.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OrderMenuDialogFragment.s0(OrderMenuDialogFragment.this, view);
                }
            });
            return;
        }
        ((RoundButton) O(i8)).setText(R.string.button_stop_new_requests);
        ((RoundButton) O(i8)).setOnClickListener(new View.OnClickListener() { // from class: w4.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OrderMenuDialogFragment.r0(OrderMenuDialogFragment.this, view);
            }
        });
    }

    public final void t0(Price price) {
        Intrinsics.f(price, "price");
        int e02 = e0();
        if (e02 >= 0) {
            List<OrderMenuDialogData> list = this.f31561z;
            list.set(e02, OrderMenuDialogData.b(list.get(e02), null, null, new Text.Value(f0(price)), null, null, false, 27, null));
            w0();
        }
    }

    public final void v0() {
        int e02 = e0();
        if (e02 >= 0) {
            List<OrderMenuDialogData> list = this.f31561z;
            list.set(e02, OrderMenuDialogData.b(list.get(e02), null, null, null, null, null, true, 31, null));
            w0();
        }
    }
}
