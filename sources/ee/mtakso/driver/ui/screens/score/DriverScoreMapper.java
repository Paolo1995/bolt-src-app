package ee.mtakso.driver.ui.screens.score;

import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.generic.InformationMessage;
import ee.mtakso.driver.network.client.score.Action;
import ee.mtakso.driver.network.client.score.IssueGroup;
import ee.mtakso.driver.network.client.score.IssueItem;
import ee.mtakso.driver.network.client.score.RatingShownToRiders;
import ee.mtakso.driver.network.client.score.ScoreDetails;
import ee.mtakso.driver.network.client.score.ScoreReducingIssues;
import ee.mtakso.driver.network.client.score.Threshold;
import ee.mtakso.driver.network.client.score.TipItem;
import ee.mtakso.driver.network.client.score.TipsSection;
import ee.mtakso.driver.ui.common.HighlightTypeExtKt;
import ee.mtakso.driver.ui.common.mapping.InformationMessageMapper;
import ee.mtakso.driver.ui.screens.score.DriverScoreActionDelegate;
import ee.mtakso.driver.ui.screens.score.DriverScoreHeaderDelegate;
import ee.mtakso.driver.ui.screens.score.DriverScoreMoreDelegate;
import ee.mtakso.driver.ui.screens.score.DriverScoreRatingDelegate;
import ee.mtakso.driver.uicore.R$style;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.ItemHeaderDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.list.ItemOptionTextDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.list.ItemStyle;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Text;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverScoreMapper.kt */
/* loaded from: classes3.dex */
public final class DriverScoreMapper {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f32930b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final InformationMessageMapper f32931a;

    /* compiled from: DriverScoreMapper.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public DriverScoreMapper(InformationMessageMapper informationMessageMapper) {
        Intrinsics.f(informationMessageMapper, "informationMessageMapper");
        this.f32931a = informationMessageMapper;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void a(java.util.List<ee.mtakso.driver.uikit.recyclerview.ListModel> r34, java.util.List<ee.mtakso.driver.network.client.score.IssueItem> r35, int r36, boolean r37) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.score.DriverScoreMapper.a(java.util.List, java.util.List, int, boolean):void");
    }

    private final void b(List<ListModel> list, List<IssueGroup> list2) {
        boolean z7;
        Iterator it = list2.iterator();
        int i8 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            IssueGroup issueGroup = (IssueGroup) next;
            Iterator it2 = it;
            list.add(new TwoLinesItemDelegate.Model("SCORE_ISSUE_SECTION_" + i8, new Text.Value(issueGroup.c()), Integer.valueOf((int) R$style.TextAppearance_UIKit_BodyM_Semibold), new Color.Attr(R.attr.contentPrimary), Integer.valueOf(Dimens.c(16)), new Text.Value(issueGroup.b()), 2132017742, new Color.Attr(R.attr.contentSecondary), null, null, null, null, null, null, null, null, new Color.Attr(R.attr.backPrimary), null, issueGroup, false, 0, 0, false, null, null, Float.valueOf(Dimens.b(0.0f)), false, false, false, 498269952, null));
            List<IssueItem> a8 = issueGroup.a();
            if (a8 != null) {
                if (i9 == list2.size()) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                a(list, a8, i8, z7);
            }
            i8 = i9;
            it = it2;
        }
    }

    private final void c(List<ListModel> list, ScoreDetails scoreDetails) {
        List v02;
        double d8;
        double d9;
        double d10;
        int i8;
        double d11;
        double b8 = scoreDetails.g().b();
        double a8 = scoreDetails.g().a();
        double d12 = a8 - b8;
        double d13 = (scoreDetails.d() - b8) / d12;
        v02 = CollectionsKt___CollectionsKt.v0(scoreDetails.g().c(), new Comparator() { // from class: ee.mtakso.driver.ui.screens.score.DriverScoreMapper$addScoreDetails$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t7, T t8) {
                int a9;
                a9 = ComparisonsKt__ComparisonsKt.a(Double.valueOf(((Threshold) t7).d()), Double.valueOf(((Threshold) t8).d()));
                return a9;
            }
        });
        ArrayList arrayList = new ArrayList();
        Iterator it = v02.iterator();
        int i9 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            int i10 = i9 + 1;
            if (i9 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            Threshold threshold = (Threshold) next;
            if (i9 == 0) {
                d9 = threshold.d() - b8;
                d8 = d13;
            } else {
                d8 = d13;
                d9 = (threshold.d() - ((Threshold) v02.get(i9 - 1)).d()) / 2;
            }
            double d14 = d9;
            if (i9 == v02.size() - 1) {
                d10 = a8;
                d11 = a8 - threshold.d();
                i8 = 2;
            } else {
                d10 = a8;
                i8 = 2;
                d11 = (((Threshold) v02.get(i10)).d() - threshold.d()) / 2;
            }
            arrayList.add(new DriverScoreHeaderDelegate.Threshold(threshold.b(), threshold.a(), (threshold.d() - b8) / d12, (i8 * Math.min(d14, d11)) / d12, HighlightTypeExtKt.l(threshold.c()), HighlightTypeExtKt.n(threshold.c())));
            i9 = i10;
            it = it;
            a8 = d10;
            d13 = d8;
        }
        list.add(new DriverScoreHeaderDelegate.Model("SCORE_DETAILS", scoreDetails.f(), scoreDetails.e(), d13, HighlightTypeExtKt.j(scoreDetails.g().d()), arrayList));
        InformationMessage c8 = scoreDetails.c();
        if (c8 != null) {
            list.add(this.f32931a.a(c8, "SCORE_INFO_MESSAGE", new Color.Attr(R.attr.backPrimary)));
        }
        list.add(new DriverScoreMoreDelegate.Model("SCORE_FIND_OUT_MORE", scoreDetails.a(), scoreDetails.b(), null, 8, null));
    }

    private final void d(List<ListModel> list, ScoreReducingIssues scoreReducingIssues) {
        list.add(new ItemHeaderDelegate.Model("SCORE_REDUCING_ISSUES", scoreReducingIssues.b(), 2132017743, new Color.Attr(R.attr.contentSecondary), new Color.Res(R.color.transparent), Integer.valueOf(Dimens.c(12))));
        b(list, scoreReducingIssues.a());
    }

    private final void e(List<ListModel> list, TipsSection tipsSection) {
        ItemStyle itemStyle;
        list.add(new TwoLinesItemDelegate.Model("SCORE_TIPS_HEADER", new Text.Value(tipsSection.c()), Integer.valueOf((int) R$style.TextAppearance_UIKit_BodyM_Semibold), new Color.Attr(R.attr.contentPrimary), Integer.valueOf(Dimens.c(16)), new Text.Value(tipsSection.b()), 2132017742, new Color.Attr(R.attr.contentSecondary), null, null, null, null, null, null, null, null, new Color.Attr(R.attr.backPrimary), null, tipsSection, false, 0, 0, false, null, null, Float.valueOf(Dimens.b(0.0f)), false, false, false, 498269952, null));
        int i8 = 0;
        for (Object obj : tipsSection.a()) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            TipItem tipItem = (TipItem) obj;
            if (tipsSection.a().size() == i9) {
                itemStyle = ItemStyle.ENCLOSING;
            } else {
                itemStyle = ItemStyle.SIMPLE;
            }
            list.add(new ItemOptionTextDelegate.Model("SCORE_TIPS_ITEM_" + i8, tipItem.a(), null, null, itemStyle, null, 44, null));
            i8 = i9;
        }
    }

    private final ListModel f(Action action) {
        return new DriverScoreActionDelegate.Model("SCORE_ACTION", action, null, 4, null);
    }

    private final ListModel h(RatingShownToRiders ratingShownToRiders) {
        return new DriverScoreRatingDelegate.Model("SCORE_DRIVER_RATING", ratingShownToRiders.c(), ratingShownToRiders.a(), ratingShownToRiders.b());
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0017, code lost:
        r1 = kotlin.collections.CollectionsKt___CollectionsKt.A0(r1, 1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<ee.mtakso.driver.uikit.recyclerview.ListModel> g(ee.mtakso.driver.network.client.score.DriverScoreOverviewResponse r4) {
        /*
            r3 = this;
            java.lang.String r0 = "driverScoreOverview"
            kotlin.jvm.internal.Intrinsics.f(r4, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            ee.mtakso.driver.network.client.score.ScoreDetails r1 = r4.c()
            r3.c(r0, r1)
            java.util.List r1 = r4.a()
            if (r1 == 0) goto L2d
            r2 = 1
            java.util.List r1 = kotlin.collections.CollectionsKt.A0(r1, r2)
            if (r1 == 0) goto L2d
            java.lang.Object r1 = kotlin.collections.CollectionsKt.Y(r1)
            ee.mtakso.driver.network.client.score.Action r1 = (ee.mtakso.driver.network.client.score.Action) r1
            if (r1 == 0) goto L2d
            ee.mtakso.driver.uikit.recyclerview.ListModel r1 = r3.f(r1)
            r0.add(r1)
        L2d:
            ee.mtakso.driver.network.client.score.TipsSection r1 = r4.e()
            if (r1 == 0) goto L36
            r3.e(r0, r1)
        L36:
            ee.mtakso.driver.network.client.score.ScoreReducingIssues r1 = r4.d()
            if (r1 == 0) goto L3f
            r3.d(r0, r1)
        L3f:
            ee.mtakso.driver.network.client.score.RatingShownToRiders r4 = r4.b()
            if (r4 == 0) goto L4c
            ee.mtakso.driver.uikit.recyclerview.ListModel r4 = r3.h(r4)
            r0.add(r4)
        L4c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.score.DriverScoreMapper.g(ee.mtakso.driver.network.client.score.DriverScoreOverviewResponse):java.util.List");
    }
}
