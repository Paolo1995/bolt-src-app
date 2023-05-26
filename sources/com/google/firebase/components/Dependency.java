package com.google.firebase.components;

/* loaded from: classes.dex */
public final class Dependency {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f15487a;

    /* renamed from: b  reason: collision with root package name */
    private final int f15488b;

    /* renamed from: c  reason: collision with root package name */
    private final int f15489c;

    private Dependency(Class<?> cls, int i8, int i9) {
        this.f15487a = (Class) Preconditions.c(cls, "Null dependency anInterface.");
        this.f15488b = i8;
        this.f15489c = i9;
    }

    public static Dependency a(Class<?> cls) {
        return new Dependency(cls, 0, 2);
    }

    private static String b(int i8) {
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 == 2) {
                    return "deferred";
                }
                throw new AssertionError("Unsupported injection: " + i8);
            }
            return "provider";
        }
        return "direct";
    }

    @Deprecated
    public static Dependency h(Class<?> cls) {
        return new Dependency(cls, 0, 0);
    }

    public static Dependency i(Class<?> cls) {
        return new Dependency(cls, 0, 1);
    }

    public static Dependency j(Class<?> cls) {
        return new Dependency(cls, 1, 0);
    }

    public static Dependency k(Class<?> cls) {
        return new Dependency(cls, 1, 1);
    }

    public static Dependency l(Class<?> cls) {
        return new Dependency(cls, 2, 0);
    }

    public Class<?> c() {
        return this.f15487a;
    }

    public boolean d() {
        if (this.f15489c == 2) {
            return true;
        }
        return false;
    }

    public boolean e() {
        if (this.f15489c == 0) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Dependency)) {
            return false;
        }
        Dependency dependency = (Dependency) obj;
        if (this.f15487a != dependency.f15487a || this.f15488b != dependency.f15488b || this.f15489c != dependency.f15489c) {
            return false;
        }
        return true;
    }

    public boolean f() {
        if (this.f15488b == 1) {
            return true;
        }
        return false;
    }

    public boolean g() {
        if (this.f15488b == 2) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f15487a.hashCode() ^ 1000003) * 1000003) ^ this.f15488b) * 1000003) ^ this.f15489c;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.f15487a);
        sb.append(", type=");
        int i8 = this.f15488b;
        if (i8 == 1) {
            str = "required";
        } else if (i8 == 0) {
            str = "optional";
        } else {
            str = "set";
        }
        sb.append(str);
        sb.append(", injection=");
        sb.append(b(this.f15489c));
        sb.append("}");
        return sb.toString();
    }
}
