package ee.mtakso.driver.service.voip.lifecycle;

import ee.mtakso.voip_client.VoipCall;

/* compiled from: VoipLifecycleObserver.kt */
/* loaded from: classes3.dex */
public interface VoipLifecycleObserver {
    void a(VoipCall voipCall);

    void b(VoipCall voipCall, VoipCall.EndReason endReason);

    void c(VoipCall voipCall);

    void d(VoipCall voipCall);
}
