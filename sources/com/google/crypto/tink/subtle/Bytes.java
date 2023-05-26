package com.google.crypto.tink.subtle;

import com.google.android.gms.common.api.Api;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class Bytes {
    public static byte[] a(byte[]... bArr) throws GeneralSecurityException {
        int i8 = 0;
        for (byte[] bArr2 : bArr) {
            if (i8 <= Api.BaseClientBuilder.API_PRIORITY_OTHER - bArr2.length) {
                i8 += bArr2.length;
            } else {
                throw new GeneralSecurityException("exceeded size limit");
            }
        }
        byte[] bArr3 = new byte[i8];
        int i9 = 0;
        for (byte[] bArr4 : bArr) {
            System.arraycopy(bArr4, 0, bArr3, i9, bArr4.length);
            i9 += bArr4.length;
        }
        return bArr3;
    }

    public static final boolean b(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length != bArr2.length) {
            return false;
        }
        int i8 = 0;
        for (int i9 = 0; i9 < bArr.length; i9++) {
            i8 |= bArr[i9] ^ bArr2[i9];
        }
        if (i8 != 0) {
            return false;
        }
        return true;
    }

    public static final void c(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i8) {
        if (i8 >= 0 && byteBuffer2.remaining() >= i8 && byteBuffer3.remaining() >= i8 && byteBuffer.remaining() >= i8) {
            for (int i9 = 0; i9 < i8; i9++) {
                byteBuffer.put((byte) (byteBuffer2.get() ^ byteBuffer3.get()));
            }
            return;
        }
        throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
    }

    public static final byte[] d(byte[] bArr, int i8, byte[] bArr2, int i9, int i10) {
        if (i10 >= 0 && bArr.length - i10 >= i8 && bArr2.length - i10 >= i9) {
            byte[] bArr3 = new byte[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                bArr3[i11] = (byte) (bArr[i11 + i8] ^ bArr2[i11 + i9]);
            }
            return bArr3;
        }
        throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
    }

    public static final byte[] e(byte[] bArr, byte[] bArr2) {
        if (bArr.length == bArr2.length) {
            return d(bArr, 0, bArr2, 0, bArr.length);
        }
        throw new IllegalArgumentException("The lengths of x and y should match.");
    }

    public static final byte[] f(byte[] bArr, byte[] bArr2) {
        if (bArr.length >= bArr2.length) {
            int length = bArr.length - bArr2.length;
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            for (int i8 = 0; i8 < bArr2.length; i8++) {
                int i9 = length + i8;
                copyOf[i9] = (byte) (copyOf[i9] ^ bArr2[i8]);
            }
            return copyOf;
        }
        throw new IllegalArgumentException("xorEnd requires a.length >= b.length");
    }
}
