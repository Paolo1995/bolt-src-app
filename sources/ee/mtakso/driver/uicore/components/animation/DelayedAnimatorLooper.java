package ee.mtakso.driver.uicore.components.animation;

import android.animation.Animator;
import android.os.Handler;
import ee.mtakso.driver.uicore.components.animation.DelayedAnimatorLooper;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DelayedAnimatorLooper.kt */
/* loaded from: classes5.dex */
public final class DelayedAnimatorLooper implements Animator.AnimatorListener {

    /* renamed from: a  reason: collision with root package name */
    private final long f34737a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f34738b = new Handler();

    public DelayedAnimatorLooper(long j8) {
        this.f34737a = j8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Animator animation) {
        Intrinsics.f(animation, "$animation");
        animation.setStartDelay(0L);
        animation.start();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animation) {
        Intrinsics.f(animation, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(final Animator animation) {
        Intrinsics.f(animation, "animation");
        this.f34738b.postDelayed(new Runnable() { // from class: n5.a
            @Override // java.lang.Runnable
            public final void run() {
                DelayedAnimatorLooper.b(animation);
            }
        }, this.f34737a);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animation) {
        Intrinsics.f(animation, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animation) {
        Intrinsics.f(animation, "animation");
    }
}
