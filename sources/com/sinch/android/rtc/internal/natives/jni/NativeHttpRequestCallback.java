package com.sinch.android.rtc.internal.natives.jni;

import com.sinch.android.rtc.internal.natives.HttpRequestCallback;

/* loaded from: classes3.dex */
public class NativeHttpRequestCallback extends NativeProxy implements HttpRequestCallback {
    private NativeHttpRequestCallback(long j8) {
        super(j8);
    }

    private static synchronized NativeHttpRequestCallback createInstance(long j8) {
        NativeHttpRequestCallback nativeHttpRequestCallback;
        synchronized (NativeHttpRequestCallback.class) {
            nativeHttpRequestCallback = (NativeHttpRequestCallback) NativeProxy.get(j8, NativeHttpRequestCallback.class);
            if (nativeHttpRequestCallback == null) {
                nativeHttpRequestCallback = new NativeHttpRequestCallback(j8);
                NativeProxy.put(j8, nativeHttpRequestCallback);
            }
        }
        return nativeHttpRequestCallback;
    }

    @Override // com.sinch.android.rtc.internal.natives.HttpRequestCallback
    public native void completed(int i8, String str, int i9, String str2, String str3);

    @Override // com.sinch.android.rtc.internal.natives.HttpRequestCallback
    public native void exception(String str);
}
