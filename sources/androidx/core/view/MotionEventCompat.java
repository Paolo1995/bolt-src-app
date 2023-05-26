package androidx.core.view;

import android.view.MotionEvent;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class MotionEventCompat {
    private MotionEventCompat() {
    }

    public static boolean a(@NonNull MotionEvent motionEvent, int i8) {
        if ((motionEvent.getSource() & i8) == i8) {
            return true;
        }
        return false;
    }
}
