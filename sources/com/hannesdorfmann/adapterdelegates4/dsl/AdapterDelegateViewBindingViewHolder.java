package com.hannesdorfmann.adapterdelegates4.dsl;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewBindingListAdapterDelegateDsl.kt */
/* loaded from: classes3.dex */
public final class AdapterDelegateViewBindingViewHolder<T, V extends ViewBinding> extends RecyclerView.ViewHolder {
    private Function0<Unit> A;
    private Function0<Unit> B;

    /* renamed from: u  reason: collision with root package name */
    private final V f17749u;

    /* renamed from: v  reason: collision with root package name */
    private Object f17750v;

    /* renamed from: w  reason: collision with root package name */
    private final Context f17751w;

    /* renamed from: x  reason: collision with root package name */
    private Function1<? super List<? extends Object>, Unit> f17752x;

    /* renamed from: y  reason: collision with root package name */
    private Function0<Unit> f17753y;

    /* renamed from: z  reason: collision with root package name */
    private Function0<Boolean> f17754z;

    /* compiled from: ViewBindingListAdapterDelegateDsl.kt */
    /* loaded from: classes3.dex */
    private static final class Uninitialized {

        /* renamed from: a  reason: collision with root package name */
        public static final Uninitialized f17755a = new Uninitialized();

        private Uninitialized() {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ AdapterDelegateViewBindingViewHolder(androidx.viewbinding.ViewBinding r1, android.view.View r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r3 = r3 & 2
            if (r3 == 0) goto Ld
            android.view.View r2 = r1.getRoot()
            java.lang.String r3 = "class AdapterDelegateVie…romWindow = block\n    }\n}"
            kotlin.jvm.internal.Intrinsics.e(r2, r3)
        Ld:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hannesdorfmann.adapterdelegates4.dsl.AdapterDelegateViewBindingViewHolder.<init>(androidx.viewbinding.ViewBinding, android.view.View, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final void O(Function1<? super List<? extends Object>, Unit> bindingBlock) {
        Intrinsics.f(bindingBlock, "bindingBlock");
        if (this.f17752x == null) {
            this.f17752x = bindingBlock;
            return;
        }
        throw new IllegalStateException("bind { ... } is already defined. Only one bind { ... } is allowed.");
    }

    public final V P() {
        return this.f17749u;
    }

    public final Context Q() {
        return this.f17751w;
    }

    public final T R() {
        T t7 = (T) this.f17750v;
        if (t7 != Uninitialized.f17755a) {
            return t7;
        }
        throw new IllegalArgumentException("Item has not been set yet. That is an internal issue. Please report at https://github.com/sockeqwe/AdapterDelegates");
    }

    public final Function1<List<? extends Object>, Unit> S() {
        return this.f17752x;
    }

    public final Function0<Boolean> T() {
        return this.f17754z;
    }

    public final Function0<Unit> U() {
        return this.A;
    }

    public final Function0<Unit> V() {
        return this.B;
    }

    public final Function0<Unit> W() {
        return this.f17753y;
    }

    public final void X(Object obj) {
        Intrinsics.f(obj, "<set-?>");
        this.f17750v = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdapterDelegateViewBindingViewHolder(V binding, View view) {
        super(view);
        Intrinsics.f(binding, "binding");
        Intrinsics.f(view, "view");
        this.f17749u = binding;
        this.f17750v = Uninitialized.f17755a;
        Context context = view.getContext();
        Intrinsics.e(context, "view.context");
        this.f17751w = context;
    }
}
