package ee.mtakso.driver.ui.screens.order.arrived;

import ee.mtakso.driver.network.client.order.PricingData;
import ee.mtakso.driver.service.order.details.ActiveOrderDetails;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DrivePriceInteractor.kt */
/* loaded from: classes3.dex */
public final class DrivePriceInteractor$getPriceInfo$1 extends Lambda implements Function1<ActiveOrderDetails, SingleSource<? extends DrivePriceInfoAndOrderDetails>> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ DrivePriceInteractor f30991f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrivePriceInteractor$getPriceInfo$1(DrivePriceInteractor drivePriceInteractor) {
        super(1);
        this.f30991f = drivePriceInteractor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrivePriceInfoAndOrderDetails d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (DrivePriceInfoAndOrderDetails) tmp0.invoke(obj);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: c */
    public final SingleSource<? extends DrivePriceInfoAndOrderDetails> invoke(final ActiveOrderDetails details) {
        Single o8;
        Intrinsics.f(details, "details");
        o8 = this.f30991f.o(details.a());
        final Function1<PricingData, DrivePriceInfoAndOrderDetails> function1 = new Function1<PricingData, DrivePriceInfoAndOrderDetails>() { // from class: ee.mtakso.driver.ui.screens.order.arrived.DrivePriceInteractor$getPriceInfo$1.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final DrivePriceInfoAndOrderDetails invoke(PricingData pricing) {
                Intrinsics.f(pricing, "pricing");
                return new DrivePriceInfoAndOrderDetails(pricing, ActiveOrderDetails.this);
            }
        };
        return o8.x(new Function() { // from class: ee.mtakso.driver.ui.screens.order.arrived.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                DrivePriceInfoAndOrderDetails d8;
                d8 = DrivePriceInteractor$getPriceInfo$1.d(Function1.this, obj);
                return d8;
            }
        });
    }
}
