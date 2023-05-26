package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.PolymorphicSerializerKt;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.AbstractEncoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonEncoder;
import kotlinx.serialization.modules.SerializersModule;

/* compiled from: StreamingJsonEncoder.kt */
/* loaded from: classes5.dex */
public final class StreamingJsonEncoder extends AbstractEncoder implements JsonEncoder {

    /* renamed from: a  reason: collision with root package name */
    private final Composer f52433a;

    /* renamed from: b  reason: collision with root package name */
    private final Json f52434b;

    /* renamed from: c  reason: collision with root package name */
    private final WriteMode f52435c;

    /* renamed from: d  reason: collision with root package name */
    private final JsonEncoder[] f52436d;

    /* renamed from: e  reason: collision with root package name */
    private final SerializersModule f52437e;

    /* renamed from: f  reason: collision with root package name */
    private final JsonConfiguration f52438f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f52439g;

    /* renamed from: h  reason: collision with root package name */
    private String f52440h;

    /* compiled from: StreamingJsonEncoder.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f52441a;

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
            f52441a = iArr;
        }
    }

    public StreamingJsonEncoder(Composer composer, Json json, WriteMode mode, JsonEncoder[] jsonEncoderArr) {
        Intrinsics.f(composer, "composer");
        Intrinsics.f(json, "json");
        Intrinsics.f(mode, "mode");
        this.f52433a = composer;
        this.f52434b = json;
        this.f52435c = mode;
        this.f52436d = jsonEncoderArr;
        this.f52437e = d().a();
        this.f52438f = d().g();
        int ordinal = mode.ordinal();
        if (jsonEncoderArr != null) {
            JsonEncoder jsonEncoder = jsonEncoderArr[ordinal];
            if (jsonEncoder == null && jsonEncoder == this) {
                return;
            }
            jsonEncoderArr[ordinal] = this;
        }
    }

    private final Composer J() {
        Composer composer = this.f52433a;
        if (!(composer instanceof ComposerForUnsignedNumbers)) {
            return new ComposerForUnsignedNumbers(composer.f52378a, this.f52439g);
        }
        return composer;
    }

    private final void K(SerialDescriptor serialDescriptor) {
        this.f52433a.c();
        String str = this.f52440h;
        Intrinsics.c(str);
        F(str);
        this.f52433a.e(':');
        this.f52433a.o();
        F(serialDescriptor.i());
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void A(int i8) {
        if (this.f52439g) {
            F(String.valueOf(i8));
        } else {
            this.f52433a.h(i8);
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void F(String value) {
        Intrinsics.f(value, "value");
        this.f52433a.m(value);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public boolean G(SerialDescriptor descriptor, int i8) {
        Intrinsics.f(descriptor, "descriptor");
        int i9 = WhenMappings.f52441a[this.f52435c.ordinal()];
        if (i9 != 1) {
            boolean z7 = false;
            if (i9 != 2) {
                if (i9 != 3) {
                    if (!this.f52433a.a()) {
                        this.f52433a.e(',');
                    }
                    this.f52433a.c();
                    F(descriptor.f(i8));
                    this.f52433a.e(':');
                    this.f52433a.o();
                } else {
                    if (i8 == 0) {
                        this.f52439g = true;
                    }
                    if (i8 == 1) {
                        this.f52433a.e(',');
                        this.f52433a.o();
                        this.f52439g = false;
                    }
                }
            } else if (!this.f52433a.a()) {
                if (i8 % 2 == 0) {
                    this.f52433a.e(',');
                    this.f52433a.c();
                    z7 = true;
                } else {
                    this.f52433a.e(':');
                    this.f52433a.o();
                }
                this.f52439g = z7;
            } else {
                this.f52439g = true;
                this.f52433a.c();
            }
        } else {
            if (!this.f52433a.a()) {
                this.f52433a.e(',');
            }
            this.f52433a.c();
        }
        return true;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public SerializersModule a() {
        return this.f52437e;
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public CompositeEncoder b(SerialDescriptor descriptor) {
        JsonEncoder jsonEncoder;
        Intrinsics.f(descriptor, "descriptor");
        WriteMode b8 = WriteModeKt.b(d(), descriptor);
        char c8 = b8.f52451f;
        if (c8 != 0) {
            this.f52433a.e(c8);
            this.f52433a.b();
        }
        if (this.f52440h != null) {
            K(descriptor);
            this.f52440h = null;
        }
        if (this.f52435c == b8) {
            return this;
        }
        JsonEncoder[] jsonEncoderArr = this.f52436d;
        if (jsonEncoderArr == null || (jsonEncoder = jsonEncoderArr[b8.ordinal()]) == null) {
            return new StreamingJsonEncoder(this.f52433a, d(), b8, this.f52436d);
        }
        return jsonEncoder;
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.CompositeEncoder
    public void c(SerialDescriptor descriptor) {
        Intrinsics.f(descriptor, "descriptor");
        if (this.f52435c.f52452g != 0) {
            this.f52433a.p();
            this.f52433a.c();
            this.f52433a.e(this.f52435c.f52452g);
        }
    }

    @Override // kotlinx.serialization.json.JsonEncoder
    public Json d() {
        return this.f52434b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public <T> void e(SerializationStrategy<? super T> serializer, T t7) {
        Intrinsics.f(serializer, "serializer");
        if ((serializer instanceof AbstractPolymorphicSerializer) && !d().g().k()) {
            AbstractPolymorphicSerializer abstractPolymorphicSerializer = (AbstractPolymorphicSerializer) serializer;
            String c8 = PolymorphicKt.c(serializer.a(), d());
            Intrinsics.d(t7, "null cannot be cast to non-null type kotlin.Any");
            SerializationStrategy b8 = PolymorphicSerializerKt.b(abstractPolymorphicSerializer, this, t7);
            PolymorphicKt.f(abstractPolymorphicSerializer, b8, c8);
            PolymorphicKt.b(b8.a().d());
            this.f52440h = c8;
            b8.c(this, t7);
            return;
        }
        serializer.c(this, t7);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void g(double d8) {
        boolean z7;
        if (this.f52439g) {
            F(String.valueOf(d8));
        } else {
            this.f52433a.f(d8);
        }
        if (!this.f52438f.a()) {
            if (!Double.isInfinite(d8) && !Double.isNaN(d8)) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                throw JsonExceptionsKt.b(Double.valueOf(d8), this.f52433a.f52378a.toString());
            }
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void h(byte b8) {
        if (this.f52439g) {
            F(String.valueOf((int) b8));
        } else {
            this.f52433a.d(b8);
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.CompositeEncoder
    public <T> void i(SerialDescriptor descriptor, int i8, SerializationStrategy<? super T> serializer, T t7) {
        Intrinsics.f(descriptor, "descriptor");
        Intrinsics.f(serializer, "serializer");
        if (t7 != null || this.f52438f.f()) {
            super.i(descriptor, i8, serializer, t7);
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void k(SerialDescriptor enumDescriptor, int i8) {
        Intrinsics.f(enumDescriptor, "enumDescriptor");
        F(enumDescriptor.f(i8));
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public Encoder l(SerialDescriptor descriptor) {
        Intrinsics.f(descriptor, "descriptor");
        if (StreamingJsonEncoderKt.a(descriptor)) {
            return new StreamingJsonEncoder(J(), d(), this.f52435c, (JsonEncoder[]) null);
        }
        return super.l(descriptor);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void m(long j8) {
        if (this.f52439g) {
            F(String.valueOf(j8));
        } else {
            this.f52433a.i(j8);
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void o() {
        this.f52433a.j("null");
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void q(short s7) {
        if (this.f52439g) {
            F(String.valueOf((int) s7));
        } else {
            this.f52433a.k(s7);
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void r(boolean z7) {
        if (this.f52439g) {
            F(String.valueOf(z7));
        } else {
            this.f52433a.l(z7);
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void t(float f8) {
        boolean z7;
        if (this.f52439g) {
            F(String.valueOf(f8));
        } else {
            this.f52433a.g(f8);
        }
        if (!this.f52438f.a()) {
            if (!Float.isInfinite(f8) && !Float.isNaN(f8)) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                throw JsonExceptionsKt.b(Float.valueOf(f8), this.f52433a.f52378a.toString());
            }
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void u(char c8) {
        F(String.valueOf(c8));
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.CompositeEncoder
    public boolean z(SerialDescriptor descriptor, int i8) {
        Intrinsics.f(descriptor, "descriptor");
        return this.f52438f.e();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StreamingJsonEncoder(JsonWriter output, Json json, WriteMode mode, JsonEncoder[] modeReuseCache) {
        this(ComposersKt.a(output, json), json, mode, modeReuseCache);
        Intrinsics.f(output, "output");
        Intrinsics.f(json, "json");
        Intrinsics.f(mode, "mode");
        Intrinsics.f(modeReuseCache, "modeReuseCache");
    }
}
