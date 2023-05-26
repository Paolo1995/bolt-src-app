package eu.bolt.verification.sdk.internal;

import com.google.gson.annotations.SerializedName;
import eu.bolt.verification.sdk.internal.io;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class bq {
    @SerializedName("flow_run_uuid")

    /* renamed from: a  reason: collision with root package name */
    private final String f42405a;
    @SerializedName("user_inputs")

    /* renamed from: b  reason: collision with root package name */
    private final List<io.a> f42406b;
    @SerializedName("step_uuid")

    /* renamed from: c  reason: collision with root package name */
    private final String f42407c;

    public bq(String flowRunUuid, List<io.a> userInputs, String stepId) {
        Intrinsics.f(flowRunUuid, "flowRunUuid");
        Intrinsics.f(userInputs, "userInputs");
        Intrinsics.f(stepId, "stepId");
        this.f42405a = flowRunUuid;
        this.f42406b = userInputs;
        this.f42407c = stepId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof bq) {
            bq bqVar = (bq) obj;
            return Intrinsics.a(this.f42405a, bqVar.f42405a) && Intrinsics.a(this.f42406b, bqVar.f42406b) && Intrinsics.a(this.f42407c, bqVar.f42407c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f42405a.hashCode() * 31) + this.f42406b.hashCode()) * 31) + this.f42407c.hashCode();
    }

    public String toString() {
        String str = this.f42405a;
        List<io.a> list = this.f42406b;
        String str2 = this.f42407c;
        return "VerificationSubmitDataRequest(flowRunUuid=" + str + ", userInputs=" + list + ", stepId=" + str2 + ")";
    }
}
