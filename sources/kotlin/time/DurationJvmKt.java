package kotlin.time;

import java.text.DecimalFormat;

/* compiled from: DurationJvm.kt */
/* loaded from: classes5.dex */
public final class DurationJvmKt {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f51181a = false;

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal<DecimalFormat>[] f51182b;

    static {
        ThreadLocal<DecimalFormat>[] threadLocalArr = new ThreadLocal[4];
        for (int i8 = 0; i8 < 4; i8++) {
            threadLocalArr[i8] = new ThreadLocal<>();
        }
        f51182b = threadLocalArr;
    }

    public static final boolean a() {
        return f51181a;
    }
}
