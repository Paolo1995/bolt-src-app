package eu.bolt.verification.sdk.internal;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class lp {
    @SerializedName("event")

    /* renamed from: a  reason: collision with root package name */
    private final String f44099a;

    public lp(String event) {
        Intrinsics.f(event, "event");
        this.f44099a = event;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof lp) && Intrinsics.a(this.f44099a, ((lp) obj).f44099a);
    }

    public int hashCode() {
        return this.f44099a.hashCode();
    }

    public String toString() {
        String str = this.f44099a;
        return "VerificationReportSdkEventRequest(event=" + str + ")";
    }
}
