package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ToolbarActionBar extends ActionBar {

    /* renamed from: a  reason: collision with root package name */
    final DecorToolbar f1277a;

    /* renamed from: b  reason: collision with root package name */
    final Window.Callback f1278b;

    /* renamed from: c  reason: collision with root package name */
    final AppCompatDelegateImpl.ActionBarMenuCallback f1279c;

    /* renamed from: d  reason: collision with root package name */
    boolean f1280d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1281e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1282f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<ActionBar.OnMenuVisibilityListener> f1283g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private final Runnable f1284h = new Runnable() { // from class: androidx.appcompat.app.ToolbarActionBar.1
        @Override // java.lang.Runnable
        public void run() {
            ToolbarActionBar.this.A();
        }
    };

    /* renamed from: i  reason: collision with root package name */
    private final Toolbar.OnMenuItemClickListener f1285i;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class ActionMenuPresenterCallback implements MenuPresenter.Callback {

        /* renamed from: f  reason: collision with root package name */
        private boolean f1288f;

        ActionMenuPresenterCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void a(@NonNull MenuBuilder menuBuilder, boolean z7) {
            if (this.f1288f) {
                return;
            }
            this.f1288f = true;
            ToolbarActionBar.this.f1277a.q();
            ToolbarActionBar.this.f1278b.onPanelClosed(108, menuBuilder);
            this.f1288f = false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean b(@NonNull MenuBuilder menuBuilder) {
            ToolbarActionBar.this.f1278b.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class MenuBuilderCallback implements MenuBuilder.Callback {
        MenuBuilderCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean a(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void b(@NonNull MenuBuilder menuBuilder) {
            if (ToolbarActionBar.this.f1277a.e()) {
                ToolbarActionBar.this.f1278b.onPanelClosed(108, menuBuilder);
            } else if (ToolbarActionBar.this.f1278b.onPreparePanel(0, null, menuBuilder)) {
                ToolbarActionBar.this.f1278b.onMenuOpened(108, menuBuilder);
            }
        }
    }

    /* loaded from: classes.dex */
    private class ToolbarMenuCallback implements AppCompatDelegateImpl.ActionBarMenuCallback {
        ToolbarMenuCallback() {
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.ActionBarMenuCallback
        public boolean a(int i8) {
            if (i8 == 0) {
                ToolbarActionBar toolbarActionBar = ToolbarActionBar.this;
                if (!toolbarActionBar.f1280d) {
                    toolbarActionBar.f1277a.f();
                    ToolbarActionBar.this.f1280d = true;
                    return false;
                }
                return false;
            }
            return false;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.ActionBarMenuCallback
        public View onCreatePanelView(int i8) {
            if (i8 == 0) {
                return new View(ToolbarActionBar.this.f1277a.getContext());
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ToolbarActionBar(@NonNull Toolbar toolbar, CharSequence charSequence, @NonNull Window.Callback callback) {
        Toolbar.OnMenuItemClickListener onMenuItemClickListener = new Toolbar.OnMenuItemClickListener() { // from class: androidx.appcompat.app.ToolbarActionBar.2
            @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                return ToolbarActionBar.this.f1278b.onMenuItemSelected(0, menuItem);
            }
        };
        this.f1285i = onMenuItemClickListener;
        Preconditions.g(toolbar);
        ToolbarWidgetWrapper toolbarWidgetWrapper = new ToolbarWidgetWrapper(toolbar, false);
        this.f1277a = toolbarWidgetWrapper;
        this.f1278b = (Window.Callback) Preconditions.g(callback);
        toolbarWidgetWrapper.setWindowCallback(callback);
        toolbar.setOnMenuItemClickListener(onMenuItemClickListener);
        toolbarWidgetWrapper.setWindowTitle(charSequence);
        this.f1279c = new ToolbarMenuCallback();
    }

    private Menu z() {
        if (!this.f1281e) {
            this.f1277a.t(new ActionMenuPresenterCallback(), new MenuBuilderCallback());
            this.f1281e = true;
        }
        return this.f1277a.j();
    }

    void A() {
        MenuBuilder menuBuilder;
        Menu z7 = z();
        if (z7 instanceof MenuBuilder) {
            menuBuilder = (MenuBuilder) z7;
        } else {
            menuBuilder = null;
        }
        if (menuBuilder != null) {
            menuBuilder.d0();
        }
        try {
            z7.clear();
            if (!this.f1278b.onCreatePanelMenu(0, z7) || !this.f1278b.onPreparePanel(0, null, z7)) {
                z7.clear();
            }
        } finally {
            if (menuBuilder != null) {
                menuBuilder.c0();
            }
        }
    }

    public void B(int i8, int i9) {
        this.f1277a.i((i8 & i9) | ((~i9) & this.f1277a.v()));
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean g() {
        return this.f1277a.b();
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean h() {
        if (this.f1277a.h()) {
            this.f1277a.collapseActionView();
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void i(boolean z7) {
        if (z7 == this.f1282f) {
            return;
        }
        this.f1282f = z7;
        int size = this.f1283g.size();
        for (int i8 = 0; i8 < size; i8++) {
            this.f1283g.get(i8).onMenuVisibilityChanged(z7);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public int j() {
        return this.f1277a.v();
    }

    @Override // androidx.appcompat.app.ActionBar
    public Context k() {
        return this.f1277a.getContext();
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean l() {
        this.f1277a.m().removeCallbacks(this.f1284h);
        ViewCompat.k0(this.f1277a.m(), this.f1284h);
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void m(Configuration configuration) {
        super.m(configuration);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.app.ActionBar
    public void n() {
        this.f1277a.m().removeCallbacks(this.f1284h);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean o(int i8, KeyEvent keyEvent) {
        int i9;
        Menu z7 = z();
        if (z7 == null) {
            return false;
        }
        if (keyEvent != null) {
            i9 = keyEvent.getDeviceId();
        } else {
            i9 = -1;
        }
        boolean z8 = true;
        if (KeyCharacterMap.load(i9).getKeyboardType() == 1) {
            z8 = false;
        }
        z7.setQwertyMode(z8);
        return z7.performShortcut(i8, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean p(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            q();
        }
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean q() {
        return this.f1277a.c();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void r(boolean z7) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public void s(boolean z7) {
        int i8;
        if (z7) {
            i8 = 4;
        } else {
            i8 = 0;
        }
        B(i8, 4);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void t(boolean z7) {
        int i8;
        if (z7) {
            i8 = 8;
        } else {
            i8 = 0;
        }
        B(i8, 8);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void u(boolean z7) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public void v(int i8) {
        CharSequence charSequence;
        DecorToolbar decorToolbar = this.f1277a;
        if (i8 != 0) {
            charSequence = decorToolbar.getContext().getText(i8);
        } else {
            charSequence = null;
        }
        decorToolbar.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void w(CharSequence charSequence) {
        this.f1277a.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void x(CharSequence charSequence) {
        this.f1277a.setWindowTitle(charSequence);
    }
}
