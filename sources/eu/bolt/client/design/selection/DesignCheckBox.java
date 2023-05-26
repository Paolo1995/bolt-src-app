package eu.bolt.client.design.selection;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Checkable;
import eu.bolt.client.design.selection.DesignCheckBox;
import eu.bolt.verification.R$color;
import eu.bolt.verification.sdk.internal.f2;
import eu.bolt.verification.sdk.internal.uq;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class DesignCheckBox extends View implements Checkable {
    public static final a D = new a(null);
    private int A;
    private boolean B;
    private boolean C;

    /* renamed from: f  reason: collision with root package name */
    private final Paint f40159f;

    /* renamed from: g  reason: collision with root package name */
    private Paint f40160g;

    /* renamed from: h  reason: collision with root package name */
    private final Paint f40161h;

    /* renamed from: i  reason: collision with root package name */
    private final Paint f40162i;

    /* renamed from: j  reason: collision with root package name */
    private final Point[] f40163j;

    /* renamed from: k  reason: collision with root package name */
    private final Point f40164k;

    /* renamed from: l  reason: collision with root package name */
    private final Path f40165l;

    /* renamed from: m  reason: collision with root package name */
    private final float f40166m;

    /* renamed from: n  reason: collision with root package name */
    private final int f40167n;

    /* renamed from: o  reason: collision with root package name */
    private float f40168o;

    /* renamed from: p  reason: collision with root package name */
    private float f40169p;

    /* renamed from: q  reason: collision with root package name */
    private float f40170q;

    /* renamed from: r  reason: collision with root package name */
    private float f40171r;

    /* renamed from: s  reason: collision with root package name */
    private float f40172s;

    /* renamed from: t  reason: collision with root package name */
    private long f40173t;

    /* renamed from: u  reason: collision with root package name */
    private float f40174u;

    /* renamed from: v  reason: collision with root package name */
    private float f40175v;

    /* renamed from: w  reason: collision with root package name */
    private int f40176w;

    /* renamed from: x  reason: collision with root package name */
    private int f40177x;

    /* renamed from: y  reason: collision with root package name */
    private int f40178y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f40179z;

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
    public DesignCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DesignCheckBox(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        this.f40159f = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.STROKE);
        this.f40161h = paint2;
        Paint paint3 = new Paint(1);
        paint3.setStyle(Paint.Style.FILL);
        this.f40162i = paint3;
        this.f40163j = new Point[]{new Point(), new Point(), new Point()};
        this.f40164k = new Point();
        this.f40165l = new Path();
        this.f40166m = f2.a(context, 4.0f);
        this.f40167n = f2.a(context, 25.0f);
        this.f40171r = 1.0f;
        this.f40172s = 1.0f;
        this.f40179z = true;
        int d8 = uq.d(this, R$color.F);
        this.f40173t = 200L;
        setBorderColor(uq.d(this, R$color.neutral_600));
        setCheckedColor(uq.d(this, R$color.green_500));
        setUnCheckedColor(uq.d(this, R$color.A));
        setBorderWidth(f2.a(context, 2.0f));
        this.f40174u = 0.0f;
        this.A = this.f40178y;
        setWillNotDraw(false);
        Paint paint4 = new Paint(1);
        paint4.setStyle(Paint.Style.STROKE);
        paint4.setStrokeCap(Paint.Cap.ROUND);
        paint4.setColor(d8);
        this.f40160g = paint4;
        if (isClickable()) {
            setOnClickListener(new View.OnClickListener() { // from class: t6.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DesignCheckBox.k(DesignCheckBox.this, view);
                }
            });
        }
    }

    public /* synthetic */ DesignCheckBox(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    private final void f() {
        postDelayed(new Runnable() { // from class: t6.e
            @Override // java.lang.Runnable
            public final void run() {
                DesignCheckBox.i(DesignCheckBox.this);
            }
        }, this.f40173t);
    }

    private final void g(Canvas canvas) {
        h(canvas, this.f40162i, this.f40164k.x);
        if (this.C) {
            n(canvas);
        }
    }

    private final void h(Canvas canvas, Paint paint, float f8) {
        if (this.f40179z) {
            Point point = this.f40164k;
            canvas.drawCircle(point.x, point.y, f8 * this.f40172s, paint);
            return;
        }
        float f9 = this.f40166m;
        canvas.drawRoundRect(1.0f, 1.0f, getWidth() - 1, getHeight() - 1, f9, f9, paint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(DesignCheckBox this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.C = true;
        this$0.postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(DesignCheckBox this$0, ValueAnimator animation) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.d(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.f40172s = ((Float) animatedValue).floatValue();
        this$0.postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(DesignCheckBox this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.toggle();
        this$0.C = false;
        this$0.f40170q = 0.0f;
        if (this$0.isChecked()) {
            this$0.s();
        } else {
            this$0.t();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x005f, code lost:
        if (r10 > r0) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void n(android.graphics.Canvas r10) {
        /*
            Method dump skipped, instructions count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.client.design.selection.DesignCheckBox.n(android.graphics.Canvas):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(DesignCheckBox this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(DesignCheckBox this$0, ValueAnimator animation) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.d(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.f40172s = ((Float) animatedValue).floatValue();
        this$0.postInvalidate();
    }

    private final void q() {
        this.C = true;
        this.f40172s = 1.0f;
        this.f40171r = isChecked() ? 0.0f : 1.0f;
        this.f40170q = isChecked() ? this.f40168o + this.f40169p : 0.0f;
    }

    private final void r(Canvas canvas) {
        if (Color.alpha(this.f40177x) > 0) {
            h(canvas, this.f40159f, this.f40164k.x * this.f40172s);
        }
        this.f40161h.setColor(this.f40178y);
        h(canvas, this.f40161h, this.f40164k.x - (this.f40161h.getStrokeWidth() / 2));
    }

    private final void s() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.8f, 1.0f);
        ofFloat.setDuration(this.f40173t);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: t6.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DesignCheckBox.j(DesignCheckBox.this, valueAnimator);
            }
        });
        ofFloat.start();
        f();
    }

    private final void t() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.8f, 1.0f);
        ofFloat.setDuration(this.f40173t);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: t6.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DesignCheckBox.p(DesignCheckBox.this, valueAnimator);
            }
        });
        ofFloat.start();
    }

    public final int getBorderColor() {
        return this.f40178y;
    }

    public final float getBorderWidth() {
        return this.f40175v;
    }

    public final int getCheckedColor() {
        return this.f40176w;
    }

    public final b getListener() {
        return null;
    }

    public final int getUnCheckedColor() {
        return this.f40177x;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.B;
    }

    public final void l(boolean z7, boolean z8) {
        if (!z8) {
            setChecked(z7);
            return;
        }
        this.C = false;
        this.B = z7;
        this.f40170q = 0.0f;
        if (z7) {
            s();
        } else {
            t();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    /* renamed from: m */
    public Bundle onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("KEY_INSTANCE_STATE", super.onSaveInstanceState());
        bundle.putBoolean("KEY_INSTANCE_STATE_CHECKED", isChecked());
        return bundle;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.f(canvas, "canvas");
        if (isChecked()) {
            g(canvas);
        } else {
            r(canvas);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        Point point;
        Point point2;
        float f8 = this.f40174u;
        if (f8 == 0.0f) {
            f8 = getMeasuredWidth() / 10.0f;
        }
        this.f40174u = f8;
        float measuredWidth = f8 > ((float) getMeasuredWidth()) / 5.0f ? getMeasuredWidth() / 5.0f : this.f40174u;
        this.f40174u = measuredWidth;
        if (measuredWidth < 3.0f) {
            measuredWidth = 3.0f;
        }
        this.f40174u = measuredWidth;
        this.f40164k.x = getMeasuredWidth() / 2;
        this.f40164k.y = getMeasuredHeight() / 2;
        float f9 = 30;
        this.f40163j[0].x = Math.round((getMeasuredWidth() / f9) * 9);
        this.f40163j[0].y = Math.round((getMeasuredHeight() / f9) * 15);
        this.f40163j[1].x = Math.round((getMeasuredWidth() / f9) * 13);
        float f10 = 20;
        this.f40163j[1].y = Math.round((getMeasuredHeight() / f9) * f10);
        this.f40163j[2].x = Math.round((getMeasuredWidth() / f9) * f10);
        this.f40163j[2].y = Math.round((getMeasuredHeight() / f9) * 11);
        Point[] pointArr = this.f40163j;
        int i12 = pointArr[1].x;
        Point point3 = pointArr[0];
        this.f40168o = (float) Math.hypot(i12 - point3.x, point.y - point3.y);
        Point[] pointArr2 = this.f40163j;
        int i13 = pointArr2[2].x;
        Point point4 = pointArr2[1];
        this.f40169p = (float) Math.hypot(i13 - point4.x, point2.y - point4.y);
        this.f40160g.setStrokeWidth(this.f40174u);
    }

    @Override // android.view.View
    protected void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        setMeasuredDimension(uq.e(this, i8, this.f40167n), uq.e(this, i9, this.f40167n));
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

    public final void setBorderColor(int i8) {
        this.f40161h.setColor(i8);
        this.f40178y = i8;
    }

    public final void setBorderWidth(float f8) {
        this.f40161h.setStrokeWidth(f8);
        this.f40175v = f8;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z7) {
        this.B = z7;
        q();
        invalidate();
    }

    public final void setCheckedColor(int i8) {
        this.f40162i.setColor(i8);
        this.f40176w = i8;
    }

    public final void setCircle(boolean z7) {
        this.f40179z = z7;
    }

    @Override // android.view.View
    public void setEnabled(boolean z7) {
        super.setEnabled(z7);
        setAlpha(z7 ? 1.0f : 0.3f);
    }

    public final void setListener(b bVar) {
    }

    public final void setUnCheckedColor(int i8) {
        this.f40159f.setColor(i8);
        this.f40177x = i8;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }
}
