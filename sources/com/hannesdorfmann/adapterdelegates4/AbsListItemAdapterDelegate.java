package com.hannesdorfmann.adapterdelegates4;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class AbsListItemAdapterDelegate<I extends T, T, VH extends RecyclerView.ViewHolder> extends AdapterDelegate<List<T>> {
    protected abstract boolean h(@NonNull T t7, @NonNull List<T> list, int i8);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hannesdorfmann.adapterdelegates4.AdapterDelegate
    /* renamed from: i */
    public final boolean a(@NonNull List<T> list, int i8) {
        return h(list.get(i8), list, i8);
    }

    protected abstract void j(@NonNull I i8, @NonNull VH vh, @NonNull List<Object> list);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hannesdorfmann.adapterdelegates4.AdapterDelegate
    /* renamed from: k */
    public final void b(@NonNull List<T> list, int i8, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull List<Object> list2) {
        j(list.get(i8), viewHolder, list2);
    }
}
