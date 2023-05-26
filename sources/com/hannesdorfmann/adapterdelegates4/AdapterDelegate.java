package com.hannesdorfmann.adapterdelegates4;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class AdapterDelegate<T> {
    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean a(@NonNull T t7, int i8);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void b(@NonNull T t7, int i8, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull List<Object> list);

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public abstract RecyclerView.ViewHolder c(@NonNull ViewGroup viewGroup);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d(@NonNull RecyclerView.ViewHolder viewHolder) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(@NonNull RecyclerView.ViewHolder viewHolder) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(@NonNull RecyclerView.ViewHolder viewHolder) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(@NonNull RecyclerView.ViewHolder viewHolder) {
    }
}
