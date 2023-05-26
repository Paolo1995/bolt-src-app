package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Tuples.kt */
/* loaded from: classes5.dex */
public final class Pair<A, B> implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    private final A f50816f;

    /* renamed from: g  reason: collision with root package name */
    private final B f50817g;

    public Pair(A a8, B b8) {
        this.f50816f = a8;
        this.f50817g = b8;
    }

    public final A a() {
        return this.f50816f;
    }

    public final B b() {
        return this.f50817g;
    }

    public final Pair<A, B> c(A a8, B b8) {
        return new Pair<>(a8, b8);
    }

    public final A d() {
        return this.f50816f;
    }

    public final B e() {
        return this.f50817g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            return Intrinsics.a(this.f50816f, pair.f50816f) && Intrinsics.a(this.f50817g, pair.f50817g);
        }
        return false;
    }

    public int hashCode() {
        A a8 = this.f50816f;
        int hashCode = (a8 == null ? 0 : a8.hashCode()) * 31;
        B b8 = this.f50817g;
        return hashCode + (b8 != null ? b8.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.f50816f + ", " + this.f50817g + ')';
    }
}
