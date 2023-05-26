package com.google.crypto.tink.aead;

import com.google.crypto.tink.mac.MacConfig;
import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class AeadConfig {

    /* renamed from: a  reason: collision with root package name */
    public static final String f14834a = new AesCtrHmacAeadKeyManager().c();

    /* renamed from: b  reason: collision with root package name */
    public static final String f14835b = new AesGcmKeyManager().c();

    /* renamed from: c  reason: collision with root package name */
    public static final String f14836c = new AesGcmSivKeyManager().c();

    /* renamed from: d  reason: collision with root package name */
    public static final String f14837d = new AesEaxKeyManager().c();

    /* renamed from: e  reason: collision with root package name */
    public static final String f14838e = new KmsAeadKeyManager().c();

    /* renamed from: f  reason: collision with root package name */
    public static final String f14839f = new KmsEnvelopeAeadKeyManager().c();

    /* renamed from: g  reason: collision with root package name */
    public static final String f14840g = new ChaCha20Poly1305KeyManager().c();

    /* renamed from: h  reason: collision with root package name */
    public static final String f14841h = new XChaCha20Poly1305KeyManager().c();
    @Deprecated

    /* renamed from: i  reason: collision with root package name */
    public static final RegistryConfig f14842i;
    @Deprecated

    /* renamed from: j  reason: collision with root package name */
    public static final RegistryConfig f14843j;
    @Deprecated

    /* renamed from: k  reason: collision with root package name */
    public static final RegistryConfig f14844k;

    static {
        RegistryConfig F = RegistryConfig.F();
        f14842i = F;
        f14843j = F;
        f14844k = F;
        try {
            a();
        } catch (GeneralSecurityException e8) {
            throw new ExceptionInInitializerError(e8);
        }
    }

    private AeadConfig() {
    }

    @Deprecated
    public static void a() throws GeneralSecurityException {
        b();
    }

    public static void b() throws GeneralSecurityException {
        MacConfig.b();
        AesCtrHmacAeadKeyManager.l(true);
        AesEaxKeyManager.l(true);
        AesGcmKeyManager.n(true);
        AesGcmSivKeyManager.m(true);
        ChaCha20Poly1305KeyManager.l(true);
        KmsAeadKeyManager.l(true);
        KmsEnvelopeAeadKeyManager.l(true);
        XChaCha20Poly1305KeyManager.l(true);
        AeadWrapper.e();
    }
}
