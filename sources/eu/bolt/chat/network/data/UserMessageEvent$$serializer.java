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
public final class UserMessageEvent$$serializer implements GeneratedSerializer<UserMessageEvent> {

    /* renamed from: a  reason: collision with root package name */
    public static final UserMessageEvent$$serializer f39330a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ SerialDescriptor f39331b;

    static {
        UserMessageEvent$$serializer userMessageEvent$$serializer = new UserMessageEvent$$serializer();
        f39330a = userMessageEvent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("message", userMessageEvent$$serializer, 7);
        pluginGeneratedSerialDescriptor.l("status", true);
        pluginGeneratedSerialDescriptor.l(Name.MARK, false);
        pluginGeneratedSerialDescriptor.l("date", false);
        pluginGeneratedSerialDescriptor.l("text", true);
        pluginGeneratedSerialDescriptor.l("detected_language", true);
        pluginGeneratedSerialDescriptor.l("translation", true);
        pluginGeneratedSerialDescriptor.l("sender", true);
        f39331b = pluginGeneratedSerialDescriptor;
    }

    private UserMessageEvent$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f39331b;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] d() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] e() {
        StringSerializer stringSerializer = StringSerializer.f52262a;
        return new KSerializer[]{MessageStatusNet.Companion.serializer(), stringSerializer, LongSerializer.f52202a, BuiltinSerializersKt.t(stringSerializer), BuiltinSerializersKt.t(stringSerializer), BuiltinSerializersKt.t(TranslationInfoNet$$serializer.f39310a), BuiltinSerializersKt.t(ChatMessageSender$$serializer.f39165a)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public UserMessageEvent b(Decoder decoder) {
        int i8;
        Object obj;
        String str;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        long j8;
        Intrinsics.f(decoder, "decoder");
        SerialDescriptor a8 = a();
        CompositeDecoder b8 = decoder.b(a8);
        int i9 = 6;
        Object obj6 = null;
        if (b8.p()) {
            obj = b8.y(a8, 0, MessageStatusNet.Companion.serializer(), null);
            String m8 = b8.m(a8, 1);
            j8 = b8.f(a8, 2);
            StringSerializer stringSerializer = StringSerializer.f52262a;
            obj2 = b8.n(a8, 3, stringSerializer, null);
            obj3 = b8.n(a8, 4, stringSerializer, null);
            obj4 = b8.n(a8, 5, TranslationInfoNet$$serializer.f39310a, null);
            obj5 = b8.n(a8, 6, ChatMessageSender$$serializer.f39165a, null);
            str = m8;
            i8 = 127;
        } else {
            Object obj7 = null;
            Object obj8 = null;
            Object obj9 = null;
            long j9 = 0;
            int i10 = 0;
            boolean z7 = true;
            String str2 = null;
            Object obj10 = null;
            while (z7) {
                int o8 = b8.o(a8);
                switch (o8) {
                    case -1:
                        i9 = 6;
                        z7 = false;
                        continue;
                    case 0:
                        obj6 = b8.y(a8, 0, MessageStatusNet.Companion.serializer(), obj6);
                        i10 |= 1;
                        i9 = 6;
                        break;
                    case 1:
                        str2 = b8.m(a8, 1);
                        i10 |= 2;
                        break;
                    case 2:
                        j9 = b8.f(a8, 2);
                        i10 |= 4;
                        break;
                    case 3:
                        obj10 = b8.n(a8, 3, StringSerializer.f52262a, obj10);
                        i10 |= 8;
                        break;
                    case 4:
                        obj7 = b8.n(a8, 4, StringSerializer.f52262a, obj7);
                        i10 |= 16;
                        break;
                    case 5:
                        obj8 = b8.n(a8, 5, TranslationInfoNet$$serializer.f39310a, obj8);
                        i10 |= 32;
                        break;
                    case 6:
                        obj9 = b8.n(a8, i9, ChatMessageSender$$serializer.f39165a, obj9);
                        i10 |= 64;
                        break;
                    default:
                        throw new UnknownFieldException(o8);
                }
            }
            i8 = i10;
            obj = obj6;
            str = str2;
            obj2 = obj10;
            obj3 = obj7;
            obj4 = obj8;
            obj5 = obj9;
            j8 = j9;
        }
        b8.c(a8);
        return new UserMessageEvent(i8, (MessageStatusNet) obj, str, j8, (String) obj2, (String) obj3, (TranslationInfoNet) obj4, (ChatMessageSender) obj5, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: g */
    public void c(Encoder encoder, UserMessageEvent value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        SerialDescriptor a8 = a();
        CompositeEncoder b8 = encoder.b(a8);
        UserMessageEvent.j(value, b8, a8);
        b8.c(a8);
    }
}
