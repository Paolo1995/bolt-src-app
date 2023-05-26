package com.google.firebase.installations.time;

/* loaded from: classes3.dex */
public class SystemClock implements Clock {

    /* renamed from: a  reason: collision with root package name */
    private static SystemClock f16447a;

    private SystemClock() {
    }

    public static SystemClock a() {
        if (f16447a == null) {
            f16447a = new SystemClock();
        }
        return f16447a;
    }

    @Override // com.google.firebase.installations.time.Clock
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
