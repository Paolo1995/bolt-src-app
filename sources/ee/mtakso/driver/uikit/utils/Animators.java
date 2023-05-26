package ee.mtakso.driver.uikit.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Animators.kt */
/* loaded from: classes5.dex */
public final class Animators {

    /* renamed from: a  reason: collision with root package name */
    public static final Animators f36024a = new Animators();

    /* renamed from: b  reason: collision with root package name */
    private static final LinearInterpolator f36025b = new LinearInterpolator();

    /* renamed from: c  reason: collision with root package name */
    private static final LinearOutSlowInInterpolator f36026c = new LinearOutSlowInInterpolator();

    private Animators() {
    }

    private final Animator a(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.ALPHA, 0.0f, 1.0f);
        ofFloat.setInterpolator(f36025b);
        Intrinsics.e(ofFloat, "ofFloat(child, View.ALPH…AR_INTERPOLATOR\n        }");
        return ofFloat;
    }

    private final Animator c(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, view.getMeasuredHeight(), 0.0f);
        ofFloat.setInterpolator(f36026c);
        Intrinsics.e(ofFloat, "ofFloat(\n            con…IN_INTERPOLATOR\n        }");
        return ofFloat;
    }

    public final Animator b(View container, View... children) {
        Intrinsics.f(container, "container");
        Intrinsics.f(children, "children");
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(f36024a.c(container));
        for (View view : children) {
            animatorSet.playTogether(f36024a.a(view));
        }
        animatorSet.setDuration(400L);
        return animatorSet;
    }
}
