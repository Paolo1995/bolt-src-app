package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.ViewPropertyAnimatorCompat;

/* loaded from: classes.dex */
public interface DecorToolbar {
    boolean a();

    boolean b();

    boolean c();

    void collapseActionView();

    void d(Menu menu, MenuPresenter.Callback callback);

    boolean e();

    void f();

    boolean g();

    Context getContext();

    CharSequence getTitle();

    boolean h();

    void i(int i8);

    Menu j();

    int k();

    ViewPropertyAnimatorCompat l(int i8, long j8);

    ViewGroup m();

    void n(boolean z7);

    void o();

    void p(boolean z7);

    void q();

    void r(ScrollingTabContainerView scrollingTabContainerView);

    void s(int i8);

    void setIcon(int i8);

    void setIcon(Drawable drawable);

    void setTitle(CharSequence charSequence);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    void t(MenuPresenter.Callback callback, MenuBuilder.Callback callback2);

    void u(int i8);

    int v();

    void w();
}
