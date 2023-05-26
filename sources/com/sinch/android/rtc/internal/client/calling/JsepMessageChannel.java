package com.sinch.android.rtc.internal.client.calling;

/* loaded from: classes3.dex */
public interface JsepMessageChannel {
    void sendMessage(String str, String str2, JsepMessage jsepMessage);

    void setInboundReceiver(JsepMessageReceiver jsepMessageReceiver);
}
