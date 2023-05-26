package ee.mtakso.driver.uikit.internal.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StrokeShapeDrawable.kt */
/* loaded from: classes5.dex */
public final class StrokeShapeDrawable extends ShapeDrawable {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f35944a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f35945b;

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f35946c;

    public StrokeShapeDrawable(Shape shape) {
        super(shape);
        Paint paint = new Paint(getPaint());
        this.f35944a = paint;
        Paint paint2 = new Paint(paint);
        paint2.setStyle(Paint.Style.STROKE);
        this.f35945b = paint2;
        this.f35946c = new Matrix();
    }

    public final int a() {
        return this.f35944a.getColor();
    }

    public final int b() {
        return this.f35945b.getColor();
    }

    public final float c() {
        return this.f35945b.getStrokeWidth();
    }

    public final void d(int i8) {
        this.f35944a.setColor(i8);
        invalidateSelf();
    }

    public final void e(int i8) {
        this.f35945b.setColor(i8);
        invalidateSelf();
    }

    public final void f(float f8) {
        this.f35945b.setStrokeWidth(f8);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.ShapeDrawable
    protected void onDraw(Shape shape, Canvas canvas, Paint paint) {
        boolean z7;
        Intrinsics.f(shape, "shape");
        if (canvas == null) {
            return;
        }
        if (a() != 0) {
            shape.draw(canvas, this.f35944a);
        }
        if (b() != 0) {
            if (c() == 0.0f) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                this.f35946c.reset();
                this.f35946c.setRectToRect(new RectF(0.0f, 0.0f, canvas.getClipBounds().right, canvas.getClipBounds().bottom), new RectF(c() / 2.0f, c() / 2.0f, canvas.getClipBounds().right - (c() / 2.0f), canvas.getClipBounds().bottom - (c() / 2.0f)), Matrix.ScaleToFit.FILL);
                canvas.concat(this.f35946c);
                shape.draw(canvas, this.f35945b);
            }
        }
    }
}
