package eu.bolt.verification.sdk.internal;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class ko {
    @SerializedName("data")

    /* renamed from: a  reason: collision with root package name */
    private final jo f43901a;

    public final jo a() {
        return this.f43901a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ko) && Intrinsics.a(this.f43901a, ((ko) obj).f43901a);
    }

    public int hashCode() {
        return this.f43901a.hashCode();
    }

    public String toString() {
        jo joVar = this.f43901a;
        return "VerificationGetFlowDetailsResponseWrapper(data=" + joVar + ")";
    }
}
