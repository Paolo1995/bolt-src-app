package eu.bolt.driver.core.storage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import eu.bolt.driver.core.storage.BoltSharedPrefs;
import java.util.ArrayList;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BoltSharedPrefs.kt */
@SuppressLint({"ApplySharedPref"})
/* loaded from: classes5.dex */
public final class BoltSharedPrefs implements BoltPrefsStorage {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f40937d = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f40938a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<OnPrefChangeListener> f40939b;

    /* renamed from: c  reason: collision with root package name */
    private final SharedPreferences.OnSharedPreferenceChangeListener f40940c;

    /* compiled from: BoltSharedPrefs.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BoltSharedPrefs(Context context, String sharedPrefsName, int i8, OnStorageVersionUpgradedListener onStorageVersionUpgradedListener) {
        Intrinsics.f(context, "context");
        Intrinsics.f(sharedPrefsName, "sharedPrefsName");
        SharedPreferences sharedPreferences = context.getSharedPreferences(sharedPrefsName, 0);
        Intrinsics.e(sharedPreferences, "context.getSharedPrefere…me, Context.MODE_PRIVATE)");
        this.f40938a = sharedPreferences;
        this.f40939b = new ArrayList<>();
        if (a("prefs_current_version", 0) < i8) {
            if (onStorageVersionUpgradedListener != null) {
                onStorageVersionUpgradedListener.a(sharedPreferences.getInt("prefs_current_version", 0), i8, this);
            }
            b("prefs_current_version", Integer.valueOf(i8));
        }
        this.f40940c = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: a7.a
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences2, String str) {
                BoltSharedPrefs.j(BoltSharedPrefs.this, sharedPreferences2, str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(BoltSharedPrefs this$0, SharedPreferences sharedPreferences, String key) {
        Intrinsics.f(this$0, "this$0");
        for (OnPrefChangeListener onPrefChangeListener : this$0.f40939b) {
            Intrinsics.e(key, "key");
            onPrefChangeListener.a(key);
        }
    }

    @Override // eu.bolt.driver.core.storage.BoltPrefsStorage
    public int a(String keySuffix, int i8) {
        Intrinsics.f(keySuffix, "keySuffix");
        return this.f40938a.getInt(keySuffix, i8);
    }

    @Override // eu.bolt.driver.core.storage.BoltPrefsStorage
    public void b(String keySuffix, Integer num) {
        Intrinsics.f(keySuffix, "keySuffix");
        SharedPreferences.Editor edit = this.f40938a.edit();
        if (num == null) {
            edit.remove(keySuffix);
        } else {
            edit.putInt(keySuffix, num.intValue());
        }
        edit.commit();
    }

    @Override // eu.bolt.driver.core.storage.BoltPrefsStorage
    public void c(String keySuffix, String str) {
        Intrinsics.f(keySuffix, "keySuffix");
        SharedPreferences.Editor edit = this.f40938a.edit();
        if (TextUtils.isEmpty(str)) {
            edit.remove(keySuffix);
        } else {
            edit.putString(keySuffix, str);
        }
        edit.commit();
    }

    @Override // eu.bolt.driver.core.storage.BoltPrefsStorage
    public boolean contains(String keySuffix) {
        Intrinsics.f(keySuffix, "keySuffix");
        return this.f40938a.contains(keySuffix);
    }

    @Override // eu.bolt.driver.core.storage.BoltPrefsStorage
    public void d(String keySuffix, Set<String> set) {
        boolean z7;
        Intrinsics.f(keySuffix, "keySuffix");
        SharedPreferences.Editor edit = this.f40938a.edit();
        if (set != null && !set.isEmpty()) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (z7) {
            edit.remove(keySuffix);
        } else {
            edit.putStringSet(keySuffix, set);
        }
        edit.apply();
    }

    @Override // eu.bolt.driver.core.storage.BoltPrefsStorage
    public void e(String... suffixes) {
        boolean z7;
        Intrinsics.f(suffixes, "suffixes");
        if (suffixes.length == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return;
        }
        SharedPreferences.Editor edit = this.f40938a.edit();
        for (String str : suffixes) {
            edit.remove(str);
        }
        edit.commit();
    }

    @Override // eu.bolt.driver.core.storage.BoltPrefsStorage
    public void f() {
        this.f40938a.edit().clear().commit();
    }

    @Override // eu.bolt.driver.core.storage.BoltPrefsStorage
    public void g(String keySuffix, Long l8) {
        Intrinsics.f(keySuffix, "keySuffix");
        SharedPreferences.Editor edit = this.f40938a.edit();
        if (l8 == null) {
            edit.remove(keySuffix);
        } else {
            edit.putLong(keySuffix, l8.longValue());
        }
        edit.commit();
    }

    @Override // eu.bolt.driver.core.storage.BoltPrefsStorage
    public boolean getBoolean(String keySuffix, boolean z7) {
        Intrinsics.f(keySuffix, "keySuffix");
        return this.f40938a.getBoolean(keySuffix, z7);
    }

    @Override // eu.bolt.driver.core.storage.BoltPrefsStorage
    public long getLong(String keySuffix, long j8) {
        Intrinsics.f(keySuffix, "keySuffix");
        return this.f40938a.getLong(keySuffix, j8);
    }

    @Override // eu.bolt.driver.core.storage.BoltPrefsStorage
    public String getString(String keySuffix, String str) {
        Intrinsics.f(keySuffix, "keySuffix");
        String string = this.f40938a.getString(keySuffix, str);
        if (string != null) {
            return string;
        }
        return str;
    }

    @Override // eu.bolt.driver.core.storage.BoltPrefsStorage
    public Set<String> getStringSet(String keySuffix, Set<String> defaultValue) {
        Intrinsics.f(keySuffix, "keySuffix");
        Intrinsics.f(defaultValue, "defaultValue");
        Set<String> stringSet = this.f40938a.getStringSet(keySuffix, defaultValue);
        if (stringSet != null) {
            return stringSet;
        }
        return defaultValue;
    }

    @Override // eu.bolt.driver.core.storage.BoltPrefsStorage
    public void h(String keySuffix, Boolean bool) {
        Intrinsics.f(keySuffix, "keySuffix");
        SharedPreferences.Editor edit = this.f40938a.edit();
        if (bool == null) {
            edit.remove(keySuffix);
        } else {
            edit.putBoolean(keySuffix, bool.booleanValue());
        }
        edit.commit();
    }
}
