package ee.mtakso.driver.uikit.widgets.gridlayout;

import android.graphics.Rect;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SpannedGridLayoutManager.kt */
/* loaded from: classes5.dex */
public final class SpannedGridLayoutManagerKt {
    public static final boolean a(Rect rect, Rect rect2) {
        Intrinsics.f(rect, "<this>");
        Intrinsics.f(rect2, "rect");
        return rect.intersects(rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    public static final boolean b(Rect rect, Rect rect2) {
        Intrinsics.f(rect, "<this>");
        Intrinsics.f(rect2, "rect");
        if (rect.right != rect2.left && rect.top != rect2.bottom && rect.left != rect2.right && rect.bottom != rect2.top) {
            return false;
        }
        return true;
    }
}
