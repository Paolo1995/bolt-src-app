package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;

/* loaded from: classes.dex */
public class PathKeyframe extends Keyframe<PointF> {

    /* renamed from: q  reason: collision with root package name */
    private Path f9194q;

    /* renamed from: r  reason: collision with root package name */
    private final Keyframe<PointF> f9195r;

    public PathKeyframe(LottieComposition lottieComposition, Keyframe<PointF> keyframe) {
        super(lottieComposition, keyframe.f9661b, keyframe.f9662c, keyframe.f9663d, keyframe.f9664e, keyframe.f9665f, keyframe.f9666g, keyframe.f9667h);
        this.f9195r = keyframe;
        i();
    }

    public void i() {
        boolean z7;
        T t7;
        T t8;
        T t9 = this.f9662c;
        if (t9 != 0 && (t8 = this.f9661b) != 0 && ((PointF) t8).equals(((PointF) t9).x, ((PointF) t9).y)) {
            z7 = true;
        } else {
            z7 = false;
        }
        T t10 = this.f9661b;
        if (t10 != 0 && (t7 = this.f9662c) != 0 && !z7) {
            Keyframe<PointF> keyframe = this.f9195r;
            this.f9194q = Utils.d((PointF) t10, (PointF) t7, keyframe.f9674o, keyframe.f9675p);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Path j() {
        return this.f9194q;
    }
}
