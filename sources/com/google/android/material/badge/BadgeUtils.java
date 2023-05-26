package com.google.android.material.badge;

import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class BadgeUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f12903a = false;

    private BadgeUtils() {
    }

    public static void a(@NonNull BadgeDrawable badgeDrawable, @NonNull View view, FrameLayout frameLayout) {
        c(badgeDrawable, view, frameLayout);
        if (badgeDrawable.g() != null) {
            badgeDrawable.g().setForeground(badgeDrawable);
        } else if (!f12903a) {
            view.getOverlay().add(badgeDrawable);
        } else {
            throw new IllegalArgumentException("Trying to reference null customBadgeParent");
        }
    }

    public static void b(BadgeDrawable badgeDrawable, @NonNull View view) {
        if (badgeDrawable == null) {
            return;
        }
        if (!f12903a && badgeDrawable.g() == null) {
            view.getOverlay().remove(badgeDrawable);
        } else {
            badgeDrawable.g().setForeground(null);
        }
    }

    public static void c(@NonNull BadgeDrawable badgeDrawable, @NonNull View view, FrameLayout frameLayout) {
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        badgeDrawable.setBounds(rect);
        badgeDrawable.z(view, frameLayout);
    }

    public static void d(@NonNull Rect rect, float f8, float f9, float f10, float f11) {
        rect.set((int) (f8 - f10), (int) (f9 - f11), (int) (f8 + f10), (int) (f9 + f11));
    }
}
