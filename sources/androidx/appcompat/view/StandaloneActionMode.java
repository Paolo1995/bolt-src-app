package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class StandaloneActionMode extends ActionMode implements MenuBuilder.Callback {

    /* renamed from: h  reason: collision with root package name */
    private Context f1439h;

    /* renamed from: i  reason: collision with root package name */
    private ActionBarContextView f1440i;

    /* renamed from: j  reason: collision with root package name */
    private ActionMode.Callback f1441j;

    /* renamed from: k  reason: collision with root package name */
    private WeakReference<View> f1442k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f1443l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f1444m;

    /* renamed from: n  reason: collision with root package name */
    private MenuBuilder f1445n;

    public StandaloneActionMode(Context context, ActionBarContextView actionBarContextView, ActionMode.Callback callback, boolean z7) {
        this.f1439h = context;
        this.f1440i = actionBarContextView;
        this.f1441j = callback;
        MenuBuilder S = new MenuBuilder(actionBarContextView.getContext()).S(1);
        this.f1445n = S;
        S.R(this);
        this.f1444m = z7;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public boolean a(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        return this.f1441j.c(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public void b(@NonNull MenuBuilder menuBuilder) {
        k();
        this.f1440i.l();
    }

    @Override // androidx.appcompat.view.ActionMode
    public void c() {
        if (this.f1443l) {
            return;
        }
        this.f1443l = true;
        this.f1441j.a(this);
    }

    @Override // androidx.appcompat.view.ActionMode
    public View d() {
        WeakReference<View> weakReference = this.f1442k;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // androidx.appcompat.view.ActionMode
    public Menu e() {
        return this.f1445n;
    }

    @Override // androidx.appcompat.view.ActionMode
    public MenuInflater f() {
        return new SupportMenuInflater(this.f1440i.getContext());
    }

    @Override // androidx.appcompat.view.ActionMode
    public CharSequence g() {
        return this.f1440i.getSubtitle();
    }

    @Override // androidx.appcompat.view.ActionMode
    public CharSequence i() {
        return this.f1440i.getTitle();
    }

    @Override // androidx.appcompat.view.ActionMode
    public void k() {
        this.f1441j.d(this, this.f1445n);
    }

    @Override // androidx.appcompat.view.ActionMode
    public boolean l() {
        return this.f1440i.j();
    }

    @Override // androidx.appcompat.view.ActionMode
    public void m(View view) {
        WeakReference<View> weakReference;
        this.f1440i.setCustomView(view);
        if (view != null) {
            weakReference = new WeakReference<>(view);
        } else {
            weakReference = null;
        }
        this.f1442k = weakReference;
    }

    @Override // androidx.appcompat.view.ActionMode
    public void n(int i8) {
        o(this.f1439h.getString(i8));
    }

    @Override // androidx.appcompat.view.ActionMode
    public void o(CharSequence charSequence) {
        this.f1440i.setSubtitle(charSequence);
    }

    @Override // androidx.appcompat.view.ActionMode
    public void q(int i8) {
        r(this.f1439h.getString(i8));
    }

    @Override // androidx.appcompat.view.ActionMode
    public void r(CharSequence charSequence) {
        this.f1440i.setTitle(charSequence);
    }

    @Override // androidx.appcompat.view.ActionMode
    public void s(boolean z7) {
        super.s(z7);
        this.f1440i.setTitleOptional(z7);
    }
}
