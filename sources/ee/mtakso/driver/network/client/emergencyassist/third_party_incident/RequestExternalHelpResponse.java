package ee.mtakso.driver.network.client.emergencyassist.third_party_incident;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RequestExternalHelpResponse.kt */
/* loaded from: classes3.dex */
public final class RequestExternalHelpResponse {
    @SerializedName("incident")

    /* renamed from: a  reason: collision with root package name */
    private final Incident f22209a;

    public final Incident a() {
        return this.f22209a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RequestExternalHelpResponse) && Intrinsics.a(this.f22209a, ((RequestExternalHelpResponse) obj).f22209a);
    }

    public int hashCode() {
        return this.f22209a.hashCode();
    }

    public String toString() {
        Incident incident = this.f22209a;
        return "RequestExternalHelpResponse(incident=" + incident + ")";
    }
}
