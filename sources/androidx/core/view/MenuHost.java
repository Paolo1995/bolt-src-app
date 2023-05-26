package androidx.core.view;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public interface MenuHost {
    void addMenuProvider(@NonNull MenuProvider menuProvider);

    void removeMenuProvider(@NonNull MenuProvider menuProvider);
}
