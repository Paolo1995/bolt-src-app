package eu.bolt.verification.sdk.internal;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class lq extends dh {
    @SerializedName("flow_run_uuid")

    /* renamed from: d  reason: collision with root package name */
    private final String f44100d;

    public final String a() {
        return this.f44100d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof lq) && Intrinsics.a(this.f44100d, ((lq) obj).f44100d);
    }

    public int hashCode() {
        return this.f44100d.hashCode();
    }

    public String toString() {
        String str = this.f44100d;
        return "VerificationTriggerFlowResponse(flowRunUuid=" + str + ")";
    }
}
