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

/* compiled from: TranslationInfoNet.kt */
/* loaded from: classes5.dex */
public final class TranslationInfoNet$$serializer implements GeneratedSerializer<TranslationInfoNet> {

    /* renamed from: a  reason: collision with root package name */
    public static final TranslationInfoNet$$serializer f39310a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ SerialDescriptor f39311b;

    static {
        TranslationInfoNet$$serializer translationInfoNet$$serializer = new TranslationInfoNet$$serializer();
        f39310a = translationInfoNet$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("eu.bolt.chat.network.data.TranslationInfoNet", translationInfoNet$$serializer, 2);
        pluginGeneratedSerialDescriptor.l("text", false);
        pluginGeneratedSerialDescriptor.l("attribution", false);
        f39311b = pluginGeneratedSerialDescriptor;
    }

    private TranslationInfoNet$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f39311b;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] d() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] e() {
        return new KSerializer[]{StringSerializer.f52262a, AttributionInfoNet$$serializer.f39143a};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public TranslationInfoNet b(Decoder decoder) {
        String str;
        Object obj;
        int i8;
        Intrinsics.f(decoder, "decoder");
        SerialDescriptor a8 = a();
        CompositeDecoder b8 = decoder.b(a8);
        if (b8.p()) {
            str = b8.m(a8, 0);
            obj = b8.y(a8, 1, AttributionInfoNet$$serializer.f39143a, null);
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
                            obj2 = b8.y(a8, 1, AttributionInfoNet$$serializer.f39143a, obj2);
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
        return new TranslationInfoNet(i8, str, (AttributionInfoNet) obj, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: g */
    public void c(Encoder encoder, TranslationInfoNet value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        SerialDescriptor a8 = a();
        CompositeEncoder b8 = encoder.b(a8);
        TranslationInfoNet.c(value, b8, a8);
        b8.c(a8);
    }
}
