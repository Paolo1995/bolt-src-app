package ee.mtakso.driver.uikit.widgets;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.core.widget.TextViewCompat;
import ee.mtakso.driver.uikit.R$font;
import ee.mtakso.driver.uikit.R$styleable;
import ee.mtakso.driver.uikit.internal.drawable.IndeterminateCircularProgressDrawable;
import ee.mtakso.driver.uikit.internal.drawable.RippleDrawableHelper;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Margins;
import ee.mtakso.driver.uikit.utils.Padding;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import eu.bolt.kalev.Kalev;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jctools.util.Pow2;

/* compiled from: RoundButton.kt */
/* loaded from: classes5.dex */
public final class RoundButton extends LinearLayout {
    private static final Companion D = new Companion(null);
    private Padding A;
    private boolean B;
    public Map<Integer, View> C;

    /* renamed from: f  reason: collision with root package name */
    private final RectF f36122f;

    /* renamed from: g  reason: collision with root package name */
    private final ImageView f36123g;

    /* renamed from: h  reason: collision with root package name */
    private final TextView f36124h;

    /* renamed from: i  reason: collision with root package name */
    private IndeterminateCircularProgressDrawable f36125i;

    /* renamed from: j  reason: collision with root package name */
    private int f36126j;

    /* renamed from: k  reason: collision with root package name */
    private Style f36127k;

    /* renamed from: l  reason: collision with root package name */
    private float f36128l;

    /* renamed from: m  reason: collision with root package name */
    private float f36129m;

    /* renamed from: n  reason: collision with root package name */
    private int f36130n;

    /* renamed from: o  reason: collision with root package name */
    private Rect f36131o;

    /* renamed from: p  reason: collision with root package name */
    private int f36132p;

    /* renamed from: q  reason: collision with root package name */
    private int f36133q;

    /* renamed from: r  reason: collision with root package name */
    private int f36134r;

    /* renamed from: s  reason: collision with root package name */
    private int f36135s;

    /* renamed from: t  reason: collision with root package name */
    private int f36136t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f36137u;

    /* renamed from: v  reason: collision with root package name */
    private int f36138v;

    /* renamed from: w  reason: collision with root package name */
    private Margins f36139w;

    /* renamed from: x  reason: collision with root package name */
    private float f36140x;

    /* renamed from: y  reason: collision with root package name */
    private int f36141y;

    /* renamed from: z  reason: collision with root package name */
    private Padding f36142z;

    /* compiled from: RoundButton.kt */
    /* loaded from: classes5.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: RoundButton.kt */
    /* loaded from: classes5.dex */
    private final class RoundedButtonOutlineProvider extends ViewOutlineProvider {
        public RoundedButtonOutlineProvider() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (outline != null) {
                RectF rectF = RoundButton.this.f36122f;
                Rect rect = new Rect();
                rectF.roundOut(rect);
                outline.setRoundRect(rect, MathUtils.a(RoundButton.this.getBgCornerRadius(), 0.0f, Math.min(RoundButton.this.getWidth(), RoundButton.this.getHeight()) / 2.0f));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RoundButton.kt */
    /* loaded from: classes5.dex */
    public static final class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Creator();

        /* renamed from: f  reason: collision with root package name */
        private final int f36144f;

        /* renamed from: g  reason: collision with root package name */
        private final int f36145g;

        /* renamed from: h  reason: collision with root package name */
        private final Parcelable f36146h;

        /* compiled from: RoundButton.kt */
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final SavedState createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new SavedState(parcel.readInt(), parcel.readInt(), parcel.readParcelable(SavedState.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final SavedState[] newArray(int i8) {
                return new SavedState[i8];
            }
        }

        public SavedState(int i8, int i9, Parcelable parcelable) {
            this.f36144f = i8;
            this.f36145g = i9;
            this.f36146h = parcelable;
        }

        public final Parcelable a() {
            return this.f36146h;
        }

        public final int b() {
            return this.f36144f;
        }

        public final int c() {
            return this.f36145g;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SavedState) {
                SavedState savedState = (SavedState) obj;
                return this.f36144f == savedState.f36144f && this.f36145g == savedState.f36145g && Intrinsics.a(this.f36146h, savedState.f36146h);
            }
            return false;
        }

        public int hashCode() {
            int i8 = ((this.f36144f * 31) + this.f36145g) * 31;
            Parcelable parcelable = this.f36146h;
            return i8 + (parcelable == null ? 0 : parcelable.hashCode());
        }

        public String toString() {
            int i8 = this.f36144f;
            int i9 = this.f36145g;
            Parcelable parcelable = this.f36146h;
            return "SavedState(textVisibility=" + i8 + ", viewVisibility=" + i9 + ", superState=" + parcelable + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeInt(this.f36144f);
            out.writeInt(this.f36145g);
            out.writeParcelable(this.f36146h, i8);
        }
    }

    /* compiled from: RoundButton.kt */
    /* loaded from: classes5.dex */
    public enum Style {
        SOLID(0, Paint.Style.FILL),
        OUTLINED(1, Paint.Style.STROKE),
        LABELED(2, Paint.Style.FILL);
        

        /* renamed from: f  reason: collision with root package name */
        private final int f36151f;

        /* renamed from: g  reason: collision with root package name */
        private final Paint.Style f36152g;

        Style(int i8, Paint.Style style) {
            this.f36151f = i8;
            this.f36152g = style;
        }

        public final int c() {
            return this.f36151f;
        }

        public final Paint.Style e() {
            return this.f36152g;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundButton(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Rect rect;
        Unit unit;
        Intrinsics.f(context, "context");
        this.C = new LinkedHashMap();
        this.f36122f = new RectF();
        ImageView imageView = new ImageView(context);
        this.f36123g = imageView;
        TextView textView = new TextView(context);
        this.f36124h = textView;
        this.f36126j = Dimens.c(320);
        this.f36127k = Style.SOLID;
        this.f36129m = Dimens.b(2.0f);
        this.f36131o = new Rect();
        this.f36135s = -16777216;
        this.f36136t = R$font.f35752a;
        this.f36138v = -2;
        this.f36139w = new Margins(0, 0, 0, 0);
        this.f36140x = Dimens.b(7.0f);
        this.f36141y = -16777216;
        this.f36142z = new Padding(0, 0, 0, 0);
        this.A = new Padding(0, 0, 0, 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.D1);
        Intrinsics.e(obtainStyledAttributes, "context.obtainStyledAttr… R.styleable.RoundButton)");
        setStyle(e(obtainStyledAttributes.getInt(R$styleable.f35856p2, 0)));
        setBgColor(obtainStyledAttributes.getColor(R$styleable.R1, -16777216));
        setRippleColor(obtainStyledAttributes.getColor(R$styleable.f35851o2, -1));
        setProgressBgColor(obtainStyledAttributes.getColor(R$styleable.f35836l2, -16777216));
        setBgCornerRadius(obtainStyledAttributes.getDimension(R$styleable.S1, 0.0f));
        setBorderStrokeWidth(obtainStyledAttributes.getDimension(R$styleable.Y1, Dimens.b(2.0f)));
        setImageSize(obtainStyledAttributes.getDimensionPixelSize(R$styleable.f35826j2, this.f36138v));
        setMaxWidthConstraint(obtainStyledAttributes.getDimensionPixelSize(R$styleable.L1, this.f36126j));
        setTextAppearance(obtainStyledAttributes.getResourceId(R$styleable.F1, 0));
        setTextColor(obtainStyledAttributes.getColor(R$styleable.G1, this.f36135s));
        setTypeface(obtainStyledAttributes.getResourceId(R$styleable.O1, this.f36136t));
        if (!obtainStyledAttributes.getBoolean(R$styleable.E1, true)) {
            setEnabled(false);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.X1, 0);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.V1, dimensionPixelSize);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.W1, dimensionPixelSize);
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.U1, dimensionPixelSize);
        int dimensionPixelSize5 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.T1, dimensionPixelSize);
        if (getLayoutDirection() == 0) {
            rect = new Rect(dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize4, dimensionPixelSize5);
        } else {
            rect = new Rect(dimensionPixelSize4, dimensionPixelSize3, dimensionPixelSize2, dimensionPixelSize5);
        }
        setBgInsets(rect);
        setProgressColor(obtainStyledAttributes.getColor(R$styleable.f35841m2, -16777216));
        setProgressWidth(obtainStyledAttributes.getDimension(R$styleable.f35846n2, Dimens.b(7.0f)));
        setAllCaps(obtainStyledAttributes.getBoolean(R$styleable.N1, false));
        CharSequence text = obtainStyledAttributes.getText(R$styleable.M1);
        if (text != null) {
            textView.setText(text);
            unit = Unit.f50853a;
        } else {
            unit = null;
        }
        if (unit == null) {
            ViewExtKt.d(textView, false, 0, 2, null);
        }
        int dimensionPixelSize6 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f35861q2, 0);
        setTextPadding(new Padding(obtainStyledAttributes.getDimensionPixelSize(R$styleable.f35876t2, dimensionPixelSize6), obtainStyledAttributes.getDimensionPixelSize(R$styleable.f35881u2, dimensionPixelSize6), obtainStyledAttributes.getDimensionPixelSize(R$styleable.f35871s2, dimensionPixelSize6), obtainStyledAttributes.getDimensionPixelSize(R$styleable.f35866r2, dimensionPixelSize6)));
        setElevationCompat(obtainStyledAttributes.getDimension(R$styleable.Z1, 0.0f));
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.K1, 0);
        if (resourceId != 0) {
            imageView.setImageResource(resourceId);
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R$styleable.f35831k2);
        if (colorStateList != null) {
            setIconTintList(colorStateList);
        }
        if (!obtainStyledAttributes.hasValue(R$styleable.H1) && !obtainStyledAttributes.hasValue(R$styleable.P1) && !obtainStyledAttributes.hasValue(R$styleable.I1) && !obtainStyledAttributes.hasValue(R$styleable.Q1) && !obtainStyledAttributes.hasValue(R$styleable.J1)) {
            super.setPadding(Dimens.c(24), Dimens.c(16), Dimens.c(24), Dimens.c(16));
        }
        setImageMargins(new Margins(obtainStyledAttributes.getDimensionPixelSize(R$styleable.f35791c2, this.f36139w.b()), obtainStyledAttributes.getDimensionPixelSize(R$styleable.f35796d2, this.f36139w.d()), obtainStyledAttributes.getDimensionPixelSize(R$styleable.f35786b2, this.f36139w.c()), obtainStyledAttributes.getDimensionPixelSize(R$styleable.f35781a2, this.f36139w.a())));
        int dimensionPixelSize7 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f35801e2, 0);
        setImagePadding(new Padding(obtainStyledAttributes.getDimensionPixelSize(R$styleable.f35816h2, dimensionPixelSize7), obtainStyledAttributes.getDimensionPixelSize(R$styleable.f35821i2, dimensionPixelSize7), obtainStyledAttributes.getDimensionPixelSize(R$styleable.f35811g2, dimensionPixelSize7), obtainStyledAttributes.getDimensionPixelSize(R$styleable.f35806f2, dimensionPixelSize7)));
        obtainStyledAttributes.recycle();
        addView(imageView);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        Unit unit2 = Unit.f50853a;
        addView(textView, layoutParams);
        setOrientation(this.f36127k == Style.LABELED ? 1 : 0);
        setGravity(17);
        textView.setGravity(17);
        setClickable(true);
        setFocusable(true);
        i();
        setOutlineProvider(new RoundedButtonOutlineProvider());
        setClipToOutline(true);
    }

    private final int d(int i8, int i9, boolean z7) {
        if (!z7) {
            return i8;
        }
        int mode = View.MeasureSpec.getMode(i8);
        int size = View.MeasureSpec.getSize(i8);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode == 1073741824) {
                    return View.MeasureSpec.makeMeasureSpec(Math.min(size, i9), Pow2.MAX_POW2);
                }
                return i8;
            }
            return View.MeasureSpec.makeMeasureSpec(i9, Integer.MIN_VALUE);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(size, i9), Integer.MIN_VALUE);
    }

    private final Style e(int i8) {
        Style style;
        boolean z7;
        Style[] values = Style.values();
        int length = values.length;
        int i9 = 0;
        while (true) {
            if (i9 < length) {
                style = values[i9];
                if (style.c() == i8) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z7) {
                    break;
                }
                i9++;
            } else {
                style = null;
                break;
            }
        }
        if (style != null) {
            return style;
        }
        throw new IllegalArgumentException("Cannot find style with id: " + i8);
    }

    private final void i() {
        int i8;
        if (this.B) {
            i8 = this.f36132p;
        } else {
            i8 = this.f36130n;
        }
        int i9 = i8;
        Style style = this.f36127k;
        if (style == Style.LABELED) {
            RippleDrawableHelper rippleDrawableHelper = RippleDrawableHelper.f35939a;
            ImageView imageView = this.f36123g;
            int i10 = this.f36133q;
            float f8 = this.f36128l;
            imageView.setBackground(rippleDrawableHelper.c(i9, i10, new RippleDrawableHelper.CornerRadiuses(f8, f8, f8, f8), this.f36129m, style.e(), this.f36131o));
        } else {
            RippleDrawableHelper rippleDrawableHelper2 = RippleDrawableHelper.f35939a;
            int i11 = this.f36133q;
            float f9 = this.f36128l;
            setBackground(rippleDrawableHelper2.c(i9, i11, new RippleDrawableHelper.CornerRadiuses(f9, f9, f9, f9), this.f36129m, style.e(), this.f36131o));
        }
        super.setPadding(getPaddingStart(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    private final void m() {
        LinearLayout.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2 = this.f36123g.getLayoutParams();
        if (layoutParams2 instanceof LinearLayout.LayoutParams) {
            layoutParams = (LinearLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            int i8 = this.f36138v;
            layoutParams.height = i8;
            layoutParams.width = i8;
            layoutParams.gravity = 17;
            layoutParams.setMarginStart(this.f36139w.b());
            layoutParams.topMargin = this.f36139w.d();
            layoutParams.setMarginEnd(this.f36139w.c());
            layoutParams.bottomMargin = this.f36139w.a();
        } else {
            int i9 = this.f36138v;
            layoutParams = new LinearLayout.LayoutParams(i9, i9);
            layoutParams.gravity = 17;
            layoutParams.setMarginStart(this.f36139w.b());
            layoutParams.topMargin = this.f36139w.d();
            layoutParams.setMarginEnd(this.f36139w.c());
            layoutParams.bottomMargin = this.f36139w.a();
        }
        this.f36123g.setLayoutParams(layoutParams);
    }

    public final void b(int i8) {
        this.f36123g.setVisibility(0);
        this.f36123g.setImageResource(i8);
    }

    public final void c(Drawable icon) {
        Intrinsics.f(icon, "icon");
        this.f36123g.setVisibility(0);
        this.f36123g.setImageDrawable(icon);
    }

    public final void f() {
        this.f36123g.setVisibility(8);
    }

    public final void g() {
        this.B = false;
        IndeterminateCircularProgressDrawable indeterminateCircularProgressDrawable = this.f36125i;
        if (indeterminateCircularProgressDrawable != null) {
            indeterminateCircularProgressDrawable.stop();
        }
        this.f36123g.setVisibility(8);
        this.f36124h.setVisibility(0);
        setEnabled(true);
        i();
    }

    public final int getBgColor() {
        return this.f36130n;
    }

    public final float getBgCornerRadius() {
        return this.f36128l;
    }

    public final Rect getBgInsets() {
        return this.f36131o;
    }

    public final float getBorderStrokeWidth() {
        return this.f36129m;
    }

    public final Margins getImageMargins() {
        return this.f36139w;
    }

    public final Padding getImagePadding() {
        return this.f36142z;
    }

    public final int getImageSize() {
        return this.f36138v;
    }

    public final int getMaxWidthConstraint() {
        return this.f36126j;
    }

    public final int getProgressBgColor() {
        return this.f36132p;
    }

    public final int getProgressColor() {
        return this.f36141y;
    }

    public final float getProgressWidth() {
        return this.f36140x;
    }

    public final int getRippleColor() {
        return this.f36133q;
    }

    public final Style getStyle() {
        return this.f36127k;
    }

    public final int getTextAppearance() {
        return this.f36134r;
    }

    public final int getTextColor() {
        return this.f36135s;
    }

    public final Padding getTextPadding() {
        return this.A;
    }

    public final int getTypeface() {
        return this.f36136t;
    }

    public final void h() {
        this.f36124h.setVisibility(8);
    }

    public final void j() {
        this.f36123g.setVisibility(0);
    }

    public final void k() {
        this.B = true;
        IndeterminateCircularProgressDrawable indeterminateCircularProgressDrawable = this.f36125i;
        if (indeterminateCircularProgressDrawable != null) {
            indeterminateCircularProgressDrawable.start();
        }
        this.f36123g.setVisibility(0);
        this.f36123g.setImageDrawable(this.f36125i);
        this.f36124h.setVisibility(8);
        setEnabled(false);
        i();
    }

    public final void l() {
        this.f36124h.setVisibility(0);
    }

    public final void n() {
        IndeterminateCircularProgressDrawable indeterminateCircularProgressDrawable = this.f36125i;
        if (indeterminateCircularProgressDrawable != null) {
            indeterminateCircularProgressDrawable.stop();
        }
        IndeterminateCircularProgressDrawable indeterminateCircularProgressDrawable2 = new IndeterminateCircularProgressDrawable();
        indeterminateCircularProgressDrawable2.i(this.f36141y);
        indeterminateCircularProgressDrawable2.n(this.f36140x);
        this.f36125i = indeterminateCircularProgressDrawable2;
        if (this.B) {
            indeterminateCircularProgressDrawable2.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i8, int i9) {
        boolean z7;
        int i10 = this.f36126j;
        if (i10 != -1) {
            z7 = true;
        } else {
            z7 = false;
        }
        super.onMeasure(d(i8, i10, z7), i9);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.a());
            this.f36124h.setVisibility(savedState.b());
            setVisibility(savedState.c());
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return new SavedState(this.f36124h.getVisibility(), getVisibility(), super.onSaveInstanceState());
    }

    @Override // android.view.View
    protected void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        this.f36122f.set(0.0f, 0.0f, i8, i9);
        invalidateOutline();
    }

    public final void setAllCaps(boolean z7) {
        this.f36124h.setAllCaps(z7);
        this.f36137u = z7;
    }

    public final void setBgColor(int i8) {
        this.f36130n = i8;
        if (isEnabled()) {
            i();
        }
    }

    public final void setBgCornerRadius(float f8) {
        this.f36128l = f8;
        i();
    }

    public final void setBgInsets(Rect value) {
        Intrinsics.f(value, "value");
        this.f36131o = value;
        i();
    }

    public final void setBorderStrokeWidth(float f8) {
        this.f36129m = f8;
        i();
    }

    public final void setElevationCompat(float f8) {
        ViewCompat.A0(this, f8);
    }

    @Override // android.view.View
    public void setEnabled(boolean z7) {
        float f8;
        super.setEnabled(z7);
        if (z7) {
            f8 = 1.0f;
        } else {
            f8 = 0.5f;
        }
        setAlpha(f8);
    }

    public final void setIconTint(Integer num) {
        if (num == null) {
            this.f36123g.setColorFilter((ColorFilter) null);
            ImageViewCompat.c(this.f36123g, null);
            return;
        }
        this.f36123g.setColorFilter(ContextCompat.getColor(getContext(), num.intValue()), PorterDuff.Mode.SRC_IN);
    }

    public final void setIconTintList(ColorStateList imageTint) {
        Intrinsics.f(imageTint, "imageTint");
        ImageViewCompat.c(this.f36123g, imageTint);
    }

    public final void setImageMargins(Margins value) {
        Intrinsics.f(value, "value");
        this.f36139w = value;
        m();
    }

    public final void setImagePadding(Padding value) {
        Intrinsics.f(value, "value");
        this.f36142z = value;
        this.f36123g.setPadding(value.b(), value.d(), value.c(), value.a());
    }

    public final void setImageSize(int i8) {
        this.f36138v = i8;
        m();
    }

    public final void setMaxWidthConstraint(int i8) {
        this.f36126j = i8;
        i();
    }

    public final void setProgressBgColor(int i8) {
        this.f36132p = i8;
        if (isEnabled()) {
            i();
        }
    }

    public final void setProgressColor(int i8) {
        this.f36141y = i8;
        n();
    }

    public final void setProgressWidth(float f8) {
        this.f36140x = f8;
        n();
    }

    public final void setRippleColor(int i8) {
        this.f36133q = i8;
        i();
    }

    public final void setStyle(Style value) {
        Intrinsics.f(value, "value");
        this.f36127k = value;
        i();
    }

    public final void setText(CharSequence charSequence) {
        if (!(this.f36124h.getVisibility() == 0)) {
            ViewExtKt.d(this.f36124h, false, 0, 3, null);
        }
        this.f36124h.setText(charSequence);
    }

    public final void setTextAppearance(int i8) {
        this.f36134r = i8;
        TextViewCompat.o(this.f36124h, i8);
    }

    public final void setTextColor(int i8) {
        this.f36135s = i8;
        this.f36124h.setTextColor(i8);
    }

    public final void setTextPadding(Padding value) {
        Intrinsics.f(value, "value");
        this.A = value;
        this.f36124h.setPadding(value.b(), value.d(), value.c(), value.a());
    }

    public final void setTypeface(int i8) {
        try {
            this.f36136t = i8;
            this.f36124h.setTypeface(ResourcesCompat.h(getContext(), i8));
        } catch (Resources.NotFoundException e8) {
            Kalev.e(e8, "Unable to set the font to the RoundButton!");
        }
    }

    public final void setText(int i8) {
        if (!(this.f36124h.getVisibility() == 0)) {
            ViewExtKt.d(this.f36124h, false, 0, 3, null);
        }
        this.f36124h.setText(i8);
    }

    public /* synthetic */ RoundButton(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }
}
