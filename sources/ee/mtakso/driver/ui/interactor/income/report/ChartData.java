package ee.mtakso.driver.ui.interactor.income.report;

import ee.mtakso.driver.uicore.components.views.chart.BarChartAdapter;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChartData.kt */
/* loaded from: classes3.dex */
public final class ChartData {

    /* renamed from: a  reason: collision with root package name */
    private final Type f26576a;

    /* renamed from: b  reason: collision with root package name */
    private final String f26577b;

    /* renamed from: c  reason: collision with root package name */
    private final String f26578c;

    /* renamed from: d  reason: collision with root package name */
    private final String f26579d;

    /* renamed from: e  reason: collision with root package name */
    private final String f26580e;

    /* renamed from: f  reason: collision with root package name */
    private final List<BarChartAdapter.BarInfo> f26581f;

    /* compiled from: ChartData.kt */
    /* loaded from: classes3.dex */
    public enum Type {
        WITH_HIGHLIGHTED_VALUE,
        ORDINARY
    }

    public ChartData(Type type, String title, String str, String str2, String currencyTitle, List<BarChartAdapter.BarInfo> barInfos) {
        Intrinsics.f(type, "type");
        Intrinsics.f(title, "title");
        Intrinsics.f(currencyTitle, "currencyTitle");
        Intrinsics.f(barInfos, "barInfos");
        this.f26576a = type;
        this.f26577b = title;
        this.f26578c = str;
        this.f26579d = str2;
        this.f26580e = currencyTitle;
        this.f26581f = barInfos;
    }

    public final List<BarChartAdapter.BarInfo> a() {
        return this.f26581f;
    }

    public final String b() {
        return this.f26580e;
    }

    public final String c() {
        return this.f26578c;
    }

    public final String d() {
        return this.f26579d;
    }

    public final String e() {
        return this.f26577b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChartData) {
            ChartData chartData = (ChartData) obj;
            return this.f26576a == chartData.f26576a && Intrinsics.a(this.f26577b, chartData.f26577b) && Intrinsics.a(this.f26578c, chartData.f26578c) && Intrinsics.a(this.f26579d, chartData.f26579d) && Intrinsics.a(this.f26580e, chartData.f26580e) && Intrinsics.a(this.f26581f, chartData.f26581f);
        }
        return false;
    }

    public final Type f() {
        return this.f26576a;
    }

    public int hashCode() {
        int hashCode = ((this.f26576a.hashCode() * 31) + this.f26577b.hashCode()) * 31;
        String str = this.f26578c;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f26579d;
        return ((((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f26580e.hashCode()) * 31) + this.f26581f.hashCode();
    }

    public String toString() {
        Type type = this.f26576a;
        String str = this.f26577b;
        String str2 = this.f26578c;
        String str3 = this.f26579d;
        String str4 = this.f26580e;
        List<BarChartAdapter.BarInfo> list = this.f26581f;
        return "ChartData(type=" + type + ", title=" + str + ", expenses=" + str2 + ", net=" + str3 + ", currencyTitle=" + str4 + ", barInfos=" + list + ")";
    }
}
