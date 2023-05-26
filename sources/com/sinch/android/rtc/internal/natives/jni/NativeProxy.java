package com.sinch.android.rtc.internal.natives.jni;

import android.util.Log;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class NativeProxy {
    private static Map<Long, WeakReference<Object>> instances = new HashMap();
    private static ReferenceQueue<Object> reaped = new ReferenceQueue<>();
    private long nativeAddress;

    public NativeProxy(long j8) {
        this.nativeAddress = j8;
    }

    public static <T> T get(long j8, Class cls) {
        T t7;
        synchronized (instances) {
            while (true) {
                Reference<? extends Object> poll = reaped.poll();
                if (poll == null) {
                    break;
                }
                instances.remove(poll);
            }
            if (!instances.containsKey(Long.valueOf(j8)) || (t7 = (T) instances.get(Long.valueOf(j8)).get()) == null) {
                return null;
            }
            if (t7.getClass() == cls) {
                return t7;
            }
            Log.v("NativeProxy", "instances already contains weak ref to object for address " + j8 + " of type " + t7.getClass().getName() + ", but " + cls.getName() + " was expected.");
            ((NativeProxy) t7).invalidate();
            return null;
        }
    }

    public static void put(long j8, Object obj) {
        synchronized (instances) {
            instances.put(Long.valueOf(j8), new WeakReference<>(obj, reaped));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.nativeAddress == ((NativeProxy) obj).nativeAddress;
    }

    public long getNativeAddress() {
        return this.nativeAddress;
    }

    public int hashCode() {
        long j8 = this.nativeAddress;
        return ((int) (j8 ^ (j8 >>> 32))) + 31;
    }

    public void invalidate() {
        synchronized (instances) {
            instances.remove(Long.valueOf(this.nativeAddress));
            this.nativeAddress = 0L;
        }
    }
}
