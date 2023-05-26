package kotlinx.serialization.json.internal;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.AbstractDecoder;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.modules.SerializersModule;

/* compiled from: StreamingJsonDecoder.kt */
/* loaded from: classes5.dex */
public class StreamingJsonDecoder extends AbstractDecoder implements JsonDecoder {

    /* renamed from: a  reason: collision with root package name */
    private final Json f52423a;

    /* renamed from: b  reason: collision with root package name */
    private final WriteMode f52424b;

    /* renamed from: c  reason: collision with root package name */
    public final AbstractJsonLexer f52425c;

    /* renamed from: d  reason: collision with root package name */
    private final SerializersModule f52426d;

    /* renamed from: e  reason: collision with root package name */
    private int f52427e;

    /* renamed from: f  reason: collision with root package name */
    private DiscriminatorHolder f52428f;

    /* renamed from: g  reason: collision with root package name */
    private final JsonConfiguration f52429g;

    /* renamed from: h  reason: collision with root package name */
    private final JsonElementMarker f52430h;

    /* compiled from: StreamingJsonDecoder.kt */
    /* loaded from: classes5.dex */
    public static final class DiscriminatorHolder {

        /* renamed from: a  reason: collision with root package name */
        public String f52431a;

        public DiscriminatorHolder(String str) {
            this.f52431a = str;
        }
    }

    /* compiled from: StreamingJsonDecoder.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f52432a;

        static {
            int[] iArr = new int[WriteMode.values().length];
            try {
                iArr[WriteMode.LIST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WriteMode.MAP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WriteMode.POLY_OBJ.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[WriteMode.OBJ.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f52432a = iArr;
        }
    }

    public StreamingJsonDecoder(Json json, WriteMode mode, AbstractJsonLexer lexer, SerialDescriptor descriptor, DiscriminatorHolder discriminatorHolder) {
        JsonElementMarker jsonElementMarker;
        Intrinsics.f(json, "json");
        Intrinsics.f(mode, "mode");
        Intrinsics.f(lexer, "lexer");
        Intrinsics.f(descriptor, "descriptor");
        this.f52423a = json;
        this.f52424b = mode;
        this.f52425c = lexer;
        this.f52426d = json.a();
        this.f52427e = -1;
        this.f52428f = discriminatorHolder;
        JsonConfiguration g8 = json.g();
        this.f52429g = g8;
        if (g8.f()) {
            jsonElementMarker = null;
        } else {
            jsonElementMarker = new JsonElementMarker(descriptor);
        }
        this.f52430h = jsonElementMarker;
    }

    private final void K() {
        if (this.f52425c.E() != 4) {
            return;
        }
        AbstractJsonLexer.y(this.f52425c, "Unexpected leading comma", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final boolean L(SerialDescriptor serialDescriptor, int i8) {
        String F;
        Json json = this.f52423a;
        SerialDescriptor h8 = serialDescriptor.h(i8);
        if (h8.b() || !(!this.f52425c.M())) {
            if (!Intrinsics.a(h8.d(), SerialKind.ENUM.f52123a) || (F = this.f52425c.F(this.f52429g.l())) == null || JsonNamesMapKt.d(h8, json, F) != -3) {
                return false;
            }
            this.f52425c.q();
        }
        return true;
    }

    private final int M() {
        boolean L = this.f52425c.L();
        if (this.f52425c.f()) {
            int i8 = this.f52427e;
            if (i8 != -1 && !L) {
                AbstractJsonLexer.y(this.f52425c, "Expected end of the array or comma", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            int i9 = i8 + 1;
            this.f52427e = i9;
            return i9;
        } else if (!L) {
            return -1;
        } else {
            AbstractJsonLexer.y(this.f52425c, "Unexpected trailing comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    private final int N() {
        boolean z7;
        int i8;
        int i9;
        int i10 = this.f52427e;
        boolean z8 = false;
        if (i10 % 2 != 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if (i10 != -1) {
                z8 = this.f52425c.L();
            }
        } else {
            this.f52425c.o(':');
        }
        if (this.f52425c.f()) {
            if (z7) {
                if (this.f52427e == -1) {
                    AbstractJsonLexer abstractJsonLexer = this.f52425c;
                    boolean z9 = !z8;
                    i9 = abstractJsonLexer.f52364a;
                    if (!z9) {
                        AbstractJsonLexer.y(abstractJsonLexer, "Unexpected trailing comma", i9, null, 4, null);
                        throw new KotlinNothingValueException();
                    }
                } else {
                    AbstractJsonLexer abstractJsonLexer2 = this.f52425c;
                    i8 = abstractJsonLexer2.f52364a;
                    if (!z8) {
                        AbstractJsonLexer.y(abstractJsonLexer2, "Expected comma after the key-value pair", i8, null, 4, null);
                        throw new KotlinNothingValueException();
                    }
                }
            }
            int i11 = this.f52427e + 1;
            this.f52427e = i11;
            return i11;
        } else if (!z8) {
            return -1;
        } else {
            AbstractJsonLexer.y(this.f52425c, "Expected '}', but had ',' instead", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    private final int O(SerialDescriptor serialDescriptor) {
        boolean z7;
        boolean L = this.f52425c.L();
        while (this.f52425c.f()) {
            String P = P();
            this.f52425c.o(':');
            int d8 = JsonNamesMapKt.d(serialDescriptor, this.f52423a, P);
            boolean z8 = false;
            if (d8 != -3) {
                if (this.f52429g.d() && L(serialDescriptor, d8)) {
                    z7 = this.f52425c.L();
                } else {
                    JsonElementMarker jsonElementMarker = this.f52430h;
                    if (jsonElementMarker != null) {
                        jsonElementMarker.c(d8);
                    }
                    return d8;
                }
            } else {
                z7 = false;
                z8 = true;
            }
            if (z8) {
                L = Q(P);
            } else {
                L = z7;
            }
        }
        if (!L) {
            JsonElementMarker jsonElementMarker2 = this.f52430h;
            if (jsonElementMarker2 != null) {
                return jsonElementMarker2.d();
            }
            return -1;
        }
        AbstractJsonLexer.y(this.f52425c, "Unexpected trailing comma", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final String P() {
        if (this.f52429g.l()) {
            return this.f52425c.t();
        }
        return this.f52425c.k();
    }

    private final boolean Q(String str) {
        if (!this.f52429g.g() && !S(this.f52428f, str)) {
            this.f52425c.A(str);
        } else {
            this.f52425c.H(this.f52429g.l());
        }
        return this.f52425c.L();
    }

    private final void R(SerialDescriptor serialDescriptor) {
        do {
        } while (o(serialDescriptor) != -1);
    }

    private final boolean S(DiscriminatorHolder discriminatorHolder, String str) {
        if (discriminatorHolder == null || !Intrinsics.a(discriminatorHolder.f52431a, str)) {
            return false;
        }
        discriminatorHolder.f52431a = null;
        return true;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public boolean D() {
        boolean z7;
        JsonElementMarker jsonElementMarker = this.f52430h;
        if (jsonElementMarker != null) {
            z7 = jsonElementMarker.b();
        } else {
            z7 = false;
        }
        if (z7 || !this.f52425c.M()) {
            return false;
        }
        return true;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public <T> T G(DeserializationStrategy<T> deserializer) {
        Intrinsics.f(deserializer, "deserializer");
        try {
            if ((deserializer instanceof AbstractPolymorphicSerializer) && !this.f52423a.g().k()) {
                String c8 = PolymorphicKt.c(deserializer.a(), this.f52423a);
                String l8 = this.f52425c.l(c8, this.f52429g.l());
                DeserializationStrategy<? extends T> deserializationStrategy = null;
                if (l8 != null) {
                    deserializationStrategy = ((AbstractPolymorphicSerializer) deserializer).h(this, l8);
                }
                if (deserializationStrategy == null) {
                    return (T) PolymorphicKt.d(this, deserializer);
                }
                this.f52428f = new DiscriminatorHolder(c8);
                return deserializationStrategy.b(this);
            }
            return deserializer.b(this);
        } catch (MissingFieldException e8) {
            List<String> a8 = e8.a();
            throw new MissingFieldException(a8, e8.getMessage() + " at path: " + this.f52425c.f52365b.a(), e8);
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public byte H() {
        long p8 = this.f52425c.p();
        byte b8 = (byte) p8;
        if (p8 == b8) {
            return b8;
        }
        AbstractJsonLexer abstractJsonLexer = this.f52425c;
        AbstractJsonLexer.y(abstractJsonLexer, "Failed to parse byte for input '" + p8 + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public SerializersModule a() {
        return this.f52426d;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public CompositeDecoder b(SerialDescriptor descriptor) {
        Intrinsics.f(descriptor, "descriptor");
        WriteMode b8 = WriteModeKt.b(this.f52423a, descriptor);
        this.f52425c.f52365b.c(descriptor);
        this.f52425c.o(b8.f52451f);
        K();
        int i8 = WhenMappings.f52432a[b8.ordinal()];
        if (i8 != 1 && i8 != 2 && i8 != 3) {
            if (this.f52424b == b8 && this.f52423a.g().f()) {
                return this;
            }
            return new StreamingJsonDecoder(this.f52423a, b8, this.f52425c, descriptor, this.f52428f);
        }
        return new StreamingJsonDecoder(this.f52423a, b8, this.f52425c, descriptor, this.f52428f);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public void c(SerialDescriptor descriptor) {
        Intrinsics.f(descriptor, "descriptor");
        if (this.f52423a.g().g() && descriptor.e() == 0) {
            R(descriptor);
        }
        this.f52425c.o(this.f52424b.f52452g);
        this.f52425c.f52365b.b();
    }

    @Override // kotlinx.serialization.json.JsonDecoder
    public final Json d() {
        return this.f52423a;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public int e(SerialDescriptor enumDescriptor) {
        Intrinsics.f(enumDescriptor, "enumDescriptor");
        Json json = this.f52423a;
        String z7 = z();
        return JsonNamesMapKt.e(enumDescriptor, json, z7, " at path " + this.f52425c.f52365b.a());
    }

    @Override // kotlinx.serialization.json.JsonDecoder
    public JsonElement g() {
        return new JsonTreeReader(this.f52423a.g(), this.f52425c).e();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public int h() {
        long p8 = this.f52425c.p();
        int i8 = (int) p8;
        if (p8 == i8) {
            return i8;
        }
        AbstractJsonLexer abstractJsonLexer = this.f52425c;
        AbstractJsonLexer.y(abstractJsonLexer, "Failed to parse int for input '" + p8 + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public Void j() {
        return null;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public long l() {
        return this.f52425c.p();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public int o(SerialDescriptor descriptor) {
        int N;
        Intrinsics.f(descriptor, "descriptor");
        int i8 = WhenMappings.f52432a[this.f52424b.ordinal()];
        if (i8 != 2) {
            if (i8 != 4) {
                N = M();
            } else {
                N = O(descriptor);
            }
        } else {
            N = N();
        }
        if (this.f52424b != WriteMode.MAP) {
            this.f52425c.f52365b.g(N);
        }
        return N;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public Decoder q(SerialDescriptor descriptor) {
        Intrinsics.f(descriptor, "descriptor");
        if (StreamingJsonEncoderKt.a(descriptor)) {
            return new JsonDecoderForUnsignedTypes(this.f52425c, this.f52423a);
        }
        return super.q(descriptor);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public short s() {
        long p8 = this.f52425c.p();
        short s7 = (short) p8;
        if (p8 == s7) {
            return s7;
        }
        AbstractJsonLexer abstractJsonLexer = this.f52425c;
        AbstractJsonLexer.y(abstractJsonLexer, "Failed to parse short for input '" + p8 + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public float t() {
        boolean z7;
        AbstractJsonLexer abstractJsonLexer = this.f52425c;
        String s7 = abstractJsonLexer.s();
        try {
            float parseFloat = Float.parseFloat(s7);
            if (!this.f52423a.g().a()) {
                if (!Float.isInfinite(parseFloat) && !Float.isNaN(parseFloat)) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (!z7) {
                    JsonExceptionsKt.i(this.f52425c, Float.valueOf(parseFloat));
                    throw new KotlinNothingValueException();
                }
            }
            return parseFloat;
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.y(abstractJsonLexer, "Failed to parse type 'float' for input '" + s7 + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public double v() {
        boolean z7;
        AbstractJsonLexer abstractJsonLexer = this.f52425c;
        String s7 = abstractJsonLexer.s();
        try {
            double parseDouble = Double.parseDouble(s7);
            if (!this.f52423a.g().a()) {
                if (!Double.isInfinite(parseDouble) && !Double.isNaN(parseDouble)) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (!z7) {
                    JsonExceptionsKt.i(this.f52425c, Double.valueOf(parseDouble));
                    throw new KotlinNothingValueException();
                }
            }
            return parseDouble;
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.y(abstractJsonLexer, "Failed to parse type 'double' for input '" + s7 + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public boolean w() {
        if (this.f52429g.l()) {
            return this.f52425c.i();
        }
        return this.f52425c.g();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public char x() {
        String s7 = this.f52425c.s();
        if (s7.length() == 1) {
            return s7.charAt(0);
        }
        AbstractJsonLexer abstractJsonLexer = this.f52425c;
        AbstractJsonLexer.y(abstractJsonLexer, "Expected single char, but got '" + s7 + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public <T> T y(SerialDescriptor descriptor, int i8, DeserializationStrategy<T> deserializer, T t7) {
        boolean z7;
        Intrinsics.f(descriptor, "descriptor");
        Intrinsics.f(deserializer, "deserializer");
        if (this.f52424b == WriteMode.MAP && (i8 & 1) == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            this.f52425c.f52365b.d();
        }
        T t8 = (T) super.y(descriptor, i8, deserializer, t7);
        if (z7) {
            this.f52425c.f52365b.f(t8);
        }
        return t8;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public String z() {
        if (this.f52429g.l()) {
            return this.f52425c.t();
        }
        return this.f52425c.q();
    }
}
