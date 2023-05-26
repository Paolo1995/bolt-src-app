package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.os.SystemClock;

/* loaded from: classes.dex */
public final class LogTime {

    /* renamed from: a  reason: collision with root package name */
    private static final double f10775a = 1.0d / Math.pow(10.0d, 6.0d);

    private LogTime() {
    }

    public static double a(long j8) {
        return (b() - j8) * f10775a;
    }

    @TargetApi(17)
    public static long b() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
