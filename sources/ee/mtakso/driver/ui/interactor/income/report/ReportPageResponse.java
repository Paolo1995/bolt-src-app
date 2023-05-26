package ee.mtakso.driver.ui.interactor.income.report;

import ee.mtakso.driver.network.client.earnings.EarningsChartResponse;
import ee.mtakso.driver.network.client.earnings.ReportScreen;
import ee.mtakso.driver.utils.Optional;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReportPageResponse.kt */
/* loaded from: classes3.dex */
public final class ReportPageResponse {

    /* renamed from: a  reason: collision with root package name */
    private final Optional<EarningsChartResponse> f26601a;

    /* renamed from: b  reason: collision with root package name */
    private final ReportScreen f26602b;

    public ReportPageResponse(Optional<EarningsChartResponse> chart, ReportScreen report) {
        Intrinsics.f(chart, "chart");
        Intrinsics.f(report, "report");
        this.f26601a = chart;
        this.f26602b = report;
    }

    public final Optional<EarningsChartResponse> a() {
        return this.f26601a;
    }

    public final ReportScreen b() {
        return this.f26602b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ReportPageResponse) {
            ReportPageResponse reportPageResponse = (ReportPageResponse) obj;
            return Intrinsics.a(this.f26601a, reportPageResponse.f26601a) && Intrinsics.a(this.f26602b, reportPageResponse.f26602b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f26601a.hashCode() * 31) + this.f26602b.hashCode();
    }

    public String toString() {
        Optional<EarningsChartResponse> optional = this.f26601a;
        ReportScreen reportScreen = this.f26602b;
        return "ReportPageResponse(chart=" + optional + ", report=" + reportScreen + ")";
    }
}
