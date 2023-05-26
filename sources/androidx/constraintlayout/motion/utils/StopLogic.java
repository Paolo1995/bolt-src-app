package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.core.motion.utils.StopEngine;
import androidx.constraintlayout.core.motion.utils.StopLogicEngine;
import androidx.constraintlayout.motion.widget.MotionInterpolator;

/* loaded from: classes.dex */
public class StopLogic extends MotionInterpolator {

    /* renamed from: a  reason: collision with root package name */
    private StopLogicEngine f4771a;

    /* renamed from: b  reason: collision with root package name */
    private StopEngine f4772b;

    public StopLogic() {
        StopLogicEngine stopLogicEngine = new StopLogicEngine();
        this.f4771a = stopLogicEngine;
        this.f4772b = stopLogicEngine;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
    public float a() {
        return this.f4772b.a();
    }

    public boolean b() {
        return this.f4772b.b();
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f8) {
        return this.f4772b.getInterpolation(f8);
    }
}
