package com.sinch.android.rtc.internal.natives.jni;

/* loaded from: classes3.dex */
public class NativeJsepMessageChannel extends NativeProxy implements JsepMessageChannel {
    private NativeJsepMessageChannel(long j8) {
        super(j8);
    }

    private static synchronized NativeJsepMessageChannel createInstance(long j8) {
        NativeJsepMessageChannel nativeJsepMessageChannel;
        synchronized (NativeJsepMessageChannel.class) {
            nativeJsepMessageChannel = (NativeJsepMessageChannel) NativeProxy.get(j8, NativeJsepMessageChannel.class);
            if (nativeJsepMessageChannel == null) {
                nativeJsepMessageChannel = new NativeJsepMessageChannel(j8);
                NativeProxy.put(j8, nativeJsepMessageChannel);
            }
        }
        return nativeJsepMessageChannel;
    }

    @Override // com.sinch.android.rtc.internal.natives.jni.JsepMessageChannel
    public native void sendMessage(String str, String str2, int i8, String str3);

    @Override // com.sinch.android.rtc.internal.natives.jni.JsepMessageChannel
    public native void setInboundReceiver(JsepMessageReceiver jsepMessageReceiver);
}
