package androidx.core.view;

import android.view.LayoutInflater;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class LayoutInflaterCompat {
    private LayoutInflaterCompat() {
    }

    public static void a(@NonNull LayoutInflater layoutInflater, @NonNull LayoutInflater.Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
    }
}
