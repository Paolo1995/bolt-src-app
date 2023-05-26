package ee.mtakso.driver.ui.screens.priority;

import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.priority.ContentItem;
import ee.mtakso.driver.network.client.priority.PreconditionItem;
import ee.mtakso.driver.network.client.priority.PreconditionSection;
import ee.mtakso.driver.network.client.priority.PriorityComponentItem;
import ee.mtakso.driver.network.client.priority.PriorityComponentsSection;
import ee.mtakso.driver.network.client.priority.PriorityPreconditionStyleEnum;
import ee.mtakso.driver.ui.common.mapping.InformationMessageMapper;
import ee.mtakso.driver.ui.common.mapping.SimpleTextMapper;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.DividerDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.HorizontalListDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.dashboard.DashboardItemDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.generic.GenericItemDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.generic.GenericTitleDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.utils.StringUtilsKt;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverPriorityMapper.kt */
/* loaded from: classes3.dex */
public final class DriverPriorityMapper {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f32516c = new Companion(null);

    /* renamed from: d  reason: collision with root package name */
    private static final int f32517d = Dimens.c(210);

    /* renamed from: a  reason: collision with root package name */
    private final InformationMessageMapper f32518a;

    /* renamed from: b  reason: collision with root package name */
    private final SimpleTextMapper f32519b;

    /* compiled from: DriverPriorityMapper.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public DriverPriorityMapper(InformationMessageMapper informationMessageMapper, SimpleTextMapper simpleTextMapper) {
        Intrinsics.f(informationMessageMapper, "informationMessageMapper");
        Intrinsics.f(simpleTextMapper, "simpleTextMapper");
        this.f32518a = informationMessageMapper;
        this.f32519b = simpleTextMapper;
    }

    private final DividerDelegate.Model a(String str) {
        return new DividerDelegate.Model(str, Dimens.c(8), 0, null, new Color.Attr(R.attr.backPrimary), 0, 0, 108, null);
    }

    private final DividerDelegate.Model b(String str) {
        return new DividerDelegate.Model(str, Dimens.c(8), 0, null, null, 0, 0, 124, null);
    }

    private final List<ListModel> c(PriorityComponentsSection priorityComponentsSection) {
        int v7;
        List<ListModel> n8;
        String b8 = priorityComponentsSection.b();
        int hashCode = priorityComponentsSection.hashCode();
        GenericTitleDelegate.Model k8 = k(b8, "title=_" + hashCode);
        List<PriorityComponentItem> a8 = priorityComponentsSection.a();
        v7 = CollectionsKt__IterablesKt.v(a8, 10);
        ArrayList arrayList = new ArrayList(v7);
        int i8 = 0;
        for (Object obj : a8) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            arrayList.add(d(i8, (PriorityComponentItem) obj));
            i8 = i9;
        }
        n8 = CollectionsKt__CollectionsKt.n(k8, new HorizontalListDelegate.Model("priority-components", arrayList, Dimens.c(92), null, null, null, null, null, 248, null));
        return n8;
    }

    private final DashboardItemDelegate.Model d(int i8, PriorityComponentItem priorityComponentItem) {
        boolean z7;
        String str = "component-" + i8;
        Text.Value value = new Text.Value(priorityComponentItem.b());
        Text.Value value2 = new Text.Value(priorityComponentItem.c());
        if (priorityComponentItem.a() != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        return new DashboardItemDelegate.Model(str, value, null, value2, 2, null, null, null, z7, f32517d, -1, null, priorityComponentItem, 2276, null);
    }

    private final List<ListModel> e(ContentItem contentItem) {
        List<ListModel> k8;
        List<ListModel> e8;
        List<ListModel> e9;
        List<ListModel> n8;
        if (contentItem instanceof ContentItem.Separator) {
            ContentItem.Separator separator = (ContentItem.Separator) contentItem;
            n8 = CollectionsKt__CollectionsKt.n(a("divider-pre" + separator.hashCode()), new DividerDelegate.Model("item-divider" + separator.hashCode(), Dimens.c(1), Dimens.c(72), new Color.Attr(R.attr.dynamicNeutral01), new Color.Attr(R.attr.backPrimary), Dimens.c(24), Dimens.c(24)), a("divider-post" + separator.hashCode()));
            return n8;
        }
        Text.Value value = null;
        if (contentItem instanceof ContentItem.Text) {
            SimpleTextMapper simpleTextMapper = this.f32519b;
            ContentItem.Text text = (ContentItem.Text) contentItem;
            String str = "item" + text.hashCode();
            CharSequence a8 = StringUtilsKt.a(text.a());
            if (a8 != null) {
                value = new Text.Value(a8);
            }
            e9 = CollectionsKt__CollectionsJVMKt.e(simpleTextMapper.b(value, str, new Color.Attr(R.attr.backPrimary)));
            return e9;
        } else if (contentItem instanceof ContentItem.Link) {
            SimpleTextMapper simpleTextMapper2 = this.f32519b;
            ContentItem.Link link = (ContentItem.Link) contentItem;
            String str2 = "link" + link.hashCode();
            CharSequence a9 = StringUtilsKt.a(link.b());
            if (a9 != null) {
                value = new Text.Value(a9);
            }
            e8 = CollectionsKt__CollectionsJVMKt.e(simpleTextMapper2.a(value, str2, new Color.Attr(R.attr.backPrimary), contentItem));
            return e8;
        } else {
            k8 = CollectionsKt__CollectionsKt.k();
            return k8;
        }
    }

    private final List<ListModel> f(List<? extends ContentItem> list) {
        int v7;
        List x7;
        List<ListModel> T;
        v7 = CollectionsKt__IterablesKt.v(list, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (ContentItem contentItem : list) {
            arrayList.add(e(contentItem));
        }
        x7 = CollectionsKt__IterablesKt.x(arrayList);
        T = CollectionsKt___CollectionsKt.T(x7);
        return T;
    }

    private final ListModel g(PreconditionItem preconditionItem) {
        boolean z7;
        GenericItemDelegate.PopupInfo popupInfo;
        int i8;
        Text.Value value;
        Image.Res res;
        CharSequence a8;
        if (preconditionItem.c() == PriorityPreconditionStyleEnum.FADED) {
            z7 = true;
        } else {
            z7 = false;
        }
        String a9 = preconditionItem.a();
        Image.Url url = null;
        if (a9 != null && (a8 = StringUtilsKt.a(a9)) != null) {
            String e8 = preconditionItem.e();
            String d8 = preconditionItem.d();
            if (d8 == null) {
                d8 = "";
            }
            popupInfo = new GenericItemDelegate.PopupInfo(e8, d8, R.color.purple700, a8, null, true, 16, null);
        } else {
            popupInfo = null;
        }
        String str = "item=_" + preconditionItem.hashCode();
        Text.Value value2 = new Text.Value(preconditionItem.e());
        int i9 = R.attr.contentTransparent;
        if (z7) {
            i8 = R.attr.contentTransparent;
        } else {
            i8 = R.attr.contentPrimary;
        }
        Color.Attr attr = new Color.Attr(i8);
        String d9 = preconditionItem.d();
        if (d9 != null) {
            value = new Text.Value(d9);
        } else {
            value = null;
        }
        if (!z7) {
            i9 = R.attr.contentSecondary;
        }
        Color.Attr attr2 = new Color.Attr(i9);
        Color.Attr attr3 = new Color.Attr(R.attr.backPrimary);
        if (popupInfo != null) {
            res = new Image.Res(R.drawable.ic_info);
        } else {
            res = null;
        }
        String b8 = preconditionItem.b();
        if (b8 != null) {
            url = new Image.Url(b8);
        }
        return new TwoLinesItemDelegate.Model(str, value2, 2132017739, attr, null, value, 2132017739, attr2, null, url, null, null, null, null, null, res, attr3, null, preconditionItem, false, 0, 0, false, null, null, Float.valueOf(0.0f), false, false, false, 498760976, null);
    }

    private final List<ListModel> i(PreconditionSection preconditionSection) {
        int v7;
        int v8;
        List x7;
        List o8;
        List<ListModel> n02;
        int m8;
        boolean z7;
        DividerDelegate.Model model;
        List p8;
        String b8 = preconditionSection.b();
        int hashCode = preconditionSection.hashCode();
        GenericTitleDelegate.Model k8 = k(b8, "title=_" + hashCode);
        List<PreconditionItem> a8 = preconditionSection.a();
        v7 = CollectionsKt__IterablesKt.v(a8, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (PreconditionItem preconditionItem : a8) {
            arrayList.add(g(preconditionItem));
        }
        v8 = CollectionsKt__IterablesKt.v(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(v8);
        int i8 = 0;
        for (Object obj : arrayList) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            ListModel listModel = (ListModel) obj;
            m8 = CollectionsKt__CollectionsKt.m(preconditionSection.a());
            if (i8 == m8) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                model = null;
            } else {
                model = new DividerDelegate.Model("message-divider" + i8, Dimens.c(1), 0, new Color.Res(R.color.neutral800), new Color.Res(R.color.neutral900), Dimens.c(24), Dimens.c(24), 4, null);
            }
            p8 = CollectionsKt__CollectionsKt.p(listModel, model);
            arrayList2.add(p8);
            i8 = i9;
        }
        x7 = CollectionsKt__IterablesKt.x(arrayList2);
        o8 = CollectionsKt__CollectionsKt.o(k8);
        n02 = CollectionsKt___CollectionsKt.n0(o8, x7);
        return n02;
    }

    private final GenericTitleDelegate.Model k(String str, String str2) {
        return new GenericTitleDelegate.Model(str2, 0, str, null, false, false, false, null, null, null, 1016, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x001d, code lost:
        r2 = kotlin.collections.CollectionsKt__CollectionsKt.n(b("pre-message-divider"), ee.mtakso.driver.ui.common.mapping.InformationMessageMapper.b(r10.f32518a, r3, "LISTID_MESSAGE", null, 4, null));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<ee.mtakso.driver.uikit.recyclerview.ListModel> h(ee.mtakso.driver.network.client.priority.DriverPriorityResponse r11) {
        /*
            r10 = this;
            java.lang.String r0 = "details"
            kotlin.jvm.internal.Intrinsics.f(r11, r0)
            ee.mtakso.driver.network.client.priority.PrioritySummary r0 = r11.d()
            java.util.List r0 = r0.b()
            java.util.List r0 = r10.f(r0)
            java.lang.String r1 = "post-summary-divider"
            ee.mtakso.driver.uicore.components.recyclerview.delegates.common.DividerDelegate$Model r1 = r10.a(r1)
            ee.mtakso.driver.network.client.generic.InformationMessage r3 = r11.a()
            if (r3 == 0) goto L3d
            r2 = 2
            ee.mtakso.driver.uikit.recyclerview.ListModel[] r8 = new ee.mtakso.driver.uikit.recyclerview.ListModel[r2]
            r2 = 0
            java.lang.String r4 = "pre-message-divider"
            ee.mtakso.driver.uicore.components.recyclerview.delegates.common.DividerDelegate$Model r4 = r10.b(r4)
            r8[r2] = r4
            r9 = 1
            ee.mtakso.driver.ui.common.mapping.InformationMessageMapper r2 = r10.f32518a
            r5 = 0
            r6 = 4
            r7 = 0
            java.lang.String r4 = "LISTID_MESSAGE"
            ee.mtakso.driver.uikit.recyclerview.ListModel r2 = ee.mtakso.driver.ui.common.mapping.InformationMessageMapper.b(r2, r3, r4, r5, r6, r7)
            r8[r9] = r2
            java.util.List r2 = kotlin.collections.CollectionsKt.n(r8)
            if (r2 != 0) goto L41
        L3d:
            java.util.List r2 = kotlin.collections.CollectionsKt.k()
        L41:
            ee.mtakso.driver.network.client.priority.PreconditionSection r3 = r11.b()
            java.util.List r3 = kotlin.collections.CollectionsKt.e(r3)
            java.util.List r3 = r10.j(r3)
            ee.mtakso.driver.network.client.priority.PriorityComponentsSection r11 = r11.c()
            java.util.List r11 = r10.c(r11)
            java.util.List r0 = kotlin.collections.CollectionsKt.o0(r0, r1)
            java.util.List r0 = kotlin.collections.CollectionsKt.n0(r0, r3)
            java.util.List r0 = kotlin.collections.CollectionsKt.n0(r0, r2)
            java.util.List r11 = kotlin.collections.CollectionsKt.n0(r0, r11)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.priority.DriverPriorityMapper.h(ee.mtakso.driver.network.client.priority.DriverPriorityResponse):java.util.List");
    }

    public final List<ListModel> j(List<PreconditionSection> sections) {
        int v7;
        List<ListModel> x7;
        Intrinsics.f(sections, "sections");
        v7 = CollectionsKt__IterablesKt.v(sections, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (PreconditionSection preconditionSection : sections) {
            arrayList.add(i(preconditionSection));
        }
        x7 = CollectionsKt__IterablesKt.x(arrayList);
        return x7;
    }
}
