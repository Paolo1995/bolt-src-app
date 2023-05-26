package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final class CascadingMenuPopup extends MenuPopup implements View.OnKeyListener, PopupWindow.OnDismissListener {
    private static final int G = R$layout.f921e;
    private boolean B;
    private MenuPresenter.Callback C;
    ViewTreeObserver D;
    private PopupWindow.OnDismissListener E;
    boolean F;

    /* renamed from: g  reason: collision with root package name */
    private final Context f1542g;

    /* renamed from: h  reason: collision with root package name */
    private final int f1543h;

    /* renamed from: i  reason: collision with root package name */
    private final int f1544i;

    /* renamed from: j  reason: collision with root package name */
    private final int f1545j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f1546k;

    /* renamed from: l  reason: collision with root package name */
    final Handler f1547l;

    /* renamed from: t  reason: collision with root package name */
    private View f1555t;

    /* renamed from: u  reason: collision with root package name */
    View f1556u;

    /* renamed from: w  reason: collision with root package name */
    private boolean f1558w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f1559x;

    /* renamed from: y  reason: collision with root package name */
    private int f1560y;

    /* renamed from: z  reason: collision with root package name */
    private int f1561z;

    /* renamed from: m  reason: collision with root package name */
    private final List<MenuBuilder> f1548m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    final List<CascadingMenuInfo> f1549n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f1550o = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.view.menu.CascadingMenuPopup.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (CascadingMenuPopup.this.c() && CascadingMenuPopup.this.f1549n.size() > 0 && !CascadingMenuPopup.this.f1549n.get(0).f1569a.B()) {
                View view = CascadingMenuPopup.this.f1556u;
                if (view != null && view.isShown()) {
                    for (CascadingMenuInfo cascadingMenuInfo : CascadingMenuPopup.this.f1549n) {
                        cascadingMenuInfo.f1569a.b();
                    }
                    return;
                }
                CascadingMenuPopup.this.dismiss();
            }
        }
    };

    /* renamed from: p  reason: collision with root package name */
    private final View.OnAttachStateChangeListener f1551p = new View.OnAttachStateChangeListener() { // from class: androidx.appcompat.view.menu.CascadingMenuPopup.2
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = CascadingMenuPopup.this.D;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    CascadingMenuPopup.this.D = view.getViewTreeObserver();
                }
                CascadingMenuPopup cascadingMenuPopup = CascadingMenuPopup.this;
                cascadingMenuPopup.D.removeGlobalOnLayoutListener(cascadingMenuPopup.f1550o);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };

    /* renamed from: q  reason: collision with root package name */
    private final MenuItemHoverListener f1552q = new MenuItemHoverListener() { // from class: androidx.appcompat.view.menu.CascadingMenuPopup.3
        @Override // androidx.appcompat.widget.MenuItemHoverListener
        public void a(@NonNull final MenuBuilder menuBuilder, @NonNull final MenuItem menuItem) {
            final CascadingMenuInfo cascadingMenuInfo = null;
            CascadingMenuPopup.this.f1547l.removeCallbacksAndMessages(null);
            int size = CascadingMenuPopup.this.f1549n.size();
            int i8 = 0;
            while (true) {
                if (i8 < size) {
                    if (menuBuilder == CascadingMenuPopup.this.f1549n.get(i8).f1570b) {
                        break;
                    }
                    i8++;
                } else {
                    i8 = -1;
                    break;
                }
            }
            if (i8 == -1) {
                return;
            }
            int i9 = i8 + 1;
            if (i9 < CascadingMenuPopup.this.f1549n.size()) {
                cascadingMenuInfo = CascadingMenuPopup.this.f1549n.get(i9);
            }
            CascadingMenuPopup.this.f1547l.postAtTime(new Runnable() { // from class: androidx.appcompat.view.menu.CascadingMenuPopup.3.1
                @Override // java.lang.Runnable
                public void run() {
                    CascadingMenuInfo cascadingMenuInfo2 = cascadingMenuInfo;
                    if (cascadingMenuInfo2 != null) {
                        CascadingMenuPopup.this.F = true;
                        cascadingMenuInfo2.f1570b.e(false);
                        CascadingMenuPopup.this.F = false;
                    }
                    if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                        menuBuilder.L(menuItem, 4);
                    }
                }
            }, menuBuilder, SystemClock.uptimeMillis() + 200);
        }

        @Override // androidx.appcompat.widget.MenuItemHoverListener
        public void o(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            CascadingMenuPopup.this.f1547l.removeCallbacksAndMessages(menuBuilder);
        }
    };

    /* renamed from: r  reason: collision with root package name */
    private int f1553r = 0;

    /* renamed from: s  reason: collision with root package name */
    private int f1554s = 0;
    private boolean A = false;

    /* renamed from: v  reason: collision with root package name */
    private int f1557v = D();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class CascadingMenuInfo {

        /* renamed from: a  reason: collision with root package name */
        public final MenuPopupWindow f1569a;

        /* renamed from: b  reason: collision with root package name */
        public final MenuBuilder f1570b;

        /* renamed from: c  reason: collision with root package name */
        public final int f1571c;

        public CascadingMenuInfo(@NonNull MenuPopupWindow menuPopupWindow, @NonNull MenuBuilder menuBuilder, int i8) {
            this.f1569a = menuPopupWindow;
            this.f1570b = menuBuilder;
            this.f1571c = i8;
        }

        public ListView a() {
            return this.f1569a.p();
        }
    }

    public CascadingMenuPopup(@NonNull Context context, @NonNull View view, int i8, int i9, boolean z7) {
        this.f1542g = context;
        this.f1555t = view;
        this.f1544i = i8;
        this.f1545j = i9;
        this.f1546k = z7;
        Resources resources = context.getResources();
        this.f1543h = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.f853d));
        this.f1547l = new Handler();
    }

    private int A(@NonNull MenuBuilder menuBuilder) {
        int size = this.f1549n.size();
        for (int i8 = 0; i8 < size; i8++) {
            if (menuBuilder == this.f1549n.get(i8).f1570b) {
                return i8;
            }
        }
        return -1;
    }

    private MenuItem B(@NonNull MenuBuilder menuBuilder, @NonNull MenuBuilder menuBuilder2) {
        int size = menuBuilder.size();
        for (int i8 = 0; i8 < size; i8++) {
            MenuItem item = menuBuilder.getItem(i8);
            if (item.hasSubMenu() && menuBuilder2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View C(@NonNull CascadingMenuInfo cascadingMenuInfo, @NonNull MenuBuilder menuBuilder) {
        MenuAdapter menuAdapter;
        int i8;
        int firstVisiblePosition;
        MenuItem B = B(cascadingMenuInfo.f1570b, menuBuilder);
        if (B == null) {
            return null;
        }
        ListView a8 = cascadingMenuInfo.a();
        ListAdapter adapter = a8.getAdapter();
        int i9 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i8 = headerViewListAdapter.getHeadersCount();
            menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
        } else {
            menuAdapter = (MenuAdapter) adapter;
            i8 = 0;
        }
        int count = menuAdapter.getCount();
        while (true) {
            if (i9 < count) {
                if (B == menuAdapter.getItem(i9)) {
                    break;
                }
                i9++;
            } else {
                i9 = -1;
                break;
            }
        }
        if (i9 == -1 || (firstVisiblePosition = (i9 + i8) - a8.getFirstVisiblePosition()) < 0 || firstVisiblePosition >= a8.getChildCount()) {
            return null;
        }
        return a8.getChildAt(firstVisiblePosition);
    }

    private int D() {
        if (ViewCompat.E(this.f1555t) != 1) {
            return 1;
        }
        return 0;
    }

    private int E(int i8) {
        List<CascadingMenuInfo> list = this.f1549n;
        ListView a8 = list.get(list.size() - 1).a();
        int[] iArr = new int[2];
        a8.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f1556u.getWindowVisibleDisplayFrame(rect);
        if (this.f1557v == 1) {
            if (iArr[0] + a8.getWidth() + i8 <= rect.right) {
                return 1;
            }
            return 0;
        } else if (iArr[0] - i8 < 0) {
            return 1;
        } else {
            return 0;
        }
    }

    private void F(@NonNull MenuBuilder menuBuilder) {
        CascadingMenuInfo cascadingMenuInfo;
        View view;
        boolean z7;
        int i8;
        int i9;
        int i10;
        LayoutInflater from = LayoutInflater.from(this.f1542g);
        MenuAdapter menuAdapter = new MenuAdapter(menuBuilder, from, this.f1546k, G);
        if (!c() && this.A) {
            menuAdapter.d(true);
        } else if (c()) {
            menuAdapter.d(MenuPopup.x(menuBuilder));
        }
        int n8 = MenuPopup.n(menuAdapter, null, this.f1542g, this.f1543h);
        MenuPopupWindow z8 = z();
        z8.n(menuAdapter);
        z8.F(n8);
        z8.G(this.f1554s);
        if (this.f1549n.size() > 0) {
            List<CascadingMenuInfo> list = this.f1549n;
            cascadingMenuInfo = list.get(list.size() - 1);
            view = C(cascadingMenuInfo, menuBuilder);
        } else {
            cascadingMenuInfo = null;
            view = null;
        }
        if (view != null) {
            z8.V(false);
            z8.S(null);
            int E = E(n8);
            if (E == 1) {
                z7 = true;
            } else {
                z7 = false;
            }
            this.f1557v = E;
            if (Build.VERSION.SDK_INT >= 26) {
                z8.D(view);
                i9 = 0;
                i8 = 0;
            } else {
                int[] iArr = new int[2];
                this.f1555t.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.f1554s & 7) == 5) {
                    iArr[0] = iArr[0] + this.f1555t.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i8 = iArr2[0] - iArr[0];
                i9 = iArr2[1] - iArr[1];
            }
            if ((this.f1554s & 5) == 5) {
                if (!z7) {
                    n8 = view.getWidth();
                    i10 = i8 - n8;
                }
                i10 = i8 + n8;
            } else {
                if (z7) {
                    n8 = view.getWidth();
                    i10 = i8 + n8;
                }
                i10 = i8 - n8;
            }
            z8.f(i10);
            z8.N(true);
            z8.j(i9);
        } else {
            if (this.f1558w) {
                z8.f(this.f1560y);
            }
            if (this.f1559x) {
                z8.j(this.f1561z);
            }
            z8.H(m());
        }
        this.f1549n.add(new CascadingMenuInfo(z8, menuBuilder, this.f1557v));
        z8.b();
        ListView p8 = z8.p();
        p8.setOnKeyListener(this);
        if (cascadingMenuInfo == null && this.B && menuBuilder.x() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(R$layout.f928l, (ViewGroup) p8, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(menuBuilder.x());
            p8.addHeaderView(frameLayout, null, false);
            z8.b();
        }
    }

    private MenuPopupWindow z() {
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow(this.f1542g, null, this.f1544i, this.f1545j);
        menuPopupWindow.U(this.f1552q);
        menuPopupWindow.L(this);
        menuPopupWindow.K(this);
        menuPopupWindow.D(this.f1555t);
        menuPopupWindow.G(this.f1554s);
        menuPopupWindow.J(true);
        menuPopupWindow.I(2);
        return menuPopupWindow;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void a(MenuBuilder menuBuilder, boolean z7) {
        int A = A(menuBuilder);
        if (A < 0) {
            return;
        }
        int i8 = A + 1;
        if (i8 < this.f1549n.size()) {
            this.f1549n.get(i8).f1570b.e(false);
        }
        CascadingMenuInfo remove = this.f1549n.remove(A);
        remove.f1570b.O(this);
        if (this.F) {
            remove.f1569a.T(null);
            remove.f1569a.E(0);
        }
        remove.f1569a.dismiss();
        int size = this.f1549n.size();
        if (size > 0) {
            this.f1557v = this.f1549n.get(size - 1).f1571c;
        } else {
            this.f1557v = D();
        }
        if (size == 0) {
            dismiss();
            MenuPresenter.Callback callback = this.C;
            if (callback != null) {
                callback.a(menuBuilder, true);
            }
            ViewTreeObserver viewTreeObserver = this.D;
            if (viewTreeObserver != null) {
                if (viewTreeObserver.isAlive()) {
                    this.D.removeGlobalOnLayoutListener(this.f1550o);
                }
                this.D = null;
            }
            this.f1556u.removeOnAttachStateChangeListener(this.f1551p);
            this.E.onDismiss();
        } else if (z7) {
            this.f1549n.get(0).f1570b.e(false);
        }
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void b() {
        boolean z7;
        if (c()) {
            return;
        }
        for (MenuBuilder menuBuilder : this.f1548m) {
            F(menuBuilder);
        }
        this.f1548m.clear();
        View view = this.f1555t;
        this.f1556u = view;
        if (view != null) {
            if (this.D == null) {
                z7 = true;
            } else {
                z7 = false;
            }
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.D = viewTreeObserver;
            if (z7) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f1550o);
            }
            this.f1556u.addOnAttachStateChangeListener(this.f1551p);
        }
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean c() {
        if (this.f1549n.size() <= 0 || !this.f1549n.get(0).f1569a.c()) {
            return false;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        int size = this.f1549n.size();
        if (size > 0) {
            CascadingMenuInfo[] cascadingMenuInfoArr = (CascadingMenuInfo[]) this.f1549n.toArray(new CascadingMenuInfo[size]);
            for (int i8 = size - 1; i8 >= 0; i8--) {
                CascadingMenuInfo cascadingMenuInfo = cascadingMenuInfoArr[i8];
                if (cascadingMenuInfo.f1569a.c()) {
                    cascadingMenuInfo.f1569a.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void e(MenuPresenter.Callback callback) {
        this.C = callback;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean f(SubMenuBuilder subMenuBuilder) {
        for (CascadingMenuInfo cascadingMenuInfo : this.f1549n) {
            if (subMenuBuilder == cascadingMenuInfo.f1570b) {
                cascadingMenuInfo.a().requestFocus();
                return true;
            }
        }
        if (subMenuBuilder.hasVisibleItems()) {
            k(subMenuBuilder);
            MenuPresenter.Callback callback = this.C;
            if (callback != null) {
                callback.b(subMenuBuilder);
            }
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void g(boolean z7) {
        for (CascadingMenuInfo cascadingMenuInfo : this.f1549n) {
            MenuPopup.y(cascadingMenuInfo.a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean h() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void k(MenuBuilder menuBuilder) {
        menuBuilder.c(this, this.f1542g);
        if (c()) {
            F(menuBuilder);
        } else {
            this.f1548m.add(menuBuilder);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    protected boolean l() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void o(@NonNull View view) {
        if (this.f1555t != view) {
            this.f1555t = view;
            this.f1554s = GravityCompat.b(this.f1553r, ViewCompat.E(view));
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        CascadingMenuInfo cascadingMenuInfo;
        int size = this.f1549n.size();
        int i8 = 0;
        while (true) {
            if (i8 < size) {
                cascadingMenuInfo = this.f1549n.get(i8);
                if (!cascadingMenuInfo.f1569a.c()) {
                    break;
                }
                i8++;
            } else {
                cascadingMenuInfo = null;
                break;
            }
        }
        if (cascadingMenuInfo != null) {
            cascadingMenuInfo.f1570b.e(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i8, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i8 == 82) {
            dismiss();
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public ListView p() {
        if (this.f1549n.isEmpty()) {
            return null;
        }
        List<CascadingMenuInfo> list = this.f1549n;
        return list.get(list.size() - 1).a();
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void r(boolean z7) {
        this.A = z7;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void s(int i8) {
        if (this.f1553r != i8) {
            this.f1553r = i8;
            this.f1554s = GravityCompat.b(i8, ViewCompat.E(this.f1555t));
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void t(int i8) {
        this.f1558w = true;
        this.f1560y = i8;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.E = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void v(boolean z7) {
        this.B = z7;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void w(int i8) {
        this.f1559x = true;
        this.f1561z = i8;
    }
}
