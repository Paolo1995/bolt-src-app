package ee.mtakso.driver.utils.bottomsheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import ee.mtakso.driver.R$styleable;
import ee.mtakso.driver.uicore.utils.Dimens;
import eu.bolt.kalev.Kalev;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class ComponentBottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final HideMode E = HideMode.HIDEABLE_ONLY_VIA_API;
    protected boolean A;
    private ComponentBottomSheetBehavior<V>.SettleRunnable B;
    private int C;
    private final ViewDragHelper.Callback D;

    /* renamed from: a  reason: collision with root package name */
    private boolean f36347a;

    /* renamed from: b  reason: collision with root package name */
    private float f36348b;

    /* renamed from: c  reason: collision with root package name */
    private int f36349c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f36350d;

    /* renamed from: e  reason: collision with root package name */
    private int f36351e;

    /* renamed from: f  reason: collision with root package name */
    private int f36352f;

    /* renamed from: g  reason: collision with root package name */
    int f36353g;

    /* renamed from: h  reason: collision with root package name */
    int f36354h;

    /* renamed from: i  reason: collision with root package name */
    int f36355i;

    /* renamed from: j  reason: collision with root package name */
    HideMode f36356j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f36357k;

    /* renamed from: l  reason: collision with root package name */
    int f36358l;

    /* renamed from: m  reason: collision with root package name */
    ViewDragHelper f36359m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f36360n;

    /* renamed from: o  reason: collision with root package name */
    private int f36361o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f36362p;

    /* renamed from: q  reason: collision with root package name */
    int f36363q;

    /* renamed from: r  reason: collision with root package name */
    WeakReference<V> f36364r;

    /* renamed from: s  reason: collision with root package name */
    WeakReference<View> f36365s;

    /* renamed from: t  reason: collision with root package name */
    private BottomSheetCallback f36366t;

    /* renamed from: u  reason: collision with root package name */
    private VelocityTracker f36367u;

    /* renamed from: v  reason: collision with root package name */
    int f36368v;

    /* renamed from: w  reason: collision with root package name */
    private int f36369w;

    /* renamed from: x  reason: collision with root package name */
    boolean f36370x;

    /* renamed from: y  reason: collision with root package name */
    private Map<View, Integer> f36371y;

    /* renamed from: z  reason: collision with root package name */
    protected boolean f36372z;

    /* loaded from: classes5.dex */
    public static abstract class BottomSheetCallback {
        public abstract void a(@NonNull View view, float f8);

        public abstract void b(@NonNull View view, int i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class SettleRunnable implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        private final View f36378f;

        /* renamed from: g  reason: collision with root package name */
        private final int f36379g;

        SettleRunnable(View view, int i8) {
            this.f36378f = view;
            this.f36379g = i8;
            if (ComponentBottomSheetBehavior.this.B != null) {
                view.removeCallbacks(ComponentBottomSheetBehavior.this.B);
                Kalev.l("Two settling animation was started. The first one is cancelled now.");
            }
            ComponentBottomSheetBehavior.this.B = this;
        }

        public int a() {
            return this.f36379g;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper viewDragHelper = ComponentBottomSheetBehavior.this.f36359m;
            if (viewDragHelper != null && viewDragHelper.m(true)) {
                ViewCompat.k0(this.f36378f, this);
                return;
            }
            ComponentBottomSheetBehavior.this.B = null;
            ComponentBottomSheetBehavior.this.Y(this.f36379g);
        }
    }

    public ComponentBottomSheetBehavior() {
        this.f36347a = true;
        this.f36356j = E;
        this.f36358l = 4;
        this.f36372z = true;
        this.A = true;
        this.B = null;
        this.C = 0;
        this.D = new ViewDragHelper.Callback() { // from class: ee.mtakso.driver.utils.bottomsheet.ComponentBottomSheetBehavior.2
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int a(@NonNull View view, int i8, int i9) {
                return view.getLeft();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int b(@NonNull View view, int i8, int i9) {
                int i10;
                boolean f8 = ComponentBottomSheetBehavior.this.f36356j.f();
                int O = ComponentBottomSheetBehavior.this.O();
                if (f8) {
                    i10 = ComponentBottomSheetBehavior.this.f36363q;
                } else {
                    i10 = ComponentBottomSheetBehavior.this.f36355i;
                }
                return MathUtils.b(i8, O, i10);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int e(@NonNull View view) {
                if (ComponentBottomSheetBehavior.this.f36356j.f()) {
                    return ComponentBottomSheetBehavior.this.f36363q;
                }
                return ComponentBottomSheetBehavior.this.f36355i;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void j(int i8) {
                if (i8 == 1) {
                    ComponentBottomSheetBehavior.this.Y(1);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void k(@NonNull View view, int i8, int i9, int i10, int i11) {
                ComponentBottomSheetBehavior.this.M(i9);
            }

            /* JADX WARN: Removed duplicated region for block: B:45:0x00d3  */
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void l(@androidx.annotation.NonNull android.view.View r8, float r9, float r10) {
                /*
                    Method dump skipped, instructions count: 244
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.utils.bottomsheet.ComponentBottomSheetBehavior.AnonymousClass2.l(android.view.View, float, float):void");
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean m(@NonNull View view, int i8) {
                int i9;
                View view2;
                ComponentBottomSheetBehavior componentBottomSheetBehavior = ComponentBottomSheetBehavior.this;
                if (!componentBottomSheetBehavior.f36372z || (i9 = componentBottomSheetBehavior.f36358l) == 1 || componentBottomSheetBehavior.f36370x) {
                    return false;
                }
                if (i9 == 3 && componentBottomSheetBehavior.f36368v == i8) {
                    WeakReference<View> weakReference = componentBottomSheetBehavior.f36365s;
                    if (weakReference != null) {
                        view2 = weakReference.get();
                    } else {
                        view2 = null;
                    }
                    if (view2 != null && view2.canScrollVertically(-1)) {
                        return false;
                    }
                }
                WeakReference<V> weakReference2 = ComponentBottomSheetBehavior.this.f36364r;
                if (weakReference2 == null || weakReference2.get() != view) {
                    return false;
                }
                return true;
            }
        };
    }

    private void J() {
        if (this.f36347a) {
            this.f36355i = Math.max(this.f36363q - this.f36352f, this.f36353g);
        } else {
            this.f36355i = this.f36363q - this.f36352f;
        }
    }

    private float K(int i8) {
        int O = O();
        int i9 = this.f36355i;
        if (O >= i9) {
            return -1.0f;
        }
        return (i9 - i8) / (i9 - O);
    }

    private float L(int i8) {
        int i9 = this.f36363q;
        int i10 = this.f36355i;
        if (i9 == i10) {
            return -1.0f;
        }
        return (i10 - i8) / (i9 - i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int O() {
        if (this.f36347a) {
            return this.f36353g;
        }
        return 0;
    }

    private int Q(int i8, boolean z7) {
        if (i8 == 4) {
            return this.f36355i;
        }
        if (i8 == 6) {
            if (this.f36347a) {
                int i9 = this.f36354h;
                int i10 = this.f36353g;
                if (i9 <= i10) {
                    return i10;
                }
            }
            return this.f36354h;
        } else if (i8 == 3) {
            return O();
        } else {
            if ((this.f36356j.e() || z7) && i8 == 5) {
                return this.f36363q;
            }
            throw new IllegalArgumentException("Illegal state argument: " + i8);
        }
    }

    private float R() {
        VelocityTracker velocityTracker = this.f36367u;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f36348b);
        return this.f36367u.getYVelocity(this.f36368v);
    }

    private void S() {
        this.f36368v = -1;
        VelocityTracker velocityTracker = this.f36367u;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f36367u = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0(View view, int i8, boolean z7) {
        int Q = Q(i8, z7);
        if (i8 == 6 && this.f36347a && this.f36354h <= this.f36353g) {
            i8 = 3;
        }
        ComponentBottomSheetBehavior<V>.SettleRunnable settleRunnable = this.B;
        if (settleRunnable != null) {
            view.removeCallbacks(settleRunnable);
            this.B = null;
        }
        ViewDragHelper viewDragHelper = this.f36359m;
        if (viewDragHelper != null && viewDragHelper.O(view, view.getLeft(), Q)) {
            Y(2);
            ViewCompat.k0(view, new SettleRunnable(view, i8));
            return;
        }
        Y(i8);
    }

    private void b0(boolean z7) {
        WeakReference<V> weakReference = this.f36364r;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (!(parent instanceof CoordinatorLayout)) {
            return;
        }
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
        int childCount = coordinatorLayout.getChildCount();
        if (z7) {
            if (this.f36371y == null) {
                this.f36371y = new HashMap(childCount);
            } else {
                return;
            }
        }
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = coordinatorLayout.getChildAt(i8);
            if (childAt != this.f36364r.get()) {
                if (!z7) {
                    Map<View, Integer> map = this.f36371y;
                    if (map != null && map.containsKey(childAt)) {
                        ViewCompat.D0(childAt, this.f36371y.get(childAt).intValue());
                    }
                } else {
                    this.f36371y.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    ViewCompat.D0(childAt, 4);
                }
            }
        }
        if (!z7) {
            this.f36371y = null;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean A(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull View view, @NonNull View view2, int i8, int i9) {
        if (!this.A) {
            return false;
        }
        this.f36361o = 0;
        this.f36362p = false;
        if ((i8 & 2) == 0) {
            return false;
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void C(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull View view, int i8) {
        int i9;
        if (!this.A) {
            return;
        }
        int i10 = 3;
        if (v7.getTop() == O()) {
            Y(3);
        } else if (view == this.f36365s.get() && this.f36362p) {
            boolean f8 = this.f36356j.f();
            if (this.f36361o > 0) {
                i9 = O();
            } else if (f8 && Z(v7, R())) {
                i9 = this.f36363q;
                i10 = 5;
            } else {
                if (this.f36361o == 0) {
                    int top = v7.getTop();
                    if (this.f36347a) {
                        if (Math.abs(top - this.f36353g) < Math.abs(top - this.f36355i)) {
                            i9 = this.f36353g;
                        } else {
                            i9 = this.f36355i;
                        }
                    } else {
                        int i11 = this.f36354h;
                        if (top < i11) {
                            if (top < Math.abs(top - this.f36355i)) {
                                i9 = 0;
                            } else {
                                i9 = this.f36354h;
                            }
                        } else if (Math.abs(top - i11) < Math.abs(top - this.f36355i)) {
                            i9 = this.f36354h;
                        } else {
                            i9 = this.f36355i;
                        }
                        i10 = 6;
                    }
                } else {
                    i9 = this.f36355i;
                }
                i10 = 4;
            }
            ViewDragHelper viewDragHelper = this.f36359m;
            if (viewDragHelper != null && viewDragHelper.O(v7, v7.getLeft(), i9)) {
                Y(2);
                ViewCompat.k0(v7, new SettleRunnable(v7, i10));
            } else {
                Y(i10);
            }
            this.f36362p = false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean D(CoordinatorLayout coordinatorLayout, V v7, MotionEvent motionEvent) {
        if (!v7.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f36358l == 1 && actionMasked == 0) {
            return true;
        }
        ViewDragHelper viewDragHelper = this.f36359m;
        if (viewDragHelper != null) {
            viewDragHelper.F(motionEvent);
        }
        if (actionMasked == 0) {
            S();
        }
        if (this.f36367u == null) {
            this.f36367u = VelocityTracker.obtain();
        }
        this.f36367u.addMovement(motionEvent);
        if (actionMasked == 2 && !this.f36360n && this.f36359m != null && this.f36372z && Math.abs(this.f36369w - motionEvent.getY()) > this.f36359m.z()) {
            this.f36359m.b(v7, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f36360n;
    }

    void M(int i8) {
        V v7;
        BottomSheetCallback bottomSheetCallback;
        WeakReference<V> weakReference = this.f36364r;
        if (weakReference != null) {
            v7 = weakReference.get();
        } else {
            v7 = null;
        }
        if (v7 != null && (bottomSheetCallback = this.f36366t) != null) {
            if (i8 == this.f36363q) {
                bottomSheetCallback.a(v7, -1.0f);
            } else if (i8 > this.f36355i) {
                bottomSheetCallback.a(v7, L(i8));
            } else {
                bottomSheetCallback.a(v7, K(i8));
            }
        }
    }

    View N(View view) {
        if (ViewCompat.X(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                View N = N(viewGroup.getChildAt(i8));
                if (N != null) {
                    return N;
                }
            }
            return null;
        }
        return null;
    }

    public final int P() {
        if (this.f36350d) {
            return -1;
        }
        return this.f36349c;
    }

    public void T(BottomSheetCallback bottomSheetCallback) {
        this.f36366t = bottomSheetCallback;
    }

    public void U(boolean z7) {
        int i8;
        if (this.f36347a == z7) {
            return;
        }
        this.f36347a = z7;
        if (this.f36364r != null) {
            J();
        }
        if (this.f36347a && this.f36358l == 6) {
            i8 = 3;
        } else {
            i8 = this.f36358l;
        }
        Y(i8);
    }

    public final void V(int i8) {
        WeakReference<V> weakReference;
        V v7;
        boolean z7 = true;
        if (i8 == -1) {
            if (!this.f36350d) {
                this.f36350d = true;
            }
            z7 = false;
        } else {
            if (this.f36350d || this.f36349c != i8) {
                this.f36350d = false;
                this.f36349c = Math.max(0, i8);
                this.f36355i = this.f36363q - i8;
            }
            z7 = false;
        }
        if (z7 && this.f36358l == 4 && (weakReference = this.f36364r) != null && (v7 = weakReference.get()) != null) {
            v7.requestLayout();
        }
    }

    public void W(boolean z7) {
        this.f36357k = z7;
    }

    public final void X(final int i8) {
        if (i8 == this.f36358l) {
            return;
        }
        if (i8 == 5 && !this.f36356j.e()) {
            throw new IllegalArgumentException("Illegal state argument: " + i8 + ". Dont set HIDDEN while hideable == " + this.f36356j);
        }
        WeakReference<V> weakReference = this.f36364r;
        if (weakReference == null) {
            if (i8 == 4 || i8 == 3 || i8 == 6 || i8 == 5) {
                this.f36358l = i8;
                return;
            }
            return;
        }
        final V v7 = weakReference.get();
        if (v7 == null) {
            return;
        }
        final ViewParent parent = v7.getParent();
        if (parent != null && parent.isLayoutRequested() && ViewCompat.V(v7)) {
            v7.post(new Runnable() { // from class: ee.mtakso.driver.utils.bottomsheet.ComponentBottomSheetBehavior.1
                @Override // java.lang.Runnable
                public void run() {
                    if (parent.isLayoutRequested() && ViewCompat.V(v7)) {
                        v7.post(this);
                    } else if (i8 == 5 && !ComponentBottomSheetBehavior.this.f36356j.e()) {
                    } else {
                        ComponentBottomSheetBehavior.this.a0(v7, i8, false);
                    }
                }
            });
        } else {
            a0(v7, i8, false);
        }
    }

    void Y(int i8) {
        V v7;
        BottomSheetCallback bottomSheetCallback;
        if (this.f36358l == i8) {
            return;
        }
        this.f36358l = i8;
        if (i8 != 6 && i8 != 3) {
            if (i8 == 5 || i8 == 4) {
                b0(false);
            }
        } else {
            b0(true);
        }
        WeakReference<V> weakReference = this.f36364r;
        if (weakReference != null) {
            v7 = weakReference.get();
        } else {
            v7 = null;
        }
        if (v7 != null && (bottomSheetCallback = this.f36366t) != null) {
            bottomSheetCallback.b(v7, i8);
        }
    }

    boolean Z(View view, float f8) {
        if (this.f36357k) {
            return true;
        }
        if (view.getTop() >= this.f36355i && Math.abs((view.getTop() + (f8 * 0.1f)) - this.f36355i) / this.f36349c > 0.5f) {
            return true;
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean k(CoordinatorLayout coordinatorLayout, V v7, MotionEvent motionEvent) {
        View view;
        boolean z7;
        ViewDragHelper viewDragHelper;
        if (!v7.isShown()) {
            this.f36360n = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            S();
        }
        if (this.f36367u == null) {
            this.f36367u = VelocityTracker.obtain();
        }
        this.f36367u.addMovement(motionEvent);
        View view2 = null;
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                this.f36370x = false;
                this.f36368v = -1;
                if (this.f36360n) {
                    this.f36360n = false;
                    return false;
                }
            }
        } else {
            int x7 = (int) motionEvent.getX();
            this.f36369w = (int) motionEvent.getY();
            WeakReference<View> weakReference = this.f36365s;
            if (weakReference != null) {
                view = weakReference.get();
            } else {
                view = null;
            }
            if (view != null && coordinatorLayout.C(view, x7, this.f36369w)) {
                this.f36368v = motionEvent.getPointerId(motionEvent.getActionIndex());
                this.f36370x = true;
            }
            if (this.f36368v == -1 && !coordinatorLayout.C(v7, x7, this.f36369w)) {
                z7 = true;
            } else {
                z7 = false;
            }
            this.f36360n = z7;
        }
        if (!this.f36360n && (viewDragHelper = this.f36359m) != null && viewDragHelper.N(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.f36365s;
        if (weakReference2 != null) {
            view2 = weakReference2.get();
        }
        if (actionMasked != 2 || view2 == null || this.f36360n || this.f36358l == 1 || coordinatorLayout.C(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.f36359m == null || Math.abs(this.f36369w - motionEvent.getY()) <= this.f36359m.z()) {
            return false;
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean l(CoordinatorLayout coordinatorLayout, V v7, int i8) {
        ComponentBottomSheetBehavior<V>.SettleRunnable settleRunnable;
        if (ViewCompat.B(coordinatorLayout) && !ViewCompat.B(v7)) {
            v7.setFitsSystemWindows(true);
        }
        int top = v7.getTop();
        coordinatorLayout.J(v7, i8);
        this.f36363q = coordinatorLayout.getHeight();
        if (this.f36350d) {
            if (this.f36351e == 0) {
                this.f36351e = Dimens.d(64);
            }
            this.f36352f = Math.max(this.f36351e, this.f36363q - ((coordinatorLayout.getWidth() * 9) / 16));
        } else {
            this.f36352f = this.f36349c;
        }
        this.f36353g = Math.max(this.C, this.f36363q - v7.getHeight());
        this.f36354h = this.f36363q / 2;
        J();
        int i9 = this.f36358l;
        if (i9 == 3) {
            ViewCompat.d0(v7, O());
        } else if (i9 == 6) {
            ViewCompat.d0(v7, this.f36354h);
        } else if (i9 == 5) {
            ViewCompat.d0(v7, this.f36363q);
        } else if (i9 == 4) {
            ViewCompat.d0(v7, this.f36355i);
        } else if (i9 == 1 || i9 == 2) {
            ViewCompat.d0(v7, top - v7.getTop());
        }
        if (this.f36359m == null) {
            this.f36359m = ViewDragHelper.o(coordinatorLayout, this.D);
        }
        this.f36364r = new WeakReference<>(v7);
        this.f36365s = new WeakReference<>(N(v7));
        if (this.f36358l == 2 && (settleRunnable = this.B) != null) {
            a0(v7, settleRunnable.a(), true);
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean m(CoordinatorLayout coordinatorLayout, V v7, int i8, int i9, int i10, int i11) {
        coordinatorLayout.K(v7, i8, i9, i10, this.C);
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean o(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull View view, float f8, float f9) {
        View view2;
        WeakReference<View> weakReference = this.f36365s;
        if (weakReference != null) {
            view2 = weakReference.get();
        } else {
            view2 = null;
        }
        if (view == view2 && (this.f36358l != 3 || super.o(coordinatorLayout, v7, view, f8, f9))) {
            return true;
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void q(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull View view, int i8, int i9, @NonNull int[] iArr, int i10) {
        View view2;
        if (!this.A || i10 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.f36365s;
        if (weakReference != null) {
            view2 = weakReference.get();
        } else {
            view2 = null;
        }
        if (view != view2) {
            return;
        }
        int top = v7.getTop();
        int i11 = top - i9;
        boolean f8 = this.f36356j.f();
        if (i9 > 0) {
            if (i11 < O()) {
                int O = top - O();
                iArr[1] = O;
                ViewCompat.d0(v7, -O);
                Y(3);
            } else {
                iArr[1] = i9;
                ViewCompat.d0(v7, -i9);
                Y(1);
            }
        } else if (i9 < 0 && !view.canScrollVertically(-1)) {
            int i12 = this.f36355i;
            if (i11 > i12 && !f8) {
                int i13 = top - i12;
                iArr[1] = i13;
                ViewCompat.d0(v7, -i13);
                Y(4);
            } else {
                iArr[1] = i9;
                ViewCompat.d0(v7, -i9);
                Y(1);
            }
        }
        M(v7.getTop());
        this.f36361o = i9;
        this.f36362p = true;
    }

    public ComponentBottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i8;
        this.f36347a = true;
        HideMode hideMode = E;
        this.f36356j = hideMode;
        this.f36358l = 4;
        this.f36372z = true;
        this.A = true;
        this.B = null;
        this.C = 0;
        this.D = new ViewDragHelper.Callback() { // from class: ee.mtakso.driver.utils.bottomsheet.ComponentBottomSheetBehavior.2
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int a(@NonNull View view, int i82, int i9) {
                return view.getLeft();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int b(@NonNull View view, int i82, int i9) {
                int i10;
                boolean f8 = ComponentBottomSheetBehavior.this.f36356j.f();
                int O = ComponentBottomSheetBehavior.this.O();
                if (f8) {
                    i10 = ComponentBottomSheetBehavior.this.f36363q;
                } else {
                    i10 = ComponentBottomSheetBehavior.this.f36355i;
                }
                return MathUtils.b(i82, O, i10);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int e(@NonNull View view) {
                if (ComponentBottomSheetBehavior.this.f36356j.f()) {
                    return ComponentBottomSheetBehavior.this.f36363q;
                }
                return ComponentBottomSheetBehavior.this.f36355i;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void j(int i82) {
                if (i82 == 1) {
                    ComponentBottomSheetBehavior.this.Y(1);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void k(@NonNull View view, int i82, int i9, int i10, int i11) {
                ComponentBottomSheetBehavior.this.M(i9);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void l(@androidx.annotation.NonNull android.view.View r8, float r9, float r10) {
                /*
                    Method dump skipped, instructions count: 244
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.utils.bottomsheet.ComponentBottomSheetBehavior.AnonymousClass2.l(android.view.View, float, float):void");
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean m(@NonNull View view, int i82) {
                int i9;
                View view2;
                ComponentBottomSheetBehavior componentBottomSheetBehavior = ComponentBottomSheetBehavior.this;
                if (!componentBottomSheetBehavior.f36372z || (i9 = componentBottomSheetBehavior.f36358l) == 1 || componentBottomSheetBehavior.f36370x) {
                    return false;
                }
                if (i9 == 3 && componentBottomSheetBehavior.f36368v == i82) {
                    WeakReference<View> weakReference = componentBottomSheetBehavior.f36365s;
                    if (weakReference != null) {
                        view2 = weakReference.get();
                    } else {
                        view2 = null;
                    }
                    if (view2 != null && view2.canScrollVertically(-1)) {
                        return false;
                    }
                }
                WeakReference<V> weakReference2 = ComponentBottomSheetBehavior.this.f36364r;
                if (weakReference2 == null || weakReference2.get() != view) {
                    return false;
                }
                return true;
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f19846b1);
        TypedValue peekValue = obtainStyledAttributes.peekValue(2);
        if (peekValue != null && (i8 = peekValue.data) == -1) {
            V(i8);
        } else {
            V(obtainStyledAttributes.getDimensionPixelSize(2, -1));
        }
        this.f36356j = HideMode.c(obtainStyledAttributes.getInt(2, hideMode.a()));
        U(obtainStyledAttributes.getBoolean(0, true));
        W(obtainStyledAttributes.getBoolean(1, false));
        obtainStyledAttributes.recycle();
        this.f36348b = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
