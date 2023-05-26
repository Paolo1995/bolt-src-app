package ee.mtakso.driver.ui.screens.earnings.v3.landing;

import ee.mtakso.driver.R;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.ui.screens.earnings.v3.common.ChipModel;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverChipMapper;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverColorMapper;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverImageMapper;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverLinkAppearanceMapper;
import ee.mtakso.driver.ui.screens.earnings.v3.common.EarningsBalanceStateTypeMapper;
import ee.mtakso.driver.ui.screens.earnings.v3.common.StaticItemDelegate;
import ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsActivityChartItemDelegate;
import ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsActivityProgressItemDelegate;
import ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsActivityTextItemDelegate;
import ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsActivityTextWithImageItemDelegate;
import ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsBalanceItemDelegate;
import ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsPieChartItemDelegate;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.SubtitleItemDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Margins;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.driver.earnings.network.DriverChip;
import eu.bolt.driver.earnings.network.EarningLandingItem;
import eu.bolt.driver.earnings.network.EarningLandingScreen;
import eu.bolt.driver.earnings.network.EarningPieChartItem;
import eu.bolt.driver.earnings.network.EarningsActivityTile;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: EarningsLandingMapper.kt */
/* loaded from: classes3.dex */
public final class EarningsLandingMapper {

    /* renamed from: g  reason: collision with root package name */
    public static final Companion f29331g = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final DriverFeatures f29332a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverColorMapper f29333b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverImageMapper f29334c;

    /* renamed from: d  reason: collision with root package name */
    private final DriverChipMapper f29335d;

    /* renamed from: e  reason: collision with root package name */
    private final DriverLinkAppearanceMapper f29336e;

    /* renamed from: f  reason: collision with root package name */
    private final EarningsBalanceStateTypeMapper f29337f;

    /* compiled from: EarningsLandingMapper.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public EarningsLandingMapper(DriverFeatures driverFeatures, DriverColorMapper colorMapper, DriverImageMapper imageMapper, DriverChipMapper chipMapper, DriverLinkAppearanceMapper linkAppearanceMapper, EarningsBalanceStateTypeMapper balanceStateTypeMapper) {
        Intrinsics.f(driverFeatures, "driverFeatures");
        Intrinsics.f(colorMapper, "colorMapper");
        Intrinsics.f(imageMapper, "imageMapper");
        Intrinsics.f(chipMapper, "chipMapper");
        Intrinsics.f(linkAppearanceMapper, "linkAppearanceMapper");
        Intrinsics.f(balanceStateTypeMapper, "balanceStateTypeMapper");
        this.f29332a = driverFeatures;
        this.f29333b = colorMapper;
        this.f29334c = imageMapper;
        this.f29335d = chipMapper;
        this.f29336e = linkAppearanceMapper;
        this.f29337f = balanceStateTypeMapper;
    }

    private final ListModel b(String str, EarningsActivityTile.Chart chart) {
        int v7;
        int a8;
        Text.Value value = new Text.Value(chart.b());
        List<EarningsActivityTile.ChartBar> a9 = chart.a();
        v7 = CollectionsKt__IterablesKt.v(a9, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (EarningsActivityTile.ChartBar chartBar : a9) {
            a8 = MathKt__MathJVMKt.a(chartBar.b() * 100);
            arrayList.add(new EarningsActivityChartItemDelegate.Bar(a8, new Text.Value(chartBar.a())));
        }
        return new EarningsActivityChartItemDelegate.Model(str, value, arrayList, chart.c(), null, 16, null);
    }

    private final ListModel c(String str, EarningsActivityTile.Progress progress) {
        return new EarningsActivityProgressItemDelegate.Model(str, new Text.Value(progress.c()), new Text.Value(progress.e()), new Text.Value(progress.b()), progress.a(), progress.d(), null, 64, null);
    }

    private final ListModel d(String str, EarningsActivityTile.Text text) {
        return new EarningsActivityTextItemDelegate.Model(str, new Text.Value(text.b()), new Text.Value(text.d()), new Text.Value(text.a()), text.c(), null, 32, null);
    }

    private final ListModel e(String str, EarningsActivityTile.TextWithIcon textWithIcon) {
        return new EarningsActivityTextWithImageItemDelegate.Model(str, new Text.Value(textWithIcon.c()), new Text.Value(textWithIcon.b()), this.f29334c.a(textWithIcon.a()), textWithIcon.d(), null, 32, null);
    }

    private final ListModel f(String str, EarningLandingItem.BalanceItem balanceItem) {
        ChipModel chipModel;
        Text.Value value;
        Image a8 = this.f29334c.a(balanceItem.b());
        Text.Value value2 = new Text.Value(balanceItem.d());
        Color a9 = this.f29337f.a(balanceItem.a());
        DriverChip e8 = balanceItem.e();
        Text.Value value3 = null;
        if (e8 != null) {
            chipModel = this.f29335d.c(e8);
        } else {
            chipModel = null;
        }
        String c8 = balanceItem.c();
        if (c8 != null) {
            value = new Text.Value(c8);
        } else {
            value = null;
        }
        String g8 = balanceItem.g();
        if (g8 != null) {
            value3 = new Text.Value(g8);
        }
        return new EarningsBalanceItemDelegate.Model(str, a8, value2, a9, chipModel, value, value3, balanceItem.f());
    }

    private final ListModel g(String str, EarningLandingItem.PieChart pieChart) {
        Text.Value value;
        int v7;
        EarningsPieChartItemDelegate.Segment segment;
        String d8 = pieChart.d();
        if (d8 != null) {
            value = new Text.Value(d8);
        } else {
            value = null;
        }
        Text.Value value2 = new Text.Value(pieChart.c());
        List<EarningPieChartItem> a8 = pieChart.a();
        ArrayList arrayList = new ArrayList();
        for (EarningPieChartItem earningPieChartItem : a8) {
            Double a9 = earningPieChartItem.a();
            if (a9 != null) {
                segment = new EarningsPieChartItemDelegate.Segment((float) a9.doubleValue(), this.f29333b.a(earningPieChartItem.b()));
            } else {
                segment = null;
            }
            if (segment != null) {
                arrayList.add(segment);
            }
        }
        List<EarningPieChartItem> a10 = pieChart.a();
        v7 = CollectionsKt__IterablesKt.v(a10, 10);
        ArrayList arrayList2 = new ArrayList(v7);
        for (EarningPieChartItem earningPieChartItem2 : a10) {
            Color a11 = this.f29333b.a(earningPieChartItem2.b());
            Text.Value value3 = new Text.Value(earningPieChartItem2.d());
            Text.Value value4 = new Text.Value(earningPieChartItem2.c());
            if (!(!this.f29332a.u())) {
                value4 = null;
            }
            arrayList2.add(new EarningsPieChartItemDelegate.Legend(a11, value3, value4));
        }
        return new EarningsPieChartItemDelegate.Model(str, value, value2, arrayList, arrayList2, new Text.Value(pieChart.b().b()), this.f29336e.a(pieChart.b().a()), pieChart.b().c());
    }

    private final List<StaticItemDelegate.Model> h() {
        List<StaticItemDelegate.Model> n8;
        n8 = CollectionsKt__CollectionsKt.n(new StaticItemDelegate.Model.List("pie_chart_0", R.layout.delegate_item_earnings_pie_chart_stub, null, 4, null), new StaticItemDelegate.Model.List("balance_header_1", R.layout.delegate_item_subtitle_stub, null, 4, null), new StaticItemDelegate.Model.List("balance_1", R.layout.delegate_item_earnings_balance_stub, null, 4, null), new StaticItemDelegate.Model.List("activity_header_2", R.layout.delegate_item_subtitle_stub, null, 4, null), new StaticItemDelegate.Model.Grid("activity_chart_2_0", R.layout.delegate_item_earnings_activity_chart_stub, null, 4, null), new StaticItemDelegate.Model.Grid("activity_text_2_1", R.layout.delegate_item_earnings_activity_text_stub, null, 4, null));
        return n8;
    }

    public final List<ListModel> a(EarningLandingScreen earningLandingScreen) {
        Text resource;
        int c8;
        int c9;
        if (earningLandingScreen == null) {
            return h();
        }
        ArrayList arrayList = new ArrayList();
        int i8 = 0;
        for (Object obj : earningLandingScreen.a()) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            EarningLandingItem earningLandingItem = (EarningLandingItem) obj;
            if (earningLandingItem instanceof EarningLandingItem.PieChart) {
                arrayList.add(g("pie_chart_" + i8, (EarningLandingItem.PieChart) earningLandingItem));
            } else if (earningLandingItem instanceof EarningLandingItem.BalanceItem) {
                String str = "balance_header_" + i8;
                Text.Resource resource2 = new Text.Resource(R.string.balance, null, 2, null);
                int c10 = Dimens.c(16);
                if (i8 == 0) {
                    c9 = Dimens.c(16);
                } else {
                    c9 = Dimens.c(12);
                }
                arrayList.add(new SubtitleItemDelegate.Model(str, resource2, null, new Margins(c10, c9, Dimens.c(16), Dimens.c(4)), 4, null));
                arrayList.add(f("balance_" + i8, (EarningLandingItem.BalanceItem) earningLandingItem));
            } else if (earningLandingItem instanceof EarningLandingItem.ActivityItem) {
                EarningLandingItem.ActivityItem activityItem = (EarningLandingItem.ActivityItem) earningLandingItem;
                String b8 = activityItem.b();
                if (b8 != null) {
                    resource = new Text.Value(b8);
                } else {
                    resource = new Text.Resource(R.string.weekly_activity, null, 2, null);
                }
                String str2 = "activity_header_" + i8;
                int c11 = Dimens.c(16);
                if (i8 == 0) {
                    c8 = Dimens.c(16);
                } else {
                    c8 = Dimens.c(12);
                }
                arrayList.add(new SubtitleItemDelegate.Model(str2, resource, null, new Margins(c11, c8, Dimens.c(16), Dimens.c(4)), 4, null));
                int i10 = 0;
                for (Object obj2 : activityItem.a()) {
                    int i11 = i10 + 1;
                    if (i10 < 0) {
                        CollectionsKt__CollectionsKt.u();
                    }
                    EarningsActivityTile earningsActivityTile = (EarningsActivityTile) obj2;
                    if (earningsActivityTile instanceof EarningsActivityTile.Chart) {
                        arrayList.add(b("activity_chart_" + i8 + "_" + i10, (EarningsActivityTile.Chart) earningsActivityTile));
                    } else if (earningsActivityTile instanceof EarningsActivityTile.Text) {
                        arrayList.add(d("activity_text_" + i8 + "_" + i10, (EarningsActivityTile.Text) earningsActivityTile));
                    } else if (earningsActivityTile instanceof EarningsActivityTile.TextWithIcon) {
                        arrayList.add(e("activity_text_with_image_" + i8 + "_" + i10, (EarningsActivityTile.TextWithIcon) earningsActivityTile));
                    } else if (earningsActivityTile instanceof EarningsActivityTile.Progress) {
                        arrayList.add(c("activity_chart_" + i8 + "_" + i10, (EarningsActivityTile.Progress) earningsActivityTile));
                    } else {
                        Intrinsics.a(earningsActivityTile, EarningsActivityTile.Empty.f41456a);
                    }
                    i10 = i11;
                }
            } else {
                Intrinsics.a(earningLandingItem, EarningLandingItem.Empty.f41437a);
            }
            i8 = i9;
        }
        return arrayList;
    }
}
