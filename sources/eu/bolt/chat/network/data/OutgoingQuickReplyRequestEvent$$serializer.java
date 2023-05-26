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

/* compiled from: OutgoingChatEvent.kt */
/* loaded from: classes5.dex */
public final class OutgoingQuickReplyRequestEvent$$serializer implements GeneratedSerializer<OutgoingQuickReplyRequestEvent> {

    /* renamed from: a  reason: collision with root package name */
    public static final OutgoingQuickReplyRequestEvent$$serializer f39260a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ SerialDescriptor f39261b;

    static {
        OutgoingQuickReplyRequestEvent$$serializer outgoingQuickReplyRequestEvent$$serializer = new OutgoingQuickReplyRequestEvent$$serializer();
        f39260a = outgoingQuickReplyRequestEvent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("request_quick_reply_suggestions", outgoingQuickReplyRequestEvent$$serializer, 1);
        pluginGeneratedSerialDescriptor.l(Name.MARK, false);
        f39261b = pluginGeneratedSerialDescriptor;
    }

    private OutgoingQuickReplyRequestEvent$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f39261b;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] d() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] e() {
        return new KSerializer[]{StringSerializer.f52262a};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public OutgoingQuickReplyRequestEvent b(Decoder decoder) {
        String str;
        Intrinsics.f(decoder, "decoder");
        SerialDescriptor a8 = a();
        CompositeDecoder b8 = decoder.b(a8);
        int i8 = 1;
        if (b8.p()) {
            str = b8.m(a8, 0);
        } else {
            str = null;
            int i9 = 0;
            while (i8 != 0) {
                int o8 = b8.o(a8);
                if (o8 != -1) {
                    if (o8 == 0) {
                        str = b8.m(a8, 0);
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
        return new OutgoingQuickReplyRequestEvent(i8, str, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: g */
    public void c(Encoder encoder, OutgoingQuickReplyRequestEvent value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        SerialDescriptor a8 = a();
        CompositeEncoder b8 = encoder.b(a8);
        OutgoingQuickReplyRequestEvent.d(value, b8, a8);
        b8.c(a8);
    }
}
