package ee.mtakso.driver.network.client.order;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PastOrder.kt */
/* loaded from: classes3.dex */
public final class PreviousOrders {
    @SerializedName("list")

    /* renamed from: a  reason: collision with root package name */
    private final List<PreviousOrder> f22466a;

    public final List<PreviousOrder> a() {
        return this.f22466a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PreviousOrders) && Intrinsics.a(this.f22466a, ((PreviousOrders) obj).f22466a);
    }

    public int hashCode() {
        return this.f22466a.hashCode();
    }

    public String toString() {
        List<PreviousOrder> list = this.f22466a;
        return "PreviousOrders(previousOrders=" + list + ")";
    }
}
