package eu.bolt.chat.data;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderHandle.kt */
/* loaded from: classes5.dex */
public final class OrderHandle {

    /* renamed from: a  reason: collision with root package name */
    private final String f38954a;

    /* renamed from: b  reason: collision with root package name */
    private final int f38955b;

    /* renamed from: c  reason: collision with root package name */
    private final int f38956c;

    public OrderHandle(String orderSystem, int i8, int i9) {
        Intrinsics.f(orderSystem, "orderSystem");
        this.f38954a = orderSystem;
        this.f38955b = i8;
        this.f38956c = i9;
    }

    public final int a() {
        return this.f38956c;
    }

    public final int b() {
        return this.f38955b;
    }

    public final String c() {
        return this.f38954a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OrderHandle) {
            OrderHandle orderHandle = (OrderHandle) obj;
            return Intrinsics.a(this.f38954a, orderHandle.f38954a) && this.f38955b == orderHandle.f38955b && this.f38956c == orderHandle.f38956c;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f38954a.hashCode() * 31) + this.f38955b) * 31) + this.f38956c;
    }

    public String toString() {
        return "OrderHandle(orderSystem=" + this.f38954a + ", orderId=" + this.f38955b + ", cityId=" + this.f38956c + ')';
    }
}
