package ee.mtakso.driver.service.push.handler;

import ee.mtakso.driver.platform.push.Push;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import ee.mtakso.driver.service.push.PushHandler;
import ee.mtakso.driver.service.push.PushNotificationManager;
import ee.mtakso.driver.service.rating.app.AppRatingManager;
import ee.mtakso.driver.utils.BackgroundManager;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RateAppPushHandler.kt */
/* loaded from: classes3.dex */
public final class RateAppPushHandler implements PushHandler {

    /* renamed from: a  reason: collision with root package name */
    private final PushNotificationManager f25693a;

    /* renamed from: b  reason: collision with root package name */
    private final AppRatingManager f25694b;

    /* renamed from: c  reason: collision with root package name */
    private final BackgroundManager f25695c;

    /* renamed from: d  reason: collision with root package name */
    private final DriverStatusProvider f25696d;

    @Inject
    public RateAppPushHandler(PushNotificationManager pushNotificationManager, AppRatingManager appRatingManager, BackgroundManager backgroundManager, DriverStatusProvider driverStatusProvider) {
        Intrinsics.f(pushNotificationManager, "pushNotificationManager");
        Intrinsics.f(appRatingManager, "appRatingManager");
        Intrinsics.f(backgroundManager, "backgroundManager");
        Intrinsics.f(driverStatusProvider, "driverStatusProvider");
        this.f25693a = pushNotificationManager;
        this.f25694b = appRatingManager;
        this.f25695c = backgroundManager;
        this.f25696d = driverStatusProvider;
    }

    @Override // ee.mtakso.driver.service.push.PushHandler
    public int a() {
        return PushHandler.DefaultImpls.a(this);
    }

    @Override // ee.mtakso.driver.service.push.PushHandler
    public boolean b(Push push) {
        Intrinsics.f(push, "push");
        return false;
    }
}
