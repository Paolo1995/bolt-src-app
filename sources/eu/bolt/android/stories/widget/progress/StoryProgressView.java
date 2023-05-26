package eu.bolt.android.stories.widget.progress;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import eu.bolt.android.stories.util.ViewExtKt;
import eu.bolt.android.stories.widget.slide.ARiderXKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: StoryProgressView.kt */
/* loaded from: classes5.dex */
public final class StoryProgressView extends View {

    /* renamed from: f  reason: collision with root package name */
    private final Paint f37635f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f37636g;

    /* renamed from: h  reason: collision with root package name */
    private final RectF f37637h;

    /* renamed from: i  reason: collision with root package name */
    private int f37638i;

    /* renamed from: j  reason: collision with root package name */
    private int f37639j;

    /* renamed from: k  reason: collision with root package name */
    private float f37640k;

    /* renamed from: l  reason: collision with root package name */
    private float f37641l;

    /* renamed from: m  reason: collision with root package name */
    private float f37642m;

    /* renamed from: n  reason: collision with root package name */
    private float f37643n;

    /* renamed from: o  reason: collision with root package name */
    private final int f37644o;

    /* renamed from: p  reason: collision with root package name */
    public Map<Integer, View> f37645p;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StoryProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoryProgressView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.f37645p = new LinkedHashMap();
        Paint paint = new Paint(1);
        this.f37635f = paint;
        Paint paint2 = new Paint(1);
        this.f37636g = paint2;
        this.f37637h = new RectF();
        this.f37638i = 1;
        this.f37642m = ARiderXKt.d(context, 6.0f);
        this.f37643n = ARiderXKt.d(context, 2.0f);
        this.f37644o = ARiderXKt.c(context, 0.0f);
        paint.setColor(Color.parseColor("#5CFFFFFF"));
        paint2.setColor(Color.parseColor("#D6FFFFFF"));
    }

    private final void a(int i8, Canvas canvas, int i9, int i10) {
        int i11 = this.f37644o;
        float f8 = this.f37641l;
        float f9 = i11 + (i8 * (this.f37643n + f8));
        e(canvas, f9, i9, (f8 + f9) - (i11 * 2), i10, this.f37636g);
    }

    private final void b(Canvas canvas) {
        int i8 = this.f37644o;
        int height = getHeight() - this.f37644o;
        if (ViewExtKt.a(this)) {
            int i9 = this.f37638i;
            for (int i10 = i9 - this.f37639j; i10 < i9; i10++) {
                a(i10, canvas, i8, height);
            }
            return;
        }
        int i11 = this.f37639j;
        for (int i12 = 0; i12 < i11; i12++) {
            a(i12, canvas, i8, height);
        }
    }

    private final void c(Canvas canvas) {
        float f8 = 0.0f;
        int height = getHeight();
        int i8 = this.f37638i;
        float f9 = this.f37641l + 0.0f;
        for (int i9 = 0; i9 < i8; i9++) {
            e(canvas, f8, 0, f9, height, this.f37635f);
            float f10 = this.f37641l;
            f8 += this.f37643n + f10;
            f9 = f8 + f10;
        }
    }

    private final void d(Canvas canvas) {
        float f8;
        float f9;
        int i8;
        float f10 = this.f37640k;
        if (f10 > 0.0f) {
            int i9 = (int) (f10 * this.f37641l);
            int currentSegmentIndex = getCurrentSegmentIndex();
            if (ViewExtKt.a(this)) {
                float f11 = this.f37641l;
                f8 = (((currentSegmentIndex * (this.f37643n + f11)) - this.f37644o) + f11) - i9;
            } else {
                f8 = (currentSegmentIndex * (this.f37641l + this.f37643n)) + this.f37644o;
            }
            float f12 = f8;
            if (ViewExtKt.a(this)) {
                float f13 = currentSegmentIndex;
                float f14 = this.f37641l;
                f9 = (f13 * (this.f37643n + f14)) + f14;
                i8 = this.f37644o;
            } else {
                f9 = i9 + f12;
                i8 = this.f37644o * 2;
            }
            e(canvas, f12, this.f37644o, f9 - i8, getHeight() - this.f37644o, this.f37636g);
        }
    }

    private final void e(Canvas canvas, float f8, float f9, float f10, float f11, Paint paint) {
        RectF rectF = this.f37637h;
        rectF.left = f8;
        rectF.top = f9;
        rectF.right = f10;
        rectF.bottom = f11;
        float f12 = this.f37642m;
        canvas.drawRoundRect(rectF, f12, f12, paint);
    }

    private final void f() {
        float i8;
        if (getWidth() > 0) {
            float segmentWidth = getSegmentWidth();
            this.f37641l = segmentWidth;
            i8 = RangesKt___RangesKt.i(this.f37642m, 0.0f, segmentWidth / 2.0f);
            this.f37642m = i8;
        }
    }

    private final int getCurrentSegmentIndex() {
        if (ViewExtKt.a(this)) {
            return (this.f37638i - 1) - this.f37639j;
        }
        return this.f37639j;
    }

    private final float getSegmentWidth() {
        float f8 = this.f37643n;
        int i8 = this.f37638i;
        return (getWidth() - (f8 * (i8 - 1))) / i8;
    }

    public final void g(int i8, float f8) {
        this.f37639j = i8;
        this.f37640k = f8;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.f(canvas, "canvas");
        super.onDraw(canvas);
        c(canvas);
        b(canvas);
        d(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        f();
    }

    public final void setSlidesCount(int i8) {
        this.f37638i = i8;
        f();
        invalidate();
    }

    public /* synthetic */ StoryProgressView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }
}
