package com.airbnb.lottie.utils;

import com.airbnb.lottie.LottieLogger;

/* loaded from: classes.dex */
public class Logger {

    /* renamed from: a  reason: collision with root package name */
    private static LottieLogger f9640a = new LogcatLogger();

    public static void a(String str) {
        f9640a.debug(str);
    }

    public static void b(String str, Throwable th) {
        f9640a.error(str, th);
    }

    public static void c(String str) {
        f9640a.a(str);
    }

    public static void d(String str, Throwable th) {
        f9640a.b(str, th);
    }
}
