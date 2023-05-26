package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class MenuAdapter extends BaseAdapter {

    /* renamed from: f  reason: collision with root package name */
    MenuBuilder f1603f;

    /* renamed from: g  reason: collision with root package name */
    private int f1604g = -1;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1605h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f1606i;

    /* renamed from: j  reason: collision with root package name */
    private final LayoutInflater f1607j;

    /* renamed from: k  reason: collision with root package name */
    private final int f1608k;

    public MenuAdapter(MenuBuilder menuBuilder, LayoutInflater layoutInflater, boolean z7, int i8) {
        this.f1606i = z7;
        this.f1607j = layoutInflater;
        this.f1603f = menuBuilder;
        this.f1608k = i8;
        a();
    }

    void a() {
        MenuItemImpl v7 = this.f1603f.v();
        if (v7 != null) {
            ArrayList<MenuItemImpl> z7 = this.f1603f.z();
            int size = z7.size();
            for (int i8 = 0; i8 < size; i8++) {
                if (z7.get(i8) == v7) {
                    this.f1604g = i8;
                    return;
                }
            }
        }
        this.f1604g = -1;
    }

    public MenuBuilder b() {
        return this.f1603f;
    }

    @Override // android.widget.Adapter
    /* renamed from: c */
    public MenuItemImpl getItem(int i8) {
        ArrayList<MenuItemImpl> E;
        if (this.f1606i) {
            E = this.f1603f.z();
        } else {
            E = this.f1603f.E();
        }
        int i9 = this.f1604g;
        if (i9 >= 0 && i8 >= i9) {
            i8++;
        }
        return E.get(i8);
    }

    public void d(boolean z7) {
        this.f1605h = z7;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<MenuItemImpl> E;
        if (this.f1606i) {
            E = this.f1603f.z();
        } else {
            E = this.f1603f.E();
        }
        if (this.f1604g < 0) {
            return E.size();
        }
        return E.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i8) {
        return i8;
    }

    @Override // android.widget.Adapter
    public View getView(int i8, View view, ViewGroup viewGroup) {
        int i9;
        boolean z7;
        if (view == null) {
            view = this.f1607j.inflate(this.f1608k, viewGroup, false);
        }
        int groupId = getItem(i8).getGroupId();
        int i10 = i8 - 1;
        if (i10 >= 0) {
            i9 = getItem(i10).getGroupId();
        } else {
            i9 = groupId;
        }
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.f1603f.F() && groupId != i9) {
            z7 = true;
        } else {
            z7 = false;
        }
        listMenuItemView.setGroupDividerEnabled(z7);
        MenuView.ItemView itemView = (MenuView.ItemView) view;
        if (this.f1605h) {
            listMenuItemView.setForceShowIcon(true);
        }
        itemView.c(getItem(i8), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
