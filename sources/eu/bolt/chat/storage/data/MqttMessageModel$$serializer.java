package eu.bolt.chat.storage.data;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: PendingRawMessageModel.kt */
/* loaded from: classes5.dex */
public final class MqttMessageModel$$serializer implements GeneratedSerializer<MqttMessageModel> {

    /* renamed from: a  reason: collision with root package name */
    public static final MqttMessageModel$$serializer f39649a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ SerialDescriptor f39650b;

    static {
        MqttMessageModel$$serializer mqttMessageModel$$serializer = new MqttMessageModel$$serializer();
        f39649a = mqttMessageModel$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("eu.bolt.chat.storage.data.MqttMessageModel", mqttMessageModel$$serializer, 2);
        pluginGeneratedSerialDescriptor.l("topic", false);
        pluginGeneratedSerialDescriptor.l("payload", false);
        f39650b = pluginGeneratedSerialDescriptor;
    }

    private MqttMessageModel$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f39650b;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] d() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] e() {
        StringSerializer stringSerializer = StringSerializer.f52262a;
        return new KSerializer[]{stringSerializer, stringSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public MqttMessageModel b(Decoder decoder) {
        String str;
        String str2;
        int i8;
        Intrinsics.f(decoder, "decoder");
        SerialDescriptor a8 = a();
        CompositeDecoder b8 = decoder.b(a8);
        if (b8.p()) {
            str = b8.m(a8, 0);
            str2 = b8.m(a8, 1);
            i8 = 3;
        } else {
            str = null;
            String str3 = null;
            int i9 = 0;
            boolean z7 = true;
            while (z7) {
                int o8 = b8.o(a8);
                if (o8 != -1) {
                    if (o8 != 0) {
                        if (o8 == 1) {
                            str3 = b8.m(a8, 1);
                            i9 |= 2;
                        } else {
                            throw new UnknownFieldException(o8);
                        }
                    } else {
                        str = b8.m(a8, 0);
                        i9 |= 1;
                    }
                } else {
                    z7 = false;
                }
            }
            str2 = str3;
            i8 = i9;
        }
        b8.c(a8);
        return new MqttMessageModel(i8, str, str2, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: g */
    public void c(Encoder encoder, MqttMessageModel value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        SerialDescriptor a8 = a();
        CompositeEncoder b8 = encoder.b(a8);
        MqttMessageModel.c(value, b8, a8);
        b8.c(a8);
    }
}
