package androidx.viewpager2.widget;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class FakeDrag {

    /* renamed from: a  reason: collision with root package name */
    private final ViewPager2 f8150a;

    /* renamed from: b  reason: collision with root package name */
    private final ScrollEventAdapter f8151b;

    /* renamed from: c  reason: collision with root package name */
    private final RecyclerView f8152c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FakeDrag(ViewPager2 viewPager2, ScrollEventAdapter scrollEventAdapter, RecyclerView recyclerView) {
        this.f8150a = viewPager2;
        this.f8151b = scrollEventAdapter;
        this.f8152c = recyclerView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.f8151b.i();
    }
}
