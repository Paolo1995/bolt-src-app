package kotlinx.serialization.internal;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* compiled from: Platform.common.kt */
/* loaded from: classes5.dex */
public final class Platform_commonKt {

    /* renamed from: a  reason: collision with root package name */
    private static final SerialDescriptor[] f52229a = new SerialDescriptor[0];

    public static final Set<String> a(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "<this>");
        if (serialDescriptor instanceof CachedNames) {
            return ((CachedNames) serialDescriptor).a();
        }
        HashSet hashSet = new HashSet(serialDescriptor.e());
        int e8 = serialDescriptor.e();
        for (int i8 = 0; i8 < e8; i8++) {
            hashSet.add(serialDescriptor.f(i8));
        }
        return hashSet;
    }

    public static final SerialDescriptor[] b(List<? extends SerialDescriptor> list) {
        boolean z7;
        if (list != null && !list.isEmpty()) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (z7) {
            list = null;
        }
        if (list != null) {
            Object[] array = list.toArray(new SerialDescriptor[0]);
            Intrinsics.d(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            SerialDescriptor[] serialDescriptorArr = (SerialDescriptor[]) array;
            if (serialDescriptorArr != null) {
                return serialDescriptorArr;
            }
        }
        return f52229a;
    }

    public static final KClass<Object> c(KType kType) {
        Intrinsics.f(kType, "<this>");
        KClassifier c8 = kType.c();
        if (c8 instanceof KClass) {
            return (KClass) c8;
        }
        if (c8 instanceof KTypeParameter) {
            throw new IllegalStateException(("Captured type paramerer " + c8 + " from generic non-reified function. Such functionality cannot be supported as " + c8 + " is erased, either specify serializer explicitly or make calling function inline with reified " + c8).toString());
        }
        throw new IllegalStateException(("Only KClass supported as classifier, got " + c8).toString());
    }

    public static final Void d(KClass<?> kClass) {
        Intrinsics.f(kClass, "<this>");
        throw new SerializationException("Serializer for class '" + kClass.d() + "' is not found.\nMark the class as @Serializable or provide the serializer explicitly.");
    }
}
