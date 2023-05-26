package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public interface MotionStrategy {
    void a();

    MotionSpec b();

    boolean c();

    void d();

    int e();

    void f();

    void g(MotionSpec motionSpec);

    AnimatorSet h();

    List<Animator.AnimatorListener> i();

    void j(ExtendedFloatingActionButton.OnChangedCallback onChangedCallback);

    void onAnimationStart(Animator animator);
}
