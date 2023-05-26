package androidx.dynamicanimation.animation;

import androidx.dynamicanimation.animation.DynamicAnimation;

/* loaded from: classes.dex */
public final class SpringForce {

    /* renamed from: a  reason: collision with root package name */
    double f6285a;

    /* renamed from: b  reason: collision with root package name */
    double f6286b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f6287c;

    /* renamed from: d  reason: collision with root package name */
    private double f6288d;

    /* renamed from: e  reason: collision with root package name */
    private double f6289e;

    /* renamed from: f  reason: collision with root package name */
    private double f6290f;

    /* renamed from: g  reason: collision with root package name */
    private double f6291g;

    /* renamed from: h  reason: collision with root package name */
    private double f6292h;

    /* renamed from: i  reason: collision with root package name */
    private double f6293i;

    /* renamed from: j  reason: collision with root package name */
    private final DynamicAnimation.MassState f6294j;

    public SpringForce() {
        this.f6285a = Math.sqrt(1500.0d);
        this.f6286b = 0.5d;
        this.f6287c = false;
        this.f6293i = Double.MAX_VALUE;
        this.f6294j = new DynamicAnimation.MassState();
    }

    private void b() {
        if (this.f6287c) {
            return;
        }
        if (this.f6293i != Double.MAX_VALUE) {
            double d8 = this.f6286b;
            if (d8 > 1.0d) {
                double d9 = this.f6285a;
                this.f6290f = ((-d8) * d9) + (d9 * Math.sqrt((d8 * d8) - 1.0d));
                double d10 = this.f6286b;
                double d11 = this.f6285a;
                this.f6291g = ((-d10) * d11) - (d11 * Math.sqrt((d10 * d10) - 1.0d));
            } else if (d8 >= 0.0d && d8 < 1.0d) {
                this.f6292h = this.f6285a * Math.sqrt(1.0d - (d8 * d8));
            }
            this.f6287c = true;
            return;
        }
        throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
    }

    public float a() {
        return (float) this.f6293i;
    }

    public boolean c(float f8, float f9) {
        if (Math.abs(f9) < this.f6289e && Math.abs(f8 - a()) < this.f6288d) {
            return true;
        }
        return false;
    }

    public SpringForce d(float f8) {
        if (f8 >= 0.0f) {
            this.f6286b = f8;
            this.f6287c = false;
            return this;
        }
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    public SpringForce e(float f8) {
        this.f6293i = f8;
        return this;
    }

    public SpringForce f(float f8) {
        if (f8 > 0.0f) {
            this.f6285a = Math.sqrt(f8);
            this.f6287c = false;
            return this;
        }
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(double d8) {
        double abs = Math.abs(d8);
        this.f6288d = abs;
        this.f6289e = abs * 62.5d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DynamicAnimation.MassState h(double d8, double d9, long j8) {
        double cos;
        double d10;
        b();
        double d11 = j8 / 1000.0d;
        double d12 = d8 - this.f6293i;
        double d13 = this.f6286b;
        if (d13 > 1.0d) {
            double d14 = this.f6291g;
            double d15 = this.f6290f;
            double d16 = d12 - (((d14 * d12) - d9) / (d14 - d15));
            double d17 = ((d12 * d14) - d9) / (d14 - d15);
            d10 = (Math.pow(2.718281828459045d, d14 * d11) * d16) + (Math.pow(2.718281828459045d, this.f6290f * d11) * d17);
            double d18 = this.f6291g;
            double pow = d16 * d18 * Math.pow(2.718281828459045d, d18 * d11);
            double d19 = this.f6290f;
            cos = pow + (d17 * d19 * Math.pow(2.718281828459045d, d19 * d11));
        } else if (d13 == 1.0d) {
            double d20 = this.f6285a;
            double d21 = d9 + (d20 * d12);
            double d22 = d12 + (d21 * d11);
            d10 = Math.pow(2.718281828459045d, (-d20) * d11) * d22;
            double pow2 = d22 * Math.pow(2.718281828459045d, (-this.f6285a) * d11);
            double d23 = this.f6285a;
            cos = (d21 * Math.pow(2.718281828459045d, (-d23) * d11)) + (pow2 * (-d23));
        } else {
            double d24 = 1.0d / this.f6292h;
            double d25 = this.f6285a;
            double d26 = d24 * ((d13 * d25 * d12) + d9);
            double pow3 = Math.pow(2.718281828459045d, (-d13) * d25 * d11) * ((Math.cos(this.f6292h * d11) * d12) + (Math.sin(this.f6292h * d11) * d26));
            double d27 = this.f6285a;
            double d28 = this.f6286b;
            double d29 = (-d27) * pow3 * d28;
            double pow4 = Math.pow(2.718281828459045d, (-d28) * d27 * d11);
            double d30 = this.f6292h;
            double sin = (-d30) * d12 * Math.sin(d30 * d11);
            double d31 = this.f6292h;
            cos = d29 + (pow4 * (sin + (d26 * d31 * Math.cos(d31 * d11))));
            d10 = pow3;
        }
        DynamicAnimation.MassState massState = this.f6294j;
        massState.f6282a = (float) (d10 + this.f6293i);
        massState.f6283b = (float) cos;
        return massState;
    }

    public SpringForce(float f8) {
        this.f6285a = Math.sqrt(1500.0d);
        this.f6286b = 0.5d;
        this.f6287c = false;
        this.f6293i = Double.MAX_VALUE;
        this.f6294j = new DynamicAnimation.MassState();
        this.f6293i = f8;
    }
}
