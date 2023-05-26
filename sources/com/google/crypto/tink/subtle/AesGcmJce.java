package com.google.crypto.tink.subtle;

import com.google.crypto.tink.Aead;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class AesGcmJce implements Aead {

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal<Cipher> f15316b = new ThreadLocal<Cipher>() { // from class: com.google.crypto.tink.subtle.AesGcmJce.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public Cipher initialValue() {
            try {
                return EngineFactory.f15350f.a("AES/GCM/NoPadding");
            } catch (GeneralSecurityException e8) {
                throw new IllegalStateException(e8);
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final SecretKey f15317a;

    public AesGcmJce(byte[] bArr) throws GeneralSecurityException {
        Validators.a(bArr.length);
        this.f15317a = new SecretKeySpec(bArr, "AES");
    }

    private static AlgorithmParameterSpec c(byte[] bArr) throws GeneralSecurityException {
        return d(bArr, 0, bArr.length);
    }

    private static AlgorithmParameterSpec d(byte[] bArr, int i8, int i9) throws GeneralSecurityException {
        if (SubtleUtil.b() && SubtleUtil.a() <= 19) {
            return new IvParameterSpec(bArr, i8, i9);
        }
        return new GCMParameterSpec(128, bArr, i8, i9);
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length <= 2147483619) {
            byte[] bArr3 = new byte[bArr.length + 12 + 16];
            byte[] c8 = Random.c(12);
            System.arraycopy(c8, 0, bArr3, 0, 12);
            AlgorithmParameterSpec c9 = c(c8);
            ThreadLocal<Cipher> threadLocal = f15316b;
            threadLocal.get().init(1, this.f15317a, c9);
            if (bArr2 != null && bArr2.length != 0) {
                threadLocal.get().updateAAD(bArr2);
            }
            int doFinal = threadLocal.get().doFinal(bArr, 0, bArr.length, bArr3, 12);
            if (doFinal == bArr.length + 16) {
                return bArr3;
            }
            throw new GeneralSecurityException(String.format("encryption failed; GCM tag must be %s bytes, but got only %s bytes", 16, Integer.valueOf(doFinal - bArr.length)));
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length >= 28) {
            AlgorithmParameterSpec d8 = d(bArr, 0, 12);
            ThreadLocal<Cipher> threadLocal = f15316b;
            threadLocal.get().init(2, this.f15317a, d8);
            if (bArr2 != null && bArr2.length != 0) {
                threadLocal.get().updateAAD(bArr2);
            }
            return threadLocal.get().doFinal(bArr, 12, bArr.length - 12);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
