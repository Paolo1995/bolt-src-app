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

/* compiled from: ChatDetailsNet.kt */
/* loaded from: classes5.dex */
public final class ChatDetailsNet$$serializer implements GeneratedSerializer<ChatDetailsNet> {

    /* renamed from: a  reason: collision with root package name */
    public static final ChatDetailsNet$$serializer f39156a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ SerialDescriptor f39157b;

    static {
        ChatDetailsNet$$serializer chatDetailsNet$$serializer = new ChatDetailsNet$$serializer();
        f39156a = chatDetailsNet$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("eu.bolt.chat.network.data.ChatDetailsNet", chatDetailsNet$$serializer, 6);
        pluginGeneratedSerialDescriptor.l("title", false);
        pluginGeneratedSerialDescriptor.l("description", true);
        pluginGeneratedSerialDescriptor.l("thumbnail_url", true);
        pluginGeneratedSerialDescriptor.l("order_handle", false);
        pluginGeneratedSerialDescriptor.l("start_date", false);
        pluginGeneratedSerialDescriptor.l("chat_status", true);
        f39157b = pluginGeneratedSerialDescriptor;
    }

    private ChatDetailsNet$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f39157b;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] d() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] e() {
        StringSerializer stringSerializer = StringSerializer.f52262a;
        return new KSerializer[]{stringSerializer, BuiltinSerializersKt.t(stringSerializer), BuiltinSerializersKt.t(stringSerializer), OrderHandleNet$$serializer.f39233a, LongSerializer.f52202a, ChatStatusNet.Companion.serializer()};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public ChatDetailsNet b(Decoder decoder) {
        long j8;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        String str;
        int i8;
        Intrinsics.f(decoder, "decoder");
        SerialDescriptor a8 = a();
        CompositeDecoder b8 = decoder.b(a8);
        String str2 = null;
        if (b8.p()) {
            String m8 = b8.m(a8, 0);
            StringSerializer stringSerializer = StringSerializer.f52262a;
            obj = b8.n(a8, 1, stringSerializer, null);
            obj2 = b8.n(a8, 2, stringSerializer, null);
            obj3 = b8.y(a8, 3, OrderHandleNet$$serializer.f39233a, null);
            long f8 = b8.f(a8, 4);
            obj4 = b8.y(a8, 5, ChatStatusNet.Companion.serializer(), null);
            j8 = f8;
            i8 = 63;
            str = m8;
        } else {
            Object obj5 = null;
            Object obj6 = null;
            j8 = 0;
            int i9 = 0;
            boolean z7 = true;
            Object obj7 = null;
            Object obj8 = null;
            while (z7) {
                int o8 = b8.o(a8);
                switch (o8) {
                    case -1:
                        z7 = false;
                        continue;
                    case 0:
                        str2 = b8.m(a8, 0);
                        i9 |= 1;
                        continue;
                    case 1:
                        obj7 = b8.n(a8, 1, StringSerializer.f52262a, obj7);
                        i9 |= 2;
                        break;
                    case 2:
                        obj8 = b8.n(a8, 2, StringSerializer.f52262a, obj8);
                        i9 |= 4;
                        break;
                    case 3:
                        obj5 = b8.y(a8, 3, OrderHandleNet$$serializer.f39233a, obj5);
                        i9 |= 8;
                        break;
                    case 4:
                        j8 = b8.f(a8, 4);
                        i9 |= 16;
                        break;
                    case 5:
                        obj6 = b8.y(a8, 5, ChatStatusNet.Companion.serializer(), obj6);
                        i9 |= 32;
                        break;
                    default:
                        throw new UnknownFieldException(o8);
                }
            }
            obj = obj7;
            obj2 = obj8;
            obj3 = obj5;
            obj4 = obj6;
            str = str2;
            i8 = i9;
        }
        b8.c(a8);
        return new ChatDetailsNet(i8, str, (String) obj, (String) obj2, (OrderHandleNet) obj3, j8, (ChatStatusNet) obj4, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: g */
    public void c(Encoder encoder, ChatDetailsNet value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        SerialDescriptor a8 = a();
        CompositeEncoder b8 = encoder.b(a8);
        ChatDetailsNet.f(value, b8, a8);
        b8.c(a8);
    }
}
