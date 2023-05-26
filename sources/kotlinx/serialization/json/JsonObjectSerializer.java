package kotlinx.serialization.json;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: JsonElementSerializers.kt */
/* loaded from: classes5.dex */
public final class JsonObjectSerializer implements KSerializer<JsonObject> {

    /* renamed from: a  reason: collision with root package name */
    public static final JsonObjectSerializer f52357a = new JsonObjectSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f52358b = JsonObjectDescriptor.f52359b;

    /* compiled from: JsonElementSerializers.kt */
    /* loaded from: classes5.dex */
    private static final class JsonObjectDescriptor implements SerialDescriptor {

        /* renamed from: b  reason: collision with root package name */
        public static final JsonObjectDescriptor f52359b = new JsonObjectDescriptor();

        /* renamed from: c  reason: collision with root package name */
        private static final String f52360c = "kotlinx.serialization.json.JsonObject";

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ SerialDescriptor f52361a = BuiltinSerializersKt.k(BuiltinSerializersKt.H(StringCompanionObject.f51021a), JsonElementSerializer.f52337a).a();

        private JsonObjectDescriptor() {
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public boolean b() {
            return this.f52361a.b();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public int c(String name) {
            Intrinsics.f(name, "name");
            return this.f52361a.c(name);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public SerialKind d() {
            return this.f52361a.d();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public int e() {
            return this.f52361a.e();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public String f(int i8) {
            return this.f52361a.f(i8);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public List<Annotation> g(int i8) {
            return this.f52361a.g(i8);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public List<Annotation> getAnnotations() {
            return this.f52361a.getAnnotations();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public SerialDescriptor h(int i8) {
            return this.f52361a.h(i8);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public String i() {
            return f52360c;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public boolean isInline() {
            return this.f52361a.isInline();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public boolean j(int i8) {
            return this.f52361a.j(i8);
        }
    }

    private JsonObjectSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return f52358b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: f */
    public JsonObject b(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        JsonElementSerializersKt.g(decoder);
        return new JsonObject((Map) BuiltinSerializersKt.k(BuiltinSerializersKt.H(StringCompanionObject.f51021a), JsonElementSerializer.f52337a).b(decoder));
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: g */
    public void c(Encoder encoder, JsonObject value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        JsonElementSerializersKt.h(encoder);
        BuiltinSerializersKt.k(BuiltinSerializersKt.H(StringCompanionObject.f51021a), JsonElementSerializer.f52337a).c(encoder, value);
    }
}
