package com.google.crypto.tink.daead;

import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class DeterministicAeadConfig {

    /* renamed from: a  reason: collision with root package name */
    public static final String f14862a = new AesSivKeyManager().c();
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public static final RegistryConfig f14863b = RegistryConfig.F();
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static final RegistryConfig f14864c = RegistryConfig.F();

    static {
        try {
            a();
        } catch (GeneralSecurityException e8) {
            throw new ExceptionInInitializerError(e8);
        }
    }

    private DeterministicAeadConfig() {
    }

    @Deprecated
    public static void a() throws GeneralSecurityException {
        b();
    }

    public static void b() throws GeneralSecurityException {
        AesSivKeyManager.n(true);
        DeterministicAeadWrapper.e();
    }
}
