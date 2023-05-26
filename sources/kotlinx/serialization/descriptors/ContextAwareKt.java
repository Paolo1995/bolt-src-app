package kotlinx.serialization.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.SerialDescriptorForNullable;
import kotlinx.serialization.modules.SerializersModule;

/* compiled from: ContextAware.kt */
/* loaded from: classes5.dex */
public final class ContextAwareKt {
    public static final KClass<?> a(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "<this>");
        if (serialDescriptor instanceof ContextDescriptor) {
            return ((ContextDescriptor) serialDescriptor).f52088b;
        }
        if (serialDescriptor instanceof SerialDescriptorForNullable) {
            return a(((SerialDescriptorForNullable) serialDescriptor).k());
        }
        return null;
    }

    public static final SerialDescriptor b(SerializersModule serializersModule, SerialDescriptor descriptor) {
        KSerializer c8;
        Intrinsics.f(serializersModule, "<this>");
        Intrinsics.f(descriptor, "descriptor");
        KClass<?> a8 = a(descriptor);
        if (a8 == null || (c8 = SerializersModule.c(serializersModule, a8, null, 2, null)) == null) {
            return null;
        }
        return c8.a();
    }

    public static final SerialDescriptor c(SerialDescriptor serialDescriptor, KClass<?> context) {
        Intrinsics.f(serialDescriptor, "<this>");
        Intrinsics.f(context, "context");
        return new ContextDescriptor(serialDescriptor, context);
    }
}
