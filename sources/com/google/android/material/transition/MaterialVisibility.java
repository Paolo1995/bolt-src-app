package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.transition.TransitionValues;
import androidx.transition.Visibility;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.transition.VisibilityAnimatorProvider;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
abstract class MaterialVisibility<P extends VisibilityAnimatorProvider> extends Visibility {
    private final P R;
    private VisibilityAnimatorProvider S;
    private final List<VisibilityAnimatorProvider> T = new ArrayList();

    /* JADX INFO: Access modifiers changed from: protected */
    public MaterialVisibility(P p8, VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.R = p8;
        this.S = visibilityAnimatorProvider;
    }

    private static void r0(List<Animator> list, VisibilityAnimatorProvider visibilityAnimatorProvider, ViewGroup viewGroup, View view, boolean z7) {
        Animator a8;
        if (visibilityAnimatorProvider == null) {
            return;
        }
        if (z7) {
            a8 = visibilityAnimatorProvider.b(viewGroup, view);
        } else {
            a8 = visibilityAnimatorProvider.a(viewGroup, view);
        }
        if (a8 != null) {
            list.add(a8);
        }
    }

    private Animator s0(@NonNull ViewGroup viewGroup, @NonNull View view, boolean z7) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        r0(arrayList, this.R, viewGroup, view, z7);
        r0(arrayList, this.S, viewGroup, view, z7);
        for (VisibilityAnimatorProvider visibilityAnimatorProvider : this.T) {
            r0(arrayList, visibilityAnimatorProvider, viewGroup, view, z7);
        }
        w0(viewGroup.getContext(), z7);
        AnimatorSetCompat.a(animatorSet, arrayList);
        return animatorSet;
    }

    private void w0(@NonNull Context context, boolean z7) {
        TransitionUtils.d(this, context, u0(z7));
        TransitionUtils.e(this, context, v0(z7), t0(z7));
    }

    @Override // androidx.transition.Visibility
    public Animator m0(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return s0(viewGroup, view, true);
    }

    @Override // androidx.transition.Visibility
    public Animator o0(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return s0(viewGroup, view, false);
    }

    @NonNull
    TimeInterpolator t0(boolean z7) {
        return AnimationUtils.f12721b;
    }

    int u0(boolean z7) {
        return 0;
    }

    int v0(boolean z7) {
        return 0;
    }
}
