package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.google.android.material.color.MaterialColors;

/* loaded from: classes.dex */
final class CircularDrawingDelegate extends DrawingDelegate<CircularProgressIndicatorSpec> {

    /* renamed from: c  reason: collision with root package name */
    private int f13787c;

    /* renamed from: d  reason: collision with root package name */
    private float f13788d;

    /* renamed from: e  reason: collision with root package name */
    private float f13789e;

    /* renamed from: f  reason: collision with root package name */
    private float f13790f;

    public CircularDrawingDelegate(@NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
        this.f13787c = 1;
    }

    private void h(Canvas canvas, Paint paint, float f8, float f9, float f10) {
        canvas.save();
        canvas.rotate(f10);
        float f11 = this.f13790f;
        float f12 = f8 / 2.0f;
        canvas.drawRoundRect(new RectF(f11 - f12, f9, f11 + f12, -f9), f9, f9, paint);
        canvas.restore();
    }

    private int i() {
        S s7 = this.f13833a;
        return ((CircularProgressIndicatorSpec) s7).f13807g + (((CircularProgressIndicatorSpec) s7).f13808h * 2);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void a(@NonNull Canvas canvas, @NonNull Rect rect, float f8) {
        S s7;
        int i8;
        float width = rect.width() / e();
        float height = rect.height() / d();
        S s8 = this.f13833a;
        float f9 = (((CircularProgressIndicatorSpec) s8).f13807g / 2.0f) + ((CircularProgressIndicatorSpec) s8).f13808h;
        canvas.translate((f9 * width) + rect.left, (f9 * height) + rect.top);
        canvas.scale(width, height);
        canvas.rotate(-90.0f);
        float f10 = -f9;
        canvas.clipRect(f10, f10, f9, f9);
        if (((CircularProgressIndicatorSpec) this.f13833a).f13809i == 0) {
            i8 = 1;
        } else {
            i8 = -1;
        }
        this.f13787c = i8;
        this.f13788d = ((CircularProgressIndicatorSpec) s7).f13781a * f8;
        this.f13789e = ((CircularProgressIndicatorSpec) s7).f13782b * f8;
        this.f13790f = (((CircularProgressIndicatorSpec) s7).f13807g - ((CircularProgressIndicatorSpec) s7).f13781a) / 2.0f;
        if ((this.f13834b.k() && ((CircularProgressIndicatorSpec) this.f13833a).f13785e == 2) || (this.f13834b.j() && ((CircularProgressIndicatorSpec) this.f13833a).f13786f == 1)) {
            this.f13790f += ((1.0f - f8) * ((CircularProgressIndicatorSpec) this.f13833a).f13781a) / 2.0f;
        } else if ((this.f13834b.k() && ((CircularProgressIndicatorSpec) this.f13833a).f13785e == 1) || (this.f13834b.j() && ((CircularProgressIndicatorSpec) this.f13833a).f13786f == 2)) {
            this.f13790f -= ((1.0f - f8) * ((CircularProgressIndicatorSpec) this.f13833a).f13781a) / 2.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void b(@NonNull Canvas canvas, @NonNull Paint paint, float f8, float f9, int i8) {
        float f10;
        if (f8 == f9) {
            return;
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(i8);
        paint.setStrokeWidth(this.f13788d);
        int i9 = this.f13787c;
        float f11 = f8 * 360.0f * i9;
        if (f9 >= f8) {
            f10 = f9 - f8;
        } else {
            f10 = (1.0f + f9) - f8;
        }
        float f12 = f10 * 360.0f * i9;
        float f13 = this.f13790f;
        canvas.drawArc(new RectF(-f13, -f13, f13, f13), f11, f12, false, paint);
        if (this.f13789e > 0.0f && Math.abs(f12) < 360.0f) {
            paint.setStyle(Paint.Style.FILL);
            h(canvas, paint, this.f13788d, this.f13789e, f11);
            h(canvas, paint, this.f13788d, this.f13789e, f11 + f12);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void c(@NonNull Canvas canvas, @NonNull Paint paint) {
        int a8 = MaterialColors.a(((CircularProgressIndicatorSpec) this.f13833a).f13784d, this.f13834b.getAlpha());
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(a8);
        paint.setStrokeWidth(this.f13788d);
        float f8 = this.f13790f;
        canvas.drawArc(new RectF(-f8, -f8, f8, f8), 0.0f, 360.0f, false, paint);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int d() {
        return i();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int e() {
        return i();
    }
}
