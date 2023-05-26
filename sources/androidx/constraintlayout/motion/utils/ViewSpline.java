package androidx.constraintlayout.motion.utils;

import android.view.View;
import androidx.constraintlayout.core.motion.utils.SplineSet;

/* loaded from: classes.dex */
public abstract class ViewSpline extends SplineSet {

    /* loaded from: classes.dex */
    public static class PathRotate extends ViewSpline {
        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void b(View view, float f8) {
        }

        public void c(View view, float f8, double d8, double d9) {
            view.setRotation(a(f8) + ((float) Math.toDegrees(Math.atan2(d9, d8))));
        }
    }

    public abstract void b(View view, float f8);
}
