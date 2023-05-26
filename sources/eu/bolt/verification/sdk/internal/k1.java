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
public final class k1 extends Drawable {

    /* renamed from: d  reason: collision with root package name */
    public static final a f43792d = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f43793a;

    /* renamed from: b  reason: collision with root package name */
    private final Path f43794b;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f43795c;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public k1(Context context) {
        Intrinsics.f(context, "context");
        this.f43793a = context;
        this.f43794b = new Path();
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(c());
        paint.setColor(a());
        this.f43795c = paint;
    }

    private final int a() {
        return f2.b(this.f43793a, R$color.white_300);
    }

    private final void b(Rect rect) {
        this.f43794b.rewind();
        float a8 = f2.a(this.f43793a, 2.0f);
        RectF rectF = new RectF(rect);
        rectF.inset(a8, a8);
        this.f43794b.addOval(new RectF(rectF), Path.Direction.CW);
    }

    private final float c() {
        return f2.l(this.f43793a, R$dimen.verification_camera_overlay_cutoff_frame_width);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.f(canvas, "canvas");
        canvas.drawPath(this.f43794b, this.f43795c);
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
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i8) {
        this.f43795c.setAlpha(i8);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f43795c.setColorFilter(colorFilter);
    }
}
