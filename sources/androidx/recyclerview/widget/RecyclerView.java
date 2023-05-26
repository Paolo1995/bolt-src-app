package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.R$attr;
import androidx.recyclerview.R$dimen;
import androidx.recyclerview.R$styleable;
import androidx.recyclerview.widget.AdapterHelper;
import androidx.recyclerview.widget.ChildHelper;
import androidx.recyclerview.widget.GapWorker;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import androidx.recyclerview.widget.ViewBoundsCheck;
import androidx.recyclerview.widget.ViewInfoStore;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.api.Api;
import j$.util.Spliterator;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jctools.util.Pow2;

/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements NestedScrollingChild {
    private static final int[] H0 = {16843830};
    static final boolean I0;
    static final boolean J0;
    static final boolean K0;
    static final boolean L0;
    private static final boolean M0;
    private static final boolean N0;
    private static final Class<?>[] O0;
    static final Interpolator P0;
    boolean A;
    final int[] A0;
    private int B;
    final List<ViewHolder> B0;
    boolean C;
    private Runnable C0;
    boolean D;
    private boolean D0;
    private boolean E;
    private int E0;
    private int F;
    private int F0;
    boolean G;
    private final ViewInfoStore.ProcessCallback G0;
    private final AccessibilityManager H;
    private List<OnChildAttachStateChangeListener> I;
    boolean J;
    boolean K;
    private int L;
    private int M;
    @NonNull
    private EdgeEffectFactory N;
    private EdgeEffect O;
    private EdgeEffect P;
    private EdgeEffect Q;
    private EdgeEffect R;
    ItemAnimator S;
    private int T;
    private int U;
    private VelocityTracker V;
    private int W;

    /* renamed from: a0  reason: collision with root package name */
    private int f7176a0;

    /* renamed from: b0  reason: collision with root package name */
    private int f7177b0;

    /* renamed from: c0  reason: collision with root package name */
    private int f7178c0;

    /* renamed from: d0  reason: collision with root package name */
    private int f7179d0;

    /* renamed from: e0  reason: collision with root package name */
    private OnFlingListener f7180e0;

    /* renamed from: f  reason: collision with root package name */
    private final RecyclerViewDataObserver f7181f;

    /* renamed from: f0  reason: collision with root package name */
    private final int f7182f0;

    /* renamed from: g  reason: collision with root package name */
    final Recycler f7183g;

    /* renamed from: g0  reason: collision with root package name */
    private final int f7184g0;

    /* renamed from: h  reason: collision with root package name */
    SavedState f7185h;

    /* renamed from: h0  reason: collision with root package name */
    private float f7186h0;

    /* renamed from: i  reason: collision with root package name */
    AdapterHelper f7187i;

    /* renamed from: i0  reason: collision with root package name */
    private float f7188i0;

    /* renamed from: j  reason: collision with root package name */
    ChildHelper f7189j;

    /* renamed from: j0  reason: collision with root package name */
    private boolean f7190j0;

    /* renamed from: k  reason: collision with root package name */
    final ViewInfoStore f7191k;

    /* renamed from: k0  reason: collision with root package name */
    final ViewFlinger f7192k0;

    /* renamed from: l  reason: collision with root package name */
    boolean f7193l;

    /* renamed from: l0  reason: collision with root package name */
    GapWorker f7194l0;

    /* renamed from: m  reason: collision with root package name */
    final Runnable f7195m;

    /* renamed from: m0  reason: collision with root package name */
    GapWorker.LayoutPrefetchRegistryImpl f7196m0;

    /* renamed from: n  reason: collision with root package name */
    final Rect f7197n;

    /* renamed from: n0  reason: collision with root package name */
    final State f7198n0;

    /* renamed from: o  reason: collision with root package name */
    private final Rect f7199o;

    /* renamed from: o0  reason: collision with root package name */
    private OnScrollListener f7200o0;

    /* renamed from: p  reason: collision with root package name */
    final RectF f7201p;

    /* renamed from: p0  reason: collision with root package name */
    private List<OnScrollListener> f7202p0;

    /* renamed from: q  reason: collision with root package name */
    Adapter f7203q;

    /* renamed from: q0  reason: collision with root package name */
    boolean f7204q0;

    /* renamed from: r  reason: collision with root package name */
    LayoutManager f7205r;

    /* renamed from: r0  reason: collision with root package name */
    boolean f7206r0;

    /* renamed from: s  reason: collision with root package name */
    RecyclerListener f7207s;

    /* renamed from: s0  reason: collision with root package name */
    private ItemAnimator.ItemAnimatorListener f7208s0;

    /* renamed from: t  reason: collision with root package name */
    final List<RecyclerListener> f7209t;

    /* renamed from: t0  reason: collision with root package name */
    boolean f7210t0;

    /* renamed from: u  reason: collision with root package name */
    final ArrayList<ItemDecoration> f7211u;

    /* renamed from: u0  reason: collision with root package name */
    RecyclerViewAccessibilityDelegate f7212u0;

    /* renamed from: v  reason: collision with root package name */
    private final ArrayList<OnItemTouchListener> f7213v;

    /* renamed from: v0  reason: collision with root package name */
    private ChildDrawingOrderCallback f7214v0;

    /* renamed from: w  reason: collision with root package name */
    private OnItemTouchListener f7215w;

    /* renamed from: w0  reason: collision with root package name */
    private final int[] f7216w0;

    /* renamed from: x  reason: collision with root package name */
    boolean f7217x;

    /* renamed from: x0  reason: collision with root package name */
    private NestedScrollingChildHelper f7218x0;

    /* renamed from: y  reason: collision with root package name */
    boolean f7219y;

    /* renamed from: y0  reason: collision with root package name */
    private final int[] f7220y0;

    /* renamed from: z  reason: collision with root package name */
    boolean f7221z;

    /* renamed from: z0  reason: collision with root package name */
    private final int[] f7222z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.recyclerview.widget.RecyclerView$7  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass7 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7228a;

        static {
            int[] iArr = new int[Adapter.StateRestorationPolicy.values().length];
            f7228a = iArr;
            try {
                iArr[Adapter.StateRestorationPolicy.PREVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7228a[Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Adapter<VH extends ViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        private final AdapterDataObservable f7229a = new AdapterDataObservable();

        /* renamed from: b  reason: collision with root package name */
        private boolean f7230b = false;

        /* renamed from: c  reason: collision with root package name */
        private StateRestorationPolicy f7231c = StateRestorationPolicy.ALLOW;

        /* loaded from: classes.dex */
        public enum StateRestorationPolicy {
            ALLOW,
            PREVENT_WHEN_EMPTY,
            PREVENT
        }

        public final void A(int i8, int i9) {
            this.f7229a.f(i8, i9);
        }

        public final void B(int i8, int i9) {
            this.f7229a.g(i8, i9);
        }

        public final void C(int i8) {
            this.f7229a.g(i8, 1);
        }

        public void D(@NonNull RecyclerView recyclerView) {
        }

        public abstract void E(@NonNull VH vh, int i8);

        public void F(@NonNull VH vh, int i8, @NonNull List<Object> list) {
            E(vh, i8);
        }

        @NonNull
        public abstract VH G(@NonNull ViewGroup viewGroup, int i8);

        public void H(@NonNull RecyclerView recyclerView) {
        }

        public boolean I(@NonNull VH vh) {
            return false;
        }

        public void J(@NonNull VH vh) {
        }

        public void K(@NonNull VH vh) {
        }

        public void L(@NonNull VH vh) {
        }

        public void M(@NonNull AdapterDataObserver adapterDataObserver) {
            this.f7229a.registerObserver(adapterDataObserver);
        }

        public void N(boolean z7) {
            if (!u()) {
                this.f7230b = z7;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public void O(@NonNull AdapterDataObserver adapterDataObserver) {
            this.f7229a.unregisterObserver(adapterDataObserver);
        }

        public final void n(@NonNull VH vh, int i8) {
            boolean z7;
            if (vh.f7350s == null) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                vh.f7334c = i8;
                if (v()) {
                    vh.f7336e = s(i8);
                }
                vh.H(1, 519);
                TraceCompat.a("RV OnBindView");
            }
            vh.f7350s = this;
            F(vh, i8, vh.q());
            if (z7) {
                vh.d();
                ViewGroup.LayoutParams layoutParams = vh.f7332a.getLayoutParams();
                if (layoutParams instanceof LayoutParams) {
                    ((LayoutParams) layoutParams).f7273h = true;
                }
                TraceCompat.b();
            }
        }

        boolean o() {
            int i8 = AnonymousClass7.f7228a[this.f7231c.ordinal()];
            if (i8 == 1) {
                return false;
            }
            if (i8 == 2 && r() <= 0) {
                return false;
            }
            return true;
        }

        @NonNull
        public final VH p(@NonNull ViewGroup viewGroup, int i8) {
            try {
                TraceCompat.a("RV CreateView");
                VH G = G(viewGroup, i8);
                if (G.f7332a.getParent() == null) {
                    G.f7337f = i8;
                    return G;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                TraceCompat.b();
            }
        }

        public int q(@NonNull Adapter<? extends ViewHolder> adapter, @NonNull ViewHolder viewHolder, int i8) {
            if (adapter == this) {
                return i8;
            }
            return -1;
        }

        public abstract int r();

        public long s(int i8) {
            return -1L;
        }

        public int t(int i8) {
            return 0;
        }

        public final boolean u() {
            return this.f7229a.a();
        }

        public final boolean v() {
            return this.f7230b;
        }

        public final void w() {
            this.f7229a.b();
        }

        public final void x(int i8) {
            this.f7229a.d(i8, 1);
        }

        public final void y(int i8, int i9) {
            this.f7229a.c(i8, i9);
        }

        public final void z(int i8, int i9, Object obj) {
            this.f7229a.e(i8, i9, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class AdapterDataObservable extends Observable<AdapterDataObserver> {
        AdapterDataObservable() {
        }

        public boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void b() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).a();
            }
        }

        public void c(int i8, int i9) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).e(i8, i9, 1);
            }
        }

        public void d(int i8, int i9) {
            e(i8, i9, null);
        }

        public void e(int i8, int i9, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).c(i8, i9, obj);
            }
        }

        public void f(int i8, int i9) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).d(i8, i9);
            }
        }

        public void g(int i8, int i9) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).f(i8, i9);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class AdapterDataObserver {
        public void a() {
        }

        public void b(int i8, int i9) {
        }

        public void c(int i8, int i9, Object obj) {
            b(i8, i9);
        }

        public void d(int i8, int i9) {
        }

        public void e(int i8, int i9, int i10) {
        }

        public void f(int i8, int i9) {
        }
    }

    /* loaded from: classes.dex */
    public interface ChildDrawingOrderCallback {
        int a(int i8, int i9);
    }

    /* loaded from: classes.dex */
    public static class EdgeEffectFactory {
        @NonNull
        protected EdgeEffect a(@NonNull RecyclerView recyclerView, int i8) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ItemAnimator {

        /* renamed from: a  reason: collision with root package name */
        private ItemAnimatorListener f7236a = null;

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<ItemAnimatorFinishedListener> f7237b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        private long f7238c = 120;

        /* renamed from: d  reason: collision with root package name */
        private long f7239d = 120;

        /* renamed from: e  reason: collision with root package name */
        private long f7240e = 250;

        /* renamed from: f  reason: collision with root package name */
        private long f7241f = 250;

        /* loaded from: classes.dex */
        public interface ItemAnimatorFinishedListener {
            void a();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public interface ItemAnimatorListener {
            void a(@NonNull ViewHolder viewHolder);
        }

        /* loaded from: classes.dex */
        public static class ItemHolderInfo {

            /* renamed from: a  reason: collision with root package name */
            public int f7242a;

            /* renamed from: b  reason: collision with root package name */
            public int f7243b;

            /* renamed from: c  reason: collision with root package name */
            public int f7244c;

            /* renamed from: d  reason: collision with root package name */
            public int f7245d;

            @NonNull
            public ItemHolderInfo a(@NonNull ViewHolder viewHolder) {
                return b(viewHolder, 0);
            }

            @NonNull
            public ItemHolderInfo b(@NonNull ViewHolder viewHolder, int i8) {
                View view = viewHolder.f7332a;
                this.f7242a = view.getLeft();
                this.f7243b = view.getTop();
                this.f7244c = view.getRight();
                this.f7245d = view.getBottom();
                return this;
            }
        }

        static int e(ViewHolder viewHolder) {
            int i8 = viewHolder.f7341j & 14;
            if (viewHolder.v()) {
                return 4;
            }
            if ((i8 & 4) == 0) {
                int p8 = viewHolder.p();
                int j8 = viewHolder.j();
                if (p8 != -1 && j8 != -1 && p8 != j8) {
                    return i8 | 2048;
                }
                return i8;
            }
            return i8;
        }

        public abstract boolean a(@NonNull ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, @NonNull ItemHolderInfo itemHolderInfo2);

        public abstract boolean b(@NonNull ViewHolder viewHolder, @NonNull ViewHolder viewHolder2, @NonNull ItemHolderInfo itemHolderInfo, @NonNull ItemHolderInfo itemHolderInfo2);

        public abstract boolean c(@NonNull ViewHolder viewHolder, @NonNull ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public abstract boolean d(@NonNull ViewHolder viewHolder, @NonNull ItemHolderInfo itemHolderInfo, @NonNull ItemHolderInfo itemHolderInfo2);

        public boolean f(@NonNull ViewHolder viewHolder) {
            return true;
        }

        public boolean g(@NonNull ViewHolder viewHolder, @NonNull List<Object> list) {
            return f(viewHolder);
        }

        public final void h(@NonNull ViewHolder viewHolder) {
            s(viewHolder);
            ItemAnimatorListener itemAnimatorListener = this.f7236a;
            if (itemAnimatorListener != null) {
                itemAnimatorListener.a(viewHolder);
            }
        }

        public final void i() {
            int size = this.f7237b.size();
            for (int i8 = 0; i8 < size; i8++) {
                this.f7237b.get(i8).a();
            }
            this.f7237b.clear();
        }

        public abstract void j(@NonNull ViewHolder viewHolder);

        public abstract void k();

        public long l() {
            return this.f7238c;
        }

        public long m() {
            return this.f7241f;
        }

        public long n() {
            return this.f7240e;
        }

        public long o() {
            return this.f7239d;
        }

        public abstract boolean p();

        public final boolean q(ItemAnimatorFinishedListener itemAnimatorFinishedListener) {
            boolean p8 = p();
            if (itemAnimatorFinishedListener != null) {
                if (!p8) {
                    itemAnimatorFinishedListener.a();
                } else {
                    this.f7237b.add(itemAnimatorFinishedListener);
                }
            }
            return p8;
        }

        @NonNull
        public ItemHolderInfo r() {
            return new ItemHolderInfo();
        }

        public void s(@NonNull ViewHolder viewHolder) {
        }

        @NonNull
        public ItemHolderInfo t(@NonNull State state, @NonNull ViewHolder viewHolder) {
            return r().a(viewHolder);
        }

        @NonNull
        public ItemHolderInfo u(@NonNull State state, @NonNull ViewHolder viewHolder, int i8, @NonNull List<Object> list) {
            return r().a(viewHolder);
        }

        public abstract void v();

        void w(ItemAnimatorListener itemAnimatorListener) {
            this.f7236a = itemAnimatorListener;
        }
    }

    /* loaded from: classes.dex */
    private class ItemAnimatorRestoreListener implements ItemAnimator.ItemAnimatorListener {
        ItemAnimatorRestoreListener() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemAnimatorListener
        public void a(ViewHolder viewHolder) {
            viewHolder.I(true);
            if (viewHolder.f7339h != null && viewHolder.f7340i == null) {
                viewHolder.f7339h = null;
            }
            viewHolder.f7340i = null;
            if (!viewHolder.K() && !RecyclerView.this.c1(viewHolder.f7332a) && viewHolder.z()) {
                RecyclerView.this.removeDetachedView(viewHolder.f7332a, false);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ItemDecoration {
        @Deprecated
        public void f(@NonNull Rect rect, int i8, @NonNull RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void g(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull State state) {
            f(rect, ((LayoutParams) view.getLayoutParams()).a(), recyclerView);
        }

        @Deprecated
        public void h(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        }

        public void i(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull State state) {
            h(canvas, recyclerView);
        }

        @Deprecated
        public void j(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        }

        public void k(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull State state) {
            j(canvas, recyclerView);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class LayoutManager {

        /* renamed from: f  reason: collision with root package name */
        ChildHelper f7247f;

        /* renamed from: g  reason: collision with root package name */
        RecyclerView f7248g;

        /* renamed from: h  reason: collision with root package name */
        private final ViewBoundsCheck.Callback f7249h;

        /* renamed from: i  reason: collision with root package name */
        private final ViewBoundsCheck.Callback f7250i;

        /* renamed from: j  reason: collision with root package name */
        ViewBoundsCheck f7251j;

        /* renamed from: k  reason: collision with root package name */
        ViewBoundsCheck f7252k;

        /* renamed from: l  reason: collision with root package name */
        SmoothScroller f7253l;

        /* renamed from: m  reason: collision with root package name */
        boolean f7254m;

        /* renamed from: n  reason: collision with root package name */
        boolean f7255n;

        /* renamed from: o  reason: collision with root package name */
        boolean f7256o;

        /* renamed from: p  reason: collision with root package name */
        private boolean f7257p;

        /* renamed from: q  reason: collision with root package name */
        private boolean f7258q;

        /* renamed from: r  reason: collision with root package name */
        int f7259r;

        /* renamed from: s  reason: collision with root package name */
        boolean f7260s;

        /* renamed from: t  reason: collision with root package name */
        private int f7261t;

        /* renamed from: u  reason: collision with root package name */
        private int f7262u;

        /* renamed from: v  reason: collision with root package name */
        private int f7263v;

        /* renamed from: w  reason: collision with root package name */
        private int f7264w;

        /* loaded from: classes.dex */
        public interface LayoutPrefetchRegistry {
            void a(int i8, int i9);
        }

        /* loaded from: classes.dex */
        public static class Properties {

            /* renamed from: a  reason: collision with root package name */
            public int f7267a;

            /* renamed from: b  reason: collision with root package name */
            public int f7268b;

            /* renamed from: c  reason: collision with root package name */
            public boolean f7269c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f7270d;
        }

        public LayoutManager() {
            ViewBoundsCheck.Callback callback = new ViewBoundsCheck.Callback() { // from class: androidx.recyclerview.widget.RecyclerView.LayoutManager.1
                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public View a(int i8) {
                    return LayoutManager.this.T(i8);
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int b(View view) {
                    return LayoutManager.this.b0(view) - ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).leftMargin;
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int c() {
                    return LayoutManager.this.getPaddingLeft();
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int d() {
                    return LayoutManager.this.v0() - LayoutManager.this.getPaddingRight();
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int e(View view) {
                    return LayoutManager.this.e0(view) + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).rightMargin;
                }
            };
            this.f7249h = callback;
            ViewBoundsCheck.Callback callback2 = new ViewBoundsCheck.Callback() { // from class: androidx.recyclerview.widget.RecyclerView.LayoutManager.2
                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public View a(int i8) {
                    return LayoutManager.this.T(i8);
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int b(View view) {
                    return LayoutManager.this.f0(view) - ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).topMargin;
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int c() {
                    return LayoutManager.this.getPaddingTop();
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int d() {
                    return LayoutManager.this.h0() - LayoutManager.this.getPaddingBottom();
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int e(View view) {
                    return LayoutManager.this.Z(view) + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).bottomMargin;
                }
            };
            this.f7250i = callback2;
            this.f7251j = new ViewBoundsCheck(callback);
            this.f7252k = new ViewBoundsCheck(callback2);
            this.f7254m = false;
            this.f7255n = false;
            this.f7256o = false;
            this.f7257p = true;
            this.f7258q = true;
        }

        private boolean A0(RecyclerView recyclerView, int i8, int i9) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int v02 = v0() - getPaddingRight();
            int h02 = h0() - getPaddingBottom();
            Rect rect = this.f7248g.f7197n;
            a0(focusedChild, rect);
            if (rect.left - i8 >= v02 || rect.right - i8 <= paddingLeft || rect.top - i9 >= h02 || rect.bottom - i9 <= paddingTop) {
                return false;
            }
            return true;
        }

        private static boolean E0(int i8, int i9, int i10) {
            int mode = View.MeasureSpec.getMode(i9);
            int size = View.MeasureSpec.getSize(i9);
            if (i10 > 0 && i8 != i10) {
                return false;
            }
            if (mode != Integer.MIN_VALUE) {
                if (mode == 0) {
                    return true;
                }
                if (mode != 1073741824 || size != i8) {
                    return false;
                }
                return true;
            } else if (size < i8) {
                return false;
            } else {
                return true;
            }
        }

        private void F1(Recycler recycler, int i8, View view) {
            ViewHolder k02 = RecyclerView.k0(view);
            if (k02.L()) {
                return;
            }
            if (k02.v() && !k02.x() && !this.f7248g.f7203q.v()) {
                A1(i8);
                recycler.C(k02);
                return;
            }
            I(i8);
            recycler.D(view);
            this.f7248g.f7191k.k(k02);
        }

        private void J(int i8, @NonNull View view) {
            this.f7247f.d(i8);
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
            if (r5 == 1073741824) goto L8;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static int V(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L1a
                if (r7 < 0) goto L11
                goto L1c
            L11:
                if (r7 != r1) goto L2f
                if (r5 == r2) goto L21
                if (r5 == 0) goto L2f
                if (r5 == r3) goto L21
                goto L2f
            L1a:
                if (r7 < 0) goto L1f
            L1c:
                r5 = 1073741824(0x40000000, float:2.0)
                goto L31
            L1f:
                if (r7 != r1) goto L23
            L21:
                r7 = r4
                goto L31
            L23:
                if (r7 != r0) goto L2f
                if (r5 == r2) goto L2c
                if (r5 != r3) goto L2a
                goto L2c
            L2a:
                r5 = 0
                goto L21
            L2c:
                r5 = -2147483648(0xffffffff80000000, float:-0.0)
                goto L21
            L2f:
                r5 = 0
                r7 = 0
            L31:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.V(int, int, int, int, boolean):int");
        }

        private int[] W(View view, Rect rect) {
            int[] iArr = new int[2];
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int v02 = v0() - getPaddingRight();
            int h02 = h0() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = rect.width() + left;
            int height = rect.height() + top;
            int i8 = left - paddingLeft;
            int min = Math.min(0, i8);
            int i9 = top - paddingTop;
            int min2 = Math.min(0, i9);
            int i10 = width - v02;
            int max = Math.max(0, i10);
            int max2 = Math.max(0, height - h02);
            if (k0() == 1) {
                if (max == 0) {
                    max = Math.max(min, i10);
                }
            } else {
                if (min == 0) {
                    min = Math.min(i8, max);
                }
                max = min;
            }
            if (min2 == 0) {
                min2 = Math.min(i9, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        public static Properties p0(@NonNull Context context, AttributeSet attributeSet, int i8, int i9) {
            Properties properties = new Properties();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f6876f, i8, i9);
            properties.f7267a = obtainStyledAttributes.getInt(R$styleable.f6877g, 1);
            properties.f7268b = obtainStyledAttributes.getInt(R$styleable.f6887q, 1);
            properties.f7269c = obtainStyledAttributes.getBoolean(R$styleable.f6886p, false);
            properties.f7270d = obtainStyledAttributes.getBoolean(R$styleable.f6888r, false);
            obtainStyledAttributes.recycle();
            return properties;
        }

        private void q(View view, int i8, boolean z7) {
            ViewHolder k02 = RecyclerView.k0(view);
            if (!z7 && !k02.x()) {
                this.f7248g.f7191k.p(k02);
            } else {
                this.f7248g.f7191k.b(k02);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (!k02.N() && !k02.y()) {
                if (view.getParent() == this.f7248g) {
                    int m8 = this.f7247f.m(view);
                    if (i8 == -1) {
                        i8 = this.f7247f.g();
                    }
                    if (m8 != -1) {
                        if (m8 != i8) {
                            this.f7248g.f7205r.K0(m8, i8);
                        }
                    } else {
                        throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f7248g.indexOfChild(view) + this.f7248g.R());
                    }
                } else {
                    this.f7247f.a(view, i8, false);
                    layoutParams.f7273h = true;
                    SmoothScroller smoothScroller = this.f7253l;
                    if (smoothScroller != null && smoothScroller.h()) {
                        this.f7253l.k(view);
                    }
                }
            } else {
                if (k02.y()) {
                    k02.M();
                } else {
                    k02.e();
                }
                this.f7247f.c(view, i8, view.getLayoutParams(), false);
            }
            if (layoutParams.f7274i) {
                k02.f7332a.invalidate();
                layoutParams.f7274i = false;
            }
        }

        public static int y(int i8, int i9, int i10) {
            int mode = View.MeasureSpec.getMode(i8);
            int size = View.MeasureSpec.getSize(i8);
            if (mode != Integer.MIN_VALUE) {
                if (mode != 1073741824) {
                    return Math.max(i9, i10);
                }
                return size;
            }
            return Math.min(size, Math.max(i9, i10));
        }

        public void A(int i8, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public void A1(int i8) {
            if (T(i8) != null) {
                this.f7247f.q(i8);
            }
        }

        public int B(@NonNull State state) {
            return 0;
        }

        public final boolean B0() {
            return this.f7258q;
        }

        public boolean B1(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z7) {
            return C1(recyclerView, view, rect, z7, false);
        }

        public int C(@NonNull State state) {
            return 0;
        }

        public boolean C0(@NonNull Recycler recycler, @NonNull State state) {
            return false;
        }

        public boolean C1(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z7, boolean z8) {
            int[] W = W(view, rect);
            int i8 = W[0];
            int i9 = W[1];
            if ((z8 && !A0(recyclerView, i8, i9)) || (i8 == 0 && i9 == 0)) {
                return false;
            }
            if (z7) {
                recyclerView.scrollBy(i8, i9);
            } else {
                recyclerView.t1(i8, i9);
            }
            return true;
        }

        public int D(@NonNull State state) {
            return 0;
        }

        public boolean D0() {
            return this.f7257p;
        }

        public void D1() {
            RecyclerView recyclerView = this.f7248g;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public int E(@NonNull State state) {
            return 0;
        }

        public void E1() {
            this.f7254m = true;
        }

        public int F(@NonNull State state) {
            return 0;
        }

        public boolean F0() {
            SmoothScroller smoothScroller = this.f7253l;
            if (smoothScroller != null && smoothScroller.h()) {
                return true;
            }
            return false;
        }

        public int G(@NonNull State state) {
            return 0;
        }

        public boolean G0(@NonNull View view, boolean z7, boolean z8) {
            boolean z9;
            if (this.f7251j.b(view, 24579) && this.f7252k.b(view, 24579)) {
                z9 = true;
            } else {
                z9 = false;
            }
            if (z7) {
                return z9;
            }
            return !z9;
        }

        public int G1(int i8, Recycler recycler, State state) {
            return 0;
        }

        public void H(@NonNull Recycler recycler) {
            for (int U = U() - 1; U >= 0; U--) {
                F1(recycler, U, T(U));
            }
        }

        public void H0(@NonNull View view, int i8, int i9, int i10, int i11) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f7272g;
            view.layout(i8 + rect.left, i9 + rect.top, i10 - rect.right, i11 - rect.bottom);
        }

        public void H1(int i8) {
        }

        public void I(int i8) {
            J(i8, T(i8));
        }

        public void I0(@NonNull View view, int i8, int i9, int i10, int i11) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.f7272g;
            view.layout(i8 + rect.left + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i9 + rect.top + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (i10 - rect.right) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, (i11 - rect.bottom) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        }

        public int I1(int i8, Recycler recycler, State state) {
            return 0;
        }

        public void J0(@NonNull View view, int i8, int i9) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect p02 = this.f7248g.p0(view);
            int i10 = i8 + p02.left + p02.right;
            int i11 = i9 + p02.top + p02.bottom;
            int V = V(v0(), w0(), getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + i10, ((ViewGroup.MarginLayoutParams) layoutParams).width, v());
            int V2 = V(h0(), i0(), getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + i11, ((ViewGroup.MarginLayoutParams) layoutParams).height, w());
            if (Q1(view, V, V2, layoutParams)) {
                view.measure(V, V2);
            }
        }

        @Deprecated
        public void J1(boolean z7) {
            this.f7256o = z7;
        }

        void K(RecyclerView recyclerView) {
            this.f7255n = true;
            P0(recyclerView);
        }

        public void K0(int i8, int i9) {
            View T = T(i8);
            if (T != null) {
                I(i8);
                s(T, i9);
                return;
            }
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i8 + this.f7248g.toString());
        }

        void K1(RecyclerView recyclerView) {
            L1(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), Pow2.MAX_POW2), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), Pow2.MAX_POW2));
        }

        void L(RecyclerView recyclerView, Recycler recycler) {
            this.f7255n = false;
            R0(recyclerView, recycler);
        }

        public void L0(int i8) {
            RecyclerView recyclerView = this.f7248g;
            if (recyclerView != null) {
                recyclerView.G0(i8);
            }
        }

        void L1(int i8, int i9) {
            this.f7263v = View.MeasureSpec.getSize(i8);
            int mode = View.MeasureSpec.getMode(i8);
            this.f7261t = mode;
            if (mode == 0 && !RecyclerView.J0) {
                this.f7263v = 0;
            }
            this.f7264w = View.MeasureSpec.getSize(i9);
            int mode2 = View.MeasureSpec.getMode(i9);
            this.f7262u = mode2;
            if (mode2 == 0 && !RecyclerView.J0) {
                this.f7264w = 0;
            }
        }

        public View M(@NonNull View view) {
            View U;
            RecyclerView recyclerView = this.f7248g;
            if (recyclerView == null || (U = recyclerView.U(view)) == null || this.f7247f.n(U)) {
                return null;
            }
            return U;
        }

        public void M0(int i8) {
            RecyclerView recyclerView = this.f7248g;
            if (recyclerView != null) {
                recyclerView.H0(i8);
            }
        }

        public void M1(int i8, int i9) {
            this.f7248g.setMeasuredDimension(i8, i9);
        }

        public View N(int i8) {
            int U = U();
            for (int i9 = 0; i9 < U; i9++) {
                View T = T(i9);
                ViewHolder k02 = RecyclerView.k0(T);
                if (k02 != null && k02.o() == i8 && !k02.L() && (this.f7248g.f7198n0.e() || !k02.x())) {
                    return T;
                }
            }
            return null;
        }

        public void N0(Adapter adapter, Adapter adapter2) {
        }

        public void N1(Rect rect, int i8, int i9) {
            M1(y(i8, rect.width() + getPaddingLeft() + getPaddingRight(), n0()), y(i9, rect.height() + getPaddingTop() + getPaddingBottom(), m0()));
        }

        public abstract LayoutParams O();

        public boolean O0(@NonNull RecyclerView recyclerView, @NonNull ArrayList<View> arrayList, int i8, int i9) {
            return false;
        }

        void O1(int i8, int i9) {
            int U = U();
            if (U == 0) {
                this.f7248g.y(i8, i9);
                return;
            }
            int i10 = Integer.MIN_VALUE;
            int i11 = Integer.MIN_VALUE;
            int i12 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            int i13 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            for (int i14 = 0; i14 < U; i14++) {
                View T = T(i14);
                Rect rect = this.f7248g.f7197n;
                a0(T, rect);
                int i15 = rect.left;
                if (i15 < i12) {
                    i12 = i15;
                }
                int i16 = rect.right;
                if (i16 > i10) {
                    i10 = i16;
                }
                int i17 = rect.top;
                if (i17 < i13) {
                    i13 = i17;
                }
                int i18 = rect.bottom;
                if (i18 > i11) {
                    i11 = i18;
                }
            }
            this.f7248g.f7197n.set(i12, i13, i10, i11);
            N1(this.f7248g.f7197n, i8, i9);
        }

        public LayoutParams P(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public void P0(RecyclerView recyclerView) {
        }

        void P1(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f7248g = null;
                this.f7247f = null;
                this.f7263v = 0;
                this.f7264w = 0;
            } else {
                this.f7248g = recyclerView;
                this.f7247f = recyclerView.f7189j;
                this.f7263v = recyclerView.getWidth();
                this.f7264w = recyclerView.getHeight();
            }
            this.f7261t = Pow2.MAX_POW2;
            this.f7262u = Pow2.MAX_POW2;
        }

        public LayoutParams Q(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }

        @Deprecated
        public void Q0(RecyclerView recyclerView) {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean Q1(View view, int i8, int i9, LayoutParams layoutParams) {
            if (!view.isLayoutRequested() && this.f7257p && E0(view.getWidth(), i8, ((ViewGroup.MarginLayoutParams) layoutParams).width) && E0(view.getHeight(), i9, ((ViewGroup.MarginLayoutParams) layoutParams).height)) {
                return false;
            }
            return true;
        }

        public int R() {
            return -1;
        }

        public void R0(RecyclerView recyclerView, Recycler recycler) {
            Q0(recyclerView);
        }

        boolean R1() {
            return false;
        }

        public int S(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).f7272g.bottom;
        }

        public View S0(@NonNull View view, int i8, @NonNull Recycler recycler, @NonNull State state) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean S1(View view, int i8, int i9, LayoutParams layoutParams) {
            if (this.f7257p && E0(view.getMeasuredWidth(), i8, ((ViewGroup.MarginLayoutParams) layoutParams).width) && E0(view.getMeasuredHeight(), i9, ((ViewGroup.MarginLayoutParams) layoutParams).height)) {
                return false;
            }
            return true;
        }

        public View T(int i8) {
            ChildHelper childHelper = this.f7247f;
            if (childHelper != null) {
                return childHelper.f(i8);
            }
            return null;
        }

        public void T0(@NonNull AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f7248g;
            U0(recyclerView.f7183g, recyclerView.f7198n0, accessibilityEvent);
        }

        public void T1(RecyclerView recyclerView, State state, int i8) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public int U() {
            ChildHelper childHelper = this.f7247f;
            if (childHelper != null) {
                return childHelper.g();
            }
            return 0;
        }

        public void U0(@NonNull Recycler recycler, @NonNull State state, @NonNull AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f7248g;
            if (recyclerView != null && accessibilityEvent != null) {
                boolean z7 = true;
                if (!recyclerView.canScrollVertically(1) && !this.f7248g.canScrollVertically(-1) && !this.f7248g.canScrollHorizontally(-1) && !this.f7248g.canScrollHorizontally(1)) {
                    z7 = false;
                }
                accessibilityEvent.setScrollable(z7);
                Adapter adapter = this.f7248g.f7203q;
                if (adapter != null) {
                    accessibilityEvent.setItemCount(adapter.r());
                }
            }
        }

        public void U1(SmoothScroller smoothScroller) {
            SmoothScroller smoothScroller2 = this.f7253l;
            if (smoothScroller2 != null && smoothScroller != smoothScroller2 && smoothScroller2.h()) {
                this.f7253l.r();
            }
            this.f7253l = smoothScroller;
            smoothScroller.q(this.f7248g, this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void V0(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            RecyclerView recyclerView = this.f7248g;
            W0(recyclerView.f7183g, recyclerView.f7198n0, accessibilityNodeInfoCompat);
        }

        void V1() {
            SmoothScroller smoothScroller = this.f7253l;
            if (smoothScroller != null) {
                smoothScroller.r();
            }
        }

        public void W0(@NonNull Recycler recycler, @NonNull State state, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (this.f7248g.canScrollVertically(-1) || this.f7248g.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.a(FragmentTransaction.TRANSIT_EXIT_MASK);
                accessibilityNodeInfoCompat.s0(true);
            }
            if (this.f7248g.canScrollVertically(1) || this.f7248g.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.a(4096);
                accessibilityNodeInfoCompat.s0(true);
            }
            accessibilityNodeInfoCompat.a0(AccessibilityNodeInfoCompat.CollectionInfoCompat.a(r0(recycler, state), Y(recycler, state), C0(recycler, state), s0(recycler, state)));
        }

        public boolean W1() {
            return false;
        }

        public boolean X() {
            RecyclerView recyclerView = this.f7248g;
            if (recyclerView != null && recyclerView.f7193l) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void X0(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ViewHolder k02 = RecyclerView.k0(view);
            if (k02 != null && !k02.x() && !this.f7247f.n(k02.f7332a)) {
                RecyclerView recyclerView = this.f7248g;
                Y0(recyclerView.f7183g, recyclerView.f7198n0, view, accessibilityNodeInfoCompat);
            }
        }

        public int Y(@NonNull Recycler recycler, @NonNull State state) {
            return -1;
        }

        public void Y0(@NonNull Recycler recycler, @NonNull State state, @NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        public int Z(@NonNull View view) {
            return view.getBottom() + S(view);
        }

        public View Z0(@NonNull View view, int i8) {
            return null;
        }

        public void a0(@NonNull View view, @NonNull Rect rect) {
            RecyclerView.m0(view, rect);
        }

        public void a1(@NonNull RecyclerView recyclerView, int i8, int i9) {
        }

        public int b0(@NonNull View view) {
            return view.getLeft() - l0(view);
        }

        public void b1(@NonNull RecyclerView recyclerView) {
        }

        public int c0(@NonNull View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f7272g;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void c1(@NonNull RecyclerView recyclerView, int i8, int i9, int i10) {
        }

        public int d0(@NonNull View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f7272g;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public void d1(@NonNull RecyclerView recyclerView, int i8, int i9) {
        }

        public int e0(@NonNull View view) {
            return view.getRight() + q0(view);
        }

        public void e1(@NonNull RecyclerView recyclerView, int i8, int i9) {
        }

        public int f0(@NonNull View view) {
            return view.getTop() - t0(view);
        }

        public void f1(@NonNull RecyclerView recyclerView, int i8, int i9, Object obj) {
            e1(recyclerView, i8, i9);
        }

        public View g0() {
            View focusedChild;
            RecyclerView recyclerView = this.f7248g;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f7247f.n(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void g1(Recycler recycler, State state) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public int getPaddingBottom() {
            RecyclerView recyclerView = this.f7248g;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingEnd() {
            RecyclerView recyclerView = this.f7248g;
            if (recyclerView != null) {
                return ViewCompat.I(recyclerView);
            }
            return 0;
        }

        public int getPaddingLeft() {
            RecyclerView recyclerView = this.f7248g;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingRight() {
            RecyclerView recyclerView = this.f7248g;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingStart() {
            RecyclerView recyclerView = this.f7248g;
            if (recyclerView != null) {
                return ViewCompat.J(recyclerView);
            }
            return 0;
        }

        public int getPaddingTop() {
            RecyclerView recyclerView = this.f7248g;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int h0() {
            return this.f7264w;
        }

        public void h1(State state) {
        }

        public int i0() {
            return this.f7262u;
        }

        public void i1(@NonNull Recycler recycler, @NonNull State state, int i8, int i9) {
            this.f7248g.y(i8, i9);
        }

        public int j0() {
            Adapter adapter;
            RecyclerView recyclerView = this.f7248g;
            if (recyclerView != null) {
                adapter = recyclerView.getAdapter();
            } else {
                adapter = null;
            }
            if (adapter != null) {
                return adapter.r();
            }
            return 0;
        }

        @Deprecated
        public boolean j1(@NonNull RecyclerView recyclerView, @NonNull View view, View view2) {
            if (!F0() && !recyclerView.A0()) {
                return false;
            }
            return true;
        }

        public int k0() {
            return ViewCompat.E(this.f7248g);
        }

        public boolean k1(@NonNull RecyclerView recyclerView, @NonNull State state, @NonNull View view, View view2) {
            return j1(recyclerView, view, view2);
        }

        public int l0(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).f7272g.left;
        }

        public void l1(Parcelable parcelable) {
        }

        public void m(View view) {
            n(view, -1);
        }

        public int m0() {
            return ViewCompat.F(this.f7248g);
        }

        public Parcelable m1() {
            return null;
        }

        public void n(View view, int i8) {
            q(view, i8, true);
        }

        public int n0() {
            return ViewCompat.G(this.f7248g);
        }

        public void n1(int i8) {
        }

        public void o(View view) {
            p(view, -1);
        }

        public int o0(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).a();
        }

        void o1(SmoothScroller smoothScroller) {
            if (this.f7253l == smoothScroller) {
                this.f7253l = null;
            }
        }

        public void p(View view, int i8) {
            q(view, i8, false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean p1(int i8, Bundle bundle) {
            RecyclerView recyclerView = this.f7248g;
            return q1(recyclerView.f7183g, recyclerView.f7198n0, i8, bundle);
        }

        public int q0(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).f7272g.right;
        }

        public boolean q1(@NonNull Recycler recycler, @NonNull State state, int i8, Bundle bundle) {
            int i9;
            int v02;
            int i10;
            int i11;
            RecyclerView recyclerView = this.f7248g;
            if (recyclerView == null) {
                return false;
            }
            if (i8 != 4096) {
                if (i8 != 8192) {
                    i11 = 0;
                    i10 = 0;
                } else {
                    if (recyclerView.canScrollVertically(-1)) {
                        i9 = -((h0() - getPaddingTop()) - getPaddingBottom());
                    } else {
                        i9 = 0;
                    }
                    if (this.f7248g.canScrollHorizontally(-1)) {
                        v02 = -((v0() - getPaddingLeft()) - getPaddingRight());
                        i10 = i9;
                        i11 = v02;
                    }
                    i10 = i9;
                    i11 = 0;
                }
            } else {
                if (recyclerView.canScrollVertically(1)) {
                    i9 = (h0() - getPaddingTop()) - getPaddingBottom();
                } else {
                    i9 = 0;
                }
                if (this.f7248g.canScrollHorizontally(1)) {
                    v02 = (v0() - getPaddingLeft()) - getPaddingRight();
                    i10 = i9;
                    i11 = v02;
                }
                i10 = i9;
                i11 = 0;
            }
            if (i10 == 0 && i11 == 0) {
                return false;
            }
            this.f7248g.w1(i11, i10, null, Integer.MIN_VALUE, true);
            return true;
        }

        public void r(String str) {
            RecyclerView recyclerView = this.f7248g;
            if (recyclerView != null) {
                recyclerView.p(str);
            }
        }

        public int r0(@NonNull Recycler recycler, @NonNull State state) {
            return -1;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean r1(@NonNull View view, int i8, Bundle bundle) {
            RecyclerView recyclerView = this.f7248g;
            return s1(recyclerView.f7183g, recyclerView.f7198n0, view, i8, bundle);
        }

        public void s(@NonNull View view, int i8) {
            t(view, i8, (LayoutParams) view.getLayoutParams());
        }

        public int s0(@NonNull Recycler recycler, @NonNull State state) {
            return 0;
        }

        public boolean s1(@NonNull Recycler recycler, @NonNull State state, @NonNull View view, int i8, Bundle bundle) {
            return false;
        }

        public void t(@NonNull View view, int i8, LayoutParams layoutParams) {
            ViewHolder k02 = RecyclerView.k0(view);
            if (k02.x()) {
                this.f7248g.f7191k.b(k02);
            } else {
                this.f7248g.f7191k.p(k02);
            }
            this.f7247f.c(view, i8, layoutParams, k02.x());
        }

        public int t0(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).f7272g.top;
        }

        public void t1() {
            for (int U = U() - 1; U >= 0; U--) {
                this.f7247f.q(U);
            }
        }

        public void u(@NonNull View view, @NonNull Rect rect) {
            RecyclerView recyclerView = this.f7248g;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.p0(view));
            }
        }

        public void u0(@NonNull View view, boolean z7, @NonNull Rect rect) {
            Matrix matrix;
            if (z7) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).f7272g;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.f7248g != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.f7248g.f7201p;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void u1(@NonNull Recycler recycler) {
            for (int U = U() - 1; U >= 0; U--) {
                if (!RecyclerView.k0(T(U)).L()) {
                    x1(U, recycler);
                }
            }
        }

        public boolean v() {
            return false;
        }

        public int v0() {
            return this.f7263v;
        }

        void v1(Recycler recycler) {
            int j8 = recycler.j();
            for (int i8 = j8 - 1; i8 >= 0; i8--) {
                View n8 = recycler.n(i8);
                ViewHolder k02 = RecyclerView.k0(n8);
                if (!k02.L()) {
                    k02.I(false);
                    if (k02.z()) {
                        this.f7248g.removeDetachedView(n8, false);
                    }
                    ItemAnimator itemAnimator = this.f7248g.S;
                    if (itemAnimator != null) {
                        itemAnimator.j(k02);
                    }
                    k02.I(true);
                    recycler.y(n8);
                }
            }
            recycler.e();
            if (j8 > 0) {
                this.f7248g.invalidate();
            }
        }

        public boolean w() {
            return false;
        }

        public int w0() {
            return this.f7261t;
        }

        public void w1(@NonNull View view, @NonNull Recycler recycler) {
            z1(view);
            recycler.B(view);
        }

        public boolean x(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean x0() {
            int U = U();
            for (int i8 = 0; i8 < U; i8++) {
                ViewGroup.LayoutParams layoutParams = T(i8).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public void x1(int i8, @NonNull Recycler recycler) {
            View T = T(i8);
            A1(i8);
            recycler.B(T);
        }

        public boolean y0() {
            return this.f7255n;
        }

        public boolean y1(Runnable runnable) {
            RecyclerView recyclerView = this.f7248g;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void z(int i8, int i9, State state, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public boolean z0() {
            return this.f7256o;
        }

        public void z1(View view) {
            this.f7247f.p(view);
        }
    }

    /* loaded from: classes.dex */
    public interface OnChildAttachStateChangeListener {
        void b(@NonNull View view);

        void d(@NonNull View view);
    }

    /* loaded from: classes.dex */
    public static abstract class OnFlingListener {
        public abstract boolean a(int i8, int i9);
    }

    /* loaded from: classes.dex */
    public interface OnItemTouchListener {
        void a(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent);

        boolean c(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent);

        void e(boolean z7);
    }

    /* loaded from: classes.dex */
    public static abstract class OnScrollListener {
        public void a(@NonNull RecyclerView recyclerView, int i8) {
        }

        public void b(@NonNull RecyclerView recyclerView, int i8, int i9) {
        }
    }

    /* loaded from: classes.dex */
    public static class RecycledViewPool {

        /* renamed from: a  reason: collision with root package name */
        SparseArray<ScrapData> f7275a = new SparseArray<>();

        /* renamed from: b  reason: collision with root package name */
        private int f7276b = 0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class ScrapData {

            /* renamed from: a  reason: collision with root package name */
            final ArrayList<ViewHolder> f7277a = new ArrayList<>();

            /* renamed from: b  reason: collision with root package name */
            int f7278b = 5;

            /* renamed from: c  reason: collision with root package name */
            long f7279c = 0;

            /* renamed from: d  reason: collision with root package name */
            long f7280d = 0;

            ScrapData() {
            }
        }

        private ScrapData g(int i8) {
            ScrapData scrapData = this.f7275a.get(i8);
            if (scrapData == null) {
                ScrapData scrapData2 = new ScrapData();
                this.f7275a.put(i8, scrapData2);
                return scrapData2;
            }
            return scrapData;
        }

        void a() {
            this.f7276b++;
        }

        public void b() {
            for (int i8 = 0; i8 < this.f7275a.size(); i8++) {
                this.f7275a.valueAt(i8).f7277a.clear();
            }
        }

        void c() {
            this.f7276b--;
        }

        void d(int i8, long j8) {
            ScrapData g8 = g(i8);
            g8.f7280d = j(g8.f7280d, j8);
        }

        void e(int i8, long j8) {
            ScrapData g8 = g(i8);
            g8.f7279c = j(g8.f7279c, j8);
        }

        public ViewHolder f(int i8) {
            ScrapData scrapData = this.f7275a.get(i8);
            if (scrapData != null && !scrapData.f7277a.isEmpty()) {
                ArrayList<ViewHolder> arrayList = scrapData.f7277a;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!arrayList.get(size).t()) {
                        return arrayList.remove(size);
                    }
                }
                return null;
            }
            return null;
        }

        void h(Adapter adapter, Adapter adapter2, boolean z7) {
            if (adapter != null) {
                c();
            }
            if (!z7 && this.f7276b == 0) {
                b();
            }
            if (adapter2 != null) {
                a();
            }
        }

        public void i(ViewHolder viewHolder) {
            int n8 = viewHolder.n();
            ArrayList<ViewHolder> arrayList = g(n8).f7277a;
            if (this.f7275a.get(n8).f7278b <= arrayList.size()) {
                return;
            }
            viewHolder.F();
            arrayList.add(viewHolder);
        }

        long j(long j8, long j9) {
            if (j8 == 0) {
                return j9;
            }
            return ((j8 / 4) * 3) + (j9 / 4);
        }

        boolean k(int i8, long j8, long j9) {
            long j10 = g(i8).f7280d;
            if (j10 != 0 && j8 + j10 >= j9) {
                return false;
            }
            return true;
        }

        boolean l(int i8, long j8, long j9) {
            long j10 = g(i8).f7279c;
            if (j10 != 0 && j8 + j10 >= j9) {
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public final class Recycler {

        /* renamed from: a  reason: collision with root package name */
        final ArrayList<ViewHolder> f7281a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList<ViewHolder> f7282b;

        /* renamed from: c  reason: collision with root package name */
        final ArrayList<ViewHolder> f7283c;

        /* renamed from: d  reason: collision with root package name */
        private final List<ViewHolder> f7284d;

        /* renamed from: e  reason: collision with root package name */
        private int f7285e;

        /* renamed from: f  reason: collision with root package name */
        int f7286f;

        /* renamed from: g  reason: collision with root package name */
        RecycledViewPool f7287g;

        /* renamed from: h  reason: collision with root package name */
        private ViewCacheExtension f7288h;

        public Recycler() {
            ArrayList<ViewHolder> arrayList = new ArrayList<>();
            this.f7281a = arrayList;
            this.f7282b = null;
            this.f7283c = new ArrayList<>();
            this.f7284d = Collections.unmodifiableList(arrayList);
            this.f7285e = 2;
            this.f7286f = 2;
        }

        private boolean H(@NonNull ViewHolder viewHolder, int i8, int i9, long j8) {
            viewHolder.f7350s = null;
            viewHolder.f7349r = RecyclerView.this;
            int n8 = viewHolder.n();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j8 != Long.MAX_VALUE && !this.f7287g.k(n8, nanoTime, j8)) {
                return false;
            }
            RecyclerView.this.f7203q.n(viewHolder, i8);
            this.f7287g.d(viewHolder.n(), RecyclerView.this.getNanoTime() - nanoTime);
            b(viewHolder);
            if (RecyclerView.this.f7198n0.e()) {
                viewHolder.f7338g = i9;
                return true;
            }
            return true;
        }

        private void b(ViewHolder viewHolder) {
            if (RecyclerView.this.z0()) {
                View view = viewHolder.f7332a;
                if (ViewCompat.C(view) == 0) {
                    ViewCompat.D0(view, 1);
                }
                RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate = RecyclerView.this.f7212u0;
                if (recyclerViewAccessibilityDelegate == null) {
                    return;
                }
                AccessibilityDelegateCompat n8 = recyclerViewAccessibilityDelegate.n();
                if (n8 instanceof RecyclerViewAccessibilityDelegate.ItemDelegate) {
                    ((RecyclerViewAccessibilityDelegate.ItemDelegate) n8).o(view);
                }
                ViewCompat.s0(view, n8);
            }
        }

        private void q(ViewGroup viewGroup, boolean z7) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    q((ViewGroup) childAt, true);
                }
            }
            if (!z7) {
                return;
            }
            if (viewGroup.getVisibility() == 4) {
                viewGroup.setVisibility(0);
                viewGroup.setVisibility(4);
                return;
            }
            int visibility = viewGroup.getVisibility();
            viewGroup.setVisibility(4);
            viewGroup.setVisibility(visibility);
        }

        private void r(ViewHolder viewHolder) {
            View view = viewHolder.f7332a;
            if (view instanceof ViewGroup) {
                q((ViewGroup) view, false);
            }
        }

        void A(int i8) {
            a(this.f7283c.get(i8), true);
            this.f7283c.remove(i8);
        }

        public void B(@NonNull View view) {
            ViewHolder k02 = RecyclerView.k0(view);
            if (k02.z()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (k02.y()) {
                k02.M();
            } else if (k02.N()) {
                k02.e();
            }
            C(k02);
            if (RecyclerView.this.S != null && !k02.w()) {
                RecyclerView.this.S.j(k02);
            }
        }

        void C(ViewHolder viewHolder) {
            boolean z7;
            boolean z8;
            boolean z9 = false;
            boolean z10 = true;
            if (!viewHolder.y() && viewHolder.f7332a.getParent() == null) {
                if (!viewHolder.z()) {
                    if (!viewHolder.L()) {
                        boolean h8 = viewHolder.h();
                        Adapter adapter = RecyclerView.this.f7203q;
                        if (adapter != null && h8 && adapter.I(viewHolder)) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        if (z7 || viewHolder.w()) {
                            if (this.f7286f > 0 && !viewHolder.r(526)) {
                                int size = this.f7283c.size();
                                if (size >= this.f7286f && size > 0) {
                                    A(0);
                                    size--;
                                }
                                if (RecyclerView.L0 && size > 0 && !RecyclerView.this.f7196m0.d(viewHolder.f7334c)) {
                                    int i8 = size - 1;
                                    while (i8 >= 0) {
                                        if (!RecyclerView.this.f7196m0.d(this.f7283c.get(i8).f7334c)) {
                                            break;
                                        }
                                        i8--;
                                    }
                                    size = i8 + 1;
                                }
                                this.f7283c.add(size, viewHolder);
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            if (!z8) {
                                a(viewHolder, true);
                                z9 = z8;
                                RecyclerView.this.f7191k.q(viewHolder);
                                if (z9 && !z10 && h8) {
                                    viewHolder.f7350s = null;
                                    viewHolder.f7349r = null;
                                    return;
                                }
                                return;
                            }
                            z9 = z8;
                        }
                        z10 = false;
                        RecyclerView.this.f7191k.q(viewHolder);
                        if (z9) {
                            return;
                        }
                        return;
                    }
                    throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.R());
                }
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + viewHolder + RecyclerView.this.R());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Scrapped or attached views may not be recycled. isScrap:");
            sb.append(viewHolder.y());
            sb.append(" isAttached:");
            if (viewHolder.f7332a.getParent() != null) {
                z9 = true;
            }
            sb.append(z9);
            sb.append(RecyclerView.this.R());
            throw new IllegalArgumentException(sb.toString());
        }

        void D(View view) {
            ViewHolder k02 = RecyclerView.k0(view);
            if (!k02.r(12) && k02.A() && !RecyclerView.this.q(k02)) {
                if (this.f7282b == null) {
                    this.f7282b = new ArrayList<>();
                }
                k02.J(this, true);
                this.f7282b.add(k02);
            } else if (k02.v() && !k02.x() && !RecyclerView.this.f7203q.v()) {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.R());
            } else {
                k02.J(this, false);
                this.f7281a.add(k02);
            }
        }

        void E(RecycledViewPool recycledViewPool) {
            RecycledViewPool recycledViewPool2 = this.f7287g;
            if (recycledViewPool2 != null) {
                recycledViewPool2.c();
            }
            this.f7287g = recycledViewPool;
            if (recycledViewPool != null && RecyclerView.this.getAdapter() != null) {
                this.f7287g.a();
            }
        }

        void F(ViewCacheExtension viewCacheExtension) {
            this.f7288h = viewCacheExtension;
        }

        public void G(int i8) {
            this.f7285e = i8;
            K();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Removed duplicated region for block: B:100:0x020c  */
        /* JADX WARN: Removed duplicated region for block: B:106:0x0228 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x0185  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x01a2  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x01c5  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x01d4  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x01fe  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public androidx.recyclerview.widget.RecyclerView.ViewHolder I(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instructions count: 615
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.Recycler.I(int, boolean, long):androidx.recyclerview.widget.RecyclerView$ViewHolder");
        }

        void J(ViewHolder viewHolder) {
            if (viewHolder.f7346o) {
                this.f7282b.remove(viewHolder);
            } else {
                this.f7281a.remove(viewHolder);
            }
            viewHolder.f7345n = null;
            viewHolder.f7346o = false;
            viewHolder.e();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void K() {
            int i8;
            LayoutManager layoutManager = RecyclerView.this.f7205r;
            if (layoutManager != null) {
                i8 = layoutManager.f7259r;
            } else {
                i8 = 0;
            }
            this.f7286f = this.f7285e + i8;
            for (int size = this.f7283c.size() - 1; size >= 0 && this.f7283c.size() > this.f7286f; size--) {
                A(size);
            }
        }

        boolean L(ViewHolder viewHolder) {
            if (viewHolder.x()) {
                return RecyclerView.this.f7198n0.e();
            }
            int i8 = viewHolder.f7334c;
            if (i8 >= 0 && i8 < RecyclerView.this.f7203q.r()) {
                if (!RecyclerView.this.f7198n0.e() && RecyclerView.this.f7203q.t(viewHolder.f7334c) != viewHolder.n()) {
                    return false;
                }
                if (RecyclerView.this.f7203q.v() && viewHolder.m() != RecyclerView.this.f7203q.s(viewHolder.f7334c)) {
                    return false;
                }
                return true;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + viewHolder + RecyclerView.this.R());
        }

        void M(int i8, int i9) {
            int i10;
            int i11 = i9 + i8;
            for (int size = this.f7283c.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.f7283c.get(size);
                if (viewHolder != null && (i10 = viewHolder.f7334c) >= i8 && i10 < i11) {
                    viewHolder.b(2);
                    A(size);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(@NonNull ViewHolder viewHolder, boolean z7) {
            AccessibilityDelegateCompat accessibilityDelegateCompat;
            RecyclerView.s(viewHolder);
            View view = viewHolder.f7332a;
            RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate = RecyclerView.this.f7212u0;
            if (recyclerViewAccessibilityDelegate != null) {
                AccessibilityDelegateCompat n8 = recyclerViewAccessibilityDelegate.n();
                if (n8 instanceof RecyclerViewAccessibilityDelegate.ItemDelegate) {
                    accessibilityDelegateCompat = ((RecyclerViewAccessibilityDelegate.ItemDelegate) n8).n(view);
                } else {
                    accessibilityDelegateCompat = null;
                }
                ViewCompat.s0(view, accessibilityDelegateCompat);
            }
            if (z7) {
                g(viewHolder);
            }
            viewHolder.f7350s = null;
            viewHolder.f7349r = null;
            i().i(viewHolder);
        }

        public void c() {
            this.f7281a.clear();
            z();
        }

        void d() {
            int size = this.f7283c.size();
            for (int i8 = 0; i8 < size; i8++) {
                this.f7283c.get(i8).c();
            }
            int size2 = this.f7281a.size();
            for (int i9 = 0; i9 < size2; i9++) {
                this.f7281a.get(i9).c();
            }
            ArrayList<ViewHolder> arrayList = this.f7282b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i10 = 0; i10 < size3; i10++) {
                    this.f7282b.get(i10).c();
                }
            }
        }

        void e() {
            this.f7281a.clear();
            ArrayList<ViewHolder> arrayList = this.f7282b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public int f(int i8) {
            if (i8 >= 0 && i8 < RecyclerView.this.f7198n0.b()) {
                if (!RecyclerView.this.f7198n0.e()) {
                    return i8;
                }
                return RecyclerView.this.f7187i.m(i8);
            }
            throw new IndexOutOfBoundsException("invalid position " + i8 + ". State item count is " + RecyclerView.this.f7198n0.b() + RecyclerView.this.R());
        }

        void g(@NonNull ViewHolder viewHolder) {
            RecyclerListener recyclerListener = RecyclerView.this.f7207s;
            if (recyclerListener != null) {
                recyclerListener.a(viewHolder);
            }
            int size = RecyclerView.this.f7209t.size();
            for (int i8 = 0; i8 < size; i8++) {
                RecyclerView.this.f7209t.get(i8).a(viewHolder);
            }
            Adapter adapter = RecyclerView.this.f7203q;
            if (adapter != null) {
                adapter.L(viewHolder);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f7198n0 != null) {
                recyclerView.f7191k.q(viewHolder);
            }
        }

        ViewHolder h(int i8) {
            int size;
            int m8;
            ArrayList<ViewHolder> arrayList = this.f7282b;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i9 = 0; i9 < size; i9++) {
                    ViewHolder viewHolder = this.f7282b.get(i9);
                    if (!viewHolder.N() && viewHolder.o() == i8) {
                        viewHolder.b(32);
                        return viewHolder;
                    }
                }
                if (RecyclerView.this.f7203q.v() && (m8 = RecyclerView.this.f7187i.m(i8)) > 0 && m8 < RecyclerView.this.f7203q.r()) {
                    long s7 = RecyclerView.this.f7203q.s(m8);
                    for (int i10 = 0; i10 < size; i10++) {
                        ViewHolder viewHolder2 = this.f7282b.get(i10);
                        if (!viewHolder2.N() && viewHolder2.m() == s7) {
                            viewHolder2.b(32);
                            return viewHolder2;
                        }
                    }
                }
            }
            return null;
        }

        RecycledViewPool i() {
            if (this.f7287g == null) {
                this.f7287g = new RecycledViewPool();
            }
            return this.f7287g;
        }

        int j() {
            return this.f7281a.size();
        }

        @NonNull
        public List<ViewHolder> k() {
            return this.f7284d;
        }

        ViewHolder l(long j8, int i8, boolean z7) {
            for (int size = this.f7281a.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.f7281a.get(size);
                if (viewHolder.m() == j8 && !viewHolder.N()) {
                    if (i8 == viewHolder.n()) {
                        viewHolder.b(32);
                        if (viewHolder.x() && !RecyclerView.this.f7198n0.e()) {
                            viewHolder.H(2, 14);
                        }
                        return viewHolder;
                    } else if (!z7) {
                        this.f7281a.remove(size);
                        RecyclerView.this.removeDetachedView(viewHolder.f7332a, false);
                        y(viewHolder.f7332a);
                    }
                }
            }
            int size2 = this.f7283c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                ViewHolder viewHolder2 = this.f7283c.get(size2);
                if (viewHolder2.m() == j8 && !viewHolder2.t()) {
                    if (i8 == viewHolder2.n()) {
                        if (!z7) {
                            this.f7283c.remove(size2);
                        }
                        return viewHolder2;
                    } else if (!z7) {
                        A(size2);
                        return null;
                    }
                }
            }
        }

        ViewHolder m(int i8, boolean z7) {
            View e8;
            int size = this.f7281a.size();
            for (int i9 = 0; i9 < size; i9++) {
                ViewHolder viewHolder = this.f7281a.get(i9);
                if (!viewHolder.N() && viewHolder.o() == i8 && !viewHolder.v() && (RecyclerView.this.f7198n0.f7314h || !viewHolder.x())) {
                    viewHolder.b(32);
                    return viewHolder;
                }
            }
            if (!z7 && (e8 = RecyclerView.this.f7189j.e(i8)) != null) {
                ViewHolder k02 = RecyclerView.k0(e8);
                RecyclerView.this.f7189j.s(e8);
                int m8 = RecyclerView.this.f7189j.m(e8);
                if (m8 != -1) {
                    RecyclerView.this.f7189j.d(m8);
                    D(e8);
                    k02.b(8224);
                    return k02;
                }
                throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + k02 + RecyclerView.this.R());
            }
            int size2 = this.f7283c.size();
            for (int i10 = 0; i10 < size2; i10++) {
                ViewHolder viewHolder2 = this.f7283c.get(i10);
                if (!viewHolder2.v() && viewHolder2.o() == i8 && !viewHolder2.t()) {
                    if (!z7) {
                        this.f7283c.remove(i10);
                    }
                    return viewHolder2;
                }
            }
            return null;
        }

        View n(int i8) {
            return this.f7281a.get(i8).f7332a;
        }

        @NonNull
        public View o(int i8) {
            return p(i8, false);
        }

        View p(int i8, boolean z7) {
            return I(i8, z7, Long.MAX_VALUE).f7332a;
        }

        void s() {
            int size = this.f7283c.size();
            for (int i8 = 0; i8 < size; i8++) {
                LayoutParams layoutParams = (LayoutParams) this.f7283c.get(i8).f7332a.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.f7273h = true;
                }
            }
        }

        void t() {
            int size = this.f7283c.size();
            for (int i8 = 0; i8 < size; i8++) {
                ViewHolder viewHolder = this.f7283c.get(i8);
                if (viewHolder != null) {
                    viewHolder.b(6);
                    viewHolder.a(null);
                }
            }
            Adapter adapter = RecyclerView.this.f7203q;
            if (adapter == null || !adapter.v()) {
                z();
            }
        }

        void u(int i8, int i9) {
            int size = this.f7283c.size();
            for (int i10 = 0; i10 < size; i10++) {
                ViewHolder viewHolder = this.f7283c.get(i10);
                if (viewHolder != null && viewHolder.f7334c >= i8) {
                    viewHolder.C(i9, false);
                }
            }
        }

        void v(int i8, int i9) {
            int i10;
            int i11;
            int i12;
            int i13;
            if (i8 < i9) {
                i10 = -1;
                i12 = i8;
                i11 = i9;
            } else {
                i10 = 1;
                i11 = i8;
                i12 = i9;
            }
            int size = this.f7283c.size();
            for (int i14 = 0; i14 < size; i14++) {
                ViewHolder viewHolder = this.f7283c.get(i14);
                if (viewHolder != null && (i13 = viewHolder.f7334c) >= i12 && i13 <= i11) {
                    if (i13 == i8) {
                        viewHolder.C(i9 - i8, false);
                    } else {
                        viewHolder.C(i10, false);
                    }
                }
            }
        }

        void w(int i8, int i9, boolean z7) {
            int i10 = i8 + i9;
            for (int size = this.f7283c.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.f7283c.get(size);
                if (viewHolder != null) {
                    int i11 = viewHolder.f7334c;
                    if (i11 >= i10) {
                        viewHolder.C(-i9, z7);
                    } else if (i11 >= i8) {
                        viewHolder.b(8);
                        A(size);
                    }
                }
            }
        }

        void x(Adapter adapter, Adapter adapter2, boolean z7) {
            c();
            i().h(adapter, adapter2, z7);
        }

        void y(View view) {
            ViewHolder k02 = RecyclerView.k0(view);
            k02.f7345n = null;
            k02.f7346o = false;
            k02.e();
            C(k02);
        }

        void z() {
            for (int size = this.f7283c.size() - 1; size >= 0; size--) {
                A(size);
            }
            this.f7283c.clear();
            if (RecyclerView.L0) {
                RecyclerView.this.f7196m0.b();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface RecyclerListener {
        void a(@NonNull ViewHolder viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class RecyclerViewDataObserver extends AdapterDataObserver {
        RecyclerViewDataObserver() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void a() {
            RecyclerView.this.p(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f7198n0.f7313g = true;
            recyclerView.W0(true);
            if (!RecyclerView.this.f7187i.p()) {
                RecyclerView.this.requestLayout();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void c(int i8, int i9, Object obj) {
            RecyclerView.this.p(null);
            if (RecyclerView.this.f7187i.r(i8, i9, obj)) {
                g();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void d(int i8, int i9) {
            RecyclerView.this.p(null);
            if (RecyclerView.this.f7187i.s(i8, i9)) {
                g();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void e(int i8, int i9, int i10) {
            RecyclerView.this.p(null);
            if (RecyclerView.this.f7187i.t(i8, i9, i10)) {
                g();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void f(int i8, int i9) {
            RecyclerView.this.p(null);
            if (RecyclerView.this.f7187i.u(i8, i9)) {
                g();
            }
        }

        void g() {
            if (RecyclerView.K0) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.f7219y && recyclerView.f7217x) {
                    ViewCompat.k0(recyclerView, recyclerView.f7195m);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.G = true;
            recyclerView2.requestLayout();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class SmoothScroller {

        /* renamed from: b  reason: collision with root package name */
        private RecyclerView f7293b;

        /* renamed from: c  reason: collision with root package name */
        private LayoutManager f7294c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f7295d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f7296e;

        /* renamed from: f  reason: collision with root package name */
        private View f7297f;

        /* renamed from: h  reason: collision with root package name */
        private boolean f7299h;

        /* renamed from: a  reason: collision with root package name */
        private int f7292a = -1;

        /* renamed from: g  reason: collision with root package name */
        private final Action f7298g = new Action(0, 0);

        /* loaded from: classes.dex */
        public static class Action {

            /* renamed from: a  reason: collision with root package name */
            private int f7300a;

            /* renamed from: b  reason: collision with root package name */
            private int f7301b;

            /* renamed from: c  reason: collision with root package name */
            private int f7302c;

            /* renamed from: d  reason: collision with root package name */
            private int f7303d;

            /* renamed from: e  reason: collision with root package name */
            private Interpolator f7304e;

            /* renamed from: f  reason: collision with root package name */
            private boolean f7305f;

            /* renamed from: g  reason: collision with root package name */
            private int f7306g;

            public Action(int i8, int i9) {
                this(i8, i9, Integer.MIN_VALUE, null);
            }

            private void e() {
                if (this.f7304e != null && this.f7302c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.f7302c >= 1) {
                    return;
                }
                throw new IllegalStateException("Scroll duration must be a positive number");
            }

            boolean a() {
                if (this.f7303d >= 0) {
                    return true;
                }
                return false;
            }

            public void b(int i8) {
                this.f7303d = i8;
            }

            void c(RecyclerView recyclerView) {
                int i8 = this.f7303d;
                if (i8 >= 0) {
                    this.f7303d = -1;
                    recyclerView.C0(i8);
                    this.f7305f = false;
                } else if (this.f7305f) {
                    e();
                    recyclerView.f7192k0.e(this.f7300a, this.f7301b, this.f7302c, this.f7304e);
                    int i9 = this.f7306g + 1;
                    this.f7306g = i9;
                    if (i9 > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f7305f = false;
                } else {
                    this.f7306g = 0;
                }
            }

            public void d(int i8, int i9, int i10, Interpolator interpolator) {
                this.f7300a = i8;
                this.f7301b = i9;
                this.f7302c = i10;
                this.f7304e = interpolator;
                this.f7305f = true;
            }

            public Action(int i8, int i9, int i10, Interpolator interpolator) {
                this.f7303d = -1;
                this.f7305f = false;
                this.f7306g = 0;
                this.f7300a = i8;
                this.f7301b = i9;
                this.f7302c = i10;
                this.f7304e = interpolator;
            }
        }

        /* loaded from: classes.dex */
        public interface ScrollVectorProvider {
            PointF a(int i8);
        }

        public PointF a(int i8) {
            LayoutManager e8 = e();
            if (e8 instanceof ScrollVectorProvider) {
                return ((ScrollVectorProvider) e8).a(i8);
            }
            Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + ScrollVectorProvider.class.getCanonicalName());
            return null;
        }

        public View b(int i8) {
            return this.f7293b.f7205r.N(i8);
        }

        public int c() {
            return this.f7293b.f7205r.U();
        }

        public int d(View view) {
            return this.f7293b.i0(view);
        }

        public LayoutManager e() {
            return this.f7294c;
        }

        public int f() {
            return this.f7292a;
        }

        public boolean g() {
            return this.f7295d;
        }

        public boolean h() {
            return this.f7296e;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void i(@NonNull PointF pointF) {
            float f8 = pointF.x;
            float f9 = pointF.y;
            float sqrt = (float) Math.sqrt((f8 * f8) + (f9 * f9));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        void j(int i8, int i9) {
            PointF a8;
            RecyclerView recyclerView = this.f7293b;
            if (this.f7292a == -1 || recyclerView == null) {
                r();
            }
            if (this.f7295d && this.f7297f == null && this.f7294c != null && (a8 = a(this.f7292a)) != null) {
                float f8 = a8.x;
                if (f8 != 0.0f || a8.y != 0.0f) {
                    recyclerView.o1((int) Math.signum(f8), (int) Math.signum(a8.y), null);
                }
            }
            this.f7295d = false;
            View view = this.f7297f;
            if (view != null) {
                if (d(view) == this.f7292a) {
                    o(this.f7297f, recyclerView.f7198n0, this.f7298g);
                    this.f7298g.c(recyclerView);
                    r();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f7297f = null;
                }
            }
            if (this.f7296e) {
                l(i8, i9, recyclerView.f7198n0, this.f7298g);
                boolean a9 = this.f7298g.a();
                this.f7298g.c(recyclerView);
                if (a9 && this.f7296e) {
                    this.f7295d = true;
                    recyclerView.f7192k0.d();
                }
            }
        }

        protected void k(View view) {
            if (d(view) == f()) {
                this.f7297f = view;
            }
        }

        protected abstract void l(int i8, int i9, @NonNull State state, @NonNull Action action);

        protected abstract void m();

        protected abstract void n();

        protected abstract void o(@NonNull View view, @NonNull State state, @NonNull Action action);

        public void p(int i8) {
            this.f7292a = i8;
        }

        void q(RecyclerView recyclerView, LayoutManager layoutManager) {
            recyclerView.f7192k0.f();
            if (this.f7299h) {
                Log.w("RecyclerView", "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.f7293b = recyclerView;
            this.f7294c = layoutManager;
            int i8 = this.f7292a;
            if (i8 != -1) {
                recyclerView.f7198n0.f7307a = i8;
                this.f7296e = true;
                this.f7295d = true;
                this.f7297f = b(f());
                m();
                this.f7293b.f7192k0.d();
                this.f7299h = true;
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void r() {
            if (!this.f7296e) {
                return;
            }
            this.f7296e = false;
            n();
            this.f7293b.f7198n0.f7307a = -1;
            this.f7297f = null;
            this.f7292a = -1;
            this.f7295d = false;
            this.f7294c.o1(this);
            this.f7294c = null;
            this.f7293b = null;
        }
    }

    /* loaded from: classes.dex */
    public static class State {

        /* renamed from: b  reason: collision with root package name */
        private SparseArray<Object> f7308b;

        /* renamed from: m  reason: collision with root package name */
        int f7319m;

        /* renamed from: n  reason: collision with root package name */
        long f7320n;

        /* renamed from: o  reason: collision with root package name */
        int f7321o;

        /* renamed from: p  reason: collision with root package name */
        int f7322p;

        /* renamed from: q  reason: collision with root package name */
        int f7323q;

        /* renamed from: a  reason: collision with root package name */
        int f7307a = -1;

        /* renamed from: c  reason: collision with root package name */
        int f7309c = 0;

        /* renamed from: d  reason: collision with root package name */
        int f7310d = 0;

        /* renamed from: e  reason: collision with root package name */
        int f7311e = 1;

        /* renamed from: f  reason: collision with root package name */
        int f7312f = 0;

        /* renamed from: g  reason: collision with root package name */
        boolean f7313g = false;

        /* renamed from: h  reason: collision with root package name */
        boolean f7314h = false;

        /* renamed from: i  reason: collision with root package name */
        boolean f7315i = false;

        /* renamed from: j  reason: collision with root package name */
        boolean f7316j = false;

        /* renamed from: k  reason: collision with root package name */
        boolean f7317k = false;

        /* renamed from: l  reason: collision with root package name */
        boolean f7318l = false;

        void a(int i8) {
            if ((this.f7311e & i8) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i8) + " but it is " + Integer.toBinaryString(this.f7311e));
        }

        public int b() {
            if (this.f7314h) {
                return this.f7309c - this.f7310d;
            }
            return this.f7312f;
        }

        public int c() {
            return this.f7307a;
        }

        public boolean d() {
            if (this.f7307a != -1) {
                return true;
            }
            return false;
        }

        public boolean e() {
            return this.f7314h;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void f(Adapter adapter) {
            this.f7311e = 1;
            this.f7312f = adapter.r();
            this.f7314h = false;
            this.f7315i = false;
            this.f7316j = false;
        }

        public boolean g() {
            return this.f7318l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f7307a + ", mData=" + this.f7308b + ", mItemCount=" + this.f7312f + ", mIsMeasuring=" + this.f7316j + ", mPreviousLayoutItemCount=" + this.f7309c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f7310d + ", mStructureChanged=" + this.f7313g + ", mInPreLayout=" + this.f7314h + ", mRunSimpleAnimations=" + this.f7317k + ", mRunPredictiveAnimations=" + this.f7318l + '}';
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ViewCacheExtension {
        public abstract View a(@NonNull Recycler recycler, int i8, int i9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ViewFlinger implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        private int f7324f;

        /* renamed from: g  reason: collision with root package name */
        private int f7325g;

        /* renamed from: h  reason: collision with root package name */
        OverScroller f7326h;

        /* renamed from: i  reason: collision with root package name */
        Interpolator f7327i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f7328j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f7329k;

        ViewFlinger() {
            Interpolator interpolator = RecyclerView.P0;
            this.f7327i = interpolator;
            this.f7328j = false;
            this.f7329k = false;
            this.f7326h = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        private int a(int i8, int i9) {
            boolean z7;
            int height;
            int abs = Math.abs(i8);
            int abs2 = Math.abs(i9);
            if (abs > abs2) {
                z7 = true;
            } else {
                z7 = false;
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (z7) {
                height = recyclerView.getWidth();
            } else {
                height = recyclerView.getHeight();
            }
            if (!z7) {
                abs = abs2;
            }
            return Math.min((int) (((abs / height) + 1.0f) * 300.0f), (int) CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE);
        }

        private void c() {
            RecyclerView.this.removeCallbacks(this);
            ViewCompat.k0(RecyclerView.this, this);
        }

        public void b(int i8, int i9) {
            RecyclerView.this.setScrollState(2);
            this.f7325g = 0;
            this.f7324f = 0;
            Interpolator interpolator = this.f7327i;
            Interpolator interpolator2 = RecyclerView.P0;
            if (interpolator != interpolator2) {
                this.f7327i = interpolator2;
                this.f7326h = new OverScroller(RecyclerView.this.getContext(), interpolator2);
            }
            this.f7326h.fling(0, 0, i8, i9, Integer.MIN_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER, Integer.MIN_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER);
            d();
        }

        void d() {
            if (this.f7328j) {
                this.f7329k = true;
            } else {
                c();
            }
        }

        public void e(int i8, int i9, int i10, Interpolator interpolator) {
            if (i10 == Integer.MIN_VALUE) {
                i10 = a(i8, i9);
            }
            int i11 = i10;
            if (interpolator == null) {
                interpolator = RecyclerView.P0;
            }
            if (this.f7327i != interpolator) {
                this.f7327i = interpolator;
                this.f7326h = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f7325g = 0;
            this.f7324f = 0;
            RecyclerView.this.setScrollState(2);
            this.f7326h.startScroll(0, 0, i8, i9, i11);
            if (Build.VERSION.SDK_INT < 23) {
                this.f7326h.computeScrollOffset();
            }
            d();
        }

        public void f() {
            RecyclerView.this.removeCallbacks(this);
            this.f7326h.abortAnimation();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i8;
            int i9;
            boolean z7;
            boolean z8;
            boolean z9;
            boolean z10;
            int i10;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f7205r == null) {
                f();
                return;
            }
            this.f7329k = false;
            this.f7328j = true;
            recyclerView.w();
            OverScroller overScroller = this.f7326h;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i11 = currX - this.f7324f;
                int i12 = currY - this.f7325g;
                this.f7324f = currX;
                this.f7325g = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.A0;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.H(i11, i12, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.A0;
                    i11 -= iArr2[0];
                    i12 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.v(i11, i12);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.f7203q != null) {
                    int[] iArr3 = recyclerView3.A0;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.o1(i11, i12, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.A0;
                    i9 = iArr4[0];
                    i8 = iArr4[1];
                    i11 -= i9;
                    i12 -= i8;
                    SmoothScroller smoothScroller = recyclerView4.f7205r.f7253l;
                    if (smoothScroller != null && !smoothScroller.g() && smoothScroller.h()) {
                        int b8 = RecyclerView.this.f7198n0.b();
                        if (b8 == 0) {
                            smoothScroller.r();
                        } else if (smoothScroller.f() >= b8) {
                            smoothScroller.p(b8 - 1);
                            smoothScroller.j(i9, i8);
                        } else {
                            smoothScroller.j(i9, i8);
                        }
                    }
                } else {
                    i8 = 0;
                    i9 = 0;
                }
                if (!RecyclerView.this.f7211u.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.A0;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.I(i9, i8, i11, i12, null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.A0;
                int i13 = i11 - iArr6[0];
                int i14 = i12 - iArr6[1];
                if (i9 != 0 || i8 != 0) {
                    recyclerView6.K(i9, i8);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                if (overScroller.getCurrX() == overScroller.getFinalX()) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (overScroller.getCurrY() == overScroller.getFinalY()) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (!overScroller.isFinished() && ((!z7 && i13 == 0) || (!z8 && i14 == 0))) {
                    z9 = false;
                } else {
                    z9 = true;
                }
                SmoothScroller smoothScroller2 = RecyclerView.this.f7205r.f7253l;
                if (smoothScroller2 != null && smoothScroller2.g()) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10 && z9) {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        if (i13 < 0) {
                            i10 = -currVelocity;
                        } else if (i13 > 0) {
                            i10 = currVelocity;
                        } else {
                            i10 = 0;
                        }
                        if (i14 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i14 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.b(i10, currVelocity);
                    }
                    if (RecyclerView.L0) {
                        RecyclerView.this.f7196m0.b();
                    }
                } else {
                    d();
                    RecyclerView recyclerView7 = RecyclerView.this;
                    GapWorker gapWorker = recyclerView7.f7194l0;
                    if (gapWorker != null) {
                        gapWorker.f(recyclerView7, i9, i8);
                    }
                }
            }
            SmoothScroller smoothScroller3 = RecyclerView.this.f7205r.f7253l;
            if (smoothScroller3 != null && smoothScroller3.g()) {
                smoothScroller3.j(0, 0);
            }
            this.f7328j = false;
            if (this.f7329k) {
                c();
                return;
            }
            RecyclerView.this.setScrollState(0);
            RecyclerView.this.B1(1);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ViewHolder {

        /* renamed from: t  reason: collision with root package name */
        private static final List<Object> f7331t = Collections.emptyList();
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public final View f7332a;

        /* renamed from: b  reason: collision with root package name */
        WeakReference<RecyclerView> f7333b;

        /* renamed from: j  reason: collision with root package name */
        int f7341j;

        /* renamed from: r  reason: collision with root package name */
        RecyclerView f7349r;

        /* renamed from: s  reason: collision with root package name */
        Adapter<? extends ViewHolder> f7350s;

        /* renamed from: c  reason: collision with root package name */
        int f7334c = -1;

        /* renamed from: d  reason: collision with root package name */
        int f7335d = -1;

        /* renamed from: e  reason: collision with root package name */
        long f7336e = -1;

        /* renamed from: f  reason: collision with root package name */
        int f7337f = -1;

        /* renamed from: g  reason: collision with root package name */
        int f7338g = -1;

        /* renamed from: h  reason: collision with root package name */
        ViewHolder f7339h = null;

        /* renamed from: i  reason: collision with root package name */
        ViewHolder f7340i = null;

        /* renamed from: k  reason: collision with root package name */
        List<Object> f7342k = null;

        /* renamed from: l  reason: collision with root package name */
        List<Object> f7343l = null;

        /* renamed from: m  reason: collision with root package name */
        private int f7344m = 0;

        /* renamed from: n  reason: collision with root package name */
        Recycler f7345n = null;

        /* renamed from: o  reason: collision with root package name */
        boolean f7346o = false;

        /* renamed from: p  reason: collision with root package name */
        private int f7347p = 0;

        /* renamed from: q  reason: collision with root package name */
        int f7348q = -1;

        public ViewHolder(@NonNull View view) {
            if (view != null) {
                this.f7332a = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        private void g() {
            if (this.f7342k == null) {
                ArrayList arrayList = new ArrayList();
                this.f7342k = arrayList;
                this.f7343l = Collections.unmodifiableList(arrayList);
            }
        }

        boolean A() {
            if ((this.f7341j & 2) != 0) {
                return true;
            }
            return false;
        }

        boolean B() {
            if ((this.f7341j & 2) != 0) {
                return true;
            }
            return false;
        }

        void C(int i8, boolean z7) {
            if (this.f7335d == -1) {
                this.f7335d = this.f7334c;
            }
            if (this.f7338g == -1) {
                this.f7338g = this.f7334c;
            }
            if (z7) {
                this.f7338g += i8;
            }
            this.f7334c += i8;
            if (this.f7332a.getLayoutParams() != null) {
                ((LayoutParams) this.f7332a.getLayoutParams()).f7273h = true;
            }
        }

        void D(RecyclerView recyclerView) {
            int i8 = this.f7348q;
            if (i8 != -1) {
                this.f7347p = i8;
            } else {
                this.f7347p = ViewCompat.C(this.f7332a);
            }
            recyclerView.r1(this, 4);
        }

        void E(RecyclerView recyclerView) {
            recyclerView.r1(this, this.f7347p);
            this.f7347p = 0;
        }

        void F() {
            this.f7341j = 0;
            this.f7334c = -1;
            this.f7335d = -1;
            this.f7336e = -1L;
            this.f7338g = -1;
            this.f7344m = 0;
            this.f7339h = null;
            this.f7340i = null;
            d();
            this.f7347p = 0;
            this.f7348q = -1;
            RecyclerView.s(this);
        }

        void G() {
            if (this.f7335d == -1) {
                this.f7335d = this.f7334c;
            }
        }

        void H(int i8, int i9) {
            this.f7341j = (i8 & i9) | (this.f7341j & (~i9));
        }

        public final void I(boolean z7) {
            int i8;
            int i9 = this.f7344m;
            if (z7) {
                i8 = i9 - 1;
            } else {
                i8 = i9 + 1;
            }
            this.f7344m = i8;
            if (i8 < 0) {
                this.f7344m = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z7 && i8 == 1) {
                this.f7341j |= 16;
            } else if (z7 && i8 == 0) {
                this.f7341j &= -17;
            }
        }

        void J(Recycler recycler, boolean z7) {
            this.f7345n = recycler;
            this.f7346o = z7;
        }

        boolean K() {
            if ((this.f7341j & 16) != 0) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean L() {
            if ((this.f7341j & 128) != 0) {
                return true;
            }
            return false;
        }

        void M() {
            this.f7345n.J(this);
        }

        boolean N() {
            if ((this.f7341j & 32) != 0) {
                return true;
            }
            return false;
        }

        void a(Object obj) {
            if (obj == null) {
                b(Spliterator.IMMUTABLE);
            } else if ((1024 & this.f7341j) == 0) {
                g();
                this.f7342k.add(obj);
            }
        }

        void b(int i8) {
            this.f7341j = i8 | this.f7341j;
        }

        void c() {
            this.f7335d = -1;
            this.f7338g = -1;
        }

        void d() {
            List<Object> list = this.f7342k;
            if (list != null) {
                list.clear();
            }
            this.f7341j &= -1025;
        }

        void e() {
            this.f7341j &= -33;
        }

        void f() {
            this.f7341j &= -257;
        }

        boolean h() {
            if ((this.f7341j & 16) == 0 && ViewCompat.T(this.f7332a)) {
                return true;
            }
            return false;
        }

        void i(int i8, int i9, boolean z7) {
            b(8);
            C(i9, z7);
            this.f7334c = i8;
        }

        public final int j() {
            RecyclerView recyclerView = this.f7349r;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.f0(this);
        }

        @Deprecated
        public final int k() {
            return l();
        }

        public final int l() {
            RecyclerView recyclerView;
            Adapter adapter;
            int f02;
            if (this.f7350s == null || (recyclerView = this.f7349r) == null || (adapter = recyclerView.getAdapter()) == null || (f02 = this.f7349r.f0(this)) == -1) {
                return -1;
            }
            return adapter.q(this.f7350s, this, f02);
        }

        public final long m() {
            return this.f7336e;
        }

        public final int n() {
            return this.f7337f;
        }

        public final int o() {
            int i8 = this.f7338g;
            if (i8 == -1) {
                return this.f7334c;
            }
            return i8;
        }

        public final int p() {
            return this.f7335d;
        }

        List<Object> q() {
            if ((this.f7341j & Spliterator.IMMUTABLE) == 0) {
                List<Object> list = this.f7342k;
                if (list != null && list.size() != 0) {
                    return this.f7343l;
                }
                return f7331t;
            }
            return f7331t;
        }

        boolean r(int i8) {
            if ((i8 & this.f7341j) != 0) {
                return true;
            }
            return false;
        }

        boolean s() {
            if ((this.f7341j & 512) == 0 && !v()) {
                return false;
            }
            return true;
        }

        boolean t() {
            if (this.f7332a.getParent() != null && this.f7332a.getParent() != this.f7349r) {
                return true;
            }
            return false;
        }

        public String toString() {
            String simpleName;
            String str;
            if (getClass().isAnonymousClass()) {
                simpleName = "ViewHolder";
            } else {
                simpleName = getClass().getSimpleName();
            }
            StringBuilder sb = new StringBuilder(simpleName + "{" + Integer.toHexString(hashCode()) + " position=" + this.f7334c + " id=" + this.f7336e + ", oldPos=" + this.f7335d + ", pLpos:" + this.f7338g);
            if (y()) {
                sb.append(" scrap ");
                if (this.f7346o) {
                    str = "[changeScrap]";
                } else {
                    str = "[attachedScrap]";
                }
                sb.append(str);
            }
            if (v()) {
                sb.append(" invalid");
            }
            if (!u()) {
                sb.append(" unbound");
            }
            if (B()) {
                sb.append(" update");
            }
            if (x()) {
                sb.append(" removed");
            }
            if (L()) {
                sb.append(" ignored");
            }
            if (z()) {
                sb.append(" tmpDetached");
            }
            if (!w()) {
                sb.append(" not recyclable(" + this.f7344m + ")");
            }
            if (s()) {
                sb.append(" undefined adapter position");
            }
            if (this.f7332a.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean u() {
            if ((this.f7341j & 1) != 0) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean v() {
            if ((this.f7341j & 4) != 0) {
                return true;
            }
            return false;
        }

        public final boolean w() {
            if ((this.f7341j & 16) == 0 && !ViewCompat.T(this.f7332a)) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean x() {
            if ((this.f7341j & 8) != 0) {
                return true;
            }
            return false;
        }

        boolean y() {
            if (this.f7345n != null) {
                return true;
            }
            return false;
        }

        boolean z() {
            if ((this.f7341j & Spliterator.NONNULL) != 0) {
                return true;
            }
            return false;
        }
    }

    static {
        boolean z7;
        int i8 = Build.VERSION.SDK_INT;
        I0 = false;
        if (i8 >= 23) {
            z7 = true;
        } else {
            z7 = false;
        }
        J0 = z7;
        K0 = true;
        L0 = true;
        M0 = false;
        N0 = false;
        Class<?> cls = Integer.TYPE;
        O0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        P0 = new Interpolator() { // from class: androidx.recyclerview.widget.RecyclerView.3
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f8) {
                float f9 = f8 - 1.0f;
                return (f9 * f9 * f9 * f9 * f9) + 1.0f;
            }
        };
    }

    public RecyclerView(@NonNull Context context) {
        this(context, null);
    }

    private boolean B0(View view, View view2, int i8) {
        int i9;
        int i10;
        if (view2 == null || view2 == this || view2 == view || U(view2) == null) {
            return false;
        }
        if (view == null || U(view) == null) {
            return true;
        }
        this.f7197n.set(0, 0, view.getWidth(), view.getHeight());
        this.f7199o.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.f7197n);
        offsetDescendantRectToMyCoords(view2, this.f7199o);
        char c8 = 65535;
        if (this.f7205r.k0() == 1) {
            i9 = -1;
        } else {
            i9 = 1;
        }
        Rect rect = this.f7197n;
        int i11 = rect.left;
        Rect rect2 = this.f7199o;
        int i12 = rect2.left;
        if ((i11 < i12 || rect.right <= i12) && rect.right < rect2.right) {
            i10 = 1;
        } else {
            int i13 = rect.right;
            int i14 = rect2.right;
            if ((i13 > i14 || i11 >= i14) && i11 > i12) {
                i10 = -1;
            } else {
                i10 = 0;
            }
        }
        int i15 = rect.top;
        int i16 = rect2.top;
        if ((i15 < i16 || rect.bottom <= i16) && rect.bottom < rect2.bottom) {
            c8 = 1;
        } else {
            int i17 = rect.bottom;
            int i18 = rect2.bottom;
            if ((i17 <= i18 && i15 < i18) || i15 <= i16) {
                c8 = 0;
            }
        }
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 17) {
                    if (i8 != 33) {
                        if (i8 != 66) {
                            if (i8 == 130) {
                                if (c8 <= 0) {
                                    return false;
                                }
                                return true;
                            }
                            throw new IllegalArgumentException("Invalid direction: " + i8 + R());
                        } else if (i10 <= 0) {
                            return false;
                        } else {
                            return true;
                        }
                    } else if (c8 >= 0) {
                        return false;
                    } else {
                        return true;
                    }
                } else if (i10 >= 0) {
                    return false;
                } else {
                    return true;
                }
            } else if (c8 <= 0 && (c8 != 0 || i10 * i9 <= 0)) {
                return false;
            } else {
                return true;
            }
        } else if (c8 >= 0 && (c8 != 0 || i10 * i9 >= 0)) {
            return false;
        } else {
            return true;
        }
    }

    private void C() {
        int i8 = this.F;
        this.F = 0;
        if (i8 != 0 && z0()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            AccessibilityEventCompat.b(obtain, i8);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    private void D1() {
        this.f7192k0.f();
        LayoutManager layoutManager = this.f7205r;
        if (layoutManager != null) {
            layoutManager.V1();
        }
    }

    private void E() {
        boolean z7 = true;
        this.f7198n0.a(1);
        S(this.f7198n0);
        this.f7198n0.f7316j = false;
        y1();
        this.f7191k.f();
        N0();
        V0();
        l1();
        State state = this.f7198n0;
        state.f7315i = (state.f7317k && this.f7206r0) ? false : false;
        this.f7206r0 = false;
        this.f7204q0 = false;
        state.f7314h = state.f7318l;
        state.f7312f = this.f7203q.r();
        X(this.f7216w0);
        if (this.f7198n0.f7317k) {
            int g8 = this.f7189j.g();
            for (int i8 = 0; i8 < g8; i8++) {
                ViewHolder k02 = k0(this.f7189j.f(i8));
                if (!k02.L() && (!k02.v() || this.f7203q.v())) {
                    this.f7191k.e(k02, this.S.u(this.f7198n0, k02, ItemAnimator.e(k02), k02.q()));
                    if (this.f7198n0.f7315i && k02.A() && !k02.x() && !k02.L() && !k02.v()) {
                        this.f7191k.c(g0(k02), k02);
                    }
                }
            }
        }
        if (this.f7198n0.f7318l) {
            m1();
            State state2 = this.f7198n0;
            boolean z8 = state2.f7313g;
            state2.f7313g = false;
            this.f7205r.g1(this.f7183g, state2);
            this.f7198n0.f7313g = z8;
            for (int i9 = 0; i9 < this.f7189j.g(); i9++) {
                ViewHolder k03 = k0(this.f7189j.f(i9));
                if (!k03.L() && !this.f7191k.i(k03)) {
                    int e8 = ItemAnimator.e(k03);
                    boolean r7 = k03.r(FragmentTransaction.TRANSIT_EXIT_MASK);
                    if (!r7) {
                        e8 |= 4096;
                    }
                    ItemAnimator.ItemHolderInfo u7 = this.S.u(this.f7198n0, k03, e8, k03.q());
                    if (r7) {
                        Y0(k03, u7);
                    } else {
                        this.f7191k.a(k03, u7);
                    }
                }
            }
            t();
        } else {
            t();
        }
        O0();
        A1(false);
        this.f7198n0.f7311e = 2;
    }

    private void F() {
        boolean z7;
        y1();
        N0();
        this.f7198n0.a(6);
        this.f7187i.j();
        this.f7198n0.f7312f = this.f7203q.r();
        this.f7198n0.f7310d = 0;
        if (this.f7185h != null && this.f7203q.o()) {
            Parcelable parcelable = this.f7185h.f7291h;
            if (parcelable != null) {
                this.f7205r.l1(parcelable);
            }
            this.f7185h = null;
        }
        State state = this.f7198n0;
        state.f7314h = false;
        this.f7205r.g1(this.f7183g, state);
        State state2 = this.f7198n0;
        state2.f7313g = false;
        if (state2.f7317k && this.S != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        state2.f7317k = z7;
        state2.f7311e = 4;
        O0();
        A1(false);
    }

    private void F0(int i8, int i9, MotionEvent motionEvent, int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        LayoutManager layoutManager = this.f7205r;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (this.D) {
        } else {
            int[] iArr = this.A0;
            int i15 = 0;
            iArr[0] = 0;
            iArr[1] = 0;
            boolean v7 = layoutManager.v();
            boolean w7 = this.f7205r.w();
            if (w7) {
                i11 = v7 | 2;
            } else {
                i11 = v7;
            }
            z1(i11, i10);
            if (v7 != 0) {
                i12 = i8;
            } else {
                i12 = 0;
            }
            if (w7) {
                i13 = i9;
            } else {
                i13 = 0;
            }
            if (H(i12, i13, this.A0, this.f7220y0, i10)) {
                int[] iArr2 = this.A0;
                i8 -= iArr2[0];
                i9 -= iArr2[1];
            }
            if (v7 != 0) {
                i14 = i8;
            } else {
                i14 = 0;
            }
            if (w7) {
                i15 = i9;
            }
            n1(i14, i15, motionEvent, i10);
            GapWorker gapWorker = this.f7194l0;
            if (gapWorker != null && (i8 != 0 || i9 != 0)) {
                gapWorker.f(this, i8, i9);
            }
            B1(i10);
        }
    }

    private void G() {
        this.f7198n0.a(4);
        y1();
        N0();
        State state = this.f7198n0;
        state.f7311e = 1;
        if (state.f7317k) {
            for (int g8 = this.f7189j.g() - 1; g8 >= 0; g8--) {
                ViewHolder k02 = k0(this.f7189j.f(g8));
                if (!k02.L()) {
                    long g02 = g0(k02);
                    ItemAnimator.ItemHolderInfo t7 = this.S.t(this.f7198n0, k02);
                    ViewHolder g9 = this.f7191k.g(g02);
                    if (g9 != null && !g9.L()) {
                        boolean h8 = this.f7191k.h(g9);
                        boolean h9 = this.f7191k.h(k02);
                        if (h8 && g9 == k02) {
                            this.f7191k.d(k02, t7);
                        } else {
                            ItemAnimator.ItemHolderInfo n8 = this.f7191k.n(g9);
                            this.f7191k.d(k02, t7);
                            ItemAnimator.ItemHolderInfo m8 = this.f7191k.m(k02);
                            if (n8 == null) {
                                q0(g02, k02, g9);
                            } else {
                                n(g9, k02, n8, m8, h8, h9);
                            }
                        }
                    } else {
                        this.f7191k.d(k02, t7);
                    }
                }
            }
            this.f7191k.o(this.G0);
        }
        this.f7205r.v1(this.f7183g);
        State state2 = this.f7198n0;
        state2.f7309c = state2.f7312f;
        this.J = false;
        this.K = false;
        state2.f7317k = false;
        state2.f7318l = false;
        this.f7205r.f7254m = false;
        ArrayList<ViewHolder> arrayList = this.f7183g.f7282b;
        if (arrayList != null) {
            arrayList.clear();
        }
        LayoutManager layoutManager = this.f7205r;
        if (layoutManager.f7260s) {
            layoutManager.f7259r = 0;
            layoutManager.f7260s = false;
            this.f7183g.K();
        }
        this.f7205r.h1(this.f7198n0);
        O0();
        A1(false);
        this.f7191k.f();
        int[] iArr = this.f7216w0;
        if (z(iArr[0], iArr[1])) {
            K(0, 0);
        }
        Z0();
        j1();
    }

    private boolean M(MotionEvent motionEvent) {
        OnItemTouchListener onItemTouchListener = this.f7215w;
        if (onItemTouchListener == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return W(motionEvent);
        }
        onItemTouchListener.a(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.f7215w = null;
        }
        return true;
    }

    private void Q0(MotionEvent motionEvent) {
        int i8;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.U) {
            if (actionIndex == 0) {
                i8 = 1;
            } else {
                i8 = 0;
            }
            this.U = motionEvent.getPointerId(i8);
            int x7 = (int) (motionEvent.getX(i8) + 0.5f);
            this.f7177b0 = x7;
            this.W = x7;
            int y7 = (int) (motionEvent.getY(i8) + 0.5f);
            this.f7178c0 = y7;
            this.f7176a0 = y7;
        }
    }

    private boolean U0() {
        if (this.S != null && this.f7205r.W1()) {
            return true;
        }
        return false;
    }

    private void V0() {
        boolean z7;
        boolean z8;
        boolean z9;
        if (this.J) {
            this.f7187i.y();
            if (this.K) {
                this.f7205r.b1(this);
            }
        }
        if (U0()) {
            this.f7187i.w();
        } else {
            this.f7187i.j();
        }
        boolean z10 = false;
        if (!this.f7204q0 && !this.f7206r0) {
            z7 = false;
        } else {
            z7 = true;
        }
        State state = this.f7198n0;
        if (this.A && this.S != null && (((z9 = this.J) || z7 || this.f7205r.f7254m) && (!z9 || this.f7203q.v()))) {
            z8 = true;
        } else {
            z8 = false;
        }
        state.f7317k = z8;
        State state2 = this.f7198n0;
        if (state2.f7317k && z7 && !this.J && U0()) {
            z10 = true;
        }
        state2.f7318l = z10;
    }

    private boolean W(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.f7213v.size();
        for (int i8 = 0; i8 < size; i8++) {
            OnItemTouchListener onItemTouchListener = this.f7213v.get(i8);
            if (onItemTouchListener.c(this, motionEvent) && action != 3) {
                this.f7215w = onItemTouchListener;
                return true;
            }
        }
        return false;
    }

    private void X(int[] iArr) {
        int g8 = this.f7189j.g();
        if (g8 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i8 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int i9 = Integer.MIN_VALUE;
        for (int i10 = 0; i10 < g8; i10++) {
            ViewHolder k02 = k0(this.f7189j.f(i10));
            if (!k02.L()) {
                int o8 = k02.o();
                if (o8 < i8) {
                    i8 = o8;
                }
                if (o8 > i9) {
                    i9 = o8;
                }
            }
        }
        iArr[0] = i8;
        iArr[1] = i9;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void X0(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1
            r2 = 0
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 >= 0) goto L21
            r6.O()
            android.widget.EdgeEffect r3 = r6.O
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r0 - r9
            androidx.core.widget.EdgeEffectCompat.c(r3, r4, r9)
        L1f:
            r9 = 1
            goto L3c
        L21:
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 <= 0) goto L3b
            r6.P()
            android.widget.EdgeEffect r3 = r6.Q
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            androidx.core.widget.EdgeEffectCompat.c(r3, r4, r9)
            goto L1f
        L3b:
            r9 = 0
        L3c:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 >= 0) goto L56
            r6.Q()
            android.widget.EdgeEffect r9 = r6.P
            float r0 = -r10
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            int r3 = r6.getWidth()
            float r3 = (float) r3
            float r7 = r7 / r3
            androidx.core.widget.EdgeEffectCompat.c(r9, r0, r7)
            goto L72
        L56:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 <= 0) goto L71
            r6.N()
            android.widget.EdgeEffect r9 = r6.R
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r3 = r10 / r3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r0 = r0 - r7
            androidx.core.widget.EdgeEffectCompat.c(r9, r3, r0)
            goto L72
        L71:
            r1 = r9
        L72:
            if (r1 != 0) goto L7c
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 != 0) goto L7c
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 == 0) goto L7f
        L7c:
            androidx.core.view.ViewCompat.j0(r6)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.X0(float, float, float, float):void");
    }

    static RecyclerView Y(@NonNull View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            RecyclerView Y = Y(viewGroup.getChildAt(i8));
            if (Y != null) {
                return Y;
            }
        }
        return null;
    }

    private View Z() {
        ViewHolder a02;
        State state = this.f7198n0;
        int i8 = state.f7319m;
        if (i8 == -1) {
            i8 = 0;
        }
        int b8 = state.b();
        for (int i9 = i8; i9 < b8; i9++) {
            ViewHolder a03 = a0(i9);
            if (a03 == null) {
                break;
            } else if (a03.f7332a.hasFocusable()) {
                return a03.f7332a;
            }
        }
        int min = Math.min(b8, i8);
        while (true) {
            min--;
            if (min < 0 || (a02 = a0(min)) == null) {
                return null;
            }
            if (a02.f7332a.hasFocusable()) {
                return a02.f7332a;
            }
        }
    }

    private void Z0() {
        ViewHolder viewHolder;
        View findViewById;
        if (this.f7190j0 && this.f7203q != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (getDescendantFocusability() != 131072 || !isFocused()) {
                if (!isFocused()) {
                    View focusedChild = getFocusedChild();
                    if (N0 && (focusedChild.getParent() == null || !focusedChild.hasFocus())) {
                        if (this.f7189j.g() == 0) {
                            requestFocus();
                            return;
                        }
                    } else if (!this.f7189j.n(focusedChild)) {
                        return;
                    }
                }
                View view = null;
                if (this.f7198n0.f7320n != -1 && this.f7203q.v()) {
                    viewHolder = b0(this.f7198n0.f7320n);
                } else {
                    viewHolder = null;
                }
                if (viewHolder != null && !this.f7189j.n(viewHolder.f7332a) && viewHolder.f7332a.hasFocusable()) {
                    view = viewHolder.f7332a;
                } else if (this.f7189j.g() > 0) {
                    view = Z();
                }
                if (view != null) {
                    int i8 = this.f7198n0.f7321o;
                    if (i8 != -1 && (findViewById = view.findViewById(i8)) != null && findViewById.isFocusable()) {
                        view = findViewById;
                    }
                    view.requestFocus();
                }
            }
        }
    }

    private void a1() {
        boolean z7;
        EdgeEffect edgeEffect = this.O;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z7 = this.O.isFinished();
        } else {
            z7 = false;
        }
        EdgeEffect edgeEffect2 = this.P;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z7 |= this.P.isFinished();
        }
        EdgeEffect edgeEffect3 = this.Q;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z7 |= this.Q.isFinished();
        }
        EdgeEffect edgeEffect4 = this.R;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z7 |= this.R.isFinished();
        }
        if (z7) {
            ViewCompat.j0(this);
        }
    }

    private void g(ViewHolder viewHolder) {
        boolean z7;
        View view = viewHolder.f7332a;
        if (view.getParent() == this) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.f7183g.J(j0(view));
        if (viewHolder.z()) {
            this.f7189j.c(view, -1, view.getLayoutParams(), true);
        } else if (!z7) {
            this.f7189j.b(view, true);
        } else {
            this.f7189j.k(view);
        }
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.f7218x0 == null) {
            this.f7218x0 = new NestedScrollingChildHelper(this);
        }
        return this.f7218x0;
    }

    private void i1(@NonNull View view, View view2) {
        View view3;
        boolean z7;
        if (view2 != null) {
            view3 = view2;
        } else {
            view3 = view;
        }
        this.f7197n.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.f7273h) {
                Rect rect = layoutParams2.f7272g;
                Rect rect2 = this.f7197n;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.f7197n);
            offsetRectIntoDescendantCoords(view, this.f7197n);
        }
        LayoutManager layoutManager = this.f7205r;
        Rect rect3 = this.f7197n;
        boolean z8 = !this.A;
        if (view2 == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        layoutManager.C1(this, view, rect3, z8, z7);
    }

    private void j1() {
        State state = this.f7198n0;
        state.f7320n = -1L;
        state.f7319m = -1;
        state.f7321o = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ViewHolder k0(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f7271f;
    }

    private void k1() {
        VelocityTracker velocityTracker = this.V;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        B1(0);
        a1();
    }

    private void l1() {
        View view;
        long j8;
        int j9;
        ViewHolder viewHolder = null;
        if (this.f7190j0 && hasFocus() && this.f7203q != null) {
            view = getFocusedChild();
        } else {
            view = null;
        }
        if (view != null) {
            viewHolder = V(view);
        }
        if (viewHolder == null) {
            j1();
            return;
        }
        State state = this.f7198n0;
        if (this.f7203q.v()) {
            j8 = viewHolder.m();
        } else {
            j8 = -1;
        }
        state.f7320n = j8;
        State state2 = this.f7198n0;
        if (this.J) {
            j9 = -1;
        } else if (viewHolder.x()) {
            j9 = viewHolder.f7335d;
        } else {
            j9 = viewHolder.j();
        }
        state2.f7319m = j9;
        this.f7198n0.f7321o = n0(viewHolder.f7332a);
    }

    static void m0(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.f7272g;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
    }

    private void n(@NonNull ViewHolder viewHolder, @NonNull ViewHolder viewHolder2, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo2, boolean z7, boolean z8) {
        viewHolder.I(false);
        if (z7) {
            g(viewHolder);
        }
        if (viewHolder != viewHolder2) {
            if (z8) {
                g(viewHolder2);
            }
            viewHolder.f7339h = viewHolder2;
            g(viewHolder);
            this.f7183g.J(viewHolder);
            viewHolder2.I(false);
            viewHolder2.f7340i = viewHolder;
        }
        if (this.S.b(viewHolder, viewHolder2, itemHolderInfo, itemHolderInfo2)) {
            T0();
        }
    }

    private int n0(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    private String o0(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        } else if (str.contains(".")) {
            return str;
        } else {
            return RecyclerView.class.getPackage().getName() + '.' + str;
        }
    }

    private void q0(long j8, ViewHolder viewHolder, ViewHolder viewHolder2) {
        int g8 = this.f7189j.g();
        for (int i8 = 0; i8 < g8; i8++) {
            ViewHolder k02 = k0(this.f7189j.f(i8));
            if (k02 != viewHolder && g0(k02) == j8) {
                Adapter adapter = this.f7203q;
                if (adapter != null && adapter.v()) {
                    throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + k02 + " \n View Holder 2:" + viewHolder + R());
                }
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + k02 + " \n View Holder 2:" + viewHolder + R());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + viewHolder2 + " cannot be found but it is necessary for " + viewHolder + R());
    }

    private void q1(Adapter adapter, boolean z7, boolean z8) {
        Adapter adapter2 = this.f7203q;
        if (adapter2 != null) {
            adapter2.O(this.f7181f);
            this.f7203q.H(this);
        }
        if (!z7 || z8) {
            b1();
        }
        this.f7187i.y();
        Adapter adapter3 = this.f7203q;
        this.f7203q = adapter;
        if (adapter != null) {
            adapter.M(this.f7181f);
            adapter.D(this);
        }
        LayoutManager layoutManager = this.f7205r;
        if (layoutManager != null) {
            layoutManager.N0(adapter3, this.f7203q);
        }
        this.f7183g.x(adapter3, this.f7203q, z7);
        this.f7198n0.f7313g = true;
    }

    private void r() {
        k1();
        setScrollState(0);
    }

    static void s(@NonNull ViewHolder viewHolder) {
        WeakReference<RecyclerView> weakReference = viewHolder.f7333b;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView == viewHolder.f7332a) {
                    return;
                }
                ViewParent parent = recyclerView.getParent();
                if (parent instanceof View) {
                    recyclerView = (View) parent;
                } else {
                    recyclerView = null;
                }
            }
            viewHolder.f7333b = null;
        }
    }

    private boolean s0() {
        int g8 = this.f7189j.g();
        for (int i8 = 0; i8 < g8; i8++) {
            ViewHolder k02 = k0(this.f7189j.f(i8));
            if (k02 != null && !k02.L() && k02.A()) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    private void u0() {
        if (ViewCompat.D(this) == 0) {
            ViewCompat.E0(this, 8);
        }
    }

    private void v0() {
        this.f7189j = new ChildHelper(new ChildHelper.Callback() { // from class: androidx.recyclerview.widget.RecyclerView.5
            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public View a(int i8) {
                return RecyclerView.this.getChildAt(i8);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void b(View view) {
                ViewHolder k02 = RecyclerView.k0(view);
                if (k02 != null) {
                    k02.D(RecyclerView.this);
                }
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public int c() {
                return RecyclerView.this.getChildCount();
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public ViewHolder d(View view) {
                return RecyclerView.k0(view);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void e(int i8) {
                ViewHolder k02;
                View a8 = a(i8);
                if (a8 != null && (k02 = RecyclerView.k0(a8)) != null) {
                    if (k02.z() && !k02.L()) {
                        throw new IllegalArgumentException("called detach on an already detached child " + k02 + RecyclerView.this.R());
                    }
                    k02.b(Spliterator.NONNULL);
                }
                RecyclerView.this.detachViewFromParent(i8);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void f(View view, int i8) {
                RecyclerView.this.addView(view, i8);
                RecyclerView.this.A(view);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void g() {
                int c8 = c();
                for (int i8 = 0; i8 < c8; i8++) {
                    View a8 = a(i8);
                    RecyclerView.this.B(a8);
                    a8.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public int h(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void i(View view) {
                ViewHolder k02 = RecyclerView.k0(view);
                if (k02 != null) {
                    k02.E(RecyclerView.this);
                }
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void j(int i8) {
                View childAt = RecyclerView.this.getChildAt(i8);
                if (childAt != null) {
                    RecyclerView.this.B(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i8);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void k(View view, int i8, ViewGroup.LayoutParams layoutParams) {
                ViewHolder k02 = RecyclerView.k0(view);
                if (k02 != null) {
                    if (!k02.z() && !k02.L()) {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + k02 + RecyclerView.this.R());
                    }
                    k02.f();
                }
                RecyclerView.this.attachViewToParent(view, i8, layoutParams);
            }
        });
    }

    private void x(Context context, String str, AttributeSet attributeSet, int i8, int i9) {
        ClassLoader classLoader;
        Constructor constructor;
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty()) {
                String o02 = o0(context, trim);
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class<? extends U> asSubclass = Class.forName(o02, false, classLoader).asSubclass(LayoutManager.class);
                    Object[] objArr = null;
                    try {
                        constructor = asSubclass.getConstructor(O0);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i8), Integer.valueOf(i9)};
                    } catch (NoSuchMethodException e8) {
                        try {
                            constructor = asSubclass.getConstructor(new Class[0]);
                        } catch (NoSuchMethodException e9) {
                            e9.initCause(e8);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + o02, e9);
                        }
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((LayoutManager) constructor.newInstance(objArr));
                } catch (ClassCastException e10) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + o02, e10);
                } catch (ClassNotFoundException e11) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + o02, e11);
                } catch (IllegalAccessException e12) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + o02, e12);
                } catch (InstantiationException e13) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + o02, e13);
                } catch (InvocationTargetException e14) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + o02, e14);
                }
            }
        }
    }

    private boolean z(int i8, int i9) {
        X(this.f7216w0);
        int[] iArr = this.f7216w0;
        if (iArr[0] == i8 && iArr[1] == i9) {
            return false;
        }
        return true;
    }

    void A(View view) {
        ViewHolder k02 = k0(view);
        L0(view);
        Adapter adapter = this.f7203q;
        if (adapter != null && k02 != null) {
            adapter.J(k02);
        }
        List<OnChildAttachStateChangeListener> list = this.I;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.I.get(size).d(view);
            }
        }
    }

    public boolean A0() {
        if (this.L > 0) {
            return true;
        }
        return false;
    }

    void A1(boolean z7) {
        if (this.B < 1) {
            this.B = 1;
        }
        if (!z7 && !this.D) {
            this.C = false;
        }
        if (this.B == 1) {
            if (z7 && this.C && !this.D && this.f7205r != null && this.f7203q != null) {
                D();
            }
            if (!this.D) {
                this.C = false;
            }
        }
        this.B--;
    }

    void B(View view) {
        ViewHolder k02 = k0(view);
        M0(view);
        Adapter adapter = this.f7203q;
        if (adapter != null && k02 != null) {
            adapter.K(k02);
        }
        List<OnChildAttachStateChangeListener> list = this.I;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.I.get(size).b(view);
            }
        }
    }

    public void B1(int i8) {
        getScrollingChildHelper().r(i8);
    }

    void C0(int i8) {
        if (this.f7205r == null) {
            return;
        }
        setScrollState(2);
        this.f7205r.H1(i8);
        awakenScrollBars();
    }

    public void C1() {
        setScrollState(0);
        D1();
    }

    void D() {
        boolean z7;
        if (this.f7203q == null) {
            Log.w("RecyclerView", "No adapter attached; skipping layout");
        } else if (this.f7205r == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
        } else {
            this.f7198n0.f7316j = false;
            if (this.D0 && (this.E0 != getWidth() || this.F0 != getHeight())) {
                z7 = true;
            } else {
                z7 = false;
            }
            this.E0 = 0;
            this.F0 = 0;
            this.D0 = false;
            if (this.f7198n0.f7311e == 1) {
                E();
                this.f7205r.K1(this);
                F();
            } else if (!this.f7187i.q() && !z7 && this.f7205r.v0() == getWidth() && this.f7205r.h0() == getHeight()) {
                this.f7205r.K1(this);
            } else {
                this.f7205r.K1(this);
                F();
            }
            G();
        }
    }

    void D0() {
        int j8 = this.f7189j.j();
        for (int i8 = 0; i8 < j8; i8++) {
            ((LayoutParams) this.f7189j.i(i8).getLayoutParams()).f7273h = true;
        }
        this.f7183g.s();
    }

    void E0() {
        int j8 = this.f7189j.j();
        for (int i8 = 0; i8 < j8; i8++) {
            ViewHolder k02 = k0(this.f7189j.i(i8));
            if (k02 != null && !k02.L()) {
                k02.b(6);
            }
        }
        D0();
        this.f7183g.t();
    }

    void E1(int i8, int i9, Object obj) {
        int i10;
        int j8 = this.f7189j.j();
        int i11 = i8 + i9;
        for (int i12 = 0; i12 < j8; i12++) {
            View i13 = this.f7189j.i(i12);
            ViewHolder k02 = k0(i13);
            if (k02 != null && !k02.L() && (i10 = k02.f7334c) >= i8 && i10 < i11) {
                k02.b(2);
                k02.a(obj);
                ((LayoutParams) i13.getLayoutParams()).f7273h = true;
            }
        }
        this.f7183g.M(i8, i9);
    }

    public void G0(int i8) {
        int g8 = this.f7189j.g();
        for (int i9 = 0; i9 < g8; i9++) {
            this.f7189j.f(i9).offsetLeftAndRight(i8);
        }
    }

    public boolean H(int i8, int i9, int[] iArr, int[] iArr2, int i10) {
        return getScrollingChildHelper().d(i8, i9, iArr, iArr2, i10);
    }

    public void H0(int i8) {
        int g8 = this.f7189j.g();
        for (int i9 = 0; i9 < g8; i9++) {
            this.f7189j.f(i9).offsetTopAndBottom(i8);
        }
    }

    public final void I(int i8, int i9, int i10, int i11, int[] iArr, int i12, @NonNull int[] iArr2) {
        getScrollingChildHelper().e(i8, i9, i10, i11, iArr, i12, iArr2);
    }

    void I0(int i8, int i9) {
        int j8 = this.f7189j.j();
        for (int i10 = 0; i10 < j8; i10++) {
            ViewHolder k02 = k0(this.f7189j.i(i10));
            if (k02 != null && !k02.L() && k02.f7334c >= i8) {
                k02.C(i9, false);
                this.f7198n0.f7313g = true;
            }
        }
        this.f7183g.u(i8, i9);
        requestLayout();
    }

    void J(int i8) {
        LayoutManager layoutManager = this.f7205r;
        if (layoutManager != null) {
            layoutManager.n1(i8);
        }
        R0(i8);
        OnScrollListener onScrollListener = this.f7200o0;
        if (onScrollListener != null) {
            onScrollListener.a(this, i8);
        }
        List<OnScrollListener> list = this.f7202p0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f7202p0.get(size).a(this, i8);
            }
        }
    }

    void J0(int i8, int i9) {
        int i10;
        int i11;
        int i12;
        int i13;
        int j8 = this.f7189j.j();
        if (i8 < i9) {
            i12 = -1;
            i11 = i8;
            i10 = i9;
        } else {
            i10 = i8;
            i11 = i9;
            i12 = 1;
        }
        for (int i14 = 0; i14 < j8; i14++) {
            ViewHolder k02 = k0(this.f7189j.i(i14));
            if (k02 != null && (i13 = k02.f7334c) >= i11 && i13 <= i10) {
                if (i13 == i8) {
                    k02.C(i9 - i8, false);
                } else {
                    k02.C(i12, false);
                }
                this.f7198n0.f7313g = true;
            }
        }
        this.f7183g.v(i8, i9);
        requestLayout();
    }

    void K(int i8, int i9) {
        this.M++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i8, scrollY - i9);
        S0(i8, i9);
        OnScrollListener onScrollListener = this.f7200o0;
        if (onScrollListener != null) {
            onScrollListener.b(this, i8, i9);
        }
        List<OnScrollListener> list = this.f7202p0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f7202p0.get(size).b(this, i8, i9);
            }
        }
        this.M--;
    }

    void K0(int i8, int i9, boolean z7) {
        int i10 = i8 + i9;
        int j8 = this.f7189j.j();
        for (int i11 = 0; i11 < j8; i11++) {
            ViewHolder k02 = k0(this.f7189j.i(i11));
            if (k02 != null && !k02.L()) {
                int i12 = k02.f7334c;
                if (i12 >= i10) {
                    k02.C(-i9, z7);
                    this.f7198n0.f7313g = true;
                } else if (i12 >= i8) {
                    k02.i(i8 - 1, -i9, z7);
                    this.f7198n0.f7313g = true;
                }
            }
        }
        this.f7183g.w(i8, i9, z7);
        requestLayout();
    }

    void L() {
        int i8;
        for (int size = this.B0.size() - 1; size >= 0; size--) {
            ViewHolder viewHolder = this.B0.get(size);
            if (viewHolder.f7332a.getParent() == this && !viewHolder.L() && (i8 = viewHolder.f7348q) != -1) {
                ViewCompat.D0(viewHolder.f7332a, i8);
                viewHolder.f7348q = -1;
            }
        }
        this.B0.clear();
    }

    public void L0(@NonNull View view) {
    }

    public void M0(@NonNull View view) {
    }

    void N() {
        if (this.R != null) {
            return;
        }
        EdgeEffect a8 = this.N.a(this, 3);
        this.R = a8;
        if (this.f7193l) {
            a8.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            a8.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N0() {
        this.L++;
    }

    void O() {
        if (this.O != null) {
            return;
        }
        EdgeEffect a8 = this.N.a(this, 0);
        this.O = a8;
        if (this.f7193l) {
            a8.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            a8.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void O0() {
        P0(true);
    }

    void P() {
        if (this.Q != null) {
            return;
        }
        EdgeEffect a8 = this.N.a(this, 2);
        this.Q = a8;
        if (this.f7193l) {
            a8.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            a8.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P0(boolean z7) {
        int i8 = this.L - 1;
        this.L = i8;
        if (i8 < 1) {
            this.L = 0;
            if (z7) {
                C();
                L();
            }
        }
    }

    void Q() {
        if (this.P != null) {
            return;
        }
        EdgeEffect a8 = this.N.a(this, 1);
        this.P = a8;
        if (this.f7193l) {
            a8.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            a8.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    String R() {
        return " " + super.toString() + ", adapter:" + this.f7203q + ", layout:" + this.f7205r + ", context:" + getContext();
    }

    public void R0(int i8) {
    }

    final void S(State state) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.f7192k0.f7326h;
            state.f7322p = overScroller.getFinalX() - overScroller.getCurrX();
            state.f7323q = overScroller.getFinalY() - overScroller.getCurrY();
            return;
        }
        state.f7322p = 0;
        state.f7323q = 0;
    }

    public void S0(int i8, int i9) {
    }

    public View T(float f8, float f9) {
        for (int g8 = this.f7189j.g() - 1; g8 >= 0; g8--) {
            View f10 = this.f7189j.f(g8);
            float translationX = f10.getTranslationX();
            float translationY = f10.getTranslationY();
            if (f8 >= f10.getLeft() + translationX && f8 <= f10.getRight() + translationX && f9 >= f10.getTop() + translationY && f9 <= f10.getBottom() + translationY) {
                return f10;
            }
        }
        return null;
    }

    void T0() {
        if (!this.f7210t0 && this.f7217x) {
            ViewCompat.k0(this, this.C0);
            this.f7210t0 = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View U(@androidx.annotation.NonNull android.view.View r3) {
        /*
            r2 = this;
            android.view.ViewParent r0 = r3.getParent()
        L4:
            if (r0 == 0) goto L14
            if (r0 == r2) goto L14
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L14
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            android.view.ViewParent r0 = r3.getParent()
            goto L4
        L14:
            if (r0 != r2) goto L17
            goto L18
        L17:
            r3 = 0
        L18:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.U(android.view.View):android.view.View");
    }

    public ViewHolder V(@NonNull View view) {
        View U = U(view);
        if (U == null) {
            return null;
        }
        return j0(U);
    }

    void W0(boolean z7) {
        this.K = z7 | this.K;
        this.J = true;
        E0();
    }

    void Y0(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo) {
        viewHolder.H(0, FragmentTransaction.TRANSIT_EXIT_MASK);
        if (this.f7198n0.f7315i && viewHolder.A() && !viewHolder.x() && !viewHolder.L()) {
            this.f7191k.c(g0(viewHolder), viewHolder);
        }
        this.f7191k.e(viewHolder, itemHolderInfo);
    }

    public ViewHolder a0(int i8) {
        ViewHolder viewHolder = null;
        if (this.J) {
            return null;
        }
        int j8 = this.f7189j.j();
        for (int i9 = 0; i9 < j8; i9++) {
            ViewHolder k02 = k0(this.f7189j.i(i9));
            if (k02 != null && !k02.x() && f0(k02) == i8) {
                if (this.f7189j.n(k02.f7332a)) {
                    viewHolder = k02;
                } else {
                    return k02;
                }
            }
        }
        return viewHolder;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i8, int i9) {
        LayoutManager layoutManager = this.f7205r;
        if (layoutManager == null || !layoutManager.O0(this, arrayList, i8, i9)) {
            super.addFocusables(arrayList, i8, i9);
        }
    }

    void b(int i8, int i9) {
        if (i8 < 0) {
            O();
            if (this.O.isFinished()) {
                this.O.onAbsorb(-i8);
            }
        } else if (i8 > 0) {
            P();
            if (this.Q.isFinished()) {
                this.Q.onAbsorb(i8);
            }
        }
        if (i9 < 0) {
            Q();
            if (this.P.isFinished()) {
                this.P.onAbsorb(-i9);
            }
        } else if (i9 > 0) {
            N();
            if (this.R.isFinished()) {
                this.R.onAbsorb(i9);
            }
        }
        if (i8 != 0 || i9 != 0) {
            ViewCompat.j0(this);
        }
    }

    public ViewHolder b0(long j8) {
        Adapter adapter = this.f7203q;
        ViewHolder viewHolder = null;
        if (adapter != null && adapter.v()) {
            int j9 = this.f7189j.j();
            for (int i8 = 0; i8 < j9; i8++) {
                ViewHolder k02 = k0(this.f7189j.i(i8));
                if (k02 != null && !k02.x() && k02.m() == j8) {
                    if (this.f7189j.n(k02.f7332a)) {
                        viewHolder = k02;
                    } else {
                        return k02;
                    }
                }
            }
        }
        return viewHolder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b1() {
        ItemAnimator itemAnimator = this.S;
        if (itemAnimator != null) {
            itemAnimator.k();
        }
        LayoutManager layoutManager = this.f7205r;
        if (layoutManager != null) {
            layoutManager.u1(this.f7183g);
            this.f7205r.v1(this.f7183g);
        }
        this.f7183g.c();
    }

    public ViewHolder c0(int i8) {
        return d0(i8, false);
    }

    boolean c1(View view) {
        y1();
        boolean r7 = this.f7189j.r(view);
        if (r7) {
            ViewHolder k02 = k0(view);
            this.f7183g.J(k02);
            this.f7183g.C(k02);
        }
        A1(!r7);
        return r7;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof LayoutParams) && this.f7205r.x((LayoutParams) layoutParams)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        LayoutManager layoutManager = this.f7205r;
        if (layoutManager == null || !layoutManager.v()) {
            return 0;
        }
        return this.f7205r.B(this.f7198n0);
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        LayoutManager layoutManager = this.f7205r;
        if (layoutManager == null || !layoutManager.v()) {
            return 0;
        }
        return this.f7205r.C(this.f7198n0);
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        LayoutManager layoutManager = this.f7205r;
        if (layoutManager == null || !layoutManager.v()) {
            return 0;
        }
        return this.f7205r.D(this.f7198n0);
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        LayoutManager layoutManager = this.f7205r;
        if (layoutManager == null || !layoutManager.w()) {
            return 0;
        }
        return this.f7205r.E(this.f7198n0);
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        LayoutManager layoutManager = this.f7205r;
        if (layoutManager == null || !layoutManager.w()) {
            return 0;
        }
        return this.f7205r.F(this.f7198n0);
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        LayoutManager layoutManager = this.f7205r;
        if (layoutManager == null || !layoutManager.w()) {
            return 0;
        }
        return this.f7205r.G(this.f7198n0);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0036 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    androidx.recyclerview.widget.RecyclerView.ViewHolder d0(int r6, boolean r7) {
        /*
            r5 = this;
            androidx.recyclerview.widget.ChildHelper r0 = r5.f7189j
            int r0 = r0.j()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3a
            androidx.recyclerview.widget.ChildHelper r3 = r5.f7189j
            android.view.View r3 = r3.i(r2)
            androidx.recyclerview.widget.RecyclerView$ViewHolder r3 = k0(r3)
            if (r3 == 0) goto L37
            boolean r4 = r3.x()
            if (r4 != 0) goto L37
            if (r7 == 0) goto L23
            int r4 = r3.f7334c
            if (r4 == r6) goto L2a
            goto L37
        L23:
            int r4 = r3.o()
            if (r4 == r6) goto L2a
            goto L37
        L2a:
            androidx.recyclerview.widget.ChildHelper r1 = r5.f7189j
            android.view.View r4 = r3.f7332a
            boolean r1 = r1.n(r4)
            if (r1 == 0) goto L36
            r1 = r3
            goto L37
        L36:
            return r3
        L37:
            int r2 = r2 + 1
            goto L8
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.d0(int, boolean):androidx.recyclerview.widget.RecyclerView$ViewHolder");
    }

    public void d1(@NonNull ItemDecoration itemDecoration) {
        boolean z7;
        LayoutManager layoutManager = this.f7205r;
        if (layoutManager != null) {
            layoutManager.r("Cannot remove item decoration during a scroll  or layout");
        }
        this.f7211u.remove(itemDecoration);
        if (this.f7211u.isEmpty()) {
            if (getOverScrollMode() == 2) {
                z7 = true;
            } else {
                z7 = false;
            }
            setWillNotDraw(z7);
        }
        D0();
        requestLayout();
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f8, float f9, boolean z7) {
        return getScrollingChildHelper().a(f8, f9, z7);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f8, float f9) {
        return getScrollingChildHelper().b(f8, f9);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i8, int i9, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i8, i9, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i8, int i9, int i10, int i11, int[] iArr) {
        return getScrollingChildHelper().f(i8, i9, i10, i11, iArr);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z7;
        int i8;
        boolean z8;
        boolean z9;
        int i9;
        super.draw(canvas);
        int size = this.f7211u.size();
        boolean z10 = false;
        for (int i10 = 0; i10 < size; i10++) {
            this.f7211u.get(i10).k(canvas, this, this.f7198n0);
        }
        EdgeEffect edgeEffect = this.O;
        boolean z11 = true;
        if (edgeEffect != null && !edgeEffect.isFinished()) {
            int save = canvas.save();
            if (this.f7193l) {
                i9 = getPaddingBottom();
            } else {
                i9 = 0;
            }
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + i9, 0.0f);
            EdgeEffect edgeEffect2 = this.O;
            if (edgeEffect2 != null && edgeEffect2.draw(canvas)) {
                z7 = true;
            } else {
                z7 = false;
            }
            canvas.restoreToCount(save);
        } else {
            z7 = false;
        }
        EdgeEffect edgeEffect3 = this.P;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.f7193l) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.P;
            if (edgeEffect4 != null && edgeEffect4.draw(canvas)) {
                z9 = true;
            } else {
                z9 = false;
            }
            z7 |= z9;
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.Q;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            if (this.f7193l) {
                i8 = getPaddingTop();
            } else {
                i8 = 0;
            }
            canvas.rotate(90.0f);
            canvas.translate(i8, -width);
            EdgeEffect edgeEffect6 = this.Q;
            if (edgeEffect6 != null && edgeEffect6.draw(canvas)) {
                z8 = true;
            } else {
                z8 = false;
            }
            z7 |= z8;
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.R;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f7193l) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.R;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z10 = true;
            }
            z7 |= z10;
            canvas.restoreToCount(save4);
        }
        if (z7 || this.S == null || this.f7211u.size() <= 0 || !this.S.p()) {
            z11 = z7;
        }
        if (z11) {
            ViewCompat.j0(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j8) {
        return super.drawChild(canvas, view, j8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public boolean e0(int i8, int i9) {
        boolean z7;
        LayoutManager layoutManager = this.f7205r;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.D) {
            return false;
        } else {
            int v7 = layoutManager.v();
            boolean w7 = this.f7205r.w();
            i8 = (v7 == 0 || Math.abs(i8) < this.f7182f0) ? 0 : 0;
            i9 = (!w7 || Math.abs(i9) < this.f7182f0) ? 0 : 0;
            if (i8 == 0 && i9 == 0) {
                return false;
            }
            float f8 = i8;
            float f9 = i9;
            if (!dispatchNestedPreFling(f8, f9)) {
                if (v7 == 0 && !w7) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                dispatchNestedFling(f8, f9, z7);
                OnFlingListener onFlingListener = this.f7180e0;
                if (onFlingListener != null && onFlingListener.a(i8, i9)) {
                    return true;
                }
                if (z7) {
                    if (w7) {
                        v7 = (v7 == true ? 1 : 0) | 2;
                    }
                    z1(v7, 1);
                    int i10 = this.f7184g0;
                    int max = Math.max(-i10, Math.min(i8, i10));
                    int i11 = this.f7184g0;
                    this.f7192k0.b(max, Math.max(-i11, Math.min(i9, i11)));
                    return true;
                }
            }
            return false;
        }
    }

    public void e1(@NonNull OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        List<OnChildAttachStateChangeListener> list = this.I;
        if (list == null) {
            return;
        }
        list.remove(onChildAttachStateChangeListener);
    }

    int f0(ViewHolder viewHolder) {
        if (!viewHolder.r(524) && viewHolder.u()) {
            return this.f7187i.e(viewHolder.f7334c);
        }
        return -1;
    }

    public void f1(@NonNull OnItemTouchListener onItemTouchListener) {
        this.f7213v.remove(onItemTouchListener);
        if (this.f7215w == onItemTouchListener) {
            this.f7215w = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i8) {
        boolean z7;
        View view2;
        boolean z8;
        boolean z9;
        boolean z10;
        int i9;
        int i10;
        View Z0 = this.f7205r.Z0(view, i8);
        if (Z0 != null) {
            return Z0;
        }
        boolean z11 = true;
        if (this.f7203q != null && this.f7205r != null && !A0() && !this.D) {
            z7 = true;
        } else {
            z7 = false;
        }
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z7 && (i8 == 2 || i8 == 1)) {
            if (this.f7205r.w()) {
                if (i8 == 2) {
                    i10 = 130;
                } else {
                    i10 = 33;
                }
                if (focusFinder.findNextFocus(this, view, i10) == null) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (M0) {
                    i8 = i10;
                }
            } else {
                z8 = false;
            }
            if (!z8 && this.f7205r.v()) {
                if (this.f7205r.k0() == 1) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                if (i8 == 2) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z9 ^ z10) {
                    i9 = 66;
                } else {
                    i9 = 17;
                }
                if (focusFinder.findNextFocus(this, view, i9) != null) {
                    z11 = false;
                }
                if (M0) {
                    i8 = i9;
                }
                z8 = z11;
            }
            if (z8) {
                w();
                if (U(view) == null) {
                    return null;
                }
                y1();
                this.f7205r.S0(view, i8, this.f7183g, this.f7198n0);
                A1(false);
            }
            view2 = focusFinder.findNextFocus(this, view, i8);
        } else {
            View findNextFocus = focusFinder.findNextFocus(this, view, i8);
            if (findNextFocus == null && z7) {
                w();
                if (U(view) == null) {
                    return null;
                }
                y1();
                view2 = this.f7205r.S0(view, i8, this.f7183g, this.f7198n0);
                A1(false);
            } else {
                view2 = findNextFocus;
            }
        }
        if (view2 != null && !view2.hasFocusable()) {
            if (getFocusedChild() == null) {
                return super.focusSearch(view, i8);
            }
            i1(view2, null);
            return view;
        } else if (!B0(view, view2, i8)) {
            return super.focusSearch(view, i8);
        } else {
            return view2;
        }
    }

    long g0(ViewHolder viewHolder) {
        if (this.f7203q.v()) {
            return viewHolder.m();
        }
        return viewHolder.f7334c;
    }

    public void g1(@NonNull OnScrollListener onScrollListener) {
        List<OnScrollListener> list = this.f7202p0;
        if (list != null) {
            list.remove(onScrollListener);
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutManager layoutManager = this.f7205r;
        if (layoutManager != null) {
            return layoutManager.O();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + R());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        LayoutManager layoutManager = this.f7205r;
        if (layoutManager != null) {
            return layoutManager.P(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + R());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public Adapter getAdapter() {
        return this.f7203q;
    }

    @Override // android.view.View
    public int getBaseline() {
        LayoutManager layoutManager = this.f7205r;
        if (layoutManager != null) {
            return layoutManager.R();
        }
        return super.getBaseline();
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i8, int i9) {
        ChildDrawingOrderCallback childDrawingOrderCallback = this.f7214v0;
        if (childDrawingOrderCallback == null) {
            return super.getChildDrawingOrder(i8, i9);
        }
        return childDrawingOrderCallback.a(i8, i9);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f7193l;
    }

    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.f7212u0;
    }

    @NonNull
    public EdgeEffectFactory getEdgeEffectFactory() {
        return this.N;
    }

    public ItemAnimator getItemAnimator() {
        return this.S;
    }

    public int getItemDecorationCount() {
        return this.f7211u.size();
    }

    public LayoutManager getLayoutManager() {
        return this.f7205r;
    }

    public int getMaxFlingVelocity() {
        return this.f7184g0;
    }

    public int getMinFlingVelocity() {
        return this.f7182f0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getNanoTime() {
        if (L0) {
            return System.nanoTime();
        }
        return 0L;
    }

    public OnFlingListener getOnFlingListener() {
        return this.f7180e0;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f7190j0;
    }

    @NonNull
    public RecycledViewPool getRecycledViewPool() {
        return this.f7183g.i();
    }

    public int getScrollState() {
        return this.T;
    }

    public void h(@NonNull ItemDecoration itemDecoration) {
        i(itemDecoration, -1);
    }

    public int h0(@NonNull View view) {
        ViewHolder k02 = k0(view);
        if (k02 != null) {
            return k02.j();
        }
        return -1;
    }

    void h1() {
        ViewHolder viewHolder;
        int g8 = this.f7189j.g();
        for (int i8 = 0; i8 < g8; i8++) {
            View f8 = this.f7189j.f(i8);
            ViewHolder j02 = j0(f8);
            if (j02 != null && (viewHolder = j02.f7340i) != null) {
                View view = viewHolder.f7332a;
                int left = f8.getLeft();
                int top = f8.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().j();
    }

    public void i(@NonNull ItemDecoration itemDecoration, int i8) {
        LayoutManager layoutManager = this.f7205r;
        if (layoutManager != null) {
            layoutManager.r("Cannot add item decoration during a scroll  or layout");
        }
        if (this.f7211u.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i8 < 0) {
            this.f7211u.add(itemDecoration);
        } else {
            this.f7211u.add(i8, itemDecoration);
        }
        D0();
        requestLayout();
    }

    public int i0(@NonNull View view) {
        ViewHolder k02 = k0(view);
        if (k02 != null) {
            return k02.o();
        }
        return -1;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.f7217x;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.D;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().l();
    }

    public void j(@NonNull OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        if (this.I == null) {
            this.I = new ArrayList();
        }
        this.I.add(onChildAttachStateChangeListener);
    }

    public ViewHolder j0(@NonNull View view) {
        ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
        }
        return k0(view);
    }

    public void k(@NonNull OnItemTouchListener onItemTouchListener) {
        this.f7213v.add(onItemTouchListener);
    }

    public void l(@NonNull OnScrollListener onScrollListener) {
        if (this.f7202p0 == null) {
            this.f7202p0 = new ArrayList();
        }
        this.f7202p0.add(onScrollListener);
    }

    public void l0(@NonNull View view, @NonNull Rect rect) {
        m0(view, rect);
    }

    void m(@NonNull ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        viewHolder.I(false);
        if (this.S.a(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            T0();
        }
    }

    void m1() {
        int j8 = this.f7189j.j();
        for (int i8 = 0; i8 < j8; i8++) {
            ViewHolder k02 = k0(this.f7189j.i(i8));
            if (!k02.L()) {
                k02.G();
            }
        }
    }

    boolean n1(int i8, int i9, MotionEvent motionEvent, int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z7;
        w();
        if (this.f7203q != null) {
            int[] iArr = this.A0;
            iArr[0] = 0;
            iArr[1] = 0;
            o1(i8, i9, iArr);
            int[] iArr2 = this.A0;
            int i15 = iArr2[0];
            int i16 = iArr2[1];
            i11 = i16;
            i12 = i15;
            i13 = i8 - i15;
            i14 = i9 - i16;
        } else {
            i11 = 0;
            i12 = 0;
            i13 = 0;
            i14 = 0;
        }
        if (!this.f7211u.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.A0;
        iArr3[0] = 0;
        iArr3[1] = 0;
        I(i12, i11, i13, i14, this.f7220y0, i10, iArr3);
        int[] iArr4 = this.A0;
        int i17 = iArr4[0];
        int i18 = i13 - i17;
        int i19 = iArr4[1];
        int i20 = i14 - i19;
        if (i17 == 0 && i19 == 0) {
            z7 = false;
        } else {
            z7 = true;
        }
        int i21 = this.f7177b0;
        int[] iArr5 = this.f7220y0;
        int i22 = iArr5[0];
        this.f7177b0 = i21 - i22;
        int i23 = this.f7178c0;
        int i24 = iArr5[1];
        this.f7178c0 = i23 - i24;
        int[] iArr6 = this.f7222z0;
        iArr6[0] = iArr6[0] + i22;
        iArr6[1] = iArr6[1] + i24;
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !MotionEventCompat.a(motionEvent, FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)) {
                X0(motionEvent.getX(), i18, motionEvent.getY(), i20);
            }
            v(i8, i9);
        }
        if (i12 != 0 || i11 != 0) {
            K(i12, i11);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (z7 || i12 != 0 || i11 != 0) {
            return true;
        }
        return false;
    }

    void o(@NonNull ViewHolder viewHolder, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        g(viewHolder);
        viewHolder.I(false);
        if (this.S.c(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            T0();
        }
    }

    void o1(int i8, int i9, int[] iArr) {
        int i10;
        int i11;
        y1();
        N0();
        TraceCompat.a("RV Scroll");
        S(this.f7198n0);
        if (i8 != 0) {
            i10 = this.f7205r.G1(i8, this.f7183g, this.f7198n0);
        } else {
            i10 = 0;
        }
        if (i9 != 0) {
            i11 = this.f7205r.I1(i9, this.f7183g, this.f7198n0);
        } else {
            i11 = 0;
        }
        TraceCompat.b();
        h1();
        O0();
        A1(false);
        if (iArr != null) {
            iArr[0] = i10;
            iArr[1] = i11;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.L = 0;
        boolean z7 = true;
        this.f7217x = true;
        this.A = (!this.A || isLayoutRequested()) ? false : false;
        LayoutManager layoutManager = this.f7205r;
        if (layoutManager != null) {
            layoutManager.K(this);
        }
        this.f7210t0 = false;
        if (L0) {
            ThreadLocal<GapWorker> threadLocal = GapWorker.f7044j;
            GapWorker gapWorker = threadLocal.get();
            this.f7194l0 = gapWorker;
            if (gapWorker == null) {
                this.f7194l0 = new GapWorker();
                Display x7 = ViewCompat.x(this);
                float f8 = 60.0f;
                if (!isInEditMode() && x7 != null) {
                    float refreshRate = x7.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        f8 = refreshRate;
                    }
                }
                GapWorker gapWorker2 = this.f7194l0;
                gapWorker2.f7048h = 1.0E9f / f8;
                threadLocal.set(gapWorker2);
            }
            this.f7194l0.a(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        GapWorker gapWorker;
        super.onDetachedFromWindow();
        ItemAnimator itemAnimator = this.S;
        if (itemAnimator != null) {
            itemAnimator.k();
        }
        C1();
        this.f7217x = false;
        LayoutManager layoutManager = this.f7205r;
        if (layoutManager != null) {
            layoutManager.L(this, this.f7183g);
        }
        this.B0.clear();
        removeCallbacks(this.C0);
        this.f7191k.j();
        if (L0 && (gapWorker = this.f7194l0) != null) {
            gapWorker.j(this);
            this.f7194l0 = null;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f7211u.size();
        for (int i8 = 0; i8 < size; i8++) {
            this.f7211u.get(i8).i(canvas, this, this.f7198n0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0066  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r5.f7205r
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.D
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L78
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3c
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r5.f7205r
            boolean r0 = r0.w()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = 0
        L2d:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r3 = r5.f7205r
            boolean r3 = r3.v()
            if (r3 == 0) goto L61
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L62
        L3c:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L60
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r3 = r5.f7205r
            boolean r3 = r3.w()
            if (r3 == 0) goto L55
            float r0 = -r0
            goto L61
        L55:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r3 = r5.f7205r
            boolean r3 = r3.v()
            if (r3 == 0) goto L60
            r3 = r0
            r0 = 0
            goto L62
        L60:
            r0 = 0
        L61:
            r3 = 0
        L62:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6a
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L78
        L6a:
            float r2 = r5.f7186h0
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.f7188i0
            float r0 = r0 * r3
            int r0 = (int) r0
            r3 = 1
            r5.F0(r2, r0, r6, r3)
        L78:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z7;
        if (this.D) {
            return false;
        }
        this.f7215w = null;
        if (W(motionEvent)) {
            r();
            return true;
        }
        LayoutManager layoutManager = this.f7205r;
        if (layoutManager == null) {
            return false;
        }
        boolean v7 = layoutManager.v();
        boolean w7 = this.f7205r.w();
        if (this.V == null) {
            this.V = VelocityTracker.obtain();
        }
        this.V.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                Q0(motionEvent);
                            }
                        } else {
                            this.U = motionEvent.getPointerId(actionIndex);
                            int x7 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                            this.f7177b0 = x7;
                            this.W = x7;
                            int y7 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                            this.f7178c0 = y7;
                            this.f7176a0 = y7;
                        }
                    } else {
                        r();
                    }
                } else {
                    int findPointerIndex = motionEvent.findPointerIndex(this.U);
                    if (findPointerIndex < 0) {
                        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.U + " not found. Did any MotionEvents get skipped?");
                        return false;
                    }
                    int x8 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                    int y8 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                    if (this.T != 1) {
                        int i8 = x8 - this.W;
                        int i9 = y8 - this.f7176a0;
                        if (v7 && Math.abs(i8) > this.f7179d0) {
                            this.f7177b0 = x8;
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        if (w7 && Math.abs(i9) > this.f7179d0) {
                            this.f7178c0 = y8;
                            z7 = true;
                        }
                        if (z7) {
                            setScrollState(1);
                        }
                    }
                }
            } else {
                this.V.clear();
                B1(0);
            }
        } else {
            if (this.E) {
                this.E = false;
            }
            this.U = motionEvent.getPointerId(0);
            int x9 = (int) (motionEvent.getX() + 0.5f);
            this.f7177b0 = x9;
            this.W = x9;
            int y9 = (int) (motionEvent.getY() + 0.5f);
            this.f7178c0 = y9;
            this.f7176a0 = y9;
            if (this.T == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                B1(1);
            }
            int[] iArr = this.f7222z0;
            iArr[1] = 0;
            iArr[0] = 0;
            int i10 = v7;
            if (w7) {
                i10 = (v7 ? 1 : 0) | 2;
            }
            z1(i10, 0);
        }
        if (this.T != 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        TraceCompat.a("RV OnLayout");
        D();
        TraceCompat.b();
        this.A = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i8, int i9) {
        LayoutManager layoutManager = this.f7205r;
        if (layoutManager == null) {
            y(i8, i9);
            return;
        }
        boolean z7 = false;
        if (layoutManager.z0()) {
            int mode = View.MeasureSpec.getMode(i8);
            int mode2 = View.MeasureSpec.getMode(i9);
            this.f7205r.i1(this.f7183g, this.f7198n0, i8, i9);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z7 = true;
            }
            this.D0 = z7;
            if (!z7 && this.f7203q != null) {
                if (this.f7198n0.f7311e == 1) {
                    E();
                }
                this.f7205r.L1(i8, i9);
                this.f7198n0.f7316j = true;
                F();
                this.f7205r.O1(i8, i9);
                if (this.f7205r.R1()) {
                    this.f7205r.L1(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), Pow2.MAX_POW2), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), Pow2.MAX_POW2));
                    this.f7198n0.f7316j = true;
                    F();
                    this.f7205r.O1(i8, i9);
                }
                this.E0 = getMeasuredWidth();
                this.F0 = getMeasuredHeight();
            }
        } else if (this.f7219y) {
            this.f7205r.i1(this.f7183g, this.f7198n0, i8, i9);
        } else {
            if (this.G) {
                y1();
                N0();
                V0();
                O0();
                State state = this.f7198n0;
                if (state.f7318l) {
                    state.f7314h = true;
                } else {
                    this.f7187i.j();
                    this.f7198n0.f7314h = false;
                }
                this.G = false;
                A1(false);
            } else if (this.f7198n0.f7318l) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            Adapter adapter = this.f7203q;
            if (adapter != null) {
                this.f7198n0.f7312f = adapter.r();
            } else {
                this.f7198n0.f7312f = 0;
            }
            y1();
            this.f7205r.i1(this.f7183g, this.f7198n0, i8, i9);
            A1(false);
            this.f7198n0.f7314h = false;
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i8, Rect rect) {
        if (A0()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i8, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.f7185h = savedState;
        super.onRestoreInstanceState(savedState.a());
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.f7185h;
        if (savedState2 != null) {
            savedState.b(savedState2);
        } else {
            LayoutManager layoutManager = this.f7205r;
            if (layoutManager != null) {
                savedState.f7291h = layoutManager.m1();
            } else {
                savedState.f7291h = null;
            }
        }
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        if (i8 != i10 || i9 != i11) {
            x0();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 480
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    void p(String str) {
        if (A0()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + R());
            }
            throw new IllegalStateException(str);
        } else if (this.M > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + R()));
        }
    }

    Rect p0(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.f7273h) {
            return layoutParams.f7272g;
        }
        if (this.f7198n0.e() && (layoutParams.b() || layoutParams.d())) {
            return layoutParams.f7272g;
        }
        Rect rect = layoutParams.f7272g;
        rect.set(0, 0, 0, 0);
        int size = this.f7211u.size();
        for (int i8 = 0; i8 < size; i8++) {
            this.f7197n.set(0, 0, 0, 0);
            this.f7211u.get(i8).g(this.f7197n, view, this, this.f7198n0);
            int i9 = rect.left;
            Rect rect2 = this.f7197n;
            rect.left = i9 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        layoutParams.f7273h = false;
        return rect;
    }

    public void p1(int i8) {
        if (this.D) {
            return;
        }
        C1();
        LayoutManager layoutManager = this.f7205r;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        layoutManager.H1(i8);
        awakenScrollBars();
    }

    boolean q(ViewHolder viewHolder) {
        ItemAnimator itemAnimator = this.S;
        if (itemAnimator != null && !itemAnimator.g(viewHolder, viewHolder.q())) {
            return false;
        }
        return true;
    }

    public boolean r0() {
        if (this.A && !this.J && !this.f7187i.p()) {
            return false;
        }
        return true;
    }

    boolean r1(ViewHolder viewHolder, int i8) {
        if (A0()) {
            viewHolder.f7348q = i8;
            this.B0.add(viewHolder);
            return false;
        }
        ViewCompat.D0(viewHolder.f7332a, i8);
        return true;
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z7) {
        ViewHolder k02 = k0(view);
        if (k02 != null) {
            if (k02.z()) {
                k02.f();
            } else if (!k02.L()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + k02 + R());
            }
        }
        view.clearAnimation();
        B(view);
        super.removeDetachedView(view, z7);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.f7205r.k1(this, this.f7198n0, view, view2) && view2 != null) {
            i1(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z7) {
        return this.f7205r.B1(this, view, rect, z7);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z7) {
        int size = this.f7213v.size();
        for (int i8 = 0; i8 < size; i8++) {
            this.f7213v.get(i8).e(z7);
        }
        super.requestDisallowInterceptTouchEvent(z7);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.B == 0 && !this.D) {
            super.requestLayout();
        } else {
            this.C = true;
        }
    }

    boolean s1(AccessibilityEvent accessibilityEvent) {
        int i8;
        int i9 = 0;
        if (!A0()) {
            return false;
        }
        if (accessibilityEvent != null) {
            i8 = AccessibilityEventCompat.a(accessibilityEvent);
        } else {
            i8 = 0;
        }
        if (i8 != 0) {
            i9 = i8;
        }
        this.F |= i9;
        return true;
    }

    @Override // android.view.View
    public void scrollBy(int i8, int i9) {
        LayoutManager layoutManager = this.f7205r;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (this.D) {
        } else {
            boolean v7 = layoutManager.v();
            boolean w7 = this.f7205r.w();
            if (v7 || w7) {
                if (!v7) {
                    i8 = 0;
                }
                if (!w7) {
                    i9 = 0;
                }
                n1(i8, i9, null, 0);
            }
        }
    }

    @Override // android.view.View
    public void scrollTo(int i8, int i9) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (s1(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
        this.f7212u0 = recyclerViewAccessibilityDelegate;
        ViewCompat.s0(this, recyclerViewAccessibilityDelegate);
    }

    public void setAdapter(Adapter adapter) {
        setLayoutFrozen(false);
        q1(adapter, false, true);
        W0(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(ChildDrawingOrderCallback childDrawingOrderCallback) {
        boolean z7;
        if (childDrawingOrderCallback == this.f7214v0) {
            return;
        }
        this.f7214v0 = childDrawingOrderCallback;
        if (childDrawingOrderCallback != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        setChildrenDrawingOrderEnabled(z7);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z7) {
        if (z7 != this.f7193l) {
            x0();
        }
        this.f7193l = z7;
        super.setClipToPadding(z7);
        if (this.A) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(@NonNull EdgeEffectFactory edgeEffectFactory) {
        Preconditions.g(edgeEffectFactory);
        this.N = edgeEffectFactory;
        x0();
    }

    public void setHasFixedSize(boolean z7) {
        this.f7219y = z7;
    }

    public void setItemAnimator(ItemAnimator itemAnimator) {
        ItemAnimator itemAnimator2 = this.S;
        if (itemAnimator2 != null) {
            itemAnimator2.k();
            this.S.w(null);
        }
        this.S = itemAnimator;
        if (itemAnimator != null) {
            itemAnimator.w(this.f7208s0);
        }
    }

    public void setItemViewCacheSize(int i8) {
        this.f7183g.G(i8);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z7) {
        suppressLayout(z7);
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        if (layoutManager == this.f7205r) {
            return;
        }
        C1();
        if (this.f7205r != null) {
            ItemAnimator itemAnimator = this.S;
            if (itemAnimator != null) {
                itemAnimator.k();
            }
            this.f7205r.u1(this.f7183g);
            this.f7205r.v1(this.f7183g);
            this.f7183g.c();
            if (this.f7217x) {
                this.f7205r.L(this, this.f7183g);
            }
            this.f7205r.P1(null);
            this.f7205r = null;
        } else {
            this.f7183g.c();
        }
        this.f7189j.o();
        this.f7205r = layoutManager;
        if (layoutManager != null) {
            if (layoutManager.f7248g == null) {
                layoutManager.P1(this);
                if (this.f7217x) {
                    this.f7205r.K(this);
                }
            } else {
                throw new IllegalArgumentException("LayoutManager " + layoutManager + " is already attached to a RecyclerView:" + layoutManager.f7248g.R());
            }
        }
        this.f7183g.K();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition == null) {
            super.setLayoutTransition(null);
            return;
        }
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z7) {
        getScrollingChildHelper().m(z7);
    }

    public void setOnFlingListener(OnFlingListener onFlingListener) {
        this.f7180e0 = onFlingListener;
    }

    @Deprecated
    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.f7200o0 = onScrollListener;
    }

    public void setPreserveFocusAfterLayout(boolean z7) {
        this.f7190j0 = z7;
    }

    public void setRecycledViewPool(RecycledViewPool recycledViewPool) {
        this.f7183g.E(recycledViewPool);
    }

    @Deprecated
    public void setRecyclerListener(RecyclerListener recyclerListener) {
        this.f7207s = recyclerListener;
    }

    void setScrollState(int i8) {
        if (i8 == this.T) {
            return;
        }
        this.T = i8;
        if (i8 != 2) {
            D1();
        }
        J(i8);
    }

    public void setScrollingTouchSlop(int i8) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i8 != 0) {
            if (i8 != 1) {
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i8 + "; using default value");
            } else {
                this.f7179d0 = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.f7179d0 = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(ViewCacheExtension viewCacheExtension) {
        this.f7183g.F(viewCacheExtension);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i8) {
        return getScrollingChildHelper().o(i8);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        getScrollingChildHelper().q();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z7) {
        if (z7 != this.D) {
            p("Do not suppressLayout in layout or scroll");
            if (!z7) {
                this.D = false;
                if (this.C && this.f7205r != null && this.f7203q != null) {
                    requestLayout();
                }
                this.C = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.D = true;
            this.E = true;
            C1();
        }
    }

    void t() {
        int j8 = this.f7189j.j();
        for (int i8 = 0; i8 < j8; i8++) {
            ViewHolder k02 = k0(this.f7189j.i(i8));
            if (!k02.L()) {
                k02.c();
            }
        }
        this.f7183g.d();
    }

    void t0() {
        this.f7187i = new AdapterHelper(new AdapterHelper.Callback() { // from class: androidx.recyclerview.widget.RecyclerView.6
            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void a(int i8, int i9) {
                RecyclerView.this.J0(i8, i9);
                RecyclerView.this.f7204q0 = true;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void b(AdapterHelper.UpdateOp updateOp) {
                i(updateOp);
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void c(AdapterHelper.UpdateOp updateOp) {
                i(updateOp);
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void d(int i8, int i9) {
                RecyclerView.this.K0(i8, i9, false);
                RecyclerView.this.f7204q0 = true;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void e(int i8, int i9, Object obj) {
                RecyclerView.this.E1(i8, i9, obj);
                RecyclerView.this.f7206r0 = true;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public ViewHolder f(int i8) {
                ViewHolder d02 = RecyclerView.this.d0(i8, true);
                if (d02 == null || RecyclerView.this.f7189j.n(d02.f7332a)) {
                    return null;
                }
                return d02;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void g(int i8, int i9) {
                RecyclerView.this.I0(i8, i9);
                RecyclerView.this.f7204q0 = true;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void h(int i8, int i9) {
                RecyclerView.this.K0(i8, i9, true);
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.f7204q0 = true;
                recyclerView.f7198n0.f7310d += i9;
            }

            void i(AdapterHelper.UpdateOp updateOp) {
                int i8 = updateOp.f6897a;
                if (i8 != 1) {
                    if (i8 != 2) {
                        if (i8 != 4) {
                            if (i8 == 8) {
                                RecyclerView recyclerView = RecyclerView.this;
                                recyclerView.f7205r.c1(recyclerView, updateOp.f6898b, updateOp.f6900d, 1);
                                return;
                            }
                            return;
                        }
                        RecyclerView recyclerView2 = RecyclerView.this;
                        recyclerView2.f7205r.f1(recyclerView2, updateOp.f6898b, updateOp.f6900d, updateOp.f6899c);
                        return;
                    }
                    RecyclerView recyclerView3 = RecyclerView.this;
                    recyclerView3.f7205r.d1(recyclerView3, updateOp.f6898b, updateOp.f6900d);
                    return;
                }
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.f7205r.a1(recyclerView4, updateOp.f6898b, updateOp.f6900d);
            }
        });
    }

    public void t1(int i8, int i9) {
        u1(i8, i9, null);
    }

    public void u() {
        List<OnScrollListener> list = this.f7202p0;
        if (list != null) {
            list.clear();
        }
    }

    public void u1(int i8, int i9, Interpolator interpolator) {
        v1(i8, i9, interpolator, Integer.MIN_VALUE);
    }

    void v(int i8, int i9) {
        boolean z7;
        EdgeEffect edgeEffect = this.O;
        if (edgeEffect != null && !edgeEffect.isFinished() && i8 > 0) {
            this.O.onRelease();
            z7 = this.O.isFinished();
        } else {
            z7 = false;
        }
        EdgeEffect edgeEffect2 = this.Q;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i8 < 0) {
            this.Q.onRelease();
            z7 |= this.Q.isFinished();
        }
        EdgeEffect edgeEffect3 = this.P;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i9 > 0) {
            this.P.onRelease();
            z7 |= this.P.isFinished();
        }
        EdgeEffect edgeEffect4 = this.R;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i9 < 0) {
            this.R.onRelease();
            z7 |= this.R.isFinished();
        }
        if (z7) {
            ViewCompat.j0(this);
        }
    }

    public void v1(int i8, int i9, Interpolator interpolator, int i10) {
        w1(i8, i9, interpolator, i10, false);
    }

    void w() {
        if (this.A && !this.J) {
            if (!this.f7187i.p()) {
                return;
            }
            if (this.f7187i.o(4) && !this.f7187i.o(11)) {
                TraceCompat.a("RV PartialInvalidate");
                y1();
                N0();
                this.f7187i.w();
                if (!this.C) {
                    if (s0()) {
                        D();
                    } else {
                        this.f7187i.i();
                    }
                }
                A1(true);
                O0();
                TraceCompat.b();
                return;
            } else if (this.f7187i.p()) {
                TraceCompat.a("RV FullInvalidate");
                D();
                TraceCompat.b();
                return;
            } else {
                return;
            }
        }
        TraceCompat.a("RV FullInvalidate");
        D();
        TraceCompat.b();
    }

    void w0(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new FastScroller(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(R$dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(R$dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(R$dimen.fastscroll_margin));
            return;
        }
        throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + R());
    }

    void w1(int i8, int i9, Interpolator interpolator, int i10, boolean z7) {
        boolean z8;
        LayoutManager layoutManager = this.f7205r;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (this.D) {
        } else {
            int i11 = 0;
            if (!layoutManager.v()) {
                i8 = 0;
            }
            if (!this.f7205r.w()) {
                i9 = 0;
            }
            if (i8 != 0 || i9 != 0) {
                if (i10 != Integer.MIN_VALUE && i10 <= 0) {
                    z8 = false;
                } else {
                    z8 = true;
                }
                if (z8) {
                    if (z7) {
                        if (i8 != 0) {
                            i11 = 1;
                        }
                        if (i9 != 0) {
                            i11 |= 2;
                        }
                        z1(i11, 1);
                    }
                    this.f7192k0.e(i8, i9, i10, interpolator);
                    return;
                }
                scrollBy(i8, i9);
            }
        }
    }

    void x0() {
        this.R = null;
        this.P = null;
        this.Q = null;
        this.O = null;
    }

    public void x1(int i8) {
        if (this.D) {
            return;
        }
        LayoutManager layoutManager = this.f7205r;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            layoutManager.T1(this, this.f7198n0, i8);
        }
    }

    void y(int i8, int i9) {
        setMeasuredDimension(LayoutManager.y(i8, getPaddingLeft() + getPaddingRight(), ViewCompat.G(this)), LayoutManager.y(i9, getPaddingTop() + getPaddingBottom(), ViewCompat.F(this)));
    }

    public void y0() {
        if (this.f7211u.size() == 0) {
            return;
        }
        LayoutManager layoutManager = this.f7205r;
        if (layoutManager != null) {
            layoutManager.r("Cannot invalidate item decorations during a scroll or layout");
        }
        D0();
        requestLayout();
    }

    void y1() {
        int i8 = this.B + 1;
        this.B = i8;
        if (i8 == 1 && !this.D) {
            this.C = false;
        }
    }

    boolean z0() {
        AccessibilityManager accessibilityManager = this.H;
        if (accessibilityManager != null && accessibilityManager.isEnabled()) {
            return true;
        }
        return false;
    }

    public boolean z1(int i8, int i9) {
        return getScrollingChildHelper().p(i8, i9);
    }

    public RecyclerView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.recyclerViewStyle);
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.recyclerview.widget.RecyclerView.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public SavedState[] newArray(int i8) {
                return new SavedState[i8];
            }
        };

        /* renamed from: h  reason: collision with root package name */
        Parcelable f7291h;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f7291h = parcel.readParcelable(classLoader == null ? LayoutManager.class.getClassLoader() : classLoader);
        }

        void b(SavedState savedState) {
            this.f7291h = savedState.f7291h;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i8) {
            super.writeToParcel(parcel, i8);
            parcel.writeParcelable(this.f7291h, 0);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public RecyclerView(@NonNull Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f7181f = new RecyclerViewDataObserver();
        this.f7183g = new Recycler();
        this.f7191k = new ViewInfoStore();
        this.f7195m = new Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.A && !recyclerView.isLayoutRequested()) {
                    RecyclerView recyclerView2 = RecyclerView.this;
                    if (!recyclerView2.f7217x) {
                        recyclerView2.requestLayout();
                    } else if (recyclerView2.D) {
                        recyclerView2.C = true;
                    } else {
                        recyclerView2.w();
                    }
                }
            }
        };
        this.f7197n = new Rect();
        this.f7199o = new Rect();
        this.f7201p = new RectF();
        this.f7209t = new ArrayList();
        this.f7211u = new ArrayList<>();
        this.f7213v = new ArrayList<>();
        this.B = 0;
        this.J = false;
        this.K = false;
        this.L = 0;
        this.M = 0;
        this.N = new EdgeEffectFactory();
        this.S = new DefaultItemAnimator();
        this.T = 0;
        this.U = -1;
        this.f7186h0 = Float.MIN_VALUE;
        this.f7188i0 = Float.MIN_VALUE;
        this.f7190j0 = true;
        this.f7192k0 = new ViewFlinger();
        this.f7196m0 = L0 ? new GapWorker.LayoutPrefetchRegistryImpl() : null;
        this.f7198n0 = new State();
        this.f7204q0 = false;
        this.f7206r0 = false;
        this.f7208s0 = new ItemAnimatorRestoreListener();
        this.f7210t0 = false;
        this.f7216w0 = new int[2];
        this.f7220y0 = new int[2];
        this.f7222z0 = new int[2];
        this.A0 = new int[2];
        this.B0 = new ArrayList();
        this.C0 = new Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.2
            @Override // java.lang.Runnable
            public void run() {
                ItemAnimator itemAnimator = RecyclerView.this.S;
                if (itemAnimator != null) {
                    itemAnimator.v();
                }
                RecyclerView.this.f7210t0 = false;
            }
        };
        this.E0 = 0;
        this.F0 = 0;
        this.G0 = new ViewInfoStore.ProcessCallback() { // from class: androidx.recyclerview.widget.RecyclerView.4
            @Override // androidx.recyclerview.widget.ViewInfoStore.ProcessCallback
            public void a(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                RecyclerView.this.m(viewHolder, itemHolderInfo, itemHolderInfo2);
            }

            @Override // androidx.recyclerview.widget.ViewInfoStore.ProcessCallback
            public void b(ViewHolder viewHolder) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.f7205r.w1(viewHolder.f7332a, recyclerView.f7183g);
            }

            @Override // androidx.recyclerview.widget.ViewInfoStore.ProcessCallback
            public void c(ViewHolder viewHolder, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                RecyclerView.this.f7183g.J(viewHolder);
                RecyclerView.this.o(viewHolder, itemHolderInfo, itemHolderInfo2);
            }

            @Override // androidx.recyclerview.widget.ViewInfoStore.ProcessCallback
            public void d(ViewHolder viewHolder, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                viewHolder.I(false);
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.J) {
                    if (recyclerView.S.b(viewHolder, viewHolder, itemHolderInfo, itemHolderInfo2)) {
                        RecyclerView.this.T0();
                    }
                } else if (recyclerView.S.d(viewHolder, itemHolderInfo, itemHolderInfo2)) {
                    RecyclerView.this.T0();
                }
            }
        };
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f7179d0 = viewConfiguration.getScaledTouchSlop();
        this.f7186h0 = ViewConfigurationCompat.b(viewConfiguration, context);
        this.f7188i0 = ViewConfigurationCompat.d(viewConfiguration, context);
        this.f7182f0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f7184g0 = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.S.w(this.f7208s0);
        t0();
        v0();
        u0();
        if (ViewCompat.C(this) == 0) {
            ViewCompat.D0(this, 1);
        }
        this.H = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        int[] iArr = R$styleable.f6876f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i8, 0);
        ViewCompat.q0(this, context, iArr, attributeSet, obtainStyledAttributes, i8, 0);
        String string = obtainStyledAttributes.getString(R$styleable.f6885o);
        if (obtainStyledAttributes.getInt(R$styleable.f6879i, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.f7193l = obtainStyledAttributes.getBoolean(R$styleable.f6878h, true);
        boolean z7 = obtainStyledAttributes.getBoolean(R$styleable.f6880j, false);
        this.f7221z = z7;
        if (z7) {
            w0((StateListDrawable) obtainStyledAttributes.getDrawable(R$styleable.f6883m), obtainStyledAttributes.getDrawable(R$styleable.f6884n), (StateListDrawable) obtainStyledAttributes.getDrawable(R$styleable.f6881k), obtainStyledAttributes.getDrawable(R$styleable.f6882l));
        }
        obtainStyledAttributes.recycle();
        x(context, string, attributeSet, i8, 0);
        int[] iArr2 = H0;
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i8, 0);
        ViewCompat.q0(this, context, iArr2, attributeSet, obtainStyledAttributes2, i8, 0);
        boolean z8 = obtainStyledAttributes2.getBoolean(0, true);
        obtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z8);
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: f  reason: collision with root package name */
        ViewHolder f7271f;

        /* renamed from: g  reason: collision with root package name */
        final Rect f7272g;

        /* renamed from: h  reason: collision with root package name */
        boolean f7273h;

        /* renamed from: i  reason: collision with root package name */
        boolean f7274i;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f7272g = new Rect();
            this.f7273h = true;
            this.f7274i = false;
        }

        public int a() {
            return this.f7271f.o();
        }

        public boolean b() {
            return this.f7271f.A();
        }

        public boolean c() {
            return this.f7271f.x();
        }

        public boolean d() {
            return this.f7271f.v();
        }

        public LayoutParams(int i8, int i9) {
            super(i8, i9);
            this.f7272g = new Rect();
            this.f7273h = true;
            this.f7274i = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f7272g = new Rect();
            this.f7273h = true;
            this.f7274i = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f7272g = new Rect();
            this.f7273h = true;
            this.f7274i = false;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.f7272g = new Rect();
            this.f7273h = true;
            this.f7274i = false;
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutManager layoutManager = this.f7205r;
        if (layoutManager != null) {
            return layoutManager.Q(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + R());
    }
}
