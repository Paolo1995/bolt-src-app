package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes.dex */
public class Easing {

    /* renamed from: b  reason: collision with root package name */
    static Easing f4445b = new Easing();

    /* renamed from: c  reason: collision with root package name */
    public static String[] f4446c = {"standard", "accelerate", "decelerate", "linear"};

    /* renamed from: a  reason: collision with root package name */
    String f4447a = "identity";

    public double a(double d8) {
        return d8;
    }

    public double b(double d8) {
        return 1.0d;
    }

    public String toString() {
        return this.f4447a;
    }
}
