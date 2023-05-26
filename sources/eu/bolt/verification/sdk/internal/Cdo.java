package eu.bolt.verification.sdk.internal;

import android.view.ViewGroup;
import eu.bolt.android.rib.dynamic.BaseDynamicRouter;
import eu.bolt.android.rib.dynamic.controller.DynamicStateController1Arg;
import eu.bolt.verification.sdk.internal.xi;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: eu.bolt.verification.sdk.internal.do  reason: invalid class name */
/* loaded from: classes5.dex */
public abstract class Cdo extends BaseDynamicRouter<ViewGroup> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Cdo(ViewGroup view, zn<Cdo> interactor) {
        super(view, interactor, null, 4, null);
        Intrinsics.f(view, "view");
        Intrinsics.f(interactor, "interactor");
    }

    public abstract DynamicStateController1Arg<xi.a> f1();
}
