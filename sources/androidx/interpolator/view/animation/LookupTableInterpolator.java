package androidx.interpolator.view.animation;

import android.view.animation.Interpolator;

/* loaded from: classes.dex */
abstract class LookupTableInterpolator implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f6649a;

    /* renamed from: b  reason: collision with root package name */
    private final float f6650b;

    /* JADX INFO: Access modifiers changed from: protected */
    public LookupTableInterpolator(float[] fArr) {
        this.f6649a = fArr;
        this.f6650b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f8) {
        if (f8 >= 1.0f) {
            return 1.0f;
        }
        if (f8 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f6649a;
        int min = Math.min((int) ((fArr.length - 1) * f8), fArr.length - 2);
        float f9 = this.f6650b;
        float f10 = (f8 - (min * f9)) / f9;
        float[] fArr2 = this.f6649a;
        float f11 = fArr2[min];
        return f11 + (f10 * (fArr2[min + 1] - f11));
    }
}
