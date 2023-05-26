package ee.mtakso.driver.uicore.components.views.chart;

import ee.mtakso.driver.uicore.components.views.chart.BarChartAdapter;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Bar.kt */
/* loaded from: classes5.dex */
public final class BarKt {
    public static final float a(Bar bar) {
        Intrinsics.f(bar, "<this>");
        return Math.abs(bar.g() - bar.b());
    }

    public static final Label b(BarChartAdapter.BarLabel barLabel) {
        if (barLabel == null) {
            return null;
        }
        return new Label(barLabel.a(), barLabel.b());
    }

    public static final float c(Bar bar) {
        Intrinsics.f(bar, "<this>");
        return Math.abs(bar.e() - bar.d());
    }
}
