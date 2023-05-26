package com.sinch.android.rtc.internal.natives.jni;

import com.sinch.android.rtc.internal.natives.UserAgentEventListener;
import com.sinch.android.rtc.internal.natives.UserAgentState;
import java.util.List;

/* loaded from: classes3.dex */
public class DefaultUserAgent extends NativeProxy implements UserAgent {
    private DefaultUserAgent(long j8) {
        super(j8);
    }

    private static synchronized DefaultUserAgent createInstance(long j8) {
        DefaultUserAgent defaultUserAgent;
        synchronized (DefaultUserAgent.class) {
            defaultUserAgent = (DefaultUserAgent) NativeProxy.get(j8, DefaultUserAgent.class);
            if (defaultUserAgent == null) {
                defaultUserAgent = new DefaultUserAgent(j8);
                NativeProxy.put(j8, defaultUserAgent);
            }
        }
        return defaultUserAgent;
    }

    private native int getStateAsInt();

    @Override // com.sinch.android.rtc.internal.natives.jni.UserAgent
    public native void deletePushData();

    @Override // com.sinch.android.rtc.internal.natives.jni.UserAgent
    public native void disableCapability(String str);

    @Override // com.sinch.android.rtc.internal.natives.jni.UserAgent
    public native void dispose();

    @Override // com.sinch.android.rtc.internal.natives.jni.UserAgent
    public native void doHouseKeeping();

    @Override // com.sinch.android.rtc.internal.natives.jni.UserAgent
    public native void enableCapability(String str);

    @Override // com.sinch.android.rtc.internal.natives.jni.UserAgent
    public native CallClient getCallClient();

    @Override // com.sinch.android.rtc.internal.natives.jni.UserAgent
    public native JsepMessageChannel getJsepMessageChannel();

    @Override // com.sinch.android.rtc.internal.natives.jni.UserAgent
    public native List<String> getLegacyStunServers();

    @Override // com.sinch.android.rtc.internal.natives.jni.UserAgent
    public UserAgentState getState() {
        int stateAsInt = getStateAsInt();
        return (stateAsInt < 0 || stateAsInt >= UserAgentState.values().length) ? UserAgentState.UNKNOWN : UserAgentState.values()[stateAsInt];
    }

    @Override // com.sinch.android.rtc.internal.natives.jni.UserAgent
    public native boolean isCapabilityEnabled(String str);

    @Override // com.sinch.android.rtc.internal.natives.jni.UserAgent
    public native boolean isStarted();

    @Override // com.sinch.android.rtc.internal.natives.jni.UserAgent
    public native void refreshConfig();

    @Override // com.sinch.android.rtc.internal.natives.jni.UserAgent
    public native void registerManagedPushToken(int i8, String str, String str2, int i9);

    @Override // com.sinch.android.rtc.internal.natives.jni.UserAgent
    public native void resendFailedRequests();

    @Override // com.sinch.android.rtc.internal.natives.jni.UserAgent
    public native void setApplicationContext(long j8);

    @Override // com.sinch.android.rtc.internal.natives.jni.UserAgent
    public native void setEventListener(UserAgentEventListener userAgentEventListener);

    @Override // com.sinch.android.rtc.internal.natives.jni.UserAgent
    public native void setMinimumLogLevel(int i8);

    @Override // com.sinch.android.rtc.internal.natives.jni.UserAgent
    public native void setPushData(byte[] bArr);

    @Override // com.sinch.android.rtc.internal.natives.jni.UserAgent
    public native void setPushNotificationDisplayName(String str);

    @Override // com.sinch.android.rtc.internal.natives.jni.UserAgent
    public native void setUseManagedPush(boolean z7);

    @Override // com.sinch.android.rtc.internal.natives.jni.UserAgent
    public native void start();

    @Override // com.sinch.android.rtc.internal.natives.jni.UserAgent
    public native void startBroadcastListener();

    @Override // com.sinch.android.rtc.internal.natives.jni.UserAgent
    public native void stop();

    @Override // com.sinch.android.rtc.internal.natives.jni.UserAgent
    public native void stopBroadcastListener();

    @Override // com.sinch.android.rtc.internal.natives.jni.UserAgent
    public native void triggerNewPushProfileRequest();

    @Override // com.sinch.android.rtc.internal.natives.jni.UserAgent
    public native void unregisterManagedPushToken(int i8);
}
