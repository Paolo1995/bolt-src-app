package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class WindowDecorActionBar extends ActionBar implements ActionBarOverlayLayout.ActionBarVisibilityCallback {
    private static final Interpolator E = new AccelerateInterpolator();
    private static final Interpolator F = new DecelerateInterpolator();
    boolean A;

    /* renamed from: a  reason: collision with root package name */
    Context f1302a;

    /* renamed from: b  reason: collision with root package name */
    private Context f1303b;

    /* renamed from: c  reason: collision with root package name */
    private Activity f1304c;

    /* renamed from: d  reason: collision with root package name */
    ActionBarOverlayLayout f1305d;

    /* renamed from: e  reason: collision with root package name */
    ActionBarContainer f1306e;

    /* renamed from: f  reason: collision with root package name */
    DecorToolbar f1307f;

    /* renamed from: g  reason: collision with root package name */
    ActionBarContextView f1308g;

    /* renamed from: h  reason: collision with root package name */
    View f1309h;

    /* renamed from: i  reason: collision with root package name */
    ScrollingTabContainerView f1310i;

    /* renamed from: l  reason: collision with root package name */
    private boolean f1313l;

    /* renamed from: m  reason: collision with root package name */
    ActionModeImpl f1314m;

    /* renamed from: n  reason: collision with root package name */
    ActionMode f1315n;

    /* renamed from: o  reason: collision with root package name */
    ActionMode.Callback f1316o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f1317p;

    /* renamed from: r  reason: collision with root package name */
    private boolean f1319r;

    /* renamed from: u  reason: collision with root package name */
    boolean f1322u;

    /* renamed from: v  reason: collision with root package name */
    boolean f1323v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f1324w;

    /* renamed from: y  reason: collision with root package name */
    ViewPropertyAnimatorCompatSet f1326y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f1327z;

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<Object> f1311j = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    private int f1312k = -1;

    /* renamed from: q  reason: collision with root package name */
    private ArrayList<ActionBar.OnMenuVisibilityListener> f1318q = new ArrayList<>();

    /* renamed from: s  reason: collision with root package name */
    private int f1320s = 0;

    /* renamed from: t  reason: collision with root package name */
    boolean f1321t = true;

    /* renamed from: x  reason: collision with root package name */
    private boolean f1325x = true;
    final ViewPropertyAnimatorListener B = new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.app.WindowDecorActionBar.1
        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void b(View view) {
            View view2;
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.f1321t && (view2 = windowDecorActionBar.f1309h) != null) {
                view2.setTranslationY(0.0f);
                WindowDecorActionBar.this.f1306e.setTranslationY(0.0f);
            }
            WindowDecorActionBar.this.f1306e.setVisibility(8);
            WindowDecorActionBar.this.f1306e.setTransitioning(false);
            WindowDecorActionBar windowDecorActionBar2 = WindowDecorActionBar.this;
            windowDecorActionBar2.f1326y = null;
            windowDecorActionBar2.B();
            ActionBarOverlayLayout actionBarOverlayLayout = WindowDecorActionBar.this.f1305d;
            if (actionBarOverlayLayout != null) {
                ViewCompat.p0(actionBarOverlayLayout);
            }
        }
    };
    final ViewPropertyAnimatorListener C = new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.app.WindowDecorActionBar.2
        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void b(View view) {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            windowDecorActionBar.f1326y = null;
            windowDecorActionBar.f1306e.requestLayout();
        }
    };
    final ViewPropertyAnimatorUpdateListener D = new ViewPropertyAnimatorUpdateListener() { // from class: androidx.appcompat.app.WindowDecorActionBar.3
        @Override // androidx.core.view.ViewPropertyAnimatorUpdateListener
        public void a(View view) {
            ((View) WindowDecorActionBar.this.f1306e.getParent()).invalidate();
        }
    };

    /* loaded from: classes.dex */
    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {

        /* renamed from: h  reason: collision with root package name */
        private final Context f1331h;

        /* renamed from: i  reason: collision with root package name */
        private final MenuBuilder f1332i;

        /* renamed from: j  reason: collision with root package name */
        private ActionMode.Callback f1333j;

        /* renamed from: k  reason: collision with root package name */
        private WeakReference<View> f1334k;

        public ActionModeImpl(Context context, ActionMode.Callback callback) {
            this.f1331h = context;
            this.f1333j = callback;
            MenuBuilder S = new MenuBuilder(context).S(1);
            this.f1332i = S;
            S.R(this);
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean a(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            ActionMode.Callback callback = this.f1333j;
            if (callback != null) {
                return callback.c(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void b(@NonNull MenuBuilder menuBuilder) {
            if (this.f1333j == null) {
                return;
            }
            k();
            WindowDecorActionBar.this.f1308g.l();
        }

        @Override // androidx.appcompat.view.ActionMode
        public void c() {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.f1314m != this) {
                return;
            }
            if (!WindowDecorActionBar.A(windowDecorActionBar.f1322u, windowDecorActionBar.f1323v, false)) {
                WindowDecorActionBar windowDecorActionBar2 = WindowDecorActionBar.this;
                windowDecorActionBar2.f1315n = this;
                windowDecorActionBar2.f1316o = this.f1333j;
            } else {
                this.f1333j.a(this);
            }
            this.f1333j = null;
            WindowDecorActionBar.this.z(false);
            WindowDecorActionBar.this.f1308g.g();
            WindowDecorActionBar windowDecorActionBar3 = WindowDecorActionBar.this;
            windowDecorActionBar3.f1305d.setHideOnContentScrollEnabled(windowDecorActionBar3.A);
            WindowDecorActionBar.this.f1314m = null;
        }

        @Override // androidx.appcompat.view.ActionMode
        public View d() {
            WeakReference<View> weakReference = this.f1334k;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // androidx.appcompat.view.ActionMode
        public Menu e() {
            return this.f1332i;
        }

        @Override // androidx.appcompat.view.ActionMode
        public MenuInflater f() {
            return new SupportMenuInflater(this.f1331h);
        }

        @Override // androidx.appcompat.view.ActionMode
        public CharSequence g() {
            return WindowDecorActionBar.this.f1308g.getSubtitle();
        }

        @Override // androidx.appcompat.view.ActionMode
        public CharSequence i() {
            return WindowDecorActionBar.this.f1308g.getTitle();
        }

        @Override // androidx.appcompat.view.ActionMode
        public void k() {
            if (WindowDecorActionBar.this.f1314m != this) {
                return;
            }
            this.f1332i.d0();
            try {
                this.f1333j.d(this, this.f1332i);
            } finally {
                this.f1332i.c0();
            }
        }

        @Override // androidx.appcompat.view.ActionMode
        public boolean l() {
            return WindowDecorActionBar.this.f1308g.j();
        }

        @Override // androidx.appcompat.view.ActionMode
        public void m(View view) {
            WindowDecorActionBar.this.f1308g.setCustomView(view);
            this.f1334k = new WeakReference<>(view);
        }

        @Override // androidx.appcompat.view.ActionMode
        public void n(int i8) {
            o(WindowDecorActionBar.this.f1302a.getResources().getString(i8));
        }

        @Override // androidx.appcompat.view.ActionMode
        public void o(CharSequence charSequence) {
            WindowDecorActionBar.this.f1308g.setSubtitle(charSequence);
        }

        @Override // androidx.appcompat.view.ActionMode
        public void q(int i8) {
            r(WindowDecorActionBar.this.f1302a.getResources().getString(i8));
        }

        @Override // androidx.appcompat.view.ActionMode
        public void r(CharSequence charSequence) {
            WindowDecorActionBar.this.f1308g.setTitle(charSequence);
        }

        @Override // androidx.appcompat.view.ActionMode
        public void s(boolean z7) {
            super.s(z7);
            WindowDecorActionBar.this.f1308g.setTitleOptional(z7);
        }

        public boolean t() {
            this.f1332i.d0();
            try {
                return this.f1333j.b(this, this.f1332i);
            } finally {
                this.f1332i.c0();
            }
        }
    }

    public WindowDecorActionBar(Activity activity, boolean z7) {
        this.f1304c = activity;
        View decorView = activity.getWindow().getDecorView();
        H(decorView);
        if (z7) {
            return;
        }
        this.f1309h = decorView.findViewById(16908290);
    }

    static boolean A(boolean z7, boolean z8, boolean z9) {
        if (z9) {
            return true;
        }
        return (z7 || z8) ? false : true;
    }

    private DecorToolbar E(View view) {
        String str;
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        if (view != null) {
            str = view.getClass().getSimpleName();
        } else {
            str = "null";
        }
        sb.append(str);
        throw new IllegalStateException(sb.toString());
    }

    private void G() {
        if (this.f1324w) {
            this.f1324w = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f1305d;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            P(false);
        }
    }

    private void H(View view) {
        boolean z7;
        boolean z8;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(R$id.f906p);
        this.f1305d = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f1307f = E(view.findViewById(R$id.f891a));
        this.f1308g = (ActionBarContextView) view.findViewById(R$id.f896f);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(R$id.f893c);
        this.f1306e = actionBarContainer;
        DecorToolbar decorToolbar = this.f1307f;
        if (decorToolbar != null && this.f1308g != null && actionBarContainer != null) {
            this.f1302a = decorToolbar.getContext();
            if ((this.f1307f.v() & 4) != 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                this.f1313l = true;
            }
            ActionBarPolicy b8 = ActionBarPolicy.b(this.f1302a);
            if (!b8.a() && !z7) {
                z8 = false;
            } else {
                z8 = true;
            }
            M(z8);
            K(b8.g());
            TypedArray obtainStyledAttributes = this.f1302a.obtainStyledAttributes(null, R$styleable.f956a, R$attr.f817c, 0);
            if (obtainStyledAttributes.getBoolean(R$styleable.f1006k, false)) {
                L(true);
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f996i, 0);
            if (dimensionPixelSize != 0) {
                J(dimensionPixelSize);
            }
            obtainStyledAttributes.recycle();
            return;
        }
        throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
    }

    private void K(boolean z7) {
        boolean z8;
        boolean z9;
        this.f1319r = z7;
        if (!z7) {
            this.f1307f.r(null);
            this.f1306e.setTabContainer(this.f1310i);
        } else {
            this.f1306e.setTabContainer(null);
            this.f1307f.r(this.f1310i);
        }
        boolean z10 = true;
        if (F() == 2) {
            z8 = true;
        } else {
            z8 = false;
        }
        ScrollingTabContainerView scrollingTabContainerView = this.f1310i;
        if (scrollingTabContainerView != null) {
            if (z8) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f1305d;
                if (actionBarOverlayLayout != null) {
                    ViewCompat.p0(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
        }
        DecorToolbar decorToolbar = this.f1307f;
        if (!this.f1319r && z8) {
            z9 = true;
        } else {
            z9 = false;
        }
        decorToolbar.p(z9);
        this.f1305d.setHasNonEmbeddedTabs((this.f1319r || !z8) ? false : false);
    }

    private boolean N() {
        return ViewCompat.W(this.f1306e);
    }

    private void O() {
        if (!this.f1324w) {
            this.f1324w = true;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f1305d;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(true);
            }
            P(false);
        }
    }

    private void P(boolean z7) {
        if (A(this.f1322u, this.f1323v, this.f1324w)) {
            if (!this.f1325x) {
                this.f1325x = true;
                D(z7);
            }
        } else if (this.f1325x) {
            this.f1325x = false;
            C(z7);
        }
    }

    void B() {
        ActionMode.Callback callback = this.f1316o;
        if (callback != null) {
            callback.a(this.f1315n);
            this.f1315n = null;
            this.f1316o = null;
        }
    }

    public void C(boolean z7) {
        View view;
        int[] iArr;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.f1326y;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.a();
        }
        if (this.f1320s == 0 && (this.f1327z || z7)) {
            this.f1306e.setAlpha(1.0f);
            this.f1306e.setTransitioning(true);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
            float f8 = -this.f1306e.getHeight();
            if (z7) {
                this.f1306e.getLocationInWindow(new int[]{0, 0});
                f8 -= iArr[1];
            }
            ViewPropertyAnimatorCompat m8 = ViewCompat.e(this.f1306e).m(f8);
            m8.k(this.D);
            viewPropertyAnimatorCompatSet2.c(m8);
            if (this.f1321t && (view = this.f1309h) != null) {
                viewPropertyAnimatorCompatSet2.c(ViewCompat.e(view).m(f8));
            }
            viewPropertyAnimatorCompatSet2.f(E);
            viewPropertyAnimatorCompatSet2.e(250L);
            viewPropertyAnimatorCompatSet2.g(this.B);
            this.f1326y = viewPropertyAnimatorCompatSet2;
            viewPropertyAnimatorCompatSet2.h();
            return;
        }
        this.B.b(null);
    }

    public void D(boolean z7) {
        View view;
        View view2;
        int[] iArr;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.f1326y;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.a();
        }
        this.f1306e.setVisibility(0);
        if (this.f1320s == 0 && (this.f1327z || z7)) {
            this.f1306e.setTranslationY(0.0f);
            float f8 = -this.f1306e.getHeight();
            if (z7) {
                this.f1306e.getLocationInWindow(new int[]{0, 0});
                f8 -= iArr[1];
            }
            this.f1306e.setTranslationY(f8);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
            ViewPropertyAnimatorCompat m8 = ViewCompat.e(this.f1306e).m(0.0f);
            m8.k(this.D);
            viewPropertyAnimatorCompatSet2.c(m8);
            if (this.f1321t && (view2 = this.f1309h) != null) {
                view2.setTranslationY(f8);
                viewPropertyAnimatorCompatSet2.c(ViewCompat.e(this.f1309h).m(0.0f));
            }
            viewPropertyAnimatorCompatSet2.f(F);
            viewPropertyAnimatorCompatSet2.e(250L);
            viewPropertyAnimatorCompatSet2.g(this.C);
            this.f1326y = viewPropertyAnimatorCompatSet2;
            viewPropertyAnimatorCompatSet2.h();
        } else {
            this.f1306e.setAlpha(1.0f);
            this.f1306e.setTranslationY(0.0f);
            if (this.f1321t && (view = this.f1309h) != null) {
                view.setTranslationY(0.0f);
            }
            this.C.b(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f1305d;
        if (actionBarOverlayLayout != null) {
            ViewCompat.p0(actionBarOverlayLayout);
        }
    }

    public int F() {
        return this.f1307f.k();
    }

    public void I(int i8, int i9) {
        int v7 = this.f1307f.v();
        if ((i9 & 4) != 0) {
            this.f1313l = true;
        }
        this.f1307f.i((i8 & i9) | ((~i9) & v7));
    }

    public void J(float f8) {
        ViewCompat.A0(this.f1306e, f8);
    }

    public void L(boolean z7) {
        if (z7 && !this.f1305d.w()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.A = z7;
        this.f1305d.setHideOnContentScrollEnabled(z7);
    }

    public void M(boolean z7) {
        this.f1307f.n(z7);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void a() {
        if (this.f1323v) {
            this.f1323v = false;
            P(true);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void b(int i8) {
        this.f1320s = i8;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void c() {
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void d(boolean z7) {
        this.f1321t = z7;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void e() {
        if (!this.f1323v) {
            this.f1323v = true;
            P(true);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void f() {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.f1326y;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.a();
            this.f1326y = null;
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean h() {
        DecorToolbar decorToolbar = this.f1307f;
        if (decorToolbar != null && decorToolbar.h()) {
            this.f1307f.collapseActionView();
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void i(boolean z7) {
        if (z7 == this.f1317p) {
            return;
        }
        this.f1317p = z7;
        int size = this.f1318q.size();
        for (int i8 = 0; i8 < size; i8++) {
            this.f1318q.get(i8).onMenuVisibilityChanged(z7);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public int j() {
        return this.f1307f.v();
    }

    @Override // androidx.appcompat.app.ActionBar
    public Context k() {
        if (this.f1303b == null) {
            TypedValue typedValue = new TypedValue();
            this.f1302a.getTheme().resolveAttribute(R$attr.f821g, typedValue, true);
            int i8 = typedValue.resourceId;
            if (i8 != 0) {
                this.f1303b = new ContextThemeWrapper(this.f1302a, i8);
            } else {
                this.f1303b = this.f1302a;
            }
        }
        return this.f1303b;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void m(Configuration configuration) {
        K(ActionBarPolicy.b(this.f1302a).g());
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean o(int i8, KeyEvent keyEvent) {
        Menu e8;
        int i9;
        ActionModeImpl actionModeImpl = this.f1314m;
        if (actionModeImpl == null || (e8 = actionModeImpl.e()) == null) {
            return false;
        }
        if (keyEvent != null) {
            i9 = keyEvent.getDeviceId();
        } else {
            i9 = -1;
        }
        boolean z7 = true;
        if (KeyCharacterMap.load(i9).getKeyboardType() == 1) {
            z7 = false;
        }
        e8.setQwertyMode(z7);
        return e8.performShortcut(i8, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void r(boolean z7) {
        if (!this.f1313l) {
            s(z7);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void s(boolean z7) {
        int i8;
        if (z7) {
            i8 = 4;
        } else {
            i8 = 0;
        }
        I(i8, 4);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void t(boolean z7) {
        int i8;
        if (z7) {
            i8 = 8;
        } else {
            i8 = 0;
        }
        I(i8, 8);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void u(boolean z7) {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet;
        this.f1327z = z7;
        if (!z7 && (viewPropertyAnimatorCompatSet = this.f1326y) != null) {
            viewPropertyAnimatorCompatSet.a();
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void v(int i8) {
        w(this.f1302a.getString(i8));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void w(CharSequence charSequence) {
        this.f1307f.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void x(CharSequence charSequence) {
        this.f1307f.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionMode y(ActionMode.Callback callback) {
        ActionModeImpl actionModeImpl = this.f1314m;
        if (actionModeImpl != null) {
            actionModeImpl.c();
        }
        this.f1305d.setHideOnContentScrollEnabled(false);
        this.f1308g.k();
        ActionModeImpl actionModeImpl2 = new ActionModeImpl(this.f1308g.getContext(), callback);
        if (actionModeImpl2.t()) {
            this.f1314m = actionModeImpl2;
            actionModeImpl2.k();
            this.f1308g.h(actionModeImpl2);
            z(true);
            return actionModeImpl2;
        }
        return null;
    }

    public void z(boolean z7) {
        ViewPropertyAnimatorCompat l8;
        ViewPropertyAnimatorCompat f8;
        if (z7) {
            O();
        } else {
            G();
        }
        if (N()) {
            if (z7) {
                f8 = this.f1307f.l(4, 100L);
                l8 = this.f1308g.f(0, 200L);
            } else {
                l8 = this.f1307f.l(0, 200L);
                f8 = this.f1308g.f(8, 100L);
            }
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            viewPropertyAnimatorCompatSet.d(f8, l8);
            viewPropertyAnimatorCompatSet.h();
        } else if (z7) {
            this.f1307f.u(4);
            this.f1308g.setVisibility(0);
        } else {
            this.f1307f.u(0);
            this.f1308g.setVisibility(8);
        }
    }

    public WindowDecorActionBar(Dialog dialog) {
        H(dialog.getWindow().getDecorView());
    }
}
