package eu.bolt.verification.sdk.internal;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class mq {
    @SerializedName("data")

    /* renamed from: a  reason: collision with root package name */
    private final lq f44223a;

    public final lq a() {
        return this.f44223a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof mq) && Intrinsics.a(this.f44223a, ((mq) obj).f44223a);
    }

    public int hashCode() {
        return this.f44223a.hashCode();
    }

    public String toString() {
        lq lqVar = this.f44223a;
        return "VerificationTriggerFlowResponseWrapper(data=" + lqVar + ")";
    }
}
