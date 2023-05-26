package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
class RoundRectDrawable extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private float f4226a;

    /* renamed from: c  reason: collision with root package name */
    private final RectF f4228c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f4229d;

    /* renamed from: e  reason: collision with root package name */
    private float f4230e;

    /* renamed from: h  reason: collision with root package name */
    private ColorStateList f4233h;

    /* renamed from: i  reason: collision with root package name */
    private PorterDuffColorFilter f4234i;

    /* renamed from: j  reason: collision with root package name */
    private ColorStateList f4235j;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4231f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f4232g = true;

    /* renamed from: k  reason: collision with root package name */
    private PorterDuff.Mode f4236k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f4227b = new Paint(5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public RoundRectDrawable(ColorStateList colorStateList, float f8) {
        this.f4226a = f8;
        e(colorStateList);
        this.f4228c = new RectF();
        this.f4229d = new Rect();
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList != null && mode != null) {
            return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
        }
        return null;
    }

    private void e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f4233h = colorStateList;
        this.f4227b.setColor(colorStateList.getColorForState(getState(), this.f4233h.getDefaultColor()));
    }

    private void i(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f4228c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f4229d.set(rect);
        if (this.f4231f) {
            float b8 = RoundRectDrawableWithShadow.b(this.f4230e, this.f4226a, this.f4232g);
            this.f4229d.inset((int) Math.ceil(RoundRectDrawableWithShadow.a(this.f4230e, this.f4226a, this.f4232g)), (int) Math.ceil(b8));
            this.f4228c.set(this.f4229d);
        }
    }

    public ColorStateList b() {
        return this.f4233h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c() {
        return this.f4230e;
    }

    public float d() {
        return this.f4226a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z7;
        Paint paint = this.f4227b;
        if (this.f4234i != null && paint.getColorFilter() == null) {
            paint.setColorFilter(this.f4234i);
            z7 = true;
        } else {
            z7 = false;
        }
        RectF rectF = this.f4228c;
        float f8 = this.f4226a;
        canvas.drawRoundRect(rectF, f8, f8, paint);
        if (z7) {
            paint.setColorFilter(null);
        }
    }

    public void f(ColorStateList colorStateList) {
        e(colorStateList);
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(float f8, boolean z7, boolean z8) {
        if (f8 == this.f4230e && this.f4231f == z7 && this.f4232g == z8) {
            return;
        }
        this.f4230e = f8;
        this.f4231f = z7;
        this.f4232g = z8;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f4229d, this.f4226a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(float f8) {
        if (f8 == this.f4226a) {
            return;
        }
        this.f4226a = f8;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f4235j;
        if ((colorStateList2 != null && colorStateList2.isStateful()) || (((colorStateList = this.f4233h) != null && colorStateList.isStateful()) || super.isStateful())) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        i(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean z7;
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f4233h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (colorForState != this.f4227b.getColor()) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            this.f4227b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f4235j;
        if (colorStateList2 != null && (mode = this.f4236k) != null) {
            this.f4234i = a(colorStateList2, mode);
            return true;
        }
        return z7;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i8) {
        this.f4227b.setAlpha(i8);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f4227b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f4235j = colorStateList;
        this.f4234i = a(colorStateList, this.f4236k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f4236k = mode;
        this.f4234i = a(this.f4235j, mode);
        invalidateSelf();
    }
}
