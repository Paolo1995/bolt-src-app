package com.sinch.android.rtc.internal.natives.jni;

import com.sinch.android.rtc.ClientRegistration;
import com.sinch.android.rtc.PushConfiguration;
import com.sinch.android.rtc.PushTokenRegistrationCallback;
import com.sinch.android.rtc.PushTokenUnregistrationCallback;
import com.sinch.android.rtc.SinchError;
import com.sinch.android.rtc.UserController;
import com.sinch.android.rtc.UserRegistrationCallback;
import com.sinch.android.rtc.internal.CallbackHandler;
import com.sinch.android.rtc.internal.DefaultFcmPushConfigurationBuilder;
import com.sinch.android.rtc.internal.DefaultSinchError;
import com.sinch.android.rtc.internal.ManagedPushVendor;
import com.sinch.android.rtc.internal.client.DefaultManagedPush;
import com.sinch.android.rtc.internal.client.DefaultScheduledExecutor;
import com.sinch.android.rtc.internal.client.ManagedPushImpl;
import com.sinch.android.rtc.internal.client.ManagedPushInternal;
import com.sinch.android.rtc.internal.client.NoOpManagedPush;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public class DefaultUserController extends NativeProxy implements UserController, NativePushProfileRegistrationListener {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private boolean mIsUsingManagedPush;
    private ManagedPushImpl mManagedPush;
    private Map<Integer, PushTokenRegistrationCallback> mPushTokenRegistrationCallbacks;
    private NativeInstanceRegistrationListener mRegistrationListener;
    private final AtomicLong mRequestId;
    private Map<Integer, UserRegistrationCallback> mUserRegistrationCallbacks;

    private DefaultUserController(long j8) {
        super(j8);
        this.mUserRegistrationCallbacks = new HashMap();
        this.mPushTokenRegistrationCallbacks = new HashMap();
        this.mRequestId = new AtomicLong(0L);
    }

    private static synchronized DefaultUserController createInstance(long j8) {
        DefaultUserController defaultUserController;
        synchronized (DefaultUserController.class) {
            defaultUserController = (DefaultUserController) NativeProxy.get(j8, DefaultUserController.class);
            if (defaultUserController == null) {
                defaultUserController = new DefaultUserController(j8);
                NativeProxy.put(j8, defaultUserController);
            }
        }
        return defaultUserController;
    }

    private NativeInstanceRegistrationListener createRegistrationListener() {
        return new NativeInstanceRegistrationListener() { // from class: com.sinch.android.rtc.internal.natives.jni.DefaultUserController.1
            @Override // com.sinch.android.rtc.internal.natives.jni.NativeInstanceRegistrationListener
            public void onCredentialsRequired(int i8, ClientRegistration clientRegistration) {
                UserRegistrationCallback userRegistrationCallback = (UserRegistrationCallback) DefaultUserController.this.mUserRegistrationCallbacks.get(Integer.valueOf(i8));
                if (userRegistrationCallback != null) {
                    userRegistrationCallback.onCredentialsRequired(clientRegistration);
                }
            }

            @Override // com.sinch.android.rtc.internal.natives.jni.NativeInstanceRegistrationListener
            public void onInstanceRegistered(int i8) {
                DefaultUserController.this.onInstanceRegistered(i8);
            }

            @Override // com.sinch.android.rtc.internal.natives.jni.NativeInstanceRegistrationListener
            public void onInstanceRegistrationFailed(int i8, SinchError sinchError) {
                DefaultUserController.this.onInstanceRegistrationFailed(i8, sinchError);
            }
        };
    }

    private native void initialize(NativeInstanceRegistrationListener nativeInstanceRegistrationListener);

    private int nextRequestId() {
        return (int) this.mRequestId.incrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onInstanceRegistered(int i8) {
        UserRegistrationCallback userRegistrationCallback = this.mUserRegistrationCallbacks.get(Integer.valueOf(i8));
        if (userRegistrationCallback != null) {
            userRegistrationCallback.onUserRegistered();
            PushTokenRegistrationCallback pushTokenRegistrationCallback = this.mPushTokenRegistrationCallbacks.get(Integer.valueOf(i8));
            if (pushTokenRegistrationCallback != null) {
                this.mManagedPush.registerPushToken(pushTokenRegistrationCallback);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onInstanceRegistrationFailed(int i8, SinchError sinchError) {
        UserRegistrationCallback userRegistrationCallback = this.mUserRegistrationCallbacks.get(Integer.valueOf(i8));
        if (userRegistrationCallback != null) {
            userRegistrationCallback.onUserRegistrationFailed(sinchError);
        }
        PushTokenRegistrationCallback pushTokenRegistrationCallback = this.mPushTokenRegistrationCallbacks.get(Integer.valueOf(i8));
        if (pushTokenRegistrationCallback != null) {
            pushTokenRegistrationCallback.onPushTokenRegistrationFailed(DefaultSinchError.genericError("Push Token registration task failed due to failure of User Registration task with error: " + sinchError.getMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void registerPushToken(int i8, String str, String str2, int i9);

    /* JADX INFO: Access modifiers changed from: private */
    public native void registerUpaPushToken(int i8, String str, String str2, String[] strArr, String[] strArr2, int i9);

    private native void registerUser(int i8, boolean z7);

    public native void dispose();

    public void disposeManagedPush() {
        this.mManagedPush.dispose();
    }

    public void finalize() {
        dispose();
    }

    public void initialize() {
        this.mManagedPush = new NoOpManagedPush();
        NativeInstanceRegistrationListener createRegistrationListener = createRegistrationListener();
        this.mRegistrationListener = createRegistrationListener;
        initialize(createRegistrationListener);
    }

    public void initialize(CallbackHandler callbackHandler, final PushConfiguration pushConfiguration) {
        this.mIsUsingManagedPush = true;
        this.mManagedPush = DefaultManagedPush.CreateManagedPush(new ManagedPushInternal() { // from class: com.sinch.android.rtc.internal.natives.jni.DefaultUserController.2
            @Override // com.sinch.android.rtc.internal.client.ManagedPushInternal
            public boolean isManagedPushEnabled() {
                return true;
            }

            @Override // com.sinch.android.rtc.internal.client.ManagedPushRegistration
            public void registerPushToken(int i8) {
                if (pushConfiguration.getVendorId().equals(ManagedPushVendor.FCM.getVendorID())) {
                    DefaultUserController.this.registerPushToken(i8, pushConfiguration.getVendorData().get(DefaultFcmPushConfigurationBuilder.FCM_SENDER_ID_KEY), pushConfiguration.getDeviceToken(), 4096);
                    return;
                }
                String[] strArr = (String[]) pushConfiguration.getVendorData().keySet().toArray(new String[0]);
                String[] strArr2 = new String[strArr.length];
                for (int i9 = 0; i9 < strArr.length; i9++) {
                    strArr2[i9] = pushConfiguration.getVendorData().get(strArr[i9]);
                }
                DefaultUserController.this.registerUpaPushToken(i8, pushConfiguration.getDeviceToken(), pushConfiguration.getVendorId(), strArr, strArr2, 4096);
            }

            @Override // com.sinch.android.rtc.internal.client.ManagedPushRegistration
            public void unregisterPushToken(int i8) {
                DefaultUserController.this.unregisterPushToken(i8);
            }
        }, callbackHandler, new DefaultScheduledExecutor());
        NativeInstanceRegistrationListener createRegistrationListener = createRegistrationListener();
        this.mRegistrationListener = createRegistrationListener;
        initialize(createRegistrationListener);
    }

    @Override // com.sinch.android.rtc.internal.natives.jni.NativePushProfileRegistrationListener
    public void onNewPushProfileRequired(String str) {
        this.mManagedPush.setSenderId(str);
    }

    @Override // com.sinch.android.rtc.internal.natives.jni.NativePushProfileRegistrationListener
    public void onPushProfileUpdateFailed(int i8, SinchError sinchError) {
        this.mManagedPush.tokenUpdateFailed(i8, sinchError);
    }

    @Override // com.sinch.android.rtc.internal.natives.jni.NativePushProfileRegistrationListener
    public void onPushProfileUpdated(int i8) {
        this.mManagedPush.tokenUpdated(i8);
    }

    @Override // com.sinch.android.rtc.UserController
    public void registerUser(UserRegistrationCallback userRegistrationCallback, PushTokenRegistrationCallback pushTokenRegistrationCallback) throws UnsupportedOperationException {
        int nextRequestId = nextRequestId();
        this.mUserRegistrationCallbacks.put(Integer.valueOf(nextRequestId), userRegistrationCallback);
        this.mPushTokenRegistrationCallbacks.put(Integer.valueOf(nextRequestId), pushTokenRegistrationCallback);
        registerUser(nextRequestId, this.mIsUsingManagedPush);
    }

    public native void unregisterPushToken(int i8);

    @Override // com.sinch.android.rtc.UserController
    public void unregisterPushToken(PushTokenUnregistrationCallback pushTokenUnregistrationCallback) throws UnsupportedOperationException {
        this.mManagedPush.unregisterPushToken(pushTokenUnregistrationCallback);
    }
}
