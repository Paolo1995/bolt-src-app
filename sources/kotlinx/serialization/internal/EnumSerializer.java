package kotlinx.serialization.internal;

import java.lang.Enum;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: Enums.kt */
/* loaded from: classes5.dex */
public final class EnumSerializer<T extends Enum<T>> implements KSerializer<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T[] f52174a;

    /* renamed from: b  reason: collision with root package name */
    private SerialDescriptor f52175b;

    /* renamed from: c  reason: collision with root package name */
    private final Lazy f52176c;

    public EnumSerializer(final String serialName, T[] values) {
        Lazy b8;
        Intrinsics.f(serialName, "serialName");
        Intrinsics.f(values, "values");
        this.f52174a = values;
        b8 = LazyKt__LazyJVMKt.b(new Function0<SerialDescriptor>(this) { // from class: kotlinx.serialization.internal.EnumSerializer$descriptor$2

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ EnumSerializer<T> f52177f;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.f52177f = this;
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final SerialDescriptor invoke() {
                SerialDescriptor serialDescriptor;
                SerialDescriptor h8;
                serialDescriptor = ((EnumSerializer) this.f52177f).f52175b;
                if (serialDescriptor == null) {
                    h8 = this.f52177f.h(serialName);
                    return h8;
                }
                return serialDescriptor;
            }
        });
        this.f52176c = b8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SerialDescriptor h(String str) {
        EnumDescriptor enumDescriptor = new EnumDescriptor(str, this.f52174a.length);
        for (T t7 : this.f52174a) {
            PluginGeneratedSerialDescriptor.m(enumDescriptor, t7.name(), false, 2, null);
        }
        return enumDescriptor;
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return (SerialDescriptor) this.f52176c.getValue();
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: i */
    public T b(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        int e8 = decoder.e(a());
        boolean z7 = false;
        if (e8 >= 0 && e8 < this.f52174a.length) {
            z7 = true;
        }
        if (z7) {
            return this.f52174a[e8];
        }
        throw new SerializationException(e8 + " is not among valid " + a().i() + " enum values, values size is " + this.f52174a.length);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: j */
    public void c(Encoder encoder, T value) {
        int O;
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        O = ArraysKt___ArraysKt.O(this.f52174a, value);
        if (O != -1) {
            encoder.k(a(), O);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(value);
        sb.append(" is not a valid enum ");
        sb.append(a().i());
        sb.append(", must be one of ");
        String arrays = Arrays.toString(this.f52174a);
        Intrinsics.e(arrays, "toString(this)");
        sb.append(arrays);
        throw new SerializationException(sb.toString());
    }

    public String toString() {
        return "kotlinx.serialization.internal.EnumSerializer<" + a().i() + '>';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EnumSerializer(String serialName, T[] values, SerialDescriptor descriptor) {
        this(serialName, values);
        Intrinsics.f(serialName, "serialName");
        Intrinsics.f(values, "values");
        Intrinsics.f(descriptor, "descriptor");
        this.f52175b = descriptor;
    }
}
