package eu.bolt.verification.sdk.internal;

/* loaded from: classes5.dex */
public enum n9 {
    NON_HIDEABLE(0),
    HIDEABLE_ONLY_VIA_API(1),
    HIDEABLE(2);
    

    /* renamed from: f  reason: collision with root package name */
    private int f44314f;

    n9(int i8) {
        this.f44314f = i8;
    }

    public static n9 c(int i8) {
        n9[] values;
        for (n9 n9Var : values()) {
            if (n9Var.f44314f == i8) {
                return n9Var;
            }
        }
        throw new IllegalArgumentException("Unknown attr id " + i8);
    }

    public int a() {
        return this.f44314f;
    }

    public boolean e() {
        return this == HIDEABLE || this == HIDEABLE_ONLY_VIA_API;
    }

    public boolean f() {
        return this == HIDEABLE;
    }
}
