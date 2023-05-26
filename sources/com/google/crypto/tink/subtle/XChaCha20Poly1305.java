package com.google.crypto.tink.subtle;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* loaded from: classes.dex */
public final class XChaCha20Poly1305 extends ChaCha20Poly1305Base {
    public XChaCha20Poly1305(byte[] bArr) throws InvalidKeyException {
        super(bArr);
    }

    @Override // com.google.crypto.tink.subtle.ChaCha20Poly1305Base, com.google.crypto.tink.Aead
    public /* bridge */ /* synthetic */ byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return super.a(bArr, bArr2);
    }

    @Override // com.google.crypto.tink.subtle.ChaCha20Poly1305Base, com.google.crypto.tink.Aead
    public /* bridge */ /* synthetic */ byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return super.b(bArr, bArr2);
    }

    @Override // com.google.crypto.tink.subtle.ChaCha20Poly1305Base
    ChaCha20Base g(byte[] bArr, int i8) throws InvalidKeyException {
        return new XChaCha20(bArr, i8);
    }
}
