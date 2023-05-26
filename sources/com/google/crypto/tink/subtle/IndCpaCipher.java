package com.google.crypto.tink.subtle;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public interface IndCpaCipher {
    byte[] a(byte[] bArr) throws GeneralSecurityException;

    byte[] b(byte[] bArr) throws GeneralSecurityException;
}
