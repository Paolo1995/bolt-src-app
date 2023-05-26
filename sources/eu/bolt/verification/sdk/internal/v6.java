package eu.bolt.verification.sdk.internal;

import android.content.Context;
import eu.bolt.android.rib.ViewRouter;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class v6 extends ViewRouter<w6> {

    /* renamed from: k  reason: collision with root package name */
    private final qj f45433k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v6(w6 view, t6 interactor, qj storyScreenRouter) {
        super(view, interactor);
        Intrinsics.f(view, "view");
        Intrinsics.f(interactor, "interactor");
        Intrinsics.f(storyScreenRouter, "storyScreenRouter");
        this.f45433k = storyScreenRouter;
    }

    public final void B(String url) {
        Intrinsics.f(url, "url");
        Context context = A().getContext();
        Intrinsics.e(context, "view.context");
        f2.g(context, url, 0, 0, null, 14, null);
    }

    public final void C(String storyId) {
        Intrinsics.f(storyId, "storyId");
        this.f45433k.c(storyId);
    }
}
