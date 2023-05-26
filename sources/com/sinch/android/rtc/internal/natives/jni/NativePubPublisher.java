package com.sinch.android.rtc.internal.natives.jni;

import com.sinch.android.rtc.internal.natives.PubPublisher;

/* loaded from: classes3.dex */
public class NativePubPublisher extends NativeProxy implements PubPublisher {
    private NativePubPublisher(long j8) {
        super(j8);
    }

    public static synchronized NativePubPublisher createInstance(long j8) {
        NativePubPublisher nativePubPublisher;
        synchronized (NativePubPublisher.class) {
            nativePubPublisher = (NativePubPublisher) NativeProxy.get(j8, NativePubPublisher.class);
            if (nativePubPublisher == null) {
                nativePubPublisher = new NativePubPublisher(j8);
                NativeProxy.put(j8, nativePubPublisher);
            }
        }
        return nativePubPublisher;
    }

    public native void dispose();

    @Override // com.sinch.android.rtc.internal.natives.PubPublisher
    public native void onPublishFailed(int i8, String str, String str2);

    @Override // com.sinch.android.rtc.internal.natives.PubPublisher
    public native void onPublishSuccess(String str);
}
