package androidx.viewbinding;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class ViewBindings {
    private ViewBindings() {
    }

    public static <T extends View> T a(View view, int i8) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            T t7 = (T) viewGroup.getChildAt(i9).findViewById(i8);
            if (t7 != null) {
                return t7;
            }
        }
        return null;
    }
}
