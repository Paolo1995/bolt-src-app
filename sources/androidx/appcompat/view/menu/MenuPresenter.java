package androidx.appcompat.view.menu;

import android.content.Context;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public interface MenuPresenter {

    /* loaded from: classes.dex */
    public interface Callback {
        void a(@NonNull MenuBuilder menuBuilder, boolean z7);

        boolean b(@NonNull MenuBuilder menuBuilder);
    }

    void a(MenuBuilder menuBuilder, boolean z7);

    boolean d(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl);

    void e(Callback callback);

    boolean f(SubMenuBuilder subMenuBuilder);

    void g(boolean z7);

    boolean h();

    boolean i(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl);

    void j(Context context, MenuBuilder menuBuilder);
}
