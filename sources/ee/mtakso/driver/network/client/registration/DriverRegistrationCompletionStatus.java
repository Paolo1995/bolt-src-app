package ee.mtakso.driver.network.client.registration;

import com.google.gson.annotations.SerializedName;

/* compiled from: DriverRegistrationCompletionStatus.kt */
/* loaded from: classes3.dex */
public final class DriverRegistrationCompletionStatus {
    @SerializedName("is_registration_closed")

    /* renamed from: a  reason: collision with root package name */
    private final int f22701a;

    public final int a() {
        return this.f22701a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DriverRegistrationCompletionStatus) && this.f22701a == ((DriverRegistrationCompletionStatus) obj).f22701a;
    }

    public int hashCode() {
        return this.f22701a;
    }

    public String toString() {
        int i8 = this.f22701a;
        return "DriverRegistrationCompletionStatus(registrationClosed=" + i8 + ")";
    }
}
