package com.sinch.android.rtc.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.sinch.android.rtc.PushConfiguration;
import com.sinch.android.rtc.UserController;
import com.sinch.android.rtc.UserControllerBuilder;
import com.sinch.android.rtc.internal.client.DeviceId;
import com.sinch.android.rtc.internal.client.ServiceFactory;
import com.sinch.android.rtc.internal.client.SinchDBPathHelper;
import com.sinch.android.rtc.internal.client.libloader.NativeLibLoader;
import com.sinch.android.rtc.internal.natives.jni.DefaultUserController;
import com.sinch.android.rtc.internal.natives.jni.UserControllerFactory;
import com.sinch.android.rtc.internal.service.dispatcher.DefaultDispatcher;
import com.sinch.android.rtc.internal.service.dispatcher.Dispatcher;
import com.sinch.android.rtc.internal.service.http.DefaultHttpService;
import com.sinch.android.rtc.internal.service.http.HttpService;
import com.sinch.android.rtc.internal.service.time.TimeService;
import java.io.IOException;

/* loaded from: classes3.dex */
public class DefaultUserControllerBuilder implements UserControllerBuilder {
    private String mApplicationKey;
    private CallbackHandler mCallbackHandler;
    private Context mContext;
    private String mEnvironmentHost;
    private PushConfiguration mPushConfiguration;
    private String mUserId;

    @Override // com.sinch.android.rtc.UserControllerBuilder
    public UserControllerBuilder applicationKey(@NonNull String str) {
        this.mApplicationKey = str;
        return this;
    }

    @Override // com.sinch.android.rtc.UserControllerBuilder
    public UserController build() throws IOException {
        if (this.mContext != null) {
            String str = this.mUserId;
            if (str == null || str.isEmpty()) {
                throw new IllegalArgumentException("The user id must not be null or empty.");
            }
            String str2 = this.mApplicationKey;
            if (str2 == null || str2.isEmpty()) {
                throw new IllegalArgumentException("The application key must not be null or empty.");
            }
            String str3 = this.mEnvironmentHost;
            if (str3 == null || str3.isEmpty()) {
                throw new IllegalArgumentException("The environment host must not be null or empty.");
            }
            NativeLibLoader.loadAllRequiredLibraries(this.mContext);
            if (this.mCallbackHandler == null) {
                this.mCallbackHandler = new AndroidLooperCallbackHandler();
            }
            final String pathForPersistenceServiceDatabase = new SinchDBPathHelper(this.mContext).getPathForPersistenceServiceDatabase(this.mApplicationKey);
            ServiceFactory serviceFactory = new ServiceFactory(this.mCallbackHandler);
            final DefaultDispatcher createDefaultDispatcher = serviceFactory.createDefaultDispatcher();
            final DefaultHttpService createDefaultHttpService = serviceFactory.createDefaultHttpService(serviceFactory.createHttpClient());
            final String deviceId = DeviceId.getDeviceId(this.mContext);
            return buildWithResources(new RuntimeResources() { // from class: com.sinch.android.rtc.internal.DefaultUserControllerBuilder.1
                @Override // com.sinch.android.rtc.internal.RuntimeResources
                public CallbackHandler getCallbackHandler() {
                    return DefaultUserControllerBuilder.this.mCallbackHandler;
                }

                @Override // com.sinch.android.rtc.internal.RuntimeResources
                public Context getContext() {
                    return DefaultUserControllerBuilder.this.mContext;
                }

                @Override // com.sinch.android.rtc.internal.RuntimeResources
                public String getDeviceId() {
                    return deviceId;
                }

                @Override // com.sinch.android.rtc.internal.RuntimeResources
                public Dispatcher getDispatcher() {
                    return createDefaultDispatcher;
                }

                @Override // com.sinch.android.rtc.internal.RuntimeResources
                public HttpService getHttpService() {
                    return createDefaultHttpService;
                }

                @Override // com.sinch.android.rtc.internal.RuntimeResources
                public String getPersistenceServiceDatabasePath() {
                    return pathForPersistenceServiceDatabase;
                }

                @Override // com.sinch.android.rtc.internal.RuntimeResources
                public TimeService getTimeService() {
                    return null;
                }
            });
        }
        throw new IllegalArgumentException("Context must not be null.");
    }

    public UserController buildWithResources(RuntimeResources runtimeResources) {
        CallbackHandler callbackHandler = runtimeResources.getCallbackHandler();
        UserController createUserController = UserControllerFactory.createUserController(this.mUserId, this.mApplicationKey, this.mEnvironmentHost, runtimeResources);
        if (createUserController instanceof DefaultUserController) {
            PushConfiguration pushConfiguration = this.mPushConfiguration;
            if (pushConfiguration == null) {
                ((DefaultUserController) createUserController).initialize();
            } else {
                ((DefaultUserController) createUserController).initialize(callbackHandler, pushConfiguration);
            }
        }
        return createUserController;
    }

    @Override // com.sinch.android.rtc.UserControllerBuilder
    public UserControllerBuilder callbackHandler(CallbackHandler callbackHandler) {
        this.mCallbackHandler = callbackHandler;
        return this;
    }

    @Override // com.sinch.android.rtc.UserControllerBuilder
    public UserControllerBuilder context(@NonNull Context context) {
        this.mContext = context;
        return this;
    }

    @Override // com.sinch.android.rtc.UserControllerBuilder
    public UserControllerBuilder environmentHost(@NonNull String str) {
        this.mEnvironmentHost = str;
        return this;
    }

    @Override // com.sinch.android.rtc.UserControllerBuilder
    public UserControllerBuilder pushConfiguration(PushConfiguration pushConfiguration) {
        this.mPushConfiguration = pushConfiguration;
        return this;
    }

    @Override // com.sinch.android.rtc.UserControllerBuilder
    public UserControllerBuilder userId(@NonNull String str) {
        this.mUserId = str;
        return this;
    }
}
