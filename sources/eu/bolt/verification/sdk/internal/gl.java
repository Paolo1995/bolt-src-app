package eu.bolt.verification.sdk.internal;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class gl extends Transition {
    public static final a P = new a(null);
    private static final String[] Q = {"client:textColorTransition:textColor"};

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(ArgbEvaluator argbEvaluator, Integer num, Integer num2, TextView textView, ValueAnimator animation) {
        Intrinsics.f(argbEvaluator, "$argbEvaluator");
        Intrinsics.f(textView, "$textView");
        Intrinsics.f(animation, "animation");
        Object evaluate = argbEvaluator.evaluate(animation.getAnimatedFraction(), num, num2);
        Integer num3 = evaluate instanceof Integer ? (Integer) evaluate : null;
        if (num3 != null) {
            textView.setTextColor(num3.intValue());
        }
    }

    private final void m0(TransitionValues transitionValues) {
        View view = transitionValues.f7876b;
        TextView textView = view instanceof TextView ? (TextView) view : null;
        if (textView != null) {
            int currentTextColor = textView.getCurrentTextColor();
            Map<String, Object> map = transitionValues.f7875a;
            Intrinsics.e(map, "transitionValues.values");
            map.put("client:textColorTransition:textColor", Integer.valueOf(currentTextColor));
        }
    }

    @Override // androidx.transition.Transition
    public String[] L() {
        return Q;
    }

    @Override // androidx.transition.Transition
    public void h(TransitionValues transitionValues) {
        Intrinsics.f(transitionValues, "transitionValues");
        m0(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void k(TransitionValues transitionValues) {
        Intrinsics.f(transitionValues, "transitionValues");
        m0(transitionValues);
    }

    @Override // androidx.transition.Transition
    public Animator o(ViewGroup sceneRoot, TransitionValues transitionValues, TransitionValues transitionValues2) {
        Intrinsics.f(sceneRoot, "sceneRoot");
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        Object obj = transitionValues.f7875a.get("client:textColorTransition:textColor");
        final Integer num = obj instanceof Integer ? (Integer) obj : null;
        Object obj2 = transitionValues2.f7875a.get("client:textColorTransition:textColor");
        final Integer num2 = obj2 instanceof Integer ? (Integer) obj2 : null;
        View view = transitionValues2.f7876b;
        final TextView textView = view instanceof TextView ? (TextView) view : null;
        if (textView != null) {
            final ArgbEvaluator argbEvaluator = new ArgbEvaluator();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: eu.bolt.verification.sdk.internal.ts
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    gl.l0(argbEvaluator, num, num2, textView, valueAnimator);
                }
            });
            return ofFloat;
        }
        throw new IllegalStateException("unsupported view type".toString());
    }
}
