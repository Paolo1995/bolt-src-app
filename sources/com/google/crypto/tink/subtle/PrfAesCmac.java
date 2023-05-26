package com.google.crypto.tink.subtle;

import com.google.crypto.tink.prf.Prf;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class PrfAesCmac implements Prf {

    /* renamed from: a  reason: collision with root package name */
    private final SecretKey f15360a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f15361b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f15362c;

    public PrfAesCmac(byte[] bArr) throws GeneralSecurityException {
        Validators.a(bArr.length);
        this.f15360a = new SecretKeySpec(bArr, "AES");
        b();
    }

    private void b() throws GeneralSecurityException {
        Cipher c8 = c();
        c8.init(1, this.f15360a);
        byte[] b8 = AesUtil.b(c8.doFinal(new byte[16]));
        this.f15361b = b8;
        this.f15362c = AesUtil.b(b8);
    }

    private static Cipher c() throws GeneralSecurityException {
        return EngineFactory.f15350f.a("AES/ECB/NoPadding");
    }

    @Override // com.google.crypto.tink.prf.Prf
    public byte[] a(byte[] bArr, int i8) throws GeneralSecurityException {
        boolean z7;
        byte[] e8;
        if (i8 <= 16) {
            Cipher c8 = c();
            c8.init(1, this.f15360a);
            int max = Math.max(1, (int) Math.ceil(bArr.length / 16.0d));
            if (max * 16 == bArr.length) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                e8 = Bytes.d(bArr, (max - 1) * 16, this.f15361b, 0, 16);
            } else {
                e8 = Bytes.e(AesUtil.a(Arrays.copyOfRange(bArr, (max - 1) * 16, bArr.length)), this.f15362c);
            }
            byte[] bArr2 = new byte[16];
            for (int i9 = 0; i9 < max - 1; i9++) {
                bArr2 = c8.doFinal(Bytes.d(bArr2, 0, bArr, i9 * 16, 16));
            }
            return Arrays.copyOf(c8.doFinal(Bytes.e(e8, bArr2)), i8);
        }
        throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
    }
}
