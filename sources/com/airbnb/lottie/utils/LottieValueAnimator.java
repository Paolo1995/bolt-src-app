package com.airbnb.lottie.utils;

import android.view.Choreographer;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;

/* loaded from: classes.dex */
public class LottieValueAnimator extends BaseLottieAnimator implements Choreographer.FrameCallback {

    /* renamed from: o  reason: collision with root package name */
    private LottieComposition f9648o;

    /* renamed from: h  reason: collision with root package name */
    private float f9641h = 1.0f;

    /* renamed from: i  reason: collision with root package name */
    private boolean f9642i = false;

    /* renamed from: j  reason: collision with root package name */
    private long f9643j = 0;

    /* renamed from: k  reason: collision with root package name */
    private float f9644k = 0.0f;

    /* renamed from: l  reason: collision with root package name */
    private int f9645l = 0;

    /* renamed from: m  reason: collision with root package name */
    private float f9646m = -2.1474836E9f;

    /* renamed from: n  reason: collision with root package name */
    private float f9647n = 2.1474836E9f;

    /* renamed from: p  reason: collision with root package name */
    protected boolean f9649p = false;

    private void E() {
        if (this.f9648o == null) {
            return;
        }
        float f8 = this.f9644k;
        if (f8 >= this.f9646m && f8 <= this.f9647n) {
            return;
        }
        throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.f9646m), Float.valueOf(this.f9647n), Float.valueOf(this.f9644k)));
    }

    private float k() {
        LottieComposition lottieComposition = this.f9648o;
        if (lottieComposition == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / lottieComposition.i()) / Math.abs(this.f9641h);
    }

    private boolean o() {
        if (n() < 0.0f) {
            return true;
        }
        return false;
    }

    public void A(float f8) {
        B(this.f9646m, f8);
    }

    public void B(float f8, float f9) {
        float p8;
        float f10;
        if (f8 <= f9) {
            LottieComposition lottieComposition = this.f9648o;
            if (lottieComposition == null) {
                p8 = -3.4028235E38f;
            } else {
                p8 = lottieComposition.p();
            }
            LottieComposition lottieComposition2 = this.f9648o;
            if (lottieComposition2 == null) {
                f10 = Float.MAX_VALUE;
            } else {
                f10 = lottieComposition2.f();
            }
            float b8 = MiscUtils.b(f8, p8, f10);
            float b9 = MiscUtils.b(f9, p8, f10);
            if (b8 != this.f9646m || b9 != this.f9647n) {
                this.f9646m = b8;
                this.f9647n = b9;
                z((int) MiscUtils.b(this.f9644k, b8, b9));
                return;
            }
            return;
        }
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f8), Float.valueOf(f9)));
    }

    public void C(int i8) {
        B(i8, (int) this.f9647n);
    }

    public void D(float f8) {
        this.f9641h = f8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.utils.BaseLottieAnimator
    public void a() {
        super.a();
        b(o());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        a();
        s();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j8) {
        float m8;
        float l8;
        r();
        if (this.f9648o != null && isRunning()) {
            L.a("LottieValueAnimator#doFrame");
            long j9 = this.f9643j;
            long j10 = 0;
            if (j9 != 0) {
                j10 = j8 - j9;
            }
            float k8 = ((float) j10) / k();
            float f8 = this.f9644k;
            if (o()) {
                k8 = -k8;
            }
            float f9 = f8 + k8;
            this.f9644k = f9;
            boolean z7 = !MiscUtils.d(f9, m(), l());
            this.f9644k = MiscUtils.b(this.f9644k, m(), l());
            this.f9643j = j8;
            e();
            if (z7) {
                if (getRepeatCount() != -1 && this.f9645l >= getRepeatCount()) {
                    if (this.f9641h < 0.0f) {
                        l8 = m();
                    } else {
                        l8 = l();
                    }
                    this.f9644k = l8;
                    s();
                    b(o());
                } else {
                    c();
                    this.f9645l++;
                    if (getRepeatMode() == 2) {
                        this.f9642i = !this.f9642i;
                        v();
                    } else {
                        if (o()) {
                            m8 = l();
                        } else {
                            m8 = m();
                        }
                        this.f9644k = m8;
                    }
                    this.f9643j = j8;
                }
            }
            E();
            L.b("LottieValueAnimator#doFrame");
        }
    }

    public void f() {
        this.f9648o = null;
        this.f9646m = -2.1474836E9f;
        this.f9647n = 2.1474836E9f;
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        float m8;
        float l8;
        float m9;
        if (this.f9648o == null) {
            return 0.0f;
        }
        if (o()) {
            m8 = l() - this.f9644k;
            l8 = l();
            m9 = m();
        } else {
            m8 = this.f9644k - m();
            l8 = l();
            m9 = m();
        }
        return m8 / (l8 - m9);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(i());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        LottieComposition lottieComposition = this.f9648o;
        if (lottieComposition == null) {
            return 0L;
        }
        return lottieComposition.d();
    }

    public void h() {
        s();
        b(o());
    }

    public float i() {
        LottieComposition lottieComposition = this.f9648o;
        if (lottieComposition == null) {
            return 0.0f;
        }
        return (this.f9644k - lottieComposition.p()) / (this.f9648o.f() - this.f9648o.p());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f9649p;
    }

    public float j() {
        return this.f9644k;
    }

    public float l() {
        LottieComposition lottieComposition = this.f9648o;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f8 = this.f9647n;
        if (f8 == 2.1474836E9f) {
            return lottieComposition.f();
        }
        return f8;
    }

    public float m() {
        LottieComposition lottieComposition = this.f9648o;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f8 = this.f9646m;
        if (f8 == -2.1474836E9f) {
            return lottieComposition.p();
        }
        return f8;
    }

    public float n() {
        return this.f9641h;
    }

    public void p() {
        s();
    }

    public void q() {
        float m8;
        this.f9649p = true;
        d(o());
        if (o()) {
            m8 = l();
        } else {
            m8 = m();
        }
        z((int) m8);
        this.f9643j = 0L;
        this.f9645l = 0;
        r();
    }

    protected void r() {
        if (isRunning()) {
            t(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    protected void s() {
        t(true);
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i8) {
        super.setRepeatMode(i8);
        if (i8 != 2 && this.f9642i) {
            this.f9642i = false;
            v();
        }
    }

    protected void t(boolean z7) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z7) {
            this.f9649p = false;
        }
    }

    public void u() {
        this.f9649p = true;
        r();
        this.f9643j = 0L;
        if (o() && j() == m()) {
            this.f9644k = l();
        } else if (!o() && j() == l()) {
            this.f9644k = m();
        }
    }

    public void v() {
        D(-n());
    }

    public void x(LottieComposition lottieComposition) {
        boolean z7;
        if (this.f9648o == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.f9648o = lottieComposition;
        if (z7) {
            B(Math.max(this.f9646m, lottieComposition.p()), Math.min(this.f9647n, lottieComposition.f()));
        } else {
            B((int) lottieComposition.p(), (int) lottieComposition.f());
        }
        float f8 = this.f9644k;
        this.f9644k = 0.0f;
        z((int) f8);
        e();
    }

    public void z(float f8) {
        if (this.f9644k == f8) {
            return;
        }
        this.f9644k = MiscUtils.b(f8, m(), l());
        this.f9643j = 0L;
        e();
    }
}
