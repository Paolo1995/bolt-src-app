package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class AdapterListUpdateCallback implements ListUpdateCallback {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final RecyclerView.Adapter f6901a;

    public AdapterListUpdateCallback(@NonNull RecyclerView.Adapter adapter) {
        this.f6901a = adapter;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void a(int i8, int i9) {
        this.f6901a.A(i8, i9);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void b(int i8, int i9) {
        this.f6901a.B(i8, i9);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void c(int i8, int i9, Object obj) {
        this.f6901a.z(i8, i9, obj);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void d(int i8, int i9) {
        this.f6901a.y(i8, i9);
    }
}
