package kotlinx.serialization.json;

import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.UStringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.internal.JsonExceptionsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JsonElementSerializers.kt */
/* loaded from: classes5.dex */
public final class JsonLiteralSerializer implements KSerializer<JsonLiteral> {

    /* renamed from: a  reason: collision with root package name */
    public static final JsonLiteralSerializer f52348a = new JsonLiteralSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f52349b = SerialDescriptorsKt.a("kotlinx.serialization.json.JsonLiteral", PrimitiveKind.STRING.f52100a);

    private JsonLiteralSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f52349b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public JsonLiteral b(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        JsonElement g8 = JsonElementSerializersKt.d(decoder).g();
        if (g8 instanceof JsonLiteral) {
            return (JsonLiteral) g8;
        }
        throw JsonExceptionsKt.e(-1, "Unexpected JSON element, expected JsonLiteral, had " + Reflection.b(g8.getClass()), g8.toString());
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: g */
    public void c(Encoder encoder, JsonLiteral value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        JsonElementSerializersKt.h(encoder);
        if (value.d()) {
            encoder.F(value.b());
            return;
        }
        Long l8 = JsonElementKt.l(value);
        if (l8 != null) {
            encoder.m(l8.longValue());
            return;
        }
        ULong h8 = UStringsKt.h(value.b());
        if (h8 != null) {
            encoder.l(BuiltinSerializersKt.w(ULong.f50842g).a()).m(h8.j());
            return;
        }
        Double f8 = JsonElementKt.f(value);
        if (f8 != null) {
            encoder.g(f8.doubleValue());
            return;
        }
        Boolean c8 = JsonElementKt.c(value);
        if (c8 != null) {
            encoder.r(c8.booleanValue());
        } else {
            encoder.F(value.b());
        }
    }
}
