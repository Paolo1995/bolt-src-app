package okio.internal;

import kotlin.jvm.internal.Intrinsics;
import okio.SegmentedByteString;

/* compiled from: -SegmentedByteString.kt */
/* loaded from: classes5.dex */
public final class _SegmentedByteStringKt {
    public static final int a(int[] iArr, int i8, int i9, int i10) {
        Intrinsics.f(iArr, "<this>");
        int i11 = i10 - 1;
        while (i9 <= i11) {
            int i12 = (i9 + i11) >>> 1;
            int i13 = iArr[i12];
            if (i13 < i8) {
                i9 = i12 + 1;
            } else if (i13 > i8) {
                i11 = i12 - 1;
            } else {
                return i12;
            }
        }
        return (-i9) - 1;
    }

    public static final int b(SegmentedByteString segmentedByteString, int i8) {
        Intrinsics.f(segmentedByteString, "<this>");
        int a8 = a(segmentedByteString.F(), i8 + 1, 0, segmentedByteString.G().length);
        if (a8 < 0) {
            return ~a8;
        }
        return a8;
    }
}
