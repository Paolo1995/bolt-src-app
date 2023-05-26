package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.R$string;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;

/* loaded from: classes.dex */
public final class MenuItemImpl implements SupportMenuItem {
    private View A;
    private ActionProvider B;
    private MenuItem.OnActionExpandListener C;
    private ContextMenu.ContextMenuInfo E;

    /* renamed from: a  reason: collision with root package name */
    private final int f1639a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1640b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1641c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1642d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f1643e;

    /* renamed from: f  reason: collision with root package name */
    private CharSequence f1644f;

    /* renamed from: g  reason: collision with root package name */
    private Intent f1645g;

    /* renamed from: h  reason: collision with root package name */
    private char f1646h;

    /* renamed from: j  reason: collision with root package name */
    private char f1648j;

    /* renamed from: l  reason: collision with root package name */
    private Drawable f1650l;

    /* renamed from: n  reason: collision with root package name */
    MenuBuilder f1652n;

    /* renamed from: o  reason: collision with root package name */
    private SubMenuBuilder f1653o;

    /* renamed from: p  reason: collision with root package name */
    private Runnable f1654p;

    /* renamed from: q  reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f1655q;

    /* renamed from: r  reason: collision with root package name */
    private CharSequence f1656r;

    /* renamed from: s  reason: collision with root package name */
    private CharSequence f1657s;

    /* renamed from: z  reason: collision with root package name */
    private int f1664z;

    /* renamed from: i  reason: collision with root package name */
    private int f1647i = 4096;

    /* renamed from: k  reason: collision with root package name */
    private int f1649k = 4096;

    /* renamed from: m  reason: collision with root package name */
    private int f1651m = 0;

    /* renamed from: t  reason: collision with root package name */
    private ColorStateList f1658t = null;

    /* renamed from: u  reason: collision with root package name */
    private PorterDuff.Mode f1659u = null;

    /* renamed from: v  reason: collision with root package name */
    private boolean f1660v = false;

    /* renamed from: w  reason: collision with root package name */
    private boolean f1661w = false;

    /* renamed from: x  reason: collision with root package name */
    private boolean f1662x = false;

    /* renamed from: y  reason: collision with root package name */
    private int f1663y = 16;
    private boolean D = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MenuItemImpl(MenuBuilder menuBuilder, int i8, int i9, int i10, int i11, CharSequence charSequence, int i12) {
        this.f1652n = menuBuilder;
        this.f1639a = i9;
        this.f1640b = i8;
        this.f1641c = i10;
        this.f1642d = i11;
        this.f1643e = charSequence;
        this.f1664z = i12;
    }

    private static void d(StringBuilder sb, int i8, int i9, String str) {
        if ((i8 & i9) == i9) {
            sb.append(str);
        }
    }

    private Drawable e(Drawable drawable) {
        if (drawable != null && this.f1662x && (this.f1660v || this.f1661w)) {
            drawable = DrawableCompat.r(drawable).mutate();
            if (this.f1660v) {
                DrawableCompat.o(drawable, this.f1658t);
            }
            if (this.f1661w) {
                DrawableCompat.p(drawable, this.f1659u);
            }
            this.f1662x = false;
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean A() {
        if (this.f1652n.H() && g() != 0) {
            return true;
        }
        return false;
    }

    public boolean B() {
        if ((this.f1664z & 4) == 4) {
            return true;
        }
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public ActionProvider a() {
        return this.B;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    @NonNull
    public SupportMenuItem b(ActionProvider actionProvider) {
        ActionProvider actionProvider2 = this.B;
        if (actionProvider2 != null) {
            actionProvider2.h();
        }
        this.A = null;
        this.B = actionProvider;
        this.f1652n.K(true);
        ActionProvider actionProvider3 = this.B;
        if (actionProvider3 != null) {
            actionProvider3.j(new ActionProvider.VisibilityListener() { // from class: androidx.appcompat.view.menu.MenuItemImpl.1
                @Override // androidx.core.view.ActionProvider.VisibilityListener
                public void onActionProviderVisibilityChanged(boolean z7) {
                    MenuItemImpl menuItemImpl = MenuItemImpl.this;
                    menuItemImpl.f1652n.J(menuItemImpl);
                }
            });
        }
        return this;
    }

    public void c() {
        this.f1652n.I(this);
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f1664z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener != null && !onActionExpandListener.onMenuItemActionCollapse(this)) {
            return false;
        }
        return this.f1652n.f(this);
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean expandActionView() {
        if (!j()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener != null && !onActionExpandListener.onMenuItemActionExpand(this)) {
            return false;
        }
        return this.f1652n.k(this);
    }

    public int f() {
        return this.f1642d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public char g() {
        if (this.f1652n.G()) {
            return this.f1648j;
        }
        return this.f1646h;
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public View getActionView() {
        View view = this.A;
        if (view != null) {
            return view;
        }
        ActionProvider actionProvider = this.B;
        if (actionProvider != null) {
            View d8 = actionProvider.d(this);
            this.A = d8;
            return d8;
        }
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f1649k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f1648j;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f1656r;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f1640b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f1650l;
        if (drawable != null) {
            return e(drawable);
        }
        if (this.f1651m != 0) {
            Drawable b8 = AppCompatResources.b(this.f1652n.u(), this.f1651m);
            this.f1651m = 0;
            this.f1650l = b8;
            return e(b8);
        }
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f1658t;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f1659u;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f1645g;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f1639a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f1647i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f1646h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f1641c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f1653o;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f1643e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1644f;
        if (charSequence == null) {
            return this.f1643e;
        }
        return charSequence;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f1657s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String h() {
        int i8;
        char g8 = g();
        if (g8 == 0) {
            return "";
        }
        Resources resources = this.f1652n.u().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f1652n.u()).hasPermanentMenuKey()) {
            sb.append(resources.getString(R$string.f949m));
        }
        if (this.f1652n.G()) {
            i8 = this.f1649k;
        } else {
            i8 = this.f1647i;
        }
        d(sb, i8, 65536, resources.getString(R$string.f945i));
        d(sb, i8, 4096, resources.getString(R$string.f941e));
        d(sb, i8, 2, resources.getString(R$string.f940d));
        d(sb, i8, 1, resources.getString(R$string.f946j));
        d(sb, i8, 4, resources.getString(R$string.f948l));
        d(sb, i8, 8, resources.getString(R$string.f944h));
        if (g8 != '\b') {
            if (g8 != '\n') {
                if (g8 != ' ') {
                    sb.append(g8);
                } else {
                    sb.append(resources.getString(R$string.f947k));
                }
            } else {
                sb.append(resources.getString(R$string.f943g));
            }
        } else {
            sb.append(resources.getString(R$string.f942f));
        }
        return sb.toString();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        if (this.f1653o != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence i(MenuView.ItemView itemView) {
        if (itemView != null && itemView.d()) {
            return getTitleCondensed();
        }
        return getTitle();
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.D;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        if ((this.f1663y & 1) == 1) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        if ((this.f1663y & 2) == 2) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        if ((this.f1663y & 16) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        ActionProvider actionProvider = this.B;
        if (actionProvider != null && actionProvider.g()) {
            if ((this.f1663y & 8) == 0 && this.B.b()) {
                return true;
            }
            return false;
        } else if ((this.f1663y & 8) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean j() {
        ActionProvider actionProvider;
        if ((this.f1664z & 8) == 0) {
            return false;
        }
        if (this.A == null && (actionProvider = this.B) != null) {
            this.A = actionProvider.d(this);
        }
        if (this.A == null) {
            return false;
        }
        return true;
    }

    public boolean k() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f1655q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        MenuBuilder menuBuilder = this.f1652n;
        if (menuBuilder.h(menuBuilder, this)) {
            return true;
        }
        Runnable runnable = this.f1654p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f1645g != null) {
            try {
                this.f1652n.u().startActivity(this.f1645g);
                return true;
            } catch (ActivityNotFoundException e8) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e8);
            }
        }
        ActionProvider actionProvider = this.B;
        if (actionProvider != null && actionProvider.e()) {
            return true;
        }
        return false;
    }

    public boolean l() {
        if ((this.f1663y & 32) == 32) {
            return true;
        }
        return false;
    }

    public boolean m() {
        if ((this.f1663y & 4) != 0) {
            return true;
        }
        return false;
    }

    public boolean n() {
        if ((this.f1664z & 1) == 1) {
            return true;
        }
        return false;
    }

    public boolean o() {
        if ((this.f1664z & 2) == 2) {
            return true;
        }
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    /* renamed from: p */
    public SupportMenuItem setActionView(int i8) {
        Context u7 = this.f1652n.u();
        setActionView(LayoutInflater.from(u7).inflate(i8, (ViewGroup) new LinearLayout(u7), false));
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    /* renamed from: q */
    public SupportMenuItem setActionView(View view) {
        int i8;
        this.A = view;
        this.B = null;
        if (view != null && view.getId() == -1 && (i8 = this.f1639a) > 0) {
            view.setId(i8);
        }
        this.f1652n.I(this);
        return this;
    }

    public void r(boolean z7) {
        this.D = z7;
        this.f1652n.K(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(boolean z7) {
        int i8;
        int i9 = this.f1663y;
        int i10 = i9 & (-3);
        if (z7) {
            i8 = 2;
        } else {
            i8 = 0;
        }
        int i11 = i8 | i10;
        this.f1663y = i11;
        if (i9 != i11) {
            this.f1652n.K(false);
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c8) {
        if (this.f1648j == c8) {
            return this;
        }
        this.f1648j = Character.toLowerCase(c8);
        this.f1652n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z7) {
        int i8 = this.f1663y;
        int i9 = (z7 ? 1 : 0) | (i8 & (-2));
        this.f1663y = i9;
        if (i8 != i9) {
            this.f1652n.K(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z7) {
        if ((this.f1663y & 4) != 0) {
            this.f1652n.T(this);
        } else {
            s(z7);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z7) {
        if (z7) {
            this.f1663y |= 16;
        } else {
            this.f1663y &= -17;
        }
        this.f1652n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f1651m = 0;
        this.f1650l = drawable;
        this.f1662x = true;
        this.f1652n.K(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f1658t = colorStateList;
        this.f1660v = true;
        this.f1662x = true;
        this.f1652n.K(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f1659u = mode;
        this.f1661w = true;
        this.f1662x = true;
        this.f1652n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f1645g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c8) {
        if (this.f1646h == c8) {
            return this;
        }
        this.f1646h = c8;
        this.f1652n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.C = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f1655q = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c8, char c9) {
        this.f1646h = c8;
        this.f1648j = Character.toLowerCase(c9);
        this.f1652n.K(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public void setShowAsAction(int i8) {
        int i9 = i8 & 3;
        if (i9 != 0 && i9 != 1 && i9 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f1664z = i8;
        this.f1652n.I(this);
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f1643e = charSequence;
        this.f1652n.K(false);
        SubMenuBuilder subMenuBuilder = this.f1653o;
        if (subMenuBuilder != null) {
            subMenuBuilder.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1644f = charSequence;
        this.f1652n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z7) {
        if (y(z7)) {
            this.f1652n.J(this);
        }
        return this;
    }

    public void t(boolean z7) {
        int i8;
        int i9 = this.f1663y & (-5);
        if (z7) {
            i8 = 4;
        } else {
            i8 = 0;
        }
        this.f1663y = i8 | i9;
    }

    public String toString() {
        CharSequence charSequence = this.f1643e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void u(boolean z7) {
        if (z7) {
            this.f1663y |= 32;
        } else {
            this.f1663y &= -33;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.E = contextMenuInfo;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    /* renamed from: w */
    public SupportMenuItem setShowAsActionFlags(int i8) {
        setShowAsAction(i8);
        return this;
    }

    public void x(SubMenuBuilder subMenuBuilder) {
        this.f1653o = subMenuBuilder;
        subMenuBuilder.setHeaderTitle(getTitle());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean y(boolean z7) {
        int i8;
        int i9 = this.f1663y;
        int i10 = i9 & (-9);
        if (z7) {
            i8 = 0;
        } else {
            i8 = 8;
        }
        int i11 = i8 | i10;
        this.f1663y = i11;
        if (i9 == i11) {
            return false;
        }
        return true;
    }

    public boolean z() {
        return this.f1652n.A();
    }

    @Override // android.view.MenuItem
    @NonNull
    public SupportMenuItem setContentDescription(CharSequence charSequence) {
        this.f1656r = charSequence;
        this.f1652n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    @NonNull
    public SupportMenuItem setTooltipText(CharSequence charSequence) {
        this.f1657s = charSequence;
        this.f1652n.K(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public MenuItem setAlphabeticShortcut(char c8, int i8) {
        if (this.f1648j == c8 && this.f1649k == i8) {
            return this;
        }
        this.f1648j = Character.toLowerCase(c8);
        this.f1649k = KeyEvent.normalizeMetaState(i8);
        this.f1652n.K(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public MenuItem setNumericShortcut(char c8, int i8) {
        if (this.f1646h == c8 && this.f1647i == i8) {
            return this;
        }
        this.f1646h = c8;
        this.f1647i = KeyEvent.normalizeMetaState(i8);
        this.f1652n.K(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public MenuItem setShortcut(char c8, char c9, int i8, int i9) {
        this.f1646h = c8;
        this.f1647i = KeyEvent.normalizeMetaState(i8);
        this.f1648j = Character.toLowerCase(c9);
        this.f1649k = KeyEvent.normalizeMetaState(i9);
        this.f1652n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i8) {
        this.f1650l = null;
        this.f1651m = i8;
        this.f1662x = true;
        this.f1652n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i8) {
        return setTitle(this.f1652n.u().getString(i8));
    }
}
