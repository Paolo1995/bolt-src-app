package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class IndicatorViewController {
    private ColorStateList A;
    private Typeface B;

    /* renamed from: a  reason: collision with root package name */
    private final int f14355a;

    /* renamed from: b  reason: collision with root package name */
    private final int f14356b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14357c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final TimeInterpolator f14358d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final TimeInterpolator f14359e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final TimeInterpolator f14360f;

    /* renamed from: g  reason: collision with root package name */
    private final Context f14361g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final TextInputLayout f14362h;

    /* renamed from: i  reason: collision with root package name */
    private LinearLayout f14363i;

    /* renamed from: j  reason: collision with root package name */
    private int f14364j;

    /* renamed from: k  reason: collision with root package name */
    private FrameLayout f14365k;

    /* renamed from: l  reason: collision with root package name */
    private Animator f14366l;

    /* renamed from: m  reason: collision with root package name */
    private final float f14367m;

    /* renamed from: n  reason: collision with root package name */
    private int f14368n;

    /* renamed from: o  reason: collision with root package name */
    private int f14369o;

    /* renamed from: p  reason: collision with root package name */
    private CharSequence f14370p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f14371q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f14372r;

    /* renamed from: s  reason: collision with root package name */
    private CharSequence f14373s;

    /* renamed from: t  reason: collision with root package name */
    private int f14374t;

    /* renamed from: u  reason: collision with root package name */
    private int f14375u;

    /* renamed from: v  reason: collision with root package name */
    private ColorStateList f14376v;

    /* renamed from: w  reason: collision with root package name */
    private CharSequence f14377w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f14378x;

    /* renamed from: y  reason: collision with root package name */
    private TextView f14379y;

    /* renamed from: z  reason: collision with root package name */
    private int f14380z;

    public IndicatorViewController(@NonNull TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f14361g = context;
        this.f14362h = textInputLayout;
        this.f14367m = context.getResources().getDimensionPixelSize(R$dimen.design_textinput_caption_translate_y);
        int i8 = R$attr.motionDurationShort4;
        this.f14355a = MotionUtils.f(context, i8, 217);
        this.f14356b = MotionUtils.f(context, R$attr.motionDurationMedium4, 167);
        this.f14357c = MotionUtils.f(context, i8, 167);
        int i9 = R$attr.motionEasingEmphasizedDecelerateInterpolator;
        this.f14358d = MotionUtils.g(context, i9, AnimationUtils.f12723d);
        TimeInterpolator timeInterpolator = AnimationUtils.f12720a;
        this.f14359e = MotionUtils.g(context, i9, timeInterpolator);
        this.f14360f = MotionUtils.g(context, R$attr.motionEasingLinearInterpolator, timeInterpolator);
    }

    private void D(int i8, int i9) {
        TextView m8;
        TextView m9;
        if (i8 == i9) {
            return;
        }
        if (i9 != 0 && (m9 = m(i9)) != null) {
            m9.setVisibility(0);
            m9.setAlpha(1.0f);
        }
        if (i8 != 0 && (m8 = m(i8)) != null) {
            m8.setVisibility(4);
            if (i8 == 1) {
                m8.setText((CharSequence) null);
            }
        }
        this.f14368n = i9;
    }

    private void M(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    private void O(@NonNull ViewGroup viewGroup, int i8) {
        if (i8 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    private boolean P(TextView textView, @NonNull CharSequence charSequence) {
        if (ViewCompat.W(this.f14362h) && this.f14362h.isEnabled() && (this.f14369o != this.f14368n || textView == null || !TextUtils.equals(textView.getText(), charSequence))) {
            return true;
        }
        return false;
    }

    private void S(final int i8, final int i9, boolean z7) {
        if (i8 == i9) {
            return;
        }
        if (z7) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f14366l = animatorSet;
            ArrayList arrayList = new ArrayList();
            i(arrayList, this.f14378x, this.f14379y, 2, i8, i9);
            i(arrayList, this.f14371q, this.f14372r, 1, i8, i9);
            AnimatorSetCompat.a(animatorSet, arrayList);
            final TextView m8 = m(i8);
            final TextView m9 = m(i9);
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.textfield.IndicatorViewController.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    IndicatorViewController.this.f14368n = i9;
                    IndicatorViewController.this.f14366l = null;
                    TextView textView = m8;
                    if (textView != null) {
                        textView.setVisibility(4);
                        if (i8 == 1 && IndicatorViewController.this.f14372r != null) {
                            IndicatorViewController.this.f14372r.setText((CharSequence) null);
                        }
                    }
                    TextView textView2 = m9;
                    if (textView2 != null) {
                        textView2.setTranslationY(0.0f);
                        m9.setAlpha(1.0f);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    TextView textView = m9;
                    if (textView != null) {
                        textView.setVisibility(0);
                        m9.setAlpha(0.0f);
                    }
                }
            });
            animatorSet.start();
        } else {
            D(i8, i9);
        }
        this.f14362h.m0();
        this.f14362h.q0(z7);
        this.f14362h.w0();
    }

    private boolean g() {
        if (this.f14363i != null && this.f14362h.getEditText() != null) {
            return true;
        }
        return false;
    }

    private void i(@NonNull List<Animator> list, boolean z7, TextView textView, int i8, int i9, int i10) {
        boolean z8;
        boolean z9;
        if (textView != null && z7) {
            boolean z10 = false;
            if (i8 != i10 && i8 != i9) {
                z8 = false;
            } else {
                z8 = true;
            }
            if (z8) {
                if (i10 == i8) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                ObjectAnimator j8 = j(textView, z9);
                if (i8 == i10 && i9 != 0) {
                    z10 = true;
                }
                if (z10) {
                    j8.setStartDelay(this.f14357c);
                }
                list.add(j8);
                if (i10 == i8 && i9 != 0) {
                    ObjectAnimator k8 = k(textView);
                    k8.setStartDelay(this.f14357c);
                    list.add(k8);
                }
            }
        }
    }

    private ObjectAnimator j(TextView textView, boolean z7) {
        float f8;
        int i8;
        TimeInterpolator timeInterpolator;
        if (z7) {
            f8 = 1.0f;
        } else {
            f8 = 0.0f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, f8);
        if (z7) {
            i8 = this.f14356b;
        } else {
            i8 = this.f14357c;
        }
        ofFloat.setDuration(i8);
        if (z7) {
            timeInterpolator = this.f14359e;
        } else {
            timeInterpolator = this.f14360f;
        }
        ofFloat.setInterpolator(timeInterpolator);
        return ofFloat;
    }

    private ObjectAnimator k(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, -this.f14367m, 0.0f);
        ofFloat.setDuration(this.f14355a);
        ofFloat.setInterpolator(this.f14358d);
        return ofFloat;
    }

    private TextView m(int i8) {
        if (i8 != 1) {
            if (i8 != 2) {
                return null;
            }
            return this.f14379y;
        }
        return this.f14372r;
    }

    private int v(boolean z7, int i8, int i9) {
        if (z7) {
            return this.f14361g.getResources().getDimensionPixelSize(i8);
        }
        return i9;
    }

    private boolean y(int i8) {
        if (i8 == 1 && this.f14372r != null && !TextUtils.isEmpty(this.f14370p)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean A() {
        return this.f14371q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean B() {
        return this.f14378x;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(TextView textView, int i8) {
        FrameLayout frameLayout;
        if (this.f14363i == null) {
            return;
        }
        if (z(i8) && (frameLayout = this.f14365k) != null) {
            frameLayout.removeView(textView);
        } else {
            this.f14363i.removeView(textView);
        }
        int i9 = this.f14364j - 1;
        this.f14364j = i9;
        O(this.f14363i, i9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(int i8) {
        this.f14374t = i8;
        TextView textView = this.f14372r;
        if (textView != null) {
            ViewCompat.u0(textView, i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(CharSequence charSequence) {
        this.f14373s = charSequence;
        TextView textView = this.f14372r;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(boolean z7) {
        if (this.f14371q == z7) {
            return;
        }
        h();
        if (z7) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.f14361g);
            this.f14372r = appCompatTextView;
            appCompatTextView.setId(R$id.textinput_error);
            this.f14372r.setTextAlignment(5);
            Typeface typeface = this.B;
            if (typeface != null) {
                this.f14372r.setTypeface(typeface);
            }
            H(this.f14375u);
            I(this.f14376v);
            F(this.f14373s);
            E(this.f14374t);
            this.f14372r.setVisibility(4);
            e(this.f14372r, 0);
        } else {
            w();
            C(this.f14372r, 0);
            this.f14372r = null;
            this.f14362h.m0();
            this.f14362h.w0();
        }
        this.f14371q = z7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(int i8) {
        this.f14375u = i8;
        TextView textView = this.f14372r;
        if (textView != null) {
            this.f14362h.Z(textView, i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(ColorStateList colorStateList) {
        this.f14376v = colorStateList;
        TextView textView = this.f14372r;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(int i8) {
        this.f14380z = i8;
        TextView textView = this.f14379y;
        if (textView != null) {
            TextViewCompat.o(textView, i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(boolean z7) {
        if (this.f14378x == z7) {
            return;
        }
        h();
        if (z7) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.f14361g);
            this.f14379y = appCompatTextView;
            appCompatTextView.setId(R$id.textinput_helper_text);
            this.f14379y.setTextAlignment(5);
            Typeface typeface = this.B;
            if (typeface != null) {
                this.f14379y.setTypeface(typeface);
            }
            this.f14379y.setVisibility(4);
            ViewCompat.u0(this.f14379y, 1);
            J(this.f14380z);
            L(this.A);
            e(this.f14379y, 1);
            this.f14379y.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: com.google.android.material.textfield.IndicatorViewController.2
                @Override // android.view.View.AccessibilityDelegate
                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                    super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                    EditText editText = IndicatorViewController.this.f14362h.getEditText();
                    if (editText != null) {
                        accessibilityNodeInfo.setLabeledBy(editText);
                    }
                }
            });
        } else {
            x();
            C(this.f14379y, 1);
            this.f14379y = null;
            this.f14362h.m0();
            this.f14362h.w0();
        }
        this.f14378x = z7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(ColorStateList colorStateList) {
        this.A = colorStateList;
        TextView textView = this.f14379y;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N(Typeface typeface) {
        if (typeface != this.B) {
            this.B = typeface;
            M(this.f14372r, typeface);
            M(this.f14379y, typeface);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q(CharSequence charSequence) {
        h();
        this.f14370p = charSequence;
        this.f14372r.setText(charSequence);
        int i8 = this.f14368n;
        if (i8 != 1) {
            this.f14369o = 1;
        }
        S(i8, this.f14369o, P(this.f14372r, charSequence));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(CharSequence charSequence) {
        h();
        this.f14377w = charSequence;
        this.f14379y.setText(charSequence);
        int i8 = this.f14368n;
        if (i8 != 2) {
            this.f14369o = 2;
        }
        S(i8, this.f14369o, P(this.f14379y, charSequence));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(TextView textView, int i8) {
        if (this.f14363i == null && this.f14365k == null) {
            LinearLayout linearLayout = new LinearLayout(this.f14361g);
            this.f14363i = linearLayout;
            linearLayout.setOrientation(0);
            this.f14362h.addView(this.f14363i, -1, -2);
            this.f14365k = new FrameLayout(this.f14361g);
            this.f14363i.addView(this.f14365k, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f14362h.getEditText() != null) {
                f();
            }
        }
        if (z(i8)) {
            this.f14365k.setVisibility(0);
            this.f14365k.addView(textView);
        } else {
            this.f14363i.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f14363i.setVisibility(0);
        this.f14364j++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        if (g()) {
            EditText editText = this.f14362h.getEditText();
            boolean i8 = MaterialResources.i(this.f14361g);
            LinearLayout linearLayout = this.f14363i;
            int i9 = R$dimen.material_helper_text_font_1_3_padding_horizontal;
            ViewCompat.H0(linearLayout, v(i8, i9, ViewCompat.J(editText)), v(i8, R$dimen.material_helper_text_font_1_3_padding_top, this.f14361g.getResources().getDimensionPixelSize(R$dimen.material_helper_text_default_padding_top)), v(i8, i9, ViewCompat.I(editText)), 0);
        }
    }

    void h() {
        Animator animator = this.f14366l;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        return y(this.f14369o);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n() {
        return this.f14374t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence o() {
        return this.f14373s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence p() {
        return this.f14370p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int q() {
        TextView textView = this.f14372r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList r() {
        TextView textView = this.f14372r;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence s() {
        return this.f14377w;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View t() {
        return this.f14379y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int u() {
        TextView textView = this.f14379y;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w() {
        this.f14370p = null;
        h();
        if (this.f14368n == 1) {
            if (this.f14378x && !TextUtils.isEmpty(this.f14377w)) {
                this.f14369o = 2;
            } else {
                this.f14369o = 0;
            }
        }
        S(this.f14368n, this.f14369o, P(this.f14372r, ""));
    }

    void x() {
        h();
        int i8 = this.f14368n;
        if (i8 == 2) {
            this.f14369o = 0;
        }
        S(i8, this.f14369o, P(this.f14379y, ""));
    }

    boolean z(int i8) {
        return i8 == 0 || i8 == 1;
    }
}
