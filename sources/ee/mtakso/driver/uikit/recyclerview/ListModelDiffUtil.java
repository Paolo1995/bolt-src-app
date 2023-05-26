package ee.mtakso.driver.uikit.recyclerview;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ListModelDiffUtil.kt */
/* loaded from: classes5.dex */
public final class ListModelDiffUtil extends DiffUtil.ItemCallback<ListModel> {
    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    /* renamed from: d */
    public boolean a(ListModel oldItem, ListModel newItem) {
        Intrinsics.f(oldItem, "oldItem");
        Intrinsics.f(newItem, "newItem");
        return Intrinsics.a(oldItem, newItem);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    /* renamed from: e */
    public boolean b(ListModel oldItem, ListModel newItem) {
        Intrinsics.f(oldItem, "oldItem");
        Intrinsics.f(newItem, "newItem");
        return Intrinsics.a(oldItem.m(), newItem.m());
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    /* renamed from: f */
    public Object c(ListModel oldItem, ListModel newItem) {
        Intrinsics.f(oldItem, "oldItem");
        Intrinsics.f(newItem, "newItem");
        return newItem.l(oldItem);
    }
}
