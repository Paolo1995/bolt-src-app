package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.yalantis.ucrop.view.CropImageView;

/* loaded from: classes.dex */
public abstract class AutoScrollHelper implements View.OnTouchListener {

    /* renamed from: w  reason: collision with root package name */
    private static final int f6086w = ViewConfiguration.getTapTimeout();

    /* renamed from: h  reason: collision with root package name */
    final View f6089h;

    /* renamed from: i  reason: collision with root package name */
    private Runnable f6090i;

    /* renamed from: l  reason: collision with root package name */
    private int f6093l;

    /* renamed from: m  reason: collision with root package name */
    private int f6094m;

    /* renamed from: q  reason: collision with root package name */
    private boolean f6098q;

    /* renamed from: r  reason: collision with root package name */
    boolean f6099r;

    /* renamed from: s  reason: collision with root package name */
    boolean f6100s;

    /* renamed from: t  reason: collision with root package name */
    boolean f6101t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f6102u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f6103v;

    /* renamed from: f  reason: collision with root package name */
    final ClampedScroller f6087f = new ClampedScroller();

    /* renamed from: g  reason: collision with root package name */
    private final Interpolator f6088g = new AccelerateInterpolator();

    /* renamed from: j  reason: collision with root package name */
    private float[] f6091j = {0.0f, 0.0f};

    /* renamed from: k  reason: collision with root package name */
    private float[] f6092k = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: n  reason: collision with root package name */
    private float[] f6095n = {0.0f, 0.0f};

    /* renamed from: o  reason: collision with root package name */
    private float[] f6096o = {0.0f, 0.0f};

    /* renamed from: p  reason: collision with root package name */
    private float[] f6097p = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ClampedScroller {

        /* renamed from: a  reason: collision with root package name */
        private int f6104a;

        /* renamed from: b  reason: collision with root package name */
        private int f6105b;

        /* renamed from: c  reason: collision with root package name */
        private float f6106c;

        /* renamed from: d  reason: collision with root package name */
        private float f6107d;

        /* renamed from: j  reason: collision with root package name */
        private float f6113j;

        /* renamed from: k  reason: collision with root package name */
        private int f6114k;

        /* renamed from: e  reason: collision with root package name */
        private long f6108e = Long.MIN_VALUE;

        /* renamed from: i  reason: collision with root package name */
        private long f6112i = -1;

        /* renamed from: f  reason: collision with root package name */
        private long f6109f = 0;

        /* renamed from: g  reason: collision with root package name */
        private int f6110g = 0;

        /* renamed from: h  reason: collision with root package name */
        private int f6111h = 0;

        ClampedScroller() {
        }

        private float e(long j8) {
            long j9 = this.f6108e;
            if (j8 < j9) {
                return 0.0f;
            }
            long j10 = this.f6112i;
            if (j10 >= 0 && j8 >= j10) {
                float f8 = this.f6113j;
                return (1.0f - f8) + (f8 * AutoScrollHelper.e(((float) (j8 - j10)) / this.f6114k, 0.0f, 1.0f));
            }
            return AutoScrollHelper.e(((float) (j8 - j9)) / this.f6104a, 0.0f, 1.0f) * 0.5f;
        }

        private float g(float f8) {
            return ((-4.0f) * f8 * f8) + (f8 * 4.0f);
        }

        public void a() {
            if (this.f6109f != 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float g8 = g(e(currentAnimationTimeMillis));
                this.f6109f = currentAnimationTimeMillis;
                float f8 = ((float) (currentAnimationTimeMillis - this.f6109f)) * g8;
                this.f6110g = (int) (this.f6106c * f8);
                this.f6111h = (int) (f8 * this.f6107d);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        public int b() {
            return this.f6110g;
        }

        public int c() {
            return this.f6111h;
        }

        public int d() {
            float f8 = this.f6106c;
            return (int) (f8 / Math.abs(f8));
        }

        public int f() {
            float f8 = this.f6107d;
            return (int) (f8 / Math.abs(f8));
        }

        public boolean h() {
            if (this.f6112i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f6112i + this.f6114k) {
                return true;
            }
            return false;
        }

        public void i() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f6114k = AutoScrollHelper.f((int) (currentAnimationTimeMillis - this.f6108e), 0, this.f6105b);
            this.f6113j = e(currentAnimationTimeMillis);
            this.f6112i = currentAnimationTimeMillis;
        }

        public void j(int i8) {
            this.f6105b = i8;
        }

        public void k(int i8) {
            this.f6104a = i8;
        }

        public void l(float f8, float f9) {
            this.f6106c = f8;
            this.f6107d = f9;
        }

        public void m() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f6108e = currentAnimationTimeMillis;
            this.f6112i = -1L;
            this.f6109f = currentAnimationTimeMillis;
            this.f6113j = 0.5f;
            this.f6110g = 0;
            this.f6111h = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ScrollAnimationRunnable implements Runnable {
        ScrollAnimationRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AutoScrollHelper autoScrollHelper = AutoScrollHelper.this;
            if (!autoScrollHelper.f6101t) {
                return;
            }
            if (autoScrollHelper.f6099r) {
                autoScrollHelper.f6099r = false;
                autoScrollHelper.f6087f.m();
            }
            ClampedScroller clampedScroller = AutoScrollHelper.this.f6087f;
            if (!clampedScroller.h() && AutoScrollHelper.this.u()) {
                AutoScrollHelper autoScrollHelper2 = AutoScrollHelper.this;
                if (autoScrollHelper2.f6100s) {
                    autoScrollHelper2.f6100s = false;
                    autoScrollHelper2.c();
                }
                clampedScroller.a();
                AutoScrollHelper.this.j(clampedScroller.b(), clampedScroller.c());
                ViewCompat.k0(AutoScrollHelper.this.f6089h, this);
                return;
            }
            AutoScrollHelper.this.f6101t = false;
        }
    }

    public AutoScrollHelper(@NonNull View view) {
        this.f6089h = view;
        float f8 = Resources.getSystem().getDisplayMetrics().density;
        float f9 = (int) ((1575.0f * f8) + 0.5f);
        o(f9, f9);
        float f10 = (int) ((f8 * 315.0f) + 0.5f);
        p(f10, f10);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(f6086w);
        r(CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION);
        q(CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION);
    }

    private float d(int i8, float f8, float f9, float f10) {
        float h8 = h(this.f6091j[i8], f9, this.f6092k[i8], f8);
        int i9 = (h8 > 0.0f ? 1 : (h8 == 0.0f ? 0 : -1));
        if (i9 == 0) {
            return 0.0f;
        }
        float f11 = this.f6095n[i8];
        float f12 = this.f6096o[i8];
        float f13 = this.f6097p[i8];
        float f14 = f11 * f10;
        if (i9 > 0) {
            return e(h8 * f14, f12, f13);
        }
        return -e((-h8) * f14, f12, f13);
    }

    static float e(float f8, float f9, float f10) {
        return f8 > f10 ? f10 : f8 < f9 ? f9 : f8;
    }

    static int f(int i8, int i9, int i10) {
        return i8 > i10 ? i10 : i8 < i9 ? i9 : i8;
    }

    private float g(float f8, float f9) {
        if (f9 == 0.0f) {
            return 0.0f;
        }
        int i8 = this.f6093l;
        if (i8 != 0 && i8 != 1) {
            if (i8 == 2 && f8 < 0.0f) {
                return f8 / (-f9);
            }
        } else if (f8 < f9) {
            if (f8 >= 0.0f) {
                return 1.0f - (f8 / f9);
            }
            if (this.f6101t && i8 == 1) {
                return 1.0f;
            }
        }
        return 0.0f;
    }

    private float h(float f8, float f9, float f10, float f11) {
        float interpolation;
        float e8 = e(f8 * f9, 0.0f, f10);
        float g8 = g(f9 - f11, e8) - g(f11, e8);
        if (g8 < 0.0f) {
            interpolation = -this.f6088g.getInterpolation(-g8);
        } else if (g8 <= 0.0f) {
            return 0.0f;
        } else {
            interpolation = this.f6088g.getInterpolation(g8);
        }
        return e(interpolation, -1.0f, 1.0f);
    }

    private void i() {
        if (this.f6099r) {
            this.f6101t = false;
        } else {
            this.f6087f.i();
        }
    }

    private void v() {
        int i8;
        if (this.f6090i == null) {
            this.f6090i = new ScrollAnimationRunnable();
        }
        this.f6101t = true;
        this.f6099r = true;
        if (!this.f6098q && (i8 = this.f6094m) > 0) {
            ViewCompat.l0(this.f6089h, this.f6090i, i8);
        } else {
            this.f6090i.run();
        }
        this.f6098q = true;
    }

    public abstract boolean a(int i8);

    public abstract boolean b(int i8);

    void c() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f6089h.onTouchEvent(obtain);
        obtain.recycle();
    }

    public abstract void j(int i8, int i9);

    @NonNull
    public AutoScrollHelper k(int i8) {
        this.f6094m = i8;
        return this;
    }

    @NonNull
    public AutoScrollHelper l(int i8) {
        this.f6093l = i8;
        return this;
    }

    public AutoScrollHelper m(boolean z7) {
        if (this.f6102u && !z7) {
            i();
        }
        this.f6102u = z7;
        return this;
    }

    @NonNull
    public AutoScrollHelper n(float f8, float f9) {
        float[] fArr = this.f6092k;
        fArr[0] = f8;
        fArr[1] = f9;
        return this;
    }

    @NonNull
    public AutoScrollHelper o(float f8, float f9) {
        float[] fArr = this.f6097p;
        fArr[0] = f8 / 1000.0f;
        fArr[1] = f9 / 1000.0f;
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
        if (r0 != 3) goto L12;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.f6102u
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r6 = 3
            if (r0 == r6) goto L16
            goto L58
        L16:
            r5.i()
            goto L58
        L1a:
            r5.f6100s = r2
            r5.f6098q = r1
        L1e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f6089h
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.d(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f6089h
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.d(r2, r7, r6, r3)
            androidx.core.widget.AutoScrollHelper$ClampedScroller r7 = r5.f6087f
            r7.l(r0, r6)
            boolean r6 = r5.f6101t
            if (r6 != 0) goto L58
            boolean r6 = r5.u()
            if (r6 == 0) goto L58
            r5.v()
        L58:
            boolean r6 = r5.f6103v
            if (r6 == 0) goto L61
            boolean r6 = r5.f6101t
            if (r6 == 0) goto L61
            r1 = 1
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.AutoScrollHelper.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @NonNull
    public AutoScrollHelper p(float f8, float f9) {
        float[] fArr = this.f6096o;
        fArr[0] = f8 / 1000.0f;
        fArr[1] = f9 / 1000.0f;
        return this;
    }

    @NonNull
    public AutoScrollHelper q(int i8) {
        this.f6087f.j(i8);
        return this;
    }

    @NonNull
    public AutoScrollHelper r(int i8) {
        this.f6087f.k(i8);
        return this;
    }

    @NonNull
    public AutoScrollHelper s(float f8, float f9) {
        float[] fArr = this.f6091j;
        fArr[0] = f8;
        fArr[1] = f9;
        return this;
    }

    @NonNull
    public AutoScrollHelper t(float f8, float f9) {
        float[] fArr = this.f6095n;
        fArr[0] = f8 / 1000.0f;
        fArr[1] = f9 / 1000.0f;
        return this;
    }

    boolean u() {
        ClampedScroller clampedScroller = this.f6087f;
        int f8 = clampedScroller.f();
        int d8 = clampedScroller.d();
        if ((f8 != 0 && b(f8)) || (d8 != 0 && a(d8))) {
            return true;
        }
        return false;
    }
}
