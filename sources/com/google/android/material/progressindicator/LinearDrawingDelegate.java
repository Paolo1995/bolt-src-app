package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.google.android.material.color.MaterialColors;

/* loaded from: classes.dex */
final class LinearDrawingDelegate extends DrawingDelegate<LinearProgressIndicatorSpec> {

    /* renamed from: c  reason: collision with root package name */
    private float f13840c;

    /* renamed from: d  reason: collision with root package name */
    private float f13841d;

    /* renamed from: e  reason: collision with root package name */
    private float f13842e;

    public LinearDrawingDelegate(@NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(linearProgressIndicatorSpec);
        this.f13840c = 300.0f;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void a(@NonNull Canvas canvas, @NonNull Rect rect, float f8) {
        this.f13840c = rect.width();
        float f9 = ((LinearProgressIndicatorSpec) this.f13833a).f13781a;
        canvas.translate(rect.left + (rect.width() / 2.0f), rect.top + (rect.height() / 2.0f) + Math.max(0.0f, (rect.height() - ((LinearProgressIndicatorSpec) this.f13833a).f13781a) / 2.0f));
        if (((LinearProgressIndicatorSpec) this.f13833a).f13867i) {
            canvas.scale(-1.0f, 1.0f);
        }
        if ((this.f13834b.k() && ((LinearProgressIndicatorSpec) this.f13833a).f13785e == 1) || (this.f13834b.j() && ((LinearProgressIndicatorSpec) this.f13833a).f13786f == 2)) {
            canvas.scale(1.0f, -1.0f);
        }
        if (this.f13834b.k() || this.f13834b.j()) {
            canvas.translate(0.0f, (((LinearProgressIndicatorSpec) this.f13833a).f13781a * (f8 - 1.0f)) / 2.0f);
        }
        float f10 = this.f13840c;
        canvas.clipRect((-f10) / 2.0f, (-f9) / 2.0f, f10 / 2.0f, f9 / 2.0f);
        S s7 = this.f13833a;
        this.f13841d = ((LinearProgressIndicatorSpec) s7).f13781a * f8;
        this.f13842e = ((LinearProgressIndicatorSpec) s7).f13782b * f8;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void b(@NonNull Canvas canvas, @NonNull Paint paint, float f8, float f9, int i8) {
        if (f8 == f9) {
            return;
        }
        float f10 = this.f13840c;
        float f11 = this.f13842e;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(i8);
        float f12 = this.f13841d;
        RectF rectF = new RectF(((-f10) / 2.0f) + (f8 * (f10 - (f11 * 2.0f))), (-f12) / 2.0f, ((-f10) / 2.0f) + (f9 * (f10 - (f11 * 2.0f))) + (f11 * 2.0f), f12 / 2.0f);
        float f13 = this.f13842e;
        canvas.drawRoundRect(rectF, f13, f13, paint);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void c(@NonNull Canvas canvas, @NonNull Paint paint) {
        int a8 = MaterialColors.a(((LinearProgressIndicatorSpec) this.f13833a).f13784d, this.f13834b.getAlpha());
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(a8);
        float f8 = this.f13840c;
        float f9 = this.f13841d;
        RectF rectF = new RectF((-f8) / 2.0f, (-f9) / 2.0f, f8 / 2.0f, f9 / 2.0f);
        float f10 = this.f13842e;
        canvas.drawRoundRect(rectF, f10, f10, paint);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int d() {
        return ((LinearProgressIndicatorSpec) this.f13833a).f13781a;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int e() {
        return -1;
    }
}
