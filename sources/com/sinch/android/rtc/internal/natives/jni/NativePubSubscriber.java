package com.sinch.android.rtc.internal.natives.jni;

import com.sinch.android.rtc.internal.natives.PubSubscriber;
import java.util.List;

/* loaded from: classes3.dex */
public class NativePubSubscriber extends NativeProxy implements PubSubscriber {
    private NativePubSubscriber(long j8) {
        super(j8);
    }

    public static synchronized NativePubSubscriber createInstance(long j8) {
        NativePubSubscriber nativePubSubscriber;
        synchronized (NativePubSubscriber.class) {
            nativePubSubscriber = (NativePubSubscriber) NativeProxy.get(j8, NativePubSubscriber.class);
            if (nativePubSubscriber == null) {
                nativePubSubscriber = new NativePubSubscriber(j8);
                NativeProxy.put(j8, nativePubSubscriber);
            }
        }
        return nativePubSubscriber;
    }

    public native void dispose();

    @Override // com.sinch.android.rtc.internal.natives.jni.NativeProxy
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        NativePubSubscriber nativePubSubscriber = (NativePubSubscriber) obj;
        if (getChannels() == null) {
            if (nativePubSubscriber.getChannels() != null) {
                return false;
            }
        } else if (!getChannels().equals(nativePubSubscriber.getChannels())) {
            return false;
        }
        if (getPublishKey() == null) {
            if (nativePubSubscriber.getPublishKey() != null) {
                return false;
            }
        } else if (!getPublishKey().equals(nativePubSubscriber.getPublishKey())) {
            return false;
        }
        if (getSubscribeKey() == null) {
            if (nativePubSubscriber.getSubscribeKey() != null) {
                return false;
            }
        } else if (!getSubscribeKey().equals(nativePubSubscriber.getSubscribeKey())) {
            return false;
        }
        return true;
    }

    @Override // com.sinch.android.rtc.internal.natives.PubSubscriber
    public native List<String> getChannels();

    @Override // com.sinch.android.rtc.internal.natives.PubSubscriber
    public native String getClientId();

    @Override // com.sinch.android.rtc.internal.natives.PubSubscriber
    public native String getPublishKey();

    @Override // com.sinch.android.rtc.internal.natives.PubSubscriber
    public native String getSubscribeKey();

    @Override // com.sinch.android.rtc.internal.natives.PubSubscriber
    public native void handleData(String str, String str2, String str3);

    @Override // com.sinch.android.rtc.internal.natives.PubSubscriber
    public native void handleFailure(String str);

    @Override // com.sinch.android.rtc.internal.natives.jni.NativeProxy
    public int hashCode() {
        return (((((getChannels() == null ? 0 : getChannels().hashCode()) + 31) * 31) + (getPublishKey() == null ? 0 : getPublishKey().hashCode())) * 31) + (getSubscribeKey() != null ? getSubscribeKey().hashCode() : 0);
    }
}
