package ee.mtakso.driver.uikit.widgets.chart;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import ee.mtakso.driver.uikit.R$styleable;
import ee.mtakso.driver.uikit.utils.Dimens;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PieChartView.kt */
/* loaded from: classes5.dex */
public final class PieChartView extends View {

    /* renamed from: f  reason: collision with root package name */
    private final Paint f36207f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f36208g;

    /* renamed from: h  reason: collision with root package name */
    private final RectF f36209h;

    /* renamed from: i  reason: collision with root package name */
    private final Rect f36210i;

    /* renamed from: j  reason: collision with root package name */
    private Bitmap f36211j;

    /* renamed from: k  reason: collision with root package name */
    private int f36212k;

    /* renamed from: l  reason: collision with root package name */
    private int f36213l;

    /* renamed from: m  reason: collision with root package name */
    private int f36214m;

    /* renamed from: n  reason: collision with root package name */
    private int f36215n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f36216o;

    /* renamed from: p  reason: collision with root package name */
    private List<Segment> f36217p;

    /* renamed from: q  reason: collision with root package name */
    private int f36218q;

    /* renamed from: r  reason: collision with root package name */
    private int f36219r;

    /* renamed from: s  reason: collision with root package name */
    private int f36220s;

    /* renamed from: t  reason: collision with root package name */
    private float f36221t;

    /* renamed from: u  reason: collision with root package name */
    private int f36222u;

    /* renamed from: v  reason: collision with root package name */
    private float f36223v;

    /* renamed from: w  reason: collision with root package name */
    public Map<Integer, View> f36224w;

    /* compiled from: PieChartView.kt */
    /* loaded from: classes5.dex */
    public static final class Segment {

        /* renamed from: a  reason: collision with root package name */
        private final float f36225a;

        /* renamed from: b  reason: collision with root package name */
        private final int f36226b;

        public Segment(float f8, int i8) {
            this.f36225a = f8;
            this.f36226b = i8;
        }

        public final int a() {
            return this.f36226b;
        }

        public final float b() {
            return this.f36225a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Segment) {
                Segment segment = (Segment) obj;
                return Float.compare(this.f36225a, segment.f36225a) == 0 && this.f36226b == segment.f36226b;
            }
            return false;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f36225a) * 31) + this.f36226b;
        }

        public String toString() {
            float f8 = this.f36225a;
            int i8 = this.f36226b;
            return "Segment(value=" + f8 + ", color=" + i8 + ")";
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PieChartView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PieChartView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.f36224w = new LinkedHashMap();
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        this.f36207f = paint;
        Paint paint2 = new Paint(1);
        paint2.setColor(-65536);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.f36208g = paint2;
        this.f36209h = new RectF();
        this.f36210i = new Rect();
        this.f36217p = isInEditMode() ? d() : CollectionsKt__CollectionsKt.k();
        this.f36218q = Dimens.c(250);
        this.f36219r = Dimens.c(28);
        this.f36220s = Dimens.c(2);
        this.f36221t = -90.0f;
        this.f36223v = 1.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f35845n1);
        Intrinsics.e(obtainStyledAttributes, "context.obtainStyledAttr…R.styleable.PieChartView)");
        this.f36218q = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f35860q1, this.f36218q);
        this.f36219r = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f35855p1, this.f36219r);
        this.f36220s = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f35865r1, this.f36220s);
        this.f36221t = obtainStyledAttributes.getFloat(R$styleable.f35870s1, this.f36221t);
        this.f36222u = obtainStyledAttributes.getColor(R$styleable.f35850o1, this.f36222u);
        obtainStyledAttributes.recycle();
    }

    private final int a(int i8, int i9) {
        int size = View.MeasureSpec.getSize(i9);
        int mode = View.MeasureSpec.getMode(i9);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 1073741824) {
                return size;
            }
            return i8;
        }
        return Math.min(i8, size);
    }

    private final void b(Canvas canvas, float f8) {
        double radians = Math.toRadians(f8);
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);
        int i8 = this.f36214m;
        int i9 = this.f36212k;
        float f9 = i8 + ((float) (i9 * cos));
        int i10 = this.f36215n;
        float f10 = i10 + ((float) (i9 * sin));
        int i11 = this.f36213l;
        canvas.drawLine(f9, f10, i8 + ((float) (cos * i11)), i10 + ((float) (sin * i11)), this.f36208g);
    }

    private final Bitmap c() {
        Bitmap bitmap = this.f36211j;
        if (bitmap == null) {
            Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            this.f36211j = createBitmap;
            Intrinsics.e(createBitmap, "createBitmap(width, heig…hartBitmap = it\n        }");
            return createBitmap;
        }
        return bitmap;
    }

    private final List<Segment> d() {
        List<Segment> n8;
        n8 = CollectionsKt__CollectionsKt.n(new Segment(0.75f, Color.parseColor("#5B68F6")), new Segment(0.1f, Color.parseColor("#FFB200")), new Segment(0.15f, Color.parseColor("#27B973")));
        return n8;
    }

    public final int getChartBackgroundColor() {
        return this.f36222u;
    }

    public final float getSegmentScale() {
        return this.f36223v;
    }

    public final int getSegmentSize() {
        return this.f36219r;
    }

    public final List<Segment> getSegments() {
        return this.f36217p;
    }

    public final int getSize() {
        return this.f36218q;
    }

    public final int getSpacingSize() {
        return this.f36220s;
    }

    public final float getStartOffset() {
        return this.f36221t;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f36216o) {
            this.f36216o = false;
            Bitmap c8 = c();
            Canvas canvas2 = new Canvas(c8);
            c8.eraseColor(0);
            this.f36207f.setStrokeWidth(this.f36219r);
            this.f36208g.setStrokeWidth(this.f36220s);
            this.f36207f.setColor(this.f36222u);
            canvas2.drawArc(this.f36209h, this.f36221t, 360.0f, false, this.f36207f);
            b(canvas2, this.f36221t);
            float f8 = 0.0f;
            for (Segment segment : this.f36217p) {
                float b8 = f8 + (360 * segment.b());
                this.f36207f.setColor(segment.a());
                RectF rectF = this.f36209h;
                float f9 = this.f36221t;
                float f10 = this.f36223v;
                canvas2.drawArc(rectF, (f8 * f10) + f9, (b8 - f8) * f10, false, this.f36207f);
                if (this.f36220s > 0.0f) {
                    b(canvas2, this.f36221t + (f8 * this.f36223v));
                    b(canvas2, this.f36221t + (this.f36223v * b8));
                }
                f8 = b8;
            }
        }
        Bitmap bitmap = this.f36211j;
        if (bitmap != null && canvas != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        boolean z8;
        super.onLayout(z7, i8, i9, i10, i11);
        float f8 = this.f36219r / 2.0f;
        this.f36209h.left = getPaddingLeft() + f8;
        this.f36209h.top = getPaddingTop() + f8;
        this.f36209h.right = (getWidth() - getPaddingRight()) - f8;
        this.f36209h.bottom = (getHeight() - getPaddingBottom()) - f8;
        int i12 = this.f36218q / 2;
        this.f36212k = i12;
        this.f36213l = i12 - this.f36219r;
        this.f36214m = getWidth() / 2;
        this.f36215n = getHeight() / 2;
        Bitmap bitmap = this.f36211j;
        if (bitmap != null) {
            boolean z9 = false;
            if (bitmap != null && bitmap.getWidth() == getWidth()) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8) {
                Bitmap bitmap2 = this.f36211j;
                if (bitmap2 != null && bitmap2.getHeight() == getHeight()) {
                    z9 = true;
                }
                if (z9) {
                    return;
                }
            }
        }
        this.f36211j = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        this.f36216o = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        Drawable background = getBackground();
        boolean z7 = true;
        if (!((background == null || !background.getPadding(this.f36210i)) ? false : false)) {
            this.f36210i.set(0, 0, 0, 0);
        }
        this.f36210i.left += getPaddingLeft();
        this.f36210i.right += getPaddingRight();
        this.f36210i.top += getPaddingTop();
        this.f36210i.bottom += getPaddingBottom();
        int i10 = this.f36218q;
        Rect rect = this.f36210i;
        int a8 = a(i10 + rect.left + rect.right, i8);
        int i11 = this.f36218q;
        Rect rect2 = this.f36210i;
        setMeasuredDimension(a8, a(i11 + rect2.top + rect2.bottom, i9));
    }

    public final void setChartBackgroundColor(int i8) {
        this.f36222u = i8;
    }

    public final void setSegmentScale(float f8) {
        this.f36223v = f8;
        this.f36216o = true;
        invalidate();
    }

    public final void setSegmentSize(int i8) {
        this.f36219r = i8;
    }

    public final void setSegments(List<Segment> value) {
        Intrinsics.f(value, "value");
        this.f36217p = value;
        this.f36216o = true;
        invalidate();
    }

    public final void setSize(int i8) {
        this.f36218q = i8;
    }

    public final void setSpacingSize(int i8) {
        this.f36220s = i8;
    }

    public final void setStartOffset(float f8) {
        this.f36221t = f8;
    }

    public /* synthetic */ PieChartView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }
}
