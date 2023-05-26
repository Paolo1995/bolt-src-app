package ee.mtakso.driver.ui.interactor.income.report;

import ee.mtakso.driver.ui.common.generictreeviewstate.GenericViewTreeState;
import ee.mtakso.driver.utils.Optional;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReportPageData.kt */
/* loaded from: classes3.dex */
public final class ReportPageData {

    /* renamed from: a  reason: collision with root package name */
    private final GenericViewTreeState f26588a;

    /* renamed from: b  reason: collision with root package name */
    private final Optional<ChartData> f26589b;

    public ReportPageData(GenericViewTreeState reportView, Optional<ChartData> chart) {
        Intrinsics.f(reportView, "reportView");
        Intrinsics.f(chart, "chart");
        this.f26588a = reportView;
        this.f26589b = chart;
    }

    public final Optional<ChartData> a() {
        return this.f26589b;
    }

    public final GenericViewTreeState b() {
        return this.f26588a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ReportPageData) {
            ReportPageData reportPageData = (ReportPageData) obj;
            return Intrinsics.a(this.f26588a, reportPageData.f26588a) && Intrinsics.a(this.f26589b, reportPageData.f26589b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f26588a.hashCode() * 31) + this.f26589b.hashCode();
    }

    public String toString() {
        GenericViewTreeState genericViewTreeState = this.f26588a;
        Optional<ChartData> optional = this.f26589b;
        return "ReportPageData(reportView=" + genericViewTreeState + ", chart=" + optional + ")";
    }
}
