package eu.bolt.android.rib;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewRouter.kt */
/* loaded from: classes5.dex */
public abstract class ViewRouter<V extends View> extends Router {

    /* renamed from: j  reason: collision with root package name */
    private final V f37100j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewRouter(V view, RibLifecycleSubject interactor) {
        super(interactor);
        Intrinsics.f(view, "view");
        Intrinsics.f(interactor, "interactor");
        this.f37100j = view;
    }

    public final V A() {
        return this.f37100j;
    }
}
