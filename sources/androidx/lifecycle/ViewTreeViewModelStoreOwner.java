package androidx.lifecycle;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.viewmodel.R$id;

/* loaded from: classes.dex */
public class ViewTreeViewModelStoreOwner {
    private ViewTreeViewModelStoreOwner() {
    }

    public static void a(@NonNull View view, ViewModelStoreOwner viewModelStoreOwner) {
        view.setTag(R$id.f6815a, viewModelStoreOwner);
    }
}
