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

/* compiled from: ActiveChatNet.kt */
/* loaded from: classes5.dex */
public final class ActiveChatNet$$serializer implements GeneratedSerializer<ActiveChatNet> {

    /* renamed from: a  reason: collision with root package name */
    public static final ActiveChatNet$$serializer f39139a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ SerialDescriptor f39140b;

    static {
        ActiveChatNet$$serializer activeChatNet$$serializer = new ActiveChatNet$$serializer();
        f39139a = activeChatNet$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("eu.bolt.chat.network.data.ActiveChatNet", activeChatNet$$serializer, 6);
        pluginGeneratedSerialDescriptor.l("chat_id", false);
        pluginGeneratedSerialDescriptor.l("title", false);
        pluginGeneratedSerialDescriptor.l("description", true);
        pluginGeneratedSerialDescriptor.l("thumbnail_url", true);
        pluginGeneratedSerialDescriptor.l("order_handle", false);
        pluginGeneratedSerialDescriptor.l("start_date", false);
        f39140b = pluginGeneratedSerialDescriptor;
    }

    private ActiveChatNet$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f39140b;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] d() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] e() {
        StringSerializer stringSerializer = StringSerializer.f52262a;
        return new KSerializer[]{stringSerializer, stringSerializer, BuiltinSerializersKt.t(stringSerializer), BuiltinSerializersKt.t(stringSerializer), OrderHandleNet$$serializer.f39233a, LongSerializer.f52202a};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public ActiveChatNet b(Decoder decoder) {
        Object obj;
        Object obj2;
        Object obj3;
        long j8;
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
            str2 = m8;
            str = m9;
            j8 = b8.f(a8, 5);
            i8 = 63;
        } else {
            long j9 = 0;
            String str4 = null;
            Object obj4 = null;
            Object obj5 = null;
            Object obj6 = null;
            int i9 = 0;
            boolean z7 = true;
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
                        obj4 = b8.n(a8, 2, StringSerializer.f52262a, obj4);
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
                        j9 = b8.f(a8, 5);
                        i9 |= 32;
                        break;
                    default:
                        throw new UnknownFieldException(o8);
                }
            }
            obj = obj4;
            obj2 = obj5;
            obj3 = obj6;
            j8 = j9;
            str = str4;
            str2 = str3;
            i8 = i9;
        }
        b8.c(a8);
        return new ActiveChatNet(i8, str2, str, (String) obj, (String) obj2, (OrderHandleNet) obj3, j8, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: g */
    public void c(Encoder encoder, ActiveChatNet value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        SerialDescriptor a8 = a();
        CompositeEncoder b8 = encoder.b(a8);
        ActiveChatNet.f(value, b8, a8);
        b8.c(a8);
    }
}
