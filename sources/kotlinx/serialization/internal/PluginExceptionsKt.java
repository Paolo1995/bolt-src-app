package kotlinx.serialization.internal;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* compiled from: PluginExceptions.kt */
/* loaded from: classes5.dex */
public final class PluginExceptionsKt {
    public static final void a(int i8, int i9, SerialDescriptor descriptor) {
        Intrinsics.f(descriptor, "descriptor");
        ArrayList arrayList = new ArrayList();
        int i10 = (~i8) & i9;
        for (int i11 = 0; i11 < 32; i11++) {
            if ((i10 & 1) != 0) {
                arrayList.add(descriptor.f(i11));
            }
            i10 >>>= 1;
        }
        throw new MissingFieldException(arrayList, descriptor.i());
    }
}
