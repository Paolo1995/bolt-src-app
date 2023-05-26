package ee.mtakso.driver.service.geo.transmitter;

import ee.mtakso.driver.service.modules.order.v2.OrderProviderUtils;
import ee.mtakso.driver.service.order.details.ActiveOrderDetails;
import ee.mtakso.driver.service.order.details.OrderProvider;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TransmissionService.kt */
/* loaded from: classes3.dex */
public final class TransmissionService$startLocationTransmission$1 extends Lambda implements Function1<Long, CompletableSource> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ TransmissionService f24498f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ int f24499g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransmissionService$startLocationTransmission$1(TransmissionService transmissionService, int i8) {
        super(1);
        this.f24498f = transmissionService;
        this.f24499g = i8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g() {
        FastLog g8 = Kalev.f41674e.g();
        if (g8 != null) {
            FastLog.DefaultImpls.a(g8, "Upload done", null, 2, null);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: d */
    public final CompletableSource invoke(Long tick) {
        OrderProvider orderProvider;
        LocationTransmitter locationTransmitter;
        Intrinsics.f(tick, "tick");
        FastLog g8 = Kalev.f41674e.g();
        if (g8 != null) {
            FastLog.DefaultImpls.a(g8, "Do upload: " + tick, null, 2, null);
        }
        orderProvider = this.f24498f.f24489d;
        ActiveOrderDetails i8 = OrderProviderUtils.i(orderProvider.f());
        if (i8 != null) {
            locationTransmitter = this.f24498f.f24490e;
            Completable k8 = locationTransmitter.k(i8.a(), false, this.f24499g);
            final AnonymousClass1 anonymousClass1 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.geo.transmitter.TransmissionService$startLocationTransmission$1.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.f50853a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable error) {
                    Intrinsics.e(error, "error");
                    Kalev.e(error, "Failed to push location batch");
                }
            };
            return k8.p(new Consumer() { // from class: ee.mtakso.driver.service.geo.transmitter.n
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    TransmissionService$startLocationTransmission$1.e(Function1.this, obj);
                }
            }).n(new Action() { // from class: ee.mtakso.driver.service.geo.transmitter.o
                @Override // io.reactivex.functions.Action
                public final void run() {
                    TransmissionService$startLocationTransmission$1.g();
                }
            }).A();
        }
        Kalev.e(new NullPointerException("Current order is null"), "Failed to push location batch");
        return Completable.g();
    }
}
