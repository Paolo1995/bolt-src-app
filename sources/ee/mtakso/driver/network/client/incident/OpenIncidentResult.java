package ee.mtakso.driver.network.client.incident;

import com.google.gson.annotations.SerializedName;
import i0.a;

/* compiled from: OpenIncidentResult.kt */
/* loaded from: classes3.dex */
public final class OpenIncidentResult {
    @SerializedName("incident_id")

    /* renamed from: a  reason: collision with root package name */
    private final long f22274a;

    public final long a() {
        return this.f22274a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OpenIncidentResult) && this.f22274a == ((OpenIncidentResult) obj).f22274a;
    }

    public int hashCode() {
        return a.a(this.f22274a);
    }

    public String toString() {
        long j8 = this.f22274a;
        return "OpenIncidentResult(incidentId=" + j8 + ")";
    }
}
