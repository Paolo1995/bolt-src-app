package ee.mtakso.driver.network.client.earnings;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsChart.kt */
/* loaded from: classes3.dex */
public final class EarningsIntervalTitle {
    @SerializedName("title")

    /* renamed from: a  reason: collision with root package name */
    private final String f22107a;
    @SerializedName("total_expenses")

    /* renamed from: b  reason: collision with root package name */
    private final String f22108b;
    @SerializedName("total_net")

    /* renamed from: c  reason: collision with root package name */
    private final String f22109c;

    public final String a() {
        return this.f22107a;
    }

    public final String b() {
        return this.f22108b;
    }

    public final String c() {
        return this.f22109c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EarningsIntervalTitle) {
            EarningsIntervalTitle earningsIntervalTitle = (EarningsIntervalTitle) obj;
            return Intrinsics.a(this.f22107a, earningsIntervalTitle.f22107a) && Intrinsics.a(this.f22108b, earningsIntervalTitle.f22108b) && Intrinsics.a(this.f22109c, earningsIntervalTitle.f22109c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f22107a.hashCode() * 31;
        String str = this.f22108b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f22109c;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        String str = this.f22107a;
        String str2 = this.f22108b;
        String str3 = this.f22109c;
        return "EarningsIntervalTitle(title=" + str + ", totalExpenses=" + str2 + ", totalNet=" + str3 + ")";
    }
}
