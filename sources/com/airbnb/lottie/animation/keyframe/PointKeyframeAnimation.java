package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: classes.dex */
public class PointKeyframeAnimation extends KeyframeAnimation<PointF> {

    /* renamed from: i  reason: collision with root package name */
    private final PointF f9200i;

    public PointKeyframeAnimation(List<Keyframe<PointF>> list) {
        super(list);
        this.f9200i = new PointF();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: p */
    public PointF i(Keyframe<PointF> keyframe, float f8) {
        return j(keyframe, f8, f8, f8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: q */
    public PointF j(Keyframe<PointF> keyframe, float f8, float f9, float f10) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3 = keyframe.f9661b;
        if (pointF3 != null && (pointF = keyframe.f9662c) != null) {
            PointF pointF4 = pointF3;
            PointF pointF5 = pointF;
            LottieValueCallback<A> lottieValueCallback = this.f9171e;
            if (lottieValueCallback != 0 && (pointF2 = (PointF) lottieValueCallback.b(keyframe.f9666g, keyframe.f9667h.floatValue(), pointF4, pointF5, f8, e(), f())) != null) {
                return pointF2;
            }
            PointF pointF6 = this.f9200i;
            float f11 = pointF4.x;
            float f12 = f11 + (f9 * (pointF5.x - f11));
            float f13 = pointF4.y;
            pointF6.set(f12, f13 + (f10 * (pointF5.y - f13)));
            return this.f9200i;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
