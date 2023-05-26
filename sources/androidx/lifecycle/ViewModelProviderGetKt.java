package androidx.lifecycle;

import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewModelProvider.kt */
/* loaded from: classes.dex */
public final class ViewModelProviderGetKt {
    public static final CreationExtras a(ViewModelStoreOwner owner) {
        Intrinsics.f(owner, "owner");
        if (owner instanceof HasDefaultViewModelProviderFactory) {
            CreationExtras defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) owner).getDefaultViewModelCreationExtras();
            Intrinsics.e(defaultViewModelCreationExtras, "{\n        owner.defaultV…ModelCreationExtras\n    }");
            return defaultViewModelCreationExtras;
        }
        return CreationExtras.Empty.f6812b;
    }
}
