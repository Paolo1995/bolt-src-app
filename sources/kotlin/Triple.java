package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Tuples.kt */
/* loaded from: classes5.dex */
public final class Triple<A, B, C> implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    private final A f50829f;

    /* renamed from: g  reason: collision with root package name */
    private final B f50830g;

    /* renamed from: h  reason: collision with root package name */
    private final C f50831h;

    public Triple(A a8, B b8, C c8) {
        this.f50829f = a8;
        this.f50830g = b8;
        this.f50831h = c8;
    }

    public final A a() {
        return this.f50829f;
    }

    public final B b() {
        return this.f50830g;
    }

    public final C c() {
        return this.f50831h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Triple) {
            Triple triple = (Triple) obj;
            return Intrinsics.a(this.f50829f, triple.f50829f) && Intrinsics.a(this.f50830g, triple.f50830g) && Intrinsics.a(this.f50831h, triple.f50831h);
        }
        return false;
    }

    public int hashCode() {
        A a8 = this.f50829f;
        int hashCode = (a8 == null ? 0 : a8.hashCode()) * 31;
        B b8 = this.f50830g;
        int hashCode2 = (hashCode + (b8 == null ? 0 : b8.hashCode())) * 31;
        C c8 = this.f50831h;
        return hashCode2 + (c8 != null ? c8.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.f50829f + ", " + this.f50830g + ", " + this.f50831h + ')';
    }
}
