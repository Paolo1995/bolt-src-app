package androidx.appcompat.widget;

import android.view.Menu;
import android.view.Window;
import androidx.appcompat.view.menu.MenuPresenter;

/* loaded from: classes.dex */
public interface DecorContentParent {
    boolean a();

    boolean b();

    boolean c();

    void d(Menu menu, MenuPresenter.Callback callback);

    boolean e();

    void f();

    boolean g();

    void h(int i8);

    void l();

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);
}
