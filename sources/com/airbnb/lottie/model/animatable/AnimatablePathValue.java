package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PathKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PointKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* loaded from: classes.dex */
public class AnimatablePathValue implements AnimatableValue<PointF, PointF> {

    /* renamed from: a  reason: collision with root package name */
    private final List<Keyframe<PointF>> f9302a;

    public AnimatablePathValue(List<Keyframe<PointF>> list) {
        this.f9302a = list;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<PointF, PointF> a() {
        if (this.f9302a.get(0).h()) {
            return new PointKeyframeAnimation(this.f9302a);
        }
        return new PathKeyframeAnimation(this.f9302a);
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public List<Keyframe<PointF>> b() {
        return this.f9302a;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public boolean c() {
        if (this.f9302a.size() != 1 || !this.f9302a.get(0).h()) {
            return false;
        }
        return true;
    }
}
