package ee.mtakso.driver.ui.interactor.income.report;

import ee.mtakso.driver.network.client.generic.GenericItem;
import ee.mtakso.driver.network.client.generic.GenericSection;
import ee.mtakso.driver.ui.common.generictreeviewstate.GenericViewState;
import ee.mtakso.driver.ui.common.generictreeviewstate.GenericViewStateItem;
import ee.mtakso.driver.ui.common.generictreeviewstate.GenericViewStateTitle;
import ee.mtakso.driver.ui.common.generictreeviewstate.GenericViewTreeState;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReportItemsMapper.kt */
/* loaded from: classes3.dex */
public final class ReportItemsMapper {
    private final List<GenericViewTreeState.Node> a(int i8, GenericItem genericItem) {
        GenericViewState.Divider divider;
        ArrayList arrayList = new ArrayList();
        List<GenericItem> b8 = genericItem.b();
        if (b8 != null) {
            int i9 = 0;
            for (GenericItem genericItem2 : b8) {
                int i10 = i9 + 1;
                boolean z7 = true;
                int i11 = i8 + 1;
                if (i9 != b8.size() - 1) {
                    z7 = false;
                }
                if (z7) {
                    divider = null;
                } else {
                    divider = GenericViewState.Divider.ITEM;
                }
                GenericViewState.Divider divider2 = divider;
                arrayList.add(new GenericViewTreeState.Node("item_" + i9 + "_" + i11 + "_" + genericItem2.hashCode(), i11, new GenericViewStateItem(divider2, false, genericItem2.c(), genericItem2.a(), genericItem2.e(), genericItem2.d().d(), genericItem2.d().c(), genericItem2.d().b(), Intrinsics.a(genericItem2.d().a(), Boolean.TRUE), 2, null), a(i11, genericItem2)));
                i9 = i10;
            }
        }
        return arrayList;
    }

    private final GenericViewStateTitle b(GenericSection genericSection, int i8) {
        boolean z7;
        String b8 = genericSection.b();
        GenericViewState.Divider divider = null;
        if (b8 == null) {
            return null;
        }
        if (i8 == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7) {
            divider = GenericViewState.Divider.SECTION;
        }
        return new GenericViewStateTitle(b8, divider);
    }

    public final GenericViewTreeState c(List<GenericSection> sections) {
        GenericViewState.Divider divider;
        Intrinsics.f(sections, "sections");
        ArrayList arrayList = new ArrayList();
        int i8 = 0;
        for (GenericSection genericSection : sections) {
            int i9 = i8 + 1;
            GenericViewStateTitle b8 = b(genericSection, i8);
            if (b8 != null) {
                int hashCode = b8.hashCode();
                arrayList.add(new GenericViewTreeState.Node("title_" + i8 + "_" + hashCode, 0, b8, null, 8, null));
            }
            int i10 = 0;
            for (GenericItem genericItem : genericSection.a()) {
                int i11 = i10 + 1;
                boolean z7 = true;
                if (i10 != genericSection.a().size() - 1) {
                    z7 = false;
                }
                if (z7) {
                    divider = null;
                } else {
                    divider = GenericViewState.Divider.ITEM;
                }
                int hashCode2 = genericItem.hashCode();
                arrayList.add(new GenericViewTreeState.Node("item_" + i8 + "_" + i10 + "_" + hashCode2, 0, new GenericViewStateItem(divider, false, genericItem.c(), genericItem.a(), genericItem.e(), genericItem.d().d(), genericItem.d().c(), genericItem.d().b(), Intrinsics.a(genericItem.d().a(), Boolean.TRUE), 2, null), a(0, genericItem)));
                i10 = i11;
            }
            i8 = i9;
        }
        return new GenericViewTreeState(new GenericViewTreeState.Node("root", -1, null, arrayList));
    }
}
