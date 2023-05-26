package kotlinx.serialization.internal;

import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.SerializationException;

/* compiled from: AbstractPolymorphicSerializer.kt */
/* loaded from: classes5.dex */
public final class AbstractPolymorphicSerializerKt {
    public static final Void a(String str, KClass<?> baseClass) {
        String str2;
        Intrinsics.f(baseClass, "baseClass");
        String str3 = "in the scope of '" + baseClass.d() + '\'';
        if (str == null) {
            str2 = "Class discriminator was missing and no default polymorphic serializers were registered " + str3;
        } else {
            str2 = "Class '" + str + "' is not registered for polymorphic serialization " + str3 + ".\nMark the base class as 'sealed' or register the serializer explicitly.";
        }
        throw new SerializationException(str2);
    }

    public static final Void b(KClass<?> subClass, KClass<?> baseClass) {
        Intrinsics.f(subClass, "subClass");
        Intrinsics.f(baseClass, "baseClass");
        String d8 = subClass.d();
        if (d8 == null) {
            d8 = String.valueOf(subClass);
        }
        a(d8, baseClass);
        throw new KotlinNothingValueException();
    }
}
