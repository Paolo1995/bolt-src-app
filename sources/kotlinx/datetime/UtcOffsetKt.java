package kotlinx.datetime;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: UtcOffset.kt */
/* loaded from: classes5.dex */
public final class UtcOffsetKt {
    public static final FixedOffsetTimeZone a(UtcOffset utcOffset) {
        Intrinsics.f(utcOffset, "<this>");
        return new FixedOffsetTimeZone(utcOffset);
    }
}
