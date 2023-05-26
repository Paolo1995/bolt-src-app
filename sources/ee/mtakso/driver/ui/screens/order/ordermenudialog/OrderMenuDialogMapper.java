package ee.mtakso.driver.ui.screens.order.ordermenudialog;

import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.order.ordermenudialog.Destination;
import ee.mtakso.driver.ui.screens.order.ordermenudialog.OrderMenuDialogData;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Text;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderMenuDialogMapper.kt */
/* loaded from: classes3.dex */
public final class OrderMenuDialogMapper {

    /* compiled from: OrderMenuDialogMapper.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f31576a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f31577b;

        static {
            int[] iArr = new int[OrderMenuDialogData.OrderMenuSection.values().length];
            try {
                iArr[OrderMenuDialogData.OrderMenuSection.CANCEL_RIDE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OrderMenuDialogData.OrderMenuSection.STOPS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OrderMenuDialogData.OrderMenuSection.CONTACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[OrderMenuDialogData.OrderMenuSection.SHARE_TRIP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[OrderMenuDialogData.OrderMenuSection.NAVIGATION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[OrderMenuDialogData.OrderMenuSection.PRICE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[OrderMenuDialogData.OrderMenuSection.WAYBILL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[OrderMenuDialogData.OrderMenuSection.CANCEL_NEXT_RIDE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[OrderMenuDialogData.OrderMenuSection.MATCH_TO_DESTINATION.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            f31576a = iArr;
            int[] iArr2 = new int[Destination.StopType.values().length];
            try {
                iArr2[Destination.StopType.DESTINATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[Destination.StopType.DESTINATION_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[Destination.StopType.NEXT_STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[Destination.StopType.COMMON.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            f31577b = iArr2;
        }
    }

    private final TwoLinesItemDelegate.Indicator a(OrderMenuDialogData orderMenuDialogData) {
        if (orderMenuDialogData.d() != null) {
            return new TwoLinesItemDelegate.Indicator.Label(orderMenuDialogData.d(), 2132017739, new Color.Attr(R.attr.contentSecondary));
        }
        return null;
    }

    private final Color b(OrderMenuDialogData orderMenuDialogData) {
        Destination.StopType stopType;
        int i8;
        int i9 = WhenMappings.f31576a[orderMenuDialogData.h().ordinal()];
        if (i9 != 1) {
            if (i9 != 2) {
                if (i9 != 8) {
                    return new Color.Attr(R.attr.accentNeutral);
                }
                return new Color.Attr(R.attr.contentCritical);
            }
            Destination c8 = orderMenuDialogData.c();
            boolean z7 = false;
            if (c8 != null && !c8.a()) {
                z7 = true;
            }
            if (z7) {
                return new Color.Attr(R.attr.contentCritical);
            }
            if (c8 != null) {
                stopType = c8.c();
            } else {
                stopType = null;
            }
            if (stopType == null) {
                i8 = -1;
            } else {
                i8 = WhenMappings.f31577b[stopType.ordinal()];
            }
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 != 3) {
                        if (i8 != 4) {
                            return new Color.Attr(R.attr.dynamicNeutral04);
                        }
                        return new Color.Attr(R.attr.dynamicNeutral04);
                    }
                    return new Color.Attr(R.attr.linkAlternative);
                }
                return new Color.Attr(R.attr.accentRed);
            }
            return new Color.Attr(R.attr.dynamicNeutral04);
        }
        return new Color.Attr(R.attr.contentCritical);
    }

    private final Image c(OrderMenuDialogData.OrderMenuSection orderMenuSection) {
        if (WhenMappings.f31576a[orderMenuSection.ordinal()] == 4) {
            return new Image.Res(R.drawable.ic_info);
        }
        return null;
    }

    private final Image d(OrderMenuDialogData orderMenuDialogData) {
        switch (WhenMappings.f31576a[orderMenuDialogData.h().ordinal()]) {
            case 1:
                return new Image.Res(R.drawable.ic_cancel_red);
            case 2:
                Destination c8 = orderMenuDialogData.c();
                boolean z7 = true;
                if ((c8 == null || !c8.a()) ? false : false) {
                    return new Image.Res(R.drawable.ic_pin_fill_24dp);
                }
                return new Image.Res(R.drawable.ic_pin_alt_filled_24dp);
            case 3:
                return new Image.Res(R.drawable.ic_user_fill_24dp);
            case 4:
                return new Image.Res(R.drawable.ic_share);
            case 5:
                return new Image.Res(R.drawable.ic_my_location_fill);
            case 6:
                return new Image.Res(R.drawable.ic_card_order_menu);
            case 7:
                return new Image.Res(R.drawable.ic_card_order_menu);
            case 8:
                return new Image.Res(R.drawable.ic_cancel_red);
            case 9:
                return new Image.Res(R.drawable.ic_action_dd_dot_orange);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final Color e(OrderMenuDialogData orderMenuDialogData) {
        int i8 = WhenMappings.f31576a[orderMenuDialogData.h().ordinal()];
        boolean z7 = true;
        if (i8 != 1) {
            if (i8 != 2) {
                return new Color.Attr(R.attr.contentPrimary);
            }
            Destination c8 = orderMenuDialogData.c();
            if ((c8 == null || !c8.a()) ? false : false) {
                return new Color.Attr(R.attr.contentPrimary);
            }
            return new Color.Attr(R.attr.contentCritical);
        }
        return new Color.Attr(R.attr.contentCritical);
    }

    public final List<ListModel> f(List<OrderMenuDialogData> items) {
        int v7;
        int m8;
        boolean z7;
        Intrinsics.f(items, "items");
        v7 = CollectionsKt__IterablesKt.v(items, 10);
        ArrayList arrayList = new ArrayList(v7);
        int i8 = 0;
        for (Object obj : items) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            OrderMenuDialogData orderMenuDialogData = (OrderMenuDialogData) obj;
            String valueOf = String.valueOf(orderMenuDialogData.h());
            Text g8 = orderMenuDialogData.g();
            Color e8 = e(orderMenuDialogData);
            Text f8 = orderMenuDialogData.f();
            Color.Attr attr = new Color.Attr(R.attr.contentSecondary);
            TwoLinesItemDelegate.Indicator a8 = a(orderMenuDialogData);
            Image d8 = d(orderMenuDialogData);
            Color b8 = b(orderMenuDialogData);
            Color.Attr attr2 = new Color.Attr(R.attr.backPrimary);
            Color.Attr attr3 = new Color.Attr(R.attr.dynamicNeutral01);
            m8 = CollectionsKt__CollectionsKt.m(items);
            if (i8 != m8) {
                z7 = true;
            } else {
                z7 = false;
            }
            arrayList.add(new TwoLinesItemDelegate.Model(valueOf, g8, 2132017739, e8, null, f8, 2132017742, attr, b8, d8, null, null, null, null, null, c(orderMenuDialogData.h()), attr2, a8, orderMenuDialogData, false, 0, 0, z7, attr3, null, null, false, false, orderMenuDialogData.e(), 255360016, null));
            i8 = i9;
        }
        return arrayList;
    }
}
