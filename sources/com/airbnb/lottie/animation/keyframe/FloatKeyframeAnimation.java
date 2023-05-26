package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: classes.dex */
public class FloatKeyframeAnimation extends KeyframeAnimation<Float> {
    public FloatKeyframeAnimation(List<Keyframe<Float>> list) {
        super(list);
    }

    public float p() {
        return q(b(), d());
    }

    float q(Keyframe<Float> keyframe, float f8) {
        Float f9;
        if (keyframe.f9661b != null && keyframe.f9662c != null) {
            LottieValueCallback<A> lottieValueCallback = this.f9171e;
            if (lottieValueCallback != 0 && (f9 = (Float) lottieValueCallback.b(keyframe.f9666g, keyframe.f9667h.floatValue(), keyframe.f9661b, keyframe.f9662c, f8, e(), f())) != null) {
                return f9.floatValue();
            }
            return MiscUtils.i(keyframe.f(), keyframe.c(), f8);
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: r */
    public Float i(Keyframe<Float> keyframe, float f8) {
        return Float.valueOf(q(keyframe, f8));
    }
}
