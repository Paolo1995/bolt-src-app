package kotlinx.serialization.internal;

import java.util.Map;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.ShortCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlin.text.CharsKt__CharKt;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.time.Duration;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* compiled from: Primitives.kt */
/* loaded from: classes5.dex */
public final class PrimitivesKt {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<KClass<? extends Object>, KSerializer<? extends Object>> f52251a;

    static {
        Map<KClass<? extends Object>, KSerializer<? extends Object>> i8;
        i8 = MapsKt__MapsKt.i(kotlin.TuplesKt.a(Reflection.b(String.class), BuiltinSerializersKt.H(StringCompanionObject.f51021a)), kotlin.TuplesKt.a(Reflection.b(Character.TYPE), BuiltinSerializersKt.B(CharCompanionObject.f50995a)), kotlin.TuplesKt.a(Reflection.b(char[].class), BuiltinSerializersKt.d()), kotlin.TuplesKt.a(Reflection.b(Double.TYPE), BuiltinSerializersKt.C(DoubleCompanionObject.f51004a)), kotlin.TuplesKt.a(Reflection.b(double[].class), BuiltinSerializersKt.e()), kotlin.TuplesKt.a(Reflection.b(Float.TYPE), BuiltinSerializersKt.D(FloatCompanionObject.f51005a)), kotlin.TuplesKt.a(Reflection.b(float[].class), BuiltinSerializersKt.f()), kotlin.TuplesKt.a(Reflection.b(Long.TYPE), BuiltinSerializersKt.F(LongCompanionObject.f51009a)), kotlin.TuplesKt.a(Reflection.b(long[].class), BuiltinSerializersKt.i()), kotlin.TuplesKt.a(Reflection.b(ULong.class), BuiltinSerializersKt.w(ULong.f50842g)), kotlin.TuplesKt.a(Reflection.b(ULongArray.class), BuiltinSerializersKt.r()), kotlin.TuplesKt.a(Reflection.b(Integer.TYPE), BuiltinSerializersKt.E(IntCompanionObject.f51008a)), kotlin.TuplesKt.a(Reflection.b(int[].class), BuiltinSerializersKt.g()), kotlin.TuplesKt.a(Reflection.b(UInt.class), BuiltinSerializersKt.v(UInt.f50837g)), kotlin.TuplesKt.a(Reflection.b(UIntArray.class), BuiltinSerializersKt.q()), kotlin.TuplesKt.a(Reflection.b(Short.TYPE), BuiltinSerializersKt.G(ShortCompanionObject.f51019a)), kotlin.TuplesKt.a(Reflection.b(short[].class), BuiltinSerializersKt.n()), kotlin.TuplesKt.a(Reflection.b(UShort.class), BuiltinSerializersKt.x(UShort.f50848g)), kotlin.TuplesKt.a(Reflection.b(UShortArray.class), BuiltinSerializersKt.s()), kotlin.TuplesKt.a(Reflection.b(Byte.TYPE), BuiltinSerializersKt.A(ByteCompanionObject.f50986a)), kotlin.TuplesKt.a(Reflection.b(byte[].class), BuiltinSerializersKt.c()), kotlin.TuplesKt.a(Reflection.b(UByte.class), BuiltinSerializersKt.u(UByte.f50832g)), kotlin.TuplesKt.a(Reflection.b(UByteArray.class), BuiltinSerializersKt.p()), kotlin.TuplesKt.a(Reflection.b(Boolean.TYPE), BuiltinSerializersKt.z(BooleanCompanionObject.f50985a)), kotlin.TuplesKt.a(Reflection.b(boolean[].class), BuiltinSerializersKt.b()), kotlin.TuplesKt.a(Reflection.b(Unit.class), BuiltinSerializersKt.y(Unit.f50853a)), kotlin.TuplesKt.a(Reflection.b(Duration.class), BuiltinSerializersKt.I(Duration.f51176g)));
        f52251a = i8;
    }

    public static final SerialDescriptor a(String serialName, PrimitiveKind kind) {
        Intrinsics.f(serialName, "serialName");
        Intrinsics.f(kind, "kind");
        d(serialName);
        return new PrimitiveSerialDescriptor(serialName, kind);
    }

    public static final <T> KSerializer<T> b(KClass<T> kClass) {
        Intrinsics.f(kClass, "<this>");
        return (KSerializer<T>) f52251a.get(kClass);
    }

    private static final String c(String str) {
        boolean z7;
        String valueOf;
        if (str.length() > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            StringBuilder sb = new StringBuilder();
            char charAt = str.charAt(0);
            if (Character.isLowerCase(charAt)) {
                valueOf = CharsKt__CharKt.f(charAt);
            } else {
                valueOf = String.valueOf(charAt);
            }
            sb.append((Object) valueOf);
            String substring = str.substring(1);
            Intrinsics.e(substring, "this as java.lang.String).substring(startIndex)");
            sb.append(substring);
            return sb.toString();
        }
        return str;
    }

    private static final void d(String str) {
        boolean w7;
        String f8;
        boolean w8;
        for (KClass<? extends Object> kClass : f52251a.keySet()) {
            String d8 = kClass.d();
            Intrinsics.c(d8);
            String c8 = c(d8);
            w7 = StringsKt__StringsJVMKt.w(str, "kotlin." + c8, true);
            if (!w7) {
                w8 = StringsKt__StringsJVMKt.w(str, c8, true);
                if (w8) {
                }
            }
            f8 = StringsKt__IndentKt.f("\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name " + str + " there already exist " + c(c8) + "Serializer.\n                Please refer to SerialDescriptor documentation for additional information.\n            ");
            throw new IllegalArgumentException(f8);
        }
    }
}
