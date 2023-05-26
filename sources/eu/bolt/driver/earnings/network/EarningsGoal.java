package eu.bolt.driver.earnings.network;

import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsGoal.kt */
/* loaded from: classes5.dex */
public final class EarningsGoal {
    @SerializedName("target")

    /* renamed from: a  reason: collision with root package name */
    private final BigDecimal f41491a;
    @SerializedName("period_type")

    /* renamed from: b  reason: collision with root package name */
    private final String f41492b;
    @SerializedName("expenses")

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, BigDecimal> f41493c;

    public final Map<String, BigDecimal> a() {
        return this.f41493c;
    }

    public final String b() {
        return this.f41492b;
    }

    public final BigDecimal c() {
        return this.f41491a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EarningsGoal) {
            EarningsGoal earningsGoal = (EarningsGoal) obj;
            return Intrinsics.a(this.f41491a, earningsGoal.f41491a) && Intrinsics.a(this.f41492b, earningsGoal.f41492b) && Intrinsics.a(this.f41493c, earningsGoal.f41493c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f41491a.hashCode() * 31) + this.f41492b.hashCode()) * 31) + this.f41493c.hashCode();
    }

    public String toString() {
        BigDecimal bigDecimal = this.f41491a;
        String str = this.f41492b;
        Map<String, BigDecimal> map = this.f41493c;
        return "EarningsGoal(target=" + bigDecimal + ", periodType=" + str + ", expenses=" + map + ")";
    }
}
