package com.google.crypto.tink;

import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class KeysetHandle {

    /* renamed from: a  reason: collision with root package name */
    private final Keyset f14813a;

    private KeysetHandle(Keyset keyset) {
        this.f14813a = keyset;
    }

    public static void a(EncryptedKeyset encryptedKeyset) throws GeneralSecurityException {
        if (encryptedKeyset != null && encryptedKeyset.H().size() != 0) {
            return;
        }
        throw new GeneralSecurityException("empty keyset");
    }

    public static void b(Keyset keyset) throws GeneralSecurityException {
        if (keyset != null && keyset.L() > 0) {
            return;
        }
        throw new GeneralSecurityException("empty keyset");
    }

    private static Keyset c(EncryptedKeyset encryptedKeyset, Aead aead) throws GeneralSecurityException {
        try {
            Keyset P = Keyset.P(aead.b(encryptedKeyset.H().y(), new byte[0]), ExtensionRegistryLite.b());
            b(P);
            return P;
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    private static EncryptedKeyset d(Keyset keyset, Aead aead) throws GeneralSecurityException {
        byte[] a8 = aead.a(keyset.a(), new byte[0]);
        try {
            if (Keyset.P(aead.b(a8, new byte[0]), ExtensionRegistryLite.b()).equals(keyset)) {
                return EncryptedKeyset.J().q(ByteString.i(a8)).r(Util.b(keyset)).build();
            }
            throw new GeneralSecurityException("cannot encrypt keyset");
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final KeysetHandle e(Keyset keyset) throws GeneralSecurityException {
        b(keyset);
        return new KeysetHandle(keyset);
    }

    private <B, P> P i(Class<P> cls, Class<B> cls2) throws GeneralSecurityException {
        return (P) Registry.t(Registry.l(this, cls2), cls);
    }

    public static final KeysetHandle j(KeysetReader keysetReader, Aead aead) throws GeneralSecurityException, IOException {
        EncryptedKeyset a8 = keysetReader.a();
        a(a8);
        return new KeysetHandle(c(a8, aead));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Keyset f() {
        return this.f14813a;
    }

    public KeysetInfo g() {
        return Util.b(this.f14813a);
    }

    public <P> P h(Class<P> cls) throws GeneralSecurityException {
        Class<?> e8 = Registry.e(cls);
        if (e8 != null) {
            return (P) i(cls, e8);
        }
        throw new GeneralSecurityException("No wrapper found for " + cls.getName());
    }

    public void k(KeysetWriter keysetWriter, Aead aead) throws GeneralSecurityException, IOException {
        keysetWriter.b(d(this.f14813a, aead));
    }

    public String toString() {
        return g().toString();
    }
}
