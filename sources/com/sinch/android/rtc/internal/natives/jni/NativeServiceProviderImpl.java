package com.sinch.android.rtc.internal.natives.jni;

/* loaded from: classes3.dex */
public class NativeServiceProviderImpl extends NativeProxy {
    private NativeServiceProviderImpl(long j8) {
        super(j8);
    }

    public static synchronized NativeServiceProviderImpl createInstance(long j8) {
        NativeServiceProviderImpl nativeServiceProviderImpl;
        synchronized (NativeServiceProviderImpl.class) {
            nativeServiceProviderImpl = (NativeServiceProviderImpl) NativeProxy.get(j8, NativeServiceProviderImpl.class);
            if (nativeServiceProviderImpl == null) {
                nativeServiceProviderImpl = new NativeServiceProviderImpl(j8);
                NativeProxy.put(j8, nativeServiceProviderImpl);
            }
        }
        return nativeServiceProviderImpl;
    }

    public native void dispose();
}
