package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;

@Deprecated
/* loaded from: classes.dex */
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {

    /* renamed from: b  reason: collision with root package name */
    private AnimatorSet f14532b;

    public ExpandableTransformationBehavior() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.transformation.ExpandableBehavior
    public boolean H(View view, View view2, boolean z7, boolean z8) {
        boolean z9;
        AnimatorSet animatorSet = this.f14532b;
        if (animatorSet != null) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (z9) {
            animatorSet.cancel();
        }
        AnimatorSet J = J(view, view2, z7, z9);
        this.f14532b = J;
        J.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transformation.ExpandableTransformationBehavior.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ExpandableTransformationBehavior.this.f14532b = null;
            }
        });
        this.f14532b.start();
        if (!z8) {
            this.f14532b.end();
        }
        return true;
    }

    @NonNull
    protected abstract AnimatorSet J(View view, View view2, boolean z7, boolean z8);

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
