package ee.mtakso.driver.uicore.components.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import ee.mtakso.driver.uicore.R$styleable;
import ee.mtakso.driver.uicore.components.drawables.CircularWavesIndeterminateDrawable;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CircularWavingButton.kt */
/* loaded from: classes5.dex */
public final class CircularWavingButton extends AppCompatImageView {

    /* renamed from: m  reason: collision with root package name */
    public static final Companion f35399m = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final RectF f35400f;

    /* renamed from: g  reason: collision with root package name */
    private int f35401g;

    /* renamed from: h  reason: collision with root package name */
    private int f35402h;

    /* renamed from: i  reason: collision with root package name */
    private float f35403i;

    /* renamed from: j  reason: collision with root package name */
    private final Paint f35404j;

    /* renamed from: k  reason: collision with root package name */
    private final CircularWavesIndeterminateDrawable f35405k;

    /* renamed from: l  reason: collision with root package name */
    public Map<Integer, View> f35406l;

    /* compiled from: CircularWavingButton.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CircularWavingButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircularWavingButton(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.f35406l = new LinkedHashMap();
        this.f35400f = new RectF();
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        this.f35404j = paint;
        CircularWavesIndeterminateDrawable circularWavesIndeterminateDrawable = new CircularWavesIndeterminateDrawable();
        this.f35405k = circularWavesIndeterminateDrawable;
        setBackground(circularWavesIndeterminateDrawable);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.U);
        Intrinsics.e(obtainStyledAttributes, "context.obtainStyledAttr…ble.CircularWavingButton)");
        setBgColor(obtainStyledAttributes.getColor(R$styleable.f34618c0, 0));
        setBgBorderColor(obtainStyledAttributes.getColor(R$styleable.f34608a0, 0));
        setBgBorderWidth(obtainStyledAttributes.getDimension(R$styleable.f34613b0, 0.0f));
        circularWavesIndeterminateDrawable.k(obtainStyledAttributes.getFloat(R$styleable.f34633f0, 1.0f));
        circularWavesIndeterminateDrawable.m(obtainStyledAttributes.getInt(R$styleable.f34643h0, 0));
        circularWavesIndeterminateDrawable.n(obtainStyledAttributes.getFloat(R$styleable.f34648i0, 0.0f));
        circularWavesIndeterminateDrawable.l(obtainStyledAttributes.getColor(R$styleable.f34638g0, 0));
        circularWavesIndeterminateDrawable.i(obtainStyledAttributes.getInt(R$styleable.f34623d0, 0));
        circularWavesIndeterminateDrawable.j(obtainStyledAttributes.getInt(R$styleable.f34628e0, 0));
        if (!obtainStyledAttributes.hasValue(R$styleable.V) && !obtainStyledAttributes.hasValue(R$styleable.Y) && !obtainStyledAttributes.hasValue(R$styleable.Z) && !obtainStyledAttributes.hasValue(R$styleable.W) && !obtainStyledAttributes.hasValue(R$styleable.X)) {
            super.setPadding(Dimens.d(18), Dimens.d(18), Dimens.d(18), Dimens.d(18));
        }
        obtainStyledAttributes.recycle();
    }

    public final void c() {
        this.f35405k.stop();
    }

    public final boolean d() {
        return this.f35405k.isRunning();
    }

    public final void e() {
        ViewExtKt.a(this);
        this.f35405k.start();
    }

    public final int getBgBorderColor() {
        return this.f35402h;
    }

    public final float getBgBorderWidth() {
        return this.f35403i;
    }

    public final int getBgColor() {
        return this.f35401g;
    }

    public final long getDelayBetweenCycles() {
        return this.f35405k.b();
    }

    public final long getDelayBetweenWaves() {
        return this.f35405k.c();
    }

    public final long getOverallAnimationDuration() {
        return this.f35405k.d();
    }

    public final int getWavesColor() {
        return this.f35405k.e();
    }

    public final int getWavesCount() {
        return this.f35405k.f();
    }

    public final float getWavesMaxRadius() {
        return this.f35405k.g();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z7;
        float min = Math.min(getHeight(), getWidth()) / 2.0f;
        if (this.f35402h != 0) {
            if (this.f35403i == 0.0f) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                this.f35404j.setStyle(Paint.Style.STROKE);
                this.f35404j.setColor(this.f35402h);
                this.f35404j.setStrokeWidth(this.f35403i);
                if (canvas != null) {
                    canvas.drawCircle(this.f35400f.centerX(), this.f35400f.centerY(), min - (this.f35403i / 2.0f), this.f35404j);
                }
            }
        }
        this.f35404j.setStyle(Paint.Style.FILL);
        this.f35404j.setColor(this.f35401g);
        if (canvas != null) {
            canvas.drawCircle(this.f35400f.centerX(), this.f35400f.centerY(), min - this.f35403i, this.f35404j);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        this.f35400f.set(0.0f, 0.0f, i8, i9);
    }

    public final void setBgBorderColor(int i8) {
        this.f35402h = i8;
        invalidate();
    }

    public final void setBgBorderWidth(float f8) {
        this.f35403i = f8;
        invalidate();
    }

    public final void setBgColor(int i8) {
        this.f35401g = i8;
        invalidate();
    }

    public final void setDelayBetweenCycles(long j8) {
        this.f35405k.h(j8);
    }

    public final void setDelayBetweenWaves(long j8) {
        this.f35405k.i(j8);
    }

    public final void setOverallAnimationDuration(long j8) {
        this.f35405k.j(j8);
    }

    public final void setWavesColor(int i8) {
        this.f35405k.l(i8);
    }

    public final void setWavesCount(int i8) {
        this.f35405k.m(i8);
    }

    public final void setWavesMaxRadius(float f8) {
        this.f35405k.n(f8);
    }

    public /* synthetic */ CircularWavingButton(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }
}
