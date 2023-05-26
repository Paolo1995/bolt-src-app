package ee.mtakso.driver.network.client.driver;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.response.ServerResponse;
import ee.mtakso.driver.network.response.ServerResponseKt;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WaybillClient.kt */
/* loaded from: classes3.dex */
public final class WaybillClient {

    /* renamed from: a  reason: collision with root package name */
    private final WaybillApi f22017a;

    @Inject
    public WaybillClient(WaybillApi api) {
        Intrinsics.f(api, "api");
        this.f22017a = api;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WayBillData c(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (WayBillData) tmp0.invoke(obj);
    }

    public final Single<WayBillData> b(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        Single<ServerResponse<WayBillData>> a8 = this.f22017a.a(orderHandle);
        final WaybillClient$getWaybill$1 waybillClient$getWaybill$1 = new Function1<ServerResponse<WayBillData>, WayBillData>() { // from class: ee.mtakso.driver.network.client.driver.WaybillClient$getWaybill$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final WayBillData invoke(ServerResponse<WayBillData> it) {
                Intrinsics.f(it, "it");
                return (WayBillData) ServerResponseKt.b(it);
            }
        };
        Single x7 = a8.x(new Function() { // from class: ee.mtakso.driver.network.client.driver.h
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                WayBillData c8;
                c8 = WaybillClient.c(Function1.this, obj);
                return c8;
            }
        });
        Intrinsics.e(x7, "api.getWaybill(orderHand…).map { it.exposeData() }");
        return x7;
    }
}
