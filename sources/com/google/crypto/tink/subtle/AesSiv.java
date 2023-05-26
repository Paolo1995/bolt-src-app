package com.google.crypto.tink.subtle;

import com.google.crypto.tink.DeterministicAead;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.Collection;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class AesSiv implements DeterministicAead {

    /* renamed from: c  reason: collision with root package name */
    private static final Collection<Integer> f15318c = Arrays.asList(64);

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f15319d = new byte[16];

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f15320e = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};

    /* renamed from: a  reason: collision with root package name */
    private final PrfAesCmac f15321a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f15322b;

    public AesSiv(byte[] bArr) throws GeneralSecurityException {
        if (f15318c.contains(Integer.valueOf(bArr.length))) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length / 2);
            this.f15322b = Arrays.copyOfRange(bArr, bArr.length / 2, bArr.length);
            this.f15321a = new PrfAesCmac(copyOfRange);
            return;
        }
        throw new InvalidKeyException("invalid key size: " + bArr.length + " bytes; key must have 64 bytes");
    }

    private byte[] c(byte[]... bArr) throws GeneralSecurityException {
        byte[] e8;
        if (bArr.length == 0) {
            return this.f15321a.a(f15320e, 16);
        }
        byte[] a8 = this.f15321a.a(f15319d, 16);
        for (int i8 = 0; i8 < bArr.length - 1; i8++) {
            byte[] bArr2 = bArr[i8];
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            a8 = Bytes.e(AesUtil.b(a8), this.f15321a.a(bArr2, 16));
        }
        byte[] bArr3 = bArr[bArr.length - 1];
        if (bArr3.length >= 16) {
            e8 = Bytes.f(bArr3, a8);
        } else {
            e8 = Bytes.e(AesUtil.a(bArr3), AesUtil.b(a8));
        }
        return this.f15321a.a(e8, 16);
    }

    @Override // com.google.crypto.tink.DeterministicAead
    public byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length <= 2147483631) {
            Cipher a8 = EngineFactory.f15350f.a("AES/CTR/NoPadding");
            byte[] c8 = c(bArr2, bArr);
            byte[] bArr3 = (byte[]) c8.clone();
            bArr3[8] = (byte) (bArr3[8] & Byte.MAX_VALUE);
            bArr3[12] = (byte) (bArr3[12] & Byte.MAX_VALUE);
            a8.init(1, new SecretKeySpec(this.f15322b, "AES"), new IvParameterSpec(bArr3));
            return Bytes.a(c8, a8.doFinal(bArr));
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    @Override // com.google.crypto.tink.DeterministicAead
    public byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length >= 16) {
            Cipher a8 = EngineFactory.f15350f.a("AES/CTR/NoPadding");
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 16);
            byte[] bArr3 = (byte[]) copyOfRange.clone();
            bArr3[8] = (byte) (bArr3[8] & Byte.MAX_VALUE);
            bArr3[12] = (byte) (bArr3[12] & Byte.MAX_VALUE);
            a8.init(2, new SecretKeySpec(this.f15322b, "AES"), new IvParameterSpec(bArr3));
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 16, bArr.length);
            byte[] doFinal = a8.doFinal(copyOfRange2);
            if (copyOfRange2.length == 0 && doFinal == null && SubtleUtil.b()) {
                doFinal = new byte[0];
            }
            if (Bytes.b(copyOfRange, c(bArr2, doFinal))) {
                return doFinal;
            }
            throw new AEADBadTagException("Integrity check failed.");
        }
        throw new GeneralSecurityException("Ciphertext too short.");
    }
}
