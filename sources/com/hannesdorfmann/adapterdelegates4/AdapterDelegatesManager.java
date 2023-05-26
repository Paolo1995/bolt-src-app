package com.hannesdorfmann.adapterdelegates4;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.collection.SparseArrayCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class AdapterDelegatesManager<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final List<Object> f17744c = Collections.emptyList();

    /* renamed from: a  reason: collision with root package name */
    protected SparseArrayCompat<AdapterDelegate<T>> f17745a = new SparseArrayCompat<>();

    /* renamed from: b  reason: collision with root package name */
    protected AdapterDelegate<T> f17746b;

    public AdapterDelegatesManager() {
    }

    public AdapterDelegatesManager<T> a(int i8, boolean z7, @NonNull AdapterDelegate<T> adapterDelegate) {
        if (adapterDelegate != null) {
            if (i8 != 2147483646) {
                if (!z7 && this.f17745a.e(i8) != null) {
                    throw new IllegalArgumentException("An AdapterDelegate is already registered for the viewType = " + i8 + ". Already registered AdapterDelegate is " + this.f17745a.e(i8));
                }
                this.f17745a.j(i8, adapterDelegate);
                return this;
            }
            throw new IllegalArgumentException("The view type = 2147483646 is reserved for fallback adapter delegate (see setFallbackDelegate() ). Please use another view type.");
        }
        throw new NullPointerException("AdapterDelegate is null!");
    }

    public AdapterDelegatesManager<T> b(@NonNull AdapterDelegate<T> adapterDelegate) {
        int k8 = this.f17745a.k();
        while (this.f17745a.e(k8) != null) {
            k8++;
            if (k8 == 2147483646) {
                throw new IllegalArgumentException("Oops, we are very close to Integer.MAX_VALUE. It seems that there are no more free and unused view type integers left to add another AdapterDelegate.");
            }
        }
        return a(k8, false, adapterDelegate);
    }

    public AdapterDelegate<T> c(int i8) {
        return this.f17745a.f(i8, this.f17746b);
    }

    public int d(@NonNull T t7, int i8) {
        String str;
        if (t7 != null) {
            int k8 = this.f17745a.k();
            for (int i9 = 0; i9 < k8; i9++) {
                if (this.f17745a.l(i9).a(t7, i8)) {
                    return this.f17745a.i(i9);
                }
            }
            if (this.f17746b != null) {
                return 2147483646;
            }
            if (t7 instanceof List) {
                str = "No AdapterDelegate added that matches item=" + ((List) t7).get(i8).toString() + " at position=" + i8 + " in data source";
            } else {
                str = "No AdapterDelegate added for item at position=" + i8 + ". items=" + t7;
            }
            throw new NullPointerException(str);
        }
        throw new NullPointerException("Items datasource is null!");
    }

    public void e(@NonNull T t7, int i8, @NonNull RecyclerView.ViewHolder viewHolder, List list) {
        AdapterDelegate<T> c8 = c(viewHolder.n());
        if (c8 != null) {
            if (list == null) {
                list = f17744c;
            }
            c8.b(t7, i8, viewHolder, list);
            return;
        }
        throw new NullPointerException("No delegate found for item at position = " + i8 + " for viewType = " + viewHolder.n());
    }

    @NonNull
    public RecyclerView.ViewHolder f(@NonNull ViewGroup viewGroup, int i8) {
        AdapterDelegate<T> c8 = c(i8);
        if (c8 != null) {
            RecyclerView.ViewHolder c9 = c8.c(viewGroup);
            if (c9 != null) {
                return c9;
            }
            throw new NullPointerException("ViewHolder returned from AdapterDelegate " + c8 + " for ViewType =" + i8 + " is null!");
        }
        throw new NullPointerException("No AdapterDelegate added for ViewType " + i8);
    }

    public boolean g(@NonNull RecyclerView.ViewHolder viewHolder) {
        AdapterDelegate<T> c8 = c(viewHolder.n());
        if (c8 != null) {
            return c8.d(viewHolder);
        }
        throw new NullPointerException("No delegate found for " + viewHolder + " for item at position = " + viewHolder.k() + " for viewType = " + viewHolder.n());
    }

    public void h(@NonNull RecyclerView.ViewHolder viewHolder) {
        AdapterDelegate<T> c8 = c(viewHolder.n());
        if (c8 != null) {
            c8.e(viewHolder);
            return;
        }
        throw new NullPointerException("No delegate found for " + viewHolder + " for item at position = " + viewHolder.k() + " for viewType = " + viewHolder.n());
    }

    public void i(@NonNull RecyclerView.ViewHolder viewHolder) {
        AdapterDelegate<T> c8 = c(viewHolder.n());
        if (c8 != null) {
            c8.f(viewHolder);
            return;
        }
        throw new NullPointerException("No delegate found for " + viewHolder + " for item at position = " + viewHolder.k() + " for viewType = " + viewHolder.n());
    }

    public void j(@NonNull RecyclerView.ViewHolder viewHolder) {
        AdapterDelegate<T> c8 = c(viewHolder.n());
        if (c8 != null) {
            c8.g(viewHolder);
            return;
        }
        throw new NullPointerException("No delegate found for " + viewHolder + " for item at position = " + viewHolder.k() + " for viewType = " + viewHolder.n());
    }

    public AdapterDelegatesManager(@NonNull AdapterDelegate<T>... adapterDelegateArr) {
        for (AdapterDelegate<T> adapterDelegate : adapterDelegateArr) {
            b(adapterDelegate);
        }
    }
}
