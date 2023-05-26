package kotlinx.serialization.json;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.internal.JsonExceptionsKt;

/* compiled from: JsonElementSerializers.kt */
/* loaded from: classes5.dex */
public final class JsonPrimitiveSerializer implements KSerializer<JsonPrimitive> {

    /* renamed from: a  reason: collision with root package name */
    public static final JsonPrimitiveSerializer f52362a = new JsonPrimitiveSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f52363b = SerialDescriptorsKt.d("kotlinx.serialization.json.JsonPrimitive", PrimitiveKind.STRING.f52100a, new SerialDescriptor[0], null, 8, null);

    private JsonPrimitiveSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f52363b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public JsonPrimitive b(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        JsonElement g8 = JsonElementSerializersKt.d(decoder).g();
        if (g8 instanceof JsonPrimitive) {
            return (JsonPrimitive) g8;
        }
        throw JsonExceptionsKt.e(-1, "Unexpected JSON element, expected JsonPrimitive, had " + Reflection.b(g8.getClass()), g8.toString());
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: g */
    public void c(Encoder encoder, JsonPrimitive value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        JsonElementSerializersKt.c(encoder);
        if (value instanceof JsonNull) {
            encoder.e(JsonNullSerializer.f52353a, JsonNull.INSTANCE);
        } else {
            encoder.e(JsonLiteralSerializer.f52348a, (JsonLiteral) value);
        }
    }
}
