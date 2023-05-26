package com.sinch.android.rtc.internal.natives.jni;

import com.sinch.android.rtc.internal.natives.Dispatchable;

/* loaded from: classes3.dex */
public class NativeDispatchable extends NativeProxy implements Dispatchable {
    private NativeDispatchable(long j8) {
        super(j8);
    }

    private static synchronized NativeDispatchable createInstance(long j8) {
        NativeDispatchable nativeDispatchable;
        synchronized (NativeDispatchable.class) {
            nativeDispatchable = (NativeDispatchable) NativeProxy.get(j8, NativeDispatchable.class);
            if (nativeDispatchable == null) {
                nativeDispatchable = new NativeDispatchable(j8);
                NativeProxy.put(j8, nativeDispatchable);
            }
        }
        return nativeDispatchable;
    }

    @Override // com.sinch.android.rtc.internal.natives.Dispatchable
    public native void dispose();

    @Override // com.sinch.android.rtc.internal.natives.Dispatchable
    public native void run();
}
