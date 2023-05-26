package com.google.firebase.perf.util;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.firebase.perf.logging.AndroidLogger;
import okhttp3.HttpUrl;

/* loaded from: classes3.dex */
public class Utils {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f16902a;

    public static void a(boolean z7, String str) {
        if (z7) {
            return;
        }
        throw new IllegalArgumentException(str);
    }

    public static boolean b(@NonNull Context context) {
        Boolean bool = f16902a;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Boolean valueOf = Boolean.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("firebase_performance_logcat_enabled", false));
            f16902a = valueOf;
            return valueOf.booleanValue();
        } catch (PackageManager.NameNotFoundException | NullPointerException e8) {
            AndroidLogger e9 = AndroidLogger.e();
            e9.a("No perf logcat meta data found " + e8.getMessage());
            return false;
        }
    }

    public static int c(long j8) {
        if (j8 > 2147483647L) {
            return Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        if (j8 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j8;
    }

    public static String d(@NonNull String str) {
        HttpUrl parse = HttpUrl.parse(str);
        if (parse != null) {
            return parse.newBuilder().username("").password("").query(null).fragment(null).toString();
        }
        return str;
    }

    public static String e(String str, int i8) {
        int lastIndexOf;
        if (str.length() <= i8) {
            return str;
        }
        if (str.charAt(i8) == '/') {
            return str.substring(0, i8);
        }
        HttpUrl parse = HttpUrl.parse(str);
        if (parse == null) {
            return str.substring(0, i8);
        }
        if (parse.encodedPath().lastIndexOf(47) >= 0 && (lastIndexOf = str.lastIndexOf(47, i8 - 1)) >= 0) {
            return str.substring(0, lastIndexOf);
        }
        return str.substring(0, i8);
    }
}
