package eu.bolt.chat.network.data;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.simpleframework.xml.strategy.Name;

/* compiled from: IncomingChatEvent.kt */
/* loaded from: classes5.dex */
public final class IncomingChatDomainEvent$$serializer implements GeneratedSerializer<IncomingChatDomainEvent> {

    /* renamed from: a  reason: collision with root package name */
    public static final IncomingChatDomainEvent$$serializer f39205a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ SerialDescriptor f39206b;

    static {
        IncomingChatDomainEvent$$serializer incomingChatDomainEvent$$serializer = new IncomingChatDomainEvent$$serializer();
        f39205a = incomingChatDomainEvent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("eu.bolt.chat.network.data.IncomingChatDomainEvent", incomingChatDomainEvent$$serializer, 2);
        pluginGeneratedSerialDescriptor.l(Name.MARK, false);
        pluginGeneratedSerialDescriptor.l("chat", false);
        f39206b = pluginGeneratedSerialDescriptor;
    }

    private IncomingChatDomainEvent$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f39206b;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] d() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] e() {
        return new KSerializer[]{StringSerializer.f52262a, IncomingChatEvent$$serializer.f39209a};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public IncomingChatDomainEvent b(Decoder decoder) {
        String str;
        Object obj;
        int i8;
        Intrinsics.f(decoder, "decoder");
        SerialDescriptor a8 = a();
        CompositeDecoder b8 = decoder.b(a8);
        if (b8.p()) {
            str = b8.m(a8, 0);
            obj = b8.y(a8, 1, IncomingChatEvent$$serializer.f39209a, null);
            i8 = 3;
        } else {
            str = null;
            Object obj2 = null;
            int i9 = 0;
            boolean z7 = true;
            while (z7) {
                int o8 = b8.o(a8);
                if (o8 != -1) {
                    if (o8 != 0) {
                        if (o8 == 1) {
                            obj2 = b8.y(a8, 1, IncomingChatEvent$$serializer.f39209a, obj2);
                            i9 |= 2;
                        } else {
                            throw new UnknownFieldException(o8);
                        }
                    } else {
                        str = b8.m(a8, 0);
                        i9 |= 1;
                    }
                } else {
                    z7 = false;
                }
            }
            obj = obj2;
            i8 = i9;
        }
        b8.c(a8);
        return new IncomingChatDomainEvent(i8, str, (IncomingChatEvent) obj, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: g */
    public void c(Encoder encoder, IncomingChatDomainEvent value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        SerialDescriptor a8 = a();
        CompositeEncoder b8 = encoder.b(a8);
        IncomingChatDomainEvent.c(value, b8, a8);
        b8.c(a8);
    }
}
