package com.bumptech.glide.signature;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes.dex */
public final class ApplicationVersionSignature {

    /* renamed from: a  reason: collision with root package name */
    private static final ConcurrentMap<String, Key> f10758a = new ConcurrentHashMap();

    private ApplicationVersionSignature() {
    }

    private static PackageInfo a(@NonNull Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e8) {
            Log.e("AppVersionSignature", "Cannot resolve info for" + context.getPackageName(), e8);
            return null;
        }
    }

    @NonNull
    private static String b(PackageInfo packageInfo) {
        if (packageInfo != null) {
            return String.valueOf(packageInfo.versionCode);
        }
        return UUID.randomUUID().toString();
    }

    @NonNull
    public static Key c(@NonNull Context context) {
        String packageName = context.getPackageName();
        ConcurrentMap<String, Key> concurrentMap = f10758a;
        Key key = concurrentMap.get(packageName);
        if (key == null) {
            Key d8 = d(context);
            Key putIfAbsent = concurrentMap.putIfAbsent(packageName, d8);
            if (putIfAbsent != null) {
                return putIfAbsent;
            }
            return d8;
        }
        return key;
    }

    @NonNull
    private static Key d(@NonNull Context context) {
        return new ObjectKey(b(a(context)));
    }
}
