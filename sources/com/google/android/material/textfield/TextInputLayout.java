package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {
    private static final int D0 = R$style.Widget_Design_TextInputLayout;
    private static final int[][] E0 = {new int[]{16842919}, new int[0]};
    private int A;
    private ValueAnimator A0;
    private Fade B;
    private boolean B0;
    private Fade C;
    private boolean C0;
    private ColorStateList D;
    private ColorStateList E;
    private boolean F;
    private CharSequence G;
    private boolean H;
    private MaterialShapeDrawable I;
    private MaterialShapeDrawable J;
    private StateListDrawable K;
    private boolean L;
    private MaterialShapeDrawable M;
    private MaterialShapeDrawable N;
    @NonNull
    private ShapeAppearanceModel O;
    private boolean P;
    private final int Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int V;
    private int W;

    /* renamed from: a0  reason: collision with root package name */
    private int f14413a0;

    /* renamed from: b0  reason: collision with root package name */
    private final Rect f14414b0;

    /* renamed from: c0  reason: collision with root package name */
    private final Rect f14415c0;

    /* renamed from: d0  reason: collision with root package name */
    private final RectF f14416d0;

    /* renamed from: e0  reason: collision with root package name */
    private Typeface f14417e0;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final FrameLayout f14418f;

    /* renamed from: f0  reason: collision with root package name */
    private Drawable f14419f0;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final StartCompoundLayout f14420g;

    /* renamed from: g0  reason: collision with root package name */
    private int f14421g0;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final EndCompoundLayout f14422h;

    /* renamed from: h0  reason: collision with root package name */
    private final LinkedHashSet<OnEditTextAttachedListener> f14423h0;

    /* renamed from: i  reason: collision with root package name */
    EditText f14424i;

    /* renamed from: i0  reason: collision with root package name */
    private Drawable f14425i0;

    /* renamed from: j  reason: collision with root package name */
    private CharSequence f14426j;

    /* renamed from: j0  reason: collision with root package name */
    private int f14427j0;

    /* renamed from: k  reason: collision with root package name */
    private int f14428k;

    /* renamed from: k0  reason: collision with root package name */
    private Drawable f14429k0;

    /* renamed from: l  reason: collision with root package name */
    private int f14430l;

    /* renamed from: l0  reason: collision with root package name */
    private ColorStateList f14431l0;

    /* renamed from: m  reason: collision with root package name */
    private int f14432m;

    /* renamed from: m0  reason: collision with root package name */
    private ColorStateList f14433m0;

    /* renamed from: n  reason: collision with root package name */
    private int f14434n;

    /* renamed from: n0  reason: collision with root package name */
    private int f14435n0;

    /* renamed from: o  reason: collision with root package name */
    private final IndicatorViewController f14436o;

    /* renamed from: o0  reason: collision with root package name */
    private int f14437o0;

    /* renamed from: p  reason: collision with root package name */
    boolean f14438p;

    /* renamed from: p0  reason: collision with root package name */
    private int f14439p0;

    /* renamed from: q  reason: collision with root package name */
    private int f14440q;

    /* renamed from: q0  reason: collision with root package name */
    private ColorStateList f14441q0;

    /* renamed from: r  reason: collision with root package name */
    private boolean f14442r;

    /* renamed from: r0  reason: collision with root package name */
    private int f14443r0;
    @NonNull

    /* renamed from: s  reason: collision with root package name */
    private LengthCounter f14444s;

    /* renamed from: s0  reason: collision with root package name */
    private int f14445s0;

    /* renamed from: t  reason: collision with root package name */
    private TextView f14446t;

    /* renamed from: t0  reason: collision with root package name */
    private int f14447t0;

    /* renamed from: u  reason: collision with root package name */
    private int f14448u;

    /* renamed from: u0  reason: collision with root package name */
    private int f14449u0;

    /* renamed from: v  reason: collision with root package name */
    private int f14450v;

    /* renamed from: v0  reason: collision with root package name */
    private int f14451v0;

    /* renamed from: w  reason: collision with root package name */
    private CharSequence f14452w;

    /* renamed from: w0  reason: collision with root package name */
    private boolean f14453w0;

    /* renamed from: x  reason: collision with root package name */
    private boolean f14454x;

    /* renamed from: x0  reason: collision with root package name */
    final CollapsingTextHelper f14455x0;

    /* renamed from: y  reason: collision with root package name */
    private TextView f14456y;

    /* renamed from: y0  reason: collision with root package name */
    private boolean f14457y0;

    /* renamed from: z  reason: collision with root package name */
    private ColorStateList f14458z;

    /* renamed from: z0  reason: collision with root package name */
    private boolean f14459z0;

    /* loaded from: classes.dex */
    public static class AccessibilityDelegate extends AccessibilityDelegateCompat {

        /* renamed from: d  reason: collision with root package name */
        private final TextInputLayout f14464d;

        public AccessibilityDelegate(@NonNull TextInputLayout textInputLayout) {
            this.f14464d = textInputLayout;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void g(@NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            CharSequence charSequence;
            boolean z7;
            String str;
            super.g(view, accessibilityNodeInfoCompat);
            EditText editText = this.f14464d.getEditText();
            if (editText != null) {
                charSequence = editText.getText();
            } else {
                charSequence = null;
            }
            CharSequence hint = this.f14464d.getHint();
            CharSequence error = this.f14464d.getError();
            CharSequence placeholderText = this.f14464d.getPlaceholderText();
            int counterMaxLength = this.f14464d.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.f14464d.getCounterOverflowDescription();
            boolean z8 = !TextUtils.isEmpty(charSequence);
            boolean z9 = !TextUtils.isEmpty(hint);
            boolean z10 = !this.f14464d.O();
            boolean z11 = !TextUtils.isEmpty(error);
            if (!z11 && TextUtils.isEmpty(counterOverflowDescription)) {
                z7 = false;
            } else {
                z7 = true;
            }
            if (z9) {
                str = hint.toString();
            } else {
                str = "";
            }
            this.f14464d.f14420g.z(accessibilityNodeInfoCompat);
            if (z8) {
                accessibilityNodeInfoCompat.w0(charSequence);
            } else if (!TextUtils.isEmpty(str)) {
                accessibilityNodeInfoCompat.w0(str);
                if (z10 && placeholderText != null) {
                    accessibilityNodeInfoCompat.w0(str + ", " + ((Object) placeholderText));
                }
            } else if (placeholderText != null) {
                accessibilityNodeInfoCompat.w0(placeholderText);
            }
            if (!TextUtils.isEmpty(str)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    accessibilityNodeInfoCompat.j0(str);
                } else {
                    if (z8) {
                        str = ((Object) charSequence) + ", " + str;
                    }
                    accessibilityNodeInfoCompat.w0(str);
                }
                accessibilityNodeInfoCompat.t0(!z8);
            }
            accessibilityNodeInfoCompat.l0((charSequence == null || charSequence.length() != counterMaxLength) ? -1 : -1);
            if (z7) {
                if (!z11) {
                    error = counterOverflowDescription;
                }
                accessibilityNodeInfoCompat.f0(error);
            }
            View t7 = this.f14464d.f14436o.t();
            if (t7 != null) {
                accessibilityNodeInfoCompat.k0(t7);
            }
            this.f14464d.f14422h.m().o(view, accessibilityNodeInfoCompat);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void h(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
            super.h(view, accessibilityEvent);
            this.f14464d.f14422h.m().p(view, accessibilityEvent);
        }
    }

    /* loaded from: classes.dex */
    public interface LengthCounter {
        int a(Editable editable);
    }

    /* loaded from: classes.dex */
    public interface OnEditTextAttachedListener {
        void a(@NonNull TextInputLayout textInputLayout);
    }

    /* loaded from: classes.dex */
    public interface OnEndIconChangedListener {
        void a(@NonNull TextInputLayout textInputLayout, int i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.textfield.TextInputLayout.SavedState.1
            @Override // android.os.Parcelable.Creator
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
        CharSequence f14465h;

        /* renamed from: i  reason: collision with root package name */
        boolean f14466i;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @NonNull
        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f14465h) + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i8) {
            super.writeToParcel(parcel, i8);
            TextUtils.writeToParcel(this.f14465h, parcel, i8);
            parcel.writeInt(this.f14466i ? 1 : 0);
        }

        SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f14465h = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f14466i = parcel.readInt() == 1;
        }
    }

    public TextInputLayout(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.textInputStyle);
    }

    private boolean A() {
        if (this.F && !TextUtils.isEmpty(this.G) && (this.I instanceof CutoutDrawable)) {
            return true;
        }
        return false;
    }

    private void B() {
        Iterator<OnEditTextAttachedListener> it = this.f14423h0.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    private void C(Canvas canvas) {
        MaterialShapeDrawable materialShapeDrawable;
        if (this.N != null && (materialShapeDrawable = this.M) != null) {
            materialShapeDrawable.draw(canvas);
            if (this.f14424i.isFocused()) {
                Rect bounds = this.N.getBounds();
                Rect bounds2 = this.M.getBounds();
                float F = this.f14455x0.F();
                int centerX = bounds2.centerX();
                bounds.left = AnimationUtils.c(centerX, bounds2.left, F);
                bounds.right = AnimationUtils.c(centerX, bounds2.right, F);
                this.N.draw(canvas);
            }
        }
    }

    private void D(@NonNull Canvas canvas) {
        if (this.F) {
            this.f14455x0.l(canvas);
        }
    }

    private void E(boolean z7) {
        ValueAnimator valueAnimator = this.A0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.A0.cancel();
        }
        if (z7 && this.f14459z0) {
            k(0.0f);
        } else {
            this.f14455x0.y0(0.0f);
        }
        if (A() && ((CutoutDrawable) this.I).s0()) {
            x();
        }
        this.f14453w0 = true;
        K();
        this.f14420g.k(true);
        this.f14422h.G(true);
    }

    private MaterialShapeDrawable F(boolean z7) {
        float f8;
        float dimensionPixelOffset;
        float dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R$dimen.mtrl_shape_corner_size_small_component);
        if (z7) {
            f8 = dimensionPixelOffset2;
        } else {
            f8 = 0.0f;
        }
        EditText editText = this.f14424i;
        if (editText instanceof MaterialAutoCompleteTextView) {
            dimensionPixelOffset = ((MaterialAutoCompleteTextView) editText).getPopupElevation();
        } else {
            dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.m3_comp_outlined_autocomplete_menu_container_elevation);
        }
        int dimensionPixelOffset3 = getResources().getDimensionPixelOffset(R$dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        ShapeAppearanceModel m8 = ShapeAppearanceModel.a().A(f8).E(f8).s(dimensionPixelOffset2).w(dimensionPixelOffset2).m();
        MaterialShapeDrawable m9 = MaterialShapeDrawable.m(getContext(), dimensionPixelOffset);
        m9.setShapeAppearanceModel(m8);
        m9.e0(0, dimensionPixelOffset3, 0, dimensionPixelOffset3);
        return m9;
    }

    private static Drawable G(MaterialShapeDrawable materialShapeDrawable, int i8, int i9, int[][] iArr) {
        return new RippleDrawable(new ColorStateList(iArr, new int[]{MaterialColors.j(i9, i8, 0.1f), i8}), materialShapeDrawable, materialShapeDrawable);
    }

    private int H(int i8, boolean z7) {
        int compoundPaddingLeft = i8 + this.f14424i.getCompoundPaddingLeft();
        if (getPrefixText() != null && !z7) {
            return (compoundPaddingLeft - getPrefixTextView().getMeasuredWidth()) + getPrefixTextView().getPaddingLeft();
        }
        return compoundPaddingLeft;
    }

    private int I(int i8, boolean z7) {
        int compoundPaddingRight = i8 - this.f14424i.getCompoundPaddingRight();
        if (getPrefixText() != null && z7) {
            return compoundPaddingRight + (getPrefixTextView().getMeasuredWidth() - getPrefixTextView().getPaddingRight());
        }
        return compoundPaddingRight;
    }

    private static Drawable J(Context context, MaterialShapeDrawable materialShapeDrawable, int i8, int[][] iArr) {
        int c8 = MaterialColors.c(context, R$attr.colorSurface, "TextInputLayout");
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(materialShapeDrawable.F());
        int j8 = MaterialColors.j(i8, c8, 0.1f);
        materialShapeDrawable2.c0(new ColorStateList(iArr, new int[]{j8, 0}));
        materialShapeDrawable2.setTint(c8);
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{j8, c8});
        MaterialShapeDrawable materialShapeDrawable3 = new MaterialShapeDrawable(materialShapeDrawable.F());
        materialShapeDrawable3.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, materialShapeDrawable2, materialShapeDrawable3), materialShapeDrawable});
    }

    private void K() {
        TextView textView = this.f14456y;
        if (textView != null && this.f14454x) {
            textView.setText((CharSequence) null);
            TransitionManager.b(this.f14418f, this.C);
            this.f14456y.setVisibility(4);
        }
    }

    private boolean Q() {
        if (this.R == 1 && this.f14424i.getMinLines() <= 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int R(Editable editable) {
        if (editable != null) {
            return editable.length();
        }
        return 0;
    }

    private void S() {
        o();
        n0();
        w0();
        e0();
        j();
        if (this.R != 0) {
            p0();
        }
        Y();
    }

    private void T() {
        if (!A()) {
            return;
        }
        RectF rectF = this.f14416d0;
        this.f14455x0.o(rectF, this.f14424i.getWidth(), this.f14424i.getGravity());
        if (rectF.width() > 0.0f && rectF.height() > 0.0f) {
            n(rectF);
            rectF.offset(-getPaddingLeft(), ((-getPaddingTop()) - (rectF.height() / 2.0f)) + this.T);
            ((CutoutDrawable) this.I).v0(rectF);
        }
    }

    private void U() {
        if (A() && !this.f14453w0) {
            x();
            T();
        }
    }

    private static void V(@NonNull ViewGroup viewGroup, boolean z7) {
        int childCount = viewGroup.getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = viewGroup.getChildAt(i8);
            childAt.setEnabled(z7);
            if (childAt instanceof ViewGroup) {
                V((ViewGroup) childAt, z7);
            }
        }
    }

    private void X() {
        TextView textView = this.f14456y;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void Y() {
        EditText editText = this.f14424i;
        if (!(editText instanceof AutoCompleteTextView)) {
            return;
        }
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
        if (autoCompleteTextView.getDropDownBackground() == null) {
            int i8 = this.R;
            if (i8 == 2) {
                autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
            } else if (i8 == 1) {
                autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateFilledDropDownMenuBackground());
            }
        }
    }

    private boolean b0() {
        if ((this.f14422h.F() || ((this.f14422h.z() && L()) || this.f14422h.w() != null)) && this.f14422h.getMeasuredWidth() > 0) {
            return true;
        }
        return false;
    }

    private boolean c0() {
        if ((getStartIconDrawable() != null || (getPrefixText() != null && getPrefixTextView().getVisibility() == 0)) && this.f14420g.getMeasuredWidth() > 0) {
            return true;
        }
        return false;
    }

    private void d0() {
        if (this.f14456y != null && this.f14454x && !TextUtils.isEmpty(this.f14452w)) {
            this.f14456y.setText(this.f14452w);
            TransitionManager.b(this.f14418f, this.B);
            this.f14456y.setVisibility(0);
            this.f14456y.bringToFront();
            announceForAccessibility(this.f14452w);
        }
    }

    private void e0() {
        if (this.R == 1) {
            if (MaterialResources.j(getContext())) {
                this.S = getResources().getDimensionPixelSize(R$dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (MaterialResources.i(getContext())) {
                this.S = getResources().getDimensionPixelSize(R$dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
    }

    private void f0(@NonNull Rect rect) {
        MaterialShapeDrawable materialShapeDrawable = this.M;
        if (materialShapeDrawable != null) {
            int i8 = rect.bottom;
            materialShapeDrawable.setBounds(rect.left, i8 - this.U, rect.right, i8);
        }
        MaterialShapeDrawable materialShapeDrawable2 = this.N;
        if (materialShapeDrawable2 != null) {
            int i9 = rect.bottom;
            materialShapeDrawable2.setBounds(rect.left, i9 - this.V, rect.right, i9);
        }
    }

    private void g0() {
        Editable text;
        if (this.f14446t != null) {
            EditText editText = this.f14424i;
            if (editText == null) {
                text = null;
            } else {
                text = editText.getText();
            }
            h0(text);
        }
    }

    private Drawable getEditTextBoxBackground() {
        EditText editText = this.f14424i;
        if ((editText instanceof AutoCompleteTextView) && !EditTextUtils.a(editText)) {
            int d8 = MaterialColors.d(this.f14424i, R$attr.f12482l);
            int i8 = this.R;
            if (i8 == 2) {
                return J(getContext(), this.I, d8, E0);
            }
            if (i8 == 1) {
                return G(this.I, this.f14413a0, d8, E0);
            }
            return null;
        }
        return this.I;
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.K == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.K = stateListDrawable;
            stateListDrawable.addState(new int[]{16842922}, getOrCreateOutlinedDropDownMenuBackground());
            this.K.addState(new int[0], F(false));
        }
        return this.K;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.J == null) {
            this.J = F(true);
        }
        return this.J;
    }

    private void i() {
        TextView textView = this.f14456y;
        if (textView != null) {
            this.f14418f.addView(textView);
            this.f14456y.setVisibility(0);
        }
    }

    private static void i0(@NonNull Context context, @NonNull TextView textView, int i8, int i9, boolean z7) {
        int i10;
        if (z7) {
            i10 = R$string.character_counter_overflowed_content_description;
        } else {
            i10 = R$string.character_counter_content_description;
        }
        textView.setContentDescription(context.getString(i10, Integer.valueOf(i8), Integer.valueOf(i9)));
    }

    private void j() {
        if (this.f14424i != null && this.R == 1) {
            if (MaterialResources.j(getContext())) {
                EditText editText = this.f14424i;
                ViewCompat.H0(editText, ViewCompat.J(editText), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_2_0_padding_top), ViewCompat.I(this.f14424i), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_2_0_padding_bottom));
            } else if (MaterialResources.i(getContext())) {
                EditText editText2 = this.f14424i;
                ViewCompat.H0(editText2, ViewCompat.J(editText2), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_1_3_padding_top), ViewCompat.I(this.f14424i), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_1_3_padding_bottom));
            }
        }
    }

    private void j0() {
        int i8;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.f14446t;
        if (textView != null) {
            if (this.f14442r) {
                i8 = this.f14448u;
            } else {
                i8 = this.f14450v;
            }
            Z(textView, i8);
            if (!this.f14442r && (colorStateList2 = this.D) != null) {
                this.f14446t.setTextColor(colorStateList2);
            }
            if (this.f14442r && (colorStateList = this.E) != null) {
                this.f14446t.setTextColor(colorStateList);
            }
        }
    }

    @TargetApi(29)
    private void k0(boolean z7) {
        Drawable textCursorDrawable;
        Drawable textCursorDrawable2;
        ColorStateList g8 = MaterialColors.g(getContext(), R$attr.f12481k);
        EditText editText = this.f14424i;
        if (editText != null) {
            textCursorDrawable = editText.getTextCursorDrawable();
            if (textCursorDrawable != null && g8 != null) {
                textCursorDrawable2 = this.f14424i.getTextCursorDrawable();
                if (z7) {
                    ColorStateList colorStateList = this.f14441q0;
                    if (colorStateList == null) {
                        colorStateList = ColorStateList.valueOf(this.W);
                    }
                    g8 = colorStateList;
                }
                DrawableCompat.o(textCursorDrawable2, g8);
            }
        }
    }

    private void l() {
        MaterialShapeDrawable materialShapeDrawable = this.I;
        if (materialShapeDrawable == null) {
            return;
        }
        ShapeAppearanceModel F = materialShapeDrawable.F();
        ShapeAppearanceModel shapeAppearanceModel = this.O;
        if (F != shapeAppearanceModel) {
            this.I.setShapeAppearanceModel(shapeAppearanceModel);
        }
        if (v()) {
            this.I.k0(this.T, this.W);
        }
        int p8 = p();
        this.f14413a0 = p8;
        this.I.c0(ColorStateList.valueOf(p8));
        m();
        n0();
    }

    private void m() {
        ColorStateList valueOf;
        if (this.M != null && this.N != null) {
            if (w()) {
                MaterialShapeDrawable materialShapeDrawable = this.M;
                if (this.f14424i.isFocused()) {
                    valueOf = ColorStateList.valueOf(this.f14435n0);
                } else {
                    valueOf = ColorStateList.valueOf(this.W);
                }
                materialShapeDrawable.c0(valueOf);
                this.N.c0(ColorStateList.valueOf(this.W));
            }
            invalidate();
        }
    }

    private void n(@NonNull RectF rectF) {
        float f8 = rectF.left;
        int i8 = this.Q;
        rectF.left = f8 - i8;
        rectF.right += i8;
    }

    private void o() {
        int i8 = this.R;
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 == 2) {
                    if (this.F && !(this.I instanceof CutoutDrawable)) {
                        this.I = CutoutDrawable.r0(this.O);
                    } else {
                        this.I = new MaterialShapeDrawable(this.O);
                    }
                    this.M = null;
                    this.N = null;
                    return;
                }
                throw new IllegalArgumentException(this.R + " is illegal; only @BoxBackgroundMode constants are supported.");
            }
            this.I = new MaterialShapeDrawable(this.O);
            this.M = new MaterialShapeDrawable();
            this.N = new MaterialShapeDrawable();
            return;
        }
        this.I = null;
        this.M = null;
        this.N = null;
    }

    private boolean o0() {
        int max;
        if (this.f14424i == null || this.f14424i.getMeasuredHeight() >= (max = Math.max(this.f14422h.getMeasuredHeight(), this.f14420g.getMeasuredHeight()))) {
            return false;
        }
        this.f14424i.setMinimumHeight(max);
        return true;
    }

    private int p() {
        int i8 = this.f14413a0;
        if (this.R == 1) {
            return MaterialColors.i(MaterialColors.e(this, R$attr.colorSurface, 0), this.f14413a0);
        }
        return i8;
    }

    private void p0() {
        if (this.R != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f14418f.getLayoutParams();
            int u7 = u();
            if (u7 != layoutParams.topMargin) {
                layoutParams.topMargin = u7;
                this.f14418f.requestLayout();
            }
        }
    }

    @NonNull
    private Rect q(@NonNull Rect rect) {
        if (this.f14424i != null) {
            Rect rect2 = this.f14415c0;
            boolean f8 = ViewUtils.f(this);
            rect2.bottom = rect.bottom;
            int i8 = this.R;
            if (i8 != 1) {
                if (i8 != 2) {
                    rect2.left = H(rect.left, f8);
                    rect2.top = getPaddingTop();
                    rect2.right = I(rect.right, f8);
                    return rect2;
                }
                rect2.left = rect.left + this.f14424i.getPaddingLeft();
                rect2.top = rect.top - u();
                rect2.right = rect.right - this.f14424i.getPaddingRight();
                return rect2;
            }
            rect2.left = H(rect.left, f8);
            rect2.top = rect.top + this.S;
            rect2.right = I(rect.right, f8);
            return rect2;
        }
        throw new IllegalStateException();
    }

    private int r(@NonNull Rect rect, @NonNull Rect rect2, float f8) {
        if (Q()) {
            return (int) (rect2.top + f8);
        }
        return rect.bottom - this.f14424i.getCompoundPaddingBottom();
    }

    private void r0(boolean z7, boolean z8) {
        boolean z9;
        boolean z10;
        ColorStateList colorStateList;
        TextView textView;
        int i8;
        boolean isEnabled = isEnabled();
        EditText editText = this.f14424i;
        if (editText != null && !TextUtils.isEmpty(editText.getText())) {
            z9 = true;
        } else {
            z9 = false;
        }
        EditText editText2 = this.f14424i;
        if (editText2 != null && editText2.hasFocus()) {
            z10 = true;
        } else {
            z10 = false;
        }
        ColorStateList colorStateList2 = this.f14431l0;
        if (colorStateList2 != null) {
            this.f14455x0.d0(colorStateList2);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.f14431l0;
            if (colorStateList3 != null) {
                i8 = colorStateList3.getColorForState(new int[]{-16842910}, this.f14451v0);
            } else {
                i8 = this.f14451v0;
            }
            this.f14455x0.d0(ColorStateList.valueOf(i8));
        } else if (a0()) {
            this.f14455x0.d0(this.f14436o.r());
        } else if (this.f14442r && (textView = this.f14446t) != null) {
            this.f14455x0.d0(textView.getTextColors());
        } else if (z10 && (colorStateList = this.f14433m0) != null) {
            this.f14455x0.i0(colorStateList);
        }
        if (!z9 && this.f14457y0 && (!isEnabled() || !z10)) {
            if (z8 || !this.f14453w0) {
                E(z7);
            }
        } else if (z8 || this.f14453w0) {
            y(z7);
        }
    }

    private int s(@NonNull Rect rect, float f8) {
        if (Q()) {
            return (int) (rect.centerY() - (f8 / 2.0f));
        }
        return rect.top + this.f14424i.getCompoundPaddingTop();
    }

    private void s0() {
        EditText editText;
        if (this.f14456y != null && (editText = this.f14424i) != null) {
            this.f14456y.setGravity(editText.getGravity());
            this.f14456y.setPadding(this.f14424i.getCompoundPaddingLeft(), this.f14424i.getCompoundPaddingTop(), this.f14424i.getCompoundPaddingRight(), this.f14424i.getCompoundPaddingBottom());
        }
    }

    private void setEditText(EditText editText) {
        if (this.f14424i == null) {
            if (getEndIconMode() != 3 && !(editText instanceof TextInputEditText)) {
                Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
            }
            this.f14424i = editText;
            int i8 = this.f14428k;
            if (i8 != -1) {
                setMinEms(i8);
            } else {
                setMinWidth(this.f14432m);
            }
            int i9 = this.f14430l;
            if (i9 != -1) {
                setMaxEms(i9);
            } else {
                setMaxWidth(this.f14434n);
            }
            this.L = false;
            S();
            setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
            this.f14455x0.N0(this.f14424i.getTypeface());
            this.f14455x0.v0(this.f14424i.getTextSize());
            this.f14455x0.q0(this.f14424i.getLetterSpacing());
            int gravity = this.f14424i.getGravity();
            this.f14455x0.j0((gravity & (-113)) | 48);
            this.f14455x0.u0(gravity);
            this.f14424i.addTextChangedListener(new TextWatcher() { // from class: com.google.android.material.textfield.TextInputLayout.1
                @Override // android.text.TextWatcher
                public void afterTextChanged(@NonNull Editable editable) {
                    TextInputLayout textInputLayout = TextInputLayout.this;
                    textInputLayout.q0(!textInputLayout.C0);
                    TextInputLayout textInputLayout2 = TextInputLayout.this;
                    if (textInputLayout2.f14438p) {
                        textInputLayout2.h0(editable);
                    }
                    if (TextInputLayout.this.f14454x) {
                        TextInputLayout.this.u0(editable);
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
                }
            });
            if (this.f14431l0 == null) {
                this.f14431l0 = this.f14424i.getHintTextColors();
            }
            if (this.F) {
                if (TextUtils.isEmpty(this.G)) {
                    CharSequence hint = this.f14424i.getHint();
                    this.f14426j = hint;
                    setHint(hint);
                    this.f14424i.setHint((CharSequence) null);
                }
                this.H = true;
            }
            if (this.f14446t != null) {
                h0(this.f14424i.getText());
            }
            m0();
            this.f14436o.f();
            this.f14420g.bringToFront();
            this.f14422h.bringToFront();
            B();
            this.f14422h.w0();
            if (!isEnabled()) {
                editText.setEnabled(false);
            }
            r0(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.G)) {
            this.G = charSequence;
            this.f14455x0.K0(charSequence);
            if (!this.f14453w0) {
                T();
            }
        }
    }

    private void setPlaceholderTextEnabled(boolean z7) {
        if (this.f14454x == z7) {
            return;
        }
        if (z7) {
            i();
        } else {
            X();
            this.f14456y = null;
        }
        this.f14454x = z7;
    }

    @NonNull
    private Rect t(@NonNull Rect rect) {
        if (this.f14424i != null) {
            Rect rect2 = this.f14415c0;
            float C = this.f14455x0.C();
            rect2.left = rect.left + this.f14424i.getCompoundPaddingLeft();
            rect2.top = s(rect, C);
            rect2.right = rect.right - this.f14424i.getCompoundPaddingRight();
            rect2.bottom = r(rect, rect2, C);
            return rect2;
        }
        throw new IllegalStateException();
    }

    private void t0() {
        Editable text;
        EditText editText = this.f14424i;
        if (editText == null) {
            text = null;
        } else {
            text = editText.getText();
        }
        u0(text);
    }

    private int u() {
        float r7;
        if (!this.F) {
            return 0;
        }
        int i8 = this.R;
        if (i8 != 0) {
            if (i8 != 2) {
                return 0;
            }
            r7 = this.f14455x0.r() / 2.0f;
        } else {
            r7 = this.f14455x0.r();
        }
        return (int) r7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(Editable editable) {
        if (this.f14444s.a(editable) == 0 && !this.f14453w0) {
            d0();
        } else {
            K();
        }
    }

    private boolean v() {
        if (this.R == 2 && w()) {
            return true;
        }
        return false;
    }

    private void v0(boolean z7, boolean z8) {
        int defaultColor = this.f14441q0.getDefaultColor();
        int colorForState = this.f14441q0.getColorForState(new int[]{16843623, 16842910}, defaultColor);
        int colorForState2 = this.f14441q0.getColorForState(new int[]{16843518, 16842910}, defaultColor);
        if (z7) {
            this.W = colorForState2;
        } else if (z8) {
            this.W = colorForState;
        } else {
            this.W = defaultColor;
        }
    }

    private boolean w() {
        if (this.T > -1 && this.W != 0) {
            return true;
        }
        return false;
    }

    private void x() {
        if (A()) {
            ((CutoutDrawable) this.I).t0();
        }
    }

    private void y(boolean z7) {
        ValueAnimator valueAnimator = this.A0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.A0.cancel();
        }
        if (z7 && this.f14459z0) {
            k(1.0f);
        } else {
            this.f14455x0.y0(1.0f);
        }
        this.f14453w0 = false;
        if (A()) {
            T();
        }
        t0();
        this.f14420g.k(false);
        this.f14422h.G(false);
    }

    private Fade z() {
        Fade fade = new Fade();
        fade.c0(MotionUtils.f(getContext(), R$attr.motionDurationShort2, 87));
        fade.e0(MotionUtils.g(getContext(), R$attr.motionEasingLinearInterpolator, AnimationUtils.f12720a));
        return fade;
    }

    public boolean L() {
        return this.f14422h.E();
    }

    public boolean M() {
        return this.f14436o.A();
    }

    public boolean N() {
        return this.f14436o.B();
    }

    final boolean O() {
        return this.f14453w0;
    }

    public boolean P() {
        return this.H;
    }

    public void W() {
        this.f14420g.l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
        if (r3.getTextColors().getDefaultColor() == (-65281)) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void Z(@androidx.annotation.NonNull android.widget.TextView r3, int r4) {
        /*
            r2 = this;
            r0 = 1
            androidx.core.widget.TextViewCompat.o(r3, r4)     // Catch: java.lang.Exception -> L1b
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L1b
            r1 = 23
            if (r4 < r1) goto L18
            android.content.res.ColorStateList r4 = r3.getTextColors()     // Catch: java.lang.Exception -> L1b
            int r4 = r4.getDefaultColor()     // Catch: java.lang.Exception -> L1b
            r1 = -65281(0xffffffffffff00ff, float:NaN)
            if (r4 != r1) goto L18
            goto L1c
        L18:
            r4 = 0
            r0 = 0
            goto L1c
        L1b:
        L1c:
            if (r0 == 0) goto L30
            int r4 = com.google.android.material.R$style.f12493b
            androidx.core.widget.TextViewCompat.o(r3, r4)
            android.content.Context r4 = r2.getContext()
            int r0 = com.google.android.material.R$color.design_error
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r0)
            r3.setTextColor(r4)
        L30:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.Z(android.widget.TextView, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a0() {
        return this.f14436o.l();
    }

    @Override // android.view.ViewGroup
    public void addView(@NonNull View view, int i8, @NonNull ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
            this.f14418f.addView(view, layoutParams2);
            this.f14418f.setLayoutParams(layoutParams);
            p0();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i8, layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(26)
    public void dispatchProvideAutofillStructure(@NonNull ViewStructure viewStructure, int i8) {
        EditText editText = this.f14424i;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i8);
            return;
        }
        if (this.f14426j != null) {
            boolean z7 = this.H;
            this.H = false;
            CharSequence hint = editText.getHint();
            this.f14424i.setHint(this.f14426j);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i8);
                return;
            } finally {
                this.f14424i.setHint(hint);
                this.H = z7;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i8);
        onProvideAutofillVirtualStructure(viewStructure, i8);
        viewStructure.setChildCount(this.f14418f.getChildCount());
        for (int i9 = 0; i9 < this.f14418f.getChildCount(); i9++) {
            View childAt = this.f14418f.getChildAt(i9);
            ViewStructure newChild = viewStructure.newChild(i9);
            childAt.dispatchProvideAutofillStructure(newChild, i8);
            if (childAt == this.f14424i) {
                newChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(@NonNull SparseArray<Parcelable> sparseArray) {
        this.C0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.C0 = false;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        D(canvas);
        C(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        boolean z7;
        if (this.B0) {
            return;
        }
        boolean z8 = true;
        this.B0 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        CollapsingTextHelper collapsingTextHelper = this.f14455x0;
        if (collapsingTextHelper != null) {
            z7 = collapsingTextHelper.I0(drawableState) | false;
        } else {
            z7 = false;
        }
        if (this.f14424i != null) {
            q0((ViewCompat.W(this) && isEnabled()) ? false : false);
        }
        m0();
        w0();
        if (z7) {
            invalidate();
        }
        this.B0 = false;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f14424i;
        if (editText != null) {
            return editText.getBaseline() + getPaddingTop() + u();
        }
        return super.getBaseline();
    }

    @NonNull
    MaterialShapeDrawable getBoxBackground() {
        int i8 = this.R;
        if (i8 != 1 && i8 != 2) {
            throw new IllegalStateException();
        }
        return this.I;
    }

    public int getBoxBackgroundColor() {
        return this.f14413a0;
    }

    public int getBoxBackgroundMode() {
        return this.R;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.S;
    }

    public float getBoxCornerRadiusBottomEnd() {
        if (ViewUtils.f(this)) {
            return this.O.j().a(this.f14416d0);
        }
        return this.O.l().a(this.f14416d0);
    }

    public float getBoxCornerRadiusBottomStart() {
        if (ViewUtils.f(this)) {
            return this.O.l().a(this.f14416d0);
        }
        return this.O.j().a(this.f14416d0);
    }

    public float getBoxCornerRadiusTopEnd() {
        if (ViewUtils.f(this)) {
            return this.O.r().a(this.f14416d0);
        }
        return this.O.t().a(this.f14416d0);
    }

    public float getBoxCornerRadiusTopStart() {
        if (ViewUtils.f(this)) {
            return this.O.t().a(this.f14416d0);
        }
        return this.O.r().a(this.f14416d0);
    }

    public int getBoxStrokeColor() {
        return this.f14439p0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.f14441q0;
    }

    public int getBoxStrokeWidth() {
        return this.U;
    }

    public int getBoxStrokeWidthFocused() {
        return this.V;
    }

    public int getCounterMaxLength() {
        return this.f14440q;
    }

    CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.f14438p && this.f14442r && (textView = this.f14446t) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.E;
    }

    public ColorStateList getCounterTextColor() {
        return this.D;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.f14431l0;
    }

    public EditText getEditText() {
        return this.f14424i;
    }

    public CharSequence getEndIconContentDescription() {
        return this.f14422h.l();
    }

    public Drawable getEndIconDrawable() {
        return this.f14422h.n();
    }

    public int getEndIconMinSize() {
        return this.f14422h.o();
    }

    public int getEndIconMode() {
        return this.f14422h.p();
    }

    @NonNull
    public ImageView.ScaleType getEndIconScaleType() {
        return this.f14422h.q();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public CheckableImageButton getEndIconView() {
        return this.f14422h.r();
    }

    public CharSequence getError() {
        if (this.f14436o.A()) {
            return this.f14436o.p();
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.f14436o.n();
    }

    public CharSequence getErrorContentDescription() {
        return this.f14436o.o();
    }

    public int getErrorCurrentTextColors() {
        return this.f14436o.q();
    }

    public Drawable getErrorIconDrawable() {
        return this.f14422h.s();
    }

    public CharSequence getHelperText() {
        if (this.f14436o.B()) {
            return this.f14436o.s();
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.f14436o.u();
    }

    public CharSequence getHint() {
        if (this.F) {
            return this.G;
        }
        return null;
    }

    final float getHintCollapsedTextHeight() {
        return this.f14455x0.r();
    }

    final int getHintCurrentCollapsedTextColor() {
        return this.f14455x0.w();
    }

    public ColorStateList getHintTextColor() {
        return this.f14433m0;
    }

    @NonNull
    public LengthCounter getLengthCounter() {
        return this.f14444s;
    }

    public int getMaxEms() {
        return this.f14430l;
    }

    public int getMaxWidth() {
        return this.f14434n;
    }

    public int getMinEms() {
        return this.f14428k;
    }

    public int getMinWidth() {
        return this.f14432m;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f14422h.u();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f14422h.v();
    }

    public CharSequence getPlaceholderText() {
        if (this.f14454x) {
            return this.f14452w;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.A;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.f14458z;
    }

    public CharSequence getPrefixText() {
        return this.f14420g.a();
    }

    public ColorStateList getPrefixTextColor() {
        return this.f14420g.b();
    }

    @NonNull
    public TextView getPrefixTextView() {
        return this.f14420g.c();
    }

    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.O;
    }

    public CharSequence getStartIconContentDescription() {
        return this.f14420g.d();
    }

    public Drawable getStartIconDrawable() {
        return this.f14420g.e();
    }

    public int getStartIconMinSize() {
        return this.f14420g.f();
    }

    @NonNull
    public ImageView.ScaleType getStartIconScaleType() {
        return this.f14420g.g();
    }

    public CharSequence getSuffixText() {
        return this.f14422h.w();
    }

    public ColorStateList getSuffixTextColor() {
        return this.f14422h.x();
    }

    @NonNull
    public TextView getSuffixTextView() {
        return this.f14422h.y();
    }

    public Typeface getTypeface() {
        return this.f14417e0;
    }

    public void h(@NonNull OnEditTextAttachedListener onEditTextAttachedListener) {
        this.f14423h0.add(onEditTextAttachedListener);
        if (this.f14424i != null) {
            onEditTextAttachedListener.a(this);
        }
    }

    void h0(Editable editable) {
        boolean z7;
        int a8 = this.f14444s.a(editable);
        boolean z8 = this.f14442r;
        int i8 = this.f14440q;
        if (i8 == -1) {
            this.f14446t.setText(String.valueOf(a8));
            this.f14446t.setContentDescription(null);
            this.f14442r = false;
        } else {
            if (a8 > i8) {
                z7 = true;
            } else {
                z7 = false;
            }
            this.f14442r = z7;
            i0(getContext(), this.f14446t, a8, this.f14440q, this.f14442r);
            if (z8 != this.f14442r) {
                j0();
            }
            this.f14446t.setText(BidiFormatter.c().j(getContext().getString(R$string.character_counter_pattern, Integer.valueOf(a8), Integer.valueOf(this.f14440q))));
        }
        if (this.f14424i != null && z8 != this.f14442r) {
            q0(false);
            w0();
            m0();
        }
    }

    void k(float f8) {
        if (this.f14455x0.F() == f8) {
            return;
        }
        if (this.A0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.A0 = valueAnimator;
            valueAnimator.setInterpolator(MotionUtils.g(getContext(), R$attr.motionEasingEmphasizedInterpolator, AnimationUtils.f12721b));
            this.A0.setDuration(MotionUtils.f(getContext(), R$attr.motionDurationMedium4, 167));
            this.A0.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.TextInputLayout.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator2) {
                    TextInputLayout.this.f14455x0.y0(((Float) valueAnimator2.getAnimatedValue()).floatValue());
                }
            });
        }
        this.A0.setFloatValues(this.f14455x0.F(), f8);
        this.A0.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l0() {
        boolean z7;
        if (this.f14424i == null) {
            return false;
        }
        boolean z8 = true;
        if (c0()) {
            int measuredWidth = this.f14420g.getMeasuredWidth() - this.f14424i.getPaddingLeft();
            if (this.f14419f0 == null || this.f14421g0 != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.f14419f0 = colorDrawable;
                this.f14421g0 = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] a8 = TextViewCompat.a(this.f14424i);
            Drawable drawable = a8[0];
            Drawable drawable2 = this.f14419f0;
            if (drawable != drawable2) {
                TextViewCompat.j(this.f14424i, drawable2, a8[1], a8[2], a8[3]);
                z7 = true;
            }
            z7 = false;
        } else {
            if (this.f14419f0 != null) {
                Drawable[] a9 = TextViewCompat.a(this.f14424i);
                TextViewCompat.j(this.f14424i, null, a9[1], a9[2], a9[3]);
                this.f14419f0 = null;
                z7 = true;
            }
            z7 = false;
        }
        if (b0()) {
            int measuredWidth2 = this.f14422h.y().getMeasuredWidth() - this.f14424i.getPaddingRight();
            CheckableImageButton k8 = this.f14422h.k();
            if (k8 != null) {
                measuredWidth2 = measuredWidth2 + k8.getMeasuredWidth() + MarginLayoutParamsCompat.b((ViewGroup.MarginLayoutParams) k8.getLayoutParams());
            }
            Drawable[] a10 = TextViewCompat.a(this.f14424i);
            Drawable drawable3 = this.f14425i0;
            if (drawable3 != null && this.f14427j0 != measuredWidth2) {
                this.f14427j0 = measuredWidth2;
                drawable3.setBounds(0, 0, measuredWidth2, 1);
                TextViewCompat.j(this.f14424i, a10[0], a10[1], this.f14425i0, a10[3]);
            } else {
                if (drawable3 == null) {
                    ColorDrawable colorDrawable2 = new ColorDrawable();
                    this.f14425i0 = colorDrawable2;
                    this.f14427j0 = measuredWidth2;
                    colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                }
                Drawable drawable4 = a10[2];
                Drawable drawable5 = this.f14425i0;
                if (drawable4 != drawable5) {
                    this.f14429k0 = drawable4;
                    TextViewCompat.j(this.f14424i, a10[0], a10[1], drawable5, a10[3]);
                } else {
                    z8 = z7;
                }
            }
        } else if (this.f14425i0 != null) {
            Drawable[] a11 = TextViewCompat.a(this.f14424i);
            if (a11[2] == this.f14425i0) {
                TextViewCompat.j(this.f14424i, a11[0], a11[1], this.f14429k0, a11[3]);
            } else {
                z8 = z7;
            }
            this.f14425i0 = null;
        } else {
            return z7;
        }
        return z8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m0() {
        Drawable background;
        TextView textView;
        EditText editText = this.f14424i;
        if (editText == null || this.R != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (DrawableUtils.a(background)) {
            background = background.mutate();
        }
        if (a0()) {
            background.setColorFilter(AppCompatDrawableManager.e(getErrorCurrentTextColors(), PorterDuff.Mode.SRC_IN));
        } else if (this.f14442r && (textView = this.f14446t) != null) {
            background.setColorFilter(AppCompatDrawableManager.e(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            DrawableCompat.c(background);
            this.f14424i.refreshDrawableState();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n0() {
        EditText editText = this.f14424i;
        if (editText != null && this.I != null) {
            if ((this.L || editText.getBackground() == null) && this.R != 0) {
                ViewCompat.w0(this.f14424i, getEditTextBoxBackground());
                this.L = true;
            }
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f14455x0.Y(configuration);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        super.onLayout(z7, i8, i9, i10, i11);
        EditText editText = this.f14424i;
        if (editText != null) {
            Rect rect = this.f14414b0;
            DescendantOffsetUtils.a(this, editText, rect);
            f0(rect);
            if (this.F) {
                this.f14455x0.v0(this.f14424i.getTextSize());
                int gravity = this.f14424i.getGravity();
                this.f14455x0.j0((gravity & (-113)) | 48);
                this.f14455x0.u0(gravity);
                this.f14455x0.f0(q(rect));
                this.f14455x0.p0(t(rect));
                this.f14455x0.a0();
                if (A() && !this.f14453w0) {
                    T();
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        boolean o02 = o0();
        boolean l02 = l0();
        if (o02 || l02) {
            this.f14424i.post(new Runnable() { // from class: com.google.android.material.textfield.TextInputLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    TextInputLayout.this.f14424i.requestLayout();
                }
            });
        }
        s0();
        this.f14422h.w0();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        setError(savedState.f14465h);
        if (savedState.f14466i) {
            post(new Runnable() { // from class: com.google.android.material.textfield.TextInputLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    TextInputLayout.this.f14422h.h();
                }
            });
        }
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onRtlPropertiesChanged(int i8) {
        super.onRtlPropertiesChanged(i8);
        boolean z7 = true;
        if (i8 != 1) {
            z7 = false;
        }
        if (z7 != this.P) {
            float a8 = this.O.r().a(this.f14416d0);
            float a9 = this.O.t().a(this.f14416d0);
            float a10 = this.O.j().a(this.f14416d0);
            float a11 = this.O.l().a(this.f14416d0);
            CornerTreatment q8 = this.O.q();
            CornerTreatment s7 = this.O.s();
            ShapeAppearanceModel m8 = ShapeAppearanceModel.a().z(s7).D(q8).r(this.O.k()).v(this.O.i()).A(a9).E(a8).s(a11).w(a10).m();
            this.P = z7;
            setShapeAppearanceModel(m8);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (a0()) {
            savedState.f14465h = getError();
        }
        savedState.f14466i = this.f14422h.D();
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q0(boolean z7) {
        r0(z7, false);
    }

    public void setBoxBackgroundColor(int i8) {
        if (this.f14413a0 != i8) {
            this.f14413a0 = i8;
            this.f14443r0 = i8;
            this.f14447t0 = i8;
            this.f14449u0 = i8;
            l();
        }
    }

    public void setBoxBackgroundColorResource(int i8) {
        setBoxBackgroundColor(ContextCompat.getColor(getContext(), i8));
    }

    public void setBoxBackgroundColorStateList(@NonNull ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.f14443r0 = defaultColor;
        this.f14413a0 = defaultColor;
        this.f14445s0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.f14447t0 = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.f14449u0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        l();
    }

    public void setBoxBackgroundMode(int i8) {
        if (i8 == this.R) {
            return;
        }
        this.R = i8;
        if (this.f14424i != null) {
            S();
        }
    }

    public void setBoxCollapsedPaddingTop(int i8) {
        this.S = i8;
    }

    public void setBoxCornerFamily(int i8) {
        this.O = this.O.v().y(i8, this.O.r()).C(i8, this.O.t()).q(i8, this.O.j()).u(i8, this.O.l()).m();
        l();
    }

    public void setBoxStrokeColor(int i8) {
        if (this.f14439p0 != i8) {
            this.f14439p0 = i8;
            w0();
        }
    }

    public void setBoxStrokeColorStateList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.f14435n0 = colorStateList.getDefaultColor();
            this.f14451v0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.f14437o0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
            this.f14439p0 = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        } else if (this.f14439p0 != colorStateList.getDefaultColor()) {
            this.f14439p0 = colorStateList.getDefaultColor();
        }
        w0();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.f14441q0 != colorStateList) {
            this.f14441q0 = colorStateList;
            w0();
        }
    }

    public void setBoxStrokeWidth(int i8) {
        this.U = i8;
        w0();
    }

    public void setBoxStrokeWidthFocused(int i8) {
        this.V = i8;
        w0();
    }

    public void setBoxStrokeWidthFocusedResource(int i8) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i8));
    }

    public void setBoxStrokeWidthResource(int i8) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i8));
    }

    public void setCounterEnabled(boolean z7) {
        if (this.f14438p != z7) {
            if (z7) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.f14446t = appCompatTextView;
                appCompatTextView.setId(R$id.textinput_counter);
                Typeface typeface = this.f14417e0;
                if (typeface != null) {
                    this.f14446t.setTypeface(typeface);
                }
                this.f14446t.setMaxLines(1);
                this.f14436o.e(this.f14446t, 2);
                MarginLayoutParamsCompat.d((ViewGroup.MarginLayoutParams) this.f14446t.getLayoutParams(), getResources().getDimensionPixelOffset(R$dimen.mtrl_textinput_counter_margin_start));
                j0();
                g0();
            } else {
                this.f14436o.C(this.f14446t, 2);
                this.f14446t = null;
            }
            this.f14438p = z7;
        }
    }

    public void setCounterMaxLength(int i8) {
        if (this.f14440q != i8) {
            if (i8 > 0) {
                this.f14440q = i8;
            } else {
                this.f14440q = -1;
            }
            if (this.f14438p) {
                g0();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i8) {
        if (this.f14448u != i8) {
            this.f14448u = i8;
            j0();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.E != colorStateList) {
            this.E = colorStateList;
            j0();
        }
    }

    public void setCounterTextAppearance(int i8) {
        if (this.f14450v != i8) {
            this.f14450v = i8;
            j0();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.D != colorStateList) {
            this.D = colorStateList;
            j0();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.f14431l0 = colorStateList;
        this.f14433m0 = colorStateList;
        if (this.f14424i != null) {
            q0(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z7) {
        V(this, z7);
        super.setEnabled(z7);
    }

    public void setEndIconActivated(boolean z7) {
        this.f14422h.M(z7);
    }

    public void setEndIconCheckable(boolean z7) {
        this.f14422h.N(z7);
    }

    public void setEndIconContentDescription(int i8) {
        this.f14422h.O(i8);
    }

    public void setEndIconDrawable(int i8) {
        this.f14422h.Q(i8);
    }

    public void setEndIconMinSize(int i8) {
        this.f14422h.S(i8);
    }

    public void setEndIconMode(int i8) {
        this.f14422h.T(i8);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        this.f14422h.U(onClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f14422h.V(onLongClickListener);
    }

    public void setEndIconScaleType(@NonNull ImageView.ScaleType scaleType) {
        this.f14422h.W(scaleType);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        this.f14422h.X(colorStateList);
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        this.f14422h.Y(mode);
    }

    public void setEndIconVisible(boolean z7) {
        this.f14422h.Z(z7);
    }

    public void setError(CharSequence charSequence) {
        if (!this.f14436o.A()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            setErrorEnabled(true);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.f14436o.Q(charSequence);
        } else {
            this.f14436o.w();
        }
    }

    public void setErrorAccessibilityLiveRegion(int i8) {
        this.f14436o.E(i8);
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        this.f14436o.F(charSequence);
    }

    public void setErrorEnabled(boolean z7) {
        this.f14436o.G(z7);
    }

    public void setErrorIconDrawable(int i8) {
        this.f14422h.a0(i8);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        this.f14422h.c0(onClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f14422h.d0(onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        this.f14422h.e0(colorStateList);
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        this.f14422h.f0(mode);
    }

    public void setErrorTextAppearance(int i8) {
        this.f14436o.H(i8);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.f14436o.I(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z7) {
        if (this.f14457y0 != z7) {
            this.f14457y0 = z7;
            q0(false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (N()) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!N()) {
            setHelperTextEnabled(true);
        }
        this.f14436o.R(charSequence);
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.f14436o.L(colorStateList);
    }

    public void setHelperTextEnabled(boolean z7) {
        this.f14436o.K(z7);
    }

    public void setHelperTextTextAppearance(int i8) {
        this.f14436o.J(i8);
    }

    public void setHint(CharSequence charSequence) {
        if (this.F) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z7) {
        this.f14459z0 = z7;
    }

    public void setHintEnabled(boolean z7) {
        if (z7 != this.F) {
            this.F = z7;
            if (!z7) {
                this.H = false;
                if (!TextUtils.isEmpty(this.G) && TextUtils.isEmpty(this.f14424i.getHint())) {
                    this.f14424i.setHint(this.G);
                }
                setHintInternal(null);
            } else {
                CharSequence hint = this.f14424i.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.G)) {
                        setHint(hint);
                    }
                    this.f14424i.setHint((CharSequence) null);
                }
                this.H = true;
            }
            if (this.f14424i != null) {
                p0();
            }
        }
    }

    public void setHintTextAppearance(int i8) {
        this.f14455x0.g0(i8);
        this.f14433m0 = this.f14455x0.p();
        if (this.f14424i != null) {
            q0(false);
            p0();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.f14433m0 != colorStateList) {
            if (this.f14431l0 == null) {
                this.f14455x0.i0(colorStateList);
            }
            this.f14433m0 = colorStateList;
            if (this.f14424i != null) {
                q0(false);
            }
        }
    }

    public void setLengthCounter(@NonNull LengthCounter lengthCounter) {
        this.f14444s = lengthCounter;
    }

    public void setMaxEms(int i8) {
        this.f14430l = i8;
        EditText editText = this.f14424i;
        if (editText != null && i8 != -1) {
            editText.setMaxEms(i8);
        }
    }

    public void setMaxWidth(int i8) {
        this.f14434n = i8;
        EditText editText = this.f14424i;
        if (editText != null && i8 != -1) {
            editText.setMaxWidth(i8);
        }
    }

    public void setMaxWidthResource(int i8) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i8));
    }

    public void setMinEms(int i8) {
        this.f14428k = i8;
        EditText editText = this.f14424i;
        if (editText != null && i8 != -1) {
            editText.setMinEms(i8);
        }
    }

    public void setMinWidth(int i8) {
        this.f14432m = i8;
        EditText editText = this.f14424i;
        if (editText != null && i8 != -1) {
            editText.setMinWidth(i8);
        }
    }

    public void setMinWidthResource(int i8) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i8));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i8) {
        this.f14422h.h0(i8);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i8) {
        this.f14422h.j0(i8);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z7) {
        this.f14422h.l0(z7);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.f14422h.m0(colorStateList);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.f14422h.n0(mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.f14456y == null) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.f14456y = appCompatTextView;
            appCompatTextView.setId(R$id.textinput_placeholder);
            ViewCompat.D0(this.f14456y, 2);
            Fade z7 = z();
            this.B = z7;
            z7.h0(67L);
            this.C = z();
            setPlaceholderTextAppearance(this.A);
            setPlaceholderTextColor(this.f14458z);
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.f14454x) {
                setPlaceholderTextEnabled(true);
            }
            this.f14452w = charSequence;
        }
        t0();
    }

    public void setPlaceholderTextAppearance(int i8) {
        this.A = i8;
        TextView textView = this.f14456y;
        if (textView != null) {
            TextViewCompat.o(textView, i8);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.f14458z != colorStateList) {
            this.f14458z = colorStateList;
            TextView textView = this.f14456y;
            if (textView != null && colorStateList != null) {
                textView.setTextColor(colorStateList);
            }
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        this.f14420g.m(charSequence);
    }

    public void setPrefixTextAppearance(int i8) {
        this.f14420g.n(i8);
    }

    public void setPrefixTextColor(@NonNull ColorStateList colorStateList) {
        this.f14420g.o(colorStateList);
    }

    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        MaterialShapeDrawable materialShapeDrawable = this.I;
        if (materialShapeDrawable != null && materialShapeDrawable.F() != shapeAppearanceModel) {
            this.O = shapeAppearanceModel;
            l();
        }
    }

    public void setStartIconCheckable(boolean z7) {
        this.f14420g.p(z7);
    }

    public void setStartIconContentDescription(int i8) {
        setStartIconContentDescription(i8 != 0 ? getResources().getText(i8) : null);
    }

    public void setStartIconDrawable(int i8) {
        setStartIconDrawable(i8 != 0 ? AppCompatResources.b(getContext(), i8) : null);
    }

    public void setStartIconMinSize(int i8) {
        this.f14420g.s(i8);
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        this.f14420g.t(onClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f14420g.u(onLongClickListener);
    }

    public void setStartIconScaleType(@NonNull ImageView.ScaleType scaleType) {
        this.f14420g.v(scaleType);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        this.f14420g.w(colorStateList);
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        this.f14420g.x(mode);
    }

    public void setStartIconVisible(boolean z7) {
        this.f14420g.y(z7);
    }

    public void setSuffixText(CharSequence charSequence) {
        this.f14422h.o0(charSequence);
    }

    public void setSuffixTextAppearance(int i8) {
        this.f14422h.p0(i8);
    }

    public void setSuffixTextColor(@NonNull ColorStateList colorStateList) {
        this.f14422h.q0(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(AccessibilityDelegate accessibilityDelegate) {
        EditText editText = this.f14424i;
        if (editText != null) {
            ViewCompat.s0(editText, accessibilityDelegate);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.f14417e0) {
            this.f14417e0 = typeface;
            this.f14455x0.N0(typeface);
            this.f14436o.N(typeface);
            TextView textView = this.f14446t;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w0() {
        boolean z7;
        boolean z8;
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.I != null && this.R != 0) {
            boolean z9 = false;
            if (!isFocused() && ((editText2 = this.f14424i) == null || !editText2.hasFocus())) {
                z7 = false;
            } else {
                z7 = true;
            }
            if (!isHovered() && ((editText = this.f14424i) == null || !editText.isHovered())) {
                z8 = false;
            } else {
                z8 = true;
            }
            if (a0() || (this.f14446t != null && this.f14442r)) {
                z9 = true;
            }
            if (!isEnabled()) {
                this.W = this.f14451v0;
            } else if (a0()) {
                if (this.f14441q0 != null) {
                    v0(z7, z8);
                } else {
                    this.W = getErrorCurrentTextColors();
                }
            } else if (this.f14442r && (textView = this.f14446t) != null) {
                if (this.f14441q0 != null) {
                    v0(z7, z8);
                } else {
                    this.W = textView.getCurrentTextColor();
                }
            } else if (z7) {
                this.W = this.f14439p0;
            } else if (z8) {
                this.W = this.f14437o0;
            } else {
                this.W = this.f14435n0;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                k0(z9);
            }
            this.f14422h.H();
            W();
            if (this.R == 2) {
                int i8 = this.T;
                if (z7 && isEnabled()) {
                    this.T = this.V;
                } else {
                    this.T = this.U;
                }
                if (this.T != i8) {
                    U();
                }
            }
            if (this.R == 1) {
                if (!isEnabled()) {
                    this.f14413a0 = this.f14445s0;
                } else if (z8 && !z7) {
                    this.f14413a0 = this.f14449u0;
                } else if (z7) {
                    this.f14413a0 = this.f14447t0;
                } else {
                    this.f14413a0 = this.f14443r0;
                }
            }
            l();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v45 */
    /* JADX WARN: Type inference failed for: r3v46, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r3v66 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TextInputLayout(@androidx.annotation.NonNull android.content.Context r21, android.util.AttributeSet r22, int r23) {
        /*
            Method dump skipped, instructions count: 884
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        this.f14422h.P(charSequence);
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.f14422h.R(drawable);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.f14422h.b0(drawable);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f14422h.i0(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f14422h.k0(drawable);
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        this.f14420g.q(charSequence);
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.f14420g.r(drawable);
    }

    public void setHint(int i8) {
        setHint(i8 != 0 ? getResources().getText(i8) : null);
    }
}
