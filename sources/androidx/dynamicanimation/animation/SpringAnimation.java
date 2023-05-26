package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import androidx.dynamicanimation.animation.DynamicAnimation;

/* loaded from: classes.dex */
public final class SpringAnimation extends DynamicAnimation<SpringAnimation> {
    private SpringForce A;
    private float B;
    private boolean C;

    public <K> SpringAnimation(K k8, FloatPropertyCompat<K> floatPropertyCompat) {
        super(k8, floatPropertyCompat);
        this.A = null;
        this.B = Float.MAX_VALUE;
        this.C = false;
    }

    private void o() {
        SpringForce springForce = this.A;
        if (springForce != null) {
            double a8 = springForce.a();
            if (a8 <= this.f6276g) {
                if (a8 >= this.f6277h) {
                    return;
                }
                throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
            }
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public void i() {
        o();
        this.A.g(d());
        super.i();
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    boolean k(long j8) {
        if (this.C) {
            float f8 = this.B;
            if (f8 != Float.MAX_VALUE) {
                this.A.e(f8);
                this.B = Float.MAX_VALUE;
            }
            this.f6271b = this.A.a();
            this.f6270a = 0.0f;
            this.C = false;
            return true;
        }
        if (this.B != Float.MAX_VALUE) {
            this.A.a();
            long j9 = j8 / 2;
            DynamicAnimation.MassState h8 = this.A.h(this.f6271b, this.f6270a, j9);
            this.A.e(this.B);
            this.B = Float.MAX_VALUE;
            DynamicAnimation.MassState h9 = this.A.h(h8.f6282a, h8.f6283b, j9);
            this.f6271b = h9.f6282a;
            this.f6270a = h9.f6283b;
        } else {
            DynamicAnimation.MassState h10 = this.A.h(this.f6271b, this.f6270a, j8);
            this.f6271b = h10.f6282a;
            this.f6270a = h10.f6283b;
        }
        float max = Math.max(this.f6271b, this.f6277h);
        this.f6271b = max;
        float min = Math.min(max, this.f6276g);
        this.f6271b = min;
        if (!n(min, this.f6270a)) {
            return false;
        }
        this.f6271b = this.A.a();
        this.f6270a = 0.0f;
        return true;
    }

    public void l(float f8) {
        if (e()) {
            this.B = f8;
            return;
        }
        if (this.A == null) {
            this.A = new SpringForce(f8);
        }
        this.A.e(f8);
        i();
    }

    public boolean m() {
        if (this.A.f6286b > 0.0d) {
            return true;
        }
        return false;
    }

    boolean n(float f8, float f9) {
        return this.A.c(f8, f9);
    }

    public SpringAnimation p(SpringForce springForce) {
        this.A = springForce;
        return this;
    }

    public void q() {
        if (m()) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                if (this.f6275f) {
                    this.C = true;
                    return;
                }
                return;
            }
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
    }
}
