package com.google.crypto.tink;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public interface KmsClient {
    boolean a(String str);

    Aead b(String str) throws GeneralSecurityException;
}
