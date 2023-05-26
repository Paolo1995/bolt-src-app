package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.collection.ArraySet;
import androidx.collection.LongSparseArray;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* loaded from: classes.dex */
public abstract class FragmentStateAdapter extends RecyclerView.Adapter<FragmentViewHolder> implements StatefulAdapter {

    /* renamed from: d  reason: collision with root package name */
    final Lifecycle f8117d;

    /* renamed from: e  reason: collision with root package name */
    final FragmentManager f8118e;

    /* renamed from: f  reason: collision with root package name */
    final LongSparseArray<Fragment> f8119f;

    /* renamed from: g  reason: collision with root package name */
    private final LongSparseArray<Fragment.SavedState> f8120g;

    /* renamed from: h  reason: collision with root package name */
    private final LongSparseArray<Integer> f8121h;

    /* renamed from: i  reason: collision with root package name */
    private FragmentMaxLifecycleEnforcer f8122i;

    /* renamed from: j  reason: collision with root package name */
    boolean f8123j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f8124k;

    /* loaded from: classes.dex */
    private static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
        private DataSetChangeObserver() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public abstract void a();

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void b(int i8, int i9) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void c(int i8, int i9, Object obj) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void d(int i8, int i9) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void e(int i8, int i9, int i10) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void f(int i8, int i9) {
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class FragmentMaxLifecycleEnforcer {

        /* renamed from: a  reason: collision with root package name */
        private ViewPager2.OnPageChangeCallback f8137a;

        /* renamed from: b  reason: collision with root package name */
        private RecyclerView.AdapterDataObserver f8138b;

        /* renamed from: c  reason: collision with root package name */
        private LifecycleEventObserver f8139c;

        /* renamed from: d  reason: collision with root package name */
        private ViewPager2 f8140d;

        /* renamed from: e  reason: collision with root package name */
        private long f8141e = -1;

        FragmentMaxLifecycleEnforcer() {
        }

        @NonNull
        private ViewPager2 a(@NonNull RecyclerView recyclerView) {
            ViewParent parent = recyclerView.getParent();
            if (parent instanceof ViewPager2) {
                return (ViewPager2) parent;
            }
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
        }

        void b(@NonNull RecyclerView recyclerView) {
            this.f8140d = a(recyclerView);
            ViewPager2.OnPageChangeCallback onPageChangeCallback = new ViewPager2.OnPageChangeCallback() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.1
                @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                public void a(int i8) {
                    FragmentMaxLifecycleEnforcer.this.d(false);
                }

                @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                public void c(int i8) {
                    FragmentMaxLifecycleEnforcer.this.d(false);
                }
            };
            this.f8137a = onPageChangeCallback;
            this.f8140d.g(onPageChangeCallback);
            DataSetChangeObserver dataSetChangeObserver = new DataSetChangeObserver() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.2
                @Override // androidx.viewpager2.adapter.FragmentStateAdapter.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
                public void a() {
                    FragmentMaxLifecycleEnforcer.this.d(true);
                }
            };
            this.f8138b = dataSetChangeObserver;
            FragmentStateAdapter.this.M(dataSetChangeObserver);
            LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.3
                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                    FragmentMaxLifecycleEnforcer.this.d(false);
                }
            };
            this.f8139c = lifecycleEventObserver;
            FragmentStateAdapter.this.f8117d.a(lifecycleEventObserver);
        }

        void c(@NonNull RecyclerView recyclerView) {
            a(recyclerView).n(this.f8137a);
            FragmentStateAdapter.this.O(this.f8138b);
            FragmentStateAdapter.this.f8117d.c(this.f8139c);
            this.f8140d = null;
        }

        void d(boolean z7) {
            int currentItem;
            Fragment f8;
            boolean z8;
            if (FragmentStateAdapter.this.i0() || this.f8140d.getScrollState() != 0 || FragmentStateAdapter.this.f8119f.j() || FragmentStateAdapter.this.r() == 0 || (currentItem = this.f8140d.getCurrentItem()) >= FragmentStateAdapter.this.r()) {
                return;
            }
            long s7 = FragmentStateAdapter.this.s(currentItem);
            if ((s7 != this.f8141e || z7) && (f8 = FragmentStateAdapter.this.f8119f.f(s7)) != null && f8.isAdded()) {
                this.f8141e = s7;
                FragmentTransaction beginTransaction = FragmentStateAdapter.this.f8118e.beginTransaction();
                Fragment fragment = null;
                for (int i8 = 0; i8 < FragmentStateAdapter.this.f8119f.o(); i8++) {
                    long k8 = FragmentStateAdapter.this.f8119f.k(i8);
                    Fragment p8 = FragmentStateAdapter.this.f8119f.p(i8);
                    if (p8.isAdded()) {
                        if (k8 != this.f8141e) {
                            beginTransaction.setMaxLifecycle(p8, Lifecycle.State.STARTED);
                        } else {
                            fragment = p8;
                        }
                        if (k8 == this.f8141e) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        p8.setMenuVisibility(z8);
                    }
                }
                if (fragment != null) {
                    beginTransaction.setMaxLifecycle(fragment, Lifecycle.State.RESUMED);
                }
                if (!beginTransaction.isEmpty()) {
                    beginTransaction.commitNow();
                }
            }
        }
    }

    public FragmentStateAdapter(@NonNull FragmentActivity fragmentActivity) {
        this(fragmentActivity.getSupportFragmentManager(), fragmentActivity.getLifecycle());
    }

    @NonNull
    private static String S(@NonNull String str, long j8) {
        return str + j8;
    }

    private void T(int i8) {
        long s7 = s(i8);
        if (!this.f8119f.d(s7)) {
            Fragment R = R(i8);
            R.setInitialSavedState(this.f8120g.f(s7));
            this.f8119f.l(s7, R);
        }
    }

    private boolean V(long j8) {
        View view;
        if (this.f8121h.d(j8)) {
            return true;
        }
        Fragment f8 = this.f8119f.f(j8);
        if (f8 != null && (view = f8.getView()) != null && view.getParent() != null) {
            return true;
        }
        return false;
    }

    private static boolean W(@NonNull String str, @NonNull String str2) {
        if (str.startsWith(str2) && str.length() > str2.length()) {
            return true;
        }
        return false;
    }

    private Long X(int i8) {
        Long l8 = null;
        for (int i9 = 0; i9 < this.f8121h.o(); i9++) {
            if (this.f8121h.p(i9).intValue() == i8) {
                if (l8 == null) {
                    l8 = Long.valueOf(this.f8121h.k(i9));
                } else {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
            }
        }
        return l8;
    }

    private static long d0(@NonNull String str, @NonNull String str2) {
        return Long.parseLong(str.substring(str2.length()));
    }

    private void f0(long j8) {
        ViewParent parent;
        Fragment f8 = this.f8119f.f(j8);
        if (f8 == null) {
            return;
        }
        if (f8.getView() != null && (parent = f8.getView().getParent()) != null) {
            ((FrameLayout) parent).removeAllViews();
        }
        if (!Q(j8)) {
            this.f8120g.m(j8);
        }
        if (!f8.isAdded()) {
            this.f8119f.m(j8);
        } else if (i0()) {
            this.f8124k = true;
        } else {
            if (f8.isAdded() && Q(j8)) {
                this.f8120g.l(j8, this.f8118e.saveFragmentInstanceState(f8));
            }
            this.f8118e.beginTransaction().remove(f8).commitNow();
            this.f8119f.m(j8);
        }
    }

    private void g0() {
        final Handler handler = new Handler(Looper.getMainLooper());
        final Runnable runnable = new Runnable() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.4
            @Override // java.lang.Runnable
            public void run() {
                FragmentStateAdapter fragmentStateAdapter = FragmentStateAdapter.this;
                fragmentStateAdapter.f8123j = false;
                fragmentStateAdapter.U();
            }
        };
        this.f8117d.a(new LifecycleEventObserver() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.5
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    handler.removeCallbacks(runnable);
                    lifecycleOwner.getLifecycle().c(this);
                }
            }
        });
        handler.postDelayed(runnable, 10000L);
    }

    private void h0(final Fragment fragment, @NonNull final FrameLayout frameLayout) {
        this.f8118e.registerFragmentLifecycleCallbacks(new FragmentManager.FragmentLifecycleCallbacks() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.3
            @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
            public void onFragmentViewCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment2, @NonNull View view, Bundle bundle) {
                if (fragment2 == fragment) {
                    fragmentManager.unregisterFragmentLifecycleCallbacks(this);
                    FragmentStateAdapter.this.P(view, frameLayout);
                }
            }
        }, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void D(@NonNull RecyclerView recyclerView) {
        boolean z7;
        if (this.f8122i == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        Preconditions.a(z7);
        FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer = new FragmentMaxLifecycleEnforcer();
        this.f8122i = fragmentMaxLifecycleEnforcer;
        fragmentMaxLifecycleEnforcer.b(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void H(@NonNull RecyclerView recyclerView) {
        this.f8122i.c(recyclerView);
        this.f8122i = null;
    }

    void P(@NonNull View view, @NonNull FrameLayout frameLayout) {
        if (frameLayout.getChildCount() <= 1) {
            if (view.getParent() == frameLayout) {
                return;
            }
            if (frameLayout.getChildCount() > 0) {
                frameLayout.removeAllViews();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            frameLayout.addView(view);
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    public boolean Q(long j8) {
        if (j8 >= 0 && j8 < r()) {
            return true;
        }
        return false;
    }

    @NonNull
    public abstract Fragment R(int i8);

    void U() {
        if (this.f8124k && !i0()) {
            ArraySet<Long> arraySet = new ArraySet();
            for (int i8 = 0; i8 < this.f8119f.o(); i8++) {
                long k8 = this.f8119f.k(i8);
                if (!Q(k8)) {
                    arraySet.add(Long.valueOf(k8));
                    this.f8121h.m(k8);
                }
            }
            if (!this.f8123j) {
                this.f8124k = false;
                for (int i9 = 0; i9 < this.f8119f.o(); i9++) {
                    long k9 = this.f8119f.k(i9);
                    if (!V(k9)) {
                        arraySet.add(Long.valueOf(k9));
                    }
                }
            }
            for (Long l8 : arraySet) {
                f0(l8.longValue());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: Y */
    public final void E(@NonNull final FragmentViewHolder fragmentViewHolder, int i8) {
        long m8 = fragmentViewHolder.m();
        int id = fragmentViewHolder.P().getId();
        Long X = X(id);
        if (X != null && X.longValue() != m8) {
            f0(X.longValue());
            this.f8121h.m(X.longValue());
        }
        this.f8121h.l(m8, Integer.valueOf(id));
        T(i8);
        final FrameLayout P = fragmentViewHolder.P();
        if (ViewCompat.V(P)) {
            if (P.getParent() == null) {
                P.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.1
                    @Override // android.view.View.OnLayoutChangeListener
                    public void onLayoutChange(View view, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
                        if (P.getParent() != null) {
                            P.removeOnLayoutChangeListener(this);
                            FragmentStateAdapter.this.e0(fragmentViewHolder);
                        }
                    }
                });
            } else {
                throw new IllegalStateException("Design assumption violated.");
            }
        }
        U();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: Z */
    public final FragmentViewHolder G(@NonNull ViewGroup viewGroup, int i8) {
        return FragmentViewHolder.O(viewGroup);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a0 */
    public final boolean I(@NonNull FragmentViewHolder fragmentViewHolder) {
        return true;
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    @NonNull
    public final Parcelable b() {
        Bundle bundle = new Bundle(this.f8119f.o() + this.f8120g.o());
        for (int i8 = 0; i8 < this.f8119f.o(); i8++) {
            long k8 = this.f8119f.k(i8);
            Fragment f8 = this.f8119f.f(k8);
            if (f8 != null && f8.isAdded()) {
                this.f8118e.putFragment(bundle, S("f#", k8), f8);
            }
        }
        for (int i9 = 0; i9 < this.f8120g.o(); i9++) {
            long k9 = this.f8120g.k(i9);
            if (Q(k9)) {
                bundle.putParcelable(S("s#", k9), this.f8120g.f(k9));
            }
        }
        return bundle;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: b0 */
    public final void J(@NonNull FragmentViewHolder fragmentViewHolder) {
        e0(fragmentViewHolder);
        U();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c0 */
    public final void L(@NonNull FragmentViewHolder fragmentViewHolder) {
        Long X = X(fragmentViewHolder.P().getId());
        if (X != null) {
            f0(X.longValue());
            this.f8121h.m(X.longValue());
        }
    }

    void e0(@NonNull final FragmentViewHolder fragmentViewHolder) {
        Fragment f8 = this.f8119f.f(fragmentViewHolder.m());
        if (f8 != null) {
            FrameLayout P = fragmentViewHolder.P();
            View view = f8.getView();
            if (!f8.isAdded() && view != null) {
                throw new IllegalStateException("Design assumption violated.");
            }
            if (f8.isAdded() && view == null) {
                h0(f8, P);
                return;
            } else if (f8.isAdded() && view.getParent() != null) {
                if (view.getParent() != P) {
                    P(view, P);
                    return;
                }
                return;
            } else if (f8.isAdded()) {
                P(view, P);
                return;
            } else if (!i0()) {
                h0(f8, P);
                FragmentTransaction beginTransaction = this.f8118e.beginTransaction();
                beginTransaction.add(f8, "f" + fragmentViewHolder.m()).setMaxLifecycle(f8, Lifecycle.State.STARTED).commitNow();
                this.f8122i.d(false);
                return;
            } else if (this.f8118e.isDestroyed()) {
                return;
            } else {
                this.f8117d.a(new LifecycleEventObserver() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.2
                    @Override // androidx.lifecycle.LifecycleEventObserver
                    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                        if (FragmentStateAdapter.this.i0()) {
                            return;
                        }
                        lifecycleOwner.getLifecycle().c(this);
                        if (ViewCompat.V(fragmentViewHolder.P())) {
                            FragmentStateAdapter.this.e0(fragmentViewHolder);
                        }
                    }
                });
                return;
            }
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    public final void g(@NonNull Parcelable parcelable) {
        if (this.f8120g.j() && this.f8119f.j()) {
            Bundle bundle = (Bundle) parcelable;
            if (bundle.getClassLoader() == null) {
                bundle.setClassLoader(getClass().getClassLoader());
            }
            for (String str : bundle.keySet()) {
                if (W(str, "f#")) {
                    this.f8119f.l(d0(str, "f#"), this.f8118e.getFragment(bundle, str));
                } else if (W(str, "s#")) {
                    long d02 = d0(str, "s#");
                    Fragment.SavedState savedState = (Fragment.SavedState) bundle.getParcelable(str);
                    if (Q(d02)) {
                        this.f8120g.l(d02, savedState);
                    }
                } else {
                    throw new IllegalArgumentException("Unexpected key in savedState: " + str);
                }
            }
            if (!this.f8119f.j()) {
                this.f8124k = true;
                this.f8123j = true;
                U();
                g0();
                return;
            }
            return;
        }
        throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
    }

    boolean i0() {
        return this.f8118e.isStateSaved();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long s(int i8) {
        return i8;
    }

    public FragmentStateAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        this.f8119f = new LongSparseArray<>();
        this.f8120g = new LongSparseArray<>();
        this.f8121h = new LongSparseArray<>();
        this.f8123j = false;
        this.f8124k = false;
        this.f8118e = fragmentManager;
        this.f8117d = lifecycle;
        super.N(true);
    }
}
