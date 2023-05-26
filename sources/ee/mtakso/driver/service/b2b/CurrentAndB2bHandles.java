package ee.mtakso.driver.service.b2b;

import ee.mtakso.driver.network.client.OrderHandle;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: B2bManager.kt */
/* loaded from: classes3.dex */
final class CurrentAndB2bHandles {

    /* renamed from: a  reason: collision with root package name */
    private final OrderHandle f23947a;

    /* renamed from: b  reason: collision with root package name */
    private final OrderHandle f23948b;

    public CurrentAndB2bHandles(OrderHandle currentOrderHandle, OrderHandle b2bOrderHandle) {
        Intrinsics.f(currentOrderHandle, "currentOrderHandle");
        Intrinsics.f(b2bOrderHandle, "b2bOrderHandle");
        this.f23947a = currentOrderHandle;
        this.f23948b = b2bOrderHandle;
    }

    public final OrderHandle a() {
        return this.f23948b;
    }

    public final OrderHandle b() {
        return this.f23947a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CurrentAndB2bHandles) {
            CurrentAndB2bHandles currentAndB2bHandles = (CurrentAndB2bHandles) obj;
            return Intrinsics.a(this.f23947a, currentAndB2bHandles.f23947a) && Intrinsics.a(this.f23948b, currentAndB2bHandles.f23948b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f23947a.hashCode() * 31) + this.f23948b.hashCode();
    }

    public String toString() {
        OrderHandle orderHandle = this.f23947a;
        OrderHandle orderHandle2 = this.f23948b;
        return "CurrentAndB2bHandles(currentOrderHandle=" + orderHandle + ", b2bOrderHandle=" + orderHandle2 + ")";
    }
}
