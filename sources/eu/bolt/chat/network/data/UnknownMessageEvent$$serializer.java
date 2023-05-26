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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.simpleframework.xml.strategy.Name;

/* compiled from: IncomingChatEvent.kt */
/* loaded from: classes5.dex */
public final class UnknownMessageEvent$$serializer implements GeneratedSerializer<UnknownMessageEvent> {

    /* renamed from: a  reason: collision with root package name */
    public static final UnknownMessageEvent$$serializer f39321a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ SerialDescriptor f39322b;

    static {
        UnknownMessageEvent$$serializer unknownMessageEvent$$serializer = new UnknownMessageEvent$$serializer();
        f39321a = unknownMessageEvent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("eu.bolt.chat.network.data.UnknownMessageEvent", unknownMessageEvent$$serializer, 5);
        pluginGeneratedSerialDescriptor.l("status", true);
        pluginGeneratedSerialDescriptor.l(Name.MARK, false);
        pluginGeneratedSerialDescriptor.l("date", false);
        pluginGeneratedSerialDescriptor.l("sender", true);
        pluginGeneratedSerialDescriptor.l("type", false);
        f39322b = pluginGeneratedSerialDescriptor;
    }

    private UnknownMessageEvent$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f39322b;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] d() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] e() {
        StringSerializer stringSerializer = StringSerializer.f52262a;
        return new KSerializer[]{MessageStatusNet.Companion.serializer(), stringSerializer, LongSerializer.f52202a, BuiltinSerializersKt.t(ChatMessageSender$$serializer.f39165a), stringSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public UnknownMessageEvent b(Decoder decoder) {
        String str;
        int i8;
        Object obj;
        String str2;
        Object obj2;
        long j8;
        Intrinsics.f(decoder, "decoder");
        SerialDescriptor a8 = a();
        CompositeDecoder b8 = decoder.b(a8);
        Object obj3 = null;
        if (b8.p()) {
            obj = b8.y(a8, 0, MessageStatusNet.Companion.serializer(), null);
            str2 = b8.m(a8, 1);
            j8 = b8.f(a8, 2);
            obj2 = b8.n(a8, 3, ChatMessageSender$$serializer.f39165a, null);
            i8 = 31;
            str = b8.m(a8, 4);
        } else {
            str = null;
            long j9 = 0;
            int i9 = 0;
            boolean z7 = true;
            String str3 = null;
            Object obj4 = null;
            while (z7) {
                int o8 = b8.o(a8);
                if (o8 != -1) {
                    if (o8 != 0) {
                        if (o8 != 1) {
                            if (o8 != 2) {
                                if (o8 != 3) {
                                    if (o8 == 4) {
                                        str = b8.m(a8, 4);
                                        i9 |= 16;
                                    } else {
                                        throw new UnknownFieldException(o8);
                                    }
                                } else {
                                    obj4 = b8.n(a8, 3, ChatMessageSender$$serializer.f39165a, obj4);
                                    i9 |= 8;
                                }
                            } else {
                                j9 = b8.f(a8, 2);
                                i9 |= 4;
                            }
                        } else {
                            str3 = b8.m(a8, 1);
                            i9 |= 2;
                        }
                    } else {
                        obj3 = b8.y(a8, 0, MessageStatusNet.Companion.serializer(), obj3);
                        i9 |= 1;
                    }
                } else {
                    z7 = false;
                }
            }
            i8 = i9;
            obj = obj3;
            str2 = str3;
            obj2 = obj4;
            j8 = j9;
        }
        b8.c(a8);
        return new UnknownMessageEvent(i8, (MessageStatusNet) obj, str2, j8, (ChatMessageSender) obj2, str, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: g */
    public void c(Encoder encoder, UnknownMessageEvent value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        SerialDescriptor a8 = a();
        CompositeEncoder b8 = encoder.b(a8);
        UnknownMessageEvent.g(value, b8, a8);
        b8.c(a8);
    }
}
