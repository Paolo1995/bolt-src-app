package ee.mtakso.driver.network.client.contact;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContactOptionsDetailsResponse.kt */
/* loaded from: classes3.dex */
public final class ContactOptionsDetailsResponse {
    @SerializedName("details")

    /* renamed from: a  reason: collision with root package name */
    private final ContactOptionsDetails f21794a;

    public final ContactOptionsDetails a() {
        return this.f21794a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ContactOptionsDetailsResponse) && Intrinsics.a(this.f21794a, ((ContactOptionsDetailsResponse) obj).f21794a);
    }

    public int hashCode() {
        return this.f21794a.hashCode();
    }

    public String toString() {
        ContactOptionsDetails contactOptionsDetails = this.f21794a;
        return "ContactOptionsDetailsResponse(details=" + contactOptionsDetails + ")";
    }
}
