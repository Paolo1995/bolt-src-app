package ee.mtakso.driver.uicore.components.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.math.MathUtils;
import ee.mtakso.driver.uicore.R$styleable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: AlphaAnimatedPlaceholderView.kt */
/* loaded from: classes5.dex */
public final class AlphaAnimatedPlaceholderView extends View {

    /* renamed from: f  reason: collision with root package name */
    private final RectF f35390f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f35391g;

    /* renamed from: h  reason: collision with root package name */
    private float f35392h;

    /* renamed from: i  reason: collision with root package name */
    private final int f35393i;

    /* renamed from: j  reason: collision with root package name */
    private final float f35394j;

    /* renamed from: k  reason: collision with root package name */
    private final float f35395k;

    /* renamed from: l  reason: collision with root package name */
    private final ValueAnimator.AnimatorUpdateListener f35396l;

    /* renamed from: m  reason: collision with root package name */
    private ValueAnimator f35397m;

    /* renamed from: n  reason: collision with root package name */
    public Map<Integer, View> f35398n;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AlphaAnimatedPlaceholderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlphaAnimatedPlaceholderView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.f35398n = new LinkedHashMap();
        this.f35390f = new RectF();
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f35391g = paint;
        this.f35396l = new ValueAnimator.AnimatorUpdateListener() { // from class: ee.mtakso.driver.uicore.components.views.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AlphaAnimatedPlaceholderView.c(AlphaAnimatedPlaceholderView.this, valueAnimator);
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f34642h);
        Intrinsics.e(obtainStyledAttributes, "context.obtainStyledAttr…aAnimatedPlaceholderView)");
        setForegroundColor(obtainStyledAttributes.getColor(R$styleable.f34652j, 0));
        this.f35393i = obtainStyledAttributes.getInt(R$styleable.f34647i, 250);
        setRoundRadius(obtainStyledAttributes.getDimension(R$styleable.f34667m, 0.0f));
        float f8 = obtainStyledAttributes.getFloat(R$styleable.f34662l, 0.0f);
        this.f35394j = f8;
        this.f35395k = obtainStyledAttributes.getFloat(R$styleable.f34657k, 1.0f);
        setAlpha(f8);
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(AlphaAnimatedPlaceholderView this$0, ValueAnimator it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.d(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.setAlpha(((Float) animatedValue).floatValue());
    }

    private final void d() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f35394j, this.f35395k);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ofFloat.addUpdateListener(this.f35396l);
        ofFloat.setDuration(this.f35393i);
        ofFloat.start();
        this.f35397m = ofFloat;
    }

    private final void e() {
        ValueAnimator valueAnimator = this.f35397m;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.f35397m;
        if (valueAnimator2 != null) {
            valueAnimator2.removeUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ee.mtakso.driver.uicore.components.views.b
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    AlphaAnimatedPlaceholderView.f(AlphaAnimatedPlaceholderView.this, valueAnimator3);
                }
            });
        }
        this.f35397m = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(AlphaAnimatedPlaceholderView this$0, ValueAnimator it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(it, "it");
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this$0.f35396l;
    }

    public final int getForegroundColor() {
        return this.f35391g.getColor();
    }

    public final float getRoundRadius() {
        float f8;
        float f9 = this.f35392h;
        f8 = RangesKt___RangesKt.f(this.f35390f.width(), this.f35390f.height());
        return MathUtils.a(f9, 0.0f, f8 / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (canvas != null) {
            canvas.drawRoundRect(this.f35390f, getRoundRadius(), getRoundRadius(), this.f35391g);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        this.f35390f.set(getPaddingLeft(), getPaddingTop(), i8 - getPaddingRight(), i9 - getPaddingBottom());
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View changedView, int i8) {
        Intrinsics.f(changedView, "changedView");
        super.onVisibilityChanged(changedView, i8);
        if (i8 == 0) {
            d();
        } else {
            e();
        }
    }

    public final void setForegroundColor(int i8) {
        this.f35391g.setColor(i8);
        invalidate();
    }

    public final void setRoundRadius(float f8) {
        this.f35392h = f8;
        invalidate();
    }

    public /* synthetic */ AlphaAnimatedPlaceholderView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }
}
