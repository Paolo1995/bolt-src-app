package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
class ViewUtilsApi23 extends ViewUtilsApi22 {

    /* renamed from: i  reason: collision with root package name */
    private static boolean f7892i = true;

    @Override // androidx.transition.ViewUtilsBase
    @SuppressLint({"NewApi"})
    public void g(@NonNull View view, int i8) {
        if (Build.VERSION.SDK_INT == 28) {
            super.g(view, i8);
        } else if (f7892i) {
            try {
                view.setTransitionVisibility(i8);
            } catch (NoSuchMethodError unused) {
                f7892i = false;
            }
        }
    }
}
