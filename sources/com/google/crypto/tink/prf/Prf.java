package com.google.crypto.tink.prf;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public interface Prf {
    byte[] a(byte[] bArr, int i8) throws GeneralSecurityException;
}
