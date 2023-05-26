package ee.mtakso.driver.network.client.driver;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: Car.kt */
/* loaded from: classes3.dex */
public final class Car {
    @SerializedName(Name.MARK)

    /* renamed from: a  reason: collision with root package name */
    private final long f21886a;
    @SerializedName("name")

    /* renamed from: b  reason: collision with root package name */
    private final String f21887b;
    @SerializedName("uuid")

    /* renamed from: c  reason: collision with root package name */
    private final String f21888c;

    public final long a() {
        return this.f21886a;
    }

    public final String b() {
        return this.f21888c;
    }

    public final String c() {
        return this.f21887b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Car) {
            Car car = (Car) obj;
            return this.f21886a == car.f21886a && Intrinsics.a(this.f21887b, car.f21887b) && Intrinsics.a(this.f21888c, car.f21888c);
        }
        return false;
    }

    public int hashCode() {
        int a8 = ((i0.a.a(this.f21886a) * 31) + this.f21887b.hashCode()) * 31;
        String str = this.f21888c;
        return a8 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        long j8 = this.f21886a;
        String str = this.f21887b;
        String str2 = this.f21888c;
        return "Car(id=" + j8 + ", name=" + str + ", insuranceKey=" + str2 + ")";
    }
}
