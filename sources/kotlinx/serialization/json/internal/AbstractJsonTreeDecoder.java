package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt___StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.internal.NamedValueDecoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TreeJsonDecoder.kt */
/* loaded from: classes5.dex */
public abstract class AbstractJsonTreeDecoder extends NamedValueDecoder implements JsonDecoder {

    /* renamed from: c  reason: collision with root package name */
    private final Json f52368c;

    /* renamed from: d  reason: collision with root package name */
    private final JsonElement f52369d;

    /* renamed from: e  reason: collision with root package name */
    protected final JsonConfiguration f52370e;

    private AbstractJsonTreeDecoder(Json json, JsonElement jsonElement) {
        this.f52368c = json;
        this.f52369d = jsonElement;
        this.f52370e = d().g();
    }

    public /* synthetic */ AbstractJsonTreeDecoder(Json json, JsonElement jsonElement, DefaultConstructorMarker defaultConstructorMarker) {
        this(json, jsonElement);
    }

    private final JsonLiteral f0(JsonPrimitive jsonPrimitive, String str) {
        JsonLiteral jsonLiteral;
        if (jsonPrimitive instanceof JsonLiteral) {
            jsonLiteral = (JsonLiteral) jsonPrimitive;
        } else {
            jsonLiteral = null;
        }
        if (jsonLiteral != null) {
            return jsonLiteral;
        }
        throw JsonExceptionsKt.d(-1, "Unexpected 'null' when " + str + " was expected");
    }

    private final JsonElement h0() {
        JsonElement g02;
        String W = W();
        if (W == null || (g02 = g0(W)) == null) {
            return v0();
        }
        return g02;
    }

    private final Void w0(String str) {
        throw JsonExceptionsKt.e(-1, "Failed to parse '" + str + '\'', h0().toString());
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder
    public boolean D() {
        return !(h0() instanceof JsonNull);
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder
    public <T> T G(DeserializationStrategy<T> deserializer) {
        Intrinsics.f(deserializer, "deserializer");
        return (T) PolymorphicKt.d(this, deserializer);
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public SerializersModule a() {
        return d().a();
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder
    public CompositeDecoder b(SerialDescriptor descriptor) {
        boolean z7;
        Intrinsics.f(descriptor, "descriptor");
        JsonElement h02 = h0();
        SerialKind d8 = descriptor.d();
        if (Intrinsics.a(d8, StructureKind.LIST.f52125a)) {
            z7 = true;
        } else {
            z7 = d8 instanceof PolymorphicKind;
        }
        if (z7) {
            Json d9 = d();
            if (h02 instanceof JsonArray) {
                return new JsonTreeListDecoder(d9, (JsonArray) h02);
            }
            throw JsonExceptionsKt.d(-1, "Expected " + Reflection.b(JsonArray.class) + " as the serialized body of " + descriptor.i() + ", but had " + Reflection.b(h02.getClass()));
        } else if (Intrinsics.a(d8, StructureKind.MAP.f52126a)) {
            Json d10 = d();
            SerialDescriptor a8 = WriteModeKt.a(descriptor.h(0), d10.a());
            SerialKind d11 = a8.d();
            if (!(d11 instanceof PrimitiveKind) && !Intrinsics.a(d11, SerialKind.ENUM.f52123a)) {
                if (d10.g().b()) {
                    Json d12 = d();
                    if (h02 instanceof JsonArray) {
                        return new JsonTreeListDecoder(d12, (JsonArray) h02);
                    }
                    throw JsonExceptionsKt.d(-1, "Expected " + Reflection.b(JsonArray.class) + " as the serialized body of " + descriptor.i() + ", but had " + Reflection.b(h02.getClass()));
                }
                throw JsonExceptionsKt.c(a8);
            }
            Json d13 = d();
            if (h02 instanceof JsonObject) {
                return new JsonTreeMapDecoder(d13, (JsonObject) h02);
            }
            throw JsonExceptionsKt.d(-1, "Expected " + Reflection.b(JsonObject.class) + " as the serialized body of " + descriptor.i() + ", but had " + Reflection.b(h02.getClass()));
        } else {
            Json d14 = d();
            if (h02 instanceof JsonObject) {
                return new JsonTreeDecoder(d14, (JsonObject) h02, null, null, 12, null);
            }
            throw JsonExceptionsKt.d(-1, "Expected " + Reflection.b(JsonObject.class) + " as the serialized body of " + descriptor.i() + ", but had " + Reflection.b(h02.getClass()));
        }
    }

    @Override // kotlinx.serialization.internal.NamedValueDecoder
    protected String b0(String parentName, String childName) {
        Intrinsics.f(parentName, "parentName");
        Intrinsics.f(childName, "childName");
        return childName;
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public void c(SerialDescriptor descriptor) {
        Intrinsics.f(descriptor, "descriptor");
    }

    @Override // kotlinx.serialization.json.JsonDecoder
    public Json d() {
        return this.f52368c;
    }

    @Override // kotlinx.serialization.json.JsonDecoder
    public JsonElement g() {
        return h0();
    }

    protected abstract JsonElement g0(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* renamed from: i0 */
    public boolean J(String tag) {
        Intrinsics.f(tag, "tag");
        JsonPrimitive u02 = u0(tag);
        if (!d().g().l() && f0(u02, "boolean").d()) {
            throw JsonExceptionsKt.e(-1, "Boolean literal for key '" + tag + "' should be unquoted.\nUse 'isLenient = true' in 'Json {}` builder to accept non-compliant JSON.", h0().toString());
        }
        try {
            Boolean c8 = JsonElementKt.c(u02);
            if (c8 != null) {
                return c8.booleanValue();
            }
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException unused) {
            w0("boolean");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* renamed from: j0 */
    public byte K(String tag) {
        Byte b8;
        Intrinsics.f(tag, "tag");
        try {
            int h8 = JsonElementKt.h(u0(tag));
            boolean z7 = false;
            if (-128 <= h8 && h8 <= 127) {
                z7 = true;
            }
            if (z7) {
                b8 = Byte.valueOf((byte) h8);
            } else {
                b8 = null;
            }
            if (b8 != null) {
                return b8.byteValue();
            }
            w0("byte");
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException unused) {
            w0("byte");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* renamed from: k0 */
    public char L(String tag) {
        char e12;
        Intrinsics.f(tag, "tag");
        try {
            e12 = StringsKt___StringsKt.e1(u0(tag).b());
            return e12;
        } catch (IllegalArgumentException unused) {
            w0("char");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* renamed from: l0 */
    public double M(String tag) {
        boolean z7;
        Intrinsics.f(tag, "tag");
        try {
            double e8 = JsonElementKt.e(u0(tag));
            if (!d().g().a()) {
                if (!Double.isInfinite(e8) && !Double.isNaN(e8)) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (!z7) {
                    throw JsonExceptionsKt.a(Double.valueOf(e8), tag, h0().toString());
                }
            }
            return e8;
        } catch (IllegalArgumentException unused) {
            w0("double");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* renamed from: m0 */
    public int N(String tag, SerialDescriptor enumDescriptor) {
        Intrinsics.f(tag, "tag");
        Intrinsics.f(enumDescriptor, "enumDescriptor");
        return JsonNamesMapKt.f(enumDescriptor, d(), u0(tag).b(), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* renamed from: n0 */
    public float O(String tag) {
        boolean z7;
        Intrinsics.f(tag, "tag");
        try {
            float g8 = JsonElementKt.g(u0(tag));
            if (!d().g().a()) {
                if (!Float.isInfinite(g8) && !Float.isNaN(g8)) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (!z7) {
                    throw JsonExceptionsKt.a(Float.valueOf(g8), tag, h0().toString());
                }
            }
            return g8;
        } catch (IllegalArgumentException unused) {
            w0("float");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* renamed from: o0 */
    public Decoder P(String tag, SerialDescriptor inlineDescriptor) {
        Intrinsics.f(tag, "tag");
        Intrinsics.f(inlineDescriptor, "inlineDescriptor");
        if (StreamingJsonEncoderKt.a(inlineDescriptor)) {
            return new JsonDecoderForUnsignedTypes(new StringJsonLexer(u0(tag).b()), d());
        }
        return super.P(tag, inlineDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* renamed from: p0 */
    public int Q(String tag) {
        Intrinsics.f(tag, "tag");
        try {
            return JsonElementKt.h(u0(tag));
        } catch (IllegalArgumentException unused) {
            w0("int");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* renamed from: q0 */
    public long R(String tag) {
        Intrinsics.f(tag, "tag");
        try {
            return JsonElementKt.k(u0(tag));
        } catch (IllegalArgumentException unused) {
            w0("long");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* renamed from: r0 */
    public boolean S(String tag) {
        Intrinsics.f(tag, "tag");
        if (g0(tag) != JsonNull.INSTANCE) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* renamed from: s0 */
    public short T(String tag) {
        Short sh;
        Intrinsics.f(tag, "tag");
        try {
            int h8 = JsonElementKt.h(u0(tag));
            boolean z7 = false;
            if (-32768 <= h8 && h8 <= 32767) {
                z7 = true;
            }
            if (z7) {
                sh = Short.valueOf((short) h8);
            } else {
                sh = null;
            }
            if (sh != null) {
                return sh.shortValue();
            }
            w0("short");
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException unused) {
            w0("short");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* renamed from: t0 */
    public String U(String tag) {
        Intrinsics.f(tag, "tag");
        JsonPrimitive u02 = u0(tag);
        if (!d().g().l() && !f0(u02, "string").d()) {
            throw JsonExceptionsKt.e(-1, "String literal for key '" + tag + "' should be quoted.\nUse 'isLenient = true' in 'Json {}` builder to accept non-compliant JSON.", h0().toString());
        } else if (!(u02 instanceof JsonNull)) {
            return u02.b();
        } else {
            throw JsonExceptionsKt.e(-1, "Unexpected 'null' value instead of string literal", h0().toString());
        }
    }

    protected final JsonPrimitive u0(String tag) {
        JsonPrimitive jsonPrimitive;
        Intrinsics.f(tag, "tag");
        JsonElement g02 = g0(tag);
        if (g02 instanceof JsonPrimitive) {
            jsonPrimitive = (JsonPrimitive) g02;
        } else {
            jsonPrimitive = null;
        }
        if (jsonPrimitive != null) {
            return jsonPrimitive;
        }
        throw JsonExceptionsKt.e(-1, "Expected JsonPrimitive at " + tag + ", found " + g02, h0().toString());
    }

    public JsonElement v0() {
        return this.f52369d;
    }
}
