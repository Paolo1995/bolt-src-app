package eu.bolt.verification.sdk.internal;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class qq {
    @SerializedName("data")

    /* renamed from: a  reason: collision with root package name */
    private final nq f44691a;

    public final nq a() {
        return this.f44691a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof qq) && Intrinsics.a(this.f44691a, ((qq) obj).f44691a);
    }

    public int hashCode() {
        return this.f44691a.hashCode();
    }

    public String toString() {
        nq nqVar = this.f44691a;
        return "VerificationUploadFileResponseWrapper(data=" + nqVar + ")";
    }
}
