package com.google.crypto.tink;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class CleartextKeysetHandle {
    public static KeysetHandle a(KeysetReader keysetReader) throws GeneralSecurityException, IOException {
        return KeysetHandle.e(keysetReader.read());
    }

    public static void b(KeysetHandle keysetHandle, KeysetWriter keysetWriter) throws IOException {
        keysetWriter.a(keysetHandle.f());
    }
}
