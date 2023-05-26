package eu.bolt.chat.network.data;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AttributionInfoNet.kt */
/* loaded from: classes5.dex */
public final class AttributionInfoNet$$serializer implements GeneratedSerializer<AttributionInfoNet> {

    /* renamed from: a  reason: collision with root package name */
    public static final AttributionInfoNet$$serializer f39143a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ SerialDescriptor f39144b;

    static {
        AttributionInfoNet$$serializer attributionInfoNet$$serializer = new AttributionInfoNet$$serializer();
        f39143a = attributionInfoNet$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("eu.bolt.chat.network.data.AttributionInfoNet", attributionInfoNet$$serializer, 2);
        pluginGeneratedSerialDescriptor.l("provider_name", true);
        pluginGeneratedSerialDescriptor.l("provider_logo_url", true);
        f39144b = pluginGeneratedSerialDescriptor;
    }

    private AttributionInfoNet$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f39144b;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] d() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] e() {
        StringSerializer stringSerializer = StringSerializer.f52262a;
        return new KSerializer[]{BuiltinSerializersKt.t(stringSerializer), BuiltinSerializersKt.t(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public AttributionInfoNet b(Decoder decoder) {
        Object obj;
        Object obj2;
        int i8;
        Intrinsics.f(decoder, "decoder");
        SerialDescriptor a8 = a();
        CompositeDecoder b8 = decoder.b(a8);
        if (b8.p()) {
            StringSerializer stringSerializer = StringSerializer.f52262a;
            obj2 = b8.n(a8, 0, stringSerializer, null);
            obj = b8.n(a8, 1, stringSerializer, null);
            i8 = 3;
        } else {
            obj = null;
            Object obj3 = null;
            int i9 = 0;
            boolean z7 = true;
            while (z7) {
                int o8 = b8.o(a8);
                if (o8 != -1) {
                    if (o8 != 0) {
                        if (o8 == 1) {
                            obj = b8.n(a8, 1, StringSerializer.f52262a, obj);
                            i9 |= 2;
                        } else {
                            throw new UnknownFieldException(o8);
                        }
                    } else {
                        obj3 = b8.n(a8, 0, StringSerializer.f52262a, obj3);
                        i9 |= 1;
                    }
                } else {
                    z7 = false;
                }
            }
            obj2 = obj3;
            i8 = i9;
        }
        b8.c(a8);
        return new AttributionInfoNet(i8, (String) obj2, (String) obj, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: g */
    public void c(Encoder encoder, AttributionInfoNet value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        SerialDescriptor a8 = a();
        CompositeEncoder b8 = encoder.b(a8);
        AttributionInfoNet.c(value, b8, a8);
        b8.c(a8);
    }
}
