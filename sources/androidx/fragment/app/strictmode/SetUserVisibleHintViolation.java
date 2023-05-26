package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SetUserVisibleHintViolation.kt */
/* loaded from: classes.dex */
public final class SetUserVisibleHintViolation extends Violation {
    private final boolean isVisibleToUser;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SetUserVisibleHintViolation(Fragment fragment, boolean z7) {
        super(fragment, "Attempting to set user visible hint to " + z7 + " for fragment " + fragment);
        Intrinsics.f(fragment, "fragment");
        this.isVisibleToUser = z7;
    }

    public final boolean isVisibleToUser() {
        return this.isVisibleToUser;
    }
}
