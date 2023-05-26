package eu.bolt.client.design.bottomsheet.behavior;

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
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior;
import eu.bolt.logger.Logger;
import eu.bolt.verification.R$styleable;
import eu.bolt.verification.sdk.internal.n9;
import eu.bolt.verification.sdk.internal.t3;
import eu.bolt.verification.sdk.internal.uq;
import eu.bolt.verification.sdk.internal.zb;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes5.dex */
public class DesignBottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final n9 O = n9.HIDEABLE_ONLY_VIA_API;
    private Map<View, Integer> A;
    protected boolean B;
    protected boolean C;
    protected boolean D;
    protected boolean E;
    protected boolean F;
    protected boolean G;
    protected boolean H;
    protected boolean I;
    private DesignBottomSheetBehavior<V>.d J;
    private DesignBottomSheetBehavior<V>.c K;
    private int L;
    private final Logger M;
    private final ViewDragHelper.Callback N;

    /* renamed from: a  reason: collision with root package name */
    private boolean f39922a;

    /* renamed from: b  reason: collision with root package name */
    private float f39923b;

    /* renamed from: c  reason: collision with root package name */
    private int f39924c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f39925d;

    /* renamed from: e  reason: collision with root package name */
    private int f39926e;

    /* renamed from: f  reason: collision with root package name */
    private int f39927f;

    /* renamed from: g  reason: collision with root package name */
    int f39928g;

    /* renamed from: h  reason: collision with root package name */
    int f39929h;

    /* renamed from: i  reason: collision with root package name */
    int f39930i;

    /* renamed from: j  reason: collision with root package name */
    int f39931j;

    /* renamed from: k  reason: collision with root package name */
    n9 f39932k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f39933l;

    /* renamed from: m  reason: collision with root package name */
    int f39934m;

    /* renamed from: n  reason: collision with root package name */
    int f39935n;

    /* renamed from: o  reason: collision with root package name */
    ViewDragHelper f39936o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f39937p;

    /* renamed from: q  reason: collision with root package name */
    private int f39938q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f39939r;

    /* renamed from: s  reason: collision with root package name */
    int f39940s;

    /* renamed from: t  reason: collision with root package name */
    WeakReference<V> f39941t;

    /* renamed from: u  reason: collision with root package name */
    WeakReference<View> f39942u;

    /* renamed from: v  reason: collision with root package name */
    private b f39943v;

    /* renamed from: w  reason: collision with root package name */
    private VelocityTracker f39944w;

    /* renamed from: x  reason: collision with root package name */
    int f39945x;

    /* renamed from: y  reason: collision with root package name */
    private int f39946y;

    /* renamed from: z  reason: collision with root package name */
    boolean f39947z;

    /* loaded from: classes5.dex */
    class a extends ViewDragHelper.Callback {
        a() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int a(@NonNull View view, int i8, int i9) {
            return view.getLeft();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int b(@NonNull View view, int i8, int i9) {
            return MathUtils.b(i8, DesignBottomSheetBehavior.this.a0(), DesignBottomSheetBehavior.this.f39932k.f() ? DesignBottomSheetBehavior.this.f39940s : DesignBottomSheetBehavior.this.f39930i);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int e(@NonNull View view) {
            return DesignBottomSheetBehavior.this.f39932k.f() ? DesignBottomSheetBehavior.this.f39940s : DesignBottomSheetBehavior.this.f39930i;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void j(int i8) {
            if (i8 == 1) {
                DesignBottomSheetBehavior.this.r0(1);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void k(@NonNull View view, int i8, int i9, int i10, int i11) {
            DesignBottomSheetBehavior.this.e0(i9);
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x008d, code lost:
            if (r7 < java.lang.Math.abs(r7 - r8.f39930i)) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00a0, code lost:
            if (java.lang.Math.abs(r7 - r0) < java.lang.Math.abs(r7 - r5.f39948a.f39930i)) goto L42;
         */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00b2  */
        @Override // androidx.customview.widget.ViewDragHelper.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void l(@androidx.annotation.NonNull android.view.View r6, float r7, float r8) {
            /*
                r5 = this;
                eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior r0 = eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior.this
                eu.bolt.verification.sdk.internal.n9 r0 = r0.f39932k
                boolean r0 = r0.f()
                r1 = 6
                r2 = 0
                r3 = 3
                int r4 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r4 >= 0) goto L29
                eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior r7 = eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior.this
                boolean r8 = eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior.G(r7)
                if (r8 == 0) goto L1c
            L17:
                int r7 = r7.f39928g
            L19:
                r1 = 3
                goto Lac
            L1c:
                int r7 = r6.getTop()
                eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior r8 = eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior.this
                int r8 = r8.f39929h
                if (r7 <= r8) goto L8f
                r7 = r8
                goto Lac
            L29:
                if (r0 == 0) goto L4f
                eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior r0 = eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior.this
                boolean r0 = r0.Y(r6, r8)
                if (r0 == 0) goto L4f
                int r0 = r6.getTop()
                eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior r4 = eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior.this
                int r4 = r4.f39930i
                if (r0 > r4) goto L49
                float r0 = java.lang.Math.abs(r7)
                float r4 = java.lang.Math.abs(r8)
                int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r0 >= 0) goto L4f
            L49:
                eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior r7 = eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior.this
                int r7 = r7.f39940s
                r1 = 5
                goto Lac
            L4f:
                int r0 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r0 == 0) goto L5f
                float r7 = java.lang.Math.abs(r7)
                float r8 = java.lang.Math.abs(r8)
                int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
                if (r7 <= 0) goto La7
            L5f:
                int r7 = r6.getTop()
                eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior r8 = eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior.this
                boolean r0 = eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior.G(r8)
                if (r0 == 0) goto L81
                int r8 = r8.f39928g
                int r8 = r7 - r8
                int r8 = java.lang.Math.abs(r8)
                eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior r0 = eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior.this
                int r0 = r0.f39930i
                int r7 = r7 - r0
                int r7 = java.lang.Math.abs(r7)
                if (r8 >= r7) goto La7
                eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior r7 = eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior.this
                goto L17
            L81:
                int r0 = r8.f39929h
                if (r7 >= r0) goto L91
                int r8 = r8.f39930i
                int r8 = r7 - r8
                int r8 = java.lang.Math.abs(r8)
                if (r7 >= r8) goto La2
            L8f:
                r7 = 0
                goto L19
            L91:
                int r8 = r7 - r0
                int r8 = java.lang.Math.abs(r8)
                eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior r0 = eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior.this
                int r0 = r0.f39930i
                int r7 = r7 - r0
                int r7 = java.lang.Math.abs(r7)
                if (r8 >= r7) goto La7
            La2:
                eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior r7 = eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior.this
                int r7 = r7.f39929h
                goto Lac
            La7:
                eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior r7 = eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior.this
                int r7 = r7.f39930i
                r1 = 4
            Lac:
                eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior r8 = eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior.this
                androidx.customview.widget.ViewDragHelper r8 = r8.f39936o
                if (r8 == 0) goto Lcd
                int r0 = r6.getLeft()
                boolean r8 = r8.M(r0, r7)
                if (r8 == 0) goto Lcd
                eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior r8 = eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior.this
                r0 = 2
                r8.r0(r0)
                eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior$d r8 = new eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior$d
                eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior r0 = eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior.this
                r8.<init>(r6, r1, r7)
                androidx.core.view.ViewCompat.k0(r6, r8)
                goto Ld2
            Lcd:
                eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior r6 = eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior.this
                r6.r0(r1)
            Ld2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior.a.l(android.view.View, float, float):void");
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean m(@NonNull View view, int i8) {
            int i9;
            DesignBottomSheetBehavior designBottomSheetBehavior = DesignBottomSheetBehavior.this;
            if (!designBottomSheetBehavior.B || (i9 = designBottomSheetBehavior.f39934m) == 1 || designBottomSheetBehavior.f39947z) {
                return false;
            }
            if (i9 == 3 && designBottomSheetBehavior.f39945x == i8) {
                WeakReference<View> weakReference = designBottomSheetBehavior.f39942u;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            WeakReference<V> weakReference2 = DesignBottomSheetBehavior.this.f39941t;
            return weakReference2 != null && weakReference2.get() == view;
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class b {
        public abstract void a(@NonNull View view, float f8);

        public abstract void b(@NonNull View view, int i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class c implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        private ViewParent f39949f;

        /* renamed from: g  reason: collision with root package name */
        private View f39950g;

        /* renamed from: h  reason: collision with root package name */
        private int f39951h;

        /* renamed from: i  reason: collision with root package name */
        private int f39952i;

        /* renamed from: j  reason: collision with root package name */
        private ViewTreeObserver.OnGlobalLayoutListener f39953j;

        public c(ViewParent viewParent, View view, int i8, int i9) {
            this.f39949f = viewParent;
            this.f39950g = view;
            this.f39951h = i8;
            this.f39952i = i9;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit d() {
            run();
            return Unit.f50853a;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f39949f.isLayoutRequested() && ViewCompat.V(this.f39950g)) {
                this.f39953j = uq.m(this.f39950g, new Function0() { // from class: eu.bolt.client.design.bottomsheet.behavior.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit d8;
                        d8 = DesignBottomSheetBehavior.c.this.d();
                        return d8;
                    }
                });
                return;
            }
            this.f39953j = null;
            DesignBottomSheetBehavior designBottomSheetBehavior = DesignBottomSheetBehavior.this;
            designBottomSheetBehavior.K = null;
            if (this.f39951h != 5 || designBottomSheetBehavior.f39932k.e()) {
                DesignBottomSheetBehavior designBottomSheetBehavior2 = DesignBottomSheetBehavior.this;
                designBottomSheetBehavior2.W("pending_settling_start", designBottomSheetBehavior2.f39934m, this.f39951h);
                DesignBottomSheetBehavior.this.R(this.f39950g, this.f39951h, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class d implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        private final View f39955f;

        /* renamed from: g  reason: collision with root package name */
        private final int f39956g;

        /* renamed from: h  reason: collision with root package name */
        private int f39957h;

        d(View view, int i8, int i9) {
            this.f39955f = view;
            this.f39956g = i8;
            this.f39957h = i9;
            d dVar = DesignBottomSheetBehavior.this.J;
            if (dVar != null) {
                view.removeCallbacks(dVar);
                DesignBottomSheetBehavior.this.M.d("Two settling animation was started. The first one is cancelled now.");
            }
            DesignBottomSheetBehavior.this.J = this;
        }

        private void b(int i8) {
            ViewDragHelper viewDragHelper = DesignBottomSheetBehavior.this.f39936o;
            if (viewDragHelper == null) {
                c();
                return;
            }
            viewDragHelper.a();
            ViewDragHelper viewDragHelper2 = DesignBottomSheetBehavior.this.f39936o;
            View view = this.f39955f;
            if (viewDragHelper2.O(view, view.getLeft(), i8)) {
                ViewCompat.k0(this.f39955f, this);
            } else {
                c();
            }
            this.f39957h = i8;
        }

        private void c() {
            DesignBottomSheetBehavior designBottomSheetBehavior = DesignBottomSheetBehavior.this;
            designBottomSheetBehavior.J = null;
            designBottomSheetBehavior.W("settling", designBottomSheetBehavior.f39934m, this.f39956g);
            DesignBottomSheetBehavior.this.r0(this.f39956g);
        }

        public int a() {
            return this.f39956g;
        }

        @Override // java.lang.Runnable
        public void run() {
            int O = DesignBottomSheetBehavior.this.O(this.f39956g, true);
            if (O != this.f39957h) {
                b(O);
                return;
            }
            ViewDragHelper viewDragHelper = DesignBottomSheetBehavior.this.f39936o;
            if (viewDragHelper == null || !viewDragHelper.m(true)) {
                c();
            } else {
                ViewCompat.k0(this.f39955f, this);
            }
        }
    }

    public DesignBottomSheetBehavior() {
        this.f39922a = true;
        this.f39932k = O;
        this.f39934m = 4;
        this.f39935n = 4;
        this.B = true;
        this.C = true;
        this.D = false;
        this.E = false;
        this.F = true;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = null;
        this.K = null;
        this.L = 0;
        this.M = new zb("[SheetBehaviour]");
        this.N = new a();
    }

    public DesignBottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i8;
        this.f39922a = true;
        n9 n9Var = O;
        this.f39932k = n9Var;
        this.f39934m = 4;
        this.f39935n = 4;
        this.B = true;
        this.C = true;
        this.D = false;
        this.E = false;
        this.F = true;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = null;
        this.K = null;
        this.L = 0;
        this.M = new zb("[SheetBehaviour]");
        this.N = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.R2);
        int i9 = R$styleable.U2;
        TypedValue peekValue = obtainStyledAttributes.peekValue(i9);
        if (peekValue == null || (i8 = peekValue.data) != -1) {
            n0(obtainStyledAttributes.getDimensionPixelSize(i9, -1));
        } else {
            n0(i8);
        }
        this.f39932k = n9.c(obtainStyledAttributes.getInt(R$styleable.f41766e0, n9Var.a()));
        f0(obtainStyledAttributes.getBoolean(R$styleable.S2, true));
        i0(obtainStyledAttributes.getBoolean(R$styleable.T2, false));
        obtainStyledAttributes.recycle();
        this.f39923b = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    private float N(int i8) {
        int a02 = a0();
        int i9 = this.f39930i;
        if (a02 >= i9) {
            return -1.0f;
        }
        return (i9 - i8) / (i9 - a02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int O(int i8, boolean z7) {
        if (i8 == 4) {
            return this.f39930i;
        }
        if (i8 == 6) {
            if (this.f39922a) {
                int i9 = this.f39929h;
                int i10 = this.f39928g;
                if (i9 <= i10) {
                    return i10;
                }
            }
            return this.f39929h;
        } else if (i8 == 3) {
            return a0();
        } else {
            if ((this.f39932k.e() || z7) && i8 == 5) {
                return this.f39940s + this.f39931j;
            }
            throw new IllegalArgumentException("Illegal state argument: " + i8);
        }
    }

    private void P() {
        this.f39930i = this.f39922a ? Math.max(this.f39940s - this.f39927f, this.f39928g) : this.f39940s - this.f39927f;
    }

    private void Q(View view) {
        ViewTreeObserver Q;
        DesignBottomSheetBehavior<V>.c cVar = this.K;
        if (cVar != null) {
            view.removeCallbacks(cVar);
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = ((c) this.K).f39953j;
            if (onGlobalLayoutListener != null && (Q = uq.Q(view)) != null) {
                Q.removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
            this.K = null;
        }
        DesignBottomSheetBehavior<V>.d dVar = this.J;
        if (dVar != null) {
            view.removeCallbacks(dVar);
            this.J = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(View view, int i8, boolean z7) {
        int O2 = O(i8, z7);
        if (i8 == 6 && this.f39922a && this.f39929h <= this.f39928g) {
            i8 = 3;
        }
        Q(view);
        ViewDragHelper viewDragHelper = this.f39936o;
        if (viewDragHelper == null || !viewDragHelper.O(view, view.getLeft(), O2)) {
            r0(i8);
            return;
        }
        r0(2);
        ViewCompat.k0(view, new d(view, i8, O2));
    }

    private void S(ViewParent viewParent, View view, int i8) {
        W("settle_on_laid_out", this.f39934m, i8);
        Q(view);
        DesignBottomSheetBehavior<V>.c cVar = new c(viewParent, view, i8, this.f39930i);
        this.K = cVar;
        view.post(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(String str, int i8, int i9) {
    }

    private float Z(int i8) {
        int i9 = this.f39940s;
        int i10 = this.f39930i;
        if (i9 == i10) {
            return -1.0f;
        }
        return (i10 - i8) / (i9 - i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a0() {
        if (this.f39922a) {
            return this.f39928g;
        }
        return 0;
    }

    private float j0() {
        VelocityTracker velocityTracker = this.f39944w;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f39923b);
        return this.f39944w.getYVelocity(this.f39945x);
    }

    private void l0(boolean z7) {
        int intValue;
        WeakReference<V> weakReference = this.f39941t;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z7) {
                if (this.A != null) {
                    return;
                }
                this.A = new HashMap(childCount);
            }
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = coordinatorLayout.getChildAt(i8);
                if (childAt != this.f39941t.get()) {
                    Map<View, Integer> map = this.A;
                    if (z7) {
                        map.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    } else {
                        intValue = (map != null && map.containsKey(childAt)) ? this.A.get(childAt).intValue() : 4;
                    }
                    ViewCompat.D0(childAt, intValue);
                }
            }
            if (z7) {
                return;
            }
            this.A = null;
        }
    }

    private void o0() {
        this.f39945x = -1;
        VelocityTracker velocityTracker = this.f39944w;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f39944w = null;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean A(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull View view, @NonNull View view2, int i8, int i9) {
        if (this.C) {
            this.f39938q = 0;
            this.f39939r = false;
            this.D = view2.canScrollVertically(-1);
            this.E = view2.canScrollVertically(1);
            this.H = false;
            this.G = false;
            return (i8 & 2) != 0;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x007f, code lost:
        if (java.lang.Math.abs(r3 - r5) < java.lang.Math.abs(r3 - r2.f39930i)) goto L40;
     */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void C(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout r3, @androidx.annotation.NonNull V r4, @androidx.annotation.NonNull android.view.View r5, int r6) {
        /*
            r2 = this;
            boolean r3 = r2.C
            if (r3 != 0) goto L5
            return
        L5:
            int r3 = r4.getTop()
            int r6 = r2.a0()
            r0 = 3
            if (r3 != r6) goto L14
            r2.r0(r0)
            return
        L14:
            java.lang.ref.WeakReference<android.view.View> r3 = r2.f39942u
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto La8
            boolean r3 = r2.f39939r
            if (r3 != 0) goto L22
            goto La8
        L22:
            eu.bolt.verification.sdk.internal.n9 r3 = r2.f39932k
            boolean r3 = r3.f()
            int r5 = r2.f39938q
            r6 = 0
            if (r5 <= 0) goto L32
            int r3 = r2.a0()
            goto L88
        L32:
            if (r3 == 0) goto L42
            float r3 = r2.j0()
            boolean r3 = r2.Y(r4, r3)
            if (r3 == 0) goto L42
            int r3 = r2.f39940s
            r0 = 5
            goto L88
        L42:
            int r3 = r2.f39938q
            if (r3 != 0) goto L85
            int r3 = r4.getTop()
            boolean r5 = r2.f39922a
            if (r5 == 0) goto L62
            int r5 = r2.f39928g
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            int r1 = r2.f39930i
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r5 >= r3) goto L85
            int r3 = r2.f39928g
            goto L88
        L62:
            int r5 = r2.f39929h
            if (r3 >= r5) goto L72
            int r5 = r2.f39930i
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            if (r3 >= r5) goto L81
            r3 = 0
            goto L88
        L72:
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            int r0 = r2.f39930i
            int r3 = r3 - r0
            int r3 = java.lang.Math.abs(r3)
            if (r5 >= r3) goto L85
        L81:
            int r3 = r2.f39929h
            r0 = 6
            goto L88
        L85:
            int r3 = r2.f39930i
            r0 = 4
        L88:
            androidx.customview.widget.ViewDragHelper r5 = r2.f39936o
            if (r5 == 0) goto La3
            int r1 = r4.getLeft()
            boolean r5 = r5.O(r4, r1, r3)
            if (r5 == 0) goto La3
            r5 = 2
            r2.r0(r5)
            eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior$d r5 = new eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior$d
            r5.<init>(r4, r0, r3)
            androidx.core.view.ViewCompat.k0(r4, r5)
            goto La6
        La3:
            r2.r0(r0)
        La6:
            r2.f39939r = r6
        La8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior.C(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean D(CoordinatorLayout coordinatorLayout, V v7, MotionEvent motionEvent) {
        if (v7.isShown()) {
            int actionMasked = motionEvent.getActionMasked();
            if (this.f39934m == 1 && actionMasked == 0) {
                return true;
            }
            ViewDragHelper viewDragHelper = this.f39936o;
            if (viewDragHelper != null) {
                try {
                    viewDragHelper.F(motionEvent);
                } catch (IllegalArgumentException e8) {
                    t3.d(e8, "Multi touch ViewDragHelper exception");
                }
            }
            if (actionMasked == 0) {
                o0();
            }
            if (this.f39944w == null) {
                this.f39944w = VelocityTracker.obtain();
            }
            this.f39944w.addMovement(motionEvent);
            if (actionMasked == 2 && !this.f39937p && this.f39936o != null && this.B && Math.abs(this.f39946y - motionEvent.getY()) > this.f39936o.z()) {
                this.f39936o.b(v7, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
            return !this.f39937p;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void T(androidx.coordinatorlayout.widget.CoordinatorLayout r5, V r6, int r7) {
        /*
            r4 = this;
            boolean r0 = androidx.core.view.ViewCompat.B(r5)
            r1 = 1
            if (r0 == 0) goto L10
            boolean r0 = androidx.core.view.ViewCompat.B(r6)
            if (r0 != 0) goto L10
            r6.setFitsSystemWindows(r1)
        L10:
            int r0 = r6.getTop()
            r5.J(r6, r7)
            int r7 = r5.getHeight()
            r4.f39940s = r7
            boolean r7 = r4.f39925d
            if (r7 == 0) goto L43
            int r7 = r4.f39926e
            if (r7 != 0) goto L31
            android.content.res.Resources r7 = r5.getResources()
            int r2 = eu.bolt.verification.R$dimen.design_bottom_sheet_default_peek_height_min
            int r7 = r7.getDimensionPixelSize(r2)
            r4.f39926e = r7
        L31:
            int r7 = r4.f39926e
            int r2 = r4.f39940s
            int r3 = r5.getWidth()
            int r3 = r3 * 9
            int r3 = r3 / 16
            int r2 = r2 - r3
            int r7 = java.lang.Math.max(r7, r2)
            goto L45
        L43:
            int r7 = r4.f39924c
        L45:
            r4.f39927f = r7
            int r7 = r4.L
            int r2 = r4.f39940s
            int r3 = r6.getHeight()
            int r2 = r2 - r3
            int r7 = java.lang.Math.max(r7, r2)
            r4.f39928g = r7
            int r7 = r4.f39940s
            r2 = 2
            int r7 = r7 / r2
            r4.f39929h = r7
            r4.P()
            int r7 = r4.f39934m
            r3 = 3
            if (r7 != r3) goto L6c
            int r7 = r4.a0()
        L68:
            androidx.core.view.ViewCompat.d0(r6, r7)
            goto L93
        L6c:
            r3 = 6
            if (r7 != r3) goto L72
            int r7 = r4.f39929h
            goto L68
        L72:
            r3 = 5
            if (r7 != r3) goto L78
            int r7 = r4.f39940s
            goto L68
        L78:
            r3 = 4
            if (r7 != r3) goto L87
            eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior<V>$c r7 = r4.K
            if (r7 != 0) goto L82
            int r7 = r4.f39930i
            goto L68
        L82:
            int r7 = eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior.c.b(r7)
            goto L68
        L87:
            if (r7 == r1) goto L8b
            if (r7 != r2) goto L93
        L8b:
            int r7 = r6.getTop()
            int r0 = r0 - r7
            androidx.core.view.ViewCompat.d0(r6, r0)
        L93:
            androidx.customview.widget.ViewDragHelper r7 = r4.f39936o
            if (r7 != 0) goto L9f
            androidx.customview.widget.ViewDragHelper$Callback r7 = r4.N
            androidx.customview.widget.ViewDragHelper r5 = androidx.customview.widget.ViewDragHelper.o(r5, r7)
            r4.f39936o = r5
        L9f:
            java.lang.ref.WeakReference r5 = new java.lang.ref.WeakReference
            r5.<init>(r6)
            r4.f39941t = r5
            java.lang.ref.WeakReference r5 = new java.lang.ref.WeakReference
            android.view.View r7 = r4.b0(r6)
            r5.<init>(r7)
            r4.f39942u = r5
            int r5 = r4.f39934m
            if (r5 != r2) goto Lc7
            eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior<V>$d r5 = r4.J
            if (r5 == 0) goto Lc7
            int r5 = r5.a()
            int r7 = r4.f39934m
            java.lang.String r0 = "relayout"
            r4.W(r0, r7, r5)
            r4.R(r6, r5, r1)
        Lc7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior.T(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int):void");
    }

    public void U(b bVar) {
        this.f39943v = bVar;
    }

    public void V(n9 n9Var) {
        this.f39932k = n9Var;
    }

    public void X(boolean z7) {
        this.F = z7;
    }

    boolean Y(View view, float f8) {
        if (this.f39933l) {
            return true;
        }
        return view.getTop() >= this.f39930i && Math.abs((((float) view.getTop()) + (f8 * 0.1f)) - ((float) this.f39930i)) / ((float) this.f39924c) > 0.5f;
    }

    View b0(View view) {
        if (ViewCompat.X(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                View b02 = b0(viewGroup.getChildAt(i8));
                if (b02 != null) {
                    return b02;
                }
            }
            return null;
        }
        return null;
    }

    public void c0(boolean z7) {
        this.B = z7;
        this.C = z7;
    }

    public final int d0() {
        return this.f39934m;
    }

    void e0(int i8) {
        b bVar;
        WeakReference<V> weakReference = this.f39941t;
        V v7 = weakReference != null ? weakReference.get() : null;
        if (v7 == null || (bVar = this.f39943v) == null) {
            return;
        }
        bVar.a(v7, i8 == this.f39940s ? -1.0f : i8 > this.f39930i ? Z(i8) : N(i8));
    }

    public void f0(boolean z7) {
        if (this.f39922a == z7) {
            return;
        }
        this.f39922a = z7;
        if (this.f39941t != null) {
            P();
        }
        r0((this.f39922a && this.f39934m == 6) ? 3 : this.f39934m);
    }

    public int g0() {
        return this.f39935n;
    }

    public void h0(int i8) {
        this.L = i8;
        WeakReference<V> weakReference = this.f39941t;
        V v7 = weakReference != null ? weakReference.get() : null;
        if (v7 != null) {
            v7.requestLayout();
        }
    }

    public void i0(boolean z7) {
        this.f39933l = z7;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean k(CoordinatorLayout coordinatorLayout, V v7, MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper;
        boolean z7 = false;
        if (!v7.isShown()) {
            this.f39937p = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            o0();
        }
        if (this.f39944w == null) {
            this.f39944w = VelocityTracker.obtain();
        }
        this.f39944w.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x7 = (int) motionEvent.getX();
            this.f39946y = (int) motionEvent.getY();
            WeakReference<View> weakReference = this.f39942u;
            View view = weakReference != null ? weakReference.get() : null;
            if (view != null && view.getVisibility() == 0 && coordinatorLayout.C(view, x7, this.f39946y)) {
                this.f39945x = motionEvent.getPointerId(motionEvent.getActionIndex());
                this.f39947z = true;
            }
            this.f39937p = this.f39945x == -1 && !coordinatorLayout.C(v7, x7, this.f39946y);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f39947z = false;
            this.f39945x = -1;
            if (this.f39937p) {
                this.f39937p = false;
                return false;
            }
        }
        if (this.f39937p || (viewDragHelper = this.f39936o) == null || !viewDragHelper.N(motionEvent)) {
            WeakReference<View> weakReference2 = this.f39942u;
            View view2 = weakReference2 != null ? weakReference2.get() : null;
            if (actionMasked == 2 && view2 != null && !this.f39937p && this.f39934m != 1 && !coordinatorLayout.C(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) && this.f39936o != null && Math.abs(this.f39946y - motionEvent.getY()) > this.f39936o.z()) {
                z7 = true;
            }
            if (z7 && view2 != null) {
                view2.dispatchTouchEvent(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), 3, motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState()));
            }
            return z7;
        }
        return true;
    }

    public void k0(int i8) {
        this.f39931j = i8;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean l(CoordinatorLayout coordinatorLayout, V v7, int i8) {
        T(coordinatorLayout, v7, i8);
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean m(CoordinatorLayout coordinatorLayout, V v7, int i8, int i9, int i10, int i11) {
        coordinatorLayout.K(v7, i8, i9, i10, this.L);
        return true;
    }

    public void m0() {
        WeakReference<V> weakReference = this.f39941t;
        V v7 = weakReference != null ? weakReference.get() : null;
        if (v7 == null) {
            return;
        }
        e0(v7.getTop());
    }

    public final void n0(int i8) {
        WeakReference<V> weakReference;
        V v7;
        boolean z7 = true;
        if (i8 == -1) {
            if (!this.f39925d) {
                this.f39925d = true;
            }
            z7 = false;
        } else {
            if (this.f39925d || this.f39924c != i8) {
                this.f39925d = false;
                this.f39924c = Math.max(0, i8);
                this.f39930i = this.f39940s - i8;
            }
            z7 = false;
        }
        if (!z7 || this.f39934m != 4 || (weakReference = this.f39941t) == null || (v7 = weakReference.get()) == null) {
            return;
        }
        v7.requestLayout();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean o(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull View view, float f8, float f9) {
        WeakReference<View> weakReference = this.f39942u;
        return view == (weakReference != null ? weakReference.get() : null) && (this.f39934m != 3 || super.o(coordinatorLayout, v7, view, f8, f9));
    }

    public final void p0(int i8) {
        W("public_api", this.f39934m, i8);
        if (i8 == this.f39934m) {
            return;
        }
        if (i8 == 5 && !this.f39932k.e()) {
            throw new IllegalArgumentException("Illegal state argument: " + i8 + ". Dont set HIDDEN while hideable == " + this.f39932k);
        }
        WeakReference<V> weakReference = this.f39941t;
        if (weakReference == null) {
            if (i8 == 4 || i8 == 3 || i8 == 6 || i8 == 5) {
                this.f39934m = i8;
                return;
            }
            return;
        }
        V v7 = weakReference.get();
        if (v7 == null) {
            return;
        }
        ViewParent parent = v7.getParent();
        if (parent != null && parent.isLayoutRequested() && ViewCompat.V(v7)) {
            S(parent, v7, i8);
        } else {
            R(v7, i8, false);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void q(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull View view, int i8, int i9, @NonNull int[] iArr, int i10) {
        int i11;
        if (this.C && i10 != 1) {
            WeakReference<View> weakReference = this.f39942u;
            if (view != (weakReference != null ? weakReference.get() : null)) {
                return;
            }
            int top = v7.getTop();
            int i12 = top - i9;
            boolean f8 = this.f39932k.f();
            if (!this.H) {
                if (i9 <= 0 || this.E) {
                    if (i9 < 0 && !this.D) {
                        this.I = true;
                    }
                    this.H = true;
                } else {
                    this.I = false;
                }
                this.G = true;
                this.H = true;
            } else if ((this.I && i9 > 0 && d0() != 1) || (!this.I && i9 < 0 && d0() != 1)) {
                this.G = false;
            }
            if (this.F || this.G) {
                if (i9 > 0) {
                    if (i12 < a0()) {
                        int a02 = top - a0();
                        iArr[1] = a02;
                        ViewCompat.d0(v7, -a02);
                        i11 = 3;
                        r0(i11);
                    } else {
                        iArr[1] = i9;
                        ViewCompat.d0(v7, -i9);
                        r0(1);
                    }
                } else if (i9 < 0 && !view.canScrollVertically(-1)) {
                    int i13 = this.f39930i;
                    if (i12 <= i13 || f8) {
                        iArr[1] = i9;
                        ViewCompat.d0(v7, -i9);
                        r0(1);
                    } else {
                        int i14 = top - i13;
                        iArr[1] = i14;
                        ViewCompat.d0(v7, -i14);
                        i11 = 4;
                        r0(i11);
                    }
                }
                e0(v7.getTop());
            }
            this.f39938q = i9;
            this.f39939r = true;
        }
    }

    public void q0(int i8) {
        WeakReference<V> weakReference = this.f39941t;
        V v7 = weakReference == null ? null : weakReference.get();
        if (v7 != null) {
            Q(v7);
            v7.setTop(O(i8, true));
        }
        r0(i8);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void r0(int r3) {
        /*
            r2 = this;
            int r0 = r2.f39934m
            if (r0 != r3) goto L5
            return
        L5:
            r2.f39934m = r3
            r0 = 6
            if (r3 == r0) goto L16
            r0 = 3
            if (r3 != r0) goto Le
            goto L16
        Le:
            r0 = 5
            if (r3 == r0) goto L14
            r0 = 4
            if (r3 != r0) goto L1a
        L14:
            r0 = 0
            goto L17
        L16:
            r0 = 1
        L17:
            r2.l0(r0)
        L1a:
            java.lang.ref.WeakReference<V extends android.view.View> r0 = r2.f39941t
            if (r0 == 0) goto L25
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            goto L26
        L25:
            r0 = 0
        L26:
            if (r0 == 0) goto L2f
            eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior$b r1 = r2.f39943v
            if (r1 == 0) goto L2f
            r1.b(r0, r3)
        L2f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior.r0(int):void");
    }

    public void s0(int i8) {
        this.f39935n = i8;
    }
}
