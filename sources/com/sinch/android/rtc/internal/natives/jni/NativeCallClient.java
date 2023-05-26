package com.sinch.android.rtc.internal.natives.jni;

/* loaded from: classes3.dex */
public class NativeCallClient extends NativeProxy implements CallClient {
    private NativeCallClient(long j8) {
        super(j8);
    }

    private static synchronized NativeCallClient createInstance(long j8) {
        NativeCallClient nativeCallClient;
        synchronized (NativeCallClient.class) {
            nativeCallClient = (NativeCallClient) NativeProxy.get(j8, NativeCallClient.class);
            if (nativeCallClient == null) {
                nativeCallClient = new NativeCallClient(j8);
                NativeProxy.put(j8, nativeCallClient);
            }
        }
        return nativeCallClient;
    }

    @Override // com.sinch.android.rtc.internal.natives.jni.CallClient
    public native Call createIncomingCall(String str, String str2, String str3, String[] strArr, String[] strArr2, int i8);

    @Override // com.sinch.android.rtc.internal.natives.jni.CallClient
    public native Call createOutgoingCall(String str, String str2, String str3, String str4, String[] strArr, String[] strArr2, int i8);

    @Override // com.sinch.android.rtc.internal.natives.jni.CallClient
    public native void relayPushNotificationPayload(String str);

    @Override // com.sinch.android.rtc.internal.natives.jni.CallClient
    public native void setListener(CallClientListener callClientListener);
}
