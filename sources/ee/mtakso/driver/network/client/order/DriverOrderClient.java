package ee.mtakso.driver.network.client.order;

import io.reactivex.Completable;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.rx2.RxCompletableKt;

/* compiled from: DriverOrderClient.kt */
/* loaded from: classes3.dex */
public final class DriverOrderClient {

    /* renamed from: a  reason: collision with root package name */
    private final CoroutineDispatcher f22332a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverOrderApi f22333b;

    @Inject
    public DriverOrderClient(CoroutineDispatcher dispatcher, DriverOrderApi driverOrderApi) {
        Intrinsics.f(dispatcher, "dispatcher");
        Intrinsics.f(driverOrderApi, "driverOrderApi");
        this.f22332a = dispatcher;
        this.f22333b = driverOrderApi;
    }

    public final Completable b(long j8) {
        return RxCompletableKt.b(this.f22332a, new DriverOrderClient$disableNewOrder$1(this, j8, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(ee.mtakso.driver.network.client.OrderHandle r5, kotlin.coroutines.Continuation<? super ee.mtakso.driver.network.client.order.Order> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ee.mtakso.driver.network.client.order.DriverOrderClient$getActiveOrder$1
            if (r0 == 0) goto L13
            r0 = r6
            ee.mtakso.driver.network.client.order.DriverOrderClient$getActiveOrder$1 r0 = (ee.mtakso.driver.network.client.order.DriverOrderClient$getActiveOrder$1) r0
            int r1 = r0.f22339h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f22339h = r1
            goto L18
        L13:
            ee.mtakso.driver.network.client.order.DriverOrderClient$getActiveOrder$1 r0 = new ee.mtakso.driver.network.client.order.DriverOrderClient$getActiveOrder$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f22337f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f22339h
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r6)
            goto L44
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.b(r6)
            ee.mtakso.driver.network.client.order.DriverOrderApi r6 = r4.f22333b
            ee.mtakso.driver.network.client.OrderRequest r2 = new ee.mtakso.driver.network.client.OrderRequest
            r2.<init>(r5)
            r0.f22339h = r3
            java.lang.Object r6 = r6.a(r2, r0)
            if (r6 != r1) goto L44
            return r1
        L44:
            eu.bolt.driver.core.network.response.ServerResponse r6 = (eu.bolt.driver.core.network.response.ServerResponse) r6
            java.lang.Object r5 = eu.bolt.driver.core.network.response.BasicServerResponseKt.a(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.network.client.order.DriverOrderClient.c(ee.mtakso.driver.network.client.OrderHandle, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
