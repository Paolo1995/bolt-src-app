package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.ViewConfigurationCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.internal.http2.Settings;

/* loaded from: classes.dex */
public class MenuBuilder implements SupportMenu {
    private static final int[] A = {1, 4, 5, 3, 2, 0};

    /* renamed from: a  reason: collision with root package name */
    private final Context f1609a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f1610b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1611c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1612d;

    /* renamed from: e  reason: collision with root package name */
    private Callback f1613e;

    /* renamed from: m  reason: collision with root package name */
    private ContextMenu.ContextMenuInfo f1621m;

    /* renamed from: n  reason: collision with root package name */
    CharSequence f1622n;

    /* renamed from: o  reason: collision with root package name */
    Drawable f1623o;

    /* renamed from: p  reason: collision with root package name */
    View f1624p;

    /* renamed from: x  reason: collision with root package name */
    private MenuItemImpl f1632x;

    /* renamed from: z  reason: collision with root package name */
    private boolean f1634z;

    /* renamed from: l  reason: collision with root package name */
    private int f1620l = 0;

    /* renamed from: q  reason: collision with root package name */
    private boolean f1625q = false;

    /* renamed from: r  reason: collision with root package name */
    private boolean f1626r = false;

    /* renamed from: s  reason: collision with root package name */
    private boolean f1627s = false;

    /* renamed from: t  reason: collision with root package name */
    private boolean f1628t = false;

    /* renamed from: u  reason: collision with root package name */
    private boolean f1629u = false;

    /* renamed from: v  reason: collision with root package name */
    private ArrayList<MenuItemImpl> f1630v = new ArrayList<>();

    /* renamed from: w  reason: collision with root package name */
    private CopyOnWriteArrayList<WeakReference<MenuPresenter>> f1631w = new CopyOnWriteArrayList<>();

    /* renamed from: y  reason: collision with root package name */
    private boolean f1633y = false;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<MenuItemImpl> f1614f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<MenuItemImpl> f1615g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private boolean f1616h = true;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<MenuItemImpl> f1617i = new ArrayList<>();

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<MenuItemImpl> f1618j = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    private boolean f1619k = true;

    /* loaded from: classes.dex */
    public interface Callback {
        boolean a(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem);

        void b(@NonNull MenuBuilder menuBuilder);
    }

    /* loaded from: classes.dex */
    public interface ItemInvoker {
        boolean b(MenuItemImpl menuItemImpl);
    }

    public MenuBuilder(Context context) {
        this.f1609a = context;
        this.f1610b = context.getResources();
        b0(true);
    }

    private static int B(int i8) {
        int i9 = ((-65536) & i8) >> 16;
        if (i9 >= 0) {
            int[] iArr = A;
            if (i9 < iArr.length) {
                return (i8 & Settings.DEFAULT_INITIAL_WINDOW_SIZE) | (iArr[i9] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void N(int i8, boolean z7) {
        if (i8 >= 0 && i8 < this.f1614f.size()) {
            this.f1614f.remove(i8);
            if (z7) {
                K(true);
            }
        }
    }

    private void W(int i8, CharSequence charSequence, int i9, Drawable drawable, View view) {
        Resources C = C();
        if (view != null) {
            this.f1624p = view;
            this.f1622n = null;
            this.f1623o = null;
        } else {
            if (i8 > 0) {
                this.f1622n = C.getText(i8);
            } else if (charSequence != null) {
                this.f1622n = charSequence;
            }
            if (i9 > 0) {
                this.f1623o = ContextCompat.getDrawable(u(), i9);
            } else if (drawable != null) {
                this.f1623o = drawable;
            }
            this.f1624p = null;
        }
        K(false);
    }

    private void b0(boolean z7) {
        boolean z8 = true;
        this.f1612d = (z7 && this.f1610b.getConfiguration().keyboard != 1 && ViewConfigurationCompat.e(ViewConfiguration.get(this.f1609a), this.f1609a)) ? false : false;
    }

    private MenuItemImpl g(int i8, int i9, int i10, int i11, CharSequence charSequence, int i12) {
        return new MenuItemImpl(this, i8, i9, i10, i11, charSequence, i12);
    }

    private void i(boolean z7) {
        if (this.f1631w.isEmpty()) {
            return;
        }
        d0();
        Iterator<WeakReference<MenuPresenter>> it = this.f1631w.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter = next.get();
            if (menuPresenter == null) {
                this.f1631w.remove(next);
            } else {
                menuPresenter.g(z7);
            }
        }
        c0();
    }

    private boolean j(SubMenuBuilder subMenuBuilder, MenuPresenter menuPresenter) {
        boolean z7 = false;
        if (this.f1631w.isEmpty()) {
            return false;
        }
        if (menuPresenter != null) {
            z7 = menuPresenter.f(subMenuBuilder);
        }
        Iterator<WeakReference<MenuPresenter>> it = this.f1631w.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter2 = next.get();
            if (menuPresenter2 == null) {
                this.f1631w.remove(next);
            } else if (!z7) {
                z7 = menuPresenter2.f(subMenuBuilder);
            }
        }
        return z7;
    }

    private static int n(ArrayList<MenuItemImpl> arrayList, int i8) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).f() <= i8) {
                return size + 1;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean A() {
        return this.f1628t;
    }

    Resources C() {
        return this.f1610b;
    }

    public MenuBuilder D() {
        return this;
    }

    @NonNull
    public ArrayList<MenuItemImpl> E() {
        if (!this.f1616h) {
            return this.f1615g;
        }
        this.f1615g.clear();
        int size = this.f1614f.size();
        for (int i8 = 0; i8 < size; i8++) {
            MenuItemImpl menuItemImpl = this.f1614f.get(i8);
            if (menuItemImpl.isVisible()) {
                this.f1615g.add(menuItemImpl);
            }
        }
        this.f1616h = false;
        this.f1619k = true;
        return this.f1615g;
    }

    public boolean F() {
        return this.f1633y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean G() {
        return this.f1611c;
    }

    public boolean H() {
        return this.f1612d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(MenuItemImpl menuItemImpl) {
        this.f1619k = true;
        K(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(MenuItemImpl menuItemImpl) {
        this.f1616h = true;
        K(true);
    }

    public void K(boolean z7) {
        if (!this.f1625q) {
            if (z7) {
                this.f1616h = true;
                this.f1619k = true;
            }
            i(z7);
            return;
        }
        this.f1626r = true;
        if (z7) {
            this.f1627s = true;
        }
    }

    public boolean L(MenuItem menuItem, int i8) {
        return M(menuItem, null, i8);
    }

    public boolean M(MenuItem menuItem, MenuPresenter menuPresenter, int i8) {
        boolean z7;
        MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
        if (menuItemImpl == null || !menuItemImpl.isEnabled()) {
            return false;
        }
        boolean k8 = menuItemImpl.k();
        ActionProvider a8 = menuItemImpl.a();
        if (a8 != null && a8.a()) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (menuItemImpl.j()) {
            k8 |= menuItemImpl.expandActionView();
            if (k8) {
                e(true);
            }
        } else if (!menuItemImpl.hasSubMenu() && !z7) {
            if ((i8 & 1) == 0) {
                e(true);
            }
        } else {
            if ((i8 & 4) == 0) {
                e(false);
            }
            if (!menuItemImpl.hasSubMenu()) {
                menuItemImpl.x(new SubMenuBuilder(u(), this, menuItemImpl));
            }
            SubMenuBuilder subMenuBuilder = (SubMenuBuilder) menuItemImpl.getSubMenu();
            if (z7) {
                a8.f(subMenuBuilder);
            }
            k8 |= j(subMenuBuilder, menuPresenter);
            if (!k8) {
                e(true);
            }
        }
        return k8;
    }

    public void O(MenuPresenter menuPresenter) {
        Iterator<WeakReference<MenuPresenter>> it = this.f1631w.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter2 = next.get();
            if (menuPresenter2 == null || menuPresenter2 == menuPresenter) {
                this.f1631w.remove(next);
            }
        }
    }

    public void P(Bundle bundle) {
        MenuItem findItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(t());
        int size = size();
        for (int i8 = 0; i8 < size; i8++) {
            MenuItem item = getItem(i8);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((SubMenuBuilder) item.getSubMenu()).P(bundle);
            }
        }
        int i9 = bundle.getInt("android:menu:expandedactionview");
        if (i9 > 0 && (findItem = findItem(i9)) != null) {
            findItem.expandActionView();
        }
    }

    public void Q(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i8 = 0; i8 < size; i8++) {
            MenuItem item = getItem(i8);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((SubMenuBuilder) item.getSubMenu()).Q(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(t(), sparseArray);
        }
    }

    public void R(Callback callback) {
        this.f1613e = callback;
    }

    public MenuBuilder S(int i8) {
        this.f1620l = i8;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(MenuItem menuItem) {
        boolean z7;
        int groupId = menuItem.getGroupId();
        int size = this.f1614f.size();
        d0();
        for (int i8 = 0; i8 < size; i8++) {
            MenuItemImpl menuItemImpl = this.f1614f.get(i8);
            if (menuItemImpl.getGroupId() == groupId && menuItemImpl.m() && menuItemImpl.isCheckable()) {
                if (menuItemImpl == menuItem) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                menuItemImpl.s(z7);
            }
        }
        c0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MenuBuilder U(int i8) {
        W(0, null, i8, null, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MenuBuilder V(Drawable drawable) {
        W(0, null, 0, drawable, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MenuBuilder X(int i8) {
        W(i8, null, 0, null, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MenuBuilder Y(CharSequence charSequence) {
        W(0, charSequence, 0, null, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MenuBuilder Z(View view) {
        W(0, null, 0, null, view);
        return this;
    }

    protected MenuItem a(int i8, int i9, int i10, CharSequence charSequence) {
        int B = B(i10);
        MenuItemImpl g8 = g(i8, i9, i10, B, charSequence, this.f1620l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f1621m;
        if (contextMenuInfo != null) {
            g8.v(contextMenuInfo);
        }
        ArrayList<MenuItemImpl> arrayList = this.f1614f;
        arrayList.add(n(arrayList, B), g8);
        K(true);
        return g8;
    }

    public void a0(boolean z7) {
        this.f1634z = z7;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i8, int i9, int i10, ComponentName componentName, Intent[] intentArr, Intent intent, int i11, MenuItem[] menuItemArr) {
        int i12;
        Intent intent2;
        int i13;
        PackageManager packageManager = this.f1609a.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        if (queryIntentActivityOptions != null) {
            i12 = queryIntentActivityOptions.size();
        } else {
            i12 = 0;
        }
        if ((i11 & 1) == 0) {
            removeGroup(i8);
        }
        for (int i14 = 0; i14 < i12; i14++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i14);
            int i15 = resolveInfo.specificIndex;
            if (i15 < 0) {
                intent2 = intent;
            } else {
                intent2 = intentArr[i15];
            }
            Intent intent3 = new Intent(intent2);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent3.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent4 = add(i8, i9, i10, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent3);
            if (menuItemArr != null && (i13 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i13] = intent4;
            }
        }
        return i12;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(MenuPresenter menuPresenter) {
        c(menuPresenter, this.f1609a);
    }

    public void c(MenuPresenter menuPresenter, Context context) {
        this.f1631w.add(new WeakReference<>(menuPresenter));
        menuPresenter.j(context, this);
        this.f1619k = true;
    }

    public void c0() {
        this.f1625q = false;
        if (this.f1626r) {
            this.f1626r = false;
            K(this.f1627s);
        }
    }

    @Override // android.view.Menu
    public void clear() {
        MenuItemImpl menuItemImpl = this.f1632x;
        if (menuItemImpl != null) {
            f(menuItemImpl);
        }
        this.f1614f.clear();
        K(true);
    }

    public void clearHeader() {
        this.f1623o = null;
        this.f1622n = null;
        this.f1624p = null;
        K(false);
    }

    @Override // android.view.Menu
    public void close() {
        e(true);
    }

    public void d() {
        Callback callback = this.f1613e;
        if (callback != null) {
            callback.b(this);
        }
    }

    public void d0() {
        if (!this.f1625q) {
            this.f1625q = true;
            this.f1626r = false;
            this.f1627s = false;
        }
    }

    public final void e(boolean z7) {
        if (this.f1629u) {
            return;
        }
        this.f1629u = true;
        Iterator<WeakReference<MenuPresenter>> it = this.f1631w.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter = next.get();
            if (menuPresenter == null) {
                this.f1631w.remove(next);
            } else {
                menuPresenter.a(this, z7);
            }
        }
        this.f1629u = false;
    }

    public boolean f(MenuItemImpl menuItemImpl) {
        boolean z7 = false;
        if (!this.f1631w.isEmpty() && this.f1632x == menuItemImpl) {
            d0();
            Iterator<WeakReference<MenuPresenter>> it = this.f1631w.iterator();
            while (it.hasNext()) {
                WeakReference<MenuPresenter> next = it.next();
                MenuPresenter menuPresenter = next.get();
                if (menuPresenter == null) {
                    this.f1631w.remove(next);
                } else {
                    z7 = menuPresenter.i(this, menuItemImpl);
                    if (z7) {
                        break;
                    }
                }
            }
            c0();
            if (z7) {
                this.f1632x = null;
            }
        }
        return z7;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i8) {
        MenuItem findItem;
        int size = size();
        for (int i9 = 0; i9 < size; i9++) {
            MenuItemImpl menuItemImpl = this.f1614f.get(i9);
            if (menuItemImpl.getItemId() == i8) {
                return menuItemImpl;
            }
            if (menuItemImpl.hasSubMenu() && (findItem = menuItemImpl.getSubMenu().findItem(i8)) != null) {
                return findItem;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i8) {
        return this.f1614f.get(i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        Callback callback = this.f1613e;
        if (callback != null && callback.a(menuBuilder, menuItem)) {
            return true;
        }
        return false;
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.f1634z) {
            return true;
        }
        int size = size();
        for (int i8 = 0; i8 < size; i8++) {
            if (this.f1614f.get(i8).isVisible()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i8, KeyEvent keyEvent) {
        if (p(i8, keyEvent) != null) {
            return true;
        }
        return false;
    }

    public boolean k(MenuItemImpl menuItemImpl) {
        boolean z7 = false;
        if (this.f1631w.isEmpty()) {
            return false;
        }
        d0();
        Iterator<WeakReference<MenuPresenter>> it = this.f1631w.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter = next.get();
            if (menuPresenter == null) {
                this.f1631w.remove(next);
            } else {
                z7 = menuPresenter.d(this, menuItemImpl);
                if (z7) {
                    break;
                }
            }
        }
        c0();
        if (z7) {
            this.f1632x = menuItemImpl;
        }
        return z7;
    }

    public int l(int i8) {
        return m(i8, 0);
    }

    public int m(int i8, int i9) {
        int size = size();
        if (i9 < 0) {
            i9 = 0;
        }
        while (i9 < size) {
            if (this.f1614f.get(i9).getGroupId() == i8) {
                return i9;
            }
            i9++;
        }
        return -1;
    }

    public int o(int i8) {
        int size = size();
        for (int i9 = 0; i9 < size; i9++) {
            if (this.f1614f.get(i9).getItemId() == i8) {
                return i9;
            }
        }
        return -1;
    }

    MenuItemImpl p(int i8, KeyEvent keyEvent) {
        char numericShortcut;
        ArrayList<MenuItemImpl> arrayList = this.f1630v;
        arrayList.clear();
        q(arrayList, i8, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean G = G();
        for (int i9 = 0; i9 < size; i9++) {
            MenuItemImpl menuItemImpl = arrayList.get(i9);
            if (G) {
                numericShortcut = menuItemImpl.getAlphabeticShortcut();
            } else {
                numericShortcut = menuItemImpl.getNumericShortcut();
            }
            char[] cArr = keyData.meta;
            if ((numericShortcut == cArr[0] && (metaState & 2) == 0) || ((numericShortcut == cArr[2] && (metaState & 2) != 0) || (G && numericShortcut == '\b' && i8 == 67))) {
                return menuItemImpl;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i8, int i9) {
        return L(findItem(i8), i9);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i8, KeyEvent keyEvent, int i9) {
        boolean z7;
        MenuItemImpl p8 = p(i8, keyEvent);
        if (p8 != null) {
            z7 = L(p8, i9);
        } else {
            z7 = false;
        }
        if ((i9 & 2) != 0) {
            e(true);
        }
        return z7;
    }

    void q(List<MenuItemImpl> list, int i8, KeyEvent keyEvent) {
        char numericShortcut;
        int numericModifiers;
        boolean z7;
        boolean G = G();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (!keyEvent.getKeyData(keyData) && i8 != 67) {
            return;
        }
        int size = this.f1614f.size();
        for (int i9 = 0; i9 < size; i9++) {
            MenuItemImpl menuItemImpl = this.f1614f.get(i9);
            if (menuItemImpl.hasSubMenu()) {
                ((MenuBuilder) menuItemImpl.getSubMenu()).q(list, i8, keyEvent);
            }
            if (G) {
                numericShortcut = menuItemImpl.getAlphabeticShortcut();
            } else {
                numericShortcut = menuItemImpl.getNumericShortcut();
            }
            if (G) {
                numericModifiers = menuItemImpl.getAlphabeticModifiers();
            } else {
                numericModifiers = menuItemImpl.getNumericModifiers();
            }
            if ((modifiers & 69647) == (numericModifiers & 69647)) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7 && numericShortcut != 0) {
                char[] cArr = keyData.meta;
                if ((numericShortcut == cArr[0] || numericShortcut == cArr[2] || (G && numericShortcut == '\b' && i8 == 67)) && menuItemImpl.isEnabled()) {
                    list.add(menuItemImpl);
                }
            }
        }
    }

    public void r() {
        ArrayList<MenuItemImpl> E = E();
        if (!this.f1619k) {
            return;
        }
        Iterator<WeakReference<MenuPresenter>> it = this.f1631w.iterator();
        boolean z7 = false;
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter = next.get();
            if (menuPresenter == null) {
                this.f1631w.remove(next);
            } else {
                z7 |= menuPresenter.h();
            }
        }
        if (z7) {
            this.f1617i.clear();
            this.f1618j.clear();
            int size = E.size();
            for (int i8 = 0; i8 < size; i8++) {
                MenuItemImpl menuItemImpl = E.get(i8);
                if (menuItemImpl.l()) {
                    this.f1617i.add(menuItemImpl);
                } else {
                    this.f1618j.add(menuItemImpl);
                }
            }
        } else {
            this.f1617i.clear();
            this.f1618j.clear();
            this.f1618j.addAll(E());
        }
        this.f1619k = false;
    }

    @Override // android.view.Menu
    public void removeGroup(int i8) {
        int l8 = l(i8);
        if (l8 >= 0) {
            int size = this.f1614f.size() - l8;
            int i9 = 0;
            while (true) {
                int i10 = i9 + 1;
                if (i9 >= size || this.f1614f.get(l8).getGroupId() != i8) {
                    break;
                }
                N(l8, false);
                i9 = i10;
            }
            K(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i8) {
        N(o(i8), true);
    }

    public ArrayList<MenuItemImpl> s() {
        r();
        return this.f1617i;
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i8, boolean z7, boolean z8) {
        int size = this.f1614f.size();
        for (int i9 = 0; i9 < size; i9++) {
            MenuItemImpl menuItemImpl = this.f1614f.get(i9);
            if (menuItemImpl.getGroupId() == i8) {
                menuItemImpl.t(z8);
                menuItemImpl.setCheckable(z7);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z7) {
        this.f1633y = z7;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i8, boolean z7) {
        int size = this.f1614f.size();
        for (int i9 = 0; i9 < size; i9++) {
            MenuItemImpl menuItemImpl = this.f1614f.get(i9);
            if (menuItemImpl.getGroupId() == i8) {
                menuItemImpl.setEnabled(z7);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i8, boolean z7) {
        int size = this.f1614f.size();
        boolean z8 = false;
        for (int i9 = 0; i9 < size; i9++) {
            MenuItemImpl menuItemImpl = this.f1614f.get(i9);
            if (menuItemImpl.getGroupId() == i8 && menuItemImpl.y(z7)) {
                z8 = true;
            }
        }
        if (z8) {
            K(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z7) {
        this.f1611c = z7;
        K(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f1614f.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String t() {
        return "android:menu:actionviewstates";
    }

    public Context u() {
        return this.f1609a;
    }

    public MenuItemImpl v() {
        return this.f1632x;
    }

    public Drawable w() {
        return this.f1623o;
    }

    public CharSequence x() {
        return this.f1622n;
    }

    public View y() {
        return this.f1624p;
    }

    public ArrayList<MenuItemImpl> z() {
        r();
        return this.f1618j;
    }

    @Override // android.view.Menu
    public MenuItem add(int i8) {
        return a(0, 0, 0, this.f1610b.getString(i8));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i8) {
        return addSubMenu(0, 0, 0, this.f1610b.getString(i8));
    }

    @Override // android.view.Menu
    public MenuItem add(int i8, int i9, int i10, CharSequence charSequence) {
        return a(i8, i9, i10, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i8, int i9, int i10, CharSequence charSequence) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) a(i8, i9, i10, charSequence);
        SubMenuBuilder subMenuBuilder = new SubMenuBuilder(this.f1609a, this, menuItemImpl);
        menuItemImpl.x(subMenuBuilder);
        return subMenuBuilder;
    }

    @Override // android.view.Menu
    public MenuItem add(int i8, int i9, int i10, int i11) {
        return a(i8, i9, i10, this.f1610b.getString(i11));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i8, int i9, int i10, int i11) {
        return addSubMenu(i8, i9, i10, this.f1610b.getString(i11));
    }
}
