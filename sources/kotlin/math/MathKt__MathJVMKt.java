package kotlin.math;

import com.google.android.gms.common.api.Api;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MathJVM.kt */
/* loaded from: classes5.dex */
public class MathKt__MathJVMKt extends MathKt__MathHKt {
    public static int a(double d8) {
        if (!Double.isNaN(d8)) {
            if (d8 > 2.147483647E9d) {
                return Api.BaseClientBuilder.API_PRIORITY_OTHER;
            }
            if (d8 < -2.147483648E9d) {
                return Integer.MIN_VALUE;
            }
            return (int) Math.round(d8);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    public static int b(float f8) {
        if (!Float.isNaN(f8)) {
            return Math.round(f8);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    public static long c(double d8) {
        if (!Double.isNaN(d8)) {
            return Math.round(d8);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }
}
