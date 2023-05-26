package ee.mtakso.driver.network.client.driver.surge;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SurgeResponse.kt */
/* loaded from: classes3.dex */
public final class SurgeResponse {
    @SerializedName("current")

    /* renamed from: a  reason: collision with root package name */
    private final CurrentSurge f22085a;

    public final CurrentSurge a() {
        return this.f22085a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SurgeResponse) && Intrinsics.a(this.f22085a, ((SurgeResponse) obj).f22085a);
    }

    public int hashCode() {
        return this.f22085a.hashCode();
    }

    public String toString() {
        CurrentSurge currentSurge = this.f22085a;
        return "SurgeResponse(currentSurge=" + currentSurge + ")";
    }
}
