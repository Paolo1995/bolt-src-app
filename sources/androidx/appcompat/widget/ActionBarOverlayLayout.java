package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.graphics.Insets;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.gms.common.api.Api;
import j$.util.Spliterator;

@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements DecorContentParent, NestedScrollingParent2, NestedScrollingParent3 {
    static final int[] K = {R$attr.f816b, 16842841};
    @NonNull
    private WindowInsetsCompat A;
    @NonNull
    private WindowInsetsCompat B;
    @NonNull
    private WindowInsetsCompat C;
    private ActionBarVisibilityCallback D;
    private OverScroller E;
    ViewPropertyAnimator F;
    final AnimatorListenerAdapter G;
    private final Runnable H;
    private final Runnable I;
    private final NestedScrollingParentHelper J;

    /* renamed from: f  reason: collision with root package name */
    private int f1751f;

    /* renamed from: g  reason: collision with root package name */
    private int f1752g;

    /* renamed from: h  reason: collision with root package name */
    private ContentFrameLayout f1753h;

    /* renamed from: i  reason: collision with root package name */
    ActionBarContainer f1754i;

    /* renamed from: j  reason: collision with root package name */
    private DecorToolbar f1755j;

    /* renamed from: k  reason: collision with root package name */
    private Drawable f1756k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f1757l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f1758m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f1759n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f1760o;

    /* renamed from: p  reason: collision with root package name */
    boolean f1761p;

    /* renamed from: q  reason: collision with root package name */
    private int f1762q;

    /* renamed from: r  reason: collision with root package name */
    private int f1763r;

    /* renamed from: s  reason: collision with root package name */
    private final Rect f1764s;

    /* renamed from: t  reason: collision with root package name */
    private final Rect f1765t;

    /* renamed from: u  reason: collision with root package name */
    private final Rect f1766u;

    /* renamed from: v  reason: collision with root package name */
    private final Rect f1767v;

    /* renamed from: w  reason: collision with root package name */
    private final Rect f1768w;

    /* renamed from: x  reason: collision with root package name */
    private final Rect f1769x;

    /* renamed from: y  reason: collision with root package name */
    private final Rect f1770y;
    @NonNull

    /* renamed from: z  reason: collision with root package name */
    private WindowInsetsCompat f1771z;

    /* loaded from: classes.dex */
    public interface ActionBarVisibilityCallback {
        void a();

        void b(int i8);

        void c();

        void d(boolean z7);

        void e();

        void f();
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i8, int i9) {
            super(i8, i9);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1752g = 0;
        this.f1764s = new Rect();
        this.f1765t = new Rect();
        this.f1766u = new Rect();
        this.f1767v = new Rect();
        this.f1768w = new Rect();
        this.f1769x = new Rect();
        this.f1770y = new Rect();
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.f5991b;
        this.f1771z = windowInsetsCompat;
        this.A = windowInsetsCompat;
        this.B = windowInsetsCompat;
        this.C = windowInsetsCompat;
        this.G = new AnimatorListenerAdapter() { // from class: androidx.appcompat.widget.ActionBarOverlayLayout.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.F = null;
                actionBarOverlayLayout.f1761p = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.F = null;
                actionBarOverlayLayout.f1761p = false;
            }
        };
        this.H = new Runnable() { // from class: androidx.appcompat.widget.ActionBarOverlayLayout.2
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.u();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.F = actionBarOverlayLayout.f1754i.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.G);
            }
        };
        this.I = new Runnable() { // from class: androidx.appcompat.widget.ActionBarOverlayLayout.3
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.u();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.F = actionBarOverlayLayout.f1754i.animate().translationY(-ActionBarOverlayLayout.this.f1754i.getHeight()).setListener(ActionBarOverlayLayout.this.G);
            }
        };
        v(context);
        this.J = new NestedScrollingParentHelper(this);
    }

    private void A() {
        u();
        this.H.run();
    }

    private boolean B(float f8) {
        this.E.fling(0, 0, 0, (int) f8, 0, 0, Integer.MIN_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER);
        if (this.E.getFinalY() > this.f1754i.getHeight()) {
            return true;
        }
        return false;
    }

    private void p() {
        u();
        this.I.run();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean q(@androidx.annotation.NonNull android.view.View r3, @androidx.annotation.NonNull android.graphics.Rect r4, boolean r5, boolean r6, boolean r7, boolean r8) {
        /*
            r2 = this;
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.ActionBarOverlayLayout$LayoutParams r3 = (androidx.appcompat.widget.ActionBarOverlayLayout.LayoutParams) r3
            r0 = 1
            if (r5 == 0) goto L13
            int r5 = r3.leftMargin
            int r1 = r4.left
            if (r5 == r1) goto L13
            r3.leftMargin = r1
            r5 = 1
            goto L14
        L13:
            r5 = 0
        L14:
            if (r6 == 0) goto L1f
            int r6 = r3.topMargin
            int r1 = r4.top
            if (r6 == r1) goto L1f
            r3.topMargin = r1
            r5 = 1
        L1f:
            if (r8 == 0) goto L2a
            int r6 = r3.rightMargin
            int r8 = r4.right
            if (r6 == r8) goto L2a
            r3.rightMargin = r8
            r5 = 1
        L2a:
            if (r7 == 0) goto L35
            int r6 = r3.bottomMargin
            int r4 = r4.bottom
            if (r6 == r4) goto L35
            r3.bottomMargin = r4
            goto L36
        L35:
            r0 = r5
        L36:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.q(android.view.View, android.graphics.Rect, boolean, boolean, boolean, boolean):boolean");
    }

    private DecorToolbar t(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void v(Context context) {
        boolean z7;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(K);
        boolean z8 = false;
        this.f1751f = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f1756k = drawable;
        if (drawable == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        setWillNotDraw(z7);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z8 = true;
        }
        this.f1757l = z8;
        this.E = new OverScroller(context);
    }

    private void x() {
        u();
        postDelayed(this.I, 600L);
    }

    private void y() {
        u();
        postDelayed(this.H, 600L);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean a() {
        z();
        return this.f1755j.a();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean b() {
        z();
        return this.f1755j.b();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean c() {
        z();
        return this.f1755j.c();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void d(Menu menu, MenuPresenter.Callback callback) {
        z();
        this.f1755j.d(menu, callback);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i8;
        super.draw(canvas);
        if (this.f1756k != null && !this.f1757l) {
            if (this.f1754i.getVisibility() == 0) {
                i8 = (int) (this.f1754i.getBottom() + this.f1754i.getTranslationY() + 0.5f);
            } else {
                i8 = 0;
            }
            this.f1756k.setBounds(0, i8, getWidth(), this.f1756k.getIntrinsicHeight() + i8);
            this.f1756k.draw(canvas);
        }
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean e() {
        z();
        return this.f1755j.e();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void f() {
        z();
        this.f1755j.f();
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean g() {
        z();
        return this.f1755j.g();
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f1754i;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.J.a();
    }

    public CharSequence getTitle() {
        z();
        return this.f1755j.getTitle();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void h(int i8) {
        z();
        if (i8 != 2) {
            if (i8 != 5) {
                if (i8 == 109) {
                    setOverlayMode(true);
                    return;
                }
                return;
            }
            this.f1755j.w();
            return;
        }
        this.f1755j.o();
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void i(View view, View view2, int i8, int i9) {
        if (i9 == 0) {
            onNestedScrollAccepted(view, view2, i8);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void j(View view, int i8) {
        if (i8 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void k(View view, int i8, int i9, int[] iArr, int i10) {
        if (i10 == 0) {
            onNestedPreScroll(view, i8, i9, iArr);
        }
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void l() {
        z();
        this.f1755j.q();
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void m(View view, int i8, int i9, int i10, int i11, int i12, int[] iArr) {
        n(view, i8, i9, i10, i11, i12);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void n(View view, int i8, int i9, int i10, int i11, int i12) {
        if (i12 == 0) {
            onNestedScroll(view, i8, i9, i10, i11);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean o(View view, View view2, int i8, int i9) {
        if (i9 == 0 && onStartNestedScroll(view, view2, i8)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(@NonNull WindowInsets windowInsets) {
        z();
        WindowInsetsCompat w7 = WindowInsetsCompat.w(windowInsets, this);
        boolean q8 = q(this.f1754i, new Rect(w7.j(), w7.l(), w7.k(), w7.i()), true, true, false, true);
        ViewCompat.h(this, w7, this.f1764s);
        Rect rect = this.f1764s;
        WindowInsetsCompat m8 = w7.m(rect.left, rect.top, rect.right, rect.bottom);
        this.f1771z = m8;
        boolean z7 = true;
        if (!this.A.equals(m8)) {
            this.A = this.f1771z;
            q8 = true;
        }
        if (!this.f1765t.equals(this.f1764s)) {
            this.f1765t.set(this.f1764s);
        } else {
            z7 = q8;
        }
        if (z7) {
            requestLayout();
        }
        return w7.a().c().b().u();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        v(getContext());
        ViewCompat.p0(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i13 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                int i14 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + paddingTop;
                childAt.layout(i13, i14, measuredWidth + i13, measuredHeight + i14);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i8, int i9) {
        boolean z7;
        int measuredHeight;
        z();
        measureChildWithMargins(this.f1754i, i8, 0, i9, 0);
        LayoutParams layoutParams = (LayoutParams) this.f1754i.getLayoutParams();
        int max = Math.max(0, this.f1754i.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
        int max2 = Math.max(0, this.f1754i.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f1754i.getMeasuredState());
        if ((ViewCompat.O(this) & Spliterator.NONNULL) != 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            measuredHeight = this.f1751f;
            if (this.f1759n && this.f1754i.getTabContainer() != null) {
                measuredHeight += this.f1751f;
            }
        } else {
            measuredHeight = this.f1754i.getVisibility() != 8 ? this.f1754i.getMeasuredHeight() : 0;
        }
        this.f1766u.set(this.f1764s);
        WindowInsetsCompat windowInsetsCompat = this.f1771z;
        this.B = windowInsetsCompat;
        if (!this.f1758m && !z7) {
            Rect rect = this.f1766u;
            rect.top += measuredHeight;
            rect.bottom += 0;
            this.B = windowInsetsCompat.m(0, measuredHeight, 0, 0);
        } else {
            this.B = new WindowInsetsCompat.Builder(this.B).c(Insets.b(windowInsetsCompat.j(), this.B.l() + measuredHeight, this.B.k(), this.B.i() + 0)).a();
        }
        q(this.f1753h, this.f1766u, true, true, true, true);
        if (!this.C.equals(this.B)) {
            WindowInsetsCompat windowInsetsCompat2 = this.B;
            this.C = windowInsetsCompat2;
            ViewCompat.i(this.f1753h, windowInsetsCompat2);
        }
        measureChildWithMargins(this.f1753h, i8, 0, i9, 0);
        LayoutParams layoutParams2 = (LayoutParams) this.f1753h.getLayoutParams();
        int max3 = Math.max(max, this.f1753h.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
        int max4 = Math.max(max2, this.f1753h.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f1753h.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i8, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i9, combineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f8, float f9, boolean z7) {
        if (this.f1760o && z7) {
            if (B(f9)) {
                p();
            } else {
                A();
            }
            this.f1761p = true;
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f8, float f9) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i8, int i9, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i8, int i9, int i10, int i11) {
        int i12 = this.f1762q + i9;
        this.f1762q = i12;
        setActionBarHideOffset(i12);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i8) {
        this.J.b(view, view2, i8);
        this.f1762q = getActionBarHideOffset();
        u();
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.D;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.f();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i8) {
        if ((i8 & 2) != 0 && this.f1754i.getVisibility() == 0) {
            return this.f1760o;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        if (this.f1760o && !this.f1761p) {
            if (this.f1762q <= this.f1754i.getHeight()) {
                y();
            } else {
                x();
            }
        }
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.D;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.c();
        }
    }

    @Override // android.view.View
    @Deprecated
    public void onWindowSystemUiVisibilityChanged(int i8) {
        boolean z7;
        super.onWindowSystemUiVisibilityChanged(i8);
        z();
        int i9 = this.f1763r ^ i8;
        this.f1763r = i8;
        boolean z8 = false;
        if ((i8 & 4) == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if ((i8 & Spliterator.NONNULL) != 0) {
            z8 = true;
        }
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.D;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.d(!z8);
            if (!z7 && z8) {
                this.D.e();
            } else {
                this.D.a();
            }
        }
        if ((i9 & Spliterator.NONNULL) != 0 && this.D != null) {
            ViewCompat.p0(this);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i8) {
        super.onWindowVisibilityChanged(i8);
        this.f1752g = i8;
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.D;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.b(i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: r */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    /* renamed from: s */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void setActionBarHideOffset(int i8) {
        u();
        this.f1754i.setTranslationY(-Math.max(0, Math.min(i8, this.f1754i.getHeight())));
    }

    public void setActionBarVisibilityCallback(ActionBarVisibilityCallback actionBarVisibilityCallback) {
        this.D = actionBarVisibilityCallback;
        if (getWindowToken() != null) {
            this.D.b(this.f1752g);
            int i8 = this.f1763r;
            if (i8 != 0) {
                onWindowSystemUiVisibilityChanged(i8);
                ViewCompat.p0(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z7) {
        this.f1759n = z7;
    }

    public void setHideOnContentScrollEnabled(boolean z7) {
        if (z7 != this.f1760o) {
            this.f1760o = z7;
            if (!z7) {
                u();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i8) {
        z();
        this.f1755j.setIcon(i8);
    }

    public void setLogo(int i8) {
        z();
        this.f1755j.s(i8);
    }

    public void setOverlayMode(boolean z7) {
        boolean z8;
        this.f1758m = z7;
        if (z7 && getContext().getApplicationInfo().targetSdkVersion < 19) {
            z8 = true;
        } else {
            z8 = false;
        }
        this.f1757l = z8;
    }

    public void setShowingForActionMode(boolean z7) {
    }

    public void setUiOptions(int i8) {
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setWindowCallback(Window.Callback callback) {
        z();
        this.f1755j.setWindowCallback(callback);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setWindowTitle(CharSequence charSequence) {
        z();
        this.f1755j.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    void u() {
        removeCallbacks(this.H);
        removeCallbacks(this.I);
        ViewPropertyAnimator viewPropertyAnimator = this.F;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public boolean w() {
        return this.f1758m;
    }

    void z() {
        if (this.f1753h == null) {
            this.f1753h = (ContentFrameLayout) findViewById(R$id.f892b);
            this.f1754i = (ActionBarContainer) findViewById(R$id.f893c);
            this.f1755j = t(findViewById(R$id.f891a));
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        z();
        this.f1755j.setIcon(drawable);
    }
}
