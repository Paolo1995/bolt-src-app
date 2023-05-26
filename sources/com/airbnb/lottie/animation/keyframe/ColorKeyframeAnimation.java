package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: classes.dex */
public class ColorKeyframeAnimation extends KeyframeAnimation<Integer> {
    public ColorKeyframeAnimation(List<Keyframe<Integer>> list) {
        super(list);
    }

    public int p() {
        return q(b(), d());
    }

    public int q(Keyframe<Integer> keyframe, float f8) {
        Integer num;
        if (keyframe.f9661b != null && keyframe.f9662c != null) {
            LottieValueCallback<A> lottieValueCallback = this.f9171e;
            if (lottieValueCallback != 0 && (num = (Integer) lottieValueCallback.b(keyframe.f9666g, keyframe.f9667h.floatValue(), keyframe.f9661b, keyframe.f9662c, f8, e(), f())) != null) {
                return num.intValue();
            }
            return GammaEvaluator.c(MiscUtils.b(f8, 0.0f, 1.0f), keyframe.f9661b.intValue(), keyframe.f9662c.intValue());
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: r */
    public Integer i(Keyframe<Integer> keyframe, float f8) {
        return Integer.valueOf(q(keyframe, f8));
    }
}
