package ee.mtakso.driver.uicore.components.recyclerview.decorations;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VerticalInsetsDecoration.kt */
/* loaded from: classes5.dex */
public final class VerticalInsetsDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private int f34836a;

    /* renamed from: b  reason: collision with root package name */
    private int f34837b;

    public VerticalInsetsDecoration() {
        this(0, 0, 3, null);
    }

    public /* synthetic */ VerticalInsetsDecoration(int i8, int i9, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? 0 : i8, (i10 & 2) != 0 ? 0 : i9);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void g(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        Intrinsics.f(outRect, "outRect");
        Intrinsics.f(view, "view");
        Intrinsics.f(parent, "parent");
        Intrinsics.f(state, "state");
        int h02 = parent.h0(view);
        if (h02 == 0) {
            outRect.top += this.f34836a;
        } else if (h02 == state.b() - 1) {
            outRect.bottom += this.f34837b;
        }
    }

    public VerticalInsetsDecoration(int i8, int i9) {
        this.f34836a = i8;
        this.f34837b = i9;
    }
}
