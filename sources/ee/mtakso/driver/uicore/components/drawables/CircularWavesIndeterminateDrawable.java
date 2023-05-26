package ee.mtakso.driver.uicore.components.drawables;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.AccelerateDecelerateInterpolator;
import ee.mtakso.driver.uicore.components.animation.DelayedAnimatorLooper;
import ee.mtakso.driver.uicore.components.drawables.CircularWavesIndeterminateDrawable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CircularWavesIndeterminateDrawable.kt */
/* loaded from: classes5.dex */
public final class CircularWavesIndeterminateDrawable extends Drawable implements Animatable {

    /* renamed from: f  reason: collision with root package name */
    private final Paint f34789f;

    /* renamed from: g  reason: collision with root package name */
    private int f34790g;

    /* renamed from: h  reason: collision with root package name */
    private float f34791h;

    /* renamed from: i  reason: collision with root package name */
    private int f34792i;

    /* renamed from: j  reason: collision with root package name */
    private float f34793j;

    /* renamed from: k  reason: collision with root package name */
    private long f34794k;

    /* renamed from: l  reason: collision with root package name */
    private long f34795l;

    /* renamed from: m  reason: collision with root package name */
    private long f34796m;

    /* renamed from: n  reason: collision with root package name */
    private AnimatorSet f34797n;

    /* renamed from: o  reason: collision with root package name */
    private final List<WaveInfo> f34798o;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CircularWavesIndeterminateDrawable.kt */
    /* loaded from: classes5.dex */
    public static final class WaveInfo {

        /* renamed from: a  reason: collision with root package name */
        private float f34799a;

        /* renamed from: b  reason: collision with root package name */
        private float f34800b;

        public WaveInfo(float f8, float f9) {
            this.f34799a = f8;
            this.f34800b = f9;
        }

        public final float a() {
            return this.f34800b;
        }

        public final float b() {
            return this.f34799a;
        }

        public final void c(float f8) {
            this.f34800b = f8;
        }

        public final void d(float f8) {
            this.f34799a = f8;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof WaveInfo) {
                WaveInfo waveInfo = (WaveInfo) obj;
                return Float.compare(this.f34799a, waveInfo.f34799a) == 0 && Float.compare(this.f34800b, waveInfo.f34800b) == 0;
            }
            return false;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f34799a) * 31) + Float.floatToIntBits(this.f34800b);
        }

        public String toString() {
            float f8 = this.f34799a;
            float f9 = this.f34800b;
            return "WaveInfo(size=" + f8 + ", progress=" + f9 + ")";
        }
    }

    public CircularWavesIndeterminateDrawable() {
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        this.f34789f = paint;
        this.f34791h = 1.0f;
        this.f34798o = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(WaveInfo capturedWave, CircularWavesIndeterminateDrawable this$0, ValueAnimator it) {
        Intrinsics.f(capturedWave, "$capturedWave");
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.d(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        capturedWave.c((floatValue - 1.0f) / (this$0.f34791h - 1.0f));
        capturedWave.d(floatValue);
        this$0.invalidateSelf();
    }

    public final long b() {
        return this.f34795l;
    }

    public final long c() {
        return this.f34794k;
    }

    public final long d() {
        return this.f34796m;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.f(canvas, "canvas");
        this.f34789f.setColor(this.f34792i);
        float min = Math.min(getBounds().width(), getBounds().height()) / 2.0f;
        int size = this.f34798o.size();
        for (int i8 = 0; i8 < size; i8++) {
            WaveInfo waveInfo = this.f34798o.get(i8);
            this.f34789f.setAlpha((int) ((1.0f - waveInfo.a()) * 255 * this.f34793j));
            canvas.drawCircle(getBounds().centerX(), getBounds().centerY(), waveInfo.b() * min, this.f34789f);
        }
    }

    public final int e() {
        return this.f34792i;
    }

    public final int f() {
        return this.f34790g;
    }

    public final float g() {
        return this.f34791h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    public final void h(long j8) {
        this.f34795l = j8;
        stop();
    }

    public final void i(long j8) {
        this.f34794k = j8;
        stop();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        AnimatorSet animatorSet = this.f34797n;
        if (animatorSet != null) {
            return animatorSet.isRunning();
        }
        return false;
    }

    public final void j(long j8) {
        this.f34796m = j8;
        stop();
    }

    public final void k(float f8) {
        this.f34793j = f8;
        invalidateSelf();
    }

    public final void l(int i8) {
        this.f34792i = i8;
        stop();
    }

    public final void m(int i8) {
        this.f34790g = i8;
        stop();
    }

    public final void n(float f8) {
        this.f34791h = f8;
        stop();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i8) {
        this.f34789f.setAlpha(i8);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f34789f.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        stop();
        long max = Math.max(this.f34796m, this.f34794k * (this.f34790g + 1));
        AnimatorSet animatorSet = new AnimatorSet();
        this.f34797n = animatorSet;
        animatorSet.addListener(new DelayedAnimatorLooper(this.f34795l));
        int i8 = this.f34790g;
        Animator[] animatorArr = new Animator[i8];
        for (int i9 = 0; i9 < i8; i9++) {
            animatorArr[i9] = null;
        }
        this.f34798o.clear();
        int i10 = this.f34790g;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f34798o.add(new WaveInfo(1.0f, 1.0f));
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, this.f34791h);
            final WaveInfo waveInfo = this.f34798o.get(i11);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ee.mtakso.driver.uicore.components.drawables.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CircularWavesIndeterminateDrawable.o(CircularWavesIndeterminateDrawable.WaveInfo.this, this, valueAnimator);
                }
            });
            long j8 = this.f34794k * i11;
            ofFloat.setStartDelay(j8);
            ofFloat.setDuration(max - j8);
            animatorArr[i11] = ofFloat;
        }
        AnimatorSet animatorSet2 = this.f34797n;
        if (animatorSet2 != null) {
            animatorSet2.setInterpolator(new AccelerateDecelerateInterpolator());
        }
        AnimatorSet animatorSet3 = this.f34797n;
        if (animatorSet3 != null) {
            animatorSet3.setDuration(max);
        }
        AnimatorSet animatorSet4 = this.f34797n;
        if (animatorSet4 != null) {
            animatorSet4.playTogether((Animator[]) Arrays.copyOf(animatorArr, i8));
        }
        AnimatorSet animatorSet5 = this.f34797n;
        if (animatorSet5 != null) {
            animatorSet5.start();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        AnimatorSet animatorSet = this.f34797n;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
        }
        AnimatorSet animatorSet2 = this.f34797n;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        this.f34798o.clear();
        invalidateSelf();
    }
}
