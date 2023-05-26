package ee.mtakso.driver.ui.screens.earnings.v2.balance;

import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.interactor.income.report.ChartData;
import ee.mtakso.driver.ui.interactor.income.report.ReportPageData;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.chart.BarChartItemDelegate;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.utils.Optional;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReportPageMapper.kt */
/* loaded from: classes3.dex */
public final class ReportPageMapper {

    /* compiled from: ReportPageMapper.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f28569a;

        static {
            int[] iArr = new int[ChartData.Type.values().length];
            try {
                iArr[ChartData.Type.WITH_HIGHLIGHTED_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ChartData.Type.ORDINARY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f28569a = iArr;
        }
    }

    private final float a(ChartData chartData) {
        int i8 = WhenMappings.f28569a[chartData.f().ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return Dimens.c(2.0f);
            }
            throw new NoWhenBranchMatchedException();
        }
        return Dimens.c(3.0f);
    }

    public final List<ListModel> b(ReportPageData reportPageData, String key) {
        Intrinsics.f(reportPageData, "reportPageData");
        Intrinsics.f(key, "key");
        ArrayList arrayList = new ArrayList();
        Optional<ChartData> a8 = reportPageData.a();
        if (!a8.d()) {
            ChartData b8 = a8.b();
            Intrinsics.e(b8, "chartData.value");
            ChartData chartData = b8;
            String e8 = chartData.e();
            String c8 = chartData.c();
            arrayList.add(new BarChartItemDelegate.Model("bar_chart_for_" + key, e8, chartData.d(), c8, new Color.Attr(R.attr.dynamicNeutral01), Dimens.c(1.0f), new Color.Attr(R.attr.contentPrimary), 0.0f, new Color.Attr(R.attr.contentSecondary), new Color.Attr(R.attr.contentPrimary), 0.0f, chartData.b(), a(chartData), chartData.a(), null, 17536, null));
        }
        arrayList.addAll(reportPageData.b().f());
        return arrayList;
    }
}
