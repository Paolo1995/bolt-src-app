package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.UStringsKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.AbstractDecoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.modules.SerializersModule;

/* compiled from: StreamingJsonDecoder.kt */
/* loaded from: classes5.dex */
public final class JsonDecoderForUnsignedTypes extends AbstractDecoder {

    /* renamed from: a  reason: collision with root package name */
    private final AbstractJsonLexer f52384a;

    /* renamed from: b  reason: collision with root package name */
    private final SerializersModule f52385b;

    public JsonDecoderForUnsignedTypes(AbstractJsonLexer lexer, Json json) {
        Intrinsics.f(lexer, "lexer");
        Intrinsics.f(json, "json");
        this.f52384a = lexer;
        this.f52385b = json.a();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public byte H() {
        AbstractJsonLexer abstractJsonLexer = this.f52384a;
        String s7 = abstractJsonLexer.s();
        try {
            return UStringsKt.a(s7);
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.y(abstractJsonLexer, "Failed to parse type 'UByte' for input '" + s7 + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public SerializersModule a() {
        return this.f52385b;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public int h() {
        AbstractJsonLexer abstractJsonLexer = this.f52384a;
        String s7 = abstractJsonLexer.s();
        try {
            return UStringsKt.d(s7);
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.y(abstractJsonLexer, "Failed to parse type 'UInt' for input '" + s7 + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public long l() {
        AbstractJsonLexer abstractJsonLexer = this.f52384a;
        String s7 = abstractJsonLexer.s();
        try {
            return UStringsKt.g(s7);
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.y(abstractJsonLexer, "Failed to parse type 'ULong' for input '" + s7 + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public int o(SerialDescriptor descriptor) {
        Intrinsics.f(descriptor, "descriptor");
        throw new IllegalStateException("unsupported".toString());
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public short s() {
        AbstractJsonLexer abstractJsonLexer = this.f52384a;
        String s7 = abstractJsonLexer.s();
        try {
            return UStringsKt.j(s7);
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.y(abstractJsonLexer, "Failed to parse type 'UShort' for input '" + s7 + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }
}
