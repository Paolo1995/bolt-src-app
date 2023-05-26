package eu.bolt.chat.network.data;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.simpleframework.xml.strategy.Name;

/* compiled from: IncomingChatEvent.kt */
/* loaded from: classes5.dex */
public final class SeenMessagesEvent$$serializer implements GeneratedSerializer<SeenMessagesEvent> {

    /* renamed from: a  reason: collision with root package name */
    public static final SeenMessagesEvent$$serializer f39282a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ SerialDescriptor f39283b;

    static {
        SeenMessagesEvent$$serializer seenMessagesEvent$$serializer = new SeenMessagesEvent$$serializer();
        f39282a = seenMessagesEvent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("seen_message", seenMessagesEvent$$serializer, 4);
        pluginGeneratedSerialDescriptor.l(Name.MARK, false);
        pluginGeneratedSerialDescriptor.l("date", false);
        pluginGeneratedSerialDescriptor.l("seen_message_ids", false);
        pluginGeneratedSerialDescriptor.l("sender", true);
        f39283b = pluginGeneratedSerialDescriptor;
    }

    private SeenMessagesEvent$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f39283b;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] d() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] e() {
        StringSerializer stringSerializer = StringSerializer.f52262a;
        return new KSerializer[]{stringSerializer, LongSerializer.f52202a, new ArrayListSerializer(stringSerializer), BuiltinSerializersKt.t(ChatMessageSender$$serializer.f39165a)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public SeenMessagesEvent b(Decoder decoder) {
        String str;
        int i8;
        Object obj;
        Object obj2;
        long j8;
        Intrinsics.f(decoder, "decoder");
        SerialDescriptor a8 = a();
        CompositeDecoder b8 = decoder.b(a8);
        if (b8.p()) {
            String m8 = b8.m(a8, 0);
            long f8 = b8.f(a8, 1);
            obj = b8.y(a8, 2, new ArrayListSerializer(StringSerializer.f52262a), null);
            obj2 = b8.n(a8, 3, ChatMessageSender$$serializer.f39165a, null);
            str = m8;
            j8 = f8;
            i8 = 15;
        } else {
            String str2 = null;
            long j9 = 0;
            boolean z7 = true;
            Object obj3 = null;
            Object obj4 = null;
            int i9 = 0;
            while (z7) {
                int o8 = b8.o(a8);
                if (o8 != -1) {
                    if (o8 != 0) {
                        if (o8 != 1) {
                            if (o8 != 2) {
                                if (o8 == 3) {
                                    obj4 = b8.n(a8, 3, ChatMessageSender$$serializer.f39165a, obj4);
                                    i9 |= 8;
                                } else {
                                    throw new UnknownFieldException(o8);
                                }
                            } else {
                                obj3 = b8.y(a8, 2, new ArrayListSerializer(StringSerializer.f52262a), obj3);
                                i9 |= 4;
                            }
                        } else {
                            j9 = b8.f(a8, 1);
                            i9 |= 2;
                        }
                    } else {
                        str2 = b8.m(a8, 0);
                        i9 |= 1;
                    }
                } else {
                    z7 = false;
                }
            }
            str = str2;
            i8 = i9;
            obj = obj3;
            obj2 = obj4;
            j8 = j9;
        }
        b8.c(a8);
        return new SeenMessagesEvent(i8, str, j8, (List) obj, (ChatMessageSender) obj2, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: g */
    public void c(Encoder encoder, SeenMessagesEvent value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        SerialDescriptor a8 = a();
        CompositeEncoder b8 = encoder.b(a8);
        SeenMessagesEvent.g(value, b8, a8);
        b8.c(a8);
    }
}
