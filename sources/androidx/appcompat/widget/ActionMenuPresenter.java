package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ActionProvider;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider.SubUiVisibilityListener {
    private boolean A;
    private int B;
    private final SparseBooleanArray C;
    OverflowPopup D;
    ActionButtonSubmenu E;
    OpenOverflowRunnable F;
    private ActionMenuPopupCallback G;
    final PopupPresenterCallback H;
    int I;

    /* renamed from: p  reason: collision with root package name */
    OverflowMenuButton f1775p;

    /* renamed from: q  reason: collision with root package name */
    private Drawable f1776q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f1777r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f1778s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f1779t;

    /* renamed from: u  reason: collision with root package name */
    private int f1780u;

    /* renamed from: v  reason: collision with root package name */
    private int f1781v;

    /* renamed from: w  reason: collision with root package name */
    private int f1782w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f1783x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f1784y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f1785z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ActionButtonSubmenu extends MenuPopupHelper {
        public ActionButtonSubmenu(Context context, SubMenuBuilder subMenuBuilder, View view) {
            super(context, subMenuBuilder, view, false, R$attr.f826l);
            if (!((MenuItemImpl) subMenuBuilder.getItem()).l()) {
                View view2 = ActionMenuPresenter.this.f1775p;
                f(view2 == null ? (View) ((BaseMenuPresenter) ActionMenuPresenter.this).f1537n : view2);
            }
            j(ActionMenuPresenter.this.H);
        }

        @Override // androidx.appcompat.view.menu.MenuPopupHelper
        protected void e() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.E = null;
            actionMenuPresenter.I = 0;
            super.e();
        }
    }

    /* loaded from: classes.dex */
    private class ActionMenuPopupCallback extends ActionMenuItemView.PopupCallback {
        ActionMenuPopupCallback() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.PopupCallback
        public ShowableListMenu a() {
            ActionButtonSubmenu actionButtonSubmenu = ActionMenuPresenter.this.E;
            if (actionButtonSubmenu != null) {
                return actionButtonSubmenu.c();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class OpenOverflowRunnable implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        private OverflowPopup f1788f;

        public OpenOverflowRunnable(OverflowPopup overflowPopup) {
            this.f1788f = overflowPopup;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((BaseMenuPresenter) ActionMenuPresenter.this).f1531h != null) {
                ((BaseMenuPresenter) ActionMenuPresenter.this).f1531h.d();
            }
            View view = (View) ((BaseMenuPresenter) ActionMenuPresenter.this).f1537n;
            if (view != null && view.getWindowToken() != null && this.f1788f.m()) {
                ActionMenuPresenter.this.D = this.f1788f;
            }
            ActionMenuPresenter.this.F = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class OverflowMenuButton extends AppCompatImageView implements ActionMenuView.ActionMenuChildView {
        public OverflowMenuButton(Context context) {
            super(context, null, R$attr.f825k);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            TooltipCompat.a(this, getContentDescription());
            setOnTouchListener(new ForwardingListener(this) { // from class: androidx.appcompat.widget.ActionMenuPresenter.OverflowMenuButton.1
                @Override // androidx.appcompat.widget.ForwardingListener
                public ShowableListMenu b() {
                    OverflowPopup overflowPopup = ActionMenuPresenter.this.D;
                    if (overflowPopup == null) {
                        return null;
                    }
                    return overflowPopup.c();
                }

                @Override // androidx.appcompat.widget.ForwardingListener
                public boolean c() {
                    ActionMenuPresenter.this.K();
                    return true;
                }

                @Override // androidx.appcompat.widget.ForwardingListener
                public boolean d() {
                    ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                    if (actionMenuPresenter.F != null) {
                        return false;
                    }
                    actionMenuPresenter.B();
                    return true;
                }
            });
        }

        @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
        public boolean a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
        public boolean b() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.K();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i8, int i9, int i10, int i11) {
            boolean frame = super.setFrame(i8, i9, i10, i11);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                DrawableCompat.l(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class OverflowPopup extends MenuPopupHelper {
        public OverflowPopup(Context context, MenuBuilder menuBuilder, View view, boolean z7) {
            super(context, menuBuilder, view, z7, R$attr.f826l);
            h(8388613);
            j(ActionMenuPresenter.this.H);
        }

        @Override // androidx.appcompat.view.menu.MenuPopupHelper
        protected void e() {
            if (((BaseMenuPresenter) ActionMenuPresenter.this).f1531h != null) {
                ((BaseMenuPresenter) ActionMenuPresenter.this).f1531h.close();
            }
            ActionMenuPresenter.this.D = null;
            super.e();
        }
    }

    /* loaded from: classes.dex */
    private class PopupPresenterCallback implements MenuPresenter.Callback {
        PopupPresenterCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void a(@NonNull MenuBuilder menuBuilder, boolean z7) {
            if (menuBuilder instanceof SubMenuBuilder) {
                menuBuilder.D().e(false);
            }
            MenuPresenter.Callback m8 = ActionMenuPresenter.this.m();
            if (m8 != null) {
                m8.a(menuBuilder, z7);
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean b(@NonNull MenuBuilder menuBuilder) {
            if (menuBuilder == ((BaseMenuPresenter) ActionMenuPresenter.this).f1531h) {
                return false;
            }
            ActionMenuPresenter.this.I = ((SubMenuBuilder) menuBuilder).getItem().getItemId();
            MenuPresenter.Callback m8 = ActionMenuPresenter.this.m();
            if (m8 == null) {
                return false;
            }
            return m8.b(menuBuilder);
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, R$layout.f919c, R$layout.f918b);
        this.C = new SparseBooleanArray();
        this.H = new PopupPresenterCallback();
    }

    private View z(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f1537n;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = viewGroup.getChildAt(i8);
            if ((childAt instanceof MenuView.ItemView) && ((MenuView.ItemView) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public Drawable A() {
        OverflowMenuButton overflowMenuButton = this.f1775p;
        if (overflowMenuButton != null) {
            return overflowMenuButton.getDrawable();
        }
        if (this.f1777r) {
            return this.f1776q;
        }
        return null;
    }

    public boolean B() {
        MenuView menuView;
        OpenOverflowRunnable openOverflowRunnable = this.F;
        if (openOverflowRunnable != null && (menuView = this.f1537n) != null) {
            ((View) menuView).removeCallbacks(openOverflowRunnable);
            this.F = null;
            return true;
        }
        OverflowPopup overflowPopup = this.D;
        if (overflowPopup != null) {
            overflowPopup.b();
            return true;
        }
        return false;
    }

    public boolean C() {
        ActionButtonSubmenu actionButtonSubmenu = this.E;
        if (actionButtonSubmenu != null) {
            actionButtonSubmenu.b();
            return true;
        }
        return false;
    }

    public boolean D() {
        if (this.F == null && !E()) {
            return false;
        }
        return true;
    }

    public boolean E() {
        OverflowPopup overflowPopup = this.D;
        if (overflowPopup != null && overflowPopup.d()) {
            return true;
        }
        return false;
    }

    public void F(Configuration configuration) {
        if (!this.f1783x) {
            this.f1782w = ActionBarPolicy.b(this.f1530g).d();
        }
        MenuBuilder menuBuilder = this.f1531h;
        if (menuBuilder != null) {
            menuBuilder.K(true);
        }
    }

    public void G(boolean z7) {
        this.A = z7;
    }

    public void H(ActionMenuView actionMenuView) {
        this.f1537n = actionMenuView;
        actionMenuView.a(this.f1531h);
    }

    public void I(Drawable drawable) {
        OverflowMenuButton overflowMenuButton = this.f1775p;
        if (overflowMenuButton != null) {
            overflowMenuButton.setImageDrawable(drawable);
            return;
        }
        this.f1777r = true;
        this.f1776q = drawable;
    }

    public void J(boolean z7) {
        this.f1778s = z7;
        this.f1779t = true;
    }

    public boolean K() {
        MenuBuilder menuBuilder;
        if (this.f1778s && !E() && (menuBuilder = this.f1531h) != null && this.f1537n != null && this.F == null && !menuBuilder.z().isEmpty()) {
            OpenOverflowRunnable openOverflowRunnable = new OpenOverflowRunnable(new OverflowPopup(this.f1530g, this.f1531h, this.f1775p, true));
            this.F = openOverflowRunnable;
            ((View) this.f1537n).post(openOverflowRunnable);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void a(MenuBuilder menuBuilder, boolean z7) {
        y();
        super.a(menuBuilder, z7);
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public void c(MenuItemImpl menuItemImpl, MenuView.ItemView itemView) {
        itemView.c(menuItemImpl, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) itemView;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f1537n);
        if (this.G == null) {
            this.G = new ActionMenuPopupCallback();
        }
        actionMenuItemView.setPopupCallback(this.G);
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public boolean f(SubMenuBuilder subMenuBuilder) {
        boolean z7 = false;
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
        while (subMenuBuilder2.e0() != this.f1531h) {
            subMenuBuilder2 = (SubMenuBuilder) subMenuBuilder2.e0();
        }
        View z8 = z(subMenuBuilder2.getItem());
        if (z8 == null) {
            return false;
        }
        this.I = subMenuBuilder.getItem().getItemId();
        int size = subMenuBuilder.size();
        int i8 = 0;
        while (true) {
            if (i8 >= size) {
                break;
            }
            MenuItem item = subMenuBuilder.getItem(i8);
            if (item.isVisible() && item.getIcon() != null) {
                z7 = true;
                break;
            }
            i8++;
        }
        ActionButtonSubmenu actionButtonSubmenu = new ActionButtonSubmenu(this.f1530g, subMenuBuilder, z8);
        this.E = actionButtonSubmenu;
        actionButtonSubmenu.g(z7);
        this.E.k();
        super.f(subMenuBuilder);
        return true;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void g(boolean z7) {
        ArrayList<MenuItemImpl> arrayList;
        super.g(z7);
        ((View) this.f1537n).requestLayout();
        MenuBuilder menuBuilder = this.f1531h;
        boolean z8 = false;
        if (menuBuilder != null) {
            ArrayList<MenuItemImpl> s7 = menuBuilder.s();
            int size = s7.size();
            for (int i8 = 0; i8 < size; i8++) {
                ActionProvider a8 = s7.get(i8).a();
                if (a8 != null) {
                    a8.i(this);
                }
            }
        }
        MenuBuilder menuBuilder2 = this.f1531h;
        if (menuBuilder2 != null) {
            arrayList = menuBuilder2.z();
        } else {
            arrayList = null;
        }
        if (this.f1778s && arrayList != null) {
            int size2 = arrayList.size();
            if (size2 == 1) {
                z8 = !arrayList.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z8 = true;
            }
        }
        if (z8) {
            if (this.f1775p == null) {
                this.f1775p = new OverflowMenuButton(this.f1529f);
            }
            ViewGroup viewGroup = (ViewGroup) this.f1775p.getParent();
            if (viewGroup != this.f1537n) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f1775p);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f1537n;
                actionMenuView.addView(this.f1775p, actionMenuView.D());
            }
        } else {
            OverflowMenuButton overflowMenuButton = this.f1775p;
            if (overflowMenuButton != null) {
                ViewParent parent = overflowMenuButton.getParent();
                MenuView menuView = this.f1537n;
                if (parent == menuView) {
                    ((ViewGroup) menuView).removeView(this.f1775p);
                }
            }
        }
        ((ActionMenuView) this.f1537n).setOverflowReserved(this.f1778s);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean h() {
        ArrayList<MenuItemImpl> arrayList;
        int i8;
        int i9;
        int i10;
        int i11;
        boolean z7;
        boolean z8;
        ActionMenuPresenter actionMenuPresenter = this;
        MenuBuilder menuBuilder = actionMenuPresenter.f1531h;
        View view = null;
        int i12 = 0;
        if (menuBuilder != null) {
            arrayList = menuBuilder.E();
            i8 = arrayList.size();
        } else {
            arrayList = null;
            i8 = 0;
        }
        int i13 = actionMenuPresenter.f1782w;
        int i14 = actionMenuPresenter.f1781v;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.f1537n;
        boolean z9 = false;
        int i15 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < i8; i17++) {
            MenuItemImpl menuItemImpl = arrayList.get(i17);
            if (menuItemImpl.o()) {
                i15++;
            } else if (menuItemImpl.n()) {
                i16++;
            } else {
                z9 = true;
            }
            if (actionMenuPresenter.A && menuItemImpl.isActionViewExpanded()) {
                i13 = 0;
            }
        }
        if (actionMenuPresenter.f1778s && (z9 || i16 + i15 > i13)) {
            i13--;
        }
        int i18 = i13 - i15;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.C;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.f1784y) {
            int i19 = actionMenuPresenter.B;
            i10 = i14 / i19;
            i9 = i19 + ((i14 % i19) / i10);
        } else {
            i9 = 0;
            i10 = 0;
        }
        int i20 = 0;
        int i21 = 0;
        while (i20 < i8) {
            MenuItemImpl menuItemImpl2 = arrayList.get(i20);
            if (menuItemImpl2.o()) {
                View n8 = actionMenuPresenter.n(menuItemImpl2, view, viewGroup);
                if (actionMenuPresenter.f1784y) {
                    i10 -= ActionMenuView.J(n8, i9, i10, makeMeasureSpec, i12);
                } else {
                    n8.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = n8.getMeasuredWidth();
                i14 -= measuredWidth;
                if (i21 == 0) {
                    i21 = measuredWidth;
                }
                int groupId = menuItemImpl2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                menuItemImpl2.u(true);
                i11 = i8;
            } else if (menuItemImpl2.n()) {
                int groupId2 = menuItemImpl2.getGroupId();
                boolean z10 = sparseBooleanArray.get(groupId2);
                if ((i18 > 0 || z10) && i14 > 0 && (!actionMenuPresenter.f1784y || i10 > 0)) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                boolean z11 = z7;
                i11 = i8;
                if (z7) {
                    View n9 = actionMenuPresenter.n(menuItemImpl2, null, viewGroup);
                    if (actionMenuPresenter.f1784y) {
                        int J = ActionMenuView.J(n9, i9, i10, makeMeasureSpec, 0);
                        i10 -= J;
                        if (J == 0) {
                            z11 = false;
                        }
                    } else {
                        n9.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    boolean z12 = z11;
                    int measuredWidth2 = n9.getMeasuredWidth();
                    i14 -= measuredWidth2;
                    if (i21 == 0) {
                        i21 = measuredWidth2;
                    }
                    if (!actionMenuPresenter.f1784y ? i14 + i21 > 0 : i14 >= 0) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    z7 = z12 & z8;
                }
                if (z7 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z10) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i22 = 0; i22 < i20; i22++) {
                        MenuItemImpl menuItemImpl3 = arrayList.get(i22);
                        if (menuItemImpl3.getGroupId() == groupId2) {
                            if (menuItemImpl3.l()) {
                                i18++;
                            }
                            menuItemImpl3.u(false);
                        }
                    }
                }
                if (z7) {
                    i18--;
                }
                menuItemImpl2.u(z7);
            } else {
                i11 = i8;
                menuItemImpl2.u(false);
                i20++;
                view = null;
                actionMenuPresenter = this;
                i8 = i11;
                i12 = 0;
            }
            i20++;
            view = null;
            actionMenuPresenter = this;
            i8 = i11;
            i12 = 0;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void j(@NonNull Context context, MenuBuilder menuBuilder) {
        super.j(context, menuBuilder);
        Resources resources = context.getResources();
        ActionBarPolicy b8 = ActionBarPolicy.b(context);
        if (!this.f1779t) {
            this.f1778s = b8.h();
        }
        if (!this.f1785z) {
            this.f1780u = b8.c();
        }
        if (!this.f1783x) {
            this.f1782w = b8.d();
        }
        int i8 = this.f1780u;
        if (this.f1778s) {
            if (this.f1775p == null) {
                OverflowMenuButton overflowMenuButton = new OverflowMenuButton(this.f1529f);
                this.f1775p = overflowMenuButton;
                if (this.f1777r) {
                    overflowMenuButton.setImageDrawable(this.f1776q);
                    this.f1776q = null;
                    this.f1777r = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f1775p.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i8 -= this.f1775p.getMeasuredWidth();
        } else {
            this.f1775p = null;
        }
        this.f1781v = i8;
        this.B = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public boolean l(ViewGroup viewGroup, int i8) {
        if (viewGroup.getChildAt(i8) == this.f1775p) {
            return false;
        }
        return super.l(viewGroup, i8);
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public View n(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        int i8;
        View actionView = menuItemImpl.getActionView();
        if (actionView == null || menuItemImpl.j()) {
            actionView = super.n(menuItemImpl, view, viewGroup);
        }
        if (menuItemImpl.isActionViewExpanded()) {
            i8 = 8;
        } else {
            i8 = 0;
        }
        actionView.setVisibility(i8);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.m(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public MenuView o(ViewGroup viewGroup) {
        MenuView menuView = this.f1537n;
        MenuView o8 = super.o(viewGroup);
        if (menuView != o8) {
            ((ActionMenuView) o8).setPresenter(this);
        }
        return o8;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public boolean q(int i8, MenuItemImpl menuItemImpl) {
        return menuItemImpl.l();
    }

    public boolean y() {
        return B() | C();
    }
}
