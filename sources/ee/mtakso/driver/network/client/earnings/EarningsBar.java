package ee.mtakso.driver.network.client.earnings;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsChart.kt */
/* loaded from: classes3.dex */
public final class EarningsBar {
    @SerializedName("label_short")

    /* renamed from: a  reason: collision with root package name */
    private final String f22094a;
    @SerializedName("label")

    /* renamed from: b  reason: collision with root package name */
    private final String f22095b;
    @SerializedName("expenses")

    /* renamed from: c  reason: collision with root package name */
    private final float f22096c;
    @SerializedName("net")

    /* renamed from: d  reason: collision with root package name */
    private final float f22097d;

    public final float a() {
        return this.f22096c;
    }

    public final String b() {
        return this.f22095b;
    }

    public final float c() {
        return this.f22097d;
    }

    public final String d() {
        return this.f22094a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EarningsBar) {
            EarningsBar earningsBar = (EarningsBar) obj;
            return Intrinsics.a(this.f22094a, earningsBar.f22094a) && Intrinsics.a(this.f22095b, earningsBar.f22095b) && Float.compare(this.f22096c, earningsBar.f22096c) == 0 && Float.compare(this.f22097d, earningsBar.f22097d) == 0;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f22094a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f22095b;
        return ((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Float.floatToIntBits(this.f22096c)) * 31) + Float.floatToIntBits(this.f22097d);
    }

    public String toString() {
        String str = this.f22094a;
        String str2 = this.f22095b;
        float f8 = this.f22096c;
        float f9 = this.f22097d;
        return "EarningsBar(shortLabel=" + str + ", label=" + str2 + ", expenses=" + f8 + ", net=" + f9 + ")";
    }
}
