package eu.bolt.chat.network.data;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: OrderHandleNet.kt */
/* loaded from: classes5.dex */
public final class OrderHandleNet$$serializer implements GeneratedSerializer<OrderHandleNet> {

    /* renamed from: a  reason: collision with root package name */
    public static final OrderHandleNet$$serializer f39233a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ SerialDescriptor f39234b;

    static {
        OrderHandleNet$$serializer orderHandleNet$$serializer = new OrderHandleNet$$serializer();
        f39233a = orderHandleNet$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("eu.bolt.chat.network.data.OrderHandleNet", orderHandleNet$$serializer, 3);
        pluginGeneratedSerialDescriptor.l("order_system", false);
        pluginGeneratedSerialDescriptor.l("order_id", false);
        pluginGeneratedSerialDescriptor.l("city_id", false);
        f39234b = pluginGeneratedSerialDescriptor;
    }

    private OrderHandleNet$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f39234b;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] d() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] e() {
        IntSerializer intSerializer = IntSerializer.f52191a;
        return new KSerializer[]{StringSerializer.f52262a, intSerializer, intSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public OrderHandleNet b(Decoder decoder) {
        String str;
        int i8;
        int i9;
        int i10;
        Intrinsics.f(decoder, "decoder");
        SerialDescriptor a8 = a();
        CompositeDecoder b8 = decoder.b(a8);
        if (b8.p()) {
            String m8 = b8.m(a8, 0);
            int i11 = b8.i(a8, 1);
            str = m8;
            i8 = b8.i(a8, 2);
            i9 = i11;
            i10 = 7;
        } else {
            String str2 = null;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            boolean z7 = true;
            while (z7) {
                int o8 = b8.o(a8);
                if (o8 != -1) {
                    if (o8 != 0) {
                        if (o8 != 1) {
                            if (o8 == 2) {
                                i12 = b8.i(a8, 2);
                                i14 |= 4;
                            } else {
                                throw new UnknownFieldException(o8);
                            }
                        } else {
                            i13 = b8.i(a8, 1);
                            i14 |= 2;
                        }
                    } else {
                        str2 = b8.m(a8, 0);
                        i14 |= 1;
                    }
                } else {
                    z7 = false;
                }
            }
            str = str2;
            i8 = i12;
            i9 = i13;
            i10 = i14;
        }
        b8.c(a8);
        return new OrderHandleNet(i10, str, i9, i8, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: g */
    public void c(Encoder encoder, OrderHandleNet value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        SerialDescriptor a8 = a();
        CompositeEncoder b8 = encoder.b(a8);
        OrderHandleNet.d(value, b8, a8);
        b8.c(a8);
    }
}
