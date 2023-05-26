package ee.mtakso.driver.uicore.components.views.chart;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import ee.mtakso.driver.uicore.R$styleable;
import ee.mtakso.driver.uicore.components.views.chart.VerticalBarsProcessor;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: BarChartView.kt */
/* loaded from: classes5.dex */
public final class BarChartView extends View {

    /* renamed from: y  reason: collision with root package name */
    public static final Companion f35515y = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final Paint f35516f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f35517g;

    /* renamed from: h  reason: collision with root package name */
    private final TextPaint f35518h;

    /* renamed from: i  reason: collision with root package name */
    private final float f35519i;

    /* renamed from: j  reason: collision with root package name */
    private final TextPaint f35520j;

    /* renamed from: k  reason: collision with root package name */
    private final float f35521k;

    /* renamed from: l  reason: collision with root package name */
    private BarChartAdapter f35522l;

    /* renamed from: m  reason: collision with root package name */
    private final RectF f35523m;

    /* renamed from: n  reason: collision with root package name */
    private final List<Bar> f35524n;

    /* renamed from: o  reason: collision with root package name */
    private final List<GridAxis> f35525o;

    /* renamed from: p  reason: collision with root package name */
    private float f35526p;

    /* renamed from: q  reason: collision with root package name */
    private float f35527q;

    /* renamed from: r  reason: collision with root package name */
    private Rect f35528r;

    /* renamed from: s  reason: collision with root package name */
    private final RectF f35529s;

    /* renamed from: t  reason: collision with root package name */
    private float f35530t;

    /* renamed from: u  reason: collision with root package name */
    private int f35531u;

    /* renamed from: v  reason: collision with root package name */
    private int f35532v;

    /* renamed from: w  reason: collision with root package name */
    private String f35533w;

    /* renamed from: x  reason: collision with root package name */
    public Map<Integer, View> f35534x;

    /* compiled from: BarChartView.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final float a(TextPaint textPaint) {
            Intrinsics.f(textPaint, "<this>");
            Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            Intrinsics.e(fontMetrics, "fontMetrics");
            return fontMetrics.descent - fontMetrics.ascent;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BarChartView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BarChartView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.f35534x = new LinkedHashMap();
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        this.f35516f = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        paint2.setColor(-16777216);
        paint2.setStrokeWidth(Dimens.c(1.0f));
        this.f35517g = paint2;
        TextPaint textPaint = new TextPaint(1);
        textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        textPaint.setColor(-16777216);
        textPaint.setTextSize(Dimens.a(14.0f));
        textPaint.setTextAlign(Paint.Align.LEFT);
        this.f35518h = textPaint;
        this.f35519i = Dimens.c(8.0f);
        TextPaint textPaint2 = new TextPaint(1);
        textPaint2.setStyle(Paint.Style.FILL_AND_STROKE);
        textPaint2.setColor(-16777216);
        textPaint2.setTextSize(Dimens.a(14.0f));
        textPaint2.setTextAlign(Paint.Align.CENTER);
        this.f35520j = textPaint2;
        this.f35521k = Dimens.c(4.0f);
        this.f35523m = new RectF();
        this.f35524n = new ArrayList();
        this.f35525o = new ArrayList();
        this.f35528r = new Rect();
        this.f35529s = new RectF();
        this.f35531u = -16777216;
        this.f35532v = -16777216;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.B);
        Intrinsics.e(obtainStyledAttributes, "context.obtainStyledAttr…R.styleable.BarChartView)");
        setGridLinesColor(obtainStyledAttributes.getColor(R$styleable.H, -16777216));
        setGridLinesThickness(obtainStyledAttributes.getDimension(R$styleable.I, Dimens.c(1.0f)));
        setGridLabelColor(obtainStyledAttributes.getColor(R$styleable.G, -16777216));
        int i9 = R$styleable.E;
        setGridLabelTextSize(obtainStyledAttributes.getDimension(i9, Dimens.a(14.0f)));
        setBarLabelColor(obtainStyledAttributes.getColor(R$styleable.C, -16777216));
        setBarLabelHighlightColor(obtainStyledAttributes.getColor(R$styleable.D, -16777216));
        setBarLabelTextSize(obtainStyledAttributes.getDimension(i9, Dimens.a(14.0f)));
        setBarRoundRadius(obtainStyledAttributes.getDimension(R$styleable.F, Dimens.c(4.0f)));
        obtainStyledAttributes.recycle();
    }

    private final void b(Canvas canvas, Bar bar, float f8) {
        IntProgression l8;
        boolean z7;
        float b8 = bar.b();
        if (bar.a() == BarType.POSITIVE) {
            l8 = RangesKt___RangesKt.o(0, bar.f().size());
        } else {
            l8 = RangesKt___RangesKt.l(bar.f().size() - 1, 0);
        }
        if (BarKt.a(bar) > 0.0f) {
            int g8 = l8.g();
            int i8 = l8.i();
            int k8 = l8.k();
            if ((k8 > 0 && g8 <= i8) || (k8 < 0 && i8 <= g8)) {
                while (true) {
                    BarSector barSector = bar.f().get(g8);
                    if (g8 == 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    b8 += d(canvas, bar, z7, barSector, b8, f8);
                    if (g8 == i8) {
                        break;
                    }
                    g8 += k8;
                }
            }
        }
        g(canvas, bar);
    }

    static /* synthetic */ void c(BarChartView barChartView, Canvas canvas, Bar bar, float f8, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            f8 = 0.2f;
        }
        barChartView.b(canvas, bar, f8);
    }

    private final float d(Canvas canvas, Bar bar, boolean z7, BarSector barSector, float f8, float f9) {
        float c8 = BarKt.c(bar) * f9;
        float a8 = BarKt.a(bar) * barSector.b();
        float f10 = c8 / 2;
        float d8 = bar.d() + f10;
        float e8 = bar.e() - f10;
        float f11 = f8 + a8;
        Paint paint = this.f35516f;
        Context context = getContext();
        Intrinsics.e(context, "context");
        paint.setColor(ContextUtilsKt.b(context, barSector.a()));
        if (!z7) {
            canvas.drawRect(d8, f8, e8, f11, this.f35516f);
        } else {
            this.f35529s.setEmpty();
            this.f35529s.set(d8, f8, e8, f11);
            RectF rectF = this.f35529s;
            float f12 = this.f35530t;
            canvas.drawRoundRect(rectF, f12, f12, this.f35516f);
            if (bar.a() == BarType.POSITIVE) {
                canvas.drawRect(d8, f8 + (a8 / 2.0f), e8, f11, this.f35516f);
            } else {
                canvas.drawRect(d8, f8, e8, f11 - (a8 / 2.0f), this.f35516f);
            }
        }
        return a8;
    }

    private final void e(Canvas canvas, List<Bar> list) {
        for (Bar bar : list) {
            c(this, canvas, bar, 0.0f, 2, null);
        }
    }

    private final void f(Canvas canvas, List<GridAxis> list) {
        for (GridAxis gridAxis : list) {
            canvas.drawLine(gridAxis.c(), gridAxis.b(), getRight(), gridAxis.b(), this.f35517g);
            if (gridAxis.a() != null) {
                this.f35528r.setEmpty();
                this.f35518h.getTextBounds(gridAxis.a(), 0, gridAxis.a().length(), this.f35528r);
                canvas.drawText(gridAxis.a(), (this.f35526p - this.f35528r.width()) / 2.0f, gridAxis.b() + (this.f35528r.height() / 2.0f), this.f35518h);
            }
        }
    }

    private final void g(Canvas canvas, Bar bar) {
        boolean y7;
        Label c8 = bar.c();
        if (c8 != null) {
            y7 = StringsKt__StringsJVMKt.y(c8.b());
            if (!y7) {
                if (c8.a()) {
                    this.f35520j.setColor(this.f35532v);
                } else {
                    this.f35520j.setColor(this.f35531u);
                }
                canvas.drawText(c8.b(), (bar.e() + bar.d()) / 2.0f, (canvas.getHeight() - this.f35527q) + this.f35521k + f35515y.a(this.f35520j), this.f35520j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        BarChartAdapter barChartAdapter = this.f35522l;
        if (barChartAdapter == null) {
            return;
        }
        VerticalBarsProcessor.ProcessingResult i8 = new VerticalBarsProcessor(new RectF(this.f35523m), barChartAdapter, this.f35518h, this.f35519i, this.f35521k, this.f35533w, null, VerticalBarsProcessor.Axis.REVERTED, 64, null).i();
        this.f35526p = i8.d();
        this.f35527q = i8.b();
        i(i8.a());
        j(i8.c());
        invalidate();
    }

    private final void i(List<Bar> list) {
        this.f35524n.clear();
        this.f35524n.addAll(list);
    }

    private final void j(List<GridAxis> list) {
        this.f35525o.clear();
        this.f35525o.addAll(list);
    }

    public final BarChartAdapter getAdapter() {
        return this.f35522l;
    }

    public final String getAdditionalGridLabelSuffix() {
        return this.f35533w;
    }

    public final int getBarLabelColor() {
        return this.f35531u;
    }

    public final int getBarLabelHighlightColor() {
        return this.f35532v;
    }

    public final float getBarLabelTextSize() {
        return this.f35520j.getTextSize();
    }

    public final float getBarRoundRadius() {
        return this.f35530t;
    }

    public final int getGridLabelColor() {
        return this.f35518h.getColor();
    }

    public final float getGridLabelTextSize() {
        return this.f35518h.getTextSize();
    }

    public final int getGridLinesColor() {
        return this.f35517g.getColor();
    }

    public final float getGridLinesThickness() {
        return this.f35517g.getStrokeWidth();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (canvas == null) {
            return;
        }
        f(canvas, this.f35525o);
        e(canvas, this.f35524n);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        this.f35523m.set(getPaddingLeft() + 0.0f, getPaddingTop() + 0.0f + f35515y.a(this.f35518h), i8 - getPaddingRight(), i9 - getPaddingBottom());
        h();
    }

    public final void setAdapter(BarChartAdapter adapter) {
        Intrinsics.f(adapter, "adapter");
        BarChartAdapter barChartAdapter = this.f35522l;
        if (barChartAdapter != null) {
            barChartAdapter.e(null);
        }
        this.f35522l = adapter;
        adapter.e(new Function0<Unit>() { // from class: ee.mtakso.driver.uicore.components.views.chart.BarChartView$setAdapter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final void b() {
                BarChartView.this.h();
                BarChartView.this.invalidate();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        });
    }

    public final void setAdditionalGridLabelSuffix(String str) {
        this.f35533w = str;
        h();
    }

    public final void setBarLabelColor(int i8) {
        this.f35531u = i8;
        invalidate();
    }

    public final void setBarLabelColorRes(int i8) {
        setBarLabelColor(ContextCompat.getColor(getContext(), i8));
    }

    public final void setBarLabelHighlightColor(int i8) {
        this.f35532v = i8;
        invalidate();
    }

    public final void setBarLabelHighlightColorRes(int i8) {
        setBarLabelHighlightColor(ContextCompat.getColor(getContext(), i8));
    }

    public final void setBarLabelTextSize(float f8) {
        this.f35520j.setTextSize(f8);
        invalidate();
    }

    public final void setBarRoundRadius(float f8) {
        this.f35530t = f8;
        invalidate();
    }

    public final void setGridLabelColor(int i8) {
        this.f35518h.setColor(i8);
        invalidate();
    }

    public final void setGridLabelColorRes(int i8) {
        setGridLabelColor(ContextCompat.getColor(getContext(), i8));
    }

    public final void setGridLabelTextSize(float f8) {
        this.f35518h.setTextSize(f8);
        invalidate();
    }

    public final void setGridLinesColor(int i8) {
        this.f35517g.setColor(i8);
        invalidate();
    }

    public final void setGridLinesColorRes(int i8) {
        setGridLinesColor(ContextCompat.getColor(getContext(), i8));
    }

    public final void setGridLinesThickness(float f8) {
        this.f35517g.setStrokeWidth(f8);
        invalidate();
    }

    public /* synthetic */ BarChartView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }
}
