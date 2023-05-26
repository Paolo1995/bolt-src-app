package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.internal.view.SupportSubMenu;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class BaseMenuWrapper {

    /* renamed from: a  reason: collision with root package name */
    final Context f1539a;

    /* renamed from: b  reason: collision with root package name */
    private SimpleArrayMap<SupportMenuItem, MenuItem> f1540b;

    /* renamed from: c  reason: collision with root package name */
    private SimpleArrayMap<SupportSubMenu, SubMenu> f1541c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseMenuWrapper(Context context) {
        this.f1539a = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MenuItem c(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
            if (this.f1540b == null) {
                this.f1540b = new SimpleArrayMap<>();
            }
            MenuItem menuItem2 = this.f1540b.get(supportMenuItem);
            if (menuItem2 == null) {
                MenuItemWrapperICS menuItemWrapperICS = new MenuItemWrapperICS(this.f1539a, supportMenuItem);
                this.f1540b.put(supportMenuItem, menuItemWrapperICS);
                return menuItemWrapperICS;
            }
            return menuItem2;
        }
        return menuItem;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SubMenu d(SubMenu subMenu) {
        if (subMenu instanceof SupportSubMenu) {
            SupportSubMenu supportSubMenu = (SupportSubMenu) subMenu;
            if (this.f1541c == null) {
                this.f1541c = new SimpleArrayMap<>();
            }
            SubMenu subMenu2 = this.f1541c.get(supportSubMenu);
            if (subMenu2 == null) {
                SubMenuWrapperICS subMenuWrapperICS = new SubMenuWrapperICS(this.f1539a, supportSubMenu);
                this.f1541c.put(supportSubMenu, subMenuWrapperICS);
                return subMenuWrapperICS;
            }
            return subMenu2;
        }
        return subMenu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e() {
        SimpleArrayMap<SupportMenuItem, MenuItem> simpleArrayMap = this.f1540b;
        if (simpleArrayMap != null) {
            simpleArrayMap.clear();
        }
        SimpleArrayMap<SupportSubMenu, SubMenu> simpleArrayMap2 = this.f1541c;
        if (simpleArrayMap2 != null) {
            simpleArrayMap2.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(int i8) {
        if (this.f1540b == null) {
            return;
        }
        int i9 = 0;
        while (i9 < this.f1540b.size()) {
            if (this.f1540b.j(i9).getGroupId() == i8) {
                this.f1540b.l(i9);
                i9--;
            }
            i9++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g(int i8) {
        if (this.f1540b == null) {
            return;
        }
        for (int i9 = 0; i9 < this.f1540b.size(); i9++) {
            if (this.f1540b.j(i9).getItemId() == i8) {
                this.f1540b.l(i9);
                return;
            }
        }
    }
}
