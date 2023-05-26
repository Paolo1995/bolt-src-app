package kotlinx.serialization.json;

import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: JsonContentPolymorphicSerializer.kt */
/* loaded from: classes5.dex */
public abstract class JsonContentPolymorphicSerializer<T> implements KSerializer<T> {

    /* renamed from: a  reason: collision with root package name */
    private final KClass<T> f52335a;

    /* renamed from: b  reason: collision with root package name */
    private final SerialDescriptor f52336b;

    public JsonContentPolymorphicSerializer(KClass<T> baseClass) {
        Intrinsics.f(baseClass, "baseClass");
        this.f52335a = baseClass;
        this.f52336b = SerialDescriptorsKt.d("JsonContentPolymorphicSerializer<" + baseClass.d() + '>', PolymorphicKind.SEALED.f52091a, new SerialDescriptor[0], null, 8, null);
    }

    private final Void g(KClass<?> kClass, KClass<?> kClass2) {
        String d8 = kClass.d();
        if (d8 == null) {
            d8 = String.valueOf(kClass);
        }
        throw new SerializationException("Class '" + d8 + "' is not registered for polymorphic serialization " + ("in the scope of '" + kClass2.d() + '\'') + ".\nMark the base class as 'sealed' or register the serializer explicitly.");
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return this.f52336b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final T b(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        JsonDecoder d8 = JsonElementSerializersKt.d(decoder);
        JsonElement g8 = d8.g();
        DeserializationStrategy<? extends T> f8 = f(g8);
        Intrinsics.d(f8, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.json.JsonContentPolymorphicSerializer>");
        return (T) d8.d().f((KSerializer) f8, g8);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, T value) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(value, "value");
        SerializationStrategy<T> e8 = encoder.a().e(this.f52335a, value);
        if (e8 == null && (e8 = SerializersKt.d(Reflection.b(value.getClass()))) == null) {
            g(Reflection.b(value.getClass()), this.f52335a);
            throw new KotlinNothingValueException();
        } else {
            ((KSerializer) e8).c(encoder, value);
        }
    }

    protected abstract DeserializationStrategy<? extends T> f(JsonElement jsonElement);
}
