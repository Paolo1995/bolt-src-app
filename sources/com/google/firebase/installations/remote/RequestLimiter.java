package com.google.firebase.installations.remote;

import com.google.firebase.installations.Utils;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
class RequestLimiter {

    /* renamed from: d  reason: collision with root package name */
    private static final long f16438d = TimeUnit.HOURS.toMillis(24);

    /* renamed from: e  reason: collision with root package name */
    private static final long f16439e = TimeUnit.MINUTES.toMillis(30);

    /* renamed from: a  reason: collision with root package name */
    private final Utils f16440a = Utils.c();

    /* renamed from: b  reason: collision with root package name */
    private long f16441b;

    /* renamed from: c  reason: collision with root package name */
    private int f16442c;

    private synchronized long a(int i8) {
        if (!c(i8)) {
            return f16438d;
        }
        return (long) Math.min(Math.pow(2.0d, this.f16442c) + this.f16440a.e(), f16439e);
    }

    private static boolean c(int i8) {
        return i8 == 429 || (i8 >= 500 && i8 < 600);
    }

    private static boolean d(int i8) {
        return (i8 >= 200 && i8 < 300) || i8 == 401 || i8 == 404;
    }

    private synchronized void e() {
        this.f16442c = 0;
    }

    public synchronized boolean b() {
        boolean z7;
        if (this.f16442c != 0) {
            if (this.f16440a.a() <= this.f16441b) {
                z7 = false;
            }
        }
        z7 = true;
        return z7;
    }

    public synchronized void f(int i8) {
        if (d(i8)) {
            e();
            return;
        }
        this.f16442c++;
        this.f16441b = this.f16440a.a() + a(i8);
    }
}
