package ee.mtakso.driver.network.client.contact;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContactOptionsDetailsResponse.kt */
/* loaded from: classes3.dex */
public final class PhoneCallSupportContactDetails extends ContactOptionsDetails {
    @SerializedName("phone")

    /* renamed from: a  reason: collision with root package name */
    private final String f21795a;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PhoneCallSupportContactDetails) && Intrinsics.a(this.f21795a, ((PhoneCallSupportContactDetails) obj).f21795a);
    }

    public int hashCode() {
        return this.f21795a.hashCode();
    }

    public String toString() {
        String str = this.f21795a;
        return "PhoneCallSupportContactDetails(phone=" + str + ")";
    }
}
