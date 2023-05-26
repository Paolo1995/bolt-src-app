package com.hannesdorfmann.adapterdelegates4.dsl;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewBindingListAdapterDelegateDsl.kt */
/* loaded from: classes3.dex */
public final class DslViewBindingListAdapterDelegate<I extends T, T, V extends ViewBinding> extends AbsListItemAdapterDelegate<I, T, AdapterDelegateViewBindingViewHolder<I, V>> {

    /* renamed from: a  reason: collision with root package name */
    private final Function2<LayoutInflater, ViewGroup, V> f17756a;

    /* renamed from: b  reason: collision with root package name */
    private final Function3<T, List<? extends T>, Integer, Boolean> f17757b;

    /* renamed from: c  reason: collision with root package name */
    private final Function1<AdapterDelegateViewBindingViewHolder<I, V>, Unit> f17758c;

    /* renamed from: d  reason: collision with root package name */
    private final Function1<ViewGroup, LayoutInflater> f17759d;

    /* JADX WARN: Multi-variable type inference failed */
    public DslViewBindingListAdapterDelegate(Function2<? super LayoutInflater, ? super ViewGroup, ? extends V> binding, Function3<? super T, ? super List<? extends T>, ? super Integer, Boolean> on, Function1<? super AdapterDelegateViewBindingViewHolder<I, V>, Unit> initializerBlock, Function1<? super ViewGroup, ? extends LayoutInflater> layoutInflater) {
        Intrinsics.f(binding, "binding");
        Intrinsics.f(on, "on");
        Intrinsics.f(initializerBlock, "initializerBlock");
        Intrinsics.f(layoutInflater, "layoutInflater");
        this.f17756a = binding;
        this.f17757b = on;
        this.f17758c = initializerBlock;
        this.f17759d = layoutInflater;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hannesdorfmann.adapterdelegates4.AdapterDelegate
    public boolean d(RecyclerView.ViewHolder holder) {
        Intrinsics.f(holder, "holder");
        Function0<Boolean> T = ((AdapterDelegateViewBindingViewHolder) holder).T();
        if (T == null) {
            return super.d(holder);
        }
        return T.invoke().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hannesdorfmann.adapterdelegates4.AdapterDelegate
    public void e(RecyclerView.ViewHolder holder) {
        Intrinsics.f(holder, "holder");
        Function0<Unit> U = ((AdapterDelegateViewBindingViewHolder) holder).U();
        if (U != null) {
            U.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hannesdorfmann.adapterdelegates4.AdapterDelegate
    public void f(RecyclerView.ViewHolder holder) {
        Intrinsics.f(holder, "holder");
        Function0<Unit> V = ((AdapterDelegateViewBindingViewHolder) holder).V();
        if (V != null) {
            V.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hannesdorfmann.adapterdelegates4.AdapterDelegate
    public void g(RecyclerView.ViewHolder holder) {
        Intrinsics.f(holder, "holder");
        Function0<Unit> W = ((AdapterDelegateViewBindingViewHolder) holder).W();
        if (W != null) {
            W.invoke();
        }
    }

    @Override // com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
    protected boolean h(T t7, List<T> items, int i8) {
        Intrinsics.f(items, "items");
        return this.f17757b.l(t7, items, Integer.valueOf(i8)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
    /* renamed from: l */
    public void j(I i8, AdapterDelegateViewBindingViewHolder<I, V> holder, List<Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
        if (i8 != null) {
            holder.X(i8);
            Function1<List<? extends Object>, Unit> S = holder.S();
            if (S != null) {
                S.invoke(payloads);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hannesdorfmann.adapterdelegates4.AdapterDelegate
    /* renamed from: m */
    public AdapterDelegateViewBindingViewHolder<I, V> c(ViewGroup parent) {
        Intrinsics.f(parent, "parent");
        AdapterDelegateViewBindingViewHolder<I, V> adapterDelegateViewBindingViewHolder = new AdapterDelegateViewBindingViewHolder<>(this.f17756a.s(this.f17759d.invoke(parent), parent), null, 2, null);
        this.f17758c.invoke(adapterDelegateViewBindingViewHolder);
        return adapterDelegateViewBindingViewHolder;
    }
}
