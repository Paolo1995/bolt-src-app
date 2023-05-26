package androidx.drawerlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import java.util.ArrayList;
import java.util.List;
import org.jctools.util.Pow2;

/* loaded from: classes.dex */
public class DrawerLayout extends ViewGroup {
    private static final int[] O = {16843828};
    static final int[] P = {16842931};
    static final boolean Q;
    private static final boolean R;
    private static boolean S;
    private float A;
    private Drawable B;
    private Drawable C;
    private Drawable D;
    private Object E;
    private boolean F;
    private Drawable G;
    private Drawable H;
    private Drawable I;
    private Drawable J;
    private final ArrayList<View> K;
    private Rect L;
    private Matrix M;
    private final AccessibilityViewCommand N;

    /* renamed from: f  reason: collision with root package name */
    private final ChildAccessibilityDelegate f6210f;

    /* renamed from: g  reason: collision with root package name */
    private float f6211g;

    /* renamed from: h  reason: collision with root package name */
    private int f6212h;

    /* renamed from: i  reason: collision with root package name */
    private int f6213i;

    /* renamed from: j  reason: collision with root package name */
    private float f6214j;

    /* renamed from: k  reason: collision with root package name */
    private Paint f6215k;

    /* renamed from: l  reason: collision with root package name */
    private final ViewDragHelper f6216l;

    /* renamed from: m  reason: collision with root package name */
    private final ViewDragHelper f6217m;

    /* renamed from: n  reason: collision with root package name */
    private final ViewDragCallback f6218n;

    /* renamed from: o  reason: collision with root package name */
    private final ViewDragCallback f6219o;

    /* renamed from: p  reason: collision with root package name */
    private int f6220p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f6221q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f6222r;

    /* renamed from: s  reason: collision with root package name */
    private int f6223s;

    /* renamed from: t  reason: collision with root package name */
    private int f6224t;

    /* renamed from: u  reason: collision with root package name */
    private int f6225u;

    /* renamed from: v  reason: collision with root package name */
    private int f6226v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f6227w;

    /* renamed from: x  reason: collision with root package name */
    private DrawerListener f6228x;

    /* renamed from: y  reason: collision with root package name */
    private List<DrawerListener> f6229y;

    /* renamed from: z  reason: collision with root package name */
    private float f6230z;

    /* loaded from: classes.dex */
    static final class ChildAccessibilityDelegate extends AccessibilityDelegateCompat {
        ChildAccessibilityDelegate() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.g(view, accessibilityNodeInfoCompat);
            if (!DrawerLayout.w(view)) {
                accessibilityNodeInfoCompat.o0(null);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface DrawerListener {
        void a(@NonNull View view);

        void b(@NonNull View view);

        void c(int i8);

        void d(@NonNull View view, float f8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ViewDragCallback extends ViewDragHelper.Callback {

        /* renamed from: a  reason: collision with root package name */
        private final int f6240a;

        /* renamed from: b  reason: collision with root package name */
        private ViewDragHelper f6241b;

        /* renamed from: c  reason: collision with root package name */
        private final Runnable f6242c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ DrawerLayout f6243d;

        private void n() {
            int i8 = 3;
            if (this.f6240a == 3) {
                i8 = 5;
            }
            View k8 = this.f6243d.k(i8);
            if (k8 != null) {
                this.f6243d.c(k8);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int a(View view, int i8, int i9) {
            if (this.f6243d.b(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i8, 0));
            }
            int width = this.f6243d.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i8, width));
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int b(View view, int i8, int i9) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int d(View view) {
            if (this.f6243d.z(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void f(int i8, int i9) {
            View k8;
            if ((i8 & 1) == 1) {
                k8 = this.f6243d.k(3);
            } else {
                k8 = this.f6243d.k(5);
            }
            if (k8 != null && this.f6243d.o(k8) == 0) {
                this.f6241b.b(k8, i9);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean g(int i8) {
            return false;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void h(int i8, int i9) {
            this.f6243d.postDelayed(this.f6242c, 160L);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void i(View view, int i8) {
            ((LayoutParams) view.getLayoutParams()).f6233c = false;
            n();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void j(int i8) {
            this.f6243d.O(i8, this.f6241b.v());
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void k(View view, int i8, int i9, int i10, int i11) {
            float width;
            int i12;
            int width2 = view.getWidth();
            if (this.f6243d.b(view, 3)) {
                width = i8 + width2;
            } else {
                width = this.f6243d.getWidth() - i8;
            }
            float f8 = width / width2;
            this.f6243d.L(view, f8);
            if (f8 == 0.0f) {
                i12 = 4;
            } else {
                i12 = 0;
            }
            view.setVisibility(i12);
            this.f6243d.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void l(View view, float f8, float f9) {
            int i8;
            float q8 = this.f6243d.q(view);
            int width = view.getWidth();
            if (this.f6243d.b(view, 3)) {
                int i9 = (f8 > 0.0f ? 1 : (f8 == 0.0f ? 0 : -1));
                if (i9 <= 0 && (i9 != 0 || q8 <= 0.5f)) {
                    i8 = -width;
                } else {
                    i8 = 0;
                }
            } else {
                int width2 = this.f6243d.getWidth();
                if (f8 < 0.0f || (f8 == 0.0f && q8 > 0.5f)) {
                    width2 -= width;
                }
                i8 = width2;
            }
            this.f6241b.M(i8, view.getTop());
            this.f6243d.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean m(View view, int i8) {
            if (this.f6243d.z(view) && this.f6243d.b(view, this.f6240a) && this.f6243d.o(view) == 0) {
                return true;
            }
            return false;
        }

        public void o() {
            this.f6243d.removeCallbacks(this.f6242c);
        }
    }

    static {
        boolean z7 = true;
        int i8 = Build.VERSION.SDK_INT;
        Q = true;
        R = true;
        if (i8 < 29) {
            z7 = false;
        }
        S = z7;
    }

    private boolean B(float f8, float f9, View view) {
        if (this.L == null) {
            this.L = new Rect();
        }
        view.getHitRect(this.L);
        return this.L.contains((int) f8, (int) f9);
    }

    private void C(Drawable drawable, int i8) {
        if (drawable != null && DrawableCompat.h(drawable)) {
            DrawableCompat.m(drawable, i8);
        }
    }

    private Drawable H() {
        int E = ViewCompat.E(this);
        if (E == 0) {
            Drawable drawable = this.G;
            if (drawable != null) {
                C(drawable, E);
                return this.G;
            }
        } else {
            Drawable drawable2 = this.H;
            if (drawable2 != null) {
                C(drawable2, E);
                return this.H;
            }
        }
        return this.I;
    }

    private Drawable I() {
        int E = ViewCompat.E(this);
        if (E == 0) {
            Drawable drawable = this.H;
            if (drawable != null) {
                C(drawable, E);
                return this.H;
            }
        } else {
            Drawable drawable2 = this.G;
            if (drawable2 != null) {
                C(drawable2, E);
                return this.G;
            }
        }
        return this.J;
    }

    private void J() {
        if (R) {
            return;
        }
        this.C = H();
        this.D = I();
    }

    private void M(View view) {
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.f6061y;
        ViewCompat.m0(view, accessibilityActionCompat.b());
        if (y(view) && o(view) != 2) {
            ViewCompat.o0(view, accessibilityActionCompat, null, this.N);
        }
    }

    private void N(View view, boolean z7) {
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if ((!z7 && !z(childAt)) || (z7 && childAt == view)) {
                ViewCompat.D0(childAt, 1);
            } else {
                ViewCompat.D0(childAt, 4);
            }
        }
    }

    private boolean j(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent r7 = r(motionEvent, view);
            boolean dispatchGenericMotionEvent = view.dispatchGenericMotionEvent(r7);
            r7.recycle();
            return dispatchGenericMotionEvent;
        }
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean dispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return dispatchGenericMotionEvent2;
    }

    private MotionEvent r(MotionEvent motionEvent, View view) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(getScrollX() - view.getLeft(), getScrollY() - view.getTop());
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.M == null) {
                this.M = new Matrix();
            }
            matrix.invert(this.M);
            obtain.transform(this.M);
        }
        return obtain;
    }

    static String s(int i8) {
        if ((i8 & 3) == 3) {
            return "LEFT";
        }
        if ((i8 & 5) == 5) {
            return "RIGHT";
        }
        return Integer.toHexString(i8);
    }

    private static boolean t(View view) {
        Drawable background = view.getBackground();
        if (background == null || background.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    private boolean u() {
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            if (((LayoutParams) getChildAt(i8).getLayoutParams()).f6233c) {
                return true;
            }
        }
        return false;
    }

    private boolean v() {
        if (m() != null) {
            return true;
        }
        return false;
    }

    static boolean w(View view) {
        if (ViewCompat.C(view) != 4 && ViewCompat.C(view) != 2) {
            return true;
        }
        return false;
    }

    public boolean A(@NonNull View view) {
        if (z(view)) {
            if (((LayoutParams) view.getLayoutParams()).f6232b > 0.0f) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    void D(View view, float f8) {
        float q8 = q(view);
        float width = view.getWidth();
        int i8 = ((int) (width * f8)) - ((int) (q8 * width));
        if (!b(view, 3)) {
            i8 = -i8;
        }
        view.offsetLeftAndRight(i8);
        L(view, f8);
    }

    public void E(@NonNull View view) {
        F(view, true);
    }

    public void F(@NonNull View view, boolean z7) {
        if (z(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.f6222r) {
                layoutParams.f6232b = 1.0f;
                layoutParams.f6234d = 1;
                N(view, true);
                M(view);
            } else if (z7) {
                layoutParams.f6234d |= 2;
                if (b(view, 3)) {
                    this.f6216l.O(view, 0, view.getTop());
                } else {
                    this.f6217m.O(view, getWidth() - view.getWidth(), view.getTop());
                }
            } else {
                D(view, 1.0f);
                O(0, view);
                view.setVisibility(0);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void G(@NonNull DrawerListener drawerListener) {
        List<DrawerListener> list;
        if (drawerListener == null || (list = this.f6229y) == null) {
            return;
        }
        list.remove(drawerListener);
    }

    public void K(int i8, int i9) {
        View k8;
        ViewDragHelper viewDragHelper;
        int b8 = GravityCompat.b(i9, ViewCompat.E(this));
        if (i9 != 3) {
            if (i9 != 5) {
                if (i9 != 8388611) {
                    if (i9 == 8388613) {
                        this.f6226v = i8;
                    }
                } else {
                    this.f6225u = i8;
                }
            } else {
                this.f6224t = i8;
            }
        } else {
            this.f6223s = i8;
        }
        if (i8 != 0) {
            if (b8 == 3) {
                viewDragHelper = this.f6216l;
            } else {
                viewDragHelper = this.f6217m;
            }
            viewDragHelper.a();
        }
        if (i8 != 1) {
            if (i8 == 2 && (k8 = k(b8)) != null) {
                E(k8);
                return;
            }
            return;
        }
        View k9 = k(b8);
        if (k9 != null) {
            c(k9);
        }
    }

    void L(View view, float f8) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f8 == layoutParams.f6232b) {
            return;
        }
        layoutParams.f6232b = f8;
        i(view, f8);
    }

    void O(int i8, View view) {
        int A = this.f6216l.A();
        int A2 = this.f6217m.A();
        int i9 = 2;
        if (A != 1 && A2 != 1) {
            if (A != 2 && A2 != 2) {
                i9 = 0;
            }
        } else {
            i9 = 1;
        }
        if (view != null && i8 == 0) {
            float f8 = ((LayoutParams) view.getLayoutParams()).f6232b;
            if (f8 == 0.0f) {
                g(view);
            } else if (f8 == 1.0f) {
                h(view);
            }
        }
        if (i9 != this.f6220p) {
            this.f6220p = i9;
            List<DrawerListener> list = this.f6229y;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f6229y.get(size).c(i9);
                }
            }
        }
    }

    public void a(@NonNull DrawerListener drawerListener) {
        if (drawerListener == null) {
            return;
        }
        if (this.f6229y == null) {
            this.f6229y = new ArrayList();
        }
        this.f6229y.add(drawerListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i8, int i9) {
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        boolean z7 = false;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (z(childAt)) {
                if (y(childAt)) {
                    childAt.addFocusables(arrayList, i8, i9);
                    z7 = true;
                }
            } else {
                this.K.add(childAt);
            }
        }
        if (!z7) {
            int size = this.K.size();
            for (int i11 = 0; i11 < size; i11++) {
                View view = this.K.get(i11);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i8, i9);
                }
            }
        }
        this.K.clear();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i8, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i8, layoutParams);
        if (l() == null && !z(view)) {
            ViewCompat.D0(view, 1);
        } else {
            ViewCompat.D0(view, 4);
        }
        if (!Q) {
            ViewCompat.s0(view, this.f6210f);
        }
    }

    boolean b(View view, int i8) {
        if ((p(view) & i8) == i8) {
            return true;
        }
        return false;
    }

    public void c(@NonNull View view) {
        d(view, true);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float f8 = 0.0f;
        for (int i8 = 0; i8 < childCount; i8++) {
            f8 = Math.max(f8, ((LayoutParams) getChildAt(i8).getLayoutParams()).f6232b);
        }
        this.f6214j = f8;
        boolean m8 = this.f6216l.m(true);
        boolean m9 = this.f6217m.m(true);
        if (m8 || m9) {
            ViewCompat.j0(this);
        }
    }

    public void d(@NonNull View view, boolean z7) {
        if (z(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.f6222r) {
                layoutParams.f6232b = 0.0f;
                layoutParams.f6234d = 0;
            } else if (z7) {
                layoutParams.f6234d |= 4;
                if (b(view, 3)) {
                    this.f6216l.O(view, -view.getWidth(), view.getTop());
                } else {
                    this.f6217m.O(view, getWidth(), view.getTop());
                }
            } else {
                D(view, 0.0f);
                O(0, view);
                view.setVisibility(4);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() != 10 && this.f6214j > 0.0f) {
            int childCount = getChildCount();
            if (childCount != 0) {
                float x7 = motionEvent.getX();
                float y7 = motionEvent.getY();
                for (int i8 = childCount - 1; i8 >= 0; i8--) {
                    View childAt = getChildAt(i8);
                    if (B(x7, y7, childAt) && !x(childAt) && j(motionEvent, childAt)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j8) {
        int height = getHeight();
        boolean x7 = x(view);
        int width = getWidth();
        int save = canvas.save();
        int i8 = 0;
        if (x7) {
            int childCount = getChildCount();
            int i9 = 0;
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = getChildAt(i10);
                if (childAt != view && childAt.getVisibility() == 0 && t(childAt) && z(childAt) && childAt.getHeight() >= height) {
                    if (b(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i9) {
                            i9 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i9, 0, width, getHeight());
            i8 = i9;
        }
        boolean drawChild = super.drawChild(canvas, view, j8);
        canvas.restoreToCount(save);
        float f8 = this.f6214j;
        if (f8 > 0.0f && x7) {
            int i11 = this.f6213i;
            this.f6215k.setColor((i11 & 16777215) | (((int) ((((-16777216) & i11) >>> 24) * f8)) << 24));
            canvas.drawRect(i8, 0.0f, width, getHeight(), this.f6215k);
        } else if (this.C != null && b(view, 3)) {
            int intrinsicWidth = this.C.getIntrinsicWidth();
            int right2 = view.getRight();
            float max = Math.max(0.0f, Math.min(right2 / this.f6216l.x(), 1.0f));
            this.C.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.C.setAlpha((int) (max * 255.0f));
            this.C.draw(canvas);
        } else if (this.D != null && b(view, 5)) {
            int intrinsicWidth2 = this.D.getIntrinsicWidth();
            int left2 = view.getLeft();
            float max2 = Math.max(0.0f, Math.min((getWidth() - left2) / this.f6217m.x(), 1.0f));
            this.D.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.D.setAlpha((int) (max2 * 255.0f));
            this.D.draw(canvas);
        }
        return drawChild;
    }

    public void e() {
        f(false);
    }

    void f(boolean z7) {
        boolean O2;
        int childCount = getChildCount();
        boolean z8 = false;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (z(childAt) && (!z7 || layoutParams.f6233c)) {
                int width = childAt.getWidth();
                if (b(childAt, 3)) {
                    O2 = this.f6216l.O(childAt, -width, childAt.getTop());
                } else {
                    O2 = this.f6217m.O(childAt, getWidth(), childAt.getTop());
                }
                z8 |= O2;
                layoutParams.f6233c = false;
            }
        }
        this.f6218n.o();
        this.f6219o.o();
        if (z8) {
            invalidate();
        }
    }

    void g(View view) {
        View rootView;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.f6234d & 1) == 1) {
            layoutParams.f6234d = 0;
            List<DrawerListener> list = this.f6229y;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f6229y.get(size).b(view);
                }
            }
            N(view, false);
            M(view);
            if (hasWindowFocus() && (rootView = getRootView()) != null) {
                rootView.sendAccessibilityEvent(32);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public float getDrawerElevation() {
        if (R) {
            return this.f6211g;
        }
        return 0.0f;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.B;
    }

    void h(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.f6234d & 1) == 0) {
            layoutParams.f6234d = 1;
            List<DrawerListener> list = this.f6229y;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f6229y.get(size).a(view);
                }
            }
            N(view, true);
            M(view);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    void i(View view, float f8) {
        List<DrawerListener> list = this.f6229y;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f6229y.get(size).d(view, f8);
            }
        }
    }

    View k(int i8) {
        int b8 = GravityCompat.b(i8, ViewCompat.E(this)) & 7;
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if ((p(childAt) & 7) == b8) {
                return childAt;
            }
        }
        return null;
    }

    View l() {
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if ((((LayoutParams) childAt.getLayoutParams()).f6234d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    View m() {
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (z(childAt) && A(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public int n(int i8) {
        int i9;
        int i10;
        int i11;
        int i12;
        int E = ViewCompat.E(this);
        if (i8 != 3) {
            if (i8 != 5) {
                if (i8 != 8388611) {
                    if (i8 == 8388613) {
                        int i13 = this.f6226v;
                        if (i13 != 3) {
                            return i13;
                        }
                        if (E == 0) {
                            i12 = this.f6224t;
                        } else {
                            i12 = this.f6223s;
                        }
                        if (i12 != 3) {
                            return i12;
                        }
                        return 0;
                    }
                    return 0;
                }
                int i14 = this.f6225u;
                if (i14 != 3) {
                    return i14;
                }
                if (E == 0) {
                    i11 = this.f6223s;
                } else {
                    i11 = this.f6224t;
                }
                if (i11 != 3) {
                    return i11;
                }
                return 0;
            }
            int i15 = this.f6224t;
            if (i15 != 3) {
                return i15;
            }
            if (E == 0) {
                i10 = this.f6226v;
            } else {
                i10 = this.f6225u;
            }
            if (i10 != 3) {
                return i10;
            }
            return 0;
        }
        int i16 = this.f6223s;
        if (i16 != 3) {
            return i16;
        }
        if (E == 0) {
            i9 = this.f6225u;
        } else {
            i9 = this.f6226v;
        }
        if (i9 != 3) {
            return i9;
        }
        return 0;
    }

    public int o(@NonNull View view) {
        if (z(view)) {
            return n(((LayoutParams) view.getLayoutParams()).f6231a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f6222r = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f6222r = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i8;
        super.onDraw(canvas);
        if (this.F && this.B != null) {
            Object obj = this.E;
            if (obj != null) {
                i8 = ((WindowInsets) obj).getSystemWindowInsetTop();
            } else {
                i8 = 0;
            }
            if (i8 > 0) {
                this.B.setBounds(0, 0, getWidth(), i8);
                this.B.draw(canvas);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001b, code lost:
        if (r0 != 3) goto L7;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getActionMasked()
            androidx.customview.widget.ViewDragHelper r1 = r6.f6216l
            boolean r1 = r1.N(r7)
            androidx.customview.widget.ViewDragHelper r2 = r6.f6217m
            boolean r2 = r2.N(r7)
            r1 = r1 | r2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L38
            if (r0 == r2) goto L31
            r7 = 2
            r4 = 3
            if (r0 == r7) goto L1e
            if (r0 == r4) goto L31
            goto L36
        L1e:
            androidx.customview.widget.ViewDragHelper r7 = r6.f6216l
            boolean r7 = r7.d(r4)
            if (r7 == 0) goto L36
            androidx.drawerlayout.widget.DrawerLayout$ViewDragCallback r7 = r6.f6218n
            r7.o()
            androidx.drawerlayout.widget.DrawerLayout$ViewDragCallback r7 = r6.f6219o
            r7.o()
            goto L36
        L31:
            r6.f(r2)
            r6.f6227w = r3
        L36:
            r7 = 0
            goto L60
        L38:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.f6230z = r0
            r6.A = r7
            float r4 = r6.f6214j
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L5d
            androidx.customview.widget.ViewDragHelper r4 = r6.f6216l
            int r0 = (int) r0
            int r7 = (int) r7
            android.view.View r7 = r4.t(r0, r7)
            if (r7 == 0) goto L5d
            boolean r7 = r6.x(r7)
            if (r7 == 0) goto L5d
            r7 = 1
            goto L5e
        L5d:
            r7 = 0
        L5e:
            r6.f6227w = r3
        L60:
            if (r1 != 0) goto L70
            if (r7 != 0) goto L70
            boolean r7 = r6.u()
            if (r7 != 0) goto L70
            boolean r7 = r6.f6227w
            if (r7 == 0) goto L6f
            goto L70
        L6f:
            r2 = 0
        L70:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i8, KeyEvent keyEvent) {
        if (i8 == 4 && v()) {
            keyEvent.startTracking();
            return true;
        }
        return super.onKeyDown(i8, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i8, KeyEvent keyEvent) {
        if (i8 == 4) {
            View m8 = m();
            if (m8 != null && o(m8) == 0) {
                e();
            }
            if (m8 != null) {
                return true;
            }
            return false;
        }
        return super.onKeyUp(i8, keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        WindowInsets rootWindowInsets;
        int i12;
        float f8;
        int i13;
        boolean z8;
        int i14;
        this.f6221q = true;
        int i15 = i10 - i8;
        int childCount = getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (x(childAt)) {
                    int i17 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    childAt.layout(i17, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, childAt.getMeasuredWidth() + i17, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (b(childAt, 3)) {
                        float f9 = measuredWidth;
                        i13 = (-measuredWidth) + ((int) (layoutParams.f6232b * f9));
                        f8 = (measuredWidth + i13) / f9;
                    } else {
                        float f10 = measuredWidth;
                        f8 = (i15 - i12) / f10;
                        i13 = i15 - ((int) (layoutParams.f6232b * f10));
                    }
                    if (f8 != layoutParams.f6232b) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    int i18 = layoutParams.f6231a & 112;
                    if (i18 != 16) {
                        if (i18 != 80) {
                            int i19 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                            childAt.layout(i13, i19, measuredWidth + i13, measuredHeight + i19);
                        } else {
                            int i20 = i11 - i9;
                            childAt.layout(i13, (i20 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i13, i20 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                        }
                    } else {
                        int i21 = i11 - i9;
                        int i22 = (i21 - measuredHeight) / 2;
                        int i23 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        if (i22 < i23) {
                            i22 = i23;
                        } else {
                            int i24 = i22 + measuredHeight;
                            int i25 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                            if (i24 > i21 - i25) {
                                i22 = (i21 - i25) - measuredHeight;
                            }
                        }
                        childAt.layout(i13, i22, measuredWidth + i13, measuredHeight + i22);
                    }
                    if (z8) {
                        L(childAt, f8);
                    }
                    if (layoutParams.f6232b > 0.0f) {
                        i14 = 0;
                    } else {
                        i14 = 4;
                    }
                    if (childAt.getVisibility() != i14) {
                        childAt.setVisibility(i14);
                    }
                }
            }
        }
        if (S && (rootWindowInsets = getRootWindowInsets()) != null) {
            Insets h8 = WindowInsetsCompat.v(rootWindowInsets).h();
            ViewDragHelper viewDragHelper = this.f6216l;
            viewDragHelper.L(Math.max(viewDragHelper.w(), h8.f5737a));
            ViewDragHelper viewDragHelper2 = this.f6217m;
            viewDragHelper2.L(Math.max(viewDragHelper2.w(), h8.f5739c));
        }
        this.f6221q = false;
        this.f6222r = false;
    }

    @Override // android.view.View
    @SuppressLint({"WrongConstant"})
    protected void onMeasure(int i8, int i9) {
        boolean z7;
        boolean z8;
        int mode = View.MeasureSpec.getMode(i8);
        int mode2 = View.MeasureSpec.getMode(i9);
        int size = View.MeasureSpec.getSize(i8);
        int size2 = View.MeasureSpec.getSize(i9);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (isInEditMode()) {
                if (mode == 0) {
                    size = 300;
                }
                if (mode2 == 0) {
                    size2 = 300;
                }
            } else {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
        }
        setMeasuredDimension(size, size2);
        int i10 = 0;
        if (this.E != null && ViewCompat.B(this)) {
            z7 = true;
        } else {
            z7 = false;
        }
        int E = ViewCompat.E(this);
        int childCount = getChildCount();
        int i11 = 0;
        boolean z9 = false;
        boolean z10 = false;
        while (i11 < childCount) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (z7) {
                    int b8 = GravityCompat.b(layoutParams.f6231a, E);
                    if (ViewCompat.B(childAt)) {
                        WindowInsets windowInsets = (WindowInsets) this.E;
                        if (b8 == 3) {
                            windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), i10, windowInsets.getSystemWindowInsetBottom());
                        } else if (b8 == 5) {
                            windowInsets = windowInsets.replaceSystemWindowInsets(i10, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                        }
                        childAt.dispatchApplyWindowInsets(windowInsets);
                    } else {
                        WindowInsets windowInsets2 = (WindowInsets) this.E;
                        if (b8 == 3) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(windowInsets2.getSystemWindowInsetLeft(), windowInsets2.getSystemWindowInsetTop(), i10, windowInsets2.getSystemWindowInsetBottom());
                        } else if (b8 == 5) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(i10, windowInsets2.getSystemWindowInsetTop(), windowInsets2.getSystemWindowInsetRight(), windowInsets2.getSystemWindowInsetBottom());
                        }
                        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = windowInsets2.getSystemWindowInsetLeft();
                        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = windowInsets2.getSystemWindowInsetTop();
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = windowInsets2.getSystemWindowInsetRight();
                        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = windowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (x(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, Pow2.MAX_POW2), View.MeasureSpec.makeMeasureSpec((size2 - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, Pow2.MAX_POW2));
                } else if (z(childAt)) {
                    if (R) {
                        float y7 = ViewCompat.y(childAt);
                        float f8 = this.f6211g;
                        if (y7 != f8) {
                            ViewCompat.A0(childAt, f8);
                        }
                    }
                    int p8 = p(childAt) & 7;
                    if (p8 == 3) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if ((z8 && z9) || (!z8 && z10)) {
                        throw new IllegalStateException("Child drawer has absolute gravity " + s(p8) + " but this DrawerLayout already has a drawer view along that edge");
                    }
                    if (z8) {
                        z9 = true;
                    } else {
                        z10 = true;
                    }
                    childAt.measure(ViewGroup.getChildMeasureSpec(i8, this.f6212h + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, ((ViewGroup.MarginLayoutParams) layoutParams).width), ViewGroup.getChildMeasureSpec(i9, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, ((ViewGroup.MarginLayoutParams) layoutParams).height));
                    i11++;
                    i10 = 0;
                } else {
                    throw new IllegalStateException("Child " + childAt + " at index " + i11 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                }
            }
            i11++;
            i10 = 0;
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        View k8;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        int i8 = savedState.f6235h;
        if (i8 != 0 && (k8 = k(i8)) != null) {
            E(k8);
        }
        int i9 = savedState.f6236i;
        if (i9 != 3) {
            K(i9, 3);
        }
        int i10 = savedState.f6237j;
        if (i10 != 3) {
            K(i10, 5);
        }
        int i11 = savedState.f6238k;
        if (i11 != 3) {
            K(i11, 8388611);
        }
        int i12 = savedState.f6239l;
        if (i12 != 3) {
            K(i12, 8388613);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i8) {
        J();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        boolean z7;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i8).getLayoutParams();
            int i9 = layoutParams.f6234d;
            boolean z8 = true;
            if (i9 == 1) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (i9 != 2) {
                z8 = false;
            }
            if (z7 || z8) {
                savedState.f6235h = layoutParams.f6231a;
                break;
            }
        }
        savedState.f6236i = this.f6223s;
        savedState.f6237j = this.f6224t;
        savedState.f6238k = this.f6225u;
        savedState.f6239l = this.f6226v;
        return savedState;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
        if (o(r7) != 2) goto L19;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            androidx.customview.widget.ViewDragHelper r0 = r6.f6216l
            r0.F(r7)
            androidx.customview.widget.ViewDragHelper r0 = r6.f6217m
            r0.F(r7)
            int r0 = r7.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L62
            if (r0 == r2) goto L20
            r7 = 3
            if (r0 == r7) goto L1a
            goto L70
        L1a:
            r6.f(r2)
            r6.f6227w = r1
            goto L70
        L20:
            float r0 = r7.getX()
            float r7 = r7.getY()
            androidx.customview.widget.ViewDragHelper r3 = r6.f6216l
            int r4 = (int) r0
            int r5 = (int) r7
            android.view.View r3 = r3.t(r4, r5)
            if (r3 == 0) goto L5d
            boolean r3 = r6.x(r3)
            if (r3 == 0) goto L5d
            float r3 = r6.f6230z
            float r0 = r0 - r3
            float r3 = r6.A
            float r7 = r7 - r3
            androidx.customview.widget.ViewDragHelper r3 = r6.f6216l
            int r3 = r3.z()
            float r0 = r0 * r0
            float r7 = r7 * r7
            float r0 = r0 + r7
            int r3 = r3 * r3
            float r7 = (float) r3
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 >= 0) goto L5d
            android.view.View r7 = r6.l()
            if (r7 == 0) goto L5d
            int r7 = r6.o(r7)
            r0 = 2
            if (r7 != r0) goto L5e
        L5d:
            r1 = 1
        L5e:
            r6.f(r1)
            goto L70
        L62:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.f6230z = r0
            r6.A = r7
            r6.f6227w = r1
        L70:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    int p(View view) {
        return GravityCompat.b(((LayoutParams) view.getLayoutParams()).f6231a, ViewCompat.E(this));
    }

    float q(View view) {
        return ((LayoutParams) view.getLayoutParams()).f6232b;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z7) {
        super.requestDisallowInterceptTouchEvent(z7);
        if (z7) {
            f(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.f6221q) {
            super.requestLayout();
        }
    }

    public void setDrawerElevation(float f8) {
        this.f6211g = f8;
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            View childAt = getChildAt(i8);
            if (z(childAt)) {
                ViewCompat.A0(childAt, this.f6211g);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(DrawerListener drawerListener) {
        DrawerListener drawerListener2 = this.f6228x;
        if (drawerListener2 != null) {
            G(drawerListener2);
        }
        if (drawerListener != null) {
            a(drawerListener);
        }
        this.f6228x = drawerListener;
    }

    public void setDrawerLockMode(int i8) {
        K(i8, 3);
        K(i8, 5);
    }

    public void setScrimColor(int i8) {
        this.f6213i = i8;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.B = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i8) {
        this.B = new ColorDrawable(i8);
        invalidate();
    }

    boolean x(View view) {
        if (((LayoutParams) view.getLayoutParams()).f6231a == 0) {
            return true;
        }
        return false;
    }

    public boolean y(@NonNull View view) {
        if (z(view)) {
            if ((((LayoutParams) view.getLayoutParams()).f6234d & 1) == 1) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    boolean z(View view) {
        int b8 = GravityCompat.b(((LayoutParams) view.getLayoutParams()).f6231a, ViewCompat.E(view));
        if ((b8 & 3) != 0 || (b8 & 5) != 0) {
            return true;
        }
        return false;
    }

    public void setStatusBarBackground(int i8) {
        this.B = i8 != 0 ? ContextCompat.getDrawable(getContext(), i8) : null;
        invalidate();
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f6231a;

        /* renamed from: b  reason: collision with root package name */
        float f6232b;

        /* renamed from: c  reason: collision with root package name */
        boolean f6233c;

        /* renamed from: d  reason: collision with root package name */
        int f6234d;

        public LayoutParams(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f6231a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.P);
            this.f6231a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i8, int i9) {
            super(i8, i9);
            this.f6231a = 0;
        }

        public LayoutParams(@NonNull LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.f6231a = 0;
            this.f6231a = layoutParams.f6231a;
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f6231a = 0;
        }

        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f6231a = 0;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.drawerlayout.widget.DrawerLayout.SavedState.1
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
        int f6235h;

        /* renamed from: i  reason: collision with root package name */
        int f6236i;

        /* renamed from: j  reason: collision with root package name */
        int f6237j;

        /* renamed from: k  reason: collision with root package name */
        int f6238k;

        /* renamed from: l  reason: collision with root package name */
        int f6239l;

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f6235h = 0;
            this.f6235h = parcel.readInt();
            this.f6236i = parcel.readInt();
            this.f6237j = parcel.readInt();
            this.f6238k = parcel.readInt();
            this.f6239l = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i8) {
            super.writeToParcel(parcel, i8);
            parcel.writeInt(this.f6235h);
            parcel.writeInt(this.f6236i);
            parcel.writeInt(this.f6237j);
            parcel.writeInt(this.f6238k);
            parcel.writeInt(this.f6239l);
        }

        public SavedState(@NonNull Parcelable parcelable) {
            super(parcelable);
            this.f6235h = 0;
        }
    }
}
