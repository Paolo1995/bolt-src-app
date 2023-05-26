package com.sinch.android.rtc.internal;

import com.sinch.android.rtc.calling.Call;
import java.util.Map;

/* loaded from: classes3.dex */
public interface ExternalPushListener {
    void onNewExternalPushPayload(Call call, Map<String, String> map);
}
