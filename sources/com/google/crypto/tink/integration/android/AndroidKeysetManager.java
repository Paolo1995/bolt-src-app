package com.google.crypto.tink.integration.android;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.CleartextKeysetHandle;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.KeysetManager;
import com.google.crypto.tink.KeysetReader;
import com.google.crypto.tink.KeysetWriter;
import com.google.crypto.tink.integration.android.AndroidKeystoreKmsClient;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.ProviderException;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class AndroidKeysetManager {

    /* renamed from: d  reason: collision with root package name */
    private static final String f14867d = "AndroidKeysetManager";

    /* renamed from: a  reason: collision with root package name */
    private final KeysetWriter f14868a;

    /* renamed from: b  reason: collision with root package name */
    private final Aead f14869b;
    @GuardedBy("this")

    /* renamed from: c  reason: collision with root package name */
    private KeysetManager f14870c;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private KeysetReader f14871a = null;

        /* renamed from: b  reason: collision with root package name */
        private KeysetWriter f14872b = null;

        /* renamed from: c  reason: collision with root package name */
        private String f14873c = null;

        /* renamed from: d  reason: collision with root package name */
        private Aead f14874d = null;

        /* renamed from: e  reason: collision with root package name */
        private boolean f14875e = true;

        /* renamed from: f  reason: collision with root package name */
        private KeyTemplate f14876f = null;

        /* renamed from: g  reason: collision with root package name */
        private KeyStore f14877g = null;
        @GuardedBy("this")

        /* renamed from: h  reason: collision with root package name */
        private KeysetManager f14878h;

        private KeysetManager e() throws GeneralSecurityException, IOException {
            Aead aead = this.f14874d;
            if (aead != null) {
                try {
                    return KeysetManager.j(KeysetHandle.j(this.f14871a, aead));
                } catch (InvalidProtocolBufferException | GeneralSecurityException e8) {
                    Log.w(AndroidKeysetManager.f14867d, "cannot decrypt keyset: ", e8);
                }
            }
            return KeysetManager.j(CleartextKeysetHandle.a(this.f14871a));
        }

        private KeysetManager f() throws GeneralSecurityException, IOException {
            try {
                return e();
            } catch (FileNotFoundException e8) {
                Log.w(AndroidKeysetManager.f14867d, "keyset not found, will generate a new one", e8);
                if (this.f14876f != null) {
                    KeysetManager a8 = KeysetManager.i().a(this.f14876f);
                    KeysetManager h8 = a8.h(a8.c().g().K(0).K());
                    if (this.f14874d != null) {
                        h8.c().k(this.f14872b, this.f14874d);
                    } else {
                        CleartextKeysetHandle.b(h8.c(), this.f14872b);
                    }
                    return h8;
                }
                throw new GeneralSecurityException("cannot read or generate keyset");
            }
        }

        private Aead g() throws GeneralSecurityException {
            AndroidKeystoreKmsClient androidKeystoreKmsClient;
            if (!AndroidKeysetManager.a()) {
                Log.w(AndroidKeysetManager.f14867d, "Android Keystore requires at least Android M");
                return null;
            }
            if (this.f14877g != null) {
                androidKeystoreKmsClient = new AndroidKeystoreKmsClient.Builder().b(this.f14877g).a();
            } else {
                androidKeystoreKmsClient = new AndroidKeystoreKmsClient();
            }
            boolean e8 = androidKeystoreKmsClient.e(this.f14873c);
            if (!e8) {
                try {
                    AndroidKeystoreKmsClient.d(this.f14873c);
                } catch (GeneralSecurityException | ProviderException e9) {
                    Log.w(AndroidKeysetManager.f14867d, "cannot use Android Keystore, it'll be disabled", e9);
                    return null;
                }
            }
            try {
                return androidKeystoreKmsClient.b(this.f14873c);
            } catch (GeneralSecurityException | ProviderException e10) {
                if (!e8) {
                    Log.w(AndroidKeysetManager.f14867d, "cannot use Android Keystore, it'll be disabled", e10);
                    return null;
                }
                throw new KeyStoreException(String.format("the master key %s exists but is unusable", this.f14873c), e10);
            }
        }

        public synchronized AndroidKeysetManager d() throws GeneralSecurityException, IOException {
            if (this.f14873c != null) {
                this.f14874d = g();
            }
            this.f14878h = f();
            return new AndroidKeysetManager(this);
        }

        public Builder h(KeyTemplate keyTemplate) {
            this.f14876f = keyTemplate;
            return this;
        }

        public Builder i(String str) {
            if (str.startsWith("android-keystore://")) {
                if (this.f14875e) {
                    this.f14873c = str;
                    return this;
                }
                throw new IllegalArgumentException("cannot call withMasterKeyUri() after calling doNotUseKeystore()");
            }
            throw new IllegalArgumentException("key URI must start with android-keystore://");
        }

        public Builder j(Context context, String str, String str2) throws IOException {
            if (context != null) {
                if (str != null) {
                    this.f14871a = new SharedPrefKeysetReader(context, str, str2);
                    this.f14872b = new SharedPrefKeysetWriter(context, str, str2);
                    return this;
                }
                throw new IllegalArgumentException("need a keyset name");
            }
            throw new IllegalArgumentException("need an Android context");
        }
    }

    static /* synthetic */ boolean a() {
        return d();
    }

    private static boolean d() {
        if (Build.VERSION.SDK_INT >= 23) {
            return true;
        }
        return false;
    }

    public synchronized KeysetHandle c() throws GeneralSecurityException {
        return this.f14870c.c();
    }

    private AndroidKeysetManager(Builder builder) throws GeneralSecurityException, IOException {
        this.f14868a = builder.f14872b;
        this.f14869b = builder.f14874d;
        this.f14870c = builder.f14878h;
    }
}
