package eu.bolt.chat.network.data;

import eu.bolt.chat.network.data.serializer.TextMessageSerializer;
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

/* compiled from: ChatPushMessageNet.kt */
/* loaded from: classes5.dex */
public final class ChatPushMessageNet$$serializer implements GeneratedSerializer<ChatPushMessageNet> {

    /* renamed from: a  reason: collision with root package name */
    public static final ChatPushMessageNet$$serializer f39174a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ SerialDescriptor f39175b;

    static {
        ChatPushMessageNet$$serializer chatPushMessageNet$$serializer = new ChatPushMessageNet$$serializer();
        f39174a = chatPushMessageNet$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("eu.bolt.chat.network.data.ChatPushMessageNet", chatPushMessageNet$$serializer, 7);
        pluginGeneratedSerialDescriptor.l(Name.MARK, false);
        pluginGeneratedSerialDescriptor.l("title", false);
        pluginGeneratedSerialDescriptor.l("description", true);
        pluginGeneratedSerialDescriptor.l("thumbnail_url", true);
        pluginGeneratedSerialDescriptor.l("order_handle", false);
        pluginGeneratedSerialDescriptor.l("start_date", false);
        pluginGeneratedSerialDescriptor.l("event", false);
        f39175b = pluginGeneratedSerialDescriptor;
    }

    private ChatPushMessageNet$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f39175b;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] d() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] e() {
        StringSerializer stringSerializer = StringSerializer.f52262a;
        return new KSerializer[]{stringSerializer, stringSerializer, BuiltinSerializersKt.t(stringSerializer), BuiltinSerializersKt.t(stringSerializer), OrderHandleNet$$serializer.f39233a, LongSerializer.f52202a, TextMessageSerializer.f39340c};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public ChatPushMessageNet b(Decoder decoder) {
        long j8;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        String str;
        String str2;
        int i8;
        Intrinsics.f(decoder, "decoder");
        SerialDescriptor a8 = a();
        CompositeDecoder b8 = decoder.b(a8);
        String str3 = null;
        if (b8.p()) {
            String m8 = b8.m(a8, 0);
            String m9 = b8.m(a8, 1);
            StringSerializer stringSerializer = StringSerializer.f52262a;
            obj = b8.n(a8, 2, stringSerializer, null);
            obj2 = b8.n(a8, 3, stringSerializer, null);
            obj3 = b8.y(a8, 4, OrderHandleNet$$serializer.f39233a, null);
            long f8 = b8.f(a8, 5);
            obj4 = b8.y(a8, 6, TextMessageSerializer.f39340c, null);
            j8 = f8;
            i8 = 127;
            str2 = m8;
            str = m9;
        } else {
            Object obj5 = null;
            Object obj6 = null;
            Object obj7 = null;
            j8 = 0;
            int i9 = 0;
            boolean z7 = true;
            String str4 = null;
            Object obj8 = null;
            while (z7) {
                int o8 = b8.o(a8);
                switch (o8) {
                    case -1:
                        z7 = false;
                        continue;
                    case 0:
                        str3 = b8.m(a8, 0);
                        i9 |= 1;
                        continue;
                    case 1:
                        str4 = b8.m(a8, 1);
                        i9 |= 2;
                        break;
                    case 2:
                        obj8 = b8.n(a8, 2, StringSerializer.f52262a, obj8);
                        i9 |= 4;
                        break;
                    case 3:
                        obj5 = b8.n(a8, 3, StringSerializer.f52262a, obj5);
                        i9 |= 8;
                        break;
                    case 4:
                        obj6 = b8.y(a8, 4, OrderHandleNet$$serializer.f39233a, obj6);
                        i9 |= 16;
                        break;
                    case 5:
                        j8 = b8.f(a8, 5);
                        i9 |= 32;
                        break;
                    case 6:
                        obj7 = b8.y(a8, 6, TextMessageSerializer.f39340c, obj7);
                        i9 |= 64;
                        break;
                    default:
                        throw new UnknownFieldException(o8);
                }
            }
            obj = obj8;
            obj2 = obj5;
            obj3 = obj6;
            obj4 = obj7;
            str = str4;
            str2 = str3;
            i8 = i9;
        }
        b8.c(a8);
        return new ChatPushMessageNet(i8, str2, str, (String) obj, (String) obj2, (OrderHandleNet) obj3, j8, (MessageEventBase) obj4, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: g */
    public void c(Encoder encoder, ChatPushMessageNet value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        SerialDescriptor a8 = a();
        CompositeEncoder b8 = encoder.b(a8);
        ChatPushMessageNet.g(value, b8, a8);
        b8.c(a8);
    }
}
