package ee.mtakso.driver.network.client.campaign;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignV2.kt */
/* loaded from: classes3.dex */
public final class ProgressCondition {
    @SerializedName("title")

    /* renamed from: a  reason: collision with root package name */
    private final String f21728a;
    @SerializedName("overview")

    /* renamed from: b  reason: collision with root package name */
    private final String f21729b;
    @SerializedName("status_brief")

    /* renamed from: c  reason: collision with root package name */
    private final String f21730c;
    @SerializedName("status_description")

    /* renamed from: d  reason: collision with root package name */
    private final String f21731d;
    @SerializedName("status_value")

    /* renamed from: e  reason: collision with root package name */
    private final double f21732e;
    @SerializedName("status_success")

    /* renamed from: f  reason: collision with root package name */
    private final boolean f21733f;

    public final String a() {
        return this.f21729b;
    }

    public final String b() {
        return this.f21730c;
    }

    public final String c() {
        return this.f21731d;
    }

    public final boolean d() {
        return this.f21733f;
    }

    public final double e() {
        return this.f21732e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ProgressCondition) {
            ProgressCondition progressCondition = (ProgressCondition) obj;
            return Intrinsics.a(this.f21728a, progressCondition.f21728a) && Intrinsics.a(this.f21729b, progressCondition.f21729b) && Intrinsics.a(this.f21730c, progressCondition.f21730c) && Intrinsics.a(this.f21731d, progressCondition.f21731d) && Double.compare(this.f21732e, progressCondition.f21732e) == 0 && this.f21733f == progressCondition.f21733f;
        }
        return false;
    }

    public final String f() {
        return this.f21728a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((this.f21728a.hashCode() * 31) + this.f21729b.hashCode()) * 31) + this.f21730c.hashCode()) * 31) + this.f21731d.hashCode()) * 31) + q1.a.a(this.f21732e)) * 31;
        boolean z7 = this.f21733f;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode + i8;
    }

    public String toString() {
        String str = this.f21728a;
        String str2 = this.f21729b;
        String str3 = this.f21730c;
        String str4 = this.f21731d;
        double d8 = this.f21732e;
        boolean z7 = this.f21733f;
        return "ProgressCondition(title=" + str + ", overview=" + str2 + ", statusBrief=" + str3 + ", statusDescription=" + str4 + ", statusValue=" + d8 + ", statusSuccess=" + z7 + ")";
    }
}
