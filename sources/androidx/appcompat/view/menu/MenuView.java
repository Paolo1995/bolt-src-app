package androidx.appcompat.view.menu;

/* loaded from: classes.dex */
public interface MenuView {

    /* loaded from: classes.dex */
    public interface ItemView {
        void c(MenuItemImpl menuItemImpl, int i8);

        boolean d();

        MenuItemImpl getItemData();
    }

    void a(MenuBuilder menuBuilder);
}
