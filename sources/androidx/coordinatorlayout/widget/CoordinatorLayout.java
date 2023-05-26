package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.R$attr;
import androidx.coordinatorlayout.R$style;
import androidx.coordinatorlayout.R$styleable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SynchronizedPool;
import androidx.core.view.GravityCompat;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent2, NestedScrollingParent3 {
    static final Class<?>[] A;
    static final ThreadLocal<Map<String, Constructor<Behavior>>> B;
    static final Comparator<View> C;
    private static final Pools$Pool<Rect> D;

    /* renamed from: z  reason: collision with root package name */
    static final String f5431z;

    /* renamed from: f  reason: collision with root package name */
    private final List<View> f5432f;

    /* renamed from: g  reason: collision with root package name */
    private final DirectedAcyclicGraph<View> f5433g;

    /* renamed from: h  reason: collision with root package name */
    private final List<View> f5434h;

    /* renamed from: i  reason: collision with root package name */
    private final List<View> f5435i;

    /* renamed from: j  reason: collision with root package name */
    private Paint f5436j;

    /* renamed from: k  reason: collision with root package name */
    private final int[] f5437k;

    /* renamed from: l  reason: collision with root package name */
    private final int[] f5438l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f5439m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f5440n;

    /* renamed from: o  reason: collision with root package name */
    private int[] f5441o;

    /* renamed from: p  reason: collision with root package name */
    private View f5442p;

    /* renamed from: q  reason: collision with root package name */
    private View f5443q;

    /* renamed from: r  reason: collision with root package name */
    private OnPreDrawListener f5444r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f5445s;

    /* renamed from: t  reason: collision with root package name */
    private WindowInsetsCompat f5446t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f5447u;

    /* renamed from: v  reason: collision with root package name */
    private Drawable f5448v;

    /* renamed from: w  reason: collision with root package name */
    ViewGroup.OnHierarchyChangeListener f5449w;

    /* renamed from: x  reason: collision with root package name */
    private OnApplyWindowInsetsListener f5450x;

    /* renamed from: y  reason: collision with root package name */
    private final NestedScrollingParentHelper f5451y;

    /* loaded from: classes.dex */
    public interface AttachedBehavior {
        @NonNull
        Behavior getBehavior();
    }

    /* loaded from: classes.dex */
    public static abstract class Behavior<V extends View> {
        public Behavior() {
        }

        public boolean A(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull View view, @NonNull View view2, int i8, int i9) {
            if (i9 == 0) {
                return z(coordinatorLayout, v7, view, view2, i8);
            }
            return false;
        }

        @Deprecated
        public void B(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull View view) {
        }

        public void C(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull View view, int i8) {
            if (i8 == 0) {
                B(coordinatorLayout, v7, view);
            }
        }

        public boolean D(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull MotionEvent motionEvent) {
            return false;
        }

        public boolean a(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7) {
            if (d(coordinatorLayout, v7) > 0.0f) {
                return true;
            }
            return false;
        }

        public boolean b(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull Rect rect) {
            return false;
        }

        public int c(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7) {
            return -16777216;
        }

        public float d(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7) {
            return 0.0f;
        }

        public boolean e(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull View view) {
            return false;
        }

        @NonNull
        public WindowInsetsCompat f(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        public void g(@NonNull LayoutParams layoutParams) {
        }

        public boolean h(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull View view) {
            return false;
        }

        public void i(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull View view) {
        }

        public void j() {
        }

        public boolean k(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull MotionEvent motionEvent) {
            return false;
        }

        public boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, int i8) {
            return false;
        }

        public boolean m(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, int i8, int i9, int i10, int i11) {
            return false;
        }

        public boolean n(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull View view, float f8, float f9, boolean z7) {
            return false;
        }

        public boolean o(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull View view, float f8, float f9) {
            return false;
        }

        @Deprecated
        public void p(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull View view, int i8, int i9, @NonNull int[] iArr) {
        }

        public void q(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull View view, int i8, int i9, @NonNull int[] iArr, int i10) {
            if (i10 == 0) {
                p(coordinatorLayout, v7, view, i8, i9, iArr);
            }
        }

        @Deprecated
        public void r(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull View view, int i8, int i9, int i10, int i11) {
        }

        @Deprecated
        public void s(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull View view, int i8, int i9, int i10, int i11, int i12) {
            if (i12 == 0) {
                r(coordinatorLayout, v7, view, i8, i9, i10, i11);
            }
        }

        public void t(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull View view, int i8, int i9, int i10, int i11, int i12, @NonNull int[] iArr) {
            iArr[0] = iArr[0] + i10;
            iArr[1] = iArr[1] + i11;
            s(coordinatorLayout, v7, view, i8, i9, i10, i11, i12);
        }

        @Deprecated
        public void u(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull View view, @NonNull View view2, int i8) {
        }

        public void v(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull View view, @NonNull View view2, int i8, int i9) {
            if (i9 == 0) {
                u(coordinatorLayout, v7, view, view2, i8);
            }
        }

        public boolean w(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull Rect rect, boolean z7) {
            return false;
        }

        public void x(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull Parcelable parcelable) {
        }

        public Parcelable y(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public boolean z(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull View view, @NonNull View view2, int i8) {
            return false;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    /* loaded from: classes.dex */
    public @interface DefaultBehavior {
        Class<? extends Behavior> value();
    }

    /* loaded from: classes.dex */
    private class HierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        HierarchyChangeListener() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f5449w;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.I(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f5449w;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class OnPreDrawListener implements ViewTreeObserver.OnPreDrawListener {
        OnPreDrawListener() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.I(0);
            return true;
        }
    }

    /* loaded from: classes.dex */
    static class ViewElevationComparator implements Comparator<View> {
        ViewElevationComparator() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(View view, View view2) {
            float P = ViewCompat.P(view);
            float P2 = ViewCompat.P(view2);
            if (P > P2) {
                return -1;
            }
            if (P < P2) {
                return 1;
            }
            return 0;
        }
    }

    static {
        String str;
        Package r02 = CoordinatorLayout.class.getPackage();
        if (r02 != null) {
            str = r02.getName();
        } else {
            str = null;
        }
        f5431z = str;
        C = new ViewElevationComparator();
        A = new Class[]{Context.class, AttributeSet.class};
        B = new ThreadLocal<>();
        D = new Pools$SynchronizedPool(12);
    }

    public CoordinatorLayout(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.f5413a);
    }

    private void A(List<View> list) {
        int i8;
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i9 = childCount - 1; i9 >= 0; i9--) {
            if (isChildrenDrawingOrderEnabled) {
                i8 = getChildDrawingOrder(childCount, i9);
            } else {
                i8 = i9;
            }
            list.add(getChildAt(i8));
        }
        Comparator<View> comparator = C;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    private boolean B(View view) {
        return this.f5433g.j(view);
    }

    private void D(View view, int i8) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect b8 = b();
        b8.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        if (this.f5446t != null && ViewCompat.B(this) && !ViewCompat.B(view)) {
            b8.left += this.f5446t.j();
            b8.top += this.f5446t.l();
            b8.right -= this.f5446t.k();
            b8.bottom -= this.f5446t.i();
        }
        Rect b9 = b();
        GravityCompat.a(T(layoutParams.f5456c), view.getMeasuredWidth(), view.getMeasuredHeight(), b8, b9, i8);
        view.layout(b9.left, b9.top, b9.right, b9.bottom);
        P(b8);
        P(b9);
    }

    private void E(View view, View view2, int i8) {
        Rect b8 = b();
        Rect b9 = b();
        try {
            u(view2, b8);
            v(view, i8, b8, b9);
            view.layout(b9.left, b9.top, b9.right, b9.bottom);
        } finally {
            P(b8);
            P(b9);
        }
    }

    private void F(View view, int i8, int i9) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int b8 = GravityCompat.b(U(layoutParams.f5456c), i9);
        int i10 = b8 & 7;
        int i11 = b8 & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i9 == 1) {
            i8 = width - i8;
        }
        int x7 = x(i8) - measuredWidth;
        int i12 = 0;
        if (i10 != 1) {
            if (i10 == 5) {
                x7 += measuredWidth;
            }
        } else {
            x7 += measuredWidth / 2;
        }
        if (i11 != 16) {
            if (i11 == 80) {
                i12 = measuredHeight + 0;
            }
        } else {
            i12 = 0 + (measuredHeight / 2);
        }
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, Math.min(x7, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, Math.min(i12, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin));
        view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }

    private void G(View view, Rect rect, int i8) {
        boolean z7;
        boolean z8;
        int width;
        int i9;
        int i10;
        int i11;
        int height;
        int i12;
        int i13;
        int i14;
        if (ViewCompat.W(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Behavior f8 = layoutParams.f();
            Rect b8 = b();
            Rect b9 = b();
            b9.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (f8 != null && f8.b(this, view, b8)) {
                if (!b9.contains(b8)) {
                    throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + b8.toShortString() + " | Bounds:" + b9.toShortString());
                }
            } else {
                b8.set(b9);
            }
            P(b9);
            if (b8.isEmpty()) {
                P(b8);
                return;
            }
            int b10 = GravityCompat.b(layoutParams.f5461h, i8);
            boolean z9 = true;
            if ((b10 & 48) == 48 && (i13 = (b8.top - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - layoutParams.f5463j) < (i14 = rect.top)) {
                W(view, i14 - i13);
                z7 = true;
            } else {
                z7 = false;
            }
            if ((b10 & 80) == 80 && (height = ((getHeight() - b8.bottom) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) + layoutParams.f5463j) < (i12 = rect.bottom)) {
                W(view, height - i12);
                z7 = true;
            }
            if (!z7) {
                W(view, 0);
            }
            if ((b10 & 3) == 3 && (i10 = (b8.left - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - layoutParams.f5462i) < (i11 = rect.left)) {
                V(view, i11 - i10);
                z8 = true;
            } else {
                z8 = false;
            }
            if ((b10 & 5) == 5 && (width = ((getWidth() - b8.right) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) + layoutParams.f5462i) < (i9 = rect.right)) {
                V(view, width - i9);
            } else {
                z9 = z8;
            }
            if (!z9) {
                V(view, 0);
            }
            P(b8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static Behavior L(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            String str2 = f5431z;
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + '.' + str;
            }
        }
        try {
            ThreadLocal<Map<String, Constructor<Behavior>>> threadLocal = B;
            Map<String, Constructor<Behavior>> map = threadLocal.get();
            if (map == null) {
                map = new HashMap<>();
                threadLocal.set(map);
            }
            Constructor<Behavior> constructor = map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(A);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return constructor.newInstance(context, attributeSet);
        } catch (Exception e8) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e8);
        }
    }

    private boolean M(MotionEvent motionEvent, int i8) {
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.f5434h;
        A(list);
        int size = list.size();
        MotionEvent motionEvent2 = null;
        boolean z7 = false;
        boolean z8 = false;
        for (int i9 = 0; i9 < size; i9++) {
            View view = list.get(i9);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Behavior f8 = layoutParams.f();
            if ((z7 || z8) && actionMasked != 0) {
                if (f8 != null) {
                    if (motionEvent2 == null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    }
                    if (i8 != 0) {
                        if (i8 == 1) {
                            f8.D(this, view, motionEvent2);
                        }
                    } else {
                        f8.k(this, view, motionEvent2);
                    }
                }
            } else {
                if (!z7 && f8 != null) {
                    if (i8 != 0) {
                        if (i8 == 1) {
                            z7 = f8.D(this, view, motionEvent);
                        }
                    } else {
                        z7 = f8.k(this, view, motionEvent);
                    }
                    if (z7) {
                        this.f5442p = view;
                    }
                }
                boolean c8 = layoutParams.c();
                boolean i10 = layoutParams.i(this, view);
                if (i10 && !c8) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (i10 && !z8) {
                    break;
                }
            }
        }
        list.clear();
        return z7;
    }

    private void N() {
        this.f5432f.clear();
        this.f5433g.c();
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            LayoutParams z7 = z(childAt);
            z7.d(this, childAt);
            this.f5433g.b(childAt);
            for (int i9 = 0; i9 < childCount; i9++) {
                if (i9 != i8) {
                    View childAt2 = getChildAt(i9);
                    if (z7.b(this, childAt, childAt2)) {
                        if (!this.f5433g.d(childAt2)) {
                            this.f5433g.b(childAt2);
                        }
                        this.f5433g.a(childAt2, childAt);
                    }
                }
            }
        }
        this.f5432f.addAll(this.f5433g.i());
        Collections.reverse(this.f5432f);
    }

    private static void P(@NonNull Rect rect) {
        rect.setEmpty();
        D.a(rect);
    }

    private void R(boolean z7) {
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            Behavior f8 = ((LayoutParams) childAt.getLayoutParams()).f();
            if (f8 != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z7) {
                    f8.k(this, childAt, obtain);
                } else {
                    f8.D(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i9 = 0; i9 < childCount; i9++) {
            ((LayoutParams) getChildAt(i9).getLayoutParams()).m();
        }
        this.f5442p = null;
        this.f5439m = false;
    }

    private static int S(int i8) {
        if (i8 == 0) {
            return 17;
        }
        return i8;
    }

    private static int T(int i8) {
        if ((i8 & 7) == 0) {
            i8 |= 8388611;
        }
        return (i8 & 112) == 0 ? i8 | 48 : i8;
    }

    private static int U(int i8) {
        if (i8 == 0) {
            return 8388661;
        }
        return i8;
    }

    private void V(View view, int i8) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i9 = layoutParams.f5462i;
        if (i9 != i8) {
            ViewCompat.c0(view, i8 - i9);
            layoutParams.f5462i = i8;
        }
    }

    private void W(View view, int i8) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i9 = layoutParams.f5463j;
        if (i9 != i8) {
            ViewCompat.d0(view, i8 - i9);
            layoutParams.f5463j = i8;
        }
    }

    private void Y() {
        if (ViewCompat.B(this)) {
            if (this.f5450x == null) {
                this.f5450x = new OnApplyWindowInsetsListener() { // from class: androidx.coordinatorlayout.widget.CoordinatorLayout.1
                    @Override // androidx.core.view.OnApplyWindowInsetsListener
                    public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
                        return CoordinatorLayout.this.X(windowInsetsCompat);
                    }
                };
            }
            ViewCompat.G0(this, this.f5450x);
            setSystemUiVisibility(1280);
            return;
        }
        ViewCompat.G0(this, null);
    }

    @NonNull
    private static Rect b() {
        Rect b8 = D.b();
        if (b8 == null) {
            return new Rect();
        }
        return b8;
    }

    private static int d(int i8, int i9, int i10) {
        return i8 < i9 ? i9 : i8 > i10 ? i10 : i8;
    }

    private void e(LayoutParams layoutParams, Rect rect, int i8, int i9) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i8) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i9) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin));
        rect.set(max, max2, i8 + max, i9 + max2);
    }

    private WindowInsetsCompat f(WindowInsetsCompat windowInsetsCompat) {
        Behavior f8;
        if (windowInsetsCompat.o()) {
            return windowInsetsCompat;
        }
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (ViewCompat.B(childAt) && (f8 = ((LayoutParams) childAt.getLayoutParams()).f()) != null) {
                windowInsetsCompat = f8.f(this, childAt, windowInsetsCompat);
                if (windowInsetsCompat.o()) {
                    break;
                }
            }
        }
        return windowInsetsCompat;
    }

    private void w(View view, int i8, Rect rect, Rect rect2, LayoutParams layoutParams, int i9, int i10) {
        int width;
        int height;
        int b8 = GravityCompat.b(S(layoutParams.f5456c), i8);
        int b9 = GravityCompat.b(T(layoutParams.f5457d), i8);
        int i11 = b8 & 7;
        int i12 = b8 & 112;
        int i13 = b9 & 7;
        int i14 = b9 & 112;
        if (i13 != 1) {
            if (i13 != 5) {
                width = rect.left;
            } else {
                width = rect.right;
            }
        } else {
            width = rect.left + (rect.width() / 2);
        }
        if (i14 != 16) {
            if (i14 != 80) {
                height = rect.top;
            } else {
                height = rect.bottom;
            }
        } else {
            height = rect.top + (rect.height() / 2);
        }
        if (i11 != 1) {
            if (i11 != 5) {
                width -= i9;
            }
        } else {
            width -= i9 / 2;
        }
        if (i12 != 16) {
            if (i12 != 80) {
                height -= i10;
            }
        } else {
            height -= i10 / 2;
        }
        rect2.set(width, height, i9 + width, i10 + height);
    }

    private int x(int i8) {
        int[] iArr = this.f5441o;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i8);
            return 0;
        } else if (i8 >= 0 && i8 < iArr.length) {
            return iArr[i8];
        } else {
            Log.e("CoordinatorLayout", "Keyline index " + i8 + " out of range for " + this);
            return 0;
        }
    }

    public boolean C(@NonNull View view, int i8, int i9) {
        Rect b8 = b();
        u(view, b8);
        try {
            return b8.contains(i8, i9);
        } finally {
            P(b8);
        }
    }

    void H(View view, int i8) {
        Behavior f8;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.f5464k != null) {
            Rect b8 = b();
            Rect b9 = b();
            Rect b10 = b();
            u(layoutParams.f5464k, b8);
            boolean z7 = false;
            r(view, false, b9);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            w(view, i8, b8, b10, layoutParams, measuredWidth, measuredHeight);
            z7 = (b10.left == b9.left && b10.top == b9.top) ? true : true;
            e(layoutParams, b10, measuredWidth, measuredHeight);
            int i9 = b10.left - b9.left;
            int i10 = b10.top - b9.top;
            if (i9 != 0) {
                ViewCompat.c0(view, i9);
            }
            if (i10 != 0) {
                ViewCompat.d0(view, i10);
            }
            if (z7 && (f8 = layoutParams.f()) != null) {
                f8.h(this, view, layoutParams.f5464k);
            }
            P(b8);
            P(b9);
            P(b10);
        }
    }

    final void I(int i8) {
        boolean z7;
        int E = ViewCompat.E(this);
        int size = this.f5432f.size();
        Rect b8 = b();
        Rect b9 = b();
        Rect b10 = b();
        for (int i9 = 0; i9 < size; i9++) {
            View view = this.f5432f.get(i9);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (i8 != 0 || view.getVisibility() != 8) {
                for (int i10 = 0; i10 < i9; i10++) {
                    if (layoutParams.f5465l == this.f5432f.get(i10)) {
                        H(view, E);
                    }
                }
                r(view, true, b9);
                if (layoutParams.f5460g != 0 && !b9.isEmpty()) {
                    int b11 = GravityCompat.b(layoutParams.f5460g, E);
                    int i11 = b11 & 112;
                    if (i11 != 48) {
                        if (i11 == 80) {
                            b8.bottom = Math.max(b8.bottom, getHeight() - b9.top);
                        }
                    } else {
                        b8.top = Math.max(b8.top, b9.bottom);
                    }
                    int i12 = b11 & 7;
                    if (i12 != 3) {
                        if (i12 == 5) {
                            b8.right = Math.max(b8.right, getWidth() - b9.left);
                        }
                    } else {
                        b8.left = Math.max(b8.left, b9.right);
                    }
                }
                if (layoutParams.f5461h != 0 && view.getVisibility() == 0) {
                    G(view, b8, E);
                }
                if (i8 != 2) {
                    y(view, b10);
                    if (!b10.equals(b9)) {
                        O(view, b9);
                    }
                }
                for (int i13 = i9 + 1; i13 < size; i13++) {
                    View view2 = this.f5432f.get(i13);
                    LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
                    Behavior f8 = layoutParams2.f();
                    if (f8 != null && f8.e(this, view2, view)) {
                        if (i8 == 0 && layoutParams2.g()) {
                            layoutParams2.k();
                        } else {
                            if (i8 != 2) {
                                z7 = f8.h(this, view2, view);
                            } else {
                                f8.i(this, view2, view);
                                z7 = true;
                            }
                            if (i8 == 1) {
                                layoutParams2.p(z7);
                            }
                        }
                    }
                }
            }
        }
        P(b8);
        P(b9);
        P(b10);
    }

    public void J(@NonNull View view, int i8) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.a()) {
            View view2 = layoutParams.f5464k;
            if (view2 != null) {
                E(view, view2, i8);
                return;
            }
            int i9 = layoutParams.f5458e;
            if (i9 >= 0) {
                F(view, i9, i8);
                return;
            } else {
                D(view, i8);
                return;
            }
        }
        throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
    }

    public void K(View view, int i8, int i9, int i10, int i11) {
        measureChildWithMargins(view, i8, i9, i10, i11);
    }

    void O(View view, Rect rect) {
        ((LayoutParams) view.getLayoutParams()).q(rect);
    }

    void Q() {
        if (this.f5440n && this.f5444r != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f5444r);
        }
        this.f5445s = false;
    }

    final WindowInsetsCompat X(WindowInsetsCompat windowInsetsCompat) {
        boolean z7;
        if (!ObjectsCompat.a(this.f5446t, windowInsetsCompat)) {
            this.f5446t = windowInsetsCompat;
            boolean z8 = true;
            if (windowInsetsCompat != null && windowInsetsCompat.l() > 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            this.f5447u = z7;
            setWillNotDraw((z7 || getBackground() != null) ? false : false);
            WindowInsetsCompat f8 = f(windowInsetsCompat);
            requestLayout();
            return f8;
        }
        return windowInsetsCompat;
    }

    void c() {
        if (this.f5440n) {
            if (this.f5444r == null) {
                this.f5444r = new OnPreDrawListener();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f5444r);
        }
        this.f5445s = true;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams)) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j8) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Behavior behavior = layoutParams.f5454a;
        if (behavior != null) {
            float d8 = behavior.d(this, view);
            if (d8 > 0.0f) {
                if (this.f5436j == null) {
                    this.f5436j = new Paint();
                }
                this.f5436j.setColor(layoutParams.f5454a.c(this, view));
                this.f5436j.setAlpha(d(Math.round(d8 * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.f5436j);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f5448v;
        boolean z7 = false;
        if (drawable != null && drawable.isStateful()) {
            z7 = false | drawable.setState(drawableState);
        }
        if (z7) {
            invalidate();
        }
    }

    public void g(@NonNull View view) {
        List g8 = this.f5433g.g(view);
        if (g8 != null && !g8.isEmpty()) {
            for (int i8 = 0; i8 < g8.size(); i8++) {
                View view2 = (View) g8.get(i8);
                Behavior f8 = ((LayoutParams) view2.getLayoutParams()).f();
                if (f8 != null) {
                    f8.h(this, view2, view);
                }
            }
        }
    }

    final List<View> getDependencySortedChildren() {
        N();
        return Collections.unmodifiableList(this.f5432f);
    }

    public final WindowInsetsCompat getLastWindowInsets() {
        return this.f5446t;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f5451y.a();
    }

    public Drawable getStatusBarBackground() {
        return this.f5448v;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    void h() {
        int childCount = getChildCount();
        boolean z7 = false;
        int i8 = 0;
        while (true) {
            if (i8 >= childCount) {
                break;
            } else if (B(getChildAt(i8))) {
                z7 = true;
                break;
            } else {
                i8++;
            }
        }
        if (z7 != this.f5445s) {
            if (z7) {
                c();
            } else {
                Q();
            }
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void i(View view, View view2, int i8, int i9) {
        Behavior f8;
        this.f5451y.c(view, view2, i8, i9);
        this.f5443q = view2;
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.j(i9) && (f8 = layoutParams.f()) != null) {
                f8.v(this, childAt, view, view2, i8, i9);
            }
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void j(View view, int i8) {
        this.f5451y.d(view, i8);
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.j(i8)) {
                Behavior f8 = layoutParams.f();
                if (f8 != null) {
                    f8.C(this, childAt, view, i8);
                }
                layoutParams.l(i8);
                layoutParams.k();
            }
        }
        this.f5443q = null;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void k(View view, int i8, int i9, int[] iArr, int i10) {
        Behavior f8;
        int min;
        int min2;
        int childCount = getChildCount();
        boolean z7 = false;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.j(i10) && (f8 = layoutParams.f()) != null) {
                    int[] iArr2 = this.f5437k;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    f8.q(this, childAt, view, i8, i9, iArr2, i10);
                    int[] iArr3 = this.f5437k;
                    if (i8 > 0) {
                        min = Math.max(i11, iArr3[0]);
                    } else {
                        min = Math.min(i11, iArr3[0]);
                    }
                    i11 = min;
                    int[] iArr4 = this.f5437k;
                    if (i9 > 0) {
                        min2 = Math.max(i12, iArr4[1]);
                    } else {
                        min2 = Math.min(i12, iArr4[1]);
                    }
                    i12 = min2;
                    z7 = true;
                }
            }
        }
        iArr[0] = i11;
        iArr[1] = i12;
        if (z7) {
            I(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: l */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void m(@NonNull View view, int i8, int i9, int i10, int i11, int i12, @NonNull int[] iArr) {
        Behavior f8;
        int min;
        int min2;
        int childCount = getChildCount();
        boolean z7 = false;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.j(i12) && (f8 = layoutParams.f()) != null) {
                    int[] iArr2 = this.f5437k;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    f8.t(this, childAt, view, i8, i9, i10, i11, i12, iArr2);
                    int[] iArr3 = this.f5437k;
                    if (i10 > 0) {
                        min = Math.max(i13, iArr3[0]);
                    } else {
                        min = Math.min(i13, iArr3[0]);
                    }
                    i13 = min;
                    if (i11 > 0) {
                        min2 = Math.max(i14, this.f5437k[1]);
                    } else {
                        min2 = Math.min(i14, this.f5437k[1]);
                    }
                    i14 = min2;
                    z7 = true;
                }
            }
        }
        iArr[0] = iArr[0] + i13;
        iArr[1] = iArr[1] + i14;
        if (z7) {
            I(1);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void n(View view, int i8, int i9, int i10, int i11, int i12) {
        m(view, i8, i9, i10, i11, 0, this.f5438l);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean o(View view, View view2, int i8, int i9) {
        int childCount = getChildCount();
        boolean z7 = false;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Behavior f8 = layoutParams.f();
                if (f8 != null) {
                    boolean A2 = f8.A(this, childAt, view, view2, i8, i9);
                    z7 |= A2;
                    layoutParams.r(i9, A2);
                } else {
                    layoutParams.r(i9, false);
                }
            }
        }
        return z7;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        R(false);
        if (this.f5445s) {
            if (this.f5444r == null) {
                this.f5444r = new OnPreDrawListener();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f5444r);
        }
        if (this.f5446t == null && ViewCompat.B(this)) {
            ViewCompat.p0(this);
        }
        this.f5440n = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        R(false);
        if (this.f5445s && this.f5444r != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f5444r);
        }
        View view = this.f5443q;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.f5440n = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i8;
        super.onDraw(canvas);
        if (this.f5447u && this.f5448v != null) {
            WindowInsetsCompat windowInsetsCompat = this.f5446t;
            if (windowInsetsCompat != null) {
                i8 = windowInsetsCompat.l();
            } else {
                i8 = 0;
            }
            if (i8 > 0) {
                this.f5448v.setBounds(0, 0, getWidth(), i8);
                this.f5448v.draw(canvas);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            R(true);
        }
        boolean M = M(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            R(true);
        }
        return M;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        Behavior f8;
        int E = ViewCompat.E(this);
        int size = this.f5432f.size();
        for (int i12 = 0; i12 < size; i12++) {
            View view = this.f5432f.get(i12);
            if (view.getVisibility() != 8 && ((f8 = ((LayoutParams) view.getLayoutParams()).f()) == null || !f8.l(this, view, E))) {
                J(view, E);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x011a, code lost:
        if (r0.m(r30, r20, r11, r21, r23, 0) == false) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x011d  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r31, int r32) {
        /*
            Method dump skipped, instructions count: 391
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f8, float f9, boolean z7) {
        Behavior f10;
        int childCount = getChildCount();
        boolean z8 = false;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.j(0) && (f10 = layoutParams.f()) != null) {
                    z8 |= f10.n(this, childAt, view, f8, f9, z7);
                }
            }
        }
        if (z8) {
            I(1);
        }
        return z8;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f8, float f9) {
        Behavior f10;
        int childCount = getChildCount();
        boolean z7 = false;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.j(0) && (f10 = layoutParams.f()) != null) {
                    z7 |= f10.o(this, childAt, view, f8, f9);
                }
            }
        }
        return z7;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i8, int i9, int[] iArr) {
        k(view, i8, i9, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i8, int i9, int i10, int i11) {
        n(view, i8, i9, i10, i11, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i8) {
        i(view, view2, i8, 0);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        SparseArray<Parcelable> sparseArray = savedState.f5473h;
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            int id = childAt.getId();
            Behavior f8 = z(childAt).f();
            if (id != -1 && f8 != null && (parcelable2 = sparseArray.get(id)) != null) {
                f8.x(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable y7;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            int id = childAt.getId();
            Behavior f8 = ((LayoutParams) childAt.getLayoutParams()).f();
            if (id != -1 && f8 != null && (y7 = f8.y(this, childAt)) != null) {
                sparseArray.append(id, y7);
            }
        }
        savedState.f5473h = sparseArray;
        return savedState;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i8) {
        return o(view, view2, i8, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        j(view, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
        if (r3 != false) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.f5442p
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L15
            boolean r3 = r0.M(r1, r4)
            if (r3 == 0) goto L2b
            goto L16
        L15:
            r3 = 0
        L16:
            android.view.View r6 = r0.f5442p
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r6 = r6.f()
            if (r6 == 0) goto L2b
            android.view.View r7 = r0.f5442p
            boolean r6 = r6.D(r0, r7, r1)
            goto L2c
        L2b:
            r6 = 0
        L2c:
            android.view.View r7 = r0.f5442p
            r8 = 0
            if (r7 != 0) goto L37
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L4a
        L37:
            if (r3 == 0) goto L4a
            long r11 = android.os.SystemClock.uptimeMillis()
            r13 = 3
            r14 = 0
            r15 = 0
            r16 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L4a:
            if (r8 == 0) goto L4f
            r8.recycle()
        L4f:
            if (r2 == r4) goto L54
            r1 = 3
            if (r2 != r1) goto L57
        L54:
            r0.R(r5)
        L57:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    /* renamed from: p */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: q */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    void r(View view, boolean z7, Rect rect) {
        if (!view.isLayoutRequested() && view.getVisibility() != 8) {
            if (z7) {
                u(view, rect);
                return;
            } else {
                rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                return;
            }
        }
        rect.setEmpty();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z7) {
        Behavior f8 = ((LayoutParams) view.getLayoutParams()).f();
        if (f8 != null && f8.w(this, view, rect, z7)) {
            return true;
        }
        return super.requestChildRectangleOnScreen(view, rect, z7);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z7) {
        super.requestDisallowInterceptTouchEvent(z7);
        if (z7 && !this.f5439m) {
            R(false);
            this.f5439m = true;
        }
    }

    @NonNull
    public List<View> s(@NonNull View view) {
        List<View> h8 = this.f5433g.h(view);
        this.f5435i.clear();
        if (h8 != null) {
            this.f5435i.addAll(h8);
        }
        return this.f5435i;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z7) {
        super.setFitsSystemWindows(z7);
        Y();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f5449w = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        boolean z7;
        Drawable drawable2 = this.f5448v;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f5448v = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f5448v.setState(getDrawableState());
                }
                DrawableCompat.m(this.f5448v, ViewCompat.E(this));
                Drawable drawable4 = this.f5448v;
                if (getVisibility() == 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                drawable4.setVisible(z7, false);
                this.f5448v.setCallback(this);
            }
            ViewCompat.j0(this);
        }
    }

    public void setStatusBarBackgroundColor(int i8) {
        setStatusBarBackground(new ColorDrawable(i8));
    }

    public void setStatusBarBackgroundResource(int i8) {
        Drawable drawable;
        if (i8 != 0) {
            drawable = ContextCompat.getDrawable(getContext(), i8);
        } else {
            drawable = null;
        }
        setStatusBarBackground(drawable);
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
        Drawable drawable = this.f5448v;
        if (drawable != null && drawable.isVisible() != z7) {
            this.f5448v.setVisible(z7, false);
        }
    }

    @NonNull
    public List<View> t(@NonNull View view) {
        List g8 = this.f5433g.g(view);
        this.f5435i.clear();
        if (g8 != null) {
            this.f5435i.addAll(g8);
        }
        return this.f5435i;
    }

    void u(View view, Rect rect) {
        ViewGroupUtils.a(this, view, rect);
    }

    void v(View view, int i8, Rect rect, Rect rect2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        w(view, i8, rect, rect2, layoutParams, measuredWidth, measuredHeight);
        e(layoutParams, rect2, measuredWidth, measuredHeight);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.f5448v) {
            return false;
        }
        return true;
    }

    void y(View view, Rect rect) {
        rect.set(((LayoutParams) view.getLayoutParams()).h());
    }

    LayoutParams z(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.f5455b) {
            if (view instanceof AttachedBehavior) {
                Behavior behavior = ((AttachedBehavior) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                layoutParams.o(behavior);
                layoutParams.f5455b = true;
            } else {
                DefaultBehavior defaultBehavior = null;
                for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    defaultBehavior = (DefaultBehavior) cls.getAnnotation(DefaultBehavior.class);
                    if (defaultBehavior != null) {
                        break;
                    }
                }
                if (defaultBehavior != null) {
                    try {
                        layoutParams.o(defaultBehavior.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e8) {
                        Log.e("CoordinatorLayout", "Default behavior class " + defaultBehavior.value().getName() + " could not be instantiated. Did you forget a default constructor?", e8);
                    }
                }
                layoutParams.f5455b = true;
            }
        }
        return layoutParams;
    }

    public CoordinatorLayout(@NonNull Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        TypedArray obtainStyledAttributes;
        this.f5432f = new ArrayList();
        this.f5433g = new DirectedAcyclicGraph<>();
        this.f5434h = new ArrayList();
        this.f5435i = new ArrayList();
        this.f5437k = new int[2];
        this.f5438l = new int[2];
        this.f5451y = new NestedScrollingParentHelper(this);
        if (i8 == 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f5416b, 0, R$style.f5414a);
        } else {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f5416b, i8, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (i8 == 0) {
                saveAttributeDataForStyleable(context, R$styleable.f5416b, attributeSet, obtainStyledAttributes, 0, R$style.f5414a);
            } else {
                saveAttributeDataForStyleable(context, R$styleable.f5416b, attributeSet, obtainStyledAttributes, i8, 0);
            }
        }
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.f5417c, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f5441o = resources.getIntArray(resourceId);
            float f8 = resources.getDisplayMetrics().density;
            int length = this.f5441o.length;
            for (int i9 = 0; i9 < length; i9++) {
                int[] iArr = this.f5441o;
                iArr[i9] = (int) (iArr[i9] * f8);
            }
        }
        this.f5448v = obtainStyledAttributes.getDrawable(R$styleable.f5418d);
        obtainStyledAttributes.recycle();
        Y();
        super.setOnHierarchyChangeListener(new HierarchyChangeListener());
        if (ViewCompat.C(this) == 0) {
            ViewCompat.D0(this, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.coordinatorlayout.widget.CoordinatorLayout.SavedState.1
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
        SparseArray<Parcelable> f5473h;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f5473h = new SparseArray<>(readInt);
            for (int i8 = 0; i8 < readInt; i8++) {
                this.f5473h.append(iArr[i8], readParcelableArray[i8]);
            }
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i8) {
            int i9;
            super.writeToParcel(parcel, i8);
            SparseArray<Parcelable> sparseArray = this.f5473h;
            if (sparseArray != null) {
                i9 = sparseArray.size();
            } else {
                i9 = 0;
            }
            parcel.writeInt(i9);
            int[] iArr = new int[i9];
            Parcelable[] parcelableArr = new Parcelable[i9];
            for (int i10 = 0; i10 < i9; i10++) {
                iArr[i10] = this.f5473h.keyAt(i10);
                parcelableArr[i10] = this.f5473h.valueAt(i10);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i8);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        Behavior f5454a;

        /* renamed from: b  reason: collision with root package name */
        boolean f5455b;

        /* renamed from: c  reason: collision with root package name */
        public int f5456c;

        /* renamed from: d  reason: collision with root package name */
        public int f5457d;

        /* renamed from: e  reason: collision with root package name */
        public int f5458e;

        /* renamed from: f  reason: collision with root package name */
        int f5459f;

        /* renamed from: g  reason: collision with root package name */
        public int f5460g;

        /* renamed from: h  reason: collision with root package name */
        public int f5461h;

        /* renamed from: i  reason: collision with root package name */
        int f5462i;

        /* renamed from: j  reason: collision with root package name */
        int f5463j;

        /* renamed from: k  reason: collision with root package name */
        View f5464k;

        /* renamed from: l  reason: collision with root package name */
        View f5465l;

        /* renamed from: m  reason: collision with root package name */
        private boolean f5466m;

        /* renamed from: n  reason: collision with root package name */
        private boolean f5467n;

        /* renamed from: o  reason: collision with root package name */
        private boolean f5468o;

        /* renamed from: p  reason: collision with root package name */
        private boolean f5469p;

        /* renamed from: q  reason: collision with root package name */
        final Rect f5470q;

        /* renamed from: r  reason: collision with root package name */
        Object f5471r;

        public LayoutParams(int i8, int i9) {
            super(i8, i9);
            this.f5455b = false;
            this.f5456c = 0;
            this.f5457d = 0;
            this.f5458e = -1;
            this.f5459f = -1;
            this.f5460g = 0;
            this.f5461h = 0;
            this.f5470q = new Rect();
        }

        private void n(View view, CoordinatorLayout coordinatorLayout) {
            View findViewById = coordinatorLayout.findViewById(this.f5459f);
            this.f5464k = findViewById;
            if (findViewById != null) {
                if (findViewById == coordinatorLayout) {
                    if (coordinatorLayout.isInEditMode()) {
                        this.f5465l = null;
                        this.f5464k = null;
                        return;
                    }
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
                for (ViewParent parent = findViewById.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                    if (parent == view) {
                        if (coordinatorLayout.isInEditMode()) {
                            this.f5465l = null;
                            this.f5464k = null;
                            return;
                        }
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                    if (parent instanceof View) {
                        findViewById = (View) parent;
                    }
                }
                this.f5465l = findViewById;
            } else if (coordinatorLayout.isInEditMode()) {
                this.f5465l = null;
                this.f5464k = null;
            } else {
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f5459f) + " to anchor view " + view);
            }
        }

        private boolean s(View view, int i8) {
            int b8 = GravityCompat.b(((LayoutParams) view.getLayoutParams()).f5460g, i8);
            if (b8 != 0 && (GravityCompat.b(this.f5461h, i8) & b8) == b8) {
                return true;
            }
            return false;
        }

        private boolean t(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f5464k.getId() != this.f5459f) {
                return false;
            }
            View view2 = this.f5464k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent != null && parent != view) {
                    if (parent instanceof View) {
                        view2 = (View) parent;
                    }
                } else {
                    this.f5465l = null;
                    this.f5464k = null;
                    return false;
                }
            }
            this.f5465l = view2;
            return true;
        }

        boolean a() {
            if (this.f5464k == null && this.f5459f != -1) {
                return true;
            }
            return false;
        }

        boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            Behavior behavior;
            if (view2 != this.f5465l && !s(view2, ViewCompat.E(coordinatorLayout)) && ((behavior = this.f5454a) == null || !behavior.e(coordinatorLayout, view, view2))) {
                return false;
            }
            return true;
        }

        boolean c() {
            if (this.f5454a == null) {
                this.f5466m = false;
            }
            return this.f5466m;
        }

        View d(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f5459f == -1) {
                this.f5465l = null;
                this.f5464k = null;
                return null;
            }
            if (this.f5464k == null || !t(view, coordinatorLayout)) {
                n(view, coordinatorLayout);
            }
            return this.f5464k;
        }

        public int e() {
            return this.f5459f;
        }

        public Behavior f() {
            return this.f5454a;
        }

        boolean g() {
            return this.f5469p;
        }

        Rect h() {
            return this.f5470q;
        }

        boolean i(CoordinatorLayout coordinatorLayout, View view) {
            boolean z7;
            boolean z8 = this.f5466m;
            if (z8) {
                return true;
            }
            Behavior behavior = this.f5454a;
            if (behavior != null) {
                z7 = behavior.a(coordinatorLayout, view);
            } else {
                z7 = false;
            }
            boolean z9 = z7 | z8;
            this.f5466m = z9;
            return z9;
        }

        boolean j(int i8) {
            if (i8 != 0) {
                if (i8 != 1) {
                    return false;
                }
                return this.f5468o;
            }
            return this.f5467n;
        }

        void k() {
            this.f5469p = false;
        }

        void l(int i8) {
            r(i8, false);
        }

        void m() {
            this.f5466m = false;
        }

        public void o(Behavior behavior) {
            Behavior behavior2 = this.f5454a;
            if (behavior2 != behavior) {
                if (behavior2 != null) {
                    behavior2.j();
                }
                this.f5454a = behavior;
                this.f5471r = null;
                this.f5455b = true;
                if (behavior != null) {
                    behavior.g(this);
                }
            }
        }

        void p(boolean z7) {
            this.f5469p = z7;
        }

        void q(Rect rect) {
            this.f5470q.set(rect);
        }

        void r(int i8, boolean z7) {
            if (i8 != 0) {
                if (i8 == 1) {
                    this.f5468o = z7;
                    return;
                }
                return;
            }
            this.f5467n = z7;
        }

        LayoutParams(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f5455b = false;
            this.f5456c = 0;
            this.f5457d = 0;
            this.f5458e = -1;
            this.f5459f = -1;
            this.f5460g = 0;
            this.f5461h = 0;
            this.f5470q = new Rect();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f5419e);
            this.f5456c = obtainStyledAttributes.getInteger(R$styleable.f5420f, 0);
            this.f5459f = obtainStyledAttributes.getResourceId(R$styleable.f5421g, -1);
            this.f5457d = obtainStyledAttributes.getInteger(R$styleable.f5422h, 0);
            this.f5458e = obtainStyledAttributes.getInteger(R$styleable.f5426l, -1);
            this.f5460g = obtainStyledAttributes.getInt(R$styleable.f5425k, 0);
            this.f5461h = obtainStyledAttributes.getInt(R$styleable.f5424j, 0);
            int i8 = R$styleable.f5423i;
            boolean hasValue = obtainStyledAttributes.hasValue(i8);
            this.f5455b = hasValue;
            if (hasValue) {
                this.f5454a = CoordinatorLayout.L(context, attributeSet, obtainStyledAttributes.getString(i8));
            }
            obtainStyledAttributes.recycle();
            Behavior behavior = this.f5454a;
            if (behavior != null) {
                behavior.g(this);
            }
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.f5455b = false;
            this.f5456c = 0;
            this.f5457d = 0;
            this.f5458e = -1;
            this.f5459f = -1;
            this.f5460g = 0;
            this.f5461h = 0;
            this.f5470q = new Rect();
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f5455b = false;
            this.f5456c = 0;
            this.f5457d = 0;
            this.f5458e = -1;
            this.f5459f = -1;
            this.f5460g = 0;
            this.f5461h = 0;
            this.f5470q = new Rect();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f5455b = false;
            this.f5456c = 0;
            this.f5457d = 0;
            this.f5458e = -1;
            this.f5459f = -1;
            this.f5460g = 0;
            this.f5461h = 0;
            this.f5470q = new Rect();
        }
    }
}
