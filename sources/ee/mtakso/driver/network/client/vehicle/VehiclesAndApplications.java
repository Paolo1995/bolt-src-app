package ee.mtakso.driver.network.client.vehicle;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VehiclesAndApplications.kt */
/* loaded from: classes3.dex */
public final class VehiclesAndApplications {
    @SerializedName("vehicles")

    /* renamed from: a  reason: collision with root package name */
    private final List<Car> f22902a;
    @SerializedName("applications")

    /* renamed from: b  reason: collision with root package name */
    private final List<Application> f22903b;

    public final List<Application> a() {
        return this.f22903b;
    }

    public final List<Car> b() {
        return this.f22902a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VehiclesAndApplications) {
            VehiclesAndApplications vehiclesAndApplications = (VehiclesAndApplications) obj;
            return Intrinsics.a(this.f22902a, vehiclesAndApplications.f22902a) && Intrinsics.a(this.f22903b, vehiclesAndApplications.f22903b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f22902a.hashCode() * 31) + this.f22903b.hashCode();
    }

    public String toString() {
        List<Car> list = this.f22902a;
        List<Application> list2 = this.f22903b;
        return "VehiclesAndApplications(cars=" + list + ", applications=" + list2 + ")";
    }
}
