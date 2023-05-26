package ee.mtakso.driver.ui.views;

import android.view.View;

/* compiled from: LinearSnapRecyclerView.kt */
/* loaded from: classes5.dex */
public final class LinearSnapRecyclerViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int c(View view) {
        if (view == null) {
            return 0;
        }
        return (view.getLeft() + view.getRight()) / 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int d(View view) {
        if (view == null) {
            return 0;
        }
        return (view.getTop() + view.getBottom()) / 2;
    }
}
