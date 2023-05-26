package com.clevertap.android.sdk;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public final class StorageHelper {
    static boolean a(Context context, String str, boolean z7) {
        return g(context).getBoolean(str, z7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, String str) {
        if (cleverTapInstanceConfig.t()) {
            boolean a8 = a(context, s(cleverTapInstanceConfig, str), false);
            if (!a8) {
                return a(context, str, false);
            }
            return a8;
        }
        return a(context, s(cleverTapInstanceConfig, str), false);
    }

    public static int c(Context context, String str, int i8) {
        return g(context).getInt(str, i8);
    }

    public static int d(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, String str, int i8) {
        if (cleverTapInstanceConfig.t()) {
            int c8 = c(context, s(cleverTapInstanceConfig, str), -1000);
            if (c8 == -1000) {
                return c(context, str, i8);
            }
            return c8;
        }
        return c(context, s(cleverTapInstanceConfig, str), i8);
    }

    static long e(Context context, String str, String str2, long j8) {
        return h(context, str).getLong(str2, j8);
    }

    public static long f(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, String str, int i8, String str2) {
        if (cleverTapInstanceConfig.t()) {
            long e8 = e(context, str2, s(cleverTapInstanceConfig, str), -1000L);
            if (e8 == -1000) {
                return e(context, str2, str, i8);
            }
            return e8;
        }
        return e(context, str2, s(cleverTapInstanceConfig, str), i8);
    }

    public static SharedPreferences g(Context context) {
        return h(context, null);
    }

    public static SharedPreferences h(Context context, String str) {
        String str2 = "WizRocket";
        if (str != null) {
            str2 = "WizRocket_" + str;
        }
        return context.getSharedPreferences(str2, 0);
    }

    public static String i(Context context, String str, String str2) {
        return g(context).getString(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String j(Context context, String str, String str2, String str3) {
        return h(context, str).getString(str2, str3);
    }

    public static String k(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, String str, String str2) {
        if (cleverTapInstanceConfig.t()) {
            String i8 = i(context, s(cleverTapInstanceConfig, str), str2);
            if (i8 == null) {
                return i(context, str, str2);
            }
            return i8;
        }
        return i(context, s(cleverTapInstanceConfig, str), str2);
    }

    public static void l(SharedPreferences.Editor editor) {
        try {
            editor.apply();
        } catch (Throwable th) {
            Logger.q("CRITICAL: Failed to persist shared preferences!", th);
        }
    }

    public static void m(SharedPreferences.Editor editor) {
        try {
            editor.commit();
        } catch (Throwable th) {
            Logger.q("CRITICAL: Failed to persist shared preferences!", th);
        }
    }

    public static void n(Context context, String str, int i8) {
        l(g(context).edit().putInt(str, i8));
    }

    public static void o(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, String str, String str2) {
        l(g(context).edit().putString(s(cleverTapInstanceConfig, str), str2));
    }

    public static void p(Context context, String str, String str2) {
        l(g(context).edit().putString(str, str2));
    }

    public static void q(Context context, String str, String str2) {
        m(g(context).edit().putString(str, str2));
    }

    public static void r(Context context, String str) {
        l(g(context).edit().remove(str));
    }

    public static String s(CleverTapInstanceConfig cleverTapInstanceConfig, String str) {
        return str + ":" + cleverTapInstanceConfig.c();
    }
}
