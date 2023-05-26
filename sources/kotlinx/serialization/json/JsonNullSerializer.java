package kotlinx.serialization.json;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.internal.JsonDecodingException;

/* compiled from: JsonElementSerializers.kt */
/* loaded from: classes5.dex */
public final class JsonNullSerializer implements KSerializer<JsonNull> {

    /* renamed from: a  reason: collision with root package name */
    public static final JsonNullSerializer f52353a = new JsonNullSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f52354b = SerialDescriptorsKt.d("kotlinx.serialization.json.JsonNull", SerialKind.ENUM.f52123a, new SerialDescriptor[0], null, 8, null);

    private JsonNullSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f52354b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public JsonNull b(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        JsonElementSerializersKt.g(decoder);
        if (!decoder.D()) {
            decoder.j();
            return JsonNull.INSTANCE;
        }
        throw new JsonDecodingException("Expected 'null' literal");
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: g */
    public void c(Encoder encoder, JsonNull value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        JsonElementSerializersKt.h(encoder);
        encoder.o();
    }
}
