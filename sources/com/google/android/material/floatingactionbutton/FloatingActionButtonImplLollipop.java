package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import java.util.ArrayList;

/* loaded from: classes.dex */
class FloatingActionButtonImplLollipop extends FloatingActionButtonImpl {
    private StateListAnimator N;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FloatingActionButtonImplLollipop(FloatingActionButton floatingActionButton, ShadowViewDelegate shadowViewDelegate) {
        super(floatingActionButton, shadowViewDelegate);
    }

    @NonNull
    private StateListAnimator f0(float f8, float f9, float f10) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(FloatingActionButtonImpl.H, g0(f8, f10));
        stateListAnimator.addState(FloatingActionButtonImpl.I, g0(f8, f9));
        stateListAnimator.addState(FloatingActionButtonImpl.J, g0(f8, f9));
        stateListAnimator.addState(FloatingActionButtonImpl.K, g0(f8, f9));
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this.f13472v, "elevation", f8).setDuration(0L));
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 22 && i8 <= 24) {
            FloatingActionButton floatingActionButton = this.f13472v;
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
        }
        arrayList.add(ObjectAnimator.ofFloat(this.f13472v, View.TRANSLATION_Z, 0.0f).setDuration(100L));
        animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
        animatorSet.setInterpolator(FloatingActionButtonImpl.C);
        stateListAnimator.addState(FloatingActionButtonImpl.L, animatorSet);
        stateListAnimator.addState(FloatingActionButtonImpl.M, g0(0.0f, 0.0f));
        return stateListAnimator;
    }

    @NonNull
    private Animator g0(float f8, float f9) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.f13472v, "elevation", f8).setDuration(0L)).with(ObjectAnimator.ofFloat(this.f13472v, View.TRANSLATION_Z, f9).setDuration(100L));
        animatorSet.setInterpolator(FloatingActionButtonImpl.C);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void A() {
        c0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void C(int[] iArr) {
        if (Build.VERSION.SDK_INT == 21) {
            if (this.f13472v.isEnabled()) {
                this.f13472v.setElevation(this.f13457g);
                if (this.f13472v.isPressed()) {
                    this.f13472v.setTranslationZ(this.f13459i);
                    return;
                } else if (!this.f13472v.isFocused() && !this.f13472v.isHovered()) {
                    this.f13472v.setTranslationZ(0.0f);
                    return;
                } else {
                    this.f13472v.setTranslationZ(this.f13458h);
                    return;
                }
            }
            this.f13472v.setElevation(0.0f);
            this.f13472v.setTranslationZ(0.0f);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void D(float f8, float f9, float f10) {
        if (Build.VERSION.SDK_INT == 21) {
            this.f13472v.refreshDrawableState();
        } else if (this.f13472v.getStateListAnimator() == this.N) {
            StateListAnimator f02 = f0(f8, f9, f10);
            this.N = f02;
            this.f13472v.setStateListAnimator(f02);
        }
        if (W()) {
            c0();
        }
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    boolean I() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void S(ColorStateList colorStateList) {
        Drawable drawable = this.f13453c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(RippleUtils.e(colorStateList));
        } else {
            super.S(colorStateList);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    boolean W() {
        if (!this.f13473w.b() && Y()) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    void a0() {
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public float m() {
        return this.f13472v.getElevation();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void r(@NonNull Rect rect) {
        if (this.f13473w.b()) {
            super.r(rect);
        } else if (!Y()) {
            int sizeDimension = (this.f13460j - this.f13472v.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        } else {
            rect.set(0, 0, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public void y() {
    }
}
