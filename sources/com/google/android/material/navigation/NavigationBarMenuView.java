package com.google.android.material.navigation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.util.Pools$Pool;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.HashSet;

/* loaded from: classes.dex */
public abstract class NavigationBarMenuView extends ViewGroup implements MenuView {
    private static final int[] I = {16842912};
    private static final int[] J = {-16842910};
    private int A;
    private int B;
    private int C;
    private ShapeAppearanceModel D;
    private boolean E;
    private ColorStateList F;
    private NavigationBarPresenter G;
    private MenuBuilder H;

    /* renamed from: f  reason: collision with root package name */
    private final TransitionSet f13717f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final View.OnClickListener f13718g;

    /* renamed from: h  reason: collision with root package name */
    private final Pools$Pool<NavigationBarItemView> f13719h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final SparseArray<View.OnTouchListener> f13720i;

    /* renamed from: j  reason: collision with root package name */
    private int f13721j;

    /* renamed from: k  reason: collision with root package name */
    private NavigationBarItemView[] f13722k;

    /* renamed from: l  reason: collision with root package name */
    private int f13723l;

    /* renamed from: m  reason: collision with root package name */
    private int f13724m;

    /* renamed from: n  reason: collision with root package name */
    private ColorStateList f13725n;

    /* renamed from: o  reason: collision with root package name */
    private int f13726o;

    /* renamed from: p  reason: collision with root package name */
    private ColorStateList f13727p;

    /* renamed from: q  reason: collision with root package name */
    private final ColorStateList f13728q;

    /* renamed from: r  reason: collision with root package name */
    private int f13729r;

    /* renamed from: s  reason: collision with root package name */
    private int f13730s;

    /* renamed from: t  reason: collision with root package name */
    private Drawable f13731t;

    /* renamed from: u  reason: collision with root package name */
    private ColorStateList f13732u;

    /* renamed from: v  reason: collision with root package name */
    private int f13733v;
    @NonNull

    /* renamed from: w  reason: collision with root package name */
    private final SparseArray<BadgeDrawable> f13734w;

    /* renamed from: x  reason: collision with root package name */
    private int f13735x;

    /* renamed from: y  reason: collision with root package name */
    private int f13736y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f13737z;

    private Drawable c() {
        if (this.D != null && this.F != null) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.D);
            materialShapeDrawable.c0(this.F);
            return materialShapeDrawable;
        }
        return null;
    }

    private boolean f(int i8) {
        return i8 != -1;
    }

    private void g() {
        HashSet hashSet = new HashSet();
        for (int i8 = 0; i8 < this.H.size(); i8++) {
            hashSet.add(Integer.valueOf(this.H.getItem(i8).getItemId()));
        }
        for (int i9 = 0; i9 < this.f13734w.size(); i9++) {
            int keyAt = this.f13734w.keyAt(i9);
            if (!hashSet.contains(Integer.valueOf(keyAt))) {
                this.f13734w.delete(keyAt);
            }
        }
    }

    private NavigationBarItemView getNewItem() {
        NavigationBarItemView b8 = this.f13719h.b();
        if (b8 == null) {
            return d(getContext());
        }
        return b8;
    }

    private void setBadgeIfNeeded(@NonNull NavigationBarItemView navigationBarItemView) {
        BadgeDrawable badgeDrawable;
        int id = navigationBarItemView.getId();
        if (f(id) && (badgeDrawable = this.f13734w.get(id)) != null) {
            navigationBarItemView.setBadge(badgeDrawable);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void a(@NonNull MenuBuilder menuBuilder) {
        this.H = menuBuilder;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void b() {
        removeAllViews();
        NavigationBarItemView[] navigationBarItemViewArr = this.f13722k;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView != null) {
                    this.f13719h.a(navigationBarItemView);
                    navigationBarItemView.h();
                }
            }
        }
        if (this.H.size() == 0) {
            this.f13723l = 0;
            this.f13724m = 0;
            this.f13722k = null;
            return;
        }
        g();
        this.f13722k = new NavigationBarItemView[this.H.size()];
        boolean e8 = e(this.f13721j, this.H.E().size());
        for (int i8 = 0; i8 < this.H.size(); i8++) {
            this.G.b(true);
            this.H.getItem(i8).setCheckable(true);
            this.G.b(false);
            NavigationBarItemView newItem = getNewItem();
            this.f13722k[i8] = newItem;
            newItem.setIconTintList(this.f13725n);
            newItem.setIconSize(this.f13726o);
            newItem.setTextColor(this.f13728q);
            newItem.setTextAppearanceInactive(this.f13729r);
            newItem.setTextAppearanceActive(this.f13730s);
            newItem.setTextColor(this.f13727p);
            int i9 = this.f13735x;
            if (i9 != -1) {
                newItem.setItemPaddingTop(i9);
            }
            int i10 = this.f13736y;
            if (i10 != -1) {
                newItem.setItemPaddingBottom(i10);
            }
            newItem.setActiveIndicatorWidth(this.A);
            newItem.setActiveIndicatorHeight(this.B);
            newItem.setActiveIndicatorMarginHorizontal(this.C);
            newItem.setActiveIndicatorDrawable(c());
            newItem.setActiveIndicatorResizeable(this.E);
            newItem.setActiveIndicatorEnabled(this.f13737z);
            Drawable drawable = this.f13731t;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.f13733v);
            }
            newItem.setItemRippleColor(this.f13732u);
            newItem.setShifting(e8);
            newItem.setLabelVisibilityMode(this.f13721j);
            MenuItemImpl menuItemImpl = (MenuItemImpl) this.H.getItem(i8);
            newItem.c(menuItemImpl, 0);
            newItem.setItemPosition(i8);
            int itemId = menuItemImpl.getItemId();
            newItem.setOnTouchListener(this.f13720i.get(itemId));
            newItem.setOnClickListener(this.f13718g);
            int i11 = this.f13723l;
            if (i11 != 0 && itemId == i11) {
                this.f13724m = i8;
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
        }
        int min = Math.min(this.H.size() - 1, this.f13724m);
        this.f13724m = min;
        this.H.getItem(min).setChecked(true);
    }

    @NonNull
    protected abstract NavigationBarItemView d(@NonNull Context context);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean e(int i8, int i9) {
        if (i8 == -1) {
            if (i9 > 3) {
                return true;
            }
        } else if (i8 == 0) {
            return true;
        }
        return false;
    }

    SparseArray<BadgeDrawable> getBadgeDrawables() {
        return this.f13734w;
    }

    public ColorStateList getIconTintList() {
        return this.f13725n;
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.F;
    }

    public boolean getItemActiveIndicatorEnabled() {
        return this.f13737z;
    }

    public int getItemActiveIndicatorHeight() {
        return this.B;
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.C;
    }

    public ShapeAppearanceModel getItemActiveIndicatorShapeAppearance() {
        return this.D;
    }

    public int getItemActiveIndicatorWidth() {
        return this.A;
    }

    public Drawable getItemBackground() {
        NavigationBarItemView[] navigationBarItemViewArr = this.f13722k;
        if (navigationBarItemViewArr != null && navigationBarItemViewArr.length > 0) {
            return navigationBarItemViewArr[0].getBackground();
        }
        return this.f13731t;
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.f13733v;
    }

    public int getItemIconSize() {
        return this.f13726o;
    }

    public int getItemPaddingBottom() {
        return this.f13736y;
    }

    public int getItemPaddingTop() {
        return this.f13735x;
    }

    public ColorStateList getItemRippleColor() {
        return this.f13732u;
    }

    public int getItemTextAppearanceActive() {
        return this.f13730s;
    }

    public int getItemTextAppearanceInactive() {
        return this.f13729r;
    }

    public ColorStateList getItemTextColor() {
        return this.f13727p;
    }

    public int getLabelVisibilityMode() {
        return this.f13721j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MenuBuilder getMenu() {
        return this.H;
    }

    public int getSelectedItemId() {
        return this.f13723l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getSelectedItemPosition() {
        return this.f13724m;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void h() {
        TransitionSet transitionSet;
        MenuBuilder menuBuilder = this.H;
        if (menuBuilder != null && this.f13722k != null) {
            int size = menuBuilder.size();
            if (size != this.f13722k.length) {
                b();
                return;
            }
            int i8 = this.f13723l;
            for (int i9 = 0; i9 < size; i9++) {
                MenuItem item = this.H.getItem(i9);
                if (item.isChecked()) {
                    this.f13723l = item.getItemId();
                    this.f13724m = i9;
                }
            }
            if (i8 != this.f13723l && (transitionSet = this.f13717f) != null) {
                TransitionManager.b(this, transitionSet);
            }
            boolean e8 = e(this.f13721j, this.H.E().size());
            for (int i10 = 0; i10 < size; i10++) {
                this.G.b(true);
                this.f13722k[i10].setLabelVisibilityMode(this.f13721j);
                this.f13722k[i10].setShifting(e8);
                this.f13722k[i10].c((MenuItemImpl) this.H.getItem(i10), 0);
                this.G.b(false);
            }
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.A0(accessibilityNodeInfo).a0(AccessibilityNodeInfoCompat.CollectionInfoCompat.a(1, this.H.E().size(), false, 1));
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.f13725n = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f13722k;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemActiveIndicatorColor(ColorStateList colorStateList) {
        this.F = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f13722k;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorDrawable(c());
            }
        }
    }

    public void setItemActiveIndicatorEnabled(boolean z7) {
        this.f13737z = z7;
        NavigationBarItemView[] navigationBarItemViewArr = this.f13722k;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorEnabled(z7);
            }
        }
    }

    public void setItemActiveIndicatorHeight(int i8) {
        this.B = i8;
        NavigationBarItemView[] navigationBarItemViewArr = this.f13722k;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorHeight(i8);
            }
        }
    }

    public void setItemActiveIndicatorMarginHorizontal(int i8) {
        this.C = i8;
        NavigationBarItemView[] navigationBarItemViewArr = this.f13722k;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorMarginHorizontal(i8);
            }
        }
    }

    protected void setItemActiveIndicatorResizeable(boolean z7) {
        this.E = z7;
        NavigationBarItemView[] navigationBarItemViewArr = this.f13722k;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorResizeable(z7);
            }
        }
    }

    public void setItemActiveIndicatorShapeAppearance(ShapeAppearanceModel shapeAppearanceModel) {
        this.D = shapeAppearanceModel;
        NavigationBarItemView[] navigationBarItemViewArr = this.f13722k;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorDrawable(c());
            }
        }
    }

    public void setItemActiveIndicatorWidth(int i8) {
        this.A = i8;
        NavigationBarItemView[] navigationBarItemViewArr = this.f13722k;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorWidth(i8);
            }
        }
    }

    public void setItemBackground(Drawable drawable) {
        this.f13731t = drawable;
        NavigationBarItemView[] navigationBarItemViewArr = this.f13722k;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i8) {
        this.f13733v = i8;
        NavigationBarItemView[] navigationBarItemViewArr = this.f13722k;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemBackground(i8);
            }
        }
    }

    public void setItemIconSize(int i8) {
        this.f13726o = i8;
        NavigationBarItemView[] navigationBarItemViewArr = this.f13722k;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setIconSize(i8);
            }
        }
    }

    public void setItemPaddingBottom(int i8) {
        this.f13736y = i8;
        NavigationBarItemView[] navigationBarItemViewArr = this.f13722k;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemPaddingBottom(i8);
            }
        }
    }

    public void setItemPaddingTop(int i8) {
        this.f13735x = i8;
        NavigationBarItemView[] navigationBarItemViewArr = this.f13722k;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemPaddingTop(i8);
            }
        }
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.f13732u = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f13722k;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemRippleColor(colorStateList);
            }
        }
    }

    public void setItemTextAppearanceActive(int i8) {
        this.f13730s = i8;
        NavigationBarItemView[] navigationBarItemViewArr = this.f13722k;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceActive(i8);
                ColorStateList colorStateList = this.f13727p;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(int i8) {
        this.f13729r = i8;
        NavigationBarItemView[] navigationBarItemViewArr = this.f13722k;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceInactive(i8);
                ColorStateList colorStateList = this.f13727p;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f13727p = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f13722k;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i8) {
        this.f13721j = i8;
    }

    public void setPresenter(@NonNull NavigationBarPresenter navigationBarPresenter) {
        this.G = navigationBarPresenter;
    }
}
