package ee.mtakso.driver.network.client.contact;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContactOptionsDetailsResponse.kt */
/* loaded from: classes3.dex */
public final class SimpleMessagingContactDetails extends ContactOptionsDetails {
    @SerializedName("phone")

    /* renamed from: a  reason: collision with root package name */
    private final String f21797a;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SimpleMessagingContactDetails) && Intrinsics.a(this.f21797a, ((SimpleMessagingContactDetails) obj).f21797a);
    }

    public int hashCode() {
        return this.f21797a.hashCode();
    }

    public String toString() {
        String str = this.f21797a;
        return "SimpleMessagingContactDetails(phone=" + str + ")";
    }
}
