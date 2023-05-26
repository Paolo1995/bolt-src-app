package androidx.constraintlayout.motion.utils;

import android.view.View;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;

/* loaded from: classes.dex */
public abstract class ViewTimeCycle extends TimeCycleSplineSet {

    /* loaded from: classes.dex */
    public static class PathRotate extends ViewTimeCycle {
        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean c(View view, float f8, long j8, KeyCache keyCache) {
            return this.f4484h;
        }

        public boolean d(View view, KeyCache keyCache, float f8, long j8, double d8, double d9) {
            view.setRotation(b(f8, j8, view, keyCache) + ((float) Math.toDegrees(Math.atan2(d9, d8))));
            return this.f4484h;
        }
    }

    public float b(float f8, long j8, View view, KeyCache keyCache) {
        boolean z7;
        this.f4477a.c(f8, this.f4483g);
        float[] fArr = this.f4483g;
        float f9 = fArr[1];
        int i8 = (f9 > 0.0f ? 1 : (f9 == 0.0f ? 0 : -1));
        if (i8 == 0) {
            this.f4484h = false;
            return fArr[2];
        }
        if (Float.isNaN(this.f4486j)) {
            float a8 = keyCache.a(view, this.f4482f, 0);
            this.f4486j = a8;
            if (Float.isNaN(a8)) {
                this.f4486j = 0.0f;
            }
        }
        float f10 = (float) ((this.f4486j + (((j8 - this.f4485i) * 1.0E-9d) * f9)) % 1.0d);
        this.f4486j = f10;
        keyCache.b(view, this.f4482f, 0, f10);
        this.f4485i = j8;
        float f11 = this.f4483g[0];
        float a9 = (a(this.f4486j) * f11) + this.f4483g[2];
        if (f11 == 0.0f && i8 == 0) {
            z7 = false;
        } else {
            z7 = true;
        }
        this.f4484h = z7;
        return a9;
    }

    public abstract boolean c(View view, float f8, long j8, KeyCache keyCache);
}
