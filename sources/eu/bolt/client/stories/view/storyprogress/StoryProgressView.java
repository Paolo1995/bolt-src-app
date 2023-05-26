package eu.bolt.client.stories.view.storyprogress;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import eu.bolt.verification.sdk.internal.f2;
import eu.bolt.verification.sdk.internal.ij;
import eu.bolt.verification.sdk.internal.uq;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* loaded from: classes5.dex */
public final class StoryProgressView extends View {

    /* renamed from: o  reason: collision with root package name */
    private static final a f40323o = new a(null);

    /* renamed from: f  reason: collision with root package name */
    private int f40324f;

    /* renamed from: g  reason: collision with root package name */
    private float f40325g;

    /* renamed from: h  reason: collision with root package name */
    private final ij f40326h;

    /* renamed from: i  reason: collision with root package name */
    private int f40327i;

    /* renamed from: j  reason: collision with root package name */
    private float f40328j;

    /* renamed from: k  reason: collision with root package name */
    private final int f40329k;

    /* renamed from: l  reason: collision with root package name */
    private final Paint f40330l;

    /* renamed from: m  reason: collision with root package name */
    private final Paint f40331m;

    /* renamed from: n  reason: collision with root package name */
    private final RectF f40332n;

    /* loaded from: classes5.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StoryProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoryProgressView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        ij ijVar = new ij(context, attributeSet);
        this.f40326h = ijVar;
        this.f40328j = ijVar.d();
        this.f40329k = f2.a(context, 0.0f);
        Paint paint = new Paint(1);
        this.f40330l = paint;
        Paint paint2 = new Paint(1);
        this.f40331m = paint2;
        this.f40332n = new RectF();
        paint.setColor(ijVar.a());
        paint2.setColor(ijVar.f());
    }

    public /* synthetic */ StoryProgressView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    private final void a() {
        float i8;
        if (getWidth() > 0) {
            this.f40327i = getSegmentWidth();
            i8 = RangesKt___RangesKt.i(this.f40326h.d(), 0.0f, this.f40327i / 2.0f);
            this.f40328j = i8;
        }
    }

    private final void c(int i8, Canvas canvas, int i9, int i10) {
        int j8 = this.f40329k + (i8 * (this.f40327i + this.f40326h.j()));
        e(canvas, j8, i9, (this.f40327i + j8) - (this.f40329k * 2), i10, this.f40331m);
    }

    private final void d(Canvas canvas) {
        int i8 = this.f40329k;
        int height = getHeight() - this.f40329k;
        if (uq.Z(this)) {
            int h8 = this.f40326h.h();
            for (int h9 = this.f40326h.h() - this.f40324f; h9 < h8; h9++) {
                c(h9, canvas, i8, height);
            }
            return;
        }
        int i9 = this.f40324f;
        for (int i10 = 0; i10 < i9; i10++) {
            c(i10, canvas, i8, height);
        }
    }

    private final void e(Canvas canvas, float f8, float f9, float f10, float f11, Paint paint) {
        RectF rectF = this.f40332n;
        rectF.left = f8;
        rectF.top = f9;
        rectF.right = f10;
        rectF.bottom = f11;
        float f12 = this.f40328j;
        canvas.drawRoundRect(rectF, f12, f12, paint);
    }

    private final void f(Canvas canvas) {
        int i8 = this.f40327i + 0;
        int height = getHeight();
        int h8 = this.f40326h.h();
        int i9 = 0;
        for (int i10 = 0; i10 < h8; i10++) {
            e(canvas, i9, 0, i8, height, this.f40330l);
            i9 += this.f40327i + this.f40326h.j();
            i8 = this.f40327i + i9;
        }
    }

    private final void g(Canvas canvas) {
        float f8 = this.f40325g;
        if (f8 > 0.0f) {
            int i8 = (int) (f8 * this.f40327i);
            int currentSegmentIndex = getCurrentSegmentIndex();
            int j8 = uq.Z(this) ? ((((this.f40327i + this.f40326h.j()) * currentSegmentIndex) - this.f40329k) + this.f40327i) - i8 : ((this.f40327i + this.f40326h.j()) * currentSegmentIndex) + this.f40329k;
            e(canvas, j8, this.f40329k, uq.Z(this) ? ((currentSegmentIndex * (this.f40327i + this.f40326h.j())) + this.f40327i) - this.f40329k : (i8 + j8) - (this.f40329k * 2), getHeight() - this.f40329k, this.f40331m);
        }
    }

    private final int getCurrentSegmentIndex() {
        return uq.Z(this) ? (this.f40326h.h() - 1) - this.f40324f : this.f40324f;
    }

    private final int getSegmentWidth() {
        return (getWidth() - (this.f40326h.j() * (this.f40326h.h() - 1))) / this.f40326h.h();
    }

    public final void b(int i8, float f8) {
        this.f40324f = i8;
        this.f40325g = f8;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.f(canvas, "canvas");
        super.onDraw(canvas);
        f(canvas);
        d(canvas);
        g(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        a();
    }

    public final void setSlidesCount(int i8) {
        this.f40326h.g(i8);
        a();
        invalidate();
    }
}
