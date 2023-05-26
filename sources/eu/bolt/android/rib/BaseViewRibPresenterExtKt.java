package eu.bolt.android.rib;

import eu.bolt.coroutines.flows.PublishFlow;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseViewRibPresenterExt.kt */
/* loaded from: classes5.dex */
public final class BaseViewRibPresenterExtKt {
    public static final <UiType> PublishFlow<UiType> a(BaseViewRibPresenter<?> baseViewRibPresenter) {
        Intrinsics.f(baseViewRibPresenter, "<this>");
        return new PublishFlow<>();
    }
}
