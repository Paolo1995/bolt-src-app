package ee.mtakso.driver.network.client.contact;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContactConfigurationsResponse.kt */
/* loaded from: classes3.dex */
public final class ContactConfigurationsResponse {
    @SerializedName("configurations")

    /* renamed from: a  reason: collision with root package name */
    private final List<Map<String, String>> f21782a;

    public final List<Map<String, String>> a() {
        return this.f21782a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ContactConfigurationsResponse) && Intrinsics.a(this.f21782a, ((ContactConfigurationsResponse) obj).f21782a);
    }

    public int hashCode() {
        return this.f21782a.hashCode();
    }

    public String toString() {
        List<Map<String, String>> list = this.f21782a;
        return "ContactConfigurationsResponse(configurations=" + list + ")";
    }
}
