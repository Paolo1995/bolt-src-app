package ee.mtakso.driver.uicore.components.drawables;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;
import ee.mtakso.driver.uicore.components.drawables.AnimatedPathDrawable;
import ee.mtakso.driver.uicore.utils.Dimens;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimatedPathDrawable.kt */
/* loaded from: classes5.dex */
public final class AnimatedPathDrawable extends Drawable implements Animatable {

    /* renamed from: p  reason: collision with root package name */
    public static final Companion f34776p = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final Path f34777f;

    /* renamed from: g  reason: collision with root package name */
    private final int f34778g;

    /* renamed from: h  reason: collision with root package name */
    private final int f34779h;

    /* renamed from: i  reason: collision with root package name */
    private final int f34780i;

    /* renamed from: j  reason: collision with root package name */
    private final long f34781j;

    /* renamed from: k  reason: collision with root package name */
    private final RectF f34782k;

    /* renamed from: l  reason: collision with root package name */
    private final Paint f34783l;

    /* renamed from: m  reason: collision with root package name */
    private float f34784m;

    /* renamed from: n  reason: collision with root package name */
    private final AnimatorFactory f34785n;

    /* renamed from: o  reason: collision with root package name */
    private final Lazy f34786o;

    /* compiled from: AnimatedPathDrawable.kt */
    /* loaded from: classes5.dex */
    public final class AnimatorFactory {
        public AnimatorFactory() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(AnimatedPathDrawable this$0, ValueAnimator it) {
            Intrinsics.f(this$0, "this$0");
            Intrinsics.f(it, "it");
            Object animatedValue = it.getAnimatedValue();
            Intrinsics.d(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            this$0.e(((Float) animatedValue).floatValue());
        }

        public final ValueAnimator b() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            final AnimatedPathDrawable animatedPathDrawable = AnimatedPathDrawable.this;
            ofFloat.setDuration(animatedPathDrawable.f34781j);
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: p5.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AnimatedPathDrawable.AnimatorFactory.c(AnimatedPathDrawable.this, valueAnimator);
                }
            });
            Intrinsics.e(ofFloat, "ofFloat(0F, 1F).apply {\n…s\n            }\n        }");
            return ofFloat;
        }
    }

    /* compiled from: AnimatedPathDrawable.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AnimatedPathDrawable a(int i8) {
            Path path = new Path();
            path.moveTo(Dimens.c(3.4f), Dimens.c(13.4f));
            path.lineTo(Dimens.c(9.0f), Dimens.c(19.0f));
            path.lineTo(Dimens.c(21.0f), Dimens.c(7.0f));
            return new AnimatedPathDrawable(path, i8, Dimens.d(24), Dimens.d(24), 350L);
        }
    }

    public AnimatedPathDrawable(Path path, int i8, int i9, int i10, long j8) {
        Lazy b8;
        Intrinsics.f(path, "path");
        this.f34777f = path;
        this.f34778g = i8;
        this.f34779h = i9;
        this.f34780i = i10;
        this.f34781j = j8;
        this.f34782k = new RectF();
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(Dimens.c(2.0f));
        paint.setColor(i8);
        this.f34783l = paint;
        this.f34785n = new AnimatorFactory();
        b8 = LazyKt__LazyJVMKt.b(new Function0<ValueAnimator>() { // from class: ee.mtakso.driver.uicore.components.drawables.AnimatedPathDrawable$animator$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final ValueAnimator invoke() {
                AnimatedPathDrawable.AnimatorFactory animatorFactory;
                animatorFactory = AnimatedPathDrawable.this.f34785n;
                return animatorFactory.b();
            }
        });
        this.f34786o = b8;
    }

    private final ValueAnimator d() {
        return (ValueAnimator) this.f34786o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(float f8) {
        this.f34784m = f8;
        invalidateSelf();
    }

    private final Path f(Path path, float f8, float f9) {
        Path path2 = new Path();
        PathMeasure pathMeasure = new PathMeasure(path, false);
        pathMeasure.getSegment(f8 * pathMeasure.getLength(), f9 * pathMeasure.getLength(), path2, true);
        return path2;
    }

    static /* synthetic */ Path g(AnimatedPathDrawable animatedPathDrawable, Path path, float f8, float f9, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            f8 = 0.0f;
        }
        return animatedPathDrawable.f(path, f8, f9);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.f(canvas, "canvas");
        canvas.drawPath(g(this, this.f34777f, 0.0f, this.f34784m, 1, null), this.f34783l);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f34780i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f34779h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return d().isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i8) {
        this.f34783l.setAlpha(i8);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i8, int i9, int i10, int i11) {
        super.setBounds(i8, i9, i10, i11);
        this.f34782k.set(i8 + (this.f34783l.getStrokeWidth() / 2.0f), i9 + (this.f34783l.getStrokeWidth() / 2.0f), i10 - (this.f34783l.getStrokeWidth() / 2.0f), i11 - (this.f34783l.getStrokeWidth() / 2.0f));
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f34783l.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        d().start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        d().end();
    }
}
