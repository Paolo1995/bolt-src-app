package androidx.appcompat.graphics.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;

/* loaded from: classes.dex */
public class DrawerArrowDrawable extends Drawable {

    /* renamed from: m  reason: collision with root package name */
    private static final float f1396m = (float) Math.toRadians(45.0d);

    /* renamed from: a  reason: collision with root package name */
    private final Paint f1397a;

    /* renamed from: b  reason: collision with root package name */
    private float f1398b;

    /* renamed from: c  reason: collision with root package name */
    private float f1399c;

    /* renamed from: d  reason: collision with root package name */
    private float f1400d;

    /* renamed from: e  reason: collision with root package name */
    private float f1401e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1402f;

    /* renamed from: g  reason: collision with root package name */
    private final Path f1403g;

    /* renamed from: h  reason: collision with root package name */
    private final int f1404h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1405i;

    /* renamed from: j  reason: collision with root package name */
    private float f1406j;

    /* renamed from: k  reason: collision with root package name */
    private float f1407k;

    /* renamed from: l  reason: collision with root package name */
    private int f1408l;

    private static float a(float f8, float f9, float f10) {
        return f8 + ((f9 - f8) * f10);
    }

    public void b(float f8) {
        if (this.f1406j != f8) {
            this.f1406j = f8;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float f8;
        float f9;
        float f10;
        int i8;
        Rect bounds = getBounds();
        int i9 = this.f1408l;
        boolean z7 = false;
        if (i9 != 0 && (i9 == 1 || (i9 == 3 ? DrawableCompat.f(this) == 0 : DrawableCompat.f(this) == 1))) {
            z7 = true;
        }
        float f11 = this.f1398b;
        float a8 = a(this.f1399c, (float) Math.sqrt(f11 * f11 * 2.0f), this.f1406j);
        float a9 = a(this.f1399c, this.f1400d, this.f1406j);
        float round = Math.round(a(0.0f, this.f1407k, this.f1406j));
        float a10 = a(0.0f, f1396m, this.f1406j);
        if (z7) {
            f8 = 0.0f;
        } else {
            f8 = -180.0f;
        }
        if (z7) {
            f9 = 180.0f;
        } else {
            f9 = 0.0f;
        }
        float a11 = a(f8, f9, this.f1406j);
        double d8 = a8;
        double d9 = a10;
        boolean z8 = z7;
        float round2 = (float) Math.round(Math.cos(d9) * d8);
        float round3 = (float) Math.round(d8 * Math.sin(d9));
        this.f1403g.rewind();
        float a12 = a(this.f1401e + this.f1397a.getStrokeWidth(), -this.f1407k, this.f1406j);
        float f12 = (-a9) / 2.0f;
        this.f1403g.moveTo(f12 + round, 0.0f);
        this.f1403g.rLineTo(a9 - (round * 2.0f), 0.0f);
        this.f1403g.moveTo(f12, a12);
        this.f1403g.rLineTo(round2, round3);
        this.f1403g.moveTo(f12, -a12);
        this.f1403g.rLineTo(round2, -round3);
        this.f1403g.close();
        canvas.save();
        float strokeWidth = this.f1397a.getStrokeWidth();
        float height = bounds.height() - (3.0f * strokeWidth);
        canvas.translate(bounds.centerX(), ((((int) (height - (2.0f * f10))) / 4) * 2) + (strokeWidth * 1.5f) + this.f1401e);
        if (this.f1402f) {
            if (this.f1405i ^ z8) {
                i8 = -1;
            } else {
                i8 = 1;
            }
            canvas.rotate(a11 * i8);
        } else if (z8) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.f1403g, this.f1397a);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f1404h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f1404h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i8) {
        if (i8 != this.f1397a.getAlpha()) {
            this.f1397a.setAlpha(i8);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1397a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
