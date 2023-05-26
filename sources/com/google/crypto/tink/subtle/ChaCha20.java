package com.google.crypto.tink.subtle;

import java.security.InvalidKeyException;

/* loaded from: classes.dex */
class ChaCha20 extends ChaCha20Base {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ChaCha20(byte[] bArr, int i8) throws InvalidKeyException {
        super(bArr, i8);
    }

    @Override // com.google.crypto.tink.subtle.ChaCha20Base
    int[] d(int[] iArr, int i8) {
        if (iArr.length == g() / 4) {
            int[] iArr2 = new int[16];
            ChaCha20Base.k(iArr2, this.f15341a);
            iArr2[12] = i8;
            System.arraycopy(iArr, 0, iArr2, 13, iArr.length);
            return iArr2;
        }
        throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", Integer.valueOf(iArr.length * 32)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.crypto.tink.subtle.ChaCha20Base
    public int g() {
        return 12;
    }
}
