package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.MotionSpec;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class BaseMotionStrategy implements MotionStrategy {

    /* renamed from: a  reason: collision with root package name */
    private final Context f13397a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final ExtendedFloatingActionButton f13398b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<Animator.AnimatorListener> f13399c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final AnimatorTracker f13400d;

    /* renamed from: e  reason: collision with root package name */
    private MotionSpec f13401e;

    /* renamed from: f  reason: collision with root package name */
    private MotionSpec f13402f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseMotionStrategy(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton, AnimatorTracker animatorTracker) {
        this.f13398b = extendedFloatingActionButton;
        this.f13397a = extendedFloatingActionButton.getContext();
        this.f13400d = animatorTracker;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public MotionSpec b() {
        return this.f13402f;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public void d() {
        this.f13400d.b();
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public void f() {
        this.f13400d.b();
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public final void g(MotionSpec motionSpec) {
        this.f13402f = motionSpec;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public AnimatorSet h() {
        return l(m());
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    @NonNull
    public final List<Animator.AnimatorListener> i() {
        return this.f13399c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public AnimatorSet l(@NonNull MotionSpec motionSpec) {
        ArrayList arrayList = new ArrayList();
        if (motionSpec.j("opacity")) {
            arrayList.add(motionSpec.f("opacity", this.f13398b, View.ALPHA));
        }
        if (motionSpec.j("scale")) {
            arrayList.add(motionSpec.f("scale", this.f13398b, View.SCALE_Y));
            arrayList.add(motionSpec.f("scale", this.f13398b, View.SCALE_X));
        }
        if (motionSpec.j("width")) {
            arrayList.add(motionSpec.f("width", this.f13398b, ExtendedFloatingActionButton.Q));
        }
        if (motionSpec.j("height")) {
            arrayList.add(motionSpec.f("height", this.f13398b, ExtendedFloatingActionButton.R));
        }
        if (motionSpec.j("paddingStart")) {
            arrayList.add(motionSpec.f("paddingStart", this.f13398b, ExtendedFloatingActionButton.S));
        }
        if (motionSpec.j("paddingEnd")) {
            arrayList.add(motionSpec.f("paddingEnd", this.f13398b, ExtendedFloatingActionButton.T));
        }
        if (motionSpec.j("labelOpacity")) {
            arrayList.add(motionSpec.f("labelOpacity", this.f13398b, new Property<ExtendedFloatingActionButton, Float>(Float.class, "LABEL_OPACITY_PROPERTY") { // from class: com.google.android.material.floatingactionbutton.BaseMotionStrategy.1
                @Override // android.util.Property
                /* renamed from: a */
                public Float get(ExtendedFloatingActionButton extendedFloatingActionButton) {
                    return Float.valueOf(AnimationUtils.a(0.0f, 1.0f, (Color.alpha(extendedFloatingActionButton.getCurrentTextColor()) / 255.0f) / Color.alpha(extendedFloatingActionButton.L.getColorForState(extendedFloatingActionButton.getDrawableState(), BaseMotionStrategy.this.f13398b.L.getDefaultColor()))));
                }

                @Override // android.util.Property
                /* renamed from: b */
                public void set(ExtendedFloatingActionButton extendedFloatingActionButton, Float f8) {
                    int colorForState = extendedFloatingActionButton.L.getColorForState(extendedFloatingActionButton.getDrawableState(), BaseMotionStrategy.this.f13398b.L.getDefaultColor());
                    ColorStateList valueOf = ColorStateList.valueOf(Color.argb((int) (AnimationUtils.a(0.0f, Color.alpha(colorForState) / 255.0f, f8.floatValue()) * 255.0f), Color.red(colorForState), Color.green(colorForState), Color.blue(colorForState)));
                    if (f8.floatValue() == 1.0f) {
                        extendedFloatingActionButton.G(extendedFloatingActionButton.L);
                    } else {
                        extendedFloatingActionButton.G(valueOf);
                    }
                }
            }));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.a(animatorSet, arrayList);
        return animatorSet;
    }

    public final MotionSpec m() {
        MotionSpec motionSpec = this.f13402f;
        if (motionSpec != null) {
            return motionSpec;
        }
        if (this.f13401e == null) {
            this.f13401e = MotionSpec.d(this.f13397a, e());
        }
        return (MotionSpec) Preconditions.g(this.f13401e);
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public void onAnimationStart(Animator animator) {
        this.f13400d.c(animator);
    }
}
