package com.sinch.android.rtc.internal.client;

import com.sinch.android.rtc.calling.Call;
import com.sinch.android.rtc.calling.CallListener;
import com.sinch.android.rtc.internal.natives.ConnectionInfo;
import com.sinch.android.rtc.internal.natives.StatsReport;

/* loaded from: classes3.dex */
public interface InternalCallListener extends CallListener {
    void onConnectionInfo(Call call, ConnectionInfo connectionInfo);

    void onStatisticReport(StatsReport[] statsReportArr);
}
