package com.sinch.android.rtc.internal.natives;

import java.util.List;

/* loaded from: classes3.dex */
public interface PubSubscriber {
    List<String> getChannels();

    String getClientId();

    String getPublishKey();

    String getSubscribeKey();

    void handleData(String str, String str2, String str3);

    void handleFailure(String str);
}
