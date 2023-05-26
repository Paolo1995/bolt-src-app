package ee.mtakso.driver.service.push.handler;

import ee.mtakso.driver.platform.push.Push;
import ee.mtakso.driver.service.push.PushHandler;
import ee.mtakso.driver.service.push.PushNotificationManager;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultPushHandler.kt */
/* loaded from: classes3.dex */
public final class DefaultPushHandler implements PushHandler {

    /* renamed from: a  reason: collision with root package name */
    private final PushNotificationManager f25677a;

    @Inject
    public DefaultPushHandler(PushNotificationManager pushNotificationManager) {
        Intrinsics.f(pushNotificationManager, "pushNotificationManager");
        this.f25677a = pushNotificationManager;
    }

    @Override // ee.mtakso.driver.service.push.PushHandler
    public int a() {
        return Integer.MIN_VALUE;
    }

    @Override // ee.mtakso.driver.service.push.PushHandler
    public boolean b(Push push) {
        Intrinsics.f(push, "push");
        this.f25677a.f(push);
        this.f25677a.g(push);
        return true;
    }
}
