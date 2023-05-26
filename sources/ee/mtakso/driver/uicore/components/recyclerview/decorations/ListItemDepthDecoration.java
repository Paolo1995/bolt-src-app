package ee.mtakso.driver.uicore.components.recyclerview.decorations;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.LocaleExtKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ListItemDepthDecoration.kt */
/* loaded from: classes5.dex */
public class ListItemDepthDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private final int f34826a;

    public ListItemDepthDecoration(int i8) {
        this.f34826a = i8;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void g(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        DiffAdapter diffAdapter;
        int h02;
        Intrinsics.f(outRect, "outRect");
        Intrinsics.f(view, "view");
        Intrinsics.f(parent, "parent");
        Intrinsics.f(state, "state");
        super.g(outRect, view, parent, state);
        RecyclerView.Adapter adapter = parent.getAdapter();
        DepthModel depthModel = null;
        if (adapter instanceof DiffAdapter) {
            diffAdapter = (DiffAdapter) adapter;
        } else {
            diffAdapter = null;
        }
        if (diffAdapter == null || (h02 = parent.h0(view)) == -1) {
            return;
        }
        ListModel R = diffAdapter.R(h02);
        if (R instanceof DepthModel) {
            depthModel = (DepthModel) R;
        }
        if (depthModel == null) {
            return;
        }
        if (LocaleExtKt.a()) {
            outRect.left = this.f34826a * depthModel.getDepth();
        } else {
            outRect.right = this.f34826a * depthModel.getDepth();
        }
    }
}
