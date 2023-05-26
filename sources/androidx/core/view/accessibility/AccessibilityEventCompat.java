package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class AccessibilityEventCompat {

    /* loaded from: classes.dex */
    static class Api19Impl {
        private Api19Impl() {
        }

        static int a(AccessibilityEvent accessibilityEvent) {
            return accessibilityEvent.getContentChangeTypes();
        }

        static void b(AccessibilityEvent accessibilityEvent, int i8) {
            accessibilityEvent.setContentChangeTypes(i8);
        }
    }

    private AccessibilityEventCompat() {
    }

    public static int a(@NonNull AccessibilityEvent accessibilityEvent) {
        return Api19Impl.a(accessibilityEvent);
    }

    public static void b(@NonNull AccessibilityEvent accessibilityEvent, int i8) {
        Api19Impl.b(accessibilityEvent, i8);
    }
}
