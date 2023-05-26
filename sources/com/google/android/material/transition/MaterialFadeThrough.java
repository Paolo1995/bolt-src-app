package com.google.android.material.transition;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.TransitionValues;
import com.google.android.material.R$attr;

/* loaded from: classes.dex */
public final class MaterialFadeThrough extends MaterialVisibility<FadeThroughProvider> {
    private static final int U = R$attr.motionDurationLong1;
    private static final int V = R$attr.motionEasingEmphasizedInterpolator;

    public MaterialFadeThrough() {
        super(x0(), y0());
    }

    private static FadeThroughProvider x0() {
        return new FadeThroughProvider();
    }

    private static VisibilityAnimatorProvider y0() {
        ScaleProvider scaleProvider = new ScaleProvider();
        scaleProvider.e(false);
        scaleProvider.d(0.92f);
        return scaleProvider;
    }

    @Override // com.google.android.material.transition.MaterialVisibility, androidx.transition.Visibility
    public /* bridge */ /* synthetic */ Animator m0(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.m0(viewGroup, view, transitionValues, transitionValues2);
    }

    @Override // com.google.android.material.transition.MaterialVisibility, androidx.transition.Visibility
    public /* bridge */ /* synthetic */ Animator o0(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.o0(viewGroup, view, transitionValues, transitionValues2);
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    int u0(boolean z7) {
        return U;
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    int v0(boolean z7) {
        return V;
    }
}
