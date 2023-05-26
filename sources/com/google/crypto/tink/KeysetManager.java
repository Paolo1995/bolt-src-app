package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.OutputPrefixType;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class KeysetManager {
    @GuardedBy("this")

    /* renamed from: a  reason: collision with root package name */
    private final Keyset.Builder f14814a;

    private KeysetManager(Keyset.Builder builder) {
        this.f14814a = builder;
    }

    private synchronized boolean d(int i8) {
        for (Keyset.Key key : this.f14814a.t()) {
            if (key.L() == i8) {
                return true;
            }
        }
        return false;
    }

    private synchronized Keyset.Key e(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        KeyData p8;
        int f8;
        OutputPrefixType K;
        p8 = Registry.p(keyTemplate);
        f8 = f();
        K = keyTemplate.K();
        if (K == OutputPrefixType.UNKNOWN_PREFIX) {
            K = OutputPrefixType.TINK;
        }
        return Keyset.Key.P().q(p8).r(f8).t(KeyStatusType.ENABLED).s(K).build();
    }

    private synchronized int f() {
        int g8;
        g8 = g();
        while (d(g8)) {
            g8 = g();
        }
        return g8;
    }

    private static int g() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[4];
        int i8 = 0;
        while (i8 == 0) {
            secureRandom.nextBytes(bArr);
            i8 = ((bArr[0] & Byte.MAX_VALUE) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        }
        return i8;
    }

    public static KeysetManager i() {
        return new KeysetManager(Keyset.O());
    }

    public static KeysetManager j(KeysetHandle keysetHandle) {
        return new KeysetManager(keysetHandle.f().toBuilder());
    }

    public synchronized KeysetManager a(KeyTemplate keyTemplate) throws GeneralSecurityException {
        b(keyTemplate.b(), false);
        return this;
    }

    @Deprecated
    public synchronized int b(com.google.crypto.tink.proto.KeyTemplate keyTemplate, boolean z7) throws GeneralSecurityException {
        Keyset.Key e8;
        e8 = e(keyTemplate);
        this.f14814a.q(e8);
        if (z7) {
            this.f14814a.u(e8.L());
        }
        return e8.L();
    }

    public synchronized KeysetHandle c() throws GeneralSecurityException {
        return KeysetHandle.e(this.f14814a.build());
    }

    public synchronized KeysetManager h(int i8) throws GeneralSecurityException {
        for (int i9 = 0; i9 < this.f14814a.s(); i9++) {
            Keyset.Key r7 = this.f14814a.r(i9);
            if (r7.L() == i8) {
                if (r7.N().equals(KeyStatusType.ENABLED)) {
                    this.f14814a.u(i8);
                } else {
                    throw new GeneralSecurityException("cannot set key as primary because it's not enabled: " + i8);
                }
            }
        }
        throw new GeneralSecurityException("key not found: " + i8);
        return this;
    }
}
