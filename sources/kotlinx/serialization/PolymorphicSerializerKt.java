package kotlinx.serialization;

import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.internal.AbstractPolymorphicSerializerKt;

/* compiled from: PolymorphicSerializer.kt */
/* loaded from: classes5.dex */
public final class PolymorphicSerializerKt {
    public static final <T> DeserializationStrategy<? extends T> a(AbstractPolymorphicSerializer<T> abstractPolymorphicSerializer, CompositeDecoder decoder, String str) {
        Intrinsics.f(abstractPolymorphicSerializer, "<this>");
        Intrinsics.f(decoder, "decoder");
        DeserializationStrategy<? extends T> h8 = abstractPolymorphicSerializer.h(decoder, str);
        if (h8 != null) {
            return h8;
        }
        AbstractPolymorphicSerializerKt.a(str, abstractPolymorphicSerializer.j());
        throw new KotlinNothingValueException();
    }

    public static final <T> SerializationStrategy<T> b(AbstractPolymorphicSerializer<T> abstractPolymorphicSerializer, Encoder encoder, T value) {
        Intrinsics.f(abstractPolymorphicSerializer, "<this>");
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        SerializationStrategy<T> i8 = abstractPolymorphicSerializer.i(encoder, value);
        if (i8 != null) {
            return i8;
        }
        AbstractPolymorphicSerializerKt.b(Reflection.b(value.getClass()), abstractPolymorphicSerializer.j());
        throw new KotlinNothingValueException();
    }
}
