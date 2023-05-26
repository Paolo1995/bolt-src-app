package ee.mtakso.driver.network.client.dashboard;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverHomeScreenResponse.kt */
/* loaded from: classes3.dex */
public final class DriverHomeScreenResponse {
    @SerializedName("layout")

    /* renamed from: a  reason: collision with root package name */
    private final Layout f21838a;
    @SerializedName("items")

    /* renamed from: b  reason: collision with root package name */
    private final List<HomeScreenItem> f21839b;
    @SerializedName("poll_interval_sec")

    /* renamed from: c  reason: collision with root package name */
    private final Long f21840c;

    public final List<HomeScreenItem> a() {
        return this.f21839b;
    }

    public final Layout b() {
        return this.f21838a;
    }

    public final Long c() {
        return this.f21840c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverHomeScreenResponse) {
            DriverHomeScreenResponse driverHomeScreenResponse = (DriverHomeScreenResponse) obj;
            return Intrinsics.a(this.f21838a, driverHomeScreenResponse.f21838a) && Intrinsics.a(this.f21839b, driverHomeScreenResponse.f21839b) && Intrinsics.a(this.f21840c, driverHomeScreenResponse.f21840c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.f21838a.hashCode() * 31) + this.f21839b.hashCode()) * 31;
        Long l8 = this.f21840c;
        return hashCode + (l8 == null ? 0 : l8.hashCode());
    }

    public String toString() {
        Layout layout = this.f21838a;
        List<HomeScreenItem> list = this.f21839b;
        Long l8 = this.f21840c;
        return "DriverHomeScreenResponse(layout=" + layout + ", items=" + list + ", pollIntervalSec=" + l8 + ")";
    }
}
