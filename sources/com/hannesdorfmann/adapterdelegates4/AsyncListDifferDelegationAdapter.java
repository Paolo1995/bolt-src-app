package com.hannesdorfmann.adapterdelegates4;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: classes3.dex */
public class AsyncListDifferDelegationAdapter<T> extends RecyclerView.Adapter {

    /* renamed from: d  reason: collision with root package name */
    protected final AdapterDelegatesManager<List<T>> f17747d;

    /* renamed from: e  reason: collision with root package name */
    protected final AsyncListDiffer<T> f17748e;

    public AsyncListDifferDelegationAdapter(@NonNull DiffUtil.ItemCallback<T> itemCallback) {
        this(itemCallback, new AdapterDelegatesManager());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void E(@NonNull RecyclerView.ViewHolder viewHolder, int i8) {
        this.f17747d.e(this.f17748e.a(), i8, viewHolder, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void F(@NonNull RecyclerView.ViewHolder viewHolder, int i8, @NonNull List list) {
        this.f17747d.e(this.f17748e.a(), i8, viewHolder, list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder G(@NonNull ViewGroup viewGroup, int i8) {
        return this.f17747d.f(viewGroup, i8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean I(@NonNull RecyclerView.ViewHolder viewHolder) {
        return this.f17747d.g(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void J(@NonNull RecyclerView.ViewHolder viewHolder) {
        this.f17747d.h(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void K(@NonNull RecyclerView.ViewHolder viewHolder) {
        this.f17747d.i(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void L(@NonNull RecyclerView.ViewHolder viewHolder) {
        this.f17747d.j(viewHolder);
    }

    public List<T> P() {
        return this.f17748e.a();
    }

    public void Q(List<T> list) {
        this.f17748e.d(list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int r() {
        return this.f17748e.a().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int t(int i8) {
        return this.f17747d.d(this.f17748e.a(), i8);
    }

    public AsyncListDifferDelegationAdapter(@NonNull DiffUtil.ItemCallback<T> itemCallback, @NonNull AdapterDelegatesManager<List<T>> adapterDelegatesManager) {
        if (itemCallback == null) {
            throw new NullPointerException("ItemCallback is null");
        }
        if (adapterDelegatesManager != null) {
            this.f17748e = new AsyncListDiffer<>(this, itemCallback);
            this.f17747d = adapterDelegatesManager;
            return;
        }
        throw new NullPointerException("AdapterDelegatesManager is null");
    }

    public AsyncListDifferDelegationAdapter(@NonNull DiffUtil.ItemCallback<T> itemCallback, @NonNull AdapterDelegate<List<T>>... adapterDelegateArr) {
        if (itemCallback != null) {
            this.f17748e = new AsyncListDiffer<>(this, itemCallback);
            this.f17747d = new AdapterDelegatesManager<>(adapterDelegateArr);
            return;
        }
        throw new NullPointerException("ItemCallback is null");
    }
}
