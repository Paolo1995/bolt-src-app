package com.sinch.android.rtc.internal.natives.jni;

import com.sinch.android.rtc.internal.natives.UserAgentEventListener;
import com.sinch.android.rtc.internal.natives.UserAgentState;
import java.util.List;

/* loaded from: classes3.dex */
public interface UserAgent {
    void deletePushData();

    void disableCapability(String str);

    void dispose();

    void doHouseKeeping();

    void enableCapability(String str);

    CallClient getCallClient();

    JsepMessageChannel getJsepMessageChannel();

    List<String> getLegacyStunServers();

    UserAgentState getState();

    boolean isCapabilityEnabled(String str);

    boolean isStarted();

    void refreshConfig();

    void registerManagedPushToken(int i8, String str, String str2, int i9);

    void resendFailedRequests();

    void setApplicationContext(long j8);

    void setEventListener(UserAgentEventListener userAgentEventListener);

    void setMinimumLogLevel(int i8);

    void setPushData(byte[] bArr);

    void setPushNotificationDisplayName(String str);

    void setUseManagedPush(boolean z7);

    void start();

    void startBroadcastListener();

    void stop();

    void stopBroadcastListener();

    void triggerNewPushProfileRequest();

    void unregisterManagedPushToken(int i8);
}
