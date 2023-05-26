package eu.bolt.client.design.selection;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Checkable;
import eu.bolt.client.design.selection.DesignRadioButton;
import eu.bolt.verification.R$color;
import eu.bolt.verification.sdk.internal.f2;
import eu.bolt.verification.sdk.internal.uq;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class DesignRadioButton extends View implements Checkable {

    /* renamed from: o  reason: collision with root package name */
    public static final a f40180o = new a(null);

    /* renamed from: f  reason: collision with root package name */
    private final Paint f40181f;

    /* renamed from: g  reason: collision with root package name */
    private Paint f40182g;

    /* renamed from: h  reason: collision with root package name */
    private final Paint f40183h;

    /* renamed from: i  reason: collision with root package name */
    private final PointF f40184i;

    /* renamed from: j  reason: collision with root package name */
    private final int f40185j;

    /* renamed from: k  reason: collision with root package name */
    private float f40186k;

    /* renamed from: l  reason: collision with root package name */
    private float f40187l;

    /* renamed from: m  reason: collision with root package name */
    private final ValueAnimator f40188m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f40189n;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DesignRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DesignRadioButton(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(f2.i(context, 2.0f));
        paint.setColor(uq.d(this, R$color.content_tertiary));
        this.f40181f = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(uq.d(this, R$color.F));
        this.f40182g = paint2;
        Paint paint3 = new Paint(1);
        paint3.setStyle(Paint.Style.FILL);
        paint3.setColor(uq.d(this, R$color.green_500));
        this.f40183h = paint3;
        this.f40184i = new PointF();
        this.f40185j = f2.a(context, 24.0f);
        this.f40186k = 1.0f;
        this.f40187l = 0.4f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.8f, 1.0f);
        Intrinsics.e(ofFloat, "ofFloat(DEFAULT_SCALE, ANIM_SCALE, DEFAULT_SCALE)");
        this.f40188m = ofFloat;
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: t6.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DesignRadioButton.e(DesignRadioButton.this, valueAnimator);
            }
        });
        if (isClickable()) {
            setOnClickListener(new View.OnClickListener() { // from class: t6.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DesignRadioButton.f(DesignRadioButton.this, view);
                }
            });
        }
    }

    public /* synthetic */ DesignRadioButton(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    private final void d(Canvas canvas) {
        if (this.f40189n) {
            return;
        }
        float strokeWidth = this.f40184i.x - (this.f40181f.getStrokeWidth() / 2);
        PointF pointF = this.f40184i;
        canvas.drawCircle(pointF.x, pointF.y, strokeWidth * this.f40186k, this.f40181f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(DesignRadioButton this$0, ValueAnimator animation) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.d(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.f40186k = ((Float) animatedValue).floatValue();
        this$0.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(DesignRadioButton this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.toggle();
        this$0.i();
    }

    private final void g() {
        this.f40188m.cancel();
        this.f40186k = 1.0f;
    }

    private final void h(Canvas canvas) {
        if (this.f40189n) {
            PointF pointF = this.f40184i;
            float f8 = pointF.x;
            canvas.drawCircle(f8, pointF.y, this.f40186k * f8, this.f40183h);
        }
    }

    private final void i() {
        this.f40188m.cancel();
        this.f40188m.start();
    }

    private final void j(Canvas canvas) {
        if (this.f40189n) {
            PointF pointF = this.f40184i;
            float f8 = pointF.x;
            canvas.drawCircle(f8, pointF.y, this.f40186k * f8 * this.f40187l, this.f40182g);
        }
    }

    private final void setCheckedInternal(boolean z7) {
        this.f40189n = z7;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    /* renamed from: c */
    public Bundle onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("KEY_INSTANCE_STATE", super.onSaveInstanceState());
        bundle.putBoolean("KEY_INSTANCE_STATE_CHECKED", this.f40189n);
        return bundle;
    }

    public final b getListener() {
        return null;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f40189n;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.f(canvas, "canvas");
        d(canvas);
        h(canvas);
        j(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        setMeasuredDimension(uq.e(this, i8, this.f40185j), uq.e(this, i9, this.f40185j));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable state) {
        Intrinsics.f(state, "state");
        if (!(state instanceof Bundle)) {
            super.onRestoreInstanceState(state);
            return;
        }
        Bundle bundle = (Bundle) state;
        setChecked(bundle.getBoolean("KEY_INSTANCE_STATE_CHECKED"));
        super.onRestoreInstanceState(bundle.getParcelable("KEY_INSTANCE_STATE"));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        PointF pointF = this.f40184i;
        pointF.x = i8 / 2.0f;
        pointF.y = i9 / 2.0f;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z7) {
        if (this.f40189n == z7) {
            return;
        }
        setCheckedInternal(z7);
        g();
        invalidate();
    }

    public final void setCheckedAnimated(boolean z7) {
        if (this.f40189n == z7) {
            return;
        }
        setCheckedInternal(z7);
        i();
    }

    public final void setListener(b bVar) {
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f40189n);
    }
}
