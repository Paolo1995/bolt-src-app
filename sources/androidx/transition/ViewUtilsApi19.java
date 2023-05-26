package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
class ViewUtilsApi19 extends ViewUtilsBase {

    /* renamed from: e  reason: collision with root package name */
    private static boolean f7888e = true;

    @Override // androidx.transition.ViewUtilsBase
    public void a(@NonNull View view) {
    }

    @Override // androidx.transition.ViewUtilsBase
    @SuppressLint({"NewApi"})
    public float c(@NonNull View view) {
        float transitionAlpha;
        if (f7888e) {
            try {
                transitionAlpha = view.getTransitionAlpha();
                return transitionAlpha;
            } catch (NoSuchMethodError unused) {
                f7888e = false;
            }
        }
        return view.getAlpha();
    }

    @Override // androidx.transition.ViewUtilsBase
    public void d(@NonNull View view) {
    }

    @Override // androidx.transition.ViewUtilsBase
    @SuppressLint({"NewApi"})
    public void f(@NonNull View view, float f8) {
        if (f7888e) {
            try {
                view.setTransitionAlpha(f8);
                return;
            } catch (NoSuchMethodError unused) {
                f7888e = false;
            }
        }
        view.setAlpha(f8);
    }
}
