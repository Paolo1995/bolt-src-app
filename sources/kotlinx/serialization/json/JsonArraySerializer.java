package kotlinx.serialization.json;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: JsonElementSerializers.kt */
/* loaded from: classes5.dex */
public final class JsonArraySerializer implements KSerializer<JsonArray> {

    /* renamed from: a  reason: collision with root package name */
    public static final JsonArraySerializer f52305a = new JsonArraySerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f52306b = JsonArrayDescriptor.f52307b;

    /* compiled from: JsonElementSerializers.kt */
    /* loaded from: classes5.dex */
    private static final class JsonArrayDescriptor implements SerialDescriptor {

        /* renamed from: b  reason: collision with root package name */
        public static final JsonArrayDescriptor f52307b = new JsonArrayDescriptor();

        /* renamed from: c  reason: collision with root package name */
        private static final String f52308c = "kotlinx.serialization.json.JsonArray";

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ SerialDescriptor f52309a = BuiltinSerializersKt.h(JsonElementSerializer.f52337a).a();

        private JsonArrayDescriptor() {
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public boolean b() {
            return this.f52309a.b();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public int c(String name) {
            Intrinsics.f(name, "name");
            return this.f52309a.c(name);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public SerialKind d() {
            return this.f52309a.d();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public int e() {
            return this.f52309a.e();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public String f(int i8) {
            return this.f52309a.f(i8);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public List<Annotation> g(int i8) {
            return this.f52309a.g(i8);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public List<Annotation> getAnnotations() {
            return this.f52309a.getAnnotations();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public SerialDescriptor h(int i8) {
            return this.f52309a.h(i8);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public String i() {
            return f52308c;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public boolean isInline() {
            return this.f52309a.isInline();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public boolean j(int i8) {
            return this.f52309a.j(i8);
        }
    }

    private JsonArraySerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f52306b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public JsonArray b(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        JsonElementSerializersKt.b(decoder);
        return new JsonArray((List) BuiltinSerializersKt.h(JsonElementSerializer.f52337a).b(decoder));
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: g */
    public void c(Encoder encoder, JsonArray value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        JsonElementSerializersKt.c(encoder);
        BuiltinSerializersKt.h(JsonElementSerializer.f52337a).c(encoder, value);
    }
}
