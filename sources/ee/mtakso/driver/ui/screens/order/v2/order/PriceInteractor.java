package ee.mtakso.driver.ui.screens.order.v2.order;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.order.OrderClient;
import ee.mtakso.driver.network.client.order.Price;
import ee.mtakso.driver.service.geo.transmitter.LocationTransmitter;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PriceInteractor.kt */
/* loaded from: classes3.dex */
public final class PriceInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final LocationTransmitter f32315a;

    /* renamed from: b  reason: collision with root package name */
    private final OrderClient f32316b;

    @Inject
    public PriceInteractor(LocationTransmitter locationTransmitter, OrderClient apiClient) {
        Intrinsics.f(locationTransmitter, "locationTransmitter");
        Intrinsics.f(apiClient, "apiClient");
        this.f32315a = locationTransmitter;
        this.f32316b = apiClient;
    }

    public final Single<Price> a(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        Single<Price> f8 = LocationTransmitter.l(this.f32315a, orderHandle, false, 0, 4, null).f(this.f32316b.u(orderHandle));
        Intrinsics.e(f8, "locationTransmitter.tran…urrentPrice(orderHandle))");
        return f8;
    }
}
