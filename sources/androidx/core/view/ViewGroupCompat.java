package androidx.core.view;

import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class ViewGroupCompat {

    /* loaded from: classes.dex */
    static class Api21Impl {
        private Api21Impl() {
        }

        static int a(ViewGroup viewGroup) {
            return viewGroup.getNestedScrollAxes();
        }

        static boolean b(ViewGroup viewGroup) {
            return viewGroup.isTransitionGroup();
        }

        static void c(ViewGroup viewGroup, boolean z7) {
            viewGroup.setTransitionGroup(z7);
        }
    }

    private ViewGroupCompat() {
    }

    public static boolean a(@NonNull ViewGroup viewGroup) {
        return Api21Impl.b(viewGroup);
    }
}
