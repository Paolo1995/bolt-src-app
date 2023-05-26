package androidx.viewpager2.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.R$styleable;
import androidx.viewpager2.adapter.StatefulAdapter;

/* loaded from: classes.dex */
public final class ViewPager2 extends ViewGroup {

    /* renamed from: z  reason: collision with root package name */
    static boolean f8171z = true;

    /* renamed from: f  reason: collision with root package name */
    private final Rect f8172f;

    /* renamed from: g  reason: collision with root package name */
    private final Rect f8173g;

    /* renamed from: h  reason: collision with root package name */
    private CompositeOnPageChangeCallback f8174h;

    /* renamed from: i  reason: collision with root package name */
    int f8175i;

    /* renamed from: j  reason: collision with root package name */
    boolean f8176j;

    /* renamed from: k  reason: collision with root package name */
    private RecyclerView.AdapterDataObserver f8177k;

    /* renamed from: l  reason: collision with root package name */
    private LinearLayoutManager f8178l;

    /* renamed from: m  reason: collision with root package name */
    private int f8179m;

    /* renamed from: n  reason: collision with root package name */
    private Parcelable f8180n;

    /* renamed from: o  reason: collision with root package name */
    RecyclerView f8181o;

    /* renamed from: p  reason: collision with root package name */
    private PagerSnapHelper f8182p;

    /* renamed from: q  reason: collision with root package name */
    ScrollEventAdapter f8183q;

    /* renamed from: r  reason: collision with root package name */
    private CompositeOnPageChangeCallback f8184r;

    /* renamed from: s  reason: collision with root package name */
    private FakeDrag f8185s;

    /* renamed from: t  reason: collision with root package name */
    private PageTransformerAdapter f8186t;

    /* renamed from: u  reason: collision with root package name */
    private RecyclerView.ItemAnimator f8187u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f8188v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f8189w;

    /* renamed from: x  reason: collision with root package name */
    private int f8190x;

    /* renamed from: y  reason: collision with root package name */
    AccessibilityProvider f8191y;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class AccessibilityProvider {
        private AccessibilityProvider() {
        }

        boolean a() {
            return false;
        }

        boolean b(int i8) {
            return false;
        }

        boolean c(int i8, Bundle bundle) {
            return false;
        }

        boolean d() {
            return false;
        }

        void e(RecyclerView.Adapter<?> adapter) {
        }

        void f(RecyclerView.Adapter<?> adapter) {
        }

        String g() {
            throw new IllegalStateException("Not implemented.");
        }

        void h(@NonNull CompositeOnPageChangeCallback compositeOnPageChangeCallback, @NonNull RecyclerView recyclerView) {
        }

        void i(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        void j(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        boolean k(int i8) {
            throw new IllegalStateException("Not implemented.");
        }

        boolean l(int i8, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        void m() {
        }

        CharSequence n() {
            throw new IllegalStateException("Not implemented.");
        }

        void o(@NonNull AccessibilityEvent accessibilityEvent) {
        }

        void p() {
        }

        void q() {
        }

        void r() {
        }

        void s() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class BasicAccessibilityProvider extends AccessibilityProvider {
        BasicAccessibilityProvider() {
            super();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean b(int i8) {
            if ((i8 == 8192 || i8 == 4096) && !ViewPager2.this.e()) {
                return true;
            }
            return false;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean d() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void j(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (!ViewPager2.this.e()) {
                accessibilityNodeInfoCompat.Q(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f6054r);
                accessibilityNodeInfoCompat.Q(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f6053q);
                accessibilityNodeInfoCompat.s0(false);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean k(int i8) {
            if (b(i8)) {
                return false;
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public CharSequence n() {
            if (d()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }

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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class LinearLayoutManagerImpl extends LinearLayoutManager {
        LinearLayoutManagerImpl(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean C1(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z7, boolean z8) {
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void W0(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.W0(recycler, state, accessibilityNodeInfoCompat);
            ViewPager2.this.f8191y.j(accessibilityNodeInfoCompat);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void X1(@NonNull RecyclerView.State state, @NonNull int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.X1(state, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean q1(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, int i8, Bundle bundle) {
            if (ViewPager2.this.f8191y.b(i8)) {
                return ViewPager2.this.f8191y.k(i8);
            }
            return super.q1(recycler, state, i8, bundle);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class OnPageChangeCallback {
        public void a(int i8) {
        }

        public void b(int i8, float f8, int i9) {
        }

        public void c(int i8) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class PageAwareAccessibilityProvider extends AccessibilityProvider {

        /* renamed from: b  reason: collision with root package name */
        private final AccessibilityViewCommand f8198b;

        /* renamed from: c  reason: collision with root package name */
        private final AccessibilityViewCommand f8199c;

        /* renamed from: d  reason: collision with root package name */
        private RecyclerView.AdapterDataObserver f8200d;

        PageAwareAccessibilityProvider() {
            super();
            this.f8198b = new AccessibilityViewCommand() { // from class: androidx.viewpager2.widget.ViewPager2.PageAwareAccessibilityProvider.1
                @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                public boolean a(@NonNull View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                    PageAwareAccessibilityProvider.this.v(((ViewPager2) view).getCurrentItem() + 1);
                    return true;
                }
            };
            this.f8199c = new AccessibilityViewCommand() { // from class: androidx.viewpager2.widget.ViewPager2.PageAwareAccessibilityProvider.2
                @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                public boolean a(@NonNull View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                    PageAwareAccessibilityProvider.this.v(((ViewPager2) view).getCurrentItem() - 1);
                    return true;
                }
            };
        }

        private void t(AccessibilityNodeInfo accessibilityNodeInfo) {
            int i8;
            int i9;
            if (ViewPager2.this.getAdapter() != null) {
                if (ViewPager2.this.getOrientation() == 1) {
                    i8 = ViewPager2.this.getAdapter().r();
                } else {
                    i9 = ViewPager2.this.getAdapter().r();
                    i8 = 0;
                    AccessibilityNodeInfoCompat.A0(accessibilityNodeInfo).a0(AccessibilityNodeInfoCompat.CollectionInfoCompat.a(i8, i9, false, 0));
                }
            } else {
                i8 = 0;
            }
            i9 = 0;
            AccessibilityNodeInfoCompat.A0(accessibilityNodeInfo).a0(AccessibilityNodeInfoCompat.CollectionInfoCompat.a(i8, i9, false, 0));
        }

        private void u(AccessibilityNodeInfo accessibilityNodeInfo) {
            int r7;
            RecyclerView.Adapter adapter = ViewPager2.this.getAdapter();
            if (adapter != null && (r7 = adapter.r()) != 0 && ViewPager2.this.e()) {
                if (ViewPager2.this.f8175i > 0) {
                    accessibilityNodeInfo.addAction(FragmentTransaction.TRANSIT_EXIT_MASK);
                }
                if (ViewPager2.this.f8175i < r7 - 1) {
                    accessibilityNodeInfo.addAction(4096);
                }
                accessibilityNodeInfo.setScrollable(true);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean a() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean c(int i8, Bundle bundle) {
            return i8 == 8192 || i8 == 4096;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void e(RecyclerView.Adapter<?> adapter) {
            w();
            if (adapter != null) {
                adapter.M(this.f8200d);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void f(RecyclerView.Adapter<?> adapter) {
            if (adapter != null) {
                adapter.O(this.f8200d);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public String g() {
            if (a()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void h(@NonNull CompositeOnPageChangeCallback compositeOnPageChangeCallback, @NonNull RecyclerView recyclerView) {
            ViewCompat.D0(recyclerView, 2);
            this.f8200d = new DataSetChangeObserver() { // from class: androidx.viewpager2.widget.ViewPager2.PageAwareAccessibilityProvider.3
                @Override // androidx.viewpager2.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
                public void a() {
                    PageAwareAccessibilityProvider.this.w();
                }
            };
            if (ViewCompat.C(ViewPager2.this) == 0) {
                ViewCompat.D0(ViewPager2.this, 1);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void i(AccessibilityNodeInfo accessibilityNodeInfo) {
            t(accessibilityNodeInfo);
            u(accessibilityNodeInfo);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean l(int i8, Bundle bundle) {
            int currentItem;
            if (c(i8, bundle)) {
                if (i8 == 8192) {
                    currentItem = ViewPager2.this.getCurrentItem() - 1;
                } else {
                    currentItem = ViewPager2.this.getCurrentItem() + 1;
                }
                v(currentItem);
                return true;
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void m() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void o(@NonNull AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName(g());
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void p() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void q() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void r() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void s() {
            w();
        }

        void v(int i8) {
            if (ViewPager2.this.e()) {
                ViewPager2.this.k(i8, true);
            }
        }

        void w() {
            int r7;
            int i8;
            ViewPager2 viewPager2 = ViewPager2.this;
            int i9 = 16908360;
            ViewCompat.m0(viewPager2, 16908360);
            ViewCompat.m0(viewPager2, 16908361);
            ViewCompat.m0(viewPager2, 16908358);
            ViewCompat.m0(viewPager2, 16908359);
            if (ViewPager2.this.getAdapter() == null || (r7 = ViewPager2.this.getAdapter().r()) == 0 || !ViewPager2.this.e()) {
                return;
            }
            if (ViewPager2.this.getOrientation() == 0) {
                boolean d8 = ViewPager2.this.d();
                if (d8) {
                    i8 = 16908360;
                } else {
                    i8 = 16908361;
                }
                if (d8) {
                    i9 = 16908361;
                }
                if (ViewPager2.this.f8175i < r7 - 1) {
                    ViewCompat.o0(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i8, null), null, this.f8198b);
                }
                if (ViewPager2.this.f8175i > 0) {
                    ViewCompat.o0(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i9, null), null, this.f8199c);
                    return;
                }
                return;
            }
            if (ViewPager2.this.f8175i < r7 - 1) {
                ViewCompat.o0(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908359, null), null, this.f8198b);
            }
            if (ViewPager2.this.f8175i > 0) {
                ViewCompat.o0(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908358, null), null, this.f8199c);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface PageTransformer {
        void a(@NonNull View view, float f8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PagerSnapHelperImpl extends PagerSnapHelper {
        PagerSnapHelperImpl() {
        }

        @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
        public View h(RecyclerView.LayoutManager layoutManager) {
            if (ViewPager2.this.c()) {
                return null;
            }
            return super.h(layoutManager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class RecyclerViewImpl extends RecyclerView {
        RecyclerViewImpl(@NonNull Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        public CharSequence getAccessibilityClassName() {
            if (ViewPager2.this.f8191y.d()) {
                return ViewPager2.this.f8191y.n();
            }
            return super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.f8175i);
            accessibilityEvent.setToIndex(ViewPager2.this.f8175i);
            ViewPager2.this.f8191y.o(accessibilityEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (ViewPager2.this.e() && super.onInterceptTouchEvent(motionEvent)) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (ViewPager2.this.e() && super.onTouchEvent(motionEvent)) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class SmoothScrollToPosition implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        private final int f8209f;

        /* renamed from: g  reason: collision with root package name */
        private final RecyclerView f8210g;

        SmoothScrollToPosition(int i8, RecyclerView recyclerView) {
            this.f8209f = i8;
            this.f8210g = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f8210g.x1(this.f8209f);
        }
    }

    public ViewPager2(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8172f = new Rect();
        this.f8173g = new Rect();
        this.f8174h = new CompositeOnPageChangeCallback(3);
        this.f8176j = false;
        this.f8177k = new DataSetChangeObserver() { // from class: androidx.viewpager2.widget.ViewPager2.1
            @Override // androidx.viewpager2.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void a() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f8176j = true;
                viewPager2.f8183q.l();
            }
        };
        this.f8179m = -1;
        this.f8187u = null;
        this.f8188v = false;
        this.f8189w = true;
        this.f8190x = -1;
        b(context, attributeSet);
    }

    private RecyclerView.OnChildAttachStateChangeListener a() {
        return new RecyclerView.OnChildAttachStateChangeListener() { // from class: androidx.viewpager2.widget.ViewPager2.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void b(@NonNull View view) {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void d(@NonNull View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) layoutParams).width == -1 && ((ViewGroup.MarginLayoutParams) layoutParams).height == -1) {
                    return;
                }
                throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
            }
        };
    }

    private void b(Context context, AttributeSet attributeSet) {
        AccessibilityProvider basicAccessibilityProvider;
        if (f8171z) {
            basicAccessibilityProvider = new PageAwareAccessibilityProvider();
        } else {
            basicAccessibilityProvider = new BasicAccessibilityProvider();
        }
        this.f8191y = basicAccessibilityProvider;
        RecyclerViewImpl recyclerViewImpl = new RecyclerViewImpl(context);
        this.f8181o = recyclerViewImpl;
        recyclerViewImpl.setId(ViewCompat.m());
        this.f8181o.setDescendantFocusability(131072);
        LinearLayoutManagerImpl linearLayoutManagerImpl = new LinearLayoutManagerImpl(context);
        this.f8178l = linearLayoutManagerImpl;
        this.f8181o.setLayoutManager(linearLayoutManagerImpl);
        this.f8181o.setScrollingTouchSlop(1);
        l(context, attributeSet);
        this.f8181o.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f8181o.j(a());
        ScrollEventAdapter scrollEventAdapter = new ScrollEventAdapter(this);
        this.f8183q = scrollEventAdapter;
        this.f8185s = new FakeDrag(this, scrollEventAdapter, this.f8181o);
        PagerSnapHelperImpl pagerSnapHelperImpl = new PagerSnapHelperImpl();
        this.f8182p = pagerSnapHelperImpl;
        pagerSnapHelperImpl.b(this.f8181o);
        this.f8181o.l(this.f8183q);
        CompositeOnPageChangeCallback compositeOnPageChangeCallback = new CompositeOnPageChangeCallback(3);
        this.f8184r = compositeOnPageChangeCallback;
        this.f8183q.o(compositeOnPageChangeCallback);
        OnPageChangeCallback onPageChangeCallback = new OnPageChangeCallback() { // from class: androidx.viewpager2.widget.ViewPager2.2
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void a(int i8) {
                if (i8 == 0) {
                    ViewPager2.this.o();
                }
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void c(int i8) {
                ViewPager2 viewPager2 = ViewPager2.this;
                if (viewPager2.f8175i != i8) {
                    viewPager2.f8175i = i8;
                    viewPager2.f8191y.q();
                }
            }
        };
        OnPageChangeCallback onPageChangeCallback2 = new OnPageChangeCallback() { // from class: androidx.viewpager2.widget.ViewPager2.3
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void c(int i8) {
                ViewPager2.this.clearFocus();
                if (ViewPager2.this.hasFocus()) {
                    ViewPager2.this.f8181o.requestFocus(2);
                }
            }
        };
        this.f8184r.d(onPageChangeCallback);
        this.f8184r.d(onPageChangeCallback2);
        this.f8191y.h(this.f8184r, this.f8181o);
        this.f8184r.d(this.f8174h);
        PageTransformerAdapter pageTransformerAdapter = new PageTransformerAdapter(this.f8178l);
        this.f8186t = pageTransformerAdapter;
        this.f8184r.d(pageTransformerAdapter);
        RecyclerView recyclerView = this.f8181o;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    private void f(RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.M(this.f8177k);
        }
    }

    private void i() {
        RecyclerView.Adapter adapter;
        if (this.f8179m == -1 || (adapter = getAdapter()) == null) {
            return;
        }
        Parcelable parcelable = this.f8180n;
        if (parcelable != null) {
            if (adapter instanceof StatefulAdapter) {
                ((StatefulAdapter) adapter).g(parcelable);
            }
            this.f8180n = null;
        }
        int max = Math.max(0, Math.min(this.f8179m, adapter.r() - 1));
        this.f8175i = max;
        this.f8179m = -1;
        this.f8181o.p1(max);
        this.f8191y.m();
    }

    private void l(Context context, AttributeSet attributeSet) {
        int[] iArr = R$styleable.f8115g;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        }
        try {
            setOrientation(obtainStyledAttributes.getInt(R$styleable.f8116h, 0));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void m(RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.O(this.f8177k);
        }
    }

    public boolean c() {
        return this.f8185s.a();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i8) {
        return this.f8181o.canScrollHorizontally(i8);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i8) {
        return this.f8181o.canScrollVertically(i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        if (this.f8178l.k0() == 1) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i8 = ((SavedState) parcelable).f8206f;
            sparseArray.put(this.f8181o.getId(), sparseArray.get(i8));
            sparseArray.remove(i8);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        i();
    }

    public boolean e() {
        return this.f8189w;
    }

    public void g(@NonNull OnPageChangeCallback onPageChangeCallback) {
        this.f8174h.d(onPageChangeCallback);
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (this.f8191y.a()) {
            return this.f8191y.g();
        }
        return super.getAccessibilityClassName();
    }

    public RecyclerView.Adapter getAdapter() {
        return this.f8181o.getAdapter();
    }

    public int getCurrentItem() {
        return this.f8175i;
    }

    public int getItemDecorationCount() {
        return this.f8181o.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.f8190x;
    }

    public int getOrientation() {
        return this.f8178l.y2();
    }

    int getPageSize() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.f8181o;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public int getScrollState() {
        return this.f8183q.h();
    }

    public void h() {
        if (this.f8186t.d() == null) {
            return;
        }
        double g8 = this.f8183q.g();
        int i8 = (int) g8;
        float f8 = (float) (g8 - i8);
        this.f8186t.b(i8, f8, Math.round(getPageSize() * f8));
    }

    public void j(int i8, boolean z7) {
        if (!c()) {
            k(i8, z7);
            return;
        }
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }

    void k(int i8, boolean z7) {
        int i9;
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null) {
            if (this.f8179m != -1) {
                this.f8179m = Math.max(i8, 0);
            }
        } else if (adapter.r() <= 0) {
        } else {
            int min = Math.min(Math.max(i8, 0), adapter.r() - 1);
            if (min == this.f8175i && this.f8183q.j()) {
                return;
            }
            int i10 = this.f8175i;
            if (min == i10 && z7) {
                return;
            }
            double d8 = i10;
            this.f8175i = min;
            this.f8191y.q();
            if (!this.f8183q.j()) {
                d8 = this.f8183q.g();
            }
            this.f8183q.m(min, z7);
            if (!z7) {
                this.f8181o.p1(min);
                return;
            }
            double d9 = min;
            if (Math.abs(d9 - d8) > 3.0d) {
                RecyclerView recyclerView = this.f8181o;
                if (d9 > d8) {
                    i9 = min - 3;
                } else {
                    i9 = min + 3;
                }
                recyclerView.p1(i9);
                RecyclerView recyclerView2 = this.f8181o;
                recyclerView2.post(new SmoothScrollToPosition(min, recyclerView2));
                return;
            }
            this.f8181o.x1(min);
        }
    }

    public void n(@NonNull OnPageChangeCallback onPageChangeCallback) {
        this.f8174h.e(onPageChangeCallback);
    }

    void o() {
        PagerSnapHelper pagerSnapHelper = this.f8182p;
        if (pagerSnapHelper != null) {
            View h8 = pagerSnapHelper.h(this.f8178l);
            if (h8 == null) {
                return;
            }
            int o02 = this.f8178l.o0(h8);
            if (o02 != this.f8175i && getScrollState() == 0) {
                this.f8184r.c(o02);
            }
            this.f8176j = false;
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.f8191y.i(accessibilityNodeInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        int measuredWidth = this.f8181o.getMeasuredWidth();
        int measuredHeight = this.f8181o.getMeasuredHeight();
        this.f8172f.left = getPaddingLeft();
        this.f8172f.right = (i10 - i8) - getPaddingRight();
        this.f8172f.top = getPaddingTop();
        this.f8172f.bottom = (i11 - i9) - getPaddingBottom();
        Gravity.apply(8388659, measuredWidth, measuredHeight, this.f8172f, this.f8173g);
        RecyclerView recyclerView = this.f8181o;
        Rect rect = this.f8173g;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.f8176j) {
            o();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i8, int i9) {
        measureChild(this.f8181o, i8, i9);
        int measuredWidth = this.f8181o.getMeasuredWidth();
        int measuredHeight = this.f8181o.getMeasuredHeight();
        int measuredState = this.f8181o.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i8, measuredState), View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i9, measuredState << 16));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f8179m = savedState.f8207g;
        this.f8180n = savedState.f8208h;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f8206f = this.f8181o.getId();
        int i8 = this.f8179m;
        if (i8 == -1) {
            i8 = this.f8175i;
        }
        savedState.f8207g = i8;
        Parcelable parcelable = this.f8180n;
        if (parcelable != null) {
            savedState.f8208h = parcelable;
        } else {
            RecyclerView.Adapter adapter = this.f8181o.getAdapter();
            if (adapter instanceof StatefulAdapter) {
                savedState.f8208h = ((StatefulAdapter) adapter).b();
            }
        }
        return savedState;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        throw new IllegalStateException(ViewPager2.class.getSimpleName() + " does not support direct child views");
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i8, Bundle bundle) {
        if (this.f8191y.c(i8, bundle)) {
            return this.f8191y.l(i8, bundle);
        }
        return super.performAccessibilityAction(i8, bundle);
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = this.f8181o.getAdapter();
        this.f8191y.f(adapter2);
        m(adapter2);
        this.f8181o.setAdapter(adapter);
        this.f8175i = 0;
        i();
        this.f8191y.e(adapter);
        f(adapter);
    }

    public void setCurrentItem(int i8) {
        j(i8, true);
    }

    @Override // android.view.View
    public void setLayoutDirection(int i8) {
        super.setLayoutDirection(i8);
        this.f8191y.p();
    }

    public void setOffscreenPageLimit(int i8) {
        if (i8 < 1 && i8 != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.f8190x = i8;
        this.f8181o.requestLayout();
    }

    public void setOrientation(int i8) {
        this.f8178l.M2(i8);
        this.f8191y.r();
    }

    public void setPageTransformer(PageTransformer pageTransformer) {
        if (pageTransformer != null) {
            if (!this.f8188v) {
                this.f8187u = this.f8181o.getItemAnimator();
                this.f8188v = true;
            }
            this.f8181o.setItemAnimator(null);
        } else if (this.f8188v) {
            this.f8181o.setItemAnimator(this.f8187u);
            this.f8187u = null;
            this.f8188v = false;
        }
        if (pageTransformer == this.f8186t.d()) {
            return;
        }
        this.f8186t.e(pageTransformer);
        h();
    }

    public void setUserInputEnabled(boolean z7) {
        this.f8189w = z7;
        this.f8191y.s();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.viewpager2.widget.ViewPager2.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                if (Build.VERSION.SDK_INT >= 24) {
                    return new SavedState(parcel, classLoader);
                }
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public SavedState[] newArray(int i8) {
                return new SavedState[i8];
            }
        };

        /* renamed from: f  reason: collision with root package name */
        int f8206f;

        /* renamed from: g  reason: collision with root package name */
        int f8207g;

        /* renamed from: h  reason: collision with root package name */
        Parcelable f8208h;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader);
        }

        private void a(Parcel parcel, ClassLoader classLoader) {
            this.f8206f = parcel.readInt();
            this.f8207g = parcel.readInt();
            this.f8208h = parcel.readParcelable(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i8) {
            super.writeToParcel(parcel, i8);
            parcel.writeInt(this.f8206f);
            parcel.writeInt(this.f8207g);
            parcel.writeParcelable(this.f8208h, i8);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            a(parcel, null);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
