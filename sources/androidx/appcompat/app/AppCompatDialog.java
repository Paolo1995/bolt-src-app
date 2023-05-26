package androidx.appcompat.app;

import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentDialog;
import androidx.annotation.NonNull;
import androidx.appcompat.R$attr;
import androidx.appcompat.view.ActionMode;
import androidx.core.view.KeyEventDispatcher;

/* loaded from: classes.dex */
public class AppCompatDialog extends ComponentDialog implements AppCompatCallback {

    /* renamed from: h  reason: collision with root package name */
    private AppCompatDelegate f1258h;

    /* renamed from: i  reason: collision with root package name */
    private final KeyEventDispatcher.Component f1259i;

    public AppCompatDialog(@NonNull Context context, int i8) {
        super(context, f(context, i8));
        this.f1259i = new KeyEventDispatcher.Component() { // from class: androidx.appcompat.app.f
            @Override // androidx.core.view.KeyEventDispatcher.Component
            public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
                return AppCompatDialog.this.g(keyEvent);
            }
        };
        AppCompatDelegate e8 = e();
        e8.Z(f(context, i8));
        e8.G(null);
    }

    private static int f(Context context, int i8) {
        if (i8 == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R$attr.f840z, typedValue, true);
            return typedValue.resourceId;
        }
        return i8;
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void addContentView(@NonNull View view, ViewGroup.LayoutParams layoutParams) {
        e().f(view, layoutParams);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        e().H();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return KeyEventDispatcher.e(this.f1259i, getWindow().getDecorView(), this, keyEvent);
    }

    @NonNull
    public AppCompatDelegate e() {
        if (this.f1258h == null) {
            this.f1258h = AppCompatDelegate.o(this, this);
        }
        return this.f1258h;
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i8) {
        return (T) e().p(i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean h(int i8) {
        return e().P(i8);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        e().B();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        e().A();
        super.onCreate(bundle);
        e().G(bundle);
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    protected void onStop() {
        super.onStop();
        e().M();
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeFinished(ActionMode actionMode) {
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeStarted(ActionMode actionMode) {
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback callback) {
        return null;
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(int i8) {
        e().T(i8);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        e().a0(charSequence);
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(@NonNull View view) {
        e().U(view);
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(@NonNull View view, ViewGroup.LayoutParams layoutParams) {
        e().V(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i8) {
        super.setTitle(i8);
        e().a0(getContext().getString(i8));
    }
}
