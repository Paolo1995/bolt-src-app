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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.simpleframework.xml.strategy.Name;

/* compiled from: IncomingChatEvent.kt */
/* loaded from: classes5.dex */
public final class ServiceMessageEvent$$serializer implements GeneratedSerializer<ServiceMessageEvent> {

    /* renamed from: a  reason: collision with root package name */
    public static final ServiceMessageEvent$$serializer f39297a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ SerialDescriptor f39298b;

    static {
        ServiceMessageEvent$$serializer serviceMessageEvent$$serializer = new ServiceMessageEvent$$serializer();
        f39297a = serviceMessageEvent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("service_message", serviceMessageEvent$$serializer, 6);
        pluginGeneratedSerialDescriptor.l("status", true);
        pluginGeneratedSerialDescriptor.l(Name.MARK, false);
        pluginGeneratedSerialDescriptor.l("date", false);
        pluginGeneratedSerialDescriptor.l("text_html", false);
        pluginGeneratedSerialDescriptor.l("silent", false);
        pluginGeneratedSerialDescriptor.l("sender", true);
        f39298b = pluginGeneratedSerialDescriptor;
    }

    private ServiceMessageEvent$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f39298b;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] d() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] e() {
        StringSerializer stringSerializer = StringSerializer.f52262a;
        return new KSerializer[]{MessageStatusNet.Companion.serializer(), stringSerializer, LongSerializer.f52202a, stringSerializer, BooleanSerializer.f52132a, BuiltinSerializersKt.t(ChatMessageSender$$serializer.f39165a)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public ServiceMessageEvent b(Decoder decoder) {
        int i8;
        String str;
        Object obj;
        long j8;
        boolean z7;
        Object obj2;
        String str2;
        Intrinsics.f(decoder, "decoder");
        SerialDescriptor a8 = a();
        CompositeDecoder b8 = decoder.b(a8);
        int i9 = 5;
        if (b8.p()) {
            obj2 = b8.y(a8, 0, MessageStatusNet.Companion.serializer(), null);
            String m8 = b8.m(a8, 1);
            long f8 = b8.f(a8, 2);
            String m9 = b8.m(a8, 3);
            boolean C = b8.C(a8, 4);
            obj = b8.n(a8, 5, ChatMessageSender$$serializer.f39165a, null);
            z7 = C;
            str = m8;
            j8 = f8;
            i8 = 63;
            str2 = m9;
        } else {
            String str3 = null;
            Object obj3 = null;
            long j9 = 0;
            boolean z8 = false;
            boolean z9 = true;
            Object obj4 = null;
            String str4 = null;
            int i10 = 0;
            while (z9) {
                int o8 = b8.o(a8);
                switch (o8) {
                    case -1:
                        i9 = 5;
                        z9 = false;
                        continue;
                    case 0:
                        obj4 = b8.y(a8, 0, MessageStatusNet.Companion.serializer(), obj4);
                        i10 |= 1;
                        i9 = 5;
                        break;
                    case 1:
                        str4 = b8.m(a8, 1);
                        i10 |= 2;
                        break;
                    case 2:
                        j9 = b8.f(a8, 2);
                        i10 |= 4;
                        break;
                    case 3:
                        str3 = b8.m(a8, 3);
                        i10 |= 8;
                        break;
                    case 4:
                        z8 = b8.C(a8, 4);
                        i10 |= 16;
                        break;
                    case 5:
                        obj3 = b8.n(a8, i9, ChatMessageSender$$serializer.f39165a, obj3);
                        i10 |= 32;
                        break;
                    default:
                        throw new UnknownFieldException(o8);
                }
            }
            i8 = i10;
            str = str4;
            obj = obj3;
            j8 = j9;
            z7 = z8;
            obj2 = obj4;
            str2 = str3;
        }
        b8.c(a8);
        return new ServiceMessageEvent(i8, (MessageStatusNet) obj2, str, j8, str2, z7, (ChatMessageSender) obj, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: g */
    public void c(Encoder encoder, ServiceMessageEvent value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        SerialDescriptor a8 = a();
        CompositeEncoder b8 = encoder.b(a8);
        ServiceMessageEvent.i(value, b8, a8);
        b8.c(a8);
    }
}
