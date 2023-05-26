package ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.interactor;

import ee.mtakso.driver.network.client.OrderHandle;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderHandleWithCryptoKey.kt */
/* loaded from: classes3.dex */
public final class OrderHandleWithCryptoKey {

    /* renamed from: a  reason: collision with root package name */
    private final OrderHandle f32579a;

    /* renamed from: b  reason: collision with root package name */
    private final String f32580b;

    public OrderHandleWithCryptoKey(OrderHandle orderHandle, String cryptoKey) {
        Intrinsics.f(orderHandle, "orderHandle");
        Intrinsics.f(cryptoKey, "cryptoKey");
        this.f32579a = orderHandle;
        this.f32580b = cryptoKey;
    }

    public final String a() {
        return this.f32580b;
    }

    public final OrderHandle b() {
        return this.f32579a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OrderHandleWithCryptoKey) {
            OrderHandleWithCryptoKey orderHandleWithCryptoKey = (OrderHandleWithCryptoKey) obj;
            return Intrinsics.a(this.f32579a, orderHandleWithCryptoKey.f32579a) && Intrinsics.a(this.f32580b, orderHandleWithCryptoKey.f32580b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f32579a.hashCode() * 31) + this.f32580b.hashCode();
    }

    public String toString() {
        OrderHandle orderHandle = this.f32579a;
        String str = this.f32580b;
        return "OrderHandleWithCryptoKey(orderHandle=" + orderHandle + ", cryptoKey=" + str + ")";
    }
}
