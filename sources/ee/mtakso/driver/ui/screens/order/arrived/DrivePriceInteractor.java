package ee.mtakso.driver.ui.screens.order.arrived;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.order.OrderClient;
import ee.mtakso.driver.network.client.order.PaymentType;
import ee.mtakso.driver.network.client.order.PriceModificationType;
import ee.mtakso.driver.network.client.order.PricingData;
import ee.mtakso.driver.network.client.order.PricingOptions;
import ee.mtakso.driver.network.client.order.TollRoad;
import ee.mtakso.driver.service.modules.order.v2.OrderProviderUtils;
import ee.mtakso.driver.service.order.details.ActiveOrderDetails;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.uicore.components.views.priceSelectorView.PriceSelectorView;
import ee.mtakso.driver.utils.RetryWithDelaySingle;
import eu.bolt.kalev.Kalev;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: DrivePriceInteractor.kt */
/* loaded from: classes3.dex */
public final class DrivePriceInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final OrderProvider f30987a;

    /* renamed from: b  reason: collision with root package name */
    private final OrderClient f30988b;

    /* compiled from: DrivePriceInteractor.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30989a;

        static {
            int[] iArr = new int[PriceModificationType.values().length];
            try {
                iArr[PriceModificationType.FREE_INPUT_SHIFTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PriceModificationType.FREE_INPUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PriceModificationType.STEP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f30989a = iArr;
        }
    }

    @Inject
    public DrivePriceInteractor(OrderProvider orderProvider, OrderClient orderClient) {
        Intrinsics.f(orderProvider, "orderProvider");
        Intrinsics.f(orderClient, "orderClient");
        this.f30987a = orderProvider;
        this.f30988b = orderClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String l(PricingData pricingData) {
        boolean y7;
        y7 = StringsKt__StringsJVMKt.y(pricingData.c());
        if (y7) {
            return pricingData.b();
        }
        return pricingData.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PriceSelectorView.CurrencyGravity m(PricingData pricingData) {
        boolean y7;
        y7 = StringsKt__StringsJVMKt.y(pricingData.c());
        if (y7) {
            return PriceSelectorView.CurrencyGravity.RIGHT;
        }
        return PriceSelectorView.CurrencyGravity.LEFT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final double n(PricingOptions pricingOptions) {
        Double a8 = pricingOptions.a();
        if (a8 != null) {
            return a8.doubleValue();
        }
        return 0.2d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Single<PricingData> o(OrderHandle orderHandle) {
        Single<PricingData> F = this.f30988b.B(orderHandle).F(new RetryWithDelaySingle(5, 2000L));
        final DrivePriceInteractor$fetchPricingData$1 drivePriceInteractor$fetchPricingData$1 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.arrived.DrivePriceInteractor$fetchPricingData$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable throwable) {
                Intrinsics.f(throwable, "throwable");
                Kalev.e(throwable, "Error while receiving pricing info");
            }
        };
        Single<PricingData> l8 = F.l(new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.arrived.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DrivePriceInteractor.p(Function1.this, obj);
            }
        });
        Intrinsics.e(l8, "orderClient.getPricingDa…eceiving pricing info\") }");
        return l8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int q(PricingOptions pricingOptions) {
        Integer d8 = pricingOptions.d();
        if (d8 != null) {
            return d8.intValue();
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource s(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrivePriceScreenData t(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (DrivePriceScreenData) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PriceModificationMethod u(PricingOptions pricingOptions) {
        PriceModificationType priceModificationType;
        int i8;
        if (pricingOptions != null) {
            priceModificationType = pricingOptions.b();
        } else {
            priceModificationType = null;
        }
        if (priceModificationType == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f30989a[priceModificationType.ordinal()];
        }
        if (i8 != -1) {
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 != 3) {
                        return PriceModificationMethod.DISABLED;
                    }
                    return PriceModificationMethod.STEP;
                }
                return PriceModificationMethod.FREE_INPUT;
            }
            return PriceModificationMethod.FREE_INPUT_SHIFTING;
        }
        return PriceModificationMethod.STEP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean v(PricingData pricingData) {
        if (pricingData.h() == PaymentType.IN_APP) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean w(PricingOptions pricingOptions) {
        if (pricingOptions.c() == null) {
            return true;
        }
        Integer c8 = pricingOptions.c();
        if (c8 != null && c8.intValue() == 1) {
            return true;
        }
        return false;
    }

    public final Single<DrivePriceScreenData> r() {
        Single<ActiveOrderDetails> u7 = OrderProviderUtils.u(this.f30987a, OrderState.ORDER_STATE_ARRIVED_TO_DESTINATION);
        final DrivePriceInteractor$getPriceInfo$1 drivePriceInteractor$getPriceInfo$1 = new DrivePriceInteractor$getPriceInfo$1(this);
        Single<R> r7 = u7.r(new Function() { // from class: ee.mtakso.driver.ui.screens.order.arrived.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource s7;
                s7 = DrivePriceInteractor.s(Function1.this, obj);
                return s7;
            }
        });
        final Function1<DrivePriceInfoAndOrderDetails, DrivePriceScreenData> function1 = new Function1<DrivePriceInfoAndOrderDetails, DrivePriceScreenData>() { // from class: ee.mtakso.driver.ui.screens.order.arrived.DrivePriceInteractor$getPriceInfo$2

            /* compiled from: DrivePriceInteractor.kt */
            /* loaded from: classes3.dex */
            public /* synthetic */ class WhenMappings {

                /* renamed from: a  reason: collision with root package name */
                public static final /* synthetic */ int[] f30994a;

                static {
                    int[] iArr = new int[PriceModificationType.values().length];
                    try {
                        iArr[PriceModificationType.FREE_INPUT_SHIFTING.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[PriceModificationType.FREE_INPUT.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f30994a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final DrivePriceScreenData invoke(DrivePriceInfoAndOrderDetails priceAndOrderDetails) {
                PriceModificationType priceModificationType;
                int i8;
                BigDecimal bigDecimal;
                boolean v7;
                double d8;
                String l8;
                PriceSelectorView.CurrencyGravity m8;
                int i9;
                boolean z7;
                PriceModificationMethod u8;
                boolean w7;
                int q8;
                Intrinsics.f(priceAndOrderDetails, "priceAndOrderDetails");
                PricingData b8 = priceAndOrderDetails.b();
                PricingOptions d9 = b8.d();
                if (d9 != null) {
                    priceModificationType = d9.b();
                } else {
                    priceModificationType = null;
                }
                if (priceModificationType == null) {
                    i8 = -1;
                } else {
                    i8 = WhenMappings.f30994a[priceModificationType.ordinal()];
                }
                if (i8 != 1 && i8 != 2) {
                    bigDecimal = b8.l();
                } else {
                    bigDecimal = BigDecimal.ZERO;
                }
                BigDecimal bigDecimal2 = bigDecimal;
                long a8 = b8.a();
                String i10 = b8.i();
                v7 = DrivePriceInteractor.this.v(b8);
                String e8 = priceAndOrderDetails.a().i().e();
                if (d9 != null) {
                    d8 = DrivePriceInteractor.this.n(d9);
                } else {
                    d8 = 0.2d;
                }
                double d10 = d8;
                l8 = DrivePriceInteractor.this.l(b8);
                m8 = DrivePriceInteractor.this.m(b8);
                if (d9 != null) {
                    q8 = DrivePriceInteractor.this.q(d9);
                    i9 = q8;
                } else {
                    i9 = 2;
                }
                BigDecimal f8 = b8.f();
                String e9 = b8.e();
                BigDecimal l9 = b8.l();
                if (d9 != null) {
                    w7 = DrivePriceInteractor.this.w(d9);
                    z7 = w7;
                } else {
                    z7 = false;
                }
                List<TollRoad> j8 = b8.j();
                u8 = DrivePriceInteractor.this.u(d9);
                return new DrivePriceScreenData(a8, i10, v7, e8, d10, l8, m8, i9, f8, e9, l9, bigDecimal2, z7, j8, false, u8, b8.g(), b8.n(), 16384, null);
            }
        };
        Single<DrivePriceScreenData> x7 = r7.x(new Function() { // from class: ee.mtakso.driver.ui.screens.order.arrived.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                DrivePriceScreenData t7;
                t7 = DrivePriceInteractor.t(Function1.this, obj);
                return t7;
            }
        });
        Intrinsics.e(x7, "fun getPriceInfo(): Sing…)\n                }\n    }");
        return x7;
    }
}
