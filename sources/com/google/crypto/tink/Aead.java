package com.google.crypto.tink;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public interface Aead {
    byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException;

    byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException;
}
