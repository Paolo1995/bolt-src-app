package androidx.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.core.R$attr;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import org.jctools.util.Pow2;

/* loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements NestedScrollingParent3, NestedScrollingChild {
    private static final float G = (float) (Math.log(0.78d) / Math.log(0.9d));
    private static final AccessibilityDelegate H = new AccessibilityDelegate();
    private static final int[] I = {16843130};
    private int A;
    private SavedState B;
    private final NestedScrollingParentHelper C;
    private final NestedScrollingChildHelper D;
    private float E;
    private OnScrollChangeListener F;

    /* renamed from: f  reason: collision with root package name */
    private final float f6119f;

    /* renamed from: g  reason: collision with root package name */
    private long f6120g;

    /* renamed from: h  reason: collision with root package name */
    private final Rect f6121h;

    /* renamed from: i  reason: collision with root package name */
    private OverScroller f6122i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public EdgeEffect f6123j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public EdgeEffect f6124k;

    /* renamed from: l  reason: collision with root package name */
    private int f6125l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f6126m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f6127n;

    /* renamed from: o  reason: collision with root package name */
    private View f6128o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f6129p;

    /* renamed from: q  reason: collision with root package name */
    private VelocityTracker f6130q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f6131r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f6132s;

    /* renamed from: t  reason: collision with root package name */
    private int f6133t;

    /* renamed from: u  reason: collision with root package name */
    private int f6134u;

    /* renamed from: v  reason: collision with root package name */
    private int f6135v;

    /* renamed from: w  reason: collision with root package name */
    private int f6136w;

    /* renamed from: x  reason: collision with root package name */
    private final int[] f6137x;

    /* renamed from: y  reason: collision with root package name */
    private final int[] f6138y;

    /* renamed from: z  reason: collision with root package name */
    private int f6139z;

    /* loaded from: classes.dex */
    static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        AccessibilityDelegate() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            boolean z7;
            super.f(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            if (nestedScrollView.getScrollRange() > 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            accessibilityEvent.setScrollable(z7);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            AccessibilityRecordCompat.a(accessibilityEvent, nestedScrollView.getScrollX());
            AccessibilityRecordCompat.b(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int scrollRange;
            super.g(view, accessibilityNodeInfoCompat);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityNodeInfoCompat.Y(ScrollView.class.getName());
            if (nestedScrollView.isEnabled() && (scrollRange = nestedScrollView.getScrollRange()) > 0) {
                accessibilityNodeInfoCompat.s0(true);
                if (nestedScrollView.getScrollY() > 0) {
                    accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f6054r);
                    accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.C);
                }
                if (nestedScrollView.getScrollY() < scrollRange) {
                    accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f6053q);
                    accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.E);
                }
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean j(View view, int i8, Bundle bundle) {
            if (super.j(view, i8, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int height = nestedScrollView.getHeight();
            Rect rect = new Rect();
            if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
                height = rect.height();
            }
            if (i8 != 4096) {
                if (i8 != 8192 && i8 != 16908344) {
                    if (i8 != 16908346) {
                        return false;
                    }
                } else {
                    int max = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (max == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.U(0, max, true);
                    return true;
                }
            }
            int min = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (min == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.U(0, min, true);
            return true;
        }
    }

    /* loaded from: classes.dex */
    static class Api21Impl {
        private Api21Impl() {
        }

        static boolean a(ViewGroup viewGroup) {
            return viewGroup.getClipToPadding();
        }
    }

    /* loaded from: classes.dex */
    public interface OnScrollChangeListener {
        void a(@NonNull NestedScrollView nestedScrollView, int i8, int i9, int i10, int i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.core.widget.NestedScrollView.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i8) {
                return new SavedState[i8];
            }
        };

        /* renamed from: f  reason: collision with root package name */
        public int f6140f;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @NonNull
        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f6140f + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i8) {
            super.writeToParcel(parcel, i8);
            parcel.writeInt(this.f6140f);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f6140f = parcel.readInt();
        }
    }

    public NestedScrollView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.f5482c);
    }

    private void A() {
        this.f6122i = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f6133t = viewConfiguration.getScaledTouchSlop();
        this.f6134u = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f6135v = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void B() {
        if (this.f6130q == null) {
            this.f6130q = VelocityTracker.obtain();
        }
    }

    private boolean C(View view) {
        return !E(view, 0, getHeight());
    }

    private static boolean D(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        if ((parent instanceof ViewGroup) && D((View) parent, view2)) {
            return true;
        }
        return false;
    }

    private boolean E(View view, int i8, int i9) {
        view.getDrawingRect(this.f6121h);
        offsetDescendantRectToMyCoords(view, this.f6121h);
        if (this.f6121h.bottom + i8 >= getScrollY() && this.f6121h.top - i8 <= getScrollY() + i9) {
            return true;
        }
        return false;
    }

    private void F(int i8, int i9, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i8);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.D.e(0, scrollY2, 0, i8 - scrollY2, null, i9, iArr);
    }

    private void G(MotionEvent motionEvent) {
        int i8;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f6136w) {
            if (actionIndex == 0) {
                i8 = 1;
            } else {
                i8 = 0;
            }
            this.f6125l = (int) motionEvent.getY(i8);
            this.f6136w = motionEvent.getPointerId(i8);
            VelocityTracker velocityTracker = this.f6130q;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void J() {
        VelocityTracker velocityTracker = this.f6130q;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f6130q = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int K(int r4, float r5) {
        /*
            r3 = this;
            int r0 = r3.getWidth()
            float r0 = (float) r0
            float r5 = r5 / r0
            float r4 = (float) r4
            int r0 = r3.getHeight()
            float r0 = (float) r0
            float r4 = r4 / r0
            android.widget.EdgeEffect r0 = r3.f6123j
            float r0 = androidx.core.widget.EdgeEffectCompat.b(r0)
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L31
            android.widget.EdgeEffect r0 = r3.f6123j
            float r4 = -r4
            float r4 = androidx.core.widget.EdgeEffectCompat.d(r0, r4, r5)
            float r4 = -r4
            android.widget.EdgeEffect r5 = r3.f6123j
            float r5 = androidx.core.widget.EdgeEffectCompat.b(r5)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L2f
            android.widget.EdgeEffect r5 = r3.f6123j
            r5.onRelease()
        L2f:
            r1 = r4
            goto L54
        L31:
            android.widget.EdgeEffect r0 = r3.f6124k
            float r0 = androidx.core.widget.EdgeEffectCompat.b(r0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L54
            android.widget.EdgeEffect r0 = r3.f6124k
            r2 = 1065353216(0x3f800000, float:1.0)
            float r2 = r2 - r5
            float r4 = androidx.core.widget.EdgeEffectCompat.d(r0, r4, r2)
            android.widget.EdgeEffect r5 = r3.f6124k
            float r5 = androidx.core.widget.EdgeEffectCompat.b(r5)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L2f
            android.widget.EdgeEffect r5 = r3.f6124k
            r5.onRelease()
            goto L2f
        L54:
            int r4 = r3.getHeight()
            float r4 = (float) r4
            float r1 = r1 * r4
            int r4 = java.lang.Math.round(r1)
            if (r4 == 0) goto L64
            r3.invalidate()
        L64:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.K(int, float):int");
    }

    private void L(boolean z7) {
        if (z7) {
            V(2, 1);
        } else {
            X(1);
        }
        this.A = getScrollY();
        ViewCompat.j0(this);
    }

    private boolean M(int i8, int i9, int i10) {
        boolean z7;
        int i11;
        int height = getHeight();
        int scrollY = getScrollY();
        int i12 = height + scrollY;
        boolean z8 = false;
        if (i8 == 33) {
            z7 = true;
        } else {
            z7 = false;
        }
        View t7 = t(z7, i9, i10);
        if (t7 == null) {
            t7 = this;
        }
        if (i9 < scrollY || i10 > i12) {
            if (z7) {
                i11 = i9 - scrollY;
            } else {
                i11 = i10 - i12;
            }
            p(i11);
            z8 = true;
        }
        if (t7 != findFocus()) {
            t7.requestFocus(i8);
        }
        return z8;
    }

    private void N(View view) {
        view.getDrawingRect(this.f6121h);
        offsetDescendantRectToMyCoords(view, this.f6121h);
        int f8 = f(this.f6121h);
        if (f8 != 0) {
            scrollBy(0, f8);
        }
    }

    private boolean O(Rect rect, boolean z7) {
        boolean z8;
        int f8 = f(rect);
        if (f8 != 0) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8) {
            if (z7) {
                scrollBy(0, f8);
            } else {
                Q(0, f8);
            }
        }
        return z8;
    }

    private boolean P(@NonNull EdgeEffect edgeEffect, int i8) {
        if (i8 > 0) {
            return true;
        }
        if (w(-i8) < EdgeEffectCompat.b(edgeEffect) * getHeight()) {
            return true;
        }
        return false;
    }

    private void R(int i8, int i9, int i10, boolean z7) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f6120g > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int scrollY = getScrollY();
            OverScroller overScroller = this.f6122i;
            int scrollX = getScrollX();
            overScroller.startScroll(scrollX, scrollY, 0, Math.max(0, Math.min(i9 + scrollY, Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom())))) - scrollY, i10);
            L(z7);
        } else {
            if (!this.f6122i.isFinished()) {
                a();
            }
            scrollBy(i8, i9);
        }
        this.f6120g = AnimationUtils.currentAnimationTimeMillis();
    }

    private boolean W(MotionEvent motionEvent) {
        boolean z7;
        if (EdgeEffectCompat.b(this.f6123j) != 0.0f) {
            EdgeEffectCompat.d(this.f6123j, 0.0f, motionEvent.getX() / getWidth());
            z7 = true;
        } else {
            z7 = false;
        }
        if (EdgeEffectCompat.b(this.f6124k) != 0.0f) {
            EdgeEffectCompat.d(this.f6124k, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
            return true;
        }
        return z7;
    }

    private void a() {
        this.f6122i.abortAnimation();
        X(1);
    }

    private boolean c() {
        int overScrollMode = getOverScrollMode();
        if (overScrollMode == 0) {
            return true;
        }
        if (overScrollMode == 1 && getScrollRange() > 0) {
            return true;
        }
        return false;
    }

    private boolean d() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        if (childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin <= (getHeight() - getPaddingTop()) - getPaddingBottom()) {
            return false;
        }
        return true;
    }

    private static int e(int i8, int i9, int i10) {
        if (i9 >= i10 || i8 < 0) {
            return 0;
        }
        return i9 + i8 > i10 ? i10 - i9 : i8;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.E == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.E = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.E;
    }

    private void p(int i8) {
        if (i8 != 0) {
            if (this.f6132s) {
                Q(0, i8);
            } else {
                scrollBy(0, i8);
            }
        }
    }

    private boolean q(int i8) {
        if (EdgeEffectCompat.b(this.f6123j) != 0.0f) {
            if (P(this.f6123j, i8)) {
                this.f6123j.onAbsorb(i8);
            } else {
                u(-i8);
            }
        } else if (EdgeEffectCompat.b(this.f6124k) != 0.0f) {
            int i9 = -i8;
            if (P(this.f6124k, i9)) {
                this.f6124k.onAbsorb(i9);
            } else {
                u(i9);
            }
        } else {
            return false;
        }
        return true;
    }

    private void r() {
        this.f6129p = false;
        J();
        X(0);
        this.f6123j.onRelease();
        this.f6124k.onRelease();
    }

    private View t(boolean z7, int i8, int i9) {
        boolean z8;
        boolean z9;
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z10 = false;
        for (int i10 = 0; i10 < size; i10++) {
            View view2 = focusables.get(i10);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i8 < bottom && top < i9) {
                if (i8 < top && bottom < i9) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (view == null) {
                    view = view2;
                    z10 = z8;
                } else {
                    if ((z7 && top < view.getTop()) || (!z7 && bottom > view.getBottom())) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    if (z10) {
                        if (z8) {
                            if (!z9) {
                            }
                            view = view2;
                        }
                    } else if (z8) {
                        view = view2;
                        z10 = true;
                    } else {
                        if (!z9) {
                        }
                        view = view2;
                    }
                }
            }
        }
        return view;
    }

    private float w(int i8) {
        double log = Math.log((Math.abs(i8) * 0.35f) / (this.f6119f * 0.015f));
        float f8 = G;
        return (float) (this.f6119f * 0.015f * Math.exp((f8 / (f8 - 1.0d)) * log));
    }

    private boolean y(int i8, int i9) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        if (i9 < childAt.getTop() - scrollY || i9 >= childAt.getBottom() - scrollY || i8 < childAt.getLeft() || i8 >= childAt.getRight()) {
            return false;
        }
        return true;
    }

    private void z() {
        VelocityTracker velocityTracker = this.f6130q;
        if (velocityTracker == null) {
            this.f6130q = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0083 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean H(int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, boolean r21) {
        /*
            r12 = this;
            r0 = r12
            int r1 = r12.getOverScrollMode()
            int r2 = r12.computeHorizontalScrollRange()
            int r3 = r12.computeHorizontalScrollExtent()
            r4 = 0
            r5 = 1
            if (r2 <= r3) goto L13
            r2 = 1
            goto L14
        L13:
            r2 = 0
        L14:
            int r3 = r12.computeVerticalScrollRange()
            int r6 = r12.computeVerticalScrollExtent()
            if (r3 <= r6) goto L20
            r3 = 1
            goto L21
        L20:
            r3 = 0
        L21:
            if (r1 == 0) goto L2a
            if (r1 != r5) goto L28
            if (r2 == 0) goto L28
            goto L2a
        L28:
            r2 = 0
            goto L2b
        L2a:
            r2 = 1
        L2b:
            if (r1 == 0) goto L34
            if (r1 != r5) goto L32
            if (r3 == 0) goto L32
            goto L34
        L32:
            r1 = 0
            goto L35
        L34:
            r1 = 1
        L35:
            int r3 = r15 + r13
            if (r2 != 0) goto L3b
            r2 = 0
            goto L3d
        L3b:
            r2 = r19
        L3d:
            int r6 = r16 + r14
            if (r1 != 0) goto L43
            r1 = 0
            goto L45
        L43:
            r1 = r20
        L45:
            int r7 = -r2
            int r2 = r2 + r17
            int r8 = -r1
            int r1 = r1 + r18
            if (r3 <= r2) goto L50
            r3 = r2
        L4e:
            r2 = 1
            goto L55
        L50:
            if (r3 >= r7) goto L54
            r3 = r7
            goto L4e
        L54:
            r2 = 0
        L55:
            if (r6 <= r1) goto L5a
            r6 = r1
        L58:
            r1 = 1
            goto L5f
        L5a:
            if (r6 >= r8) goto L5e
            r6 = r8
            goto L58
        L5e:
            r1 = 0
        L5f:
            if (r1 == 0) goto L7e
            boolean r7 = r12.x(r5)
            if (r7 != 0) goto L7e
            android.widget.OverScroller r7 = r0.f6122i
            r8 = 0
            r9 = 0
            r10 = 0
            int r11 = r12.getScrollRange()
            r13 = r7
            r14 = r3
            r15 = r6
            r16 = r8
            r17 = r9
            r18 = r10
            r19 = r11
            r13.springBack(r14, r15, r16, r17, r18, r19)
        L7e:
            r12.onOverScrolled(r3, r6, r2, r1)
            if (r2 != 0) goto L85
            if (r1 == 0) goto L86
        L85:
            r4 = 1
        L86:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.H(int, int, int, int, int, int, int, int, boolean):boolean");
    }

    public boolean I(int i8) {
        boolean z7;
        if (i8 == 130) {
            z7 = true;
        } else {
            z7 = false;
        }
        int height = getHeight();
        if (z7) {
            this.f6121h.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.f6121h;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.f6121h.top = getScrollY() - height;
            Rect rect2 = this.f6121h;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.f6121h;
        int i9 = rect3.top;
        int i10 = height + i9;
        rect3.bottom = i10;
        return M(i8, i9, i10);
    }

    public final void Q(int i8, int i9) {
        R(i8, i9, 250, false);
    }

    public final void S(int i8, int i9, int i10) {
        T(i8, i9, i10, false);
    }

    void T(int i8, int i9, int i10, boolean z7) {
        R(i8 - getScrollX(), i9 - getScrollY(), i10, z7);
    }

    void U(int i8, int i9, boolean z7) {
        T(i8, i9, 250, z7);
    }

    public boolean V(int i8, int i9) {
        return this.D.p(i8, i9);
    }

    public void X(int i8) {
        this.D.r(i8);
    }

    @Override // android.view.ViewGroup
    public void addView(@NonNull View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public boolean b(int i8) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i8);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus != null && E(findNextFocus, maxScrollAmount, getHeight())) {
            findNextFocus.getDrawingRect(this.f6121h);
            offsetDescendantRectToMyCoords(findNextFocus, this.f6121h);
            p(f(this.f6121h));
            findNextFocus.requestFocus(i8);
        } else {
            if (i8 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i8 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i8 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            p(maxScrollAmount);
        }
        if (findFocus != null && findFocus.isFocused() && C(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
            return true;
        }
        return true;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f6122i.isFinished()) {
            return;
        }
        this.f6122i.computeScrollOffset();
        int currY = this.f6122i.getCurrY();
        int g8 = g(currY - this.A);
        this.A = currY;
        int[] iArr = this.f6138y;
        boolean z7 = false;
        iArr[1] = 0;
        h(0, g8, iArr, null, 1);
        int i8 = g8 - this.f6138y[1];
        int scrollRange = getScrollRange();
        if (i8 != 0) {
            int scrollY = getScrollY();
            H(0, i8, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
            int scrollY2 = getScrollY() - scrollY;
            int i9 = i8 - scrollY2;
            int[] iArr2 = this.f6138y;
            iArr2[1] = 0;
            l(0, scrollY2, 0, i9, this.f6137x, 1, iArr2);
            i8 = i9 - this.f6138y[1];
        }
        if (i8 != 0) {
            int overScrollMode = getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                z7 = true;
            }
            if (z7) {
                if (i8 < 0) {
                    if (this.f6123j.isFinished()) {
                        this.f6123j.onAbsorb((int) this.f6122i.getCurrVelocity());
                    }
                } else if (this.f6124k.isFinished()) {
                    this.f6124k.onAbsorb((int) this.f6122i.getCurrVelocity());
                }
            }
            a();
        }
        if (!this.f6122i.isFinished()) {
            ViewCompat.j0(this);
        } else {
            X(1);
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        if (scrollY > max) {
            return bottom + (scrollY - max);
        }
        return bottom;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!super.dispatchKeyEvent(keyEvent) && !s(keyEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f8, float f9, boolean z7) {
        return this.D.a(f8, f9, z7);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f8, float f9) {
        return this.D.b(f8, f9);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i8, int i9, int[] iArr, int[] iArr2) {
        return h(i8, i9, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i8, int i9, int i10, int i11, int[] iArr) {
        return this.D.f(i8, i9, i10, i11, iArr);
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        int i8;
        super.draw(canvas);
        int scrollY = getScrollY();
        int i9 = 0;
        if (!this.f6123j.isFinished()) {
            int save = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int min = Math.min(0, scrollY);
            if (Api21Impl.a(this)) {
                width -= getPaddingLeft() + getPaddingRight();
                i8 = getPaddingLeft() + 0;
            } else {
                i8 = 0;
            }
            if (Api21Impl.a(this)) {
                height -= getPaddingTop() + getPaddingBottom();
                min += getPaddingTop();
            }
            canvas.translate(i8, min);
            this.f6123j.setSize(width, height);
            if (this.f6123j.draw(canvas)) {
                ViewCompat.j0(this);
            }
            canvas.restoreToCount(save);
        }
        if (!this.f6124k.isFinished()) {
            int save2 = canvas.save();
            int width2 = getWidth();
            int height2 = getHeight();
            int max = Math.max(getScrollRange(), scrollY) + height2;
            if (Api21Impl.a(this)) {
                width2 -= getPaddingLeft() + getPaddingRight();
                i9 = 0 + getPaddingLeft();
            }
            if (Api21Impl.a(this)) {
                height2 -= getPaddingTop() + getPaddingBottom();
                max -= getPaddingBottom();
            }
            canvas.translate(i9 - width2, max);
            canvas.rotate(180.0f, width2, 0.0f);
            this.f6124k.setSize(width2, height2);
            if (this.f6124k.draw(canvas)) {
                ViewCompat.j0(this);
            }
            canvas.restoreToCount(save2);
        }
    }

    protected int f(Rect rect) {
        int i8;
        int i9;
        int i10;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i11 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        if (rect.bottom < childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin) {
            i8 = i11 - verticalFadingEdgeLength;
        } else {
            i8 = i11;
        }
        int i12 = rect.bottom;
        if (i12 > i8 && rect.top > scrollY) {
            if (rect.height() > height) {
                i10 = rect.top - scrollY;
            } else {
                i10 = rect.bottom - i8;
            }
            return Math.min(i10 + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i11);
        } else if (rect.top >= scrollY || i12 >= i8) {
            return 0;
        } else {
            if (rect.height() > height) {
                i9 = 0 - (i8 - rect.bottom);
            } else {
                i9 = 0 - (scrollY - rect.top);
            }
            return Math.max(i9, -getScrollY());
        }
    }

    int g(int i8) {
        int height = getHeight();
        if (i8 > 0 && EdgeEffectCompat.b(this.f6123j) != 0.0f) {
            int round = Math.round(((-height) / 4.0f) * EdgeEffectCompat.d(this.f6123j, ((-i8) * 4.0f) / height, 0.5f));
            if (round != i8) {
                this.f6123j.finish();
            }
            return i8 - round;
        } else if (i8 < 0 && EdgeEffectCompat.b(this.f6124k) != 0.0f) {
            float f8 = height;
            int round2 = Math.round((f8 / 4.0f) * EdgeEffectCompat.d(this.f6124k, (i8 * 4.0f) / f8, 0.5f));
            if (round2 != i8) {
                this.f6124k.finish();
            }
            return i8 - round2;
        } else {
            return i8;
        }
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.C.a();
    }

    int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public boolean h(int i8, int i9, int[] iArr, int[] iArr2, int i10) {
        return this.D.d(i8, i9, iArr, iArr2, i10);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return x(0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void i(@NonNull View view, @NonNull View view2, int i8, int i9) {
        this.C.c(view, view2, i8, i9);
        V(2, i9);
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.D.l();
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void j(@NonNull View view, int i8) {
        this.C.d(view, i8);
        X(i8);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void k(@NonNull View view, int i8, int i9, @NonNull int[] iArr, int i10) {
        h(i8, i9, iArr, null, i10);
    }

    public void l(int i8, int i9, int i10, int i11, int[] iArr, int i12, @NonNull int[] iArr2) {
        this.D.e(i8, i9, i10, i11, iArr, i12, iArr2);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void m(@NonNull View view, int i8, int i9, int i10, int i11, int i12, @NonNull int[] iArr) {
        F(i11, i12, iArr);
    }

    @Override // android.view.ViewGroup
    protected void measureChild(@NonNull View view, int i8, int i9) {
        view.measure(ViewGroup.getChildMeasureSpec(i8, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i8, int i9, int i10, int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i8, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i9, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void n(@NonNull View view, int i8, int i9, int i10, int i11, int i12) {
        F(i11, i12, null);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean o(@NonNull View view, @NonNull View view2, int i8, int i9) {
        return (i8 & 2) != 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f6127n = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public boolean onGenericMotionEvent(@NonNull MotionEvent motionEvent) {
        float f8;
        boolean z7;
        boolean z8;
        boolean z9;
        int i8 = 0;
        if (motionEvent.getAction() == 8 && !this.f6129p) {
            if (MotionEventCompat.a(motionEvent, 2)) {
                f8 = motionEvent.getAxisValue(9);
            } else if (MotionEventCompat.a(motionEvent, 4194304)) {
                f8 = motionEvent.getAxisValue(26);
            } else {
                f8 = 0.0f;
            }
            if (f8 != 0.0f) {
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int verticalScrollFactorCompat = scrollY - ((int) (f8 * getVerticalScrollFactorCompat()));
                if (verticalScrollFactorCompat < 0) {
                    if (c() && !MotionEventCompat.a(motionEvent, FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    if (z9) {
                        EdgeEffectCompat.d(this.f6123j, (-verticalScrollFactorCompat) / getHeight(), 0.5f);
                        this.f6123j.onRelease();
                        invalidate();
                        z8 = 1;
                    }
                    z8 = 0;
                } else if (verticalScrollFactorCompat > scrollRange) {
                    if (c() && !MotionEventCompat.a(motionEvent, FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (z7) {
                        EdgeEffectCompat.d(this.f6124k, (verticalScrollFactorCompat - scrollRange) / getHeight(), 0.5f);
                        this.f6124k.onRelease();
                        invalidate();
                        i8 = 1;
                    }
                    z8 = i8;
                    i8 = scrollRange;
                } else {
                    i8 = verticalScrollFactorCompat;
                    z8 = 0;
                }
                if (i8 != scrollY) {
                    super.scrollTo(getScrollX(), i8);
                    return true;
                }
                return z8;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NonNull MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z7 = true;
        if (action == 2 && this.f6129p) {
            return true;
        }
        int i8 = action & 255;
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 != 3) {
                        if (i8 == 6) {
                            G(motionEvent);
                        }
                    }
                } else {
                    int i9 = this.f6136w;
                    if (i9 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i9);
                        if (findPointerIndex == -1) {
                            Log.e("NestedScrollView", "Invalid pointerId=" + i9 + " in onInterceptTouchEvent");
                        } else {
                            int y7 = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y7 - this.f6125l) > this.f6133t && (2 & getNestedScrollAxes()) == 0) {
                                this.f6129p = true;
                                this.f6125l = y7;
                                B();
                                this.f6130q.addMovement(motionEvent);
                                this.f6139z = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                }
            }
            this.f6129p = false;
            this.f6136w = -1;
            J();
            if (this.f6122i.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                ViewCompat.j0(this);
            }
            X(0);
        } else {
            int y8 = (int) motionEvent.getY();
            if (!y((int) motionEvent.getX(), y8)) {
                if (!W(motionEvent) && this.f6122i.isFinished()) {
                    z7 = false;
                }
                this.f6129p = z7;
                J();
            } else {
                this.f6125l = y8;
                this.f6136w = motionEvent.getPointerId(0);
                z();
                this.f6130q.addMovement(motionEvent);
                this.f6122i.computeScrollOffset();
                if (!W(motionEvent) && this.f6122i.isFinished()) {
                    z7 = false;
                }
                this.f6129p = z7;
                V(2, 0);
            }
        }
        return this.f6129p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        super.onLayout(z7, i8, i9, i10, i11);
        int i12 = 0;
        this.f6126m = false;
        View view = this.f6128o;
        if (view != null && D(view, this)) {
            N(this.f6128o);
        }
        this.f6128o = null;
        if (!this.f6127n) {
            if (this.B != null) {
                scrollTo(getScrollX(), this.B.f6140f);
                this.B = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i12 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i11 - i9) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int e8 = e(scrollY, paddingTop, i12);
            if (e8 != scrollY) {
                scrollTo(getScrollX(), e8);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f6127n = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        if (this.f6131r && View.MeasureSpec.getMode(i9) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i8, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, Pow2.MAX_POW2));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(@NonNull View view, float f8, float f9, boolean z7) {
        if (!z7) {
            dispatchNestedFling(0.0f, f9, true);
            u((int) f9);
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(@NonNull View view, float f8, float f9) {
        return dispatchNestedPreFling(f8, f9);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(@NonNull View view, int i8, int i9, @NonNull int[] iArr) {
        k(view, i8, i9, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(@NonNull View view, int i8, int i9, int i10, int i11) {
        F(i11, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i8) {
        i(view, view2, i8, 0);
    }

    @Override // android.view.View
    protected void onOverScrolled(int i8, int i9, boolean z7, boolean z8) {
        super.scrollTo(i8, i9);
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i8, Rect rect) {
        View findNextFocusFromRect;
        if (i8 == 2) {
            i8 = 130;
        } else if (i8 == 1) {
            i8 = 33;
        }
        if (rect == null) {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocus(this, null, i8);
        } else {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i8);
        }
        if (findNextFocusFromRect == null || C(findNextFocusFromRect)) {
            return false;
        }
        return findNextFocusFromRect.requestFocus(i8, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.B = savedState;
        requestLayout();
    }

    @Override // android.view.View
    @NonNull
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f6140f = getScrollY();
        return savedState;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i8, int i9, int i10, int i11) {
        super.onScrollChanged(i8, i9, i10, i11);
        OnScrollChangeListener onScrollChangeListener = this.F;
        if (onScrollChangeListener != null) {
            onScrollChangeListener.a(this, i8, i9, i10, i11);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && E(findFocus, 0, i11)) {
            findFocus.getDrawingRect(this.f6121h);
            offsetDescendantRectToMyCoords(findFocus, this.f6121h);
            p(f(this.f6121h));
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i8) {
        return o(view, view2, i8, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(@NonNull View view) {
        j(view, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x01d6  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent r24) {
        /*
            Method dump skipped, instructions count: 616
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.f6126m) {
            N(view2);
        } else {
            this.f6128o = view2;
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(@NonNull View view, Rect rect, boolean z7) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return O(rect, z7);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z7) {
        if (z7) {
            J();
        }
        super.requestDisallowInterceptTouchEvent(z7);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f6126m = true;
        super.requestLayout();
    }

    public boolean s(@NonNull KeyEvent keyEvent) {
        this.f6121h.setEmpty();
        int i8 = 130;
        if (!d()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            if (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(130)) {
                return false;
            }
            return true;
        } else if (keyEvent.getAction() != 0) {
            return false;
        } else {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 19) {
                if (keyCode != 20) {
                    if (keyCode != 62) {
                        return false;
                    }
                    if (keyEvent.isShiftPressed()) {
                        i8 = 33;
                    }
                    I(i8);
                    return false;
                } else if (!keyEvent.isAltPressed()) {
                    return b(130);
                } else {
                    return v(130);
                }
            } else if (!keyEvent.isAltPressed()) {
                return b(33);
            } else {
                return v(33);
            }
        }
    }

    @Override // android.view.View
    public void scrollTo(int i8, int i9) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int e8 = e(i8, (getWidth() - getPaddingLeft()) - getPaddingRight(), childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
            int e9 = e(i9, (getHeight() - getPaddingTop()) - getPaddingBottom(), childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
            if (e8 != getScrollX() || e9 != getScrollY()) {
                super.scrollTo(e8, e9);
            }
        }
    }

    public void setFillViewport(boolean z7) {
        if (z7 != this.f6131r) {
            this.f6131r = z7;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z7) {
        this.D.m(z7);
    }

    public void setOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        this.F = onScrollChangeListener;
    }

    public void setSmoothScrollingEnabled(boolean z7) {
        this.f6132s = z7;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i8) {
        return V(i8, 0);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        X(0);
    }

    public void u(int i8) {
        if (getChildCount() > 0) {
            this.f6122i.fling(getScrollX(), getScrollY(), 0, i8, 0, 0, Integer.MIN_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER, 0, 0);
            L(true);
        }
    }

    public boolean v(int i8) {
        boolean z7;
        int childCount;
        if (i8 == 130) {
            z7 = true;
        } else {
            z7 = false;
        }
        int height = getHeight();
        Rect rect = this.f6121h;
        rect.top = 0;
        rect.bottom = height;
        if (z7 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f6121h.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.f6121h;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.f6121h;
        return M(i8, rect3.top, rect3.bottom);
    }

    public boolean x(int i8) {
        return this.D.k(i8);
    }

    public NestedScrollView(@NonNull Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f6121h = new Rect();
        this.f6126m = true;
        this.f6127n = false;
        this.f6128o = null;
        this.f6129p = false;
        this.f6132s = true;
        this.f6136w = -1;
        this.f6137x = new int[2];
        this.f6138y = new int[2];
        this.f6123j = EdgeEffectCompat.a(context, attributeSet);
        this.f6124k = EdgeEffectCompat.a(context, attributeSet);
        this.f6119f = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        A();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, I, i8, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.C = new NestedScrollingParentHelper(this);
        this.D = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        ViewCompat.s0(this, H);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i8) {
        if (getChildCount() <= 0) {
            super.addView(view, i8);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i8, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i8, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
