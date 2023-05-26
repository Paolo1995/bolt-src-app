package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.android.gms.common.api.Api;
import org.jctools.util.Pow2;

/* loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.ItemInvoker, MenuView {
    MenuBuilder.Callback A;
    private boolean B;
    private int C;
    private int D;
    private int E;
    OnMenuItemClickListener F;

    /* renamed from: u  reason: collision with root package name */
    private MenuBuilder f1795u;

    /* renamed from: v  reason: collision with root package name */
    private Context f1796v;

    /* renamed from: w  reason: collision with root package name */
    private int f1797w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f1798x;

    /* renamed from: y  reason: collision with root package name */
    private ActionMenuPresenter f1799y;

    /* renamed from: z  reason: collision with root package name */
    private MenuPresenter.Callback f1800z;

    /* loaded from: classes.dex */
    public interface ActionMenuChildView {
        boolean a();

        boolean b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        ActionMenuPresenterCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void a(@NonNull MenuBuilder menuBuilder, boolean z7) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean b(@NonNull MenuBuilder menuBuilder) {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {
        @ViewDebug.ExportedProperty

        /* renamed from: a  reason: collision with root package name */
        public boolean f1801a;
        @ViewDebug.ExportedProperty

        /* renamed from: b  reason: collision with root package name */
        public int f1802b;
        @ViewDebug.ExportedProperty

        /* renamed from: c  reason: collision with root package name */
        public int f1803c;
        @ViewDebug.ExportedProperty

        /* renamed from: d  reason: collision with root package name */
        public boolean f1804d;
        @ViewDebug.ExportedProperty

        /* renamed from: e  reason: collision with root package name */
        public boolean f1805e;

        /* renamed from: f  reason: collision with root package name */
        boolean f1806f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f1801a = layoutParams.f1801a;
        }

        public LayoutParams(int i8, int i9) {
            super(i8, i9);
            this.f1801a = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class MenuBuilderCallback implements MenuBuilder.Callback {
        MenuBuilderCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean a(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            OnMenuItemClickListener onMenuItemClickListener = ActionMenuView.this.F;
            if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(menuItem)) {
                return true;
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void b(@NonNull MenuBuilder menuBuilder) {
            MenuBuilder.Callback callback = ActionMenuView.this.A;
            if (callback != null) {
                callback.b(menuBuilder);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int J(View view, int i8, int i9, int i10, int i11) {
        ActionMenuItemView actionMenuItemView;
        boolean z7;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i10) - i11, View.MeasureSpec.getMode(i10));
        if (view instanceof ActionMenuItemView) {
            actionMenuItemView = (ActionMenuItemView) view;
        } else {
            actionMenuItemView = null;
        }
        boolean z8 = true;
        if (actionMenuItemView != null && actionMenuItemView.e()) {
            z7 = true;
        } else {
            z7 = false;
        }
        int i12 = 2;
        if (i9 > 0 && (!z7 || i9 >= 2)) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i9 * i8, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i13 = measuredWidth / i8;
            if (measuredWidth % i8 != 0) {
                i13++;
            }
            if (!z7 || i13 >= 2) {
                i12 = i13;
            }
        } else {
            i12 = 0;
        }
        layoutParams.f1804d = (layoutParams.f1801a || !z7) ? false : false;
        layoutParams.f1802b = i12;
        view.measure(View.MeasureSpec.makeMeasureSpec(i8 * i12, Pow2.MAX_POW2), makeMeasureSpec);
        return i12;
    }

    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9, types: [int, boolean] */
    private void K(int i8, int i9) {
        boolean z7;
        int i10;
        int i11;
        boolean z8;
        int i12;
        boolean z9;
        boolean z10;
        int i13;
        int i14;
        boolean z11;
        int i15;
        ?? r14;
        boolean z12;
        int i16;
        int mode = View.MeasureSpec.getMode(i9);
        int size = View.MeasureSpec.getSize(i8);
        int size2 = View.MeasureSpec.getSize(i9);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i9, paddingTop, -2);
        int i17 = size - paddingLeft;
        int i18 = this.D;
        int i19 = i17 / i18;
        int i20 = i17 % i18;
        if (i19 == 0) {
            setMeasuredDimension(i17, 0);
            return;
        }
        int i21 = i18 + (i20 / i19);
        int childCount = getChildCount();
        int i22 = 0;
        int i23 = 0;
        boolean z13 = false;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        long j8 = 0;
        while (i23 < childCount) {
            View childAt = getChildAt(i23);
            int i27 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z14 = childAt instanceof ActionMenuItemView;
                int i28 = i24 + 1;
                if (z14) {
                    int i29 = this.E;
                    i15 = i28;
                    r14 = 0;
                    childAt.setPadding(i29, 0, i29, 0);
                } else {
                    i15 = i28;
                    r14 = 0;
                }
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.f1806f = r14;
                layoutParams.f1803c = r14;
                layoutParams.f1802b = r14;
                layoutParams.f1804d = r14;
                ((LinearLayout.LayoutParams) layoutParams).leftMargin = r14;
                ((LinearLayout.LayoutParams) layoutParams).rightMargin = r14;
                if (z14 && ((ActionMenuItemView) childAt).e()) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                layoutParams.f1805e = z12;
                if (layoutParams.f1801a) {
                    i16 = 1;
                } else {
                    i16 = i19;
                }
                int J = J(childAt, i21, i16, childMeasureSpec, paddingTop);
                i25 = Math.max(i25, J);
                if (layoutParams.f1804d) {
                    i26++;
                }
                if (layoutParams.f1801a) {
                    z13 = true;
                }
                i19 -= J;
                i22 = Math.max(i22, childAt.getMeasuredHeight());
                if (J == 1) {
                    j8 |= 1 << i23;
                    i22 = i22;
                }
                i24 = i15;
            }
            i23++;
            size2 = i27;
        }
        int i30 = size2;
        if (z13 && i24 == 2) {
            z7 = true;
        } else {
            z7 = false;
        }
        boolean z15 = false;
        while (i26 > 0 && i19 > 0) {
            int i31 = 0;
            int i32 = 0;
            int i33 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            long j9 = 0;
            while (i32 < childCount) {
                boolean z16 = z15;
                LayoutParams layoutParams2 = (LayoutParams) getChildAt(i32).getLayoutParams();
                int i34 = i22;
                if (layoutParams2.f1804d) {
                    int i35 = layoutParams2.f1802b;
                    if (i35 < i33) {
                        j9 = 1 << i32;
                        i33 = i35;
                        i31 = 1;
                    } else if (i35 == i33) {
                        i31++;
                        j9 |= 1 << i32;
                    }
                }
                i32++;
                i22 = i34;
                z15 = z16;
            }
            z8 = z15;
            i12 = i22;
            j8 |= j9;
            if (i31 > i19) {
                i10 = mode;
                i11 = i17;
                break;
            }
            int i36 = i33 + 1;
            int i37 = 0;
            while (i37 < childCount) {
                View childAt2 = getChildAt(i37);
                LayoutParams layoutParams3 = (LayoutParams) childAt2.getLayoutParams();
                int i38 = i17;
                int i39 = mode;
                long j10 = 1 << i37;
                if ((j9 & j10) == 0) {
                    if (layoutParams3.f1802b == i36) {
                        j8 |= j10;
                    }
                    z11 = z7;
                } else {
                    if (z7 && layoutParams3.f1805e && i19 == 1) {
                        int i40 = this.E;
                        z11 = z7;
                        childAt2.setPadding(i40 + i21, 0, i40, 0);
                    } else {
                        z11 = z7;
                    }
                    layoutParams3.f1802b++;
                    layoutParams3.f1806f = true;
                    i19--;
                }
                i37++;
                mode = i39;
                i17 = i38;
                z7 = z11;
            }
            i22 = i12;
            z15 = true;
        }
        i10 = mode;
        i11 = i17;
        z8 = z15;
        i12 = i22;
        if (!z13 && i24 == 1) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (i19 > 0 && j8 != 0 && (i19 < i24 - 1 || z9 || i25 > 1)) {
            float bitCount = Long.bitCount(j8);
            if (!z9) {
                if ((j8 & 1) != 0 && !((LayoutParams) getChildAt(0).getLayoutParams()).f1805e) {
                    bitCount -= 0.5f;
                }
                int i41 = childCount - 1;
                if ((j8 & (1 << i41)) != 0 && !((LayoutParams) getChildAt(i41).getLayoutParams()).f1805e) {
                    bitCount -= 0.5f;
                }
            }
            if (bitCount > 0.0f) {
                i14 = (int) ((i19 * i21) / bitCount);
            } else {
                i14 = 0;
            }
            z10 = z8;
            for (int i42 = 0; i42 < childCount; i42++) {
                if ((j8 & (1 << i42)) != 0) {
                    View childAt3 = getChildAt(i42);
                    LayoutParams layoutParams4 = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        layoutParams4.f1803c = i14;
                        layoutParams4.f1806f = true;
                        if (i42 == 0 && !layoutParams4.f1805e) {
                            ((LinearLayout.LayoutParams) layoutParams4).leftMargin = (-i14) / 2;
                        }
                    } else if (layoutParams4.f1801a) {
                        layoutParams4.f1803c = i14;
                        layoutParams4.f1806f = true;
                        ((LinearLayout.LayoutParams) layoutParams4).rightMargin = (-i14) / 2;
                    } else {
                        if (i42 != 0) {
                            ((LinearLayout.LayoutParams) layoutParams4).leftMargin = i14 / 2;
                        }
                        if (i42 != childCount - 1) {
                            ((LinearLayout.LayoutParams) layoutParams4).rightMargin = i14 / 2;
                        }
                    }
                    z10 = true;
                }
            }
        } else {
            z10 = z8;
        }
        if (z10) {
            for (int i43 = 0; i43 < childCount; i43++) {
                View childAt4 = getChildAt(i43);
                LayoutParams layoutParams5 = (LayoutParams) childAt4.getLayoutParams();
                if (layoutParams5.f1806f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((layoutParams5.f1802b * i21) + layoutParams5.f1803c, Pow2.MAX_POW2), childMeasureSpec);
                }
            }
        }
        if (i10 != 1073741824) {
            i13 = i12;
        } else {
            i13 = i30;
        }
        setMeasuredDimension(i11, i13);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* renamed from: A */
    public LayoutParams k() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams) layoutParams).gravity = 16;
        return layoutParams;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* renamed from: B */
    public LayoutParams l(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* renamed from: C */
    public LayoutParams m(ViewGroup.LayoutParams layoutParams) {
        LayoutParams layoutParams2;
        if (layoutParams != null) {
            if (layoutParams instanceof LayoutParams) {
                layoutParams2 = new LayoutParams((LayoutParams) layoutParams);
            } else {
                layoutParams2 = new LayoutParams(layoutParams);
            }
            if (((LinearLayout.LayoutParams) layoutParams2).gravity <= 0) {
                ((LinearLayout.LayoutParams) layoutParams2).gravity = 16;
            }
            return layoutParams2;
        }
        return k();
    }

    public LayoutParams D() {
        LayoutParams k8 = k();
        k8.f1801a = true;
        return k8;
    }

    protected boolean E(int i8) {
        boolean z7 = false;
        if (i8 == 0) {
            return false;
        }
        View childAt = getChildAt(i8 - 1);
        View childAt2 = getChildAt(i8);
        if (i8 < getChildCount() && (childAt instanceof ActionMenuChildView)) {
            z7 = false | ((ActionMenuChildView) childAt).a();
        }
        if (i8 > 0 && (childAt2 instanceof ActionMenuChildView)) {
            return z7 | ((ActionMenuChildView) childAt2).b();
        }
        return z7;
    }

    public boolean F() {
        ActionMenuPresenter actionMenuPresenter = this.f1799y;
        if (actionMenuPresenter != null && actionMenuPresenter.B()) {
            return true;
        }
        return false;
    }

    public boolean G() {
        ActionMenuPresenter actionMenuPresenter = this.f1799y;
        if (actionMenuPresenter != null && actionMenuPresenter.D()) {
            return true;
        }
        return false;
    }

    public boolean H() {
        ActionMenuPresenter actionMenuPresenter = this.f1799y;
        if (actionMenuPresenter != null && actionMenuPresenter.E()) {
            return true;
        }
        return false;
    }

    public boolean I() {
        return this.f1798x;
    }

    public MenuBuilder L() {
        return this.f1795u;
    }

    public void M(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.f1800z = callback;
        this.A = callback2;
    }

    public boolean N() {
        ActionMenuPresenter actionMenuPresenter = this.f1799y;
        if (actionMenuPresenter != null && actionMenuPresenter.K()) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void a(MenuBuilder menuBuilder) {
        this.f1795u = menuBuilder;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.ItemInvoker
    public boolean b(MenuItemImpl menuItemImpl) {
        return this.f1795u.L(menuItemImpl, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public Menu getMenu() {
        if (this.f1795u == null) {
            Context context = getContext();
            MenuBuilder menuBuilder = new MenuBuilder(context);
            this.f1795u = menuBuilder;
            menuBuilder.R(new MenuBuilderCallback());
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.f1799y = actionMenuPresenter;
            actionMenuPresenter.J(true);
            ActionMenuPresenter actionMenuPresenter2 = this.f1799y;
            MenuPresenter.Callback callback = this.f1800z;
            if (callback == null) {
                callback = new ActionMenuPresenterCallback();
            }
            actionMenuPresenter2.e(callback);
            this.f1795u.c(this.f1799y, this.f1796v);
            this.f1799y.H(this);
        }
        return this.f1795u;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f1799y.A();
    }

    public int getPopupTheme() {
        return this.f1797w;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.f1799y;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.g(false);
            if (this.f1799y.E()) {
                this.f1799y.B();
                this.f1799y.K();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        z();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        int i12;
        int width;
        int i13;
        if (!this.B) {
            super.onLayout(z7, i8, i9, i10, i11);
            return;
        }
        int childCount = getChildCount();
        int i14 = (i11 - i9) / 2;
        int dividerWidth = getDividerWidth();
        int i15 = i10 - i8;
        int paddingRight = (i15 - getPaddingRight()) - getPaddingLeft();
        boolean b8 = ViewUtils.b(this);
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f1801a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (E(i18)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (b8) {
                        i13 = getPaddingLeft() + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                        width = i13 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                        i13 = width - measuredWidth;
                    }
                    int i19 = i14 - (measuredHeight / 2);
                    childAt.layout(i13, i19, width, measuredHeight + i19);
                    paddingRight -= measuredWidth;
                    i16 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams).leftMargin) + ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                    E(i18);
                    i17++;
                }
            }
        }
        if (childCount == 1 && i16 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i20 = (i15 / 2) - (measuredWidth2 / 2);
            int i21 = i14 - (measuredHeight2 / 2);
            childAt2.layout(i20, i21, measuredWidth2 + i20, measuredHeight2 + i21);
            return;
        }
        int i22 = i17 - (i16 ^ 1);
        if (i22 > 0) {
            i12 = paddingRight / i22;
        } else {
            i12 = 0;
        }
        int max = Math.max(0, i12);
        if (b8) {
            int width2 = getWidth() - getPaddingRight();
            for (int i23 = 0; i23 < childCount; i23++) {
                View childAt3 = getChildAt(i23);
                LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams2.f1801a) {
                    int i24 = width2 - ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i25 = i14 - (measuredHeight3 / 2);
                    childAt3.layout(i24 - measuredWidth3, i25, i24, measuredHeight3 + i25);
                    width2 = i24 - ((measuredWidth3 + ((LinearLayout.LayoutParams) layoutParams2).leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i26 = 0; i26 < childCount; i26++) {
            View childAt4 = getChildAt(i26);
            LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !layoutParams3.f1801a) {
                int i27 = paddingLeft + ((LinearLayout.LayoutParams) layoutParams3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i28 = i14 - (measuredHeight4 / 2);
                childAt4.layout(i27, i28, i27 + measuredWidth4, measuredHeight4 + i28);
                paddingLeft = i27 + measuredWidth4 + ((LinearLayout.LayoutParams) layoutParams3).rightMargin + max;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i8, int i9) {
        boolean z7;
        MenuBuilder menuBuilder;
        boolean z8 = this.B;
        if (View.MeasureSpec.getMode(i8) == 1073741824) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.B = z7;
        if (z8 != z7) {
            this.C = 0;
        }
        int size = View.MeasureSpec.getSize(i8);
        if (this.B && (menuBuilder = this.f1795u) != null && size != this.C) {
            this.C = size;
            menuBuilder.K(true);
        }
        int childCount = getChildCount();
        if (this.B && childCount > 0) {
            K(i8, i9);
            return;
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i10).getLayoutParams();
            ((LinearLayout.LayoutParams) layoutParams).rightMargin = 0;
            ((LinearLayout.LayoutParams) layoutParams).leftMargin = 0;
        }
        super.onMeasure(i8, i9);
    }

    public void setExpandedActionViewsExclusive(boolean z7) {
        this.f1799y.G(z7);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.F = onMenuItemClickListener;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f1799y.I(drawable);
    }

    public void setOverflowReserved(boolean z7) {
        this.f1798x = z7;
    }

    public void setPopupTheme(int i8) {
        if (this.f1797w != i8) {
            this.f1797w = i8;
            if (i8 == 0) {
                this.f1796v = getContext();
            } else {
                this.f1796v = new ContextThemeWrapper(getContext(), i8);
            }
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.f1799y = actionMenuPresenter;
        actionMenuPresenter.H(this);
    }

    public void z() {
        ActionMenuPresenter actionMenuPresenter = this.f1799y;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.y();
        }
    }

    public ActionMenuView(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f8 = context.getResources().getDisplayMetrics().density;
        this.D = (int) (56.0f * f8);
        this.E = (int) (f8 * 4.0f);
        this.f1796v = context;
        this.f1797w = 0;
    }
}
