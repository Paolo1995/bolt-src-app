package eu.bolt.driver.earnings.network;

import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SetEarningsGoalRequest.kt */
/* loaded from: classes5.dex */
public final class SetEarningsGoalRequest {
    @SerializedName("period_type")

    /* renamed from: a  reason: collision with root package name */
    private final String f41509a;
    @SerializedName("target")

    /* renamed from: b  reason: collision with root package name */
    private final BigDecimal f41510b;
    @SerializedName("expenses")

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, BigDecimal> f41511c;

    /* JADX WARN: Multi-variable type inference failed */
    public SetEarningsGoalRequest(String periodType, BigDecimal target, Map<String, ? extends BigDecimal> expenses) {
        Intrinsics.f(periodType, "periodType");
        Intrinsics.f(target, "target");
        Intrinsics.f(expenses, "expenses");
        this.f41509a = periodType;
        this.f41510b = target;
        this.f41511c = expenses;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SetEarningsGoalRequest) {
            SetEarningsGoalRequest setEarningsGoalRequest = (SetEarningsGoalRequest) obj;
            return Intrinsics.a(this.f41509a, setEarningsGoalRequest.f41509a) && Intrinsics.a(this.f41510b, setEarningsGoalRequest.f41510b) && Intrinsics.a(this.f41511c, setEarningsGoalRequest.f41511c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f41509a.hashCode() * 31) + this.f41510b.hashCode()) * 31) + this.f41511c.hashCode();
    }

    public String toString() {
        String str = this.f41509a;
        BigDecimal bigDecimal = this.f41510b;
        Map<String, BigDecimal> map = this.f41511c;
        return "SetEarningsGoalRequest(periodType=" + str + ", target=" + bigDecimal + ", expenses=" + map + ")";
    }
}
