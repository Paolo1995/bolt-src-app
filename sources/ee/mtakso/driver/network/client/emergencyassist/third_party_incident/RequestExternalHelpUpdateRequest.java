package ee.mtakso.driver.network.client.emergencyassist.third_party_incident;

import com.google.gson.annotations.SerializedName;
import i0.a;

/* compiled from: RequestExternalHelpUpdateRequest.kt */
/* loaded from: classes3.dex */
public final class RequestExternalHelpUpdateRequest {
    @SerializedName("incident_id")

    /* renamed from: a  reason: collision with root package name */
    private final long f22210a;
    @SerializedName("lat")

    /* renamed from: b  reason: collision with root package name */
    private final double f22211b;
    @SerializedName("lng")

    /* renamed from: c  reason: collision with root package name */
    private final double f22212c;

    public RequestExternalHelpUpdateRequest(long j8, double d8, double d9) {
        this.f22210a = j8;
        this.f22211b = d8;
        this.f22212c = d9;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RequestExternalHelpUpdateRequest) {
            RequestExternalHelpUpdateRequest requestExternalHelpUpdateRequest = (RequestExternalHelpUpdateRequest) obj;
            return this.f22210a == requestExternalHelpUpdateRequest.f22210a && Double.compare(this.f22211b, requestExternalHelpUpdateRequest.f22211b) == 0 && Double.compare(this.f22212c, requestExternalHelpUpdateRequest.f22212c) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (((a.a(this.f22210a) * 31) + q1.a.a(this.f22211b)) * 31) + q1.a.a(this.f22212c);
    }

    public String toString() {
        long j8 = this.f22210a;
        double d8 = this.f22211b;
        double d9 = this.f22212c;
        return "RequestExternalHelpUpdateRequest(incidentId=" + j8 + ", lat=" + d8 + ", lng=" + d9 + ")";
    }
}
