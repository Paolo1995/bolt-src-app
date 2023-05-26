package ee.mtakso.driver.service.voip.lifecycle;

import ee.mtakso.voip_client.VoipCall;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SimpleVoipLifecycleObserver.kt */
/* loaded from: classes3.dex */
public class SimpleVoipLifecycleObserver implements VoipLifecycleObserver {
    @Override // ee.mtakso.driver.service.voip.lifecycle.VoipLifecycleObserver
    public void a(VoipCall call) {
        Intrinsics.f(call, "call");
    }

    @Override // ee.mtakso.driver.service.voip.lifecycle.VoipLifecycleObserver
    public void b(VoipCall call, VoipCall.EndReason endReason) {
        Intrinsics.f(call, "call");
        Intrinsics.f(endReason, "endReason");
    }

    @Override // ee.mtakso.driver.service.voip.lifecycle.VoipLifecycleObserver
    public void c(VoipCall call) {
        Intrinsics.f(call, "call");
    }

    @Override // ee.mtakso.driver.service.voip.lifecycle.VoipLifecycleObserver
    public void d(VoipCall call) {
        Intrinsics.f(call, "call");
    }
}
