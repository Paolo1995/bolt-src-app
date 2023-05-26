package com.google.android.material.checkbox;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.CompoundButtonCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ViewUtils;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public class MaterialCheckBox extends AppCompatCheckBox {
    private static final int D = R$style.Widget_MaterialComponents_CompoundButton_CheckBox;
    private static final int[] E = {R$attr.state_indeterminate};
    private static final int[] F;
    private static final int[][] G;
    @SuppressLint({"DiscouragedApi"})
    private static final int H;
    private CompoundButton.OnCheckedChangeListener A;
    private final AnimatedVectorDrawableCompat B;
    private final Animatable2Compat$AnimationCallback C;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final LinkedHashSet<OnErrorChangedListener> f13159j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final LinkedHashSet<OnCheckedStateChangedListener> f13160k;

    /* renamed from: l  reason: collision with root package name */
    private ColorStateList f13161l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f13162m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f13163n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f13164o;

    /* renamed from: p  reason: collision with root package name */
    private CharSequence f13165p;

    /* renamed from: q  reason: collision with root package name */
    private Drawable f13166q;

    /* renamed from: r  reason: collision with root package name */
    private Drawable f13167r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f13168s;

    /* renamed from: t  reason: collision with root package name */
    ColorStateList f13169t;

    /* renamed from: u  reason: collision with root package name */
    ColorStateList f13170u;
    @NonNull

    /* renamed from: v  reason: collision with root package name */
    private PorterDuff.Mode f13171v;

    /* renamed from: w  reason: collision with root package name */
    private int f13172w;

    /* renamed from: x  reason: collision with root package name */
    private int[] f13173x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f13174y;

    /* renamed from: z  reason: collision with root package name */
    private CharSequence f13175z;

    /* loaded from: classes.dex */
    public interface OnCheckedStateChangedListener {
        void a(@NonNull MaterialCheckBox materialCheckBox, int i8);
    }

    /* loaded from: classes.dex */
    public interface OnErrorChangedListener {
        void a(@NonNull MaterialCheckBox materialCheckBox, boolean z7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        @NonNull
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.google.android.material.checkbox.MaterialCheckBox.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i8) {
                return new SavedState[i8];
            }
        };

        /* renamed from: f  reason: collision with root package name */
        int f13177f;

        @NonNull
        private String a() {
            int i8 = this.f13177f;
            if (i8 != 1) {
                if (i8 != 2) {
                    return "unchecked";
                }
                return "indeterminate";
            }
            return "checked";
        }

        @NonNull
        public String toString() {
            return "MaterialCheckBox.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " CheckedState=" + a() + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i8) {
            super.writeToParcel(parcel, i8);
            parcel.writeValue(Integer.valueOf(this.f13177f));
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f13177f = ((Integer) parcel.readValue(getClass().getClassLoader())).intValue();
        }
    }

    static {
        int i8 = R$attr.state_error;
        F = new int[]{i8};
        G = new int[][]{new int[]{16842910, i8}, new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};
        H = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", "android");
    }

    public MaterialCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.f12480f);
    }

    private boolean c(TintTypedArray tintTypedArray) {
        int n8 = tintTypedArray.n(R$styleable.F4, 0);
        int n9 = tintTypedArray.n(R$styleable.G4, 0);
        if (n8 != H || n9 != 0) {
            return false;
        }
        return true;
    }

    private void e() {
        this.f13166q = DrawableUtils.b(this.f13166q, this.f13169t, CompoundButtonCompat.c(this));
        this.f13167r = DrawableUtils.b(this.f13167r, this.f13170u, this.f13171v);
        g();
        h();
        super.setButtonDrawable(DrawableUtils.a(this.f13166q, this.f13167r));
        refreshDrawableState();
    }

    private void f() {
        if (Build.VERSION.SDK_INT >= 30 && this.f13175z == null) {
            super.setStateDescription(getButtonStateDescription());
        }
    }

    private void g() {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat;
        if (!this.f13168s) {
            return;
        }
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat2 = this.B;
        if (animatedVectorDrawableCompat2 != null) {
            animatedVectorDrawableCompat2.g(this.C);
            this.B.c(this.C);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            Drawable drawable = this.f13166q;
            if ((drawable instanceof AnimatedStateListDrawable) && (animatedVectorDrawableCompat = this.B) != null) {
                int i8 = R$id.f12489b;
                int i9 = R$id.f12490e0;
                ((AnimatedStateListDrawable) drawable).addTransition(i8, i9, animatedVectorDrawableCompat, false);
                ((AnimatedStateListDrawable) this.f13166q).addTransition(R$id.indeterminate, i9, this.B, false);
            }
        }
    }

    @NonNull
    private String getButtonStateDescription() {
        int i8 = this.f13172w;
        if (i8 == 1) {
            return getResources().getString(R$string.mtrl_checkbox_state_description_checked);
        }
        if (i8 == 0) {
            return getResources().getString(R$string.mtrl_checkbox_state_description_unchecked);
        }
        return getResources().getString(R$string.mtrl_checkbox_state_description_indeterminate);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f13161l == null) {
            int[][] iArr = G;
            int[] iArr2 = new int[iArr.length];
            int d8 = MaterialColors.d(this, R$attr.f12481k);
            int d9 = MaterialColors.d(this, R$attr.f12483m);
            int d10 = MaterialColors.d(this, R$attr.colorSurface);
            int d11 = MaterialColors.d(this, R$attr.colorOnSurface);
            iArr2[0] = MaterialColors.j(d10, d9, 1.0f);
            iArr2[1] = MaterialColors.j(d10, d8, 1.0f);
            iArr2[2] = MaterialColors.j(d10, d11, 0.54f);
            iArr2[3] = MaterialColors.j(d10, d11, 0.38f);
            iArr2[4] = MaterialColors.j(d10, d11, 0.38f);
            this.f13161l = new ColorStateList(iArr, iArr2);
        }
        return this.f13161l;
    }

    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.f13169t;
        if (colorStateList != null) {
            return colorStateList;
        }
        if (super.getButtonTintList() != null) {
            return super.getButtonTintList();
        }
        return getSupportButtonTintList();
    }

    private void h() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable = this.f13166q;
        if (drawable != null && (colorStateList2 = this.f13169t) != null) {
            DrawableCompat.o(drawable, colorStateList2);
        }
        Drawable drawable2 = this.f13167r;
        if (drawable2 != null && (colorStateList = this.f13170u) != null) {
            DrawableCompat.o(drawable2, colorStateList);
        }
    }

    private void i() {
    }

    public boolean d() {
        return this.f13164o;
    }

    @Override // android.widget.CompoundButton
    public Drawable getButtonDrawable() {
        return this.f13166q;
    }

    public Drawable getButtonIconDrawable() {
        return this.f13167r;
    }

    public ColorStateList getButtonIconTintList() {
        return this.f13170u;
    }

    @NonNull
    public PorterDuff.Mode getButtonIconTintMode() {
        return this.f13171v;
    }

    @Override // android.widget.CompoundButton
    public ColorStateList getButtonTintList() {
        return this.f13169t;
    }

    public int getCheckedState() {
        return this.f13172w;
    }

    public CharSequence getErrorAccessibilityLabel() {
        return this.f13165p;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public boolean isChecked() {
        if (this.f13172w == 1) {
            return true;
        }
        return false;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f13162m && this.f13169t == null && this.f13170u == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i8) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i8 + 2);
        if (getCheckedState() == 2) {
            View.mergeDrawableStates(onCreateDrawableState, E);
        }
        if (d()) {
            View.mergeDrawableStates(onCreateDrawableState, F);
        }
        this.f13173x = DrawableUtils.d(onCreateDrawableState);
        i();
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable a8;
        int i8;
        if (this.f13163n && TextUtils.isEmpty(getText()) && (a8 = CompoundButtonCompat.a(this)) != null) {
            if (ViewUtils.f(this)) {
                i8 = -1;
            } else {
                i8 = 1;
            }
            int width = ((getWidth() - a8.getIntrinsicWidth()) / 2) * i8;
            int save = canvas.save();
            canvas.translate(width, 0.0f);
            super.onDraw(canvas);
            canvas.restoreToCount(save);
            if (getBackground() != null) {
                Rect bounds = a8.getBounds();
                DrawableCompat.l(getBackground(), bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
                return;
            }
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (accessibilityNodeInfo != null && d()) {
            accessibilityNodeInfo.setText(((Object) accessibilityNodeInfo.getText()) + ", " + ((Object) this.f13165p));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCheckedState(savedState.f13177f);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f13177f = getCheckedState();
        return savedState;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(int i8) {
        setButtonDrawable(AppCompatResources.b(getContext(), i8));
    }

    public void setButtonIconDrawable(Drawable drawable) {
        this.f13167r = drawable;
        e();
    }

    public void setButtonIconDrawableResource(int i8) {
        setButtonIconDrawable(AppCompatResources.b(getContext(), i8));
    }

    public void setButtonIconTintList(ColorStateList colorStateList) {
        if (this.f13170u == colorStateList) {
            return;
        }
        this.f13170u = colorStateList;
        e();
    }

    public void setButtonIconTintMode(@NonNull PorterDuff.Mode mode) {
        if (this.f13171v == mode) {
            return;
        }
        this.f13171v = mode;
        e();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(ColorStateList colorStateList) {
        if (this.f13169t == colorStateList) {
            return;
        }
        this.f13169t = colorStateList;
        e();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        e();
    }

    public void setCenterIfNoTextEnabled(boolean z7) {
        this.f13163n = z7;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z7) {
        setCheckedState(z7 ? 1 : 0);
    }

    public void setCheckedState(int i8) {
        boolean z7;
        Object systemService;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.f13172w != i8) {
            this.f13172w = i8;
            if (i8 == 1) {
                z7 = true;
            } else {
                z7 = false;
            }
            super.setChecked(z7);
            refreshDrawableState();
            f();
            if (this.f13174y) {
                return;
            }
            this.f13174y = true;
            LinkedHashSet<OnCheckedStateChangedListener> linkedHashSet = this.f13160k;
            if (linkedHashSet != null) {
                Iterator<OnCheckedStateChangedListener> it = linkedHashSet.iterator();
                while (it.hasNext()) {
                    it.next().a(this, this.f13172w);
                }
            }
            if (this.f13172w != 2 && (onCheckedChangeListener = this.A) != null) {
                onCheckedChangeListener.onCheckedChanged(this, isChecked());
            }
            if (Build.VERSION.SDK_INT >= 26) {
                systemService = getContext().getSystemService(AutofillManager.class);
                AutofillManager autofillManager = (AutofillManager) systemService;
                if (autofillManager != null) {
                    autofillManager.notifyValueChanged(this);
                }
            }
            this.f13174y = false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z7) {
        super.setEnabled(z7);
        i();
    }

    public void setErrorAccessibilityLabel(CharSequence charSequence) {
        this.f13165p = charSequence;
    }

    public void setErrorAccessibilityLabelResource(int i8) {
        CharSequence charSequence;
        if (i8 != 0) {
            charSequence = getResources().getText(i8);
        } else {
            charSequence = null;
        }
        setErrorAccessibilityLabel(charSequence);
    }

    public void setErrorShown(boolean z7) {
        if (this.f13164o == z7) {
            return;
        }
        this.f13164o = z7;
        refreshDrawableState();
        Iterator<OnErrorChangedListener> it = this.f13159j.iterator();
        while (it.hasNext()) {
            it.next().a(this, this.f13164o);
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.A = onCheckedChangeListener;
    }

    @Override // android.widget.CompoundButton, android.view.View
    public void setStateDescription(CharSequence charSequence) {
        this.f13175z = charSequence;
        if (charSequence == null) {
            f();
        } else {
            super.setStateDescription(charSequence);
        }
    }

    public void setUseMaterialThemeColors(boolean z7) {
        this.f13162m = z7;
        if (z7) {
            CompoundButtonCompat.d(this, getMaterialThemeColorsTintList());
        } else {
            CompoundButtonCompat.d(this, null);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MaterialCheckBox(android.content.Context r9, android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            int r4 = com.google.android.material.checkbox.MaterialCheckBox.D
            android.content.Context r9 = com.google.android.material.theme.overlay.MaterialThemeOverlay.c(r9, r10, r11, r4)
            r8.<init>(r9, r10, r11)
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            r8.f13159j = r9
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            r8.f13160k = r9
            android.content.Context r9 = r8.getContext()
            int r0 = com.google.android.material.R$drawable.mtrl_checkbox_button_checked_unchecked
            androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat r9 = androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat.a(r9, r0)
            r8.B = r9
            com.google.android.material.checkbox.MaterialCheckBox$1 r9 = new com.google.android.material.checkbox.MaterialCheckBox$1
            r9.<init>()
            r8.C = r9
            android.content.Context r9 = r8.getContext()
            android.graphics.drawable.Drawable r0 = androidx.core.widget.CompoundButtonCompat.a(r8)
            r8.f13166q = r0
            android.content.res.ColorStateList r0 = r8.getSuperButtonTintList()
            r8.f13169t = r0
            r6 = 0
            r8.setSupportButtonTintList(r6)
            int[] r2 = com.google.android.material.R$styleable.E4
            r7 = 0
            int[] r5 = new int[r7]
            r0 = r9
            r1 = r10
            r3 = r11
            androidx.appcompat.widget.TintTypedArray r10 = com.google.android.material.internal.ThemeEnforcement.j(r0, r1, r2, r3, r4, r5)
            int r11 = com.google.android.material.R$styleable.H4
            android.graphics.drawable.Drawable r11 = r10.g(r11)
            r8.f13167r = r11
            android.graphics.drawable.Drawable r11 = r8.f13166q
            r0 = 1
            if (r11 == 0) goto L7c
            boolean r11 = com.google.android.material.internal.ThemeEnforcement.g(r9)
            if (r11 == 0) goto L7c
            boolean r11 = r8.c(r10)
            if (r11 == 0) goto L7c
            super.setButtonDrawable(r6)
            int r11 = com.google.android.material.R$drawable.mtrl_checkbox_button
            android.graphics.drawable.Drawable r11 = androidx.appcompat.content.res.AppCompatResources.b(r9, r11)
            r8.f13166q = r11
            r8.f13168s = r0
            android.graphics.drawable.Drawable r11 = r8.f13167r
            if (r11 != 0) goto L7c
            int r11 = com.google.android.material.R$drawable.mtrl_checkbox_button_icon
            android.graphics.drawable.Drawable r11 = androidx.appcompat.content.res.AppCompatResources.b(r9, r11)
            r8.f13167r = r11
        L7c:
            int r11 = com.google.android.material.R$styleable.I4
            android.content.res.ColorStateList r9 = com.google.android.material.resources.MaterialResources.b(r9, r10, r11)
            r8.f13170u = r9
            int r9 = com.google.android.material.R$styleable.J4
            r11 = -1
            int r9 = r10.k(r9, r11)
            android.graphics.PorterDuff$Mode r11 = android.graphics.PorterDuff.Mode.SRC_IN
            android.graphics.PorterDuff$Mode r9 = com.google.android.material.internal.ViewUtils.g(r9, r11)
            r8.f13171v = r9
            int r9 = com.google.android.material.R$styleable.O4
            boolean r9 = r10.a(r9, r7)
            r8.f13162m = r9
            int r9 = com.google.android.material.R$styleable.K4
            boolean r9 = r10.a(r9, r0)
            r8.f13163n = r9
            int r9 = com.google.android.material.R$styleable.N4
            boolean r9 = r10.a(r9, r7)
            r8.f13164o = r9
            int r9 = com.google.android.material.R$styleable.M4
            java.lang.CharSequence r9 = r10.p(r9)
            r8.f13165p = r9
            int r9 = com.google.android.material.R$styleable.L4
            boolean r11 = r10.s(r9)
            if (r11 == 0) goto Lc2
            int r9 = r10.k(r9, r7)
            r8.setCheckedState(r9)
        Lc2:
            r10.w()
            r8.e()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.checkbox.MaterialCheckBox.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        this.f13166q = drawable;
        this.f13168s = false;
        e();
    }
}
