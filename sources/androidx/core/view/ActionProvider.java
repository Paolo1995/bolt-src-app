package androidx.core.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class ActionProvider {

    /* renamed from: a  reason: collision with root package name */
    private final Context f5919a;

    /* renamed from: b  reason: collision with root package name */
    private SubUiVisibilityListener f5920b;

    /* renamed from: c  reason: collision with root package name */
    private VisibilityListener f5921c;

    /* loaded from: classes.dex */
    public interface SubUiVisibilityListener {
    }

    /* loaded from: classes.dex */
    public interface VisibilityListener {
        void onActionProviderVisibilityChanged(boolean z7);
    }

    public ActionProvider(@NonNull Context context) {
        this.f5919a = context;
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return true;
    }

    @NonNull
    public abstract View c();

    @NonNull
    public View d(@NonNull MenuItem menuItem) {
        return c();
    }

    public boolean e() {
        return false;
    }

    public void f(@NonNull SubMenu subMenu) {
    }

    public boolean g() {
        return false;
    }

    public void h() {
        this.f5921c = null;
        this.f5920b = null;
    }

    public void i(SubUiVisibilityListener subUiVisibilityListener) {
        this.f5920b = subUiVisibilityListener;
    }

    public void j(VisibilityListener visibilityListener) {
        if (this.f5921c != null && visibilityListener != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f5921c = visibilityListener;
    }
}
