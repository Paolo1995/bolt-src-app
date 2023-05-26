package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.appcompat.R$dimen;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
public class MenuPopupHelper {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1678a;

    /* renamed from: b  reason: collision with root package name */
    private final MenuBuilder f1679b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f1680c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1681d;

    /* renamed from: e  reason: collision with root package name */
    private final int f1682e;

    /* renamed from: f  reason: collision with root package name */
    private View f1683f;

    /* renamed from: g  reason: collision with root package name */
    private int f1684g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1685h;

    /* renamed from: i  reason: collision with root package name */
    private MenuPresenter.Callback f1686i;

    /* renamed from: j  reason: collision with root package name */
    private MenuPopup f1687j;

    /* renamed from: k  reason: collision with root package name */
    private PopupWindow.OnDismissListener f1688k;

    /* renamed from: l  reason: collision with root package name */
    private final PopupWindow.OnDismissListener f1689l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api17Impl {
        private Api17Impl() {
        }

        static void a(Display display, Point point) {
            display.getRealSize(point);
        }
    }

    public MenuPopupHelper(@NonNull Context context, @NonNull MenuBuilder menuBuilder, @NonNull View view, boolean z7, int i8) {
        this(context, menuBuilder, view, z7, i8, 0);
    }

    @NonNull
    private MenuPopup a() {
        boolean z7;
        MenuPopup standardMenuPopup;
        Display defaultDisplay = ((WindowManager) this.f1678a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        Api17Impl.a(defaultDisplay, point);
        if (Math.min(point.x, point.y) >= this.f1678a.getResources().getDimensionPixelSize(R$dimen.f852c)) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            standardMenuPopup = new CascadingMenuPopup(this.f1678a, this.f1683f, this.f1681d, this.f1682e, this.f1680c);
        } else {
            standardMenuPopup = new StandardMenuPopup(this.f1678a, this.f1679b, this.f1683f, this.f1681d, this.f1682e, this.f1680c);
        }
        standardMenuPopup.k(this.f1679b);
        standardMenuPopup.u(this.f1689l);
        standardMenuPopup.o(this.f1683f);
        standardMenuPopup.e(this.f1686i);
        standardMenuPopup.r(this.f1685h);
        standardMenuPopup.s(this.f1684g);
        return standardMenuPopup;
    }

    private void l(int i8, int i9, boolean z7, boolean z8) {
        MenuPopup c8 = c();
        c8.v(z8);
        if (z7) {
            if ((GravityCompat.b(this.f1684g, ViewCompat.E(this.f1683f)) & 7) == 5) {
                i8 -= this.f1683f.getWidth();
            }
            c8.t(i8);
            c8.w(i9);
            int i10 = (int) ((this.f1678a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            c8.q(new Rect(i8 - i10, i9 - i10, i8 + i10, i9 + i10));
        }
        c8.b();
    }

    public void b() {
        if (d()) {
            this.f1687j.dismiss();
        }
    }

    @NonNull
    public MenuPopup c() {
        if (this.f1687j == null) {
            this.f1687j = a();
        }
        return this.f1687j;
    }

    public boolean d() {
        MenuPopup menuPopup = this.f1687j;
        if (menuPopup != null && menuPopup.c()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        this.f1687j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f1688k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f(@NonNull View view) {
        this.f1683f = view;
    }

    public void g(boolean z7) {
        this.f1685h = z7;
        MenuPopup menuPopup = this.f1687j;
        if (menuPopup != null) {
            menuPopup.r(z7);
        }
    }

    public void h(int i8) {
        this.f1684g = i8;
    }

    public void i(PopupWindow.OnDismissListener onDismissListener) {
        this.f1688k = onDismissListener;
    }

    public void j(MenuPresenter.Callback callback) {
        this.f1686i = callback;
        MenuPopup menuPopup = this.f1687j;
        if (menuPopup != null) {
            menuPopup.e(callback);
        }
    }

    public void k() {
        if (m()) {
            return;
        }
        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }

    public boolean m() {
        if (d()) {
            return true;
        }
        if (this.f1683f == null) {
            return false;
        }
        l(0, 0, false, false);
        return true;
    }

    public boolean n(int i8, int i9) {
        if (d()) {
            return true;
        }
        if (this.f1683f == null) {
            return false;
        }
        l(i8, i9, true, true);
        return true;
    }

    public MenuPopupHelper(@NonNull Context context, @NonNull MenuBuilder menuBuilder, @NonNull View view, boolean z7, int i8, int i9) {
        this.f1684g = 8388611;
        this.f1689l = new PopupWindow.OnDismissListener() { // from class: androidx.appcompat.view.menu.MenuPopupHelper.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                MenuPopupHelper.this.e();
            }
        };
        this.f1678a = context;
        this.f1679b = menuBuilder;
        this.f1683f = view;
        this.f1680c = z7;
        this.f1681d = i8;
        this.f1682e = i9;
    }
}
