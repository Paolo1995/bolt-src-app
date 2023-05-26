package ee.mtakso.driver.ui.screens.earnings.v3.breakdown;

import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.earnings.v3.breakdown.EarningsBreakdownPayoutStubDelegate;
import ee.mtakso.driver.ui.screens.earnings.v3.common.StaticItemDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.Divider;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Dimens;
import eu.bolt.driver.earnings.network.DriverListItem;
import eu.bolt.driver.earnings.network.DriverListItemWithNestedItems;
import eu.bolt.driver.earnings.network.EarningBreakdownPayoutSection;
import eu.bolt.driver.earnings.network.EarningBreakdownScreen;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* compiled from: EarningsBreakdownStubFactory.kt */
/* loaded from: classes3.dex */
public final class EarningsBreakdownStubFactory {
    public static /* synthetic */ List b(EarningsBreakdownStubFactory earningsBreakdownStubFactory, EarningBreakdownScreen earningBreakdownScreen, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            earningBreakdownScreen = null;
        }
        return earningsBreakdownStubFactory.a(earningBreakdownScreen);
    }

    public final List<ListModel> a(EarningBreakdownScreen earningBreakdownScreen) {
        Collection n8;
        List o02;
        int i8;
        List<ListModel> o03;
        EarningBreakdownPayoutSection c8;
        List<DriverListItem> a8;
        List<DriverListItemWithNestedItems> b8;
        int v7;
        int i9 = 0;
        if (earningBreakdownScreen != null && (b8 = earningBreakdownScreen.b()) != null) {
            v7 = CollectionsKt__IterablesKt.v(b8, 10);
            n8 = new ArrayList(v7);
            for (Object obj : b8) {
                int i10 = i9 + 1;
                if (i9 < 0) {
                    CollectionsKt__CollectionsKt.u();
                }
                DriverListItemWithNestedItems driverListItemWithNestedItems = (DriverListItemWithNestedItems) obj;
                n8.add(new StaticItemDelegate.Model.List("main_" + i9, R.layout.delegate_item_earnings_one_line_stub, new Divider(false, false, false, new Color.Attr(R.attr.dynamicNeutral01), new Color.Attr(R.attr.backPrimary), null, 39, null)));
                i9 = i10;
            }
        } else {
            n8 = CollectionsKt__CollectionsKt.n(new StaticItemDelegate.Model.List("main_0", R.layout.delegate_item_earnings_one_line_stub, new Divider(false, false, false, new Color.Attr(R.attr.dynamicNeutral01), new Color.Attr(R.attr.backPrimary), null, 39, null)), new StaticItemDelegate.Model.List("main_1", R.layout.delegate_item_earnings_one_line_stub, new Divider(false, false, false, new Color.Attr(R.attr.dynamicNeutral01), new Color.Attr(R.attr.backPrimary), null, 39, null)), new StaticItemDelegate.Model.List("main_2", R.layout.delegate_item_earnings_one_line_stub, new Divider(false, false, false, new Color.Attr(R.attr.dynamicNeutral01), new Color.Attr(R.attr.backPrimary), null, 39, null)));
        }
        o02 = CollectionsKt___CollectionsKt.o0(n8, new StaticItemDelegate.Model.List("footer", R.layout.delegate_item_earnings_breakdown_footer_stub, new Divider(false, false, false, null, new Color.Attr(R.attr.backTertiary), Float.valueOf(Dimens.b(8.0f)), 15, null)));
        if (earningBreakdownScreen != null && (c8 = earningBreakdownScreen.c()) != null && (a8 = c8.a()) != null) {
            i8 = a8.size();
        } else {
            i8 = 1;
        }
        o03 = CollectionsKt___CollectionsKt.o0(o02, new EarningsBreakdownPayoutStubDelegate.Model("payout", i8));
        return o03;
    }
}
