package androidx.customview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.customview.widget.FocusStrategy;
import com.google.android.gms.common.api.Api;
import j$.util.Spliterator;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {

    /* renamed from: n  reason: collision with root package name */
    private static final Rect f6167n = new Rect(Api.BaseClientBuilder.API_PRIORITY_OTHER, Api.BaseClientBuilder.API_PRIORITY_OTHER, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* renamed from: o  reason: collision with root package name */
    private static final FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat> f6168o = new FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat>() { // from class: androidx.customview.widget.ExploreByTouchHelper.1
        @Override // androidx.customview.widget.FocusStrategy.BoundsAdapter
        /* renamed from: b */
        public void a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, Rect rect) {
            accessibilityNodeInfoCompat.l(rect);
        }
    };

    /* renamed from: p  reason: collision with root package name */
    private static final FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> f6169p = new FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat>() { // from class: androidx.customview.widget.ExploreByTouchHelper.2
        @Override // androidx.customview.widget.FocusStrategy.CollectionAdapter
        /* renamed from: b */
        public AccessibilityNodeInfoCompat a(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat, int i8) {
            return sparseArrayCompat.l(i8);
        }

        @Override // androidx.customview.widget.FocusStrategy.CollectionAdapter
        /* renamed from: c */
        public int size(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat) {
            return sparseArrayCompat.k();
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private final AccessibilityManager f6174h;

    /* renamed from: i  reason: collision with root package name */
    private final View f6175i;

    /* renamed from: j  reason: collision with root package name */
    private MyNodeProvider f6176j;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f6170d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    private final Rect f6171e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    private final Rect f6172f = new Rect();

    /* renamed from: g  reason: collision with root package name */
    private final int[] f6173g = new int[2];

    /* renamed from: k  reason: collision with root package name */
    int f6177k = Integer.MIN_VALUE;

    /* renamed from: l  reason: collision with root package name */
    int f6178l = Integer.MIN_VALUE;

    /* renamed from: m  reason: collision with root package name */
    private int f6179m = Integer.MIN_VALUE;

    /* loaded from: classes.dex */
    private class MyNodeProvider extends AccessibilityNodeProviderCompat {
        MyNodeProvider() {
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat b(int i8) {
            return AccessibilityNodeInfoCompat.N(ExploreByTouchHelper.this.H(i8));
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat d(int i8) {
            int i9;
            if (i8 == 2) {
                i9 = ExploreByTouchHelper.this.f6177k;
            } else {
                i9 = ExploreByTouchHelper.this.f6178l;
            }
            if (i9 == Integer.MIN_VALUE) {
                return null;
            }
            return b(i9);
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public boolean f(int i8, int i9, Bundle bundle) {
            return ExploreByTouchHelper.this.P(i8, i9, bundle);
        }
    }

    public ExploreByTouchHelper(@NonNull View view) {
        if (view != null) {
            this.f6175i = view;
            this.f6174h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            if (ViewCompat.C(view) == 0) {
                ViewCompat.D0(view, 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    private static Rect D(@NonNull View view, int i8, @NonNull Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i8 != 17) {
            if (i8 != 33) {
                if (i8 != 66) {
                    if (i8 == 130) {
                        rect.set(0, -1, width, -1);
                    } else {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                } else {
                    rect.set(-1, 0, -1, height);
                }
            } else {
                rect.set(0, height, width, height);
            }
        } else {
            rect.set(width, 0, width, height);
        }
        return rect;
    }

    private boolean E(Rect rect) {
        if (rect == null || rect.isEmpty() || this.f6175i.getWindowVisibility() != 0) {
            return false;
        }
        ViewParent parent = this.f6175i.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        if (parent == null) {
            return false;
        }
        return true;
    }

    private static int F(int i8) {
        if (i8 != 19) {
            if (i8 != 21) {
                return i8 != 22 ? 130 : 66;
            }
            return 17;
        }
        return 33;
    }

    private boolean G(int i8, Rect rect) {
        AccessibilityNodeInfoCompat e8;
        boolean z7;
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat;
        SparseArrayCompat<AccessibilityNodeInfoCompat> y7 = y();
        int i9 = this.f6178l;
        int i10 = Integer.MIN_VALUE;
        if (i9 == Integer.MIN_VALUE) {
            e8 = null;
        } else {
            e8 = y7.e(i9);
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = e8;
        if (i8 != 1 && i8 != 2) {
            if (i8 != 17 && i8 != 33 && i8 != 66 && i8 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            int i11 = this.f6178l;
            if (i11 != Integer.MIN_VALUE) {
                z(i11, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                D(this.f6175i, i8, rect2);
            }
            accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) FocusStrategy.c(y7, f6169p, f6168o, accessibilityNodeInfoCompat2, rect2, i8);
        } else {
            if (ViewCompat.E(this.f6175i) == 1) {
                z7 = true;
            } else {
                z7 = false;
            }
            accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) FocusStrategy.d(y7, f6169p, f6168o, accessibilityNodeInfoCompat2, i8, z7, false);
        }
        if (accessibilityNodeInfoCompat != null) {
            i10 = y7.i(y7.h(accessibilityNodeInfoCompat));
        }
        return T(i10);
    }

    private boolean Q(int i8, int i9, Bundle bundle) {
        if (i9 != 1) {
            if (i9 != 2) {
                if (i9 != 64) {
                    if (i9 != 128) {
                        return J(i8, i9, bundle);
                    }
                    return n(i8);
                }
                return S(i8);
            }
            return o(i8);
        }
        return T(i8);
    }

    private boolean R(int i8, Bundle bundle) {
        return ViewCompat.h0(this.f6175i, i8, bundle);
    }

    private boolean S(int i8) {
        int i9;
        if (!this.f6174h.isEnabled() || !this.f6174h.isTouchExplorationEnabled() || (i9 = this.f6177k) == i8) {
            return false;
        }
        if (i9 != Integer.MIN_VALUE) {
            n(i9);
        }
        this.f6177k = i8;
        this.f6175i.invalidate();
        U(i8, 32768);
        return true;
    }

    private void V(int i8) {
        int i9 = this.f6179m;
        if (i9 == i8) {
            return;
        }
        this.f6179m = i8;
        U(i8, 128);
        U(i9, Spliterator.NONNULL);
    }

    private boolean n(int i8) {
        if (this.f6177k == i8) {
            this.f6177k = Integer.MIN_VALUE;
            this.f6175i.invalidate();
            U(i8, 65536);
            return true;
        }
        return false;
    }

    private boolean p() {
        int i8 = this.f6178l;
        if (i8 != Integer.MIN_VALUE && J(i8, 16, null)) {
            return true;
        }
        return false;
    }

    private AccessibilityEvent q(int i8, int i9) {
        if (i8 != -1) {
            return r(i8, i9);
        }
        return s(i9);
    }

    private AccessibilityEvent r(int i8, int i9) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i9);
        AccessibilityNodeInfoCompat H = H(i8);
        obtain.getText().add(H.v());
        obtain.setContentDescription(H.q());
        obtain.setScrollable(H.I());
        obtain.setPassword(H.H());
        obtain.setEnabled(H.D());
        obtain.setChecked(H.B());
        L(i8, obtain);
        if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        obtain.setClassName(H.o());
        AccessibilityRecordCompat.c(obtain, this.f6175i, i8);
        obtain.setPackageName(this.f6175i.getContext().getPackageName());
        return obtain;
    }

    private AccessibilityEvent s(int i8) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i8);
        this.f6175i.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    @NonNull
    private AccessibilityNodeInfoCompat t(int i8) {
        boolean z7;
        AccessibilityNodeInfoCompat L = AccessibilityNodeInfoCompat.L();
        L.e0(true);
        L.g0(true);
        L.Y("android.view.View");
        Rect rect = f6167n;
        L.U(rect);
        L.V(rect);
        L.o0(this.f6175i);
        N(i8, L);
        if (L.v() == null && L.q() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        L.l(this.f6171e);
        if (!this.f6171e.equals(rect)) {
            int j8 = L.j();
            if ((j8 & 64) == 0) {
                if ((j8 & 128) == 0) {
                    L.m0(this.f6175i.getContext().getPackageName());
                    L.u0(this.f6175i, i8);
                    if (this.f6177k == i8) {
                        L.S(true);
                        L.a(128);
                    } else {
                        L.S(false);
                        L.a(64);
                    }
                    if (this.f6178l == i8) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (z7) {
                        L.a(2);
                    } else if (L.E()) {
                        L.a(1);
                    }
                    L.h0(z7);
                    this.f6175i.getLocationOnScreen(this.f6173g);
                    L.m(this.f6170d);
                    if (this.f6170d.equals(rect)) {
                        L.l(this.f6170d);
                        if (L.f6039b != -1) {
                            AccessibilityNodeInfoCompat L2 = AccessibilityNodeInfoCompat.L();
                            for (int i9 = L.f6039b; i9 != -1; i9 = L2.f6039b) {
                                L2.p0(this.f6175i, -1);
                                L2.U(f6167n);
                                N(i9, L2);
                                L2.l(this.f6171e);
                                Rect rect2 = this.f6170d;
                                Rect rect3 = this.f6171e;
                                rect2.offset(rect3.left, rect3.top);
                            }
                            L2.P();
                        }
                        this.f6170d.offset(this.f6173g[0] - this.f6175i.getScrollX(), this.f6173g[1] - this.f6175i.getScrollY());
                    }
                    if (this.f6175i.getLocalVisibleRect(this.f6172f)) {
                        this.f6172f.offset(this.f6173g[0] - this.f6175i.getScrollX(), this.f6173g[1] - this.f6175i.getScrollY());
                        if (this.f6170d.intersect(this.f6172f)) {
                            L.V(this.f6170d);
                            if (E(this.f6170d)) {
                                L.y0(true);
                            }
                        }
                    }
                    return L;
                }
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    }

    @NonNull
    private AccessibilityNodeInfoCompat u() {
        AccessibilityNodeInfoCompat M = AccessibilityNodeInfoCompat.M(this.f6175i);
        ViewCompat.f0(this.f6175i, M);
        ArrayList arrayList = new ArrayList();
        C(arrayList);
        if (M.n() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i8 = 0; i8 < size; i8++) {
            M.c(this.f6175i, ((Integer) arrayList.get(i8)).intValue());
        }
        return M;
    }

    private SparseArrayCompat<AccessibilityNodeInfoCompat> y() {
        ArrayList arrayList = new ArrayList();
        C(arrayList);
        SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat = new SparseArrayCompat<>();
        for (int i8 = 0; i8 < arrayList.size(); i8++) {
            sparseArrayCompat.j(arrayList.get(i8).intValue(), t(arrayList.get(i8).intValue()));
        }
        return sparseArrayCompat;
    }

    private void z(int i8, Rect rect) {
        H(i8).l(rect);
    }

    public final int A() {
        return this.f6178l;
    }

    protected abstract int B(float f8, float f9);

    protected abstract void C(List<Integer> list);

    @NonNull
    AccessibilityNodeInfoCompat H(int i8) {
        if (i8 == -1) {
            return u();
        }
        return t(i8);
    }

    public final void I(boolean z7, int i8, Rect rect) {
        int i9 = this.f6178l;
        if (i9 != Integer.MIN_VALUE) {
            o(i9);
        }
        if (z7) {
            G(i8, rect);
        }
    }

    protected abstract boolean J(int i8, int i9, Bundle bundle);

    protected void K(@NonNull AccessibilityEvent accessibilityEvent) {
    }

    protected void L(int i8, @NonNull AccessibilityEvent accessibilityEvent) {
    }

    protected void M(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    protected abstract void N(int i8, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    protected void O(int i8, boolean z7) {
    }

    boolean P(int i8, int i9, Bundle bundle) {
        if (i8 != -1) {
            return Q(i8, i9, bundle);
        }
        return R(i9, bundle);
    }

    public final boolean T(int i8) {
        int i9;
        if ((!this.f6175i.isFocused() && !this.f6175i.requestFocus()) || (i9 = this.f6178l) == i8) {
            return false;
        }
        if (i9 != Integer.MIN_VALUE) {
            o(i9);
        }
        if (i8 == Integer.MIN_VALUE) {
            return false;
        }
        this.f6178l = i8;
        O(i8, true);
        U(i8, 8);
        return true;
    }

    public final boolean U(int i8, int i9) {
        ViewParent parent;
        if (i8 == Integer.MIN_VALUE || !this.f6174h.isEnabled() || (parent = this.f6175i.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.f6175i, q(i8, i9));
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat b(View view) {
        if (this.f6176j == null) {
            this.f6176j = new MyNodeProvider();
        }
        return this.f6176j;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        K(accessibilityEvent);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.g(view, accessibilityNodeInfoCompat);
        M(accessibilityNodeInfoCompat);
    }

    public final boolean o(int i8) {
        if (this.f6178l != i8) {
            return false;
        }
        this.f6178l = Integer.MIN_VALUE;
        O(i8, false);
        U(i8, 8);
        return true;
    }

    public final boolean v(@NonNull MotionEvent motionEvent) {
        if (!this.f6174h.isEnabled() || !this.f6174h.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7 && action != 9) {
            if (action != 10 || this.f6179m == Integer.MIN_VALUE) {
                return false;
            }
            V(Integer.MIN_VALUE);
            return true;
        }
        int B = B(motionEvent.getX(), motionEvent.getY());
        V(B);
        if (B == Integer.MIN_VALUE) {
            return false;
        }
        return true;
    }

    public final boolean w(@NonNull KeyEvent keyEvent) {
        int i8 = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 61) {
            if (keyCode != 66) {
                switch (keyCode) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                        if (!keyEvent.hasNoModifiers()) {
                            return false;
                        }
                        int F = F(keyCode);
                        int repeatCount = keyEvent.getRepeatCount() + 1;
                        boolean z7 = false;
                        while (i8 < repeatCount && G(F, null)) {
                            i8++;
                            z7 = true;
                        }
                        return z7;
                    case 23:
                        break;
                    default:
                        return false;
                }
            }
            if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
                return false;
            }
            p();
            return true;
        } else if (keyEvent.hasNoModifiers()) {
            return G(2, null);
        } else {
            if (!keyEvent.hasModifiers(1)) {
                return false;
            }
            return G(1, null);
        }
    }

    public final int x() {
        return this.f6177k;
    }
}
