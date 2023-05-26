package ee.mtakso.driver.network.client.order;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PastOrder.kt */
/* loaded from: classes3.dex */
public final class OrderStop {
    @SerializedName("address")

    /* renamed from: a  reason: collision with root package name */
    private final String f22431a;
    @SerializedName("lat")

    /* renamed from: b  reason: collision with root package name */
    private final Double f22432b;
    @SerializedName("lng")

    /* renamed from: c  reason: collision with root package name */
    private final Double f22433c;
    @SerializedName("type")

    /* renamed from: d  reason: collision with root package name */
    private final StopType f22434d;

    public final String a() {
        return this.f22431a;
    }

    public final Double b() {
        return this.f22432b;
    }

    public final Double c() {
        return this.f22433c;
    }

    public final StopType d() {
        return this.f22434d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OrderStop) {
            OrderStop orderStop = (OrderStop) obj;
            return Intrinsics.a(this.f22431a, orderStop.f22431a) && Intrinsics.a(this.f22432b, orderStop.f22432b) && Intrinsics.a(this.f22433c, orderStop.f22433c) && this.f22434d == orderStop.f22434d;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f22431a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Double d8 = this.f22432b;
        int hashCode2 = (hashCode + (d8 == null ? 0 : d8.hashCode())) * 31;
        Double d9 = this.f22433c;
        return ((hashCode2 + (d9 != null ? d9.hashCode() : 0)) * 31) + this.f22434d.hashCode();
    }

    public String toString() {
        String str = this.f22431a;
        Double d8 = this.f22432b;
        Double d9 = this.f22433c;
        StopType stopType = this.f22434d;
        return "OrderStop(address=" + str + ", lat=" + d8 + ", lng=" + d9 + ", type=" + stopType + ")";
    }
}
