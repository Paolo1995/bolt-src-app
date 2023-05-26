package ee.mtakso.driver.ui.screens.earnings.v3.balance;

import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverInfoBlockMapper;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.Divider;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.NoDivider;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.SubtitleItemDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.driver.earnings.network.BalanceHistory;
import eu.bolt.driver.earnings.network.BalanceHistorySection;
import eu.bolt.driver.earnings.network.BalanceHistorySectionItem;
import eu.bolt.driver.earnings.network.DriverInfoBlock;
import eu.bolt.driver.earnings.network.DriverListItem;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsBalanceHistoryMapper.kt */
/* loaded from: classes3.dex */
public final class EarningsBalanceHistoryMapper {

    /* renamed from: a  reason: collision with root package name */
    private final EarningsBalanceHistoryItemMapper f28826a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverInfoBlockMapper f28827b;

    @Inject
    public EarningsBalanceHistoryMapper(EarningsBalanceHistoryItemMapper balanceHistoryItemMapper, DriverInfoBlockMapper infoBlockMapper) {
        Intrinsics.f(balanceHistoryItemMapper, "balanceHistoryItemMapper");
        Intrinsics.f(infoBlockMapper, "infoBlockMapper");
        this.f28826a = balanceHistoryItemMapper;
        this.f28827b = infoBlockMapper;
    }

    public final List<ListModel> a(BalanceHistory history) {
        DividerModel divider;
        Intrinsics.f(history, "history");
        ArrayList arrayList = new ArrayList();
        int i8 = 0;
        for (Object obj : history.b()) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            BalanceHistorySection balanceHistorySection = (BalanceHistorySection) obj;
            if (!balanceHistorySection.a().isEmpty()) {
                arrayList.add(new SubtitleItemDelegate.Model("section_title_page_" + history.a() + "_index_" + i8, new Text.Value(balanceHistorySection.b()), null, null, 12, null));
                int i10 = 0;
                for (Object obj2 : balanceHistorySection.a()) {
                    int i11 = i10 + 1;
                    if (i10 < 0) {
                        CollectionsKt__CollectionsKt.u();
                    }
                    BalanceHistorySectionItem balanceHistorySectionItem = (BalanceHistorySectionItem) obj2;
                    DriverInfoBlock a8 = balanceHistorySectionItem.a();
                    EarningsBalanceHistoryItemMapper earningsBalanceHistoryItemMapper = this.f28826a;
                    String str = "section_item_page_" + history.a() + "_index_" + i10;
                    DriverListItem b8 = balanceHistorySectionItem.b();
                    if (a8 == null || (divider = NoDivider.f34829a) == null) {
                        divider = new Divider(false, false, false, new Color.Attr(R.attr.dynamicNeutral01), null, null, 55, null);
                    }
                    arrayList.add(earningsBalanceHistoryItemMapper.a(str, b8, divider));
                    if (a8 != null) {
                        arrayList.add(this.f28827b.b("section_item_infoblock_page_" + history.a() + "_index_" + i10, a8));
                    }
                    i10 = i11;
                }
            }
            i8 = i9;
        }
        return arrayList;
    }
}
