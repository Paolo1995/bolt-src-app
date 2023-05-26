package com.sinch.android.rtc.internal.natives;

import com.sinch.android.rtc.PushPair;
import com.sinch.android.rtc.internal.natives.jni.Call;
import java.util.List;

/* loaded from: classes3.dex */
public interface CallEventListener {
    void onCallStatistics(Call call, StatsReport[] statsReportArr);

    void onConnectionInfo(Call call, ConnectionInfo connectionInfo);

    void onEstablished(Call call);

    void onProgressing(Call call);

    void onPushData(Call call, List<PushPair> list);

    void onRemotePeerCapabilitiesChange(Call call, String str, List<String> list);

    void onSignalStrength(Call call, int i8, int i9, int i10, int i11);

    void onTerminated(Call call);

    void onVideoTrackAdded(Call call, Object obj);

    void onVideoTrackPaused(Call call);

    void onVideoTrackResumed(Call call);
}
