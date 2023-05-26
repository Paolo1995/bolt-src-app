package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.ContextAwareKt;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.modules.SerializersModule;

/* compiled from: WriteMode.kt */
/* loaded from: classes5.dex */
public final class WriteModeKt {
    public static final SerialDescriptor a(SerialDescriptor serialDescriptor, SerializersModule module) {
        SerialDescriptor a8;
        Intrinsics.f(serialDescriptor, "<this>");
        Intrinsics.f(module, "module");
        if (Intrinsics.a(serialDescriptor.d(), SerialKind.CONTEXTUAL.f52122a)) {
            SerialDescriptor b8 = ContextAwareKt.b(module, serialDescriptor);
            if (b8 != null && (a8 = a(b8, module)) != null) {
                return a8;
            }
            return serialDescriptor;
        } else if (serialDescriptor.isInline()) {
            return a(serialDescriptor.h(0), module);
        } else {
            return serialDescriptor;
        }
    }

    public static final WriteMode b(Json json, SerialDescriptor desc) {
        Intrinsics.f(json, "<this>");
        Intrinsics.f(desc, "desc");
        SerialKind d8 = desc.d();
        if (d8 instanceof PolymorphicKind) {
            return WriteMode.POLY_OBJ;
        }
        if (Intrinsics.a(d8, StructureKind.LIST.f52125a)) {
            return WriteMode.LIST;
        }
        if (Intrinsics.a(d8, StructureKind.MAP.f52126a)) {
            SerialDescriptor a8 = a(desc.h(0), json.a());
            SerialKind d9 = a8.d();
            if (!(d9 instanceof PrimitiveKind) && !Intrinsics.a(d9, SerialKind.ENUM.f52123a)) {
                if (json.g().b()) {
                    return WriteMode.LIST;
                }
                throw JsonExceptionsKt.c(a8);
            }
            return WriteMode.MAP;
        }
        return WriteMode.OBJ;
    }
}
