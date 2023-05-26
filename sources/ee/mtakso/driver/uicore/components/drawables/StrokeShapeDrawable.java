package ee.mtakso.driver.uicore.components.drawables;

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
    private final Paint f34812a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f34813b;

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f34814c;

    public StrokeShapeDrawable(Shape shape) {
        super(shape);
        Paint paint = new Paint(getPaint());
        this.f34812a = paint;
        Paint paint2 = new Paint(paint);
        paint2.setStyle(Paint.Style.STROKE);
        this.f34813b = paint2;
        this.f34814c = new Matrix();
    }

    public final int a() {
        return this.f34812a.getColor();
    }

    public final int b() {
        return this.f34813b.getColor();
    }

    public final float c() {
        return this.f34813b.getStrokeWidth();
    }

    public final void d(int i8) {
        this.f34812a.setColor(i8);
        invalidateSelf();
    }

    public final void e(int i8) {
        this.f34813b.setColor(i8);
        invalidateSelf();
    }

    public final void f(float f8) {
        this.f34813b.setStrokeWidth(f8);
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
            shape.resize(canvas.getClipBounds().right, canvas.getClipBounds().bottom);
            shape.draw(canvas, this.f34812a);
        }
        if (b() != 0) {
            if (c() == 0.0f) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                this.f34814c.reset();
                this.f34814c.setRectToRect(new RectF(0.0f, 0.0f, canvas.getClipBounds().right, canvas.getClipBounds().bottom), new RectF(c() / 2.0f, c() / 2.0f, canvas.getClipBounds().right - (c() / 2.0f), canvas.getClipBounds().bottom - (c() / 2.0f)), Matrix.ScaleToFit.FILL);
                canvas.concat(this.f34814c);
                shape.draw(canvas, this.f34813b);
            }
        }
    }
}
