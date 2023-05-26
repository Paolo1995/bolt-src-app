package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: classes.dex */
public class IntegerKeyframeAnimation extends KeyframeAnimation<Integer> {
    public IntegerKeyframeAnimation(List<Keyframe<Integer>> list) {
        super(list);
    }

    public int p() {
        return q(b(), d());
    }

    int q(Keyframe<Integer> keyframe, float f8) {
        Integer num;
        if (keyframe.f9661b != null && keyframe.f9662c != null) {
            LottieValueCallback<A> lottieValueCallback = this.f9171e;
            if (lottieValueCallback != 0 && (num = (Integer) lottieValueCallback.b(keyframe.f9666g, keyframe.f9667h.floatValue(), keyframe.f9661b, keyframe.f9662c, f8, e(), f())) != null) {
                return num.intValue();
            }
            return MiscUtils.j(keyframe.g(), keyframe.d(), f8);
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
