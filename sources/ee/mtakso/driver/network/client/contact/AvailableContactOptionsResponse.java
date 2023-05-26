package ee.mtakso.driver.network.client.contact;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AvailableContactOptions.kt */
/* loaded from: classes3.dex */
public final class AvailableContactOptionsResponse {
    @SerializedName("contact_options")

    /* renamed from: a  reason: collision with root package name */
    private final AvailableContactOptions f21757a;

    public final AvailableContactOptions a() {
        return this.f21757a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AvailableContactOptionsResponse) && Intrinsics.a(this.f21757a, ((AvailableContactOptionsResponse) obj).f21757a);
    }

    public int hashCode() {
        return this.f21757a.hashCode();
    }

    public String toString() {
        AvailableContactOptions availableContactOptions = this.f21757a;
        return "AvailableContactOptionsResponse(availableContactOptions=" + availableContactOptions + ")";
    }
}
