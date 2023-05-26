package com.sinch.android.rtc.internal.client.calling;

import com.sinch.android.rtc.internal.client.SinchLogger;

/* loaded from: classes3.dex */
public class DefaultJsepMessageChannel implements JsepMessageChannel, com.sinch.android.rtc.internal.natives.jni.JsepMessageReceiver {
    private SinchLogger logger;
    private final com.sinch.android.rtc.internal.natives.jni.JsepMessageChannel mJsepMessageChannel;
    private JsepMessageReceiver receiver;

    public DefaultJsepMessageChannel(com.sinch.android.rtc.internal.natives.jni.JsepMessageChannel jsepMessageChannel, SinchLogger sinchLogger) {
        this.mJsepMessageChannel = jsepMessageChannel;
        this.logger = sinchLogger;
    }

    @Override // com.sinch.android.rtc.internal.natives.jni.JsepMessageReceiver
    public void onJsepMessageReceived(String str, String str2, int i8, String str3) {
        SinchLogger sinchLogger = this.logger;
        sinchLogger.d("JSEP", "onJsepMessageReceived session: " + str + ", instance: " + str2 + ", type: " + i8 + ", payload: " + str3);
        this.receiver.onJsepMessageReceived(str, str2, new JsepMessage(str3, i8));
    }

    @Override // com.sinch.android.rtc.internal.client.calling.JsepMessageChannel
    public void sendMessage(String str, String str2, JsepMessage jsepMessage) {
        SinchLogger sinchLogger = this.logger;
        sinchLogger.d("JSEP", "sendMessage session: " + str + ", instance: " + str2 + ", type: " + jsepMessage.getType() + ", payload: " + jsepMessage.getPayload());
        this.mJsepMessageChannel.sendMessage(str, str2, jsepMessage.getType().ordinal(), jsepMessage.getPayload());
    }

    @Override // com.sinch.android.rtc.internal.client.calling.JsepMessageChannel
    public void setInboundReceiver(JsepMessageReceiver jsepMessageReceiver) {
        this.receiver = jsepMessageReceiver;
        com.sinch.android.rtc.internal.natives.jni.JsepMessageChannel jsepMessageChannel = this.mJsepMessageChannel;
        if (jsepMessageChannel != null) {
            jsepMessageChannel.setInboundReceiver(this);
        }
    }
}
