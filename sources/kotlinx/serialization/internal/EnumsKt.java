package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;

/* compiled from: Enums.kt */
/* loaded from: classes5.dex */
public final class EnumsKt {
    public static final <T extends Enum<T>> KSerializer<T> a(String serialName, T[] values, String[] names, Annotation[][] annotations) {
        Object K;
        Object K2;
        Intrinsics.f(serialName, "serialName");
        Intrinsics.f(values, "values");
        Intrinsics.f(names, "names");
        Intrinsics.f(annotations, "annotations");
        EnumDescriptor enumDescriptor = new EnumDescriptor(serialName, values.length);
        int length = values.length;
        int i8 = 0;
        int i9 = 0;
        while (i8 < length) {
            T t7 = values[i8];
            int i10 = i9 + 1;
            K = ArraysKt___ArraysKt.K(names, i9);
            String str = (String) K;
            if (str == null) {
                str = t7.name();
            }
            PluginGeneratedSerialDescriptor.m(enumDescriptor, str, false, 2, null);
            K2 = ArraysKt___ArraysKt.K(annotations, i9);
            Annotation[] annotationArr = (Annotation[]) K2;
            if (annotationArr != null) {
                for (Annotation annotation : annotationArr) {
                    enumDescriptor.r(annotation);
                }
            }
            i8++;
            i9 = i10;
        }
        return new EnumSerializer(serialName, values, enumDescriptor);
    }
}
