package ee.mtakso.driver.service.push.handler;

import ee.mtakso.driver.param.RateMeModel;
import ee.mtakso.driver.platform.push.Push;
import ee.mtakso.driver.service.push.PushHandler;
import ee.mtakso.driver.service.push.PushNotificationManager;
import ee.mtakso.driver.service.push.PushType;
import ee.mtakso.driver.service.rating.app.AppRatingManager;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TipsPushHandler.kt */
/* loaded from: classes3.dex */
public final class TipsPushHandler implements PushHandler {

    /* renamed from: a  reason: collision with root package name */
    private final PushNotificationManager f25722a;

    /* renamed from: b  reason: collision with root package name */
    private final AppRatingManager f25723b;

    @Inject
    public TipsPushHandler(PushNotificationManager pushNotificationManager, AppRatingManager appRatingManager) {
        Intrinsics.f(pushNotificationManager, "pushNotificationManager");
        Intrinsics.f(appRatingManager, "appRatingManager");
        this.f25722a = pushNotificationManager;
        this.f25723b = appRatingManager;
    }

    @Override // ee.mtakso.driver.service.push.PushHandler
    public int a() {
        return PushHandler.DefaultImpls.a(this);
    }

    @Override // ee.mtakso.driver.service.push.PushHandler
    public boolean b(Push push) {
        Intrinsics.f(push, "push");
        if (!Intrinsics.a(push.b().get("type"), PushType.TIP_RECEIVED.getId())) {
            return false;
        }
        if (this.f25723b.g()) {
            this.f25723b.r(RateMeModel.Tips.f23229f);
        }
        this.f25722a.f(push);
        return true;
    }
}
