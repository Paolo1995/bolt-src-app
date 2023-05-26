package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.proto.OutputPrefixType;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class Util {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f14833a = Charset.forName("UTF-8");

    Util() {
    }

    public static KeysetInfo.KeyInfo a(Keyset.Key key) {
        return KeysetInfo.KeyInfo.L().t(key.K().L()).s(key.N()).r(key.M()).q(key.L()).build();
    }

    public static KeysetInfo b(Keyset keyset) {
        KeysetInfo.Builder r7 = KeysetInfo.L().r(keyset.N());
        for (Keyset.Key key : keyset.M()) {
            r7.q(a(key));
        }
        return r7.build();
    }

    public static void c(Keyset.Key key) throws GeneralSecurityException {
        if (key.O()) {
            if (key.M() != OutputPrefixType.UNKNOWN_PREFIX) {
                if (key.N() != KeyStatusType.UNKNOWN_STATUS) {
                    return;
                }
                throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(key.L())));
            }
            throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(key.L())));
        }
        throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(key.L())));
    }

    public static void d(Keyset keyset) throws GeneralSecurityException {
        int N = keyset.N();
        int i8 = 0;
        boolean z7 = false;
        boolean z8 = true;
        for (Keyset.Key key : keyset.M()) {
            if (key.N() == KeyStatusType.ENABLED) {
                c(key);
                if (key.L() == N) {
                    if (!z7) {
                        z7 = true;
                    } else {
                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                    }
                }
                if (key.K().K() != KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC) {
                    z8 = false;
                }
                i8++;
            }
        }
        if (i8 != 0) {
            if (!z7 && !z8) {
                throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
            }
            return;
        }
        throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
    }
}
