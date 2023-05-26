package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.R$styleable;

/* loaded from: classes.dex */
public class ImageFilterView extends AppCompatImageView {

    /* renamed from: f  reason: collision with root package name */
    private ImageMatrix f4917f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f4918g;

    /* renamed from: h  reason: collision with root package name */
    private Drawable f4919h;

    /* renamed from: i  reason: collision with root package name */
    private Drawable f4920i;

    /* renamed from: j  reason: collision with root package name */
    private float f4921j;

    /* renamed from: k  reason: collision with root package name */
    private float f4922k;

    /* renamed from: l  reason: collision with root package name */
    private float f4923l;

    /* renamed from: m  reason: collision with root package name */
    private Path f4924m;

    /* renamed from: n  reason: collision with root package name */
    ViewOutlineProvider f4925n;

    /* renamed from: o  reason: collision with root package name */
    RectF f4926o;

    /* renamed from: p  reason: collision with root package name */
    Drawable[] f4927p;

    /* renamed from: q  reason: collision with root package name */
    LayerDrawable f4928q;

    /* renamed from: r  reason: collision with root package name */
    float f4929r;

    /* renamed from: s  reason: collision with root package name */
    float f4930s;

    /* renamed from: t  reason: collision with root package name */
    float f4931t;

    /* renamed from: u  reason: collision with root package name */
    float f4932u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ImageMatrix {

        /* renamed from: a  reason: collision with root package name */
        float[] f4935a = new float[20];

        /* renamed from: b  reason: collision with root package name */
        ColorMatrix f4936b = new ColorMatrix();

        /* renamed from: c  reason: collision with root package name */
        ColorMatrix f4937c = new ColorMatrix();

        /* renamed from: d  reason: collision with root package name */
        float f4938d = 1.0f;

        /* renamed from: e  reason: collision with root package name */
        float f4939e = 1.0f;

        /* renamed from: f  reason: collision with root package name */
        float f4940f = 1.0f;

        /* renamed from: g  reason: collision with root package name */
        float f4941g = 1.0f;

        ImageMatrix() {
        }

        private void a(float f8) {
            float[] fArr = this.f4935a;
            fArr[0] = f8;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = f8;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = f8;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void b(float f8) {
            float f9 = 1.0f - f8;
            float f10 = 0.2999f * f9;
            float f11 = 0.587f * f9;
            float f12 = f9 * 0.114f;
            float[] fArr = this.f4935a;
            fArr[0] = f10 + f8;
            fArr[1] = f11;
            fArr[2] = f12;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = f10;
            fArr[6] = f11 + f8;
            fArr[7] = f12;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = f10;
            fArr[11] = f11;
            fArr[12] = f12 + f8;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void d(float f8) {
            float log;
            float f9;
            float f10;
            if (f8 <= 0.0f) {
                f8 = 0.01f;
            }
            float f11 = (5000.0f / f8) / 100.0f;
            if (f11 > 66.0f) {
                double d8 = f11 - 60.0f;
                f9 = ((float) Math.pow(d8, -0.13320475816726685d)) * 329.69873f;
                log = ((float) Math.pow(d8, 0.07551484555006027d)) * 288.12216f;
            } else {
                log = (((float) Math.log(f11)) * 99.4708f) - 161.11957f;
                f9 = 255.0f;
            }
            if (f11 < 66.0f) {
                if (f11 > 19.0f) {
                    f10 = (((float) Math.log(f11 - 10.0f)) * 138.51773f) - 305.0448f;
                } else {
                    f10 = 0.0f;
                }
            } else {
                f10 = 255.0f;
            }
            float min = Math.min(255.0f, Math.max(f9, 0.0f));
            float min2 = Math.min(255.0f, Math.max(log, 0.0f));
            float min3 = Math.min(255.0f, Math.max(f10, 0.0f));
            float min4 = Math.min(255.0f, Math.max(255.0f, 0.0f));
            float min5 = Math.min(255.0f, Math.max((((float) Math.log(50.0f)) * 99.4708f) - 161.11957f, 0.0f));
            float min6 = min3 / Math.min(255.0f, Math.max((((float) Math.log(40.0f)) * 138.51773f) - 305.0448f, 0.0f));
            float[] fArr = this.f4935a;
            fArr[0] = min / min4;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = min2 / min5;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = min6;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        void c(ImageView imageView) {
            boolean z7;
            this.f4936b.reset();
            float f8 = this.f4939e;
            boolean z8 = true;
            if (f8 != 1.0f) {
                b(f8);
                this.f4936b.set(this.f4935a);
                z7 = true;
            } else {
                z7 = false;
            }
            float f9 = this.f4940f;
            if (f9 != 1.0f) {
                this.f4937c.setScale(f9, f9, f9, 1.0f);
                this.f4936b.postConcat(this.f4937c);
                z7 = true;
            }
            float f10 = this.f4941g;
            if (f10 != 1.0f) {
                d(f10);
                this.f4937c.set(this.f4935a);
                this.f4936b.postConcat(this.f4937c);
                z7 = true;
            }
            float f11 = this.f4938d;
            if (f11 != 1.0f) {
                a(f11);
                this.f4937c.set(this.f4935a);
                this.f4936b.postConcat(this.f4937c);
            } else {
                z8 = z7;
            }
            if (z8) {
                imageView.setColorFilter(new ColorMatrixColorFilter(this.f4936b));
            } else {
                imageView.clearColorFilter();
            }
        }
    }

    public ImageFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4917f = new ImageMatrix();
        this.f4918g = true;
        this.f4919h = null;
        this.f4920i = null;
        this.f4921j = 0.0f;
        this.f4922k = 0.0f;
        this.f4923l = Float.NaN;
        this.f4927p = new Drawable[2];
        this.f4929r = Float.NaN;
        this.f4930s = Float.NaN;
        this.f4931t = Float.NaN;
        this.f4932u = Float.NaN;
        e(context, attributeSet);
    }

    private void e(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.f5316o5);
            int indexCount = obtainStyledAttributes.getIndexCount();
            this.f4919h = obtainStyledAttributes.getDrawable(R$styleable.f5325p5);
            for (int i8 = 0; i8 < indexCount; i8++) {
                int index = obtainStyledAttributes.getIndex(i8);
                if (index == R$styleable.f5351s5) {
                    this.f4921j = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R$styleable.B5) {
                    setWarmth(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.A5) {
                    setSaturation(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.f5343r5) {
                    setContrast(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.f5334q5) {
                    setBrightness(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.f5399y5) {
                    setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R$styleable.f5407z5) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.f5391x5) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.f4918g));
                } else if (index == R$styleable.f5359t5) {
                    setImagePanX(obtainStyledAttributes.getFloat(index, this.f4929r));
                } else if (index == R$styleable.f5367u5) {
                    setImagePanY(obtainStyledAttributes.getFloat(index, this.f4930s));
                } else if (index == R$styleable.f5375v5) {
                    setImageRotate(obtainStyledAttributes.getFloat(index, this.f4932u));
                } else if (index == R$styleable.f5383w5) {
                    setImageZoom(obtainStyledAttributes.getFloat(index, this.f4931t));
                }
            }
            obtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.f4920i = drawable;
            if (this.f4919h != null && drawable != null) {
                Drawable[] drawableArr = this.f4927p;
                Drawable mutate = getDrawable().mutate();
                this.f4920i = mutate;
                drawableArr[0] = mutate;
                this.f4927p[1] = this.f4919h.mutate();
                LayerDrawable layerDrawable = new LayerDrawable(this.f4927p);
                this.f4928q = layerDrawable;
                layerDrawable.getDrawable(1).setAlpha((int) (this.f4921j * 255.0f));
                if (!this.f4918g) {
                    this.f4928q.getDrawable(0).setAlpha((int) ((1.0f - this.f4921j) * 255.0f));
                }
                super.setImageDrawable(this.f4928q);
                return;
            }
            Drawable drawable2 = getDrawable();
            this.f4920i = drawable2;
            if (drawable2 != null) {
                Drawable[] drawableArr2 = this.f4927p;
                Drawable mutate2 = drawable2.mutate();
                this.f4920i = mutate2;
                drawableArr2[0] = mutate2;
            }
        }
    }

    private void f() {
        float f8;
        float f9;
        float f10;
        float f11;
        if (Float.isNaN(this.f4929r) && Float.isNaN(this.f4930s) && Float.isNaN(this.f4931t) && Float.isNaN(this.f4932u)) {
            return;
        }
        float f12 = 0.0f;
        if (Float.isNaN(this.f4929r)) {
            f8 = 0.0f;
        } else {
            f8 = this.f4929r;
        }
        if (Float.isNaN(this.f4930s)) {
            f9 = 0.0f;
        } else {
            f9 = this.f4930s;
        }
        if (Float.isNaN(this.f4931t)) {
            f10 = 1.0f;
        } else {
            f10 = this.f4931t;
        }
        if (!Float.isNaN(this.f4932u)) {
            f12 = this.f4932u;
        }
        Matrix matrix = new Matrix();
        matrix.reset();
        float intrinsicWidth = getDrawable().getIntrinsicWidth();
        float intrinsicHeight = getDrawable().getIntrinsicHeight();
        float width = getWidth();
        float height = getHeight();
        if (intrinsicWidth * height < intrinsicHeight * width) {
            f11 = width / intrinsicWidth;
        } else {
            f11 = height / intrinsicHeight;
        }
        float f13 = f10 * f11;
        matrix.postScale(f13, f13);
        float f14 = intrinsicWidth * f13;
        float f15 = f13 * intrinsicHeight;
        matrix.postTranslate((((f8 * (width - f14)) + width) - f14) * 0.5f, (((f9 * (height - f15)) + height) - f15) * 0.5f);
        matrix.postRotate(f12, width / 2.0f, height / 2.0f);
        setImageMatrix(matrix);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    private void g() {
        if (Float.isNaN(this.f4929r) && Float.isNaN(this.f4930s) && Float.isNaN(this.f4931t) && Float.isNaN(this.f4932u)) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            f();
        }
    }

    private void setOverlay(boolean z7) {
        this.f4918g = z7;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getBrightness() {
        return this.f4917f.f4938d;
    }

    public float getContrast() {
        return this.f4917f.f4940f;
    }

    public float getCrossfade() {
        return this.f4921j;
    }

    public float getImagePanX() {
        return this.f4929r;
    }

    public float getImagePanY() {
        return this.f4930s;
    }

    public float getImageRotate() {
        return this.f4932u;
    }

    public float getImageZoom() {
        return this.f4931t;
    }

    public float getRound() {
        return this.f4923l;
    }

    public float getRoundPercent() {
        return this.f4922k;
    }

    public float getSaturation() {
        return this.f4917f.f4939e;
    }

    public float getWarmth() {
        return this.f4917f.f4941g;
    }

    @Override // android.view.View
    public void layout(int i8, int i9, int i10, int i11) {
        super.layout(i8, i9, i10, i11);
        f();
    }

    public void setAltImageResource(int i8) {
        Drawable mutate = AppCompatResources.b(getContext(), i8).mutate();
        this.f4919h = mutate;
        Drawable[] drawableArr = this.f4927p;
        drawableArr[0] = this.f4920i;
        drawableArr[1] = mutate;
        LayerDrawable layerDrawable = new LayerDrawable(this.f4927p);
        this.f4928q = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f4921j);
    }

    public void setBrightness(float f8) {
        ImageMatrix imageMatrix = this.f4917f;
        imageMatrix.f4938d = f8;
        imageMatrix.c(this);
    }

    public void setContrast(float f8) {
        ImageMatrix imageMatrix = this.f4917f;
        imageMatrix.f4940f = f8;
        imageMatrix.c(this);
    }

    public void setCrossfade(float f8) {
        this.f4921j = f8;
        if (this.f4927p != null) {
            if (!this.f4918g) {
                this.f4928q.getDrawable(0).setAlpha((int) ((1.0f - this.f4921j) * 255.0f));
            }
            this.f4928q.getDrawable(1).setAlpha((int) (this.f4921j * 255.0f));
            super.setImageDrawable(this.f4928q);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.f4919h != null && drawable != null) {
            Drawable mutate = drawable.mutate();
            this.f4920i = mutate;
            Drawable[] drawableArr = this.f4927p;
            drawableArr[0] = mutate;
            drawableArr[1] = this.f4919h;
            LayerDrawable layerDrawable = new LayerDrawable(this.f4927p);
            this.f4928q = layerDrawable;
            super.setImageDrawable(layerDrawable);
            setCrossfade(this.f4921j);
            return;
        }
        super.setImageDrawable(drawable);
    }

    public void setImagePanX(float f8) {
        this.f4929r = f8;
        g();
    }

    public void setImagePanY(float f8) {
        this.f4930s = f8;
        g();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i8) {
        if (this.f4919h != null) {
            Drawable mutate = AppCompatResources.b(getContext(), i8).mutate();
            this.f4920i = mutate;
            Drawable[] drawableArr = this.f4927p;
            drawableArr[0] = mutate;
            drawableArr[1] = this.f4919h;
            LayerDrawable layerDrawable = new LayerDrawable(this.f4927p);
            this.f4928q = layerDrawable;
            super.setImageDrawable(layerDrawable);
            setCrossfade(this.f4921j);
            return;
        }
        super.setImageResource(i8);
    }

    public void setImageRotate(float f8) {
        this.f4932u = f8;
        g();
    }

    public void setImageZoom(float f8) {
        this.f4931t = f8;
        g();
    }

    public void setRound(float f8) {
        boolean z7;
        if (Float.isNaN(f8)) {
            this.f4923l = f8;
            float f9 = this.f4922k;
            this.f4922k = -1.0f;
            setRoundPercent(f9);
            return;
        }
        if (this.f4923l != f8) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.f4923l = f8;
        if (f8 != 0.0f) {
            if (this.f4924m == null) {
                this.f4924m = new Path();
            }
            if (this.f4926o == null) {
                this.f4926o = new RectF();
            }
            if (this.f4925n == null) {
                ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.ImageFilterView.2
                    @Override // android.view.ViewOutlineProvider
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), ImageFilterView.this.f4923l);
                    }
                };
                this.f4925n = viewOutlineProvider;
                setOutlineProvider(viewOutlineProvider);
            }
            setClipToOutline(true);
            this.f4926o.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f4924m.reset();
            Path path = this.f4924m;
            RectF rectF = this.f4926o;
            float f10 = this.f4923l;
            path.addRoundRect(rectF, f10, f10, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z7) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f8) {
        boolean z7;
        if (this.f4922k != f8) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.f4922k = f8;
        if (f8 != 0.0f) {
            if (this.f4924m == null) {
                this.f4924m = new Path();
            }
            if (this.f4926o == null) {
                this.f4926o = new RectF();
            }
            if (this.f4925n == null) {
                ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.ImageFilterView.1
                    @Override // android.view.ViewOutlineProvider
                    public void getOutline(View view, Outline outline) {
                        int width = ImageFilterView.this.getWidth();
                        int height = ImageFilterView.this.getHeight();
                        outline.setRoundRect(0, 0, width, height, (Math.min(width, height) * ImageFilterView.this.f4922k) / 2.0f);
                    }
                };
                this.f4925n = viewOutlineProvider;
                setOutlineProvider(viewOutlineProvider);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.f4922k) / 2.0f;
            this.f4926o.set(0.0f, 0.0f, width, height);
            this.f4924m.reset();
            this.f4924m.addRoundRect(this.f4926o, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z7) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f8) {
        ImageMatrix imageMatrix = this.f4917f;
        imageMatrix.f4939e = f8;
        imageMatrix.c(this);
    }

    public void setWarmth(float f8) {
        ImageMatrix imageMatrix = this.f4917f;
        imageMatrix.f4941g = f8;
        imageMatrix.c(this);
    }
}
