package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public class MaterialButton extends AppCompatButton implements Checkable, Shapeable {

    /* renamed from: v  reason: collision with root package name */
    private static final int[] f13064v = {16842911};

    /* renamed from: w  reason: collision with root package name */
    private static final int[] f13065w = {16842912};

    /* renamed from: x  reason: collision with root package name */
    private static final int f13066x = R$style.Widget_MaterialComponents_Button;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final MaterialButtonHelper f13067i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final LinkedHashSet<OnCheckedChangeListener> f13068j;

    /* renamed from: k  reason: collision with root package name */
    private OnPressedChangeListener f13069k;

    /* renamed from: l  reason: collision with root package name */
    private PorterDuff.Mode f13070l;

    /* renamed from: m  reason: collision with root package name */
    private ColorStateList f13071m;

    /* renamed from: n  reason: collision with root package name */
    private Drawable f13072n;

    /* renamed from: o  reason: collision with root package name */
    private int f13073o;

    /* renamed from: p  reason: collision with root package name */
    private int f13074p;

    /* renamed from: q  reason: collision with root package name */
    private int f13075q;

    /* renamed from: r  reason: collision with root package name */
    private int f13076r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f13077s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f13078t;

    /* renamed from: u  reason: collision with root package name */
    private int f13079u;

    /* loaded from: classes.dex */
    public interface OnCheckedChangeListener {
        void a(MaterialButton materialButton, boolean z7);
    }

    /* loaded from: classes.dex */
    interface OnPressedChangeListener {
        void a(MaterialButton materialButton, boolean z7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.button.MaterialButton.SavedState.1
            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: a */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            /* renamed from: b */
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: c */
            public SavedState[] newArray(int i8) {
                return new SavedState[i8];
            }
        };

        /* renamed from: h  reason: collision with root package name */
        boolean f13080h;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void b(@NonNull Parcel parcel) {
            boolean z7 = true;
            if (parcel.readInt() != 1) {
                z7 = false;
            }
            this.f13080h = z7;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i8) {
            super.writeToParcel(parcel, i8);
            parcel.writeInt(this.f13080h ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            b(parcel);
        }
    }

    public MaterialButton(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialButtonStyle);
    }

    private boolean b() {
        int i8 = this.f13079u;
        if (i8 != 3 && i8 != 4) {
            return false;
        }
        return true;
    }

    private boolean c() {
        int i8 = this.f13079u;
        if (i8 == 1 || i8 == 2) {
            return true;
        }
        return false;
    }

    private boolean d() {
        int i8 = this.f13079u;
        if (i8 != 16 && i8 != 32) {
            return false;
        }
        return true;
    }

    private boolean e() {
        if (ViewCompat.E(this) == 1) {
            return true;
        }
        return false;
    }

    private boolean f() {
        MaterialButtonHelper materialButtonHelper = this.f13067i;
        if (materialButtonHelper != null && !materialButtonHelper.o()) {
            return true;
        }
        return false;
    }

    private void g() {
        if (c()) {
            TextViewCompat.j(this, this.f13072n, null, null, null);
        } else if (b()) {
            TextViewCompat.j(this, null, null, this.f13072n, null);
        } else if (d()) {
            TextViewCompat.j(this, null, this.f13072n, null, null);
        }
    }

    @NonNull
    private String getA11yClassName() {
        Class cls;
        if (a()) {
            cls = CompoundButton.class;
        } else {
            cls = Button.class;
        }
        return cls.getName();
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        if (textAlignment != 1) {
            if (textAlignment != 6 && textAlignment != 3) {
                if (textAlignment != 4) {
                    return Layout.Alignment.ALIGN_NORMAL;
                }
                return Layout.Alignment.ALIGN_CENTER;
            }
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        return getGravityTextAlignment();
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & 8388615;
        if (gravity != 1) {
            if (gravity != 5 && gravity != 8388613) {
                return Layout.Alignment.ALIGN_NORMAL;
            }
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        return Layout.Alignment.ALIGN_CENTER;
    }

    private int getTextHeight() {
        if (getLineCount() > 1) {
            return getLayout().getHeight();
        }
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextLayoutWidth() {
        int lineCount = getLineCount();
        float f8 = 0.0f;
        for (int i8 = 0; i8 < lineCount; i8++) {
            f8 = Math.max(f8, getLayout().getLineWidth(i8));
        }
        return (int) Math.ceil(f8);
    }

    private void h(boolean z7) {
        Drawable drawable = this.f13072n;
        boolean z8 = true;
        if (drawable != null) {
            Drawable mutate = DrawableCompat.r(drawable).mutate();
            this.f13072n = mutate;
            DrawableCompat.o(mutate, this.f13071m);
            PorterDuff.Mode mode = this.f13070l;
            if (mode != null) {
                DrawableCompat.p(this.f13072n, mode);
            }
            int i8 = this.f13073o;
            if (i8 == 0) {
                i8 = this.f13072n.getIntrinsicWidth();
            }
            int i9 = this.f13073o;
            if (i9 == 0) {
                i9 = this.f13072n.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f13072n;
            int i10 = this.f13074p;
            int i11 = this.f13075q;
            drawable2.setBounds(i10, i11, i8 + i10, i9 + i11);
            this.f13072n.setVisible(true, z7);
        }
        if (z7) {
            g();
            return;
        }
        Drawable[] a8 = TextViewCompat.a(this);
        Drawable drawable3 = a8[0];
        Drawable drawable4 = a8[1];
        Drawable drawable5 = a8[2];
        if ((!c() || drawable3 == this.f13072n) && ((!b() || drawable5 == this.f13072n) && (!d() || drawable4 == this.f13072n))) {
            z8 = false;
        }
        if (z8) {
            g();
        }
    }

    private void i(int i8, int i9) {
        if (this.f13072n != null && getLayout() != null) {
            if (!c() && !b()) {
                if (d()) {
                    this.f13074p = 0;
                    if (this.f13079u == 16) {
                        this.f13075q = 0;
                        h(false);
                        return;
                    }
                    int i10 = this.f13073o;
                    if (i10 == 0) {
                        i10 = this.f13072n.getIntrinsicHeight();
                    }
                    int max = Math.max(0, (((((i9 - getTextHeight()) - getPaddingTop()) - i10) - this.f13076r) - getPaddingBottom()) / 2);
                    if (this.f13075q != max) {
                        this.f13075q = max;
                        h(false);
                        return;
                    }
                    return;
                }
                return;
            }
            this.f13075q = 0;
            Layout.Alignment actualTextAlignment = getActualTextAlignment();
            int i11 = this.f13079u;
            boolean z7 = true;
            if (i11 != 1 && i11 != 3 && ((i11 != 2 || actualTextAlignment != Layout.Alignment.ALIGN_NORMAL) && (i11 != 4 || actualTextAlignment != Layout.Alignment.ALIGN_OPPOSITE))) {
                int i12 = this.f13073o;
                if (i12 == 0) {
                    i12 = this.f13072n.getIntrinsicWidth();
                }
                int textLayoutWidth = ((((i8 - getTextLayoutWidth()) - ViewCompat.I(this)) - i12) - this.f13076r) - ViewCompat.J(this);
                if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
                    textLayoutWidth /= 2;
                }
                boolean e8 = e();
                if (this.f13079u != 4) {
                    z7 = false;
                }
                if (e8 != z7) {
                    textLayoutWidth = -textLayoutWidth;
                }
                if (this.f13074p != textLayoutWidth) {
                    this.f13074p = textLayoutWidth;
                    h(false);
                    return;
                }
                return;
            }
            this.f13074p = 0;
            h(false);
        }
    }

    public boolean a() {
        MaterialButtonHelper materialButtonHelper = this.f13067i;
        if (materialButtonHelper != null && materialButtonHelper.p()) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (f()) {
            return this.f13067i.b();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f13072n;
    }

    public int getIconGravity() {
        return this.f13079u;
    }

    public int getIconPadding() {
        return this.f13076r;
    }

    public int getIconSize() {
        return this.f13073o;
    }

    public ColorStateList getIconTint() {
        return this.f13071m;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f13070l;
    }

    public int getInsetBottom() {
        return this.f13067i.c();
    }

    public int getInsetTop() {
        return this.f13067i.d();
    }

    public ColorStateList getRippleColor() {
        if (f()) {
            return this.f13067i.h();
        }
        return null;
    }

    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        if (f()) {
            return this.f13067i.i();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (f()) {
            return this.f13067i.j();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (f()) {
            return this.f13067i.k();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public ColorStateList getSupportBackgroundTintList() {
        if (f()) {
            return this.f13067i.l();
        }
        return super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (f()) {
            return this.f13067i.m();
        }
        return super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f13077s;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (f()) {
            MaterialShapeUtils.f(this, this.f13067i.f());
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i8) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i8 + 2);
        if (a()) {
            View.mergeDrawableStates(onCreateDrawableState, f13064v);
        }
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f13065w);
        }
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(a());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    protected void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        MaterialButtonHelper materialButtonHelper;
        super.onLayout(z7, i8, i9, i10, i11);
        if (Build.VERSION.SDK_INT == 21 && (materialButtonHelper = this.f13067i) != null) {
            materialButtonHelper.J(i11 - i9, i10 - i8);
        }
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        setChecked(savedState.f13080h);
    }

    @Override // android.widget.TextView, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f13080h = this.f13077s;
        return savedState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
        super.onTextChanged(charSequence, i8, i9, i10);
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.f13067i.q()) {
            toggle();
        }
        return super.performClick();
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.f13072n != null) {
            if (this.f13072n.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    @Override // android.view.View
    public void setBackground(@NonNull Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i8) {
        if (f()) {
            this.f13067i.s(i8);
        } else {
            super.setBackgroundColor(i8);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(@NonNull Drawable drawable) {
        if (f()) {
            if (drawable != getBackground()) {
                Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
                this.f13067i.t();
                super.setBackgroundDrawable(drawable);
                return;
            }
            getBackground().setState(drawable.getState());
            return;
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(int i8) {
        Drawable drawable;
        if (i8 != 0) {
            drawable = AppCompatResources.b(getContext(), i8);
        } else {
            drawable = null;
        }
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z7) {
        if (f()) {
            this.f13067i.u(z7);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z7) {
        if (a() && isEnabled() && this.f13077s != z7) {
            this.f13077s = z7;
            refreshDrawableState();
            if (getParent() instanceof MaterialButtonToggleGroup) {
                ((MaterialButtonToggleGroup) getParent()).m(this, this.f13077s);
            }
            if (this.f13078t) {
                return;
            }
            this.f13078t = true;
            Iterator<OnCheckedChangeListener> it = this.f13068j.iterator();
            while (it.hasNext()) {
                it.next().a(this, this.f13077s);
            }
            this.f13078t = false;
        }
    }

    public void setCornerRadius(int i8) {
        if (f()) {
            this.f13067i.v(i8);
        }
    }

    public void setCornerRadiusResource(int i8) {
        if (f()) {
            setCornerRadius(getResources().getDimensionPixelSize(i8));
        }
    }

    @Override // android.view.View
    public void setElevation(float f8) {
        super.setElevation(f8);
        if (f()) {
            this.f13067i.f().b0(f8);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f13072n != drawable) {
            this.f13072n = drawable;
            h(true);
            i(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i8) {
        if (this.f13079u != i8) {
            this.f13079u = i8;
            i(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i8) {
        if (this.f13076r != i8) {
            this.f13076r = i8;
            setCompoundDrawablePadding(i8);
        }
    }

    public void setIconResource(int i8) {
        Drawable drawable;
        if (i8 != 0) {
            drawable = AppCompatResources.b(getContext(), i8);
        } else {
            drawable = null;
        }
        setIcon(drawable);
    }

    public void setIconSize(int i8) {
        if (i8 >= 0) {
            if (this.f13073o != i8) {
                this.f13073o = i8;
                h(true);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("iconSize cannot be less than 0");
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f13071m != colorStateList) {
            this.f13071m = colorStateList;
            h(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f13070l != mode) {
            this.f13070l = mode;
            h(false);
        }
    }

    public void setIconTintResource(int i8) {
        setIconTint(AppCompatResources.a(getContext(), i8));
    }

    public void setInsetBottom(int i8) {
        this.f13067i.w(i8);
    }

    public void setInsetTop(int i8) {
        this.f13067i.x(i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnPressedChangeListenerInternal(OnPressedChangeListener onPressedChangeListener) {
        this.f13069k = onPressedChangeListener;
    }

    @Override // android.view.View
    public void setPressed(boolean z7) {
        OnPressedChangeListener onPressedChangeListener = this.f13069k;
        if (onPressedChangeListener != null) {
            onPressedChangeListener.a(this, z7);
        }
        super.setPressed(z7);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (f()) {
            this.f13067i.y(colorStateList);
        }
    }

    public void setRippleColorResource(int i8) {
        if (f()) {
            setRippleColor(AppCompatResources.a(getContext(), i8));
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (f()) {
            this.f13067i.z(shapeAppearanceModel);
            return;
        }
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setShouldDrawSurfaceColorStroke(boolean z7) {
        if (f()) {
            this.f13067i.A(z7);
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (f()) {
            this.f13067i.B(colorStateList);
        }
    }

    public void setStrokeColorResource(int i8) {
        if (f()) {
            setStrokeColor(AppCompatResources.a(getContext(), i8));
        }
    }

    public void setStrokeWidth(int i8) {
        if (f()) {
            this.f13067i.C(i8);
        }
    }

    public void setStrokeWidthResource(int i8) {
        if (f()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i8));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (f()) {
            this.f13067i.D(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (f()) {
            this.f13067i.E(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.view.View
    public void setTextAlignment(int i8) {
        super.setTextAlignment(i8);
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean z7) {
        this.f13067i.F(z7);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f13077s);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MaterialButton(@androidx.annotation.NonNull android.content.Context r9, android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            int r6 = com.google.android.material.button.MaterialButton.f13066x
            android.content.Context r9 = com.google.android.material.theme.overlay.MaterialThemeOverlay.c(r9, r10, r11, r6)
            r8.<init>(r9, r10, r11)
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            r8.f13068j = r9
            r9 = 0
            r8.f13077s = r9
            r8.f13078t = r9
            android.content.Context r7 = r8.getContext()
            int[] r2 = com.google.android.material.R$styleable.f12716z3
            int[] r5 = new int[r9]
            r0 = r7
            r1 = r10
            r3 = r11
            r4 = r6
            android.content.res.TypedArray r0 = com.google.android.material.internal.ThemeEnforcement.i(r0, r1, r2, r3, r4, r5)
            int r1 = com.google.android.material.R$styleable.M3
            int r1 = r0.getDimensionPixelSize(r1, r9)
            r8.f13076r = r1
            int r1 = com.google.android.material.R$styleable.P3
            r2 = -1
            int r1 = r0.getInt(r1, r2)
            android.graphics.PorterDuff$Mode r2 = android.graphics.PorterDuff.Mode.SRC_IN
            android.graphics.PorterDuff$Mode r1 = com.google.android.material.internal.ViewUtils.g(r1, r2)
            r8.f13070l = r1
            android.content.Context r1 = r8.getContext()
            int r2 = com.google.android.material.R$styleable.O3
            android.content.res.ColorStateList r1 = com.google.android.material.resources.MaterialResources.a(r1, r0, r2)
            r8.f13071m = r1
            android.content.Context r1 = r8.getContext()
            int r2 = com.google.android.material.R$styleable.K3
            android.graphics.drawable.Drawable r1 = com.google.android.material.resources.MaterialResources.e(r1, r0, r2)
            r8.f13072n = r1
            int r1 = com.google.android.material.R$styleable.L3
            r2 = 1
            int r1 = r0.getInteger(r1, r2)
            r8.f13079u = r1
            int r1 = com.google.android.material.R$styleable.N3
            int r1 = r0.getDimensionPixelSize(r1, r9)
            r8.f13073o = r1
            com.google.android.material.shape.ShapeAppearanceModel$Builder r10 = com.google.android.material.shape.ShapeAppearanceModel.e(r7, r10, r11, r6)
            com.google.android.material.shape.ShapeAppearanceModel r10 = r10.m()
            com.google.android.material.button.MaterialButtonHelper r11 = new com.google.android.material.button.MaterialButtonHelper
            r11.<init>(r8, r10)
            r8.f13067i = r11
            r11.r(r0)
            r0.recycle()
            int r10 = r8.f13076r
            r8.setCompoundDrawablePadding(r10)
            android.graphics.drawable.Drawable r10 = r8.f13072n
            if (r10 == 0) goto L84
            r9 = 1
        L84:
            r8.h(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
