package ee.mtakso.driver.service.push.handler;

import ee.mtakso.driver.network.client.driver.DriverStatusKt;
import ee.mtakso.driver.platform.push.Push;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import ee.mtakso.driver.service.push.PushHandler;
import ee.mtakso.driver.service.push.PushNotificationManager;
import ee.mtakso.driver.service.push.PushType;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScheduledOrderPushHandler.kt */
/* loaded from: classes3.dex */
public final class ScheduledOrderPushHandler implements PushHandler {

    /* renamed from: a  reason: collision with root package name */
    private final PushNotificationManager f25713a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverStatusProvider f25714b;

    @Inject
    public ScheduledOrderPushHandler(PushNotificationManager pushNotificationManager, DriverStatusProvider driverStatusProvider) {
        Intrinsics.f(pushNotificationManager, "pushNotificationManager");
        Intrinsics.f(driverStatusProvider, "driverStatusProvider");
        this.f25713a = pushNotificationManager;
        this.f25714b = driverStatusProvider;
    }

    @Override // ee.mtakso.driver.service.push.PushHandler
    public int a() {
        return PushHandler.DefaultImpls.a(this);
    }

    @Override // ee.mtakso.driver.service.push.PushHandler
    public boolean b(Push push) {
        Intrinsics.f(push, "push");
        if (Intrinsics.a(push.b().get("type"), PushType.UPCOMING_SCHEDULED_RIDE_GO_ONLINE.getId())) {
            if (DriverStatusKt.a(this.f25714b.n())) {
                this.f25713a.f(push);
                this.f25713a.g(push);
            }
            return true;
        }
        return false;
    }
}
