package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import com.google.android.material.R$attr;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.motion.MotionUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ClearTextEndIconDelegate extends EndIconDelegate {

    /* renamed from: e  reason: collision with root package name */
    private final int f14296e;

    /* renamed from: f  reason: collision with root package name */
    private final int f14297f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final TimeInterpolator f14298g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final TimeInterpolator f14299h;

    /* renamed from: i  reason: collision with root package name */
    private EditText f14300i;

    /* renamed from: j  reason: collision with root package name */
    private final View.OnClickListener f14301j;

    /* renamed from: k  reason: collision with root package name */
    private final View.OnFocusChangeListener f14302k;

    /* renamed from: l  reason: collision with root package name */
    private AnimatorSet f14303l;

    /* renamed from: m  reason: collision with root package name */
    private ValueAnimator f14304m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClearTextEndIconDelegate(@NonNull EndCompoundLayout endCompoundLayout) {
        super(endCompoundLayout);
        this.f14301j = new View.OnClickListener() { // from class: com.google.android.material.textfield.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ClearTextEndIconDelegate.this.G(view);
            }
        };
        this.f14302k = new View.OnFocusChangeListener() { // from class: com.google.android.material.textfield.e
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z7) {
                ClearTextEndIconDelegate.this.H(view, z7);
            }
        };
        Context context = endCompoundLayout.getContext();
        int i8 = R$attr.motionDurationShort3;
        this.f14296e = MotionUtils.f(context, i8, 100);
        this.f14297f = MotionUtils.f(endCompoundLayout.getContext(), i8, 150);
        this.f14298g = MotionUtils.g(endCompoundLayout.getContext(), R$attr.motionEasingLinearInterpolator, AnimationUtils.f12720a);
        this.f14299h = MotionUtils.g(endCompoundLayout.getContext(), R$attr.motionEasingEmphasizedInterpolator, AnimationUtils.f12723d);
    }

    private void A(boolean z7) {
        boolean z8;
        if (this.f14352b.E() == z7) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 && !this.f14303l.isRunning()) {
            this.f14304m.cancel();
            this.f14303l.start();
            if (z8) {
                this.f14303l.end();
            }
        } else if (!z7) {
            this.f14303l.cancel();
            this.f14304m.start();
            if (z8) {
                this.f14304m.end();
            }
        }
    }

    private ValueAnimator B(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(this.f14298g);
        ofFloat.setDuration(this.f14296e);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ClearTextEndIconDelegate.this.E(valueAnimator);
            }
        });
        return ofFloat;
    }

    private ValueAnimator C() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(this.f14299h);
        ofFloat.setDuration(this.f14297f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ClearTextEndIconDelegate.this.F(valueAnimator);
            }
        });
        return ofFloat;
    }

    private void D() {
        ValueAnimator C = C();
        ValueAnimator B = B(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f14303l = animatorSet;
        animatorSet.playTogether(C, B);
        this.f14303l.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ClearTextEndIconDelegate.this.f14352b.Z(true);
            }
        });
        ValueAnimator B2 = B(1.0f, 0.0f);
        this.f14304m = B2;
        B2.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ClearTextEndIconDelegate.this.f14352b.Z(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(ValueAnimator valueAnimator) {
        this.f14354d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f14354d.setScaleX(floatValue);
        this.f14354d.setScaleY(floatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(View view) {
        EditText editText = this.f14300i;
        if (editText == null) {
            return;
        }
        Editable text = editText.getText();
        if (text != null) {
            text.clear();
        }
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(View view, boolean z7) {
        A(J());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I() {
        A(true);
    }

    private boolean J() {
        EditText editText = this.f14300i;
        if (editText != null && ((editText.hasFocus() || this.f14354d.hasFocus()) && this.f14300i.getText().length() > 0)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.EndIconDelegate
    public void a(@NonNull Editable editable) {
        if (this.f14352b.w() != null) {
            return;
        }
        A(J());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.EndIconDelegate
    public int c() {
        return R$string.clear_text_end_icon_content_description;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.EndIconDelegate
    public int d() {
        return R$drawable.mtrl_ic_cancel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.EndIconDelegate
    public View.OnFocusChangeListener e() {
        return this.f14302k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.EndIconDelegate
    public View.OnClickListener f() {
        return this.f14301j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.EndIconDelegate
    public View.OnFocusChangeListener g() {
        return this.f14302k;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void n(EditText editText) {
        this.f14300i = editText;
        this.f14351a.setEndIconVisible(J());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.EndIconDelegate
    public void q(boolean z7) {
        if (this.f14352b.w() == null) {
            return;
        }
        A(z7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.EndIconDelegate
    public void s() {
        D();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.EndIconDelegate
    public void u() {
        EditText editText = this.f14300i;
        if (editText != null) {
            editText.post(new Runnable() { // from class: com.google.android.material.textfield.a
                @Override // java.lang.Runnable
                public final void run() {
                    ClearTextEndIconDelegate.this.I();
                }
            });
        }
    }
}
