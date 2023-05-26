package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.view.menu.MenuWrapperICS;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenu;
import androidx.core.internal.view.SupportMenuItem;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SupportActionModeWrapper extends android.view.ActionMode {

    /* renamed from: a  reason: collision with root package name */
    final Context f1446a;

    /* renamed from: b  reason: collision with root package name */
    final ActionMode f1447b;

    /* loaded from: classes.dex */
    public static class CallbackWrapper implements ActionMode.Callback {

        /* renamed from: a  reason: collision with root package name */
        final ActionMode.Callback f1448a;

        /* renamed from: b  reason: collision with root package name */
        final Context f1449b;

        /* renamed from: c  reason: collision with root package name */
        final ArrayList<SupportActionModeWrapper> f1450c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        final SimpleArrayMap<Menu, Menu> f1451d = new SimpleArrayMap<>();

        public CallbackWrapper(Context context, ActionMode.Callback callback) {
            this.f1449b = context;
            this.f1448a = callback;
        }

        private Menu f(Menu menu) {
            Menu menu2 = this.f1451d.get(menu);
            if (menu2 == null) {
                MenuWrapperICS menuWrapperICS = new MenuWrapperICS(this.f1449b, (SupportMenu) menu);
                this.f1451d.put(menu, menuWrapperICS);
                return menuWrapperICS;
            }
            return menu2;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public void a(ActionMode actionMode) {
            this.f1448a.onDestroyActionMode(e(actionMode));
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean b(ActionMode actionMode, Menu menu) {
            return this.f1448a.onCreateActionMode(e(actionMode), f(menu));
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean c(ActionMode actionMode, MenuItem menuItem) {
            return this.f1448a.onActionItemClicked(e(actionMode), new MenuItemWrapperICS(this.f1449b, (SupportMenuItem) menuItem));
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean d(ActionMode actionMode, Menu menu) {
            return this.f1448a.onPrepareActionMode(e(actionMode), f(menu));
        }

        public android.view.ActionMode e(ActionMode actionMode) {
            int size = this.f1450c.size();
            for (int i8 = 0; i8 < size; i8++) {
                SupportActionModeWrapper supportActionModeWrapper = this.f1450c.get(i8);
                if (supportActionModeWrapper != null && supportActionModeWrapper.f1447b == actionMode) {
                    return supportActionModeWrapper;
                }
            }
            SupportActionModeWrapper supportActionModeWrapper2 = new SupportActionModeWrapper(this.f1449b, actionMode);
            this.f1450c.add(supportActionModeWrapper2);
            return supportActionModeWrapper2;
        }
    }

    public SupportActionModeWrapper(Context context, ActionMode actionMode) {
        this.f1446a = context;
        this.f1447b = actionMode;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f1447b.c();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f1447b.d();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new MenuWrapperICS(this.f1446a, (SupportMenu) this.f1447b.e());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f1447b.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f1447b.g();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f1447b.h();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f1447b.i();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f1447b.j();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f1447b.k();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f1447b.l();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f1447b.m(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f1447b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f1447b.p(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f1447b.r(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z7) {
        this.f1447b.s(z7);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i8) {
        this.f1447b.n(i8);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i8) {
        this.f1447b.q(i8);
    }
}
