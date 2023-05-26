package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.firebase.FirebaseApp;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
@KeepForSdk
/* loaded from: classes3.dex */
public class Metadata {

    /* renamed from: a  reason: collision with root package name */
    private final Context f16316a;
    @GuardedBy("this")

    /* renamed from: b  reason: collision with root package name */
    private String f16317b;
    @GuardedBy("this")

    /* renamed from: c  reason: collision with root package name */
    private String f16318c;
    @GuardedBy("this")

    /* renamed from: d  reason: collision with root package name */
    private int f16319d;
    @GuardedBy("this")

    /* renamed from: e  reason: collision with root package name */
    private int f16320e = 0;

    public Metadata(Context context) {
        this.f16316a = context;
    }

    public static String c(FirebaseApp firebaseApp) {
        String d8 = firebaseApp.m().d();
        if (d8 != null) {
            return d8;
        }
        String c8 = firebaseApp.m().c();
        if (!c8.startsWith("1:")) {
            return c8;
        }
        String[] split = c8.split(":");
        if (split.length < 2) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    private PackageInfo f(String str) {
        try {
            return this.f16316a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e8) {
            String valueOf = String.valueOf(e8);
            StringBuilder sb = new StringBuilder(valueOf.length() + 23);
            sb.append("Failed to find package ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString());
            return null;
        }
    }

    private synchronized void h() {
        PackageInfo f8 = f(this.f16316a.getPackageName());
        if (f8 != null) {
            this.f16317b = Integer.toString(f8.versionCode);
            this.f16318c = f8.versionName;
        }
    }

    public synchronized String a() {
        if (this.f16317b == null) {
            h();
        }
        return this.f16317b;
    }

    public synchronized String b() {
        if (this.f16318c == null) {
            h();
        }
        return this.f16318c;
    }

    public synchronized int d() {
        PackageInfo f8;
        if (this.f16319d == 0 && (f8 = f("com.google.android.gms")) != null) {
            this.f16319d = f8.versionCode;
        }
        return this.f16319d;
    }

    public synchronized int e() {
        int i8 = this.f16320e;
        if (i8 != 0) {
            return i8;
        }
        PackageManager packageManager = this.f16316a.getPackageManager();
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("FirebaseInstanceId", "Google Play services missing or without correct permission.");
            return 0;
        }
        int i9 = 1;
        if (!PlatformVersion.isAtLeastO()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                this.f16320e = 1;
                return 1;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
            this.f16320e = 2;
            return 2;
        }
        Log.w("FirebaseInstanceId", "Failed to resolve IID implementation package, falling back");
        if (PlatformVersion.isAtLeastO()) {
            this.f16320e = 2;
            i9 = 2;
        } else {
            this.f16320e = 1;
        }
        return i9;
    }

    @KeepForSdk
    public boolean g() {
        if (e() != 0) {
            return true;
        }
        return false;
    }
}
