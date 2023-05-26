package com.sinch.android.rtc.internal.natives.jni;

/* loaded from: classes3.dex */
public interface CallClient {
    Call createIncomingCall(String str, String str2, String str3, String[] strArr, String[] strArr2, int i8);

    Call createOutgoingCall(String str, String str2, String str3, String str4, String[] strArr, String[] strArr2, int i8);

    void relayPushNotificationPayload(String str);

    void setListener(CallClientListener callClientListener);
}
