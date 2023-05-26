package kotlinx.serialization.json.internal;

import java.util.Set;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* compiled from: StreamingJsonEncoder.kt */
/* loaded from: classes5.dex */
public final class StreamingJsonEncoderKt {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<SerialDescriptor> f52442a;

    static {
        Set<SerialDescriptor> f8;
        f8 = SetsKt__SetsKt.f(BuiltinSerializersKt.v(UInt.f50837g).a(), BuiltinSerializersKt.w(ULong.f50842g).a(), BuiltinSerializersKt.u(UByte.f50832g).a(), BuiltinSerializersKt.x(UShort.f50848g).a());
        f52442a = f8;
    }

    public static final boolean a(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "<this>");
        if (serialDescriptor.isInline() && f52442a.contains(serialDescriptor)) {
            return true;
        }
        return false;
    }
}
