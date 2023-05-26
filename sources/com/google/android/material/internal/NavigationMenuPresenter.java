package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class NavigationMenuPresenter implements MenuPresenter {
    boolean A;
    private int C;
    int D;

    /* renamed from: f  reason: collision with root package name */
    private NavigationMenuView f13607f;

    /* renamed from: g  reason: collision with root package name */
    LinearLayout f13608g;

    /* renamed from: h  reason: collision with root package name */
    private MenuPresenter.Callback f13609h;

    /* renamed from: i  reason: collision with root package name */
    MenuBuilder f13610i;

    /* renamed from: j  reason: collision with root package name */
    NavigationMenuAdapter f13611j;

    /* renamed from: k  reason: collision with root package name */
    LayoutInflater f13612k;

    /* renamed from: m  reason: collision with root package name */
    ColorStateList f13614m;

    /* renamed from: o  reason: collision with root package name */
    ColorStateList f13616o;

    /* renamed from: p  reason: collision with root package name */
    ColorStateList f13617p;

    /* renamed from: q  reason: collision with root package name */
    Drawable f13618q;

    /* renamed from: r  reason: collision with root package name */
    RippleDrawable f13619r;

    /* renamed from: s  reason: collision with root package name */
    int f13620s;

    /* renamed from: t  reason: collision with root package name */
    int f13621t;

    /* renamed from: u  reason: collision with root package name */
    int f13622u;

    /* renamed from: v  reason: collision with root package name */
    int f13623v;

    /* renamed from: w  reason: collision with root package name */
    int f13624w;

    /* renamed from: x  reason: collision with root package name */
    int f13625x;

    /* renamed from: y  reason: collision with root package name */
    int f13626y;

    /* renamed from: z  reason: collision with root package name */
    int f13627z;

    /* renamed from: l  reason: collision with root package name */
    int f13613l = 0;

    /* renamed from: n  reason: collision with root package name */
    int f13615n = 0;
    boolean B = true;
    private int E = -1;
    final View.OnClickListener F = new View.OnClickListener() { // from class: com.google.android.material.internal.NavigationMenuPresenter.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z7 = true;
            NavigationMenuPresenter.this.K(true);
            MenuItemImpl itemData = ((NavigationMenuItemView) view).getItemData();
            NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
            boolean M = navigationMenuPresenter.f13610i.M(itemData, navigationMenuPresenter, 0);
            if (itemData != null && itemData.isCheckable() && M) {
                NavigationMenuPresenter.this.f13611j.Y(itemData);
            } else {
                z7 = false;
            }
            NavigationMenuPresenter.this.K(false);
            if (z7) {
                NavigationMenuPresenter.this.g(false);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class HeaderViewHolder extends ViewHolder {
        public HeaderViewHolder(View view) {
            super(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class NavigationMenuAdapter extends RecyclerView.Adapter<ViewHolder> {

        /* renamed from: d  reason: collision with root package name */
        private final ArrayList<NavigationMenuItem> f13629d;

        /* renamed from: e  reason: collision with root package name */
        private MenuItemImpl f13630e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f13631f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ NavigationMenuPresenter f13632g;

        /* JADX INFO: Access modifiers changed from: private */
        public int Q(int i8) {
            int i9 = i8;
            for (int i10 = 0; i10 < i8; i10++) {
                if (this.f13632g.f13611j.t(i10) == 2) {
                    i9--;
                }
            }
            if (this.f13632g.f13608g.getChildCount() == 0) {
                return i9 - 1;
            }
            return i9;
        }

        private void R(int i8, int i9) {
            while (i8 < i9) {
                ((NavigationMenuTextItem) this.f13629d.get(i8)).f13639b = true;
                i8++;
            }
        }

        private void W() {
            if (this.f13631f) {
                return;
            }
            this.f13631f = true;
            this.f13629d.clear();
            this.f13629d.add(new NavigationMenuHeaderItem());
            int i8 = -1;
            int size = this.f13632g.f13610i.E().size();
            boolean z7 = false;
            int i9 = 0;
            for (int i10 = 0; i10 < size; i10++) {
                MenuItemImpl menuItemImpl = this.f13632g.f13610i.E().get(i10);
                if (menuItemImpl.isChecked()) {
                    Y(menuItemImpl);
                }
                if (menuItemImpl.isCheckable()) {
                    menuItemImpl.t(false);
                }
                if (menuItemImpl.hasSubMenu()) {
                    SubMenu subMenu = menuItemImpl.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i10 != 0) {
                            this.f13629d.add(new NavigationMenuSeparatorItem(this.f13632g.D, 0));
                        }
                        this.f13629d.add(new NavigationMenuTextItem(menuItemImpl));
                        int size2 = this.f13629d.size();
                        int size3 = subMenu.size();
                        boolean z8 = false;
                        for (int i11 = 0; i11 < size3; i11++) {
                            MenuItemImpl menuItemImpl2 = (MenuItemImpl) subMenu.getItem(i11);
                            if (menuItemImpl2.isVisible()) {
                                if (!z8 && menuItemImpl2.getIcon() != null) {
                                    z8 = true;
                                }
                                if (menuItemImpl2.isCheckable()) {
                                    menuItemImpl2.t(false);
                                }
                                if (menuItemImpl.isChecked()) {
                                    Y(menuItemImpl);
                                }
                                this.f13629d.add(new NavigationMenuTextItem(menuItemImpl2));
                            }
                        }
                        if (z8) {
                            R(size2, this.f13629d.size());
                        }
                    }
                } else {
                    int groupId = menuItemImpl.getGroupId();
                    if (groupId != i8) {
                        i9 = this.f13629d.size();
                        if (menuItemImpl.getIcon() != null) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        if (i10 != 0) {
                            i9++;
                            ArrayList<NavigationMenuItem> arrayList = this.f13629d;
                            int i12 = this.f13632g.D;
                            arrayList.add(new NavigationMenuSeparatorItem(i12, i12));
                        }
                    } else if (!z7 && menuItemImpl.getIcon() != null) {
                        R(i9, this.f13629d.size());
                        z7 = true;
                    }
                    NavigationMenuTextItem navigationMenuTextItem = new NavigationMenuTextItem(menuItemImpl);
                    navigationMenuTextItem.f13639b = z7;
                    this.f13629d.add(navigationMenuTextItem);
                    i8 = groupId;
                }
            }
            this.f13631f = false;
        }

        private void X(View view, final int i8, final boolean z7) {
            ViewCompat.s0(view, new AccessibilityDelegateCompat() { // from class: com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuAdapter.1
                @Override // androidx.core.view.AccessibilityDelegateCompat
                public void g(@NonNull View view2, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    super.g(view2, accessibilityNodeInfoCompat);
                    accessibilityNodeInfoCompat.b0(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(NavigationMenuAdapter.this.Q(i8), 1, 1, 1, z7, view2.isSelected()));
                }
            });
        }

        public MenuItemImpl S() {
            return this.f13630e;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: T */
        public void E(@NonNull ViewHolder viewHolder, int i8) {
            Drawable drawable;
            int t7 = t(i8);
            if (t7 != 0) {
                if (t7 != 1) {
                    if (t7 != 2) {
                        if (t7 == 3) {
                            X(viewHolder.f7332a, i8, true);
                            return;
                        }
                        return;
                    }
                    NavigationMenuSeparatorItem navigationMenuSeparatorItem = (NavigationMenuSeparatorItem) this.f13629d.get(i8);
                    viewHolder.f7332a.setPadding(this.f13632g.f13624w, navigationMenuSeparatorItem.b(), this.f13632g.f13625x, navigationMenuSeparatorItem.a());
                    return;
                }
                TextView textView = (TextView) viewHolder.f7332a;
                textView.setText(((NavigationMenuTextItem) this.f13629d.get(i8)).a().getTitle());
                int i9 = this.f13632g.f13613l;
                if (i9 != 0) {
                    TextViewCompat.o(textView, i9);
                }
                textView.setPadding(this.f13632g.f13626y, textView.getPaddingTop(), this.f13632g.f13627z, textView.getPaddingBottom());
                ColorStateList colorStateList = this.f13632g.f13614m;
                if (colorStateList != null) {
                    textView.setTextColor(colorStateList);
                }
                X(textView, i8, true);
                return;
            }
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) viewHolder.f7332a;
            navigationMenuItemView.setIconTintList(this.f13632g.f13617p);
            int i10 = this.f13632g.f13615n;
            if (i10 != 0) {
                navigationMenuItemView.setTextAppearance(i10);
            }
            ColorStateList colorStateList2 = this.f13632g.f13616o;
            if (colorStateList2 != null) {
                navigationMenuItemView.setTextColor(colorStateList2);
            }
            Drawable drawable2 = this.f13632g.f13618q;
            if (drawable2 != null) {
                drawable = drawable2.getConstantState().newDrawable();
            } else {
                drawable = null;
            }
            ViewCompat.w0(navigationMenuItemView, drawable);
            RippleDrawable rippleDrawable = this.f13632g.f13619r;
            if (rippleDrawable != null) {
                navigationMenuItemView.setForeground(rippleDrawable.getConstantState().newDrawable());
            }
            NavigationMenuTextItem navigationMenuTextItem = (NavigationMenuTextItem) this.f13629d.get(i8);
            navigationMenuItemView.setNeedsEmptyIcon(navigationMenuTextItem.f13639b);
            NavigationMenuPresenter navigationMenuPresenter = this.f13632g;
            int i11 = navigationMenuPresenter.f13620s;
            int i12 = navigationMenuPresenter.f13621t;
            navigationMenuItemView.setPadding(i11, i12, i11, i12);
            navigationMenuItemView.setIconPadding(this.f13632g.f13622u);
            NavigationMenuPresenter navigationMenuPresenter2 = this.f13632g;
            if (navigationMenuPresenter2.A) {
                navigationMenuItemView.setIconSize(navigationMenuPresenter2.f13623v);
            }
            navigationMenuItemView.setMaxLines(this.f13632g.C);
            navigationMenuItemView.c(navigationMenuTextItem.a(), 0);
            X(navigationMenuItemView, i8, false);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: U */
        public ViewHolder G(ViewGroup viewGroup, int i8) {
            if (i8 != 0) {
                if (i8 != 1) {
                    if (i8 != 2) {
                        if (i8 != 3) {
                            return null;
                        }
                        return new HeaderViewHolder(this.f13632g.f13608g);
                    }
                    return new SeparatorViewHolder(this.f13632g.f13612k, viewGroup);
                }
                return new SubheaderViewHolder(this.f13632g.f13612k, viewGroup);
            }
            NavigationMenuPresenter navigationMenuPresenter = this.f13632g;
            return new NormalViewHolder(navigationMenuPresenter.f13612k, viewGroup, navigationMenuPresenter.F);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: V */
        public void L(ViewHolder viewHolder) {
            if (viewHolder instanceof NormalViewHolder) {
                ((NavigationMenuItemView) viewHolder.f7332a).B();
            }
        }

        public void Y(@NonNull MenuItemImpl menuItemImpl) {
            if (this.f13630e != menuItemImpl && menuItemImpl.isCheckable()) {
                MenuItemImpl menuItemImpl2 = this.f13630e;
                if (menuItemImpl2 != null) {
                    menuItemImpl2.setChecked(false);
                }
                this.f13630e = menuItemImpl;
                menuItemImpl.setChecked(true);
            }
        }

        public void Z(boolean z7) {
            this.f13631f = z7;
        }

        public void a0() {
            W();
            w();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int r() {
            return this.f13629d.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long s(int i8) {
            return i8;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int t(int i8) {
            NavigationMenuItem navigationMenuItem = this.f13629d.get(i8);
            if (navigationMenuItem instanceof NavigationMenuSeparatorItem) {
                return 2;
            }
            if (navigationMenuItem instanceof NavigationMenuHeaderItem) {
                return 3;
            }
            if (navigationMenuItem instanceof NavigationMenuTextItem) {
                if (((NavigationMenuTextItem) navigationMenuItem).a().hasSubMenu()) {
                    return 1;
                }
                return 0;
            }
            throw new RuntimeException("Unknown item type.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class NavigationMenuHeaderItem implements NavigationMenuItem {
        NavigationMenuHeaderItem() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface NavigationMenuItem {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class NavigationMenuSeparatorItem implements NavigationMenuItem {

        /* renamed from: a  reason: collision with root package name */
        private final int f13636a;

        /* renamed from: b  reason: collision with root package name */
        private final int f13637b;

        public NavigationMenuSeparatorItem(int i8, int i9) {
            this.f13636a = i8;
            this.f13637b = i9;
        }

        public int a() {
            return this.f13637b;
        }

        public int b() {
            return this.f13636a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class NavigationMenuTextItem implements NavigationMenuItem {

        /* renamed from: a  reason: collision with root package name */
        private final MenuItemImpl f13638a;

        /* renamed from: b  reason: collision with root package name */
        boolean f13639b;

        NavigationMenuTextItem(MenuItemImpl menuItemImpl) {
            this.f13638a = menuItemImpl;
        }

        public MenuItemImpl a() {
            return this.f13638a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class NormalViewHolder extends ViewHolder {
        public NormalViewHolder(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R$layout.design_navigation_item, viewGroup, false));
            this.f7332a.setOnClickListener(onClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class SeparatorViewHolder extends ViewHolder {
        public SeparatorViewHolder(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R$layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class SubheaderViewHolder extends ViewHolder {
        public SubheaderViewHolder(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R$layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    /* loaded from: classes.dex */
    private static abstract class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View view) {
            super(view);
        }
    }

    public void A(int i8) {
        this.f13622u = i8;
        g(false);
    }

    public void B(int i8) {
        if (this.f13623v != i8) {
            this.f13623v = i8;
            this.A = true;
            g(false);
        }
    }

    public void C(ColorStateList colorStateList) {
        this.f13617p = colorStateList;
        g(false);
    }

    public void D(int i8) {
        this.C = i8;
        g(false);
    }

    public void E(int i8) {
        this.f13615n = i8;
        g(false);
    }

    public void F(ColorStateList colorStateList) {
        this.f13616o = colorStateList;
        g(false);
    }

    public void G(int i8) {
        this.f13621t = i8;
        g(false);
    }

    public void H(int i8) {
        this.E = i8;
        NavigationMenuView navigationMenuView = this.f13607f;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(i8);
        }
    }

    public void I(int i8) {
        this.f13627z = i8;
        g(false);
    }

    public void J(int i8) {
        this.f13626y = i8;
        g(false);
    }

    public void K(boolean z7) {
        NavigationMenuAdapter navigationMenuAdapter = this.f13611j;
        if (navigationMenuAdapter != null) {
            navigationMenuAdapter.Z(z7);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void a(MenuBuilder menuBuilder, boolean z7) {
        MenuPresenter.Callback callback = this.f13609h;
        if (callback != null) {
            callback.a(menuBuilder, z7);
        }
    }

    public MenuItemImpl c() {
        return this.f13611j.S();
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean d(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean f(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void g(boolean z7) {
        NavigationMenuAdapter navigationMenuAdapter = this.f13611j;
        if (navigationMenuAdapter != null) {
            navigationMenuAdapter.a0();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean h() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean i(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void j(@NonNull Context context, @NonNull MenuBuilder menuBuilder) {
        this.f13612k = LayoutInflater.from(context);
        this.f13610i = menuBuilder;
        this.D = context.getResources().getDimensionPixelOffset(R$dimen.design_navigation_separator_vertical_padding);
    }

    public int k() {
        return this.f13625x;
    }

    public int l() {
        return this.f13624w;
    }

    public int m() {
        return this.f13608g.getChildCount();
    }

    public Drawable n() {
        return this.f13618q;
    }

    public int o() {
        return this.f13620s;
    }

    public int p() {
        return this.f13622u;
    }

    public int q() {
        return this.C;
    }

    public ColorStateList r() {
        return this.f13616o;
    }

    public ColorStateList s() {
        return this.f13617p;
    }

    public int t() {
        return this.f13621t;
    }

    public int u() {
        return this.f13627z;
    }

    public int v() {
        return this.f13626y;
    }

    public void w(int i8) {
        this.f13625x = i8;
        g(false);
    }

    public void x(int i8) {
        this.f13624w = i8;
        g(false);
    }

    public void y(Drawable drawable) {
        this.f13618q = drawable;
        g(false);
    }

    public void z(int i8) {
        this.f13620s = i8;
        g(false);
    }
}
