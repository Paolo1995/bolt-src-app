package com.google.crypto.tink.subtle;

import com.google.crypto.tink.prf.Prf;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;

/* loaded from: classes.dex */
public final class PrfHmacJce implements Prf {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadLocal<Mac> f15363a;

    /* renamed from: b  reason: collision with root package name */
    private final String f15364b;

    /* renamed from: c  reason: collision with root package name */
    private final Key f15365c;

    /* renamed from: d  reason: collision with root package name */
    private final int f15366d;

    public PrfHmacJce(String str, Key key) throws GeneralSecurityException {
        ThreadLocal<Mac> threadLocal = new ThreadLocal<Mac>() { // from class: com.google.crypto.tink.subtle.PrfHmacJce.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            /* renamed from: a */
            public Mac initialValue() {
                try {
                    Mac a8 = EngineFactory.f15351g.a(PrfHmacJce.this.f15364b);
                    a8.init(PrfHmacJce.this.f15365c);
                    return a8;
                } catch (GeneralSecurityException e8) {
                    throw new IllegalStateException(e8);
                }
            }
        };
        this.f15363a = threadLocal;
        this.f15364b = str;
        this.f15365c = key;
        if (key.getEncoded().length >= 16) {
            str.hashCode();
            char c8 = 65535;
            switch (str.hashCode()) {
                case -1823053428:
                    if (str.equals("HMACSHA1")) {
                        c8 = 0;
                        break;
                    }
                    break;
                case 392315118:
                    if (str.equals("HMACSHA256")) {
                        c8 = 1;
                        break;
                    }
                    break;
                case 392316170:
                    if (str.equals("HMACSHA384")) {
                        c8 = 2;
                        break;
                    }
                    break;
                case 392317873:
                    if (str.equals("HMACSHA512")) {
                        c8 = 3;
                        break;
                    }
                    break;
            }
            switch (c8) {
                case 0:
                    this.f15366d = 20;
                    break;
                case 1:
                    this.f15366d = 32;
                    break;
                case 2:
                    this.f15366d = 48;
                    break;
                case 3:
                    this.f15366d = 64;
                    break;
                default:
                    throw new NoSuchAlgorithmException("unknown Hmac algorithm: " + str);
            }
            threadLocal.get();
            return;
        }
        throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
    }

    @Override // com.google.crypto.tink.prf.Prf
    public byte[] a(byte[] bArr, int i8) throws GeneralSecurityException {
        if (i8 <= this.f15366d) {
            this.f15363a.get().update(bArr);
            return Arrays.copyOf(this.f15363a.get().doFinal(), i8);
        }
        throw new InvalidAlgorithmParameterException("tag size too big");
    }
}
