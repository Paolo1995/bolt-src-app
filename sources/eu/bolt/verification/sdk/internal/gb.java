package eu.bolt.verification.sdk.internal;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class gb {
    public static final View a(Activity activity) {
        Intrinsics.f(activity, "<this>");
        return activity.getWindow().getDecorView().findViewById(16908290);
    }

    public static final boolean b(View view, Rect rootViewRect, int i8) {
        Intrinsics.f(view, "<this>");
        Intrinsics.f(rootViewRect, "rootViewRect");
        view.getWindowVisibleDisplayFrame(rootViewRect);
        return view.getRootView().getBottom() - rootViewRect.bottom > i8;
    }

    public static final boolean c(Activity activity) {
        Intrinsics.f(activity, "<this>");
        int i8 = activity.getWindow().getAttributes().softInputMode & 240;
        return i8 == 16 || i8 == 0;
    }
}
