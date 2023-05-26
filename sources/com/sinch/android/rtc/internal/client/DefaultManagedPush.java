package com.sinch.android.rtc.internal.client;

import android.util.Log;
import com.sinch.android.rtc.PushTokenRegistrationCallback;
import com.sinch.android.rtc.PushTokenUnregistrationCallback;
import com.sinch.android.rtc.SinchError;
import com.sinch.android.rtc.internal.CallbackHandler;
import com.sinch.android.rtc.internal.DefaultSinchError;
import com.sinch.android.rtc.internal.ManagedPushHandler;
import com.sinch.android.rtc.internal.client.DefaultManagedPush;
import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public class DefaultManagedPush implements ManagedPushImpl {
    private static final String TAG = "DefaultManagedPush";
    private static final long TOKEN_REGISTRATION_TIMEOUT_S = 30;
    private CallbackHandler mCallbackHandler;
    private final ScheduledExecutor mExecutor;
    public final ManagedPushHandler mManagedPushHandler;
    private final AtomicLong mRequestId = new AtomicLong(0);
    private Map<Integer, CallbackWithCancellationTask> mCallbacks = new Hashtable();
    private boolean mIsActive = true;

    /* loaded from: classes3.dex */
    public enum CallbackType {
        REGISTER,
        UNREGISTER
    }

    /* loaded from: classes3.dex */
    public class CallbackWithCancellationTask {
        private final Object mCallback;
        private final CallbackType mCallbackType;
        private final ScheduledFuture<?> mTimeoutTask;

        public CallbackWithCancellationTask(CallbackType callbackType, Object obj, ScheduledFuture<?> scheduledFuture) {
            this.mCallbackType = callbackType;
            this.mCallback = obj;
            this.mTimeoutTask = scheduledFuture;
        }

        public Object getCallback() {
            return this.mCallback;
        }

        public ScheduledFuture<?> getTimeoutTask() {
            return this.mTimeoutTask;
        }

        public CallbackType getType() {
            return this.mCallbackType;
        }
    }

    private DefaultManagedPush(ManagedPushInternal managedPushInternal, CallbackHandler callbackHandler, ScheduledExecutor scheduledExecutor) throws IllegalThreadStateException {
        this.mExecutor = scheduledExecutor;
        this.mCallbackHandler = callbackHandler;
        this.mManagedPushHandler = new ManagedPushHandler(managedPushInternal);
    }

    public static DefaultManagedPush CreateManagedPush(ManagedPushInternal managedPushInternal, CallbackHandler callbackHandler, ScheduledExecutor scheduledExecutor) throws IllegalThreadStateException {
        return new DefaultManagedPush(managedPushInternal, callbackHandler, scheduledExecutor);
    }

    private int NextRequestId() {
        return (int) this.mRequestId.incrementAndGet();
    }

    private void addCallbackAndTimeoutTask(CallbackType callbackType, Object obj, int i8) {
        ScheduledFuture<?> scheduleFailWithTimeout = scheduleFailWithTimeout(i8);
        synchronized (this) {
            Integer num = new Integer(i8);
            if (this.mCallbacks.containsKey(num)) {
                throw new IllegalStateException("A callback for requestId " + i8 + " is already registered");
            }
            this.mCallbacks.put(num, new CallbackWithCancellationTask(callbackType, obj, scheduleFailWithTimeout));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: failRequestWithTimeout */
    public void lambda$scheduleFailWithTimeout$2(int i8) {
        CallbackWithCancellationTask popCallback = popCallback(i8);
        final Object callback = popCallback.getCallback();
        CallbackType type = popCallback.getType();
        if (type == CallbackType.REGISTER) {
            this.mCallbackHandler.post(new Runnable() { // from class: com.sinch.android.rtc.internal.client.i
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultManagedPush.lambda$failRequestWithTimeout$0(callback);
                }
            });
        }
        if (type == CallbackType.UNREGISTER) {
            this.mCallbackHandler.post(new Runnable() { // from class: com.sinch.android.rtc.internal.client.j
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultManagedPush.lambda$failRequestWithTimeout$1(callback);
                }
            });
        }
    }

    public static SinchError genericError(String str) {
        return DefaultSinchError.genericError(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$failRequestWithTimeout$0(Object obj) {
        ((PushTokenRegistrationCallback) obj).onPushTokenRegistrationFailed(genericError("Push Token registration task failed due to timeout"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$failRequestWithTimeout$1(Object obj) {
        ((PushTokenUnregistrationCallback) obj).onPushTokenUnregistrationFailed(genericError("Push Token registration task failed due to timeout"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$popCallbackAndCancelTimeoutTask$3(CallbackWithCancellationTask callbackWithCancellationTask) {
        ScheduledFuture<?> timeoutTask = callbackWithCancellationTask.getTimeoutTask();
        if (timeoutTask != null) {
            timeoutTask.cancel(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$tokenUpdateFailed$4(Object obj, SinchError sinchError) {
        ((PushTokenRegistrationCallback) obj).onPushTokenRegistrationFailed(sinchError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$tokenUpdateFailed$5(Object obj, SinchError sinchError) {
        ((PushTokenUnregistrationCallback) obj).onPushTokenUnregistrationFailed(sinchError);
    }

    private CallbackWithCancellationTask popCallback(int i8) {
        CallbackWithCancellationTask remove;
        synchronized (this) {
            remove = this.mCallbacks.remove(new Integer(i8));
        }
        return remove;
    }

    private Object popCallbackAndCancelTimeoutTask(int i8) {
        final CallbackWithCancellationTask popCallback = popCallback(i8);
        if (popCallback == null) {
            return null;
        }
        this.mExecutor.execute(new Runnable() { // from class: com.sinch.android.rtc.internal.client.g
            @Override // java.lang.Runnable
            public final void run() {
                DefaultManagedPush.lambda$popCallbackAndCancelTimeoutTask$3(DefaultManagedPush.CallbackWithCancellationTask.this);
            }
        });
        return popCallback.getCallback();
    }

    private ScheduledFuture<?> scheduleFailWithTimeout(final int i8) {
        return this.mExecutor.schedule(new Runnable() { // from class: com.sinch.android.rtc.internal.client.h
            @Override // java.lang.Runnable
            public final void run() {
                DefaultManagedPush.this.lambda$scheduleFailWithTimeout$2(i8);
            }
        }, TOKEN_REGISTRATION_TIMEOUT_S, TimeUnit.SECONDS);
    }

    @Override // com.sinch.android.rtc.internal.client.ManagedPushImpl
    public void dispose() {
        synchronized (this) {
            this.mIsActive = false;
        }
    }

    @Override // com.sinch.android.rtc.internal.ManagedPush
    public void registerPushToken(PushTokenRegistrationCallback pushTokenRegistrationCallback) {
        if (pushTokenRegistrationCallback == null) {
            throw new IllegalArgumentException("Callback must not be null");
        }
        int NextRequestId = NextRequestId();
        addCallbackAndTimeoutTask(CallbackType.REGISTER, pushTokenRegistrationCallback, NextRequestId);
        if (this.mIsActive) {
            this.mManagedPushHandler.registerPushToken(NextRequestId, pushTokenRegistrationCallback);
        } else {
            pushTokenRegistrationCallback.onPushTokenRegistrationFailed(genericError("Cannot register push token without active SinchClient or UserController."));
        }
    }

    @Override // com.sinch.android.rtc.internal.client.ManagedPushImpl
    public void setSenderId(String str) {
        Log.d(TAG, "setSenderId() is ignored as sender id should be explicitly set by the client");
    }

    @Override // com.sinch.android.rtc.internal.client.PushTokenRegistrationCallbackInternal
    public void tokenUpdateFailed(int i8, final SinchError sinchError) {
        CallbackWithCancellationTask popCallback = popCallback(i8);
        final Object callback = popCallback.getCallback();
        CallbackType type = popCallback.getType();
        if (type == CallbackType.REGISTER) {
            this.mCallbackHandler.post(new Runnable() { // from class: com.sinch.android.rtc.internal.client.k
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultManagedPush.lambda$tokenUpdateFailed$4(callback, sinchError);
                }
            });
        }
        if (type == CallbackType.UNREGISTER) {
            this.mCallbackHandler.post(new Runnable() { // from class: com.sinch.android.rtc.internal.client.l
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultManagedPush.lambda$tokenUpdateFailed$5(callback, sinchError);
                }
            });
        }
    }

    @Override // com.sinch.android.rtc.internal.client.PushTokenRegistrationCallbackInternal
    public void tokenUpdated(int i8) {
        CallbackWithCancellationTask popCallback = popCallback(i8);
        Object callback = popCallback.getCallback();
        CallbackType type = popCallback.getType();
        if (type == CallbackType.REGISTER) {
            CallbackHandler callbackHandler = this.mCallbackHandler;
            final PushTokenRegistrationCallback pushTokenRegistrationCallback = (PushTokenRegistrationCallback) callback;
            Objects.requireNonNull(pushTokenRegistrationCallback);
            callbackHandler.post(new Runnable() { // from class: com.sinch.android.rtc.internal.client.m
                @Override // java.lang.Runnable
                public final void run() {
                    PushTokenRegistrationCallback.this.onPushTokenRegistered();
                }
            });
        }
        if (type == CallbackType.UNREGISTER) {
            CallbackHandler callbackHandler2 = this.mCallbackHandler;
            final PushTokenUnregistrationCallback pushTokenUnregistrationCallback = (PushTokenUnregistrationCallback) callback;
            Objects.requireNonNull(pushTokenUnregistrationCallback);
            callbackHandler2.post(new Runnable() { // from class: com.sinch.android.rtc.internal.client.n
                @Override // java.lang.Runnable
                public final void run() {
                    PushTokenUnregistrationCallback.this.onPushTokenUnregistered();
                }
            });
        }
    }

    @Override // com.sinch.android.rtc.internal.ManagedPush
    public void unregisterPushToken(PushTokenUnregistrationCallback pushTokenUnregistrationCallback) {
        if (pushTokenUnregistrationCallback == null) {
            throw new IllegalArgumentException("Callback must not be null");
        }
        int NextRequestId = NextRequestId();
        addCallbackAndTimeoutTask(CallbackType.UNREGISTER, pushTokenUnregistrationCallback, NextRequestId);
        if (this.mIsActive) {
            this.mManagedPushHandler.unregisterPushToken(NextRequestId);
        } else {
            pushTokenUnregistrationCallback.onPushTokenUnregistrationFailed(genericError("Cannot unregister push token without active SinchClient or UserController."));
        }
    }
}
