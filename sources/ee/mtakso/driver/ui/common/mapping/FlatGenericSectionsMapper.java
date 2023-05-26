package ee.mtakso.driver.ui.common.mapping;

import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.generic.GenericItem;
import ee.mtakso.driver.network.client.generic.GenericSection;
import ee.mtakso.driver.network.client.generic.ValueMark;
import ee.mtakso.driver.network.client.generic.ValueStyle;
import ee.mtakso.driver.ui.common.generictreeviewstate.GenericViewStateItemKt;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.generic.GenericItemDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.generic.GenericTitleDelegate;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.utils.StringUtilsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FlatGenericSectionsMapper.kt */
/* loaded from: classes3.dex */
public final class FlatGenericSectionsMapper {
    private final ListModel a(GenericItem genericItem, boolean z7, boolean z8) {
        GenericItemDelegate.PopupInfo popupInfo;
        int i8;
        Text.Value value;
        float f8;
        float c8;
        CharSequence a8;
        CharSequence a9;
        ValueMark b8 = genericItem.d().b();
        ValueStyle c9 = genericItem.d().c();
        String a10 = genericItem.a();
        if (a10 != null && (a9 = StringUtilsKt.a(a10)) != null) {
            popupInfo = new GenericItemDelegate.PopupInfo(genericItem.c(), genericItem.d().d(), GenericViewStateItemKt.b(b8), a9, null, Intrinsics.a(genericItem.d().a(), Boolean.TRUE), 16, null);
        } else {
            popupInfo = null;
        }
        int i9 = R.color.transparent;
        if (z7) {
            i8 = R.color.black;
        } else if (!z8) {
            i8 = R.color.neutral800;
        } else {
            i8 = R.color.transparent;
        }
        Color.Res res = new Color.Res(i8);
        if (z7) {
            i9 = R.color.black;
        } else if (!z8) {
            i9 = R.color.neutral900;
        }
        Color.Res res2 = new Color.Res(i9);
        String str = "item=_" + genericItem.hashCode();
        Text.Value value2 = new Text.Value(genericItem.c());
        Color.Attr attr = new Color.Attr(R.attr.contentSecondary);
        Text.Value value3 = new Text.Value(genericItem.d().d());
        Color.Res res3 = new Color.Res(GenericViewStateItemKt.b(b8));
        GenericItemDelegate.TextStyle c10 = GenericViewStateItemKt.c(c9);
        String e8 = genericItem.e();
        if (e8 != null && (a8 = StringUtilsKt.a(e8)) != null) {
            value = new Text.Value(a8);
        } else {
            value = null;
        }
        Color.Attr attr2 = new Color.Attr(R.attr.backPrimary);
        boolean z9 = !z8;
        if (z7) {
            c8 = Dimens.c(8.0f);
        } else if (!z8) {
            c8 = Dimens.c(1.0f);
        } else {
            f8 = 0.0f;
            return new GenericItemDelegate.Model(str, value2, R.dimen.text_size_16, attr, value3, R.dimen.text_size_16, res3, attr2, value, null, c10, popupInfo, 0, z9, false, z7, res, res2, Float.valueOf(f8), 16384, null);
        }
        f8 = c8;
        return new GenericItemDelegate.Model(str, value2, R.dimen.text_size_16, attr, value3, R.dimen.text_size_16, res3, attr2, value, null, c10, popupInfo, 0, z9, false, z7, res, res2, Float.valueOf(f8), 16384, null);
    }

    private final List<ListModel> b(GenericSection genericSection, boolean z7) {
        GenericTitleDelegate.Model model;
        int v7;
        List o8;
        List<ListModel> n02;
        int m8;
        boolean z8;
        boolean z9;
        String b8 = genericSection.b();
        if (b8 != null) {
            int hashCode = genericSection.hashCode();
            model = new GenericTitleDelegate.Model("title=_" + hashCode, 0, b8, null, false, false, false, null, null, null, 1016, null);
        } else {
            model = null;
        }
        List<GenericItem> a8 = genericSection.a();
        v7 = CollectionsKt__IterablesKt.v(a8, 10);
        ArrayList arrayList = new ArrayList(v7);
        int i8 = 0;
        for (Object obj : a8) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            GenericItem genericItem = (GenericItem) obj;
            m8 = CollectionsKt__CollectionsKt.m(genericSection.a());
            boolean z10 = true;
            if (i8 == m8) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8 && !z7) {
                z9 = true;
            } else {
                z9 = false;
            }
            if (!z8 || !z7) {
                z10 = false;
            }
            arrayList.add(a(genericItem, z9, z10));
            i8 = i9;
        }
        o8 = CollectionsKt__CollectionsKt.o(model);
        n02 = CollectionsKt___CollectionsKt.n0(o8, arrayList);
        return n02;
    }

    public final List<ListModel> c(List<GenericSection> sections) {
        int v7;
        List<ListModel> x7;
        int m8;
        boolean z7;
        Intrinsics.f(sections, "sections");
        v7 = CollectionsKt__IterablesKt.v(sections, 10);
        ArrayList arrayList = new ArrayList(v7);
        int i8 = 0;
        for (Object obj : sections) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            GenericSection genericSection = (GenericSection) obj;
            m8 = CollectionsKt__CollectionsKt.m(sections);
            if (i8 == m8) {
                z7 = true;
            } else {
                z7 = false;
            }
            arrayList.add(b(genericSection, z7));
            i8 = i9;
        }
        x7 = CollectionsKt__IterablesKt.x(arrayList);
        return x7;
    }
}
