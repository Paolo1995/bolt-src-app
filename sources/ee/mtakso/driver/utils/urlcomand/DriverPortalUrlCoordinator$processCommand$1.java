package ee.mtakso.driver.utils.urlcomand;

import ee.mtakso.driver.utils.CompositeUrlLauncher;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverPortalUrlCoordinator.kt */
/* loaded from: classes5.dex */
/* synthetic */ class DriverPortalUrlCoordinator$processCommand$1 extends AdaptedFunctionReference implements Function1<String, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DriverPortalUrlCoordinator$processCommand$1(Object obj) {
        super(1, obj, CompositeUrlLauncher.class, "openUrl", "openUrl(Ljava/lang/String;)Z", 8);
    }

    public final void c(String p02) {
        Intrinsics.f(p02, "p0");
        ((CompositeUrlLauncher) this.f50976f).a(p02);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        c(str);
        return Unit.f50853a;
    }
}
