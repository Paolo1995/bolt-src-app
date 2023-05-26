package okio;

import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* compiled from: -Base64.kt */
/* loaded from: classes5.dex */
public final class _Base64Kt {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f52646a;

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f52647b;

    static {
        ByteString.Companion companion = ByteString.f52591i;
        f52646a = companion.d("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").j();
        f52647b = companion.d("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").j();
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x00b8 A[LOOP:1: B:16:0x003e->B:63:0x00b8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00b4 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final byte[] a(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio._Base64Kt.a(java.lang.String):byte[]");
    }

    public static final String b(byte[] bArr, byte[] map) {
        Intrinsics.f(bArr, "<this>");
        Intrinsics.f(map, "map");
        byte[] bArr2 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i8 = 0;
        int i9 = 0;
        while (i8 < length) {
            int i10 = i8 + 1;
            byte b8 = bArr[i8];
            int i11 = i10 + 1;
            byte b9 = bArr[i10];
            int i12 = i11 + 1;
            byte b10 = bArr[i11];
            int i13 = i9 + 1;
            bArr2[i9] = map[(b8 & 255) >> 2];
            int i14 = i13 + 1;
            bArr2[i13] = map[((b8 & 3) << 4) | ((b9 & 255) >> 4)];
            int i15 = i14 + 1;
            bArr2[i14] = map[((b9 & 15) << 2) | ((b10 & 255) >> 6)];
            i9 = i15 + 1;
            bArr2[i15] = map[b10 & 63];
            i8 = i12;
        }
        int length2 = bArr.length - length;
        if (length2 != 1) {
            if (length2 == 2) {
                int i16 = i8 + 1;
                byte b11 = bArr[i8];
                byte b12 = bArr[i16];
                int i17 = i9 + 1;
                bArr2[i9] = map[(b11 & 255) >> 2];
                int i18 = i17 + 1;
                bArr2[i17] = map[((b11 & 3) << 4) | ((b12 & 255) >> 4)];
                bArr2[i18] = map[(b12 & 15) << 2];
                bArr2[i18 + 1] = (byte) 61;
            }
        } else {
            byte b13 = bArr[i8];
            int i19 = i9 + 1;
            bArr2[i9] = map[(b13 & 255) >> 2];
            int i20 = i19 + 1;
            bArr2[i19] = map[(b13 & 3) << 4];
            byte b14 = (byte) 61;
            bArr2[i20] = b14;
            bArr2[i20 + 1] = b14;
        }
        return _JvmPlatformKt.b(bArr2);
    }

    public static /* synthetic */ String c(byte[] bArr, byte[] bArr2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            bArr2 = f52646a;
        }
        return b(bArr, bArr2);
    }
}
