package ee.mtakso.voip_client;

import io.reactivex.Observable;
import java.util.Map;

/* compiled from: VoipClient.kt */
/* loaded from: classes5.dex */
public interface VoipClient {

    /* compiled from: VoipClient.kt */
    /* loaded from: classes5.dex */
    public enum StartStatus {
        ON_STARTED,
        USER_REGISTRATION_COMPLETED,
        TOKEN_REGISTRATION_COMPLETED,
        USER_REGISTRATION_FAILED,
        TOKEN_REGISTRATION_FAILED,
        FAILED
    }

    void a(boolean z7);

    void b(boolean z7);

    VoipCall c();

    boolean d();

    void destroy();

    boolean e();

    boolean h(Map<String, String> map);

    Observable<VoipCall> i();

    boolean isRunning();

    VoipCall j();

    Observable<StartStatus> k();

    VoipCall l(VoipPeer voipPeer, VoipConnection voipConnection);
}
