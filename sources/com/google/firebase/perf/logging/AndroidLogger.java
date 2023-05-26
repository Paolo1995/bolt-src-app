package com.google.firebase.perf.logging;

import java.util.Locale;

/* loaded from: classes3.dex */
public class AndroidLogger {

    /* renamed from: c  reason: collision with root package name */
    private static volatile AndroidLogger f16755c;

    /* renamed from: a  reason: collision with root package name */
    private final LogWrapper f16756a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f16757b;

    public AndroidLogger(LogWrapper logWrapper) {
        this.f16757b = false;
        this.f16756a = logWrapper == null ? LogWrapper.c() : logWrapper;
    }

    public static AndroidLogger e() {
        if (f16755c == null) {
            synchronized (AndroidLogger.class) {
                if (f16755c == null) {
                    f16755c = new AndroidLogger();
                }
            }
        }
        return f16755c;
    }

    public void a(String str) {
        if (this.f16757b) {
            this.f16756a.a(str);
        }
    }

    public void b(String str, Object... objArr) {
        if (this.f16757b) {
            this.f16756a.a(String.format(Locale.ENGLISH, str, objArr));
        }
    }

    public void c(String str) {
        if (this.f16757b) {
            this.f16756a.b(str);
        }
    }

    public void d(String str, Object... objArr) {
        if (this.f16757b) {
            this.f16756a.b(String.format(Locale.ENGLISH, str, objArr));
        }
    }

    public void f(String str) {
        if (this.f16757b) {
            this.f16756a.d(str);
        }
    }

    public void g(String str, Object... objArr) {
        if (this.f16757b) {
            this.f16756a.d(String.format(Locale.ENGLISH, str, objArr));
        }
    }

    public void h(boolean z7) {
        this.f16757b = z7;
    }

    public void i(String str) {
        if (this.f16757b) {
            this.f16756a.e(str);
        }
    }

    public void j(String str, Object... objArr) {
        if (this.f16757b) {
            this.f16756a.e(String.format(Locale.ENGLISH, str, objArr));
        }
    }

    private AndroidLogger() {
        this(null);
    }
}
