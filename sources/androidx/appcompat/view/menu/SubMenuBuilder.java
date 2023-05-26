package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuBuilder;

/* loaded from: classes.dex */
public class SubMenuBuilder extends MenuBuilder implements SubMenu {
    private MenuBuilder B;
    private MenuItemImpl C;

    public SubMenuBuilder(Context context, MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        super(context);
        this.B = menuBuilder;
        this.C = menuItemImpl;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public MenuBuilder D() {
        return this.B.D();
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean F() {
        return this.B.F();
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean G() {
        return this.B.G();
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean H() {
        return this.B.H();
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public void R(MenuBuilder.Callback callback) {
        this.B.R(callback);
    }

    public Menu e0() {
        return this.B;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean f(MenuItemImpl menuItemImpl) {
        return this.B.f(menuItemImpl);
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean h(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        if (!super.h(menuBuilder, menuItem) && !this.B.h(menuBuilder, menuItem)) {
            return false;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean k(MenuItemImpl menuItemImpl) {
        return this.B.k(menuItemImpl);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    public void setGroupDividerEnabled(boolean z7) {
        this.B.setGroupDividerEnabled(z7);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.V(drawable);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.Y(charSequence);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.Z(view);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.C.setIcon(drawable);
        return this;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    public void setQwertyMode(boolean z7) {
        this.B.setQwertyMode(z7);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public String t() {
        int i8;
        MenuItemImpl menuItemImpl = this.C;
        if (menuItemImpl != null) {
            i8 = menuItemImpl.getItemId();
        } else {
            i8 = 0;
        }
        if (i8 == 0) {
            return null;
        }
        return super.t() + ":" + i8;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i8) {
        return (SubMenu) super.U(i8);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i8) {
        return (SubMenu) super.X(i8);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i8) {
        this.C.setIcon(i8);
        return this;
    }
}
