package eu.bolt.chat.chatcore.network.model;

import com.google.gson.annotations.SerializedName;
import i0.a;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderHandleNetworkModel.kt */
/* loaded from: classes5.dex */
public final class OrderHandleNetworkModel {
    @SerializedName("order_id")

    /* renamed from: a  reason: collision with root package name */
    private final long f38351a;
    @SerializedName("order_system")

    /* renamed from: b  reason: collision with root package name */
    private final String f38352b;
    @SerializedName("city_id")

    /* renamed from: c  reason: collision with root package name */
    private final Long f38353c;

    public final Long a() {
        return this.f38353c;
    }

    public final long b() {
        return this.f38351a;
    }

    public final String c() {
        return this.f38352b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OrderHandleNetworkModel) {
            OrderHandleNetworkModel orderHandleNetworkModel = (OrderHandleNetworkModel) obj;
            return this.f38351a == orderHandleNetworkModel.f38351a && Intrinsics.a(this.f38352b, orderHandleNetworkModel.f38352b) && Intrinsics.a(this.f38353c, orderHandleNetworkModel.f38353c);
        }
        return false;
    }

    public int hashCode() {
        int a8 = a.a(this.f38351a) * 31;
        String str = this.f38352b;
        int hashCode = (a8 + (str == null ? 0 : str.hashCode())) * 31;
        Long l8 = this.f38353c;
        return hashCode + (l8 != null ? l8.hashCode() : 0);
    }

    public String toString() {
        return "OrderHandleNetworkModel(orderId=" + this.f38351a + ", orderSystem=" + this.f38352b + ", cityId=" + this.f38353c + ')';
    }
}
