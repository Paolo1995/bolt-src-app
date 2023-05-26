package com.google.crypto.tink.subtle;

import com.google.android.gms.security.ProviderInstaller;
import com.google.crypto.tink.subtle.EngineWrapper;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* loaded from: classes.dex */
public final class EngineFactory<T_WRAPPER extends EngineWrapper<T_ENGINE>, T_ENGINE> {

    /* renamed from: d  reason: collision with root package name */
    private static final Logger f15348d = Logger.getLogger(EngineFactory.class.getName());

    /* renamed from: e  reason: collision with root package name */
    private static final List<Provider> f15349e;

    /* renamed from: f  reason: collision with root package name */
    public static final EngineFactory<EngineWrapper.TCipher, Cipher> f15350f;

    /* renamed from: g  reason: collision with root package name */
    public static final EngineFactory<EngineWrapper.TMac, Mac> f15351g;

    /* renamed from: h  reason: collision with root package name */
    public static final EngineFactory<EngineWrapper.TSignature, Signature> f15352h;

    /* renamed from: i  reason: collision with root package name */
    public static final EngineFactory<EngineWrapper.TMessageDigest, MessageDigest> f15353i;

    /* renamed from: j  reason: collision with root package name */
    public static final EngineFactory<EngineWrapper.TKeyAgreement, KeyAgreement> f15354j;

    /* renamed from: k  reason: collision with root package name */
    public static final EngineFactory<EngineWrapper.TKeyPairGenerator, KeyPairGenerator> f15355k;

    /* renamed from: l  reason: collision with root package name */
    public static final EngineFactory<EngineWrapper.TKeyFactory, KeyFactory> f15356l;

    /* renamed from: a  reason: collision with root package name */
    private T_WRAPPER f15357a;

    /* renamed from: b  reason: collision with root package name */
    private List<Provider> f15358b = f15349e;

    /* renamed from: c  reason: collision with root package name */
    private boolean f15359c = true;

    static {
        if (SubtleUtil.b()) {
            f15349e = b(ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL");
        } else {
            f15349e = new ArrayList();
        }
        f15350f = new EngineFactory<>(new EngineWrapper.TCipher());
        f15351g = new EngineFactory<>(new EngineWrapper.TMac());
        f15352h = new EngineFactory<>(new EngineWrapper.TSignature());
        f15353i = new EngineFactory<>(new EngineWrapper.TMessageDigest());
        f15354j = new EngineFactory<>(new EngineWrapper.TKeyAgreement());
        f15355k = new EngineFactory<>(new EngineWrapper.TKeyPairGenerator());
        f15356l = new EngineFactory<>(new EngineWrapper.TKeyFactory());
    }

    public EngineFactory(T_WRAPPER t_wrapper) {
        this.f15357a = t_wrapper;
    }

    public static List<Provider> b(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Provider provider = Security.getProvider(str);
            if (provider != null) {
                arrayList.add(provider);
            } else {
                f15348d.info(String.format("Provider %s not available", str));
            }
        }
        return arrayList;
    }

    public T_ENGINE a(String str) throws GeneralSecurityException {
        Exception exc = null;
        for (Provider provider : this.f15358b) {
            try {
                return (T_ENGINE) this.f15357a.a(str, provider);
            } catch (Exception e8) {
                if (exc == null) {
                    exc = e8;
                }
            }
        }
        if (this.f15359c) {
            return (T_ENGINE) this.f15357a.a(str, null);
        }
        throw new GeneralSecurityException("No good Provider found.", exc);
    }
}
