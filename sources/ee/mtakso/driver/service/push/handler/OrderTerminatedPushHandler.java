package ee.mtakso.driver.service.push.handler;

import ee.mtakso.driver.platform.push.Push;
import ee.mtakso.driver.service.push.PushHandler;
import ee.mtakso.driver.service.push.PushNotificationManager;
import ee.mtakso.driver.service.push.PushType;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderTerminatedPushHandler.kt */
/* loaded from: classes3.dex */
public final class OrderTerminatedPushHandler implements PushHandler {

    /* renamed from: a  reason: collision with root package name */
    private final PushNotificationManager f25691a;

    @Inject
    public OrderTerminatedPushHandler(PushNotificationManager pushNotificationManager) {
        Intrinsics.f(pushNotificationManager, "pushNotificationManager");
        this.f25691a = pushNotificationManager;
    }

    @Override // ee.mtakso.driver.service.push.PushHandler
    public int a() {
        return PushHandler.DefaultImpls.a(this);
    }

    @Override // ee.mtakso.driver.service.push.PushHandler
    public boolean b(Push push) {
        boolean z7;
        Intrinsics.f(push, "push");
        String str = push.b().get("type");
        if (Intrinsics.a(str, PushType.ORDER_CANCELLED.getId()) || Intrinsics.a(str, PushType.ORDER_FINISHED_EARLIER.getId())) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7) {
            return false;
        }
        this.f25691a.f(push);
        return true;
    }
}
