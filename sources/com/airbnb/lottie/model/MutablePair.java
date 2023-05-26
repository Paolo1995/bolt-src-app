package com.airbnb.lottie.model;

import androidx.core.util.Pair;

/* loaded from: classes.dex */
public class MutablePair<T> {

    /* renamed from: a  reason: collision with root package name */
    T f9300a;

    /* renamed from: b  reason: collision with root package name */
    T f9301b;

    private static boolean a(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }

    public void b(T t7, T t8) {
        this.f9300a = t7;
        this.f9301b = t8;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        if (!a(pair.f5908a, this.f9300a) || !a(pair.f5909b, this.f9301b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        T t7 = this.f9300a;
        int i8 = 0;
        if (t7 == null) {
            hashCode = 0;
        } else {
            hashCode = t7.hashCode();
        }
        T t8 = this.f9301b;
        if (t8 != null) {
            i8 = t8.hashCode();
        }
        return hashCode ^ i8;
    }

    public String toString() {
        return "Pair{" + this.f9300a + " " + this.f9301b + "}";
    }
}
