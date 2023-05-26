package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.cardview.R$attr;
import androidx.cardview.R$color;
import androidx.cardview.R$style;
import androidx.cardview.R$styleable;

/* loaded from: classes.dex */
public class CardView extends FrameLayout {

    /* renamed from: m  reason: collision with root package name */
    private static final int[] f4215m = {16842801};

    /* renamed from: n  reason: collision with root package name */
    private static final CardViewImpl f4216n;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4217f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f4218g;

    /* renamed from: h  reason: collision with root package name */
    int f4219h;

    /* renamed from: i  reason: collision with root package name */
    int f4220i;

    /* renamed from: j  reason: collision with root package name */
    final Rect f4221j;

    /* renamed from: k  reason: collision with root package name */
    final Rect f4222k;

    /* renamed from: l  reason: collision with root package name */
    private final CardViewDelegate f4223l;

    static {
        CardViewApi21Impl cardViewApi21Impl = new CardViewApi21Impl();
        f4216n = cardViewApi21Impl;
        cardViewApi21Impl.l();
    }

    public CardView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.cardViewStyle);
    }

    public void d(int i8, int i9, int i10, int i11) {
        this.f4221j.set(i8, i9, i10, i11);
        f4216n.k(this.f4223l);
    }

    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return f4216n.e(this.f4223l);
    }

    public float getCardElevation() {
        return f4216n.i(this.f4223l);
    }

    public int getContentPaddingBottom() {
        return this.f4221j.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f4221j.left;
    }

    public int getContentPaddingRight() {
        return this.f4221j.right;
    }

    public int getContentPaddingTop() {
        return this.f4221j.top;
    }

    public float getMaxCardElevation() {
        return f4216n.d(this.f4223l);
    }

    public boolean getPreventCornerOverlap() {
        return this.f4218g;
    }

    public float getRadius() {
        return f4216n.b(this.f4223l);
    }

    public boolean getUseCompatPadding() {
        return this.f4217f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i8, int i9) {
        CardViewImpl cardViewImpl = f4216n;
        if (!(cardViewImpl instanceof CardViewApi21Impl)) {
            int mode = View.MeasureSpec.getMode(i8);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i8 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(cardViewImpl.m(this.f4223l)), View.MeasureSpec.getSize(i8)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i9);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i9 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(cardViewImpl.f(this.f4223l)), View.MeasureSpec.getSize(i9)), mode2);
            }
            super.onMeasure(i8, i9);
            return;
        }
        super.onMeasure(i8, i9);
    }

    public void setCardBackgroundColor(int i8) {
        f4216n.n(this.f4223l, ColorStateList.valueOf(i8));
    }

    public void setCardElevation(float f8) {
        f4216n.c(this.f4223l, f8);
    }

    public void setMaxCardElevation(float f8) {
        f4216n.o(this.f4223l, f8);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i8) {
        this.f4220i = i8;
        super.setMinimumHeight(i8);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i8) {
        this.f4219h = i8;
        super.setMinimumWidth(i8);
    }

    @Override // android.view.View
    public void setPadding(int i8, int i9, int i10, int i11) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i8, int i9, int i10, int i11) {
    }

    public void setPreventCornerOverlap(boolean z7) {
        if (z7 != this.f4218g) {
            this.f4218g = z7;
            f4216n.g(this.f4223l);
        }
    }

    public void setRadius(float f8) {
        f4216n.a(this.f4223l, f8);
    }

    public void setUseCompatPadding(boolean z7) {
        if (this.f4217f != z7) {
            this.f4217f = z7;
            f4216n.j(this.f4223l);
        }
    }

    public CardView(@NonNull Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        int color;
        ColorStateList valueOf;
        Rect rect = new Rect();
        this.f4221j = rect;
        this.f4222k = new Rect();
        CardViewDelegate cardViewDelegate = new CardViewDelegate() { // from class: androidx.cardview.widget.CardView.1

            /* renamed from: a  reason: collision with root package name */
            private Drawable f4224a;

            @Override // androidx.cardview.widget.CardViewDelegate
            public void a(int i9, int i10, int i11, int i12) {
                CardView.this.f4222k.set(i9, i10, i11, i12);
                CardView cardView = CardView.this;
                Rect rect2 = cardView.f4221j;
                CardView.super.setPadding(i9 + rect2.left, i10 + rect2.top, i11 + rect2.right, i12 + rect2.bottom);
            }

            @Override // androidx.cardview.widget.CardViewDelegate
            public void b(Drawable drawable) {
                this.f4224a = drawable;
                CardView.this.setBackgroundDrawable(drawable);
            }

            @Override // androidx.cardview.widget.CardViewDelegate
            public boolean c() {
                return CardView.this.getUseCompatPadding();
            }

            @Override // androidx.cardview.widget.CardViewDelegate
            public Drawable d() {
                return this.f4224a;
            }

            @Override // androidx.cardview.widget.CardViewDelegate
            public boolean e() {
                return CardView.this.getPreventCornerOverlap();
            }

            @Override // androidx.cardview.widget.CardViewDelegate
            public View f() {
                return CardView.this;
            }
        };
        this.f4223l = cardViewDelegate;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f4201a, i8, R$style.f4200a);
        int i9 = R$styleable.f4204d;
        if (obtainStyledAttributes.hasValue(i9)) {
            valueOf = obtainStyledAttributes.getColorStateList(i9);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f4215m);
            int color2 = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            if (fArr[2] > 0.5f) {
                color = getResources().getColor(R$color.cardview_light_background);
            } else {
                color = getResources().getColor(R$color.cardview_dark_background);
            }
            valueOf = ColorStateList.valueOf(color);
        }
        ColorStateList colorStateList = valueOf;
        float dimension = obtainStyledAttributes.getDimension(R$styleable.f4205e, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(R$styleable.f4206f, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(R$styleable.f4207g, 0.0f);
        this.f4217f = obtainStyledAttributes.getBoolean(R$styleable.f4209i, false);
        this.f4218g = obtainStyledAttributes.getBoolean(R$styleable.f4208h, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f4210j, 0);
        rect.left = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f4212l, dimensionPixelSize);
        rect.top = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f4214n, dimensionPixelSize);
        rect.right = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f4213m, dimensionPixelSize);
        rect.bottom = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f4211k, dimensionPixelSize);
        float f8 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f4219h = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f4202b, 0);
        this.f4220i = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f4203c, 0);
        obtainStyledAttributes.recycle();
        f4216n.h(cardViewDelegate, context, colorStateList, dimension, dimension2, f8);
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f4216n.n(this.f4223l, colorStateList);
    }
}
