package com.sinch.android.rtc.internal.natives.jni;

import com.sinch.android.rtc.internal.natives.PubSubHistoryConsumer;

/* loaded from: classes3.dex */
public class NativePubSubHistoryConsumer extends NativeProxy implements PubSubHistoryConsumer {
    private NativePubSubHistoryConsumer(long j8) {
        super(j8);
    }

    public static synchronized NativePubSubHistoryConsumer createInstance(long j8) {
        NativePubSubHistoryConsumer nativePubSubHistoryConsumer;
        synchronized (NativePubSubHistoryConsumer.class) {
            nativePubSubHistoryConsumer = (NativePubSubHistoryConsumer) NativeProxy.get(j8, NativePubSubHistoryConsumer.class);
            if (nativePubSubHistoryConsumer == null) {
                nativePubSubHistoryConsumer = new NativePubSubHistoryConsumer(j8);
                NativeProxy.put(j8, nativePubSubHistoryConsumer);
            }
        }
        return nativePubSubHistoryConsumer;
    }

    @Override // com.sinch.android.rtc.internal.natives.PubSubHistoryConsumer
    public native void endHistoryGet(String[] strArr, String[] strArr2, String str, String str2);

    @Override // com.sinch.android.rtc.internal.natives.PubSubHistoryConsumer
    public native void endHistoryGetWithoutTimestamps(String[] strArr);

    @Override // com.sinch.android.rtc.internal.natives.PubSubHistoryConsumer
    public native void failedHistoryGet();

    @Override // com.sinch.android.rtc.internal.natives.PubSubHistoryConsumer
    public native String getChannel();

    @Override // com.sinch.android.rtc.internal.natives.PubSubHistoryConsumer
    public native String getClientId();

    @Override // com.sinch.android.rtc.internal.natives.PubSubHistoryConsumer
    public native String getSubscribeKey();
}
