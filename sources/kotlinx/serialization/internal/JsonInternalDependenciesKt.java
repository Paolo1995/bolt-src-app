package kotlinx.serialization.internal;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* compiled from: JsonInternalDependencies.kt */
/* loaded from: classes5.dex */
public final class JsonInternalDependenciesKt {
    public static final Set<String> a(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "<this>");
        return Platform_commonKt.a(serialDescriptor);
    }
}
