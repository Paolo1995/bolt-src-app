package okio;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okio.Buffer;
import okio.internal._ByteStringKt;

/* compiled from: -Util.kt */
/* loaded from: classes5.dex */
public final class _UtilKt {

    /* renamed from: a  reason: collision with root package name */
    private static final Buffer.UnsafeCursor f52648a = new Buffer.UnsafeCursor();

    /* renamed from: b  reason: collision with root package name */
    private static final int f52649b = -1234567890;

    public static final boolean a(byte[] a8, int i8, byte[] b8, int i9, int i10) {
        Intrinsics.f(a8, "a");
        Intrinsics.f(b8, "b");
        if (i10 > 0) {
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                if (a8[i11 + i8] != b8[i11 + i9]) {
                    return false;
                }
                if (i12 < i10) {
                    i11 = i12;
                } else {
                    return true;
                }
            }
        } else {
            return true;
        }
    }

    public static final void b(long j8, long j9, long j10) {
        if ((j9 | j10) >= 0 && j9 <= j8 && j8 - j9 >= j10) {
            return;
        }
        throw new ArrayIndexOutOfBoundsException("size=" + j8 + " offset=" + j9 + " byteCount=" + j10);
    }

    public static final Buffer.UnsafeCursor c() {
        return f52648a;
    }

    public static final int d(ByteString byteString, int i8) {
        Intrinsics.f(byteString, "<this>");
        if (i8 == f52649b) {
            return byteString.z();
        }
        return i8;
    }

    public static final Buffer.UnsafeCursor e(Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.f(unsafeCursor, "unsafeCursor");
        if (unsafeCursor == f52648a) {
            return new Buffer.UnsafeCursor();
        }
        return unsafeCursor;
    }

    public static final int f(int i8) {
        return ((i8 & 255) << 24) | (((-16777216) & i8) >>> 24) | ((16711680 & i8) >>> 8) | ((65280 & i8) << 8);
    }

    public static final short g(short s7) {
        int i8 = s7 & 65535;
        return (short) (((i8 & 255) << 8) | ((65280 & i8) >>> 8));
    }

    public static final String h(byte b8) {
        String q8;
        q8 = StringsKt__StringsJVMKt.q(new char[]{_ByteStringKt.f()[(b8 >> 4) & 15], _ByteStringKt.f()[b8 & 15]});
        return q8;
    }

    public static final String i(int i8) {
        String r7;
        if (i8 == 0) {
            return "0";
        }
        int i9 = 0;
        char[] cArr = {_ByteStringKt.f()[(i8 >> 28) & 15], _ByteStringKt.f()[(i8 >> 24) & 15], _ByteStringKt.f()[(i8 >> 20) & 15], _ByteStringKt.f()[(i8 >> 16) & 15], _ByteStringKt.f()[(i8 >> 12) & 15], _ByteStringKt.f()[(i8 >> 8) & 15], _ByteStringKt.f()[(i8 >> 4) & 15], _ByteStringKt.f()[i8 & 15]};
        while (i9 < 8 && cArr[i9] == '0') {
            i9++;
        }
        r7 = StringsKt__StringsJVMKt.r(cArr, i9, 8);
        return r7;
    }
}
