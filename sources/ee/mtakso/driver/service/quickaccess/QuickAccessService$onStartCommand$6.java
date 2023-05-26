package ee.mtakso.driver.service.quickaccess;

import ee.mtakso.driver.service.quickaccess.QuickAccessService;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QuickAccessService.kt */
/* loaded from: classes3.dex */
/* synthetic */ class QuickAccessService$onStartCommand$6 extends FunctionReferenceImpl implements Function2<QuickAccessService.StatusOrderData, QuickAccessService.StatusOrderData, Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public QuickAccessService$onStartCommand$6(Object obj) {
        super(2, obj, QuickAccessService.class, "compare", "compare(Lee/mtakso/driver/service/quickaccess/QuickAccessService$StatusOrderData;Lee/mtakso/driver/service/quickaccess/QuickAccessService$StatusOrderData;)Z", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: j */
    public final Boolean s(QuickAccessService.StatusOrderData p02, QuickAccessService.StatusOrderData p12) {
        boolean z7;
        Intrinsics.f(p02, "p0");
        Intrinsics.f(p12, "p1");
        z7 = ((QuickAccessService) this.f50989g).z(p02, p12);
        return Boolean.valueOf(z7);
    }
}
