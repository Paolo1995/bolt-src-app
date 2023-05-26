package com.sinch.android.rtc.internal.natives.jni;

import com.sinch.android.rtc.ClientRegistration;

/* loaded from: classes3.dex */
public class NativeRegister extends NativeProxy implements ClientRegistration {
    private int mRequestId;

    public NativeRegister(long j8) {
        super(j8);
    }

    private static synchronized NativeRegister createInstance(long j8) {
        NativeRegister nativeRegister;
        synchronized (NativeRegister.class) {
            nativeRegister = (NativeRegister) NativeProxy.get(j8, NativeRegister.class);
            if (nativeRegister == null) {
                nativeRegister = new NativeRegister(j8);
                NativeProxy.put(j8, nativeRegister);
            }
        }
        return nativeRegister;
    }

    @Override // com.sinch.android.rtc.ClientRegistration
    public void register(String str) {
        registerInstance(this.mRequestId, str);
    }

    @Override // com.sinch.android.rtc.ClientRegistration
    public void registerFailed() {
        registerInstanceFailed(this.mRequestId);
    }

    public native void registerInstance(int i8, String str);

    public native void registerInstanceFailed(int i8);

    public void setRequestId(int i8) {
        this.mRequestId = i8;
    }
}
