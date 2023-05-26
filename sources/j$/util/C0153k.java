package j$.util;

import java.util.NoSuchElementException;

/* renamed from: j$.util.k  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0153k {

    /* renamed from: c  reason: collision with root package name */
    private static final C0153k f50354c = new C0153k();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f50355a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50356b;

    private C0153k() {
        this.f50355a = false;
        this.f50356b = 0;
    }

    private C0153k(int i8) {
        this.f50355a = true;
        this.f50356b = i8;
    }

    public static C0153k a() {
        return f50354c;
    }

    public static C0153k d(int i8) {
        return new C0153k(i8);
    }

    public final int b() {
        if (this.f50355a) {
            return this.f50356b;
        }
        throw new NoSuchElementException("No value present");
    }

    public final boolean c() {
        return this.f50355a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0153k) {
            C0153k c0153k = (C0153k) obj;
            boolean z7 = this.f50355a;
            if (z7 && c0153k.f50355a) {
                if (this.f50356b == c0153k.f50356b) {
                    return true;
                }
            } else if (z7 == c0153k.f50355a) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        if (this.f50355a) {
            return this.f50356b;
        }
        return 0;
    }

    public final String toString() {
        return this.f50355a ? String.format("OptionalInt[%s]", Integer.valueOf(this.f50356b)) : "OptionalInt.empty";
    }
}
