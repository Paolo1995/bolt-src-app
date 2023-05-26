package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$drawable;
import androidx.appcompat.R$id;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.ActionMenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

/* loaded from: classes.dex */
public class ToolbarWidgetWrapper implements DecorToolbar {

    /* renamed from: a  reason: collision with root package name */
    Toolbar f2243a;

    /* renamed from: b  reason: collision with root package name */
    private int f2244b;

    /* renamed from: c  reason: collision with root package name */
    private View f2245c;

    /* renamed from: d  reason: collision with root package name */
    private View f2246d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f2247e;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f2248f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f2249g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f2250h;

    /* renamed from: i  reason: collision with root package name */
    CharSequence f2251i;

    /* renamed from: j  reason: collision with root package name */
    private CharSequence f2252j;

    /* renamed from: k  reason: collision with root package name */
    private CharSequence f2253k;

    /* renamed from: l  reason: collision with root package name */
    Window.Callback f2254l;

    /* renamed from: m  reason: collision with root package name */
    boolean f2255m;

    /* renamed from: n  reason: collision with root package name */
    private ActionMenuPresenter f2256n;

    /* renamed from: o  reason: collision with root package name */
    private int f2257o;

    /* renamed from: p  reason: collision with root package name */
    private int f2258p;

    /* renamed from: q  reason: collision with root package name */
    private Drawable f2259q;

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z7) {
        this(toolbar, z7, R$string.f937a, R$drawable.f878n);
    }

    private void F(CharSequence charSequence) {
        this.f2251i = charSequence;
        if ((this.f2244b & 8) != 0) {
            this.f2243a.setTitle(charSequence);
            if (this.f2250h) {
                ViewCompat.v0(this.f2243a.getRootView(), charSequence);
            }
        }
    }

    private void G() {
        if ((this.f2244b & 4) != 0) {
            if (TextUtils.isEmpty(this.f2253k)) {
                this.f2243a.setNavigationContentDescription(this.f2258p);
            } else {
                this.f2243a.setNavigationContentDescription(this.f2253k);
            }
        }
    }

    private void H() {
        if ((this.f2244b & 4) != 0) {
            Toolbar toolbar = this.f2243a;
            Drawable drawable = this.f2249g;
            if (drawable == null) {
                drawable = this.f2259q;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.f2243a.setNavigationIcon((Drawable) null);
    }

    private void I() {
        Drawable drawable;
        int i8 = this.f2244b;
        if ((i8 & 2) != 0) {
            if ((i8 & 1) != 0) {
                drawable = this.f2248f;
                if (drawable == null) {
                    drawable = this.f2247e;
                }
            } else {
                drawable = this.f2247e;
            }
        } else {
            drawable = null;
        }
        this.f2243a.setLogo(drawable);
    }

    private int x() {
        if (this.f2243a.getNavigationIcon() != null) {
            this.f2259q = this.f2243a.getNavigationIcon();
            return 15;
        }
        return 11;
    }

    public void A(Drawable drawable) {
        this.f2248f = drawable;
        I();
    }

    public void B(int i8) {
        String string;
        if (i8 == 0) {
            string = null;
        } else {
            string = getContext().getString(i8);
        }
        C(string);
    }

    public void C(CharSequence charSequence) {
        this.f2253k = charSequence;
        G();
    }

    public void D(Drawable drawable) {
        this.f2249g = drawable;
        H();
    }

    public void E(CharSequence charSequence) {
        this.f2252j = charSequence;
        if ((this.f2244b & 8) != 0) {
            this.f2243a.setSubtitle(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean a() {
        return this.f2243a.d();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean b() {
        return this.f2243a.w();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean c() {
        return this.f2243a.Q();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void collapseActionView() {
        this.f2243a.e();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void d(Menu menu, MenuPresenter.Callback callback) {
        if (this.f2256n == null) {
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.f2243a.getContext());
            this.f2256n = actionMenuPresenter;
            actionMenuPresenter.p(R$id.f897g);
        }
        this.f2256n.e(callback);
        this.f2243a.K((MenuBuilder) menu, this.f2256n);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean e() {
        return this.f2243a.B();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void f() {
        this.f2255m = true;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean g() {
        return this.f2243a.A();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public Context getContext() {
        return this.f2243a.getContext();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public CharSequence getTitle() {
        return this.f2243a.getTitle();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean h() {
        return this.f2243a.v();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void i(int i8) {
        View view;
        int i9 = this.f2244b ^ i8;
        this.f2244b = i8;
        if (i9 != 0) {
            if ((i9 & 4) != 0) {
                if ((i8 & 4) != 0) {
                    G();
                }
                H();
            }
            if ((i9 & 3) != 0) {
                I();
            }
            if ((i9 & 8) != 0) {
                if ((i8 & 8) != 0) {
                    this.f2243a.setTitle(this.f2251i);
                    this.f2243a.setSubtitle(this.f2252j);
                } else {
                    this.f2243a.setTitle((CharSequence) null);
                    this.f2243a.setSubtitle((CharSequence) null);
                }
            }
            if ((i9 & 16) != 0 && (view = this.f2246d) != null) {
                if ((i8 & 16) != 0) {
                    this.f2243a.addView(view);
                } else {
                    this.f2243a.removeView(view);
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public Menu j() {
        return this.f2243a.getMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int k() {
        return this.f2257o;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public ViewPropertyAnimatorCompat l(final int i8, long j8) {
        float f8;
        ViewPropertyAnimatorCompat e8 = ViewCompat.e(this.f2243a);
        if (i8 == 0) {
            f8 = 1.0f;
        } else {
            f8 = 0.0f;
        }
        return e8.b(f8).f(j8).h(new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.widget.ToolbarWidgetWrapper.2

            /* renamed from: a  reason: collision with root package name */
            private boolean f2262a = false;

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void a(View view) {
                this.f2262a = true;
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void b(View view) {
                if (!this.f2262a) {
                    ToolbarWidgetWrapper.this.f2243a.setVisibility(i8);
                }
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void c(View view) {
                ToolbarWidgetWrapper.this.f2243a.setVisibility(0);
            }
        });
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public ViewGroup m() {
        return this.f2243a;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void n(boolean z7) {
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void o() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void p(boolean z7) {
        this.f2243a.setCollapsible(z7);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void q() {
        this.f2243a.f();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void r(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.f2245c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f2243a;
            if (parent == toolbar) {
                toolbar.removeView(this.f2245c);
            }
        }
        this.f2245c = scrollingTabContainerView;
        if (scrollingTabContainerView != null && this.f2257o == 2) {
            this.f2243a.addView(scrollingTabContainerView, 0);
            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f2245c.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams).width = -2;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = -2;
            layoutParams.f1086a = 8388691;
            scrollingTabContainerView.setAllowCollapse(true);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void s(int i8) {
        Drawable drawable;
        if (i8 != 0) {
            drawable = AppCompatResources.b(getContext(), i8);
        } else {
            drawable = null;
        }
        A(drawable);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setIcon(int i8) {
        setIcon(i8 != 0 ? AppCompatResources.b(getContext(), i8) : null);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setTitle(CharSequence charSequence) {
        this.f2250h = true;
        F(charSequence);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setWindowCallback(Window.Callback callback) {
        this.f2254l = callback;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setWindowTitle(CharSequence charSequence) {
        if (!this.f2250h) {
            F(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void t(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.f2243a.L(callback, callback2);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void u(int i8) {
        this.f2243a.setVisibility(i8);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int v() {
        return this.f2244b;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void w() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void y(View view) {
        View view2 = this.f2246d;
        if (view2 != null && (this.f2244b & 16) != 0) {
            this.f2243a.removeView(view2);
        }
        this.f2246d = view;
        if (view != null && (this.f2244b & 16) != 0) {
            this.f2243a.addView(view);
        }
    }

    public void z(int i8) {
        if (i8 == this.f2258p) {
            return;
        }
        this.f2258p = i8;
        if (TextUtils.isEmpty(this.f2243a.getNavigationContentDescription())) {
            B(this.f2258p);
        }
    }

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z7, int i8, int i9) {
        Drawable drawable;
        this.f2257o = 0;
        this.f2258p = 0;
        this.f2243a = toolbar;
        this.f2251i = toolbar.getTitle();
        this.f2252j = toolbar.getSubtitle();
        this.f2250h = this.f2251i != null;
        this.f2249g = toolbar.getNavigationIcon();
        TintTypedArray v7 = TintTypedArray.v(toolbar.getContext(), null, R$styleable.f956a, R$attr.f817c, 0);
        this.f2259q = v7.g(R$styleable.f1011l);
        if (z7) {
            CharSequence p8 = v7.p(R$styleable.f1041r);
            if (!TextUtils.isEmpty(p8)) {
                setTitle(p8);
            }
            CharSequence p9 = v7.p(R$styleable.f1031p);
            if (!TextUtils.isEmpty(p9)) {
                E(p9);
            }
            Drawable g8 = v7.g(R$styleable.f1021n);
            if (g8 != null) {
                A(g8);
            }
            Drawable g9 = v7.g(R$styleable.f1016m);
            if (g9 != null) {
                setIcon(g9);
            }
            if (this.f2249g == null && (drawable = this.f2259q) != null) {
                D(drawable);
            }
            i(v7.k(R$styleable.f991h, 0));
            int n8 = v7.n(R$styleable.f986g, 0);
            if (n8 != 0) {
                y(LayoutInflater.from(this.f2243a.getContext()).inflate(n8, (ViewGroup) this.f2243a, false));
                i(this.f2244b | 16);
            }
            int m8 = v7.m(R$styleable.f1001j, 0);
            if (m8 > 0) {
                ViewGroup.LayoutParams layoutParams = this.f2243a.getLayoutParams();
                layoutParams.height = m8;
                this.f2243a.setLayoutParams(layoutParams);
            }
            int e8 = v7.e(R$styleable.f981f, -1);
            int e9 = v7.e(R$styleable.f976e, -1);
            if (e8 >= 0 || e9 >= 0) {
                this.f2243a.J(Math.max(e8, 0), Math.max(e9, 0));
            }
            int n9 = v7.n(R$styleable.f1046s, 0);
            if (n9 != 0) {
                Toolbar toolbar2 = this.f2243a;
                toolbar2.N(toolbar2.getContext(), n9);
            }
            int n10 = v7.n(R$styleable.f1036q, 0);
            if (n10 != 0) {
                Toolbar toolbar3 = this.f2243a;
                toolbar3.M(toolbar3.getContext(), n10);
            }
            int n11 = v7.n(R$styleable.f1026o, 0);
            if (n11 != 0) {
                this.f2243a.setPopupTheme(n11);
            }
        } else {
            this.f2244b = x();
        }
        v7.w();
        z(i8);
        this.f2253k = this.f2243a.getNavigationContentDescription();
        this.f2243a.setNavigationOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.ToolbarWidgetWrapper.1

            /* renamed from: f  reason: collision with root package name */
            final ActionMenuItem f2260f;

            {
                this.f2260f = new ActionMenuItem(ToolbarWidgetWrapper.this.f2243a.getContext(), 0, 16908332, 0, 0, ToolbarWidgetWrapper.this.f2251i);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ToolbarWidgetWrapper toolbarWidgetWrapper = ToolbarWidgetWrapper.this;
                Window.Callback callback = toolbarWidgetWrapper.f2254l;
                if (callback != null && toolbarWidgetWrapper.f2255m) {
                    callback.onMenuItemSelected(0, this.f2260f);
                }
            }
        });
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setIcon(Drawable drawable) {
        this.f2247e = drawable;
        I();
    }
}
