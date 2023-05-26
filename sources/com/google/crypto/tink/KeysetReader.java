package com.google.crypto.tink;

import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.Keyset;
import java.io.IOException;

/* loaded from: classes.dex */
public interface KeysetReader {
    EncryptedKeyset a() throws IOException;

    Keyset read() throws IOException;
}
