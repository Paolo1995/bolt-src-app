package eu.bolt.android.stories.util;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.ViewCompat;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewExt.kt */
/* loaded from: classes5.dex */
public final class ViewExtKt {
    public static final boolean a(View view) {
        Intrinsics.f(view, "<this>");
        if (ViewCompat.E(view) == 1) {
            return true;
        }
        return false;
    }

    public static final boolean b(View view, MotionEvent event, float f8, float f9) {
        Intrinsics.f(view, "<this>");
        Intrinsics.f(event, "event");
        float scaledMinimumFlingVelocity = ViewConfiguration.get(view.getContext()).getScaledMinimumFlingVelocity();
        if (Math.abs(event.getX() - f8) < scaledMinimumFlingVelocity && event.getY() - f9 > scaledMinimumFlingVelocity) {
            return true;
        }
        return false;
    }
}
