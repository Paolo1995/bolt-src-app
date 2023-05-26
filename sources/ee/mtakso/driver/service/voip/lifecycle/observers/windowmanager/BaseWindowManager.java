package ee.mtakso.driver.service.voip.lifecycle.observers.windowmanager;

import ee.mtakso.driver.service.voip.lifecycle.SimpleVoipLifecycleObserver;
import ee.mtakso.voip_client.VoipCall;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseWindowManager.kt */
/* loaded from: classes3.dex */
public abstract class BaseWindowManager extends SimpleVoipLifecycleObserver {

    /* renamed from: a  reason: collision with root package name */
    private final RateCallWindowAppearanceDelegate f26173a = new RateCallWindowAppearanceDelegate();

    @Override // ee.mtakso.driver.service.voip.lifecycle.SimpleVoipLifecycleObserver, ee.mtakso.driver.service.voip.lifecycle.VoipLifecycleObserver
    public void b(VoipCall call, VoipCall.EndReason endReason) {
        Intrinsics.f(call, "call");
        Intrinsics.f(endReason, "endReason");
        super.b(call, endReason);
        this.f26173a.b(call);
    }

    @Override // ee.mtakso.driver.service.voip.lifecycle.SimpleVoipLifecycleObserver, ee.mtakso.driver.service.voip.lifecycle.VoipLifecycleObserver
    public void c(VoipCall call) {
        Intrinsics.f(call, "call");
        this.f26173a.a(call);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean e(VoipCall call, VoipCall.EndReason endReason) {
        Intrinsics.f(call, "call");
        Intrinsics.f(endReason, "endReason");
        if (endReason == VoipCall.EndReason.HANG_UP && this.f26173a.c(call)) {
            return true;
        }
        return false;
    }
}
