package j$.util;

import java.util.NoSuchElementException;

/* renamed from: j$.util.l  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0154l {

    /* renamed from: c  reason: collision with root package name */
    private static final C0154l f50357c = new C0154l();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f50358a;

    /* renamed from: b  reason: collision with root package name */
    private final long f50359b;

    private C0154l() {
        this.f50358a = false;
        this.f50359b = 0L;
    }

    private C0154l(long j8) {
        this.f50358a = true;
        this.f50359b = j8;
    }

    public static C0154l a() {
        return f50357c;
    }

    public static C0154l d(long j8) {
        return new C0154l(j8);
    }

    public final long b() {
        if (this.f50358a) {
            return this.f50359b;
        }
        throw new NoSuchElementException("No value present");
    }

    public final boolean c() {
        return this.f50358a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0154l) {
            C0154l c0154l = (C0154l) obj;
            boolean z7 = this.f50358a;
            if (z7 && c0154l.f50358a) {
                if (this.f50359b == c0154l.f50359b) {
                    return true;
                }
            } else if (z7 == c0154l.f50358a) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        if (this.f50358a) {
            long j8 = this.f50359b;
            return (int) (j8 ^ (j8 >>> 32));
        }
        return 0;
    }

    public final String toString() {
        return this.f50358a ? String.format("OptionalLong[%s]", Long.valueOf(this.f50359b)) : "OptionalLong.empty";
    }
}
