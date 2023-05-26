package ee.mtakso.driver.uikit.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import androidx.viewpager.widget.ViewPager;
import ee.mtakso.driver.uikit.R$dimen;
import ee.mtakso.driver.uikit.R$styleable;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewPagerBottomSheetBehavior.kt */
/* loaded from: classes5.dex */
public final class ViewPagerBottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: x  reason: collision with root package name */
    public static final Companion f36174x = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private float f36175a;

    /* renamed from: b  reason: collision with root package name */
    private float f36176b;

    /* renamed from: c  reason: collision with root package name */
    private int f36177c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f36178d;

    /* renamed from: e  reason: collision with root package name */
    private int f36179e;

    /* renamed from: f  reason: collision with root package name */
    private int f36180f;

    /* renamed from: g  reason: collision with root package name */
    private int f36181g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f36182h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f36183i;

    /* renamed from: j  reason: collision with root package name */
    private int f36184j;

    /* renamed from: k  reason: collision with root package name */
    private ViewDragHelper f36185k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f36186l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f36187m;

    /* renamed from: n  reason: collision with root package name */
    private int f36188n;

    /* renamed from: o  reason: collision with root package name */
    private WeakReference<V> f36189o;

    /* renamed from: p  reason: collision with root package name */
    private WeakReference<View> f36190p;

    /* renamed from: q  reason: collision with root package name */
    private BottomSheetCallback f36191q;

    /* renamed from: r  reason: collision with root package name */
    private VelocityTracker f36192r;

    /* renamed from: s  reason: collision with root package name */
    private int f36193s;

    /* renamed from: t  reason: collision with root package name */
    private int f36194t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f36195u;

    /* renamed from: v  reason: collision with root package name */
    private Function1<? super ViewPager, ? extends View> f36196v;

    /* renamed from: w  reason: collision with root package name */
    private final ViewDragHelper.Callback f36197w;

    /* compiled from: ViewPagerBottomSheetBehavior.kt */
    /* loaded from: classes5.dex */
    public interface BottomSheetCallback {
        void a(View view, int i8);

        void b(View view, float f8);
    }

    /* compiled from: ViewPagerBottomSheetBehavior.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <V extends View> ViewPagerBottomSheetBehavior<V> a(V view) {
            Intrinsics.f(view, "view");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                CoordinatorLayout.Behavior f8 = ((CoordinatorLayout.LayoutParams) layoutParams).f();
                if (f8 instanceof ViewPagerBottomSheetBehavior) {
                    Intrinsics.d(f8, "null cannot be cast to non-null type ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior<V of ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior.Companion.from>");
                    return (ViewPagerBottomSheetBehavior) f8;
                }
                throw new IllegalArgumentException("The view is not associated with ViewPagerBottomSheetBehavior".toString());
            }
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout".toString());
        }
    }

    /* compiled from: ViewPagerBottomSheetBehavior.kt */
    /* loaded from: classes5.dex */
    private static final class SavedState extends AbsSavedState {

        /* renamed from: f  reason: collision with root package name */
        private final int f36198f;

        public SavedState(Parcelable parcelable, int i8) {
            super(parcelable);
            this.f36198f = i8;
        }

        public final int a() {
            return this.f36198f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViewPagerBottomSheetBehavior.kt */
    /* loaded from: classes5.dex */
    public final class SettleRunnable implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        private final View f36199f;

        /* renamed from: g  reason: collision with root package name */
        private final int f36200g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ ViewPagerBottomSheetBehavior<V> f36201h;

        public SettleRunnable(ViewPagerBottomSheetBehavior viewPagerBottomSheetBehavior, View mView, int i8) {
            Intrinsics.f(mView, "mView");
            this.f36201h = viewPagerBottomSheetBehavior;
            this.f36199f = mView;
            this.f36200g = i8;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper viewDragHelper = ((ViewPagerBottomSheetBehavior) this.f36201h).f36185k;
            boolean z7 = false;
            if (viewDragHelper != null && viewDragHelper.m(true)) {
                z7 = true;
            }
            if (z7) {
                ViewCompat.k0(this.f36199f, this);
            } else {
                this.f36201h.a0(this.f36200g);
            }
        }
    }

    public ViewPagerBottomSheetBehavior() {
        this.f36184j = 4;
        this.f36196v = ViewPagerBottomSheetBehavior$currentViewResolver$1.f36202f;
        this.f36197w = new ViewDragHelper.Callback(this) { // from class: ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior$mDragCallback$1

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ViewPagerBottomSheetBehavior<V> f36203a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f36203a = this;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int a(View child, int i8, int i9) {
                Intrinsics.f(child, "child");
                return child.getLeft();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int b(View child, int i8, int i9) {
                int L;
                Intrinsics.f(child, "child");
                int M = this.f36203a.M();
                if (this.f36203a.V()) {
                    L = this.f36203a.O();
                } else {
                    L = this.f36203a.L();
                }
                return MathUtils.b(i8, M, L);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int e(View child) {
                int L;
                int M;
                Intrinsics.f(child, "child");
                if (this.f36203a.V()) {
                    L = this.f36203a.O();
                    M = this.f36203a.M();
                } else {
                    L = this.f36203a.L();
                    M = this.f36203a.M();
                }
                return L - M;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void j(int i8) {
                if (i8 == 1) {
                    this.f36203a.a0(1);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void k(View changedView, int i8, int i9, int i10, int i11) {
                Intrinsics.f(changedView, "changedView");
                this.f36203a.I(i9);
            }

            /* JADX WARN: Removed duplicated region for block: B:28:0x009d  */
            /* JADX WARN: Removed duplicated region for block: B:29:0x00a6  */
            /* JADX WARN: Removed duplicated region for block: B:31:0x00a9  */
            /* JADX WARN: Removed duplicated region for block: B:32:0x00ba  */
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void l(android.view.View r6, float r7, float r8) {
                /*
                    r5 = this;
                    java.lang.String r0 = "releasedChild"
                    kotlin.jvm.internal.Intrinsics.f(r6, r0)
                    r0 = 4
                    r1 = 3
                    r2 = 0
                    int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                    if (r3 >= 0) goto L2e
                    float r3 = java.lang.Math.abs(r8)
                    ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior<V> r4 = r5.f36203a
                    float r4 = ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior.G(r4)
                    int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
                    if (r3 <= 0) goto L2e
                    float r3 = java.lang.Math.abs(r8)
                    float r4 = java.lang.Math.abs(r7)
                    int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
                    if (r3 <= 0) goto L2e
                    ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior<V> r7 = r5.f36203a
                    int r7 = r7.M()
                L2c:
                    r0 = 3
                    goto L95
                L2e:
                    ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior<V> r3 = r5.f36203a
                    boolean r3 = r3.V()
                    if (r3 == 0) goto L46
                    ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior<V> r3 = r5.f36203a
                    boolean r3 = r3.b0(r6, r8)
                    if (r3 == 0) goto L46
                    ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior<V> r7 = r5.f36203a
                    int r7 = r7.O()
                    r0 = 5
                    goto L95
                L46:
                    int r2 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                    if (r2 <= 0) goto L6b
                    float r2 = java.lang.Math.abs(r8)
                    ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior<V> r3 = r5.f36203a
                    float r3 = ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior.G(r3)
                    int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
                    if (r2 <= 0) goto L6b
                    float r8 = java.lang.Math.abs(r8)
                    float r7 = java.lang.Math.abs(r7)
                    int r7 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
                    if (r7 <= 0) goto L6b
                    ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior<V> r7 = r5.f36203a
                    int r7 = r7.L()
                    goto L95
                L6b:
                    int r7 = r6.getTop()
                    ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior<V> r8 = r5.f36203a
                    int r8 = r8.M()
                    int r8 = r7 - r8
                    int r8 = java.lang.Math.abs(r8)
                    ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior<V> r2 = r5.f36203a
                    int r2 = r2.L()
                    int r7 = r7 - r2
                    int r7 = java.lang.Math.abs(r7)
                    if (r8 >= r7) goto L8f
                    ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior<V> r7 = r5.f36203a
                    int r7 = r7.M()
                    goto L2c
                L8f:
                    ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior<V> r7 = r5.f36203a
                    int r7 = r7.L()
                L95:
                    ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior<V> r8 = r5.f36203a
                    androidx.customview.widget.ViewDragHelper r8 = ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior.H(r8)
                    if (r8 == 0) goto La6
                    int r1 = r6.getLeft()
                    boolean r7 = r8.M(r1, r7)
                    goto La7
                La6:
                    r7 = 0
                La7:
                    if (r7 == 0) goto Lba
                    ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior<V> r7 = r5.f36203a
                    r8 = 2
                    r7.a0(r8)
                    ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior$SettleRunnable r7 = new ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior$SettleRunnable
                    ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior<V> r8 = r5.f36203a
                    r7.<init>(r8, r6, r0)
                    androidx.core.view.ViewCompat.k0(r6, r7)
                    goto Lbf
                Lba:
                    ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior<V> r6 = r5.f36203a
                    r6.a0(r0)
                Lbf:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior$mDragCallback$1.l(android.view.View, float, float):void");
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean m(View child, int i8) {
                View view;
                Intrinsics.f(child, "child");
                if (this.f36203a.P() == 1 || this.f36203a.Q()) {
                    return false;
                }
                View view2 = null;
                if (this.f36203a.P() == 3 && this.f36203a.K() == i8) {
                    WeakReference<View> N = this.f36203a.N();
                    if (N != null) {
                        view = N.get();
                    } else {
                        view = null;
                    }
                    if (view != null && view.canScrollVertically(-1)) {
                        return false;
                    }
                }
                if (this.f36203a.R() != null) {
                    WeakReference R = this.f36203a.R();
                    if (R != null) {
                        view2 = (View) R.get();
                    }
                    if (view2 == child) {
                        return true;
                    }
                }
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(ViewPagerBottomSheetBehavior this$0, View child, int i8) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(child, "$child");
        this$0.c0(child, i8);
    }

    private final int U() {
        ViewDragHelper viewDragHelper = this.f36185k;
        if (viewDragHelper != null) {
            return viewDragHelper.z();
        }
        return 0;
    }

    private final void W() {
        this.f36193s = -1;
        VelocityTracker velocityTracker = this.f36192r;
        if (velocityTracker != null) {
            if (velocityTracker != null) {
                velocityTracker.recycle();
            }
            this.f36192r = null;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void B(CoordinatorLayout coordinatorLayout, V child, View target) {
        View view;
        float f8;
        float f9;
        int i8;
        boolean z7;
        Intrinsics.f(coordinatorLayout, "coordinatorLayout");
        Intrinsics.f(child, "child");
        Intrinsics.f(target, "target");
        int i9 = 3;
        if (child.getTop() == this.f36180f) {
            a0(3);
            return;
        }
        WeakReference<View> weakReference = this.f36190p;
        if (weakReference != null) {
            if (weakReference != null) {
                view = weakReference.get();
            } else {
                view = null;
            }
            if (target == view && this.f36187m) {
                VelocityTracker velocityTracker = this.f36192r;
                if (velocityTracker != null) {
                    velocityTracker.computeCurrentVelocity(1000, this.f36176b);
                }
                VelocityTracker velocityTracker2 = this.f36192r;
                if (velocityTracker2 != null) {
                    f8 = velocityTracker2.getXVelocity(this.f36193s);
                } else {
                    f8 = 0.0f;
                }
                VelocityTracker velocityTracker3 = this.f36192r;
                if (velocityTracker3 != null) {
                    f9 = velocityTracker3.getYVelocity(this.f36193s);
                } else {
                    f9 = 0.0f;
                }
                if (f9 < 0.0f && Math.abs(f9) > this.f36175a && Math.abs(f9) > Math.abs(f8)) {
                    i8 = this.f36180f;
                } else if (this.f36182h && b0(child, f9)) {
                    i8 = this.f36188n;
                    i9 = 5;
                } else {
                    if (f9 > 0.0f && Math.abs(f9) > this.f36175a && Math.abs(f9) > Math.abs(f8)) {
                        i8 = this.f36181g;
                    } else {
                        int top = child.getTop();
                        if (Math.abs(top - this.f36180f) < Math.abs(top - this.f36181g)) {
                            i8 = this.f36180f;
                        } else {
                            i8 = this.f36181g;
                        }
                    }
                    i9 = 4;
                }
                ViewDragHelper viewDragHelper = this.f36185k;
                if (viewDragHelper != null) {
                    z7 = viewDragHelper.O(child, child.getLeft(), i8);
                } else {
                    z7 = false;
                }
                if (z7) {
                    a0(2);
                    ViewCompat.k0(child, new SettleRunnable(this, child, i9));
                } else {
                    a0(i9);
                }
                this.f36187m = false;
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean D(CoordinatorLayout parent, V child, MotionEvent event) {
        ViewDragHelper viewDragHelper;
        Intrinsics.f(parent, "parent");
        Intrinsics.f(child, "child");
        Intrinsics.f(event, "event");
        if (!child.isShown()) {
            return false;
        }
        int actionMasked = event.getActionMasked();
        if (this.f36184j == 1 && actionMasked == 0) {
            return true;
        }
        ViewDragHelper viewDragHelper2 = this.f36185k;
        if (viewDragHelper2 != null) {
            viewDragHelper2.F(event);
        }
        if (actionMasked == 0) {
            W();
        }
        if (this.f36192r == null) {
            this.f36192r = VelocityTracker.obtain();
        }
        VelocityTracker velocityTracker = this.f36192r;
        if (velocityTracker != null) {
            velocityTracker.addMovement(event);
        }
        if (actionMasked == 2 && !this.f36186l && Math.abs(this.f36194t - event.getY()) > U() && (viewDragHelper = this.f36185k) != null) {
            viewDragHelper.b(child, event.getPointerId(event.getActionIndex()));
        }
        return !this.f36186l;
    }

    public final void I(int i8) {
        V v7;
        BottomSheetCallback bottomSheetCallback;
        WeakReference<V> weakReference = this.f36189o;
        if (weakReference != null) {
            v7 = weakReference.get();
        } else {
            v7 = null;
        }
        if (v7 != null && (bottomSheetCallback = this.f36191q) != null) {
            int i9 = this.f36181g;
            if (i8 > i9) {
                if (bottomSheetCallback != null) {
                    bottomSheetCallback.b(v7, (i9 - i8) / (this.f36188n - i9));
                }
            } else if (bottomSheetCallback != null) {
                bottomSheetCallback.b(v7, (i9 - i8) / (i9 - this.f36180f));
            }
        }
    }

    public final View J(View view) {
        View J;
        if (view == null) {
            return null;
        }
        if (ViewCompat.X(view)) {
            return view;
        }
        if (view instanceof ViewPager) {
            View invoke = this.f36196v.invoke(view);
            if (invoke != null && (J = J(invoke)) != null) {
                return J;
            }
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                View J2 = J(viewGroup.getChildAt(i8));
                if (J2 != null) {
                    return J2;
                }
            }
        }
        return null;
    }

    public final int K() {
        return this.f36193s;
    }

    public final int L() {
        return this.f36181g;
    }

    public final int M() {
        return this.f36180f;
    }

    public final WeakReference<View> N() {
        return this.f36190p;
    }

    public final int O() {
        return this.f36188n;
    }

    public final int P() {
        return this.f36184j;
    }

    public final boolean Q() {
        return this.f36195u;
    }

    public final WeakReference<V> R() {
        return this.f36189o;
    }

    public final int S() {
        if (this.f36178d) {
            return -1;
        }
        return this.f36177c;
    }

    public final int T() {
        return this.f36184j;
    }

    public final boolean V() {
        return this.f36182h;
    }

    public final void X(BottomSheetCallback bottomSheetCallback) {
        this.f36191q = bottomSheetCallback;
    }

    public final void Y(int i8) {
        WeakReference<V> weakReference;
        V v7;
        boolean z7 = true;
        if (i8 == -1) {
            if (!this.f36178d) {
                this.f36178d = true;
            }
            z7 = false;
        } else {
            if (this.f36178d || this.f36177c != i8) {
                this.f36178d = false;
                this.f36177c = Math.max(0, i8);
                this.f36181g = this.f36188n - i8;
            }
            z7 = false;
        }
        if (z7 && this.f36184j == 4 && (weakReference = this.f36189o) != null) {
            if (weakReference != null) {
                v7 = weakReference.get();
            } else {
                v7 = null;
            }
            if (v7 != null) {
                v7.requestLayout();
            }
        }
    }

    public final void Z(final int i8) {
        final V v7;
        if (i8 == this.f36184j) {
            return;
        }
        WeakReference<V> weakReference = this.f36189o;
        if (weakReference == null) {
            if (i8 == 4 || i8 == 3 || (this.f36182h && i8 == 5)) {
                this.f36184j = i8;
            }
        } else if (weakReference != null && (v7 = weakReference.get()) != null) {
            ViewParent parent = v7.getParent();
            if (parent != null && parent.isLayoutRequested() && ViewCompat.V(v7)) {
                v7.post(new Runnable() { // from class: ee.mtakso.driver.uikit.widgets.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        ViewPagerBottomSheetBehavior.F(ViewPagerBottomSheetBehavior.this, v7, i8);
                    }
                });
            } else {
                c0(v7, i8);
            }
        }
    }

    public final void a0(int i8) {
        V v7;
        BottomSheetCallback bottomSheetCallback;
        if (this.f36184j == i8) {
            return;
        }
        this.f36184j = i8;
        WeakReference<V> weakReference = this.f36189o;
        if (weakReference != null) {
            v7 = weakReference.get();
        } else {
            v7 = null;
        }
        if (v7 != null && (bottomSheetCallback = this.f36191q) != null && bottomSheetCallback != null) {
            bottomSheetCallback.a(v7, i8);
        }
    }

    public final boolean b0(View child, float f8) {
        Intrinsics.f(child, "child");
        if (this.f36183i) {
            return true;
        }
        if (child.getTop() >= this.f36181g && Math.abs((child.getTop() + (f8 * 0.1f)) - this.f36181g) / this.f36177c > 0.5f) {
            return true;
        }
        return false;
    }

    public final void c0(View child, int i8) {
        int i9;
        boolean z7;
        Intrinsics.f(child, "child");
        if (i8 == 4) {
            i9 = this.f36181g;
        } else if (i8 == 3) {
            i9 = this.f36180f;
        } else if (this.f36182h && i8 == 5) {
            i9 = this.f36188n;
        } else {
            throw new IllegalArgumentException("Illegal state argument: " + i8);
        }
        ViewDragHelper viewDragHelper = this.f36185k;
        if (viewDragHelper != null) {
            z7 = viewDragHelper.O(child, child.getLeft(), i9);
        } else {
            z7 = false;
        }
        if (z7) {
            a0(2);
            ViewCompat.k0(child, new SettleRunnable(this, child, i8));
            return;
        }
        a0(i8);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean k(CoordinatorLayout parent, V child, MotionEvent event) {
        View view;
        boolean z7;
        Intrinsics.f(parent, "parent");
        Intrinsics.f(child, "child");
        Intrinsics.f(event, "event");
        if (!child.isShown()) {
            this.f36186l = true;
            return false;
        }
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            W();
        }
        if (this.f36192r == null) {
            this.f36192r = VelocityTracker.obtain();
        }
        VelocityTracker velocityTracker = this.f36192r;
        if (velocityTracker != null) {
            velocityTracker.addMovement(event);
        }
        View view2 = null;
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                this.f36195u = false;
                this.f36193s = -1;
                if (this.f36186l) {
                    this.f36186l = false;
                    return false;
                }
            }
        } else {
            int x7 = (int) event.getX();
            this.f36194t = (int) event.getY();
            WeakReference<View> weakReference = this.f36190p;
            if (weakReference != null) {
                view = weakReference.get();
            } else {
                view = null;
            }
            if (view != null && parent.C(view, x7, this.f36194t)) {
                this.f36193s = event.getPointerId(event.getActionIndex());
                this.f36195u = true;
            }
            if (this.f36193s == -1 && !parent.C(child, x7, this.f36194t)) {
                z7 = true;
            } else {
                z7 = false;
            }
            this.f36186l = z7;
        }
        ViewDragHelper viewDragHelper = this.f36185k;
        if (viewDragHelper != null && !this.f36186l && viewDragHelper.N(event)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.f36190p;
        if (weakReference2 != null) {
            view2 = weakReference2.get();
        }
        if (actionMasked != 2 || view2 == null || this.f36186l || this.f36184j == 1 || parent.C(view2, (int) event.getX(), (int) event.getY()) || Math.abs(this.f36194t - event.getY()) <= U()) {
            return false;
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean l(CoordinatorLayout parent, V child, int i8) {
        int i9;
        Intrinsics.f(parent, "parent");
        Intrinsics.f(child, "child");
        if (ViewCompat.B(parent) && !ViewCompat.B(child)) {
            ViewCompat.B0(child, true);
        }
        int top = child.getTop();
        parent.J(child, i8);
        this.f36188n = parent.getHeight();
        if (this.f36178d) {
            if (this.f36179e == 0) {
                this.f36179e = parent.getResources().getDimensionPixelSize(R$dimen.f35751a);
            }
            i9 = Math.max(this.f36179e, this.f36188n - ((parent.getWidth() * 9) / 16));
        } else {
            i9 = this.f36177c;
        }
        int max = Math.max(0, this.f36188n - child.getHeight());
        this.f36180f = max;
        int max2 = Math.max(this.f36188n - i9, max);
        this.f36181g = max2;
        int i10 = this.f36184j;
        if (i10 == 3) {
            ViewCompat.d0(child, this.f36180f);
        } else if (this.f36182h && i10 == 5) {
            ViewCompat.d0(child, this.f36188n);
        } else if (i10 == 4) {
            ViewCompat.d0(child, max2);
        } else if (i10 == 1 || i10 == 2) {
            ViewCompat.d0(child, top - child.getTop());
        }
        if (this.f36185k == null) {
            this.f36185k = ViewDragHelper.o(parent, this.f36197w);
        }
        this.f36189o = new WeakReference<>(child);
        this.f36190p = new WeakReference<>(J(child));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean o(CoordinatorLayout coordinatorLayout, V child, View target, float f8, float f9) {
        View view;
        Intrinsics.f(coordinatorLayout, "coordinatorLayout");
        Intrinsics.f(child, "child");
        Intrinsics.f(target, "target");
        WeakReference<View> weakReference = this.f36190p;
        if (weakReference != null) {
            view = weakReference.get();
        } else {
            view = null;
        }
        if (Intrinsics.a(target, view) && (this.f36184j != 3 || super.o(coordinatorLayout, child, target, f8, f9))) {
            return true;
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void p(CoordinatorLayout coordinatorLayout, V child, View target, int i8, int i9, int[] consumed) {
        View view;
        Intrinsics.f(coordinatorLayout, "coordinatorLayout");
        Intrinsics.f(child, "child");
        Intrinsics.f(target, "target");
        Intrinsics.f(consumed, "consumed");
        WeakReference<View> weakReference = this.f36190p;
        if (weakReference != null) {
            view = weakReference.get();
        } else {
            view = null;
        }
        if (target != view) {
            return;
        }
        int top = child.getTop();
        int i10 = top - i9;
        if (i9 > 0) {
            int i11 = this.f36180f;
            if (i10 < i11) {
                int i12 = top - i11;
                consumed[1] = i12;
                ViewCompat.d0(child, -i12);
                a0(3);
            } else {
                consumed[1] = i9;
                ViewCompat.d0(child, -i9);
                a0(1);
            }
        } else if (i9 < 0 && !target.canScrollVertically(-1)) {
            int i13 = this.f36181g;
            if (i10 > i13 && !this.f36182h) {
                int i14 = top - i13;
                consumed[1] = i14;
                ViewCompat.d0(child, -i14);
                a0(4);
            } else {
                consumed[1] = i9;
                ViewCompat.d0(child, -i9);
                a0(1);
            }
        }
        I(child.getTop());
        this.f36187m = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void x(CoordinatorLayout parent, V child, Parcelable state) {
        SavedState savedState;
        int i8;
        Intrinsics.f(parent, "parent");
        Intrinsics.f(child, "child");
        Intrinsics.f(state, "state");
        if (state instanceof SavedState) {
            savedState = (SavedState) state;
        } else {
            savedState = null;
        }
        if (savedState == null) {
            return;
        }
        super.x(parent, child, savedState.getSuperState());
        if (savedState.a() != 1 && savedState.a() != 2) {
            i8 = savedState.a();
        } else {
            i8 = 4;
        }
        this.f36184j = i8;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public Parcelable y(CoordinatorLayout parent, V child) {
        Intrinsics.f(parent, "parent");
        Intrinsics.f(child, "child");
        return new SavedState(super.y(parent, child), this.f36184j);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean z(CoordinatorLayout coordinatorLayout, V child, View directTargetChild, View target, int i8) {
        Intrinsics.f(coordinatorLayout, "coordinatorLayout");
        Intrinsics.f(child, "child");
        Intrinsics.f(directTargetChild, "directTargetChild");
        Intrinsics.f(target, "target");
        this.f36187m = false;
        if ((i8 & 2) == 0) {
            return false;
        }
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewPagerBottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int dimensionPixelSize;
        Intrinsics.f(context, "context");
        this.f36184j = 4;
        this.f36196v = ViewPagerBottomSheetBehavior$currentViewResolver$1.f36202f;
        this.f36197w = new ViewDragHelper.Callback(this) { // from class: ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior$mDragCallback$1

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ViewPagerBottomSheetBehavior<V> f36203a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f36203a = this;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int a(View child, int i8, int i9) {
                Intrinsics.f(child, "child");
                return child.getLeft();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int b(View child, int i8, int i9) {
                int L;
                Intrinsics.f(child, "child");
                int M = this.f36203a.M();
                if (this.f36203a.V()) {
                    L = this.f36203a.O();
                } else {
                    L = this.f36203a.L();
                }
                return MathUtils.b(i8, M, L);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int e(View child) {
                int L;
                int M;
                Intrinsics.f(child, "child");
                if (this.f36203a.V()) {
                    L = this.f36203a.O();
                    M = this.f36203a.M();
                } else {
                    L = this.f36203a.L();
                    M = this.f36203a.M();
                }
                return L - M;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void j(int i8) {
                if (i8 == 1) {
                    this.f36203a.a0(1);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void k(View changedView, int i8, int i9, int i10, int i11) {
                Intrinsics.f(changedView, "changedView");
                this.f36203a.I(i9);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void l(android.view.View r6, float r7, float r8) {
                /*
                    r5 = this;
                    java.lang.String r0 = "releasedChild"
                    kotlin.jvm.internal.Intrinsics.f(r6, r0)
                    r0 = 4
                    r1 = 3
                    r2 = 0
                    int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                    if (r3 >= 0) goto L2e
                    float r3 = java.lang.Math.abs(r8)
                    ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior<V> r4 = r5.f36203a
                    float r4 = ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior.G(r4)
                    int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
                    if (r3 <= 0) goto L2e
                    float r3 = java.lang.Math.abs(r8)
                    float r4 = java.lang.Math.abs(r7)
                    int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
                    if (r3 <= 0) goto L2e
                    ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior<V> r7 = r5.f36203a
                    int r7 = r7.M()
                L2c:
                    r0 = 3
                    goto L95
                L2e:
                    ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior<V> r3 = r5.f36203a
                    boolean r3 = r3.V()
                    if (r3 == 0) goto L46
                    ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior<V> r3 = r5.f36203a
                    boolean r3 = r3.b0(r6, r8)
                    if (r3 == 0) goto L46
                    ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior<V> r7 = r5.f36203a
                    int r7 = r7.O()
                    r0 = 5
                    goto L95
                L46:
                    int r2 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                    if (r2 <= 0) goto L6b
                    float r2 = java.lang.Math.abs(r8)
                    ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior<V> r3 = r5.f36203a
                    float r3 = ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior.G(r3)
                    int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
                    if (r2 <= 0) goto L6b
                    float r8 = java.lang.Math.abs(r8)
                    float r7 = java.lang.Math.abs(r7)
                    int r7 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
                    if (r7 <= 0) goto L6b
                    ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior<V> r7 = r5.f36203a
                    int r7 = r7.L()
                    goto L95
                L6b:
                    int r7 = r6.getTop()
                    ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior<V> r8 = r5.f36203a
                    int r8 = r8.M()
                    int r8 = r7 - r8
                    int r8 = java.lang.Math.abs(r8)
                    ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior<V> r2 = r5.f36203a
                    int r2 = r2.L()
                    int r7 = r7 - r2
                    int r7 = java.lang.Math.abs(r7)
                    if (r8 >= r7) goto L8f
                    ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior<V> r7 = r5.f36203a
                    int r7 = r7.M()
                    goto L2c
                L8f:
                    ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior<V> r7 = r5.f36203a
                    int r7 = r7.L()
                L95:
                    ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior<V> r8 = r5.f36203a
                    androidx.customview.widget.ViewDragHelper r8 = ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior.H(r8)
                    if (r8 == 0) goto La6
                    int r1 = r6.getLeft()
                    boolean r7 = r8.M(r1, r7)
                    goto La7
                La6:
                    r7 = 0
                La7:
                    if (r7 == 0) goto Lba
                    ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior<V> r7 = r5.f36203a
                    r8 = 2
                    r7.a0(r8)
                    ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior$SettleRunnable r7 = new ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior$SettleRunnable
                    ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior<V> r8 = r5.f36203a
                    r7.<init>(r8, r6, r0)
                    androidx.core.view.ViewCompat.k0(r6, r7)
                    goto Lbf
                Lba:
                    ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior<V> r6 = r5.f36203a
                    r6.a0(r0)
                Lbf:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.uikit.widgets.ViewPagerBottomSheetBehavior$mDragCallback$1.l(android.view.View, float, float):void");
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean m(View child, int i8) {
                View view;
                Intrinsics.f(child, "child");
                if (this.f36203a.P() == 1 || this.f36203a.Q()) {
                    return false;
                }
                View view2 = null;
                if (this.f36203a.P() == 3 && this.f36203a.K() == i8) {
                    WeakReference<View> N = this.f36203a.N();
                    if (N != null) {
                        view = N.get();
                    } else {
                        view = null;
                    }
                    if (view != null && view.canScrollVertically(-1)) {
                        return false;
                    }
                }
                if (this.f36203a.R() != null) {
                    WeakReference R = this.f36203a.R();
                    if (R != null) {
                        view2 = (View) R.get();
                    }
                    if (view2 == child) {
                        return true;
                    }
                }
                return false;
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f35893x);
        Intrinsics.e(obtainStyledAttributes, "context.obtainStyledAttr…ttomSheetBehavior_Layout)");
        int i8 = R$styleable.f35901z;
        TypedValue peekValue = obtainStyledAttributes.peekValue(i8);
        Y((peekValue == null || (dimensionPixelSize = peekValue.data) != -1) ? obtainStyledAttributes.getDimensionPixelSize(i8, -1) : dimensionPixelSize);
        this.f36182h = obtainStyledAttributes.getBoolean(R$styleable.f35897y, false);
        this.f36183i = obtainStyledAttributes.getBoolean(R$styleable.A, false);
        obtainStyledAttributes.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f36176b = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f36175a = viewConfiguration.getScaledMinimumFlingVelocity();
    }
}
