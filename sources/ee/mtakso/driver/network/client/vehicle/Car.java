package ee.mtakso.driver.network.client.vehicle;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: VehiclesAndApplications.kt */
/* loaded from: classes3.dex */
public final class Car {
    @SerializedName(Name.MARK)

    /* renamed from: a  reason: collision with root package name */
    private final long f22895a;
    @SerializedName("uuid")

    /* renamed from: b  reason: collision with root package name */
    private final String f22896b;
    @SerializedName("title")

    /* renamed from: c  reason: collision with root package name */
    private final String f22897c;
    @SerializedName("subtitle")

    /* renamed from: d  reason: collision with root package name */
    private final String f22898d;

    public final long a() {
        return this.f22895a;
    }

    public final String b() {
        return this.f22898d;
    }

    public final String c() {
        return this.f22897c;
    }

    public final String d() {
        return this.f22896b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Car) {
            Car car = (Car) obj;
            return this.f22895a == car.f22895a && Intrinsics.a(this.f22896b, car.f22896b) && Intrinsics.a(this.f22897c, car.f22897c) && Intrinsics.a(this.f22898d, car.f22898d);
        }
        return false;
    }

    public int hashCode() {
        int a8 = i0.a.a(this.f22895a) * 31;
        String str = this.f22896b;
        return ((((a8 + (str == null ? 0 : str.hashCode())) * 31) + this.f22897c.hashCode()) * 31) + this.f22898d.hashCode();
    }

    public String toString() {
        long j8 = this.f22895a;
        String str = this.f22896b;
        String str2 = this.f22897c;
        String str3 = this.f22898d;
        return "Car(id=" + j8 + ", uuid=" + str + ", title=" + str2 + ", subtitle=" + str3 + ")";
    }
}
