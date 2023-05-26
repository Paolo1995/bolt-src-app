package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.internal.view.SupportSubMenu;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SubMenuWrapperICS extends MenuWrapperICS implements SubMenu {

    /* renamed from: e  reason: collision with root package name */
    private final SupportSubMenu f1714e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SubMenuWrapperICS(Context context, SupportSubMenu supportSubMenu) {
        super(context, supportSubMenu);
        this.f1714e = supportSubMenu;
    }

    @Override // android.view.SubMenu
    public void clearHeader() {
        this.f1714e.clearHeader();
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return c(this.f1714e.getItem());
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i8) {
        this.f1714e.setHeaderIcon(i8);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i8) {
        this.f1714e.setHeaderTitle(i8);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        this.f1714e.setHeaderView(view);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i8) {
        this.f1714e.setIcon(i8);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        this.f1714e.setHeaderIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.f1714e.setHeaderTitle(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.f1714e.setIcon(drawable);
        return this;
    }
}
