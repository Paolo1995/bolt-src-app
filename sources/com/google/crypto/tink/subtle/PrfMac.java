package com.google.crypto.tink.subtle;

import com.google.crypto.tink.Mac;
import com.google.crypto.tink.prf.Prf;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* loaded from: classes.dex */
public class PrfMac implements Mac {

    /* renamed from: a  reason: collision with root package name */
    private final Prf f15368a;

    /* renamed from: b  reason: collision with root package name */
    private final int f15369b;

    public PrfMac(Prf prf, int i8) throws GeneralSecurityException {
        this.f15368a = prf;
        this.f15369b = i8;
        if (i8 >= 10) {
            prf.a(new byte[0], i8);
            return;
        }
        throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
    }

    @Override // com.google.crypto.tink.Mac
    public void a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (Bytes.b(b(bArr2), bArr)) {
            return;
        }
        throw new GeneralSecurityException("invalid MAC");
    }

    @Override // com.google.crypto.tink.Mac
    public byte[] b(byte[] bArr) throws GeneralSecurityException {
        return this.f15368a.a(bArr, this.f15369b);
    }
}
