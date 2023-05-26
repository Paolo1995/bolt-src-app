package ee.mtakso.driver.uikit.recyclerview;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DiffAdapter.kt */
/* loaded from: classes5.dex */
public final class DiffAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: d */
    private final AsyncListDiffer<ListModel> f35985d = new AsyncListDiffer<>(this, new ListModelDiffUtil());

    /* renamed from: e */
    private final List<DiffAdapterDelegate<?, ?>> f35986e = new ArrayList();

    private final DiffAdapterDelegate<?, ?> S(int i8) {
        Object obj;
        boolean z7;
        Iterator<T> it = this.f35986e.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((DiffAdapterDelegate) obj).e() == i8) {
                    z7 = true;
                    continue;
                } else {
                    z7 = false;
                    continue;
                }
                if (z7) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        DiffAdapterDelegate<?, ?> diffAdapterDelegate = (DiffAdapterDelegate) obj;
        if (diffAdapterDelegate != null) {
            return diffAdapterDelegate;
        }
        throw new IllegalStateException("Cannot find delegate for a viewtype " + i8);
    }

    public static /* synthetic */ void V(DiffAdapter diffAdapter, List list, Runnable runnable, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            runnable = null;
        }
        diffAdapter.U(list, runnable);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void E(RecyclerView.ViewHolder holder, int i8) {
        Intrinsics.f(holder, "holder");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void F(RecyclerView.ViewHolder holder, int i8, List<Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
        ListModel listModel = this.f35985d.a().get(i8);
        Intrinsics.e(listModel, "asyncListDiffer.currentList[position]");
        DiffAdapterDelegate<?, ?> T = T(listModel);
        if (payloads.isEmpty()) {
            ListModel listModel2 = this.f35985d.a().get(i8);
            Intrinsics.e(listModel2, "asyncListDiffer.currentList[position]");
            T.h(holder, listModel2);
            return;
        }
        T.j(holder, payloads);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder G(ViewGroup parent, int i8) {
        Intrinsics.f(parent, "parent");
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        DiffAdapterDelegate<?, ?> S = S(i8);
        Intrinsics.e(inflater, "inflater");
        RecyclerView.ViewHolder k8 = S.k(inflater, parent);
        S.q(k8);
        return k8;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void L(RecyclerView.ViewHolder holder) {
        Intrinsics.f(holder, "holder");
        int l8 = holder.l();
        if (l8 > -1 && l8 < r()) {
            ListModel model = this.f35985d.a().get(l8);
            Intrinsics.e(model, "model");
            T(model).o(holder, model);
        }
        S(holder.n()).n(holder);
        super.L(holder);
    }

    public final DiffAdapter P(DiffAdapterDelegate<?, ?> delegate) {
        Intrinsics.f(delegate, "delegate");
        delegate.b(this);
        this.f35986e.add(delegate);
        return this;
    }

    public final void Q() {
        this.f35985d.d(null);
    }

    public final ListModel R(int i8) {
        Object Z;
        List<ListModel> a8 = this.f35985d.a();
        Intrinsics.e(a8, "asyncListDiffer.currentList");
        Z = CollectionsKt___CollectionsKt.Z(a8, i8);
        return (ListModel) Z;
    }

    public final DiffAdapterDelegate<?, ?> T(ListModel model) {
        Object obj;
        Intrinsics.f(model, "model");
        Iterator<T> it = this.f35986e.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((DiffAdapterDelegate) obj).f(model)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        DiffAdapterDelegate<?, ?> diffAdapterDelegate = (DiffAdapterDelegate) obj;
        if (diffAdapterDelegate != null) {
            return diffAdapterDelegate;
        }
        throw new IllegalStateException("Cannot find delegate for a required item " + model);
    }

    public final void U(List<? extends ListModel> newModels, Runnable runnable) {
        Intrinsics.f(newModels, "newModels");
        this.f35985d.e(newModels, runnable);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int r() {
        return this.f35985d.a().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int t(int i8) {
        ListModel listModel = this.f35985d.a().get(i8);
        Intrinsics.e(listModel, "asyncListDiffer.currentList[position]");
        return T(listModel).e();
    }
}
