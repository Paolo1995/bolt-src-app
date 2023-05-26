package androidx.appcompat.widget;

import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuBuilder;

/* loaded from: classes.dex */
public interface MenuItemHoverListener {
    void a(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem);

    void o(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem);
}
