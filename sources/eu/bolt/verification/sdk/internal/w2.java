package eu.bolt.verification.sdk.internal;

import eu.bolt.android.rib.ViewRouter;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class w2 extends ViewRouter<y2> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public w2(y2 view, q2 interactor) {
        super(view, interactor);
        Intrinsics.f(view, "view");
        Intrinsics.f(interactor, "interactor");
        interactor.O(this);
    }
}
