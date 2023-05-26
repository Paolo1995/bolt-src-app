package ee.mtakso.driver.network.client.earnings;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReportMode.kt */
/* loaded from: classes3.dex */
public final class EarningsReportPeriod {
    @SerializedName("key")

    /* renamed from: a  reason: collision with root package name */
    private final String f22110a;
    @SerializedName("label")

    /* renamed from: b  reason: collision with root package name */
    private final String f22111b;
    @SerializedName("default")

    /* renamed from: c  reason: collision with root package name */
    private final boolean f22112c;

    public final String a() {
        return this.f22110a;
    }

    public final String b() {
        return this.f22111b;
    }

    public final boolean c() {
        return this.f22112c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EarningsReportPeriod) {
            EarningsReportPeriod earningsReportPeriod = (EarningsReportPeriod) obj;
            return Intrinsics.a(this.f22110a, earningsReportPeriod.f22110a) && Intrinsics.a(this.f22111b, earningsReportPeriod.f22111b) && this.f22112c == earningsReportPeriod.f22112c;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.f22110a.hashCode() * 31) + this.f22111b.hashCode()) * 31;
        boolean z7 = this.f22112c;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode + i8;
    }

    public String toString() {
        String str = this.f22110a;
        String str2 = this.f22111b;
        boolean z7 = this.f22112c;
        return "EarningsReportPeriod(key=" + str + ", label=" + str2 + ", isDefault=" + z7 + ")";
    }
}
