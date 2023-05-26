package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.material.R$styleable;

/* loaded from: classes.dex */
public class TextAppearance {

    /* renamed from: a  reason: collision with root package name */
    public final ColorStateList f13875a;

    /* renamed from: b  reason: collision with root package name */
    public final ColorStateList f13876b;

    /* renamed from: c  reason: collision with root package name */
    public final ColorStateList f13877c;

    /* renamed from: d  reason: collision with root package name */
    public final String f13878d;

    /* renamed from: e  reason: collision with root package name */
    public final int f13879e;

    /* renamed from: f  reason: collision with root package name */
    public final int f13880f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f13881g;

    /* renamed from: h  reason: collision with root package name */
    public final float f13882h;

    /* renamed from: i  reason: collision with root package name */
    public final float f13883i;

    /* renamed from: j  reason: collision with root package name */
    public final float f13884j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f13885k;

    /* renamed from: l  reason: collision with root package name */
    public final float f13886l;

    /* renamed from: m  reason: collision with root package name */
    private ColorStateList f13887m;

    /* renamed from: n  reason: collision with root package name */
    private float f13888n;

    /* renamed from: o  reason: collision with root package name */
    private final int f13889o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f13890p = false;

    /* renamed from: q  reason: collision with root package name */
    private Typeface f13891q;

    public TextAppearance(@NonNull Context context, int i8) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i8, R$styleable.f12620n7);
        l(obtainStyledAttributes.getDimension(R$styleable.f12629o7, 0.0f));
        k(MaterialResources.a(context, obtainStyledAttributes, R$styleable.r7));
        this.f13875a = MaterialResources.a(context, obtainStyledAttributes, R$styleable.s7);
        this.f13876b = MaterialResources.a(context, obtainStyledAttributes, R$styleable.t7);
        this.f13879e = obtainStyledAttributes.getInt(R$styleable.f12647q7, 0);
        this.f13880f = obtainStyledAttributes.getInt(R$styleable.f12638p7, 1);
        int f8 = MaterialResources.f(obtainStyledAttributes, R$styleable.z7, R$styleable.y7);
        this.f13889o = obtainStyledAttributes.getResourceId(f8, 0);
        this.f13878d = obtainStyledAttributes.getString(f8);
        this.f13881g = obtainStyledAttributes.getBoolean(R$styleable.A7, false);
        this.f13877c = MaterialResources.a(context, obtainStyledAttributes, R$styleable.u7);
        this.f13882h = obtainStyledAttributes.getFloat(R$styleable.v7, 0.0f);
        this.f13883i = obtainStyledAttributes.getFloat(R$styleable.w7, 0.0f);
        this.f13884j = obtainStyledAttributes.getFloat(R$styleable.x7, 0.0f);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i8, R$styleable.Y4);
        int i9 = R$styleable.Z4;
        this.f13885k = obtainStyledAttributes2.hasValue(i9);
        this.f13886l = obtainStyledAttributes2.getFloat(i9, 0.0f);
        obtainStyledAttributes2.recycle();
    }

    private void d() {
        String str;
        if (this.f13891q == null && (str = this.f13878d) != null) {
            this.f13891q = Typeface.create(str, this.f13879e);
        }
        if (this.f13891q == null) {
            int i8 = this.f13880f;
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 != 3) {
                        this.f13891q = Typeface.DEFAULT;
                    } else {
                        this.f13891q = Typeface.MONOSPACE;
                    }
                } else {
                    this.f13891q = Typeface.SERIF;
                }
            } else {
                this.f13891q = Typeface.SANS_SERIF;
            }
            this.f13891q = Typeface.create(this.f13891q, this.f13879e);
        }
    }

    private boolean m(Context context) {
        Typeface typeface;
        if (TextAppearanceConfig.a()) {
            return true;
        }
        int i8 = this.f13889o;
        if (i8 != 0) {
            typeface = ResourcesCompat.c(context, i8);
        } else {
            typeface = null;
        }
        if (typeface != null) {
            return true;
        }
        return false;
    }

    public Typeface e() {
        d();
        return this.f13891q;
    }

    @NonNull
    public Typeface f(@NonNull Context context) {
        if (this.f13890p) {
            return this.f13891q;
        }
        if (!context.isRestricted()) {
            try {
                Typeface h8 = ResourcesCompat.h(context, this.f13889o);
                this.f13891q = h8;
                if (h8 != null) {
                    this.f13891q = Typeface.create(h8, this.f13879e);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e8) {
                Log.d("TextAppearance", "Error loading font " + this.f13878d, e8);
            }
        }
        d();
        this.f13890p = true;
        return this.f13891q;
    }

    public void g(@NonNull final Context context, @NonNull final TextPaint textPaint, @NonNull final TextAppearanceFontCallback textAppearanceFontCallback) {
        p(context, textPaint, e());
        h(context, new TextAppearanceFontCallback() { // from class: com.google.android.material.resources.TextAppearance.2
            @Override // com.google.android.material.resources.TextAppearanceFontCallback
            public void a(int i8) {
                textAppearanceFontCallback.a(i8);
            }

            @Override // com.google.android.material.resources.TextAppearanceFontCallback
            public void b(@NonNull Typeface typeface, boolean z7) {
                TextAppearance.this.p(context, textPaint, typeface);
                textAppearanceFontCallback.b(typeface, z7);
            }
        });
    }

    public void h(@NonNull Context context, @NonNull final TextAppearanceFontCallback textAppearanceFontCallback) {
        if (m(context)) {
            f(context);
        } else {
            d();
        }
        int i8 = this.f13889o;
        if (i8 == 0) {
            this.f13890p = true;
        }
        if (this.f13890p) {
            textAppearanceFontCallback.b(this.f13891q, true);
            return;
        }
        try {
            ResourcesCompat.j(context, i8, new ResourcesCompat.FontCallback() { // from class: com.google.android.material.resources.TextAppearance.1
                @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                public void h(int i9) {
                    TextAppearance.this.f13890p = true;
                    textAppearanceFontCallback.a(i9);
                }

                @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                public void i(@NonNull Typeface typeface) {
                    TextAppearance textAppearance = TextAppearance.this;
                    textAppearance.f13891q = Typeface.create(typeface, textAppearance.f13879e);
                    TextAppearance.this.f13890p = true;
                    textAppearanceFontCallback.b(TextAppearance.this.f13891q, false);
                }
            }, null);
        } catch (Resources.NotFoundException unused) {
            this.f13890p = true;
            textAppearanceFontCallback.a(1);
        } catch (Exception e8) {
            Log.d("TextAppearance", "Error loading font " + this.f13878d, e8);
            this.f13890p = true;
            textAppearanceFontCallback.a(-3);
        }
    }

    public ColorStateList i() {
        return this.f13887m;
    }

    public float j() {
        return this.f13888n;
    }

    public void k(ColorStateList colorStateList) {
        this.f13887m = colorStateList;
    }

    public void l(float f8) {
        this.f13888n = f8;
    }

    public void n(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull TextAppearanceFontCallback textAppearanceFontCallback) {
        int i8;
        int i9;
        o(context, textPaint, textAppearanceFontCallback);
        ColorStateList colorStateList = this.f13887m;
        if (colorStateList != null) {
            i8 = colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor());
        } else {
            i8 = -16777216;
        }
        textPaint.setColor(i8);
        float f8 = this.f13884j;
        float f9 = this.f13882h;
        float f10 = this.f13883i;
        ColorStateList colorStateList2 = this.f13877c;
        if (colorStateList2 != null) {
            i9 = colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor());
        } else {
            i9 = 0;
        }
        textPaint.setShadowLayer(f8, f9, f10, i9);
    }

    public void o(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull TextAppearanceFontCallback textAppearanceFontCallback) {
        if (m(context)) {
            p(context, textPaint, f(context));
        } else {
            g(context, textPaint, textAppearanceFontCallback);
        }
    }

    public void p(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull Typeface typeface) {
        boolean z7;
        float f8;
        Typeface a8 = TypefaceUtils.a(context, typeface);
        if (a8 != null) {
            typeface = a8;
        }
        textPaint.setTypeface(typeface);
        int i8 = this.f13879e & (~typeface.getStyle());
        if ((i8 & 1) != 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        textPaint.setFakeBoldText(z7);
        if ((i8 & 2) != 0) {
            f8 = -0.25f;
        } else {
            f8 = 0.0f;
        }
        textPaint.setTextSkewX(f8);
        textPaint.setTextSize(this.f13888n);
        if (this.f13885k) {
            textPaint.setLetterSpacing(this.f13886l);
        }
    }
}
