package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.R$attr;
import androidx.appcompat.graphics.drawable.DrawableWrapperCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.os.BuildCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.widget.ListViewAutoScrollHelper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.jctools.util.Pow2;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class DropDownListView extends ListView {

    /* renamed from: f  reason: collision with root package name */
    private final Rect f1977f;

    /* renamed from: g  reason: collision with root package name */
    private int f1978g;

    /* renamed from: h  reason: collision with root package name */
    private int f1979h;

    /* renamed from: i  reason: collision with root package name */
    private int f1980i;

    /* renamed from: j  reason: collision with root package name */
    private int f1981j;

    /* renamed from: k  reason: collision with root package name */
    private int f1982k;

    /* renamed from: l  reason: collision with root package name */
    private GateKeeperDrawable f1983l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f1984m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f1985n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f1986o;

    /* renamed from: p  reason: collision with root package name */
    private ViewPropertyAnimatorCompat f1987p;

    /* renamed from: q  reason: collision with root package name */
    private ListViewAutoScrollHelper f1988q;

    /* renamed from: r  reason: collision with root package name */
    ResolveHoverRunnable f1989r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api21Impl {
        private Api21Impl() {
        }

        static void a(View view, float f8, float f9) {
            view.drawableHotspotChanged(f8, f9);
        }
    }

    /* loaded from: classes.dex */
    static class Api30Impl {

        /* renamed from: a  reason: collision with root package name */
        private static Method f1990a;

        /* renamed from: b  reason: collision with root package name */
        private static Method f1991b;

        /* renamed from: c  reason: collision with root package name */
        private static Method f1992c;

        /* renamed from: d  reason: collision with root package name */
        private static boolean f1993d;

        static {
            try {
                Class cls = Integer.TYPE;
                Class cls2 = Float.TYPE;
                Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, Boolean.TYPE, cls2, cls2);
                f1990a = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
                f1991b = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
                f1992c = declaredMethod3;
                declaredMethod3.setAccessible(true);
                f1993d = true;
            } catch (NoSuchMethodException e8) {
                e8.printStackTrace();
            }
        }

        private Api30Impl() {
        }

        static boolean a() {
            return f1993d;
        }

        @SuppressLint({"BanUncheckedReflection"})
        static void b(DropDownListView dropDownListView, int i8, View view) {
            try {
                f1990a.invoke(dropDownListView, Integer.valueOf(i8), view, Boolean.FALSE, -1, -1);
                f1991b.invoke(dropDownListView, Integer.valueOf(i8));
                f1992c.invoke(dropDownListView, Integer.valueOf(i8));
            } catch (IllegalAccessException e8) {
                e8.printStackTrace();
            } catch (InvocationTargetException e9) {
                e9.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api33Impl {
        private Api33Impl() {
        }

        static boolean a(AbsListView absListView) {
            return absListView.isSelectedChildViewEnabled();
        }

        static void b(AbsListView absListView, boolean z7) {
            absListView.setSelectedChildViewEnabled(z7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class GateKeeperDrawable extends DrawableWrapperCompat {

        /* renamed from: g  reason: collision with root package name */
        private boolean f1994g;

        GateKeeperDrawable(Drawable drawable) {
            super(drawable);
            this.f1994g = true;
        }

        void b(boolean z7) {
            this.f1994g = z7;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f1994g) {
                super.draw(canvas);
            }
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
        public void setHotspot(float f8, float f9) {
            if (this.f1994g) {
                super.setHotspot(f8, f9);
            }
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i8, int i9, int i10, int i11) {
            if (this.f1994g) {
                super.setHotspotBounds(i8, i9, i10, i11);
            }
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f1994g) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z7, boolean z8) {
            if (this.f1994g) {
                return super.setVisible(z7, z8);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class PreApi33Impl {

        /* renamed from: a  reason: collision with root package name */
        private static final Field f1995a;

        static {
            Field field = null;
            try {
                field = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
                field.setAccessible(true);
            } catch (NoSuchFieldException e8) {
                e8.printStackTrace();
            }
            f1995a = field;
        }

        private PreApi33Impl() {
        }

        static boolean a(AbsListView absListView) {
            Field field = f1995a;
            if (field != null) {
                try {
                    return field.getBoolean(absListView);
                } catch (IllegalAccessException e8) {
                    e8.printStackTrace();
                    return false;
                }
            }
            return false;
        }

        static void b(AbsListView absListView, boolean z7) {
            Field field = f1995a;
            if (field != null) {
                try {
                    field.set(absListView, Boolean.valueOf(z7));
                } catch (IllegalAccessException e8) {
                    e8.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ResolveHoverRunnable implements Runnable {
        ResolveHoverRunnable() {
        }

        public void a() {
            DropDownListView dropDownListView = DropDownListView.this;
            dropDownListView.f1989r = null;
            dropDownListView.removeCallbacks(this);
        }

        public void b() {
            DropDownListView.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            DropDownListView dropDownListView = DropDownListView.this;
            dropDownListView.f1989r = null;
            dropDownListView.drawableStateChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DropDownListView(@NonNull Context context, boolean z7) {
        super(context, null, R$attr.A);
        this.f1977f = new Rect();
        this.f1978g = 0;
        this.f1979h = 0;
        this.f1980i = 0;
        this.f1981j = 0;
        this.f1985n = z7;
        setCacheColorHint(0);
    }

    private void a() {
        this.f1986o = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f1982k - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f1987p;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.c();
            this.f1987p = null;
        }
    }

    private void b(View view, int i8) {
        performItemClick(view, i8, getItemIdAtPosition(i8));
    }

    private void c(Canvas canvas) {
        Drawable selector;
        if (!this.f1977f.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(this.f1977f);
            selector.draw(canvas);
        }
    }

    private void f(int i8, View view) {
        Rect rect = this.f1977f;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f1978g;
        rect.top -= this.f1979h;
        rect.right += this.f1980i;
        rect.bottom += this.f1981j;
        boolean j8 = j();
        if (view.isEnabled() != j8) {
            k(!j8);
            if (i8 != -1) {
                refreshDrawableState();
            }
        }
    }

    private void g(int i8, View view) {
        boolean z7;
        Drawable selector = getSelector();
        boolean z8 = true;
        if (selector != null && i8 != -1) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            selector.setVisible(false, false);
        }
        f(i8, view);
        if (z7) {
            Rect rect = this.f1977f;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z8 = false;
            }
            selector.setVisible(z8, false);
            DrawableCompat.k(selector, exactCenterX, exactCenterY);
        }
    }

    private void h(int i8, View view, float f8, float f9) {
        g(i8, view);
        Drawable selector = getSelector();
        if (selector != null && i8 != -1) {
            DrawableCompat.k(selector, f8, f9);
        }
    }

    private void i(View view, int i8, float f8, float f9) {
        View childAt;
        this.f1986o = true;
        Api21Impl.a(this, f8, f9);
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i9 = this.f1982k;
        if (i9 != -1 && (childAt = getChildAt(i9 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f1982k = i8;
        Api21Impl.a(view, f8 - view.getLeft(), f9 - view.getTop());
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        h(i8, view, f8, f9);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    private boolean j() {
        if (BuildCompat.d()) {
            return Api33Impl.a(this);
        }
        return PreApi33Impl.a(this);
    }

    private void k(boolean z7) {
        if (BuildCompat.d()) {
            Api33Impl.b(this, z7);
        } else {
            PreApi33Impl.b(this, z7);
        }
    }

    private boolean l() {
        return this.f1986o;
    }

    private void m() {
        Drawable selector = getSelector();
        if (selector != null && l() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    private void setSelectorEnabled(boolean z7) {
        GateKeeperDrawable gateKeeperDrawable = this.f1983l;
        if (gateKeeperDrawable != null) {
            gateKeeperDrawable.b(z7);
        }
    }

    public int d(int i8, int i9, int i10, int i11, int i12) {
        int makeMeasureSpec;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i13 = listPaddingTop + listPaddingBottom;
        dividerHeight = (dividerHeight <= 0 || divider == null) ? 0 : 0;
        int count = adapter.getCount();
        View view = null;
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < count; i16++) {
            int itemViewType = adapter.getItemViewType(i16);
            if (itemViewType != i14) {
                view = null;
                i14 = itemViewType;
            }
            view = adapter.getView(i16, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i17 = layoutParams.height;
            if (i17 > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i17, Pow2.MAX_POW2);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i8, makeMeasureSpec);
            view.forceLayout();
            if (i16 > 0) {
                i13 += dividerHeight;
            }
            i13 += view.getMeasuredHeight();
            if (i13 >= i11) {
                if (i12 >= 0 && i16 > i12 && i15 > 0 && i13 != i11) {
                    return i15;
                }
                return i11;
            }
            if (i12 >= 0 && i16 >= i12) {
                i15 = i13;
            }
        }
        return i13;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.f1989r != null) {
            return;
        }
        super.drawableStateChanged();
        setSelectorEnabled(true);
        m();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000c, code lost:
        if (r0 != 3) goto L7;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0048 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean e(android.view.MotionEvent r8, int r9) {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L14
            r9 = 3
            if (r0 == r9) goto L11
        Le:
            r9 = 0
            r3 = 1
            goto L46
        L11:
            r9 = 0
            r3 = 0
            goto L46
        L14:
            r3 = 1
            goto L17
        L16:
            r3 = 0
        L17:
            int r9 = r8.findPointerIndex(r9)
            if (r9 >= 0) goto L1e
            goto L11
        L1e:
            float r4 = r8.getX(r9)
            int r4 = (int) r4
            float r9 = r8.getY(r9)
            int r9 = (int) r9
            int r5 = r7.pointToPosition(r4, r9)
            r6 = -1
            if (r5 != r6) goto L31
            r9 = 1
            goto L46
        L31:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.i(r3, r5, r4, r9)
            if (r0 != r2) goto Le
            r7.b(r3, r5)
            goto Le
        L46:
            if (r3 == 0) goto L4a
            if (r9 == 0) goto L4d
        L4a:
            r7.a()
        L4d:
            if (r3 == 0) goto L65
            androidx.core.widget.ListViewAutoScrollHelper r9 = r7.f1988q
            if (r9 != 0) goto L5a
            androidx.core.widget.ListViewAutoScrollHelper r9 = new androidx.core.widget.ListViewAutoScrollHelper
            r9.<init>(r7)
            r7.f1988q = r9
        L5a:
            androidx.core.widget.ListViewAutoScrollHelper r9 = r7.f1988q
            r9.m(r2)
            androidx.core.widget.ListViewAutoScrollHelper r9 = r7.f1988q
            r9.onTouch(r7, r8)
            goto L6c
        L65:
            androidx.core.widget.ListViewAutoScrollHelper r8 = r7.f1988q
            if (r8 == 0) goto L6c
            r8.m(r1)
        L6c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.DropDownListView.e(android.view.MotionEvent, int):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        if (!this.f1985n && !super.hasFocus()) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        if (!this.f1985n && !super.hasWindowFocus()) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean isFocused() {
        if (!this.f1985n && !super.isFocused()) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        if ((this.f1985n && this.f1984m) || super.isInTouchMode()) {
            return true;
        }
        return false;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f1989r = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(@NonNull MotionEvent motionEvent) {
        int i8 = Build.VERSION.SDK_INT;
        if (i8 < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f1989r == null) {
            ResolveHoverRunnable resolveHoverRunnable = new ResolveHoverRunnable();
            this.f1989r = resolveHoverRunnable;
            resolveHoverRunnable.b();
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked != 9 && actionMasked != 7) {
            setSelection(-1);
        } else {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (pointToPosition != -1 && pointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    requestFocus();
                    if (i8 >= 30 && Api30Impl.a()) {
                        Api30Impl.b(this, pointToPosition, childAt);
                    } else {
                        setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                    }
                }
                m();
            }
        }
        return onHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f1982k = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        ResolveHoverRunnable resolveHoverRunnable = this.f1989r;
        if (resolveHoverRunnable != null) {
            resolveHoverRunnable.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setListSelectionHidden(boolean z7) {
        this.f1984m = z7;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        GateKeeperDrawable gateKeeperDrawable;
        if (drawable != null) {
            gateKeeperDrawable = new GateKeeperDrawable(drawable);
        } else {
            gateKeeperDrawable = null;
        }
        this.f1983l = gateKeeperDrawable;
        super.setSelector(gateKeeperDrawable);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f1978g = rect.left;
        this.f1979h = rect.top;
        this.f1980i = rect.right;
        this.f1981j = rect.bottom;
    }
}
