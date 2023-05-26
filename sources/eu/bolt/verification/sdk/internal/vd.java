package eu.bolt.verification.sdk.internal;

import androidx.annotation.NonNull;
import java.io.Serializable;

/* loaded from: classes5.dex */
public abstract class vd<T> implements Serializable {
    public static <T> vd<T> a() {
        return a.h();
    }

    public static <T> vd<T> b(T t7) {
        return t7 == null ? a() : new ef(t7);
    }

    public static <T> vd<T> c(@NonNull T t7) {
        return new ef(xe.a(t7));
    }

    public abstract T d();

    public abstract boolean e();

    public abstract boolean f();

    public abstract T g();
}
