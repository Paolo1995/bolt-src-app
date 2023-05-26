package com.sinch.android.rtc.internal.natives.jni;

/* loaded from: classes3.dex */
public interface JsepMessageChannel {
    void sendMessage(String str, String str2, int i8, String str3);

    void setInboundReceiver(JsepMessageReceiver jsepMessageReceiver);
}
