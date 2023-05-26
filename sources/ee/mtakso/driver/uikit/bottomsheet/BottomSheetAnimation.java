package ee.mtakso.driver.uikit.bottomsheet;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import androidx.core.view.ViewCompat;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BottomSheetAnimation.kt */
/* loaded from: classes5.dex */
public final class BottomSheetAnimation {

    /* renamed from: a  reason: collision with root package name */
    public static final BottomSheetAnimation f35905a = new BottomSheetAnimation();

    /* renamed from: b  reason: collision with root package name */
    private static final DecelerateInterpolator f35906b = new DecelerateInterpolator();

    private BottomSheetAnimation() {
    }

    public final boolean a(ViewGroup parent, View child, Function0<Boolean> change) {
        Intrinsics.f(parent, "parent");
        Intrinsics.f(child, "child");
        Intrinsics.f(change, "change");
        int top = child.getTop();
        int bottom = child.getBottom() - top;
        boolean W = ViewCompat.W(child);
        boolean booleanValue = change.invoke().booleanValue();
        int top2 = child.getTop();
        int bottom2 = child.getBottom() - top2;
        int i8 = top - top2;
        child.animate().cancel();
        if (W) {
            if (bottom2 < bottom) {
                child.layout(child.getLeft(), child.getTop(), child.getRight(), child.getTop() + bottom);
            }
            child.setTranslationY(i8);
            ViewPropertyAnimator listener = child.animate().translationY(0.0f).setDuration((long) ((Math.abs(i8) * 1000) / Math.abs(parent.getBottom() - parent.getTop()))).setInterpolator(f35906b).setListener(new Animator.AnimatorListener() { // from class: ee.mtakso.driver.uikit.bottomsheet.BottomSheetAnimation$animateLayoutChange$animator$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    Intrinsics.f(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.f(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animation) {
                    Intrinsics.f(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    Intrinsics.f(animation, "animation");
                }
            });
            Intrinsics.e(listener, "child.animate()\n        …     }\n                })");
            listener.start();
        }
        return booleanValue;
    }
}
