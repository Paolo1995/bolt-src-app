package kotlinx.serialization.descriptors;

import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.internal.PrimitivesKt;

/* compiled from: SerialDescriptors.kt */
/* loaded from: classes5.dex */
public final class SerialDescriptorsKt {
    public static final SerialDescriptor a(String serialName, PrimitiveKind kind) {
        boolean y7;
        Intrinsics.f(serialName, "serialName");
        Intrinsics.f(kind, "kind");
        y7 = StringsKt__StringsJVMKt.y(serialName);
        if (!y7) {
            return PrimitivesKt.a(serialName, kind);
        }
        throw new IllegalArgumentException("Blank serial names are prohibited".toString());
    }

    public static final SerialDescriptor b(String serialName, SerialDescriptor[] typeParameters, Function1<? super ClassSerialDescriptorBuilder, Unit> builderAction) {
        boolean y7;
        List f02;
        Intrinsics.f(serialName, "serialName");
        Intrinsics.f(typeParameters, "typeParameters");
        Intrinsics.f(builderAction, "builderAction");
        y7 = StringsKt__StringsJVMKt.y(serialName);
        if (!y7) {
            ClassSerialDescriptorBuilder classSerialDescriptorBuilder = new ClassSerialDescriptorBuilder(serialName);
            builderAction.invoke(classSerialDescriptorBuilder);
            StructureKind.CLASS r32 = StructureKind.CLASS.f52124a;
            int size = classSerialDescriptorBuilder.f().size();
            f02 = ArraysKt___ArraysKt.f0(typeParameters);
            return new SerialDescriptorImpl(serialName, r32, size, f02, classSerialDescriptorBuilder);
        }
        throw new IllegalArgumentException("Blank serial names are prohibited".toString());
    }

    public static final SerialDescriptor c(String serialName, SerialKind kind, SerialDescriptor[] typeParameters, Function1<? super ClassSerialDescriptorBuilder, Unit> builder) {
        boolean y7;
        List f02;
        Intrinsics.f(serialName, "serialName");
        Intrinsics.f(kind, "kind");
        Intrinsics.f(typeParameters, "typeParameters");
        Intrinsics.f(builder, "builder");
        y7 = StringsKt__StringsJVMKt.y(serialName);
        if (!y7) {
            if (!Intrinsics.a(kind, StructureKind.CLASS.f52124a)) {
                ClassSerialDescriptorBuilder classSerialDescriptorBuilder = new ClassSerialDescriptorBuilder(serialName);
                builder.invoke(classSerialDescriptorBuilder);
                int size = classSerialDescriptorBuilder.f().size();
                f02 = ArraysKt___ArraysKt.f0(typeParameters);
                return new SerialDescriptorImpl(serialName, kind, size, f02, classSerialDescriptorBuilder);
            }
            throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead".toString());
        }
        throw new IllegalArgumentException("Blank serial names are prohibited".toString());
    }

    public static /* synthetic */ SerialDescriptor d(String str, SerialKind serialKind, SerialDescriptor[] serialDescriptorArr, Function1 function1, int i8, Object obj) {
        if ((i8 & 8) != 0) {
            function1 = new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.serialization.descriptors.SerialDescriptorsKt$buildSerialDescriptor$1
                public final void b(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
                    Intrinsics.f(classSerialDescriptorBuilder, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
                    b(classSerialDescriptorBuilder);
                    return Unit.f50853a;
                }
            };
        }
        return c(str, serialKind, serialDescriptorArr, function1);
    }
}
