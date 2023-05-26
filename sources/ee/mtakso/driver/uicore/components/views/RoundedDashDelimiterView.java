package ee.mtakso.driver.uicore.components.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import ee.mtakso.driver.uicore.R$styleable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: RoundedDashDelimiter.kt */
/* loaded from: classes5.dex */
public final class RoundedDashDelimiterView extends View {

    /* renamed from: f  reason: collision with root package name */
    private final Paint f35482f;

    /* renamed from: g  reason: collision with root package name */
    private final Path f35483g;

    /* renamed from: h  reason: collision with root package name */
    private float f35484h;

    /* renamed from: i  reason: collision with root package name */
    private float f35485i;

    /* renamed from: j  reason: collision with root package name */
    private float f35486j;

    /* renamed from: k  reason: collision with root package name */
    private int f35487k;

    /* renamed from: l  reason: collision with root package name */
    public Map<Integer, View> f35488l;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundedDashDelimiterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundedDashDelimiterView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.f35488l = new LinkedHashMap();
        this.f35482f = new Paint(1);
        this.f35483g = new Path();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.X2);
        Intrinsics.e(obtainStyledAttributes, "context.obtainStyledAttr…RoundedDashDelimiterView)");
        setLineWidth(obtainStyledAttributes.getDimension(R$styleable.f34611a3, 0.0f));
        setDashWidth(obtainStyledAttributes.getDimension(R$styleable.f34616b3, 0.0f));
        setGapWidth(obtainStyledAttributes.getDimension(R$styleable.Z2, 0.0f));
        setLineColor(obtainStyledAttributes.getColor(R$styleable.Y2, -16777216));
        Unit unit = Unit.f50853a;
        obtainStyledAttributes.recycle();
    }

    private final void a() {
        float c8;
        this.f35482f.setStyle(Paint.Style.STROKE);
        this.f35482f.setStrokeCap(Paint.Cap.ROUND);
        this.f35482f.setStrokeWidth(this.f35484h);
        this.f35482f.setColor(this.f35487k);
        Paint paint = this.f35482f;
        c8 = RangesKt___RangesKt.c(this.f35485i, 0.0f);
        paint.setPathEffect(new DashPathEffect(new float[]{c8, this.f35486j}, 0.0f));
    }

    private final void setLineColor(int i8) {
        this.f35487k = i8;
        a();
        invalidate();
    }

    public final float getDashWidth() {
        return this.f35485i;
    }

    public final float getGapWidth() {
        return this.f35486j;
    }

    public final float getLineWidth() {
        return this.f35484h;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.f(canvas, "canvas");
        super.onDraw(canvas);
        canvas.drawPath(this.f35483g, this.f35482f);
    }

    @Override // android.view.View
    protected void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        this.f35483g.reset();
        float f8 = 2;
        this.f35483g.moveTo(getPaddingLeft(), getPaddingTop() + (this.f35484h / f8));
        this.f35483g.lineTo(getMeasuredWidth() - getPaddingRight(), getPaddingTop() + (this.f35484h / f8));
    }

    public final void setDashWidth(float f8) {
        this.f35485i = f8;
        a();
        invalidate();
    }

    public final void setGapWidth(float f8) {
        this.f35486j = f8;
        a();
        invalidate();
    }

    public final void setLineWidth(float f8) {
        this.f35484h = f8;
        a();
        invalidate();
    }

    public /* synthetic */ RoundedDashDelimiterView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }
}
