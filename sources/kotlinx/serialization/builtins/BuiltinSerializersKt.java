package kotlinx.serialization.builtins;

import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.Unit;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.ShortCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlin.time.Duration;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanArraySerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.ByteArraySerializer;
import kotlinx.serialization.internal.ByteSerializer;
import kotlinx.serialization.internal.CharArraySerializer;
import kotlinx.serialization.internal.CharSerializer;
import kotlinx.serialization.internal.DoubleArraySerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.DurationSerializer;
import kotlinx.serialization.internal.FloatArraySerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.IntArraySerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LinkedHashSetSerializer;
import kotlinx.serialization.internal.LongArraySerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.MapEntrySerializer;
import kotlinx.serialization.internal.NullableSerializer;
import kotlinx.serialization.internal.PairSerializer;
import kotlinx.serialization.internal.ReferenceArraySerializer;
import kotlinx.serialization.internal.ShortArraySerializer;
import kotlinx.serialization.internal.ShortSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.internal.TripleSerializer;
import kotlinx.serialization.internal.UByteArraySerializer;
import kotlinx.serialization.internal.UByteSerializer;
import kotlinx.serialization.internal.UIntArraySerializer;
import kotlinx.serialization.internal.UIntSerializer;
import kotlinx.serialization.internal.ULongArraySerializer;
import kotlinx.serialization.internal.ULongSerializer;
import kotlinx.serialization.internal.UShortArraySerializer;
import kotlinx.serialization.internal.UShortSerializer;
import kotlinx.serialization.internal.UnitSerializer;

/* compiled from: BuiltinSerializers.kt */
/* loaded from: classes5.dex */
public final class BuiltinSerializersKt {
    public static final KSerializer<Byte> A(ByteCompanionObject byteCompanionObject) {
        Intrinsics.f(byteCompanionObject, "<this>");
        return ByteSerializer.f52137a;
    }

    public static final KSerializer<Character> B(CharCompanionObject charCompanionObject) {
        Intrinsics.f(charCompanionObject, "<this>");
        return CharSerializer.f52144a;
    }

    public static final KSerializer<Double> C(DoubleCompanionObject doubleCompanionObject) {
        Intrinsics.f(doubleCompanionObject, "<this>");
        return DoubleSerializer.f52159a;
    }

    public static final KSerializer<Float> D(FloatCompanionObject floatCompanionObject) {
        Intrinsics.f(floatCompanionObject, "<this>");
        return FloatSerializer.f52182a;
    }

    public static final KSerializer<Integer> E(IntCompanionObject intCompanionObject) {
        Intrinsics.f(intCompanionObject, "<this>");
        return IntSerializer.f52191a;
    }

    public static final KSerializer<Long> F(LongCompanionObject longCompanionObject) {
        Intrinsics.f(longCompanionObject, "<this>");
        return LongSerializer.f52202a;
    }

    public static final KSerializer<Short> G(ShortCompanionObject shortCompanionObject) {
        Intrinsics.f(shortCompanionObject, "<this>");
        return ShortSerializer.f52260a;
    }

    public static final KSerializer<String> H(StringCompanionObject stringCompanionObject) {
        Intrinsics.f(stringCompanionObject, "<this>");
        return StringSerializer.f52262a;
    }

    public static final KSerializer<Duration> I(Duration.Companion companion) {
        Intrinsics.f(companion, "<this>");
        return DurationSerializer.f52161a;
    }

    public static final <T, E extends T> KSerializer<E[]> a(KClass<T> kClass, KSerializer<E> elementSerializer) {
        Intrinsics.f(kClass, "kClass");
        Intrinsics.f(elementSerializer, "elementSerializer");
        return new ReferenceArraySerializer(kClass, elementSerializer);
    }

    public static final KSerializer<boolean[]> b() {
        return BooleanArraySerializer.f52131c;
    }

    public static final KSerializer<byte[]> c() {
        return ByteArraySerializer.f52136c;
    }

    public static final KSerializer<char[]> d() {
        return CharArraySerializer.f52143c;
    }

    public static final KSerializer<double[]> e() {
        return DoubleArraySerializer.f52158c;
    }

    public static final KSerializer<float[]> f() {
        return FloatArraySerializer.f52181c;
    }

    public static final KSerializer<int[]> g() {
        return IntArraySerializer.f52190c;
    }

    public static final <T> KSerializer<List<T>> h(KSerializer<T> elementSerializer) {
        Intrinsics.f(elementSerializer, "elementSerializer");
        return new ArrayListSerializer(elementSerializer);
    }

    public static final KSerializer<long[]> i() {
        return LongArraySerializer.f52201c;
    }

    public static final <K, V> KSerializer<Map.Entry<K, V>> j(KSerializer<K> keySerializer, KSerializer<V> valueSerializer) {
        Intrinsics.f(keySerializer, "keySerializer");
        Intrinsics.f(valueSerializer, "valueSerializer");
        return new MapEntrySerializer(keySerializer, valueSerializer);
    }

    public static final <K, V> KSerializer<Map<K, V>> k(KSerializer<K> keySerializer, KSerializer<V> valueSerializer) {
        Intrinsics.f(keySerializer, "keySerializer");
        Intrinsics.f(valueSerializer, "valueSerializer");
        return new LinkedHashMapSerializer(keySerializer, valueSerializer);
    }

    public static final <K, V> KSerializer<Pair<K, V>> l(KSerializer<K> keySerializer, KSerializer<V> valueSerializer) {
        Intrinsics.f(keySerializer, "keySerializer");
        Intrinsics.f(valueSerializer, "valueSerializer");
        return new PairSerializer(keySerializer, valueSerializer);
    }

    public static final <T> KSerializer<Set<T>> m(KSerializer<T> elementSerializer) {
        Intrinsics.f(elementSerializer, "elementSerializer");
        return new LinkedHashSetSerializer(elementSerializer);
    }

    public static final KSerializer<short[]> n() {
        return ShortArraySerializer.f52259c;
    }

    public static final <A, B, C> KSerializer<Triple<A, B, C>> o(KSerializer<A> aSerializer, KSerializer<B> bSerializer, KSerializer<C> cSerializer) {
        Intrinsics.f(aSerializer, "aSerializer");
        Intrinsics.f(bSerializer, "bSerializer");
        Intrinsics.f(cSerializer, "cSerializer");
        return new TripleSerializer(aSerializer, bSerializer, cSerializer);
    }

    public static final KSerializer<UByteArray> p() {
        return UByteArraySerializer.f52280c;
    }

    public static final KSerializer<UIntArray> q() {
        return UIntArraySerializer.f52285c;
    }

    public static final KSerializer<ULongArray> r() {
        return ULongArraySerializer.f52290c;
    }

    public static final KSerializer<UShortArray> s() {
        return UShortArraySerializer.f52295c;
    }

    public static final <T> KSerializer<T> t(KSerializer<T> kSerializer) {
        Intrinsics.f(kSerializer, "<this>");
        if (!kSerializer.a().b()) {
            return new NullableSerializer(kSerializer);
        }
        return kSerializer;
    }

    public static final KSerializer<UByte> u(UByte.Companion companion) {
        Intrinsics.f(companion, "<this>");
        return UByteSerializer.f52281a;
    }

    public static final KSerializer<UInt> v(UInt.Companion companion) {
        Intrinsics.f(companion, "<this>");
        return UIntSerializer.f52286a;
    }

    public static final KSerializer<ULong> w(ULong.Companion companion) {
        Intrinsics.f(companion, "<this>");
        return ULongSerializer.f52291a;
    }

    public static final KSerializer<UShort> x(UShort.Companion companion) {
        Intrinsics.f(companion, "<this>");
        return UShortSerializer.f52296a;
    }

    public static final KSerializer<Unit> y(Unit unit) {
        Intrinsics.f(unit, "<this>");
        return UnitSerializer.f52298b;
    }

    public static final KSerializer<Boolean> z(BooleanCompanionObject booleanCompanionObject) {
        Intrinsics.f(booleanCompanionObject, "<this>");
        return BooleanSerializer.f52132a;
    }
}
