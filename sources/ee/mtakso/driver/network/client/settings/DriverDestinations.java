package ee.mtakso.driver.network.client.settings;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverDestination.kt */
/* loaded from: classes3.dex */
public final class DriverDestinations {
    @SerializedName("destinations")

    /* renamed from: a  reason: collision with root package name */
    private final List<DriverDestination> f22790a;
    @SerializedName("limit_max")

    /* renamed from: b  reason: collision with root package name */
    private final int f22791b;
    @SerializedName("limit_used")

    /* renamed from: c  reason: collision with root package name */
    private final int f22792c;

    public final List<DriverDestination> a() {
        return this.f22790a;
    }

    public final int b() {
        return this.f22791b;
    }

    public final int c() {
        return this.f22792c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverDestinations) {
            DriverDestinations driverDestinations = (DriverDestinations) obj;
            return Intrinsics.a(this.f22790a, driverDestinations.f22790a) && this.f22791b == driverDestinations.f22791b && this.f22792c == driverDestinations.f22792c;
        }
        return false;
    }

    public int hashCode() {
        List<DriverDestination> list = this.f22790a;
        return ((((list == null ? 0 : list.hashCode()) * 31) + this.f22791b) * 31) + this.f22792c;
    }

    public String toString() {
        List<DriverDestination> list = this.f22790a;
        int i8 = this.f22791b;
        int i9 = this.f22792c;
        return "DriverDestinations(destinations=" + list + ", limitMax=" + i8 + ", limitUsed=" + i9 + ")";
    }
}
