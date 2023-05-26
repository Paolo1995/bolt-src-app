package eu.bolt.chat.network.data;

import eu.bolt.chat.network.data.serializer.TextMessageSerializer;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* compiled from: ChatHistoryNet.kt */
/* loaded from: classes5.dex */
public final class ChatHistoryNet$$serializer implements GeneratedSerializer<ChatHistoryNet> {

    /* renamed from: a  reason: collision with root package name */
    public static final ChatHistoryNet$$serializer f39161a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ SerialDescriptor f39162b;

    static {
        ChatHistoryNet$$serializer chatHistoryNet$$serializer = new ChatHistoryNet$$serializer();
        f39161a = chatHistoryNet$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("eu.bolt.chat.network.data.ChatHistoryNet", chatHistoryNet$$serializer, 3);
        pluginGeneratedSerialDescriptor.l("chat_details", false);
        pluginGeneratedSerialDescriptor.l("messages", false);
        pluginGeneratedSerialDescriptor.l("finish_chat_event", true);
        f39162b = pluginGeneratedSerialDescriptor;
    }

    private ChatHistoryNet$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f39162b;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] d() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] e() {
        return new KSerializer[]{ChatDetailsNet$$serializer.f39156a, new ArrayListSerializer(TextMessageSerializer.f39340c), BuiltinSerializersKt.t(EndChatEvent$$serializer.f39199a)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public ChatHistoryNet b(Decoder decoder) {
        Object obj;
        Object obj2;
        Object obj3;
        int i8;
        Intrinsics.f(decoder, "decoder");
        SerialDescriptor a8 = a();
        CompositeDecoder b8 = decoder.b(a8);
        Object obj4 = null;
        if (b8.p()) {
            obj2 = b8.y(a8, 0, ChatDetailsNet$$serializer.f39156a, null);
            Object y7 = b8.y(a8, 1, new ArrayListSerializer(TextMessageSerializer.f39340c), null);
            obj3 = b8.n(a8, 2, EndChatEvent$$serializer.f39199a, null);
            obj = y7;
            i8 = 7;
        } else {
            Object obj5 = null;
            Object obj6 = null;
            int i9 = 0;
            boolean z7 = true;
            while (z7) {
                int o8 = b8.o(a8);
                if (o8 != -1) {
                    if (o8 != 0) {
                        if (o8 != 1) {
                            if (o8 == 2) {
                                obj6 = b8.n(a8, 2, EndChatEvent$$serializer.f39199a, obj6);
                                i9 |= 4;
                            } else {
                                throw new UnknownFieldException(o8);
                            }
                        } else {
                            obj5 = b8.y(a8, 1, new ArrayListSerializer(TextMessageSerializer.f39340c), obj5);
                            i9 |= 2;
                        }
                    } else {
                        obj4 = b8.y(a8, 0, ChatDetailsNet$$serializer.f39156a, obj4);
                        i9 |= 1;
                    }
                } else {
                    z7 = false;
                }
            }
            obj = obj5;
            obj2 = obj4;
            obj3 = obj6;
            i8 = i9;
        }
        b8.c(a8);
        return new ChatHistoryNet(i8, (ChatDetailsNet) obj2, (List) obj, (EndChatEvent) obj3, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: g */
    public void c(Encoder encoder, ChatHistoryNet value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        SerialDescriptor a8 = a();
        CompositeEncoder b8 = encoder.b(a8);
        ChatHistoryNet.d(value, b8, a8);
        b8.c(a8);
    }
}
