package eu.bolt.driver.core.storage.crypto;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKeys;
import eu.bolt.driver.core.storage.KVStorage;
import eu.bolt.driver.core.storage.OnStorageChangeListener;
import eu.bolt.driver.core.storage.crypto.EncryptedSharedPreferencesApi23;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EncryptedSharedPreferencesApi23.kt */
/* loaded from: classes5.dex */
public final class EncryptedSharedPreferencesApi23 implements KVStorage {

    /* renamed from: a  reason: collision with root package name */
    private final String f40951a;

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f40952b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<OnStorageChangeListener> f40953c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedPreferences.OnSharedPreferenceChangeListener f40954d;

    public EncryptedSharedPreferencesApi23(Context context, String filename) {
        Intrinsics.f(context, "context");
        Intrinsics.f(filename, "filename");
        String c8 = MasterKeys.c(MasterKeys.f7736a);
        Intrinsics.e(c8, "getOrCreate(MasterKeys.AES256_GCM_SPEC)");
        this.f40951a = c8;
        SharedPreferences a8 = EncryptedSharedPreferences.a(filename, c8, context, EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV, EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM);
        Intrinsics.e(a8, "create(\n        filename…onScheme.AES256_GCM\n    )");
        this.f40952b = a8;
        this.f40953c = new ArrayList<>();
        this.f40954d = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: b7.b
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                EncryptedSharedPreferencesApi23.e(EncryptedSharedPreferencesApi23.this, sharedPreferences, str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(EncryptedSharedPreferencesApi23 this$0, SharedPreferences sharedPreferences, String key) {
        Intrinsics.f(this$0, "this$0");
        for (OnStorageChangeListener onStorageChangeListener : this$0.f40953c) {
            Intrinsics.e(key, "key");
            onStorageChangeListener.a(key);
        }
    }

    @Override // eu.bolt.driver.core.storage.KVStorage
    public int a(String key, int i8) {
        Intrinsics.f(key, "key");
        return this.f40952b.getInt(key, i8);
    }

    @Override // eu.bolt.driver.core.storage.KVStorage
    public void b(String key, Integer num) {
        Intrinsics.f(key, "key");
        SharedPreferences.Editor edit = this.f40952b.edit();
        if (num == null) {
            edit.remove(key);
        } else {
            edit.putInt(key, num.intValue());
        }
        edit.apply();
    }

    @Override // eu.bolt.driver.core.storage.KVStorage
    public void c(String key, String str) {
        Intrinsics.f(key, "key");
        SharedPreferences.Editor edit = this.f40952b.edit();
        if (TextUtils.isEmpty(str)) {
            edit.remove(key);
        } else {
            edit.putString(key, str);
        }
        edit.apply();
    }

    @Override // eu.bolt.driver.core.storage.KVStorage
    public String getString(String key, String str) {
        Intrinsics.f(key, "key");
        return this.f40952b.getString(key, str);
    }
}
