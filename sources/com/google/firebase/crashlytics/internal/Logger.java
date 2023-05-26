package com.google.firebase.crashlytics.internal;

import android.util.Log;

/* loaded from: classes3.dex */
public class Logger {

    /* renamed from: c  reason: collision with root package name */
    static final Logger f15548c = new Logger("FirebaseCrashlytics");

    /* renamed from: a  reason: collision with root package name */
    private final String f15549a;

    /* renamed from: b  reason: collision with root package name */
    private int f15550b = 4;

    public Logger(String str) {
        this.f15549a = str;
    }

    private boolean a(int i8) {
        if (this.f15550b > i8 && !Log.isLoggable(this.f15549a, i8)) {
            return false;
        }
        return true;
    }

    public static Logger f() {
        return f15548c;
    }

    public void b(String str) {
        c(str, null);
    }

    public void c(String str, Throwable th) {
        if (a(3)) {
            Log.d(this.f15549a, str, th);
        }
    }

    public void d(String str) {
        e(str, null);
    }

    public void e(String str, Throwable th) {
        if (a(6)) {
            Log.e(this.f15549a, str, th);
        }
    }

    public void g(String str) {
        h(str, null);
    }

    public void h(String str, Throwable th) {
        if (a(4)) {
            Log.i(this.f15549a, str, th);
        }
    }

    public void i(String str) {
        j(str, null);
    }

    public void j(String str, Throwable th) {
        if (a(2)) {
            Log.v(this.f15549a, str, th);
        }
    }

    public void k(String str) {
        l(str, null);
    }

    public void l(String str, Throwable th) {
        if (a(5)) {
            Log.w(this.f15549a, str, th);
        }
    }
}
