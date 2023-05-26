package com.google.firebase.perf.config;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.firebase.FirebaseApp;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Optional;

/* loaded from: classes3.dex */
public class DeviceCacheManager {

    /* renamed from: b  reason: collision with root package name */
    private static final AndroidLogger f16676b = AndroidLogger.e();

    /* renamed from: c  reason: collision with root package name */
    private static DeviceCacheManager f16677c;

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f16678a;

    private DeviceCacheManager() {
    }

    private Context b() {
        try {
            FirebaseApp.k();
            return FirebaseApp.k().j();
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    public static synchronized DeviceCacheManager d() {
        DeviceCacheManager deviceCacheManager;
        synchronized (DeviceCacheManager.class) {
            if (f16677c == null) {
                f16677c = new DeviceCacheManager();
            }
            deviceCacheManager = f16677c;
        }
        return deviceCacheManager;
    }

    public Optional<Boolean> a(String str) {
        if (str == null) {
            f16676b.a("Key is null when getting boolean value on device cache.");
            return Optional.a();
        }
        if (this.f16678a == null) {
            g(b());
            if (this.f16678a == null) {
                return Optional.a();
            }
        }
        if (!this.f16678a.contains(str)) {
            return Optional.a();
        }
        try {
            return Optional.e(Boolean.valueOf(this.f16678a.getBoolean(str, false)));
        } catch (ClassCastException e8) {
            f16676b.b("Key %s from sharedPreferences has type other than long: %s", str, e8.getMessage());
            return Optional.a();
        }
    }

    public Optional<Float> c(String str) {
        if (str == null) {
            f16676b.a("Key is null when getting float value on device cache.");
            return Optional.a();
        }
        if (this.f16678a == null) {
            g(b());
            if (this.f16678a == null) {
                return Optional.a();
            }
        }
        if (!this.f16678a.contains(str)) {
            return Optional.a();
        }
        try {
            return Optional.e(Float.valueOf(this.f16678a.getFloat(str, 0.0f)));
        } catch (ClassCastException e8) {
            f16676b.b("Key %s from sharedPreferences has type other than float: %s", str, e8.getMessage());
            return Optional.a();
        }
    }

    public Optional<Long> e(String str) {
        if (str == null) {
            f16676b.a("Key is null when getting long value on device cache.");
            return Optional.a();
        }
        if (this.f16678a == null) {
            g(b());
            if (this.f16678a == null) {
                return Optional.a();
            }
        }
        if (!this.f16678a.contains(str)) {
            return Optional.a();
        }
        try {
            return Optional.e(Long.valueOf(this.f16678a.getLong(str, 0L)));
        } catch (ClassCastException e8) {
            f16676b.b("Key %s from sharedPreferences has type other than long: %s", str, e8.getMessage());
            return Optional.a();
        }
    }

    public Optional<String> f(String str) {
        if (str == null) {
            f16676b.a("Key is null when getting String value on device cache.");
            return Optional.a();
        }
        if (this.f16678a == null) {
            g(b());
            if (this.f16678a == null) {
                return Optional.a();
            }
        }
        if (!this.f16678a.contains(str)) {
            return Optional.a();
        }
        try {
            return Optional.e(this.f16678a.getString(str, ""));
        } catch (ClassCastException e8) {
            f16676b.b("Key %s from sharedPreferences has type other than String: %s", str, e8.getMessage());
            return Optional.a();
        }
    }

    public synchronized void g(Context context) {
        if (this.f16678a == null && context != null) {
            this.f16678a = context.getSharedPreferences("FirebasePerfSharedPrefs", 0);
        }
    }

    public boolean h(String str, float f8) {
        if (str == null) {
            f16676b.a("Key is null when setting float value on device cache.");
            return false;
        }
        if (this.f16678a == null) {
            g(b());
            if (this.f16678a == null) {
                return false;
            }
        }
        this.f16678a.edit().putFloat(str, f8).apply();
        return true;
    }

    public boolean i(String str, long j8) {
        if (str == null) {
            f16676b.a("Key is null when setting long value on device cache.");
            return false;
        }
        if (this.f16678a == null) {
            g(b());
            if (this.f16678a == null) {
                return false;
            }
        }
        this.f16678a.edit().putLong(str, j8).apply();
        return true;
    }

    public boolean j(String str, String str2) {
        if (str == null) {
            f16676b.a("Key is null when setting String value on device cache.");
            return false;
        }
        if (this.f16678a == null) {
            g(b());
            if (this.f16678a == null) {
                return false;
            }
        }
        if (str2 == null) {
            this.f16678a.edit().remove(str).apply();
            return true;
        }
        this.f16678a.edit().putString(str, str2).apply();
        return true;
    }

    public boolean k(String str, boolean z7) {
        if (str == null) {
            f16676b.a("Key is null when setting boolean value on device cache.");
            return false;
        }
        if (this.f16678a == null) {
            g(b());
            if (this.f16678a == null) {
                return false;
            }
        }
        this.f16678a.edit().putBoolean(str, z7).apply();
        return true;
    }
}
