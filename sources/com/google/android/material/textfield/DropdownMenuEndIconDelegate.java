package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.motion.MotionUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class DropdownMenuEndIconDelegate extends EndIconDelegate {

    /* renamed from: s  reason: collision with root package name */
    private static final boolean f14307s = true;

    /* renamed from: e  reason: collision with root package name */
    private final int f14308e;

    /* renamed from: f  reason: collision with root package name */
    private final int f14309f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final TimeInterpolator f14310g;

    /* renamed from: h  reason: collision with root package name */
    private AutoCompleteTextView f14311h;

    /* renamed from: i  reason: collision with root package name */
    private final View.OnClickListener f14312i;

    /* renamed from: j  reason: collision with root package name */
    private final View.OnFocusChangeListener f14313j;

    /* renamed from: k  reason: collision with root package name */
    private final AccessibilityManagerCompat.TouchExplorationStateChangeListener f14314k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f14315l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f14316m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f14317n;

    /* renamed from: o  reason: collision with root package name */
    private long f14318o;

    /* renamed from: p  reason: collision with root package name */
    private AccessibilityManager f14319p;

    /* renamed from: q  reason: collision with root package name */
    private ValueAnimator f14320q;

    /* renamed from: r  reason: collision with root package name */
    private ValueAnimator f14321r;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DropdownMenuEndIconDelegate(@NonNull EndCompoundLayout endCompoundLayout) {
        super(endCompoundLayout);
        this.f14312i = new View.OnClickListener() { // from class: com.google.android.material.textfield.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DropdownMenuEndIconDelegate.this.J(view);
            }
        };
        this.f14313j = new View.OnFocusChangeListener() { // from class: com.google.android.material.textfield.h
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z7) {
                DropdownMenuEndIconDelegate.this.K(view, z7);
            }
        };
        this.f14314k = new AccessibilityManagerCompat.TouchExplorationStateChangeListener() { // from class: com.google.android.material.textfield.i
            @Override // androidx.core.view.accessibility.AccessibilityManagerCompat.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z7) {
                DropdownMenuEndIconDelegate.this.L(z7);
            }
        };
        this.f14318o = Long.MAX_VALUE;
        Context context = endCompoundLayout.getContext();
        int i8 = R$attr.motionDurationShort3;
        this.f14309f = MotionUtils.f(context, i8, 67);
        this.f14308e = MotionUtils.f(endCompoundLayout.getContext(), i8, 50);
        this.f14310g = MotionUtils.g(endCompoundLayout.getContext(), R$attr.motionEasingLinearInterpolator, AnimationUtils.f12720a);
    }

    @NonNull
    private static AutoCompleteTextView D(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private ValueAnimator E(int i8, float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(this.f14310g);
        ofFloat.setDuration(i8);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.j
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DropdownMenuEndIconDelegate.this.I(valueAnimator);
            }
        });
        return ofFloat;
    }

    private void F() {
        this.f14321r = E(this.f14309f, 0.0f, 1.0f);
        ValueAnimator E = E(this.f14308e, 1.0f, 0.0f);
        this.f14320q = E;
        E.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                DropdownMenuEndIconDelegate.this.r();
                DropdownMenuEndIconDelegate.this.f14321r.start();
            }
        });
    }

    private boolean G() {
        long currentTimeMillis = System.currentTimeMillis() - this.f14318o;
        if (currentTimeMillis >= 0 && currentTimeMillis <= 300) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H() {
        boolean isPopupShowing = this.f14311h.isPopupShowing();
        O(isPopupShowing);
        this.f14316m = isPopupShowing;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(ValueAnimator valueAnimator) {
        this.f14354d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(View view) {
        Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(View view, boolean z7) {
        this.f14315l = z7;
        r();
        if (!z7) {
            O(false);
            this.f14316m = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(boolean z7) {
        int i8;
        AutoCompleteTextView autoCompleteTextView = this.f14311h;
        if (autoCompleteTextView != null && !EditTextUtils.a(autoCompleteTextView)) {
            CheckableImageButton checkableImageButton = this.f14354d;
            if (z7) {
                i8 = 2;
            } else {
                i8 = 1;
            }
            ViewCompat.D0(checkableImageButton, i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean M(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (G()) {
                this.f14316m = false;
            }
            Q();
            R();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N() {
        R();
        O(false);
    }

    private void O(boolean z7) {
        if (this.f14317n != z7) {
            this.f14317n = z7;
            this.f14321r.cancel();
            this.f14320q.start();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void P() {
        this.f14311h.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.material.textfield.l
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean M;
                M = DropdownMenuEndIconDelegate.this.M(view, motionEvent);
                return M;
            }
        });
        if (f14307s) {
            this.f14311h.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: com.google.android.material.textfield.m
                @Override // android.widget.AutoCompleteTextView.OnDismissListener
                public final void onDismiss() {
                    DropdownMenuEndIconDelegate.this.N();
                }
            });
        }
        this.f14311h.setThreshold(0);
    }

    private void Q() {
        if (this.f14311h == null) {
            return;
        }
        if (G()) {
            this.f14316m = false;
        }
        if (!this.f14316m) {
            if (f14307s) {
                O(!this.f14317n);
            } else {
                this.f14317n = !this.f14317n;
                r();
            }
            if (this.f14317n) {
                this.f14311h.requestFocus();
                this.f14311h.showDropDown();
                return;
            }
            this.f14311h.dismissDropDown();
            return;
        }
        this.f14316m = false;
    }

    private void R() {
        this.f14316m = true;
        this.f14318o = System.currentTimeMillis();
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void a(Editable editable) {
        if (this.f14319p.isTouchExplorationEnabled() && EditTextUtils.a(this.f14311h) && !this.f14354d.hasFocus()) {
            this.f14311h.dismissDropDown();
        }
        this.f14311h.post(new Runnable() { // from class: com.google.android.material.textfield.k
            @Override // java.lang.Runnable
            public final void run() {
                DropdownMenuEndIconDelegate.this.H();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.EndIconDelegate
    public int c() {
        return R$string.exposed_dropdown_menu_content_description;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.EndIconDelegate
    public int d() {
        if (f14307s) {
            return R$drawable.mtrl_dropdown_arrow;
        }
        return R$drawable.mtrl_ic_arrow_drop_down;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.EndIconDelegate
    public View.OnFocusChangeListener e() {
        return this.f14313j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.EndIconDelegate
    public View.OnClickListener f() {
        return this.f14312i;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public AccessibilityManagerCompat.TouchExplorationStateChangeListener h() {
        return this.f14314k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.EndIconDelegate
    public boolean i(int i8) {
        return i8 != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.EndIconDelegate
    public boolean j() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.EndIconDelegate
    public boolean k() {
        return this.f14315l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.EndIconDelegate
    public boolean l() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.EndIconDelegate
    public boolean m() {
        return this.f14317n;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void n(EditText editText) {
        this.f14311h = D(editText);
        P();
        this.f14351a.setErrorIconDrawable((Drawable) null);
        if (!EditTextUtils.a(editText) && this.f14319p.isTouchExplorationEnabled()) {
            ViewCompat.D0(this.f14354d, 2);
        }
        this.f14351a.setEndIconVisible(true);
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void o(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (!EditTextUtils.a(this.f14311h)) {
            accessibilityNodeInfoCompat.Y(Spinner.class.getName());
        }
        if (accessibilityNodeInfoCompat.K()) {
            accessibilityNodeInfoCompat.j0(null);
        }
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void p(View view, @NonNull AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 1 && this.f14319p.isEnabled() && !EditTextUtils.a(this.f14311h)) {
            Q();
            R();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.EndIconDelegate
    public void s() {
        F();
        this.f14319p = (AccessibilityManager) this.f14353c.getSystemService("accessibility");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.EndIconDelegate
    public boolean t() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.EndIconDelegate
    @SuppressLint({"ClickableViewAccessibility"})
    public void u() {
        AutoCompleteTextView autoCompleteTextView = this.f14311h;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            if (f14307s) {
                this.f14311h.setOnDismissListener(null);
            }
        }
    }
}
