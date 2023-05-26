package ee.mtakso.driver.network.client.contact;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContactOptionsDetailsResponse.kt */
/* loaded from: classes3.dex */
public final class PhoneContactDetails extends ContactOptionsDetails {
    @SerializedName("phone")

    /* renamed from: a  reason: collision with root package name */
    private final String f21796a;

    public final String a() {
        return this.f21796a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PhoneContactDetails) && Intrinsics.a(this.f21796a, ((PhoneContactDetails) obj).f21796a);
    }

    public int hashCode() {
        return this.f21796a.hashCode();
    }

    public String toString() {
        String str = this.f21796a;
        return "PhoneContactDetails(phone=" + str + ")";
    }
}
