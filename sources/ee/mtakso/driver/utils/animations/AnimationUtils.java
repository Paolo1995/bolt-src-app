package ee.mtakso.driver.utils.animations;

import android.animation.ValueAnimator;
import android.view.View;
import ee.mtakso.driver.R;

/* loaded from: classes5.dex */
public class AnimationUtils {
    public static void a(long j8, int i8, int i9, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        ValueAnimator duration = ValueAnimator.ofInt(i8, i9).setDuration(j8);
        duration.addUpdateListener(animatorUpdateListener);
        duration.start();
    }

    public static void b(View view) {
        view.startAnimation(android.view.animation.AnimationUtils.loadAnimation(view.getContext(), R.anim.shake));
    }
}
