package com.google.crypto.tink.subtle;

import com.google.android.gms.common.api.Api;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class AesCtrJceCipher implements IndCpaCipher {

    /* renamed from: d  reason: collision with root package name */
    private static final ThreadLocal<Cipher> f15306d = new ThreadLocal<Cipher>() { // from class: com.google.crypto.tink.subtle.AesCtrJceCipher.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public Cipher initialValue() {
            try {
                return EngineFactory.f15350f.a("AES/CTR/NoPadding");
            } catch (GeneralSecurityException e8) {
                throw new IllegalStateException(e8);
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final SecretKeySpec f15307a;

    /* renamed from: b  reason: collision with root package name */
    private final int f15308b;

    /* renamed from: c  reason: collision with root package name */
    private final int f15309c;

    public AesCtrJceCipher(byte[] bArr, int i8) throws GeneralSecurityException {
        Validators.a(bArr.length);
        this.f15307a = new SecretKeySpec(bArr, "AES");
        int blockSize = f15306d.get().getBlockSize();
        this.f15309c = blockSize;
        if (i8 >= 12 && i8 <= blockSize) {
            this.f15308b = i8;
            return;
        }
        throw new GeneralSecurityException("invalid IV size");
    }

    private void c(byte[] bArr, int i8, int i9, byte[] bArr2, int i10, byte[] bArr3, boolean z7) throws GeneralSecurityException {
        Cipher cipher = f15306d.get();
        byte[] bArr4 = new byte[this.f15309c];
        System.arraycopy(bArr3, 0, bArr4, 0, this.f15308b);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr4);
        if (z7) {
            cipher.init(1, this.f15307a, ivParameterSpec);
        } else {
            cipher.init(2, this.f15307a, ivParameterSpec);
        }
        if (cipher.doFinal(bArr, i8, i9, bArr2, i10) == i9) {
            return;
        }
        throw new GeneralSecurityException("stored output's length does not match input's length");
    }

    @Override // com.google.crypto.tink.subtle.IndCpaCipher
    public byte[] a(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i8 = this.f15308b;
        if (length <= Api.BaseClientBuilder.API_PRIORITY_OTHER - i8) {
            byte[] bArr2 = new byte[bArr.length + i8];
            byte[] c8 = Random.c(i8);
            System.arraycopy(c8, 0, bArr2, 0, this.f15308b);
            c(bArr, 0, bArr.length, bArr2, this.f15308b, c8, true);
            return bArr2;
        }
        throw new GeneralSecurityException("plaintext length can not exceed " + (Api.BaseClientBuilder.API_PRIORITY_OTHER - this.f15308b));
    }

    @Override // com.google.crypto.tink.subtle.IndCpaCipher
    public byte[] b(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i8 = this.f15308b;
        if (length >= i8) {
            byte[] bArr2 = new byte[i8];
            System.arraycopy(bArr, 0, bArr2, 0, i8);
            int length2 = bArr.length;
            int i9 = this.f15308b;
            byte[] bArr3 = new byte[length2 - i9];
            c(bArr, i9, bArr.length - i9, bArr3, 0, bArr2, false);
            return bArr3;
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
