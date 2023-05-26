package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import eu.bolt.verification.R$color;
import eu.bolt.verification.R$dimen;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class m1 extends Drawable {

    /* renamed from: f  reason: collision with root package name */
    public static final a f44112f = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f44113a;

    /* renamed from: b  reason: collision with root package name */
    private final Path f44114b;

    /* renamed from: c  reason: collision with root package name */
    private final Path f44115c;

    /* renamed from: d  reason: collision with root package name */
    private final Paint f44116d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f44117e;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public m1(Context context) {
        Intrinsics.f(context, "context");
        this.f44113a = context;
        this.f44114b = new Path();
        this.f44115c = new Path();
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(e());
        paint.setColor(a());
        this.f44116d = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(e());
        paint2.setColor(c());
        this.f44117e = paint2;
    }

    private final int a() {
        return f2.b(this.f44113a, R$color.F);
    }

    private final void b(Rect rect) {
        this.f44114b.rewind();
        float a8 = f2.a(this.f44113a, 2.0f);
        RectF rectF = new RectF(rect);
        rectF.inset(a8, a8);
        float l8 = f2.l(this.f44113a, R$dimen.verification_camera_overlay_rect_corner_radius);
        float l9 = f2.l(this.f44113a, R$dimen.verification_camera_overlay_rect_cap_size);
        Path path = this.f44114b;
        path.moveTo(rectF.left, rectF.top + l8 + l9);
        float f8 = -l9;
        path.rLineTo(0.0f, f8);
        float f9 = rectF.left;
        float f10 = rectF.top;
        path.quadTo(f9, f10, f9 + l8, f10);
        path.rLineTo(l9, 0.0f);
        path.moveTo((rectF.right - l8) - l9, rectF.top);
        path.rLineTo(l9, 0.0f);
        float f11 = rectF.right;
        float f12 = rectF.top;
        path.quadTo(f11, f12, f11, f12 + l8);
        path.rLineTo(0.0f, l9);
        path.moveTo(rectF.right, (rectF.bottom - l8) - l9);
        path.rLineTo(0.0f, l9);
        float f13 = rectF.right;
        float f14 = rectF.bottom;
        path.quadTo(f13, f14, f13 - l8, f14);
        path.rLineTo(f8, 0.0f);
        path.moveTo(rectF.left + l8 + l9, rectF.bottom);
        path.rLineTo(f8, 0.0f);
        float f15 = rectF.left;
        float f16 = rectF.bottom;
        path.quadTo(f15, f16, f15, f16 - l8);
        path.rLineTo(0.0f, f8);
    }

    private final int c() {
        return f2.b(this.f44113a, R$color.white_300);
    }

    private final void d(Rect rect) {
        this.f44115c.rewind();
        float a8 = f2.a(this.f44113a, 2.0f);
        RectF rectF = new RectF(rect);
        rectF.inset(a8, a8);
        float l8 = f2.l(this.f44113a, R$dimen.verification_camera_overlay_rect_corner_radius);
        float l9 = f2.l(this.f44113a, R$dimen.verification_camera_overlay_rect_cap_size);
        float f8 = rectF.right;
        float f9 = rectF.left;
        float f10 = 2;
        float f11 = l8 * f10;
        float f12 = f10 * l9;
        float f13 = ((f8 - f9) - f11) - f12;
        float f14 = rectF.bottom;
        float f15 = rectF.top;
        float f16 = ((f14 - f15) - f11) - f12;
        Path path = this.f44115c;
        path.moveTo(f9, f15 + l8 + l9);
        path.rLineTo(0.0f, f16);
        path.moveTo((rectF.right - l8) - l9, rectF.top);
        path.rLineTo(-f13, 0.0f);
        path.moveTo(rectF.right, (rectF.bottom - l8) - l9);
        path.rLineTo(0.0f, -f16);
        path.moveTo(rectF.left + l8 + l9, rectF.bottom);
        path.rLineTo(f13, 0.0f);
    }

    private final float e() {
        return f2.l(this.f44113a, R$dimen.verification_camera_overlay_cutoff_frame_width);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.f(canvas, "canvas");
        canvas.drawPath(this.f44114b, this.f44116d);
        canvas.drawPath(this.f44115c, this.f44117e);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect bounds) {
        Intrinsics.f(bounds, "bounds");
        super.onBoundsChange(bounds);
        b(bounds);
        d(bounds);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i8) {
        this.f44116d.setAlpha(i8);
        this.f44117e.setAlpha(i8);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f44116d.setColorFilter(colorFilter);
        this.f44117e.setColorFilter(colorFilter);
    }
}
