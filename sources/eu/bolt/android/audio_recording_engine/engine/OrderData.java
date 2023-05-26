package eu.bolt.android.audio_recording_engine.engine;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderData.kt */
/* loaded from: classes5.dex */
public final class OrderData {

    /* renamed from: a  reason: collision with root package name */
    private final String f36674a;

    /* renamed from: b  reason: collision with root package name */
    private final String f36675b;

    /* renamed from: c  reason: collision with root package name */
    private final String f36676c;

    public OrderData(String orderSystem, String cityId, String orderId) {
        Intrinsics.f(orderSystem, "orderSystem");
        Intrinsics.f(cityId, "cityId");
        Intrinsics.f(orderId, "orderId");
        this.f36674a = orderSystem;
        this.f36675b = cityId;
        this.f36676c = orderId;
    }

    public final String a() {
        return this.f36675b;
    }

    public final String b() {
        return this.f36676c;
    }

    public final String c() {
        return this.f36674a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OrderData) {
            OrderData orderData = (OrderData) obj;
            return Intrinsics.a(this.f36674a, orderData.f36674a) && Intrinsics.a(this.f36675b, orderData.f36675b) && Intrinsics.a(this.f36676c, orderData.f36676c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f36674a.hashCode() * 31) + this.f36675b.hashCode()) * 31) + this.f36676c.hashCode();
    }

    public String toString() {
        return "OrderData(orderSystem=" + this.f36674a + ", cityId=" + this.f36675b + ", orderId=" + this.f36676c + ')';
    }
}
