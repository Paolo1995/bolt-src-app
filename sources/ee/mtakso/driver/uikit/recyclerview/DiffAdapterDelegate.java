package ee.mtakso.driver.uikit.recyclerview;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DiffAdapterDelegate.kt */
/* loaded from: classes5.dex */
public abstract class DiffAdapterDelegate<VH extends RecyclerView.ViewHolder, LM extends ListModel> {

    /* renamed from: a  reason: collision with root package name */
    protected DiffAdapter f35987a;

    public final void b(DiffAdapter adapter) {
        Intrinsics.f(adapter, "adapter");
        r(adapter);
    }

    protected final DiffAdapter c() {
        DiffAdapter diffAdapter = this.f35987a;
        if (diffAdapter != null) {
            return diffAdapter;
        }
        Intrinsics.w("adapter");
        return null;
    }

    public final LM d(VH holder) {
        Intrinsics.f(holder, "holder");
        LM lm = (LM) c().R(holder.k());
        Intrinsics.d(lm, "null cannot be cast to non-null type LM of ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate");
        return lm;
    }

    public abstract int e();

    public abstract boolean f(ListModel listModel);

    public abstract void g(VH vh, LM lm);

    /* JADX WARN: Multi-variable type inference failed */
    public final void h(RecyclerView.ViewHolder holder, ListModel model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        g(holder, model);
    }

    public abstract void i(VH vh, List<? extends Object> list);

    /* JADX WARN: Multi-variable type inference failed */
    public final void j(RecyclerView.ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
        i(holder, payloads);
    }

    public abstract RecyclerView.ViewHolder k(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public void l(VH holder) {
        Intrinsics.f(holder, "holder");
    }

    public void m(VH holder, LM model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void n(RecyclerView.ViewHolder holder) {
        Intrinsics.f(holder, "holder");
        l(holder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void o(RecyclerView.ViewHolder holder, ListModel model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        m(holder, model);
    }

    public void p(VH holder) {
        Intrinsics.f(holder, "holder");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void q(RecyclerView.ViewHolder holder) {
        Intrinsics.f(holder, "holder");
        p(holder);
    }

    protected final void r(DiffAdapter diffAdapter) {
        Intrinsics.f(diffAdapter, "<set-?>");
        this.f35987a = diffAdapter;
    }
}
