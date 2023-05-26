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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ServerResponse.kt */
/* loaded from: classes5.dex */
public final class ServerResponse$$serializer<DATA> implements GeneratedSerializer<ServerResponse<DATA>> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SerialDescriptor f39289a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ KSerializer<DATA> f39290b;

    private ServerResponse$$serializer() {
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("eu.bolt.chat.network.data.ServerResponse", this, 4);
        pluginGeneratedSerialDescriptor.l("code", false);
        pluginGeneratedSerialDescriptor.l("message", false);
        pluginGeneratedSerialDescriptor.l("data", true);
        pluginGeneratedSerialDescriptor.l("error_hint", true);
        this.f39289a = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return this.f39289a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] d() {
        return new KSerializer[]{this.f39290b};
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] e() {
        StringSerializer stringSerializer = StringSerializer.f52262a;
        return new KSerializer[]{IntSerializer.f52191a, stringSerializer, BuiltinSerializersKt.t(this.f39290b), BuiltinSerializersKt.t(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public ServerResponse<DATA> b(Decoder decoder) {
        int i8;
        int i9;
        String str;
        Object obj;
        Object obj2;
        Intrinsics.f(decoder, "decoder");
        SerialDescriptor a8 = a();
        CompositeDecoder b8 = decoder.b(a8);
        if (b8.p()) {
            int i10 = b8.i(a8, 0);
            String m8 = b8.m(a8, 1);
            Object n8 = b8.n(a8, 2, this.f39290b, null);
            obj2 = b8.n(a8, 3, StringSerializer.f52262a, null);
            i8 = i10;
            obj = n8;
            str = m8;
            i9 = 15;
        } else {
            String str2 = null;
            Object obj3 = null;
            Object obj4 = null;
            int i11 = 0;
            int i12 = 0;
            boolean z7 = true;
            while (z7) {
                int o8 = b8.o(a8);
                if (o8 != -1) {
                    if (o8 != 0) {
                        if (o8 != 1) {
                            if (o8 != 2) {
                                if (o8 == 3) {
                                    obj4 = b8.n(a8, 3, StringSerializer.f52262a, obj4);
                                    i12 |= 8;
                                } else {
                                    throw new UnknownFieldException(o8);
                                }
                            } else {
                                obj3 = b8.n(a8, 2, this.f39290b, obj3);
                                i12 |= 4;
                            }
                        } else {
                            str2 = b8.m(a8, 1);
                            i12 |= 2;
                        }
                    } else {
                        i11 = b8.i(a8, 0);
                        i12 |= 1;
                    }
                } else {
                    z7 = false;
                }
            }
            i8 = i11;
            i9 = i12;
            str = str2;
            obj = obj3;
            obj2 = obj4;
        }
        b8.c(a8);
        return new ServerResponse<>(i9, i8, str, obj, (String) obj2, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: g */
    public void c(Encoder encoder, ServerResponse<DATA> value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        SerialDescriptor a8 = a();
        CompositeEncoder b8 = encoder.b(a8);
        ServerResponse.d(value, b8, a8, this.f39290b);
        b8.c(a8);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ServerResponse$$serializer(KSerializer typeSerial0) {
        this();
        Intrinsics.f(typeSerial0, "typeSerial0");
        this.f39290b = typeSerial0;
    }
}
