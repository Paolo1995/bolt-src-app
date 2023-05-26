package com.google.crypto.tink;

import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.Keyset;
import java.io.IOException;

/* loaded from: classes.dex */
public interface KeysetWriter {
    void a(Keyset keyset) throws IOException;

    void b(EncryptedKeyset encryptedKeyset) throws IOException;
}
