package com.google.android.material.navigation;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.SubMenuBuilder;

/* loaded from: classes.dex */
public class NavigationBarPresenter implements MenuPresenter {

    /* renamed from: f  reason: collision with root package name */
    private MenuBuilder f13738f;

    /* renamed from: g  reason: collision with root package name */
    private NavigationBarMenuView f13739g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f13740h = false;

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void a(MenuBuilder menuBuilder, boolean z7) {
    }

    public void b(boolean z7) {
        this.f13740h = z7;
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
        if (this.f13740h) {
            return;
        }
        if (z7) {
            this.f13739g.b();
        } else {
            this.f13739g.h();
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
        this.f13738f = menuBuilder;
        this.f13739g.a(menuBuilder);
    }
}
