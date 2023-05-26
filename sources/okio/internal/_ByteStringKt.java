package okio.internal;

import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;

/* compiled from: -ByteString.kt */
/* loaded from: classes5.dex */
public final class _ByteStringKt {

    /* renamed from: a */
    private static final char[] f52651a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX WARN: Removed duplicated region for block: B:553:0x0044 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:556:0x007a A[EDGE_INSN: B:556:0x007a->B:350:0x007a ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:563:0x0159 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:576:0x00ce A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:581:0x01fc A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int c(byte[] r19, int r20) {
        /*
            Method dump skipped, instructions count: 528
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._ByteStringKt.c(byte[], int):int");
    }

    public static final void d(ByteString byteString, Buffer buffer, int i8, int i9) {
        Intrinsics.f(byteString, "<this>");
        Intrinsics.f(buffer, "buffer");
        buffer.write(byteString.j(), i8, i9);
    }

    public static final int e(char c8) {
        boolean z7;
        boolean z8;
        boolean z9 = true;
        if ('0' <= c8 && c8 <= '9') {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return c8 - '0';
        }
        char c9 = 'a';
        if ('a' <= c8 && c8 <= 'f') {
            z8 = true;
        } else {
            z8 = false;
        }
        if (!z8) {
            c9 = 'A';
            if (!(('A' > c8 || c8 > 'F') ? false : false)) {
                throw new IllegalArgumentException(Intrinsics.n("Unexpected hex digit: ", Character.valueOf(c8)));
            }
        }
        return (c8 - c9) + 10;
    }

    public static final char[] f() {
        return f52651a;
    }
}
