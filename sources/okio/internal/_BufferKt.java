package okio.internal;

import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.Options;
import okio.Segment;
import okio._JvmPlatformKt;
import okio._UtilKt;

/* compiled from: -Buffer.kt */
/* loaded from: classes5.dex */
public final class _BufferKt {

    /* renamed from: a */
    private static final byte[] f52650a = _JvmPlatformKt.a("0123456789abcdef");

    public static final Buffer.UnsafeCursor a(Buffer buffer, Buffer.UnsafeCursor unsafeCursor) {
        boolean z7;
        Intrinsics.f(buffer, "<this>");
        Intrinsics.f(unsafeCursor, "unsafeCursor");
        Buffer.UnsafeCursor e8 = _UtilKt.e(unsafeCursor);
        if (e8.f52582f == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            e8.f52582f = buffer;
            e8.f52583g = true;
            return e8;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    public static final byte[] b() {
        return f52650a;
    }

    public static final boolean c(Segment segment, int i8, byte[] bytes, int i9, int i10) {
        Intrinsics.f(segment, "segment");
        Intrinsics.f(bytes, "bytes");
        int i11 = segment.f52633c;
        byte[] bArr = segment.f52631a;
        while (i9 < i10) {
            if (i8 == i11) {
                segment = segment.f52636f;
                Intrinsics.c(segment);
                byte[] bArr2 = segment.f52631a;
                bArr = bArr2;
                i8 = segment.f52632b;
                i11 = segment.f52633c;
            }
            if (bArr[i8] != bytes[i9]) {
                return false;
            }
            i8++;
            i9++;
        }
        return true;
    }

    public static final String d(Buffer buffer, long j8) {
        Intrinsics.f(buffer, "<this>");
        if (j8 > 0) {
            long j9 = j8 - 1;
            if (buffer.m(j9) == ((byte) 13)) {
                String s02 = buffer.s0(j9);
                buffer.skip(2L);
                return s02;
            }
        }
        String s03 = buffer.s0(j8);
        buffer.skip(1L);
        return s03;
    }

    public static final int e(Buffer buffer, Options options, boolean z7) {
        int i8;
        int i9;
        boolean z8;
        int i10;
        int i11;
        Segment segment;
        Intrinsics.f(buffer, "<this>");
        Intrinsics.f(options, "options");
        Segment segment2 = buffer.f52580f;
        if (segment2 == null) {
            if (z7) {
                return -2;
            }
            return -1;
        }
        byte[] bArr = segment2.f52631a;
        int i12 = segment2.f52632b;
        int i13 = segment2.f52633c;
        int[] k8 = options.k();
        Segment segment3 = segment2;
        int i14 = 0;
        int i15 = -1;
        loop0: while (true) {
            int i16 = i14 + 1;
            int i17 = k8[i14];
            int i18 = i16 + 1;
            int i19 = k8[i16];
            if (i19 != -1) {
                i15 = i19;
            }
            if (segment3 == null) {
                break;
            }
            if (i17 < 0) {
                int i20 = i18 + (i17 * (-1));
                while (true) {
                    int i21 = i12 + 1;
                    int i22 = i18 + 1;
                    if ((bArr[i12] & 255) != k8[i18]) {
                        return i15;
                    }
                    if (i22 == i20) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (i21 == i13) {
                        Intrinsics.c(segment3);
                        Segment segment4 = segment3.f52636f;
                        Intrinsics.c(segment4);
                        i11 = segment4.f52632b;
                        byte[] bArr2 = segment4.f52631a;
                        i10 = segment4.f52633c;
                        if (segment4 == segment2) {
                            if (!z8) {
                                break loop0;
                            }
                            bArr = bArr2;
                            segment = null;
                        } else {
                            segment = segment4;
                            bArr = bArr2;
                        }
                    } else {
                        Segment segment5 = segment3;
                        i10 = i13;
                        i11 = i21;
                        segment = segment5;
                    }
                    if (z8) {
                        i9 = k8[i22];
                        i8 = i11;
                        i13 = i10;
                        segment3 = segment;
                        break;
                    }
                    i12 = i11;
                    i13 = i10;
                    i18 = i22;
                    segment3 = segment;
                }
            } else {
                i8 = i12 + 1;
                int i23 = bArr[i12] & 255;
                int i24 = i18 + i17;
                while (i18 != i24) {
                    if (i23 == k8[i18]) {
                        i9 = k8[i18 + i17];
                        if (i8 == i13) {
                            segment3 = segment3.f52636f;
                            Intrinsics.c(segment3);
                            i8 = segment3.f52632b;
                            bArr = segment3.f52631a;
                            i13 = segment3.f52633c;
                            if (segment3 == segment2) {
                                segment3 = null;
                            }
                        }
                    } else {
                        i18++;
                    }
                }
                return i15;
            }
            if (i9 >= 0) {
                return i9;
            }
            i14 = -i9;
            i12 = i8;
        }
        if (z7) {
            return -2;
        }
        return i15;
    }

    public static /* synthetic */ int f(Buffer buffer, Options options, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        return e(buffer, options, z7);
    }
}
