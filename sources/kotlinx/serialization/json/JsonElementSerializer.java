package kotlinx.serialization.json;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: JsonElementSerializers.kt */
/* loaded from: classes5.dex */
public final class JsonElementSerializer implements KSerializer<JsonElement> {

    /* renamed from: a  reason: collision with root package name */
    public static final JsonElementSerializer f52337a = new JsonElementSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f52338b = SerialDescriptorsKt.c("kotlinx.serialization.json.JsonElement", PolymorphicKind.SEALED.f52091a, new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.serialization.json.JsonElementSerializer$descriptor$1
        public final void b(ClassSerialDescriptorBuilder buildSerialDescriptor) {
            SerialDescriptor f8;
            SerialDescriptor f9;
            SerialDescriptor f10;
            SerialDescriptor f11;
            SerialDescriptor f12;
            Intrinsics.f(buildSerialDescriptor, "$this$buildSerialDescriptor");
            f8 = JsonElementSerializersKt.f(new Function0<SerialDescriptor>() { // from class: kotlinx.serialization.json.JsonElementSerializer$descriptor$1.1
                @Override // kotlin.jvm.functions.Function0
                /* renamed from: b */
                public final SerialDescriptor invoke() {
                    return JsonPrimitiveSerializer.f52362a.a();
                }
            });
            ClassSerialDescriptorBuilder.b(buildSerialDescriptor, "JsonPrimitive", f8, null, false, 12, null);
            f9 = JsonElementSerializersKt.f(new Function0<SerialDescriptor>() { // from class: kotlinx.serialization.json.JsonElementSerializer$descriptor$1.2
                @Override // kotlin.jvm.functions.Function0
                /* renamed from: b */
                public final SerialDescriptor invoke() {
                    return JsonNullSerializer.f52353a.a();
                }
            });
            ClassSerialDescriptorBuilder.b(buildSerialDescriptor, "JsonNull", f9, null, false, 12, null);
            f10 = JsonElementSerializersKt.f(new Function0<SerialDescriptor>() { // from class: kotlinx.serialization.json.JsonElementSerializer$descriptor$1.3
                @Override // kotlin.jvm.functions.Function0
                /* renamed from: b */
                public final SerialDescriptor invoke() {
                    return JsonLiteralSerializer.f52348a.a();
                }
            });
            ClassSerialDescriptorBuilder.b(buildSerialDescriptor, "JsonLiteral", f10, null, false, 12, null);
            f11 = JsonElementSerializersKt.f(new Function0<SerialDescriptor>() { // from class: kotlinx.serialization.json.JsonElementSerializer$descriptor$1.4
                @Override // kotlin.jvm.functions.Function0
                /* renamed from: b */
                public final SerialDescriptor invoke() {
                    return JsonObjectSerializer.f52357a.a();
                }
            });
            ClassSerialDescriptorBuilder.b(buildSerialDescriptor, "JsonObject", f11, null, false, 12, null);
            f12 = JsonElementSerializersKt.f(new Function0<SerialDescriptor>() { // from class: kotlinx.serialization.json.JsonElementSerializer$descriptor$1.5
                @Override // kotlin.jvm.functions.Function0
                /* renamed from: b */
                public final SerialDescriptor invoke() {
                    return JsonArraySerializer.f52305a.a();
                }
            });
            ClassSerialDescriptorBuilder.b(buildSerialDescriptor, "JsonArray", f12, null, false, 12, null);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
            b(classSerialDescriptorBuilder);
            return Unit.f50853a;
        }
    });

    private JsonElementSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f52338b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public JsonElement b(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        return JsonElementSerializersKt.d(decoder).g();
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: g */
    public void c(Encoder encoder, JsonElement value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        JsonElementSerializersKt.h(encoder);
        if (value instanceof JsonPrimitive) {
            encoder.e(JsonPrimitiveSerializer.f52362a, value);
        } else if (value instanceof JsonObject) {
            encoder.e(JsonObjectSerializer.f52357a, value);
        } else if (value instanceof JsonArray) {
            encoder.e(JsonArraySerializer.f52305a, value);
        }
    }
}
