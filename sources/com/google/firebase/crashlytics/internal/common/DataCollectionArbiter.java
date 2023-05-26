package com.google.firebase.crashlytics.internal.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.Logger;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public class DataCollectionArbiter {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f15682a;

    /* renamed from: b  reason: collision with root package name */
    private final FirebaseApp f15683b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f15684c;

    /* renamed from: d  reason: collision with root package name */
    TaskCompletionSource<Void> f15685d;

    /* renamed from: e  reason: collision with root package name */
    boolean f15686e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f15687f;

    /* renamed from: g  reason: collision with root package name */
    private Boolean f15688g;

    /* renamed from: h  reason: collision with root package name */
    private final TaskCompletionSource<Void> f15689h;

    public DataCollectionArbiter(FirebaseApp firebaseApp) {
        Object obj = new Object();
        this.f15684c = obj;
        this.f15685d = new TaskCompletionSource<>();
        this.f15686e = false;
        this.f15687f = false;
        this.f15689h = new TaskCompletionSource<>();
        Context j8 = firebaseApp.j();
        this.f15683b = firebaseApp;
        this.f15682a = CommonUtils.r(j8);
        Boolean b8 = b();
        this.f15688g = b8 == null ? a(j8) : b8;
        synchronized (obj) {
            if (d()) {
                this.f15685d.trySetResult(null);
                this.f15686e = true;
            }
        }
    }

    private Boolean a(Context context) {
        Boolean f8 = f(context);
        if (f8 == null) {
            this.f15687f = false;
            return null;
        }
        this.f15687f = true;
        return Boolean.valueOf(Boolean.TRUE.equals(f8));
    }

    private Boolean b() {
        if (this.f15682a.contains("firebase_crashlytics_collection_enabled")) {
            this.f15687f = false;
            return Boolean.valueOf(this.f15682a.getBoolean("firebase_crashlytics_collection_enabled", true));
        }
        return null;
    }

    private void e(boolean z7) {
        String str;
        String str2;
        if (z7) {
            str = "ENABLED";
        } else {
            str = "DISABLED";
        }
        if (this.f15688g == null) {
            str2 = "global Firebase setting";
        } else if (this.f15687f) {
            str2 = "firebase_crashlytics_collection_enabled manifest flag";
        } else {
            str2 = "API";
        }
        Logger.f().b(String.format("Crashlytics automatic data collection %s by %s.", str, str2));
    }

    private static Boolean f(Context context) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("firebase_crashlytics_collection_enabled")) {
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_crashlytics_collection_enabled"));
            }
            return null;
        } catch (PackageManager.NameNotFoundException e8) {
            Logger.f().e("Could not read data collection permission from manifest", e8);
            return null;
        }
    }

    @SuppressLint({"ApplySharedPref"})
    private static void h(SharedPreferences sharedPreferences, Boolean bool) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (bool != null) {
            edit.putBoolean("firebase_crashlytics_collection_enabled", bool.booleanValue());
        } else {
            edit.remove("firebase_crashlytics_collection_enabled");
        }
        edit.apply();
    }

    public void c(boolean z7) {
        if (z7) {
            this.f15689h.trySetResult(null);
            return;
        }
        throw new IllegalStateException("An invalid data collection token was used.");
    }

    public synchronized boolean d() {
        boolean s7;
        Boolean bool = this.f15688g;
        if (bool != null) {
            s7 = bool.booleanValue();
        } else {
            s7 = this.f15683b.s();
        }
        e(s7);
        return s7;
    }

    public synchronized void g(Boolean bool) {
        Boolean a8;
        if (bool != null) {
            try {
                this.f15687f = false;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (bool != null) {
            a8 = bool;
        } else {
            a8 = a(this.f15683b.j());
        }
        this.f15688g = a8;
        h(this.f15682a, bool);
        synchronized (this.f15684c) {
            if (d()) {
                if (!this.f15686e) {
                    this.f15685d.trySetResult(null);
                    this.f15686e = true;
                }
            } else if (this.f15686e) {
                this.f15685d = new TaskCompletionSource<>();
                this.f15686e = false;
            }
        }
    }

    public Task<Void> i() {
        Task<Void> task;
        synchronized (this.f15684c) {
            task = this.f15685d.getTask();
        }
        return task;
    }

    public Task<Void> j(Executor executor) {
        return Utils.j(executor, this.f15689h.getTask(), i());
    }
}
