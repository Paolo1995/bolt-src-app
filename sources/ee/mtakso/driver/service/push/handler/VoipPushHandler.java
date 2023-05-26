package ee.mtakso.driver.service.push.handler;

import ee.mtakso.driver.platform.push.Push;
import ee.mtakso.driver.service.push.PushHandler;
import ee.mtakso.driver.service.voip.VoipService;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoipPushHandler.kt */
/* loaded from: classes3.dex */
public final class VoipPushHandler implements PushHandler {

    /* renamed from: a  reason: collision with root package name */
    private final VoipService f25726a;

    @Inject
    public VoipPushHandler(VoipService voipService) {
        Intrinsics.f(voipService, "voipService");
        this.f25726a = voipService;
    }

    @Override // ee.mtakso.driver.service.push.PushHandler
    public int a() {
        return PushHandler.DefaultImpls.a(this);
    }

    @Override // ee.mtakso.driver.service.push.PushHandler
    public boolean b(Push push) {
        Intrinsics.f(push, "push");
        return this.f25726a.r(push.b());
    }
}
