package ee.mtakso.driver.uicore.components.recyclerview.swipe;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.uicore.components.recyclerview.SwipeModel;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SwipeToDeleteCallback.kt */
/* loaded from: classes5.dex */
public final class SwipeToDeleteCallback extends ItemTouchHelper.SimpleCallback {

    /* renamed from: f  reason: collision with root package name */
    private final DiffAdapter f35385f;

    /* renamed from: g  reason: collision with root package name */
    private final Function2<Integer, SwipeModel, Unit> f35386g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SwipeToDeleteCallback(DiffAdapter diffAdapter, Function2<? super Integer, ? super SwipeModel, Unit> swipeListener) {
        super(0, 12);
        Intrinsics.f(diffAdapter, "diffAdapter");
        Intrinsics.f(swipeListener, "swipeListener");
        this.f35385f = diffAdapter;
        this.f35386g = swipeListener;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void B(RecyclerView.ViewHolder viewHolder, int i8) {
        SwipeModel swipeModel;
        Intrinsics.f(viewHolder, "viewHolder");
        int k8 = viewHolder.k();
        ListModel R = this.f35385f.R(k8);
        if (R instanceof SwipeModel) {
            swipeModel = (SwipeModel) R;
        } else {
            swipeModel = null;
        }
        if (swipeModel != null) {
            this.f35386g.s(Integer.valueOf(k8), swipeModel);
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.SimpleCallback, androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int k(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        SwipeModel swipeModel;
        Intrinsics.f(recyclerView, "recyclerView");
        Intrinsics.f(viewHolder, "viewHolder");
        ListModel R = this.f35385f.R(viewHolder.k());
        if (R instanceof SwipeModel) {
            swipeModel = (SwipeModel) R;
        } else {
            swipeModel = null;
        }
        boolean z7 = true;
        if (!((swipeModel == null || !swipeModel.a()) ? false : false)) {
            return 0;
        }
        return super.k(recyclerView, viewHolder);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean y(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        Intrinsics.f(recyclerView, "recyclerView");
        Intrinsics.f(viewHolder, "viewHolder");
        Intrinsics.f(target, "target");
        return false;
    }
}
