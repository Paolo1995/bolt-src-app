package eu.bolt.chat.network.data;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: OrderHandleNet.kt */
@Serializable
/* loaded from: classes5.dex */
public final class OrderHandleNet {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final String f39230a;

    /* renamed from: b  reason: collision with root package name */
    private final int f39231b;

    /* renamed from: c  reason: collision with root package name */
    private final int f39232c;

    /* compiled from: OrderHandleNet.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<OrderHandleNet> serializer() {
            return OrderHandleNet$$serializer.f39233a;
        }
    }

    public /* synthetic */ OrderHandleNet(int i8, String str, int i9, int i10, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i8 & 7)) {
            PluginExceptionsKt.a(i8, 7, OrderHandleNet$$serializer.f39233a.a());
        }
        this.f39230a = str;
        this.f39231b = i9;
        this.f39232c = i10;
    }

    public static final void d(OrderHandleNet self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.f(self, "self");
        Intrinsics.f(output, "output");
        Intrinsics.f(serialDesc, "serialDesc");
        output.y(serialDesc, 0, self.f39230a);
        output.w(serialDesc, 1, self.f39231b);
        output.w(serialDesc, 2, self.f39232c);
    }

    public final int a() {
        return this.f39232c;
    }

    public final int b() {
        return this.f39231b;
    }

    public final String c() {
        return this.f39230a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OrderHandleNet) {
            OrderHandleNet orderHandleNet = (OrderHandleNet) obj;
            return Intrinsics.a(this.f39230a, orderHandleNet.f39230a) && this.f39231b == orderHandleNet.f39231b && this.f39232c == orderHandleNet.f39232c;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f39230a.hashCode() * 31) + this.f39231b) * 31) + this.f39232c;
    }

    public String toString() {
        return "OrderHandleNet(orderSystem=" + this.f39230a + ", orderId=" + this.f39231b + ", cityId=" + this.f39232c + ')';
    }
}
