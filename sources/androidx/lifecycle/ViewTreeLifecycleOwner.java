package androidx.lifecycle;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.runtime.R$id;

/* loaded from: classes.dex */
public class ViewTreeLifecycleOwner {
    private ViewTreeLifecycleOwner() {
    }

    public static void a(@NonNull View view, LifecycleOwner lifecycleOwner) {
        view.setTag(R$id.f6810a, lifecycleOwner);
    }
}
