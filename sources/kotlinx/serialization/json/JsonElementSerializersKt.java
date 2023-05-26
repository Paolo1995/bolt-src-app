package kotlinx.serialization.json;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: JsonElementSerializers.kt */
/* loaded from: classes5.dex */
public final class JsonElementSerializersKt {
    public static final /* synthetic */ void b(Decoder decoder) {
        g(decoder);
    }

    public static final /* synthetic */ void c(Encoder encoder) {
        h(encoder);
    }

    public static final JsonDecoder d(Decoder decoder) {
        JsonDecoder jsonDecoder;
        Intrinsics.f(decoder, "<this>");
        if (decoder instanceof JsonDecoder) {
            jsonDecoder = (JsonDecoder) decoder;
        } else {
            jsonDecoder = null;
        }
        if (jsonDecoder != null) {
            return jsonDecoder;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Decoder to be JsonDecoder, got " + Reflection.b(decoder.getClass()));
    }

    public static final JsonEncoder e(Encoder encoder) {
        JsonEncoder jsonEncoder;
        Intrinsics.f(encoder, "<this>");
        if (encoder instanceof JsonEncoder) {
            jsonEncoder = (JsonEncoder) encoder;
        } else {
            jsonEncoder = null;
        }
        if (jsonEncoder != null) {
            return jsonEncoder;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Encoder to be JsonEncoder, got " + Reflection.b(encoder.getClass()));
    }

    public static final SerialDescriptor f(Function0<? extends SerialDescriptor> function0) {
        return new SerialDescriptor(function0) { // from class: kotlinx.serialization.json.JsonElementSerializersKt$defer$1

            /* renamed from: a  reason: collision with root package name */
            private final Lazy f52345a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                Lazy b8;
                b8 = LazyKt__LazyJVMKt.b(function0);
                this.f52345a = b8;
            }

            private final SerialDescriptor a() {
                return (SerialDescriptor) this.f52345a.getValue();
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public boolean b() {
                return SerialDescriptor.DefaultImpls.c(this);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public int c(String name) {
                Intrinsics.f(name, "name");
                return a().c(name);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public SerialKind d() {
                return a().d();
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public int e() {
                return a().e();
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public String f(int i8) {
                return a().f(i8);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public List<Annotation> g(int i8) {
                return a().g(i8);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public List<Annotation> getAnnotations() {
                return SerialDescriptor.DefaultImpls.a(this);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public SerialDescriptor h(int i8) {
                return a().h(i8);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public String i() {
                return a().i();
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public boolean isInline() {
                return SerialDescriptor.DefaultImpls.b(this);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public boolean j(int i8) {
                return a().j(i8);
            }
        };
    }

    public static final void g(Decoder decoder) {
        d(decoder);
    }

    public static final void h(Encoder encoder) {
        e(encoder);
    }
}
