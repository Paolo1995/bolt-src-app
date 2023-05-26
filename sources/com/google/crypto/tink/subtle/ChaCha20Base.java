package com.google.crypto.tink.subtle;

import com.google.android.gms.common.api.Api;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* loaded from: classes.dex */
abstract class ChaCha20Base implements IndCpaCipher {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f15340c = m(new byte[]{101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107});

    /* renamed from: a  reason: collision with root package name */
    int[] f15341a;

    /* renamed from: b  reason: collision with root package name */
    private final int f15342b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChaCha20Base(byte[] bArr, int i8) throws InvalidKeyException {
        if (bArr.length == 32) {
            this.f15341a = m(bArr);
            this.f15342b = i8;
            return;
        }
        throw new InvalidKeyException("The key length in bytes must be 32.");
    }

    private void h(byte[] bArr, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws GeneralSecurityException {
        int remaining = byteBuffer2.remaining();
        int i8 = (remaining / 64) + 1;
        for (int i9 = 0; i9 < i8; i9++) {
            ByteBuffer c8 = c(bArr, this.f15342b + i9);
            if (i9 == i8 - 1) {
                Bytes.c(byteBuffer, byteBuffer2, c8, remaining % 64);
            } else {
                Bytes.c(byteBuffer, byteBuffer2, c8, 64);
            }
        }
    }

    static void i(int[] iArr, int i8, int i9, int i10, int i11) {
        int i12 = iArr[i8] + iArr[i9];
        iArr[i8] = i12;
        int j8 = j(i12 ^ iArr[i11], 16);
        iArr[i11] = j8;
        int i13 = iArr[i10] + j8;
        iArr[i10] = i13;
        int j9 = j(iArr[i9] ^ i13, 12);
        iArr[i9] = j9;
        int i14 = iArr[i8] + j9;
        iArr[i8] = i14;
        int j10 = j(iArr[i11] ^ i14, 8);
        iArr[i11] = j10;
        int i15 = iArr[i10] + j10;
        iArr[i10] = i15;
        iArr[i9] = j(iArr[i9] ^ i15, 7);
    }

    private static int j(int i8, int i9) {
        return (i8 >>> (-i9)) | (i8 << i9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void k(int[] iArr, int[] iArr2) {
        int[] iArr3 = f15340c;
        System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
        System.arraycopy(iArr2, 0, iArr, iArr3.length, 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void l(int[] iArr) {
        for (int i8 = 0; i8 < 10; i8++) {
            i(iArr, 0, 4, 8, 12);
            i(iArr, 1, 5, 9, 13);
            i(iArr, 2, 6, 10, 14);
            i(iArr, 3, 7, 11, 15);
            i(iArr, 0, 5, 10, 15);
            i(iArr, 1, 6, 11, 12);
            i(iArr, 2, 7, 8, 13);
            i(iArr, 3, 4, 9, 14);
        }
    }

    static int[] m(byte[] bArr) {
        IntBuffer asIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        return iArr;
    }

    @Override // com.google.crypto.tink.subtle.IndCpaCipher
    public byte[] a(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length <= Api.BaseClientBuilder.API_PRIORITY_OTHER - g()) {
            ByteBuffer allocate = ByteBuffer.allocate(g() + bArr.length);
            f(allocate, bArr);
            return allocate.array();
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    @Override // com.google.crypto.tink.subtle.IndCpaCipher
    public byte[] b(byte[] bArr) throws GeneralSecurityException {
        return e(ByteBuffer.wrap(bArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteBuffer c(byte[] bArr, int i8) {
        int[] d8 = d(m(bArr), i8);
        int[] iArr = (int[]) d8.clone();
        l(iArr);
        for (int i9 = 0; i9 < d8.length; i9++) {
            d8[i9] = d8[i9] + iArr[i9];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(d8, 0, 16);
        return order;
    }

    abstract int[] d(int[] iArr, int i8);

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] e(ByteBuffer byteBuffer) throws GeneralSecurityException {
        if (byteBuffer.remaining() >= g()) {
            byte[] bArr = new byte[g()];
            byteBuffer.get(bArr);
            ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
            h(bArr, allocate, byteBuffer);
            return allocate.array();
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ByteBuffer byteBuffer, byte[] bArr) throws GeneralSecurityException {
        if (byteBuffer.remaining() - g() >= bArr.length) {
            byte[] c8 = Random.c(g());
            byteBuffer.put(c8);
            h(c8, byteBuffer, ByteBuffer.wrap(bArr));
            return;
        }
        throw new IllegalArgumentException("Given ByteBuffer output is too small");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int g();
}
