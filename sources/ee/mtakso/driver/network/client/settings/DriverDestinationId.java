package ee.mtakso.driver.network.client.settings;

import com.google.gson.annotations.SerializedName;

/* compiled from: DriverDestination.kt */
/* loaded from: classes3.dex */
public final class DriverDestinationId {
    @SerializedName("driver_destination_id")

    /* renamed from: a  reason: collision with root package name */
    private final long f22789a;

    public final long a() {
        return this.f22789a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DriverDestinationId) && this.f22789a == ((DriverDestinationId) obj).f22789a;
    }

    public int hashCode() {
        return i0.a.a(this.f22789a);
    }

    public String toString() {
        long j8 = this.f22789a;
        return "DriverDestinationId(id=" + j8 + ")";
    }
}
