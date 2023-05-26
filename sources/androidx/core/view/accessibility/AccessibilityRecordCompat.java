package androidx.core.view.accessibility;

import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class AccessibilityRecordCompat {

    /* loaded from: classes.dex */
    static class Api15Impl {
        private Api15Impl() {
        }

        static int a(AccessibilityRecord accessibilityRecord) {
            return accessibilityRecord.getMaxScrollX();
        }

        static int b(AccessibilityRecord accessibilityRecord) {
            return accessibilityRecord.getMaxScrollY();
        }

        static void c(AccessibilityRecord accessibilityRecord, int i8) {
            accessibilityRecord.setMaxScrollX(i8);
        }

        static void d(AccessibilityRecord accessibilityRecord, int i8) {
            accessibilityRecord.setMaxScrollY(i8);
        }
    }

    /* loaded from: classes.dex */
    static class Api16Impl {
        private Api16Impl() {
        }

        static void a(AccessibilityRecord accessibilityRecord, View view, int i8) {
            accessibilityRecord.setSource(view, i8);
        }
    }

    public static void a(@NonNull AccessibilityRecord accessibilityRecord, int i8) {
        Api15Impl.c(accessibilityRecord, i8);
    }

    public static void b(@NonNull AccessibilityRecord accessibilityRecord, int i8) {
        Api15Impl.d(accessibilityRecord, i8);
    }

    public static void c(@NonNull AccessibilityRecord accessibilityRecord, View view, int i8) {
        Api16Impl.a(accessibilityRecord, view, i8);
    }
}
