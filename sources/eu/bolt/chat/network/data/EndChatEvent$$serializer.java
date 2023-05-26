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
public final class EndChatEvent$$serializer implements GeneratedSerializer<EndChatEvent> {

    /* renamed from: a  reason: collision with root package name */
    public static final EndChatEvent$$serializer f39199a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ SerialDescriptor f39200b;

    static {
        EndChatEvent$$serializer endChatEvent$$serializer = new EndChatEvent$$serializer();
        f39199a = endChatEvent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("finish", endChatEvent$$serializer, 5);
        pluginGeneratedSerialDescriptor.l(Name.MARK, false);
        pluginGeneratedSerialDescriptor.l("date", false);
        pluginGeneratedSerialDescriptor.l("message", false);
        pluginGeneratedSerialDescriptor.l("status", true);
        pluginGeneratedSerialDescriptor.l("sender", true);
        f39200b = pluginGeneratedSerialDescriptor;
    }

    private EndChatEvent$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f39200b;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] d() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] e() {
        StringSerializer stringSerializer = StringSerializer.f52262a;
        return new KSerializer[]{stringSerializer, LongSerializer.f52202a, stringSerializer, ChatStatusNet.Companion.serializer(), BuiltinSerializersKt.t(ChatMessageSender$$serializer.f39165a)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public EndChatEvent b(Decoder decoder) {
        String str;
        int i8;
        String str2;
        Object obj;
        Object obj2;
        long j8;
        Intrinsics.f(decoder, "decoder");
        SerialDescriptor a8 = a();
        CompositeDecoder b8 = decoder.b(a8);
        if (b8.p()) {
            String m8 = b8.m(a8, 0);
            long f8 = b8.f(a8, 1);
            String m9 = b8.m(a8, 2);
            obj = b8.y(a8, 3, ChatStatusNet.Companion.serializer(), null);
            obj2 = b8.n(a8, 4, ChatMessageSender$$serializer.f39165a, null);
            str = m8;
            str2 = m9;
            j8 = f8;
            i8 = 31;
        } else {
            String str3 = null;
            Object obj3 = null;
            long j9 = 0;
            boolean z7 = true;
            String str4 = null;
            Object obj4 = null;
            int i9 = 0;
            while (z7) {
                int o8 = b8.o(a8);
                if (o8 != -1) {
                    if (o8 != 0) {
                        if (o8 != 1) {
                            if (o8 != 2) {
                                if (o8 != 3) {
                                    if (o8 == 4) {
                                        obj3 = b8.n(a8, 4, ChatMessageSender$$serializer.f39165a, obj3);
                                        i9 |= 16;
                                    } else {
                                        throw new UnknownFieldException(o8);
                                    }
                                } else {
                                    obj4 = b8.y(a8, 3, ChatStatusNet.Companion.serializer(), obj4);
                                    i9 |= 8;
                                }
                            } else {
                                str4 = b8.m(a8, 2);
                                i9 |= 4;
                            }
                        } else {
                            j9 = b8.f(a8, 1);
                            i9 |= 2;
                        }
                    } else {
                        str3 = b8.m(a8, 0);
                        i9 |= 1;
                    }
                } else {
                    z7 = false;
                }
            }
            str = str3;
            i8 = i9;
            str2 = str4;
            obj = obj4;
            obj2 = obj3;
            j8 = j9;
        }
        b8.c(a8);
        return new EndChatEvent(i8, str, j8, str2, (ChatStatusNet) obj, (ChatMessageSender) obj2, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: g */
    public void c(Encoder encoder, EndChatEvent value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        SerialDescriptor a8 = a();
        CompositeEncoder b8 = encoder.b(a8);
        EndChatEvent.h(value, b8, a8);
        b8.c(a8);
    }
}
