package ee.mtakso.driver.service.voip;

import ee.mtakso.driver.network.client.OrderHandle;

/* compiled from: VoipCache.kt */
/* loaded from: classes3.dex */
public final class VoipCache {

    /* renamed from: a  reason: collision with root package name */
    private volatile OrderHandle f26100a;

    public final OrderHandle a() {
        return this.f26100a;
    }

    public final void b(OrderHandle orderHandle) {
        this.f26100a = orderHandle;
    }
}
