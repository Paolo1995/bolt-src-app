package ee.mtakso.driver.uikit.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import ee.mtakso.driver.uikit.R$style;
import ee.mtakso.driver.uikit.R$styleable;
import ee.mtakso.driver.uikit.utils.Dimens;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomCheckBox.kt */
/* loaded from: classes5.dex */
public final class CustomCheckBox extends View implements Checkable {

    /* renamed from: z  reason: collision with root package name */
    public static final Companion f36098z = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private Paint f36099f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f36100g;

    /* renamed from: h  reason: collision with root package name */
    private final Paint f36101h;

    /* renamed from: i  reason: collision with root package name */
    private final Point[] f36102i;

    /* renamed from: j  reason: collision with root package name */
    private final Path f36103j;

    /* renamed from: k  reason: collision with root package name */
    private final int f36104k;

    /* renamed from: l  reason: collision with root package name */
    private float f36105l;

    /* renamed from: m  reason: collision with root package name */
    private float f36106m;

    /* renamed from: n  reason: collision with root package name */
    private float f36107n;

    /* renamed from: o  reason: collision with root package name */
    private float f36108o;

    /* renamed from: p  reason: collision with root package name */
    private float f36109p;

    /* renamed from: q  reason: collision with root package name */
    private int f36110q;

    /* renamed from: r  reason: collision with root package name */
    private int f36111r;

    /* renamed from: s  reason: collision with root package name */
    private int f36112s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f36113t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f36114u;

    /* renamed from: v  reason: collision with root package name */
    private OnCheckedChangeListener f36115v;

    /* renamed from: w  reason: collision with root package name */
    private final RectF f36116w;

    /* renamed from: x  reason: collision with root package name */
    private final RectF f36117x;

    /* renamed from: y  reason: collision with root package name */
    public Map<Integer, View> f36118y;

    /* compiled from: CustomCheckBox.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: CustomCheckBox.kt */
    /* loaded from: classes5.dex */
    public interface OnCheckedChangeListener {
        void a(CustomCheckBox customCheckBox, boolean z7);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomCheckBox(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.f36118y = new LinkedHashMap();
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        this.f36100g = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.FILL);
        this.f36101h = paint2;
        this.f36102i = new Point[]{new Point(), new Point(), new Point()};
        this.f36103j = new Path();
        this.f36104k = Dimens.c(25);
        this.f36116w = new RectF();
        this.f36117x = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Z, i8, R$style.Widget_UIKit_CustomCheckBox);
        Intrinsics.e(obtainStyledAttributes, "context.obtainStyledAttr…_CustomCheckBox\n        )");
        int color = obtainStyledAttributes.getColor(R$styleable.f35789c0, -1);
        setBorderColor(obtainStyledAttributes.getColor(R$styleable.f35779a0, this.f36111r));
        setCheckedColor(obtainStyledAttributes.getColor(R$styleable.f35784b0, this.f36110q));
        setBorderWidth(Dimens.b(2.0f));
        this.f36108o = 0.0f;
        this.f36112s = this.f36111r;
        setWillNotDraw(false);
        Paint paint3 = new Paint(1);
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeCap(Paint.Cap.ROUND);
        paint3.setColor(color);
        this.f36099f = paint3;
        setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.uikit.widgets.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomCheckBox.c(CustomCheckBox.this, view);
            }
        });
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(CustomCheckBox this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.toggle();
        this$0.f36114u = false;
        this$0.f36107n = 0.0f;
        if (this$0.isChecked()) {
            this$0.f36114u = true;
            this$0.postInvalidate();
        }
        OnCheckedChangeListener onCheckedChangeListener = this$0.f36115v;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.a(this$0, this$0.isChecked());
        }
    }

    private final void d(Canvas canvas) {
        if (!isChecked()) {
            this.f36100g.setColor(this.f36111r);
            canvas.drawRoundRect(this.f36116w, Dimens.b(4.0f), Dimens.b(4.0f), this.f36100g);
        }
    }

    private final void e(Canvas canvas) {
        if (isChecked()) {
            canvas.drawRoundRect(this.f36117x, Dimens.b(4.0f), Dimens.b(4.0f), this.f36101h);
        }
    }

    private final void f(Canvas canvas) {
        if (this.f36114u && isChecked()) {
            g(canvas);
        }
    }

    private final void g(Canvas canvas) {
        this.f36103j.reset();
        if (this.f36107n < this.f36105l) {
            float f8 = 3.0f;
            if (getMeasuredWidth() / 20.0f >= 3.0f) {
                f8 = getMeasuredWidth() / 20.0f;
            }
            float f9 = this.f36107n + f8;
            this.f36107n = f9;
            Point[] pointArr = this.f36102i;
            Point point = pointArr[0];
            int i8 = point.x;
            Point point2 = pointArr[1];
            float f10 = this.f36105l;
            int i9 = point.y;
            this.f36103j.moveTo(i8, i9);
            this.f36103j.lineTo(i8 + (((point2.x - i8) * f9) / f10), i9 + (((point2.y - i9) * f9) / f10));
            canvas.drawPath(this.f36103j, this.f36099f);
            float f11 = this.f36107n;
            float f12 = this.f36105l;
            if (f11 > f12) {
                this.f36107n = f12;
            }
        } else {
            Path path = this.f36103j;
            Point point3 = this.f36102i[0];
            path.moveTo(point3.x, point3.y);
            Path path2 = this.f36103j;
            Point point4 = this.f36102i[1];
            path2.lineTo(point4.x, point4.y);
            canvas.drawPath(this.f36103j, this.f36099f);
            float f13 = this.f36107n;
            float f14 = this.f36105l;
            float f15 = this.f36106m;
            if (f13 < f14 + f15) {
                Point[] pointArr2 = this.f36102i;
                Point point5 = pointArr2[1];
                int i10 = point5.x;
                Point point6 = pointArr2[2];
                float f16 = i10 + (((point6.x - i10) * (f13 - f14)) / f15);
                int i11 = point5.y;
                this.f36103j.reset();
                Path path3 = this.f36103j;
                Point point7 = this.f36102i[1];
                path3.moveTo(point7.x, point7.y);
                this.f36103j.lineTo(f16, i11 - (((i11 - point6.y) * (f13 - f14)) / f15));
                canvas.drawPath(this.f36103j, this.f36099f);
                int i12 = 3;
                if (getMeasuredWidth() / 20 >= 3) {
                    i12 = getMeasuredWidth() / 20;
                }
                this.f36107n += i12;
            } else {
                this.f36103j.reset();
                Path path4 = this.f36103j;
                Point point8 = this.f36102i[1];
                path4.moveTo(point8.x, point8.y);
                Path path5 = this.f36103j;
                Point point9 = this.f36102i[2];
                path5.lineTo(point9.x, point9.y);
                canvas.drawPath(this.f36103j, this.f36099f);
            }
        }
        if (this.f36107n < this.f36105l + this.f36106m) {
            postDelayed(new Runnable() { // from class: ee.mtakso.driver.uikit.widgets.c
                @Override // java.lang.Runnable
                public final void run() {
                    CustomCheckBox.h(CustomCheckBox.this);
                }
            }, 10L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(CustomCheckBox this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.postInvalidate();
    }

    private final int i(int i8) {
        int size = View.MeasureSpec.getSize(i8);
        int mode = View.MeasureSpec.getMode(i8);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode != 1073741824) {
                    return 0;
                }
                return size;
            }
            return this.f36104k;
        }
        return Math.min(this.f36104k, size);
    }

    private final void k() {
        float f8;
        this.f36114u = true;
        if (isChecked()) {
            f8 = this.f36105l + this.f36106m;
        } else {
            f8 = 0.0f;
        }
        this.f36107n = f8;
    }

    private final void l() {
        float f8 = 2;
        this.f36116w.top = this.f36100g.getStrokeWidth() / f8;
        this.f36116w.left = this.f36100g.getStrokeWidth() / f8;
        this.f36116w.right = getMeasuredWidth() - (this.f36100g.getStrokeWidth() / f8);
        this.f36116w.bottom = getMeasuredHeight() - (this.f36100g.getStrokeWidth() / f8);
        RectF rectF = this.f36117x;
        rectF.top = 0.0f;
        rectF.left = 0.0f;
        rectF.right = getMeasuredWidth();
        this.f36117x.bottom = getMeasuredHeight();
    }

    public final int getBorderColor() {
        return this.f36111r;
    }

    public final float getBorderWidth() {
        return this.f36109p;
    }

    public final int getCheckedColor() {
        return this.f36110q;
    }

    public final OnCheckedChangeListener getListener() {
        return this.f36115v;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f36113t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    /* renamed from: j */
    public Bundle onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("KEY_INSTANCE_STATE", super.onSaveInstanceState());
        bundle.putBoolean("KEY_INSTANCE_STATE_CHECKED", isChecked());
        return bundle;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.f(canvas, "canvas");
        d(canvas);
        e(canvas);
        f(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        boolean z8;
        float f8;
        float f9 = this.f36108o;
        if (f9 == 0.0f) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8) {
            f9 = getMeasuredWidth() / 10.0f;
        }
        this.f36108o = f9;
        if (f9 > getMeasuredWidth() / 5.0f) {
            f8 = getMeasuredWidth() / 5.0f;
        } else {
            f8 = this.f36108o;
        }
        this.f36108o = f8;
        if (f8 < 3.0f) {
            f8 = 3.0f;
        }
        this.f36108o = f8;
        l();
        this.f36102i[0].x = (int) Math.round(getMeasuredWidth() * 0.27d);
        this.f36102i[0].y = (int) Math.round(getMeasuredHeight() * 0.55d);
        this.f36102i[1].x = (int) Math.round(getMeasuredWidth() * 0.42d);
        this.f36102i[1].y = (int) Math.round(getMeasuredHeight() * 0.7d);
        this.f36102i[2].x = (int) Math.round(getMeasuredWidth() * 0.73d);
        this.f36102i[2].y = (int) Math.round(getMeasuredHeight() * 0.35d);
        Point[] pointArr = this.f36102i;
        Point point = pointArr[1];
        int i12 = point.x;
        Point point2 = pointArr[0];
        this.f36105l = (float) Math.hypot(i12 - point2.x, point.y - point2.y);
        Point[] pointArr2 = this.f36102i;
        Point point3 = pointArr2[2];
        int i13 = point3.x;
        Point point4 = pointArr2[1];
        this.f36106m = (float) Math.hypot(i13 - point4.x, point3.y - point4.y);
        this.f36099f.setStrokeWidth(this.f36108o);
    }

    @Override // android.view.View
    protected void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        setMeasuredDimension(i(i8), i(i9));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable state) {
        Intrinsics.f(state, "state");
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            setChecked(bundle.getBoolean("KEY_INSTANCE_STATE_CHECKED"));
            super.onRestoreInstanceState(bundle.getParcelable("KEY_INSTANCE_STATE"));
            return;
        }
        super.onRestoreInstanceState(state);
    }

    public final void setBorderColor(int i8) {
        this.f36100g.setColor(i8);
        this.f36111r = i8;
    }

    public final void setBorderWidth(float f8) {
        this.f36100g.setStrokeWidth(f8);
        this.f36109p = f8;
        l();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z7) {
        this.f36113t = z7;
        k();
        invalidate();
    }

    public final void setCheckedColor(int i8) {
        this.f36101h.setColor(i8);
        this.f36110q = i8;
    }

    public final void setListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.f36115v = onCheckedChangeListener;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
        OnCheckedChangeListener onCheckedChangeListener = this.f36115v;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.a(this, isChecked());
        }
    }

    public /* synthetic */ CustomCheckBox(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }
}
