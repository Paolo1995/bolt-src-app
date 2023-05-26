package ee.mtakso.voip_client.sinch;

import com.sinch.android.rtc.calling.Call;
import ee.mtakso.voip_client.VoipLogger;
import java.util.Map;

/* compiled from: SinchCallDelegate.kt */
/* loaded from: classes5.dex */
public interface SinchCallDelegate {
    Call f(Call call, Map<String, String> map);

    VoipLogger g();

    void onCallEnded(Call call);

    void onCallEstablished(Call call);

    void onCallProgressing(Call call);
}
