package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public interface KeyManager<P> {
    boolean a(String str);

    KeyData b(ByteString byteString) throws GeneralSecurityException;

    P c(ByteString byteString) throws GeneralSecurityException;

    MessageLite d(ByteString byteString) throws GeneralSecurityException;
}
