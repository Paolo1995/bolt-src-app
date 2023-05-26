package com.sinch.android.rtc.internal;

import android.util.Log;
import com.sinch.android.rtc.PushTokenRegistrationCallback;
import com.sinch.android.rtc.internal.client.DefaultManagedPush;
import com.sinch.android.rtc.internal.client.ManagedPushInternal;

/* loaded from: classes3.dex */
public class ManagedPushHandler {
    private static final String TAG = DefaultManagedPush.class.getSimpleName();
    private ManagedPushInternal mManagedPush;

    public ManagedPushHandler(ManagedPushInternal managedPushInternal) throws IllegalThreadStateException {
        this.mManagedPush = managedPushInternal;
    }

    private ManagedPushInternal getInternalManagedPush() {
        ManagedPushInternal managedPushInternal;
        synchronized (this) {
            managedPushInternal = this.mManagedPush;
        }
        return managedPushInternal;
    }

    public void registerPushToken(int i8, PushTokenRegistrationCallback pushTokenRegistrationCallback) {
        ManagedPushInternal internalManagedPush = getInternalManagedPush();
        if (internalManagedPush != null) {
            internalManagedPush.registerPushToken(i8);
        } else {
            pushTokenRegistrationCallback.onPushTokenRegistrationFailed(DefaultManagedPush.genericError("registerPushToken() failed: mpi == null."));
        }
    }

    public void unregisterPushToken(int i8) {
        ManagedPushInternal internalManagedPush = getInternalManagedPush();
        if (internalManagedPush != null) {
            internalManagedPush.unregisterPushToken(i8);
        } else {
            Log.e(TAG, "unregisterPushToken() failed: mpi == null.");
        }
    }
}
