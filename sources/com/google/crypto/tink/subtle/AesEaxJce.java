package com.google.crypto.tink.subtle;

import com.google.android.gms.common.api.Api;
import com.google.crypto.tink.Aead;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class AesEaxJce implements Aead {

    /* renamed from: e  reason: collision with root package name */
    private static final ThreadLocal<Cipher> f15310e = new ThreadLocal<Cipher>() { // from class: com.google.crypto.tink.subtle.AesEaxJce.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public Cipher initialValue() {
            try {
                return EngineFactory.f15350f.a("AES/ECB/NOPADDING");
            } catch (GeneralSecurityException e8) {
                throw new IllegalStateException(e8);
            }
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private static final ThreadLocal<Cipher> f15311f = new ThreadLocal<Cipher>() { // from class: com.google.crypto.tink.subtle.AesEaxJce.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public Cipher initialValue() {
            try {
                return EngineFactory.f15350f.a("AES/CTR/NOPADDING");
            } catch (GeneralSecurityException e8) {
                throw new IllegalStateException(e8);
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f15312a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f15313b;

    /* renamed from: c  reason: collision with root package name */
    private final SecretKeySpec f15314c;

    /* renamed from: d  reason: collision with root package name */
    private final int f15315d;

    public AesEaxJce(byte[] bArr, int i8) throws GeneralSecurityException {
        if (i8 != 12 && i8 != 16) {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        this.f15315d = i8;
        Validators.a(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.f15314c = secretKeySpec;
        Cipher cipher = f15310e.get();
        cipher.init(1, secretKeySpec);
        byte[] c8 = c(cipher.doFinal(new byte[16]));
        this.f15312a = c8;
        this.f15313b = c(c8);
    }

    private static byte[] c(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i8 = 0;
        int i9 = 0;
        while (i9 < 15) {
            int i10 = i9 + 1;
            bArr2[i9] = (byte) (((bArr[i9] << 1) ^ ((bArr[i10] & 255) >>> 7)) & 255);
            i9 = i10;
        }
        int i11 = bArr[15] << 1;
        if ((bArr[0] & 128) != 0) {
            i8 = 135;
        }
        bArr2[15] = (byte) (i11 ^ i8);
        return bArr2;
    }

    private byte[] d(Cipher cipher, int i8, byte[] bArr, int i9, int i10) throws IllegalBlockSizeException, BadPaddingException {
        byte[] bArr2 = new byte[16];
        bArr2[15] = (byte) i8;
        if (i10 == 0) {
            return cipher.doFinal(f(bArr2, this.f15312a));
        }
        byte[] doFinal = cipher.doFinal(bArr2);
        int i11 = 0;
        while (i10 - i11 > 16) {
            for (int i12 = 0; i12 < 16; i12++) {
                doFinal[i12] = (byte) (doFinal[i12] ^ bArr[(i9 + i11) + i12]);
            }
            doFinal = cipher.doFinal(doFinal);
            i11 += 16;
        }
        return cipher.doFinal(f(doFinal, e(Arrays.copyOfRange(bArr, i11 + i9, i9 + i10))));
    }

    private byte[] e(byte[] bArr) {
        if (bArr.length == 16) {
            return f(bArr, this.f15312a);
        }
        byte[] copyOf = Arrays.copyOf(this.f15313b, 16);
        for (int i8 = 0; i8 < bArr.length; i8++) {
            copyOf[i8] = (byte) (copyOf[i8] ^ bArr[i8]);
        }
        copyOf[bArr.length] = (byte) (copyOf[bArr.length] ^ 128);
        return copyOf;
    }

    private static byte[] f(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i8 = 0; i8 < length; i8++) {
            bArr3[i8] = (byte) (bArr[i8] ^ bArr2[i8]);
        }
        return bArr3;
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3;
        int length = bArr.length;
        int i8 = this.f15315d;
        if (length <= (Api.BaseClientBuilder.API_PRIORITY_OTHER - i8) - 16) {
            byte[] bArr4 = new byte[bArr.length + i8 + 16];
            byte[] c8 = Random.c(i8);
            System.arraycopy(c8, 0, bArr4, 0, this.f15315d);
            Cipher cipher = f15310e.get();
            cipher.init(1, this.f15314c);
            byte[] d8 = d(cipher, 0, c8, 0, c8.length);
            if (bArr2 == null) {
                bArr3 = new byte[0];
            } else {
                bArr3 = bArr2;
            }
            byte[] d9 = d(cipher, 1, bArr3, 0, bArr3.length);
            Cipher cipher2 = f15311f.get();
            cipher2.init(1, this.f15314c, new IvParameterSpec(d8));
            cipher2.doFinal(bArr, 0, bArr.length, bArr4, this.f15315d);
            byte[] d10 = d(cipher, 2, bArr4, this.f15315d, bArr.length);
            int length2 = bArr.length + this.f15315d;
            for (int i9 = 0; i9 < 16; i9++) {
                bArr4[length2 + i9] = (byte) ((d9[i9] ^ d8[i9]) ^ d10[i9]);
            }
            return bArr4;
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = (bArr.length - this.f15315d) - 16;
        if (length >= 0) {
            Cipher cipher = f15310e.get();
            cipher.init(1, this.f15314c);
            byte[] d8 = d(cipher, 0, bArr, 0, this.f15315d);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            byte[] bArr3 = bArr2;
            byte[] d9 = d(cipher, 1, bArr3, 0, bArr3.length);
            byte[] d10 = d(cipher, 2, bArr, this.f15315d, length);
            int length2 = bArr.length - 16;
            byte b8 = 0;
            for (int i8 = 0; i8 < 16; i8++) {
                b8 = (byte) (b8 | (((bArr[length2 + i8] ^ d9[i8]) ^ d8[i8]) ^ d10[i8]));
            }
            if (b8 == 0) {
                Cipher cipher2 = f15311f.get();
                cipher2.init(1, this.f15314c, new IvParameterSpec(d8));
                return cipher2.doFinal(bArr, this.f15315d, length);
            }
            throw new AEADBadTagException("tag mismatch");
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
