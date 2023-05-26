package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
final class StandardMenuPopup extends MenuPopup implements PopupWindow.OnDismissListener, View.OnKeyListener {
    private static final int A = R$layout.f929m;

    /* renamed from: g  reason: collision with root package name */
    private final Context f1692g;

    /* renamed from: h  reason: collision with root package name */
    private final MenuBuilder f1693h;

    /* renamed from: i  reason: collision with root package name */
    private final MenuAdapter f1694i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f1695j;

    /* renamed from: k  reason: collision with root package name */
    private final int f1696k;

    /* renamed from: l  reason: collision with root package name */
    private final int f1697l;

    /* renamed from: m  reason: collision with root package name */
    private final int f1698m;

    /* renamed from: n  reason: collision with root package name */
    final MenuPopupWindow f1699n;

    /* renamed from: q  reason: collision with root package name */
    private PopupWindow.OnDismissListener f1702q;

    /* renamed from: r  reason: collision with root package name */
    private View f1703r;

    /* renamed from: s  reason: collision with root package name */
    View f1704s;

    /* renamed from: t  reason: collision with root package name */
    private MenuPresenter.Callback f1705t;

    /* renamed from: u  reason: collision with root package name */
    ViewTreeObserver f1706u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f1707v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f1708w;

    /* renamed from: x  reason: collision with root package name */
    private int f1709x;

    /* renamed from: z  reason: collision with root package name */
    private boolean f1711z;

    /* renamed from: o  reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f1700o = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.view.menu.StandardMenuPopup.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (StandardMenuPopup.this.c() && !StandardMenuPopup.this.f1699n.B()) {
                View view = StandardMenuPopup.this.f1704s;
                if (view != null && view.isShown()) {
                    StandardMenuPopup.this.f1699n.b();
                } else {
                    StandardMenuPopup.this.dismiss();
                }
            }
        }
    };

    /* renamed from: p  reason: collision with root package name */
    private final View.OnAttachStateChangeListener f1701p = new View.OnAttachStateChangeListener() { // from class: androidx.appcompat.view.menu.StandardMenuPopup.2
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = StandardMenuPopup.this.f1706u;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    StandardMenuPopup.this.f1706u = view.getViewTreeObserver();
                }
                StandardMenuPopup standardMenuPopup = StandardMenuPopup.this;
                standardMenuPopup.f1706u.removeGlobalOnLayoutListener(standardMenuPopup.f1700o);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };

    /* renamed from: y  reason: collision with root package name */
    private int f1710y = 0;

    public StandardMenuPopup(Context context, MenuBuilder menuBuilder, View view, int i8, int i9, boolean z7) {
        this.f1692g = context;
        this.f1693h = menuBuilder;
        this.f1695j = z7;
        this.f1694i = new MenuAdapter(menuBuilder, LayoutInflater.from(context), z7, A);
        this.f1697l = i8;
        this.f1698m = i9;
        Resources resources = context.getResources();
        this.f1696k = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.f853d));
        this.f1703r = view;
        this.f1699n = new MenuPopupWindow(context, null, i8, i9);
        menuBuilder.c(this, context);
    }

    private boolean z() {
        View view;
        boolean z7;
        if (c()) {
            return true;
        }
        if (this.f1707v || (view = this.f1703r) == null) {
            return false;
        }
        this.f1704s = view;
        this.f1699n.K(this);
        this.f1699n.L(this);
        this.f1699n.J(true);
        View view2 = this.f1704s;
        if (this.f1706u == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f1706u = viewTreeObserver;
        if (z7) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f1700o);
        }
        view2.addOnAttachStateChangeListener(this.f1701p);
        this.f1699n.D(view2);
        this.f1699n.G(this.f1710y);
        if (!this.f1708w) {
            this.f1709x = MenuPopup.n(this.f1694i, null, this.f1692g, this.f1696k);
            this.f1708w = true;
        }
        this.f1699n.F(this.f1709x);
        this.f1699n.I(2);
        this.f1699n.H(m());
        this.f1699n.b();
        ListView p8 = this.f1699n.p();
        p8.setOnKeyListener(this);
        if (this.f1711z && this.f1693h.x() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f1692g).inflate(R$layout.f928l, (ViewGroup) p8, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.f1693h.x());
            }
            frameLayout.setEnabled(false);
            p8.addHeaderView(frameLayout, null, false);
        }
        this.f1699n.n(this.f1694i);
        this.f1699n.b();
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void a(MenuBuilder menuBuilder, boolean z7) {
        if (menuBuilder != this.f1693h) {
            return;
        }
        dismiss();
        MenuPresenter.Callback callback = this.f1705t;
        if (callback != null) {
            callback.a(menuBuilder, z7);
        }
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void b() {
        if (z()) {
            return;
        }
        throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean c() {
        if (!this.f1707v && this.f1699n.c()) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        if (c()) {
            this.f1699n.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void e(MenuPresenter.Callback callback) {
        this.f1705t = callback;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean f(SubMenuBuilder subMenuBuilder) {
        if (subMenuBuilder.hasVisibleItems()) {
            MenuPopupHelper menuPopupHelper = new MenuPopupHelper(this.f1692g, subMenuBuilder, this.f1704s, this.f1695j, this.f1697l, this.f1698m);
            menuPopupHelper.j(this.f1705t);
            menuPopupHelper.g(MenuPopup.x(subMenuBuilder));
            menuPopupHelper.i(this.f1702q);
            this.f1702q = null;
            this.f1693h.e(false);
            int e8 = this.f1699n.e();
            int m8 = this.f1699n.m();
            if ((Gravity.getAbsoluteGravity(this.f1710y, ViewCompat.E(this.f1703r)) & 7) == 5) {
                e8 += this.f1703r.getWidth();
            }
            if (menuPopupHelper.n(e8, m8)) {
                MenuPresenter.Callback callback = this.f1705t;
                if (callback != null) {
                    callback.b(subMenuBuilder);
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void g(boolean z7) {
        this.f1708w = false;
        MenuAdapter menuAdapter = this.f1694i;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean h() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void k(MenuBuilder menuBuilder) {
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void o(View view) {
        this.f1703r = view;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f1707v = true;
        this.f1693h.close();
        ViewTreeObserver viewTreeObserver = this.f1706u;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f1706u = this.f1704s.getViewTreeObserver();
            }
            this.f1706u.removeGlobalOnLayoutListener(this.f1700o);
            this.f1706u = null;
        }
        this.f1704s.removeOnAttachStateChangeListener(this.f1701p);
        PopupWindow.OnDismissListener onDismissListener = this.f1702q;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
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
        return this.f1699n.p();
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void r(boolean z7) {
        this.f1694i.d(z7);
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void s(int i8) {
        this.f1710y = i8;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void t(int i8) {
        this.f1699n.f(i8);
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.f1702q = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void v(boolean z7) {
        this.f1711z = z7;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void w(int i8) {
        this.f1699n.j(i8);
    }
}
