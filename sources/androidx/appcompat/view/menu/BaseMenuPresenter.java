package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class BaseMenuPresenter implements MenuPresenter {

    /* renamed from: f  reason: collision with root package name */
    protected Context f1529f;

    /* renamed from: g  reason: collision with root package name */
    protected Context f1530g;

    /* renamed from: h  reason: collision with root package name */
    protected MenuBuilder f1531h;

    /* renamed from: i  reason: collision with root package name */
    protected LayoutInflater f1532i;

    /* renamed from: j  reason: collision with root package name */
    protected LayoutInflater f1533j;

    /* renamed from: k  reason: collision with root package name */
    private MenuPresenter.Callback f1534k;

    /* renamed from: l  reason: collision with root package name */
    private int f1535l;

    /* renamed from: m  reason: collision with root package name */
    private int f1536m;

    /* renamed from: n  reason: collision with root package name */
    protected MenuView f1537n;

    /* renamed from: o  reason: collision with root package name */
    private int f1538o;

    public BaseMenuPresenter(Context context, int i8, int i9) {
        this.f1529f = context;
        this.f1532i = LayoutInflater.from(context);
        this.f1535l = i8;
        this.f1536m = i9;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void a(MenuBuilder menuBuilder, boolean z7) {
        MenuPresenter.Callback callback = this.f1534k;
        if (callback != null) {
            callback.a(menuBuilder, z7);
        }
    }

    protected void b(View view, int i8) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f1537n).addView(view, i8);
    }

    public abstract void c(MenuItemImpl menuItemImpl, MenuView.ItemView itemView);

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean d(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void e(MenuPresenter.Callback callback) {
        this.f1534k = callback;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.appcompat.view.menu.MenuBuilder] */
    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean f(SubMenuBuilder subMenuBuilder) {
        MenuPresenter.Callback callback = this.f1534k;
        SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
        if (callback != null) {
            if (subMenuBuilder == null) {
                subMenuBuilder2 = this.f1531h;
            }
            return callback.b(subMenuBuilder2);
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void g(boolean z7) {
        MenuItemImpl menuItemImpl;
        ViewGroup viewGroup = (ViewGroup) this.f1537n;
        if (viewGroup == null) {
            return;
        }
        MenuBuilder menuBuilder = this.f1531h;
        int i8 = 0;
        if (menuBuilder != null) {
            menuBuilder.r();
            ArrayList<MenuItemImpl> E = this.f1531h.E();
            int size = E.size();
            int i9 = 0;
            for (int i10 = 0; i10 < size; i10++) {
                MenuItemImpl menuItemImpl2 = E.get(i10);
                if (q(i9, menuItemImpl2)) {
                    View childAt = viewGroup.getChildAt(i9);
                    if (childAt instanceof MenuView.ItemView) {
                        menuItemImpl = ((MenuView.ItemView) childAt).getItemData();
                    } else {
                        menuItemImpl = null;
                    }
                    View n8 = n(menuItemImpl2, childAt, viewGroup);
                    if (menuItemImpl2 != menuItemImpl) {
                        n8.setPressed(false);
                        n8.jumpDrawablesToCurrentState();
                    }
                    if (n8 != childAt) {
                        b(n8, i9);
                    }
                    i9++;
                }
            }
            i8 = i9;
        }
        while (i8 < viewGroup.getChildCount()) {
            if (!l(viewGroup, i8)) {
                i8++;
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean i(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void j(Context context, MenuBuilder menuBuilder) {
        this.f1530g = context;
        this.f1533j = LayoutInflater.from(context);
        this.f1531h = menuBuilder;
    }

    public MenuView.ItemView k(ViewGroup viewGroup) {
        return (MenuView.ItemView) this.f1532i.inflate(this.f1536m, viewGroup, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean l(ViewGroup viewGroup, int i8) {
        viewGroup.removeViewAt(i8);
        return true;
    }

    public MenuPresenter.Callback m() {
        return this.f1534k;
    }

    public View n(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        MenuView.ItemView k8;
        if (view instanceof MenuView.ItemView) {
            k8 = (MenuView.ItemView) view;
        } else {
            k8 = k(viewGroup);
        }
        c(menuItemImpl, k8);
        return (View) k8;
    }

    public MenuView o(ViewGroup viewGroup) {
        if (this.f1537n == null) {
            MenuView menuView = (MenuView) this.f1532i.inflate(this.f1535l, viewGroup, false);
            this.f1537n = menuView;
            menuView.a(this.f1531h);
            g(true);
        }
        return this.f1537n;
    }

    public void p(int i8) {
        this.f1538o = i8;
    }

    public abstract boolean q(int i8, MenuItemImpl menuItemImpl);
}
