package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.NonNull;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.jctools.util.Pow2;

/* loaded from: classes.dex */
public class Toolbar extends ViewGroup implements MenuHost {
    private int A;
    private int B;
    private CharSequence C;
    private CharSequence D;
    private ColorStateList E;
    private ColorStateList F;
    private boolean G;
    private boolean H;
    private final ArrayList<View> I;
    private final ArrayList<View> J;
    private final int[] K;
    final MenuHostHelper L;
    private ArrayList<MenuItem> M;
    OnMenuItemClickListener N;
    private final ActionMenuView.OnMenuItemClickListener O;
    private ToolbarWidgetWrapper P;
    private ActionMenuPresenter Q;
    private ExpandedActionViewMenuPresenter R;
    private MenuPresenter.Callback S;
    MenuBuilder.Callback T;
    private boolean U;
    private OnBackInvokedCallback V;
    private OnBackInvokedDispatcher W;

    /* renamed from: a0  reason: collision with root package name */
    private boolean f2210a0;

    /* renamed from: b0  reason: collision with root package name */
    private final Runnable f2211b0;

    /* renamed from: f  reason: collision with root package name */
    ActionMenuView f2212f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f2213g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f2214h;

    /* renamed from: i  reason: collision with root package name */
    private ImageButton f2215i;

    /* renamed from: j  reason: collision with root package name */
    private ImageView f2216j;

    /* renamed from: k  reason: collision with root package name */
    private Drawable f2217k;

    /* renamed from: l  reason: collision with root package name */
    private CharSequence f2218l;

    /* renamed from: m  reason: collision with root package name */
    ImageButton f2219m;

    /* renamed from: n  reason: collision with root package name */
    View f2220n;

    /* renamed from: o  reason: collision with root package name */
    private Context f2221o;

    /* renamed from: p  reason: collision with root package name */
    private int f2222p;

    /* renamed from: q  reason: collision with root package name */
    private int f2223q;

    /* renamed from: r  reason: collision with root package name */
    private int f2224r;

    /* renamed from: s  reason: collision with root package name */
    int f2225s;

    /* renamed from: t  reason: collision with root package name */
    private int f2226t;

    /* renamed from: u  reason: collision with root package name */
    private int f2227u;

    /* renamed from: v  reason: collision with root package name */
    private int f2228v;

    /* renamed from: w  reason: collision with root package name */
    private int f2229w;

    /* renamed from: x  reason: collision with root package name */
    private int f2230x;

    /* renamed from: y  reason: collision with root package name */
    private RtlSpacingHelper f2231y;

    /* renamed from: z  reason: collision with root package name */
    private int f2232z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api33Impl {
        private Api33Impl() {
        }

        static OnBackInvokedDispatcher a(@NonNull View view) {
            return view.findOnBackInvokedDispatcher();
        }

        @NonNull
        static OnBackInvokedCallback b(@NonNull Runnable runnable) {
            Objects.requireNonNull(runnable);
            return new androidx.activity.g(runnable);
        }

        static void c(@NonNull Object obj, @NonNull Object obj2) {
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) obj2);
        }

        static void d(@NonNull Object obj, @NonNull Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ExpandedActionViewMenuPresenter implements MenuPresenter {

        /* renamed from: f  reason: collision with root package name */
        MenuBuilder f2237f;

        /* renamed from: g  reason: collision with root package name */
        MenuItemImpl f2238g;

        ExpandedActionViewMenuPresenter() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void a(MenuBuilder menuBuilder, boolean z7) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean d(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            Toolbar.this.g();
            ViewParent parent = Toolbar.this.f2219m.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f2219m);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f2219m);
            }
            Toolbar.this.f2220n = menuItemImpl.getActionView();
            this.f2238g = menuItemImpl;
            ViewParent parent2 = Toolbar.this.f2220n.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f2220n);
                }
                LayoutParams generateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                generateDefaultLayoutParams.f1086a = 8388611 | (toolbar4.f2225s & 112);
                generateDefaultLayoutParams.f2240b = 2;
                toolbar4.f2220n.setLayoutParams(generateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f2220n);
            }
            Toolbar.this.I();
            Toolbar.this.requestLayout();
            menuItemImpl.r(true);
            View view = Toolbar.this.f2220n;
            if (view instanceof CollapsibleActionView) {
                ((CollapsibleActionView) view).onActionViewExpanded();
            }
            Toolbar.this.R();
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean f(SubMenuBuilder subMenuBuilder) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void g(boolean z7) {
            if (this.f2238g != null) {
                MenuBuilder menuBuilder = this.f2237f;
                boolean z8 = false;
                if (menuBuilder != null) {
                    int size = menuBuilder.size();
                    int i8 = 0;
                    while (true) {
                        if (i8 >= size) {
                            break;
                        } else if (this.f2237f.getItem(i8) == this.f2238g) {
                            z8 = true;
                            break;
                        } else {
                            i8++;
                        }
                    }
                }
                if (!z8) {
                    i(this.f2237f, this.f2238g);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean h() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean i(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            View view = Toolbar.this.f2220n;
            if (view instanceof CollapsibleActionView) {
                ((CollapsibleActionView) view).onActionViewCollapsed();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f2220n);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f2219m);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f2220n = null;
            toolbar3.a();
            this.f2238g = null;
            Toolbar.this.requestLayout();
            menuItemImpl.r(false);
            Toolbar.this.R();
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void j(Context context, MenuBuilder menuBuilder) {
            MenuItemImpl menuItemImpl;
            MenuBuilder menuBuilder2 = this.f2237f;
            if (menuBuilder2 != null && (menuItemImpl = this.f2238g) != null) {
                menuBuilder2.f(menuItemImpl);
            }
            this.f2237f = menuBuilder;
        }
    }

    /* loaded from: classes.dex */
    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public Toolbar(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.O);
    }

    private int C(View view, int i8, int[] iArr, int i9) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i10 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin - iArr[0];
        int max = i8 + Math.max(0, i10);
        iArr[0] = Math.max(0, -i10);
        int q8 = q(view, i9);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, q8, max + measuredWidth, view.getMeasuredHeight() + q8);
        return max + measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
    }

    private int D(View view, int i8, int[] iArr, int i9) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i10 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin - iArr[1];
        int max = i8 - Math.max(0, i10);
        iArr[1] = Math.max(0, -i10);
        int q8 = q(view, i9);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, q8, max, view.getMeasuredHeight() + q8);
        return max - (measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin);
    }

    private int E(View view, int i8, int i9, int i10, int i11, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i12 = marginLayoutParams.leftMargin - iArr[0];
        int i13 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i12) + Math.max(0, i13);
        iArr[0] = Math.max(0, -i12);
        iArr[1] = Math.max(0, -i13);
        view.measure(ViewGroup.getChildMeasureSpec(i8, getPaddingLeft() + getPaddingRight() + max + i9, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i10, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i11, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private void F(View view, int i8, int i9, int i10, int i11, int i12) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i8, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i9, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i10, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i11, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i12 >= 0) {
            if (mode != 0) {
                i12 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i12);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i12, Pow2.MAX_POW2);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void G() {
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        this.L.h(menu, getMenuInflater());
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.M = currentMenuItems2;
    }

    private void H() {
        removeCallbacks(this.f2211b0);
        post(this.f2211b0);
    }

    private boolean O() {
        if (!this.U) {
            return false;
        }
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (P(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean P(View view) {
        if (view != null && view.getParent() == this && view.getVisibility() != 8) {
            return true;
        }
        return false;
    }

    private void b(List<View> list, int i8) {
        boolean z7;
        if (ViewCompat.E(this) == 1) {
            z7 = true;
        } else {
            z7 = false;
        }
        int childCount = getChildCount();
        int b8 = GravityCompat.b(i8, ViewCompat.E(this));
        list.clear();
        if (z7) {
            for (int i9 = childCount - 1; i9 >= 0; i9--) {
                View childAt = getChildAt(i9);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f2240b == 0 && P(childAt) && p(layoutParams.f1086a) == b8) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt2 = getChildAt(i10);
            LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams2.f2240b == 0 && P(childAt2) && p(layoutParams2.f1086a) == b8) {
                list.add(childAt2);
            }
        }
    }

    private void c(View view, boolean z7) {
        LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams2)) {
            layoutParams = generateLayoutParams(layoutParams2);
        } else {
            layoutParams = (LayoutParams) layoutParams2;
        }
        layoutParams.f2240b = 1;
        if (z7 && this.f2220n != null) {
            view.setLayoutParams(layoutParams);
            this.J.add(view);
            return;
        }
        addView(view, layoutParams);
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i8 = 0; i8 < menu.size(); i8++) {
            arrayList.add(menu.getItem(i8));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(getContext());
    }

    private void h() {
        if (this.f2231y == null) {
            this.f2231y = new RtlSpacingHelper();
        }
    }

    private void i() {
        if (this.f2216j == null) {
            this.f2216j = new AppCompatImageView(getContext());
        }
    }

    private void j() {
        k();
        if (this.f2212f.L() == null) {
            MenuBuilder menuBuilder = (MenuBuilder) this.f2212f.getMenu();
            if (this.R == null) {
                this.R = new ExpandedActionViewMenuPresenter();
            }
            this.f2212f.setExpandedActionViewsExclusive(true);
            menuBuilder.c(this.R, this.f2221o);
            R();
        }
    }

    private void k() {
        if (this.f2212f == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f2212f = actionMenuView;
            actionMenuView.setPopupTheme(this.f2222p);
            this.f2212f.setOnMenuItemClickListener(this.O);
            this.f2212f.M(this.S, new MenuBuilder.Callback() { // from class: androidx.appcompat.widget.Toolbar.3
                @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
                public boolean a(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
                    MenuBuilder.Callback callback = Toolbar.this.T;
                    if (callback != null && callback.a(menuBuilder, menuItem)) {
                        return true;
                    }
                    return false;
                }

                @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
                public void b(@NonNull MenuBuilder menuBuilder) {
                    if (!Toolbar.this.f2212f.H()) {
                        Toolbar.this.L.k(menuBuilder);
                    }
                    MenuBuilder.Callback callback = Toolbar.this.T;
                    if (callback != null) {
                        callback.b(menuBuilder);
                    }
                }
            });
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f1086a = 8388613 | (this.f2225s & 112);
            this.f2212f.setLayoutParams(generateDefaultLayoutParams);
            c(this.f2212f, false);
        }
    }

    private void l() {
        if (this.f2215i == null) {
            this.f2215i = new AppCompatImageButton(getContext(), null, R$attr.N);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f1086a = 8388611 | (this.f2225s & 112);
            this.f2215i.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    private int p(int i8) {
        int E = ViewCompat.E(this);
        int b8 = GravityCompat.b(i8, E) & 7;
        if (b8 != 1 && b8 != 3 && b8 != 5) {
            if (E != 1) {
                return 3;
            }
            return 5;
        }
        return b8;
    }

    private int q(View view, int i8) {
        int i9;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        if (i8 > 0) {
            i9 = (measuredHeight - i8) / 2;
        } else {
            i9 = 0;
        }
        int r7 = r(layoutParams.f1086a);
        if (r7 != 48) {
            if (r7 != 80) {
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                int i10 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                int i11 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                if (i10 < i11) {
                    i10 = i11;
                } else {
                    int i12 = (((height - paddingBottom) - measuredHeight) - i10) - paddingTop;
                    int i13 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    if (i12 < i13) {
                        i10 = Math.max(0, i10 - (i13 - i12));
                    }
                }
                return paddingTop + i10;
            }
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - i9;
        }
        return getPaddingTop() - i9;
    }

    private int r(int i8) {
        int i9 = i8 & 112;
        if (i9 != 16 && i9 != 48 && i9 != 80) {
            return this.B & 112;
        }
        return i9;
    }

    private int s(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return MarginLayoutParamsCompat.b(marginLayoutParams) + MarginLayoutParamsCompat.a(marginLayoutParams);
    }

    private int t(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int u(List<View> list, int[] iArr) {
        int i8 = iArr[0];
        int i9 = iArr[1];
        int size = list.size();
        int i10 = 0;
        int i11 = 0;
        while (i10 < size) {
            View view = list.get(i10);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int i12 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin - i8;
            int i13 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin - i9;
            int max = Math.max(0, i12);
            int max2 = Math.max(0, i13);
            int max3 = Math.max(0, -i12);
            int max4 = Math.max(0, -i13);
            i11 += max + view.getMeasuredWidth() + max2;
            i10++;
            i9 = max4;
            i8 = max3;
        }
        return i11;
    }

    private boolean z(View view) {
        if (view.getParent() != this && !this.J.contains(view)) {
            return false;
        }
        return true;
    }

    public boolean A() {
        ActionMenuView actionMenuView = this.f2212f;
        if (actionMenuView != null && actionMenuView.G()) {
            return true;
        }
        return false;
    }

    public boolean B() {
        ActionMenuView actionMenuView = this.f2212f;
        if (actionMenuView != null && actionMenuView.H()) {
            return true;
        }
        return false;
    }

    void I() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((LayoutParams) childAt.getLayoutParams()).f2240b != 2 && childAt != this.f2212f) {
                removeViewAt(childCount);
                this.J.add(childAt);
            }
        }
    }

    public void J(int i8, int i9) {
        h();
        this.f2231y.g(i8, i9);
    }

    public void K(MenuBuilder menuBuilder, ActionMenuPresenter actionMenuPresenter) {
        if (menuBuilder == null && this.f2212f == null) {
            return;
        }
        k();
        MenuBuilder L = this.f2212f.L();
        if (L == menuBuilder) {
            return;
        }
        if (L != null) {
            L.O(this.Q);
            L.O(this.R);
        }
        if (this.R == null) {
            this.R = new ExpandedActionViewMenuPresenter();
        }
        actionMenuPresenter.G(true);
        if (menuBuilder != null) {
            menuBuilder.c(actionMenuPresenter, this.f2221o);
            menuBuilder.c(this.R, this.f2221o);
        } else {
            actionMenuPresenter.j(this.f2221o, null);
            this.R.j(this.f2221o, null);
            actionMenuPresenter.g(true);
            this.R.g(true);
        }
        this.f2212f.setPopupTheme(this.f2222p);
        this.f2212f.setPresenter(actionMenuPresenter);
        this.Q = actionMenuPresenter;
        R();
    }

    public void L(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.S = callback;
        this.T = callback2;
        ActionMenuView actionMenuView = this.f2212f;
        if (actionMenuView != null) {
            actionMenuView.M(callback, callback2);
        }
    }

    public void M(Context context, int i8) {
        this.f2224r = i8;
        TextView textView = this.f2214h;
        if (textView != null) {
            textView.setTextAppearance(context, i8);
        }
    }

    public void N(Context context, int i8) {
        this.f2223q = i8;
        TextView textView = this.f2213g;
        if (textView != null) {
            textView.setTextAppearance(context, i8);
        }
    }

    public boolean Q() {
        ActionMenuView actionMenuView = this.f2212f;
        if (actionMenuView != null && actionMenuView.N()) {
            return true;
        }
        return false;
    }

    void R() {
        boolean z7;
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher a8 = Api33Impl.a(this);
            if (v() && a8 != null && ViewCompat.V(this) && this.f2210a0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7 && this.W == null) {
                if (this.V == null) {
                    this.V = Api33Impl.b(new Runnable() { // from class: androidx.appcompat.widget.n0
                        @Override // java.lang.Runnable
                        public final void run() {
                            Toolbar.this.e();
                        }
                    });
                }
                Api33Impl.c(a8, this.V);
                this.W = a8;
            } else if (!z7 && (onBackInvokedDispatcher = this.W) != null) {
                Api33Impl.d(onBackInvokedDispatcher, this.V);
                this.W = null;
            }
        }
    }

    void a() {
        for (int size = this.J.size() - 1; size >= 0; size--) {
            addView(this.J.get(size));
        }
        this.J.clear();
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(@NonNull MenuProvider menuProvider) {
        this.L.c(menuProvider);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams)) {
            return true;
        }
        return false;
    }

    public boolean d() {
        ActionMenuView actionMenuView;
        if (getVisibility() == 0 && (actionMenuView = this.f2212f) != null && actionMenuView.I()) {
            return true;
        }
        return false;
    }

    public void e() {
        MenuItemImpl menuItemImpl;
        ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.R;
        if (expandedActionViewMenuPresenter == null) {
            menuItemImpl = null;
        } else {
            menuItemImpl = expandedActionViewMenuPresenter.f2238g;
        }
        if (menuItemImpl != null) {
            menuItemImpl.collapseActionView();
        }
    }

    public void f() {
        ActionMenuView actionMenuView = this.f2212f;
        if (actionMenuView != null) {
            actionMenuView.z();
        }
    }

    void g() {
        if (this.f2219m == null) {
            AppCompatImageButton appCompatImageButton = new AppCompatImageButton(getContext(), null, R$attr.N);
            this.f2219m = appCompatImageButton;
            appCompatImageButton.setImageDrawable(this.f2217k);
            this.f2219m.setContentDescription(this.f2218l);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f1086a = 8388611 | (this.f2225s & 112);
            generateDefaultLayoutParams.f2240b = 2;
            this.f2219m.setLayoutParams(generateDefaultLayoutParams);
            this.f2219m.setOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.Toolbar.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Toolbar.this.e();
                }
            });
        }
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.f2219m;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.f2219m;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        RtlSpacingHelper rtlSpacingHelper = this.f2231y;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i8 = this.A;
        if (i8 == Integer.MIN_VALUE) {
            return getContentInsetEnd();
        }
        return i8;
    }

    public int getContentInsetLeft() {
        RtlSpacingHelper rtlSpacingHelper = this.f2231y;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        RtlSpacingHelper rtlSpacingHelper = this.f2231y;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        RtlSpacingHelper rtlSpacingHelper = this.f2231y;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i8 = this.f2232z;
        if (i8 == Integer.MIN_VALUE) {
            return getContentInsetStart();
        }
        return i8;
    }

    public int getCurrentContentInsetEnd() {
        boolean z7;
        MenuBuilder L;
        ActionMenuView actionMenuView = this.f2212f;
        if (actionMenuView != null && (L = actionMenuView.L()) != null && L.hasVisibleItems()) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return Math.max(getContentInsetEnd(), Math.max(this.A, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        if (ViewCompat.E(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (ViewCompat.E(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.f2232z, 0));
        }
        return getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f2216j;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f2216j;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        j();
        return this.f2212f.getMenu();
    }

    View getNavButtonView() {
        return this.f2215i;
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f2215i;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f2215i;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.Q;
    }

    public Drawable getOverflowIcon() {
        j();
        return this.f2212f.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.f2221o;
    }

    public int getPopupTheme() {
        return this.f2222p;
    }

    public CharSequence getSubtitle() {
        return this.D;
    }

    final TextView getSubtitleTextView() {
        return this.f2214h;
    }

    public CharSequence getTitle() {
        return this.C;
    }

    public int getTitleMarginBottom() {
        return this.f2230x;
    }

    public int getTitleMarginEnd() {
        return this.f2228v;
    }

    public int getTitleMarginStart() {
        return this.f2227u;
    }

    public int getTitleMarginTop() {
        return this.f2229w;
    }

    final TextView getTitleTextView() {
        return this.f2213g;
    }

    public DecorToolbar getWrapper() {
        if (this.P == null) {
            this.P = new ToolbarWidgetWrapper(this, true);
        }
        return this.P;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: m */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* renamed from: n */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: o */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ActionBar.LayoutParams) {
            return new LayoutParams((ActionBar.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        R();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f2211b0);
        R();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.H = false;
        }
        if (!this.H) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.H = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.H = false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:105:0x029f A[LOOP:0: B:104:0x029d->B:105:0x029f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02c1 A[LOOP:1: B:107:0x02bf->B:108:0x02c1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02fa A[LOOP:2: B:116:0x02f8->B:117:0x02fa, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0227  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 783
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i8, int i9) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int[] iArr = this.K;
        boolean b8 = ViewUtils.b(this);
        int i17 = 0;
        int i18 = !b8 ? 1 : 0;
        if (P(this.f2215i)) {
            F(this.f2215i, i8, 0, i9, 0, this.f2226t);
            i10 = this.f2215i.getMeasuredWidth() + s(this.f2215i);
            i11 = Math.max(0, this.f2215i.getMeasuredHeight() + t(this.f2215i));
            i12 = View.combineMeasuredStates(0, this.f2215i.getMeasuredState());
        } else {
            i10 = 0;
            i11 = 0;
            i12 = 0;
        }
        if (P(this.f2219m)) {
            F(this.f2219m, i8, 0, i9, 0, this.f2226t);
            i10 = this.f2219m.getMeasuredWidth() + s(this.f2219m);
            i11 = Math.max(i11, this.f2219m.getMeasuredHeight() + t(this.f2219m));
            i12 = View.combineMeasuredStates(i12, this.f2219m.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = 0 + Math.max(currentContentInsetStart, i10);
        iArr[b8 ? 1 : 0] = Math.max(0, currentContentInsetStart - i10);
        if (P(this.f2212f)) {
            F(this.f2212f, i8, max, i9, 0, this.f2226t);
            i13 = this.f2212f.getMeasuredWidth() + s(this.f2212f);
            i11 = Math.max(i11, this.f2212f.getMeasuredHeight() + t(this.f2212f));
            i12 = View.combineMeasuredStates(i12, this.f2212f.getMeasuredState());
        } else {
            i13 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = max + Math.max(currentContentInsetEnd, i13);
        iArr[i18] = Math.max(0, currentContentInsetEnd - i13);
        if (P(this.f2220n)) {
            max2 += E(this.f2220n, i8, max2, i9, 0, iArr);
            i11 = Math.max(i11, this.f2220n.getMeasuredHeight() + t(this.f2220n));
            i12 = View.combineMeasuredStates(i12, this.f2220n.getMeasuredState());
        }
        if (P(this.f2216j)) {
            max2 += E(this.f2216j, i8, max2, i9, 0, iArr);
            i11 = Math.max(i11, this.f2216j.getMeasuredHeight() + t(this.f2216j));
            i12 = View.combineMeasuredStates(i12, this.f2216j.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt = getChildAt(i19);
            if (((LayoutParams) childAt.getLayoutParams()).f2240b == 0 && P(childAt)) {
                max2 += E(childAt, i8, max2, i9, 0, iArr);
                i11 = Math.max(i11, childAt.getMeasuredHeight() + t(childAt));
                i12 = View.combineMeasuredStates(i12, childAt.getMeasuredState());
            }
        }
        int i20 = this.f2229w + this.f2230x;
        int i21 = this.f2227u + this.f2228v;
        if (P(this.f2213g)) {
            E(this.f2213g, i8, max2 + i21, i9, i20, iArr);
            int measuredWidth = this.f2213g.getMeasuredWidth() + s(this.f2213g);
            i16 = this.f2213g.getMeasuredHeight() + t(this.f2213g);
            i14 = View.combineMeasuredStates(i12, this.f2213g.getMeasuredState());
            i15 = measuredWidth;
        } else {
            i14 = i12;
            i15 = 0;
            i16 = 0;
        }
        if (P(this.f2214h)) {
            i15 = Math.max(i15, E(this.f2214h, i8, max2 + i21, i9, i16 + i20, iArr));
            i16 += this.f2214h.getMeasuredHeight() + t(this.f2214h);
            i14 = View.combineMeasuredStates(i14, this.f2214h.getMeasuredState());
        }
        int max3 = Math.max(i11, i16);
        int paddingLeft = max2 + i15 + getPaddingLeft() + getPaddingRight();
        int paddingTop = max3 + getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i8, (-16777216) & i14);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i9, i14 << 16);
        if (!O()) {
            i17 = resolveSizeAndState2;
        }
        setMeasuredDimension(resolveSizeAndState, i17);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuBuilder menuBuilder;
        MenuItem findItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        ActionMenuView actionMenuView = this.f2212f;
        if (actionMenuView != null) {
            menuBuilder = actionMenuView.L();
        } else {
            menuBuilder = null;
        }
        int i8 = savedState.f2241h;
        if (i8 != 0 && this.R != null && menuBuilder != null && (findItem = menuBuilder.findItem(i8)) != null) {
            findItem.expandActionView();
        }
        if (savedState.f2242i) {
            H();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i8) {
        super.onRtlPropertiesChanged(i8);
        h();
        RtlSpacingHelper rtlSpacingHelper = this.f2231y;
        boolean z7 = true;
        if (i8 != 1) {
            z7 = false;
        }
        rtlSpacingHelper.f(z7);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        MenuItemImpl menuItemImpl;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.R;
        if (expandedActionViewMenuPresenter != null && (menuItemImpl = expandedActionViewMenuPresenter.f2238g) != null) {
            savedState.f2241h = menuItemImpl.getItemId();
        }
        savedState.f2242i = B();
        return savedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.G = false;
        }
        if (!this.G) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.G = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.G = false;
        }
        return true;
    }

    @Override // androidx.core.view.MenuHost
    public void removeMenuProvider(@NonNull MenuProvider menuProvider) {
        this.L.l(menuProvider);
    }

    public void setBackInvokedCallbackEnabled(boolean z7) {
        if (this.f2210a0 != z7) {
            this.f2210a0 = z7;
            R();
        }
    }

    public void setCollapseContentDescription(int i8) {
        setCollapseContentDescription(i8 != 0 ? getContext().getText(i8) : null);
    }

    public void setCollapseIcon(int i8) {
        setCollapseIcon(AppCompatResources.b(getContext(), i8));
    }

    public void setCollapsible(boolean z7) {
        this.U = z7;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i8) {
        if (i8 < 0) {
            i8 = Integer.MIN_VALUE;
        }
        if (i8 != this.A) {
            this.A = i8;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i8) {
        if (i8 < 0) {
            i8 = Integer.MIN_VALUE;
        }
        if (i8 != this.f2232z) {
            this.f2232z = i8;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i8) {
        setLogo(AppCompatResources.b(getContext(), i8));
    }

    public void setLogoDescription(int i8) {
        setLogoDescription(getContext().getText(i8));
    }

    public void setNavigationContentDescription(int i8) {
        setNavigationContentDescription(i8 != 0 ? getContext().getText(i8) : null);
    }

    public void setNavigationIcon(int i8) {
        setNavigationIcon(AppCompatResources.b(getContext(), i8));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        l();
        this.f2215i.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.N = onMenuItemClickListener;
    }

    public void setOverflowIcon(Drawable drawable) {
        j();
        this.f2212f.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i8) {
        if (this.f2222p != i8) {
            this.f2222p = i8;
            if (i8 == 0) {
                this.f2221o = getContext();
            } else {
                this.f2221o = new ContextThemeWrapper(getContext(), i8);
            }
        }
    }

    public void setSubtitle(int i8) {
        setSubtitle(getContext().getText(i8));
    }

    public void setSubtitleTextColor(int i8) {
        setSubtitleTextColor(ColorStateList.valueOf(i8));
    }

    public void setTitle(int i8) {
        setTitle(getContext().getText(i8));
    }

    public void setTitleMarginBottom(int i8) {
        this.f2230x = i8;
        requestLayout();
    }

    public void setTitleMarginEnd(int i8) {
        this.f2228v = i8;
        requestLayout();
    }

    public void setTitleMarginStart(int i8) {
        this.f2227u = i8;
        requestLayout();
    }

    public void setTitleMarginTop(int i8) {
        this.f2229w = i8;
        requestLayout();
    }

    public void setTitleTextColor(int i8) {
        setTitleTextColor(ColorStateList.valueOf(i8));
    }

    public boolean v() {
        ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.R;
        if (expandedActionViewMenuPresenter != null && expandedActionViewMenuPresenter.f2238g != null) {
            return true;
        }
        return false;
    }

    public boolean w() {
        ActionMenuView actionMenuView = this.f2212f;
        if (actionMenuView != null && actionMenuView.F()) {
            return true;
        }
        return false;
    }

    public void x(int i8) {
        getMenuInflater().inflate(i8, getMenu());
    }

    public void y() {
        Iterator<MenuItem> it = this.M.iterator();
        while (it.hasNext()) {
            getMenu().removeItem(it.next().getItemId());
        }
        G();
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ActionBar.LayoutParams {

        /* renamed from: b  reason: collision with root package name */
        int f2240b;

        public LayoutParams(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2240b = 0;
        }

        void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public LayoutParams(int i8, int i9) {
            super(i8, i9);
            this.f2240b = 0;
            this.f1086a = 8388627;
        }

        public LayoutParams(int i8, int i9, int i10) {
            super(i8, i9);
            this.f2240b = 0;
            this.f1086a = i10;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ActionBar.LayoutParams) layoutParams);
            this.f2240b = 0;
            this.f2240b = layoutParams.f2240b;
        }

        public LayoutParams(ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2240b = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2240b = 0;
            a(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2240b = 0;
        }
    }

    public Toolbar(@NonNull Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.B = 8388627;
        this.I = new ArrayList<>();
        this.J = new ArrayList<>();
        this.K = new int[2];
        this.L = new MenuHostHelper(new Runnable() { // from class: androidx.appcompat.widget.m0
            @Override // java.lang.Runnable
            public final void run() {
                Toolbar.this.y();
            }
        });
        this.M = new ArrayList<>();
        this.O = new ActionMenuView.OnMenuItemClickListener() { // from class: androidx.appcompat.widget.Toolbar.1
            @Override // androidx.appcompat.widget.ActionMenuView.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (Toolbar.this.L.j(menuItem)) {
                    return true;
                }
                OnMenuItemClickListener onMenuItemClickListener = Toolbar.this.N;
                if (onMenuItemClickListener != null) {
                    return onMenuItemClickListener.onMenuItemClick(menuItem);
                }
                return false;
            }
        };
        this.f2211b0 = new Runnable() { // from class: androidx.appcompat.widget.Toolbar.2
            @Override // java.lang.Runnable
            public void run() {
                Toolbar.this.Q();
            }
        };
        Context context2 = getContext();
        int[] iArr = R$styleable.f985f3;
        TintTypedArray v7 = TintTypedArray.v(context2, attributeSet, iArr, i8, 0);
        ViewCompat.q0(this, context, iArr, attributeSet, v7.r(), i8, 0);
        this.f2223q = v7.n(R$styleable.H3, 0);
        this.f2224r = v7.n(R$styleable.f1080y3, 0);
        this.B = v7.l(R$styleable.f990g3, this.B);
        this.f2225s = v7.l(R$styleable.f995h3, 48);
        int e8 = v7.e(R$styleable.B3, 0);
        int i9 = R$styleable.G3;
        e8 = v7.s(i9) ? v7.e(i9, e8) : e8;
        this.f2230x = e8;
        this.f2229w = e8;
        this.f2228v = e8;
        this.f2227u = e8;
        int e9 = v7.e(R$styleable.E3, -1);
        if (e9 >= 0) {
            this.f2227u = e9;
        }
        int e10 = v7.e(R$styleable.D3, -1);
        if (e10 >= 0) {
            this.f2228v = e10;
        }
        int e11 = v7.e(R$styleable.F3, -1);
        if (e11 >= 0) {
            this.f2229w = e11;
        }
        int e12 = v7.e(R$styleable.C3, -1);
        if (e12 >= 0) {
            this.f2230x = e12;
        }
        this.f2226t = v7.f(R$styleable.f1050s3, -1);
        int e13 = v7.e(R$styleable.f1030o3, Integer.MIN_VALUE);
        int e14 = v7.e(R$styleable.f1010k3, Integer.MIN_VALUE);
        int f8 = v7.f(R$styleable.f1020m3, 0);
        int f9 = v7.f(R$styleable.f1025n3, 0);
        h();
        this.f2231y.e(f8, f9);
        if (e13 != Integer.MIN_VALUE || e14 != Integer.MIN_VALUE) {
            this.f2231y.g(e13, e14);
        }
        this.f2232z = v7.e(R$styleable.f1035p3, Integer.MIN_VALUE);
        this.A = v7.e(R$styleable.f1015l3, Integer.MIN_VALUE);
        this.f2217k = v7.g(R$styleable.f1005j3);
        this.f2218l = v7.p(R$styleable.f1000i3);
        CharSequence p8 = v7.p(R$styleable.A3);
        if (!TextUtils.isEmpty(p8)) {
            setTitle(p8);
        }
        CharSequence p9 = v7.p(R$styleable.f1075x3);
        if (!TextUtils.isEmpty(p9)) {
            setSubtitle(p9);
        }
        this.f2221o = getContext();
        setPopupTheme(v7.n(R$styleable.f1070w3, 0));
        Drawable g8 = v7.g(R$styleable.f1065v3);
        if (g8 != null) {
            setNavigationIcon(g8);
        }
        CharSequence p10 = v7.p(R$styleable.f1060u3);
        if (!TextUtils.isEmpty(p10)) {
            setNavigationContentDescription(p10);
        }
        Drawable g9 = v7.g(R$styleable.f1040q3);
        if (g9 != null) {
            setLogo(g9);
        }
        CharSequence p11 = v7.p(R$styleable.f1045r3);
        if (!TextUtils.isEmpty(p11)) {
            setLogoDescription(p11);
        }
        int i10 = R$styleable.I3;
        if (v7.s(i10)) {
            setTitleTextColor(v7.c(i10));
        }
        int i11 = R$styleable.f1085z3;
        if (v7.s(i11)) {
            setSubtitleTextColor(v7.c(i11));
        }
        int i12 = R$styleable.f1055t3;
        if (v7.s(i12)) {
            x(v7.n(i12, 0));
        }
        v7.w();
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        ImageButton imageButton = this.f2219m;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            this.f2219m.setImageDrawable(drawable);
            return;
        }
        ImageButton imageButton = this.f2219m;
        if (imageButton != null) {
            imageButton.setImageDrawable(this.f2217k);
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            i();
            if (!z(this.f2216j)) {
                c(this.f2216j, true);
            }
        } else {
            ImageView imageView = this.f2216j;
            if (imageView != null && z(imageView)) {
                removeView(this.f2216j);
                this.J.remove(this.f2216j);
            }
        }
        ImageView imageView2 = this.f2216j;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            i();
        }
        ImageView imageView = this.f2216j;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            l();
        }
        ImageButton imageButton = this.f2215i;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
            TooltipCompat.a(this.f2215i, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            l();
            if (!z(this.f2215i)) {
                c(this.f2215i, true);
            }
        } else {
            ImageButton imageButton = this.f2215i;
            if (imageButton != null && z(imageButton)) {
                removeView(this.f2215i);
                this.J.remove(this.f2215i);
            }
        }
        ImageButton imageButton2 = this.f2215i;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f2214h == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.f2214h = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.f2214h.setEllipsize(TextUtils.TruncateAt.END);
                int i8 = this.f2224r;
                if (i8 != 0) {
                    this.f2214h.setTextAppearance(context, i8);
                }
                ColorStateList colorStateList = this.F;
                if (colorStateList != null) {
                    this.f2214h.setTextColor(colorStateList);
                }
            }
            if (!z(this.f2214h)) {
                c(this.f2214h, true);
            }
        } else {
            TextView textView = this.f2214h;
            if (textView != null && z(textView)) {
                removeView(this.f2214h);
                this.J.remove(this.f2214h);
            }
        }
        TextView textView2 = this.f2214h;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.D = charSequence;
    }

    public void setSubtitleTextColor(@NonNull ColorStateList colorStateList) {
        this.F = colorStateList;
        TextView textView = this.f2214h;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f2213g == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.f2213g = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.f2213g.setEllipsize(TextUtils.TruncateAt.END);
                int i8 = this.f2223q;
                if (i8 != 0) {
                    this.f2213g.setTextAppearance(context, i8);
                }
                ColorStateList colorStateList = this.E;
                if (colorStateList != null) {
                    this.f2213g.setTextColor(colorStateList);
                }
            }
            if (!z(this.f2213g)) {
                c(this.f2213g, true);
            }
        } else {
            TextView textView = this.f2213g;
            if (textView != null && z(textView)) {
                removeView(this.f2213g);
                this.J.remove(this.f2213g);
            }
        }
        TextView textView2 = this.f2213g;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.C = charSequence;
    }

    public void setTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.E = colorStateList;
        TextView textView = this.f2213g;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.appcompat.widget.Toolbar.SavedState.1
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
        int f2241h;

        /* renamed from: i  reason: collision with root package name */
        boolean f2242i;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2241h = parcel.readInt();
            this.f2242i = parcel.readInt() != 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i8) {
            super.writeToParcel(parcel, i8);
            parcel.writeInt(this.f2241h);
            parcel.writeInt(this.f2242i ? 1 : 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
