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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.simpleframework.xml.strategy.Name;

/* compiled from: OutgoingChatEvent.kt */
/* loaded from: classes5.dex */
public final class OutgoingChatDomainEvent$$serializer implements GeneratedSerializer<OutgoingChatDomainEvent> {

    /* renamed from: a  reason: collision with root package name */
    public static final OutgoingChatDomainEvent$$serializer f39239a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ SerialDescriptor f39240b;

    static {
        OutgoingChatDomainEvent$$serializer outgoingChatDomainEvent$$serializer = new OutgoingChatDomainEvent$$serializer();
        f39239a = outgoingChatDomainEvent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("eu.bolt.chat.network.data.OutgoingChatDomainEvent", outgoingChatDomainEvent$$serializer, 4);
        pluginGeneratedSerialDescriptor.l(Name.MARK, false);
        pluginGeneratedSerialDescriptor.l("domain", true);
        pluginGeneratedSerialDescriptor.l("chat", false);
        pluginGeneratedSerialDescriptor.l("client_context", false);
        f39240b = pluginGeneratedSerialDescriptor;
    }

    private OutgoingChatDomainEvent$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f39240b;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] d() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] e() {
        StringSerializer stringSerializer = StringSerializer.f52262a;
        return new KSerializer[]{stringSerializer, stringSerializer, OutgoingChatEvent$$serializer.f39243a, ClientContext$$serializer.f39184a};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public OutgoingChatDomainEvent b(Decoder decoder) {
        String str;
        int i8;
        String str2;
        Object obj;
        Object obj2;
        Intrinsics.f(decoder, "decoder");
        SerialDescriptor a8 = a();
        CompositeDecoder b8 = decoder.b(a8);
        if (b8.p()) {
            String m8 = b8.m(a8, 0);
            String m9 = b8.m(a8, 1);
            obj = b8.y(a8, 2, OutgoingChatEvent$$serializer.f39243a, null);
            obj2 = b8.y(a8, 3, ClientContext$$serializer.f39184a, null);
            str = m8;
            str2 = m9;
            i8 = 15;
        } else {
            String str3 = null;
            String str4 = null;
            Object obj3 = null;
            Object obj4 = null;
            int i9 = 0;
            boolean z7 = true;
            while (z7) {
                int o8 = b8.o(a8);
                if (o8 != -1) {
                    if (o8 != 0) {
                        if (o8 != 1) {
                            if (o8 != 2) {
                                if (o8 == 3) {
                                    obj4 = b8.y(a8, 3, ClientContext$$serializer.f39184a, obj4);
                                    i9 |= 8;
                                } else {
                                    throw new UnknownFieldException(o8);
                                }
                            } else {
                                obj3 = b8.y(a8, 2, OutgoingChatEvent$$serializer.f39243a, obj3);
                                i9 |= 4;
                            }
                        } else {
                            str4 = b8.m(a8, 1);
                            i9 |= 2;
                        }
                    } else {
                        str3 = b8.m(a8, 0);
                        i9 |= 1;
                    }
                } else {
                    z7 = false;
                }
            }
            str = str3;
            i8 = i9;
            str2 = str4;
            obj = obj3;
            obj2 = obj4;
        }
        b8.c(a8);
        return new OutgoingChatDomainEvent(i8, str, str2, (OutgoingChatEvent) obj, (ClientContext) obj2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: g */
    public void c(Encoder encoder, OutgoingChatDomainEvent value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        SerialDescriptor a8 = a();
        CompositeEncoder b8 = encoder.b(a8);
        OutgoingChatDomainEvent.a(value, b8, a8);
        b8.c(a8);
    }
}
