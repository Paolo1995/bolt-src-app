package eu.bolt.verification.sdk.internal;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class yn implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    private final String f45772f;

    public yn(String flowRunUuid) {
        Intrinsics.f(flowRunUuid, "flowRunUuid");
        this.f45772f = flowRunUuid;
    }

    public final String a() {
        return this.f45772f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof yn) && Intrinsics.a(this.f45772f, ((yn) obj).f45772f);
    }

    public int hashCode() {
        return this.f45772f.hashCode();
    }

    public String toString() {
        String str = this.f45772f;
        return "VerificationFlowRibArgs(flowRunUuid=" + str + ")";
    }
}
