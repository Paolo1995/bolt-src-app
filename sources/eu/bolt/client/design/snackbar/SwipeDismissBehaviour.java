package eu.bolt.client.design.snackbar;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import eu.bolt.verification.sdk.internal.uq;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.RangesKt___RangesKt;

/* loaded from: classes5.dex */
public class SwipeDismissBehaviour<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: t  reason: collision with root package name */
    public static final a f40192t = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private boolean f40193a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f40194b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f40195c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f40196d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f40197e;

    /* renamed from: f  reason: collision with root package name */
    private b f40198f;

    /* renamed from: g  reason: collision with root package name */
    private final PointF f40199g;

    /* renamed from: h  reason: collision with root package name */
    private ViewDragHelper f40200h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f40201i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f40202j;

    /* renamed from: k  reason: collision with root package name */
    private float f40203k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f40204l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f40205m;

    /* renamed from: n  reason: collision with root package name */
    private float f40206n;

    /* renamed from: o  reason: collision with root package name */
    private float f40207o;

    /* renamed from: p  reason: collision with root package name */
    private float f40208p;

    /* renamed from: q  reason: collision with root package name */
    private float f40209q;

    /* renamed from: r  reason: collision with root package name */
    private float f40210r;

    /* renamed from: s  reason: collision with root package name */
    private final ViewDragHelper.Callback f40211s;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float a(float f8, float f9, float f10) {
            return (f10 - f8) / (f9 - f8);
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void d(int i8);

        void e(View view);

        void f(float f8);
    }

    /* loaded from: classes5.dex */
    private static final class c implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        private final View f40212f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f40213g;

        /* renamed from: h  reason: collision with root package name */
        private final ViewDragHelper f40214h;

        /* renamed from: i  reason: collision with root package name */
        private final b f40215i;

        public c(View view, boolean z7, ViewDragHelper viewDragHelper, b bVar) {
            Intrinsics.f(view, "view");
            this.f40212f = view;
            this.f40213g = z7;
            this.f40214h = viewDragHelper;
            this.f40215i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper viewDragHelper = this.f40214h;
            if (viewDragHelper != null && viewDragHelper.m(true)) {
                ViewCompat.k0(this.f40212f, this);
            } else if (!this.f40213g || this.f40215i == null) {
            } else {
                this.f40212f.setAlpha(1.0f);
                this.f40215i.e(this.f40212f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends ViewDragHelper.Callback {

        /* renamed from: a  reason: collision with root package name */
        private Integer f40216a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f40217b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ SwipeDismissBehaviour<V> f40218c;

        d(SwipeDismissBehaviour<V> swipeDismissBehaviour) {
            this.f40218c = swipeDismissBehaviour;
        }

        private final int n() {
            Integer num = this.f40217b;
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }

        private final int o(View view, float f8) {
            int n8 = n();
            return (this.f40218c.b0() || !u(view, f8)) ? n8 : view.getLeft() < n8 ? (n8 + view.getWidth()) * (-1) : (n8 * 2) + view.getWidth();
        }

        private final void p(View view, int i8) {
            float i9;
            float f8;
            if (this.f40218c.O()) {
                float n8 = n();
                float width = n8 - (view.getWidth() * ((SwipeDismissBehaviour) this.f40218c).f40208p);
                float width2 = n8 - (view.getWidth() * ((SwipeDismissBehaviour) this.f40218c).f40209q);
                float width3 = (view.getWidth() * ((SwipeDismissBehaviour) this.f40218c).f40208p) + n8;
                float width4 = n8 + (view.getWidth() * ((SwipeDismissBehaviour) this.f40218c).f40209q);
                float f9 = i8;
                if (f9 >= width && f9 <= width3) {
                    f8 = 1.0f;
                } else if (f9 <= width2 || f9 >= width4) {
                    f8 = ((SwipeDismissBehaviour) this.f40218c).f40210r;
                } else {
                    f8 = MathUtils.a(1.0f - (f9 < width ? SwipeDismissBehaviour.f40192t.a(width, width2, f9) : SwipeDismissBehaviour.f40192t.a(width3, width4, f9)), ((SwipeDismissBehaviour) this.f40218c).f40210r, 1.0f);
                }
                view.setAlpha(f8);
            }
            i9 = RangesKt___RangesKt.i(Math.abs(i8) / view.getWidth(), 0.0f, 1.0f);
            b Y = this.f40218c.Y();
            if (Y != null) {
                Y.f(i9);
            }
        }

        private final boolean q(int i8) {
            return !this.f40218c.U() ? !this.f40218c.S() || i8 >= 0 : i8 <= 0;
        }

        private final int r() {
            Integer num = this.f40216a;
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }

        private final int s(View view, float f8) {
            int r7 = r();
            if (this.f40218c.b0() && v(view, f8)) {
                int top = view.getTop();
                int height = view.getHeight();
                return top < r7 ? r7 - height : r7 + height;
            }
            return r7;
        }

        private final void t(View view, int i8) {
            float i9;
            if (this.f40218c.O()) {
                float r7 = r();
                float height = r7 - (view.getHeight() * ((SwipeDismissBehaviour) this.f40218c).f40208p);
                float height2 = r7 - (view.getHeight() * ((SwipeDismissBehaviour) this.f40218c).f40209q);
                float f8 = i8;
                view.setAlpha((f8 < height || f8 > (((float) view.getHeight()) * ((SwipeDismissBehaviour) this.f40218c).f40208p) + r7) ? (f8 <= height2 || f8 >= r7 + (((float) view.getHeight()) * ((SwipeDismissBehaviour) this.f40218c).f40209q)) ? ((SwipeDismissBehaviour) this.f40218c).f40210r : MathUtils.a(1.0f - SwipeDismissBehaviour.f40192t.a(height, height2, f8), ((SwipeDismissBehaviour) this.f40218c).f40210r, 1.0f) : 1.0f);
            }
            i9 = RangesKt___RangesKt.i(Math.abs(i8) / view.getHeight(), 0.0f, 1.0f);
            b Y = this.f40218c.Y();
            if (Y != null) {
                Y.f(i9);
            }
        }

        private final boolean u(View view, float f8) {
            int b8;
            int b9;
            int left = view.getLeft() - n();
            int i8 = (f8 > 0.0f ? 1 : (f8 == 0.0f ? 0 : -1));
            if (i8 == 0) {
                b9 = MathKt__MathJVMKt.b(view.getWidth() * ((SwipeDismissBehaviour) this.f40218c).f40206n);
                if (Math.abs(left) >= b9 && q(left)) {
                    return true;
                }
            } else {
                b8 = MathKt__MathJVMKt.b(view.getWidth() * ((SwipeDismissBehaviour) this.f40218c).f40207o);
                if (Math.abs(left) >= b8) {
                    if (this.f40218c.I()) {
                        return true;
                    }
                    if (this.f40218c.U()) {
                        if (uq.Z(view)) {
                            if (i8 < 0) {
                                return true;
                            }
                        } else if (f8 > 0.0f) {
                            return true;
                        }
                    } else if (this.f40218c.S()) {
                        if (uq.Z(view)) {
                            if (f8 > 0.0f) {
                                return true;
                            }
                        } else if (i8 < 0) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        private final boolean v(View view, float f8) {
            int b8;
            int i8 = (f8 > 0.0f ? 1 : (f8 == 0.0f ? 0 : -1));
            if (i8 == 0) {
                int top = view.getTop() - r();
                b8 = MathKt__MathJVMKt.b(view.getHeight() * ((SwipeDismissBehaviour) this.f40218c).f40206n);
                if (Math.abs(top) >= b8) {
                    return true;
                }
            } else if (this.f40218c.L()) {
                return true;
            } else {
                if (this.f40218c.W()) {
                    if (i8 < 0) {
                        return true;
                    }
                } else if (this.f40218c.Q() && f8 > 0.0f) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int a(View child, int i8, int i9) {
            Intrinsics.f(child, "child");
            return this.f40218c.b0() ? child.getLeft() : MathUtils.b(i8, n() - child.getWidth(), n() + child.getWidth());
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int b(View child, int i8, int i9) {
            Intrinsics.f(child, "child");
            if (this.f40218c.b0()) {
                return MathUtils.b(i8, this.f40218c.W() ? r() - child.getHeight() : r(), this.f40218c.Q() ? r() + child.getHeight() : r());
            }
            return child.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int d(View child) {
            Intrinsics.f(child, "child");
            return child.getWidth();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int e(View child) {
            Intrinsics.f(child, "child");
            return child.getHeight();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void i(View capturedChild, int i8) {
            Intrinsics.f(capturedChild, "capturedChild");
            if (this.f40216a == null) {
                this.f40216a = Integer.valueOf(capturedChild.getTop());
            }
            if (this.f40217b == null) {
                this.f40217b = Integer.valueOf(capturedChild.getLeft());
            }
            ((SwipeDismissBehaviour) this.f40218c).f40205m = true;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void j(int i8) {
            b Y = this.f40218c.Y();
            if (Y != null) {
                Y.d(i8);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void k(View child, int i8, int i9, int i10, int i11) {
            Intrinsics.f(child, "child");
            if (this.f40218c.b0()) {
                t(child, i9);
            } else {
                p(child, i8);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void l(View child, float f8, float f9) {
            b Y;
            Intrinsics.f(child, "child");
            int s7 = s(child, f9);
            int o8 = o(child, f8);
            boolean z7 = true;
            boolean z8 = (s7 == r() && o8 == n()) ? false : true;
            ViewDragHelper viewDragHelper = ((SwipeDismissBehaviour) this.f40218c).f40200h;
            if ((viewDragHelper == null || !viewDragHelper.M(o8, s7)) ? false : false) {
                ViewCompat.k0(child, new c(child, z8, ((SwipeDismissBehaviour) this.f40218c).f40200h, this.f40218c.Y()));
            } else if (z8 && (Y = this.f40218c.Y()) != null) {
                Y.e(child);
            }
            ((SwipeDismissBehaviour) this.f40218c).f40205m = false;
            this.f40216a = null;
            this.f40217b = null;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean m(View child, int i8) {
            Intrinsics.f(child, "child");
            return this.f40218c.J(child);
        }
    }

    public SwipeDismissBehaviour() {
        this(false, false, false, false, false, 31, null);
    }

    public SwipeDismissBehaviour(boolean z7, boolean z8, boolean z9, boolean z10, boolean z11) {
        this.f40193a = z7;
        this.f40194b = z8;
        this.f40195c = z9;
        this.f40196d = z10;
        this.f40197e = z11;
        this.f40199g = new PointF();
        this.f40203k = 1.0f;
        this.f40206n = 0.5f;
        this.f40207o = 0.25f;
        this.f40209q = 0.5f;
        this.f40211s = new d(this);
    }

    public /* synthetic */ SwipeDismissBehaviour(boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? true : z7, (i8 & 2) != 0 ? true : z8, (i8 & 4) != 0 ? true : z9, (i8 & 8) != 0 ? false : z10, (i8 & 16) != 0 ? true : z11);
    }

    private final void E(ViewGroup viewGroup) {
        if (this.f40200h == null) {
            this.f40200h = ViewDragHelper.n(viewGroup, this.f40203k, this.f40211s);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean I() {
        return this.f40194b && this.f40195c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean L() {
        return this.f40193a && this.f40196d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean b0() {
        return L() || this.f40201i;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean D(CoordinatorLayout parent, V child, MotionEvent event) {
        Intrinsics.f(parent, "parent");
        Intrinsics.f(child, "child");
        Intrinsics.f(event, "event");
        ViewDragHelper viewDragHelper = this.f40200h;
        if (viewDragHelper != null) {
            viewDragHelper.F(event);
            return true;
        }
        return false;
    }

    public final void F(b bVar) {
        this.f40198f = bVar;
    }

    public final void H(boolean z7) {
        this.f40204l = z7;
    }

    public final boolean J(View view) {
        Intrinsics.f(view, "view");
        if (!this.f40204l && !Z()) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.d(layoutParams, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
            if (Intrinsics.a(((CoordinatorLayout.LayoutParams) layoutParams).f(), this)) {
                return true;
            }
        }
        return false;
    }

    public final boolean O() {
        return this.f40197e;
    }

    public final boolean Q() {
        return this.f40196d;
    }

    public final boolean S() {
        return this.f40195c;
    }

    public final boolean U() {
        return this.f40194b;
    }

    public final boolean W() {
        return this.f40193a;
    }

    public final b Y() {
        return this.f40198f;
    }

    public final boolean Z() {
        if (!this.f40205m) {
            ViewDragHelper viewDragHelper = this.f40200h;
            if (!(viewDragHelper != null && viewDragHelper.m(true))) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean k(CoordinatorLayout parent, V child, MotionEvent event) {
        Intrinsics.f(parent, "parent");
        Intrinsics.f(child, "child");
        Intrinsics.f(event, "event");
        int action = event.getAction();
        if (action == 1 || action == 3) {
            this.f40199g.set(0.0f, 0.0f);
            if (this.f40202j) {
                this.f40202j = false;
                return false;
            }
        } else {
            if (event.getAction() == 0) {
                this.f40199g.set(event.getX(), event.getY());
            }
            this.f40202j = !parent.C(child, (int) event.getX(), (int) event.getY());
        }
        if (this.f40202j) {
            return false;
        }
        this.f40201i = Math.abs(event.getX() - this.f40199g.x) < Math.abs(event.getY() - this.f40199g.y);
        E(parent);
        ViewDragHelper viewDragHelper = this.f40200h;
        if (viewDragHelper != null) {
            return viewDragHelper.N(event);
        }
        return false;
    }
}
