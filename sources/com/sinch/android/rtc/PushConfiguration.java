package com.sinch.android.rtc;

import java.util.Map;

/* loaded from: classes3.dex */
public interface PushConfiguration {
    String getDeviceToken();

    Map<String, String> getVendorData();

    String getVendorId();
}
