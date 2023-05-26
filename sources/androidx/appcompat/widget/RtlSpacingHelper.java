package androidx.appcompat.widget;

/* loaded from: classes.dex */
class RtlSpacingHelper {

    /* renamed from: a  reason: collision with root package name */
    private int f2068a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f2069b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f2070c = Integer.MIN_VALUE;

    /* renamed from: d  reason: collision with root package name */
    private int f2071d = Integer.MIN_VALUE;

    /* renamed from: e  reason: collision with root package name */
    private int f2072e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f2073f = 0;

    /* renamed from: g  reason: collision with root package name */
    private boolean f2074g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f2075h = false;

    public int a() {
        if (this.f2074g) {
            return this.f2068a;
        }
        return this.f2069b;
    }

    public int b() {
        return this.f2068a;
    }

    public int c() {
        return this.f2069b;
    }

    public int d() {
        if (this.f2074g) {
            return this.f2069b;
        }
        return this.f2068a;
    }

    public void e(int i8, int i9) {
        this.f2075h = false;
        if (i8 != Integer.MIN_VALUE) {
            this.f2072e = i8;
            this.f2068a = i8;
        }
        if (i9 != Integer.MIN_VALUE) {
            this.f2073f = i9;
            this.f2069b = i9;
        }
    }

    public void f(boolean z7) {
        if (z7 == this.f2074g) {
            return;
        }
        this.f2074g = z7;
        if (this.f2075h) {
            if (z7) {
                int i8 = this.f2071d;
                if (i8 == Integer.MIN_VALUE) {
                    i8 = this.f2072e;
                }
                this.f2068a = i8;
                int i9 = this.f2070c;
                if (i9 == Integer.MIN_VALUE) {
                    i9 = this.f2073f;
                }
                this.f2069b = i9;
                return;
            }
            int i10 = this.f2070c;
            if (i10 == Integer.MIN_VALUE) {
                i10 = this.f2072e;
            }
            this.f2068a = i10;
            int i11 = this.f2071d;
            if (i11 == Integer.MIN_VALUE) {
                i11 = this.f2073f;
            }
            this.f2069b = i11;
            return;
        }
        this.f2068a = this.f2072e;
        this.f2069b = this.f2073f;
    }

    public void g(int i8, int i9) {
        this.f2070c = i8;
        this.f2071d = i9;
        this.f2075h = true;
        if (this.f2074g) {
            if (i9 != Integer.MIN_VALUE) {
                this.f2068a = i9;
            }
            if (i8 != Integer.MIN_VALUE) {
                this.f2069b = i8;
                return;
            }
            return;
        }
        if (i8 != Integer.MIN_VALUE) {
            this.f2068a = i8;
        }
        if (i9 != Integer.MIN_VALUE) {
            this.f2069b = i9;
        }
    }
}
