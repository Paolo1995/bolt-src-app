package eu.bolt.driver.core.storage.crypto;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import eu.bolt.driver.core.storage.KVStorage;
import eu.bolt.driver.core.storage.OnStorageChangeListener;
import eu.bolt.driver.core.storage.crypto.EncryptedSharedPreferencesApi1;
import eu.bolt.driver.core.util.CipherWrapper;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EncryptedSharedPreferencesApi1.kt */
/* loaded from: classes5.dex */
public final class EncryptedSharedPreferencesApi1 implements KVStorage {

    /* renamed from: a  reason: collision with root package name */
    private final CipherWrapper f40947a;

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f40948b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<OnStorageChangeListener> f40949c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedPreferences.OnSharedPreferenceChangeListener f40950d;

    public EncryptedSharedPreferencesApi1(Context context, String filename, CipherWrapper cipher) {
        Intrinsics.f(context, "context");
        Intrinsics.f(filename, "filename");
        Intrinsics.f(cipher, "cipher");
        this.f40947a = cipher;
        SharedPreferences sharedPreferences = context.getSharedPreferences(filename, 0);
        Intrinsics.e(sharedPreferences, "context.getSharedPrefere…me, Context.MODE_PRIVATE)");
        this.f40948b = sharedPreferences;
        this.f40949c = new ArrayList<>();
        this.f40950d = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: b7.a
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences2, String str) {
                EncryptedSharedPreferencesApi1.e(EncryptedSharedPreferencesApi1.this, sharedPreferences2, str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(EncryptedSharedPreferencesApi1 this$0, SharedPreferences sharedPreferences, String key) {
        Intrinsics.f(this$0, "this$0");
        for (OnStorageChangeListener onStorageChangeListener : this$0.f40949c) {
            Intrinsics.e(key, "key");
            onStorageChangeListener.a(key);
        }
    }

    private final String f(String str) {
        String string = this.f40948b.getString(str, null);
        if (string == null) {
            return null;
        }
        return this.f40947a.b(string);
    }

    private final void g(String str, String str2) {
        SharedPreferences.Editor edit = this.f40948b.edit();
        if (str2 != null && !TextUtils.isEmpty(str2)) {
            edit.putString(str, this.f40947a.a(str2));
        } else {
            edit.remove(str);
        }
        edit.apply();
    }

    @Override // eu.bolt.driver.core.storage.KVStorage
    public int a(String key, int i8) {
        Intrinsics.f(key, "key");
        String f8 = f(key);
        if (f8 != null) {
            return Integer.parseInt(f8);
        }
        return i8;
    }

    @Override // eu.bolt.driver.core.storage.KVStorage
    public void b(String key, Integer num) {
        String str;
        Intrinsics.f(key, "key");
        if (num != null) {
            str = num.toString();
        } else {
            str = null;
        }
        g(key, str);
    }

    @Override // eu.bolt.driver.core.storage.KVStorage
    public void c(String key, String str) {
        Intrinsics.f(key, "key");
        g(key, str);
    }

    @Override // eu.bolt.driver.core.storage.KVStorage
    public String getString(String key, String str) {
        Intrinsics.f(key, "key");
        String f8 = f(key);
        if (f8 != null) {
            return f8;
        }
        return str;
    }
}
