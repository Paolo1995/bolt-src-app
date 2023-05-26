package ee.mtakso.driver.uicore.components.views.swipe.states;

import android.graphics.Rect;
import android.view.View;

/* compiled from: SwipeStrategy.kt */
/* loaded from: classes5.dex */
public final class SwipeStrategyKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final float b(Rect rect, View view) {
        return Math.min(0.5f, 1 - (view.getWidth() / rect.width()));
    }
}
