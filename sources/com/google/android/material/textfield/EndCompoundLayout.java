package com.google.android.material.textfield;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public class EndCompoundLayout extends LinearLayout {
    private final TextWatcher A;
    private final TextInputLayout.OnEditTextAttachedListener B;

    /* renamed from: f  reason: collision with root package name */
    final TextInputLayout f14323f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final FrameLayout f14324g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final CheckableImageButton f14325h;

    /* renamed from: i  reason: collision with root package name */
    private ColorStateList f14326i;

    /* renamed from: j  reason: collision with root package name */
    private PorterDuff.Mode f14327j;

    /* renamed from: k  reason: collision with root package name */
    private View.OnLongClickListener f14328k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final CheckableImageButton f14329l;

    /* renamed from: m  reason: collision with root package name */
    private final EndIconDelegates f14330m;

    /* renamed from: n  reason: collision with root package name */
    private int f14331n;

    /* renamed from: o  reason: collision with root package name */
    private final LinkedHashSet<TextInputLayout.OnEndIconChangedListener> f14332o;

    /* renamed from: p  reason: collision with root package name */
    private ColorStateList f14333p;

    /* renamed from: q  reason: collision with root package name */
    private PorterDuff.Mode f14334q;

    /* renamed from: r  reason: collision with root package name */
    private int f14335r;
    @NonNull

    /* renamed from: s  reason: collision with root package name */
    private ImageView.ScaleType f14336s;

    /* renamed from: t  reason: collision with root package name */
    private View.OnLongClickListener f14337t;

    /* renamed from: u  reason: collision with root package name */
    private CharSequence f14338u;
    @NonNull

    /* renamed from: v  reason: collision with root package name */
    private final TextView f14339v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f14340w;

    /* renamed from: x  reason: collision with root package name */
    private EditText f14341x;

    /* renamed from: y  reason: collision with root package name */
    private final AccessibilityManager f14342y;

    /* renamed from: z  reason: collision with root package name */
    private AccessibilityManagerCompat.TouchExplorationStateChangeListener f14343z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class EndIconDelegates {

        /* renamed from: a  reason: collision with root package name */
        private final SparseArray<EndIconDelegate> f14347a = new SparseArray<>();

        /* renamed from: b  reason: collision with root package name */
        private final EndCompoundLayout f14348b;

        /* renamed from: c  reason: collision with root package name */
        private final int f14349c;

        /* renamed from: d  reason: collision with root package name */
        private final int f14350d;

        EndIconDelegates(EndCompoundLayout endCompoundLayout, TintTypedArray tintTypedArray) {
            this.f14348b = endCompoundLayout;
            this.f14349c = tintTypedArray.n(R$styleable.e8, 0);
            this.f14350d = tintTypedArray.n(R$styleable.C8, 0);
        }

        private EndIconDelegate b(int i8) {
            if (i8 != -1) {
                if (i8 != 0) {
                    if (i8 != 1) {
                        if (i8 != 2) {
                            if (i8 == 3) {
                                return new DropdownMenuEndIconDelegate(this.f14348b);
                            }
                            throw new IllegalArgumentException("Invalid end icon mode: " + i8);
                        }
                        return new ClearTextEndIconDelegate(this.f14348b);
                    }
                    return new PasswordToggleEndIconDelegate(this.f14348b, this.f14350d);
                }
                return new NoEndIconDelegate(this.f14348b);
            }
            return new CustomEndIconDelegate(this.f14348b);
        }

        EndIconDelegate c(int i8) {
            EndIconDelegate endIconDelegate = this.f14347a.get(i8);
            if (endIconDelegate == null) {
                EndIconDelegate b8 = b(i8);
                this.f14347a.append(i8, b8);
                return b8;
            }
            return endIconDelegate;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EndCompoundLayout(TextInputLayout textInputLayout, TintTypedArray tintTypedArray) {
        super(textInputLayout.getContext());
        this.f14331n = 0;
        this.f14332o = new LinkedHashSet<>();
        this.A = new TextWatcherAdapter() { // from class: com.google.android.material.textfield.EndCompoundLayout.1
            @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                EndCompoundLayout.this.m().a(editable);
            }

            @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
                EndCompoundLayout.this.m().b(charSequence, i8, i9, i10);
            }
        };
        TextInputLayout.OnEditTextAttachedListener onEditTextAttachedListener = new TextInputLayout.OnEditTextAttachedListener() { // from class: com.google.android.material.textfield.EndCompoundLayout.2
            @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
            public void a(@NonNull TextInputLayout textInputLayout2) {
                if (EndCompoundLayout.this.f14341x == textInputLayout2.getEditText()) {
                    return;
                }
                if (EndCompoundLayout.this.f14341x != null) {
                    EndCompoundLayout.this.f14341x.removeTextChangedListener(EndCompoundLayout.this.A);
                    if (EndCompoundLayout.this.f14341x.getOnFocusChangeListener() == EndCompoundLayout.this.m().e()) {
                        EndCompoundLayout.this.f14341x.setOnFocusChangeListener(null);
                    }
                }
                EndCompoundLayout.this.f14341x = textInputLayout2.getEditText();
                if (EndCompoundLayout.this.f14341x != null) {
                    EndCompoundLayout.this.f14341x.addTextChangedListener(EndCompoundLayout.this.A);
                }
                EndCompoundLayout.this.m().n(EndCompoundLayout.this.f14341x);
                EndCompoundLayout endCompoundLayout = EndCompoundLayout.this;
                endCompoundLayout.g0(endCompoundLayout.m());
            }
        };
        this.B = onEditTextAttachedListener;
        this.f14342y = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f14323f = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f14324g = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater from = LayoutInflater.from(getContext());
        CheckableImageButton i8 = i(this, from, R$id.text_input_error_icon);
        this.f14325h = i8;
        CheckableImageButton i9 = i(frameLayout, from, R$id.text_input_end_icon);
        this.f14329l = i9;
        this.f14330m = new EndIconDelegates(this, tintTypedArray);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.f14339v = appCompatTextView;
        B(tintTypedArray);
        A(tintTypedArray);
        C(tintTypedArray);
        frameLayout.addView(i9);
        addView(appCompatTextView);
        addView(frameLayout);
        addView(i8);
        textInputLayout.h(onEditTextAttachedListener);
        addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.google.android.material.textfield.EndCompoundLayout.3
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                EndCompoundLayout.this.g();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                EndCompoundLayout.this.L();
            }
        });
    }

    private void A(TintTypedArray tintTypedArray) {
        int i8 = R$styleable.D8;
        if (!tintTypedArray.s(i8)) {
            int i9 = R$styleable.i8;
            if (tintTypedArray.s(i9)) {
                this.f14333p = MaterialResources.b(getContext(), tintTypedArray, i9);
            }
            int i10 = R$styleable.j8;
            if (tintTypedArray.s(i10)) {
                this.f14334q = ViewUtils.g(tintTypedArray.k(i10, -1), null);
            }
        }
        int i11 = R$styleable.g8;
        if (tintTypedArray.s(i11)) {
            T(tintTypedArray.k(i11, 0));
            int i12 = R$styleable.d8;
            if (tintTypedArray.s(i12)) {
                P(tintTypedArray.p(i12));
            }
            N(tintTypedArray.a(R$styleable.c8, true));
        } else if (tintTypedArray.s(i8)) {
            int i13 = R$styleable.E8;
            if (tintTypedArray.s(i13)) {
                this.f14333p = MaterialResources.b(getContext(), tintTypedArray, i13);
            }
            int i14 = R$styleable.F8;
            if (tintTypedArray.s(i14)) {
                this.f14334q = ViewUtils.g(tintTypedArray.k(i14, -1), null);
            }
            T(tintTypedArray.a(i8, false) ? 1 : 0);
            P(tintTypedArray.p(R$styleable.B8));
        }
        S(tintTypedArray.f(R$styleable.f8, getResources().getDimensionPixelSize(R$dimen.mtrl_min_touch_target_size)));
        int i15 = R$styleable.h8;
        if (tintTypedArray.s(i15)) {
            W(IconHelper.b(tintTypedArray.k(i15, -1)));
        }
    }

    private void B(TintTypedArray tintTypedArray) {
        int i8 = R$styleable.o8;
        if (tintTypedArray.s(i8)) {
            this.f14326i = MaterialResources.b(getContext(), tintTypedArray, i8);
        }
        int i9 = R$styleable.p8;
        if (tintTypedArray.s(i9)) {
            this.f14327j = ViewUtils.g(tintTypedArray.k(i9, -1), null);
        }
        int i10 = R$styleable.n8;
        if (tintTypedArray.s(i10)) {
            b0(tintTypedArray.g(i10));
        }
        this.f14325h.setContentDescription(getResources().getText(R$string.error_icon_content_description));
        ViewCompat.D0(this.f14325h, 2);
        this.f14325h.setClickable(false);
        this.f14325h.setPressable(false);
        this.f14325h.setFocusable(false);
    }

    private void C(TintTypedArray tintTypedArray) {
        this.f14339v.setVisibility(8);
        this.f14339v.setId(R$id.textinput_suffix_text);
        this.f14339v.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        ViewCompat.u0(this.f14339v, 1);
        p0(tintTypedArray.n(R$styleable.U8, 0));
        int i8 = R$styleable.V8;
        if (tintTypedArray.s(i8)) {
            q0(tintTypedArray.c(i8));
        }
        o0(tintTypedArray.p(R$styleable.T8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        AccessibilityManager accessibilityManager;
        AccessibilityManagerCompat.TouchExplorationStateChangeListener touchExplorationStateChangeListener = this.f14343z;
        if (touchExplorationStateChangeListener != null && (accessibilityManager = this.f14342y) != null) {
            AccessibilityManagerCompat.b(accessibilityManager, touchExplorationStateChangeListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f14343z != null && this.f14342y != null && ViewCompat.V(this)) {
            AccessibilityManagerCompat.a(this.f14342y, this.f14343z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0(EndIconDelegate endIconDelegate) {
        if (this.f14341x == null) {
            return;
        }
        if (endIconDelegate.e() != null) {
            this.f14341x.setOnFocusChangeListener(endIconDelegate.e());
        }
        if (endIconDelegate.g() != null) {
            this.f14329l.setOnFocusChangeListener(endIconDelegate.g());
        }
    }

    private CheckableImageButton i(ViewGroup viewGroup, LayoutInflater layoutInflater, int i8) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(R$layout.design_text_input_end_icon, viewGroup, false);
        checkableImageButton.setId(i8);
        IconHelper.e(checkableImageButton);
        if (MaterialResources.i(getContext())) {
            MarginLayoutParamsCompat.d((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), 0);
        }
        return checkableImageButton;
    }

    private void j(int i8) {
        Iterator<TextInputLayout.OnEndIconChangedListener> it = this.f14332o.iterator();
        while (it.hasNext()) {
            it.next().a(this.f14323f, i8);
        }
    }

    private void r0(@NonNull EndIconDelegate endIconDelegate) {
        endIconDelegate.s();
        this.f14343z = endIconDelegate.h();
        g();
    }

    private void s0(@NonNull EndIconDelegate endIconDelegate) {
        L();
        this.f14343z = null;
        endIconDelegate.u();
    }

    private int t(EndIconDelegate endIconDelegate) {
        int i8 = this.f14330m.f14349c;
        if (i8 == 0) {
            return endIconDelegate.d();
        }
        return i8;
    }

    private void t0(boolean z7) {
        if (z7 && n() != null) {
            Drawable mutate = DrawableCompat.r(n()).mutate();
            DrawableCompat.n(mutate, this.f14323f.getErrorCurrentTextColors());
            this.f14329l.setImageDrawable(mutate);
            return;
        }
        IconHelper.a(this.f14323f, this.f14329l, this.f14333p, this.f14334q);
    }

    private void u0() {
        int i8;
        char c8;
        boolean z7;
        FrameLayout frameLayout = this.f14324g;
        int i9 = 8;
        if (this.f14329l.getVisibility() == 0 && !F()) {
            i8 = 0;
        } else {
            i8 = 8;
        }
        frameLayout.setVisibility(i8);
        if (this.f14338u != null && !this.f14340w) {
            c8 = 0;
        } else {
            c8 = '\b';
        }
        if (!E() && !F() && c8 != 0) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (z7) {
            i9 = 0;
        }
        setVisibility(i9);
    }

    private void v0() {
        boolean z7;
        int i8 = 0;
        if (s() != null && this.f14323f.M() && this.f14323f.a0()) {
            z7 = true;
        } else {
            z7 = false;
        }
        CheckableImageButton checkableImageButton = this.f14325h;
        if (!z7) {
            i8 = 8;
        }
        checkableImageButton.setVisibility(i8);
        u0();
        w0();
        if (!z()) {
            this.f14323f.l0();
        }
    }

    private void x0() {
        int i8;
        int visibility = this.f14339v.getVisibility();
        boolean z7 = false;
        if (this.f14338u != null && !this.f14340w) {
            i8 = 0;
        } else {
            i8 = 8;
        }
        if (visibility != i8) {
            EndIconDelegate m8 = m();
            if (i8 == 0) {
                z7 = true;
            }
            m8.q(z7);
        }
        u0();
        this.f14339v.setVisibility(i8);
        this.f14323f.l0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean D() {
        if (z() && this.f14329l.isChecked()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean E() {
        if (this.f14324g.getVisibility() == 0 && this.f14329l.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean F() {
        if (this.f14325h.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(boolean z7) {
        this.f14340w = z7;
        x0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H() {
        v0();
        J();
        I();
        if (m().t()) {
            t0(this.f14323f.a0());
        }
    }

    void I() {
        IconHelper.d(this.f14323f, this.f14329l, this.f14333p);
    }

    void J() {
        IconHelper.d(this.f14323f, this.f14325h, this.f14326i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(boolean z7) {
        boolean z8;
        boolean isActivated;
        boolean isChecked;
        EndIconDelegate m8 = m();
        boolean z9 = true;
        if (m8.l() && (isChecked = this.f14329l.isChecked()) != m8.m()) {
            this.f14329l.setChecked(!isChecked);
            z8 = true;
        } else {
            z8 = false;
        }
        if (m8.j() && (isActivated = this.f14329l.isActivated()) != m8.k()) {
            M(!isActivated);
        } else {
            z9 = z8;
        }
        if (z7 || z9) {
            I();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(boolean z7) {
        this.f14329l.setActivated(z7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N(boolean z7) {
        this.f14329l.setCheckable(z7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O(int i8) {
        CharSequence charSequence;
        if (i8 != 0) {
            charSequence = getResources().getText(i8);
        } else {
            charSequence = null;
        }
        P(charSequence);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P(CharSequence charSequence) {
        if (l() != charSequence) {
            this.f14329l.setContentDescription(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q(int i8) {
        Drawable drawable;
        if (i8 != 0) {
            drawable = AppCompatResources.b(getContext(), i8);
        } else {
            drawable = null;
        }
        R(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(Drawable drawable) {
        this.f14329l.setImageDrawable(drawable);
        if (drawable != null) {
            IconHelper.a(this.f14323f, this.f14329l, this.f14333p, this.f14334q);
            I();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S(int i8) {
        if (i8 >= 0) {
            if (i8 != this.f14335r) {
                this.f14335r = i8;
                IconHelper.g(this.f14329l, i8);
                IconHelper.g(this.f14325h, i8);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("endIconSize cannot be less than 0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(int i8) {
        boolean z7;
        if (this.f14331n == i8) {
            return;
        }
        s0(m());
        int i9 = this.f14331n;
        this.f14331n = i8;
        j(i9);
        if (i8 != 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        Z(z7);
        EndIconDelegate m8 = m();
        Q(t(m8));
        O(m8.c());
        N(m8.l());
        if (m8.i(this.f14323f.getBoxBackgroundMode())) {
            r0(m8);
            U(m8.f());
            EditText editText = this.f14341x;
            if (editText != null) {
                m8.n(editText);
                g0(m8);
            }
            IconHelper.a(this.f14323f, this.f14329l, this.f14333p, this.f14334q);
            K(true);
            return;
        }
        throw new IllegalStateException("The current box background mode " + this.f14323f.getBoxBackgroundMode() + " is not supported by the end icon mode " + i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U(View.OnClickListener onClickListener) {
        IconHelper.h(this.f14329l, onClickListener, this.f14337t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V(View.OnLongClickListener onLongClickListener) {
        this.f14337t = onLongClickListener;
        IconHelper.i(this.f14329l, onLongClickListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W(@NonNull ImageView.ScaleType scaleType) {
        this.f14336s = scaleType;
        IconHelper.j(this.f14329l, scaleType);
        IconHelper.j(this.f14325h, scaleType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X(ColorStateList colorStateList) {
        if (this.f14333p != colorStateList) {
            this.f14333p = colorStateList;
            IconHelper.a(this.f14323f, this.f14329l, colorStateList, this.f14334q);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y(PorterDuff.Mode mode) {
        if (this.f14334q != mode) {
            this.f14334q = mode;
            IconHelper.a(this.f14323f, this.f14329l, this.f14333p, mode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z(boolean z7) {
        int i8;
        if (E() != z7) {
            CheckableImageButton checkableImageButton = this.f14329l;
            if (z7) {
                i8 = 0;
            } else {
                i8 = 8;
            }
            checkableImageButton.setVisibility(i8);
            u0();
            w0();
            this.f14323f.l0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a0(int i8) {
        Drawable drawable;
        if (i8 != 0) {
            drawable = AppCompatResources.b(getContext(), i8);
        } else {
            drawable = null;
        }
        b0(drawable);
        J();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b0(Drawable drawable) {
        this.f14325h.setImageDrawable(drawable);
        v0();
        IconHelper.a(this.f14323f, this.f14325h, this.f14326i, this.f14327j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c0(View.OnClickListener onClickListener) {
        IconHelper.h(this.f14325h, onClickListener, this.f14328k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d0(View.OnLongClickListener onLongClickListener) {
        this.f14328k = onLongClickListener;
        IconHelper.i(this.f14325h, onLongClickListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e0(ColorStateList colorStateList) {
        if (this.f14326i != colorStateList) {
            this.f14326i = colorStateList;
            IconHelper.a(this.f14323f, this.f14325h, colorStateList, this.f14327j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f0(PorterDuff.Mode mode) {
        if (this.f14327j != mode) {
            this.f14327j = mode;
            IconHelper.a(this.f14323f, this.f14325h, this.f14326i, mode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        this.f14329l.performClick();
        this.f14329l.jumpDrawablesToCurrentState();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h0(int i8) {
        CharSequence charSequence;
        if (i8 != 0) {
            charSequence = getResources().getText(i8);
        } else {
            charSequence = null;
        }
        i0(charSequence);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i0(CharSequence charSequence) {
        this.f14329l.setContentDescription(charSequence);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j0(int i8) {
        Drawable drawable;
        if (i8 != 0) {
            drawable = AppCompatResources.b(getContext(), i8);
        } else {
            drawable = null;
        }
        k0(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CheckableImageButton k() {
        if (F()) {
            return this.f14325h;
        }
        if (z() && E()) {
            return this.f14329l;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k0(Drawable drawable) {
        this.f14329l.setImageDrawable(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence l() {
        return this.f14329l.getContentDescription();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l0(boolean z7) {
        if (z7 && this.f14331n != 1) {
            T(1);
        } else if (!z7) {
            T(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EndIconDelegate m() {
        return this.f14330m.c(this.f14331n);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m0(ColorStateList colorStateList) {
        this.f14333p = colorStateList;
        IconHelper.a(this.f14323f, this.f14329l, colorStateList, this.f14334q);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable n() {
        return this.f14329l.getDrawable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n0(PorterDuff.Mode mode) {
        this.f14334q = mode;
        IconHelper.a(this.f14323f, this.f14329l, this.f14333p, mode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int o() {
        return this.f14335r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o0(CharSequence charSequence) {
        CharSequence charSequence2;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        this.f14338u = charSequence2;
        this.f14339v.setText(charSequence);
        x0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int p() {
        return this.f14331n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p0(int i8) {
        TextViewCompat.o(this.f14339v, i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public ImageView.ScaleType q() {
        return this.f14336s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q0(@NonNull ColorStateList colorStateList) {
        this.f14339v.setTextColor(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CheckableImageButton r() {
        return this.f14329l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable s() {
        return this.f14325h.getDrawable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence u() {
        return this.f14329l.getContentDescription();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable v() {
        return this.f14329l.getDrawable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence w() {
        return this.f14338u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w0() {
        int i8;
        if (this.f14323f.f14424i == null) {
            return;
        }
        if (!E() && !F()) {
            i8 = ViewCompat.I(this.f14323f.f14424i);
        } else {
            i8 = 0;
        }
        ViewCompat.H0(this.f14339v, getContext().getResources().getDimensionPixelSize(R$dimen.material_input_text_to_prefix_suffix_padding), this.f14323f.f14424i.getPaddingTop(), i8, this.f14323f.f14424i.getPaddingBottom());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList x() {
        return this.f14339v.getTextColors();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextView y() {
        return this.f14339v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean z() {
        if (this.f14331n != 0) {
            return true;
        }
        return false;
    }
}
