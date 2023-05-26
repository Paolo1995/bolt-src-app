package ee.mtakso.driver.network.client.campaign;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignV2.kt */
/* loaded from: classes3.dex */
public final class Condition {
    @SerializedName("type")

    /* renamed from: a  reason: collision with root package name */
    private final ConditionType f21628a;
    @SerializedName("progress")

    /* renamed from: b  reason: collision with root package name */
    private final ProgressCondition f21629b;
    @SerializedName("threshold")

    /* renamed from: c  reason: collision with root package name */
    private final ThresholdCondition f21630c;

    public final ProgressCondition a() {
        return this.f21629b;
    }

    public final ThresholdCondition b() {
        return this.f21630c;
    }

    public final ConditionType c() {
        return this.f21628a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Condition) {
            Condition condition = (Condition) obj;
            return this.f21628a == condition.f21628a && Intrinsics.a(this.f21629b, condition.f21629b) && Intrinsics.a(this.f21630c, condition.f21630c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f21628a.hashCode() * 31;
        ProgressCondition progressCondition = this.f21629b;
        int hashCode2 = (hashCode + (progressCondition == null ? 0 : progressCondition.hashCode())) * 31;
        ThresholdCondition thresholdCondition = this.f21630c;
        return hashCode2 + (thresholdCondition != null ? thresholdCondition.hashCode() : 0);
    }

    public String toString() {
        ConditionType conditionType = this.f21628a;
        ProgressCondition progressCondition = this.f21629b;
        ThresholdCondition thresholdCondition = this.f21630c;
        return "Condition(type=" + conditionType + ", progress=" + progressCondition + ", threshold=" + thresholdCondition + ")";
    }
}
