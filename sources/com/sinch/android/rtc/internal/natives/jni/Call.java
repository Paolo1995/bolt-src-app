package com.sinch.android.rtc.internal.natives.jni;

import android.util.Log;
import com.sinch.android.rtc.internal.natives.CallDetails;
import com.sinch.android.rtc.internal.natives.CallEventListener;
import java.util.Map;

/* loaded from: classes3.dex */
public class Call extends NativeProxy {
    private Call(long j8) {
        super(j8);
    }

    private static synchronized Call createInstance(long j8, long j9) {
        Call call;
        synchronized (Call.class) {
            call = (Call) NativeProxy.get(j9, Call.class);
            if (call == null) {
                call = new Call(j8);
                NativeProxy.put(j9, call);
            }
        }
        return call;
    }

    public native void accept();

    public native void dispose();

    public native void enableVideoTrack(boolean z7);

    public void finalize() throws Throwable {
        try {
            Log.d("Session", "Disposing session object with address " + getNativeAddress());
            dispose();
            invalidate();
        } finally {
            super.finalize();
        }
    }

    public native String getCallId();

    public native String getCli();

    public native CallDetails getDetails();

    public native int getDirection();

    public native CallEventListener getEventListener();

    public native Map<String, String> getHeaders();

    public native String getRemoteInstanceId();

    public native String getRemoteUserId();

    public native int getState();

    public native boolean hasEarlyMedia();

    public boolean isInbound() {
        return getDirection() == 0;
    }

    public native void reportAudioRouteEvent(String str, long j8);

    public native void reportClientEvent(String str, long j8);

    public native void reportWebRtcStats(long j8);

    public native void setConnectionInfo(String str, String str2, String str3, String str4, int i8);

    public native void setEventListener(CallEventListener callEventListener);

    public native void setLocalAnswer(String str);

    public native void startInbound();

    public native void startOutbound(String str);

    public native void terminate(int i8);
}
