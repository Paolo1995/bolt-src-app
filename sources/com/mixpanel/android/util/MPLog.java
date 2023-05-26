package com.mixpanel.android.util;

import android.util.Log;

/* loaded from: classes3.dex */
public class MPLog {

    /* renamed from: a  reason: collision with root package name */
    private static int f19433a = 5;

    public static void a(String str, String str2) {
        if (h(3)) {
            Log.d(str, str2);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (h(3)) {
            Log.d(str, str2, th);
        }
    }

    public static void c(String str, String str2) {
        if (h(6)) {
            Log.e(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (h(6)) {
            Log.e(str, str2, th);
        }
    }

    public static void e(String str, String str2) {
        if (h(4)) {
            Log.i(str, str2);
        }
    }

    public static void f(String str, String str2, Throwable th) {
        if (h(4)) {
            Log.i(str, str2, th);
        }
    }

    public static void g(int i8) {
        f19433a = i8;
    }

    private static boolean h(int i8) {
        if (f19433a <= i8) {
            return true;
        }
        return false;
    }

    public static void i(String str, String str2) {
        if (h(2)) {
            Log.v(str, str2);
        }
    }

    public static void j(String str, String str2, Throwable th) {
        if (h(2)) {
            Log.v(str, str2, th);
        }
    }

    public static void k(String str, String str2) {
        if (h(5)) {
            Log.w(str, str2);
        }
    }

    public static void l(String str, String str2, Throwable th) {
        if (h(5)) {
            Log.w(str, str2, th);
        }
    }

    public static void m(String str, String str2) {
        if (h(6)) {
            Log.wtf(str, str2);
        }
    }

    public static void n(String str, String str2, Throwable th) {
        if (h(6)) {
            Log.wtf(str, str2, th);
        }
    }
}
