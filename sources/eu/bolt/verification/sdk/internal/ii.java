package eu.bolt.verification.sdk.internal;

import eu.bolt.android.rib.ViewRouter;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class ii extends ViewRouter<hi> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ii(hi view, ei interactor) {
        super(view, interactor);
        Intrinsics.f(view, "view");
        Intrinsics.f(interactor, "interactor");
    }
}
