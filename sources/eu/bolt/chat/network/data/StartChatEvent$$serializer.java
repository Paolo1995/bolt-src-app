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
public final class StartChatEvent$$serializer implements GeneratedSerializer<StartChatEvent> {

    /* renamed from: a  reason: collision with root package name */
    public static final StartChatEvent$$serializer f39306a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ SerialDescriptor f39307b;

    static {
        StartChatEvent$$serializer startChatEvent$$serializer = new StartChatEvent$$serializer();
        f39306a = startChatEvent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("start", startChatEvent$$serializer, 7);
        pluginGeneratedSerialDescriptor.l(Name.MARK, false);
        pluginGeneratedSerialDescriptor.l("date", false);
        pluginGeneratedSerialDescriptor.l("title", false);
        pluginGeneratedSerialDescriptor.l("description", false);
        pluginGeneratedSerialDescriptor.l("thumbnail_url", true);
        pluginGeneratedSerialDescriptor.l("order_handle", false);
        pluginGeneratedSerialDescriptor.l("sender", true);
        f39307b = pluginGeneratedSerialDescriptor;
    }

    private StartChatEvent$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f39307b;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] d() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] e() {
        StringSerializer stringSerializer = StringSerializer.f52262a;
        return new KSerializer[]{stringSerializer, LongSerializer.f52202a, stringSerializer, stringSerializer, BuiltinSerializersKt.t(stringSerializer), OrderHandleNet$$serializer.f39233a, BuiltinSerializersKt.t(ChatMessageSender$$serializer.f39165a)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public StartChatEvent b(Decoder decoder) {
        long j8;
        String str;
        String str2;
        Object obj;
        Object obj2;
        int i8;
        Object obj3;
        String str3;
        Intrinsics.f(decoder, "decoder");
        SerialDescriptor a8 = a();
        CompositeDecoder b8 = decoder.b(a8);
        if (b8.p()) {
            String m8 = b8.m(a8, 0);
            long f8 = b8.f(a8, 1);
            String m9 = b8.m(a8, 2);
            String m10 = b8.m(a8, 3);
            obj3 = b8.n(a8, 4, StringSerializer.f52262a, null);
            obj = b8.y(a8, 5, OrderHandleNet$$serializer.f39233a, null);
            obj2 = b8.n(a8, 6, ChatMessageSender$$serializer.f39165a, null);
            str3 = m8;
            str2 = m10;
            str = m9;
            j8 = f8;
            i8 = 127;
        } else {
            j8 = 0;
            String str4 = null;
            Object obj4 = null;
            Object obj5 = null;
            str = null;
            str2 = null;
            Object obj6 = null;
            int i9 = 0;
            boolean z7 = true;
            while (z7) {
                int o8 = b8.o(a8);
                switch (o8) {
                    case -1:
                        z7 = false;
                        break;
                    case 0:
                        i9 |= 1;
                        str4 = b8.m(a8, 0);
                        continue;
                    case 1:
                        i9 |= 2;
                        j8 = b8.f(a8, 1);
                        continue;
                    case 2:
                        str = b8.m(a8, 2);
                        i9 |= 4;
                        continue;
                    case 3:
                        str2 = b8.m(a8, 3);
                        i9 |= 8;
                        break;
                    case 4:
                        obj6 = b8.n(a8, 4, StringSerializer.f52262a, obj6);
                        i9 |= 16;
                        break;
                    case 5:
                        obj4 = b8.y(a8, 5, OrderHandleNet$$serializer.f39233a, obj4);
                        i9 |= 32;
                        break;
                    case 6:
                        obj5 = b8.n(a8, 6, ChatMessageSender$$serializer.f39165a, obj5);
                        i9 |= 64;
                        break;
                    default:
                        throw new UnknownFieldException(o8);
                }
            }
            obj = obj4;
            obj2 = obj5;
            i8 = i9;
            obj3 = obj6;
            str3 = str4;
        }
        b8.c(a8);
        return new StartChatEvent(i8, str3, j8, str, str2, (String) obj3, (OrderHandleNet) obj, (ChatMessageSender) obj2, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: g */
    public void c(Encoder encoder, StartChatEvent value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        SerialDescriptor a8 = a();
        CompositeEncoder b8 = encoder.b(a8);
        StartChatEvent.j(value, b8, a8);
        b8.c(a8);
    }
}
