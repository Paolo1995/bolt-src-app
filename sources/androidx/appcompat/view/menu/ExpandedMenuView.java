package androidx.appcompat.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.TintTypedArray;

/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements MenuBuilder.ItemInvoker, MenuView, AdapterView.OnItemClickListener {

    /* renamed from: h  reason: collision with root package name */
    private static final int[] f1572h = {16842964, 16843049};

    /* renamed from: f  reason: collision with root package name */
    private MenuBuilder f1573f;

    /* renamed from: g  reason: collision with root package name */
    private int f1574g;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void a(MenuBuilder menuBuilder) {
        this.f1573f = menuBuilder;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.ItemInvoker
    public boolean b(MenuItemImpl menuItemImpl) {
        return this.f1573f.L(menuItemImpl, 0);
    }

    public int getWindowAnimations() {
        return this.f1574g;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i8, long j8) {
        b((MenuItemImpl) getAdapter().getItem(i8));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        TintTypedArray v7 = TintTypedArray.v(context, attributeSet, f1572h, i8, 0);
        if (v7.s(0)) {
            setBackgroundDrawable(v7.g(0));
        }
        if (v7.s(1)) {
            setDivider(v7.g(1));
        }
        v7.w();
    }
}
