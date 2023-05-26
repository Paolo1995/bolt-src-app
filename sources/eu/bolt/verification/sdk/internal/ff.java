package eu.bolt.verification.sdk.internal;

/* loaded from: classes5.dex */
public final class ff {

    /* renamed from: a  reason: collision with root package name */
    private final int f42981a;

    /* renamed from: b  reason: collision with root package name */
    private final int f42982b;

    /* renamed from: c  reason: collision with root package name */
    private final int f42983c;

    /* renamed from: d  reason: collision with root package name */
    private final int f42984d;

    public ff(int i8, int i9, int i10, int i11) {
        this.f42981a = i8;
        this.f42982b = i9;
        this.f42983c = i10;
        this.f42984d = i11;
    }

    public final int a() {
        return this.f42982b;
    }

    public final int b() {
        return this.f42984d;
    }

    public final int c() {
        return this.f42981a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ff) {
            ff ffVar = (ff) obj;
            return this.f42981a == ffVar.f42981a && this.f42982b == ffVar.f42982b && this.f42983c == ffVar.f42983c && this.f42984d == ffVar.f42984d;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f42981a * 31) + this.f42982b) * 31) + this.f42983c) * 31) + this.f42984d;
    }

    public String toString() {
        int i8 = this.f42981a;
        int i9 = this.f42982b;
        int i10 = this.f42983c;
        int i11 = this.f42984d;
        return "PreviewConfig(topPreviewMargin=" + i8 + ", bottomPreviewMargin=" + i9 + ", screenWidth=" + i10 + ", cutoffRectVerticalOffset=" + i11 + ")";
    }
}
