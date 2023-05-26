package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
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
import android.view.View$OnUnhandledKeyEventListener;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.AttachedBehavior {
    private static final int D = R$style.Widget_Design_AppBarLayout;
    private Drawable A;
    private final float B;
    private Behavior C;

    /* renamed from: f  reason: collision with root package name */
    private int f12743f;

    /* renamed from: g  reason: collision with root package name */
    private int f12744g;

    /* renamed from: h  reason: collision with root package name */
    private int f12745h;

    /* renamed from: i  reason: collision with root package name */
    private int f12746i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f12747j;

    /* renamed from: k  reason: collision with root package name */
    private int f12748k;

    /* renamed from: l  reason: collision with root package name */
    private WindowInsetsCompat f12749l;

    /* renamed from: m  reason: collision with root package name */
    private List<BaseOnOffsetChangedListener> f12750m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f12751n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f12752o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f12753p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f12754q;

    /* renamed from: r  reason: collision with root package name */
    private int f12755r;

    /* renamed from: s  reason: collision with root package name */
    private WeakReference<View> f12756s;

    /* renamed from: t  reason: collision with root package name */
    private final ColorStateList f12757t;

    /* renamed from: u  reason: collision with root package name */
    private ValueAnimator f12758u;

    /* renamed from: v  reason: collision with root package name */
    private ValueAnimator.AnimatorUpdateListener f12759v;

    /* renamed from: w  reason: collision with root package name */
    private final List<LiftOnScrollListener> f12760w;

    /* renamed from: x  reason: collision with root package name */
    private final long f12761x;

    /* renamed from: y  reason: collision with root package name */
    private final TimeInterpolator f12762y;

    /* renamed from: z  reason: collision with root package name */
    private int[] f12763z;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {

        /* renamed from: k  reason: collision with root package name */
        private int f12765k;

        /* renamed from: l  reason: collision with root package name */
        private int f12766l;

        /* renamed from: m  reason: collision with root package name */
        private ValueAnimator f12767m;

        /* renamed from: n  reason: collision with root package name */
        private SavedState f12768n;

        /* renamed from: o  reason: collision with root package name */
        private WeakReference<View> f12769o;

        /* renamed from: p  reason: collision with root package name */
        private BaseDragCallback f12770p;

        /* renamed from: q  reason: collision with root package name */
        private boolean f12771q;

        /* loaded from: classes.dex */
        public static abstract class BaseDragCallback<T extends AppBarLayout> {
            public abstract boolean a(@NonNull T t7);
        }

        public BaseBehavior() {
        }

        private boolean A0(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t7) {
            List<View> t8 = coordinatorLayout.t(t7);
            int size = t8.size();
            for (int i8 = 0; i8 < size; i8++) {
                CoordinatorLayout.Behavior f8 = ((CoordinatorLayout.LayoutParams) t8.get(i8).getLayoutParams()).f();
                if (f8 instanceof ScrollingViewBehavior) {
                    if (((ScrollingViewBehavior) f8).K() == 0) {
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }

        private void B0(CoordinatorLayout coordinatorLayout, @NonNull T t7) {
            int topInset = t7.getTopInset() + t7.getPaddingTop();
            int M = M() - topInset;
            int h02 = h0(t7, M);
            if (h02 >= 0) {
                View childAt = t7.getChildAt(h02);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int c8 = layoutParams.c();
                if ((c8 & 17) == 17) {
                    int i8 = -childAt.getTop();
                    int i9 = -childAt.getBottom();
                    if (h02 == 0 && ViewCompat.B(t7) && ViewCompat.B(childAt)) {
                        i8 -= t7.getTopInset();
                    }
                    if (c0(c8, 2)) {
                        i9 += ViewCompat.F(childAt);
                    } else if (c0(c8, 5)) {
                        int F = ViewCompat.F(childAt) + i9;
                        if (M < F) {
                            i8 = F;
                        } else {
                            i9 = F;
                        }
                    }
                    if (c0(c8, 32)) {
                        i8 += ((LinearLayout.LayoutParams) layoutParams).topMargin;
                        i9 -= ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    }
                    X(coordinatorLayout, t7, MathUtils.b(Z(M, i9, i8) + topInset, -t7.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        private void C0(CoordinatorLayout coordinatorLayout, @NonNull T t7) {
            View i02;
            ViewCompat.m0(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.f6053q.b());
            ViewCompat.m0(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.f6054r.b());
            if (t7.getTotalScrollRange() == 0 || (i02 = i0(coordinatorLayout)) == null || !d0(t7)) {
                return;
            }
            if (!ViewCompat.Q(coordinatorLayout)) {
                ViewCompat.s0(coordinatorLayout, new AccessibilityDelegateCompat() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.2
                    @Override // androidx.core.view.AccessibilityDelegateCompat
                    public void g(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                        super.g(view, accessibilityNodeInfoCompat);
                        accessibilityNodeInfoCompat.s0(BaseBehavior.this.f12771q);
                        accessibilityNodeInfoCompat.Y(ScrollView.class.getName());
                    }
                });
            }
            this.f12771q = V(coordinatorLayout, t7, i02);
        }

        private void D0(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t7, int i8, int i9, boolean z7) {
            View g02 = g0(t7, i8);
            boolean z8 = false;
            if (g02 != null) {
                int c8 = ((LayoutParams) g02.getLayoutParams()).c();
                if ((c8 & 1) != 0) {
                    int F = ViewCompat.F(g02);
                    if (i9 <= 0 || (c8 & 12) == 0 ? !((c8 & 2) == 0 || (-i8) < (g02.getBottom() - F) - t7.getTopInset()) : (-i8) >= (g02.getBottom() - F) - t7.getTopInset()) {
                        z8 = true;
                    }
                }
            }
            if (t7.p()) {
                z8 = t7.D(f0(coordinatorLayout));
            }
            boolean A = t7.A(z8);
            if (z7 || (A && A0(coordinatorLayout, t7))) {
                t7.jumpDrawablesToCurrentState();
            }
        }

        private boolean V(final CoordinatorLayout coordinatorLayout, @NonNull final T t7, @NonNull final View view) {
            boolean z7 = false;
            if (M() != (-t7.getTotalScrollRange())) {
                W(coordinatorLayout, t7, AccessibilityNodeInfoCompat.AccessibilityActionCompat.f6053q, false);
                z7 = true;
            }
            if (M() != 0) {
                if (view.canScrollVertically(-1)) {
                    final int i8 = -t7.getDownNestedPreScrollRange();
                    if (i8 != 0) {
                        ViewCompat.o0(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.f6054r, null, new AccessibilityViewCommand() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.3
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                            public boolean a(@NonNull View view2, AccessibilityViewCommand.CommandArguments commandArguments) {
                                BaseBehavior.this.q(coordinatorLayout, t7, view, 0, i8, new int[]{0, 0}, 1);
                                return true;
                            }
                        });
                        return true;
                    }
                } else {
                    W(coordinatorLayout, t7, AccessibilityNodeInfoCompat.AccessibilityActionCompat.f6054r, true);
                    return true;
                }
            }
            return z7;
        }

        private void W(CoordinatorLayout coordinatorLayout, @NonNull final T t7, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, final boolean z7) {
            ViewCompat.o0(coordinatorLayout, accessibilityActionCompat, null, new AccessibilityViewCommand() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.4
                @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                public boolean a(@NonNull View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                    t7.setExpanded(z7);
                    return true;
                }
            });
        }

        private void X(CoordinatorLayout coordinatorLayout, @NonNull T t7, int i8, float f8) {
            int height;
            int abs = Math.abs(M() - i8);
            float abs2 = Math.abs(f8);
            if (abs2 > 0.0f) {
                height = Math.round((abs / abs2) * 1000.0f) * 3;
            } else {
                height = (int) (((abs / t7.getHeight()) + 1.0f) * 150.0f);
            }
            Y(coordinatorLayout, t7, i8, height);
        }

        private void Y(final CoordinatorLayout coordinatorLayout, final T t7, int i8, int i9) {
            int M = M();
            if (M == i8) {
                ValueAnimator valueAnimator = this.f12767m;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.f12767m.cancel();
                    return;
                }
                return;
            }
            ValueAnimator valueAnimator2 = this.f12767m;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.f12767m = valueAnimator3;
                valueAnimator3.setInterpolator(AnimationUtils.f12724e);
                this.f12767m.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator4) {
                        BaseBehavior.this.P(coordinatorLayout, t7, ((Integer) valueAnimator4.getAnimatedValue()).intValue());
                    }
                });
            } else {
                valueAnimator2.cancel();
            }
            this.f12767m.setDuration(Math.min(i9, 600));
            this.f12767m.setIntValues(M, i8);
            this.f12767m.start();
        }

        private int Z(int i8, int i9, int i10) {
            if (i8 >= (i9 + i10) / 2) {
                return i10;
            }
            return i9;
        }

        private boolean b0(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t7, @NonNull View view) {
            if (t7.l() && coordinatorLayout.getHeight() - view.getHeight() <= t7.getHeight()) {
                return true;
            }
            return false;
        }

        private static boolean c0(int i8, int i9) {
            return (i8 & i9) == i9;
        }

        private boolean d0(AppBarLayout appBarLayout) {
            int childCount = appBarLayout.getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                if (((LayoutParams) appBarLayout.getChildAt(i8).getLayoutParams()).f12791a != 0) {
                    return true;
                }
            }
            return false;
        }

        private void e0(KeyEvent keyEvent, View view, AppBarLayout appBarLayout) {
            if (keyEvent.getAction() == 0 || keyEvent.getAction() == 1) {
                int keyCode = keyEvent.getKeyCode();
                if (keyCode != 19 && keyCode != 280 && keyCode != 92) {
                    if ((keyCode == 20 || keyCode == 281 || keyCode == 93) && view.getScrollY() > 0) {
                        appBarLayout.setExpanded(false);
                    }
                } else if (view.getScrollY() < view.getMeasuredHeight() * 0.1d) {
                    appBarLayout.setExpanded(true);
                }
            }
        }

        private View f0(@NonNull CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = coordinatorLayout.getChildAt(i8);
                if ((childAt instanceof NestedScrollingChild) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        private static View g0(@NonNull AppBarLayout appBarLayout, int i8) {
            int abs = Math.abs(i8);
            int childCount = appBarLayout.getChildCount();
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = appBarLayout.getChildAt(i9);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private int h0(@NonNull T t7, int i8) {
            int childCount = t7.getChildCount();
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = t7.getChildAt(i9);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (c0(layoutParams.c(), 32)) {
                    top -= ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    bottom += ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                }
                int i10 = -i8;
                if (top <= i10 && bottom >= i10) {
                    return i9;
                }
            }
            return -1;
        }

        private View i0(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = coordinatorLayout.getChildAt(i8);
                if (((CoordinatorLayout.LayoutParams) childAt.getLayoutParams()).f() instanceof ScrollingViewBehavior) {
                    return childAt;
                }
            }
            return null;
        }

        private int l0(@NonNull T t7, int i8) {
            int abs = Math.abs(i8);
            int childCount = t7.getChildCount();
            int i9 = 0;
            int i10 = 0;
            while (true) {
                if (i10 >= childCount) {
                    break;
                }
                View childAt = t7.getChildAt(i10);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Interpolator d8 = layoutParams.d();
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    if (d8 != null) {
                        int c8 = layoutParams.c();
                        if ((c8 & 1) != 0) {
                            i9 = 0 + childAt.getHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                            if ((c8 & 2) != 0) {
                                i9 -= ViewCompat.F(childAt);
                            }
                        }
                        if (ViewCompat.B(childAt)) {
                            i9 -= t7.getTopInset();
                        }
                        if (i9 > 0) {
                            float f8 = i9;
                            return Integer.signum(i8) * (childAt.getTop() + Math.round(f8 * d8.getInterpolation((abs - childAt.getTop()) / f8)));
                        }
                    }
                } else {
                    i10++;
                }
            }
            return i8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean m0(View view, AppBarLayout appBarLayout, View view2, KeyEvent keyEvent) {
            e0(keyEvent, view, appBarLayout);
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean n0(View view, AppBarLayout appBarLayout, View view2, int i8, KeyEvent keyEvent) {
            e0(keyEvent, view, appBarLayout);
            return false;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        int M() {
            return E() + this.f12765k;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: a0 */
        public boolean H(T t7) {
            BaseDragCallback baseDragCallback = this.f12770p;
            if (baseDragCallback != null) {
                return baseDragCallback.a(t7);
            }
            WeakReference<View> weakReference = this.f12769o;
            if (weakReference == null) {
                return true;
            }
            View view = weakReference.get();
            if (view != null && view.isShown() && !view.canScrollVertically(-1)) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: j0 */
        public int K(@NonNull T t7) {
            return -t7.getDownNestedScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: k0 */
        public int L(@NonNull T t7) {
            return t7.getTotalScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: o0 */
        public void N(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t7) {
            B0(coordinatorLayout, t7);
            if (t7.p()) {
                t7.A(t7.D(f0(coordinatorLayout)));
            }
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: p0 */
        public boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull final T t7, int i8) {
            boolean z7;
            int round;
            boolean l8 = super.l(coordinatorLayout, t7, i8);
            int pendingAction = t7.getPendingAction();
            SavedState savedState = this.f12768n;
            if (savedState != null && (pendingAction & 8) == 0) {
                if (savedState.f12784h) {
                    P(coordinatorLayout, t7, -t7.getTotalScrollRange());
                } else if (savedState.f12785i) {
                    P(coordinatorLayout, t7, 0);
                } else {
                    View childAt = t7.getChildAt(savedState.f12786j);
                    int i9 = -childAt.getBottom();
                    if (this.f12768n.f12788l) {
                        round = ViewCompat.F(childAt) + t7.getTopInset();
                    } else {
                        round = Math.round(childAt.getHeight() * this.f12768n.f12787k);
                    }
                    P(coordinatorLayout, t7, i9 + round);
                }
            } else if (pendingAction != 0) {
                if ((pendingAction & 4) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if ((pendingAction & 2) != 0) {
                    int i10 = -t7.getUpNestedPreScrollRange();
                    if (z7) {
                        X(coordinatorLayout, t7, i10, 0.0f);
                    } else {
                        P(coordinatorLayout, t7, i10);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z7) {
                        X(coordinatorLayout, t7, 0, 0.0f);
                    } else {
                        P(coordinatorLayout, t7, 0);
                    }
                }
            }
            t7.w();
            this.f12768n = null;
            G(MathUtils.b(E(), -t7.getTotalScrollRange(), 0));
            D0(coordinatorLayout, t7, E(), 0, true);
            t7.s(E());
            C0(coordinatorLayout, t7);
            final View f02 = f0(coordinatorLayout);
            if (f02 != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    f02.addOnUnhandledKeyEventListener(new View$OnUnhandledKeyEventListener() { // from class: com.google.android.material.appbar.c
                        public final boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent) {
                            boolean m02;
                            m02 = AppBarLayout.BaseBehavior.this.m0(f02, t7, view, keyEvent);
                            return m02;
                        }
                    });
                } else {
                    f02.setOnKeyListener(new View.OnKeyListener() { // from class: com.google.android.material.appbar.d
                        @Override // android.view.View.OnKeyListener
                        public final boolean onKey(View view, int i11, KeyEvent keyEvent) {
                            boolean n02;
                            n02 = AppBarLayout.BaseBehavior.this.n0(f02, t7, view, i11, keyEvent);
                            return n02;
                        }
                    });
                }
            }
            return l8;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: q0 */
        public boolean m(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t7, int i8, int i9, int i10, int i11) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) t7.getLayoutParams())).height == -2) {
                coordinatorLayout.K(t7, i8, i9, View.MeasureSpec.makeMeasureSpec(0, 0), i11);
                return true;
            }
            return super.m(coordinatorLayout, t7, i8, i9, i10, i11);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: r0 */
        public void q(CoordinatorLayout coordinatorLayout, @NonNull T t7, View view, int i8, int i9, int[] iArr, int i10) {
            int i11;
            int i12;
            if (i9 != 0) {
                if (i9 < 0) {
                    int i13 = -t7.getTotalScrollRange();
                    i11 = i13;
                    i12 = t7.getDownNestedPreScrollRange() + i13;
                } else {
                    i11 = -t7.getUpNestedPreScrollRange();
                    i12 = 0;
                }
                if (i11 != i12) {
                    iArr[1] = O(coordinatorLayout, t7, i9, i11, i12);
                }
            }
            if (t7.p()) {
                t7.A(t7.D(view));
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: s0 */
        public void t(CoordinatorLayout coordinatorLayout, @NonNull T t7, View view, int i8, int i9, int i10, int i11, int i12, int[] iArr) {
            if (i11 < 0) {
                iArr[1] = O(coordinatorLayout, t7, i11, -t7.getDownNestedScrollRange(), 0);
            }
            if (i11 == 0) {
                C0(coordinatorLayout, t7);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: t0 */
        public void x(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t7, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                x0((SavedState) parcelable, true);
                super.x(coordinatorLayout, t7, this.f12768n.a());
                return;
            }
            super.x(coordinatorLayout, t7, parcelable);
            this.f12768n = null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: u0 */
        public Parcelable y(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t7) {
            Parcelable y7 = super.y(coordinatorLayout, t7);
            SavedState y02 = y0(y7, t7);
            if (y02 != null) {
                return y02;
            }
            return y7;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: v0 */
        public boolean A(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t7, @NonNull View view, View view2, int i8, int i9) {
            boolean z7;
            ValueAnimator valueAnimator;
            if ((i8 & 2) != 0 && (t7.p() || b0(coordinatorLayout, t7, view))) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7 && (valueAnimator = this.f12767m) != null) {
                valueAnimator.cancel();
            }
            this.f12769o = null;
            this.f12766l = i9;
            return z7;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: w0 */
        public void C(CoordinatorLayout coordinatorLayout, @NonNull T t7, View view, int i8) {
            if (this.f12766l == 0 || i8 == 1) {
                B0(coordinatorLayout, t7);
                if (t7.p()) {
                    t7.A(t7.D(view));
                }
            }
            this.f12769o = new WeakReference<>(view);
        }

        void x0(SavedState savedState, boolean z7) {
            if (this.f12768n == null || z7) {
                this.f12768n = savedState;
            }
        }

        SavedState y0(Parcelable parcelable, @NonNull T t7) {
            boolean z7;
            boolean z8;
            int E = E();
            int childCount = t7.getChildCount();
            boolean z9 = false;
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = t7.getChildAt(i8);
                int bottom = childAt.getBottom() + E;
                if (childAt.getTop() + E <= 0 && bottom >= 0) {
                    if (parcelable == null) {
                        parcelable = AbsSavedState.f6165g;
                    }
                    SavedState savedState = new SavedState(parcelable);
                    if (E == 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    savedState.f12785i = z7;
                    if (!z7 && (-E) >= t7.getTotalScrollRange()) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    savedState.f12784h = z8;
                    savedState.f12786j = i8;
                    if (bottom == ViewCompat.F(childAt) + t7.getTopInset()) {
                        z9 = true;
                    }
                    savedState.f12788l = z9;
                    savedState.f12787k = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: z0 */
        public int Q(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t7, int i8, int i9, int i10) {
            int i11;
            int i12;
            int M = M();
            int i13 = 0;
            if (i9 != 0 && M >= i9 && M <= i10) {
                int b8 = MathUtils.b(i8, i9, i10);
                if (M != b8) {
                    if (t7.j()) {
                        i11 = l0(t7, b8);
                    } else {
                        i11 = b8;
                    }
                    boolean G = G(i11);
                    int i14 = M - b8;
                    this.f12765k = b8 - i11;
                    if (G) {
                        while (i13 < t7.getChildCount()) {
                            LayoutParams layoutParams = (LayoutParams) t7.getChildAt(i13).getLayoutParams();
                            ChildScrollEffect b9 = layoutParams.b();
                            if (b9 != null && (layoutParams.c() & 1) != 0) {
                                b9.a(t7, t7.getChildAt(i13), E());
                            }
                            i13++;
                        }
                    }
                    if (!G && t7.j()) {
                        coordinatorLayout.g(t7);
                    }
                    t7.s(E());
                    if (b8 < M) {
                        i12 = -1;
                    } else {
                        i12 = 1;
                    }
                    D0(coordinatorLayout, t7, b8, i12, false);
                    i13 = i14;
                }
            } else {
                this.f12765k = 0;
            }
            C0(coordinatorLayout, t7);
            return i13;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* loaded from: classes.dex */
        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.SavedState.1
                @Override // android.os.Parcelable.Creator
                /* renamed from: a */
                public SavedState createFromParcel(@NonNull Parcel parcel) {
                    return new SavedState(parcel, null);
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                @NonNull
                /* renamed from: b */
                public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                @NonNull
                /* renamed from: c */
                public SavedState[] newArray(int i8) {
                    return new SavedState[i8];
                }
            };

            /* renamed from: h  reason: collision with root package name */
            boolean f12784h;

            /* renamed from: i  reason: collision with root package name */
            boolean f12785i;

            /* renamed from: j  reason: collision with root package name */
            int f12786j;

            /* renamed from: k  reason: collision with root package name */
            float f12787k;

            /* renamed from: l  reason: collision with root package name */
            boolean f12788l;

            public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f12784h = parcel.readByte() != 0;
                this.f12785i = parcel.readByte() != 0;
                this.f12786j = parcel.readInt();
                this.f12787k = parcel.readFloat();
                this.f12788l = parcel.readByte() != 0;
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(@NonNull Parcel parcel, int i8) {
                super.writeToParcel(parcel, i8);
                parcel.writeByte(this.f12784h ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.f12785i ? (byte) 1 : (byte) 0);
                parcel.writeInt(this.f12786j);
                parcel.writeFloat(this.f12787k);
                parcel.writeByte(this.f12788l ? (byte) 1 : (byte) 0);
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface BaseOnOffsetChangedListener<T extends AppBarLayout> {
        void a(T t7, int i8);
    }

    /* loaded from: classes.dex */
    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean D(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            return super.D(coordinatorLayout, view, motionEvent);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int E() {
            return super.E();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean G(int i8) {
            return super.G(i8);
        }

        @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean k(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            return super.k(coordinatorLayout, view, motionEvent);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean p0(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, int i8) {
            return super.l(coordinatorLayout, appBarLayout, i8);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean q0(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, int i8, int i9, int i10, int i11) {
            return super.m(coordinatorLayout, appBarLayout, i8, i9, i10, i11);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void r0(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i8, int i9, int[] iArr, int i10) {
            super.q(coordinatorLayout, appBarLayout, view, i8, i9, iArr, i10);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void s0(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i8, int i9, int i10, int i11, int i12, int[] iArr) {
            super.t(coordinatorLayout, appBarLayout, view, i8, i9, i10, i11, i12, iArr);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void t0(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, Parcelable parcelable) {
            super.x(coordinatorLayout, appBarLayout, parcelable);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ Parcelable u0(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout) {
            return super.y(coordinatorLayout, appBarLayout);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean v0(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, View view2, int i8, int i9) {
            return super.A(coordinatorLayout, appBarLayout, view, view2, i8, i9);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void w0(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i8) {
            super.C(coordinatorLayout, appBarLayout, view, i8);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ChildScrollEffect {
        public abstract void a(@NonNull AppBarLayout appBarLayout, @NonNull View view, float f8);
    }

    /* loaded from: classes.dex */
    public static class CompressChildScrollEffect extends ChildScrollEffect {

        /* renamed from: a  reason: collision with root package name */
        private final Rect f12789a = new Rect();

        /* renamed from: b  reason: collision with root package name */
        private final Rect f12790b = new Rect();

        private static void b(Rect rect, AppBarLayout appBarLayout, View view) {
            view.getDrawingRect(rect);
            appBarLayout.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(0, -appBarLayout.getTopInset());
        }

        @Override // com.google.android.material.appbar.AppBarLayout.ChildScrollEffect
        public void a(@NonNull AppBarLayout appBarLayout, @NonNull View view, float f8) {
            b(this.f12789a, appBarLayout, view);
            float abs = this.f12789a.top - Math.abs(f8);
            if (abs <= 0.0f) {
                float a8 = 1.0f - MathUtils.a(Math.abs(abs / this.f12789a.height()), 0.0f, 1.0f);
                float height = (-abs) - ((this.f12789a.height() * 0.3f) * (1.0f - (a8 * a8)));
                view.setTranslationY(height);
                view.getDrawingRect(this.f12790b);
                this.f12790b.offset(0, (int) (-height));
                ViewCompat.z0(view, this.f12790b);
                return;
            }
            ViewCompat.z0(view, null);
            view.setTranslationY(0.0f);
        }
    }

    /* loaded from: classes.dex */
    public interface LiftOnScrollListener {
        void a(float f8, int i8);
    }

    /* loaded from: classes.dex */
    public interface OnOffsetChangedListener extends BaseOnOffsetChangedListener<AppBarLayout> {
    }

    /* loaded from: classes.dex */
    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        private static int R(@NonNull AppBarLayout appBarLayout) {
            CoordinatorLayout.Behavior f8 = ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).f();
            if (f8 instanceof BaseBehavior) {
                return ((BaseBehavior) f8).M();
            }
            return 0;
        }

        private void S(@NonNull View view, @NonNull View view2) {
            CoordinatorLayout.Behavior f8 = ((CoordinatorLayout.LayoutParams) view2.getLayoutParams()).f();
            if (f8 instanceof BaseBehavior) {
                ViewCompat.d0(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) f8).f12765k) + M()) - I(view2));
            }
        }

        private void T(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.p()) {
                    appBarLayout.A(appBarLayout.D(view));
                }
            }
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        float J(View view) {
            int i8;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int R = R(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + R > downNestedPreScrollRange) && (i8 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (R / i8) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        int L(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return super.L(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        /* renamed from: Q */
        public AppBarLayout H(@NonNull List<View> list) {
            int size = list.size();
            for (int i8 = 0; i8 < size; i8++) {
                View view = list.get(i8);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean h(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            S(view, view2);
            T(view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void i(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            if (view2 instanceof AppBarLayout) {
                ViewCompat.m0(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.f6053q.b());
                ViewCompat.m0(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.f6054r.b());
                ViewCompat.s0(coordinatorLayout, null);
            }
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i8) {
            return super.l(coordinatorLayout, view, i8);
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean m(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i8, int i9, int i10, int i11) {
            return super.m(coordinatorLayout, view, i8, i9, i10, i11);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean w(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull Rect rect, boolean z7) {
            AppBarLayout H = H(coordinatorLayout.s(view));
            if (H != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f12830d;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    H.x(false, !z7);
                    return true;
                }
            }
            return false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.L5);
            O(obtainStyledAttributes.getDimensionPixelSize(R$styleable.M5, 0));
            obtainStyledAttributes.recycle();
        }
    }

    public AppBarLayout(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.appBarLayoutStyle);
    }

    private boolean C() {
        if (this.A != null && getTopInset() > 0) {
            return true;
        }
        return false;
    }

    private boolean E() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        if (childAt.getVisibility() == 8 || ViewCompat.B(childAt)) {
            return false;
        }
        return true;
    }

    private void F(float f8, float f9) {
        ValueAnimator valueAnimator = this.f12758u;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f8, f9);
        this.f12758u = ofFloat;
        ofFloat.setDuration(this.f12761x);
        this.f12758u.setInterpolator(this.f12762y);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.f12759v;
        if (animatorUpdateListener != null) {
            this.f12758u.addUpdateListener(animatorUpdateListener);
        }
        this.f12758u.start();
    }

    private void G() {
        setWillNotDraw(!C());
    }

    private void e() {
        WeakReference<View> weakReference = this.f12756s;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f12756s = null;
    }

    private View f(View view) {
        int i8;
        View view2;
        if (this.f12756s == null && (i8 = this.f12755r) != -1) {
            if (view != null) {
                view2 = view.findViewById(i8);
            } else {
                view2 = null;
            }
            if (view2 == null && (getParent() instanceof ViewGroup)) {
                view2 = ((ViewGroup) getParent()).findViewById(this.f12755r);
            }
            if (view2 != null) {
                this.f12756s = new WeakReference<>(view2);
            }
        }
        WeakReference<View> weakReference = this.f12756s;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private boolean k() {
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            if (((LayoutParams) getChildAt(i8).getLayoutParams()).e()) {
                return true;
            }
        }
        return false;
    }

    private void m(final MaterialShapeDrawable materialShapeDrawable) {
        int i8;
        if (this.f12753p) {
            i8 = 255;
        } else {
            i8 = 0;
        }
        materialShapeDrawable.setAlpha(i8);
        materialShapeDrawable.c0(this.f12757t);
        this.f12759v = new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppBarLayout.this.q(materialShapeDrawable, valueAnimator);
            }
        };
    }

    private void n(Context context, final MaterialShapeDrawable materialShapeDrawable) {
        materialShapeDrawable.R(context);
        this.f12759v = new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppBarLayout.this.r(materialShapeDrawable, valueAnimator);
            }
        };
    }

    private void o() {
        BaseBehavior.SavedState savedState;
        Behavior behavior = this.C;
        if (behavior != null && this.f12744g != -1 && this.f12748k == 0) {
            savedState = behavior.y0(AbsSavedState.f6165g, this);
        } else {
            savedState = null;
        }
        this.f12744g = -1;
        this.f12745h = -1;
        this.f12746i = -1;
        if (savedState != null) {
            this.C.x0(savedState, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(MaterialShapeDrawable materialShapeDrawable, ValueAnimator valueAnimator) {
        int floatValue = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
        materialShapeDrawable.setAlpha(floatValue);
        for (LiftOnScrollListener liftOnScrollListener : this.f12760w) {
            if (materialShapeDrawable.x() != null) {
                liftOnScrollListener.a(0.0f, materialShapeDrawable.x().withAlpha(floatValue).getDefaultColor());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(MaterialShapeDrawable materialShapeDrawable, ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        materialShapeDrawable.b0(floatValue);
        Drawable drawable = this.A;
        if (drawable instanceof MaterialShapeDrawable) {
            ((MaterialShapeDrawable) drawable).b0(floatValue);
        }
        for (LiftOnScrollListener liftOnScrollListener : this.f12760w) {
            liftOnScrollListener.a(floatValue, materialShapeDrawable.B());
        }
    }

    private void y(boolean z7, boolean z8, boolean z9) {
        int i8;
        int i9;
        if (z7) {
            i8 = 1;
        } else {
            i8 = 2;
        }
        int i10 = 0;
        if (z8) {
            i9 = 4;
        } else {
            i9 = 0;
        }
        int i11 = i8 | i9;
        if (z9) {
            i10 = 8;
        }
        this.f12748k = i11 | i10;
        requestLayout();
    }

    private boolean z(boolean z7) {
        if (this.f12752o != z7) {
            this.f12752o = z7;
            refreshDrawableState();
            return true;
        }
        return false;
    }

    boolean A(boolean z7) {
        return B(z7, !this.f12751n);
    }

    boolean B(boolean z7, boolean z8) {
        float f8;
        float f9;
        if (z8 && this.f12753p != z7) {
            this.f12753p = z7;
            refreshDrawableState();
            if (this.f12754q && (getBackground() instanceof MaterialShapeDrawable)) {
                float f10 = 0.0f;
                if (this.f12757t != null) {
                    if (z7) {
                        f9 = 0.0f;
                    } else {
                        f9 = 255.0f;
                    }
                    if (z7) {
                        f10 = 255.0f;
                    }
                    F(f9, f10);
                    return true;
                }
                if (z7) {
                    f8 = 0.0f;
                } else {
                    f8 = this.B;
                }
                if (z7) {
                    f10 = this.B;
                }
                F(f8, f10);
                return true;
            }
            return true;
        }
        return false;
    }

    boolean D(View view) {
        View f8 = f(view);
        if (f8 != null) {
            view = f8;
        }
        if (view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0)) {
            return true;
        }
        return false;
    }

    public void c(BaseOnOffsetChangedListener baseOnOffsetChangedListener) {
        if (this.f12750m == null) {
            this.f12750m = new ArrayList();
        }
        if (baseOnOffsetChangedListener != null && !this.f12750m.contains(baseOnOffsetChangedListener)) {
            this.f12750m.add(baseOnOffsetChangedListener);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void d(OnOffsetChangedListener onOffsetChangedListener) {
        c(onOffsetChangedListener);
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        if (C()) {
            int save = canvas.save();
            canvas.translate(0.0f, -this.f12743f);
            this.A.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.A;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: g */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        Behavior behavior = new Behavior();
        this.C = behavior;
        return behavior;
    }

    int getDownNestedPreScrollRange() {
        int i8;
        int F;
        int i9 = this.f12745h;
        if (i9 != -1) {
            return i9;
        }
        int i10 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i11 = layoutParams.f12791a;
                if ((i11 & 5) == 5) {
                    int i12 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    if ((i11 & 8) != 0) {
                        F = ViewCompat.F(childAt);
                    } else if ((i11 & 2) != 0) {
                        F = measuredHeight - ViewCompat.F(childAt);
                    } else {
                        i8 = i12 + measuredHeight;
                        if (childCount == 0 && ViewCompat.B(childAt)) {
                            i8 = Math.min(i8, measuredHeight - getTopInset());
                        }
                        i10 += i8;
                    }
                    i8 = i12 + F;
                    if (childCount == 0) {
                        i8 = Math.min(i8, measuredHeight - getTopInset());
                    }
                    i10 += i8;
                } else if (i10 > 0) {
                    break;
                }
            }
        }
        int max = Math.max(0, i10);
        this.f12745h = max;
        return max;
    }

    int getDownNestedScrollRange() {
        int i8 = this.f12746i;
        if (i8 != -1) {
            return i8;
        }
        int childCount = getChildCount();
        int i9 = 0;
        int i10 = 0;
        while (true) {
            if (i9 >= childCount) {
                break;
            }
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                int i11 = layoutParams.f12791a;
                if ((i11 & 1) == 0) {
                    break;
                }
                i10 += measuredHeight;
                if ((i11 & 2) != 0) {
                    i10 -= ViewCompat.F(childAt);
                    break;
                }
            }
            i9++;
        }
        int max = Math.max(0, i10);
        this.f12746i = max;
        return max;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.f12755r;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int F = ViewCompat.F(this);
        if (F == 0) {
            int childCount = getChildCount();
            if (childCount >= 1) {
                F = ViewCompat.F(getChildAt(childCount - 1));
            } else {
                F = 0;
            }
            if (F == 0) {
                return getHeight() / 3;
            }
        }
        return (F * 2) + topInset;
    }

    int getPendingAction() {
        return this.f12748k;
    }

    public Drawable getStatusBarForeground() {
        return this.A;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    final int getTopInset() {
        WindowInsetsCompat windowInsetsCompat = this.f12749l;
        if (windowInsetsCompat != null) {
            return windowInsetsCompat.l();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i8 = this.f12744g;
        if (i8 != -1) {
            return i8;
        }
        int childCount = getChildCount();
        int i9 = 0;
        int i10 = 0;
        while (true) {
            if (i9 >= childCount) {
                break;
            }
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i11 = layoutParams.f12791a;
                if ((i11 & 1) == 0) {
                    break;
                }
                i10 += measuredHeight + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                if (i9 == 0 && ViewCompat.B(childAt)) {
                    i10 -= getTopInset();
                }
                if ((i11 & 2) != 0) {
                    i10 -= ViewCompat.F(childAt);
                    break;
                }
            }
            i9++;
        }
        int max = Math.max(0, i10);
        this.f12744g = max;
        return max;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: h */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: i */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return new LayoutParams((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    boolean j() {
        return this.f12747j;
    }

    boolean l() {
        if (getTotalScrollRange() != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.e(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i8) {
        int i9;
        int i10;
        if (this.f12763z == null) {
            this.f12763z = new int[4];
        }
        int[] iArr = this.f12763z;
        int[] onCreateDrawableState = super.onCreateDrawableState(i8 + iArr.length);
        boolean z7 = this.f12752o;
        int i11 = R$attr.state_liftable;
        if (!z7) {
            i11 = -i11;
        }
        iArr[0] = i11;
        if (z7 && this.f12753p) {
            i9 = R$attr.state_lifted;
        } else {
            i9 = -R$attr.state_lifted;
        }
        iArr[1] = i9;
        int i12 = R$attr.state_collapsible;
        if (!z7) {
            i12 = -i12;
        }
        iArr[2] = i12;
        if (z7 && this.f12753p) {
            i10 = R$attr.state_collapsed;
        } else {
            i10 = -R$attr.state_collapsed;
        }
        iArr[3] = i10;
        return View.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        super.onLayout(z7, i8, i9, i10, i11);
        boolean z8 = true;
        if (ViewCompat.B(this) && E()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                ViewCompat.d0(getChildAt(childCount), topInset);
            }
        }
        o();
        this.f12747j = false;
        int childCount2 = getChildCount();
        int i12 = 0;
        while (true) {
            if (i12 >= childCount2) {
                break;
            } else if (((LayoutParams) getChildAt(i12).getLayoutParams()).d() != null) {
                this.f12747j = true;
                break;
            } else {
                i12++;
            }
        }
        Drawable drawable = this.A;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (!this.f12751n) {
            if (!this.f12754q && !k()) {
                z8 = false;
            }
            z(z8);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        int mode = View.MeasureSpec.getMode(i9);
        if (mode != 1073741824 && ViewCompat.B(this) && E()) {
            int measuredHeight = getMeasuredHeight();
            if (mode != Integer.MIN_VALUE) {
                if (mode == 0) {
                    measuredHeight += getTopInset();
                }
            } else {
                measuredHeight = MathUtils.b(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i9));
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        o();
    }

    public boolean p() {
        return this.f12754q;
    }

    void s(int i8) {
        this.f12743f = i8;
        if (!willNotDraw()) {
            ViewCompat.j0(this);
        }
        List<BaseOnOffsetChangedListener> list = this.f12750m;
        if (list != null) {
            int size = list.size();
            for (int i9 = 0; i9 < size; i9++) {
                BaseOnOffsetChangedListener baseOnOffsetChangedListener = this.f12750m.get(i9);
                if (baseOnOffsetChangedListener != null) {
                    baseOnOffsetChangedListener.a(this, i8);
                }
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f8) {
        super.setElevation(f8);
        MaterialShapeUtils.d(this, f8);
    }

    public void setExpanded(boolean z7) {
        x(z7, ViewCompat.W(this));
    }

    public void setLiftOnScroll(boolean z7) {
        this.f12754q = z7;
    }

    public void setLiftOnScrollTargetView(View view) {
        this.f12755r = -1;
        if (view == null) {
            e();
        } else {
            this.f12756s = new WeakReference<>(view);
        }
    }

    public void setLiftOnScrollTargetViewId(int i8) {
        this.f12755r = i8;
        e();
    }

    public void setLiftableOverrideEnabled(boolean z7) {
        this.f12751n = z7;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i8) {
        if (i8 == 1) {
            super.setOrientation(i8);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    public void setStatusBarForeground(Drawable drawable) {
        boolean z7;
        Drawable drawable2 = this.A;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.A = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.A.setState(getDrawableState());
                }
                DrawableCompat.m(this.A, ViewCompat.E(this));
                Drawable drawable4 = this.A;
                if (getVisibility() == 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                drawable4.setVisible(z7, false);
                this.A.setCallback(this);
            }
            G();
            ViewCompat.j0(this);
        }
    }

    public void setStatusBarForegroundColor(int i8) {
        setStatusBarForeground(new ColorDrawable(i8));
    }

    public void setStatusBarForegroundResource(int i8) {
        setStatusBarForeground(AppCompatResources.b(getContext(), i8));
    }

    @Deprecated
    public void setTargetElevation(float f8) {
        ViewUtilsLollipop.b(this, f8);
    }

    @Override // android.view.View
    public void setVisibility(int i8) {
        boolean z7;
        super.setVisibility(i8);
        if (i8 == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        Drawable drawable = this.A;
        if (drawable != null) {
            drawable.setVisible(z7, false);
        }
    }

    WindowInsetsCompat t(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2;
        if (ViewCompat.B(this)) {
            windowInsetsCompat2 = windowInsetsCompat;
        } else {
            windowInsetsCompat2 = null;
        }
        if (!ObjectsCompat.a(this.f12749l, windowInsetsCompat2)) {
            this.f12749l = windowInsetsCompat2;
            G();
            requestLayout();
        }
        return windowInsetsCompat;
    }

    public void u(BaseOnOffsetChangedListener baseOnOffsetChangedListener) {
        List<BaseOnOffsetChangedListener> list = this.f12750m;
        if (list != null && baseOnOffsetChangedListener != null) {
            list.remove(baseOnOffsetChangedListener);
        }
    }

    public void v(OnOffsetChangedListener onOffsetChangedListener) {
        u(onOffsetChangedListener);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(@NonNull Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.A) {
            return false;
        }
        return true;
    }

    void w() {
        this.f12748k = 0;
    }

    public void x(boolean z7, boolean z8) {
        y(z7, z8, true);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AppBarLayout(@androidx.annotation.NonNull android.content.Context r10, android.util.AttributeSet r11, int r12) {
        /*
            r9 = this;
            int r4 = com.google.android.material.appbar.AppBarLayout.D
            android.content.Context r10 = com.google.android.material.theme.overlay.MaterialThemeOverlay.c(r10, r11, r12, r4)
            r9.<init>(r10, r11, r12)
            r10 = -1
            r9.f12744g = r10
            r9.f12745h = r10
            r9.f12746i = r10
            r6 = 0
            r9.f12748k = r6
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r9.f12760w = r0
            android.content.Context r7 = r9.getContext()
            r0 = 1
            r9.setOrientation(r0)
            int r8 = android.os.Build.VERSION.SDK_INT
            android.view.ViewOutlineProvider r0 = r9.getOutlineProvider()
            android.view.ViewOutlineProvider r1 = android.view.ViewOutlineProvider.BACKGROUND
            if (r0 != r1) goto L2f
            com.google.android.material.appbar.ViewUtilsLollipop.a(r9)
        L2f:
            com.google.android.material.appbar.ViewUtilsLollipop.c(r9, r11, r12, r4)
            int[] r2 = com.google.android.material.R$styleable.f12585k
            int[] r5 = new int[r6]
            r0 = r7
            r1 = r11
            r3 = r12
            android.content.res.TypedArray r11 = com.google.android.material.internal.ThemeEnforcement.i(r0, r1, r2, r3, r4, r5)
            int r12 = com.google.android.material.R$styleable.f12594l
            android.graphics.drawable.Drawable r12 = r11.getDrawable(r12)
            androidx.core.view.ViewCompat.w0(r9, r12)
            int r12 = com.google.android.material.R$styleable.f12648r
            android.content.res.ColorStateList r12 = com.google.android.material.resources.MaterialResources.a(r7, r11, r12)
            r9.f12757t = r12
            android.graphics.drawable.Drawable r0 = r9.getBackground()
            boolean r0 = r0 instanceof android.graphics.drawable.ColorDrawable
            if (r0 == 0) goto L78
            android.graphics.drawable.Drawable r0 = r9.getBackground()
            android.graphics.drawable.ColorDrawable r0 = (android.graphics.drawable.ColorDrawable) r0
            com.google.android.material.shape.MaterialShapeDrawable r1 = new com.google.android.material.shape.MaterialShapeDrawable
            r1.<init>()
            int r0 = r0.getColor()
            android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r0)
            r1.c0(r0)
            if (r12 == 0) goto L72
            r9.m(r1)
            goto L75
        L72:
            r9.n(r7, r1)
        L75:
            androidx.core.view.ViewCompat.w0(r9, r1)
        L78:
            int r12 = com.google.android.material.R$attr.motionDurationMedium2
            android.content.res.Resources r0 = r9.getResources()
            int r1 = com.google.android.material.R$integer.app_bar_elevation_anim_duration
            int r0 = r0.getInteger(r1)
            int r12 = com.google.android.material.motion.MotionUtils.f(r7, r12, r0)
            long r0 = (long) r12
            r9.f12761x = r0
            int r12 = com.google.android.material.R$attr.motionEasingStandardInterpolator
            android.animation.TimeInterpolator r0 = com.google.android.material.animation.AnimationUtils.f12720a
            android.animation.TimeInterpolator r12 = com.google.android.material.motion.MotionUtils.g(r7, r12, r0)
            r9.f12762y = r12
            int r12 = com.google.android.material.R$styleable.f12630p
            boolean r0 = r11.hasValue(r12)
            if (r0 == 0) goto La4
            boolean r12 = r11.getBoolean(r12, r6)
            r9.y(r12, r6, r6)
        La4:
            int r12 = com.google.android.material.R$styleable.f12621o
            boolean r0 = r11.hasValue(r12)
            if (r0 == 0) goto Lb4
            int r12 = r11.getDimensionPixelSize(r12, r6)
            float r12 = (float) r12
            com.google.android.material.appbar.ViewUtilsLollipop.b(r9, r12)
        Lb4:
            r12 = 26
            if (r8 < r12) goto Ld6
            int r12 = com.google.android.material.R$styleable.f12612n
            boolean r0 = r11.hasValue(r12)
            if (r0 == 0) goto Lc7
            boolean r12 = r11.getBoolean(r12, r6)
            r9.setKeyboardNavigationCluster(r12)
        Lc7:
            int r12 = com.google.android.material.R$styleable.f12603m
            boolean r0 = r11.hasValue(r12)
            if (r0 == 0) goto Ld6
            boolean r12 = r11.getBoolean(r12, r6)
            r9.setTouchscreenBlocksFocus(r12)
        Ld6:
            android.content.res.Resources r12 = r9.getResources()
            int r0 = com.google.android.material.R$dimen.design_appbar_elevation
            float r12 = r12.getDimension(r0)
            r9.B = r12
            int r12 = com.google.android.material.R$styleable.f12639q
            boolean r12 = r11.getBoolean(r12, r6)
            r9.f12754q = r12
            int r12 = com.google.android.material.R$styleable.f12656s
            int r10 = r11.getResourceId(r12, r10)
            r9.f12755r = r10
            int r10 = com.google.android.material.R$styleable.f12664t
            android.graphics.drawable.Drawable r10 = r11.getDrawable(r10)
            r9.setStatusBarForeground(r10)
            r11.recycle()
            com.google.android.material.appbar.AppBarLayout$1 r10 = new com.google.android.material.appbar.AppBarLayout$1
            r10.<init>()
            androidx.core.view.ViewCompat.G0(r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        int f12791a;

        /* renamed from: b  reason: collision with root package name */
        private ChildScrollEffect f12792b;

        /* renamed from: c  reason: collision with root package name */
        Interpolator f12793c;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f12791a = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f12680v);
            this.f12791a = obtainStyledAttributes.getInt(R$styleable.f12696x, 0);
            f(obtainStyledAttributes.getInt(R$styleable.f12688w, 0));
            int i8 = R$styleable.f12704y;
            if (obtainStyledAttributes.hasValue(i8)) {
                this.f12793c = android.view.animation.AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(i8, 0));
            }
            obtainStyledAttributes.recycle();
        }

        private ChildScrollEffect a(int i8) {
            if (i8 != 1) {
                return null;
            }
            return new CompressChildScrollEffect();
        }

        public ChildScrollEffect b() {
            return this.f12792b;
        }

        public int c() {
            return this.f12791a;
        }

        public Interpolator d() {
            return this.f12793c;
        }

        boolean e() {
            int i8 = this.f12791a;
            if ((i8 & 1) == 1 && (i8 & 10) != 0) {
                return true;
            }
            return false;
        }

        public void f(int i8) {
            this.f12792b = a(i8);
        }

        public void g(int i8) {
            this.f12791a = i8;
        }

        public LayoutParams(int i8, int i9) {
            super(i8, i9);
            this.f12791a = 1;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f12791a = 1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f12791a = 1;
        }

        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f12791a = 1;
        }
    }
}
