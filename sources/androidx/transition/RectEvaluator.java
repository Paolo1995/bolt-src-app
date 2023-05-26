package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* loaded from: classes.dex */
class RectEvaluator implements TypeEvaluator<Rect> {

    /* renamed from: a  reason: collision with root package name */
    private Rect f7828a;

    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public Rect evaluate(float f8, Rect rect, Rect rect2) {
        int i8 = rect.left;
        int i9 = i8 + ((int) ((rect2.left - i8) * f8));
        int i10 = rect.top;
        int i11 = i10 + ((int) ((rect2.top - i10) * f8));
        int i12 = rect.right;
        int i13 = i12 + ((int) ((rect2.right - i12) * f8));
        int i14 = rect.bottom;
        int i15 = i14 + ((int) ((rect2.bottom - i14) * f8));
        Rect rect3 = this.f7828a;
        if (rect3 == null) {
            return new Rect(i9, i11, i13, i15);
        }
        rect3.set(i9, i11, i13, i15);
        return this.f7828a;
    }
}
