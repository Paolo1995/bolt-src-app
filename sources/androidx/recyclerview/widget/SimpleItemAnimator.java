package androidx.recyclerview.widget;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class SimpleItemAnimator extends RecyclerView.ItemAnimator {

    /* renamed from: g  reason: collision with root package name */
    boolean f7355g = true;

    public abstract boolean A(RecyclerView.ViewHolder viewHolder);

    public final void B(RecyclerView.ViewHolder viewHolder) {
        J(viewHolder);
        h(viewHolder);
    }

    public final void C(RecyclerView.ViewHolder viewHolder) {
        K(viewHolder);
    }

    public final void D(RecyclerView.ViewHolder viewHolder, boolean z7) {
        L(viewHolder, z7);
        h(viewHolder);
    }

    public final void E(RecyclerView.ViewHolder viewHolder, boolean z7) {
        M(viewHolder, z7);
    }

    public final void F(RecyclerView.ViewHolder viewHolder) {
        N(viewHolder);
        h(viewHolder);
    }

    public final void G(RecyclerView.ViewHolder viewHolder) {
        O(viewHolder);
    }

    public final void H(RecyclerView.ViewHolder viewHolder) {
        P(viewHolder);
        h(viewHolder);
    }

    public final void I(RecyclerView.ViewHolder viewHolder) {
        Q(viewHolder);
    }

    public void J(RecyclerView.ViewHolder viewHolder) {
    }

    public void K(RecyclerView.ViewHolder viewHolder) {
    }

    public void L(RecyclerView.ViewHolder viewHolder, boolean z7) {
    }

    public void M(RecyclerView.ViewHolder viewHolder, boolean z7) {
    }

    public void N(RecyclerView.ViewHolder viewHolder) {
    }

    public void O(RecyclerView.ViewHolder viewHolder) {
    }

    public void P(RecyclerView.ViewHolder viewHolder) {
    }

    public void Q(RecyclerView.ViewHolder viewHolder) {
    }

    public void R(boolean z7) {
        this.f7355g = z7;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean a(@NonNull RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i8;
        int i9;
        if (itemHolderInfo != null && ((i8 = itemHolderInfo.f7242a) != (i9 = itemHolderInfo2.f7242a) || itemHolderInfo.f7243b != itemHolderInfo2.f7243b)) {
            return z(viewHolder, i8, itemHolderInfo.f7243b, i9, itemHolderInfo2.f7243b);
        }
        return x(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean b(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i8;
        int i9;
        int i10 = itemHolderInfo.f7242a;
        int i11 = itemHolderInfo.f7243b;
        if (viewHolder2.L()) {
            int i12 = itemHolderInfo.f7242a;
            i9 = itemHolderInfo.f7243b;
            i8 = i12;
        } else {
            i8 = itemHolderInfo2.f7242a;
            i9 = itemHolderInfo2.f7243b;
        }
        return y(viewHolder, viewHolder2, i10, i11, i8, i9);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean c(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i8;
        int i9;
        int i10 = itemHolderInfo.f7242a;
        int i11 = itemHolderInfo.f7243b;
        View view = viewHolder.f7332a;
        if (itemHolderInfo2 == null) {
            i8 = view.getLeft();
        } else {
            i8 = itemHolderInfo2.f7242a;
        }
        int i12 = i8;
        if (itemHolderInfo2 == null) {
            i9 = view.getTop();
        } else {
            i9 = itemHolderInfo2.f7243b;
        }
        int i13 = i9;
        if (!viewHolder.x() && (i10 != i12 || i11 != i13)) {
            view.layout(i12, i13, view.getWidth() + i12, view.getHeight() + i13);
            return z(viewHolder, i10, i11, i12, i13);
        }
        return A(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean d(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i8 = itemHolderInfo.f7242a;
        int i9 = itemHolderInfo2.f7242a;
        if (i8 == i9 && itemHolderInfo.f7243b == itemHolderInfo2.f7243b) {
            F(viewHolder);
            return false;
        }
        return z(viewHolder, i8, itemHolderInfo.f7243b, i9, itemHolderInfo2.f7243b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean f(@NonNull RecyclerView.ViewHolder viewHolder) {
        if (this.f7355g && !viewHolder.v()) {
            return false;
        }
        return true;
    }

    public abstract boolean x(RecyclerView.ViewHolder viewHolder);

    public abstract boolean y(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i8, int i9, int i10, int i11);

    public abstract boolean z(RecyclerView.ViewHolder viewHolder, int i8, int i9, int i10, int i11);
}
