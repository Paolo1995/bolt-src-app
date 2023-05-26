package androidx.core.util;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class Pair<F, S> {

    /* renamed from: a  reason: collision with root package name */
    public final F f5908a;

    /* renamed from: b  reason: collision with root package name */
    public final S f5909b;

    public Pair(F f8, S s7) {
        this.f5908a = f8;
        this.f5909b = s7;
    }

    @NonNull
    public static <A, B> Pair<A, B> a(A a8, B b8) {
        return new Pair<>(a8, b8);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        if (!ObjectsCompat.a(pair.f5908a, this.f5908a) || !ObjectsCompat.a(pair.f5909b, this.f5909b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        F f8 = this.f5908a;
        int i8 = 0;
        if (f8 == null) {
            hashCode = 0;
        } else {
            hashCode = f8.hashCode();
        }
        S s7 = this.f5909b;
        if (s7 != null) {
            i8 = s7.hashCode();
        }
        return hashCode ^ i8;
    }

    @NonNull
    public String toString() {
        return "Pair{" + this.f5908a + " " + this.f5909b + "}";
    }
}
