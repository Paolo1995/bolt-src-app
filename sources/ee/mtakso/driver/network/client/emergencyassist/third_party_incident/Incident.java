package ee.mtakso.driver.network.client.emergencyassist.third_party_incident;

import com.google.gson.annotations.SerializedName;
import i0.a;

/* compiled from: Incident.kt */
/* loaded from: classes3.dex */
public final class Incident {
    @SerializedName("incident_id")

    /* renamed from: a  reason: collision with root package name */
    private final long f22208a;

    public final long a() {
        return this.f22208a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Incident) && this.f22208a == ((Incident) obj).f22208a;
    }

    public int hashCode() {
        return a.a(this.f22208a);
    }

    public String toString() {
        long j8 = this.f22208a;
        return "Incident(incident_id=" + j8 + ")";
    }
}
