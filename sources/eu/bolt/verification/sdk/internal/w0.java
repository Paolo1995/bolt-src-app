package eu.bolt.verification.sdk.internal;

import android.content.Context;
import eu.bolt.android.rib.ViewRouter;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class w0 extends ViewRouter<x0> {

    /* renamed from: k  reason: collision with root package name */
    private final qj f45485k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w0(x0 view, t0 interactor, qj storyScreenRouter) {
        super(view, interactor);
        Intrinsics.f(view, "view");
        Intrinsics.f(interactor, "interactor");
        Intrinsics.f(storyScreenRouter, "storyScreenRouter");
        this.f45485k = storyScreenRouter;
    }

    public final void B(String storyId) {
        Intrinsics.f(storyId, "storyId");
        this.f45485k.c(storyId);
    }

    public final void C(String url) {
        Intrinsics.f(url, "url");
        Context context = A().getContext();
        Intrinsics.e(context, "view.context");
        f2.g(context, url, 0, 0, null, 14, null);
    }
}
