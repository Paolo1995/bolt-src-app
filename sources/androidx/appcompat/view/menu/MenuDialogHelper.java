package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.appcompat.R$layout;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.MenuPresenter;

/* loaded from: classes.dex */
class MenuDialogHelper implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, MenuPresenter.Callback {

    /* renamed from: f  reason: collision with root package name */
    private MenuBuilder f1635f;

    /* renamed from: g  reason: collision with root package name */
    private AlertDialog f1636g;

    /* renamed from: h  reason: collision with root package name */
    ListMenuPresenter f1637h;

    /* renamed from: i  reason: collision with root package name */
    private MenuPresenter.Callback f1638i;

    public MenuDialogHelper(MenuBuilder menuBuilder) {
        this.f1635f = menuBuilder;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public void a(@NonNull MenuBuilder menuBuilder, boolean z7) {
        if (z7 || menuBuilder == this.f1635f) {
            c();
        }
        MenuPresenter.Callback callback = this.f1638i;
        if (callback != null) {
            callback.a(menuBuilder, z7);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public boolean b(@NonNull MenuBuilder menuBuilder) {
        MenuPresenter.Callback callback = this.f1638i;
        if (callback != null) {
            return callback.b(menuBuilder);
        }
        return false;
    }

    public void c() {
        AlertDialog alertDialog = this.f1636g;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public void d(IBinder iBinder) {
        MenuBuilder menuBuilder = this.f1635f;
        AlertDialog.Builder builder = new AlertDialog.Builder(menuBuilder.u());
        ListMenuPresenter listMenuPresenter = new ListMenuPresenter(builder.b(), R$layout.f926j);
        this.f1637h = listMenuPresenter;
        listMenuPresenter.e(this);
        this.f1635f.b(this.f1637h);
        builder.c(this.f1637h.b(), this);
        View y7 = menuBuilder.y();
        if (y7 != null) {
            builder.e(y7);
        } else {
            builder.g(menuBuilder.w()).o(menuBuilder.x());
        }
        builder.k(this);
        AlertDialog a8 = builder.a();
        this.f1636g = a8;
        a8.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f1636g.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f1636g.show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i8) {
        this.f1635f.L((MenuItemImpl) this.f1637h.b().getItem(i8), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f1637h.a(this.f1635f, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i8, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i8 == 82 || i8 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f1636g.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f1636g.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f1635f.e(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f1635f.performShortcut(i8, keyEvent, 0);
    }
}
