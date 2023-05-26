package com.google.crypto.tink.mac;

import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class MacConfig {

    /* renamed from: a  reason: collision with root package name */
    public static final String f14893a = new HmacKeyManager().c();
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public static final RegistryConfig f14894b;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static final RegistryConfig f14895c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public static final RegistryConfig f14896d;

    static {
        RegistryConfig F = RegistryConfig.F();
        f14894b = F;
        f14895c = F;
        f14896d = F;
        try {
            a();
        } catch (GeneralSecurityException e8) {
            throw new ExceptionInInitializerError(e8);
        }
    }

    private MacConfig() {
    }

    @Deprecated
    public static void a() throws GeneralSecurityException {
        b();
    }

    public static void b() throws GeneralSecurityException {
        HmacKeyManager.m(true);
        AesCmacKeyManager.n(true);
        MacWrapper.e();
    }
}
