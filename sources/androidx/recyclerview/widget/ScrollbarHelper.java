package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
class ScrollbarHelper {
    private ScrollbarHelper() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(RecyclerView.State state, OrientationHelper orientationHelper, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z7) {
        if (layoutManager.U() != 0 && state.b() != 0 && view != null && view2 != null) {
            if (!z7) {
                return Math.abs(layoutManager.o0(view) - layoutManager.o0(view2)) + 1;
            }
            return Math.min(orientationHelper.n(), orientationHelper.d(view2) - orientationHelper.g(view));
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(RecyclerView.State state, OrientationHelper orientationHelper, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z7, boolean z8) {
        int max;
        if (layoutManager.U() == 0 || state.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int min = Math.min(layoutManager.o0(view), layoutManager.o0(view2));
        int max2 = Math.max(layoutManager.o0(view), layoutManager.o0(view2));
        if (z8) {
            max = Math.max(0, (state.b() - max2) - 1);
        } else {
            max = Math.max(0, min);
        }
        if (!z7) {
            return max;
        }
        return Math.round((max * (Math.abs(orientationHelper.d(view2) - orientationHelper.g(view)) / (Math.abs(layoutManager.o0(view) - layoutManager.o0(view2)) + 1))) + (orientationHelper.m() - orientationHelper.g(view)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(RecyclerView.State state, OrientationHelper orientationHelper, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z7) {
        if (layoutManager.U() != 0 && state.b() != 0 && view != null && view2 != null) {
            if (!z7) {
                return state.b();
            }
            return (int) (((orientationHelper.d(view2) - orientationHelper.g(view)) / (Math.abs(layoutManager.o0(view) - layoutManager.o0(view2)) + 1)) * state.b());
        }
        return 0;
    }
}
