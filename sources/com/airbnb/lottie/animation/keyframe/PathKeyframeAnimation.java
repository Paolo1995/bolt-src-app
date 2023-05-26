package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: classes.dex */
public class PathKeyframeAnimation extends KeyframeAnimation<PointF> {

    /* renamed from: i  reason: collision with root package name */
    private final PointF f9196i;

    /* renamed from: j  reason: collision with root package name */
    private final float[] f9197j;

    /* renamed from: k  reason: collision with root package name */
    private final PathMeasure f9198k;

    /* renamed from: l  reason: collision with root package name */
    private PathKeyframe f9199l;

    public PathKeyframeAnimation(List<? extends Keyframe<PointF>> list) {
        super(list);
        this.f9196i = new PointF();
        this.f9197j = new float[2];
        this.f9198k = new PathMeasure();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: p */
    public PointF i(Keyframe<PointF> keyframe, float f8) {
        PointF pointF;
        PathKeyframe pathKeyframe = (PathKeyframe) keyframe;
        Path j8 = pathKeyframe.j();
        if (j8 == null) {
            return keyframe.f9661b;
        }
        LottieValueCallback<A> lottieValueCallback = this.f9171e;
        if (lottieValueCallback != 0 && (pointF = (PointF) lottieValueCallback.b(pathKeyframe.f9666g, pathKeyframe.f9667h.floatValue(), (PointF) pathKeyframe.f9661b, (PointF) pathKeyframe.f9662c, e(), f8, f())) != null) {
            return pointF;
        }
        if (this.f9199l != pathKeyframe) {
            this.f9198k.setPath(j8, false);
            this.f9199l = pathKeyframe;
        }
        PathMeasure pathMeasure = this.f9198k;
        pathMeasure.getPosTan(f8 * pathMeasure.getLength(), this.f9197j, null);
        PointF pointF2 = this.f9196i;
        float[] fArr = this.f9197j;
        pointF2.set(fArr[0], fArr[1]);
        return this.f9196i;
    }
}
