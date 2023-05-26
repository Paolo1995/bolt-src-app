package com.google.android.material.imageview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.R$style;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.shape.Shapeable;

/* loaded from: classes.dex */
public class ShapeableImageView extends AppCompatImageView implements Shapeable {

    /* renamed from: x  reason: collision with root package name */
    private static final int f13505x = R$style.Widget_MaterialComponents_ShapeableImageView;

    /* renamed from: f  reason: collision with root package name */
    private final ShapeAppearancePathProvider f13506f;

    /* renamed from: g  reason: collision with root package name */
    private final RectF f13507g;

    /* renamed from: h  reason: collision with root package name */
    private final RectF f13508h;

    /* renamed from: i  reason: collision with root package name */
    private final Paint f13509i;

    /* renamed from: j  reason: collision with root package name */
    private final Paint f13510j;

    /* renamed from: k  reason: collision with root package name */
    private final Path f13511k;

    /* renamed from: l  reason: collision with root package name */
    private ColorStateList f13512l;

    /* renamed from: m  reason: collision with root package name */
    private MaterialShapeDrawable f13513m;

    /* renamed from: n  reason: collision with root package name */
    private ShapeAppearanceModel f13514n;

    /* renamed from: o  reason: collision with root package name */
    private float f13515o;

    /* renamed from: p  reason: collision with root package name */
    private Path f13516p;

    /* renamed from: q  reason: collision with root package name */
    private int f13517q;

    /* renamed from: r  reason: collision with root package name */
    private int f13518r;

    /* renamed from: s  reason: collision with root package name */
    private int f13519s;

    /* renamed from: t  reason: collision with root package name */
    private int f13520t;

    /* renamed from: u  reason: collision with root package name */
    private int f13521u;

    /* renamed from: v  reason: collision with root package name */
    private int f13522v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f13523w;

    @TargetApi(21)
    /* loaded from: classes.dex */
    class OutlineProvider extends ViewOutlineProvider {

        /* renamed from: a  reason: collision with root package name */
        private final Rect f13524a = new Rect();

        OutlineProvider() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (ShapeableImageView.this.f13514n == null) {
                return;
            }
            if (ShapeableImageView.this.f13513m == null) {
                ShapeableImageView.this.f13513m = new MaterialShapeDrawable(ShapeableImageView.this.f13514n);
            }
            ShapeableImageView.this.f13507g.round(this.f13524a);
            ShapeableImageView.this.f13513m.setBounds(this.f13524a);
            ShapeableImageView.this.f13513m.getOutline(outline);
        }
    }

    public ShapeableImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void g(Canvas canvas) {
        if (this.f13512l == null) {
            return;
        }
        this.f13509i.setStrokeWidth(this.f13515o);
        int colorForState = this.f13512l.getColorForState(getDrawableState(), this.f13512l.getDefaultColor());
        if (this.f13515o > 0.0f && colorForState != 0) {
            this.f13509i.setColor(colorForState);
            canvas.drawPath(this.f13511k, this.f13509i);
        }
    }

    private boolean h() {
        if (this.f13521u == Integer.MIN_VALUE && this.f13522v == Integer.MIN_VALUE) {
            return false;
        }
        return true;
    }

    private boolean i() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    private void j(int i8, int i9) {
        this.f13507g.set(getPaddingLeft(), getPaddingTop(), i8 - getPaddingRight(), i9 - getPaddingBottom());
        this.f13506f.d(this.f13514n, 1.0f, this.f13507g, this.f13511k);
        this.f13516p.rewind();
        this.f13516p.addPath(this.f13511k);
        this.f13508h.set(0.0f, 0.0f, i8, i9);
        this.f13516p.addRect(this.f13508h, Path.Direction.CCW);
    }

    public int getContentPaddingBottom() {
        return this.f13520t;
    }

    public final int getContentPaddingEnd() {
        int i8 = this.f13522v;
        if (i8 != Integer.MIN_VALUE) {
            return i8;
        }
        if (i()) {
            return this.f13517q;
        }
        return this.f13519s;
    }

    public int getContentPaddingLeft() {
        int i8;
        int i9;
        if (h()) {
            if (i() && (i9 = this.f13522v) != Integer.MIN_VALUE) {
                return i9;
            }
            if (!i() && (i8 = this.f13521u) != Integer.MIN_VALUE) {
                return i8;
            }
        }
        return this.f13517q;
    }

    public int getContentPaddingRight() {
        int i8;
        int i9;
        if (h()) {
            if (i() && (i9 = this.f13521u) != Integer.MIN_VALUE) {
                return i9;
            }
            if (!i() && (i8 = this.f13522v) != Integer.MIN_VALUE) {
                return i8;
            }
        }
        return this.f13519s;
    }

    public final int getContentPaddingStart() {
        int i8 = this.f13521u;
        if (i8 != Integer.MIN_VALUE) {
            return i8;
        }
        if (i()) {
            return this.f13519s;
        }
        return this.f13517q;
    }

    public int getContentPaddingTop() {
        return this.f13518r;
    }

    @Override // android.view.View
    public int getPaddingBottom() {
        return super.getPaddingBottom() - getContentPaddingBottom();
    }

    @Override // android.view.View
    public int getPaddingEnd() {
        return super.getPaddingEnd() - getContentPaddingEnd();
    }

    @Override // android.view.View
    public int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    @Override // android.view.View
    public int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    @Override // android.view.View
    public int getPaddingStart() {
        return super.getPaddingStart() - getContentPaddingStart();
    }

    @Override // android.view.View
    public int getPaddingTop() {
        return super.getPaddingTop() - getContentPaddingTop();
    }

    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.f13514n;
    }

    public ColorStateList getStrokeColor() {
        return this.f13512l;
    }

    public float getStrokeWidth() {
        return this.f13515o;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f13516p, this.f13510j);
        g(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        if (this.f13523w || !isLayoutDirectionResolved()) {
            return;
        }
        this.f13523w = true;
        if (!isPaddingRelative() && !h()) {
            setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
        } else {
            setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        j(i8, i9);
    }

    @Override // android.view.View
    public void setPadding(int i8, int i9, int i10, int i11) {
        super.setPadding(i8 + getContentPaddingLeft(), i9 + getContentPaddingTop(), i10 + getContentPaddingRight(), i11 + getContentPaddingBottom());
    }

    @Override // android.view.View
    public void setPaddingRelative(int i8, int i9, int i10, int i11) {
        super.setPaddingRelative(i8 + getContentPaddingStart(), i9 + getContentPaddingTop(), i10 + getContentPaddingEnd(), i11 + getContentPaddingBottom());
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.f13514n = shapeAppearanceModel;
        MaterialShapeDrawable materialShapeDrawable = this.f13513m;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
        j(getWidth(), getHeight());
        invalidate();
        invalidateOutline();
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.f13512l = colorStateList;
        invalidate();
    }

    public void setStrokeColorResource(int i8) {
        setStrokeColor(AppCompatResources.a(getContext(), i8));
    }

    public void setStrokeWidth(float f8) {
        if (this.f13515o != f8) {
            this.f13515o = f8;
            invalidate();
        }
    }

    public void setStrokeWidthResource(int i8) {
        setStrokeWidth(getResources().getDimensionPixelSize(i8));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ShapeableImageView(android.content.Context r7, android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r0 = com.google.android.material.imageview.ShapeableImageView.f13505x
            android.content.Context r7 = com.google.android.material.theme.overlay.MaterialThemeOverlay.c(r7, r8, r9, r0)
            r6.<init>(r7, r8, r9)
            com.google.android.material.shape.ShapeAppearancePathProvider r7 = com.google.android.material.shape.ShapeAppearancePathProvider.k()
            r6.f13506f = r7
            android.graphics.Path r7 = new android.graphics.Path
            r7.<init>()
            r6.f13511k = r7
            r7 = 0
            r6.f13523w = r7
            android.content.Context r1 = r6.getContext()
            android.graphics.Paint r2 = new android.graphics.Paint
            r2.<init>()
            r6.f13510j = r2
            r3 = 1
            r2.setAntiAlias(r3)
            r4 = -1
            r2.setColor(r4)
            android.graphics.PorterDuffXfermode r4 = new android.graphics.PorterDuffXfermode
            android.graphics.PorterDuff$Mode r5 = android.graphics.PorterDuff.Mode.DST_OUT
            r4.<init>(r5)
            r2.setXfermode(r4)
            android.graphics.RectF r2 = new android.graphics.RectF
            r2.<init>()
            r6.f13507g = r2
            android.graphics.RectF r2 = new android.graphics.RectF
            r2.<init>()
            r6.f13508h = r2
            android.graphics.Path r2 = new android.graphics.Path
            r2.<init>()
            r6.f13516p = r2
            int[] r2 = com.google.android.material.R$styleable.f12502a6
            android.content.res.TypedArray r2 = r1.obtainStyledAttributes(r8, r2, r9, r0)
            r4 = 2
            r5 = 0
            r6.setLayerType(r4, r5)
            int r4 = com.google.android.material.R$styleable.f12574i6
            android.content.res.ColorStateList r4 = com.google.android.material.resources.MaterialResources.a(r1, r2, r4)
            r6.f13512l = r4
            int r4 = com.google.android.material.R$styleable.f12583j6
            int r4 = r2.getDimensionPixelSize(r4, r7)
            float r4 = (float) r4
            r6.f13515o = r4
            int r4 = com.google.android.material.R$styleable.f12511b6
            int r7 = r2.getDimensionPixelSize(r4, r7)
            r6.f13517q = r7
            r6.f13518r = r7
            r6.f13519s = r7
            r6.f13520t = r7
            int r4 = com.google.android.material.R$styleable.f12538e6
            int r4 = r2.getDimensionPixelSize(r4, r7)
            r6.f13517q = r4
            int r4 = com.google.android.material.R$styleable.f12565h6
            int r4 = r2.getDimensionPixelSize(r4, r7)
            r6.f13518r = r4
            int r4 = com.google.android.material.R$styleable.f12547f6
            int r4 = r2.getDimensionPixelSize(r4, r7)
            r6.f13519s = r4
            int r4 = com.google.android.material.R$styleable.f12520c6
            int r7 = r2.getDimensionPixelSize(r4, r7)
            r6.f13520t = r7
            int r7 = com.google.android.material.R$styleable.f12556g6
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            int r7 = r2.getDimensionPixelSize(r7, r4)
            r6.f13521u = r7
            int r7 = com.google.android.material.R$styleable.f12529d6
            int r7 = r2.getDimensionPixelSize(r7, r4)
            r6.f13522v = r7
            r2.recycle()
            android.graphics.Paint r7 = new android.graphics.Paint
            r7.<init>()
            r6.f13509i = r7
            android.graphics.Paint$Style r2 = android.graphics.Paint.Style.STROKE
            r7.setStyle(r2)
            r7.setAntiAlias(r3)
            com.google.android.material.shape.ShapeAppearanceModel$Builder r7 = com.google.android.material.shape.ShapeAppearanceModel.e(r1, r8, r9, r0)
            com.google.android.material.shape.ShapeAppearanceModel r7 = r7.m()
            r6.f13514n = r7
            com.google.android.material.imageview.ShapeableImageView$OutlineProvider r7 = new com.google.android.material.imageview.ShapeableImageView$OutlineProvider
            r7.<init>()
            r6.setOutlineProvider(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.imageview.ShapeableImageView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
