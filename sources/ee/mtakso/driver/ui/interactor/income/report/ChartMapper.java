package ee.mtakso.driver.ui.interactor.income.report;

import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.earnings.EarningsBar;
import ee.mtakso.driver.network.client.earnings.EarningsChartResponse;
import ee.mtakso.driver.network.client.earnings.EarningsInterval;
import ee.mtakso.driver.ui.interactor.income.report.ChartData;
import ee.mtakso.driver.uicore.components.views.chart.BarChartAdapter;
import ee.mtakso.driver.uicore.components.views.chart.BarSector;
import ee.mtakso.driver.uikit.utils.LocaleExtKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChartMapper.kt */
/* loaded from: classes3.dex */
public final class ChartMapper {

    /* compiled from: ChartMapper.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f26585a;

        static {
            int[] iArr = new int[ChartData.Type.values().length];
            try {
                iArr[ChartData.Type.ORDINARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ChartData.Type.WITH_HIGHLIGHTED_VALUE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f26585a = iArr;
        }
    }

    private final List<BarChartAdapter.BarInfo> a(List<EarningsInterval> list, ChartData.Type type, String str) {
        List<BarChartAdapter.BarInfo> f8;
        List<BarChartAdapter.BarInfo> r02;
        int i8 = WhenMappings.f26585a[type.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                f8 = e(list, str);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            f8 = f(list);
        }
        Locale locale = Locale.getDefault();
        Intrinsics.e(locale, "getDefault()");
        if (!LocaleExtKt.b(locale)) {
            r02 = CollectionsKt___CollectionsKt.r0(f8);
            return r02;
        }
        return f8;
    }

    private final BarChartAdapter.BarLabel c(String str, boolean z7) {
        return new BarChartAdapter.BarLabel(str, z7);
    }

    static /* synthetic */ BarChartAdapter.BarLabel d(ChartMapper chartMapper, String str, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        return chartMapper.c(str, z7);
    }

    private final List<BarChartAdapter.BarInfo> e(List<EarningsInterval> list, String str) {
        int v7;
        List e8;
        BarChartAdapter.BarLabel c8;
        BarChartAdapter.BarLabel barLabel;
        boolean z7;
        boolean z8;
        Iterator<EarningsInterval> it = list.iterator();
        int i8 = 0;
        while (true) {
            if (it.hasNext()) {
                if (Intrinsics.a(it.next().b(), str)) {
                    break;
                }
                i8++;
            } else {
                i8 = -1;
                break;
            }
        }
        int max = Math.max(i8 - 2, 0);
        int min = Math.min(i8 + 2, list.size() - 1);
        ArrayList<EarningsInterval> arrayList = new ArrayList();
        int i9 = 0;
        for (Object obj : list) {
            int i10 = i9 + 1;
            if (i9 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            EarningsInterval earningsInterval = (EarningsInterval) obj;
            if (max <= i9 && i9 <= min) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8) {
                arrayList.add(obj);
            }
            i9 = i10;
        }
        ArrayList arrayList2 = new ArrayList();
        for (EarningsInterval earningsInterval2 : arrayList) {
            CollectionsKt__MutableCollectionsKt.A(arrayList2, earningsInterval2.a());
        }
        int i11 = i8 - max;
        v7 = CollectionsKt__IterablesKt.v(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(v7);
        int i12 = 0;
        for (Object obj2 : arrayList2) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            EarningsBar earningsBar = (EarningsBar) obj2;
            float max2 = Math.max(earningsBar.c(), 0.0f);
            float a8 = earningsBar.a() + max2;
            if (earningsBar.a() < 0.0f) {
                a8 = earningsBar.a();
            }
            float f8 = a8;
            if (i12 == i11) {
                BarSector[] barSectorArr = new BarSector[2];
                BarSector barSector = new BarSector(R.attr.accentNeutralSecondary, earningsBar.a() / f8);
                if (earningsBar.a() > 0.0f) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (!z7) {
                    barSector = null;
                }
                barSectorArr[0] = barSector;
                barSectorArr[1] = new BarSector(R.attr.dynamicPurple02, max2 / f8);
                e8 = CollectionsKt__CollectionsKt.p(barSectorArr);
            } else {
                e8 = CollectionsKt__CollectionsJVMKt.e(new BarSector(R.attr.dynamicNeutral04, 1.0f));
            }
            List list2 = e8;
            if (earningsBar.b() == null) {
                barLabel = null;
            } else {
                if (earningsBar.d() != null && i12 != i11) {
                    c8 = c(earningsBar.d(), false);
                } else {
                    c8 = c(earningsBar.b(), true);
                }
                barLabel = c8;
            }
            arrayList3.add(new BarChartAdapter.BarInfo(0.0f, f8, i12, list2, barLabel, null, 32, null));
            i12 = i13;
        }
        return arrayList3;
    }

    private final List<BarChartAdapter.BarInfo> f(List<EarningsInterval> list) {
        int v7;
        BarChartAdapter.BarLabel barLabel;
        boolean z7;
        List p8;
        ArrayList arrayList = new ArrayList();
        for (EarningsInterval earningsInterval : list) {
            arrayList.addAll(earningsInterval.a());
        }
        v7 = CollectionsKt__IterablesKt.v(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(v7);
        int i8 = 0;
        for (Object obj : arrayList) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            EarningsBar earningsBar = (EarningsBar) obj;
            float max = Math.max(earningsBar.c(), 0.0f);
            float a8 = earningsBar.a() + max;
            if (earningsBar.a() < 0.0f) {
                a8 = earningsBar.a();
            }
            float f8 = a8;
            String b8 = earningsBar.b();
            BarSector barSector = null;
            if (b8 != null) {
                barLabel = d(this, b8, false, 2, null);
            } else {
                barLabel = null;
            }
            float f9 = i8;
            BarSector[] barSectorArr = new BarSector[2];
            BarSector barSector2 = new BarSector(R.attr.accentNeutralSecondary, earningsBar.a() / f8);
            if (earningsBar.a() > 0.0f) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                barSector = barSector2;
            }
            barSectorArr[0] = barSector;
            barSectorArr[1] = new BarSector(R.attr.dynamicPurple02, max / f8);
            p8 = CollectionsKt__CollectionsKt.p(barSectorArr);
            arrayList2.add(new BarChartAdapter.BarInfo(0.0f, f8, f9, p8, barLabel, null, 32, null));
            i8 = i9;
        }
        return arrayList2;
    }

    public final ChartData b(EarningsChartResponse model, String currentIntervalKey) {
        ChartData.Type type;
        Intrinsics.f(model, "model");
        Intrinsics.f(currentIntervalKey, "currentIntervalKey");
        List<EarningsInterval> b8 = model.b();
        Object obj = null;
        if (b8 == null) {
            return null;
        }
        if (b8.size() <= 1) {
            type = ChartData.Type.ORDINARY;
        } else {
            type = ChartData.Type.WITH_HIGHLIGHTED_VALUE;
        }
        ChartData.Type type2 = type;
        Iterator<T> it = b8.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (Intrinsics.a(((EarningsInterval) next).b(), currentIntervalKey)) {
                obj = next;
                break;
            }
        }
        EarningsInterval earningsInterval = (EarningsInterval) obj;
        if (earningsInterval != null) {
            return new ChartData(type2, earningsInterval.c().a(), earningsInterval.c().b(), earningsInterval.c().c(), model.a(), a(b8, type2, currentIntervalKey));
        }
        throw new IllegalStateException();
    }
}
