package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ListMenuPresenter implements MenuPresenter, AdapterView.OnItemClickListener {

    /* renamed from: f  reason: collision with root package name */
    Context f1592f;

    /* renamed from: g  reason: collision with root package name */
    LayoutInflater f1593g;

    /* renamed from: h  reason: collision with root package name */
    MenuBuilder f1594h;

    /* renamed from: i  reason: collision with root package name */
    ExpandedMenuView f1595i;

    /* renamed from: j  reason: collision with root package name */
    int f1596j;

    /* renamed from: k  reason: collision with root package name */
    int f1597k;

    /* renamed from: l  reason: collision with root package name */
    int f1598l;

    /* renamed from: m  reason: collision with root package name */
    private MenuPresenter.Callback f1599m;

    /* renamed from: n  reason: collision with root package name */
    MenuAdapter f1600n;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class MenuAdapter extends BaseAdapter {

        /* renamed from: f  reason: collision with root package name */
        private int f1601f = -1;

        public MenuAdapter() {
            a();
        }

        void a() {
            MenuItemImpl v7 = ListMenuPresenter.this.f1594h.v();
            if (v7 != null) {
                ArrayList<MenuItemImpl> z7 = ListMenuPresenter.this.f1594h.z();
                int size = z7.size();
                for (int i8 = 0; i8 < size; i8++) {
                    if (z7.get(i8) == v7) {
                        this.f1601f = i8;
                        return;
                    }
                }
            }
            this.f1601f = -1;
        }

        @Override // android.widget.Adapter
        /* renamed from: b */
        public MenuItemImpl getItem(int i8) {
            ArrayList<MenuItemImpl> z7 = ListMenuPresenter.this.f1594h.z();
            int i9 = i8 + ListMenuPresenter.this.f1596j;
            int i10 = this.f1601f;
            if (i10 >= 0 && i9 >= i10) {
                i9++;
            }
            return z7.get(i9);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = ListMenuPresenter.this.f1594h.z().size() - ListMenuPresenter.this.f1596j;
            if (this.f1601f < 0) {
                return size;
            }
            return size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i8) {
            return i8;
        }

        @Override // android.widget.Adapter
        public View getView(int i8, View view, ViewGroup viewGroup) {
            if (view == null) {
                ListMenuPresenter listMenuPresenter = ListMenuPresenter.this;
                view = listMenuPresenter.f1593g.inflate(listMenuPresenter.f1598l, viewGroup, false);
            }
            ((MenuView.ItemView) view).c(getItem(i8), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public ListMenuPresenter(Context context, int i8) {
        this(i8, 0);
        this.f1592f = context;
        this.f1593g = LayoutInflater.from(context);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void a(MenuBuilder menuBuilder, boolean z7) {
        MenuPresenter.Callback callback = this.f1599m;
        if (callback != null) {
            callback.a(menuBuilder, z7);
        }
    }

    public ListAdapter b() {
        if (this.f1600n == null) {
            this.f1600n = new MenuAdapter();
        }
        return this.f1600n;
    }

    public MenuView c(ViewGroup viewGroup) {
        if (this.f1595i == null) {
            this.f1595i = (ExpandedMenuView) this.f1593g.inflate(R$layout.f923g, viewGroup, false);
            if (this.f1600n == null) {
                this.f1600n = new MenuAdapter();
            }
            this.f1595i.setAdapter((ListAdapter) this.f1600n);
            this.f1595i.setOnItemClickListener(this);
        }
        return this.f1595i;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean d(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void e(MenuPresenter.Callback callback) {
        this.f1599m = callback;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean f(SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        new MenuDialogHelper(subMenuBuilder).d(null);
        MenuPresenter.Callback callback = this.f1599m;
        if (callback != null) {
            callback.b(subMenuBuilder);
            return true;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void g(boolean z7) {
        MenuAdapter menuAdapter = this.f1600n;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
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
    public void j(Context context, MenuBuilder menuBuilder) {
        if (this.f1597k != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f1597k);
            this.f1592f = contextThemeWrapper;
            this.f1593g = LayoutInflater.from(contextThemeWrapper);
        } else if (this.f1592f != null) {
            this.f1592f = context;
            if (this.f1593g == null) {
                this.f1593g = LayoutInflater.from(context);
            }
        }
        this.f1594h = menuBuilder;
        MenuAdapter menuAdapter = this.f1600n;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i8, long j8) {
        this.f1594h.M(this.f1600n.getItem(i8), this, 0);
    }

    public ListMenuPresenter(int i8, int i9) {
        this.f1598l = i8;
        this.f1597k = i9;
    }
}
