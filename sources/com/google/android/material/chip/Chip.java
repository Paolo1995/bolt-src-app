package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R$attr;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.chip.ChipDrawable;
import com.google.android.material.internal.MaterialCheckable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceFontCallback;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.util.List;

/* loaded from: classes.dex */
public class Chip extends AppCompatCheckBox implements ChipDrawable.Delegate, Shapeable, MaterialCheckable<Chip> {
    private static final int C = R$style.Widget_MaterialComponents_Chip_Action;
    private static final Rect D = new Rect();
    private static final int[] E = {16842913};
    private static final int[] F = {16842911};
    private final RectF A;
    private final TextAppearanceFontCallback B;

    /* renamed from: j  reason: collision with root package name */
    private ChipDrawable f13178j;

    /* renamed from: k  reason: collision with root package name */
    private InsetDrawable f13179k;

    /* renamed from: l  reason: collision with root package name */
    private RippleDrawable f13180l;

    /* renamed from: m  reason: collision with root package name */
    private View.OnClickListener f13181m;

    /* renamed from: n  reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f13182n;

    /* renamed from: o  reason: collision with root package name */
    private MaterialCheckable.OnCheckedChangeListener<Chip> f13183o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f13184p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f13185q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f13186r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f13187s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f13188t;

    /* renamed from: u  reason: collision with root package name */
    private int f13189u;

    /* renamed from: v  reason: collision with root package name */
    private int f13190v;

    /* renamed from: w  reason: collision with root package name */
    private CharSequence f13191w;
    @NonNull

    /* renamed from: x  reason: collision with root package name */
    private final ChipTouchHelper f13192x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f13193y;

    /* renamed from: z  reason: collision with root package name */
    private final Rect f13194z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ChipTouchHelper extends ExploreByTouchHelper {
        ChipTouchHelper(Chip chip) {
            super(chip);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected int B(float f8, float f9) {
            if (Chip.this.n() && Chip.this.getCloseIconTouchBounds().contains(f8, f9)) {
                return 1;
            }
            return 0;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void C(@NonNull List<Integer> list) {
            list.add(0);
            if (Chip.this.n() && Chip.this.s() && Chip.this.f13181m != null) {
                list.add(1);
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected boolean J(int i8, int i9, Bundle bundle) {
            if (i9 == 16) {
                if (i8 == 0) {
                    return Chip.this.performClick();
                }
                if (i8 == 1) {
                    return Chip.this.u();
                }
                return false;
            }
            return false;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void M(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.W(Chip.this.r());
            accessibilityNodeInfoCompat.Z(Chip.this.isClickable());
            accessibilityNodeInfoCompat.Y(Chip.this.getAccessibilityClassName());
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                accessibilityNodeInfoCompat.w0(text);
            } else {
                accessibilityNodeInfoCompat.c0(text);
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void N(int i8, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            String str = "";
            if (i8 == 1) {
                CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
                if (closeIconContentDescription != null) {
                    accessibilityNodeInfoCompat.c0(closeIconContentDescription);
                } else {
                    CharSequence text = Chip.this.getText();
                    Context context = Chip.this.getContext();
                    int i9 = R$string.mtrl_chip_close_icon_content_description;
                    Object[] objArr = new Object[1];
                    if (!TextUtils.isEmpty(text)) {
                        str = text;
                    }
                    objArr[0] = str;
                    accessibilityNodeInfoCompat.c0(context.getString(i9, objArr).trim());
                }
                accessibilityNodeInfoCompat.U(Chip.this.getCloseIconTouchBoundsInt());
                accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f6045i);
                accessibilityNodeInfoCompat.e0(Chip.this.isEnabled());
                return;
            }
            accessibilityNodeInfoCompat.c0("");
            accessibilityNodeInfoCompat.U(Chip.D);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void O(int i8, boolean z7) {
            if (i8 == 1) {
                Chip.this.f13187s = z7;
                Chip.this.refreshDrawableState();
            }
        }
    }

    public Chip(Context context) {
        this(context, null);
    }

    private void A() {
        this.f13180l = new RippleDrawable(RippleUtils.e(this.f13178j.m1()), getBackgroundDrawable(), null);
        this.f13178j.S2(false);
        ViewCompat.w0(this, this.f13180l);
        B();
    }

    private void B() {
        ChipDrawable chipDrawable;
        if (!TextUtils.isEmpty(getText()) && (chipDrawable = this.f13178j) != null) {
            int Q0 = (int) (chipDrawable.Q0() + this.f13178j.q1() + this.f13178j.x0());
            int V0 = (int) (this.f13178j.V0() + this.f13178j.r1() + this.f13178j.t0());
            if (this.f13179k != null) {
                Rect rect = new Rect();
                this.f13179k.getPadding(rect);
                V0 += rect.left;
                Q0 += rect.right;
            }
            ViewCompat.H0(this, V0, getPaddingTop(), Q0, getPaddingBottom());
        }
    }

    private void C() {
        TextPaint paint = getPaint();
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            paint.drawableState = chipDrawable.getState();
        }
        TextAppearance textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.n(getContext(), paint, this.B);
        }
    }

    private void D(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") == null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") == null) {
                if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") == null) {
                    if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") == null) {
                        if (attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) == 1 && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) == 1 && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) == 1) {
                            if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                                Log.w("Chip", "Chip text must be vertically center and start aligned");
                                return;
                            }
                            return;
                        }
                        throw new UnsupportedOperationException("Chip does not support multi-line text");
                    }
                    throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
                }
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public RectF getCloseIconTouchBounds() {
        this.A.setEmpty();
        if (n() && this.f13181m != null) {
            this.f13178j.f1(this.A);
        }
        return this.A;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.f13194z.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.f13194z;
    }

    private TextAppearance getTextAppearance() {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            return chipDrawable.p1();
        }
        return null;
    }

    private void j(@NonNull ChipDrawable chipDrawable) {
        chipDrawable.w2(this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [int, boolean] */
    @NonNull
    private int[] k() {
        ?? isEnabled = isEnabled();
        int i8 = isEnabled;
        if (this.f13187s) {
            i8 = isEnabled + 1;
        }
        int i9 = i8;
        if (this.f13186r) {
            i9 = i8 + 1;
        }
        int i10 = i9;
        if (this.f13185q) {
            i10 = i9 + 1;
        }
        int i11 = i10;
        if (isChecked()) {
            i11 = i10 + 1;
        }
        int[] iArr = new int[i11];
        int i12 = 0;
        if (isEnabled()) {
            iArr[0] = 16842910;
            i12 = 1;
        }
        if (this.f13187s) {
            iArr[i12] = 16842908;
            i12++;
        }
        if (this.f13186r) {
            iArr[i12] = 16843623;
            i12++;
        }
        if (this.f13185q) {
            iArr[i12] = 16842919;
            i12++;
        }
        if (isChecked()) {
            iArr[i12] = 16842913;
        }
        return iArr;
    }

    private void m() {
        if (getBackgroundDrawable() == this.f13179k && this.f13178j.getCallback() == null) {
            this.f13178j.setCallback(this.f13179k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n() {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null && chipDrawable.Y0() != null) {
            return true;
        }
        return false;
    }

    private void o(Context context, AttributeSet attributeSet, int i8) {
        TypedArray i9 = ThemeEnforcement.i(context, attributeSet, R$styleable.G0, i8, C, new int[0]);
        this.f13188t = i9.getBoolean(R$styleable.f12614n1, false);
        this.f13190v = (int) Math.ceil(i9.getDimension(R$styleable.f12506b1, (float) Math.ceil(ViewUtils.c(getContext(), 48))));
        i9.recycle();
    }

    private void p() {
        setOutlineProvider(new ViewOutlineProvider() { // from class: com.google.android.material.chip.Chip.2
            @Override // android.view.ViewOutlineProvider
            @TargetApi(21)
            public void getOutline(View view, @NonNull Outline outline) {
                if (Chip.this.f13178j != null) {
                    Chip.this.f13178j.getOutline(outline);
                } else {
                    outline.setAlpha(0.0f);
                }
            }
        });
    }

    private void q(int i8, int i9, int i10, int i11) {
        this.f13179k = new InsetDrawable((Drawable) this.f13178j, i8, i9, i10, i11);
    }

    private void setCloseIconHovered(boolean z7) {
        if (this.f13186r != z7) {
            this.f13186r = z7;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z7) {
        if (this.f13185q != z7) {
            this.f13185q = z7;
            refreshDrawableState();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(CompoundButton compoundButton, boolean z7) {
        MaterialCheckable.OnCheckedChangeListener<Chip> onCheckedChangeListener = this.f13183o;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.a(this, z7);
        }
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener2 = this.f13182n;
        if (onCheckedChangeListener2 != null) {
            onCheckedChangeListener2.onCheckedChanged(compoundButton, z7);
        }
    }

    private void v() {
        if (this.f13179k != null) {
            this.f13179k = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            z();
        }
    }

    private void x(ChipDrawable chipDrawable) {
        if (chipDrawable != null) {
            chipDrawable.w2(null);
        }
    }

    private void y() {
        if (n() && s() && this.f13181m != null) {
            ViewCompat.s0(this, this.f13192x);
            this.f13193y = true;
            return;
        }
        ViewCompat.s0(this, null);
        this.f13193y = false;
    }

    private void z() {
        if (RippleUtils.f13902a) {
            A();
            return;
        }
        this.f13178j.S2(true);
        ViewCompat.w0(this, getBackgroundDrawable());
        B();
        m();
    }

    @Override // com.google.android.material.chip.ChipDrawable.Delegate
    public void a() {
        l(this.f13190v);
        requestLayout();
        invalidateOutline();
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        if (!this.f13193y) {
            return super.dispatchHoverEvent(motionEvent);
        }
        if (!this.f13192x.v(motionEvent) && !super.dispatchHoverEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.f13193y) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (this.f13192x.w(keyEvent) && this.f13192x.A() != Integer.MIN_VALUE) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        boolean z7;
        super.drawableStateChanged();
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null && chipDrawable.w1()) {
            z7 = this.f13178j.s2(k());
        } else {
            z7 = false;
        }
        if (z7) {
            invalidate();
        }
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.f13191w)) {
            return this.f13191w;
        }
        if (r()) {
            ViewParent parent = getParent();
            if (!(parent instanceof ChipGroup) || !((ChipGroup) parent).i()) {
                return "android.widget.Button";
            }
            return "android.widget.RadioButton";
        } else if (isClickable()) {
            return "android.widget.Button";
        } else {
            return "android.view.View";
        }
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f13179k;
        if (insetDrawable == null) {
            return this.f13178j;
        }
        return insetDrawable;
    }

    public Drawable getCheckedIcon() {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            return chipDrawable.M0();
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            return chipDrawable.N0();
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            return chipDrawable.O0();
        }
        return null;
    }

    public float getChipCornerRadius() {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable == null) {
            return 0.0f;
        }
        return Math.max(0.0f, chipDrawable.P0());
    }

    public Drawable getChipDrawable() {
        return this.f13178j;
    }

    public float getChipEndPadding() {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            return chipDrawable.Q0();
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            return chipDrawable.R0();
        }
        return null;
    }

    public float getChipIconSize() {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            return chipDrawable.S0();
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            return chipDrawable.T0();
        }
        return null;
    }

    public float getChipMinHeight() {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            return chipDrawable.U0();
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            return chipDrawable.V0();
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            return chipDrawable.W0();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            return chipDrawable.X0();
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            return chipDrawable.Y0();
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            return chipDrawable.Z0();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            return chipDrawable.a1();
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            return chipDrawable.b1();
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            return chipDrawable.c1();
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            return chipDrawable.e1();
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            return chipDrawable.i1();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(@NonNull Rect rect) {
        if (this.f13193y && (this.f13192x.A() == 1 || this.f13192x.x() == 1)) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    public MotionSpec getHideMotionSpec() {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            return chipDrawable.j1();
        }
        return null;
    }

    public float getIconEndPadding() {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            return chipDrawable.k1();
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            return chipDrawable.l1();
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            return chipDrawable.m1();
        }
        return null;
    }

    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.f13178j.F();
    }

    public MotionSpec getShowMotionSpec() {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            return chipDrawable.n1();
        }
        return null;
    }

    public float getTextEndPadding() {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            return chipDrawable.q1();
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            return chipDrawable.r1();
        }
        return 0.0f;
    }

    public boolean l(int i8) {
        int i9;
        this.f13190v = i8;
        int i10 = 0;
        if (!w()) {
            if (this.f13179k != null) {
                v();
            } else {
                z();
            }
            return false;
        }
        int max = Math.max(0, i8 - this.f13178j.getIntrinsicHeight());
        int max2 = Math.max(0, i8 - this.f13178j.getIntrinsicWidth());
        if (max2 <= 0 && max <= 0) {
            if (this.f13179k != null) {
                v();
            } else {
                z();
            }
            return false;
        }
        if (max2 > 0) {
            i9 = max2 / 2;
        } else {
            i9 = 0;
        }
        if (max > 0) {
            i10 = max / 2;
        }
        if (this.f13179k != null) {
            Rect rect = new Rect();
            this.f13179k.getPadding(rect);
            if (rect.top == i10 && rect.bottom == i10 && rect.left == i9 && rect.right == i9) {
                z();
                return true;
            }
        }
        if (getMinHeight() != i8) {
            setMinHeight(i8);
        }
        if (getMinWidth() != i8) {
            setMinWidth(i8);
        }
        q(i9, i10, i9, i10);
        z();
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.f(this, this.f13178j);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i8) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i8 + 2);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, E);
        }
        if (r()) {
            View.mergeDrawableStates(onCreateDrawableState, F);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z7, int i8, Rect rect) {
        super.onFocusChanged(z7, i8, rect);
        if (this.f13193y) {
            this.f13192x.I(z7, i8, rect);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(@NonNull MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 7) {
            if (actionMasked == 10) {
                setCloseIconHovered(false);
            }
        } else {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        int i8;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        accessibilityNodeInfo.setCheckable(r());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            AccessibilityNodeInfoCompat A0 = AccessibilityNodeInfoCompat.A0(accessibilityNodeInfo);
            if (chipGroup.c()) {
                i8 = chipGroup.g(this);
            } else {
                i8 = -1;
            }
            A0.b0(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(chipGroup.b(this), 1, i8, 1, false, isChecked()));
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(@NonNull MotionEvent motionEvent, int i8) {
        if (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
            return PointerIcon.getSystemIcon(getContext(), 1002);
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(17)
    public void onRtlPropertiesChanged(int i8) {
        super.onRtlPropertiesChanged(i8);
        if (this.f13189u != i8) {
            this.f13189u = i8;
            B();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
        if (r0 != 3) goto L16;
     */
    @Override // android.widget.TextView, android.view.View
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L39
            if (r0 == r3) goto L2b
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L34
            goto L40
        L21:
            boolean r0 = r5.f13185q
            if (r0 == 0) goto L40
            if (r1 != 0) goto L3e
            r5.setCloseIconPressed(r2)
            goto L3e
        L2b:
            boolean r0 = r5.f13185q
            if (r0 == 0) goto L34
            r5.u()
            r0 = 1
            goto L35
        L34:
            r0 = 0
        L35:
            r5.setCloseIconPressed(r2)
            goto L41
        L39:
            if (r1 == 0) goto L40
            r5.setCloseIconPressed(r3)
        L3e:
            r0 = 1
            goto L41
        L40:
            r0 = 0
        L41:
            if (r0 != 0) goto L49
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L4a
        L49:
            r2 = 1
        L4a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean r() {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null && chipDrawable.v1()) {
            return true;
        }
        return false;
    }

    public boolean s() {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null && chipDrawable.x1()) {
            return true;
        }
        return false;
    }

    public void setAccessibilityClassName(CharSequence charSequence) {
        this.f13191w = charSequence;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable != getBackgroundDrawable() && drawable != this.f13180l) {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        } else {
            super.setBackground(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i8) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable != getBackgroundDrawable() && drawable != this.f13180l) {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        } else {
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int i8) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z7) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.E1(z7);
        }
    }

    public void setCheckableResource(int i8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.F1(i8);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z7) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable == null) {
            this.f13184p = z7;
        } else if (chipDrawable.v1()) {
            super.setChecked(z7);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.G1(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z7) {
        setCheckedIconVisible(z7);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i8) {
        setCheckedIconVisible(i8);
    }

    public void setCheckedIconResource(int i8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.H1(i8);
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.I1(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.J1(i8);
        }
    }

    public void setCheckedIconVisible(int i8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.K1(i8);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.M1(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(int i8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.N1(i8);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.O1(f8);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.P1(i8);
        }
    }

    public void setChipDrawable(@NonNull ChipDrawable chipDrawable) {
        ChipDrawable chipDrawable2 = this.f13178j;
        if (chipDrawable2 != chipDrawable) {
            x(chipDrawable2);
            this.f13178j = chipDrawable;
            chipDrawable.H2(false);
            j(this.f13178j);
            l(this.f13190v);
        }
    }

    public void setChipEndPadding(float f8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.Q1(f8);
        }
    }

    public void setChipEndPaddingResource(int i8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.R1(i8);
        }
    }

    public void setChipIcon(Drawable drawable) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.S1(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z7) {
        setChipIconVisible(z7);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i8) {
        setChipIconVisible(i8);
    }

    public void setChipIconResource(int i8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.T1(i8);
        }
    }

    public void setChipIconSize(float f8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.U1(f8);
        }
    }

    public void setChipIconSizeResource(int i8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.V1(i8);
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.W1(colorStateList);
        }
    }

    public void setChipIconTintResource(int i8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.X1(i8);
        }
    }

    public void setChipIconVisible(int i8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.Y1(i8);
        }
    }

    public void setChipMinHeight(float f8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.a2(f8);
        }
    }

    public void setChipMinHeightResource(int i8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.b2(i8);
        }
    }

    public void setChipStartPadding(float f8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.c2(f8);
        }
    }

    public void setChipStartPaddingResource(int i8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.d2(i8);
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.e2(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.f2(i8);
        }
    }

    public void setChipStrokeWidth(float f8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.g2(f8);
        }
    }

    public void setChipStrokeWidthResource(int i8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.h2(i8);
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i8) {
        setText(getResources().getString(i8));
    }

    public void setCloseIcon(Drawable drawable) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.j2(drawable);
        }
        y();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.k2(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z7) {
        setCloseIconVisible(z7);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i8) {
        setCloseIconVisible(i8);
    }

    public void setCloseIconEndPadding(float f8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.l2(f8);
        }
    }

    public void setCloseIconEndPaddingResource(int i8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.m2(i8);
        }
    }

    public void setCloseIconResource(int i8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.n2(i8);
        }
        y();
    }

    public void setCloseIconSize(float f8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.o2(f8);
        }
    }

    public void setCloseIconSizeResource(int i8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.p2(i8);
        }
    }

    public void setCloseIconStartPadding(float f8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.q2(f8);
        }
    }

    public void setCloseIconStartPaddingResource(int i8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.r2(i8);
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.t2(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.u2(i8);
        }
    }

    public void setCloseIconVisible(int i8) {
        setCloseIconVisible(getResources().getBoolean(i8));
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable == null) {
            if (drawable3 == null) {
                super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
                return;
            }
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable == null) {
            if (drawable3 == null) {
                super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
                return;
            }
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i8, int i9, int i10, int i11) {
        if (i8 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i10 == 0) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(i8, i9, i10, i11);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i8, int i9, int i10, int i11) {
        if (i8 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i10 == 0) {
            super.setCompoundDrawablesWithIntrinsicBounds(i8, i9, i10, i11);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.view.View
    public void setElevation(float f8) {
        super.setElevation(f8);
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.b0(f8);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f13178j == null) {
            return;
        }
        if (truncateAt != TextUtils.TruncateAt.MARQUEE) {
            super.setEllipsize(truncateAt);
            ChipDrawable chipDrawable = this.f13178j;
            if (chipDrawable != null) {
                chipDrawable.x2(truncateAt);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
    }

    public void setEnsureMinTouchTargetSize(boolean z7) {
        this.f13188t = z7;
        l(this.f13190v);
    }

    @Override // android.widget.TextView
    public void setGravity(int i8) {
        if (i8 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i8);
        }
    }

    public void setHideMotionSpec(MotionSpec motionSpec) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.y2(motionSpec);
        }
    }

    public void setHideMotionSpecResource(int i8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.z2(i8);
        }
    }

    public void setIconEndPadding(float f8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.A2(f8);
        }
    }

    public void setIconEndPaddingResource(int i8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.B2(i8);
        }
    }

    public void setIconStartPadding(float f8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.C2(f8);
        }
    }

    public void setIconStartPaddingResource(int i8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.D2(i8);
        }
    }

    @Override // com.google.android.material.internal.MaterialCheckable
    public void setInternalOnCheckedChangeListener(MaterialCheckable.OnCheckedChangeListener<Chip> onCheckedChangeListener) {
        this.f13183o = onCheckedChangeListener;
    }

    @Override // android.view.View
    public void setLayoutDirection(int i8) {
        if (this.f13178j == null) {
            return;
        }
        super.setLayoutDirection(i8);
    }

    @Override // android.widget.TextView
    public void setLines(int i8) {
        if (i8 <= 1) {
            super.setLines(i8);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i8) {
        if (i8 <= 1) {
            super.setMaxLines(i8);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i8) {
        super.setMaxWidth(i8);
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.E2(i8);
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i8) {
        if (i8 <= 1) {
            super.setMinLines(i8);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f13182n = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f13181m = onClickListener;
        y();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.F2(colorStateList);
        }
        if (!this.f13178j.t1()) {
            A();
        }
    }

    public void setRippleColorResource(int i8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.G2(i8);
            if (!this.f13178j.t1()) {
                A();
            }
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.f13178j.setShapeAppearanceModel(shapeAppearanceModel);
    }

    public void setShowMotionSpec(MotionSpec motionSpec) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.I2(motionSpec);
        }
    }

    public void setShowMotionSpecResource(int i8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.J2(i8);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z7) {
        if (z7) {
            super.setSingleLine(z7);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        CharSequence charSequence2;
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        if (chipDrawable.T2()) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        super.setText(charSequence2, bufferType);
        ChipDrawable chipDrawable2 = this.f13178j;
        if (chipDrawable2 != null) {
            chipDrawable2.K2(charSequence);
        }
    }

    public void setTextAppearance(TextAppearance textAppearance) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.L2(textAppearance);
        }
        C();
    }

    public void setTextAppearanceResource(int i8) {
        setTextAppearance(getContext(), i8);
    }

    public void setTextEndPadding(float f8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.N2(f8);
        }
    }

    public void setTextEndPaddingResource(int i8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.O2(i8);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i8, float f8) {
        super.setTextSize(i8, f8);
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.P2(TypedValue.applyDimension(i8, f8, getResources().getDisplayMetrics()));
        }
        C();
    }

    public void setTextStartPadding(float f8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.Q2(f8);
        }
    }

    public void setTextStartPaddingResource(int i8) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.R2(i8);
        }
    }

    public boolean u() {
        boolean z7 = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f13181m;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z7 = true;
        }
        if (this.f13193y) {
            this.f13192x.U(1, 1);
        }
        return z7;
    }

    public boolean w() {
        return this.f13188t;
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.chipStyle);
    }

    public void setCloseIconVisible(boolean z7) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.v2(z7);
        }
        y();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Chip(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = com.google.android.material.chip.Chip.C
            android.content.Context r8 = com.google.android.material.theme.overlay.MaterialThemeOverlay.c(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            android.graphics.Rect r8 = new android.graphics.Rect
            r8.<init>()
            r7.f13194z = r8
            android.graphics.RectF r8 = new android.graphics.RectF
            r8.<init>()
            r7.A = r8
            com.google.android.material.chip.Chip$1 r8 = new com.google.android.material.chip.Chip$1
            r8.<init>()
            r7.B = r8
            android.content.Context r8 = r7.getContext()
            r7.D(r9)
            com.google.android.material.chip.ChipDrawable r6 = com.google.android.material.chip.ChipDrawable.C0(r8, r9, r10, r4)
            r7.o(r8, r9, r10)
            r7.setChipDrawable(r6)
            float r0 = androidx.core.view.ViewCompat.y(r7)
            r6.b0(r0)
            int[] r2 = com.google.android.material.R$styleable.G0
            r0 = 0
            int[] r5 = new int[r0]
            r0 = r8
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.ThemeEnforcement.i(r0, r1, r2, r3, r4, r5)
            int r10 = android.os.Build.VERSION.SDK_INT
            r0 = 23
            if (r10 >= r0) goto L51
            int r10 = com.google.android.material.R$styleable.J0
            android.content.res.ColorStateList r8 = com.google.android.material.resources.MaterialResources.a(r8, r9, r10)
            r7.setTextColor(r8)
        L51:
            int r8 = com.google.android.material.R$styleable.f12658s1
            boolean r8 = r9.hasValue(r8)
            r9.recycle()
            com.google.android.material.chip.Chip$ChipTouchHelper r9 = new com.google.android.material.chip.Chip$ChipTouchHelper
            r9.<init>(r7)
            r7.f13192x = r9
            r7.y()
            if (r8 != 0) goto L69
            r7.p()
        L69:
            boolean r8 = r7.f13184p
            r7.setChecked(r8)
            java.lang.CharSequence r8 = r6.o1()
            r7.setText(r8)
            android.text.TextUtils$TruncateAt r8 = r6.i1()
            r7.setEllipsize(r8)
            r7.C()
            com.google.android.material.chip.ChipDrawable r8 = r7.f13178j
            boolean r8 = r8.T2()
            if (r8 != 0) goto L8e
            r8 = 1
            r7.setLines(r8)
            r7.setHorizontallyScrolling(r8)
        L8e:
            r8 = 8388627(0x800013, float:1.175497E-38)
            r7.setGravity(r8)
            r7.B()
            boolean r8 = r7.w()
            if (r8 == 0) goto La2
            int r8 = r7.f13190v
            r7.setMinHeight(r8)
        La2:
            int r8 = androidx.core.view.ViewCompat.E(r7)
            r7.f13189u = r8
            v.a r8 = new v.a
            r8.<init>()
            super.setOnCheckedChangeListener(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setCheckedIconVisible(boolean z7) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.L1(z7);
        }
    }

    public void setChipIconVisible(boolean z7) {
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.Z1(z7);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i8) {
        super.setTextAppearance(context, i8);
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.M2(i8);
        }
        C();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i8) {
        super.setTextAppearance(i8);
        ChipDrawable chipDrawable = this.f13178j;
        if (chipDrawable != null) {
            chipDrawable.M2(i8);
        }
        C();
    }
}
