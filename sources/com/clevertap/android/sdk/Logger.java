package com.clevertap.android.sdk;

import android.util.Log;
import com.clevertap.android.sdk.CleverTapAPI;
import com.sinch.android.rtc.internal.InternalErrorCodes;

/* loaded from: classes.dex */
public final class Logger {

    /* renamed from: a  reason: collision with root package name */
    private int f11065a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Logger(int i8) {
        this.f11065a = i8;
    }

    public static void a(String str) {
        if (i() > CleverTapAPI.LogLevel.INFO.a()) {
            Log.d("CleverTap", str);
        }
    }

    public static void b(String str, String str2) {
        if (i() > CleverTapAPI.LogLevel.INFO.a()) {
            Log.d("CleverTap:" + str, str2);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        if (i() > CleverTapAPI.LogLevel.INFO.a()) {
            Log.d("CleverTap:" + str, str2, th);
        }
    }

    public static void d(String str, Throwable th) {
        if (i() > CleverTapAPI.LogLevel.INFO.a()) {
            Log.d("CleverTap", str, th);
        }
    }

    private int h() {
        return this.f11065a;
    }

    private static int i() {
        return CleverTapAPI.w();
    }

    public static void j(String str) {
        if (i() >= CleverTapAPI.LogLevel.INFO.a()) {
            Log.i("CleverTap", str);
        }
    }

    public static void k(String str, Throwable th) {
        if (i() >= CleverTapAPI.LogLevel.INFO.a()) {
            Log.i("CleverTap", str, th);
        }
    }

    public static void n(String str) {
        if (i() > CleverTapAPI.LogLevel.DEBUG.a()) {
            Log.v("CleverTap", str);
        }
    }

    public static void o(String str, String str2) {
        if (i() > CleverTapAPI.LogLevel.DEBUG.a()) {
            Log.v("CleverTap:" + str, str2);
        }
    }

    public static void p(String str, String str2, Throwable th) {
        if (i() > CleverTapAPI.LogLevel.DEBUG.a()) {
            Log.v("CleverTap:" + str, str2, th);
        }
    }

    public static void q(String str, Throwable th) {
        if (i() > CleverTapAPI.LogLevel.DEBUG.a()) {
            Log.v("CleverTap", str, th);
        }
    }

    public void e(String str) {
        if (i() > CleverTapAPI.LogLevel.INFO.a()) {
            Log.d("CleverTap", str);
        }
    }

    public void f(String str, String str2) {
        if (i() > CleverTapAPI.LogLevel.INFO.a()) {
            if (str2.length() > 4000) {
                Log.d("CleverTap:" + str, str2.substring(0, InternalErrorCodes.ApiCallFailed));
                f(str, str2.substring(InternalErrorCodes.ApiCallFailed));
                return;
            }
            Log.d("CleverTap:" + str, str2);
        }
    }

    public void g(String str, String str2, Throwable th) {
        if (i() > CleverTapAPI.LogLevel.INFO.a()) {
            Log.d("CleverTap:" + str, str2, th);
        }
    }

    public void l(String str) {
        if (h() >= CleverTapAPI.LogLevel.INFO.a()) {
            Log.i("CleverTap", str);
        }
    }

    public void m(String str, String str2) {
        if (h() >= CleverTapAPI.LogLevel.INFO.a()) {
            Log.i("CleverTap:" + str, str2);
        }
    }

    public void r(String str) {
        if (i() > CleverTapAPI.LogLevel.DEBUG.a()) {
            Log.v("CleverTap", str);
        }
    }

    public void s(String str, String str2) {
        if (i() > CleverTapAPI.LogLevel.DEBUG.a()) {
            if (str2.length() > 4000) {
                Log.v("CleverTap:" + str, str2.substring(0, InternalErrorCodes.ApiCallFailed));
                s(str, str2.substring(InternalErrorCodes.ApiCallFailed));
                return;
            }
            Log.v("CleverTap:" + str, str2);
        }
    }

    public void t(String str, String str2, Throwable th) {
        if (i() > CleverTapAPI.LogLevel.DEBUG.a()) {
            Log.v("CleverTap:" + str, str2, th);
        }
    }

    public void u(String str, Throwable th) {
        if (i() > CleverTapAPI.LogLevel.DEBUG.a()) {
            Log.v("CleverTap", str, th);
        }
    }
}
