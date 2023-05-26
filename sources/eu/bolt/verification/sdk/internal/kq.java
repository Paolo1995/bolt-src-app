package eu.bolt.verification.sdk.internal;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class kq {
    @SerializedName("old_flow_run_id")

    /* renamed from: a  reason: collision with root package name */
    private final String f43909a;

    public kq(String flowUuid) {
        Intrinsics.f(flowUuid, "flowUuid");
        this.f43909a = flowUuid;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof kq) && Intrinsics.a(this.f43909a, ((kq) obj).f43909a);
    }

    public int hashCode() {
        return this.f43909a.hashCode();
    }

    public String toString() {
        String str = this.f43909a;
        return "VerificationTriggerFlowRequest(flowUuid=" + str + ")";
    }
}
