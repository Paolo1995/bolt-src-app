package ee.mtakso.driver.network.client.driver;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Car.kt */
/* loaded from: classes3.dex */
public final class Cars {
    @SerializedName("list")

    /* renamed from: a  reason: collision with root package name */
    private final List<Car> f21889a;

    public final List<Car> a() {
        return this.f21889a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Cars) && Intrinsics.a(this.f21889a, ((Cars) obj).f21889a);
    }

    public int hashCode() {
        return this.f21889a.hashCode();
    }

    public String toString() {
        List<Car> list = this.f21889a;
        return "Cars(cars=" + list + ")";
    }
}
