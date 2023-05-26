package ee.mtakso.driver.network.client.search;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Search.kt */
/* loaded from: classes3.dex */
public final class Drivers {
    @SerializedName("list")

    /* renamed from: a  reason: collision with root package name */
    private final List<OtherDriver> f22770a;

    public final List<OtherDriver> a() {
        return this.f22770a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Drivers) && Intrinsics.a(this.f22770a, ((Drivers) obj).f22770a);
    }

    public int hashCode() {
        return this.f22770a.hashCode();
    }

    public String toString() {
        List<OtherDriver> list = this.f22770a;
        return "Drivers(drivers=" + list + ")";
    }
}
