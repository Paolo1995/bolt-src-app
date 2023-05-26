package ee.mtakso.driver.service.voip.lifecycle.observers;

import ee.mtakso.driver.service.voip.lifecycle.SimpleVoipLifecycleObserver;
import ee.mtakso.driver.utils.power.WakeLockManager;
import ee.mtakso.voip_client.VoipCall;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoipProximityManager.kt */
@Singleton
/* loaded from: classes3.dex */
public final class VoipProximityManager extends SimpleVoipLifecycleObserver {

    /* renamed from: a  reason: collision with root package name */
    private final WakeLockManager f26166a;

    @Inject
    public VoipProximityManager(WakeLockManager wakeLockManager) {
        Intrinsics.f(wakeLockManager, "wakeLockManager");
        this.f26166a = wakeLockManager;
    }

    @Override // ee.mtakso.driver.service.voip.lifecycle.SimpleVoipLifecycleObserver, ee.mtakso.driver.service.voip.lifecycle.VoipLifecycleObserver
    public void b(VoipCall call, VoipCall.EndReason endReason) {
        Intrinsics.f(call, "call");
        Intrinsics.f(endReason, "endReason");
        this.f26166a.e();
    }

    @Override // ee.mtakso.driver.service.voip.lifecycle.SimpleVoipLifecycleObserver, ee.mtakso.driver.service.voip.lifecycle.VoipLifecycleObserver
    public void c(VoipCall call) {
        Intrinsics.f(call, "call");
        this.f26166a.b(WakeLockManager.f36459c.a(), "driverapp:incall");
    }
}
