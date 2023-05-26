package com.google.android.material.textfield;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public class StartCompoundLayout extends LinearLayout {

    /* renamed from: f  reason: collision with root package name */
    private final TextInputLayout f14401f;

    /* renamed from: g  reason: collision with root package name */
    private final TextView f14402g;

    /* renamed from: h  reason: collision with root package name */
    private CharSequence f14403h;

    /* renamed from: i  reason: collision with root package name */
    private final CheckableImageButton f14404i;

    /* renamed from: j  reason: collision with root package name */
    private ColorStateList f14405j;

    /* renamed from: k  reason: collision with root package name */
    private PorterDuff.Mode f14406k;

    /* renamed from: l  reason: collision with root package name */
    private int f14407l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    private ImageView.ScaleType f14408m;

    /* renamed from: n  reason: collision with root package name */
    private View.OnLongClickListener f14409n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f14410o;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StartCompoundLayout(TextInputLayout textInputLayout, TintTypedArray tintTypedArray) {
        super(textInputLayout.getContext());
        this.f14401f = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R$layout.design_text_input_start_icon, (ViewGroup) this, false);
        this.f14404i = checkableImageButton;
        IconHelper.e(checkableImageButton);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.f14402g = appCompatTextView;
        i(tintTypedArray);
        h(tintTypedArray);
        addView(checkableImageButton);
        addView(appCompatTextView);
    }

    private void B() {
        int i8;
        boolean z7;
        int i9 = 8;
        if (this.f14403h != null && !this.f14410o) {
            i8 = 0;
        } else {
            i8 = 8;
        }
        if (this.f14404i.getVisibility() != 0 && i8 != 0) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (z7) {
            i9 = 0;
        }
        setVisibility(i9);
        this.f14402g.setVisibility(i8);
        this.f14401f.l0();
    }

    private void h(TintTypedArray tintTypedArray) {
        this.f14402g.setVisibility(8);
        this.f14402g.setId(R$id.textinput_prefix_text);
        this.f14402g.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        ViewCompat.u0(this.f14402g, 1);
        n(tintTypedArray.n(R$styleable.K8, 0));
        int i8 = R$styleable.L8;
        if (tintTypedArray.s(i8)) {
            o(tintTypedArray.c(i8));
        }
        m(tintTypedArray.p(R$styleable.J8));
    }

    private void i(TintTypedArray tintTypedArray) {
        if (MaterialResources.i(getContext())) {
            MarginLayoutParamsCompat.c((ViewGroup.MarginLayoutParams) this.f14404i.getLayoutParams(), 0);
        }
        t(null);
        u(null);
        int i8 = R$styleable.R8;
        if (tintTypedArray.s(i8)) {
            this.f14405j = MaterialResources.b(getContext(), tintTypedArray, i8);
        }
        int i9 = R$styleable.S8;
        if (tintTypedArray.s(i9)) {
            this.f14406k = ViewUtils.g(tintTypedArray.k(i9, -1), null);
        }
        int i10 = R$styleable.O8;
        if (tintTypedArray.s(i10)) {
            r(tintTypedArray.g(i10));
            int i11 = R$styleable.N8;
            if (tintTypedArray.s(i11)) {
                q(tintTypedArray.p(i11));
            }
            p(tintTypedArray.a(R$styleable.M8, true));
        }
        s(tintTypedArray.f(R$styleable.P8, getResources().getDimensionPixelSize(R$dimen.mtrl_min_touch_target_size)));
        int i12 = R$styleable.Q8;
        if (tintTypedArray.s(i12)) {
            v(IconHelper.b(tintTypedArray.k(i12, -1)));
        }
    }

    void A() {
        int J;
        EditText editText = this.f14401f.f14424i;
        if (editText == null) {
            return;
        }
        if (j()) {
            J = 0;
        } else {
            J = ViewCompat.J(editText);
        }
        ViewCompat.H0(this.f14402g, J, editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R$dimen.material_input_text_to_prefix_suffix_padding), editText.getCompoundPaddingBottom());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence a() {
        return this.f14403h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList b() {
        return this.f14402g.getTextColors();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public TextView c() {
        return this.f14402g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence d() {
        return this.f14404i.getContentDescription();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable e() {
        return this.f14404i.getDrawable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f14407l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public ImageView.ScaleType g() {
        return this.f14408m;
    }

    boolean j() {
        if (this.f14404i.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(boolean z7) {
        this.f14410o = z7;
        B();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l() {
        IconHelper.d(this.f14401f, this.f14404i, this.f14405j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(CharSequence charSequence) {
        CharSequence charSequence2;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        this.f14403h = charSequence2;
        this.f14402g.setText(charSequence);
        B();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(int i8) {
        TextViewCompat.o(this.f14402g, i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(@NonNull ColorStateList colorStateList) {
        this.f14402g.setTextColor(colorStateList);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        A();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(boolean z7) {
        this.f14404i.setCheckable(z7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(CharSequence charSequence) {
        if (d() != charSequence) {
            this.f14404i.setContentDescription(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(Drawable drawable) {
        this.f14404i.setImageDrawable(drawable);
        if (drawable != null) {
            IconHelper.a(this.f14401f, this.f14404i, this.f14405j, this.f14406k);
            y(true);
            l();
            return;
        }
        y(false);
        t(null);
        u(null);
        q(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(int i8) {
        if (i8 >= 0) {
            if (i8 != this.f14407l) {
                this.f14407l = i8;
                IconHelper.g(this.f14404i, i8);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("startIconSize cannot be less than 0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(View.OnClickListener onClickListener) {
        IconHelper.h(this.f14404i, onClickListener, this.f14409n);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(View.OnLongClickListener onLongClickListener) {
        this.f14409n = onLongClickListener;
        IconHelper.i(this.f14404i, onLongClickListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(@NonNull ImageView.ScaleType scaleType) {
        this.f14408m = scaleType;
        IconHelper.j(this.f14404i, scaleType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(ColorStateList colorStateList) {
        if (this.f14405j != colorStateList) {
            this.f14405j = colorStateList;
            IconHelper.a(this.f14401f, this.f14404i, colorStateList, this.f14406k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(PorterDuff.Mode mode) {
        if (this.f14406k != mode) {
            this.f14406k = mode;
            IconHelper.a(this.f14401f, this.f14404i, this.f14405j, mode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(boolean z7) {
        int i8;
        if (j() != z7) {
            CheckableImageButton checkableImageButton = this.f14404i;
            if (z7) {
                i8 = 0;
            } else {
                i8 = 8;
            }
            checkableImageButton.setVisibility(i8);
            A();
            B();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (this.f14402g.getVisibility() == 0) {
            accessibilityNodeInfoCompat.k0(this.f14402g);
            accessibilityNodeInfoCompat.x0(this.f14402g);
            return;
        }
        accessibilityNodeInfoCompat.x0(this.f14404i);
    }
}
