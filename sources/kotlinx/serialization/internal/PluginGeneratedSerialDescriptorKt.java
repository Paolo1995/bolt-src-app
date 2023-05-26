package kotlinx.serialization.internal;

import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorKt;
import kotlinx.serialization.descriptors.SerialKind;

/* compiled from: PluginGeneratedSerialDescriptor.kt */
/* loaded from: classes5.dex */
public final class PluginGeneratedSerialDescriptorKt {
    public static final int a(SerialDescriptor serialDescriptor, SerialDescriptor[] typeParams) {
        int i8;
        Intrinsics.f(serialDescriptor, "<this>");
        Intrinsics.f(typeParams, "typeParams");
        int hashCode = (serialDescriptor.i().hashCode() * 31) + Arrays.hashCode(typeParams);
        Iterable<SerialDescriptor> a8 = SerialDescriptorKt.a(serialDescriptor);
        Iterator<SerialDescriptor> it = a8.iterator();
        int i9 = 1;
        int i10 = 1;
        while (true) {
            int i11 = 0;
            if (!it.hasNext()) {
                break;
            }
            int i12 = i10 * 31;
            String i13 = it.next().i();
            if (i13 != null) {
                i11 = i13.hashCode();
            }
            i10 = i12 + i11;
        }
        for (SerialDescriptor serialDescriptor2 : a8) {
            int i14 = i9 * 31;
            SerialKind d8 = serialDescriptor2.d();
            if (d8 != null) {
                i8 = d8.hashCode();
            } else {
                i8 = 0;
            }
            i9 = i14 + i8;
        }
        return (((hashCode * 31) + i10) * 31) + i9;
    }
}
