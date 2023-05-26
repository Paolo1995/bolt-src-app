package com.google.android.material.tabs;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class TabLayoutMediator {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final TabLayout f14280a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final ViewPager2 f14281b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f14282c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f14283d;

    /* renamed from: e  reason: collision with root package name */
    private final TabConfigurationStrategy f14284e;

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView.Adapter<?> f14285f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f14286g;

    /* renamed from: h  reason: collision with root package name */
    private TabLayoutOnPageChangeCallback f14287h;

    /* renamed from: i  reason: collision with root package name */
    private TabLayout.OnTabSelectedListener f14288i;

    /* renamed from: j  reason: collision with root package name */
    private RecyclerView.AdapterDataObserver f14289j;

    /* loaded from: classes.dex */
    private class PagerAdapterObserver extends RecyclerView.AdapterDataObserver {
        PagerAdapterObserver() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void a() {
            TabLayoutMediator.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void b(int i8, int i9) {
            TabLayoutMediator.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void c(int i8, int i9, Object obj) {
            TabLayoutMediator.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void d(int i8, int i9) {
            TabLayoutMediator.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void e(int i8, int i9, int i10) {
            TabLayoutMediator.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void f(int i8, int i9) {
            TabLayoutMediator.this.b();
        }
    }

    /* loaded from: classes.dex */
    public interface TabConfigurationStrategy {
        void a(@NonNull TabLayout.Tab tab, int i8);
    }

    /* loaded from: classes.dex */
    private static class TabLayoutOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<TabLayout> f14291a;

        /* renamed from: b  reason: collision with root package name */
        private int f14292b;

        /* renamed from: c  reason: collision with root package name */
        private int f14293c;

        TabLayoutOnPageChangeCallback(TabLayout tabLayout) {
            this.f14291a = new WeakReference<>(tabLayout);
            d();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void a(int i8) {
            this.f14292b = this.f14293c;
            this.f14293c = i8;
            TabLayout tabLayout = this.f14291a.get();
            if (tabLayout != null) {
                tabLayout.W(this.f14293c);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void b(int i8, float f8, int i9) {
            boolean z7;
            TabLayout tabLayout = this.f14291a.get();
            if (tabLayout != null) {
                int i10 = this.f14293c;
                boolean z8 = false;
                if (i10 == 2 && this.f14292b != 1) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                tabLayout.P(i8, f8, z7, (i10 == 2 && this.f14292b == 0) ? true : true);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void c(int i8) {
            boolean z7;
            TabLayout tabLayout = this.f14291a.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i8 && i8 < tabLayout.getTabCount()) {
                int i9 = this.f14293c;
                if (i9 != 0 && (i9 != 2 || this.f14292b != 0)) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                tabLayout.M(tabLayout.B(i8), z7);
            }
        }

        void d() {
            this.f14293c = 0;
            this.f14292b = 0;
        }
    }

    /* loaded from: classes.dex */
    private static class ViewPagerOnTabSelectedListener implements TabLayout.OnTabSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        private final ViewPager2 f14294a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f14295b;

        ViewPagerOnTabSelectedListener(ViewPager2 viewPager2, boolean z7) {
            this.f14294a = viewPager2;
            this.f14295b = z7;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void a(@NonNull TabLayout.Tab tab) {
            this.f14294a.j(tab.g(), this.f14295b);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void b(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void c(TabLayout.Tab tab) {
        }
    }

    public TabLayoutMediator(@NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2, @NonNull TabConfigurationStrategy tabConfigurationStrategy) {
        this(tabLayout, viewPager2, true, tabConfigurationStrategy);
    }

    public void a() {
        if (!this.f14286g) {
            RecyclerView.Adapter<?> adapter = this.f14281b.getAdapter();
            this.f14285f = adapter;
            if (adapter != null) {
                this.f14286g = true;
                TabLayoutOnPageChangeCallback tabLayoutOnPageChangeCallback = new TabLayoutOnPageChangeCallback(this.f14280a);
                this.f14287h = tabLayoutOnPageChangeCallback;
                this.f14281b.g(tabLayoutOnPageChangeCallback);
                ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener = new ViewPagerOnTabSelectedListener(this.f14281b, this.f14283d);
                this.f14288i = viewPagerOnTabSelectedListener;
                this.f14280a.h(viewPagerOnTabSelectedListener);
                if (this.f14282c) {
                    PagerAdapterObserver pagerAdapterObserver = new PagerAdapterObserver();
                    this.f14289j = pagerAdapterObserver;
                    this.f14285f.M(pagerAdapterObserver);
                }
                b();
                this.f14280a.O(this.f14281b.getCurrentItem(), 0.0f, true);
                return;
            }
            throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
        }
        throw new IllegalStateException("TabLayoutMediator is already attached");
    }

    void b() {
        this.f14280a.H();
        RecyclerView.Adapter<?> adapter = this.f14285f;
        if (adapter != null) {
            int r7 = adapter.r();
            for (int i8 = 0; i8 < r7; i8++) {
                TabLayout.Tab E = this.f14280a.E();
                this.f14284e.a(E, i8);
                this.f14280a.k(E, false);
            }
            if (r7 > 0) {
                int min = Math.min(this.f14281b.getCurrentItem(), this.f14280a.getTabCount() - 1);
                if (min != this.f14280a.getSelectedTabPosition()) {
                    TabLayout tabLayout = this.f14280a;
                    tabLayout.L(tabLayout.B(min));
                }
            }
        }
    }

    public TabLayoutMediator(@NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2, boolean z7, @NonNull TabConfigurationStrategy tabConfigurationStrategy) {
        this(tabLayout, viewPager2, z7, true, tabConfigurationStrategy);
    }

    public TabLayoutMediator(@NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2, boolean z7, boolean z8, @NonNull TabConfigurationStrategy tabConfigurationStrategy) {
        this.f14280a = tabLayout;
        this.f14281b = viewPager2;
        this.f14282c = z7;
        this.f14283d = z8;
        this.f14284e = tabConfigurationStrategy;
    }
}
