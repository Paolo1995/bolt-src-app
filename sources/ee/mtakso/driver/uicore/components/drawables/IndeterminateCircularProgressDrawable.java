package ee.mtakso.driver.uicore.components.drawables;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import ee.mtakso.driver.uicore.components.drawables.IndeterminateCircularProgressDrawable;
import ee.mtakso.driver.uicore.utils.Dimens;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IndeterminateCircularProgressDrawable.kt */
/* loaded from: classes5.dex */
public final class IndeterminateCircularProgressDrawable extends Drawable implements Animatable {

    /* renamed from: n  reason: collision with root package name */
    private static final Companion f34801n = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final RectF f34802f = new RectF();

    /* renamed from: g  reason: collision with root package name */
    private final Path f34803g = new Path();

    /* renamed from: h  reason: collision with root package name */
    private final Paint f34804h;

    /* renamed from: i  reason: collision with root package name */
    private final AnimatorFactory f34805i;

    /* renamed from: j  reason: collision with root package name */
    private final Lazy f34806j;

    /* renamed from: k  reason: collision with root package name */
    private float f34807k;

    /* renamed from: l  reason: collision with root package name */
    private float f34808l;

    /* renamed from: m  reason: collision with root package name */
    private float f34809m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IndeterminateCircularProgressDrawable.kt */
    /* loaded from: classes5.dex */
    public final class AnimatorFactory {
        public AnimatorFactory() {
        }

        private final Interpolator e() {
            Path path = new Path();
            path.lineTo(0.5f, 0.1f);
            path.cubicTo(0.7f, 0.15f, 0.6f, 0.75f, 1.0f, 1.0f);
            Interpolator b8 = PathInterpolatorCompat.b(path);
            Intrinsics.e(b8, "create(path)");
            return b8;
        }

        private final ValueAnimator f() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
            final IndeterminateCircularProgressDrawable indeterminateCircularProgressDrawable = IndeterminateCircularProgressDrawable.this;
            ofFloat.setInterpolator(e());
            ofFloat.setDuration(1500L);
            ofFloat.setRepeatMode(1);
            ofFloat.setRepeatCount(-1);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ee.mtakso.driver.uicore.components.drawables.b
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    IndeterminateCircularProgressDrawable.AnimatorFactory.g(IndeterminateCircularProgressDrawable.this, valueAnimator);
                }
            });
            return ofFloat;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(IndeterminateCircularProgressDrawable this$0, ValueAnimator it) {
            Intrinsics.f(this$0, "this$0");
            Intrinsics.f(it, "it");
            Object animatedValue = it.getAnimatedValue();
            Intrinsics.d(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            this$0.k(((Float) animatedValue).floatValue());
        }

        private final ValueAnimator h() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 720.0f);
            final IndeterminateCircularProgressDrawable indeterminateCircularProgressDrawable = IndeterminateCircularProgressDrawable.this;
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.setDuration(4500L);
            ofFloat.setRepeatMode(1);
            ofFloat.setRepeatCount(-1);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ee.mtakso.driver.uicore.components.drawables.d
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    IndeterminateCircularProgressDrawable.AnimatorFactory.i(IndeterminateCircularProgressDrawable.this, valueAnimator);
                }
            });
            return ofFloat;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(IndeterminateCircularProgressDrawable this$0, ValueAnimator it) {
            Intrinsics.f(this$0, "this$0");
            Intrinsics.f(it, "it");
            Object animatedValue = it.getAnimatedValue();
            Intrinsics.d(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            this$0.l(((Float) animatedValue).floatValue());
        }

        private final Interpolator j() {
            Path path = new Path();
            path.cubicTo(0.3f, 0.0f, 0.1f, 0.75f, 0.5f, 0.85f);
            path.lineTo(1.0f, 1.0f);
            Interpolator b8 = PathInterpolatorCompat.b(path);
            Intrinsics.e(b8, "create(path)");
            return b8;
        }

        private final ValueAnimator k() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
            final IndeterminateCircularProgressDrawable indeterminateCircularProgressDrawable = IndeterminateCircularProgressDrawable.this;
            ofFloat.setInterpolator(j());
            ofFloat.setDuration(1500L);
            ofFloat.setRepeatMode(1);
            ofFloat.setRepeatCount(-1);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ee.mtakso.driver.uicore.components.drawables.c
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    IndeterminateCircularProgressDrawable.AnimatorFactory.l(IndeterminateCircularProgressDrawable.this, valueAnimator);
                }
            });
            return ofFloat;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void l(IndeterminateCircularProgressDrawable this$0, ValueAnimator it) {
            Intrinsics.f(this$0, "this$0");
            Intrinsics.f(it, "it");
            Object animatedValue = it.getAnimatedValue();
            Intrinsics.d(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            this$0.m(((Float) animatedValue).floatValue());
        }

        public final Animator d() {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(k(), f(), h());
            return animatorSet;
        }
    }

    /* compiled from: IndeterminateCircularProgressDrawable.kt */
    /* loaded from: classes5.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public IndeterminateCircularProgressDrawable() {
        Lazy b8;
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(10.0f);
        paint.setColor(-65536);
        this.f34804h = paint;
        this.f34805i = new AnimatorFactory();
        b8 = LazyKt__LazyJVMKt.b(new Function0<Animator>() { // from class: ee.mtakso.driver.uicore.components.drawables.IndeterminateCircularProgressDrawable$animator$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Animator invoke() {
                IndeterminateCircularProgressDrawable.AnimatorFactory animatorFactory;
                animatorFactory = IndeterminateCircularProgressDrawable.this.f34805i;
                return animatorFactory.d();
            }
        });
        this.f34806j = b8;
    }

    private final Animator e() {
        return (Animator) this.f34806j.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(float f8) {
        this.f34808l = f8;
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(float f8) {
        this.f34809m = f8;
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(float f8) {
        this.f34807k = f8;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.f(canvas, "canvas");
        this.f34803g.rewind();
        Path path = this.f34803g;
        RectF rectF = this.f34802f;
        float f8 = this.f34807k;
        path.addArc(rectF, this.f34809m + f8, this.f34808l - f8);
        canvas.drawPath(this.f34803g, this.f34804h);
    }

    public final int f() {
        return this.f34804h.getColor();
    }

    public final Paint.Cap g() {
        Paint.Cap strokeCap = this.f34804h.getStrokeCap();
        Intrinsics.e(strokeCap, "paint.strokeCap");
        return strokeCap;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return Dimens.d(48);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Dimens.d(48);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    public final float h() {
        return this.f34804h.getStrokeWidth();
    }

    public final void i(int i8) {
        this.f34804h.setColor(i8);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return e().isRunning();
    }

    public final void j(Paint.Cap value) {
        Intrinsics.f(value, "value");
        this.f34804h.setStrokeCap(value);
        invalidateSelf();
    }

    public final void n(float f8) {
        this.f34804h.setStrokeWidth(f8);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i8) {
        this.f34804h.setAlpha(i8);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i8, int i9, int i10, int i11) {
        super.setBounds(i8, i9, i10, i11);
        this.f34802f.set(i8 + (this.f34804h.getStrokeWidth() / 2.0f), i9 + (this.f34804h.getStrokeWidth() / 2.0f), i10 - (this.f34804h.getStrokeWidth() / 2.0f), i11 - (this.f34804h.getStrokeWidth() / 2.0f));
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f34804h.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        e().start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        e().end();
    }
}
