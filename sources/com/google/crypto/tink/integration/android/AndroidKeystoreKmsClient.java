package com.google.crypto.tink.integration.android;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Log;
import com.google.android.gms.stats.CodePackage;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KmsClient;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import j$.util.Spliterator;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.Arrays;
import javax.annotation.concurrent.GuardedBy;
import javax.crypto.KeyGenerator;

/* loaded from: classes.dex */
public final class AndroidKeystoreKmsClient implements KmsClient {

    /* renamed from: c  reason: collision with root package name */
    private static final String f14881c = "AndroidKeystoreKmsClient";

    /* renamed from: a  reason: collision with root package name */
    private final String f14882a;
    @GuardedBy("this")

    /* renamed from: b  reason: collision with root package name */
    private KeyStore f14883b;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        String f14884a = null;

        /* renamed from: b  reason: collision with root package name */
        KeyStore f14885b;

        public Builder() {
            this.f14885b = null;
            if (AndroidKeystoreKmsClient.c()) {
                try {
                    KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                    this.f14885b = keyStore;
                    keyStore.load(null);
                    return;
                } catch (IOException | GeneralSecurityException e8) {
                    throw new IllegalStateException(e8);
                }
            }
            throw new IllegalStateException("need Android Keystore on Android M or newer");
        }

        public AndroidKeystoreKmsClient a() {
            return new AndroidKeystoreKmsClient(this);
        }

        public Builder b(KeyStore keyStore) {
            if (keyStore != null) {
                this.f14885b = keyStore;
                return this;
            }
            throw new IllegalArgumentException("val cannot be null");
        }
    }

    static /* synthetic */ boolean c() {
        return f();
    }

    public static void d(String str) throws GeneralSecurityException {
        if (!new AndroidKeystoreKmsClient().e(str)) {
            String b8 = Validators.b("android-keystore://", str);
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            keyGenerator.init(new KeyGenParameterSpec.Builder(b8, 3).setKeySize(Spliterator.NONNULL).setBlockModes(CodePackage.GCM).setEncryptionPaddings("NoPadding").build());
            keyGenerator.generateKey();
            return;
        }
        throw new IllegalArgumentException(String.format("cannot generate a new key %s because it already exists; please delete it with deleteKey() and try again", str));
    }

    private static boolean f() {
        if (Build.VERSION.SDK_INT >= 23) {
            return true;
        }
        return false;
    }

    private static Aead g(Aead aead) throws GeneralSecurityException {
        byte[] c8 = Random.c(10);
        byte[] bArr = new byte[0];
        if (Arrays.equals(c8, aead.b(aead.a(c8, bArr), bArr))) {
            return aead;
        }
        throw new KeyStoreException("cannot use Android Keystore: encryption/decryption of non-empty message and empty aad returns an incorrect result");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001e, code lost:
        if (r3.toLowerCase(java.util.Locale.US).startsWith("android-keystore://") != false) goto L14;
     */
    @Override // com.google.crypto.tink.KmsClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean a(java.lang.String r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = r2.f14882a     // Catch: java.lang.Throwable -> L24
            r1 = 1
            if (r0 == 0) goto Le
            boolean r0 = r0.equals(r3)     // Catch: java.lang.Throwable -> L24
            if (r0 == 0) goto Le
            monitor-exit(r2)
            return r1
        Le:
            java.lang.String r0 = r2.f14882a     // Catch: java.lang.Throwable -> L24
            if (r0 != 0) goto L21
            java.util.Locale r0 = java.util.Locale.US     // Catch: java.lang.Throwable -> L24
            java.lang.String r3 = r3.toLowerCase(r0)     // Catch: java.lang.Throwable -> L24
            java.lang.String r0 = "android-keystore://"
            boolean r3 = r3.startsWith(r0)     // Catch: java.lang.Throwable -> L24
            if (r3 == 0) goto L21
            goto L22
        L21:
            r1 = 0
        L22:
            monitor-exit(r2)
            return r1
        L24:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.integration.android.AndroidKeystoreKmsClient.a(java.lang.String):boolean");
    }

    @Override // com.google.crypto.tink.KmsClient
    public synchronized Aead b(String str) throws GeneralSecurityException {
        String str2 = this.f14882a;
        if (str2 != null && !str2.equals(str)) {
            throw new GeneralSecurityException(String.format("this client is bound to %s, cannot load keys bound to %s", this.f14882a, str));
        }
        return g(new AndroidKeystoreAesGcm(Validators.b("android-keystore://", str), this.f14883b));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean e(String str) throws GeneralSecurityException {
        String str2;
        try {
        } catch (NullPointerException unused) {
            Log.w(f14881c, "Keystore is temporarily unavailable, wait 20ms, reinitialize Keystore and try again.");
            try {
                Thread.sleep(20L);
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                this.f14883b = keyStore;
                keyStore.load(null);
            } catch (IOException e8) {
                throw new GeneralSecurityException(e8);
            } catch (InterruptedException unused2) {
            }
            return this.f14883b.containsAlias(str2);
        }
        return this.f14883b.containsAlias(Validators.b("android-keystore://", str));
    }

    public AndroidKeystoreKmsClient() throws GeneralSecurityException {
        this(new Builder());
    }

    private AndroidKeystoreKmsClient(Builder builder) {
        this.f14882a = builder.f14884a;
        this.f14883b = builder.f14885b;
    }
}
