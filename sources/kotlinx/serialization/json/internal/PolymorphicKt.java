package kotlinx.serialization.json.internal;

import java.lang.annotation.Annotation;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.internal.JsonInternalDependenciesKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonClassDiscriminator;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* compiled from: Polymorphic.kt */
/* loaded from: classes5.dex */
public final class PolymorphicKt {
    public static final void b(SerialKind kind) {
        Intrinsics.f(kind, "kind");
        if (!(kind instanceof SerialKind.ENUM)) {
            if (!(kind instanceof PrimitiveKind)) {
                if (!(kind instanceof PolymorphicKind)) {
                    return;
                }
                throw new IllegalStateException("Actual serializer for polymorphic cannot be polymorphic itself".toString());
            }
            throw new IllegalStateException("Primitives cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead".toString());
        }
        throw new IllegalStateException("Enums cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead".toString());
    }

    public static final String c(SerialDescriptor serialDescriptor, Json json) {
        Intrinsics.f(serialDescriptor, "<this>");
        Intrinsics.f(json, "json");
        for (Annotation annotation : serialDescriptor.getAnnotations()) {
            if (annotation instanceof JsonClassDiscriminator) {
                return ((JsonClassDiscriminator) annotation).discriminator();
            }
        }
        return json.g().c();
    }

    public static final <T> T d(JsonDecoder jsonDecoder, DeserializationStrategy<T> deserializer) {
        String str;
        JsonPrimitive j8;
        Intrinsics.f(jsonDecoder, "<this>");
        Intrinsics.f(deserializer, "deserializer");
        if ((deserializer instanceof AbstractPolymorphicSerializer) && !jsonDecoder.d().g().k()) {
            String c8 = c(deserializer.a(), jsonDecoder.d());
            JsonElement g8 = jsonDecoder.g();
            SerialDescriptor a8 = deserializer.a();
            if (g8 instanceof JsonObject) {
                JsonObject jsonObject = (JsonObject) g8;
                JsonElement jsonElement = (JsonElement) jsonObject.get(c8);
                if (jsonElement != null && (j8 = JsonElementKt.j(jsonElement)) != null) {
                    str = j8.b();
                } else {
                    str = null;
                }
                DeserializationStrategy<? extends T> h8 = ((AbstractPolymorphicSerializer) deserializer).h(jsonDecoder, str);
                if (h8 != null) {
                    return (T) TreeJsonDecoderKt.b(jsonDecoder.d(), c8, jsonObject, h8);
                }
                e(str, jsonObject);
                throw new KotlinNothingValueException();
            }
            throw JsonExceptionsKt.d(-1, "Expected " + Reflection.b(JsonObject.class) + " as the serialized body of " + a8.i() + ", but had " + Reflection.b(g8.getClass()));
        }
        return deserializer.b(jsonDecoder);
    }

    public static final Void e(String str, JsonObject jsonTree) {
        String str2;
        Intrinsics.f(jsonTree, "jsonTree");
        if (str == null) {
            str2 = "missing class discriminator ('null')";
        } else {
            str2 = "class discriminator '" + str + '\'';
        }
        throw JsonExceptionsKt.e(-1, "Polymorphic serializer was not found for " + str2, jsonTree.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(SerializationStrategy<?> serializationStrategy, SerializationStrategy<Object> serializationStrategy2, String str) {
        if (!(serializationStrategy instanceof SealedClassSerializer) || !JsonInternalDependenciesKt.a(serializationStrategy2.a()).contains(str)) {
            return;
        }
        String i8 = serializationStrategy.a().i();
        String i9 = serializationStrategy2.a().i();
        throw new IllegalStateException(("Sealed class '" + i9 + "' cannot be serialized as base class '" + i8 + "' because it has property name that conflicts with JSON class discriminator '" + str + "'. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism").toString());
    }
}
