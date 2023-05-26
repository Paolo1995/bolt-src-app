package com.google.firebase.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import com.google.firebase.events.Publisher;

/* loaded from: classes3.dex */
public class DataCollectionConfigStorage {

    /* renamed from: a  reason: collision with root package name */
    private final Context f16448a;

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f16449b;

    /* renamed from: c  reason: collision with root package name */
    private final Publisher f16450c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f16451d;

    public DataCollectionConfigStorage(Context context, String str, Publisher publisher) {
        Context a8 = a(context);
        this.f16448a = a8;
        this.f16449b = a8.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        this.f16450c = publisher;
        this.f16451d = c();
    }

    private static Context a(Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            return context;
        }
        return ContextCompat.createDeviceProtectedStorageContext(context);
    }

    private boolean c() {
        if (this.f16449b.contains("firebase_data_collection_default_enabled")) {
            return this.f16449b.getBoolean("firebase_data_collection_default_enabled", true);
        }
        return d();
    }

    private boolean d() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = this.f16448a.getPackageManager();
            if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(this.f16448a.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("firebase_data_collection_default_enabled")) {
                return applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    public synchronized boolean b() {
        return this.f16451d;
    }
}
