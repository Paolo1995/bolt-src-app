package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
class ViewUtilsApi22 extends ViewUtilsApi21 {

    /* renamed from: h  reason: collision with root package name */
    private static boolean f7891h = true;

    @Override // androidx.transition.ViewUtilsBase
    @SuppressLint({"NewApi"})
    public void e(@NonNull View view, int i8, int i9, int i10, int i11) {
        if (f7891h) {
            try {
                view.setLeftTopRightBottom(i8, i9, i10, i11);
            } catch (NoSuchMethodError unused) {
                f7891h = false;
            }
        }
    }
}
