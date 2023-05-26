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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: ActiveChatListNet.kt */
/* loaded from: classes5.dex */
public final class ActiveChatListNet$$serializer implements GeneratedSerializer<ActiveChatListNet> {

    /* renamed from: a  reason: collision with root package name */
    public static final ActiveChatListNet$$serializer f39131a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ SerialDescriptor f39132b;

    static {
        ActiveChatListNet$$serializer activeChatListNet$$serializer = new ActiveChatListNet$$serializer();
        f39131a = activeChatListNet$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("eu.bolt.chat.network.data.ActiveChatListNet", activeChatListNet$$serializer, 1);
        pluginGeneratedSerialDescriptor.l("active_chats", true);
        f39132b = pluginGeneratedSerialDescriptor;
    }

    private ActiveChatListNet$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f39132b;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] d() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] e() {
        return new KSerializer[]{BuiltinSerializersKt.t(new ArrayListSerializer(ActiveChatNet$$serializer.f39139a))};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public ActiveChatListNet b(Decoder decoder) {
        Object obj;
        Intrinsics.f(decoder, "decoder");
        SerialDescriptor a8 = a();
        CompositeDecoder b8 = decoder.b(a8);
        int i8 = 1;
        if (b8.p()) {
            obj = b8.n(a8, 0, new ArrayListSerializer(ActiveChatNet$$serializer.f39139a), null);
        } else {
            obj = null;
            int i9 = 0;
            while (i8 != 0) {
                int o8 = b8.o(a8);
                if (o8 != -1) {
                    if (o8 == 0) {
                        obj = b8.n(a8, 0, new ArrayListSerializer(ActiveChatNet$$serializer.f39139a), obj);
                        i9 |= 1;
                    } else {
                        throw new UnknownFieldException(o8);
                    }
                } else {
                    i8 = 0;
                }
            }
            i8 = i9;
        }
        b8.c(a8);
        return new ActiveChatListNet(i8, (List) obj, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: g */
    public void c(Encoder encoder, ActiveChatListNet value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        SerialDescriptor a8 = a();
        CompositeEncoder b8 = encoder.b(a8);
        ActiveChatListNet.b(value, b8, a8);
        b8.c(a8);
    }
}
